package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class MapGenCavesHell extends MapGenBase {

   protected void func_4129_a(int p_4129_1_, int p_4129_2_, byte[] p_4129_3_, double p_4129_4_, double p_4129_6_, double p_4129_8_) {
      this.func_4128_a(p_4129_1_, p_4129_2_, p_4129_3_, p_4129_4_, p_4129_6_, p_4129_8_, 1.0F + this.field_1305_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void func_4128_a(int p_4128_1_, int p_4128_2_, byte[] p_4128_3_, double p_4128_4_, double p_4128_6_, double p_4128_8_, float p_4128_10_, float p_4128_11_, float p_4128_12_, int p_4128_13_, int p_4128_14_, double p_4128_15_) {
      double var17 = (double)(p_4128_1_ * 16 + 8);
      double var19 = (double)(p_4128_2_ * 16 + 8);
      float var21 = 0.0F;
      float var22 = 0.0F;
      Random var23 = new Random(this.field_1305_b.nextLong());
      if(p_4128_14_ <= 0) {
         int var24 = this.field_1306_a * 16 - 16;
         p_4128_14_ = var24 - var23.nextInt(var24 / 4);
      }

      boolean var51 = false;
      if(p_4128_13_ == -1) {
         p_4128_13_ = p_4128_14_ / 2;
         var51 = true;
      }

      int var25 = var23.nextInt(p_4128_14_ / 2) + p_4128_14_ / 4;

      for(boolean var26 = var23.nextInt(6) == 0; p_4128_13_ < p_4128_14_; ++p_4128_13_) {
         double var27 = 1.5D + (double)(MathHelper.func_1106_a((float)p_4128_13_ * 3.1415927F / (float)p_4128_14_) * p_4128_10_ * 1.0F);
         double var29 = var27 * p_4128_15_;
         float var31 = MathHelper.func_1114_b(p_4128_12_);
         float var32 = MathHelper.func_1106_a(p_4128_12_);
         p_4128_4_ += (double)(MathHelper.func_1114_b(p_4128_11_) * var31);
         p_4128_6_ += (double)var32;
         p_4128_8_ += (double)(MathHelper.func_1106_a(p_4128_11_) * var31);
         if(var26) {
            p_4128_12_ *= 0.92F;
         } else {
            p_4128_12_ *= 0.7F;
         }

         p_4128_12_ += var22 * 0.1F;
         p_4128_11_ += var21 * 0.1F;
         var22 *= 0.9F;
         var21 *= 0.75F;
         var22 += (var23.nextFloat() - var23.nextFloat()) * var23.nextFloat() * 2.0F;
         var21 += (var23.nextFloat() - var23.nextFloat()) * var23.nextFloat() * 4.0F;
         if(!var51 && p_4128_13_ == var25 && p_4128_10_ > 1.0F) {
            this.func_4128_a(p_4128_1_, p_4128_2_, p_4128_3_, p_4128_4_, p_4128_6_, p_4128_8_, var23.nextFloat() * 0.5F + 0.5F, p_4128_11_ - 1.5707964F, p_4128_12_ / 3.0F, p_4128_13_, p_4128_14_, 1.0D);
            this.func_4128_a(p_4128_1_, p_4128_2_, p_4128_3_, p_4128_4_, p_4128_6_, p_4128_8_, var23.nextFloat() * 0.5F + 0.5F, p_4128_11_ + 1.5707964F, p_4128_12_ / 3.0F, p_4128_13_, p_4128_14_, 1.0D);
            return;
         }

         if(var51 || var23.nextInt(4) != 0) {
            double var33 = p_4128_4_ - var17;
            double var35 = p_4128_8_ - var19;
            double var37 = (double)(p_4128_14_ - p_4128_13_);
            double var39 = (double)(p_4128_10_ + 2.0F + 16.0F);
            if(var33 * var33 + var35 * var35 - var37 * var37 > var39 * var39) {
               return;
            }

            if(p_4128_4_ >= var17 - 16.0D - var27 * 2.0D && p_4128_8_ >= var19 - 16.0D - var27 * 2.0D && p_4128_4_ <= var17 + 16.0D + var27 * 2.0D && p_4128_8_ <= var19 + 16.0D + var27 * 2.0D) {
               int var52 = MathHelper.func_1108_b(p_4128_4_ - var27) - p_4128_1_ * 16 - 1;
               int var34 = MathHelper.func_1108_b(p_4128_4_ + var27) - p_4128_1_ * 16 + 1;
               int var53 = MathHelper.func_1108_b(p_4128_6_ - var29) - 1;
               int var36 = MathHelper.func_1108_b(p_4128_6_ + var29) + 1;
               int var54 = MathHelper.func_1108_b(p_4128_8_ - var27) - p_4128_2_ * 16 - 1;
               int var38 = MathHelper.func_1108_b(p_4128_8_ + var27) - p_4128_2_ * 16 + 1;
               if(var52 < 0) {
                  var52 = 0;
               }

               if(var34 > 16) {
                  var34 = 16;
               }

               if(var53 < 1) {
                  var53 = 1;
               }

               if(var36 > 120) {
                  var36 = 120;
               }

               if(var54 < 0) {
                  var54 = 0;
               }

               if(var38 > 16) {
                  var38 = 16;
               }

               boolean var55 = false;

               int var40;
               int var43;
               for(var40 = var52; !var55 && var40 < var34; ++var40) {
                  for(int var41 = var54; !var55 && var41 < var38; ++var41) {
                     for(int var42 = var36 + 1; !var55 && var42 >= var53 - 1; --var42) {
                        var43 = (var40 * 16 + var41) * 128 + var42;
                        if(var42 >= 0 && var42 < 128) {
                           if(p_4128_3_[var43] == Block.field_397_D.field_376_bc || p_4128_3_[var43] == Block.field_395_E.field_376_bc) {
                              var55 = true;
                           }

                           if(var42 != var53 - 1 && var40 != var52 && var40 != var34 - 1 && var41 != var54 && var41 != var38 - 1) {
                              var42 = var53;
                           }
                        }
                     }
                  }
               }

               if(!var55) {
                  for(var40 = var52; var40 < var34; ++var40) {
                     double var56 = ((double)(var40 + p_4128_1_ * 16) + 0.5D - p_4128_4_) / var27;

                     for(var43 = var54; var43 < var38; ++var43) {
                        double var44 = ((double)(var43 + p_4128_2_ * 16) + 0.5D - p_4128_8_) / var27;
                        int var46 = (var40 * 16 + var43) * 128 + var36;

                        for(int var47 = var36 - 1; var47 >= var53; --var47) {
                           double var48 = ((double)var47 + 0.5D - p_4128_6_) / var29;
                           if(var48 > -0.7D && var56 * var56 + var48 * var48 + var44 * var44 < 1.0D) {
                              byte var50 = p_4128_3_[var46];
                              if(var50 == Block.field_4053_bc.field_376_bc || var50 == Block.field_336_w.field_376_bc || var50 == Block.field_337_v.field_376_bc) {
                                 p_4128_3_[var46] = 0;
                              }
                           }

                           --var46;
                        }
                     }
                  }

                  if(var51) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_868_a(World p_868_1_, int p_868_2_, int p_868_3_, int p_868_4_, int p_868_5_, byte[] p_868_6_) {
      int var7 = this.field_1305_b.nextInt(this.field_1305_b.nextInt(this.field_1305_b.nextInt(10) + 1) + 1);
      if(this.field_1305_b.nextInt(5) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(p_868_2_ * 16 + this.field_1305_b.nextInt(16));
         double var11 = (double)this.field_1305_b.nextInt(128);
         double var13 = (double)(p_868_3_ * 16 + this.field_1305_b.nextInt(16));
         int var15 = 1;
         if(this.field_1305_b.nextInt(4) == 0) {
            this.func_4129_a(p_868_4_, p_868_5_, p_868_6_, var9, var11, var13);
            var15 += this.field_1305_b.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.field_1305_b.nextFloat() * 3.1415927F * 2.0F;
            float var18 = (this.field_1305_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.field_1305_b.nextFloat() * 2.0F + this.field_1305_b.nextFloat();
            this.func_4128_a(p_868_4_, p_868_5_, p_868_6_, var9, var11, var13, var19 * 2.0F, var17, var18, 0, 0, 0.5D);
         }
      }

   }
}
