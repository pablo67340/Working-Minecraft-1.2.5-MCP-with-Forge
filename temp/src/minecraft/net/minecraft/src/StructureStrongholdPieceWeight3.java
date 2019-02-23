package net.minecraft.src;

import net.minecraft.src.StructureStrongholdPieceWeight;

final class StructureStrongholdPieceWeight3 extends StructureStrongholdPieceWeight {

   StructureStrongholdPieceWeight3(Class p_i230_1_, int p_i230_2_, int p_i230_3_) {
      super(p_i230_1_, p_i230_2_, p_i230_3_);
   }

   public boolean func_35613_a(int p_35613_1_) {
      return super.func_35613_a(p_35613_1_) && p_35613_1_ > 5;
   }
}
