package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class BlockFluid extends Block {

   protected BlockFluid(int p_i112_1_, Material p_i112_2_) {
      super(p_i112_1_, (p_i112_2_ == Material.field_1331_g?14:12) * 16 + 13, p_i112_2_);
      float var3 = 0.0F;
      float var4 = 0.0F;
      this.func_213_a(0.0F + var4, 0.0F + var3, 0.0F + var4, 1.0F + var4, 1.0F + var3, 1.0F + var4);
      this.func_253_b(true);
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return this.field_356_bn != Material.field_1331_g;
   }

   public int func_35274_i() {
      return 16777215;
   }

   public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_) {
      if(this.field_356_bn != Material.field_1332_f) {
         return 16777215;
      } else {
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;

         for(int var8 = -1; var8 <= 1; ++var8) {
            for(int var9 = -1; var9 <= 1; ++var9) {
               int var10 = p_207_1_.func_48454_a(p_207_2_ + var9, p_207_4_ + var8).field_40256_A;
               var5 += (var10 & 16711680) >> 16;
               var6 += (var10 & '\uff00') >> 8;
               var7 += var10 & 255;
            }
         }

         return (var5 / 9 & 255) << 16 | (var6 / 9 & 255) << 8 | var7 / 9 & 255;
      }
   }

   public static float func_288_b(int p_288_0_) {
      if(p_288_0_ >= 8) {
         p_288_0_ = 0;
      }

      float var1 = (float)(p_288_0_ + 1) / 9.0F;
      return var1;
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ != 0 && p_218_1_ != 1?this.field_378_bb + 1:this.field_378_bb;
   }

   protected int func_290_h(World p_290_1_, int p_290_2_, int p_290_3_, int p_290_4_) {
      return p_290_1_.func_599_f(p_290_2_, p_290_3_, p_290_4_) != this.field_356_bn?-1:p_290_1_.func_602_e(p_290_2_, p_290_3_, p_290_4_);
   }

   protected int func_289_b(IBlockAccess p_289_1_, int p_289_2_, int p_289_3_, int p_289_4_) {
      if(p_289_1_.func_599_f(p_289_2_, p_289_3_, p_289_4_) != this.field_356_bn) {
         return -1;
      } else {
         int var5 = p_289_1_.func_602_e(p_289_2_, p_289_3_, p_289_4_);
         if(var5 >= 8) {
            var5 = 0;
         }

         return var5;
      }
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_224_a(int p_224_1_, boolean p_224_2_) {
      return p_224_2_ && p_224_1_ == 0;
   }

   public boolean func_28029_d(IBlockAccess p_28029_1_, int p_28029_2_, int p_28029_3_, int p_28029_4_, int p_28029_5_) {
      Material var6 = p_28029_1_.func_599_f(p_28029_2_, p_28029_3_, p_28029_4_);
      return var6 == this.field_356_bn?false:(p_28029_5_ == 1?true:(var6 == Material.field_1320_r?false:super.func_28029_d(p_28029_1_, p_28029_2_, p_28029_3_, p_28029_4_, p_28029_5_)));
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      Material var6 = p_260_1_.func_599_f(p_260_2_, p_260_3_, p_260_4_);
      return var6 == this.field_356_bn?false:(p_260_5_ == 1?true:(var6 == Material.field_1320_r?false:super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_)));
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public int func_210_f() {
      return 4;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return 0;
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   private Vec3D func_291_e(IBlockAccess p_291_1_, int p_291_2_, int p_291_3_, int p_291_4_) {
      Vec3D var5 = Vec3D.func_1248_b(0.0D, 0.0D, 0.0D);
      int var6 = this.func_289_b(p_291_1_, p_291_2_, p_291_3_, p_291_4_);

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_291_2_;
         int var10 = p_291_4_;
         if(var7 == 0) {
            var8 = p_291_2_ - 1;
         }

         if(var7 == 1) {
            var10 = p_291_4_ - 1;
         }

         if(var7 == 2) {
            ++var8;
         }

         if(var7 == 3) {
            ++var10;
         }

         int var11 = this.func_289_b(p_291_1_, var8, p_291_3_, var10);
         int var12;
         if(var11 < 0) {
            if(!p_291_1_.func_599_f(var8, p_291_3_, var10).func_880_c()) {
               var11 = this.func_289_b(p_291_1_, var8, p_291_3_ - 1, var10);
               if(var11 >= 0) {
                  var12 = var11 - (var6 - 8);
                  var5 = var5.func_1257_c((double)((var8 - p_291_2_) * var12), (double)((p_291_3_ - p_291_3_) * var12), (double)((var10 - p_291_4_) * var12));
               }
            }
         } else if(var11 >= 0) {
            var12 = var11 - var6;
            var5 = var5.func_1257_c((double)((var8 - p_291_2_) * var12), (double)((p_291_3_ - p_291_3_) * var12), (double)((var10 - p_291_4_) * var12));
         }
      }

      if(p_291_1_.func_602_e(p_291_2_, p_291_3_, p_291_4_) >= 8) {
         boolean var13 = false;
         if(var13 || this.func_28029_d(p_291_1_, p_291_2_, p_291_3_, p_291_4_ - 1, 2)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_, p_291_3_, p_291_4_ + 1, 3)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_ - 1, p_291_3_, p_291_4_, 4)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_ + 1, p_291_3_, p_291_4_, 5)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_, p_291_3_ + 1, p_291_4_ - 1, 2)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_, p_291_3_ + 1, p_291_4_ + 1, 3)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_ - 1, p_291_3_ + 1, p_291_4_, 4)) {
            var13 = true;
         }

         if(var13 || this.func_28029_d(p_291_1_, p_291_2_ + 1, p_291_3_ + 1, p_291_4_, 5)) {
            var13 = true;
         }

         if(var13) {
            var5 = var5.func_1252_b().func_1257_c(0.0D, -6.0D, 0.0D);
         }
      }

      var5 = var5.func_1252_b();
      return var5;
   }

   public void func_257_a(World p_257_1_, int p_257_2_, int p_257_3_, int p_257_4_, Entity p_257_5_, Vec3D p_257_6_) {
      Vec3D var7 = this.func_291_e(p_257_1_, p_257_2_, p_257_3_, p_257_4_);
      p_257_6_.field_1776_a += var7.field_1776_a;
      p_257_6_.field_1775_b += var7.field_1775_b;
      p_257_6_.field_1779_c += var7.field_1779_c;
   }

   public int func_4025_d() {
      return this.field_356_bn == Material.field_1332_f?5:(this.field_356_bn == Material.field_1331_g?30:0);
   }

   public int func_35275_c(IBlockAccess p_35275_1_, int p_35275_2_, int p_35275_3_, int p_35275_4_) {
      int var5 = p_35275_1_.func_35451_b(p_35275_2_, p_35275_3_, p_35275_4_, 0);
      int var6 = p_35275_1_.func_35451_b(p_35275_2_, p_35275_3_ + 1, p_35275_4_, 0);
      int var7 = var5 & 255;
      int var8 = var6 & 255;
      int var9 = var5 >> 16 & 255;
      int var10 = var6 >> 16 & 255;
      return (var7 > var8?var7:var8) | (var9 > var10?var9:var10) << 16;
   }

   public float func_241_c(IBlockAccess p_241_1_, int p_241_2_, int p_241_3_, int p_241_4_) {
      float var5 = p_241_1_.func_598_c(p_241_2_, p_241_3_, p_241_4_);
      float var6 = p_241_1_.func_598_c(p_241_2_, p_241_3_ + 1, p_241_4_);
      return var5 > var6?var5:var6;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      super.func_208_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
   }

   public int func_234_g() {
      return this.field_356_bn == Material.field_1332_f?1:0;
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      int var6;
      if(this.field_356_bn == Material.field_1332_f) {
         if(p_247_5_.nextInt(10) == 0) {
            var6 = p_247_1_.func_602_e(p_247_2_, p_247_3_, p_247_4_);
            if(var6 <= 0 || var6 >= 8) {
               p_247_1_.func_694_a("suspended", (double)((float)p_247_2_ + p_247_5_.nextFloat()), (double)((float)p_247_3_ + p_247_5_.nextFloat()), (double)((float)p_247_4_ + p_247_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
            }
         }

         for(var6 = 0; var6 < 0; ++var6) {
            int var7 = p_247_5_.nextInt(4);
            int var8 = p_247_2_;
            int var9 = p_247_4_;
            if(var7 == 0) {
               var8 = p_247_2_ - 1;
            }

            if(var7 == 1) {
               ++var8;
            }

            if(var7 == 2) {
               var9 = p_247_4_ - 1;
            }

            if(var7 == 3) {
               ++var9;
            }

            if(p_247_1_.func_599_f(var8, p_247_3_, var9) == Material.field_1337_a && (p_247_1_.func_599_f(var8, p_247_3_ - 1, var9).func_880_c() || p_247_1_.func_599_f(var8, p_247_3_ - 1, var9).func_879_d())) {
               float var10 = 0.0625F;
               double var11 = (double)((float)p_247_2_ + p_247_5_.nextFloat());
               double var13 = (double)((float)p_247_3_ + p_247_5_.nextFloat());
               double var15 = (double)((float)p_247_4_ + p_247_5_.nextFloat());
               if(var7 == 0) {
                  var11 = (double)((float)p_247_2_ - var10);
               }

               if(var7 == 1) {
                  var11 = (double)((float)(p_247_2_ + 1) + var10);
               }

               if(var7 == 2) {
                  var15 = (double)((float)p_247_4_ - var10);
               }

               if(var7 == 3) {
                  var15 = (double)((float)(p_247_4_ + 1) + var10);
               }

               double var17 = 0.0D;
               double var19 = 0.0D;
               if(var7 == 0) {
                  var17 = (double)(-var10);
               }

               if(var7 == 1) {
                  var17 = (double)var10;
               }

               if(var7 == 2) {
                  var19 = (double)(-var10);
               }

               if(var7 == 3) {
                  var19 = (double)var10;
               }

               p_247_1_.func_694_a("splash", var11, var13, var15, var17, 0.0D, var19);
            }
         }
      }

      if(this.field_356_bn == Material.field_1332_f && p_247_5_.nextInt(64) == 0) {
         var6 = p_247_1_.func_602_e(p_247_2_, p_247_3_, p_247_4_);
         if(var6 > 0 && var6 < 8) {
            p_247_1_.func_684_a((double)((float)p_247_2_ + 0.5F), (double)((float)p_247_3_ + 0.5F), (double)((float)p_247_4_ + 0.5F), "liquid.water", p_247_5_.nextFloat() * 0.25F + 0.75F, p_247_5_.nextFloat() * 1.0F + 0.5F);
         }
      }

      double var21;
      double var22;
      double var23;
      if(this.field_356_bn == Material.field_1331_g && p_247_1_.func_599_f(p_247_2_, p_247_3_ + 1, p_247_4_) == Material.field_1337_a && !p_247_1_.func_601_g(p_247_2_, p_247_3_ + 1, p_247_4_)) {
         if(p_247_5_.nextInt(100) == 0) {
            var21 = (double)((float)p_247_2_ + p_247_5_.nextFloat());
            var22 = (double)p_247_3_ + this.field_362_bj;
            var23 = (double)((float)p_247_4_ + p_247_5_.nextFloat());
            p_247_1_.func_694_a("lava", var21, var22, var23, 0.0D, 0.0D, 0.0D);
            p_247_1_.func_684_a(var21, var22, var23, "liquid.lavapop", 0.2F + p_247_5_.nextFloat() * 0.2F, 0.9F + p_247_5_.nextFloat() * 0.15F);
         }

         if(p_247_5_.nextInt(200) == 0) {
            p_247_1_.func_684_a((double)p_247_2_, (double)p_247_3_, (double)p_247_4_, "liquid.lava", 0.2F + p_247_5_.nextFloat() * 0.2F, 0.9F + p_247_5_.nextFloat() * 0.15F);
         }
      }

      if(p_247_5_.nextInt(10) == 0 && p_247_1_.func_28100_h(p_247_2_, p_247_3_ - 1, p_247_4_) && !p_247_1_.func_599_f(p_247_2_, p_247_3_ - 2, p_247_4_).func_880_c()) {
         var21 = (double)((float)p_247_2_ + p_247_5_.nextFloat());
         var22 = (double)p_247_3_ - 1.05D;
         var23 = (double)((float)p_247_4_ + p_247_5_.nextFloat());
         if(this.field_356_bn == Material.field_1332_f) {
            p_247_1_.func_694_a("dripWater", var21, var22, var23, 0.0D, 0.0D, 0.0D);
         } else {
            p_247_1_.func_694_a("dripLava", var21, var22, var23, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   public static double func_293_a(IBlockAccess p_293_0_, int p_293_1_, int p_293_2_, int p_293_3_, Material p_293_4_) {
      Vec3D var5 = null;
      if(p_293_4_ == Material.field_1332_f) {
         var5 = ((BlockFluid)Block.field_401_B).func_291_e(p_293_0_, p_293_1_, p_293_2_, p_293_3_);
      }

      if(p_293_4_ == Material.field_1331_g) {
         var5 = ((BlockFluid)Block.field_397_D).func_291_e(p_293_0_, p_293_1_, p_293_2_, p_293_3_);
      }

      return var5.field_1776_a == 0.0D && var5.field_1779_c == 0.0D?-1000.0D:Math.atan2(var5.field_1779_c, var5.field_1776_a) - 1.5707963267948966D;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      this.func_287_j(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      this.func_287_j(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
   }

   private void func_287_j(World p_287_1_, int p_287_2_, int p_287_3_, int p_287_4_) {
      if(p_287_1_.func_600_a(p_287_2_, p_287_3_, p_287_4_) == this.field_376_bc) {
         if(this.field_356_bn == Material.field_1331_g) {
            boolean var5 = false;
            if(var5 || p_287_1_.func_599_f(p_287_2_, p_287_3_, p_287_4_ - 1) == Material.field_1332_f) {
               var5 = true;
            }

            if(var5 || p_287_1_.func_599_f(p_287_2_, p_287_3_, p_287_4_ + 1) == Material.field_1332_f) {
               var5 = true;
            }

            if(var5 || p_287_1_.func_599_f(p_287_2_ - 1, p_287_3_, p_287_4_) == Material.field_1332_f) {
               var5 = true;
            }

            if(var5 || p_287_1_.func_599_f(p_287_2_ + 1, p_287_3_, p_287_4_) == Material.field_1332_f) {
               var5 = true;
            }

            if(var5 || p_287_1_.func_599_f(p_287_2_, p_287_3_ + 1, p_287_4_) == Material.field_1332_f) {
               var5 = true;
            }

            if(var5) {
               int var6 = p_287_1_.func_602_e(p_287_2_, p_287_3_, p_287_4_);
               if(var6 == 0) {
                  p_287_1_.func_690_d(p_287_2_, p_287_3_, p_287_4_, Block.field_405_aq.field_376_bc);
               } else if(var6 <= 4) {
                  p_287_1_.func_690_d(p_287_2_, p_287_3_, p_287_4_, Block.field_335_x.field_376_bc);
               }

               this.func_292_i(p_287_1_, p_287_2_, p_287_3_, p_287_4_);
            }
         }

      }
   }

   protected void func_292_i(World p_292_1_, int p_292_2_, int p_292_3_, int p_292_4_) {
      p_292_1_.func_684_a((double)((float)p_292_2_ + 0.5F), (double)((float)p_292_3_ + 0.5F), (double)((float)p_292_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_292_1_.field_1037_n.nextFloat() - p_292_1_.field_1037_n.nextFloat()) * 0.8F);

      for(int var5 = 0; var5 < 8; ++var5) {
         p_292_1_.func_694_a("largesmoke", (double)p_292_2_ + Math.random(), (double)p_292_3_ + 1.2D, (double)p_292_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
      }

   }
}
