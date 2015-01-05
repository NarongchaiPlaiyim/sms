package com.beci;

import lombok.Getter;

public enum HeaderType{
    CONNECTION("Connection"),
    KEEP_ALIVE("Keep-Alive"),
    CLOSE("Close");

    @Getter private String type;

    private HeaderType(String type) {
        this.type = type;
    }
}
