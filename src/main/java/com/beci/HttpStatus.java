package com.beci;

import lombok.Getter;

public enum HttpStatus {
    OK(200);

    @Getter private int status;

    private HttpStatus(int status) {
        this.status = status;
    }

    public boolean isEquals(final int status){
        try {
            return this.status == status;
        } catch (Exception e) {
            return false;
        }
    }
}
