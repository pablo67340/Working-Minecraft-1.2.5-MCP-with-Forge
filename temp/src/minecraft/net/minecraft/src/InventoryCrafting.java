package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryCrafting implements IInventory {

   private ItemStack[] field_840_a;
   private int field_21104_b;
   private Container field_841_c;


   public InventoryCrafting(Container p_i34_1_, int p_i34_2_, int p_i34_3_) {
      int var4 = p_i34_2_ * p_i34_3_;
      this.field_840_a = new ItemStack[var4];
      this.field_841_c = p_i34_1_;
      this.field_21104_b = p_i34_2_;
   }

   public int func_469_c() {
      return this.field_840_a.length;
   }

   public ItemStack func_468_c(int p_468_1_) {
      return p_468_1_ >= this.func_469_c()?null:this.field_840_a[p_468_1_];
   }

   public ItemStack func_21103_b(int p_21103_1_, int p_21103_2_) {
      if(p_21103_1_ >= 0 && p_21103_1_ < this.field_21104_b) {
         int var3 = p_21103_1_ + p_21103_2_ * this.field_21104_b;
         return this.func_468_c(var3);
      } else {
         return null;
      }
   }

   public String func_471_d() {
      return "container.crafting";
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_840_a[p_48081_1_] != null) {
         ItemStack var2 = this.field_840_a[p_48081_1_];
         this.field_840_a[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_840_a[p_473_1_] != null) {
         ItemStack var3;
         if(this.field_840_a[p_473_1_].field_1615_a <= p_473_2_) {
            var3 = this.field_840_a[p_473_1_];
            this.field_840_a[p_473_1_] = null;
            this.field_841_c.func_1103_a(this);
            return var3;
         } else {
            var3 = this.field_840_a[p_473_1_].func_1085_a(p_473_2_);
            if(this.field_840_a[p_473_1_].field_1615_a == 0) {
               this.field_840_a[p_473_1_] = null;
            }

            this.field_841_c.func_1103_a(this);
            return var3;
         }
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_840_a[p_472_1_] = p_472_2_;
      this.field_841_c.func_1103_a(this);
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
