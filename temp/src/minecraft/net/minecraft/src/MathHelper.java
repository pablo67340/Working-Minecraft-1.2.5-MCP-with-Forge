package net.minecraft.src;

import java.util.Random;

public class MathHelper {

   private static float[] field_1653_a = new float[65536];


   public static final float func_1106_a(float p_1106_0_) {
      return field_1653_a[(int)(p_1106_0_ * 10430.378F) & '\uffff'];
   }

   public static final float func_1114_b(float p_1114_0_) {
      return field_1653_a[(int)(p_1114_0_ * 10430.378F + 16384.0F) & '\uffff'];
   }

   public static final float func_1113_c(float p_1113_0_) {
      return (float)Math.sqrt((double)p_1113_0_);
   }

   public static final float func_1109_a(double p_1109_0_) {
      return (float)Math.sqrt(p_1109_0_);
   }

   public static int func_1110_d(float p_1110_0_) {
      int var1 = (int)p_1110_0_;
      return p_1110_0_ < (float)var1?var1 - 1:var1;
   }

   public static int func_40346_b(double p_40346_0_) {
      return (int)(p_40346_0_ + 1024.0D) - 1024;
   }

   public static int func_1108_b(double p_1108_0_) {
      int var2 = (int)p_1108_0_;
      return p_1108_0_ < (double)var2?var2 - 1:var2;
   }

   public static long func_35599_c(double p_35599_0_) {
      long var2 = (long)p_35599_0_;
      return p_35599_0_ < (double)var2?var2 - 1L:var2;
   }

   public static float func_1112_e(float p_1112_0_) {
      return p_1112_0_ >= 0.0F?p_1112_0_:-p_1112_0_;
   }

   public static int func_41084_a(int p_41084_0_, int p_41084_1_, int p_41084_2_) {
      return p_41084_0_ < p_41084_1_?p_41084_1_:(p_41084_0_ > p_41084_2_?p_41084_2_:p_41084_0_);
   }

   public static float func_48442_a(float p_48442_0_, float p_48442_1_, float p_48442_2_) {
      return p_48442_0_ < p_48442_1_?p_48442_1_:(p_48442_0_ > p_48442_2_?p_48442_2_:p_48442_0_);
   }

   public static double func_1107_a(double p_1107_0_, double p_1107_2_) {
      if(p_1107_0_ < 0.0D) {
         p_1107_0_ = -p_1107_0_;
      }

      if(p_1107_2_ < 0.0D) {
         p_1107_2_ = -p_1107_2_;
      }

      return p_1107_0_ > p_1107_2_?p_1107_0_:p_1107_2_;
   }

   public static int func_1111_a(int p_1111_0_, int p_1111_1_) {
      return p_1111_0_ < 0?-((-p_1111_0_ - 1) / p_1111_1_) - 1:p_1111_0_ / p_1111_1_;
   }

   public static boolean func_22282_a(String p_22282_0_) {
      return p_22282_0_ == null || p_22282_0_.length() == 0;
   }

   public static int func_35598_a(Random p_35598_0_, int p_35598_1_, int p_35598_2_) {
      return p_35598_1_ >= p_35598_2_?p_35598_1_:p_35598_0_.nextInt(p_35598_2_ - p_35598_1_ + 1) + p_35598_1_;
   }

   static {
      for(int var0 = 0; var0 < 65536; ++var0) {
         field_1653_a[var0] = (float)Math.sin((double)var0 * 3.141592653589793D * 2.0D / 65536.0D);
      }

   }
}
