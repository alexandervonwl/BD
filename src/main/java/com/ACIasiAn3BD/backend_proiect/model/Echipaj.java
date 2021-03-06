package com.ACIasiAn3BD.backend_proiect.model;

public class Echipaj {
    private int numar_ruta;
    private int numar_zbor;
    private int pilot_id;
    private int copilot_id;
    private int steward1_id;
    private int steward2_id;
    private int steward3_id;
    private int steward4_id;
    private Integer steward5_id;
    private Integer steward6_id;
    private Integer echipaj_id;

    public int getNumar_ruta() {
        return numar_ruta;
    }

    public void setNumar_ruta(int numar_ruta) {
        this.numar_ruta = numar_ruta;
    }

    public int getNumar_zbor() {
        return numar_zbor;
    }

    public void setNumar_zbor(int numar_zbor) {
        this.numar_zbor = numar_zbor;
    }

    public Integer getEchipaj_id() {
        return echipaj_id;
    }

    public void setEchipaj_id(Integer echipaj_id) {
        this.echipaj_id = echipaj_id;
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public void setPilot_id(int pilot_id) {
        this.pilot_id = pilot_id;
    }

    public int getCopilot_id() {
        return copilot_id;
    }

    public void setCopilot_id(int copilot_id) {
        this.copilot_id = copilot_id;
    }

    public int getSteward1_id() {
        return steward1_id;
    }

    public void setSteward1_id(int steward1_id) {
        this.steward1_id = steward1_id;
    }

    public int getSteward2_id() {
        return steward2_id;
    }

    public void setSteward2_id(int steward2_id) {
        this.steward2_id = steward2_id;
    }

    public int getSteward3_id() {
        return steward3_id;
    }

    public void setSteward3_id(int steward3_id) {
        this.steward3_id = steward3_id;
    }

    public int getSteward4_id() {
        return steward4_id;
    }

    public void setSteward4_id(int steward4_id) {
        this.steward4_id = steward4_id;
    }

    public Integer getSteward5_id() {
        return steward5_id;
    }

    public void setSteward5_id(Integer steward5_id) {
        this.steward5_id = steward5_id;
    }

    public Integer getSteward6_id() {
        return steward6_id;
    }

    public void setSteward6_id(Integer steward6_id) {
        this.steward6_id = steward6_id;
    }

    @Override
    public String toString() {
        return "Echipaj{" +
                "numar_ruta=" + numar_ruta +
                ", numar_zbor=" + numar_zbor +
                ", echipaj_id=" + echipaj_id +
                ", pilot_id=" + pilot_id +
                ", copilot_id=" + copilot_id +
                ", steward1_id=" + steward1_id +
                ", steward2_id=" + steward2_id +
                ", steward3_id=" + steward3_id +
                ", steward4_id=" + steward4_id +
                ", steward5_id=" + steward5_id +
                ", steward6_id=" + steward6_id +
                '}';
    }
}
