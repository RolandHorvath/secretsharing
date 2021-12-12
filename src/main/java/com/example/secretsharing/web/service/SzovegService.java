package com.example.secretsharing.web.service;

import com.example.secretsharing.model.Szoveg;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;

@Validated
public interface SzovegService {
    void setSzoveg(Szoveg szoveg) throws Exception;
    void getSzoveg(Szoveg szoveg) throws Exception;
}
