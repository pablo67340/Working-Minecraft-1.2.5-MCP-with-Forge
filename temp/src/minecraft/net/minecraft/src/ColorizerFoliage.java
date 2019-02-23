package net.minecraft.src;


public class ColorizerFoliage {

   private static int[] field_6529_a = new int[65536];


   public static void func_28152_a(int[] p_28152_0_) {
      field_6529_a = p_28152_0_;
   }

   public static int func_4146_a(double p_4146_0_, double p_4146_2_) {
      p_4146_2_ *= p_4146_0_;
      int var4 = (int)((1.0D - p_4146_0_) * 255.0D);
      int var5 = (int)((1.0D - p_4146_2_) * 255.0D);
      return field_6529_a[var5 << 8 | var4];
   }

   public static int func_21175_a() {
      return 6396257;
   }

   public static int func_21174_b() {
      return 8431445;
   }

   public static int func_31073_c() {
      return 4764952;
   }

}
