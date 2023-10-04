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
import ifpr.pgua.eic.contatos.utils.DBUtils;

public class DAOTeste {
    

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
        
        Contato contato = new Contato(nome,telefone);

        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());

        Resultado<Contato> resultado = dao.criar(contato);

        System.out.println(resultado.getMsg());

        Contato retorno = resultado.comoSucesso().getObj();

        assertTrue(resultado.foiSucesso());
        assertEquals(retorno.getNome(),nome);
        assertEquals(retorno.getId(),1);

    }


    @Test
    @DisplayName("Consegue listar contatos")
    public void teste02(){
        
        List<Contato> lista = gerarListaContatos(5);
        ContatoDAO dao = new JDBCContatoDAO(FabricaConexoes.getInstance());

        for(Contato c:lista){
            dao.criar(c);
        }

        ContatoDAO dao2 = new JDBCContatoDAO(FabricaConexoes.getInstance());

        Resultado<ArrayList<Contato>> resultado = dao2.listar();

        assertTrue(resultado.foiSucesso(),"O resultado deveria ser sucesso!");
        
        ArrayList<Contato> listaResultado = resultado.comoSucesso().getObj();
        assertEquals(lista.size(),listaResultado.size(),"O tamanho das listas deveriam ser iguais!");
        assertTrue(lista.containsAll(listaResultado),"O conteúdo das listas deveria ser iguais");
    }
    

}
