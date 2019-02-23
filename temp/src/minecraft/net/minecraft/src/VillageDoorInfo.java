package net.minecraft.src;


public class VillageDoorInfo {

   public final int field_48600_a;
   public final int field_48598_b;
   public final int field_48599_c;
   public final int field_48596_d;
   public final int field_48597_e;
   public int field_48594_f;
   public boolean field_48595_g = false;
   private int field_48601_h = 0;


   public VillageDoorInfo(int p_i1004_1_, int p_i1004_2_, int p_i1004_3_, int p_i1004_4_, int p_i1004_5_, int p_i1004_6_) {
      this.field_48600_a = p_i1004_1_;
      this.field_48598_b = p_i1004_2_;
      this.field_48599_c = p_i1004_3_;
      this.field_48596_d = p_i1004_4_;
      this.field_48597_e = p_i1004_5_;
      this.field_48594_f = p_i1004_6_;
   }

   public int func_48588_a(int p_48588_1_, int p_48588_2_, int p_48588_3_) {
      int var4 = p_48588_1_ - this.field_48600_a;
      int var5 = p_48588_2_ - this.field_48598_b;
      int var6 = p_48588_3_ - this.field_48599_c;
      return var4 * var4 + var5 * var5 + var6 * var6;
   }

   public int func_48593_b(int p_48593_1_, int p_48593_2_, int p_48593_3_) {
      int var4 = p_48593_1_ - this.field_48600_a - this.field_48596_d;
      int var5 = p_48593_2_ - this.field_48598_b;
      int var6 = p_48593_3_ - this.field_48599_c - this.field_48597_e;
      return var4 * var4 + var5 * var5 + var6 * var6;
   }

   public int func_48590_a() {
      return this.field_48600_a + this.field_48596_d;
   }

   public int func_48592_b() {
      return this.field_48598_b;
   }

   public int func_48591_c() {
      return this.field_48599_c + this.field_48597_e;
   }

   public boolean func_48586_a(int p_48586_1_, int p_48586_2_) {
      int var3 = p_48586_1_ - this.field_48600_a;
      int var4 = p_48586_2_ - this.field_48599_c;
      return var3 * this.field_48596_d + var4 * this.field_48597_e >= 0;
   }

   public void func_48585_d() {
      this.field_48601_h = 0;
   }

   public void func_48589_e() {
      ++this.field_48601_h;
   }

   public int func_48587_f() {
      return this.field_48601_h;
   }
}
