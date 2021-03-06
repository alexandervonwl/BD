package com.ACIasiAn3BD.backend_proiect.model;

public class Baza_Ruta_FK {
    private String baza_nume;
    private int ruta_numa_ruta;

    public Baza_Ruta_FK(){}

    public Baza_Ruta_FK(String baza_nume, int ruta_numa_ruta) {
        this.baza_nume = baza_nume;
        this.ruta_numa_ruta = ruta_numa_ruta;
    }

    public String getBaza_nume() {
        return baza_nume;
    }

    public void setBaza_nume(String baza_nume) {
        this.baza_nume = baza_nume;
    }

    public int getRuta_numa_ruta() {
        return ruta_numa_ruta;
    }

    public void setRuta_numa_ruta(int ruta_numa_ruta) {
        this.ruta_numa_ruta = ruta_numa_ruta;
    }
}
