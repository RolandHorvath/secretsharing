package com.example.secretsharing.web.controller;

import com.example.secretsharing.model.Szoveg;
import com.example.secretsharing.web.service.SzovegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SzovegController {

    private static final String FORMOLDAL = "/feltoltes";
    private static final String FORM = "feltoltes";
    private static final String FORM_ATTRIBUTE = "form";
    private static final String QUERYOLDAL = "/query";
    private static final String QUERY = "query";
    private static final String QUERY_ATTRIBUTE = "lekerdezett";

    @Autowired
    private SzovegService szovegService;

    @GetMapping(value = {"/",FORMOLDAL})
    public String feltoltes(@ModelAttribute(FORM_ATTRIBUTE) Szoveg sz){
        return FORM;
    }

    @PostMapping(FORMOLDAL)
    public String submit(@ModelAttribute(FORM_ATTRIBUTE) Szoveg szoveg) throws Exception {
        szovegService.setSzoveg(szoveg);
        return FORM;
    }

    @GetMapping(value={"/query"})
    public String lekeres(@ModelAttribute(QUERY_ATTRIBUTE) Szoveg sz){
        return QUERY;
    }

    @PostMapping(QUERYOLDAL)
    public String query(@ModelAttribute(QUERY_ATTRIBUTE) Szoveg szoveg) throws Exception {
        szovegService.getSzoveg(szoveg);
        return QUERY;
    }

}
