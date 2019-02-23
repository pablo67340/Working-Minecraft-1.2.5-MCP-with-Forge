package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Container;
import net.minecraft.src.EnchantmentData;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICrafting;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.SlotEnchantment;
import net.minecraft.src.SlotEnchantmentTable;
import net.minecraft.src.World;

public class ContainerEnchantment extends Container {

   public IInventory field_40236_a = new SlotEnchantmentTable(this, "Enchant", 1);
   private World field_40240_h;
   private int field_40241_i;
   private int field_40238_j;
   private int field_40239_k;
   private Random field_40237_l = new Random();
   public long field_40234_b;
   public int[] field_40235_c = new int[3];


   public ContainerEnchantment(InventoryPlayer p_i344_1_, World p_i344_2_, int p_i344_3_, int p_i344_4_, int p_i344_5_) {
      this.field_40240_h = p_i344_2_;
      this.field_40241_i = p_i344_3_;
      this.field_40238_j = p_i344_4_;
      this.field_40239_k = p_i344_5_;
      this.func_20117_a(new SlotEnchantment(this, this.field_40236_a, 0, 25, 47));

      int var6;
      for(var6 = 0; var6 < 3; ++var6) {
         for(int var7 = 0; var7 < 9; ++var7) {
            this.func_20117_a(new Slot(p_i344_1_, var7 + var6 * 9 + 9, 8 + var7 * 18, 84 + var6 * 18));
         }
      }

      for(var6 = 0; var6 < 9; ++var6) {
         this.func_20117_a(new Slot(p_i344_1_, var6, 8 + var6 * 18, 142));
      }

   }

   public void func_20114_a() {
      super.func_20114_a();

      for(int var1 = 0; var1 < this.field_20121_g.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.field_20121_g.get(var1);
         var2.func_20158_a(this, 0, this.field_40235_c[0]);
         var2.func_20158_a(this, 1, this.field_40235_c[1]);
         var2.func_20158_a(this, 2, this.field_40235_c[2]);
      }

   }

   public void func_20112_a(int p_20112_1_, int p_20112_2_) {
      if(p_20112_1_ >= 0 && p_20112_1_ <= 2) {
         this.field_40235_c[p_20112_1_] = p_20112_2_;
      } else {
         super.func_20112_a(p_20112_1_, p_20112_2_);
      }

   }

   public void func_1103_a(IInventory p_1103_1_) {
      if(p_1103_1_ == this.field_40236_a) {
         ItemStack var2 = p_1103_1_.func_468_c(0);
         int var3;
         if(var2 != null && var2.func_40708_t()) {
            this.field_40234_b = this.field_40237_l.nextLong();
            if(!this.field_40240_h.field_1026_y) {
               var3 = 0;

               int var4;
               for(var4 = -1; var4 <= 1; ++var4) {
                  for(int var5 = -1; var5 <= 1; ++var5) {
                     if((var4 != 0 || var5 != 0) && this.field_40240_h.func_20084_d(this.field_40241_i + var5, this.field_40238_j, this.field_40239_k + var4) && this.field_40240_h.func_20084_d(this.field_40241_i + var5, this.field_40238_j + 1, this.field_40239_k + var4)) {
                        if(this.field_40240_h.func_600_a(this.field_40241_i + var5 * 2, this.field_40238_j, this.field_40239_k + var4 * 2) == Block.field_407_ao.field_376_bc) {
                           ++var3;
                        }

                        if(this.field_40240_h.func_600_a(this.field_40241_i + var5 * 2, this.field_40238_j + 1, this.field_40239_k + var4 * 2) == Block.field_407_ao.field_376_bc) {
                           ++var3;
                        }

                        if(var5 != 0 && var4 != 0) {
                           if(this.field_40240_h.func_600_a(this.field_40241_i + var5 * 2, this.field_40238_j, this.field_40239_k + var4) == Block.field_407_ao.field_376_bc) {
                              ++var3;
                           }

                           if(this.field_40240_h.func_600_a(this.field_40241_i + var5 * 2, this.field_40238_j + 1, this.field_40239_k + var4) == Block.field_407_ao.field_376_bc) {
                              ++var3;
                           }

                           if(this.field_40240_h.func_600_a(this.field_40241_i + var5, this.field_40238_j, this.field_40239_k + var4 * 2) == Block.field_407_ao.field_376_bc) {
                              ++var3;
                           }

                           if(this.field_40240_h.func_600_a(this.field_40241_i + var5, this.field_40238_j + 1, this.field_40239_k + var4 * 2) == Block.field_407_ao.field_376_bc) {
                              ++var3;
                           }
                        }
                     }
                  }
               }

               for(var4 = 0; var4 < 3; ++var4) {
                  this.field_40235_c[var4] = EnchantmentHelper.func_40629_a(this.field_40237_l, var4, var3, var2);
               }

               this.func_20114_a();
            }
         } else {
            for(var3 = 0; var3 < 3; ++var3) {
               this.field_40235_c[var3] = 0;
            }
         }
      }

   }

   public boolean func_40233_a(EntityPlayer p_40233_1_, int p_40233_2_) {
      ItemStack var3 = this.field_40236_a.func_468_c(0);
      if(this.field_40235_c[p_40233_2_] > 0 && var3 != null && (p_40233_1_.field_35210_aY >= this.field_40235_c[p_40233_2_] || p_40233_1_.field_35212_aW.field_35756_d)) {
         if(!this.field_40240_h.field_1026_y) {
            List var4 = EnchantmentHelper.func_40644_a(this.field_40237_l, var3, this.field_40235_c[p_40233_2_]);
            if(var4 != null) {
               p_40233_1_.func_40184_i(this.field_40235_c[p_40233_2_]);
               Iterator var5 = var4.iterator();

               while(var5.hasNext()) {
                  EnchantmentData var6 = (EnchantmentData)var5.next();
                  var3.func_40705_a(var6.field_40264_a, var6.field_40263_b);
               }

               this.func_1103_a(this.field_40236_a);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_1104_a(EntityPlayer p_1104_1_) {
      super.func_1104_a(p_1104_1_);
      if(!this.field_40240_h.field_1026_y) {
         ItemStack var2 = this.field_40236_a.func_48081_b(0);
         if(var2 != null) {
            p_1104_1_.func_48153_a(var2);
         }

      }
   }

   public boolean func_20120_b(EntityPlayer p_20120_1_) {
      return this.field_40240_h.func_600_a(this.field_40241_i, this.field_40238_j, this.field_40239_k) != Block.field_40210_bF.field_376_bc?false:p_20120_1_.func_360_d((double)this.field_40241_i + 0.5D, (double)this.field_40238_j + 0.5D, (double)this.field_40239_k + 0.5D) <= 64.0D;
   }

   public ItemStack func_27279_a(int p_27279_1_) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.field_20122_e.get(p_27279_1_);
      if(var3 != null && var3.func_20005_c()) {
         ItemStack var4 = var3.func_777_b();
         var2 = var4.func_1102_e();
         if(p_27279_1_ != 0) {
            return null;
         }

         if(!this.func_28125_a(var4, 1, 37, true)) {
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
