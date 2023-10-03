package ifpr.pgua.eic.contatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.contatos.model.daos.ContatoDAO;
import ifpr.pgua.eic.contatos.model.daos.FabricaConexoes;
import ifpr.pgua.eic.contatos.model.daos.JDBCContatoDAO;
import ifpr.pgua.eic.contatos.model.entities.Contato;
import ifpr.pgua.eic.contatos.model.repositories.ContatoRepository;
import ifpr.pgua.eic.contatos.model.repositories.ContatoRepositoryImpl;
import ifpr.pgua.eic.contatos.utils.DBUtils;

public class RepositoryTeste {
    

    @BeforeEach
    private void setUp(){
        DBUtils.resetDataBase(FabricaConexoes.getInstance());
    }


    private List<Contato> gerarListaContatos(int qtde){

        List<Contato> lista = new ArrayList<>();

        for(int i=0;i<qtde;i++){
            Contato c = new Contato("Teste "+(i+1), ""+(i+1));
            lista.add(c);
        }

        return lista;

    }


    @Test
    @DisplayName("Consegue inserir um contato")
    public void teste01(){
        String nome = "Contato Teste";
        String telefone = "123456";
        
        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repository = new ContatoRepositoryImpl(dao);

        Resultado<Contato> resultado = repository.cadastrar(nome, telefone);

        System.out.println(resultado.getMsg());

        Contato retorno = resultado.comoSucesso().getObj();

        assertTrue(resultado.foiSucesso());
        assertEquals(retorno.getNome(),nome);
        assertEquals(retorno.getId(),1);

    }

    @Test
    @DisplayName("Não consegue inserir um contato sem nome")
    public void teste02(){
        String nome = "";
        String telefone = "123456";
        
        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repository = new ContatoRepositoryImpl(dao);

        Resultado<Contato> resultado = repository.cadastrar(nome, telefone);

        
        assertTrue(resultado.foiErro());
        assertEquals("Nome inválido!",resultado.getMsg(),"A mensagem de erro deveria ser Nome Inválido!");
        

    }

    @Test
    @DisplayName("Não consegue inserir um contato sem telefone")
    public void teste03(){
        String nome = "Contato Teste";
        String telefone = "";
        
        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repository = new ContatoRepositoryImpl(dao);

        Resultado<Contato> resultado = repository.cadastrar(nome, telefone);

        
        assertTrue(resultado.foiErro());
        assertEquals("Telefone inválido!",resultado.getMsg(),"A mensagem de erro deveria ser Telefone Inválido!");
        

    }


    @Test
    @DisplayName("Consegue listar contatos")
    public void teste4(){
        
        List<Contato> lista = gerarListaContatos(5);
        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());

        for(Contato c:lista){
            dao.criar(c);
        }

        ContatoDAO dao2 = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repository = new ContatoRepositoryImpl(dao2);

        Resultado<ArrayList<Contato>> resultado = repository.listar();

        assertTrue(resultado.foiSucesso(),"O resultado deveria ser sucesso!");
        
        ArrayList<Contato> listaResultado = resultado.comoSucesso().getObj();
        assertEquals(lista.size(),listaResultado.size(),"O tamanho das listas deveriam ser iguais!");
        assertTrue(lista.containsAll(listaResultado),"O conteúdo das listas deveria ser iguais");
    }

    @Test
    @DisplayName("Consegue listar contatos iniciando por um nome")
    public void teste5(){
        
        List<Contato> lista = gerarListaContatos(5);
        
        List<Contato> filtro = new ArrayList<>();
        filtro.add(new Contato("Maria Teste 1", "4567"));
        filtro.add(new Contato("Maria Teste 2", "45678"));
        lista.addAll(filtro);

        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());

        for(Contato c:lista){
            dao.criar(c);
        }

        ContatoDAO dao2 = new JDBCContatoDAO(FabricaConexoes.getInstance());
        ContatoRepository repository = new ContatoRepositoryImpl(dao2);

        Resultado<ArrayList<Contato>> resultado = repository.filtrarNome("Maria");
        System.out.println(resultado.getMsg());
        assertTrue(resultado.foiSucesso(),"O resultado deveria ser sucesso!");
        
        ArrayList<Contato> listaResultado = resultado.comoSucesso().getObj();
        assertEquals(filtro.size(),listaResultado.size(),"O tamanho das listas deveriam ser iguais!");
        assertTrue(filtro.containsAll(listaResultado),"O conteúdo das listas deveria ser iguais");
    }

    

}
