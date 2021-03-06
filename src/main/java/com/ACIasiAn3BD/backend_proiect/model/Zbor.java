package com.ACIasiAn3BD.backend_proiect.model;

import java.sql.Date;

public class Zbor {
    private int numar_zbor;
    private int numar_ruta;
    private String ziua_ora_decolare;
    private String oras_aterizare;
    private String oras_decolare;
    private String oras_oprire1;
    private String oras_oprire2;
    private int numar_echipaj;
    private double pret_business_class;
    private double pret_economic_class;
    private int avion_id;

    public String getZiua_ora_decolare() {
        return ziua_ora_decolare;
    }

    public void setZiua_ora_decolare(String ziua_ora_decolare) {
        this.ziua_ora_decolare = ziua_ora_decolare;
    }

    public int getNumar_zbor() {
        return numar_zbor;
    }

    public void setNumar_zbor(int numar_zbor) {
        this.numar_zbor = numar_zbor;
    }

    public int getNumar_ruta() {
        return numar_ruta;
    }

    public void setNumar_ruta(int numar_ruta) {
        this.numar_ruta = numar_ruta;
    }

    public double getPret_business_class() {
        return pret_business_class;
    }

    public void setPret_business_class(double pret_business_class) {
        this.pret_business_class = pret_business_class;
    }

    public double getPret_economic_class() {
        return pret_economic_class;
    }

    public void setPret_economic_class(double pret_economic_class) {
        this.pret_economic_class = pret_economic_class;
    }

    public int getNumar_echipaj() {
        return numar_echipaj;
    }

    public void setNumar_echipaj(int numar_echipaj) {
        this.numar_echipaj = numar_echipaj;
    }

    public String getOras_aterizare() {
        return oras_aterizare;
    }

    public void setOras_aterizare(String oras_aterizare) {
        this.oras_aterizare = oras_aterizare;
    }

    public String getOras_decolare() {
        return oras_decolare;
    }

    public void setOras_decolare(String oras_decolare) {
        this.oras_decolare = oras_decolare;
    }

    public String getOras_oprire1() {
        return oras_oprire1;
    }

    public void setOras_oprire1(String oras_oprire1) {
        this.oras_oprire1 = oras_oprire1;
    }

    public String getOras_oprire2() {
        return oras_oprire2;
    }

    public void setOras_oprire2(String oras_oprire2) {
        this.oras_oprire2 = oras_oprire2;
    }

    public int getAvion_id() {
        return avion_id;
    }

    public void setAvion_id(int avion_id) {
        this.avion_id = avion_id;
    }

    @Override
    public String toString() {
        return "Zbor{" +
                "ziua_ora_decolare=" + ziua_ora_decolare +
                ", numar_zbor=" + numar_zbor +
                ", numar_ruta=" + numar_ruta +
                ", pret_business_class=" + pret_business_class +
                ", pret_economic_class=" + pret_economic_class +
                ", numar_echipaj=" + numar_echipaj +
                ", oras_aterizare='" + oras_aterizare + '\'' +
                ", oras_decolare='" + oras_decolare + '\'' +
                ", oras_oprire1='" + oras_oprire1 + '\'' +
                ", oras_oprire2='" + oras_oprire2 + '\'' +
                ", avion_id=" + avion_id +
                '}';
    }
}
