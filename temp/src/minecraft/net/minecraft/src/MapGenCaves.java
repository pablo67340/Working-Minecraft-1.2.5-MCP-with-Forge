package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class MapGenCaves extends MapGenBase {

   protected void func_870_a(long p_870_1_, int p_870_3_, int p_870_4_, byte[] p_870_5_, double p_870_6_, double p_870_8_, double p_870_10_) {
      this.func_869_a(p_870_1_, p_870_3_, p_870_4_, p_870_5_, p_870_6_, p_870_8_, p_870_10_, 1.0F + this.field_1305_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void func_869_a(long p_869_1_, int p_869_3_, int p_869_4_, byte[] p_869_5_, double p_869_6_, double p_869_8_, double p_869_10_, float p_869_12_, float p_869_13_, float p_869_14_, int p_869_15_, int p_869_16_, double p_869_17_) {
      double var19 = (double)(p_869_3_ * 16 + 8);
      double var21 = (double)(p_869_4_ * 16 + 8);
      float var23 = 0.0F;
      float var24 = 0.0F;
      Random var25 = new Random(p_869_1_);
      if(p_869_16_ <= 0) {
         int var26 = this.field_1306_a * 16 - 16;
         p_869_16_ = var26 - var25.nextInt(var26 / 4);
      }

      boolean var54 = false;
      if(p_869_15_ == -1) {
         p_869_15_ = p_869_16_ / 2;
         var54 = true;
      }

      int var27 = var25.nextInt(p_869_16_ / 2) + p_869_16_ / 4;

      for(boolean var28 = var25.nextInt(6) == 0; p_869_15_ < p_869_16_; ++p_869_15_) {
         double var29 = 1.5D + (double)(MathHelper.func_1106_a((float)p_869_15_ * 3.1415927F / (float)p_869_16_) * p_869_12_ * 1.0F);
         double var31 = var29 * p_869_17_;
         float var33 = MathHelper.func_1114_b(p_869_14_);
         float var34 = MathHelper.func_1106_a(p_869_14_);
         p_869_6_ += (double)(MathHelper.func_1114_b(p_869_13_) * var33);
         p_869_8_ += (double)var34;
         p_869_10_ += (double)(MathHelper.func_1106_a(p_869_13_) * var33);
         if(var28) {
            p_869_14_ *= 0.92F;
         } else {
            p_869_14_ *= 0.7F;
         }

         p_869_14_ += var24 * 0.1F;
         p_869_13_ += var23 * 0.1F;
         var24 *= 0.9F;
         var23 *= 0.75F;
         var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
         var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
         if(!var54 && p_869_15_ == var27 && p_869_12_ > 1.0F && p_869_16_ > 0) {
            this.func_869_a(var25.nextLong(), p_869_3_, p_869_4_, p_869_5_, p_869_6_, p_869_8_, p_869_10_, var25.nextFloat() * 0.5F + 0.5F, p_869_13_ - 1.5707964F, p_869_14_ / 3.0F, p_869_15_, p_869_16_, 1.0D);
            this.func_869_a(var25.nextLong(), p_869_3_, p_869_4_, p_869_5_, p_869_6_, p_869_8_, p_869_10_, var25.nextFloat() * 0.5F + 0.5F, p_869_13_ + 1.5707964F, p_869_14_ / 3.0F, p_869_15_, p_869_16_, 1.0D);
            return;
         }

         if(var54 || var25.nextInt(4) != 0) {
            double var35 = p_869_6_ - var19;
            double var37 = p_869_10_ - var21;
            double var39 = (double)(p_869_16_ - p_869_15_);
            double var41 = (double)(p_869_12_ + 2.0F + 16.0F);
            if(var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
               return;
            }

            if(p_869_6_ >= var19 - 16.0D - var29 * 2.0D && p_869_10_ >= var21 - 16.0D - var29 * 2.0D && p_869_6_ <= var19 + 16.0D + var29 * 2.0D && p_869_10_ <= var21 + 16.0D + var29 * 2.0D) {
               int var55 = MathHelper.func_1108_b(p_869_6_ - var29) - p_869_3_ * 16 - 1;
               int var36 = MathHelper.func_1108_b(p_869_6_ + var29) - p_869_3_ * 16 + 1;
               int var56 = MathHelper.func_1108_b(p_869_8_ - var31) - 1;
               int var38 = MathHelper.func_1108_b(p_869_8_ + var31) + 1;
               int var57 = MathHelper.func_1108_b(p_869_10_ - var29) - p_869_4_ * 16 - 1;
               int var40 = MathHelper.func_1108_b(p_869_10_ + var29) - p_869_4_ * 16 + 1;
               if(var55 < 0) {
                  var55 = 0;
               }

               if(var36 > 16) {
                  var36 = 16;
               }

               if(var56 < 1) {
                  var56 = 1;
               }

               if(var38 > 120) {
                  var38 = 120;
               }

               if(var57 < 0) {
                  var57 = 0;
               }

               if(var40 > 16) {
                  var40 = 16;
               }

               boolean var58 = false;

               int var42;
               int var45;
               for(var42 = var55; !var58 && var42 < var36; ++var42) {
                  for(int var43 = var57; !var58 && var43 < var40; ++var43) {
                     for(int var44 = var38 + 1; !var58 && var44 >= var56 - 1; --var44) {
                        var45 = (var42 * 16 + var43) * 128 + var44;
                        if(var44 >= 0 && var44 < 128) {
                           if(p_869_5_[var45] == Block.field_401_B.field_376_bc || p_869_5_[var45] == Block.field_399_C.field_376_bc) {
                              var58 = true;
                           }

                           if(var44 != var56 - 1 && var42 != var55 && var42 != var36 - 1 && var43 != var57 && var43 != var40 - 1) {
                              var44 = var56;
                           }
                        }
                     }
                  }
               }

               if(!var58) {
                  for(var42 = var55; var42 < var36; ++var42) {
                     double var59 = ((double)(var42 + p_869_3_ * 16) + 0.5D - p_869_6_) / var29;

                     for(var45 = var57; var45 < var40; ++var45) {
                        double var46 = ((double)(var45 + p_869_4_ * 16) + 0.5D - p_869_10_) / var29;
                        int var48 = (var42 * 16 + var45) * 128 + var38;
                        boolean var49 = false;
                        if(var59 * var59 + var46 * var46 < 1.0D) {
                           for(int var50 = var38 - 1; var50 >= var56; --var50) {
                              double var51 = ((double)var50 + 0.5D - p_869_8_) / var31;
                              if(var51 > -0.7D && var59 * var59 + var51 * var51 + var46 * var46 < 1.0D) {
                                 byte var53 = p_869_5_[var48];
                                 if(var53 == Block.field_337_v.field_376_bc) {
                                    var49 = true;
                                 }

                                 if(var53 == Block.field_338_u.field_376_bc || var53 == Block.field_336_w.field_376_bc || var53 == Block.field_337_v.field_376_bc) {
                                    if(var50 < 10) {
                                       p_869_5_[var48] = (byte)Block.field_397_D.field_376_bc;
                                    } else {
                                       p_869_5_[var48] = 0;
                                       if(var49 && p_869_5_[var48 - 1] == Block.field_336_w.field_376_bc) {
                                          p_869_5_[var48 - 1] = this.field_35625_d.func_48454_a(var42 + p_869_3_ * 16, var45 + p_869_4_ * 16).field_4242_o;
                                       }
                                    }
                                 }
                              }

                              --var48;
                           }
                        }
                     }
                  }

                  if(var54) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_868_a(World p_868_1_, int p_868_2_, int p_868_3_, int p_868_4_, int p_868_5_, byte[] p_868_6_) {
      int var7 = this.field_1305_b.nextInt(this.field_1305_b.nextInt(this.field_1305_b.nextInt(40) + 1) + 1);
      if(this.field_1305_b.nextInt(15) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(p_868_2_ * 16 + this.field_1305_b.nextInt(16));
         double var11 = (double)this.field_1305_b.nextInt(this.field_1305_b.nextInt(120) + 8);
         double var13 = (double)(p_868_3_ * 16 + this.field_1305_b.nextInt(16));
         int var15 = 1;
         if(this.field_1305_b.nextInt(4) == 0) {
            this.func_870_a(this.field_1305_b.nextLong(), p_868_4_, p_868_5_, p_868_6_, var9, var11, var13);
            var15 += this.field_1305_b.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.field_1305_b.nextFloat() * 3.1415927F * 2.0F;
            float var18 = (this.field_1305_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.field_1305_b.nextFloat() * 2.0F + this.field_1305_b.nextFloat();
            if(this.field_1305_b.nextInt(10) == 0) {
               var19 *= this.field_1305_b.nextFloat() * this.field_1305_b.nextFloat() * 3.0F + 1.0F;
            }

            this.func_869_a(this.field_1305_b.nextLong(), p_868_4_, p_868_5_, p_868_6_, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
         }
      }

   }
}
