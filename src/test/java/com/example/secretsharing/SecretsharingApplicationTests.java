package com.example.secretsharing;

import com.example.secretsharing.model.Szoveg;
import com.example.secretsharing.web.service.SzovegService;
import com.example.secretsharing.web.service.exception.Exceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SecretsharingApplicationTests {

    private static final String AZONOSITO = "azonosito";
    private static final String SZOVEG = "szoveg";
    private static final String JELSZO = "jelszo";


    @Autowired
    private SzovegService szovegService;


    @Test
    void Duplicate() {
        RuntimeException thrown = Assertions.assertThrows(Exceptions.class, () -> {
            szovegService.setSzoveg(new Szoveg(AZONOSITO,SZOVEG,JELSZO));
            szovegService.setSzoveg(new Szoveg(AZONOSITO,SZOVEG,JELSZO));
        });
        Assertions.assertEquals("Foglalt azonosító", thrown.getMessage());
    }

    @Test
    void NullInput() {
        RuntimeException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            szovegService.setSzoveg(null);
        });
    }

    @Test
    void getSzovegTest() throws Exception {
        Szoveg getsz = new Szoveg("getSzovegTest","TestSzoveg","getSzovegTest");
        szovegService.getSzoveg(getsz);
        Assertions.assertEquals("TestSzoveg",getsz.getSzoveg());
    }



}
