package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.entities.Material;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioMaterial;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class CadastrarMaterial implements Initializable{
      
      @FXML
      private ListView<Material> listaMaterial;

      private RepositorioMaterial repositorio;

      public CadastrarMaterial(RepositorioMaterial repositorio){
            this.repositorio = repositorio;
      }

      @FXML
      void voltar(ActionEvent event){
            App.popScreen();
      }



      @Override
      public void initialize(URL arg0, ResourceBundle arg1){

            listaMaterial.getItems().clear();
            Resultado resultado = repositorio.CadastrarMaterial();

            if (resultado.foiErro()) {
                  Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
                  alert.showAndWait();
            }else{
                  List lista = (List)resultado.comoSucesso().getObj();
                  listaMaterial.getItems().addAll(lista);
            }

      }

}
