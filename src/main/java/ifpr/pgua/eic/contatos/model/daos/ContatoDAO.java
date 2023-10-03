package ifpr.pgua.eic.contatos.model.daos;

import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.contatos.model.entities.Contato;

public interface ContatoDAO {
    Resultado<Contato> criar(Contato contato);
    Resultado<ArrayList<Contato>> listar();
    Resultado<ArrayList<Contato>> filtrarNome(String inicio);
}
