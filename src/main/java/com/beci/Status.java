package com.beci;

import lombok.Getter;

public enum Status {
    SUCCESS("success"),
    FAILURE("failure");
    @Getter private String status;

    private Status(String status) {
        this.status = status;
    }
}
