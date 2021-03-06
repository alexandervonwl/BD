package com.ACIasiAn3BD.backend_proiect.model;

public class Ruta_Angajat_FK {
    private int ruta_numar_ruta;
    private int angajat_angajat_id;

    public Ruta_Angajat_FK(){}

    public Ruta_Angajat_FK(int ruta_numar_ruta, int angajat_angajat_id) {
        this.ruta_numar_ruta = ruta_numar_ruta;
        this.angajat_angajat_id = angajat_angajat_id;
    }

    public int getRuta_numar_ruta() {
        return ruta_numar_ruta;
    }

    public void setRuta_numar_ruta(int ruta_numar_ruta) {
        this.ruta_numar_ruta = ruta_numar_ruta;
    }

    public int getAngajat_angajat_id() {
        return angajat_angajat_id;
    }

    public void setAngajat_angajat_id(int angajat_angajat_id) {
        this.angajat_angajat_id = angajat_angajat_id;
    }
}
