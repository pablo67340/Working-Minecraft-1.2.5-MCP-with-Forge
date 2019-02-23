package net.minecraft.src;

import net.minecraft.src.MathHelper;

public class PathPoint {

   public final int field_1718_a;
   public final int field_1717_b;
   public final int field_1716_c;
   private final int field_1715_d;
   int field_1714_e = -1;
   float field_1713_f;
   float field_1712_g;
   float field_1711_h;
   PathPoint field_1710_i;
   public boolean field_1709_j = false;


   public PathPoint(int p_i297_1_, int p_i297_2_, int p_i297_3_) {
      this.field_1718_a = p_i297_1_;
      this.field_1717_b = p_i297_2_;
      this.field_1716_c = p_i297_3_;
      this.field_1715_d = func_22329_a(p_i297_1_, p_i297_2_, p_i297_3_);
   }

   public static int func_22329_a(int p_22329_0_, int p_22329_1_, int p_22329_2_) {
      return p_22329_1_ & 255 | (p_22329_0_ & 32767) << 8 | (p_22329_2_ & 32767) << 24 | (p_22329_0_ < 0?Integer.MIN_VALUE:0) | (p_22329_2_ < 0?'\u8000':0);
   }

   public float func_1180_a(PathPoint p_1180_1_) {
      float var2 = (float)(p_1180_1_.field_1718_a - this.field_1718_a);
      float var3 = (float)(p_1180_1_.field_1717_b - this.field_1717_b);
      float var4 = (float)(p_1180_1_.field_1716_c - this.field_1716_c);
      return MathHelper.func_1113_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof PathPoint)) {
         return false;
      } else {
         PathPoint var2 = (PathPoint)p_equals_1_;
         return this.field_1715_d == var2.field_1715_d && this.field_1718_a == var2.field_1718_a && this.field_1717_b == var2.field_1717_b && this.field_1716_c == var2.field_1716_c;
      }
   }

   public int hashCode() {
      return this.field_1715_d;
   }

   public boolean func_1179_a() {
      return this.field_1714_e >= 0;
   }

   public String toString() {
      return this.field_1718_a + ", " + this.field_1717_b + ", " + this.field_1716_c;
   }
}
