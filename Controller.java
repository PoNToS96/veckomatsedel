package com.Elffors.veckoMat;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import java.util.*;

public class Controller {
    private ObservableList<Matratt> lista;

    @FXML
    private ListView<Matratt> rattListView;

    @FXML
    private TextArea receptYta;

    @FXML
    private GridPane gridPane;

    public void initialize() {
        lista = MatrattPerDag.getInstans().getMatrattPerDag();
        rattListView.setItems(lista);
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
