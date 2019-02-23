package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCake extends Block {

   protected BlockCake(int p_i503_1_, int p_i503_2_) {
      super(p_i503_1_, p_i503_2_, Material.field_21150_y);
      this.func_253_b(true);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      this.func_213_a(var7, 0.0F, var6, 1.0F - var6, var8, 1.0F - var6);
   }

   public void func_237_e() {
      float var1 = 0.0625F;
      float var2 = 0.5F;
      this.func_213_a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      int var5 = p_221_1_.func_602_e(p_221_2_, p_221_3_, p_221_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      return AxisAlignedBB.func_1161_b((double)((float)p_221_2_ + var7), (double)p_221_3_, (double)((float)p_221_4_ + var6), (double)((float)(p_221_2_ + 1) - var6), (double)((float)p_221_3_ + var8 - var6), (double)((float)(p_221_4_ + 1) - var6));
   }

   public AxisAlignedBB func_246_f(World p_246_1_, int p_246_2_, int p_246_3_, int p_246_4_) {
      int var5 = p_246_1_.func_602_e(p_246_2_, p_246_3_, p_246_4_);
      float var6 = 0.0625F;
      float var7 = (float)(1 + var5 * 2) / 16.0F;
      float var8 = 0.5F;
      return AxisAlignedBB.func_1161_b((double)((float)p_246_2_ + var7), (double)p_246_3_, (double)((float)p_246_4_ + var6), (double)((float)(p_246_2_ + 1) - var6), (double)((float)p_246_3_ + var8), (double)((float)(p_246_4_ + 1) - var6));
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1?this.field_378_bb:(p_232_1_ == 0?this.field_378_bb + 3:(p_232_2_ > 0 && p_232_1_ == 4?this.field_378_bb + 2:this.field_378_bb + 1));
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb:(p_218_1_ == 0?this.field_378_bb + 3:this.field_378_bb + 1);
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      this.func_21029_c(p_250_1_, p_250_2_, p_250_3_, p_250_4_, p_250_5_);
      return true;
   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.func_21029_c(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
   }

   private void func_21029_c(World p_21029_1_, int p_21029_2_, int p_21029_3_, int p_21029_4_, EntityPlayer p_21029_5_) {
      if(p_21029_5_.func_35197_b(false)) {
         p_21029_5_.func_35191_at().func_35771_a(2, 0.1F);
         int var6 = p_21029_1_.func_602_e(p_21029_2_, p_21029_3_, p_21029_4_) + 1;
         if(var6 >= 6) {
            p_21029_1_.func_690_d(p_21029_2_, p_21029_3_, p_21029_4_, 0);
         } else {
            p_21029_1_.func_691_b(p_21029_2_, p_21029_3_, p_21029_4_, var6);
            p_21029_1_.func_21115_j(p_21029_2_, p_21029_3_, p_21029_4_);
         }
      }

   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return !super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_)?false:this.func_223_g(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!this.func_223_g(p_226_1_, p_226_2_, p_226_3_, p_226_4_)) {
         this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      }

   }

   public boolean func_223_g(World p_223_1_, int p_223_2_, int p_223_3_, int p_223_4_) {
      return p_223_1_.func_599_f(p_223_2_, p_223_3_ - 1, p_223_4_).func_878_a();
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return 0;
   }
}
