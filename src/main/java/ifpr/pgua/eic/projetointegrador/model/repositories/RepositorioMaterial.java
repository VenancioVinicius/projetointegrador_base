package ifpr.pgua.eic.projetointegrador.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.daos.MaterialDAO;

public class RepositorioMaterial {
      
      private MaterialDAO dao;

      public RepositorioMaterial(MaterialDAO dao){
            this.dao = dao;
      }

      public Resultado CadastrarMaterial(){
            return dao.listar();
      }

}
