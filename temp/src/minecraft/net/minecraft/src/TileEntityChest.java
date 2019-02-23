package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.TileEntity;

public class TileEntityChest extends TileEntity implements IInventory {

   private ItemStack[] field_827_a = new ItemStack[36];
   public boolean field_35155_a = false;
   public TileEntityChest field_35152_b;
   public TileEntityChest field_35153_c;
   public TileEntityChest field_35150_d;
   public TileEntityChest field_35151_e;
   public float field_35148_f;
   public float field_35149_g;
   public int field_35156_h;
   private int field_35154_q;


   public int func_469_c() {
      return 27;
   }

   public ItemStack func_468_c(int p_468_1_) {
      return this.field_827_a[p_468_1_];
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_827_a[p_473_1_] != null) {
         ItemStack var3;
         if(this.field_827_a[p_473_1_].field_1615_a <= p_473_2_) {
            var3 = this.field_827_a[p_473_1_];
            this.field_827_a[p_473_1_] = null;
            this.func_474_j_();
            return var3;
         } else {
            var3 = this.field_827_a[p_473_1_].func_1085_a(p_473_2_);
            if(this.field_827_a[p_473_1_].field_1615_a == 0) {
               this.field_827_a[p_473_1_] = null;
            }

            this.func_474_j_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_827_a[p_48081_1_] != null) {
         ItemStack var2 = this.field_827_a[p_48081_1_];
         this.field_827_a[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_827_a[p_472_1_] = p_472_2_;
      if(p_472_2_ != null && p_472_2_.field_1615_a > this.func_470_e()) {
         p_472_2_.field_1615_a = this.func_470_e();
      }

      this.func_474_j_();
   }

   public String func_471_d() {
      return "container.chest";
   }

   public void func_482_a(NBTTagCompound p_482_1_) {
      super.func_482_a(p_482_1_);
      NBTTagList var2 = p_482_1_.func_753_l("Items");
      this.field_827_a = new ItemStack[this.func_469_c()];

      for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
         NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
         int var5 = var4.func_746_c("Slot") & 255;
         if(var5 >= 0 && var5 < this.field_827_a.length) {
            this.field_827_a[var5] = ItemStack.func_35864_a(var4);
         }
      }

   }

   public void func_481_b(NBTTagCompound p_481_1_) {
      super.func_481_b(p_481_1_);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.field_827_a.length; ++var3) {
         if(this.field_827_a[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.func_761_a("Slot", (byte)var3);
            this.field_827_a[var3].func_1086_a(var4);
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

   public void func_35144_b() {
      super.func_35144_b();
      this.field_35155_a = false;
   }

   public void func_35147_g() {
      if(!this.field_35155_a) {
         this.field_35155_a = true;
         this.field_35152_b = null;
         this.field_35153_c = null;
         this.field_35150_d = null;
         this.field_35151_e = null;
         if(this.field_824_e.func_600_a(this.field_823_f - 1, this.field_822_g, this.field_821_h) == Block.field_396_av.field_376_bc) {
            this.field_35150_d = (TileEntityChest)this.field_824_e.func_603_b(this.field_823_f - 1, this.field_822_g, this.field_821_h);
         }

         if(this.field_824_e.func_600_a(this.field_823_f + 1, this.field_822_g, this.field_821_h) == Block.field_396_av.field_376_bc) {
            this.field_35153_c = (TileEntityChest)this.field_824_e.func_603_b(this.field_823_f + 1, this.field_822_g, this.field_821_h);
         }

         if(this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h - 1) == Block.field_396_av.field_376_bc) {
            this.field_35152_b = (TileEntityChest)this.field_824_e.func_603_b(this.field_823_f, this.field_822_g, this.field_821_h - 1);
         }

         if(this.field_824_e.func_600_a(this.field_823_f, this.field_822_g, this.field_821_h + 1) == Block.field_396_av.field_376_bc) {
            this.field_35151_e = (TileEntityChest)this.field_824_e.func_603_b(this.field_823_f, this.field_822_g, this.field_821_h + 1);
         }

         if(this.field_35152_b != null) {
            this.field_35152_b.func_35144_b();
         }

         if(this.field_35151_e != null) {
            this.field_35151_e.func_35144_b();
         }

         if(this.field_35153_c != null) {
            this.field_35153_c.func_35144_b();
         }

         if(this.field_35150_d != null) {
            this.field_35150_d.func_35144_b();
         }

      }
   }

   public void func_475_b() {
      super.func_475_b();
      this.func_35147_g();
      if(++this.field_35154_q % 20 * 4 == 0) {
         this.field_824_e.func_21116_c(this.field_823_f, this.field_822_g, this.field_821_h, 1, this.field_35156_h);
      }

      this.field_35149_g = this.field_35148_f;
      float var1 = 0.1F;
      double var4;
      if(this.field_35156_h > 0 && this.field_35148_f == 0.0F && this.field_35152_b == null && this.field_35150_d == null) {
         double var2 = (double)this.field_823_f + 0.5D;
         var4 = (double)this.field_821_h + 0.5D;
         if(this.field_35151_e != null) {
            var4 += 0.5D;
         }

         if(this.field_35153_c != null) {
            var2 += 0.5D;
         }

         this.field_824_e.func_684_a(var2, (double)this.field_822_g + 0.5D, var4, "random.chestopen", 0.5F, this.field_824_e.field_1037_n.nextFloat() * 0.1F + 0.9F);
      }

      if(this.field_35156_h == 0 && this.field_35148_f > 0.0F || this.field_35156_h > 0 && this.field_35148_f < 1.0F) {
         float var8 = this.field_35148_f;
         if(this.field_35156_h > 0) {
            this.field_35148_f += var1;
         } else {
            this.field_35148_f -= var1;
         }

         if(this.field_35148_f > 1.0F) {
            this.field_35148_f = 1.0F;
         }

         float var3 = 0.5F;
         if(this.field_35148_f < var3 && var8 >= var3 && this.field_35152_b == null && this.field_35150_d == null) {
            var4 = (double)this.field_823_f + 0.5D;
            double var6 = (double)this.field_821_h + 0.5D;
            if(this.field_35151_e != null) {
               var6 += 0.5D;
            }

            if(this.field_35153_c != null) {
               var4 += 0.5D;
            }

            this.field_824_e.func_684_a(var4, (double)this.field_822_g + 0.5D, var6, "random.chestclosed", 0.5F, this.field_824_e.field_1037_n.nextFloat() * 0.1F + 0.9F);
         }

         if(this.field_35148_f < 0.0F) {
            this.field_35148_f = 0.0F;
         }
      }

   }

   public void func_35143_b(int p_35143_1_, int p_35143_2_) {
      if(p_35143_1_ == 1) {
         this.field_35156_h = p_35143_2_;
      }

   }

   public void func_35142_x_() {
      ++this.field_35156_h;
      this.field_824_e.func_21116_c(this.field_823_f, this.field_822_g, this.field_821_h, 1, this.field_35156_h);
   }

   public void func_35141_y_() {
      --this.field_35156_h;
      this.field_824_e.func_21116_c(this.field_823_f, this.field_822_g, this.field_821_h, 1, this.field_35156_h);
   }

   public void func_31005_i() {
      this.func_35144_b();
      this.func_35147_g();
      super.func_31005_i();
   }
}
