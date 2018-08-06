package com.Elffors.veckoMat;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.*;

public class Controller {

    @FXML
    private ListView<Matratt> rattListView;

    @FXML
    private TextArea receptYta;

    @FXML
    private GridPane gridPane;

    public void initialize() {
        ObservableList<Matratt> lista = MatrattPerDag.getInstans().getMatrattPerDag();
        SortedList<Matratt> sorteradLista = new SortedList<>(lista);
        rattListView.setItems(sorteradLista.sorted());
    }

    @FXML
    public void visaNyInmatningsDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(gridPane.getScene().getWindow());
        dialog.setTitle("Lägg till maträtt");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("inmatningsDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Kunde inte ladda dialogrutan");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> resultat = dialog.showAndWait();
        if(resultat.isPresent() && resultat.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            controller.processResult();
        }
    }

    public void setReceptYta() {
        Matratt ratt = rattListView.getSelectionModel().getSelectedItem();
        receptYta.setText(ratt.getRecept());
    }
}
