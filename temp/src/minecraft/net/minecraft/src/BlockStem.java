package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.EntityItem;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class BlockStem extends BlockFlower {

   private Block field_35297_a;


   protected BlockStem(int p_i63_1_, Block p_i63_2_) {
      super(p_i63_1_, 111);
      this.field_35297_a = p_i63_2_;
      this.func_253_b(true);
      float var3 = 0.125F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
   }

   protected boolean func_269_b(int p_269_1_) {
      return p_269_1_ == Block.field_446_aB.field_376_bc;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      super.func_208_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
      if(p_208_1_.func_618_j(p_208_2_, p_208_3_ + 1, p_208_4_) >= 9) {
         float var6 = this.func_35295_j(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
         if(p_208_5_.nextInt((int)(25.0F / var6) + 1) == 0) {
            int var7 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
            if(var7 < 7) {
               ++var7;
               p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var7);
            } else {
               if(p_208_1_.func_600_a(p_208_2_ - 1, p_208_3_, p_208_4_) == this.field_35297_a.field_376_bc) {
                  return;
               }

               if(p_208_1_.func_600_a(p_208_2_ + 1, p_208_3_, p_208_4_) == this.field_35297_a.field_376_bc) {
                  return;
               }

               if(p_208_1_.func_600_a(p_208_2_, p_208_3_, p_208_4_ - 1) == this.field_35297_a.field_376_bc) {
                  return;
               }

               if(p_208_1_.func_600_a(p_208_2_, p_208_3_, p_208_4_ + 1) == this.field_35297_a.field_376_bc) {
                  return;
               }

               int var8 = p_208_5_.nextInt(4);
               int var9 = p_208_2_;
               int var10 = p_208_4_;
               if(var8 == 0) {
                  var9 = p_208_2_ - 1;
               }

               if(var8 == 1) {
                  ++var9;
               }

               if(var8 == 2) {
                  var10 = p_208_4_ - 1;
               }

               if(var8 == 3) {
                  ++var10;
               }

               int var11 = p_208_1_.func_600_a(var9, p_208_3_ - 1, var10);
               if(p_208_1_.func_600_a(var9, p_208_3_, var10) == 0 && (var11 == Block.field_446_aB.field_376_bc || var11 == Block.field_336_w.field_376_bc || var11 == Block.field_337_v.field_376_bc)) {
                  p_208_1_.func_690_d(var9, p_208_3_, var10, this.field_35297_a.field_376_bc);
               }
            }
         }
      }

   }

   public void func_35294_i(World p_35294_1_, int p_35294_2_, int p_35294_3_, int p_35294_4_) {
      p_35294_1_.func_691_b(p_35294_2_, p_35294_3_, p_35294_4_, 7);
   }

   private float func_35295_j(World p_35295_1_, int p_35295_2_, int p_35295_3_, int p_35295_4_) {
      float var5 = 1.0F;
      int var6 = p_35295_1_.func_600_a(p_35295_2_, p_35295_3_, p_35295_4_ - 1);
      int var7 = p_35295_1_.func_600_a(p_35295_2_, p_35295_3_, p_35295_4_ + 1);
      int var8 = p_35295_1_.func_600_a(p_35295_2_ - 1, p_35295_3_, p_35295_4_);
      int var9 = p_35295_1_.func_600_a(p_35295_2_ + 1, p_35295_3_, p_35295_4_);
      int var10 = p_35295_1_.func_600_a(p_35295_2_ - 1, p_35295_3_, p_35295_4_ - 1);
      int var11 = p_35295_1_.func_600_a(p_35295_2_ + 1, p_35295_3_, p_35295_4_ - 1);
      int var12 = p_35295_1_.func_600_a(p_35295_2_ + 1, p_35295_3_, p_35295_4_ + 1);
      int var13 = p_35295_1_.func_600_a(p_35295_2_ - 1, p_35295_3_, p_35295_4_ + 1);
      boolean var14 = var8 == this.field_376_bc || var9 == this.field_376_bc;
      boolean var15 = var6 == this.field_376_bc || var7 == this.field_376_bc;
      boolean var16 = var10 == this.field_376_bc || var11 == this.field_376_bc || var12 == this.field_376_bc || var13 == this.field_376_bc;

      for(int var17 = p_35295_2_ - 1; var17 <= p_35295_2_ + 1; ++var17) {
         for(int var18 = p_35295_4_ - 1; var18 <= p_35295_4_ + 1; ++var18) {
            int var19 = p_35295_1_.func_600_a(var17, p_35295_3_ - 1, var18);
            float var20 = 0.0F;
            if(var19 == Block.field_446_aB.field_376_bc) {
               var20 = 1.0F;
               if(p_35295_1_.func_602_e(var17, p_35295_3_ - 1, var18) > 0) {
                  var20 = 3.0F;
               }
            }

            if(var17 != p_35295_2_ || var18 != p_35295_4_) {
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

   public int func_31030_b(int p_31030_1_) {
      int var2 = p_31030_1_ * 32;
      int var3 = 255 - p_31030_1_ * 8;
      int var4 = p_31030_1_ * 4;
      return var2 << 16 | var3 << 8 | var4;
   }

   public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_) {
      return this.func_31030_b(p_207_1_.func_602_e(p_207_2_, p_207_3_, p_207_4_));
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return this.field_378_bb;
   }

   public void func_237_e() {
      float var1 = 0.125F;
      this.func_213_a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      this.field_362_bj = (double)((float)(p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_) * 2 + 2) / 16.0F);
      float var5 = 0.125F;
      this.func_213_a(0.5F - var5, 0.0F, 0.5F - var5, 0.5F + var5, (float)this.field_362_bj, 0.5F + var5);
   }

   public int func_210_f() {
      return 19;
   }

   public int func_35296_f(IBlockAccess p_35296_1_, int p_35296_2_, int p_35296_3_, int p_35296_4_) {
      int var5 = p_35296_1_.func_602_e(p_35296_2_, p_35296_3_, p_35296_4_);
      return var5 < 7?-1:(p_35296_1_.func_600_a(p_35296_2_ - 1, p_35296_3_, p_35296_4_) == this.field_35297_a.field_376_bc?0:(p_35296_1_.func_600_a(p_35296_2_ + 1, p_35296_3_, p_35296_4_) == this.field_35297_a.field_376_bc?1:(p_35296_1_.func_600_a(p_35296_2_, p_35296_3_, p_35296_4_ - 1) == this.field_35297_a.field_376_bc?2:(p_35296_1_.func_600_a(p_35296_2_, p_35296_3_, p_35296_4_ + 1) == this.field_35297_a.field_376_bc?3:-1))));
   }

   public void func_216_a(World p_216_1_, int p_216_2_, int p_216_3_, int p_216_4_, int p_216_5_, float p_216_6_, int p_216_7_) {
      super.func_216_a(p_216_1_, p_216_2_, p_216_3_, p_216_4_, p_216_5_, p_216_6_, p_216_7_);
      if(!p_216_1_.field_1026_y) {
         Item var8 = null;
         if(this.field_35297_a == Block.field_4055_bb) {
            var8 = Item.field_35422_bh;
         }

         if(this.field_35297_a == Block.field_35281_bs) {
            var8 = Item.field_35423_bi;
         }

         for(int var9 = 0; var9 < 3; ++var9) {
            if(p_216_1_.field_1037_n.nextInt(15) <= p_216_5_) {
               float var10 = 0.7F;
               float var11 = p_216_1_.field_1037_n.nextFloat() * var10 + (1.0F - var10) * 0.5F;
               float var12 = p_216_1_.field_1037_n.nextFloat() * var10 + (1.0F - var10) * 0.5F;
               float var13 = p_216_1_.field_1037_n.nextFloat() * var10 + (1.0F - var10) * 0.5F;
               EntityItem var14 = new EntityItem(p_216_1_, (double)((float)p_216_2_ + var11), (double)((float)p_216_3_ + var12), (double)((float)p_216_4_ + var13), new ItemStack(var8));
               var14.field_805_c = 10;
               p_216_1_.func_674_a(var14);
            }
         }

      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      if(p_240_1_ == 7) {
         ;
      }

      return -1;
   }

   public int func_229_a(Random p_229_1_) {
      return 1;
   }
}
