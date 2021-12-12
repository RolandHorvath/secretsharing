package com.example.secretsharing.web.service;

import com.example.secretsharing.model.Szoveg;
import com.example.secretsharing.web.encryption.EncryptionInterface;
import com.example.secretsharing.web.repository.SzovegRepository;
import com.example.secretsharing.web.service.exception.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SzovegServiceImpl implements SzovegService {

    @Autowired
    private SzovegRepository repository;
    @Autowired
    private EncryptionInterface encryptionInterface;

    @Override
    @Transactional(rollbackFor = Exceptions.class)
    public void setSzoveg(Szoveg szoveg) throws Exception {
        String encodedKey = encryptionInterface.keygen();
        byte[] titkositott = encryptionInterface.encrypt(szoveg,encodedKey);
        repository.setSzoveg(szoveg,titkositott,encodedKey);
    }

    @Override
    public void getSzoveg(Szoveg szoveg) throws Exception {
        String kulcs = repository.getKulcs(szoveg);
        byte[] titkositott = repository.getSzoveg(szoveg);
        String decodedString = encryptionInterface.decrypt(szoveg,kulcs,titkositott);
        szoveg.setSzoveg(decodedString);
    }
}







