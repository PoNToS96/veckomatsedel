package com.Elffors.veckoMat;

import java.time.LocalDate;

public class Matratt {

    private LocalDate datum;
    private String ratt;
    private String recept;

    public Matratt(LocalDate datum, String ratt) {
        this.datum = datum;
        this.ratt = ratt;
        this.recept = "Rätten saknar recept";
    }

    public Matratt(LocalDate datum, String ratt, String recept) {
        this.datum = datum;
        this.ratt = ratt;
        this.recept = recept;
    }

    public LocalDate getDatum() {
        return this.datum;
    }

    public void setDatum() {
        this.datum = datum;
    }

    public String getRatt() {
        return this.ratt;
    }

    public void setRatt(String ratt) {
        this.ratt = ratt;
        this.recept = "Rätten saknar recept";
    }

    public String getRecept() {
        return this.recept;
    }

    public void setRecept(String recept) {
        this.recept = recept;
    }

    @Override
    public String toString() {
        return datum + ": " + ratt;
    }
}
