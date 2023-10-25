package ifpr.pgua.eic.projetointegrador;

import ifpr.pgua.eic.projetointegrador.controllers.Principal;
import ifpr.pgua.eic.projetointegrador.utils.DBUtils;
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

    }


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
    }

}