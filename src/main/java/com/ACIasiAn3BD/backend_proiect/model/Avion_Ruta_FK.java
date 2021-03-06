package com.ACIasiAn3BD.backend_proiect.model;

public class Avion_Ruta_FK {
    private int avion_avion_id;
    private int ruta_numar_ruta;

    Avion_Ruta_FK(){}

    public Avion_Ruta_FK(int avion_avion_id, int ruta_numar_ruta) {
        this.avion_avion_id = avion_avion_id;
        this.ruta_numar_ruta = ruta_numar_ruta;
    }

    public int getAvion_avion_id() {
        return avion_avion_id;
    }

    public void setAvion_avion_id(int avion_avion_id) {
        this.avion_avion_id = avion_avion_id;
    }

    public int getRuta_numar_ruta() {
        return ruta_numar_ruta;
    }

    public void setRuta_numar_ruta(int ruta_numar_ruta) {
        this.ruta_numar_ruta = ruta_numar_ruta;
    }
}
