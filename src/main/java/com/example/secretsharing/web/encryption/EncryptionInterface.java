package com.example.secretsharing.web.encryption;

import com.example.secretsharing.model.Szoveg;
import java.security.NoSuchAlgorithmException;

public interface EncryptionInterface {
    byte[] encrypt(Szoveg szoveg,String kulcs) throws Exception;
    String decrypt(Szoveg szoveg, String kulcs, byte[] titkositott) throws Exception;
    String keygen() throws NoSuchAlgorithmException;
}
