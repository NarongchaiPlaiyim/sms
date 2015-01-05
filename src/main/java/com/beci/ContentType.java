package com.beci;

import lombok.Getter;

public enum ContentType {
    TEXT_HTML("text/xml");
    @Getter private String type;

    private ContentType(String type) {
        this.type = type;
    }
}
