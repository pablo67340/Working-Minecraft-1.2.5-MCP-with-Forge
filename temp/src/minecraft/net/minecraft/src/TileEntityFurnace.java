package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFurnace;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityFurnace extends TileEntity implements IInventory {

   private ItemStack[] field_833_a = new ItemStack[3];
   public int field_832_b = 0;
   public int field_835_c = 0;
   public int field_834_d = 0;


   public int func_469_c() {
      return this.field_833_a.length;
   }

   public ItemStack func_468_c(int p_468_1_) {
      return this.field_833_a[p_468_1_];
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_833_a[p_473_1_] != null) {
         ItemStack var3;
         if(this.field_833_a[p_473_1_].field_1615_a <= p_473_2_) {
            var3 = this.field_833_a[p_473_1_];
            this.field_833_a[p_473_1_] = null;
            return var3;
         } else {
            var3 = this.field_833_a[p_473_1_].func_1085_a(p_473_2_);
            if(this.field_833_a[p_473_1_].field_1615_a == 0) {
               this.field_833_a[p_473_1_] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_833_a[p_48081_1_] != null) {
         ItemStack var2 = this.field_833_a[p_48081_1_];
         this.field_833_a[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_833_a[p_472_1_] = p_472_2_;
      if(p_472_2_ != null && p_472_2_.field_1615_a > this.func_470_e()) {
         p_472_2_.field_1615_a = this.func_470_e();
      }

   }

   public String func_471_d() {
      return "container.furnace";
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      NBTTagList var2 = p_482_1_.func_753_l("Items");
      this.field_833_a = new ItemStack[this.func_469_c()];

      for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
         byte var5 = var4.func_746_c("Slot");
         if(var5 >= 0 && var5 < this.field_833_a.length) {
            this.field_833_a[var5] = ItemStack.func_35864_a(var4);
         }
      }

      this.field_832_b = p_482_1_.func_745_d("BurnTime");
      this.field_834_d = p_482_1_.func_745_d("CookTime");
      this.field_835_c = func_488_a(this.field_833_a[1]);
   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      p_481_1_.func_749_a("BurnTime", (short)this.field_832_b);
      p_481_1_.func_749_a("CookTime", (short)this.field_834_d);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_833_a.length; ++var3) {
         if(this.field_833_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_761_a("Slot", (byte)var3);
            this.field_833_a[var3].func_1086_a(var4);
            var2.func_742_a(var4);
         }
      }

      p_481_1_.func_762_a("Items", var2);
   }

   public int func_470_e() {
      return 64;
   }

   public int func_490_a(int p_490_1_) {
      return this.field_834_d * p_490_1_ / 200;
   }

   public int func_489_b(int p_489_1_) {
      if(this.field_835_c == 0) {
         this.field_835_c = 200;
      }

      return this.field_832_b * p_489_1_ / this.field_835_c;
   }

   public boolean func_485_a() {
      return this.field_832_b > 0;
   }

   public void func_475_b() {
      boolean var1 = this.field_832_b > 0;
      boolean var2 = false;
      if(this.field_832_b > 0) {
         --this.field_832_b;
      }

      if(!this.field_824_e.field_1026_y) {
         if(this.field_832_b == 0 && this.func_491_j()) {
            this.field_835_c = this.field_832_b = func_488_a(this.field_833_a[1]);
            if(this.field_832_b > 0) {
               var2 = true;
               if(this.field_833_a[1] != null) {
                  --this.field_833_a[1].field_1615_a;
                  if(this.field_833_a[1].field_1615_a == 0) {
                     this.field_833_a[1] = null;
                  }
               }
            }
         }

         if(this.func_485_a() && this.func_491_j()) {
            ++this.field_834_d;
            if(this.field_834_d == 200) {
               this.field_834_d = 0;
               this.func_487_i();
               var2 = true;
            }
         } else {
            this.field_834_d = 0;
         }

         if(var1 != this.field_832_b > 0) {
            var2 = true;
            BlockFurnace.func_285_a(this.field_832_b > 0, this.field_824_e, this.field_823_f, this.field_822_g, this.field_821_h);
         }
      }

      if(var2) {
         this.func_474_j_();
      }

   }

   private boolean func_491_j() {
      if(this.field_833_a[0] == null) {
         return false;
      } else {
         ItemStack var1 = FurnaceRecipes.func_21200_a().func_21198_a(this.field_833_a[0].func_1091_a().field_291_aS);
         return var1 == null?false:(this.field_833_a[2] == null?true:(!this.field_833_a[2].func_21184_a(var1)?false:(this.field_833_a[2].field_1615_a < this.func_470_e() && this.field_833_a[2].field_1615_a < this.field_833_a[2].func_1089_c()?true:this.field_833_a[2].field_1615_a < var1.func_1089_c())));
      }
   }

   public void func_487_i() {
      if(this.func_491_j()) {
         ItemStack var1 = FurnaceRecipes.func_21200_a().func_21198_a(this.field_833_a[0].func_1091_a().field_291_aS);
         if(this.field_833_a[2] == null) {
            this.field_833_a[2] = var1.func_1102_e();
         } else if(this.field_833_a[2].field_1617_c == var1.field_1617_c) {
            ++this.field_833_a[2].field_1615_a;
         }

         --this.field_833_a[0].field_1615_a;
         if(this.field_833_a[0].field_1615_a <= 0) {
            this.field_833_a[0] = null;
         }

      }
   }

   public static int func_488_a(ItemStack p_488_1_) {
      if(p_488_1_ == null) {
         return 0;
      } else {
         int var1 = p_488_1_.func_1091_a().field_291_aS;
         return var1 < 256 && Block.field_345_n[var1].field_356_bn == Material.field_1335_c?300:(var1 == Item.field_266_B.field_291_aS?100:(var1 == Item.field_225_k.field_291_aS?1600:(var1 == Item.field_258_aw.field_291_aS?20000:(var1 == Block.field_333_z.field_376_bc?100:(var1 == Item.field_40417_bo.field_291_aS?2400:0)))));
      }
   }

   public static boolean func_52005_b(ItemStack p_52005_0_) {
      return func_488_a(p_52005_0_) > 0;
   }

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return this.field_824_e.func_603_b(this.field_823_f, this.field_822_g, this.field_821_h) != this?false:p_20070_1_.func_360_d((double)this.field_823_f + 0.5D, (double)this.field_822_g + 0.5D, (double)this.field_821_h + 0.5D) <= 64.0D;
   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}
}
