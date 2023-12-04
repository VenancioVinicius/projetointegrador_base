package ifpr.pgua.eic.projetointegrador.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.daos.CalculoDAO;

public class RepositorioCalculo {
      
      private CalculoDAO dao;

      public RepositorioCalculo(CalculoDAO dao) {
            this.dao = dao;
      }

      public Resultado Limpar(){
            return dao.limpar();
      }

      public Resultado ListarCalculo(){
            return dao.listar();
      }

}
