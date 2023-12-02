package ifpr.pgua.eic.projetointegrador;

import ifpr.pgua.eic.projetointegrador.controllers.Principal;
import ifpr.pgua.eic.projetointegrador.controllers.SelecionarOperador;

import ifpr.pgua.eic.projetointegrador.model.daos.OperadorDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCOperadorDAO;
import ifpr.pgua.eic.projetointegrador.model.repositories.RepositorioOperador;

import ifpr.pgua.eic.projetointegrador.model.daos.FabricaConexoes;

import ifpr.pgua.eic.projetointegrador.utils.DBUtils;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    private OperadorDAO operadorDAO = new JDBCOperadorDAO(FabricaConexoes.getInstance());
    private RepositorioOperador repositorioOperador = new RepositorioOperador(operadorDAO);
    
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
    }

}