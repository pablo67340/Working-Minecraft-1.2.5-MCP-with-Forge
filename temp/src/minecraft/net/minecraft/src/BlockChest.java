package net.minecraft.src;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.IInventory;
import net.minecraft.src.InventoryLargeChest;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.World;

public class BlockChest extends BlockContainer {

   private Random field_457_a = new Random();


   protected BlockChest(int p_i595_1_) {
      super(p_i595_1_, Material.field_1335_c);
      this.field_378_bb = 26;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 22;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      this.func_35306_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      int var5 = p_235_1_.func_600_a(p_235_2_, p_235_3_, p_235_4_ - 1);
      int var6 = p_235_1_.func_600_a(p_235_2_, p_235_3_, p_235_4_ + 1);
      int var7 = p_235_1_.func_600_a(p_235_2_ - 1, p_235_3_, p_235_4_);
      int var8 = p_235_1_.func_600_a(p_235_2_ + 1, p_235_3_, p_235_4_);
      if(var5 == this.field_376_bc) {
         this.func_35306_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_ - 1);
      }

      if(var6 == this.field_376_bc) {
         this.func_35306_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_ + 1);
      }

      if(var7 == this.field_376_bc) {
         this.func_35306_h(p_235_1_, p_235_2_ - 1, p_235_3_, p_235_4_);
      }

      if(var8 == this.field_376_bc) {
         this.func_35306_h(p_235_1_, p_235_2_ + 1, p_235_3_, p_235_4_);
      }

   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = p_4026_1_.func_600_a(p_4026_2_, p_4026_3_, p_4026_4_ - 1);
      int var7 = p_4026_1_.func_600_a(p_4026_2_, p_4026_3_, p_4026_4_ + 1);
      int var8 = p_4026_1_.func_600_a(p_4026_2_ - 1, p_4026_3_, p_4026_4_);
      int var9 = p_4026_1_.func_600_a(p_4026_2_ + 1, p_4026_3_, p_4026_4_);
      byte var10 = 0;
      int var11 = MathHelper.func_1108_b((double)(p_4026_5_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
      if(var11 == 0) {
         var10 = 2;
      }

      if(var11 == 1) {
         var10 = 5;
      }

      if(var11 == 2) {
         var10 = 3;
      }

      if(var11 == 3) {
         var10 = 4;
      }

      if(var6 != this.field_376_bc && var7 != this.field_376_bc && var8 != this.field_376_bc && var9 != this.field_376_bc) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var10);
      } else {
         if((var6 == this.field_376_bc || var7 == this.field_376_bc) && (var10 == 4 || var10 == 5)) {
            if(var6 == this.field_376_bc) {
               p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_ - 1, var10);
            } else {
               p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_ + 1, var10);
            }

            p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var10);
         }

         if((var8 == this.field_376_bc || var9 == this.field_376_bc) && (var10 == 2 || var10 == 3)) {
            if(var8 == this.field_376_bc) {
               p_4026_1_.func_691_b(p_4026_2_ - 1, p_4026_3_, p_4026_4_, var10);
            } else {
               p_4026_1_.func_691_b(p_4026_2_ + 1, p_4026_3_, p_4026_4_, var10);
            }

            p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var10);
         }
      }

   }

   public void func_35306_h(World p_35306_1_, int p_35306_2_, int p_35306_3_, int p_35306_4_) {
      if(!p_35306_1_.field_1026_y) {
         int var5 = p_35306_1_.func_600_a(p_35306_2_, p_35306_3_, p_35306_4_ - 1);
         int var6 = p_35306_1_.func_600_a(p_35306_2_, p_35306_3_, p_35306_4_ + 1);
         int var7 = p_35306_1_.func_600_a(p_35306_2_ - 1, p_35306_3_, p_35306_4_);
         int var8 = p_35306_1_.func_600_a(p_35306_2_ + 1, p_35306_3_, p_35306_4_);
         boolean var9 = true;
         int var10;
         int var11;
         boolean var12;
         byte var13;
         int var14;
         if(var5 != this.field_376_bc && var6 != this.field_376_bc) {
            if(var7 != this.field_376_bc && var8 != this.field_376_bc) {
               var13 = 3;
               if(Block.field_343_p[var5] && !Block.field_343_p[var6]) {
                  var13 = 3;
               }

               if(Block.field_343_p[var6] && !Block.field_343_p[var5]) {
                  var13 = 2;
               }

               if(Block.field_343_p[var7] && !Block.field_343_p[var8]) {
                  var13 = 5;
               }

               if(Block.field_343_p[var8] && !Block.field_343_p[var7]) {
                  var13 = 4;
               }
            } else {
               var10 = p_35306_1_.func_600_a(var7 == this.field_376_bc?p_35306_2_ - 1:p_35306_2_ + 1, p_35306_3_, p_35306_4_ - 1);
               var11 = p_35306_1_.func_600_a(var7 == this.field_376_bc?p_35306_2_ - 1:p_35306_2_ + 1, p_35306_3_, p_35306_4_ + 1);
               var13 = 3;
               var12 = true;
               if(var7 == this.field_376_bc) {
                  var14 = p_35306_1_.func_602_e(p_35306_2_ - 1, p_35306_3_, p_35306_4_);
               } else {
                  var14 = p_35306_1_.func_602_e(p_35306_2_ + 1, p_35306_3_, p_35306_4_);
               }

               if(var14 == 2) {
                  var13 = 2;
               }

               if((Block.field_343_p[var5] || Block.field_343_p[var10]) && !Block.field_343_p[var6] && !Block.field_343_p[var11]) {
                  var13 = 3;
               }

               if((Block.field_343_p[var6] || Block.field_343_p[var11]) && !Block.field_343_p[var5] && !Block.field_343_p[var10]) {
                  var13 = 2;
               }
            }
         } else {
            var10 = p_35306_1_.func_600_a(p_35306_2_ - 1, p_35306_3_, var5 == this.field_376_bc?p_35306_4_ - 1:p_35306_4_ + 1);
            var11 = p_35306_1_.func_600_a(p_35306_2_ + 1, p_35306_3_, var5 == this.field_376_bc?p_35306_4_ - 1:p_35306_4_ + 1);
            var13 = 5;
            var12 = true;
            if(var5 == this.field_376_bc) {
               var14 = p_35306_1_.func_602_e(p_35306_2_, p_35306_3_, p_35306_4_ - 1);
            } else {
               var14 = p_35306_1_.func_602_e(p_35306_2_, p_35306_3_, p_35306_4_ + 1);
            }

            if(var14 == 4) {
               var13 = 4;
            }

            if((Block.field_343_p[var7] || Block.field_343_p[var10]) && !Block.field_343_p[var8] && !Block.field_343_p[var11]) {
               var13 = 5;
            }

            if((Block.field_343_p[var8] || Block.field_343_p[var11]) && !Block.field_343_p[var7] && !Block.field_343_p[var10]) {
               var13 = 4;
            }
         }

         p_35306_1_.func_691_b(p_35306_2_, p_35306_3_, p_35306_4_, var13);
      }
   }

   public int func_211_a(IBlockAccess p_211_1_, int p_211_2_, int p_211_3_, int p_211_4_, int p_211_5_) {
      if(p_211_5_ == 1) {
         return this.field_378_bb - 1;
      } else if(p_211_5_ == 0) {
         return this.field_378_bb - 1;
      } else {
         int var6 = p_211_1_.func_600_a(p_211_2_, p_211_3_, p_211_4_ - 1);
         int var7 = p_211_1_.func_600_a(p_211_2_, p_211_3_, p_211_4_ + 1);
         int var8 = p_211_1_.func_600_a(p_211_2_ - 1, p_211_3_, p_211_4_);
         int var9 = p_211_1_.func_600_a(p_211_2_ + 1, p_211_3_, p_211_4_);
         int var10;
         int var11;
         int var12;
         byte var13;
         if(var6 != this.field_376_bc && var7 != this.field_376_bc) {
            if(var8 != this.field_376_bc && var9 != this.field_376_bc) {
               byte var14 = 3;
               if(Block.field_343_p[var6] && !Block.field_343_p[var7]) {
                  var14 = 3;
               }

               if(Block.field_343_p[var7] && !Block.field_343_p[var6]) {
                  var14 = 2;
               }

               if(Block.field_343_p[var8] && !Block.field_343_p[var9]) {
                  var14 = 5;
               }

               if(Block.field_343_p[var9] && !Block.field_343_p[var8]) {
                  var14 = 4;
               }

               return p_211_5_ == var14?this.field_378_bb + 1:this.field_378_bb;
            } else if(p_211_5_ != 4 && p_211_5_ != 5) {
               var10 = 0;
               if(var8 == this.field_376_bc) {
                  var10 = -1;
               }

               var11 = p_211_1_.func_600_a(var8 == this.field_376_bc?p_211_2_ - 1:p_211_2_ + 1, p_211_3_, p_211_4_ - 1);
               var12 = p_211_1_.func_600_a(var8 == this.field_376_bc?p_211_2_ - 1:p_211_2_ + 1, p_211_3_, p_211_4_ + 1);
               if(p_211_5_ == 3) {
                  var10 = -1 - var10;
               }

               var13 = 3;
               if((Block.field_343_p[var6] || Block.field_343_p[var11]) && !Block.field_343_p[var7] && !Block.field_343_p[var12]) {
                  var13 = 3;
               }

               if((Block.field_343_p[var7] || Block.field_343_p[var12]) && !Block.field_343_p[var6] && !Block.field_343_p[var11]) {
                  var13 = 2;
               }

               return (p_211_5_ == var13?this.field_378_bb + 16:this.field_378_bb + 32) + var10;
            } else {
               return this.field_378_bb;
            }
         } else if(p_211_5_ != 2 && p_211_5_ != 3) {
            var10 = 0;
            if(var6 == this.field_376_bc) {
               var10 = -1;
            }

            var11 = p_211_1_.func_600_a(p_211_2_ - 1, p_211_3_, var6 == this.field_376_bc?p_211_4_ - 1:p_211_4_ + 1);
            var12 = p_211_1_.func_600_a(p_211_2_ + 1, p_211_3_, var6 == this.field_376_bc?p_211_4_ - 1:p_211_4_ + 1);
            if(p_211_5_ == 4) {
               var10 = -1 - var10;
            }

            var13 = 5;
            if((Block.field_343_p[var8] || Block.field_343_p[var11]) && !Block.field_343_p[var9] && !Block.field_343_p[var12]) {
               var13 = 5;
            }

            if((Block.field_343_p[var9] || Block.field_343_p[var12]) && !Block.field_343_p[var8] && !Block.field_343_p[var11]) {
               var13 = 4;
            }

            return (p_211_5_ == var13?this.field_378_bb + 16:this.field_378_bb + 32) + var10;
         } else {
            return this.field_378_bb;
         }
      }
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb - 1:(p_218_1_ == 0?this.field_378_bb - 1:(p_218_1_ == 3?this.field_378_bb + 1:this.field_378_bb));
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      int var5 = 0;
      if(p_243_1_.func_600_a(p_243_2_ - 1, p_243_3_, p_243_4_) == this.field_376_bc) {
         ++var5;
      }

      if(p_243_1_.func_600_a(p_243_2_ + 1, p_243_3_, p_243_4_) == this.field_376_bc) {
         ++var5;
      }

      if(p_243_1_.func_600_a(p_243_2_, p_243_3_, p_243_4_ - 1) == this.field_376_bc) {
         ++var5;
      }

      if(p_243_1_.func_600_a(p_243_2_, p_243_3_, p_243_4_ + 1) == this.field_376_bc) {
         ++var5;
      }

      return var5 > 1?false:(this.func_286_h(p_243_1_, p_243_2_ - 1, p_243_3_, p_243_4_)?false:(this.func_286_h(p_243_1_, p_243_2_ + 1, p_243_3_, p_243_4_)?false:(this.func_286_h(p_243_1_, p_243_2_, p_243_3_, p_243_4_ - 1)?false:!this.func_286_h(p_243_1_, p_243_2_, p_243_3_, p_243_4_ + 1))));
   }

   private boolean func_286_h(World p_286_1_, int p_286_2_, int p_286_3_, int p_286_4_) {
      return p_286_1_.func_600_a(p_286_2_, p_286_3_, p_286_4_) != this.field_376_bc?false:(p_286_1_.func_600_a(p_286_2_ - 1, p_286_3_, p_286_4_) == this.field_376_bc?true:(p_286_1_.func_600_a(p_286_2_ + 1, p_286_3_, p_286_4_) == this.field_376_bc?true:(p_286_1_.func_600_a(p_286_2_, p_286_3_, p_286_4_ - 1) == this.field_376_bc?true:p_286_1_.func_600_a(p_286_2_, p_286_3_, p_286_4_ + 1) == this.field_376_bc)));
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
      TileEntityChest var6 = (TileEntityChest)p_226_1_.func_603_b(p_226_2_, p_226_3_, p_226_4_);
      if(var6 != null) {
         var6.func_35144_b();
      }

   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      TileEntityChest var5 = (TileEntityChest)p_214_1_.func_603_b(p_214_2_, p_214_3_, p_214_4_);
      if(var5 != null) {
         for(int var6 = 0; var6 < var5.func_469_c(); ++var6) {
            ItemStack var7 = var5.func_468_c(var6);
            if(var7 != null) {
               float var8 = this.field_457_a.nextFloat() * 0.8F + 0.1F;
               float var9 = this.field_457_a.nextFloat() * 0.8F + 0.1F;

               EntityItem var12;
               for(float var10 = this.field_457_a.nextFloat() * 0.8F + 0.1F; var7.field_1615_a > 0; p_214_1_.func_674_a(var12)) {
                  int var11 = this.field_457_a.nextInt(21) + 10;
                  if(var11 > var7.field_1615_a) {
                     var11 = var7.field_1615_a;
                  }

                  var7.field_1615_a -= var11;
                  var12 = new EntityItem(p_214_1_, (double)((float)p_214_2_ + var8), (double)((float)p_214_3_ + var9), (double)((float)p_214_4_ + var10), new ItemStack(var7.field_1617_c, var11, var7.func_21181_i()));
                  float var13 = 0.05F;
                  var12.field_608_an = (double)((float)this.field_457_a.nextGaussian() * var13);
                  var12.field_607_ao = (double)((float)this.field_457_a.nextGaussian() * var13 + 0.2F);
                  var12.field_606_ap = (double)((float)this.field_457_a.nextGaussian() * var13);
                  if(var7.func_40710_n()) {
                     var12.field_801_a.func_40706_d((NBTTagCompound)var7.func_40709_o().func_40195_b());
                  }
               }
            }
         }
      }

      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      Object var6 = (TileEntityChest)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_);
      if(var6 == null) {
         return true;
      } else if(p_250_1_.func_28100_h(p_250_2_, p_250_3_ + 1, p_250_4_)) {
         return true;
      } else if(func_50075_j(p_250_1_, p_250_2_, p_250_3_, p_250_4_)) {
         return true;
      } else if(p_250_1_.func_600_a(p_250_2_ - 1, p_250_3_, p_250_4_) == this.field_376_bc && (p_250_1_.func_28100_h(p_250_2_ - 1, p_250_3_ + 1, p_250_4_) || func_50075_j(p_250_1_, p_250_2_ - 1, p_250_3_, p_250_4_))) {
         return true;
      } else if(p_250_1_.func_600_a(p_250_2_ + 1, p_250_3_, p_250_4_) == this.field_376_bc && (p_250_1_.func_28100_h(p_250_2_ + 1, p_250_3_ + 1, p_250_4_) || func_50075_j(p_250_1_, p_250_2_ + 1, p_250_3_, p_250_4_))) {
         return true;
      } else if(p_250_1_.func_600_a(p_250_2_, p_250_3_, p_250_4_ - 1) == this.field_376_bc && (p_250_1_.func_28100_h(p_250_2_, p_250_3_ + 1, p_250_4_ - 1) || func_50075_j(p_250_1_, p_250_2_, p_250_3_, p_250_4_ - 1))) {
         return true;
      } else if(p_250_1_.func_600_a(p_250_2_, p_250_3_, p_250_4_ + 1) == this.field_376_bc && (p_250_1_.func_28100_h(p_250_2_, p_250_3_ + 1, p_250_4_ + 1) || func_50075_j(p_250_1_, p_250_2_, p_250_3_, p_250_4_ + 1))) {
         return true;
      } else {
         if(p_250_1_.func_600_a(p_250_2_ - 1, p_250_3_, p_250_4_) == this.field_376_bc) {
            var6 = new InventoryLargeChest("Large chest", (TileEntityChest)p_250_1_.func_603_b(p_250_2_ - 1, p_250_3_, p_250_4_), (IInventory)var6);
         }

         if(p_250_1_.func_600_a(p_250_2_ + 1, p_250_3_, p_250_4_) == this.field_376_bc) {
            var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)p_250_1_.func_603_b(p_250_2_ + 1, p_250_3_, p_250_4_));
         }

         if(p_250_1_.func_600_a(p_250_2_, p_250_3_, p_250_4_ - 1) == this.field_376_bc) {
            var6 = new InventoryLargeChest("Large chest", (TileEntityChest)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_ - 1), (IInventory)var6);
         }

         if(p_250_1_.func_600_a(p_250_2_, p_250_3_, p_250_4_ + 1) == this.field_376_bc) {
            var6 = new InventoryLargeChest("Large chest", (IInventory)var6, (TileEntityChest)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_ + 1));
         }

         if(p_250_1_.field_1026_y) {
            return true;
         } else {
            p_250_5_.func_452_a((IInventory)var6);
            return true;
         }
      }
   }

   public TileEntity func_283_a_() {
      return new TileEntityChest();
   }

   private static boolean func_50075_j(World p_50075_0_, int p_50075_1_, int p_50075_2_, int p_50075_3_) {
      Iterator var4 = p_50075_0_.func_657_a(EntityOcelot.class, AxisAlignedBB.func_1161_b((double)p_50075_1_, (double)(p_50075_2_ + 1), (double)p_50075_3_, (double)(p_50075_1_ + 1), (double)(p_50075_2_ + 2), (double)(p_50075_3_ + 1))).iterator();

      EntityOcelot var6;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         Entity var5 = (Entity)var4.next();
         var6 = (EntityOcelot)var5;
      } while(!var6.func_48141_af());

      return true;
   }
}
