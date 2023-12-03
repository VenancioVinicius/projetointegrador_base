package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.entities.Operador;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioOperador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;

public class SelecionarOperador implements Initializable{
      
      @FXML
      private ListView<Operador> listaOperador;

      private RepositorioOperador repositorio;

      public SelecionarOperador(RepositorioOperador repositorio){
            this.repositorio = repositorio;
      }

      @FXML
      void voltar(ActionEvent event) {
            App.popScreen();
      }

      @FXML
      void salvar(ActionEvent event){
            String operador_selecionado = String.valueOf(listaOperador.getSelectionModel().getSelectedItem());

            Resultado resultado = repositorio.CadastrarOperador(operador_selecionado);

            Alert alert;

            if(resultado.foiErro()){
                  alert = new Alert(AlertType.ERROR, resultado.getMsg());
            }else{
                  alert = new Alert(AlertType.INFORMATION, resultado.getMsg());
            }
            
            alert.showAndWait();
      }

      @Override
      public void initialize(URL arg0, ResourceBundle arg1){

            listaOperador.getItems().clear();
            Resultado resultado = repositorio.SelecionarOperador();

            if(resultado.foiErro()){
                  Alert alert = new Alert(AlertType.ERROR, resultado.getMsg());
                  alert.showAndWait();
            }else{
                  List lista = (List)resultado.comoSucesso().getObj();
                  listaOperador.getItems().addAll(lista);
            }
      }
}
