package ifpr.pgua.eic.contatos.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.contatos.model.entities.Contato;
import ifpr.pgua.eic.contatos.model.repositories.ContatoRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

public class Principal implements Initializable{
    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TableView<Contato> tbContatos;

    @FXML
    private TableColumn<Contato,String> tbcId;

    @FXML
    private TableColumn<Contato,String> tbcNome;

    @FXML
    private TableColumn<Contato,String> tbcTelefone;




    @FXML
    private void adicionar(){
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();

        Resultado<Contato> resultado = Resultado.erro("Implementar!");
        
        
        atualizar();
        
        mostrarMensagem(resultado);
    }


    @FXML
    private void limpar(){
        tfNome.clear();
        tfTelefone.clear();
    }

    @FXML
    private void atualizar(){
        Resultado<ArrayList<Contato>> resultado = Resultado.erro("Implementar!");

        if(resultado.foiSucesso()){
            atualizarTabela(resultado.comoSucesso().getObj());
        }
    }

    private void mostrarMensagem(Resultado<Contato> resultado){
        Alert alert = new Alert(resultado.foiErro()?AlertType.ERROR:AlertType.INFORMATION,resultado.getMsg());
        alert.showAndWait();
    }

    private void atualizarTabela(List<Contato> contatos){
        tbContatos.getItems().clear();
        tbContatos.getItems().addAll(contatos);
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        tbcId.setCellValueFactory(celula -> new SimpleStringProperty(celula.getValue().getId()+""));
        tbcNome.setCellValueFactory(celula -> new SimpleStringProperty(celula.getValue().getNome()));
        tbcTelefone.setCellValueFactory(celula -> new SimpleStringProperty(celula.getValue().getTelefone()));
        
        atualizar();
    
    }
}
