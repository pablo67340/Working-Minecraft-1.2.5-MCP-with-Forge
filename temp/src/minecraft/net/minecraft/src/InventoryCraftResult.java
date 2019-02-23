package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryCraftResult implements IInventory {

   private ItemStack[] field_818_a = new ItemStack[1];


   public int func_469_c() {
      return 1;
   }

   public ItemStack func_468_c(int p_468_1_) {
      return this.field_818_a[p_468_1_];
   }

   public String func_471_d() {
      return "Result";
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_818_a[p_473_1_] != null) {
         ItemStack var3 = this.field_818_a[p_473_1_];
         this.field_818_a[p_473_1_] = null;
         return var3;
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_818_a[p_48081_1_] != null) {
         ItemStack var2 = this.field_818_a[p_48081_1_];
         this.field_818_a[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_818_a[p_472_1_] = p_472_2_;
   }

   public int func_470_e() {
      return 64;
   }

   public void func_474_j_() {}

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return true;
   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}
}
