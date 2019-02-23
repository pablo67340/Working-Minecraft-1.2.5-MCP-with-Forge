package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;

public class InventoryPlayer implements IInventory {

   public ItemStack[] field_843_a = new ItemStack[36];
   public ItemStack[] field_842_b = new ItemStack[4];
   public int field_847_d = 0;
   public EntityPlayer field_844_g;
   private ItemStack field_20077_f;
   public boolean field_845_f = false;


   public InventoryPlayer(EntityPlayer p_i740_1_) {
      this.field_844_g = p_i740_1_;
   }

   public ItemStack func_494_a() {
      return this.field_847_d < 9 && this.field_847_d >= 0?this.field_843_a[this.field_847_d]:null;
   }

   private int func_505_f(int p_505_1_) {
      for(int var2 = 0; var2 < this.field_843_a.length; ++var2) {
         if(this.field_843_a[var2] != null && this.field_843_a[var2].field_1617_c == p_505_1_) {
            return var2;
         }
      }

      return -1;
   }

   private int func_41021_b(int p_41021_1_, int p_41021_2_) {
      for(int var3 = 0; var3 < this.field_843_a.length; ++var3) {
         if(this.field_843_a[var3] != null && this.field_843_a[var3].field_1617_c == p_41021_1_ && this.field_843_a[var3].func_21181_i() == p_41021_2_) {
            return var3;
         }
      }

      return -1;
   }

   private int func_21105_c(ItemStack p_21105_1_) {
      for(int var2 = 0; var2 < this.field_843_a.length; ++var2) {
         if(this.field_843_a[var2] != null && this.field_843_a[var2].field_1617_c == p_21105_1_.field_1617_c && this.field_843_a[var2].func_21180_d() && this.field_843_a[var2].field_1615_a < this.field_843_a[var2].func_1089_c() && this.field_843_a[var2].field_1615_a < this.func_470_e() && (!this.field_843_a[var2].func_21183_f() || this.field_843_a[var2].func_21181_i() == p_21105_1_.func_21181_i()) && ItemStack.func_46154_a(this.field_843_a[var2], p_21105_1_)) {
            return var2;
         }
      }

      return -1;
   }

   private int func_499_j() {
      for(int var1 = 0; var1 < this.field_843_a.length; ++var1) {
         if(this.field_843_a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   public void func_496_a(int p_496_1_, int p_496_2_, boolean p_496_3_, boolean p_496_4_) {
      boolean var5 = true;
      int var7;
      if(p_496_3_) {
         var7 = this.func_41021_b(p_496_1_, p_496_2_);
      } else {
         var7 = this.func_505_f(p_496_1_);
      }

      if(var7 >= 0 && var7 < 9) {
         this.field_847_d = var7;
      } else {
         if(p_496_4_ && p_496_1_ > 0) {
            int var6 = this.func_499_j();
            if(var6 >= 0 && var6 < 9) {
               this.field_847_d = var6;
            }

            this.func_52006_a(Item.field_233_c[p_496_1_], p_496_2_);
         }

      }
   }

   public void func_498_a(int p_498_1_) {
      if(p_498_1_ > 0) {
         p_498_1_ = 1;
      }

      if(p_498_1_ < 0) {
         p_498_1_ = -1;
      }

      for(this.field_847_d -= p_498_1_; this.field_847_d < 0; this.field_847_d += 9) {
         ;
      }

      while(this.field_847_d >= 9) {
         this.field_847_d -= 9;
      }

   }

   public void func_52006_a(Item p_52006_1_, int p_52006_2_) {
      if(p_52006_1_ != null) {
         int var3 = this.func_41021_b(p_52006_1_.field_291_aS, p_52006_2_);
         if(var3 >= 0) {
            this.field_843_a[var3] = this.field_843_a[this.field_847_d];
         }

         this.field_843_a[this.field_847_d] = new ItemStack(Item.field_233_c[p_52006_1_.field_291_aS], 1, p_52006_2_);
      }

   }

   private int func_21106_d(ItemStack p_21106_1_) {
      int var2 = p_21106_1_.field_1617_c;
      int var3 = p_21106_1_.field_1615_a;
      int var4;
      if(p_21106_1_.func_1089_c() == 1) {
         var4 = this.func_499_j();
         if(var4 < 0) {
            return var3;
         } else {
            if(this.field_843_a[var4] == null) {
               this.field_843_a[var4] = ItemStack.func_30010_b(p_21106_1_);
            }

            return 0;
         }
      } else {
         var4 = this.func_21105_c(p_21106_1_);
         if(var4 < 0) {
            var4 = this.func_499_j();
         }

         if(var4 < 0) {
            return var3;
         } else {
            if(this.field_843_a[var4] == null) {
               this.field_843_a[var4] = new ItemStack(var2, 0, p_21106_1_.func_21181_i());
               if(p_21106_1_.func_40710_n()) {
                  this.field_843_a[var4].func_40706_d((NBTTagCompound)p_21106_1_.func_40709_o().func_40195_b());
               }
            }

            int var5 = var3;
            if(var3 > this.field_843_a[var4].func_1089_c() - this.field_843_a[var4].field_1615_a) {
               var5 = this.field_843_a[var4].func_1089_c() - this.field_843_a[var4].field_1615_a;
            }

            if(var5 > this.func_470_e() - this.field_843_a[var4].field_1615_a) {
               var5 = this.func_470_e() - this.field_843_a[var4].field_1615_a;
            }

            if(var5 == 0) {
               return var3;
            } else {
               var3 -= var5;
               this.field_843_a[var4].field_1615_a += var5;
               this.field_843_a[var4].field_1614_b = 5;
               return var3;
            }
         }
      }
   }

   public void func_511_b() {
      for(int var1 = 0; var1 < this.field_843_a.length; ++var1) {
         if(this.field_843_a[var1] != null) {
            this.field_843_a[var1].func_28153_a(this.field_844_g.field_615_ag, this.field_844_g, var1, this.field_847_d == var1);
         }
      }

   }

   public boolean func_510_b(int p_510_1_) {
      int var2 = this.func_505_f(p_510_1_);
      if(var2 < 0) {
         return false;
      } else {
         if(--this.field_843_a[var2].field_1615_a <= 0) {
            this.field_843_a[var2] = null;
         }

         return true;
      }
   }

   public boolean func_35157_d(int p_35157_1_) {
      int var2 = this.func_505_f(p_35157_1_);
      return var2 >= 0;
   }

   public boolean func_504_a(ItemStack p_504_1_) {
      int var2;
      if(p_504_1_.func_21185_g()) {
         var2 = this.func_499_j();
         if(var2 >= 0) {
            this.field_843_a[var2] = ItemStack.func_30010_b(p_504_1_);
            this.field_843_a[var2].field_1614_b = 5;
            p_504_1_.field_1615_a = 0;
            return true;
         } else if(this.field_844_g.field_35212_aW.field_35756_d) {
            p_504_1_.field_1615_a = 0;
            return true;
         } else {
            return false;
         }
      } else {
         do {
            var2 = p_504_1_.field_1615_a;
            p_504_1_.field_1615_a = this.func_21106_d(p_504_1_);
         } while(p_504_1_.field_1615_a > 0 && p_504_1_.field_1615_a < var2);

         if(p_504_1_.field_1615_a == var2 && this.field_844_g.field_35212_aW.field_35756_d) {
            p_504_1_.field_1615_a = 0;
            return true;
         } else {
            return p_504_1_.field_1615_a < var2;
         }
      }
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      ItemStack[] var3 = this.field_843_a;
      if(p_473_1_ >= this.field_843_a.length) {
         var3 = this.field_842_b;
         p_473_1_ -= this.field_843_a.length;
      }

      if(var3[p_473_1_] != null) {
         ItemStack var4;
         if(var3[p_473_1_].field_1615_a <= p_473_2_) {
            var4 = var3[p_473_1_];
            var3[p_473_1_] = null;
            return var4;
         } else {
            var4 = var3[p_473_1_].func_1085_a(p_473_2_);
            if(var3[p_473_1_].field_1615_a == 0) {
               var3[p_473_1_] = null;
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      ItemStack[] var2 = this.field_843_a;
      if(p_48081_1_ >= this.field_843_a.length) {
         var2 = this.field_842_b;
         p_48081_1_ -= this.field_843_a.length;
      }

      if(var2[p_48081_1_] != null) {
         ItemStack var3 = var2[p_48081_1_];
         var2[p_48081_1_] = null;
         return var3;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      ItemStack[] var3 = this.field_843_a;
      if(p_472_1_ >= var3.length) {
         p_472_1_ -= var3.length;
         var3 = this.field_842_b;
      }

      var3[p_472_1_] = p_472_2_;
   }

   public float func_508_a(Block p_508_1_) {
      float var2 = 1.0F;
      if(this.field_843_a[this.field_847_d] != null) {
         var2 *= this.field_843_a[this.field_847_d].func_1098_a(p_508_1_);
      }

      return var2;
   }

   public NBTTagList func_493_a(NBTTagList p_493_1_) {
      int var2;
      NBTTagCompound var3;
      for(var2 = 0; var2 < this.field_843_a.length; ++var2) {
         if(this.field_843_a[var2] != null) {
            var3 = new NBTTagCompound();
            var3.func_761_a("Slot", (byte)var2);
            this.field_843_a[var2].func_1086_a(var3);
            p_493_1_.func_742_a(var3);
         }
      }

      for(var2 = 0; var2 < this.field_842_b.length; ++var2) {
         if(this.field_842_b[var2] != null) {
            var3 = new NBTTagCompound();
            var3.func_761_a("Slot", (byte)(var2 + 100));
            this.field_842_b[var2].func_1086_a(var3);
            p_493_1_.func_742_a(var3);
         }
      }

      return p_493_1_;
   }

   public void func_513_b(NBTTagList p_513_1_) {
      this.field_843_a = new ItemStack[36];
      this.field_842_b = new ItemStack[4];

      for(int var2 = 0; var2 < p_513_1_.func_740_c(); ++var2) {
         NBTTagCompound var3 = (NBTTagCompound)p_513_1_.func_741_a(var2);
         int var4 = var3.func_746_c("Slot") & 255;
         ItemStack var5 = ItemStack.func_35864_a(var3);
         if(var5 != null) {
            if(var4 >= 0 && var4 < this.field_843_a.length) {
               this.field_843_a[var4] = var5;
            }

            if(var4 >= 100 && var4 < this.field_842_b.length + 100) {
               this.field_842_b[var4 - 100] = var5;
            }
         }
      }

   }

   public int func_469_c() {
      return this.field_843_a.length + 4;
   }

   public ItemStack func_468_c(int p_468_1_) {
      ItemStack[] var2 = this.field_843_a;
      if(p_468_1_ >= var2.length) {
         p_468_1_ -= var2.length;
         var2 = this.field_842_b;
      }

      return var2[p_468_1_];
   }

   public String func_471_d() {
      return "container.inventory";
   }

   public int func_470_e() {
      return 64;
   }

   public int func_502_a(Entity p_502_1_) {
      ItemStack var2 = this.func_468_c(this.field_847_d);
      return var2 != null?var2.func_1095_a(p_502_1_):1;
   }

   public boolean func_509_b(Block p_509_1_) {
      if(p_509_1_.field_356_bn.func_31061_i()) {
         return true;
      } else {
         ItemStack var2 = this.func_468_c(this.field_847_d);
         return var2 != null?var2.func_1099_b(p_509_1_):false;
      }
   }

   public ItemStack func_492_d(int p_492_1_) {
      return this.field_842_b[p_492_1_];
   }

   public int func_506_f() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.field_842_b.length; ++var2) {
         if(this.field_842_b[var2] != null && this.field_842_b[var2].func_1091_a() instanceof ItemArmor) {
            int var3 = ((ItemArmor)this.field_842_b[var2].func_1091_a()).field_312_aY;
            var1 += var3;
         }
      }

      return var1;
   }

   public void func_507_e(int p_507_1_) {
      p_507_1_ /= 4;
      if(p_507_1_ < 1) {
         p_507_1_ = 1;
      }

      for(int var2 = 0; var2 < this.field_842_b.length; ++var2) {
         if(this.field_842_b[var2] != null && this.field_842_b[var2].func_1091_a() instanceof ItemArmor) {
            this.field_842_b[var2].func_25190_a(p_507_1_, this.field_844_g);
            if(this.field_842_b[var2].field_1615_a == 0) {
               this.field_842_b[var2].func_1097_a(this.field_844_g);
               this.field_842_b[var2] = null;
            }
         }
      }

   }

   public void func_503_g() {
      int var1;
      for(var1 = 0; var1 < this.field_843_a.length; ++var1) {
         if(this.field_843_a[var1] != null) {
            this.field_844_g.func_48151_a(this.field_843_a[var1], true);
            this.field_843_a[var1] = null;
         }
      }

      for(var1 = 0; var1 < this.field_842_b.length; ++var1) {
         if(this.field_842_b[var1] != null) {
            this.field_844_g.func_48151_a(this.field_842_b[var1], true);
            this.field_842_b[var1] = null;
         }
      }

   }

   public void func_474_j_() {
      this.field_845_f = true;
   }

   public void func_20076_b(ItemStack p_20076_1_) {
      this.field_20077_f = p_20076_1_;
      this.field_844_g.func_20058_b(p_20076_1_);
   }

   public ItemStack func_20075_i() {
      return this.field_20077_f;
   }

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return this.field_844_g.field_646_aA?false:p_20070_1_.func_387_e(this.field_844_g) <= 64.0D;
   }

   public boolean func_28018_c(ItemStack p_28018_1_) {
      int var2;
      for(var2 = 0; var2 < this.field_842_b.length; ++var2) {
         if(this.field_842_b[var2] != null && this.field_842_b[var2].func_28154_b(p_28018_1_)) {
            return true;
         }
      }

      for(var2 = 0; var2 < this.field_843_a.length; ++var2) {
         if(this.field_843_a[var2] != null && this.field_843_a[var2].func_28154_b(p_28018_1_)) {
            return true;
         }
      }

      return false;
   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}

   public void func_41022_a(InventoryPlayer p_41022_1_) {
      int var2;
      for(var2 = 0; var2 < this.field_843_a.length; ++var2) {
         this.field_843_a[var2] = ItemStack.func_30010_b(p_41022_1_.field_843_a[var2]);
      }

      for(var2 = 0; var2 < this.field_842_b.length; ++var2) {
         this.field_842_b[var2] = ItemStack.func_30010_b(p_41022_1_.field_842_b[var2]);
      }

   }
}
