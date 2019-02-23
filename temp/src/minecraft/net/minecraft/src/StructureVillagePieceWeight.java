package net.minecraft.src;


public class StructureVillagePieceWeight {

   public Class field_35607_a;
   public final int field_35605_b;
   public int field_35606_c;
   public int field_35604_d;


   public StructureVillagePieceWeight(Class p_i289_1_, int p_i289_2_, int p_i289_3_) {
      this.field_35607_a = p_i289_1_;
      this.field_35605_b = p_i289_2_;
      this.field_35604_d = p_i289_3_;
   }

   public boolean func_35602_a(int p_35602_1_) {
      return this.field_35604_d == 0 || this.field_35606_c < this.field_35604_d;
   }

   public boolean func_35603_a() {
      return this.field_35604_d == 0 || this.field_35606_c < this.field_35604_d;
   }
}
