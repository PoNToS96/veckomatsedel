package com.Elffors.veckoMat;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class DialogController {

    @FXML
    private DatePicker datumValjare;

    @FXML
    private TextField matrattsInmatning;

    @FXML
    private TextArea receptInmatning;

    public void processResult() {
        LocalDate datum = datumValjare.getValue();
        String ratt = matrattsInmatning.getText().trim();
        String recept = receptInmatning.getText().trim();
        if (datum != null) {
            if (!ratt.equals("") && !recept.equals("")) {
                MatrattPerDag.getInstans().laggTillMatratt(new Matratt(datum, ratt, recept));
            } else if (!ratt.equals("") && recept.equals("")) {
                MatrattPerDag.getInstans().laggTillMatratt(new Matratt(datum, ratt));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Du måste skriva vad maträtten heter");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Du måste ange ett datum");
            alert.showAndWait();
        }
    }
}
