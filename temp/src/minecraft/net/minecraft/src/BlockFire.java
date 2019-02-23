package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldProviderEnd;

public class BlockFire extends Block {

   private int[] field_449_a = new int[256];
   private int[] field_448_b = new int[256];


   protected BlockFire(int p_i217_1_, int p_i217_2_) {
      super(p_i217_1_, p_i217_2_, Material.field_1326_l);
      this.func_253_b(true);
   }

   public void func_28028_i() {
      this.func_264_a(Block.field_334_y.field_376_bc, 5, 20);
      this.func_264_a(Block.field_4057_ba.field_376_bc, 5, 20);
      this.func_264_a(Block.field_4059_au.field_376_bc, 5, 20);
      this.func_264_a(Block.field_385_K.field_376_bc, 5, 5);
      this.func_264_a(Block.field_384_L.field_376_bc, 30, 60);
      this.func_264_a(Block.field_407_ao.field_376_bc, 30, 20);
      this.func_264_a(Block.field_408_an.field_376_bc, 15, 100);
      this.func_264_a(Block.field_9257_X.field_376_bc, 60, 100);
      this.func_264_a(Block.field_419_ac.field_376_bc, 30, 60);
      this.func_264_a(Block.field_35278_bv.field_376_bc, 15, 100);
   }

   private void func_264_a(int p_264_1_, int p_264_2_, int p_264_3_) {
      this.field_449_a[p_264_1_] = p_264_2_;
      this.field_448_b[p_264_1_] = p_264_3_;
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
      return 3;
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public int func_4025_d() {
      return 30;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      boolean var6 = p_208_1_.func_600_a(p_208_2_, p_208_3_ - 1, p_208_4_) == Block.field_4053_bc.field_376_bc;
      if(p_208_1_.field_4209_q instanceof WorldProviderEnd && p_208_1_.func_600_a(p_208_2_, p_208_3_ - 1, p_208_4_) == Block.field_403_A.field_376_bc) {
         var6 = true;
      }

      if(!this.func_243_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_)) {
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
      }

      if(!var6 && p_208_1_.func_27161_C() && (p_208_1_.func_27167_r(p_208_2_, p_208_3_, p_208_4_) || p_208_1_.func_27167_r(p_208_2_ - 1, p_208_3_, p_208_4_) || p_208_1_.func_27167_r(p_208_2_ + 1, p_208_3_, p_208_4_) || p_208_1_.func_27167_r(p_208_2_, p_208_3_, p_208_4_ - 1) || p_208_1_.func_27167_r(p_208_2_, p_208_3_, p_208_4_ + 1))) {
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
      } else {
         int var7 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         if(var7 < 15) {
            p_208_1_.func_635_c(p_208_2_, p_208_3_, p_208_4_, var7 + p_208_5_.nextInt(3) / 2);
         }

         p_208_1_.func_22136_c(p_208_2_, p_208_3_, p_208_4_, this.field_376_bc, this.func_4025_d() + p_208_5_.nextInt(10));
         if(!var6 && !this.func_263_h(p_208_1_, p_208_2_, p_208_3_, p_208_4_)) {
            if(!p_208_1_.func_28100_h(p_208_2_, p_208_3_ - 1, p_208_4_) || var7 > 3) {
               p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
            }

         } else if(!var6 && !this.func_261_b(p_208_1_, p_208_2_, p_208_3_ - 1, p_208_4_) && var7 == 15 && p_208_5_.nextInt(4) == 0) {
            p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
         } else {
            boolean var8 = p_208_1_.func_48455_z(p_208_2_, p_208_3_, p_208_4_);
            byte var9 = 0;
            if(var8) {
               var9 = -50;
            }

            this.func_48211_a(p_208_1_, p_208_2_ + 1, p_208_3_, p_208_4_, 300 + var9, p_208_5_, var7);
            this.func_48211_a(p_208_1_, p_208_2_ - 1, p_208_3_, p_208_4_, 300 + var9, p_208_5_, var7);
            this.func_48211_a(p_208_1_, p_208_2_, p_208_3_ - 1, p_208_4_, 250 + var9, p_208_5_, var7);
            this.func_48211_a(p_208_1_, p_208_2_, p_208_3_ + 1, p_208_4_, 250 + var9, p_208_5_, var7);
            this.func_48211_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_ - 1, 300 + var9, p_208_5_, var7);
            this.func_48211_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_ + 1, 300 + var9, p_208_5_, var7);

            for(int var10 = p_208_2_ - 1; var10 <= p_208_2_ + 1; ++var10) {
               for(int var11 = p_208_4_ - 1; var11 <= p_208_4_ + 1; ++var11) {
                  for(int var12 = p_208_3_ - 1; var12 <= p_208_3_ + 4; ++var12) {
                     if(var10 != p_208_2_ || var12 != p_208_3_ || var11 != p_208_4_) {
                        int var13 = 100;
                        if(var12 > p_208_3_ + 1) {
                           var13 += (var12 - (p_208_3_ + 1)) * 100;
                        }

                        int var14 = this.func_262_i(p_208_1_, var10, var12, var11);
                        if(var14 > 0) {
                           int var15 = (var14 + 40) / (var7 + 30);
                           if(var8) {
                              var15 /= 2;
                           }

                           if(var15 > 0 && p_208_5_.nextInt(var13) <= var15 && (!p_208_1_.func_27161_C() || !p_208_1_.func_27167_r(var10, var12, var11)) && !p_208_1_.func_27167_r(var10 - 1, var12, p_208_4_) && !p_208_1_.func_27167_r(var10 + 1, var12, var11) && !p_208_1_.func_27167_r(var10, var12, var11 - 1) && !p_208_1_.func_27167_r(var10, var12, var11 + 1)) {
                              int var16 = var7 + p_208_5_.nextInt(5) / 4;
                              if(var16 > 15) {
                                 var16 = 15;
                              }

                              p_208_1_.func_688_b(var10, var12, var11, this.field_376_bc, var16);
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }

   private void func_48211_a(World p_48211_1_, int p_48211_2_, int p_48211_3_, int p_48211_4_, int p_48211_5_, Random p_48211_6_, int p_48211_7_) {
      int var8 = this.field_448_b[p_48211_1_.func_600_a(p_48211_2_, p_48211_3_, p_48211_4_)];
      if(p_48211_6_.nextInt(p_48211_5_) < var8) {
         boolean var9 = p_48211_1_.func_600_a(p_48211_2_, p_48211_3_, p_48211_4_) == Block.field_408_an.field_376_bc;
         if(p_48211_6_.nextInt(p_48211_7_ + 10) < 5 && !p_48211_1_.func_27167_r(p_48211_2_, p_48211_3_, p_48211_4_)) {
            int var10 = p_48211_7_ + p_48211_6_.nextInt(5) / 4;
            if(var10 > 15) {
               var10 = 15;
            }

            p_48211_1_.func_688_b(p_48211_2_, p_48211_3_, p_48211_4_, this.field_376_bc, var10);
         } else {
            p_48211_1_.func_690_d(p_48211_2_, p_48211_3_, p_48211_4_, 0);
         }

         if(var9) {
            Block.field_408_an.func_252_b(p_48211_1_, p_48211_2_, p_48211_3_, p_48211_4_, 1);
         }
      }

   }

   private boolean func_263_h(World p_263_1_, int p_263_2_, int p_263_3_, int p_263_4_) {
      return this.func_261_b(p_263_1_, p_263_2_ + 1, p_263_3_, p_263_4_)?true:(this.func_261_b(p_263_1_, p_263_2_ - 1, p_263_3_, p_263_4_)?true:(this.func_261_b(p_263_1_, p_263_2_, p_263_3_ - 1, p_263_4_)?true:(this.func_261_b(p_263_1_, p_263_2_, p_263_3_ + 1, p_263_4_)?true:(this.func_261_b(p_263_1_, p_263_2_, p_263_3_, p_263_4_ - 1)?true:this.func_261_b(p_263_1_, p_263_2_, p_263_3_, p_263_4_ + 1)))));
   }

   private int func_262_i(World p_262_1_, int p_262_2_, int p_262_3_, int p_262_4_) {
      byte var5 = 0;
      if(!p_262_1_.func_20084_d(p_262_2_, p_262_3_, p_262_4_)) {
         return 0;
      } else {
         int var6 = this.func_265_g(p_262_1_, p_262_2_ + 1, p_262_3_, p_262_4_, var5);
         var6 = this.func_265_g(p_262_1_, p_262_2_ - 1, p_262_3_, p_262_4_, var6);
         var6 = this.func_265_g(p_262_1_, p_262_2_, p_262_3_ - 1, p_262_4_, var6);
         var6 = this.func_265_g(p_262_1_, p_262_2_, p_262_3_ + 1, p_262_4_, var6);
         var6 = this.func_265_g(p_262_1_, p_262_2_, p_262_3_, p_262_4_ - 1, var6);
         var6 = this.func_265_g(p_262_1_, p_262_2_, p_262_3_, p_262_4_ + 1, var6);
         return var6;
      }
   }

   public boolean func_245_h() {
      return false;
   }

   public boolean func_261_b(IBlockAccess p_261_1_, int p_261_2_, int p_261_3_, int p_261_4_) {
      return this.field_449_a[p_261_1_.func_600_a(p_261_2_, p_261_3_, p_261_4_)] > 0;
   }

   public int func_265_g(World p_265_1_, int p_265_2_, int p_265_3_, int p_265_4_, int p_265_5_) {
      int var6 = this.field_449_a[p_265_1_.func_600_a(p_265_2_, p_265_3_, p_265_4_)];
      return var6 > p_265_5_?var6:p_265_5_;
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_28100_h(p_243_2_, p_243_3_ - 1, p_243_4_) || this.func_263_h(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_ - 1, p_226_4_) && !this.func_263_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_)) {
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      }
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      if(p_235_1_.field_4209_q.field_4218_e > 0 || p_235_1_.func_600_a(p_235_2_, p_235_3_ - 1, p_235_4_) != Block.field_405_aq.field_376_bc || !Block.field_4047_bf.func_4032_a_(p_235_1_, p_235_2_, p_235_3_, p_235_4_)) {
         if(!p_235_1_.func_28100_h(p_235_2_, p_235_3_ - 1, p_235_4_) && !this.func_263_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_)) {
            p_235_1_.func_690_d(p_235_2_, p_235_3_, p_235_4_, 0);
         } else {
            p_235_1_.func_22136_c(p_235_2_, p_235_3_, p_235_4_, this.field_376_bc, this.func_4025_d() + p_235_1_.field_1037_n.nextInt(10));
         }
      }
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      if(p_247_5_.nextInt(24) == 0) {
         p_247_1_.func_684_a((double)((float)p_247_2_ + 0.5F), (double)((float)p_247_3_ + 0.5F), (double)((float)p_247_4_ + 0.5F), "fire.fire", 1.0F + p_247_5_.nextFloat(), p_247_5_.nextFloat() * 0.7F + 0.3F);
      }

      int var6;
      float var7;
      float var8;
      float var9;
      if(!p_247_1_.func_28100_h(p_247_2_, p_247_3_ - 1, p_247_4_) && !Block.field_402_as.func_261_b(p_247_1_, p_247_2_, p_247_3_ - 1, p_247_4_)) {
         if(Block.field_402_as.func_261_b(p_247_1_, p_247_2_ - 1, p_247_3_, p_247_4_)) {
            for(var6 = 0; var6 < 2; ++var6) {
               var7 = (float)p_247_2_ + p_247_5_.nextFloat() * 0.1F;
               var8 = (float)p_247_3_ + p_247_5_.nextFloat();
               var9 = (float)p_247_4_ + p_247_5_.nextFloat();
               p_247_1_.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
            }
         }

         if(Block.field_402_as.func_261_b(p_247_1_, p_247_2_ + 1, p_247_3_, p_247_4_)) {
            for(var6 = 0; var6 < 2; ++var6) {
               var7 = (float)(p_247_2_ + 1) - p_247_5_.nextFloat() * 0.1F;
               var8 = (float)p_247_3_ + p_247_5_.nextFloat();
               var9 = (float)p_247_4_ + p_247_5_.nextFloat();
               p_247_1_.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
            }
         }

         if(Block.field_402_as.func_261_b(p_247_1_, p_247_2_, p_247_3_, p_247_4_ - 1)) {
            for(var6 = 0; var6 < 2; ++var6) {
               var7 = (float)p_247_2_ + p_247_5_.nextFloat();
               var8 = (float)p_247_3_ + p_247_5_.nextFloat();
               var9 = (float)p_247_4_ + p_247_5_.nextFloat() * 0.1F;
               p_247_1_.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
            }
         }

         if(Block.field_402_as.func_261_b(p_247_1_, p_247_2_, p_247_3_, p_247_4_ + 1)) {
            for(var6 = 0; var6 < 2; ++var6) {
               var7 = (float)p_247_2_ + p_247_5_.nextFloat();
               var8 = (float)p_247_3_ + p_247_5_.nextFloat();
               var9 = (float)(p_247_4_ + 1) - p_247_5_.nextFloat() * 0.1F;
               p_247_1_.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
            }
         }

         if(Block.field_402_as.func_261_b(p_247_1_, p_247_2_, p_247_3_ + 1, p_247_4_)) {
            for(var6 = 0; var6 < 2; ++var6) {
               var7 = (float)p_247_2_ + p_247_5_.nextFloat();
               var8 = (float)(p_247_3_ + 1) - p_247_5_.nextFloat() * 0.1F;
               var9 = (float)p_247_4_ + p_247_5_.nextFloat();
               p_247_1_.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
            }
         }
      } else {
         for(var6 = 0; var6 < 3; ++var6) {
            var7 = (float)p_247_2_ + p_247_5_.nextFloat();
            var8 = (float)p_247_3_ + p_247_5_.nextFloat() * 0.5F + 0.5F;
            var9 = (float)p_247_4_ + p_247_5_.nextFloat();
            p_247_1_.func_694_a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
         }
      }

   }
}
