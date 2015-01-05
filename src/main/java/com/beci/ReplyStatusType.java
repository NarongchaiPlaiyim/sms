package com.beci;

import lombok.Getter;

public enum  ReplyStatusType {
    SUCCESS("0", "Success receive request");
    @Getter private String code;
    @Getter  private String description;

    private ReplyStatusType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
