package net.minecraft.src;

import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerFuzzyZoom extends GenLayer {

   public GenLayerFuzzyZoom(long p_i184_1_, GenLayer p_i184_3_) {
      super(p_i184_1_);
      super.field_35504_a = p_i184_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int var5 = p_35500_1_ >> 1;
      int var6 = p_35500_2_ >> 1;
      int var7 = (p_35500_3_ >> 1) + 3;
      int var8 = (p_35500_4_ >> 1) + 3;
      int[] var9 = this.field_35504_a.func_35500_a(var5, var6, var7, var8);
      int[] var10 = IntCache.func_35267_a(var7 * 2 * var8 * 2);
      int var11 = var7 << 1;

      int var13;
      for(int var12 = 0; var12 < var8 - 1; ++var12) {
         var13 = var12 << 1;
         int var14 = var13 * var11;
         int var15 = var9[0 + (var12 + 0) * var7];
         int var16 = var9[0 + (var12 + 1) * var7];

         for(int var17 = 0; var17 < var7 - 1; ++var17) {
            this.func_35499_a((long)(var17 + var5 << 1), (long)(var12 + var6 << 1));
            int var18 = var9[var17 + 1 + (var12 + 0) * var7];
            int var19 = var9[var17 + 1 + (var12 + 1) * var7];
            var10[var14] = var15;
            var10[var14++ + var11] = this.func_35511_a(var15, var16);
            var10[var14] = this.func_35511_a(var15, var18);
            var10[var14++ + var11] = this.func_35510_b(var15, var18, var16, var19);
            var15 = var18;
            var16 = var19;
         }
      }

      int[] var20 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(var13 = 0; var13 < p_35500_4_; ++var13) {
         System.arraycopy(var10, (var13 + (p_35500_2_ & 1)) * (var7 << 1) + (p_35500_1_ & 1), var20, var13 * p_35500_3_, p_35500_3_);
      }

      return var20;
   }

   protected int func_35511_a(int p_35511_1_, int p_35511_2_) {
      return this.func_35498_a(2) == 0?p_35511_1_:p_35511_2_;
   }

   protected int func_35510_b(int p_35510_1_, int p_35510_2_, int p_35510_3_, int p_35510_4_) {
      int var5 = this.func_35498_a(4);
      return var5 == 0?p_35510_1_:(var5 == 1?p_35510_2_:(var5 == 2?p_35510_3_:p_35510_4_));
   }
}
