package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;
import net.minecraft.src.WorldType;

public class GenLayerBiome extends GenLayer {

   private BiomeGenBase[] field_35509_b;


   public GenLayerBiome(long p_i1011_1_, GenLayer p_i1011_3_, WorldType p_i1011_4_) {
      super(p_i1011_1_);
      this.field_35509_b = new BiomeGenBase[]{BiomeGenBase.field_4249_h, BiomeGenBase.field_4253_d, BiomeGenBase.field_35483_e, BiomeGenBase.field_4255_b, BiomeGenBase.field_35485_c, BiomeGenBase.field_4250_g, BiomeGenBase.field_48416_w};
      this.field_35504_a = p_i1011_3_;
      if(p_i1011_4_ == WorldType.field_48634_d) {
         this.field_35509_b = new BiomeGenBase[]{BiomeGenBase.field_4249_h, BiomeGenBase.field_4253_d, BiomeGenBase.field_35483_e, BiomeGenBase.field_4255_b, BiomeGenBase.field_35485_c, BiomeGenBase.field_4250_g};
      }

   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int[] var5 = this.field_35504_a.func_35500_a(p_35500_1_, p_35500_2_, p_35500_3_, p_35500_4_);
      int[] var6 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(int var7 = 0; var7 < p_35500_4_; ++var7) {
         for(int var8 = 0; var8 < p_35500_3_; ++var8) {
            this.func_35499_a((long)(var8 + p_35500_1_), (long)(var7 + p_35500_2_));
            int var9 = var5[var8 + var7 * p_35500_3_];
            if(var9 == 0) {
               var6[var8 + var7 * p_35500_3_] = 0;
            } else if(var9 == BiomeGenBase.field_40262_p.field_35494_y) {
               var6[var8 + var7 * p_35500_3_] = var9;
            } else if(var9 == 1) {
               var6[var8 + var7 * p_35500_3_] = this.field_35509_b[this.func_35498_a(this.field_35509_b.length)].field_35494_y;
            } else {
               var6[var8 + var7 * p_35500_3_] = BiomeGenBase.field_40257_n.field_35494_y;
            }
         }
      }

      return var6;
   }
}
