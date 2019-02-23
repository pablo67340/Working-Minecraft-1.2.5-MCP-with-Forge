package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityItem;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class BlockCrops extends BlockFlower {

   protected BlockCrops(int p_i403_1_, int p_i403_2_) {
      super(p_i403_1_, p_i403_2_);
      this.field_378_bb = p_i403_2_;
      this.func_253_b(true);
      float var3 = 0.5F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
   }

   protected boolean func_269_b(int p_269_1_) {
      return p_269_1_ == Block.field_446_aB.field_376_bc;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      super.func_208_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
      if(p_208_1_.func_618_j(p_208_2_, p_208_3_ + 1, p_208_4_) >= 9) {
         int var6 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         if(var6 < 7) {
            float var7 = this.func_270_i(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
            if(p_208_5_.nextInt((int)(25.0F / var7) + 1) == 0) {
               ++var6;
               p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var6);
            }
         }
      }

   }

   public void func_21027_c_(World p_21027_1_, int p_21027_2_, int p_21027_3_, int p_21027_4_) {
      p_21027_1_.func_691_b(p_21027_2_, p_21027_3_, p_21027_4_, 7);
   }

   private float func_270_i(World p_270_1_, int p_270_2_, int p_270_3_, int p_270_4_) {
      float var5 = 1.0F;
      int var6 = p_270_1_.func_600_a(p_270_2_, p_270_3_, p_270_4_ - 1);
      int var7 = p_270_1_.func_600_a(p_270_2_, p_270_3_, p_270_4_ + 1);
      int var8 = p_270_1_.func_600_a(p_270_2_ - 1, p_270_3_, p_270_4_);
      int var9 = p_270_1_.func_600_a(p_270_2_ + 1, p_270_3_, p_270_4_);
      int var10 = p_270_1_.func_600_a(p_270_2_ - 1, p_270_3_, p_270_4_ - 1);
      int var11 = p_270_1_.func_600_a(p_270_2_ + 1, p_270_3_, p_270_4_ - 1);
      int var12 = p_270_1_.func_600_a(p_270_2_ + 1, p_270_3_, p_270_4_ + 1);
      int var13 = p_270_1_.func_600_a(p_270_2_ - 1, p_270_3_, p_270_4_ + 1);
      boolean var14 = var8 == this.field_376_bc || var9 == this.field_376_bc;
      boolean var15 = var6 == this.field_376_bc || var7 == this.field_376_bc;
      boolean var16 = var10 == this.field_376_bc || var11 == this.field_376_bc || var12 == this.field_376_bc || var13 == this.field_376_bc;

      for(int var17 = p_270_2_ - 1; var17 <= p_270_2_ + 1; ++var17) {
         for(int var18 = p_270_4_ - 1; var18 <= p_270_4_ + 1; ++var18) {
            int var19 = p_270_1_.func_600_a(var17, p_270_3_ - 1, var18);
            float var20 = 0.0F;
            if(var19 == Block.field_446_aB.field_376_bc) {
               var20 = 1.0F;
               if(p_270_1_.func_602_e(var17, p_270_3_ - 1, var18) > 0) {
                  var20 = 3.0F;
               }
            }

            if(var17 != p_270_2_ || var18 != p_270_4_) {
               var20 /= 4.0F;
            }

            var5 += var20;
         }
      }

      if(var16 || var14 && var15) {
         var5 /= 2.0F;
      }

      return var5;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      if(p_232_2_ < 0) {
         p_232_2_ = 7;
      }

      return this.field_378_bb + p_232_2_;
   }

   public int func_210_f() {
      return 6;
   }

   public void func_216_a(World p_216_1_, int p_216_2_, int p_216_3_, int p_216_4_, int p_216_5_, float p_216_6_, int p_216_7_) {
      super.func_216_a(p_216_1_, p_216_2_, p_216_3_, p_216_4_, p_216_5_, p_216_6_, 0);
      if(!p_216_1_.field_1026_y) {
         int var8 = 3 + p_216_7_;

         for(int var9 = 0; var9 < var8; ++var9) {
            if(p_216_1_.field_1037_n.nextInt(15) <= p_216_5_) {
               float var10 = 0.7F;
               float var11 = p_216_1_.field_1037_n.nextFloat() * var10 + (1.0F - var10) * 0.5F;
               float var12 = p_216_1_.field_1037_n.nextFloat() * var10 + (1.0F - var10) * 0.5F;
               float var13 = p_216_1_.field_1037_n.nextFloat() * var10 + (1.0F - var10) * 0.5F;
               EntityItem var14 = new EntityItem(p_216_1_, (double)((float)p_216_2_ + var11), (double)((float)p_216_3_ + var12), (double)((float)p_216_4_ + var13), new ItemStack(Item.field_244_Q));
               var14.field_805_c = 10;
               p_216_1_.func_674_a(var14);
            }
         }

      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return p_240_1_ == 7?Item.field_243_R.field_291_aS:-1;
   }

   public int func_229_a(Random p_229_1_) {
      return 1;
   }
}
