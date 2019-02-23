package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerAddSnow extends GenLayer {

   public GenLayerAddSnow(long p_i614_1_, GenLayer p_i614_3_) {
      super(p_i614_1_);
      this.field_35504_a = p_i614_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int var5 = p_35500_1_ - 1;
      int var6 = p_35500_2_ - 1;
      int var7 = p_35500_3_ + 2;
      int var8 = p_35500_4_ + 2;
      int[] var9 = this.field_35504_a.func_35500_a(var5, var6, var7, var8);
      int[] var10 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var11 = 0; var11 < p_35500_4_; ++var11) {
         for(int var12 = 0; var12 < p_35500_3_; ++var12) {
            int var13 = var9[var12 + 1 + (var11 + 1) * var7];
            this.func_35499_a((long)(var12 + p_35500_1_), (long)(var11 + p_35500_2_));
            if(var13 == 0) {
               var10[var12 + var11 * p_35500_3_] = 0;
            } else {
               int var14 = this.func_35498_a(5);
               if(var14 == 0) {
                  var14 = BiomeGenBase.field_40257_n.field_35494_y;
               } else {
                  var14 = 1;
               }

               var10[var12 + var11 * p_35500_3_] = var14;
            }
         }
      }

      return var10;
   }
}
