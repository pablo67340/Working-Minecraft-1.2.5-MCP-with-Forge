package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NoiseGenerator;
import net.minecraft.src.NoiseGeneratorPerlin;

public class NoiseGeneratorOctaves extends NoiseGenerator {

   private NoiseGeneratorPerlin[] field_1192_a;
   private int field_1191_b;


   public NoiseGeneratorOctaves(Random p_i498_1_, int p_i498_2_) {
      this.field_1191_b = p_i498_2_;
      this.field_1192_a = new NoiseGeneratorPerlin[p_i498_2_];

      for(int var3 = 0; var3 < p_i498_2_; ++var3) {
         this.field_1192_a[var3] = new NoiseGeneratorPerlin(p_i498_1_);
      }

   }

   public double[] func_807_a(double[] p_807_1_, int p_807_2_, int p_807_3_, int p_807_4_, int p_807_5_, int p_807_6_, int p_807_7_, double p_807_8_, double p_807_10_, double p_807_12_) {
      if(p_807_1_ == null) {
         p_807_1_ = new double[p_807_5_ * p_807_6_ * p_807_7_];
      } else {
         for(int var14 = 0; var14 < p_807_1_.length; ++var14) {
            p_807_1_[var14] = 0.0D;
         }
      }

      double var27 = 1.0D;

      for(int var16 = 0; var16 < this.field_1191_b; ++var16) {
         double var17 = (double)p_807_2_ * var27 * p_807_8_;
         double var19 = (double)p_807_3_ * var27 * p_807_10_;
         double var21 = (double)p_807_4_ * var27 * p_807_12_;
         long var23 = MathHelper.func_35599_c(var17);
         long var25 = MathHelper.func_35599_c(var21);
         var17 -= (double)var23;
         var21 -= (double)var25;
         var23 %= 16777216L;
         var25 %= 16777216L;
         var17 += (double)var23;
         var21 += (double)var25;
         this.field_1192_a[var16].func_805_a(p_807_1_, var17, var19, var21, p_807_5_, p_807_6_, p_807_7_, p_807_8_ * var27, p_807_10_ * var27, p_807_12_ * var27, var27);
         var27 /= 2.0D;
      }

      return p_807_1_;
   }

   public double[] func_4109_a(double[] p_4109_1_, int p_4109_2_, int p_4109_3_, int p_4109_4_, int p_4109_5_, double p_4109_6_, double p_4109_8_, double p_4109_10_) {
      return this.func_807_a(p_4109_1_, p_4109_2_, 10, p_4109_3_, p_4109_4_, 1, p_4109_5_, p_4109_6_, 1.0D, p_4109_8_);
   }
}
