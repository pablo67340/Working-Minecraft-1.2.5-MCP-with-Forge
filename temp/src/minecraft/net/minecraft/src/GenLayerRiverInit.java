package net.minecraft.src;

import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerRiverInit extends GenLayer {

   public GenLayerRiverInit(long p_i401_1_, GenLayer p_i401_3_) {
      super(p_i401_1_);
      this.field_35504_a = p_i401_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = this.field_35504_a.func_35500_a(p_35500_1_, p_35500_2_, p_35500_3_, p_35500_4_);
      int[] var6 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var7 = 0; var7 < p_35500_4_; ++var7) {
         for(int var8 = 0; var8 < p_35500_3_; ++var8) {
            this.func_35499_a((long)(var8 + p_35500_1_), (long)(var7 + p_35500_2_));
            var6[var8 + var7 * p_35500_3_] = var5[var8 + var7 * p_35500_3_] > 0?this.func_35498_a(2) + 2:0;
         }
      }

      return var6;
   }
}
