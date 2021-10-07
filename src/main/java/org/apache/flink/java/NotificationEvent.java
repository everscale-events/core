package org.apache.flink.java;

/**
 * NotificationEvent
 */
public class NotificationEvent {
    private String secret;
    private String url;
    private String hash;
    private String nonce;
    private String encodedMessage;

    public NotificationEvent() {}

    public NotificationEvent(String secret, String url, String hash, String nonce, String encodedMessage) {
        this.secret = secret;
        this.url = url;
        this.hash = hash;
        this.nonce = nonce;
        this.encodedMessage = encodedMessage;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String hash) {
        this.url = url;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }

    public static NotificationEvent fromString(String s) {
        String[] fields = s.split(",");

        return new NotificationEvent(fields[0], fields[1], fields[2], fields[3], fields[4]);
    }

    @Override
    public String toString() {
        return secret + "," + url + "," + hash + "," + nonce + "," + encodedMessage;
    }
}

