package com.beci;

import lombok.Getter;

public enum RsrType {
    SENT("sent"),
    SENT_DELIVERED("sent_delivered"),
    ACK("ack"),
    REPLY("reply");
    @Getter private String type;

    private RsrType(String type) {
        this.type = type;
    }
}
