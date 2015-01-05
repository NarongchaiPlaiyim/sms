package com.beci.service.authorization;

import com.beci.Utils;
import com.beci.service.exception.AuthorizationBase64Exception;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AuthorizationBase64 {
    @Setter @Getter private String userName;
    @Setter @Getter private String password;
    @Setter @Getter private String encoded;
    private final static String SEMICOLON = ":";

    public AuthorizationBase64(final String userName, final String password) {
        if(!Utils.isEmpty(userName) && !Utils.isEmpty(password)){
            setUserName(userName);
            setPassword(password);
            setEncoded(Base64.getEncoder().encodeToString(new StringBuilder(userName).append(SEMICOLON).append(password).toString().getBytes(StandardCharsets.UTF_8)));
//            String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
        }
    }

    public boolean isAllowed(final String encoded) throws AuthorizationBase64Exception {
        if(!Utils.isEmpty(encoded) && Utils.equals(getEncoded(), encoded.replace("Basic ", ""))){
            return true;
        }
        throw AuthorizationBase64Exception.failed(encoded);
    }
}
