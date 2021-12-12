package com.example.secretsharing.web.encryption;

import com.example.secretsharing.model.Szoveg;
import org.springframework.stereotype.Component;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class Encryption implements EncryptionInterface {

    public String keygen() throws NoSuchAlgorithmException {
        int Kulcsmeret = 128;
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(Kulcsmeret);
        SecretKey skey = kgen.generateKey();
        String encodedKey = Base64.getEncoder().encodeToString(skey.getEncoded());
        return encodedKey;
    }


    @Override
    public byte[] encrypt(Szoveg szoveg,String kulcs) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(kulcs);
        SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] titkositott;
        titkositott = c.doFinal(szoveg.getSzoveg().getBytes("UTF-8"));
        return titkositott;
    }

    @Override
    public String decrypt(Szoveg szoveg,String kulcs,byte[] titkositott) throws Exception {
        byte[] decodedKey = Base64.getDecoder().decode(kulcs);
        SecretKey key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedstring;
        decodedstring = c.doFinal(titkositott);
        String decodedString = new String(decodedstring);
        return decodedString;
    }

}
