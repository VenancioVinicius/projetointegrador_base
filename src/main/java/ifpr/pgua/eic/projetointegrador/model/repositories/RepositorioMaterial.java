package ifpr.pgua.eic.projetointegrador.model.repositories;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.daos.MaterialDAO;

public class RepositorioMaterial {
      
      private MaterialDAO dao;

      public RepositorioMaterial(MaterialDAO dao){
            this.dao = dao;
      }

      public Resultado CadastrarMaterial(String material_selecionado, Integer inventario_quant){
            if(material_selecionado.isEmpty() || material_selecionado.isEmpty()){
                  return Resultado.erro("Nenhum valor inserido");
            }

            return dao.atualizar(material_selecionado, inventario_quant);
      }

      public Resultado ListarMaterial(){
            return dao.listar();
      }

}
