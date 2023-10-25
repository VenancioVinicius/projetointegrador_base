package ifpr.pgua.eic.projetointegrador.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Principal{
   
    @FXML
    private void acao(){
        Alert alert = new Alert(AlertType.INFORMATION,"Oi!");
        alert.showAndWait();
    }
}
