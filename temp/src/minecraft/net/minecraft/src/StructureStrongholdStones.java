package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.StructurePieceBlockSelector;
import net.minecraft.src.StructureStrongholdPieceWeight2;

class StructureStrongholdStones extends StructurePieceBlockSelector {

   private StructureStrongholdStones() {}

   public void func_35706_a(Random p_35706_1_, int p_35706_2_, int p_35706_3_, int p_35706_4_, boolean p_35706_5_) {
      if(!p_35706_5_) {
         this.field_35710_a = 0;
         this.field_35709_b = 0;
      } else {
         this.field_35710_a = Block.field_35285_bn.field_376_bc;
         float var6 = p_35706_1_.nextFloat();
         if(var6 < 0.2F) {
            this.field_35709_b = 2;
         } else if(var6 < 0.5F) {
            this.field_35709_b = 1;
         } else if(var6 < 0.55F) {
            this.field_35710_a = Block.field_35289_bm.field_376_bc;
            this.field_35709_b = 2;
         } else {
            this.field_35709_b = 0;
         }
      }

   }

   // $FF: synthetic method
   StructureStrongholdStones(StructureStrongholdPieceWeight2 p_i161_1_) {
      this();
   }
}
