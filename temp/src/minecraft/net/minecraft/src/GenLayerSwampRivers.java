package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerSwampRivers extends GenLayer {

   public GenLayerSwampRivers(long p_i162_1_, GenLayer p_i162_3_) {
      super(p_i162_1_);
      this.field_35504_a = p_i162_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = this.field_35504_a.func_35500_a(p_35500_1_ - 1, p_35500_2_ - 1, p_35500_3_ + 2, p_35500_4_ + 2);
      int[] var6 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var7 = 0; var7 < p_35500_4_; ++var7) {
         for(int var8 = 0; var8 < p_35500_3_; ++var8) {
            this.func_35499_a((long)(var8 + p_35500_1_), (long)(var7 + p_35500_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
            if(var9 == BiomeGenBase.field_4255_b.field_35494_y && this.func_35498_a(6) == 0) {
               var6[var8 + var7 * p_35500_3_] = BiomeGenBase.field_35487_i.field_35494_y;
            } else if((var9 == BiomeGenBase.field_48416_w.field_35494_y || var9 == BiomeGenBase.field_48417_x.field_35494_y) && this.func_35498_a(8) == 0) {
               var6[var8 + var7 * p_35500_3_] = BiomeGenBase.field_35487_i.field_35494_y;
            } else {
               var6[var8 + var7 * p_35500_3_] = var9;
            }
         }
      }

      return var6;
   }
}
