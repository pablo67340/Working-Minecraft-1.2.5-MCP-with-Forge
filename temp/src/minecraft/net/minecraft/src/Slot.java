package net.minecraft.src;

import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class Slot {

   private final int field_1119_a;
   public final IInventory field_1118_b;
   public int field_20007_a;
   public int field_20006_b;
   public int field_20008_c;


   public Slot(IInventory p_i706_1_, int p_i706_2_, int p_i706_3_, int p_i706_4_) {
      this.field_1118_b = p_i706_1_;
      this.field_1119_a = p_i706_2_;
      this.field_20006_b = p_i706_3_;
      this.field_20008_c = p_i706_4_;
   }

   public void func_48433_a(ItemStack p_48433_1_, ItemStack p_48433_2_) {
      if(p_48433_1_ != null && p_48433_2_ != null) {
         if(p_48433_1_.field_1617_c == p_48433_2_.field_1617_c) {
            int var3 = p_48433_2_.field_1615_a - p_48433_1_.field_1615_a;
            if(var3 > 0) {
               this.func_48435_a(p_48433_1_, var3);
            }

         }
      }
   }

   protected void func_48435_a(ItemStack p_48435_1_, int p_48435_2_) {}

   protected void func_48434_c(ItemStack p_48434_1_) {}

   public void func_4103_a(ItemStack p_4103_1_) {
      this.func_779_d();
   }

   public boolean func_4105_a(ItemStack p_4105_1_) {
      return true;
   }

   public ItemStack func_777_b() {
      return this.field_1118_b.func_468_c(this.field_1119_a);
   }

   public boolean func_20005_c() {
      return this.func_777_b() != null;
   }

   public void func_776_b(ItemStack p_776_1_) {
      this.field_1118_b.func_472_a(this.field_1119_a, p_776_1_);
      this.func_779_d();
   }

   public void func_779_d() {
      this.field_1118_b.func_474_j_();
   }

   public int func_4104_e() {
      return this.field_1118_b.func_470_e();
   }

   public int func_775_c() {
      return -1;
   }

   public ItemStack func_20004_a(int p_20004_1_) {
      return this.field_1118_b.func_473_a(this.field_1119_a, p_20004_1_);
   }
}
