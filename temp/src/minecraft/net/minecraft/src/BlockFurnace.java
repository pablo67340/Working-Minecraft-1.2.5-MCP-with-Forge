package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;

public class BlockFurnace extends BlockContainer {

   private Random field_28036_a = new Random();
   private final boolean field_456_a;
   private static boolean field_28037_c = false;


   protected BlockFurnace(int p_i129_1_, boolean p_i129_2_) {
      super(p_i129_1_, Material.field_1334_d);
      this.field_456_a = p_i129_2_;
      this.field_378_bb = 45;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_445_aC.field_376_bc;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      this.func_284_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
   }

   private void func_284_h(World p_284_1_, int p_284_2_, int p_284_3_, int p_284_4_) {
      if(!p_284_1_.field_1026_y) {
         int var5 = p_284_1_.func_600_a(p_284_2_, p_284_3_, p_284_4_ - 1);
         int var6 = p_284_1_.func_600_a(p_284_2_, p_284_3_, p_284_4_ + 1);
         int var7 = p_284_1_.func_600_a(p_284_2_ - 1, p_284_3_, p_284_4_);
         int var8 = p_284_1_.func_600_a(p_284_2_ + 1, p_284_3_, p_284_4_);
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

         p_284_1_.func_691_b(p_284_2_, p_284_3_, p_284_4_, var9);
      }
   }

   public int func_211_a(IBlockAccess p_211_1_, int p_211_2_, int p_211_3_, int p_211_4_, int p_211_5_) {
      if(p_211_5_ == 1) {
         return this.field_378_bb + 17;
      } else if(p_211_5_ == 0) {
         return this.field_378_bb + 17;
      } else {
         int var6 = p_211_1_.func_602_e(p_211_2_, p_211_3_, p_211_4_);
         return p_211_5_ != var6?this.field_378_bb:(this.field_456_a?this.field_378_bb + 16:this.field_378_bb - 1);
      }
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      if(this.field_456_a) {
         int var6 = p_247_1_.func_602_e(p_247_2_, p_247_3_, p_247_4_);
         float var7 = (float)p_247_2_ + 0.5F;
         float var8 = (float)p_247_3_ + 0.0F + p_247_5_.nextFloat() * 6.0F / 16.0F;
         float var9 = (float)p_247_4_ + 0.5F;
         float var10 = 0.52F;
         float var11 = p_247_5_.nextFloat() * 0.6F - 0.3F;
         if(var6 == 4) {
            p_247_1_.func_694_a("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            p_247_1_.func_694_a("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
         } else if(var6 == 5) {
            p_247_1_.func_694_a("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            p_247_1_.func_694_a("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
         } else if(var6 == 2) {
            p_247_1_.func_694_a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
            p_247_1_.func_694_a("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
         } else if(var6 == 3) {
            p_247_1_.func_694_a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
            p_247_1_.func_694_a("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
         }

      }
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb + 17:(p_218_1_ == 0?this.field_378_bb + 17:(p_218_1_ == 3?this.field_378_bb - 1:this.field_378_bb));
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         TileEntityFurnace var6 = (TileEntityFurnace)p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_);
         if(var6 != null) {
            p_250_5_.func_453_a(var6);
         }

         return true;
      }
   }

   public static void func_285_a(boolean p_285_0_, World p_285_1_, int p_285_2_, int p_285_3_, int p_285_4_) {
      int var5 = p_285_1_.func_602_e(p_285_2_, p_285_3_, p_285_4_);
      TileEntity var6 = p_285_1_.func_603_b(p_285_2_, p_285_3_, p_285_4_);
      field_28037_c = true;
      if(p_285_0_) {
         p_285_1_.func_690_d(p_285_2_, p_285_3_, p_285_4_, Block.field_444_aD.field_376_bc);
      } else {
         p_285_1_.func_690_d(p_285_2_, p_285_3_, p_285_4_, Block.field_445_aC.field_376_bc);
      }

      field_28037_c = false;
      p_285_1_.func_691_b(p_285_2_, p_285_3_, p_285_4_, var5);
      if(var6 != null) {
         var6.func_31004_j();
         p_285_1_.func_654_a(p_285_2_, p_285_3_, p_285_4_, var6);
      }

   }

   public TileEntity func_283_a_() {
      return new TileEntityFurnace();
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
      if(!field_28037_c) {
         TileEntityFurnace var5 = (TileEntityFurnace)p_214_1_.func_603_b(p_214_2_, p_214_3_, p_214_4_);
         if(var5 != null) {
            for(int var6 = 0; var6 < var5.func_469_c(); ++var6) {
               ItemStack var7 = var5.func_468_c(var6);
               if(var7 != null) {
                  float var8 = this.field_28036_a.nextFloat() * 0.8F + 0.1F;
                  float var9 = this.field_28036_a.nextFloat() * 0.8F + 0.1F;
                  float var10 = this.field_28036_a.nextFloat() * 0.8F + 0.1F;

                  while(var7.field_1615_a > 0) {
                     int var11 = this.field_28036_a.nextInt(21) + 10;
                     if(var11 > var7.field_1615_a) {
                        var11 = var7.field_1615_a;
                     }

                     var7.field_1615_a -= var11;
                     EntityItem var12 = new EntityItem(p_214_1_, (double)((float)p_214_2_ + var8), (double)((float)p_214_3_ + var9), (double)((float)p_214_4_ + var10), new ItemStack(var7.field_1617_c, var11, var7.func_21181_i()));
                     if(var7.func_40710_n()) {
                        var12.field_801_a.func_40706_d((NBTTagCompound)var7.func_40709_o().func_40195_b());
                     }

                     float var13 = 0.05F;
                     var12.field_608_an = (double)((float)this.field_28036_a.nextGaussian() * var13);
                     var12.field_607_ao = (double)((float)this.field_28036_a.nextGaussian() * var13 + 0.2F);
                     var12.field_606_ap = (double)((float)this.field_28036_a.nextGaussian() * var13);
                     p_214_1_.func_674_a(var12);
                  }
               }
            }
         }
      }

      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

}
