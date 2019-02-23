package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerHills extends GenLayer {

   public GenLayerHills(long p_i229_1_, GenLayer p_i229_3_) {
      super(p_i229_1_);
      this.field_35504_a = p_i229_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = this.field_35504_a.func_35500_a(p_35500_1_ - 1, p_35500_2_ - 1, p_35500_3_ + 2, p_35500_4_ + 2);
      int[] var6 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var7 = 0; var7 < p_35500_4_; ++var7) {
         for(int var8 = 0; var8 < p_35500_3_; ++var8) {
            this.func_35499_a((long)(var8 + p_35500_1_), (long)(var7 + p_35500_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
            if(this.func_35498_a(3) == 0) {
               int var10 = var9;
               if(var9 == BiomeGenBase.field_4249_h.field_35494_y) {
                  var10 = BiomeGenBase.field_46049_s.field_35494_y;
               } else if(var9 == BiomeGenBase.field_4253_d.field_35494_y) {
                  var10 = BiomeGenBase.field_46048_t.field_35494_y;
               } else if(var9 == BiomeGenBase.field_4250_g.field_35494_y) {
                  var10 = BiomeGenBase.field_46047_u.field_35494_y;
               } else if(var9 == BiomeGenBase.field_35485_c.field_35494_y) {
                  var10 = BiomeGenBase.field_4253_d.field_35494_y;
               } else if(var9 == BiomeGenBase.field_40257_n.field_35494_y) {
                  var10 = BiomeGenBase.field_40258_o.field_35494_y;
               } else if(var9 == BiomeGenBase.field_48416_w.field_35494_y) {
                  var10 = BiomeGenBase.field_48417_x.field_35494_y;
               }

               if(var10 != var9) {
                  int var11 = var5[var8 + 1 + (var7 + 1 - 1) * (p_35500_3_ + 2)];
                  int var12 = var5[var8 + 1 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
                  int var13 = var5[var8 + 1 - 1 + (var7 + 1) * (p_35500_3_ + 2)];
                  int var14 = var5[var8 + 1 + (var7 + 1 + 1) * (p_35500_3_ + 2)];
                  if(var11 == var9 && var12 == var9 && var13 == var9 && var14 == var9) {
                     var6[var8 + var7 * p_35500_3_] = var10;
                  } else {
                     var6[var8 + var7 * p_35500_3_] = var9;
                  }
               } else {
                  var6[var8 + var7 * p_35500_3_] = var9;
               }
            } else {
               var6[var8 + var7 * p_35500_3_] = var9;
            }
         }
      }

      return var6;
   }
}
