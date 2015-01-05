package com.beci;

import lombok.Getter;

public enum  SentDeliveredStatusType {
    SUCCESS("000", "Successfully sent to phone"),
    FAILED("001", "Delivery to phone failed");
    @Getter private String code;
    @Getter private String description;

    private SentDeliveredStatusType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
