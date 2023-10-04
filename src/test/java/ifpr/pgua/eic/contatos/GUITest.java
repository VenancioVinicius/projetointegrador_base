package ifpr.pgua.eic.contatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.service.finder.NodeFinder;
import org.testfx.service.finder.impl.NodeFinderImpl;

import ifpr.pgua.eic.contatos.controllers.Principal;
import ifpr.pgua.eic.contatos.model.daos.ContatoDAO;
import ifpr.pgua.eic.contatos.model.daos.FabricaConexoes;
import ifpr.pgua.eic.contatos.model.daos.JDBCContatoDAO;
import ifpr.pgua.eic.contatos.model.entities.Contato;
import ifpr.pgua.eic.contatos.model.repositories.ContatoRepository;
import ifpr.pgua.eic.contatos.model.repositories.ContatoRepositoryImpl;
import ifpr.pgua.eic.contatos.utils.DBUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@ExtendWith(ApplicationExtension.class)
public class GUITest {

    private String arquivoFxml = "principal.fxml";
    private String idTextFieldNome = "#tfNome";
    private String idTextFieldTelefone = "#tfTelefone";
    private String idTextFieldFiltro = "#tfFiltro";
    
    private String idTableView = "#tbContatos";
    
    private String parteMensagemErro = "Erro";

    @BeforeEach
    private void setUp(){
        DBUtils.resetDataBase(FabricaConexoes.getInstance());
    }

    @Start
    public void start(Stage stage) throws IOException {
        DBUtils.resetDataBase(FabricaConexoes.getInstance());
        System.out.println("Aqui...");
        
        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repository = new ContatoRepositoryImpl(dao);
    
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(arquivoFxml));
        loader.setControllerFactory(o -> new Principal(repository));

        Parent p = loader.load();

        stage.setScene(new Scene(p, 600, 600));
        stage.show();
    }

    @Test
    @DisplayName("A tela permite cadastrar um contato")
    public void cadastroTest1(FxRobot robot) {

        robot.clickOn(idTextFieldNome).write("Contato Test");
        robot.clickOn(idTextFieldTelefone).write("12345");
        robot.clickOn(LabeledMatchers.hasText("Adicionar"));

        try {
            Node dialogPane = robot.lookup(".dialog-pane").query();
            Node bt = robot.from(dialogPane).lookup(".button").queryButton();
            
            Node text = robot.from(dialogPane).lookup((Text t) -> t.getText().contains("Contato Inserido")).query();

            assertNotNull(dialogPane, "Não foi mostrado um alert!");
            assertNotNull(text, "Não foi encontrada a mensagem Contato Inserido!");
            
            
            robot.clickOn(bt); 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi mostrado dialog");
        }
    }


    @Test
    @DisplayName("A tela não permite cadastrar um contato sem nome")
    public void cadastroTest2(FxRobot robot) {

        robot.clickOn(idTextFieldTelefone).write("12345");
        robot.clickOn(LabeledMatchers.hasText("Adicionar"));

        try {
            Node dialogPane = robot.lookup(".dialog-pane").query();
            Node bt = robot.from(dialogPane).lookup(".button").queryButton();
            
            Node text = robot.from(dialogPane).lookup((Text t) -> t.getText().contains("Nome inválido!")).query();

            assertNotNull(dialogPane, "Não foi mostrado um alert!");
            assertNotNull(text, "Não foi encontrada a mensagem Nome Inválido!");
            
            
            robot.clickOn(bt); 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi mostrado dialog");
        }
    }

    @Test
    @DisplayName("A tela não permite cadastrar um contato sem telefone")
    public void cadastroTest3(FxRobot robot) {

        robot.clickOn(idTextFieldNome).write("Contato Test");
        robot.clickOn(LabeledMatchers.hasText("Adicionar"));

        try {
            Node dialogPane = robot.lookup(".dialog-pane").query();
            Node bt = robot.from(dialogPane).lookup(".button").queryButton();
            
            Node text = robot.from(dialogPane).lookup((Text t) -> t.getText().contains("Telefone inválido!")).query();

            assertNotNull(dialogPane, "Não foi mostrado um alert!");
            assertNotNull(text, "Não foi encontrada a mensagem Telefone Inválido!");
            
            
            robot.clickOn(bt); 

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi mostrado dialog");
        }
    }

    @Test
    @DisplayName("Ao inserir um contato a tabela é atualizada")
    public void cadastroTest4(FxRobot robot) {
    
        String nome = "Contato Test";
        String telefone = "12345";

        robot.clickOn(idTextFieldNome).write(nome);
        robot.clickOn(idTextFieldTelefone).write(telefone);

        robot.clickOn(LabeledMatchers.hasText("Adicionar"));

        try {
            Node dialogPane = robot.lookup(".dialog-pane").query();
            Node bt = robot.from(dialogPane).lookup(".button").queryButton();
            robot.clickOn(bt); 

            TableView<Contato> tableView = robot.lookup(idTableView).queryTableView();

            assertEquals(1,tableView.getItems().size(),"Deveria haver 01 item na tabela!");
            assertEquals(nome,tableView.getItems().get(0).getNome());


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Não foi mostrado dialog");
        }
    }

}