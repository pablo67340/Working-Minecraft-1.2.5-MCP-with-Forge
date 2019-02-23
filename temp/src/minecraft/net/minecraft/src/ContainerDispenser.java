package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.TileEntityDispenser;

public class ContainerDispenser extends Container {

   private TileEntityDispenser field_21149_a;


   public ContainerDispenser(IInventory p_i121_1_, TileEntityDispenser p_i121_2_) {
      this.field_21149_a = p_i121_2_;

      int var3;
      int var4;
      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 3; ++var4) {
            this.func_20117_a(new Slot(p_i121_2_, var4 + var3 * 3, 62 + var4 * 18, 17 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 9; ++var4) {
            this.func_20117_a(new Slot(p_i121_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_20117_a(new Slot(p_i121_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return this.field_21149_a.func_20070_a_(p_20120_1_);
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if(p_27279_1_ < 9) {
            if(!this.func_28125_a(var4, 9, 45, true)) {
               return null;
            }
         } else if(!this.func_28125_a(var4, 0, 9, false)) {
            return null;
         }

         if(var4.field_1615_a == 0) {
            var3.func_776_b((ItemStack)null);
         } else {
            var3.func_779_d();
         }

         if(var4.field_1615_a == var2.field_1615_a) {
            return null;
         }

         var3.func_4103_a(var4);
      }

      return var2;
   }
}
