package ifpr.pgua.eic.projetointegrador.model.daos;

import com.github.hugoperlin.results.Resultado;

public interface OperadorDAO {
      
      Resultado atualizar(String operador_selecionado);
      Resultado listar();

}
