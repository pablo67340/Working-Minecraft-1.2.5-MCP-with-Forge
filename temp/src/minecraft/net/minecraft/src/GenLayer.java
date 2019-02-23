package net.minecraft.src;

import net.minecraft.src.GenLayerAddIsland;
import net.minecraft.src.GenLayerAddMushroomIsland;
import net.minecraft.src.GenLayerAddSnow;
import net.minecraft.src.GenLayerBiome;
import net.minecraft.src.GenLayerFuzzyZoom;
import net.minecraft.src.GenLayerHills;
import net.minecraft.src.GenLayerIsland;
import net.minecraft.src.GenLayerRiver;
import net.minecraft.src.GenLayerRiverInit;
import net.minecraft.src.GenLayerRiverMix;
import net.minecraft.src.GenLayerShore;
import net.minecraft.src.GenLayerSmooth;
import net.minecraft.src.GenLayerSwampRivers;
import net.minecraft.src.GenLayerVoronoiZoom;
import net.minecraft.src.GenLayerZoom;
import net.minecraft.src.WorldType;

public abstract class GenLayer {

   private long field_35502_b;
   protected GenLayer field_35504_a;
   private long field_35503_c;
   private long field_35501_d;


   public static GenLayer[] func_48425_a(long p_48425_0_, WorldType p_48425_2_) {
      GenLayerIsland var3 = new GenLayerIsland(1L);
      GenLayerFuzzyZoom var9 = new GenLayerFuzzyZoom(2000L, var3);
      GenLayerAddIsland var10 = new GenLayerAddIsland(1L, var9);
      GenLayerZoom var11 = new GenLayerZoom(2001L, var10);
      var10 = new GenLayerAddIsland(2L, var11);
      GenLayerAddSnow var12 = new GenLayerAddSnow(2L, var10);
      var11 = new GenLayerZoom(2002L, var12);
      var10 = new GenLayerAddIsland(3L, var11);
      var11 = new GenLayerZoom(2003L, var10);
      var10 = new GenLayerAddIsland(4L, var11);
      GenLayerAddMushroomIsland var15 = new GenLayerAddMushroomIsland(5L, var10);
      byte var4 = 4;
      GenLayer var5 = GenLayerZoom.func_35515_a(1000L, var15, 0);
      GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var5);
      var5 = GenLayerZoom.func_35515_a(1000L, var13, var4 + 2);
      GenLayerRiver var14 = new GenLayerRiver(1L, var5);
      GenLayerSmooth var16 = new GenLayerSmooth(1000L, var14);
      GenLayer var6 = GenLayerZoom.func_35515_a(1000L, var15, 0);
      GenLayerBiome var17 = new GenLayerBiome(200L, var6, p_48425_2_);
      var6 = GenLayerZoom.func_35515_a(1000L, var17, 2);
      Object var18 = new GenLayerHills(1000L, var6);

      for(int var7 = 0; var7 < var4; ++var7) {
         var18 = new GenLayerZoom((long)(1000 + var7), (GenLayer)var18);
         if(var7 == 0) {
            var18 = new GenLayerAddIsland(3L, (GenLayer)var18);
         }

         if(var7 == 1) {
            var18 = new GenLayerShore(1000L, (GenLayer)var18);
         }

         if(var7 == 1) {
            var18 = new GenLayerSwampRivers(1000L, (GenLayer)var18);
         }
      }

      GenLayerSmooth var19 = new GenLayerSmooth(1000L, (GenLayer)var18);
      GenLayerRiverMix var20 = new GenLayerRiverMix(100L, var19, var16);
      GenLayerVoronoiZoom var8 = new GenLayerVoronoiZoom(10L, var20);
      var20.func_35496_b(p_48425_0_);
      var8.func_35496_b(p_48425_0_);
      return new GenLayer[]{var20, var8, var20};
   }

   public GenLayer(long p_i661_1_) {
      this.field_35501_d = p_i661_1_;
      this.field_35501_d *= this.field_35501_d * 6364136223846793005L + 1442695040888963407L;
      this.field_35501_d += p_i661_1_;
      this.field_35501_d *= this.field_35501_d * 6364136223846793005L + 1442695040888963407L;
      this.field_35501_d += p_i661_1_;
      this.field_35501_d *= this.field_35501_d * 6364136223846793005L + 1442695040888963407L;
      this.field_35501_d += p_i661_1_;
   }

   public void func_35496_b(long p_35496_1_) {
      this.field_35502_b = p_35496_1_;
      if(this.field_35504_a != null) {
         this.field_35504_a.func_35496_b(p_35496_1_);
      }

      this.field_35502_b *= this.field_35502_b * 6364136223846793005L + 1442695040888963407L;
      this.field_35502_b += this.field_35501_d;
      this.field_35502_b *= this.field_35502_b * 6364136223846793005L + 1442695040888963407L;
      this.field_35502_b += this.field_35501_d;
      this.field_35502_b *= this.field_35502_b * 6364136223846793005L + 1442695040888963407L;
      this.field_35502_b += this.field_35501_d;
   }

   public void func_35499_a(long p_35499_1_, long p_35499_3_) {
      this.field_35503_c = this.field_35502_b;
      this.field_35503_c *= this.field_35503_c * 6364136223846793005L + 1442695040888963407L;
      this.field_35503_c += p_35499_1_;
      this.field_35503_c *= this.field_35503_c * 6364136223846793005L + 1442695040888963407L;
      this.field_35503_c += p_35499_3_;
      this.field_35503_c *= this.field_35503_c * 6364136223846793005L + 1442695040888963407L;
      this.field_35503_c += p_35499_1_;
      this.field_35503_c *= this.field_35503_c * 6364136223846793005L + 1442695040888963407L;
      this.field_35503_c += p_35499_3_;
   }

   protected int func_35498_a(int p_35498_1_) {
      int var2 = (int)((this.field_35503_c >> 24) % (long)p_35498_1_);
      if(var2 < 0) {
         var2 += p_35498_1_;
      }

      this.field_35503_c *= this.field_35503_c * 6364136223846793005L + 1442695040888963407L;
      this.field_35503_c += this.field_35502_b;
      return var2;
   }

   public abstract int[] func_35500_a(int var1, int var2, int var3, int var4);
}
