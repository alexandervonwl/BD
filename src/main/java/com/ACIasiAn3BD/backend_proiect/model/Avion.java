package com.ACIasiAn3BD.backend_proiect.model;

import java.sql.Date;

public class Avion {
    private int avion_id;
    private Date ultima_revizie;
    private Date anul_fabricarii;
    private int capacitate;
    private double incarcatura_maxima;
    private double distanta_maxima;
    private String tip_avion;

    public Avion(){ }

    public Avion(int avion_id, Date ultima_revizie, Date anul_fabricarii, int capacitate, double incarcatura_maxima, double distanta_maxima, String tip_avion) {
        this.avion_id = avion_id;
        this.ultima_revizie = ultima_revizie;
        this.anul_fabricarii = anul_fabricarii;
        this.capacitate = capacitate;
        this.incarcatura_maxima = incarcatura_maxima;
        this.distanta_maxima = distanta_maxima;
        this.tip_avion = tip_avion;
    }

    public int getAvion_id() {
        return avion_id;
    }

    public void setAvion_id(int avion_id) {
        this.avion_id = avion_id;
    }

    public Date getUltima_revizie() {
        return ultima_revizie;
    }

    public void setUltima_revizie(Date ultima_revizie) {
        this.ultima_revizie = ultima_revizie;
    }

    public Date getAnul_fabricarii() {
        return anul_fabricarii;
    }

    public void setAnul_fabricarii(Date anul_fabricarii) {
        this.anul_fabricarii = anul_fabricarii;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public double getIncarcatura_maxima() {
        return incarcatura_maxima;
    }

    public void setIncarcatura_maxima(double incarcatura_maxima) {
        this.incarcatura_maxima = incarcatura_maxima;
    }

    public double getDistanta_maxima() {
        return distanta_maxima;
    }

    public void setDistanta_maxima(double distanta_maxima) {
        this.distanta_maxima = distanta_maxima;
    }

    public String getTip_avion() {
        return tip_avion;
    }

    public void setTip_avion(String tip_avion) {
        this.tip_avion = tip_avion;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "avion_id=" + avion_id +
                ", ultima_revizie=" + ultima_revizie +
                ", anul_fabricarii=" + anul_fabricarii +
                ", capacitate=" + capacitate +
                ", incarcatura_maxima=" + incarcatura_maxima +
                ", distanta_maxima=" + distanta_maxima +
                ", tip_avion='" + tip_avion + '\'' +
                '}';
    }
}
