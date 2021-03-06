package com.ACIasiAn3BD.backend_proiect.model;

public class Ruta {
    private int durata;
    private Integer numar_ruta;
    private int distanta;
    private String ruta;

    public Ruta(){}

    public Ruta(int durata, Integer numar_ruta, int distanta, String ruta) {
        this.durata = durata;
        this.numar_ruta = numar_ruta;
        this.distanta = distanta;
        this.ruta = ruta;
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

    @Override
    public String toString() {
        return "Ruta{" +
                "durata=" + durata +
                ", numar_ruta=" + numar_ruta +
                ", distanta=" + distanta +
                ", ruta='" + ruta + '\'' +
                '}';
    }
}
