package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class Teleporter {

   private Random field_4232_a = new Random();


   public void func_4107_a(World p_4107_1_, Entity p_4107_2_) {
      if(p_4107_1_.field_4209_q.field_4218_e != 1) {
         if(!this.func_4106_b(p_4107_1_, p_4107_2_)) {
            this.func_4108_c(p_4107_1_, p_4107_2_);
            this.func_4106_b(p_4107_1_, p_4107_2_);
         }
      } else {
         int var3 = MathHelper.func_1108_b(p_4107_2_.field_611_ak);
         int var4 = MathHelper.func_1108_b(p_4107_2_.field_610_al) - 1;
         int var5 = MathHelper.func_1108_b(p_4107_2_.field_609_am);
         byte var6 = 1;
         byte var7 = 0;

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               for(int var10 = -1; var10 < 3; ++var10) {
                  int var11 = var3 + var9 * var6 + var8 * var7;
                  int var12 = var4 + var10;
                  int var13 = var5 + var9 * var7 - var8 * var6;
                  boolean var14 = var10 < 0;
                  p_4107_1_.func_690_d(var11, var12, var13, var14?Block.field_405_aq.field_376_bc:0);
               }
            }
         }

         p_4107_2_.func_365_c((double)var3, (double)var4, (double)var5, p_4107_2_.field_605_aq, 0.0F);
         p_4107_2_.field_608_an = p_4107_2_.field_607_ao = p_4107_2_.field_606_ap = 0.0D;
      }
   }

   public boolean func_4106_b(World p_4106_1_, Entity p_4106_2_) {
      short var3 = 128;
      double var4 = -1.0D;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = MathHelper.func_1108_b(p_4106_2_.field_611_ak);
      int var10 = MathHelper.func_1108_b(p_4106_2_.field_609_am);

      double var18;
      for(int var11 = var9 - var3; var11 <= var9 + var3; ++var11) {
         double var12 = (double)var11 + 0.5D - p_4106_2_.field_611_ak;

         for(int var14 = var10 - var3; var14 <= var10 + var3; ++var14) {
            double var15 = (double)var14 + 0.5D - p_4106_2_.field_609_am;

            for(int var17 = 127; var17 >= 0; --var17) {
               if(p_4106_1_.func_600_a(var11, var17, var14) == Block.field_4047_bf.field_376_bc) {
                  while(p_4106_1_.func_600_a(var11, var17 - 1, var14) == Block.field_4047_bf.field_376_bc) {
                     --var17;
                  }

                  var18 = (double)var17 + 0.5D - p_4106_2_.field_610_al;
                  double var20 = var12 * var12 + var18 * var18 + var15 * var15;
                  if(var4 < 0.0D || var20 < var4) {
                     var4 = var20;
                     var6 = var11;
                     var7 = var17;
                     var8 = var14;
                  }
               }
            }
         }
      }

      if(var4 >= 0.0D) {
         double var22 = (double)var6 + 0.5D;
         double var16 = (double)var7 + 0.5D;
         var18 = (double)var8 + 0.5D;
         if(p_4106_1_.func_600_a(var6 - 1, var7, var8) == Block.field_4047_bf.field_376_bc) {
            var22 -= 0.5D;
         }

         if(p_4106_1_.func_600_a(var6 + 1, var7, var8) == Block.field_4047_bf.field_376_bc) {
            var22 += 0.5D;
         }

         if(p_4106_1_.func_600_a(var6, var7, var8 - 1) == Block.field_4047_bf.field_376_bc) {
            var18 -= 0.5D;
         }

         if(p_4106_1_.func_600_a(var6, var7, var8 + 1) == Block.field_4047_bf.field_376_bc) {
            var18 += 0.5D;
         }

         p_4106_2_.func_365_c(var22, var16, var18, p_4106_2_.field_605_aq, 0.0F);
         p_4106_2_.field_608_an = p_4106_2_.field_607_ao = p_4106_2_.field_606_ap = 0.0D;
         return true;
      } else {
         return false;
      }
   }

   public boolean func_4108_c(World p_4108_1_, Entity p_4108_2_) {
      byte var3 = 16;
      double var4 = -1.0D;
      int var6 = MathHelper.func_1108_b(p_4108_2_.field_611_ak);
      int var7 = MathHelper.func_1108_b(p_4108_2_.field_610_al);
      int var8 = MathHelper.func_1108_b(p_4108_2_.field_609_am);
      int var9 = var6;
      int var10 = var7;
      int var11 = var8;
      int var12 = 0;
      int var13 = this.field_4232_a.nextInt(4);

      int var14;
      double var15;
      int var17;
      double var18;
      int var20;
      int var21;
      int var22;
      int var23;
      int var24;
      int var25;
      int var26;
      int var27;
      int var28;
      double var32;
      double var33;
      for(var14 = var6 - var3; var14 <= var6 + var3; ++var14) {
         var15 = (double)var14 + 0.5D - p_4108_2_.field_611_ak;

         for(var17 = var8 - var3; var17 <= var8 + var3; ++var17) {
            var18 = (double)var17 + 0.5D - p_4108_2_.field_609_am;

            label274:
            for(var20 = 127; var20 >= 0; --var20) {
               if(p_4108_1_.func_20084_d(var14, var20, var17)) {
                  while(var20 > 0 && p_4108_1_.func_20084_d(var14, var20 - 1, var17)) {
                     --var20;
                  }

                  for(var21 = var13; var21 < var13 + 4; ++var21) {
                     var22 = var21 % 2;
                     var23 = 1 - var22;
                     if(var21 % 4 >= 2) {
                        var22 = -var22;
                        var23 = -var23;
                     }

                     for(var24 = 0; var24 < 3; ++var24) {
                        for(var25 = 0; var25 < 4; ++var25) {
                           for(var26 = -1; var26 < 4; ++var26) {
                              var27 = var14 + (var25 - 1) * var22 + var24 * var23;
                              var28 = var20 + var26;
                              int var29 = var17 + (var25 - 1) * var23 - var24 * var22;
                              if(var26 < 0 && !p_4108_1_.func_599_f(var27, var28, var29).func_878_a() || var26 >= 0 && !p_4108_1_.func_20084_d(var27, var28, var29)) {
                                 continue label274;
                              }
                           }
                        }
                     }

                     var32 = (double)var20 + 0.5D - p_4108_2_.field_610_al;
                     var33 = var15 * var15 + var32 * var32 + var18 * var18;
                     if(var4 < 0.0D || var33 < var4) {
                        var4 = var33;
                        var9 = var14;
                        var10 = var20;
                        var11 = var17;
                        var12 = var21 % 4;
                     }
                  }
               }
            }
         }
      }

      if(var4 < 0.0D) {
         for(var14 = var6 - var3; var14 <= var6 + var3; ++var14) {
            var15 = (double)var14 + 0.5D - p_4108_2_.field_611_ak;

            for(var17 = var8 - var3; var17 <= var8 + var3; ++var17) {
               var18 = (double)var17 + 0.5D - p_4108_2_.field_609_am;

               label222:
               for(var20 = 127; var20 >= 0; --var20) {
                  if(p_4108_1_.func_20084_d(var14, var20, var17)) {
                     while(var20 > 0 && p_4108_1_.func_20084_d(var14, var20 - 1, var17)) {
                        --var20;
                     }

                     for(var21 = var13; var21 < var13 + 2; ++var21) {
                        var22 = var21 % 2;
                        var23 = 1 - var22;

                        for(var24 = 0; var24 < 4; ++var24) {
                           for(var25 = -1; var25 < 4; ++var25) {
                              var26 = var14 + (var24 - 1) * var22;
                              var27 = var20 + var25;
                              var28 = var17 + (var24 - 1) * var23;
                              if(var25 < 0 && !p_4108_1_.func_599_f(var26, var27, var28).func_878_a() || var25 >= 0 && !p_4108_1_.func_20084_d(var26, var27, var28)) {
                                 continue label222;
                              }
                           }
                        }

                        var32 = (double)var20 + 0.5D - p_4108_2_.field_610_al;
                        var33 = var15 * var15 + var32 * var32 + var18 * var18;
                        if(var4 < 0.0D || var33 < var4) {
                           var4 = var33;
                           var9 = var14;
                           var10 = var20;
                           var11 = var17;
                           var12 = var21 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int var30 = var9;
      int var16 = var10;
      var17 = var11;
      int var31 = var12 % 2;
      int var19 = 1 - var31;
      if(var12 % 4 >= 2) {
         var31 = -var31;
         var19 = -var19;
      }

      boolean var34;
      if(var4 < 0.0D) {
         if(var10 < 70) {
            var10 = 70;
         }

         if(var10 > 118) {
            var10 = 118;
         }

         var16 = var10;

         for(var20 = -1; var20 <= 1; ++var20) {
            for(var21 = 1; var21 < 3; ++var21) {
               for(var22 = -1; var22 < 3; ++var22) {
                  var23 = var30 + (var21 - 1) * var31 + var20 * var19;
                  var24 = var16 + var22;
                  var25 = var17 + (var21 - 1) * var19 - var20 * var31;
                  var34 = var22 < 0;
                  p_4108_1_.func_690_d(var23, var24, var25, var34?Block.field_405_aq.field_376_bc:0);
               }
            }
         }
      }

      for(var20 = 0; var20 < 4; ++var20) {
         p_4108_1_.field_1043_h = true;

         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var30 + (var21 - 1) * var31;
               var24 = var16 + var22;
               var25 = var17 + (var21 - 1) * var19;
               var34 = var21 == 0 || var21 == 3 || var22 == -1 || var22 == 3;
               p_4108_1_.func_690_d(var23, var24, var25, var34?Block.field_405_aq.field_376_bc:Block.field_4047_bf.field_376_bc);
            }
         }

         p_4108_1_.field_1043_h = false;

         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var30 + (var21 - 1) * var31;
               var24 = var16 + var22;
               var25 = var17 + (var21 - 1) * var19;
               p_4108_1_.func_611_g(var23, var24, var25, p_4108_1_.func_600_a(var23, var24, var25));
            }
         }
      }

      return true;
   }
}
