package com.ACIasiAn3BD.backend_proiect.model;

import java.sql.Date;


public class Angajat {
    private Integer angajat_id;
    private String nume;
    private String prenume;
    private Date data_angajare;
    private String functie;
    private int salariu;
    private Integer numar_zboruri;

    public Angajat(){ }

    public Angajat(Integer angajat_id, String nume, String prenume, Date data_angajare, String functie, int salariu, int numar_zboruri) {
        this.angajat_id = angajat_id;
        this.nume = nume;
        this.prenume = prenume;
        this.data_angajare = data_angajare;
        this.functie = functie;
        this.salariu = salariu;
        this.numar_zboruri = numar_zboruri;
    }

    public Integer getAngajat_id() {
        return angajat_id;
    }

    public void setAngajat_id(Integer angajat_id) {
        this.angajat_id = angajat_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Date getData_angajare() {
        return data_angajare;
    }

    public void setData_angajare(Date data_angajare) {
        this.data_angajare = data_angajare;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public Integer getNumar_zboruri() {
        return numar_zboruri;
    }

    public void setNumar_zboruri(Integer numar_zboruri) {
        this.numar_zboruri = numar_zboruri;
    }
}
