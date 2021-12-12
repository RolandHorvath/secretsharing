package com.example.secretsharing.web.repository;

import com.example.secretsharing.model.Szoveg;
import com.example.secretsharing.web.service.exception.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SzovegRepositoryImpl implements SzovegRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setSzoveg(Szoveg szoveg,byte[] titkositott,String encodedKey) {
        final String sql = "INSERT INTO szovegek (azonosito,szoveg,jelszo,kulcs) VALUES (?,?,?,?)";
        try{
            jdbcTemplate.update(sql,szoveg.getAzonosito(),titkositott,szoveg.getJelszo(),encodedKey);
        } catch (DuplicateKeyException duplicateKeyException){
            throw new Exceptions("Foglalt azonosító");
        }
    }

    @Override
    public byte[] getSzoveg(Szoveg szoveg) {
        String sql = "SELECT szoveg FROM szovegek WHERE azonosito ='"+ szoveg.getAzonosito()+ "' AND jelszo='"+szoveg.getJelszo()+"'";
        byte[] titkositott= jdbcTemplate.queryForObject(sql, byte[].class);
        return titkositott;
    }

    @Override
    public String getKulcs(Szoveg szoveg) {
        String sql = "SELECT kulcs FROM szovegek WHERE azonosito ='"+ szoveg.getAzonosito()+ "' AND jelszo='"+szoveg.getJelszo()+"'";
        String kulcs = jdbcTemplate.queryForObject(sql, String.class);
        return kulcs;
    }

}
