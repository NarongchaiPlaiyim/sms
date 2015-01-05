package com.beci.service.exception;

public class AuthorizationBase64Exception extends Exception{

    public AuthorizationBase64Exception() {

    }

    public AuthorizationBase64Exception(String message) {
        super(message);
    }

    public AuthorizationBase64Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationBase64Exception(Throwable cause) {
        super(cause);
    }

    public static AuthorizationBase64Exception invalidUsernameOrPassword(){
        return new AuthorizationBase64Exception("Username or password should not be empty and null.");
    }

    public static AuthorizationBase64Exception failed(final String encoded){
        return new AuthorizationBase64Exception("Authorization failed["+encoded+"]");
    }
}
