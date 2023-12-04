package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Principal{
   
    @FXML
    void operador(ActionEvent event){
        App.pushScreen("SELECIONAROPERADOR");
    }

    @FXML
    void material(ActionEvent event){
        App.pushScreen("CADASTRARMATERIAL");
    }

    @FXML
    void resultado(ActionEvent event){
        App.pushScreen("RESULTADOCALCULO");
    }
}
