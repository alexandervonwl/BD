package com.ACIasiAn3BD.backend_proiect.model;

public class Baza {
    private String nume;
    private boolean cafenea;
    private boolean service_mentenanta;
    private boolean hotel_partener;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean isCafenea() {
        return cafenea;
    }

    public void setCafenea(boolean cafenea) {
        this.cafenea = cafenea;
    }

    public boolean isService_mentenanta() {
        return service_mentenanta;
    }

    public void setService_mentenanta(boolean service_mentenanta) {
        this.service_mentenanta = service_mentenanta;
    }

    public boolean isHotel_partener() {
        return hotel_partener;
    }

    public void setHotel_partener(boolean hotel_partener) {
        this.hotel_partener = hotel_partener;
    }

    @Override
    public String toString() {
        return "Baza{" +
                "nume='" + nume + '\'' +
                ", cafenea=" + cafenea +
                ", service_mentenanta=" + service_mentenanta +
                ", hotel_partener=" + hotel_partener +
                '}';
    }
}
