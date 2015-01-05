package com.beci;

import lombok.Getter;

public enum UdType{
    TEXT("text"),
    BINARY("binary");

    @Getter private String type;

    private UdType(String type) {
        this.type = type;
    }
}
