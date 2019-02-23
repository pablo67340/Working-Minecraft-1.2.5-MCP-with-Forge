package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class MapGenRavine extends MapGenBase {

   private float[] field_35627_a = new float[1024];


   protected void func_35626_a(long p_35626_1_, int p_35626_3_, int p_35626_4_, byte[] p_35626_5_, double p_35626_6_, double p_35626_8_, double p_35626_10_, float p_35626_12_, float p_35626_13_, float p_35626_14_, int p_35626_15_, int p_35626_16_, double p_35626_17_) {
      Random var19 = new Random(p_35626_1_);
      double var20 = (double)(p_35626_3_ * 16 + 8);
      double var22 = (double)(p_35626_4_ * 16 + 8);
      float var24 = 0.0F;
      float var25 = 0.0F;
      if(p_35626_16_ <= 0) {
         int var26 = this.field_1306_a * 16 - 16;
         p_35626_16_ = var26 - var19.nextInt(var26 / 4);
      }

      boolean var53 = false;
      if(p_35626_15_ == -1) {
         p_35626_15_ = p_35626_16_ / 2;
         var53 = true;
      }

      float var27 = 1.0F;

      for(int var28 = 0; var28 < 128; ++var28) {
         if(var28 == 0 || var19.nextInt(3) == 0) {
            var27 = 1.0F + var19.nextFloat() * var19.nextFloat() * 1.0F;
         }

         this.field_35627_a[var28] = var27 * var27;
      }

      for(; p_35626_15_ < p_35626_16_; ++p_35626_15_) {
         double var54 = 1.5D + (double)(MathHelper.func_1106_a((float)p_35626_15_ * 3.1415927F / (float)p_35626_16_) * p_35626_12_ * 1.0F);
         double var30 = var54 * p_35626_17_;
         var54 *= (double)var19.nextFloat() * 0.25D + 0.75D;
         var30 *= (double)var19.nextFloat() * 0.25D + 0.75D;
         float var32 = MathHelper.func_1114_b(p_35626_14_);
         float var33 = MathHelper.func_1106_a(p_35626_14_);
         p_35626_6_ += (double)(MathHelper.func_1114_b(p_35626_13_) * var32);
         p_35626_8_ += (double)var33;
         p_35626_10_ += (double)(MathHelper.func_1106_a(p_35626_13_) * var32);
         p_35626_14_ *= 0.7F;
         p_35626_14_ += var25 * 0.05F;
         p_35626_13_ += var24 * 0.05F;
         var25 *= 0.8F;
         var24 *= 0.5F;
         var25 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
         var24 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
         if(var53 || var19.nextInt(4) != 0) {
            double var34 = p_35626_6_ - var20;
            double var36 = p_35626_10_ - var22;
            double var38 = (double)(p_35626_16_ - p_35626_15_);
            double var40 = (double)(p_35626_12_ + 2.0F + 16.0F);
            if(var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
               return;
            }

            if(p_35626_6_ >= var20 - 16.0D - var54 * 2.0D && p_35626_10_ >= var22 - 16.0D - var54 * 2.0D && p_35626_6_ <= var20 + 16.0D + var54 * 2.0D && p_35626_10_ <= var22 + 16.0D + var54 * 2.0D) {
               int var55 = MathHelper.func_1108_b(p_35626_6_ - var54) - p_35626_3_ * 16 - 1;
               int var35 = MathHelper.func_1108_b(p_35626_6_ + var54) - p_35626_3_ * 16 + 1;
               int var56 = MathHelper.func_1108_b(p_35626_8_ - var30) - 1;
               int var37 = MathHelper.func_1108_b(p_35626_8_ + var30) + 1;
               int var57 = MathHelper.func_1108_b(p_35626_10_ - var54) - p_35626_4_ * 16 - 1;
               int var39 = MathHelper.func_1108_b(p_35626_10_ + var54) - p_35626_4_ * 16 + 1;
               if(var55 < 0) {
                  var55 = 0;
               }

               if(var35 > 16) {
                  var35 = 16;
               }

               if(var56 < 1) {
                  var56 = 1;
               }

               if(var37 > 120) {
                  var37 = 120;
               }

               if(var57 < 0) {
                  var57 = 0;
               }

               if(var39 > 16) {
                  var39 = 16;
               }

               boolean var58 = false;

               int var41;
               int var44;
               for(var41 = var55; !var58 && var41 < var35; ++var41) {
                  for(int var42 = var57; !var58 && var42 < var39; ++var42) {
                     for(int var43 = var37 + 1; !var58 && var43 >= var56 - 1; --var43) {
                        var44 = (var41 * 16 + var42) * 128 + var43;
                        if(var43 >= 0 && var43 < 128) {
                           if(p_35626_5_[var44] == Block.field_401_B.field_376_bc || p_35626_5_[var44] == Block.field_399_C.field_376_bc) {
                              var58 = true;
                           }

                           if(var43 != var56 - 1 && var41 != var55 && var41 != var35 - 1 && var42 != var57 && var42 != var39 - 1) {
                              var43 = var56;
                           }
                        }
                     }
                  }
               }

               if(!var58) {
                  for(var41 = var55; var41 < var35; ++var41) {
                     double var59 = ((double)(var41 + p_35626_3_ * 16) + 0.5D - p_35626_6_) / var54;

                     for(var44 = var57; var44 < var39; ++var44) {
                        double var45 = ((double)(var44 + p_35626_4_ * 16) + 0.5D - p_35626_10_) / var54;
                        int var47 = (var41 * 16 + var44) * 128 + var37;
                        boolean var48 = false;
                        if(var59 * var59 + var45 * var45 < 1.0D) {
                           for(int var49 = var37 - 1; var49 >= var56; --var49) {
                              double var50 = ((double)var49 + 0.5D - p_35626_8_) / var30;
                              if((var59 * var59 + var45 * var45) * (double)this.field_35627_a[var49] + var50 * var50 / 6.0D < 1.0D) {
                                 byte var52 = p_35626_5_[var47];
                                 if(var52 == Block.field_337_v.field_376_bc) {
                                    var48 = true;
                                 }

                                 if(var52 == Block.field_338_u.field_376_bc || var52 == Block.field_336_w.field_376_bc || var52 == Block.field_337_v.field_376_bc) {
                                    if(var49 < 10) {
                                       p_35626_5_[var47] = (byte)Block.field_397_D.field_376_bc;
                                    } else {
                                       p_35626_5_[var47] = 0;
                                       if(var48 && p_35626_5_[var47 - 1] == Block.field_336_w.field_376_bc) {
                                          p_35626_5_[var47 - 1] = this.field_35625_d.func_48454_a(var41 + p_35626_3_ * 16, var44 + p_35626_4_ * 16).field_4242_o;
                                       }
                                    }
                                 }
                              }

                              --var47;
                           }
                        }
                     }
                  }

                  if(var53) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_868_a(World p_868_1_, int p_868_2_, int p_868_3_, int p_868_4_, int p_868_5_, byte[] p_868_6_) {
      if(this.field_1305_b.nextInt(50) == 0) {
         double var7 = (double)(p_868_2_ * 16 + this.field_1305_b.nextInt(16));
         double var9 = (double)(this.field_1305_b.nextInt(this.field_1305_b.nextInt(40) + 8) + 20);
         double var11 = (double)(p_868_3_ * 16 + this.field_1305_b.nextInt(16));
         byte var13 = 1;

         for(int var14 = 0; var14 < var13; ++var14) {
            float var15 = this.field_1305_b.nextFloat() * 3.1415927F * 2.0F;
            float var16 = (this.field_1305_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var17 = (this.field_1305_b.nextFloat() * 2.0F + this.field_1305_b.nextFloat()) * 2.0F;
            this.func_35626_a(this.field_1305_b.nextLong(), p_868_4_, p_868_5_, p_868_6_, var7, var9, var11, var17, var15, var16, 0, 0, 3.0D);
         }

      }
   }
}
