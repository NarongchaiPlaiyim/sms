package com.beci;

import lombok.Getter;

public enum NumberType {
    ABBREVIATED("abbreviated"),
    INTERNATIONAL("international");

    @Getter private String type;

    private NumberType(String type) {
        this.type = type;
    }

    public boolean isEquals(final String type){
        final boolean TRUE = true;
        try {
            return this.type.equals(type);
        } catch (Exception e) {
            return false;
        }
    }

}
