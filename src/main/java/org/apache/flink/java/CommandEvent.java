package org.apache.flink.java;

import java.util.*;

/**
 * CommandEvent
 */
public class CommandEvent {
    private String hash;
    private long timestamp;
    private String op;
    private List<String> args;

    public CommandEvent() {}

    public CommandEvent(String hash, long timestamp, String op, List<String> args) {
        this.hash = hash;
        this.timestamp = timestamp;
        this.op = op;
        this.args = args;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public static CommandEvent fromString(String s) {
        String[] fields = s.split(",");
        List<String> args = new ArrayList<String>();

        for (int i = 3; i < fields.length; i++) {
            args.add(fields[i]);
        }

        return new CommandEvent(fields[0], Long.valueOf(fields[1]), fields[2], args);
    }

    @Override
    public String toString() {
        return hash + "," + timestamp + "," + op + "," + String.join(",", args);
    }
}

