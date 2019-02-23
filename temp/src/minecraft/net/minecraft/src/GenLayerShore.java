package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerShore extends GenLayer {

   public GenLayerShore(long p_i735_1_, GenLayer p_i735_3_) {
      super(p_i735_1_);
      this.field_35504_a = p_i735_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = this.field_35504_a.func_35500_a(p_35500_1_ - 1, p_35500_2_ - 1, p_35500_3_ + 2, p_35500_4_ + 2);
      int[] var6 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var7 = 0; var7 < p_35500_4_; ++var7) {
         for(int var8 = 0; var8 < p_35500_3_; ++var8) {
            this.func_35499_a((long)(var8 + p_35500_1_), (long)(var7 + p_35500_2_));
            int var9 = var5[var8 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
            int var10;
            int var11;
            int var12;
            int var13;
            if(var9 == BiomeGenBase.field_40262_p.field_35494_y) {
               var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_35500_3_ + 2)];
               var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
               var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_35500_3_ + 2)];
               var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_35500_3_ + 2)];
               if(var10 != BiomeGenBase.field_35484_b.field_35494_y && var11 != BiomeGenBase.field_35484_b.field_35494_y && var12 != BiomeGenBase.field_35484_b.field_35494_y && var13 != BiomeGenBase.field_35484_b.field_35494_y) {
                  var6[var8 + var7 * p_35500_3_] = var9;
               } else {
                  var6[var8 + var7 * p_35500_3_] = BiomeGenBase.field_40261_q.field_35494_y;
               }
            } else if(var9 != BiomeGenBase.field_35484_b.field_35494_y && var9 != BiomeGenBase.field_35487_i.field_35494_y && var9 != BiomeGenBase.field_4255_b.field_35494_y && var9 != BiomeGenBase.field_35483_e.field_35494_y) {
               var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_35500_3_ + 2)];
               var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
               var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_35500_3_ + 2)];
               var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_35500_3_ + 2)];
               if(var10 != BiomeGenBase.field_35484_b.field_35494_y && var11 != BiomeGenBase.field_35484_b.field_35494_y && var12 != BiomeGenBase.field_35484_b.field_35494_y && var13 != BiomeGenBase.field_35484_b.field_35494_y) {
                  var6[var8 + var7 * p_35500_3_] = var9;
               } else {
                  var6[var8 + var7 * p_35500_3_] = BiomeGenBase.field_46050_r.field_35494_y;
               }
            } else if(var9 == BiomeGenBase.field_35483_e.field_35494_y) {
               var10 = var5[var8 + 1 + (var7 + 1 - 1) * (p_35500_3_ + 2)];
               var11 = var5[var8 + 1 + 1 + (var7 + 1) * (p_35500_3_ + 2)];
               var12 = var5[var8 + 1 - 1 + (var7 + 1) * (p_35500_3_ + 2)];
               var13 = var5[var8 + 1 + (var7 + 1 + 1) * (p_35500_3_ + 2)];
               if(var10 == BiomeGenBase.field_35483_e.field_35494_y && var11 == BiomeGenBase.field_35483_e.field_35494_y && var12 == BiomeGenBase.field_35483_e.field_35494_y && var13 == BiomeGenBase.field_35483_e.field_35494_y) {
                  var6[var8 + var7 * p_35500_3_] = var9;
               } else {
                  var6[var8 + var7 * p_35500_3_] = BiomeGenBase.field_46046_v.field_35494_y;
               }
            } else {
               var6[var8 + var7 * p_35500_3_] = var9;
            }
         }
      }

      return var6;
   }
}
