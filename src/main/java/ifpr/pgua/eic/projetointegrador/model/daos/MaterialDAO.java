package ifpr.pgua.eic.projetointegrador.model.daos;

import com.github.hugoperlin.results.Resultado;

public interface MaterialDAO {
      
      Resultado atualizar(String material_selecionado, Integer inventario_quant);
      Resultado listar();

}
