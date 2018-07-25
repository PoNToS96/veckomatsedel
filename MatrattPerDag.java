package com.Elffors.veckoMat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class MatrattPerDag {
    private static MatrattPerDag instans = new MatrattPerDag();
    private static ObservableList<Matratt> matratterPerDag = FXCollections.observableArrayList();
    private Matratt matratt;

    public static MatrattPerDag getInstans() {
        return instans;
    }

    public ObservableList<Matratt> getMatrattPerDag() {
        return matratterPerDag;
    }

    public void laggTillMatratt(Matratt matratt) {
        boolean kontroll = true;
        LocalDate datum = matratt.getDatum();
        if (matratterPerDag.size() == 0){
            matratterPerDag.add(matratt);
            kontroll = false;
        } else {
            for (Matratt ratt : matratterPerDag) {
                if (datum.equals(ratt.getDatum())) {
                    int index = matratterPerDag.indexOf(ratt);
                    matratterPerDag.remove(ratt);
                    matratterPerDag.add(index, matratt);
                    kontroll = false;
                }
            }
        }
        if (kontroll) {
                matratterPerDag.add(matratt);
            }
        }

    public String toString() {
        return matratt.getDatum().toString() + ": " + matratt.getRatt();
    }
}
