package org.apache.flink.java;

/**
 * QueueProviderEvent
 *
 * This is a POJO, which Flink recognizes and will allow "by-name" field referencing when keying a DataStream of such a type.
 */
public class QueueProviderEvent {
    private String idempotencyKey;
    private String hash;
    private String nonce;
    private String encodedMessage;
    private long timestamp;

    public QueueProviderEvent() {}

    public QueueProviderEvent(String idempotencyKey, String hash, String nonce, String encodedMessage, long timestamp) {
        this.idempotencyKey = idempotencyKey;
        this.hash = hash;
        this.nonce = nonce;
        this.encodedMessage = encodedMessage;
        this.timestamp = timestamp;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static QueueProviderEvent fromString(String s) {
        String[] fields = s.split(",");

        return new QueueProviderEvent(fields[0], fields[1], fields[2], fields[3], Long.valueOf(fields[4]));
    }

    @Override
    public String toString() {
        return idempotencyKey + "," + hash + "," + nonce + "," + encodedMessage + "," + timestamp;
    }
}

