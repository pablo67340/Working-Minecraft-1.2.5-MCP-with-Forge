package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityDispenser extends TileEntity implements IInventory {

   private ItemStack[] field_21102_a = new ItemStack[9];
   private Random field_21101_b = new Random();


   public int func_469_c() {
      return 9;
   }

   public ItemStack func_468_c(int p_468_1_) {
      return this.field_21102_a[p_468_1_];
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_21102_a[p_473_1_] != null) {
         ItemStack var3;
         if(this.field_21102_a[p_473_1_].field_1615_a <= p_473_2_) {
            var3 = this.field_21102_a[p_473_1_];
            this.field_21102_a[p_473_1_] = null;
            this.func_474_j_();
            return var3;
         } else {
            var3 = this.field_21102_a[p_473_1_].func_1085_a(p_473_2_);
            if(this.field_21102_a[p_473_1_].field_1615_a == 0) {
               this.field_21102_a[p_473_1_] = null;
            }

            this.func_474_j_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_21102_a[p_48081_1_] != null) {
         ItemStack var2 = this.field_21102_a[p_48081_1_];
         this.field_21102_a[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public ItemStack func_21100_b() {
      int var1 = -1;
      int var2 = 1;

      for(int var3 = 0; var3 < this.field_21102_a.length; ++var3) {
         if(this.field_21102_a[var3] != null && this.field_21101_b.nextInt(var2++) == 0) {
            var1 = var3;
         }
      }

      if(var1 >= 0) {
         return this.func_473_a(var1, 1);
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_21102_a[p_472_1_] = p_472_2_;
      if(p_472_2_ != null && p_472_2_.field_1615_a > this.func_470_e()) {
         p_472_2_.field_1615_a = this.func_470_e();
      }

      this.func_474_j_();
   }

   public String func_471_d() {
      return "container.dispenser";
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      NBTTagList var2 = p_482_1_.func_753_l("Items");
      this.field_21102_a = new ItemStack[this.func_469_c()];

      for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
         int var5 = var4.func_746_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_21102_a.length) {
            this.field_21102_a[var5] = ItemStack.func_35864_a(var4);
         }
      }

   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_21102_a.length; ++var3) {
         if(this.field_21102_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_761_a("Slot", (byte)var3);
            this.field_21102_a[var3].func_1086_a(var4);
            var2.func_742_a(var4);
         }
      }

      p_481_1_.func_762_a("Items", var2);
   }

   public int func_470_e() {
      return 64;
   }

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return this.field_824_e.func_603_b(this.field_823_f, this.field_822_g, this.field_821_h) != this?false:p_20070_1_.func_360_d((double)this.field_823_f + 0.5D, (double)this.field_822_g + 0.5D, (double)this.field_821_h + 0.5D) <= 64.0D;
   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}
}
