package eu.esens.abb.nonrep;

import org.joda.time.DateTime;
import org.opensaml.core.xml.XMLObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.mail.internet.MimeMessage;
import javax.xml.soap.SOAPMessage;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

public class Context {

    private SOAPMessage incomingMsg;
    private Element requestDOM;
    private XMLObject requestXMLObj;
    private EnforcePolicy enforcer;
    private String user;
    private String currentHost;
    private String remoteHost;
    private X509Certificate issuercertificate;
    private X509Certificate sendercertificate;
    private X509Certificate recipientcertificate;

    private DateTime submissionTime;
    private String event;
    private String messageUUID;
    private String authenticationMethod;
    private PrivateKey key;
    private Document icomingMsgAsDocument;
    private LinkedList<String> recipientNamePostalAddress;
    private LinkedList<String> senderNamePostalAddress;

    public Context() {
    }

    public final String getCurrentHost() {
        return currentHost;
    }

    public final void setCurrentHost(String currentHost) {
        this.currentHost = currentHost;
    }

    public final String getRemoteHost() {
        return remoteHost;
    }

    public final void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public void setMessage(MimeMessage message) {

    }

    public SOAPMessage getIncomingMsg() {
        return incomingMsg;
    }

    public void setIncomingMsg(SOAPMessage incomingMsg) {
        this.incomingMsg = incomingMsg;
    }

    public void setIncomingMsg(Document incomingMsg) {
        this.icomingMsgAsDocument = incomingMsg;
    }

    public Document getIncomingMsgAsDocument() {
        return this.icomingMsgAsDocument;
    }

    public void setRequest(XMLObject request) {
        this.requestXMLObj = request;
    }

    public XMLObject getRequestAsObject() {
        return this.requestXMLObj;
    }

    public void setRequest(Element request) {
        this.requestDOM = request;
    }

    public Element getRequest1() {
        return this.requestDOM;
    }

    public EnforcePolicy getEnforcer() {
        return this.enforcer;
    }

    public void setEnforcer(EnforcePolicy enforcePolicy) {
        this.enforcer = enforcePolicy;
    }

    public String getUsername() {
        return this.user;
    }

    public void setUsername(String user) {
        this.user = user;
    }

    public X509Certificate getIssuerCertificate() {
        return this.issuercertificate;
    }

    public void setIssuerCertificate(X509Certificate cert) {
        this.issuercertificate = cert;
    }

    public X509Certificate getSenderCertificate() {
        return this.sendercertificate;
    }

    public void setSenderCertificate(X509Certificate cert) {
        this.sendercertificate = cert;
    }

    public X509Certificate getRecipientCertificate() {
        return this.recipientcertificate;
    }

    public void setRecipientCertificate(X509Certificate cert) {
        this.recipientcertificate = cert;
    }

    public DateTime getSubmissionTime() {
        return this.submissionTime;
    }

    public void setSubmissionTime(DateTime dateTime) {
        this.submissionTime = dateTime;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String string) {
        this.event = string;
    }

    public String getMessageUUID() {
        return this.messageUUID;
    }

    public void setMessageUUID(String messageUUID) {
        this.messageUUID = messageUUID;
    }

    public String getAuthenticationMethod() {
        return this.authenticationMethod;
    }

    public void setAuthenticationMethod(String string) {
        this.authenticationMethod = string;
    }

    public PrivateKey getSigningKey() {
        return this.key;
    }

    public void setSigningKey(PrivateKey key) {
        this.key = key;
    }

    public LinkedList<String> getRecipientNamePostalAddress() {
        return this.recipientNamePostalAddress;
    }

    public void setRecipientNamePostalAddress(LinkedList<String> namesPostalAddress) {
        this.recipientNamePostalAddress = namesPostalAddress;
    }

    public LinkedList<String> getSenderNamePostalAddress() {
        return this.senderNamePostalAddress;
    }

    public void setSenderNamePostalAddress(LinkedList<String> sendernamesPostalAddress) {
        this.senderNamePostalAddress = sendernamesPostalAddress;

    }
}
