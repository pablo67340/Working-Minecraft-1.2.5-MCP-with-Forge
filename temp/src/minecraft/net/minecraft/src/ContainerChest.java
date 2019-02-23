package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class ContainerChest extends Container {

   private IInventory field_20125_a;
   private int field_27282_b;


   public ContainerChest(IInventory p_i249_1_, IInventory p_i249_2_) {
      this.field_20125_a = p_i249_2_;
      this.field_27282_b = p_i249_2_.func_469_c() / 9;
      p_i249_2_.func_35142_x_();
      int var3 = (this.field_27282_b - 4) * 18;

      int var4;
      int var5;
      for(var4 = 0; var4 < this.field_27282_b; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.func_20117_a(new Slot(p_i249_2_, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18));
         }
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.func_20117_a(new Slot(p_i249_1_, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.func_20117_a(new Slot(p_i249_1_, var4, 8 + var4 * 18, 161 + var3));
      }

   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return this.field_20125_a.func_20070_a_(p_20120_1_);
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if(p_27279_1_ < this.field_27282_b * 9) {
            if(!this.func_28125_a(var4, this.field_27282_b * 9, this.field_20122_e.size(), true)) {
               return null;
            }
         } else if(!this.func_28125_a(var4, 0, this.field_27282_b * 9, false)) {
            return null;
         }

         if(var4.field_1615_a == 0) {
            var3.func_776_b((ItemStack)null);
         } else {
            var3.func_779_d();
         }
      }

      return var2;
   }

   public void func_1104_a(EntityPlayer p_1104_1_) {
      super.func_1104_a(p_1104_1_);
      this.field_20125_a.func_35141_y_();
   }
}
