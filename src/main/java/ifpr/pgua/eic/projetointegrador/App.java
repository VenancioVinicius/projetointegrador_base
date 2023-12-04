package ifpr.pgua.eic.projetointegrador;

import ifpr.pgua.eic.projetointegrador.controllers.Principal;

import ifpr.pgua.eic.projetointegrador.controllers.SelecionarOperador;
import ifpr.pgua.eic.projetointegrador.controllers.CadastrarMaterial;
import ifpr.pgua.eic.projetointegrador.controllers.ResultadoCalculo;

import ifpr.pgua.eic.projetointegrador.model.daos.OperadorDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCOperadorDAO;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioOperador;

import ifpr.pgua.eic.projetointegrador.model.daos.MaterialDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCMaterialDAO;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioMaterial;

import ifpr.pgua.eic.projetointegrador.model.daos.CalculoDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCCalculoDAO;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioCalculo;

import ifpr.pgua.eic.projetointegrador.model.daos.FabricaConexoes;

import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private OperadorDAO operadorDAO = new JDBCOperadorDAO(FabricaConexoes.getInstance());
    private RepositorioOperador repositorioOperador = new RepositorioOperador(operadorDAO);

    private MaterialDAO materialDAO = new JDBCMaterialDAO(FabricaConexoes.getInstance());
    private RepositorioMaterial repositorioMaterial = new RepositorioMaterial(materialDAO);
    
    private CalculoDAO calculoDAO = new JDBCCalculoDAO(FabricaConexoes.getInstance());
    private RepositorioCalculo repositorioCalculo = new RepositorioCalculo(calculoDAO);

    public static void main(String[] args) {
        launch();
    }

    /*@Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();

    }*/


    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Projeto Integrador";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));
        registraTela("SELECIONAROPERADOR", new ScreenRegistryFXML(App.class, "selecionar_operador.fxml", o->new SelecionarOperador(repositorioOperador)));
        registraTela("CADASTRARMATERIAL", new ScreenRegistryFXML(App.class, "cadastrar_material.fxml", o->new CadastrarMaterial(repositorioMaterial)));
        registraTela("RESULTADOCALCULO", new ScreenRegistryFXML(App.class, "resultado_calculo.fxml", o->new ResultadoCalculo(repositorioCalculo)));
    }

}