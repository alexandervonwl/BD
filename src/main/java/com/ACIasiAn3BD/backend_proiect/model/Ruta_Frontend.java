package com.ACIasiAn3BD.backend_proiect.model;

public class Ruta_Frontend {
    private int durata;
    private Integer numar_ruta;
    private int distanta;
    private String ruta;
    private int avion_avion_id;
    private String baza_nume1;
    private String baza_nume2;
    private int angajat_angajat_id;

    public Ruta_Frontend(){}

    public Ruta_Frontend(int durata, Integer numar_ruta, int distanta, String ruta, int avion_avion_id, int angajat_angajat_id, String baza_nume1, String baza_nume2) {
        this.durata = durata;
        this.numar_ruta = numar_ruta;
        this.distanta = distanta;
        this.ruta = ruta;
        this.avion_avion_id = avion_avion_id;
        this.angajat_angajat_id = angajat_angajat_id;
        this.baza_nume1 = baza_nume1;
        this.baza_nume2 = baza_nume2;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Integer getNumar_ruta() {
        return numar_ruta;
    }

    public void setNumar_ruta(Integer numar_ruta) {
        this.numar_ruta = numar_ruta;
    }

    public int getDistanta() {
        return distanta;
    }

    public void setDistanta(int distanta) {
        this.distanta = distanta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getAvion_avion_id() {
        return avion_avion_id;
    }

    public void setAvion_avion_id(int avion_avion_id) {
        this.avion_avion_id = avion_avion_id;
    }

    public String getBaza_nume1() {
        return baza_nume1;
    }

    public void setBaza_nume1(String baza_nume1) {
        this.baza_nume1 = baza_nume1;
    }

    public String getBaza_nume2() {
        return baza_nume2;
    }

    public void setBaza_nume2(String baza_nume2) {
        this.baza_nume2 = baza_nume2;
    }

    public int getAngajat_angajat_id() {
        return angajat_angajat_id;
    }

    public void setAngajat_angajat_id(int angajat_angajat_id) {
        this.angajat_angajat_id = angajat_angajat_id;
    }


    @Override
    public String toString() {
        return "Ruta_Frontend{" +
                "durata=" + durata +
                ", numar_ruta=" + numar_ruta +
                ", distanta=" + distanta +
                ", ruta='" + ruta + '\'' +
                ", avion_avion_id=" + avion_avion_id +
                ", baza_nume1='" + baza_nume1 + '\'' +
                ", baza_nume2='" + baza_nume2 + '\'' +
                ", angajat_angajat_id=" + angajat_angajat_id +
                '}';
    }
}
