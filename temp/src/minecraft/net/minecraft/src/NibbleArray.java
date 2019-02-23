package net.minecraft.src;


public class NibbleArray {

   public final byte[] field_1109_a;
   private final int field_35754_b;
   private final int field_35755_c;


   public NibbleArray(int p_i558_1_, int p_i558_2_) {
      this.field_1109_a = new byte[p_i558_1_ >> 1];
      this.field_35754_b = p_i558_2_;
      this.field_35755_c = p_i558_2_ + 4;
   }

   public NibbleArray(byte[] p_i559_1_, int p_i559_2_) {
      this.field_1109_a = p_i559_1_;
      this.field_35754_b = p_i559_2_;
      this.field_35755_c = p_i559_2_ + 4;
   }

   public int func_771_a(int p_771_1_, int p_771_2_, int p_771_3_) {
      int var4 = p_771_2_ << this.field_35755_c | p_771_3_ << this.field_35754_b | p_771_1_;
      int var5 = var4 >> 1;
      int var6 = var4 & 1;
      return var6 == 0?this.field_1109_a[var5] & 15:this.field_1109_a[var5] >> 4 & 15;
   }

   public void func_770_a(int p_770_1_, int p_770_2_, int p_770_3_, int p_770_4_) {
      int var5 = p_770_2_ << this.field_35755_c | p_770_3_ << this.field_35754_b | p_770_1_;
      int var6 = var5 >> 1;
      int var7 = var5 & 1;
      if(var7 == 0) {
         this.field_1109_a[var6] = (byte)(this.field_1109_a[var6] & 240 | p_770_4_ & 15);
      } else {
         this.field_1109_a[var6] = (byte)(this.field_1109_a[var6] & 15 | (p_770_4_ & 15) << 4);
      }

   }
}
