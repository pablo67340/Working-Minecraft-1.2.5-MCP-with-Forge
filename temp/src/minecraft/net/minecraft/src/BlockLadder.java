package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLadder extends Block {

   protected BlockLadder(int p_i276_1_, int p_i276_2_) {
      super(p_i276_1_, p_i276_2_, Material.field_1324_n);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      int var5 = p_221_1_.func_602_e(p_221_2_, p_221_3_, p_221_4_);
      float var6 = 0.125F;
      if(var5 == 2) {
         this.func_213_a(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
      }

      if(var5 == 3) {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
      }

      if(var5 == 4) {
         this.func_213_a(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

      if(var5 == 5) {
         this.func_213_a(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
      }

      return super.func_221_d(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
   }

   public AxisAlignedBB func_246_f(World p_246_1_, int p_246_2_, int p_246_3_, int p_246_4_) {
      int var5 = p_246_1_.func_602_e(p_246_2_, p_246_3_, p_246_4_);
      float var6 = 0.125F;
      if(var5 == 2) {
         this.func_213_a(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
      }

      if(var5 == 3) {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
      }

      if(var5 == 4) {
         this.func_213_a(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

      if(var5 == 5) {
         this.func_213_a(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
      }

      return super.func_246_f(p_246_1_, p_246_2_, p_246_3_, p_246_4_);
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 8;
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_28100_h(p_243_2_ - 1, p_243_3_, p_243_4_)?true:(p_243_1_.func_28100_h(p_243_2_ + 1, p_243_3_, p_243_4_)?true:(p_243_1_.func_28100_h(p_243_2_, p_243_3_, p_243_4_ - 1)?true:p_243_1_.func_28100_h(p_243_2_, p_243_3_, p_243_4_ + 1)));
   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      int var6 = p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_);
      if((var6 == 0 || p_258_5_ == 2) && p_258_1_.func_28100_h(p_258_2_, p_258_3_, p_258_4_ + 1)) {
         var6 = 2;
      }

      if((var6 == 0 || p_258_5_ == 3) && p_258_1_.func_28100_h(p_258_2_, p_258_3_, p_258_4_ - 1)) {
         var6 = 3;
      }

      if((var6 == 0 || p_258_5_ == 4) && p_258_1_.func_28100_h(p_258_2_ + 1, p_258_3_, p_258_4_)) {
         var6 = 4;
      }

      if((var6 == 0 || p_258_5_ == 5) && p_258_1_.func_28100_h(p_258_2_ - 1, p_258_3_, p_258_4_)) {
         var6 = 5;
      }

      p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6);
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
      boolean var7 = false;
      if(var6 == 2 && p_226_1_.func_28100_h(p_226_2_, p_226_3_, p_226_4_ + 1)) {
         var7 = true;
      }

      if(var6 == 3 && p_226_1_.func_28100_h(p_226_2_, p_226_3_, p_226_4_ - 1)) {
         var7 = true;
      }

      if(var6 == 4 && p_226_1_.func_28100_h(p_226_2_ + 1, p_226_3_, p_226_4_)) {
         var7 = true;
      }

      if(var6 == 5 && p_226_1_.func_28100_h(p_226_2_ - 1, p_226_3_, p_226_4_)) {
         var7 = true;
      }

      if(!var7) {
         this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var6, 0);
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      }

      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
   }

   public int func_229_a(Random p_229_1_) {
      return 1;
   }
}
