package net.minecraft.src;

import net.minecraft.src.StructureStrongholdPieceWeight;

final class StructureStrongholdPieceWeight2 extends StructureStrongholdPieceWeight {

   StructureStrongholdPieceWeight2(Class p_i231_1_, int p_i231_2_, int p_i231_3_) {
      super(p_i231_1_, p_i231_2_, p_i231_3_);
   }

   public boolean func_35613_a(int p_35613_1_) {
      return super.func_35613_a(p_35613_1_) && p_35613_1_ > 4;
   }
}
