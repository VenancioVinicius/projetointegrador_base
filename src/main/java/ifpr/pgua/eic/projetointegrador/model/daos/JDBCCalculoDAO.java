package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.model.entities.Calculo;

public class JDBCCalculoDAO implements CalculoDAO{
      
      private FabricaConexoes fabrica;

      public JDBCCalculoDAO(FabricaConexoes fabrica){
            this.fabrica = fabrica;
      }

      @Override
      public Resultado listar(){

            try(Connection con = fabrica.getConnection()) {
                  PreparedStatement pstm = con.prepareStatement("SELECT * FROM materials WHERE diferenca != 0");

                  ResultSet rs = pstm.executeQuery();

                  ArrayList<Calculo> lista = new ArrayList<>();

                  while (rs.next()) {
                        String id_material = rs.getString("id_material");
                        String nome_material = rs.getString("nome_material");
                        Integer quantidade = rs.getInt("quantidade");
                        Integer inventario_quant = rs.getInt("inventario_quant");
                        Integer diferenca = rs.getInt("diferenca");

                        Calculo calculo = new Calculo(id_material, nome_material, quantidade, inventario_quant, diferenca);
                        lista.add(calculo);
                  }

                  return Resultado.sucesso("Lista de Calculos", lista);

            } catch (SQLException e) {
                  return Resultado.erro(e.getMessage());
            }

      }

      @Override
      public Resultado limpar(){

            try(Connection con = fabrica.getConnection()) {
                  
                  PreparedStatement pstm = con.prepareStatement("update materials set quantidade = 0, inventario_quant = 0, diferenca = 0");

                  pstm.executeUpdate();

                  App.popScreen();
                  return Resultado.sucesso("Tabela resetado", null);
            } catch (SQLException e) {
                  return Resultado.erro(e.getMessage());
            }

      }

}
