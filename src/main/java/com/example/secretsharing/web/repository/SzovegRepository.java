package com.example.secretsharing.web.repository;

import com.example.secretsharing.model.Szoveg;

public interface SzovegRepository {
    void setSzoveg(Szoveg szoveg, byte[] titkositott, String encodedKey);
    byte[] getSzoveg(Szoveg szoveg);
    String getKulcs(Szoveg szoveg);

}
