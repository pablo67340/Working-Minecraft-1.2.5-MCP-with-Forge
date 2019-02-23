package net.minecraft.src;


public class ColorizerGrass {

   private static int[] field_6540_a = new int[65536];


   public static void func_28181_a(int[] p_28181_0_) {
      field_6540_a = p_28181_0_;
   }

   public static int func_4147_a(double p_4147_0_, double p_4147_2_) {
      p_4147_2_ *= p_4147_0_;
      int var4 = (int)((1.0D - p_4147_0_) * 255.0D);
      int var5 = (int)((1.0D - p_4147_2_) * 255.0D);
      return field_6540_a[var5 << 8 | var4];
   }

}
