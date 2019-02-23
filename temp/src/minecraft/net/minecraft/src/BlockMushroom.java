package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigMushroom;

public class BlockMushroom extends BlockFlower {

   protected BlockMushroom(int p_i134_1_, int p_i134_2_) {
      super(p_i134_1_, p_i134_2_);
      float var3 = 0.2F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
      this.func_253_b(true);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(p_208_5_.nextInt(25) == 0) {
         byte var6 = 4;
         int var7 = 5;

         int var8;
         int var9;
         int var10;
         for(var8 = p_208_2_ - var6; var8 <= p_208_2_ + var6; ++var8) {
            for(var9 = p_208_4_ - var6; var9 <= p_208_4_ + var6; ++var9) {
               for(var10 = p_208_3_ - 1; var10 <= p_208_3_ + 1; ++var10) {
                  if(p_208_1_.func_600_a(var8, var10, var9) == this.field_376_bc) {
                     --var7;
                     if(var7 <= 0) {
                        return;
                     }
                  }
               }
            }
         }

         var8 = p_208_2_ + p_208_5_.nextInt(3) - 1;
         var9 = p_208_3_ + p_208_5_.nextInt(2) - p_208_5_.nextInt(2);
         var10 = p_208_4_ + p_208_5_.nextInt(3) - 1;

         for(int var11 = 0; var11 < 4; ++var11) {
            if(p_208_1_.func_20084_d(var8, var9, var10) && this.func_223_g(p_208_1_, var8, var9, var10)) {
               p_208_2_ = var8;
               p_208_3_ = var9;
               p_208_4_ = var10;
            }

            var8 = p_208_2_ + p_208_5_.nextInt(3) - 1;
            var9 = p_208_3_ + p_208_5_.nextInt(2) - p_208_5_.nextInt(2);
            var10 = p_208_4_ + p_208_5_.nextInt(3) - 1;
         }

         if(p_208_1_.func_20084_d(var8, var9, var10) && this.func_223_g(p_208_1_, var8, var9, var10)) {
            p_208_1_.func_690_d(var8, var9, var10, this.field_376_bc);
         }
      }

   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_) && this.func_223_g(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   protected boolean func_269_b(int p_269_1_) {
      return Block.field_343_p[p_269_1_];
   }

   public boolean func_223_g(World p_223_1_, int p_223_2_, int p_223_3_, int p_223_4_) {
      if(p_223_3_ >= 0 && p_223_3_ < 256) {
         int var5 = p_223_1_.func_600_a(p_223_2_, p_223_3_ - 1, p_223_4_);
         return var5 == Block.field_40199_bz.field_376_bc || p_223_1_.func_28104_m(p_223_2_, p_223_3_, p_223_4_) < 13 && this.func_269_b(var5);
      } else {
         return false;
      }
   }

   public boolean func_35293_c(World p_35293_1_, int p_35293_2_, int p_35293_3_, int p_35293_4_, Random p_35293_5_) {
      int var6 = p_35293_1_.func_602_e(p_35293_2_, p_35293_3_, p_35293_4_);
      p_35293_1_.func_634_a(p_35293_2_, p_35293_3_, p_35293_4_, 0);
      WorldGenBigMushroom var7 = null;
      if(this.field_376_bc == Block.field_415_ag.field_376_bc) {
         var7 = new WorldGenBigMushroom(0);
      } else if(this.field_376_bc == Block.field_414_ah.field_376_bc) {
         var7 = new WorldGenBigMushroom(1);
      }

      if(var7 != null && var7.func_516_a(p_35293_1_, p_35293_5_, p_35293_2_, p_35293_3_, p_35293_4_)) {
         return true;
      } else {
         p_35293_1_.func_643_a(p_35293_2_, p_35293_3_, p_35293_4_, this.field_376_bc, var6);
         return false;
      }
   }
}
