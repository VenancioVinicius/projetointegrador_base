package ifpr.pgua.eic.contatos;

import ifpr.pgua.eic.contatos.controllers.Principal;
import ifpr.pgua.eic.contatos.model.daos.FabricaConexoes;
import ifpr.pgua.eic.contatos.model.repositories.ContatoRepositoryImpl;
import ifpr.pgua.eic.contatos.utils.DBUtils;
import io.github.hugoperlin.navigatorfx.BaseAppNavigator;
import io.github.hugoperlin.navigatorfx.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    
    


    @Override
    public void init() throws Exception {
        // TODO Auto-generated method stub
        super.init();

        if(!DBUtils.checkDataBase(FabricaConexoes.getInstance())){
            DBUtils.createDataBase(FabricaConexoes.getInstance());
        }

    }


    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }


    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "Lista de Contatos";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new Principal()));
    }

}