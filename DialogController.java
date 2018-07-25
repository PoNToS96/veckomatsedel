package com.Elffors.veckoMat;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField matrattsInmatning;

    @FXML
    private TextArea receptInmatning;

    @FXML
    private DatePicker datumValjare;

    public void processResult() {
        String ratt = matrattsInmatning.getText().trim();
        String recept = receptInmatning.getText().trim();
        LocalDate datum = datumValjare.getValue();
        Matratt nyMatratt = new Matratt(datum, ratt, recept);
        MatrattPerDag.getInstans().laggTillMatratt(nyMatratt);
    }
}
