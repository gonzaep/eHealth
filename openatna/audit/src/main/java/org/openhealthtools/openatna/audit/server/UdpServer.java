/**
 * Copyright (c) 2009-2011 University of Cardiff and others
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 * <p>
 * Contributors:
 * University of Cardiff - initial API and implementation
 * -
 */
package org.openhealthtools.openatna.audit.server;

import org.openhealthtools.openatna.net.ConnectionFactory;
import org.openhealthtools.openatna.net.IConnectionDescription;
import org.openhealthtools.openatna.net.IUdpServerConnection;
import org.openhealthtools.openatna.syslog.SyslogException;
import org.openhealthtools.openatna.syslog.SyslogMessage;
import org.openhealthtools.openatna.syslog.SyslogMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.*;

/**
 * @author Andrew Harrison
 * @version $Revision:$
 * @created Oct 21, 2009: 11:47:14 PM
 * @date $Date:$ modified by $Author:$
 */

public class UdpServer implements Server {

    private static final Logger LOGGER = LoggerFactory.getLogger(UdpServer.class);

    private AtnaServer atnaServer;
    private IConnectionDescription udpConnection;
    private IUdpServerConnection udpConn = null;
    private boolean running = false;
    private UdpServerThread thread;
    private DatagramSocket socket = null;

    public UdpServer(AtnaServer atnaServer, IConnectionDescription udpConnection) {
        this.atnaServer = atnaServer;
        this.udpConnection = udpConnection;
    }

    public void start() {
        try {
            udpConn = ConnectionFactory.getUdpServerConnection(udpConnection);
            socket = udpConn.getServerSocket();
            thread = new UdpServerThread(socket);
            running = true;
            thread.start();
            LOGGER.info("UDP Server running on port: '{}'", udpConnection.getPort());
        } catch (Exception e) {
            LOGGER.error("Failed to start UDP server '{}'", e.getMessage(), e);
        }
    }

    public void stop() {
        running = false;
        socket.close();
        thread.interrupt();
        udpConn.closeServerConnection();
        LOGGER.info("UDP Server shutting down...");
    }

    private String logPacket(DatagramPacket packet) {
        String localAddress = udpConn.getServerSocket().getLocalAddress().getHostAddress();
        int port = udpConn.getServerSocket().getLocalPort();
        InetSocketAddress addr = (InetSocketAddress) packet.getSocketAddress();
        return "UDP DatagramPacket received from:" + addr.getAddress().getHostAddress() + ":" + addr.getPort()
                + " to:" + localAddress + ":" + port;
    }

    private class UdpServerThread extends Thread {

        private final DatagramSocket socket;

        private UdpServerThread(DatagramSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (running && !interrupted()) {
                try {
                    byte[] buffer = new byte[udpConn.getMaxTransmissionUnit()];
                    DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
                    socket.receive(packet);
                    atnaServer.execute(new UdpReceiver(packet));
                } catch (SocketException x) {
                    LOGGER.debug("Socket closed: '{}'", x.getMessage(), x);
                } catch (SocketTimeoutException x) {
                    LOGGER.debug("SocketTimeoutException: '{}'", x.getMessage(), x);
                    // Timed out, but the socket is still valid, don't shut down
                } catch (IOException x) {
                    LOGGER.debug("IOException: '{}'", x.getMessage(), x);
                    break;
                }
            }
        }
    }

    private class UdpReceiver implements Runnable {

        private DatagramPacket packet;

        private UdpReceiver(DatagramPacket packet) {
            this.packet = packet;
        }

        public void run() {
            SyslogMessage msg = null;
            byte[] data = "no data".getBytes();
            try {
                data = new byte[packet.getLength()];
                LOGGER.debug(logPacket(packet));
                System.arraycopy(packet.getData(), packet.getOffset(), data, 0, data.length);
                LOGGER.debug("creating message from bytes: '{}'", new String(data));
                msg = createMessage(data);
            } catch (SyslogException e) {
                e.setBytes(data);
                e.setSourceIp(((InetSocketAddress) packet.getSocketAddress()).getAddress().getHostAddress());
                atnaServer.notifyException(e);
            }
            if (msg != null) {
                InetSocketAddress addr = (InetSocketAddress) packet.getSocketAddress();
                msg.setSourceIp(addr.getAddress().getHostAddress());
                atnaServer.notifyListeners(msg);
            }
        }

        private SyslogMessage createMessage(byte[] bytes) throws SyslogException {
            return SyslogMessageFactory.getFactory().read(new ByteArrayInputStream(bytes));
        }
    }
}
