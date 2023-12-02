package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.entities.Operador;
import ifpr.pgua.eic.projetointegrador.utils.DBUtils;

public class JDBCOperadorDAO implements OperadorDAO{
      
      private FabricaConexoes fabrica;

      public JDBCOperadorDAO(FabricaConexoes fabrica){
            this.fabrica = fabrica;
      }

      @Override 
      public Resultado listar() {

            try (Connection con = fabrica.getConnection()) {
                  
                  PreparedStatement pstm = con.prepareStatement("SELECT * FROM operators");

                  ResultSet rs = pstm.executeQuery();

                  ArrayList<Operador> lista = new ArrayList<>();

                  while(rs.next()){
                        String id = rs.getString("id");
                        String nome_operador = rs.getString("nome_operador");
                        String id_material_e_1_1 = rs.getString("id_material_e_1_1");
                        String quant_material_e_1_1 = rs.getString("quant_material_e_1_1");

                        Operador personagem = new Operador(id, nome_operador, id_material_e_1_1, quant_material_e_1_1);
                        lista.add(personagem);
                  }

                  return Resultado.sucesso("Lista de Operadores", lista);

            } catch (SQLException e) {
                  return Resultado.erro(e.getMessage());
            }

      }

}
