package ifpr.pgua.eic.contatos.model.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.contatos.model.entities.Contato;

public interface ContatoRepository {
    
    Resultado<Contato> cadastrar(String nome, String telefone);
    Resultado<ArrayList<Contato>> listar();

}
