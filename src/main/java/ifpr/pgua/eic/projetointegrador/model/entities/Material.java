package ifpr.pgua.eic.projetointegrador.model.entities;

public class Material {
      
      private String id_material;
      private String nome_material;
      private Integer quantidade;
      private Integer inventario_quant;

      public Material(String id_material, String nome_material, Integer quantidade, Integer inventario_quant){
            this.id_material = id_material;
            this.nome_material = nome_material;
            this.quantidade = quantidade;
            this.inventario_quant = inventario_quant;
      }

      public String getId_material() {
            return id_material;
      }

      public void setId_material(String id_material) {
            this.id_material = id_material;
      }

      public String getNome_material() {
            return nome_material;
      }

      public void setNome_material(String nome_material) {
            this.nome_material = nome_material;
      }

      public Integer getQuantidade() {
            return quantidade;
      }

      public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
      }

      public Integer getInventario_quant() {
            return inventario_quant;
      }

      public void setInventario_quant(Integer inventario_quant) {
            this.inventario_quant = inventario_quant;
      }

      @Override
      public String toString(){
            return nome_material;
      }

}
