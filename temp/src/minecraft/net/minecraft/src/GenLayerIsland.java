package net.minecraft.src;

import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerIsland extends GenLayer {

   public GenLayerIsland(long p_i77_1_) {
      super(p_i77_1_);
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var6 = 0; var6 < p_35500_4_; ++var6) {
         for(int var7 = 0; var7 < p_35500_3_; ++var7) {
            this.func_35499_a((long)(p_35500_1_ + var7), (long)(p_35500_2_ + var6));
            var5[var7 + var6 * p_35500_3_] = this.func_35498_a(10) == 0?1:0;
         }
      }

      if(p_35500_1_ > -p_35500_3_ && p_35500_1_ <= 0 && p_35500_2_ > -p_35500_4_ && p_35500_2_ <= 0) {
         var5[-p_35500_1_ + -p_35500_2_ * p_35500_3_] = 1;
      }

      return var5;
   }
}
