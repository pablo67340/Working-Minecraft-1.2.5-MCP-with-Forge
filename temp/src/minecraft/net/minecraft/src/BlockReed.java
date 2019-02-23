package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockReed extends Block {

   protected BlockReed(int p_i108_1_, int p_i108_2_) {
      super(p_i108_1_, Material.field_1329_i);
      this.field_378_bb = p_i108_2_;
      float var3 = 0.375F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
      this.func_253_b(true);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(p_208_1_.func_20084_d(p_208_2_, p_208_3_ + 1, p_208_4_)) {
         int var6;
         for(var6 = 1; p_208_1_.func_600_a(p_208_2_, p_208_3_ - var6, p_208_4_) == this.field_376_bc; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
            if(var7 == 15) {
               p_208_1_.func_690_d(p_208_2_, p_208_3_ + 1, p_208_4_, this.field_376_bc);
               p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, 0);
            } else {
               p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var7 + 1);
            }
         }
      }

   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      int var5 = p_243_1_.func_600_a(p_243_2_, p_243_3_ - 1, p_243_4_);
      return var5 == this.field_376_bc?true:(var5 != Block.field_337_v.field_376_bc && var5 != Block.field_336_w.field_376_bc && var5 != Block.field_393_F.field_376_bc?false:(p_243_1_.func_599_f(p_243_2_ - 1, p_243_3_ - 1, p_243_4_) == Material.field_1332_f?true:(p_243_1_.func_599_f(p_243_2_ + 1, p_243_3_ - 1, p_243_4_) == Material.field_1332_f?true:(p_243_1_.func_599_f(p_243_2_, p_243_3_ - 1, p_243_4_ - 1) == Material.field_1332_f?true:p_243_1_.func_599_f(p_243_2_, p_243_3_ - 1, p_243_4_ + 1) == Material.field_1332_f))));
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      this.func_303_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
   }

   protected final void func_303_h(World p_303_1_, int p_303_2_, int p_303_3_, int p_303_4_) {
      if(!this.func_223_g(p_303_1_, p_303_2_, p_303_3_, p_303_4_)) {
         this.func_259_b_(p_303_1_, p_303_2_, p_303_3_, p_303_4_, p_303_1_.func_602_e(p_303_2_, p_303_3_, p_303_4_), 0);
         p_303_1_.func_690_d(p_303_2_, p_303_3_, p_303_4_, 0);
      }

   }

   public boolean func_223_g(World p_223_1_, int p_223_2_, int p_223_3_, int p_223_4_) {
      return this.func_243_a(p_223_1_, p_223_2_, p_223_3_, p_223_4_);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_302_aH.field_291_aS;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 1;
   }
}
