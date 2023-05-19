package com.andurasoftware.alexandria.business.infra.cript;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptHelper {

    private BCryptPasswordEncoder encoder;

    public EncryptHelper() {
        this.encoder = new BCryptPasswordEncoder(7);
    }

    public String encryptPassword(String rawPassword) {
        return this.encoder.encode(rawPassword);
    }

    public boolean match(String rawPassword,String encryptedPassword){
        return this.encoder.matches(rawPassword,encryptedPassword);
    }
}
