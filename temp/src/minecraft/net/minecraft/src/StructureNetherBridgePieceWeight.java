package net.minecraft.src;


class StructureNetherBridgePieceWeight {

   public Class field_40699_a;
   public final int field_40697_b;
   public int field_40698_c;
   public int field_40695_d;
   public boolean field_40696_e;


   public StructureNetherBridgePieceWeight(Class p_i124_1_, int p_i124_2_, int p_i124_3_, boolean p_i124_4_) {
      this.field_40699_a = p_i124_1_;
      this.field_40697_b = p_i124_2_;
      this.field_40695_d = p_i124_3_;
      this.field_40696_e = p_i124_4_;
   }

   public StructureNetherBridgePieceWeight(Class p_i125_1_, int p_i125_2_, int p_i125_3_) {
      this(p_i125_1_, p_i125_2_, p_i125_3_, false);
   }

   public boolean func_40693_a(int p_40693_1_) {
      return this.field_40695_d == 0 || this.field_40698_c < this.field_40695_d;
   }

   public boolean func_40694_a() {
      return this.field_40695_d == 0 || this.field_40698_c < this.field_40695_d;
   }
}
