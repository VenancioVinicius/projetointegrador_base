package ifpr.pgua.eic.projetointegrador.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.daos.OperadorDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Operador;

public class RepositorioOperador {
      
      private OperadorDAO dao;

      public RepositorioOperador(OperadorDAO dao){
            this.dao = dao;
      }

      public Resultado SelecionarOperador(){
            return dao.listar();
      }

}