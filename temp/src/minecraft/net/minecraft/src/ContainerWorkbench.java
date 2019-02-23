package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryCraftResult;
import net.minecraft.src.InventoryCrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotCrafting;
import net.minecraft.src.World;

public class ContainerWorkbench extends Container {

   public InventoryCrafting field_1622_a = new InventoryCrafting(this, 3, 3);
   public IInventory field_1621_b = new InventoryCraftResult();
   private World field_20133_c;
   private int field_20132_h;
   private int field_20131_i;
   private int field_20130_j;


   public ContainerWorkbench(InventoryPlayer p_i737_1_, World p_i737_2_, int p_i737_3_, int p_i737_4_, int p_i737_5_) {
      this.field_20133_c = p_i737_2_;
      this.field_20132_h = p_i737_3_;
      this.field_20131_i = p_i737_4_;
      this.field_20130_j = p_i737_5_;
      this.func_20117_a(new SlotCrafting(p_i737_1_.field_844_g, this.field_1622_a, this.field_1621_b, 0, 124, 35));

      int var6;
      int var7;
      for(var6 = 0; var6 < 3; ++var6) {
         for(var7 = 0; var7 < 3; ++var7) {
            this.func_20117_a(new Slot(this.field_1622_a, var7 + var6 * 3, 30 + var7 * 18, 17 + var6 * 18));
         }
      }

      for(var6 = 0; var6 < 3; ++var6) {
         for(var7 = 0; var7 < 9; ++var7) {
            this.func_20117_a(new Slot(p_i737_1_, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
         }
      }

      for(var6 = 0; var6 < 9; ++var6) {
         this.func_20117_a(new Slot(p_i737_1_, var6, 8 + var6 * 18, 142));
      }

      this.func_1103_a(this.field_1622_a);
   }

   public void func_1103_a(IInventory p_1103_1_) {
      this.field_1621_b.func_472_a(0, CraftingManager.func_1120_a().func_21188_a(this.field_1622_a));
   }

   public void func_1104_a(EntityPlayer p_1104_1_) {
      super.func_1104_a(p_1104_1_);
      if(!this.field_20133_c.field_1026_y) {
         for(int var2 = 0; var2 < 9; ++var2) {
            ItemStack var3 = this.field_1622_a.func_48081_b(var2);
            if(var3 != null) {
               p_1104_1_.func_48153_a(var3);
            }
         }

      }
   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return this.field_20133_c.func_600_a(this.field_20132_h, this.field_20131_i, this.field_20130_j) != Block.field_387_az.field_376_bc?false:p_20120_1_.func_360_d((double)this.field_20132_h + 0.5D, (double)this.field_20131_i + 0.5D, (double)this.field_20130_j + 0.5D) <= 64.0D;
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if(p_27279_1_ == 0) {
            if(!this.func_28125_a(var4, 10, 46, true)) {
               return null;
            }

            var3.func_48433_a(var4, var2);
         } else if(p_27279_1_ >= 10 && p_27279_1_ < 37) {
            if(!this.func_28125_a(var4, 37, 46, false)) {
               return null;
            }
         } else if(p_27279_1_ >= 37 && p_27279_1_ < 46) {
            if(!this.func_28125_a(var4, 10, 37, false)) {
               return null;
            }
         } else if(!this.func_28125_a(var4, 10, 46, false)) {
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
