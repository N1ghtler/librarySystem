package oop.librarysystem;

import java.util.Base64;

public class SecurePassword {
    public String encrypt(String plainPassword) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(plainPassword.getBytes());
    }
    public String decrypt(String encryptPassword){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(encryptPassword);
        return new String(bytes);
    }
}
