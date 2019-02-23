package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockStationary extends BlockFluid {

   protected BlockStationary(int p_i53_1_, Material p_i53_2_) {
      super(p_i53_1_, p_i53_2_);
      this.func_253_b(false);
      if(p_i53_2_ == Material.field_1331_g) {
         this.func_253_b(true);
      }

   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return this.field_356_bn != Material.field_1331_g;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
      if(p_226_1_.func_600_a(p_226_2_, p_226_3_, p_226_4_) == this.field_376_bc) {
         this.func_30004_j(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
      }

   }

   private void func_30004_j(World p_30004_1_, int p_30004_2_, int p_30004_3_, int p_30004_4_) {
      int var5 = p_30004_1_.func_602_e(p_30004_2_, p_30004_3_, p_30004_4_);
      p_30004_1_.field_1043_h = true;
      p_30004_1_.func_643_a(p_30004_2_, p_30004_3_, p_30004_4_, this.field_376_bc - 1, var5);
      p_30004_1_.func_701_b(p_30004_2_, p_30004_3_, p_30004_4_, p_30004_2_, p_30004_3_, p_30004_4_);
      p_30004_1_.func_22136_c(p_30004_2_, p_30004_3_, p_30004_4_, this.field_376_bc - 1, this.func_4025_d());
      p_30004_1_.field_1043_h = false;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(this.field_356_bn == Material.field_1331_g) {
         int var6 = p_208_5_.nextInt(3);

         int var7;
         int var8;
         for(var7 = 0; var7 < var6; ++var7) {
            p_208_2_ += p_208_5_.nextInt(3) - 1;
            ++p_208_3_;
            p_208_4_ += p_208_5_.nextInt(3) - 1;
            var8 = p_208_1_.func_600_a(p_208_2_, p_208_3_, p_208_4_);
            if(var8 == 0) {
               if(this.func_301_k(p_208_1_, p_208_2_ - 1, p_208_3_, p_208_4_) || this.func_301_k(p_208_1_, p_208_2_ + 1, p_208_3_, p_208_4_) || this.func_301_k(p_208_1_, p_208_2_, p_208_3_, p_208_4_ - 1) || this.func_301_k(p_208_1_, p_208_2_, p_208_3_, p_208_4_ + 1) || this.func_301_k(p_208_1_, p_208_2_, p_208_3_ - 1, p_208_4_) || this.func_301_k(p_208_1_, p_208_2_, p_208_3_ + 1, p_208_4_)) {
                  p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, Block.field_402_as.field_376_bc);
                  return;
               }
            } else if(Block.field_345_n[var8].field_356_bn.func_880_c()) {
               return;
            }
         }

         if(var6 == 0) {
            var7 = p_208_2_;
            var8 = p_208_4_;

            for(int var9 = 0; var9 < 3; ++var9) {
               p_208_2_ = var7 + p_208_5_.nextInt(3) - 1;
               p_208_4_ = var8 + p_208_5_.nextInt(3) - 1;
               if(p_208_1_.func_20084_d(p_208_2_, p_208_3_ + 1, p_208_4_) && this.func_301_k(p_208_1_, p_208_2_, p_208_3_, p_208_4_)) {
                  p_208_1_.func_690_d(p_208_2_, p_208_3_ + 1, p_208_4_, Block.field_402_as.field_376_bc);
               }
            }
         }
      }

   }

   private boolean func_301_k(World p_301_1_, int p_301_2_, int p_301_3_, int p_301_4_) {
      return p_301_1_.func_599_f(p_301_2_, p_301_3_, p_301_4_).func_876_e();
   }
}
