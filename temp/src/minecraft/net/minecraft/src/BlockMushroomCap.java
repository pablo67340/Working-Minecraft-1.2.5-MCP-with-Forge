package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockMushroomCap extends Block {

   private int field_35292_a;


   public BlockMushroomCap(int p_i529_1_, Material p_i529_2_, int p_i529_3_, int p_i529_4_) {
      super(p_i529_1_, p_i529_3_, p_i529_2_);
      this.field_35292_a = p_i529_4_;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_2_ == 10 && p_232_1_ > 1?this.field_378_bb - 1:(p_232_2_ >= 1 && p_232_2_ <= 9 && p_232_1_ == 1?this.field_378_bb - 16 - this.field_35292_a:(p_232_2_ >= 1 && p_232_2_ <= 3 && p_232_1_ == 2?this.field_378_bb - 16 - this.field_35292_a:(p_232_2_ >= 7 && p_232_2_ <= 9 && p_232_1_ == 3?this.field_378_bb - 16 - this.field_35292_a:((p_232_2_ == 1 || p_232_2_ == 4 || p_232_2_ == 7) && p_232_1_ == 4?this.field_378_bb - 16 - this.field_35292_a:((p_232_2_ == 3 || p_232_2_ == 6 || p_232_2_ == 9) && p_232_1_ == 5?this.field_378_bb - 16 - this.field_35292_a:(p_232_2_ == 14?this.field_378_bb - 16 - this.field_35292_a:(p_232_2_ == 15?this.field_378_bb - 1:this.field_378_bb)))))));
   }

   public int func_229_a(Random p_229_1_) {
      int var2 = p_229_1_.nextInt(10) - 7;
      if(var2 < 0) {
         var2 = 0;
      }

      return var2;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_415_ag.field_376_bc + this.field_35292_a;
   }
}
