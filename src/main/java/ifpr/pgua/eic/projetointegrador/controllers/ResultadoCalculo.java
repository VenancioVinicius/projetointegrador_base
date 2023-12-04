package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.entities.Calculo;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioCalculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class ResultadoCalculo implements Initializable{
      
      @FXML
      private ListView<Calculo> listaResultado;

      private RepositorioCalculo repositorio;

      public ResultadoCalculo(RepositorioCalculo repositorio){
            this.repositorio = repositorio;
      }

      @FXML
      void voltar(ActionEvent event){
            App.popScreen();
      }

      @FXML
      void limpar(ActionEvent event){

            Resultado resultado = repositorio.Limpar();

            Alert alert;

            if (resultado.foiErro()) {
                  alert = new Alert(AlertType.ERROR, resultado.getMsg());                 
            }else{
                  alert = new Alert(AlertType.INFORMATION, resultado.getMsg());
            }

            alert.showAndWait();

      }

      @Override
      public void initialize(URL arg0, ResourceBundle arg1){

            listaResultado.getItems().clear();
            Resultado resultado = repositorio.ListarCalculo();

            if (resultado.foiErro()) {
                  Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
                  alert.showAndWait();
            } else {
                  List lista = (List)resultado.comoSucesso().getObj();
                  listaResultado.getItems().addAll(lista);
            }
      }

}
