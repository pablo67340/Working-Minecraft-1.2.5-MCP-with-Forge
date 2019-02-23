package net.minecraft.src;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.ICrafting;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotFurnace;
import net.minecraft.src.TileEntityFurnace;

public class ContainerFurnace extends Container {

   private TileEntityFurnace field_20127_a;
   private int field_20126_b = 0;
   private int field_20129_c = 0;
   private int field_20128_h = 0;


   public ContainerFurnace(InventoryPlayer p_i623_1_, TileEntityFurnace p_i623_2_) {
      this.field_20127_a = p_i623_2_;
      this.func_20117_a(new Slot(p_i623_2_, 0, 56, 17));
      this.func_20117_a(new Slot(p_i623_2_, 1, 56, 53));
      this.func_20117_a(new SlotFurnace(p_i623_1_.field_844_g, p_i623_2_, 2, 116, 35));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.func_20117_a(new Slot(p_i623_1_, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.func_20117_a(new Slot(p_i623_1_, var3, 8 + var3 * 18, 142));
      }

   }

   public void func_20114_a() {
      super.func_20114_a();

      for(int var1 = 0; var1 < this.field_20121_g.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_20121_g.get(var1);
         if(this.field_20126_b != this.field_20127_a.field_834_d) {
            var2.func_20158_a(this, 0, this.field_20127_a.field_834_d);
         }

         if(this.field_20129_c != this.field_20127_a.field_832_b) {
            var2.func_20158_a(this, 1, this.field_20127_a.field_832_b);
         }

         if(this.field_20128_h != this.field_20127_a.field_835_c) {
            var2.func_20158_a(this, 2, this.field_20127_a.field_835_c);
         }
      }

      this.field_20126_b = this.field_20127_a.field_834_d;
      this.field_20129_c = this.field_20127_a.field_832_b;
      this.field_20128_h = this.field_20127_a.field_835_c;
   }

   public void func_20112_a(int p_20112_1_, int p_20112_2_) {
      if(p_20112_1_ == 0) {
         this.field_20127_a.field_834_d = p_20112_2_;
      }

      if(p_20112_1_ == 1) {
         this.field_20127_a.field_832_b = p_20112_2_;
      }

      if(p_20112_1_ == 2) {
         this.field_20127_a.field_835_c = p_20112_2_;
      }

   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return this.field_20127_a.func_20070_a_(p_20120_1_);
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if(p_27279_1_ == 2) {
            if(!this.func_28125_a(var4, 3, 39, true)) {
               return null;
            }

            var3.func_48433_a(var4, var2);
         } else if(p_27279_1_ != 1 && p_27279_1_ != 0) {
            if(FurnaceRecipes.func_21200_a().func_21198_a(var4.func_1091_a().field_291_aS) != null) {
               if(!this.func_28125_a(var4, 0, 1, false)) {
                  return null;
               }
            } else if(TileEntityFurnace.func_52005_b(var4)) {
               if(!this.func_28125_a(var4, 1, 2, false)) {
                  return null;
               }
            } else if(p_27279_1_ >= 3 && p_27279_1_ < 30) {
               if(!this.func_28125_a(var4, 30, 39, false)) {
                  return null;
               }
            } else if(p_27279_1_ >= 30 && p_27279_1_ < 39 && !this.func_28125_a(var4, 3, 30, false)) {
               return null;
            }
         } else if(!this.func_28125_a(var4, 3, 39, false)) {
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
