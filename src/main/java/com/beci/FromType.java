package com.beci;

import lombok.Getter;

public enum FromType {
    USSD_HTTP("USSD_HTTP");
    @Getter private String type;

    private FromType(String type) {
        this.type = type;
    }

    public boolean isEquals(final String type){
        try {
            return this.type.equals(type);
        } catch (Exception e) {
            return false;
        }
    }
}
