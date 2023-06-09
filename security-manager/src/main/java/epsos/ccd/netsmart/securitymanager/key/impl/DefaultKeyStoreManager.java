package epsos.ccd.netsmart.securitymanager.key.impl;

import epsos.ccd.netsmart.securitymanager.exceptions.SMgrException;
import epsos.ccd.netsmart.securitymanager.key.KeyStoreManager;
import eu.europa.ec.sante.ehdsi.openncp.configmanager.ConfigurationManager;
import eu.europa.ec.sante.ehdsi.openncp.configmanager.ConfigurationManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public final class DefaultKeyStoreManager implements KeyStoreManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultKeyStoreManager.class);

    private final String KEYSTORE_LOCATION;
    private final String TRUSTSTORE_LOCATION;
    private final String KEYSTORE_PASSWORD;
    private final String TRUSTSTORE_PASSWORD;
    private final String PRIVATEKEY_ALIAS;
    private final String PRIVATEKEY_PASSWORD;
    private KeyStore keyStore;
    private KeyStore trustStore;

    public DefaultKeyStoreManager() {

        // Constants Initialization
        ConfigurationManager cm = ConfigurationManagerFactory.getConfigurationManager();
        KEYSTORE_LOCATION = cm.getProperty("NCP_SIG_KEYSTORE_PATH");
        TRUSTSTORE_LOCATION = cm.getProperty("TRUSTSTORE_PATH");
        KEYSTORE_PASSWORD = cm.getProperty("NCP_SIG_KEYSTORE_PASSWORD");
        TRUSTSTORE_PASSWORD = cm.getProperty("TRUSTSTORE_PASSWORD");
        PRIVATEKEY_ALIAS = cm.getProperty("NCP_SIG_PRIVATEKEY_ALIAS");
        PRIVATEKEY_PASSWORD = cm.getProperty("NCP_SIG_PRIVATEKEY_PASSWORD");

        keyStore = getKeyStore();
        trustStore = getTrustStore();
    }

    @Override
    public KeyPair getPrivateKey(String alias, char[] password) throws SMgrException {

        try {

            // Get private key
            Key key = keyStore.getKey(alias, password);
            if (key instanceof PrivateKey) {
                // Get certificate of public key
                java.security.cert.Certificate cert = keyStore.getCertificate(alias);

                // Get public key
                PublicKey publicKey = cert.getPublicKey();

                // Return a key pair
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (UnrecoverableKeyException e) {
            LOGGER.error(null, e);
            throw new SMgrException("Key with alias:" + alias + " is unrecoverable", e);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error(null, e);
            throw new SMgrException("Key with alias:" + alias + " uses an incompatible algorithm", e);
        } catch (KeyStoreException e) {
            LOGGER.error(null, e);
            throw new SMgrException("Key with alias:" + alias + " not found", e);
        }
        return null;
    }

    @Override
    public KeyStore getKeyStore() {

        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

            try (InputStream keystoreStream = new FileInputStream(KEYSTORE_LOCATION)) {
                keyStore.load(keystoreStream, KEYSTORE_PASSWORD.toCharArray());

                return keyStore;
            }

        } catch (IOException | CertificateException | NoSuchAlgorithmException | KeyStoreException ex) {
            LOGGER.error(null, ex);
        }
        return null;
    }

    @Override
    public Certificate getCertificate(String alias) throws SMgrException {

        try {
            return keyStore.getCertificate(alias);

        } catch (KeyStoreException ex) {
            LOGGER.error(null, ex);
            throw new SMgrException("Certificate with alias: " + alias + " not found in keystore", ex);
        }
    }

    @Override
    public KeyStore getTrustStore() {

        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try (InputStream keystoreStream = new FileInputStream(TRUSTSTORE_LOCATION)) {
                trustStore.load(keystoreStream, TRUSTSTORE_PASSWORD.toCharArray());
                return trustStore;
            }
        } catch (IOException | NoSuchAlgorithmException | CertificateException | KeyStoreException ex) {
            LOGGER.error(null, ex);
        }
        return null;
    }

    @Override
    public KeyPair getDefaultPrivateKey() throws SMgrException {
        return getPrivateKey(PRIVATEKEY_ALIAS, PRIVATEKEY_PASSWORD.toCharArray());
    }

    @Override
    public Certificate getDefaultCertificate() throws SMgrException {
        return getCertificate(PRIVATEKEY_ALIAS);
    }
}
