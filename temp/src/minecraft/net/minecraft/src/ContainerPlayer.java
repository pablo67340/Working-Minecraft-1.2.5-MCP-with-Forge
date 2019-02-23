package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryCraftResult;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotArmor;
import net.minecraft.src.SlotCrafting;

public class ContainerPlayer extends Container {

   public InventoryCrafting field_1620_a;
   public IInventory field_1619_b;
   public boolean field_20124_c;


   public ContainerPlayer(InventoryPlayer p_i685_1_) {
      this(p_i685_1_, true);
   }

   public ContainerPlayer(InventoryPlayer p_i686_1_, boolean p_i686_2_) {
      this.field_1620_a = new InventoryCrafting(this, 2, 2);
      this.field_1619_b = new InventoryCraftResult();
      this.field_20124_c = false;
      this.field_20124_c = p_i686_2_;
      this.func_20117_a(new SlotCrafting(p_i686_1_.field_844_g, this.field_1620_a, this.field_1619_b, 0, 144, 36));

      int var3;
      int var4;
      for(var3 = 0; var3 < 2; ++var3) {
         for(var4 = 0; var4 < 2; ++var4) {
            this.func_20117_a(new Slot(this.field_1620_a, var4 + var3 * 2, 88 + var4 * 18, 26 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 4; ++var3) {
         this.func_20117_a(new SlotArmor(this, p_i686_1_, p_i686_1_.func_469_c() - 1 - var3, 8, 8 + var3 * 18, var3));
      }

      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 9; ++var4) {
            this.func_20117_a(new Slot(p_i686_1_, var4 + (var3 + 1) * 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_20117_a(new Slot(p_i686_1_, var3, 8 + var3 * 18, 142));
      }

      this.func_1103_a(this.field_1620_a);
   }

   public void func_1103_a(IInventory p_1103_1_) {
      this.field_1619_b.func_472_a(0, CraftingManager.func_1120_a().func_21188_a(this.field_1620_a));
   }

   public void func_1104_a(EntityPlayer p_1104_1_) {
      super.func_1104_a(p_1104_1_);

      for(int var2 = 0; var2 < 4; ++var2) {
         ItemStack var3 = this.field_1620_a.func_48081_b(var2);
         if(var3 != null) {
            p_1104_1_.func_48153_a(var3);
         }
      }

      this.field_1619_b.func_472_a(0, (ItemStack)null);
   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return true;
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if(p_27279_1_ == 0) {
            if(!this.func_28125_a(var4, 9, 45, true)) {
               return null;
            }

            var3.func_48433_a(var4, var2);
         } else if(p_27279_1_ >= 9 && p_27279_1_ < 36) {
            if(!this.func_28125_a(var4, 36, 45, false)) {
               return null;
            }
         } else if(p_27279_1_ >= 36 && p_27279_1_ < 45) {
            if(!this.func_28125_a(var4, 9, 36, false)) {
               return null;
            }
         } else if(!this.func_28125_a(var4, 9, 45, false)) {
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
