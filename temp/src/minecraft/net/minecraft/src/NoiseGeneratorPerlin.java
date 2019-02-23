package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.NoiseGenerator;

public class NoiseGeneratorPerlin extends NoiseGenerator {

   private int[] field_1189_d;
   public double field_1188_a;
   public double field_1187_b;
   public double field_1190_c;


   public NoiseGeneratorPerlin() {
      this(new Random());
   }

   public NoiseGeneratorPerlin(Random p_i227_1_) {
      this.field_1189_d = new int[512];
      this.field_1188_a = p_i227_1_.nextDouble() * 256.0D;
      this.field_1187_b = p_i227_1_.nextDouble() * 256.0D;
      this.field_1190_c = p_i227_1_.nextDouble() * 256.0D;

      int var2;
      for(var2 = 0; var2 < 256; this.field_1189_d[var2] = var2++) {
         ;
      }

      for(var2 = 0; var2 < 256; ++var2) {
         int var3 = p_i227_1_.nextInt(256 - var2) + var2;
         int var4 = this.field_1189_d[var2];
         this.field_1189_d[var2] = this.field_1189_d[var3];
         this.field_1189_d[var3] = var4;
         this.field_1189_d[var2 + 256] = this.field_1189_d[var2];
      }

   }

   public final double func_804_b(double p_804_1_, double p_804_3_, double p_804_5_) {
      return p_804_3_ + p_804_1_ * (p_804_5_ - p_804_3_);
   }

   public final double func_4110_a(int p_4110_1_, double p_4110_2_, double p_4110_4_) {
      int var6 = p_4110_1_ & 15;
      double var7 = (double)(1 - ((var6 & 8) >> 3)) * p_4110_2_;
      double var9 = var6 < 4?0.0D:(var6 != 12 && var6 != 14?p_4110_4_:p_4110_2_);
      return ((var6 & 1) == 0?var7:-var7) + ((var6 & 2) == 0?var9:-var9);
   }

   public final double func_803_a(int p_803_1_, double p_803_2_, double p_803_4_, double p_803_6_) {
      int var8 = p_803_1_ & 15;
      double var9 = var8 < 8?p_803_2_:p_803_4_;
      double var11 = var8 < 4?p_803_4_:(var8 != 12 && var8 != 14?p_803_6_:p_803_2_);
      return ((var8 & 1) == 0?var9:-var9) + ((var8 & 2) == 0?var11:-var11);
   }

   public void func_805_a(double[] p_805_1_, double p_805_2_, double p_805_4_, double p_805_6_, int p_805_8_, int p_805_9_, int p_805_10_, double p_805_11_, double p_805_13_, double p_805_15_, double p_805_17_) {
      int var10001;
      int var19;
      int var22;
      double var31;
      double var35;
      int var37;
      double var38;
      int var40;
      int var41;
      double var42;
      int var75;
      if(p_805_9_ == 1) {
         boolean var64 = false;
         boolean var65 = false;
         boolean var21 = false;
         boolean var68 = false;
         double var70 = 0.0D;
         double var73 = 0.0D;
         var75 = 0;
         double var77 = 1.0D / p_805_17_;

         for(int var30 = 0; var30 < p_805_8_; ++var30) {
            var31 = p_805_2_ + (double)var30 * p_805_11_ + this.field_1188_a;
            int var78 = (int)var31;
            if(var31 < (double)var78) {
               --var78;
            }

            int var34 = var78 & 255;
            var31 -= (double)var78;
            var35 = var31 * var31 * var31 * (var31 * (var31 * 6.0D - 15.0D) + 10.0D);

            for(var37 = 0; var37 < p_805_10_; ++var37) {
               var38 = p_805_6_ + (double)var37 * p_805_15_ + this.field_1190_c;
               var40 = (int)var38;
               if(var38 < (double)var40) {
                  --var40;
               }

               var41 = var40 & 255;
               var38 -= (double)var40;
               var42 = var38 * var38 * var38 * (var38 * (var38 * 6.0D - 15.0D) + 10.0D);
               var19 = this.field_1189_d[var34] + 0;
               int var66 = this.field_1189_d[var19] + var41;
               int var67 = this.field_1189_d[var34 + 1] + 0;
               var22 = this.field_1189_d[var67] + var41;
               var70 = this.func_804_b(var35, this.func_4110_a(this.field_1189_d[var66], var31, var38), this.func_803_a(this.field_1189_d[var22], var31 - 1.0D, 0.0D, var38));
               var73 = this.func_804_b(var35, this.func_803_a(this.field_1189_d[var66 + 1], var31, 0.0D, var38 - 1.0D), this.func_803_a(this.field_1189_d[var22 + 1], var31 - 1.0D, 0.0D, var38 - 1.0D));
               double var79 = this.func_804_b(var42, var70, var73);
               var10001 = var75++;
               p_805_1_[var10001] += var79 * var77;
            }
         }

      } else {
         var19 = 0;
         double var20 = 1.0D / p_805_17_;
         var22 = -1;
         boolean var23 = false;
         boolean var24 = false;
         boolean var25 = false;
         boolean var26 = false;
         boolean var27 = false;
         boolean var28 = false;
         double var29 = 0.0D;
         var31 = 0.0D;
         double var33 = 0.0D;
         var35 = 0.0D;

         for(var37 = 0; var37 < p_805_8_; ++var37) {
            var38 = p_805_2_ + (double)var37 * p_805_11_ + this.field_1188_a;
            var40 = (int)var38;
            if(var38 < (double)var40) {
               --var40;
            }

            var41 = var40 & 255;
            var38 -= (double)var40;
            var42 = var38 * var38 * var38 * (var38 * (var38 * 6.0D - 15.0D) + 10.0D);

            for(int var44 = 0; var44 < p_805_10_; ++var44) {
               double var45 = p_805_6_ + (double)var44 * p_805_15_ + this.field_1190_c;
               int var47 = (int)var45;
               if(var45 < (double)var47) {
                  --var47;
               }

               int var48 = var47 & 255;
               var45 -= (double)var47;
               double var49 = var45 * var45 * var45 * (var45 * (var45 * 6.0D - 15.0D) + 10.0D);

               for(int var51 = 0; var51 < p_805_9_; ++var51) {
                  double var52 = p_805_4_ + (double)var51 * p_805_13_ + this.field_1187_b;
                  int var54 = (int)var52;
                  if(var52 < (double)var54) {
                     --var54;
                  }

                  int var55 = var54 & 255;
                  var52 -= (double)var54;
                  double var56 = var52 * var52 * var52 * (var52 * (var52 * 6.0D - 15.0D) + 10.0D);
                  if(var51 == 0 || var55 != var22) {
                     var22 = var55;
                     int var69 = this.field_1189_d[var41] + var55;
                     int var71 = this.field_1189_d[var69] + var48;
                     int var72 = this.field_1189_d[var69 + 1] + var48;
                     int var74 = this.field_1189_d[var41 + 1] + var55;
                     var75 = this.field_1189_d[var74] + var48;
                     int var76 = this.field_1189_d[var74 + 1] + var48;
                     var29 = this.func_804_b(var42, this.func_803_a(this.field_1189_d[var71], var38, var52, var45), this.func_803_a(this.field_1189_d[var75], var38 - 1.0D, var52, var45));
                     var31 = this.func_804_b(var42, this.func_803_a(this.field_1189_d[var72], var38, var52 - 1.0D, var45), this.func_803_a(this.field_1189_d[var76], var38 - 1.0D, var52 - 1.0D, var45));
                     var33 = this.func_804_b(var42, this.func_803_a(this.field_1189_d[var71 + 1], var38, var52, var45 - 1.0D), this.func_803_a(this.field_1189_d[var75 + 1], var38 - 1.0D, var52, var45 - 1.0D));
                     var35 = this.func_804_b(var42, this.func_803_a(this.field_1189_d[var72 + 1], var38, var52 - 1.0D, var45 - 1.0D), this.func_803_a(this.field_1189_d[var76 + 1], var38 - 1.0D, var52 - 1.0D, var45 - 1.0D));
                  }

                  double var58 = this.func_804_b(var56, var29, var31);
                  double var60 = this.func_804_b(var56, var33, var35);
                  double var62 = this.func_804_b(var49, var58, var60);
                  var10001 = var19++;
                  p_805_1_[var10001] += var62 * var20;
               }
            }
         }

      }
   }
}
