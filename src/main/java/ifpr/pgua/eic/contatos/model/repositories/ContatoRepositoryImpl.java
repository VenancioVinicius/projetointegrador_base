package ifpr.pgua.eic.contatos.model.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.contatos.model.daos.ContatoDAO;
import ifpr.pgua.eic.contatos.model.entities.Contato;

public class ContatoRepositoryImpl implements ContatoRepository{



    @Override
    public Resultado<Contato> cadastrar(String nome, String telefone) {
        return Resultado.erro("Implementar!");
    }

    @Override
    public Resultado<ArrayList<Contato>> listar() {
        return Resultado.erro("Implementar!");
    }

    @Override
    public Resultado<ArrayList<Contato>> filtrarNome(String inicio) {
        return Resultado.erro("Implementar!");
    }
    



}
