package net.minecraft.src;

import java.util.List;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.TileEntity;

public class TileEntityBrewingStand extends TileEntity implements IInventory {

   private ItemStack[] field_40058_a = new ItemStack[4];
   private int field_40056_b;
   private int field_40057_c;
   private int field_40055_d;


   public String func_471_d() {
      return "container.brewing";
   }

   public int func_469_c() {
      return this.field_40058_a.length;
   }

   public void func_475_b() {
      if(this.field_40056_b > 0) {
         --this.field_40056_b;
         if(this.field_40056_b == 0) {
            this.func_40052_p();
            this.func_474_j_();
         } else if(!this.func_40050_o()) {
            this.field_40056_b = 0;
            this.func_474_j_();
         } else if(this.field_40055_d != this.field_40058_a[3].field_1617_c) {
            this.field_40056_b = 0;
            this.func_474_j_();
         }
      } else if(this.func_40050_o()) {
         this.field_40056_b = 400;
         this.field_40055_d = this.field_40058_a[3].field_1617_c;
      }

      int var1 = this.func_40054_n();
      if(var1 != this.field_40057_c) {
         this.field_40057_c = var1;
         this.field_824_e.func_691_b(this.field_823_f, this.field_822_g, this.field_821_h, var1);
      }

      super.func_475_b();
   }

   public int func_40053_g() {
      return this.field_40056_b;
   }

   private boolean func_40050_o() {
      if(this.field_40058_a[3] != null && this.field_40058_a[3].field_1615_a > 0) {
         ItemStack var1 = this.field_40058_a[3];
         if(!Item.field_233_c[var1.field_1617_c].func_40406_n()) {
            return false;
         } else {
            boolean var2 = false;

            for(int var3 = 0; var3 < 3; ++var3) {
               if(this.field_40058_a[var3] != null && this.field_40058_a[var3].field_1617_c == Item.field_40413_bs.field_291_aS) {
                  int var4 = this.field_40058_a[var3].func_21181_i();
                  int var5 = this.func_40051_b(var4, var1);
                  if(!ItemPotion.func_40433_c(var4) && ItemPotion.func_40433_c(var5)) {
                     var2 = true;
                     break;
                  }

                  List var6 = Item.field_40413_bs.func_40431_c_(var4);
                  List var7 = Item.field_40413_bs.func_40431_c_(var5);
                  if((var4 <= 0 || var6 != var7) && (var6 == null || !var6.equals(var7) && var7 != null) && var4 != var5) {
                     var2 = true;
                     break;
                  }
               }
            }

            return var2;
         }
      } else {
         return false;
      }
   }

   private void func_40052_p() {
      if(this.func_40050_o()) {
         ItemStack var1 = this.field_40058_a[3];

         for(int var2 = 0; var2 < 3; ++var2) {
            if(this.field_40058_a[var2] != null && this.field_40058_a[var2].field_1617_c == Item.field_40413_bs.field_291_aS) {
               int var3 = this.field_40058_a[var2].func_21181_i();
               int var4 = this.func_40051_b(var3, var1);
               List var5 = Item.field_40413_bs.func_40431_c_(var3);
               List var6 = Item.field_40413_bs.func_40431_c_(var4);
               if((var3 <= 0 || var5 != var6) && (var5 == null || !var5.equals(var6) && var6 != null)) {
                  if(var3 != var4) {
                     this.field_40058_a[var2].func_28156_b(var4);
                  }
               } else if(!ItemPotion.func_40433_c(var3) && ItemPotion.func_40433_c(var4)) {
                  this.field_40058_a[var2].func_28156_b(var4);
               }
            }
         }

         if(Item.field_233_c[var1.field_1617_c].func_21014_i()) {
            this.field_40058_a[3] = new ItemStack(Item.field_233_c[var1.field_1617_c].func_21016_h());
         } else {
            --this.field_40058_a[3].field_1615_a;
            if(this.field_40058_a[3].field_1615_a <= 0) {
               this.field_40058_a[3] = null;
            }
         }

      }
   }

   private int func_40051_b(int p_40051_1_, ItemStack p_40051_2_) {
      return p_40051_2_ == null?p_40051_1_:(Item.field_233_c[p_40051_2_.field_1617_c].func_40406_n()?PotionHelper.func_40356_a(p_40051_1_, Item.field_233_c[p_40051_2_.field_1617_c].func_40405_m()):p_40051_1_);
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      NBTTagList var2 = p_482_1_.func_753_l("Items");
      this.field_40058_a = new ItemStack[this.func_469_c()];

      for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
         byte var5 = var4.func_746_c("Slot");
         if(var5 >= 0 && var5 < this.field_40058_a.length) {
            this.field_40058_a[var5] = ItemStack.func_35864_a(var4);
         }
      }

      this.field_40056_b = p_482_1_.func_745_d("BrewTime");
   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      p_481_1_.func_749_a("BrewTime", (short)this.field_40056_b);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_40058_a.length; ++var3) {
         if(this.field_40058_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_761_a("Slot", (byte)var3);
            this.field_40058_a[var3].func_1086_a(var4);
            var2.func_742_a(var4);
         }
      }

      p_481_1_.func_762_a("Items", var2);
   }

   public ItemStack func_468_c(int p_468_1_) {
      return p_468_1_ >= 0 && p_468_1_ < this.field_40058_a.length?this.field_40058_a[p_468_1_]:null;
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(p_473_1_ >= 0 && p_473_1_ < this.field_40058_a.length) {
         ItemStack var3 = this.field_40058_a[p_473_1_];
         this.field_40058_a[p_473_1_] = null;
         return var3;
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(p_48081_1_ >= 0 && p_48081_1_ < this.field_40058_a.length) {
         ItemStack var2 = this.field_40058_a[p_48081_1_];
         this.field_40058_a[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      if(p_472_1_ >= 0 && p_472_1_ < this.field_40058_a.length) {
         this.field_40058_a[p_472_1_] = p_472_2_;
      }

   }

   public int func_470_e() {
      return 1;
   }

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return this.field_824_e.func_603_b(this.field_823_f, this.field_822_g, this.field_821_h) != this?false:p_20070_1_.func_360_d((double)this.field_823_f + 0.5D, (double)this.field_822_g + 0.5D, (double)this.field_821_h + 0.5D) <= 64.0D;
   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}

   public void func_40049_b(int p_40049_1_) {
      this.field_40056_b = p_40049_1_;
   }

   public int func_40054_n() {
      int var1 = 0;

      for(int var2 = 0; var2 < 3; ++var2) {
         if(this.field_40058_a[var2] != null) {
            var1 |= 1 << var2;
         }
      }

      return var1;
   }
}
