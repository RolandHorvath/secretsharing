package com.example.secretsharing.model;

public class Szoveg {

    private String azonosito;

    private String szoveg;

    private String jelszo;

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(String azonosito) {
        this.azonosito = azonosito;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }

    public Szoveg() {

    }

    public Szoveg(String azonosito, String szoveg,String jelszo) {
        this.azonosito = azonosito;
        this.szoveg = szoveg;
        this.jelszo = jelszo;
    }

    @Override
    public String toString() {
        return "Szoveg{" +
                "azonosito='" + azonosito + '\'' +
                ", szoveg='" + szoveg + '\'' +
                ", jelszo='" + jelszo + '\'' +
                '}';
    }
}
