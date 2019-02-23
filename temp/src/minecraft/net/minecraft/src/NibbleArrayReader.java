package net.minecraft.src;


public class NibbleArrayReader {

   public final byte[] field_48511_a;
   private final int field_48509_b;
   private final int field_48510_c;


   public NibbleArrayReader(byte[] p_i1058_1_, int p_i1058_2_) {
      this.field_48511_a = p_i1058_1_;
      this.field_48509_b = p_i1058_2_;
      this.field_48510_c = p_i1058_2_ + 4;
   }

   public int func_48508_a(int p_48508_1_, int p_48508_2_, int p_48508_3_) {
      int var4 = p_48508_1_ << this.field_48510_c | p_48508_3_ << this.field_48509_b | p_48508_2_;
      int var5 = var4 >> 1;
      int var6 = var4 & 1;
      return var6 == 0?this.field_48511_a[var5] & 15:this.field_48511_a[var5] >> 4 & 15;
   }
}
