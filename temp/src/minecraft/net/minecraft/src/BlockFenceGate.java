package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BlockFenceGate extends BlockDirectional {

   public BlockFenceGate(int p_i155_1_, int p_i155_2_) {
      super(p_i155_1_, p_i155_2_, Material.field_1335_c);
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return !p_243_1_.func_599_f(p_243_2_, p_243_3_ - 1, p_243_4_).func_878_a()?false:super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      int var5 = p_221_1_.func_602_e(p_221_2_, p_221_3_, p_221_4_);
      return func_35291_d(var5)?null:(var5 != 2 && var5 != 0?AxisAlignedBB.func_1161_b((double)((float)p_221_2_ + 0.375F), (double)p_221_3_, (double)p_221_4_, (double)((float)p_221_2_ + 0.625F), (double)((float)p_221_3_ + 1.5F), (double)(p_221_4_ + 1)):AxisAlignedBB.func_1161_b((double)p_221_2_, (double)p_221_3_, (double)((float)p_221_4_ + 0.375F), (double)(p_221_2_ + 1), (double)((float)p_221_3_ + 1.5F), (double)((float)p_221_4_ + 0.625F)));
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = func_48216_a(p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_));
      if(var5 != 2 && var5 != 0) {
         this.func_213_a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      } else {
         this.func_213_a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      }

   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return func_35291_d(p_48204_1_.func_602_e(p_48204_2_, p_48204_3_, p_48204_4_));
   }

   public int func_210_f() {
      return 21;
   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = (MathHelper.func_1108_b((double)(p_4026_5_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3) % 4;
      p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var6);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      int var6 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
      if(func_35291_d(var6)) {
         p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var6 & -5);
      } else {
         int var7 = (MathHelper.func_1108_b((double)(p_250_5_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3) % 4;
         int var8 = func_48216_a(var6);
         if(var8 == (var7 + 2) % 4) {
            var6 = var7;
         }

         p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var6 | 4);
      }

      p_250_1_.func_28107_a(p_250_5_, 1003, p_250_2_, p_250_3_, p_250_4_, 0);
      return true;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y) {
         int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
         boolean var7 = p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_);
         if(var7 || p_226_5_ > 0 && Block.field_345_n[p_226_5_].func_209_d() || p_226_5_ == 0) {
            if(var7 && !func_35291_d(var6)) {
               p_226_1_.func_691_b(p_226_2_, p_226_3_, p_226_4_, var6 | 4);
               p_226_1_.func_28107_a((EntityPlayer)null, 1003, p_226_2_, p_226_3_, p_226_4_, 0);
            } else if(!var7 && func_35291_d(var6)) {
               p_226_1_.func_691_b(p_226_2_, p_226_3_, p_226_4_, var6 & -5);
               p_226_1_.func_28107_a((EntityPlayer)null, 1003, p_226_2_, p_226_3_, p_226_4_, 0);
            }
         }

      }
   }

   public static boolean func_35291_d(int p_35291_0_) {
      return (p_35291_0_ & 4) != 0;
   }
}
