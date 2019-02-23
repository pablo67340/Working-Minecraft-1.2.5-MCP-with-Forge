package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockRedstoneOre extends Block {

   private boolean field_468_a;


   public BlockRedstoneOre(int p_i627_1_, int p_i627_2_, boolean p_i627_3_) {
      super(p_i627_1_, p_i627_2_, Material.field_1334_d);
      if(p_i627_3_) {
         this.func_253_b(true);
      }

      this.field_468_a = p_i627_3_;
   }

   public int func_4025_d() {
      return 30;
   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.func_320_h(p_233_1_, p_233_2_, p_233_3_, p_233_4_);
      super.func_233_b(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
   }

   public void func_254_a(World p_254_1_, int p_254_2_, int p_254_3_, int p_254_4_, Entity p_254_5_) {
      this.func_320_h(p_254_1_, p_254_2_, p_254_3_, p_254_4_);
      super.func_254_a(p_254_1_, p_254_2_, p_254_3_, p_254_4_, p_254_5_);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      this.func_320_h(p_250_1_, p_250_2_, p_250_3_, p_250_4_);
      return super.func_250_a(p_250_1_, p_250_2_, p_250_3_, p_250_4_, p_250_5_);
   }

   private void func_320_h(World p_320_1_, int p_320_2_, int p_320_3_, int p_320_4_) {
      this.func_319_i(p_320_1_, p_320_2_, p_320_3_, p_320_4_);
      if(this.field_376_bc == Block.field_433_aO.field_376_bc) {
         p_320_1_.func_690_d(p_320_2_, p_320_3_, p_320_4_, Block.field_432_aP.field_376_bc);
      }

   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(this.field_376_bc == Block.field_432_aP.field_376_bc) {
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, Block.field_433_aO.field_376_bc);
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_309_aA.field_291_aS;
   }

   public int func_40198_a(int p_40198_1_, Random p_40198_2_) {
      return this.func_229_a(p_40198_2_) + p_40198_2_.nextInt(p_40198_1_ + 1);
   }

   public int func_229_a(Random p_229_1_) {
      return 4 + p_229_1_.nextInt(2);
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      if(this.field_468_a) {
         this.func_319_i(p_247_1_, p_247_2_, p_247_3_, p_247_4_);
      }

   }

   private void func_319_i(World p_319_1_, int p_319_2_, int p_319_3_, int p_319_4_) {
      Random var5 = p_319_1_.field_1037_n;
      double var6 = 0.0625D;

      for(int var8 = 0; var8 < 6; ++var8) {
         double var9 = (double)((float)p_319_2_ + var5.nextFloat());
         double var11 = (double)((float)p_319_3_ + var5.nextFloat());
         double var13 = (double)((float)p_319_4_ + var5.nextFloat());
         if(var8 == 0 && !p_319_1_.func_601_g(p_319_2_, p_319_3_ + 1, p_319_4_)) {
            var11 = (double)(p_319_3_ + 1) + var6;
         }

         if(var8 == 1 && !p_319_1_.func_601_g(p_319_2_, p_319_3_ - 1, p_319_4_)) {
            var11 = (double)(p_319_3_ + 0) - var6;
         }

         if(var8 == 2 && !p_319_1_.func_601_g(p_319_2_, p_319_3_, p_319_4_ + 1)) {
            var13 = (double)(p_319_4_ + 1) + var6;
         }

         if(var8 == 3 && !p_319_1_.func_601_g(p_319_2_, p_319_3_, p_319_4_ - 1)) {
            var13 = (double)(p_319_4_ + 0) - var6;
         }

         if(var8 == 4 && !p_319_1_.func_601_g(p_319_2_ + 1, p_319_3_, p_319_4_)) {
            var9 = (double)(p_319_2_ + 1) + var6;
         }

         if(var8 == 5 && !p_319_1_.func_601_g(p_319_2_ - 1, p_319_3_, p_319_4_)) {
            var9 = (double)(p_319_2_ + 0) - var6;
         }

         if(var9 < (double)p_319_2_ || var9 > (double)(p_319_2_ + 1) || var11 < 0.0D || var11 > (double)(p_319_3_ + 1) || var13 < (double)p_319_4_ || var13 > (double)(p_319_4_ + 1)) {
            p_319_1_.func_694_a("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   protected ItemStack func_41049_c_(int p_41049_1_) {
      return new ItemStack(Block.field_433_aO);
   }
}
