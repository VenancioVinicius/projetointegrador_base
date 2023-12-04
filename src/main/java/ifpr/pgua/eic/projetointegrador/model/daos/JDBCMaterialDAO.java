package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.github.hugoperlin.results.Resultado;

import ifpr.pgua.eic.projetointegrador.model.entities.Material;

public class JDBCMaterialDAO implements MaterialDAO {
      
      private FabricaConexoes fabrica;

      public JDBCMaterialDAO(FabricaConexoes fabrica){
            this.fabrica = fabrica;
      }

      @Override
      public Resultado listar(){

            try(Connection con = fabrica.getConnection()) {
                  PreparedStatement pstm = con.prepareStatement("SELECT * FROM materials");

                  ResultSet rs = pstm.executeQuery();

                  ArrayList<Material> lista = new ArrayList<>();

                  while (rs.next()) {
                        String id_material = rs.getString("id_material");
                        String nome_material = rs.getString("nome_material");
                        Integer quantidade = rs.getInt("quantidade");
                        Integer inventario_quant = rs.getInt("inventario_quant");

                        Material materiais = new Material(id_material, nome_material, quantidade, inventario_quant);
                        lista.add(materiais);
                  }

                  return Resultado.sucesso("Lista de Materiais", lista);

            } catch (SQLException e) {
                  return Resultado.erro(e.getMessage());
            }

      }

      public Resultado atualizar(String material_selecionado, Integer inv_quant){

            try(Connection con = fabrica.getConnection()) {
                  PreparedStatement pstm = con.prepareStatement("update materials set inventario_quant = ? where nome_material = ?");

                  pstm.setInt(1, inv_quant);
                  pstm.setString(2, material_selecionado);

                  pstm.executeUpdate();

                  PreparedStatement ps = con.prepareStatement("SELECT quantidade, inventario_quant FROM materials WHERE nome_material = ?");

                  ps.setString(1, material_selecionado);

                  PreparedStatement pst = con.prepareStatement("update materials set diferenca = ? where nome_material = ?");
                  
                  ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                        Integer quantidade = rs.getInt("quantidade");
                        Integer inventario_quant = rs.getInt("inventario_quant");
                        
                        Integer resultado = inventario_quant - quantidade;
                        pst.setInt(1, resultado);
                        pst.setString(2, material_selecionado);

                        pst.executeUpdate();

                  }

                  return Resultado.sucesso(material_selecionado, null);
            } catch (SQLException e) {
                  return Resultado.erro(e.getMessage());
            }

      }

}
