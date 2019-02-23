package net.minecraft.src;


class StructureStrongholdPieceWeight {

   public Class field_35618_a;
   public final int field_35616_b;
   public int field_35617_c;
   public int field_35615_d;


   public StructureStrongholdPieceWeight(Class p_i122_1_, int p_i122_2_, int p_i122_3_) {
      this.field_35618_a = p_i122_1_;
      this.field_35616_b = p_i122_2_;
      this.field_35615_d = p_i122_3_;
   }

   public boolean func_35613_a(int p_35613_1_) {
      return this.field_35615_d == 0 || this.field_35617_c < this.field_35615_d;
   }

   public boolean func_35614_a() {
      return this.field_35615_d == 0 || this.field_35617_c < this.field_35615_d;
   }
}
