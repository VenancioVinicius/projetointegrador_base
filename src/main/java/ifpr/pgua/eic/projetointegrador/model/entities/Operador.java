package ifpr.pgua.eic.projetointegrador.model.entities;

public class Operador {

      private String id;
      private String nome_operador;
      private String id_material_e_1_1;
      private Integer quant_material_e_1_1;

      public Operador(String nome_operador, String id_material_e_1_1, Integer quant_material_e_1_1){
            this.nome_operador = nome_operador;
            this.id_material_e_1_1 = id_material_e_1_1;
            this.quant_material_e_1_1 = quant_material_e_1_1;
      }

      public Operador(String id, String nome_operador, String id_material_e_1_1, Integer quant_material_e_1_1){
            this.id = id;
            this.nome_operador = nome_operador;
            this.id_material_e_1_1 = id_material_e_1_1;
            this.quant_material_e_1_1 = quant_material_e_1_1;
      }

      public String getId() {
            return id;
      }

      public void setId(String id) {
            this.id = id;
      }

      public String getNome_operador() {
            return nome_operador;
      }

      public void setNome_operador(String nome_operador) {
            this.nome_operador = nome_operador;
      }

      public String getId_material_e_1_1() {
            return id_material_e_1_1;
      }

      public void setId_material_e_1_1(String id_material_e_1_1) {
            this.id_material_e_1_1 = id_material_e_1_1;
      }

      public Integer getQuant_material_e_1_1() {
            return quant_material_e_1_1;
      }

      public void setQuant_material_e_1_1(Integer quant_material_e_1_1) {
            this.quant_material_e_1_1 = quant_material_e_1_1;
      }

      @Override
    public String toString() {
        return nome_operador;
    }
}