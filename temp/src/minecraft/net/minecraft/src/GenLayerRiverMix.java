package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerRiverMix extends GenLayer {

   private GenLayer field_35512_b;
   private GenLayer field_35513_c;


   public GenLayerRiverMix(long p_i181_1_, GenLayer p_i181_3_, GenLayer p_i181_4_) {
      super(p_i181_1_);
      this.field_35512_b = p_i181_3_;
      this.field_35513_c = p_i181_4_;
   }

   public void func_35496_b(long p_35496_1_) {
      this.field_35512_b.func_35496_b(p_35496_1_);
      this.field_35513_c.func_35496_b(p_35496_1_);
      super.func_35496_b(p_35496_1_);
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = this.field_35512_b.func_35500_a(p_35500_1_, p_35500_2_, p_35500_3_, p_35500_4_);
      int[] var6 = this.field_35513_c.func_35500_a(p_35500_1_, p_35500_2_, p_35500_3_, p_35500_4_);
      int[] var7 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var8 = 0; var8 < p_35500_3_ * p_35500_4_; ++var8) {
         if(var5[var8] == BiomeGenBase.field_35484_b.field_35494_y) {
            var7[var8] = var5[var8];
         } else if(var6[var8] >= 0) {
            if(var5[var8] == BiomeGenBase.field_40257_n.field_35494_y) {
               var7[var8] = BiomeGenBase.field_40260_m.field_35494_y;
            } else if(var5[var8] != BiomeGenBase.field_40262_p.field_35494_y && var5[var8] != BiomeGenBase.field_40261_q.field_35494_y) {
               var7[var8] = var6[var8];
            } else {
               var7[var8] = BiomeGenBase.field_40261_q.field_35494_y;
            }
         } else {
            var7[var8] = var5[var8];
         }
      }

      return var7;
   }
}
