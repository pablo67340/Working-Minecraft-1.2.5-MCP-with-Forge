package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityEgg;
import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemMonsterPlacer;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityDispenser;
import net.minecraft.src.World;

public class BlockDispenser extends BlockContainer {

   private Random field_28035_a = new Random();


   protected BlockDispenser(int p_i200_1_) {
      super(p_i200_1_, Material.field_1334_d);
      this.field_378_bb = 45;
   }

   public int func_4025_d() {
      return 4;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_9265_P.field_376_bc;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      this.func_21032_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
   }

   private void func_21032_h(World p_21032_1_, int p_21032_2_, int p_21032_3_, int p_21032_4_) {
      if(!p_21032_1_.field_1026_y) {
         int var5 = p_21032_1_.func_600_a(p_21032_2_, p_21032_3_, p_21032_4_ - 1);
         int var6 = p_21032_1_.func_600_a(p_21032_2_, p_21032_3_, p_21032_4_ + 1);
         int var7 = p_21032_1_.func_600_a(p_21032_2_ - 1, p_21032_3_, p_21032_4_);
         int var8 = p_21032_1_.func_600_a(p_21032_2_ + 1, p_21032_3_, p_21032_4_);
         byte var9 = 3;
         if(Block.field_343_p[var5] && !Block.field_343_p[var6]) {
            var9 = 3;
         }

         if(Block.field_343_p[var6] && !Block.field_343_p[var5]) {
            var9 = 2;
         }

         if(Block.field_343_p[var7] && !Block.field_343_p[var8]) {
            var9 = 5;
         }

         if(Block.field_343_p[var8] && !Block.field_343_p[var7]) {
            var9 = 4;
         }

         p_21032_1_.func_691_b(p_21032_2_, p_21032_3_, p_21032_4_, var9);
      }
   }

   public int func_211_a(IBlockAccess p_211_1_, int p_211_2_, int p_211_3_, int p_211_4_, int p_211_5_) {
      if(p_211_5_ == 1) {
         return this.field_378_bb + 17;
      } else if(p_211_5_ == 0) {
         return this.field_378_bb + 17;
      } else {
         int var6 = p_211_1_.func_602_e(p_211_2_, p_211_3_, p_211_4_);
         return p_211_5_ != var6?this.field_378_bb:this.field_378_bb + 1;
      }
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb + 17:(p_218_1_ == 0?this.field_378_bb + 17:(p_218_1_ == 3?this.field_378_bb + 1:this.field_378_bb));
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         TileEntityDispenser var6 = (TileEntityDispenser)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_);
         if(var6 != null) {
            p_250_5_.func_21092_a(var6);
         }

         return true;
      }
   }

   private void func_21033_c(World p_21033_1_, int p_21033_2_, int p_21033_3_, int p_21033_4_, Random p_21033_5_) {
      int var6 = p_21033_1_.func_602_e(p_21033_2_, p_21033_3_, p_21033_4_);
      byte var9 = 0;
      byte var10 = 0;
      if(var6 == 3) {
         var10 = 1;
      } else if(var6 == 2) {
         var10 = -1;
      } else if(var6 == 5) {
         var9 = 1;
      } else {
         var9 = -1;
      }

      TileEntityDispenser var11 = (TileEntityDispenser)p_21033_1_.func_603_b(p_21033_2_, p_21033_3_, p_21033_4_);
      if(var11 != null) {
         ItemStack var12 = var11.func_21100_b();
         double var13 = (double)p_21033_2_ + (double)var9 * 0.6D + 0.5D;
         double var15 = (double)p_21033_3_ + 0.5D;
         double var17 = (double)p_21033_4_ + (double)var10 * 0.6D + 0.5D;
         if(var12 == null) {
            p_21033_1_.func_28106_e(1001, p_21033_2_, p_21033_3_, p_21033_4_, 0);
         } else {
            if(var12.field_1617_c == Item.field_226_j.field_291_aS) {
               EntityArrow var19 = new EntityArrow(p_21033_1_, var13, var15, var17);
               var19.func_408_a((double)var9, 0.10000000149011612D, (double)var10, 1.1F, 6.0F);
               var19.field_28020_a = true;
               p_21033_1_.func_674_a(var19);
               p_21033_1_.func_28106_e(1002, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else if(var12.field_1617_c == Item.field_296_aN.field_291_aS) {
               EntityEgg var22 = new EntityEgg(p_21033_1_, var13, var15, var17);
               var22.func_40076_a((double)var9, 0.10000000149011612D, (double)var10, 1.1F, 6.0F);
               p_21033_1_.func_674_a(var22);
               p_21033_1_.func_28106_e(1002, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else if(var12.field_1617_c == Item.field_308_aB.field_291_aS) {
               EntitySnowball var23 = new EntitySnowball(p_21033_1_, var13, var15, var17);
               var23.func_40076_a((double)var9, 0.10000000149011612D, (double)var10, 1.1F, 6.0F);
               p_21033_1_.func_674_a(var23);
               p_21033_1_.func_28106_e(1002, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else if(var12.field_1617_c == Item.field_40413_bs.field_291_aS && ItemPotion.func_40433_c(var12.func_21181_i())) {
               EntityPotion var27 = new EntityPotion(p_21033_1_, var13, var15, var17, var12.func_21181_i());
               var27.func_40076_a((double)var9, 0.10000000149011612D, (double)var10, 1.375F, 3.0F);
               p_21033_1_.func_674_a(var27);
               p_21033_1_.func_28106_e(1002, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else if(var12.field_1617_c == Item.field_48438_bD.field_291_aS) {
               EntityExpBottle var24 = new EntityExpBottle(p_21033_1_, var13, var15, var17);
               var24.func_40076_a((double)var9, 0.10000000149011612D, (double)var10, 1.375F, 3.0F);
               p_21033_1_.func_674_a(var24);
               p_21033_1_.func_28106_e(1002, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else if(var12.field_1617_c == Item.field_44019_bC.field_291_aS) {
               ItemMonsterPlacer.func_48440_a(p_21033_1_, var12.func_21181_i(), var13 + (double)var9 * 0.3D, var15 - 0.3D, var17 + (double)var10 * 0.3D);
               p_21033_1_.func_28106_e(1002, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else if(var12.field_1617_c == Item.field_48439_bE.field_291_aS) {
               EntitySmallFireball var25 = new EntitySmallFireball(p_21033_1_, var13 + (double)var9 * 0.3D, var15, var17 + (double)var10 * 0.3D, (double)var9 + p_21033_5_.nextGaussian() * 0.05D, p_21033_5_.nextGaussian() * 0.05D, (double)var10 + p_21033_5_.nextGaussian() * 0.05D);
               p_21033_1_.func_674_a(var25);
               p_21033_1_.func_28106_e(1009, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            } else {
               EntityItem var26 = new EntityItem(p_21033_1_, var13, var15 - 0.3D, var17, var12);
               double var20 = p_21033_5_.nextDouble() * 0.1D + 0.2D;
               var26.field_608_an = (double)var9 * var20;
               var26.field_607_ao = 0.20000000298023224D;
               var26.field_606_ap = (double)var10 * var20;
               var26.field_608_an += p_21033_5_.nextGaussian() * 0.007499999832361937D * 6.0D;
               var26.field_607_ao += p_21033_5_.nextGaussian() * 0.007499999832361937D * 6.0D;
               var26.field_606_ap += p_21033_5_.nextGaussian() * 0.007499999832361937D * 6.0D;
               p_21033_1_.func_674_a(var26);
               p_21033_1_.func_28106_e(1000, p_21033_2_, p_21033_3_, p_21033_4_, 0);
            }

            p_21033_1_.func_28106_e(2000, p_21033_2_, p_21033_3_, p_21033_4_, var9 + 1 + (var10 + 1) * 3);
         }
      }

   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(p_226_5_ > 0 && Block.field_345_n[p_226_5_].func_209_d()) {
         boolean var6 = p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_) || p_226_1_.func_625_o(p_226_2_, p_226_3_ + 1, p_226_4_);
         if(var6) {
            p_226_1_.func_22136_c(p_226_2_, p_226_3_, p_226_4_, this.field_376_bc, this.func_4025_d());
         }
      }

   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y && (p_208_1_.func_625_o(p_208_2_, p_208_3_, p_208_4_) || p_208_1_.func_625_o(p_208_2_, p_208_3_ + 1, p_208_4_))) {
         this.func_21033_c(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
      }

   }

   public TileEntity func_283_a_() {
      return new TileEntityDispenser();
   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = MathHelper.func_1108_b((double)(p_4026_5_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
      if(var6 == 0) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 2);
      }

      if(var6 == 1) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 5);
      }

      if(var6 == 2) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 3);
      }

      if(var6 == 3) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 4);
      }

   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      TileEntityDispenser var5 = (TileEntityDispenser)p_214_1_.func_603_b(p_214_2_, p_214_3_, p_214_4_);
      if(var5 != null) {
         for(int var6 = 0; var6 < var5.func_469_c(); ++var6) {
            ItemStack var7 = var5.func_468_c(var6);
            if(var7 != null) {
               float var8 = this.field_28035_a.nextFloat() * 0.8F + 0.1F;
               float var9 = this.field_28035_a.nextFloat() * 0.8F + 0.1F;
               float var10 = this.field_28035_a.nextFloat() * 0.8F + 0.1F;

               while(var7.field_1615_a > 0) {
                  int var11 = this.field_28035_a.nextInt(21) + 10;
                  if(var11 > var7.field_1615_a) {
                     var11 = var7.field_1615_a;
                  }

                  var7.field_1615_a -= var11;
                  EntityItem var12 = new EntityItem(p_214_1_, (double)((float)p_214_2_ + var8), (double)((float)p_214_3_ + var9), (double)((float)p_214_4_ + var10), new ItemStack(var7.field_1617_c, var11, var7.func_21181_i()));
                  if(var7.func_40710_n()) {
                     var12.field_801_a.func_40706_d((NBTTagCompound)var7.func_40709_o().func_40195_b());
                  }

                  float var13 = 0.05F;
                  var12.field_608_an = (double)((float)this.field_28035_a.nextGaussian() * var13);
                  var12.field_607_ao = (double)((float)this.field_28035_a.nextGaussian() * var13 + 0.2F);
                  var12.field_606_ap = (double)((float)this.field_28035_a.nextGaussian() * var13);
                  p_214_1_.func_674_a(var12);
               }
            }
         }
      }

      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }
}
