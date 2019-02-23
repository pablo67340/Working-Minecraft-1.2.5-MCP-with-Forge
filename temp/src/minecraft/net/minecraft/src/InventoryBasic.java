package net.minecraft.src;

import java.util.List;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInvBasic;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;

public class InventoryBasic implements IInventory {

   private String field_20072_a;
   private int field_20071_b;
   private ItemStack[] field_20074_c;
   private List field_20073_d;


   public InventoryBasic(String p_i448_1_, int p_i448_2_) {
      this.field_20072_a = p_i448_1_;
      this.field_20071_b = p_i448_2_;
      this.field_20074_c = new ItemStack[p_i448_2_];
   }

   public ItemStack func_468_c(int p_468_1_) {
      return this.field_20074_c[p_468_1_];
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_20074_c[p_473_1_] != null) {
         ItemStack var3;
         if(this.field_20074_c[p_473_1_].field_1615_a <= p_473_2_) {
            var3 = this.field_20074_c[p_473_1_];
            this.field_20074_c[p_473_1_] = null;
            this.func_474_j_();
            return var3;
         } else {
            var3 = this.field_20074_c[p_473_1_].func_1085_a(p_473_2_);
            if(this.field_20074_c[p_473_1_].field_1615_a == 0) {
               this.field_20074_c[p_473_1_] = null;
            }

            this.func_474_j_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_20074_c[p_48081_1_] != null) {
         ItemStack var2 = this.field_20074_c[p_48081_1_];
         this.field_20074_c[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_20074_c[p_472_1_] = p_472_2_;
      if(p_472_2_ != null && p_472_2_.field_1615_a > this.func_470_e()) {
         p_472_2_.field_1615_a = this.func_470_e();
      }

      this.func_474_j_();
   }

   public int func_469_c() {
      return this.field_20071_b;
   }

   public String func_471_d() {
      return this.field_20072_a;
   }

   public int func_470_e() {
      return 64;
   }

   public void func_474_j_() {
      if(this.field_20073_d != null) {
         for(int var1 = 0; var1 < this.field_20073_d.size(); ++var1) {
            ((IInvBasic)this.field_20073_d.get(var1)).func_20134_a(this);
         }
      }

   }

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return true;
   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}
}
