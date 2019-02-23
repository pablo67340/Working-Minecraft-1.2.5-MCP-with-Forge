package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotBrewingStandIngredient;
import net.minecraft.src.SlotBrewingStandPotion;
import net.minecraft.src.TileEntityBrewingStand;

public class ContainerBrewingStand extends Container {

   private TileEntityBrewingStand field_40243_a;
   private int field_40242_b = 0;


   public ContainerBrewingStand(InventoryPlayer p_i750_1_, TileEntityBrewingStand p_i750_2_) {
      this.field_40243_a = p_i750_2_;
      this.func_20117_a(new SlotBrewingStandPotion(this, p_i750_1_.field_844_g, p_i750_2_, 0, 56, 46));
      this.func_20117_a(new SlotBrewingStandPotion(this, p_i750_1_.field_844_g, p_i750_2_, 1, 79, 53));
      this.func_20117_a(new SlotBrewingStandPotion(this, p_i750_1_.field_844_g, p_i750_2_, 2, 102, 46));
      this.func_20117_a(new SlotBrewingStandIngredient(this, p_i750_2_, 3, 79, 17));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_20117_a(new Slot(p_i750_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_20117_a(new Slot(p_i750_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public void func_20114_a() {
      super.func_20114_a();

      for(int var1 = 0; var1 < this.field_20121_g.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_20121_g.get(var1);
         if(this.field_40242_b != this.field_40243_a.func_40053_g()) {
            var2.func_20158_a(this, 0, this.field_40243_a.func_40053_g());
         }
      }

      this.field_40242_b = this.field_40243_a.func_40053_g();
   }

   public void func_20112_a(int p_20112_1_, int p_20112_2_) {
      if(p_20112_1_ == 0) {
         this.field_40243_a.func_40049_b(p_20112_2_);
      }

   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return this.field_40243_a.func_20070_a_(p_20120_1_);
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if((p_27279_1_ < 0 || p_27279_1_ > 2) && p_27279_1_ != 3) {
            if(p_27279_1_ >= 4 && p_27279_1_ < 31) {
               if(!this.func_28125_a(var4, 31, 40, false)) {
                  return null;
               }
            } else if(p_27279_1_ >= 31 && p_27279_1_ < 40) {
               if(!this.func_28125_a(var4, 4, 31, false)) {
                  return null;
               }
            } else if(!this.func_28125_a(var4, 4, 40, false)) {
               return null;
            }
         } else {
            if(!this.func_28125_a(var4, 4, 40, true)) {
               return null;
            }

            var3.func_48433_a(var4, var2);
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
