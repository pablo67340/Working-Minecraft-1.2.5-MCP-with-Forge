package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerAddMushroomIsland extends GenLayer {

   public GenLayerAddMushroomIsland(long p_i355_1_, GenLayer p_i355_3_) {
      super(p_i355_1_);
      this.field_35504_a = p_i355_3_;
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
            int var13 = var9[var12 + 0 + (var11 + 0) * var7];
            int var14 = var9[var12 + 2 + (var11 + 0) * var7];
            int var15 = var9[var12 + 0 + (var11 + 2) * var7];
            int var16 = var9[var12 + 2 + (var11 + 2) * var7];
            int var17 = var9[var12 + 1 + (var11 + 1) * var7];
            this.func_35499_a((long)(var12 + p_35500_1_), (long)(var11 + p_35500_2_));
            if(var17 == 0 && var13 == 0 && var14 == 0 && var15 == 0 && var16 == 0 && this.func_35498_a(100) == 0) {
               var10[var12 + var11 * p_35500_3_] = BiomeGenBase.field_40262_p.field_35494_y;
            } else {
               var10[var12 + var11 * p_35500_3_] = var17;
            }
         }
      }

      return var10;
   }
}
