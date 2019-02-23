package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockStairs;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockTorch extends Block {

   protected BlockTorch(int p_i526_1_, int p_i526_2_) {
      super(p_i526_1_, p_i526_2_, Material.field_1324_n);
      this.func_253_b(true);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 2;
   }

   private boolean func_31032_h(World p_31032_1_, int p_31032_2_, int p_31032_3_, int p_31032_4_) {
      if(p_31032_1_.func_41082_b(p_31032_2_, p_31032_3_, p_31032_4_, true)) {
         return true;
      } else {
         int var5 = p_31032_1_.func_600_a(p_31032_2_, p_31032_3_, p_31032_4_);
         if(var5 != Block.field_4057_ba.field_376_bc && var5 != Block.field_40207_bC.field_376_bc && var5 != Block.field_382_N.field_376_bc) {
            if(Block.field_345_n[var5] != null && Block.field_345_n[var5] instanceof BlockStairs) {
               int var6 = p_31032_1_.func_602_e(p_31032_2_, p_31032_3_, p_31032_4_);
               if((4 & var6) != 0) {
                  return true;
               }
            }

            return false;
         } else {
            return true;
         }
      }
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_41082_b(p_243_2_ - 1, p_243_3_, p_243_4_, true)?true:(p_243_1_.func_41082_b(p_243_2_ + 1, p_243_3_, p_243_4_, true)?true:(p_243_1_.func_41082_b(p_243_2_, p_243_3_, p_243_4_ - 1, true)?true:(p_243_1_.func_41082_b(p_243_2_, p_243_3_, p_243_4_ + 1, true)?true:this.func_31032_h(p_243_1_, p_243_2_, p_243_3_ - 1, p_243_4_))));
   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      int var6 = p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_);
      if(p_258_5_ == 1 && this.func_31032_h(p_258_1_, p_258_2_, p_258_3_ - 1, p_258_4_)) {
         var6 = 5;
      }

      if(p_258_5_ == 2 && p_258_1_.func_41082_b(p_258_2_, p_258_3_, p_258_4_ + 1, true)) {
         var6 = 4;
      }

      if(p_258_5_ == 3 && p_258_1_.func_41082_b(p_258_2_, p_258_3_, p_258_4_ - 1, true)) {
         var6 = 3;
      }

      if(p_258_5_ == 4 && p_258_1_.func_41082_b(p_258_2_ + 1, p_258_3_, p_258_4_, true)) {
         var6 = 2;
      }

      if(p_258_5_ == 5 && p_258_1_.func_41082_b(p_258_2_ - 1, p_258_3_, p_258_4_, true)) {
         var6 = 1;
      }

      p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      super.func_208_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
      if(p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_) == 0) {
         this.func_235_e(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
      }

   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      if(p_235_1_.func_41082_b(p_235_2_ - 1, p_235_3_, p_235_4_, true)) {
         p_235_1_.func_691_b(p_235_2_, p_235_3_, p_235_4_, 1);
      } else if(p_235_1_.func_41082_b(p_235_2_ + 1, p_235_3_, p_235_4_, true)) {
         p_235_1_.func_691_b(p_235_2_, p_235_3_, p_235_4_, 2);
      } else if(p_235_1_.func_41082_b(p_235_2_, p_235_3_, p_235_4_ - 1, true)) {
         p_235_1_.func_691_b(p_235_2_, p_235_3_, p_235_4_, 3);
      } else if(p_235_1_.func_41082_b(p_235_2_, p_235_3_, p_235_4_ + 1, true)) {
         p_235_1_.func_691_b(p_235_2_, p_235_3_, p_235_4_, 4);
      } else if(this.func_31032_h(p_235_1_, p_235_2_, p_235_3_ - 1, p_235_4_)) {
         p_235_1_.func_691_b(p_235_2_, p_235_3_, p_235_4_, 5);
      }

      this.func_271_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(this.func_271_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_)) {
         int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
         boolean var7 = false;
         if(!p_226_1_.func_41082_b(p_226_2_ - 1, p_226_3_, p_226_4_, true) && var6 == 1) {
            var7 = true;
         }

         if(!p_226_1_.func_41082_b(p_226_2_ + 1, p_226_3_, p_226_4_, true) && var6 == 2) {
            var7 = true;
         }

         if(!p_226_1_.func_41082_b(p_226_2_, p_226_3_, p_226_4_ - 1, true) && var6 == 3) {
            var7 = true;
         }

         if(!p_226_1_.func_41082_b(p_226_2_, p_226_3_, p_226_4_ + 1, true) && var6 == 4) {
            var7 = true;
         }

         if(!this.func_31032_h(p_226_1_, p_226_2_, p_226_3_ - 1, p_226_4_) && var6 == 5) {
            var7 = true;
         }

         if(var7) {
            this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         }
      }

   }

   private boolean func_271_h(World p_271_1_, int p_271_2_, int p_271_3_, int p_271_4_) {
      if(!this.func_243_a(p_271_1_, p_271_2_, p_271_3_, p_271_4_)) {
         if(p_271_1_.func_600_a(p_271_2_, p_271_3_, p_271_4_) == this.field_376_bc) {
            this.func_259_b_(p_271_1_, p_271_2_, p_271_3_, p_271_4_, p_271_1_.func_602_e(p_271_2_, p_271_3_, p_271_4_), 0);
            p_271_1_.func_690_d(p_271_2_, p_271_3_, p_271_4_, 0);
         }

         return false;
      } else {
         return true;
      }
   }

   public MovingObjectPosition func_255_a(World p_255_1_, int p_255_2_, int p_255_3_, int p_255_4_, Vec3D p_255_5_, Vec3D p_255_6_) {
      int var7 = p_255_1_.func_602_e(p_255_2_, p_255_3_, p_255_4_) & 7;
      float var8 = 0.15F;
      if(var7 == 1) {
         this.func_213_a(0.0F, 0.2F, 0.5F - var8, var8 * 2.0F, 0.8F, 0.5F + var8);
      } else if(var7 == 2) {
         this.func_213_a(1.0F - var8 * 2.0F, 0.2F, 0.5F - var8, 1.0F, 0.8F, 0.5F + var8);
      } else if(var7 == 3) {
         this.func_213_a(0.5F - var8, 0.2F, 0.0F, 0.5F + var8, 0.8F, var8 * 2.0F);
      } else if(var7 == 4) {
         this.func_213_a(0.5F - var8, 0.2F, 1.0F - var8 * 2.0F, 0.5F + var8, 0.8F, 1.0F);
      } else {
         var8 = 0.1F;
         this.func_213_a(0.5F - var8, 0.0F, 0.5F - var8, 0.5F + var8, 0.6F, 0.5F + var8);
      }

      return super.func_255_a(p_255_1_, p_255_2_, p_255_3_, p_255_4_, p_255_5_, p_255_6_);
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      int var6 = p_247_1_.func_602_e(p_247_2_, p_247_3_, p_247_4_);
      double var7 = (double)((float)p_247_2_ + 0.5F);
      double var9 = (double)((float)p_247_3_ + 0.7F);
      double var11 = (double)((float)p_247_4_ + 0.5F);
      double var13 = 0.2199999988079071D;
      double var15 = 0.27000001072883606D;
      if(var6 == 1) {
         p_247_1_.func_694_a("smoke", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         p_247_1_.func_694_a("flame", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
      } else if(var6 == 2) {
         p_247_1_.func_694_a("smoke", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         p_247_1_.func_694_a("flame", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
      } else if(var6 == 3) {
         p_247_1_.func_694_a("smoke", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
         p_247_1_.func_694_a("flame", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
      } else if(var6 == 4) {
         p_247_1_.func_694_a("smoke", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
         p_247_1_.func_694_a("flame", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
      } else {
         p_247_1_.func_694_a("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
         p_247_1_.func_694_a("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
      }

   }
}
