package com.beci;

import lombok.Getter;

public enum DescriptionType {
    SUCCESS_RECEIVE_REQUEST("Success receive request"),//code 0
    AUTHENTICATION_FAILED("Authentication failed"),//code 003
    BAD_REQUEST("Bad Request"),//code 400
    SUCCESS("Success");//code 200

    @Getter private String type;

    private DescriptionType(String type) {
        this.type = type;
    }
}
