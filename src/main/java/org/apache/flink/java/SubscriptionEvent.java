package org.apache.flink.java;

/**
 * SubscriptionEvent
 *
 * This is a POJO, which Flink recognizes and will allow "by-name" field referencing when keying a DataStream of such a type.
 */
public class SubscriptionEvent {
    private String hash;
    private String data;
    private String secret;
    private long timestamp;

    public SubscriptionEvent() {}

    public SubscriptionEvent(String hash, String data, String secret, long timestamp) {
        this.hash = hash;
        this.data = data;
        this.secret = secret;
        this.timestamp = timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String data) {
        this.secret = secret;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static SubscriptionEvent fromString(String s) {
        String[] fields = s.split(",");

        return new SubscriptionEvent(fields[0], fields[1], fields[2], Long.valueOf(fields[3]));
    }

    @Override
    public String toString() {
        return hash + "," + data + "," + secret + "," + timestamp;
    }
}

