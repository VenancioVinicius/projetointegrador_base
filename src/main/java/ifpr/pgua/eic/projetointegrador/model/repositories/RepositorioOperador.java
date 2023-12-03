package ifpr.pgua.eic.projetointegrador.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.daos.OperadorDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Operador;

public class RepositorioOperador {
      
      private OperadorDAO dao;

      public RepositorioOperador(OperadorDAO dao){
            this.dao = dao;
      }

      public Resultado CadastrarOperador(String operador_selecionado){
            if(operador_selecionado.isEmpty() || operador_selecionado.isEmpty()){
                  return Resultado.erro("Nenhum selecionado");
            }

            return dao.atualizar(operador_selecionado);
      }

      public Resultado SelecionarOperador(){
            return dao.listar();
      }

}