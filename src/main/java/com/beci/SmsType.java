package com.beci;

import lombok.Getter;

public enum SmsType {
    MO("mo"),
    MT("mt");
    @Getter private String type;

    private SmsType(String type) {
        this.type = type;
    }

}
