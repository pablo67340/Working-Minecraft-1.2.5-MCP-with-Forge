package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenHugeTrees extends WorldGenerator {

   private final int field_48195_a;
   private final int field_48193_b;
   private final int field_48194_c;


   public WorldGenHugeTrees(boolean p_i1015_1_, int p_i1015_2_, int p_i1015_3_, int p_i1015_4_) {
      super(p_i1015_1_);
      this.field_48195_a = p_i1015_2_;
      this.field_48193_b = p_i1015_3_;
      this.field_48194_c = p_i1015_4_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_2_.nextInt(3) + this.field_48195_a;
      boolean var7 = true;
      if(p_516_4_ >= 1 && p_516_4_ + var6 + 1 <= 256) {
         int var8;
         int var10;
         int var11;
         int var12;
         for(var8 = p_516_4_; var8 <= p_516_4_ + 1 + var6; ++var8) {
            byte var9 = 2;
            if(var8 == p_516_4_) {
               var9 = 1;
            }

            if(var8 >= p_516_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(var10 = p_516_3_ - var9; var10 <= p_516_3_ + var9 && var7; ++var10) {
               for(var11 = p_516_5_ - var9; var11 <= p_516_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     var12 = p_516_1_.func_600_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_384_L.field_376_bc && var12 != Block.field_337_v.field_376_bc && var12 != Block.field_336_w.field_376_bc && var12 != Block.field_385_K.field_376_bc && var12 != Block.field_333_z.field_376_bc) {
                        var7 = false;
                     }
                  } else {
                     var7 = false;
                  }
               }
            }
         }

         if(!var7) {
            return false;
         } else {
            var8 = p_516_1_.func_600_a(p_516_3_, p_516_4_ - 1, p_516_5_);
            if((var8 == Block.field_337_v.field_376_bc || var8 == Block.field_336_w.field_376_bc) && p_516_4_ < 256 - var6 - 1) {
               p_516_1_.func_634_a(p_516_3_, p_516_4_ - 1, p_516_5_, Block.field_336_w.field_376_bc);
               p_516_1_.func_634_a(p_516_3_ + 1, p_516_4_ - 1, p_516_5_, Block.field_336_w.field_376_bc);
               p_516_1_.func_634_a(p_516_3_, p_516_4_ - 1, p_516_5_ + 1, Block.field_336_w.field_376_bc);
               p_516_1_.func_634_a(p_516_3_ + 1, p_516_4_ - 1, p_516_5_ + 1, Block.field_336_w.field_376_bc);
               this.func_48192_a(p_516_1_, p_516_3_, p_516_5_, p_516_4_ + var6, 2, p_516_2_);

               for(int var14 = p_516_4_ + var6 - 2 - p_516_2_.nextInt(4); var14 > p_516_4_ + var6 / 2; var14 -= 2 + p_516_2_.nextInt(4)) {
                  float var15 = p_516_2_.nextFloat() * 3.1415927F * 2.0F;
                  var11 = p_516_3_ + (int)(0.5F + MathHelper.func_1114_b(var15) * 4.0F);
                  var12 = p_516_5_ + (int)(0.5F + MathHelper.func_1106_a(var15) * 4.0F);
                  this.func_48192_a(p_516_1_, var11, var12, var14, 0, p_516_2_);

                  for(int var13 = 0; var13 < 5; ++var13) {
                     var11 = p_516_3_ + (int)(1.5F + MathHelper.func_1114_b(var15) * (float)var13);
                     var12 = p_516_5_ + (int)(1.5F + MathHelper.func_1106_a(var15) * (float)var13);
                     this.func_41060_a(p_516_1_, var11, var14 - 3 + var13 / 2, var12, Block.field_385_K.field_376_bc, this.field_48193_b);
                  }
               }

               for(var10 = 0; var10 < var6; ++var10) {
                  var11 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var10, p_516_5_);
                  if(var11 == 0 || var11 == Block.field_384_L.field_376_bc) {
                     this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var10, p_516_5_, Block.field_385_K.field_376_bc, this.field_48193_b);
                     if(var10 > 0) {
                        if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ - 1, p_516_4_ + var10, p_516_5_)) {
                           this.func_41060_a(p_516_1_, p_516_3_ - 1, p_516_4_ + var10, p_516_5_, Block.field_35278_bv.field_376_bc, 8);
                        }

                        if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_, p_516_4_ + var10, p_516_5_ - 1)) {
                           this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var10, p_516_5_ - 1, Block.field_35278_bv.field_376_bc, 1);
                        }
                     }
                  }

                  if(var10 < var6 - 1) {
                     var11 = p_516_1_.func_600_a(p_516_3_ + 1, p_516_4_ + var10, p_516_5_);
                     if(var11 == 0 || var11 == Block.field_384_L.field_376_bc) {
                        this.func_41060_a(p_516_1_, p_516_3_ + 1, p_516_4_ + var10, p_516_5_, Block.field_385_K.field_376_bc, this.field_48193_b);
                        if(var10 > 0) {
                           if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ + 2, p_516_4_ + var10, p_516_5_)) {
                              this.func_41060_a(p_516_1_, p_516_3_ + 2, p_516_4_ + var10, p_516_5_, Block.field_35278_bv.field_376_bc, 2);
                           }

                           if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ + 1, p_516_4_ + var10, p_516_5_ - 1)) {
                              this.func_41060_a(p_516_1_, p_516_3_ + 1, p_516_4_ + var10, p_516_5_ - 1, Block.field_35278_bv.field_376_bc, 1);
                           }
                        }
                     }

                     var11 = p_516_1_.func_600_a(p_516_3_ + 1, p_516_4_ + var10, p_516_5_ + 1);
                     if(var11 == 0 || var11 == Block.field_384_L.field_376_bc) {
                        this.func_41060_a(p_516_1_, p_516_3_ + 1, p_516_4_ + var10, p_516_5_ + 1, Block.field_385_K.field_376_bc, this.field_48193_b);
                        if(var10 > 0) {
                           if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ + 2, p_516_4_ + var10, p_516_5_ + 1)) {
                              this.func_41060_a(p_516_1_, p_516_3_ + 2, p_516_4_ + var10, p_516_5_ + 1, Block.field_35278_bv.field_376_bc, 2);
                           }

                           if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ + 1, p_516_4_ + var10, p_516_5_ + 2)) {
                              this.func_41060_a(p_516_1_, p_516_3_ + 1, p_516_4_ + var10, p_516_5_ + 2, Block.field_35278_bv.field_376_bc, 4);
                           }
                        }
                     }

                     var11 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var10, p_516_5_ + 1);
                     if(var11 == 0 || var11 == Block.field_384_L.field_376_bc) {
                        this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var10, p_516_5_ + 1, Block.field_385_K.field_376_bc, this.field_48193_b);
                        if(var10 > 0) {
                           if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ - 1, p_516_4_ + var10, p_516_5_ + 1)) {
                              this.func_41060_a(p_516_1_, p_516_3_ - 1, p_516_4_ + var10, p_516_5_ + 1, Block.field_35278_bv.field_376_bc, 8);
                           }

                           if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_, p_516_4_ + var10, p_516_5_ + 2)) {
                              this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var10, p_516_5_ + 2, Block.field_35278_bv.field_376_bc, 4);
                           }
                        }
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void func_48192_a(World p_48192_1_, int p_48192_2_, int p_48192_3_, int p_48192_4_, int p_48192_5_, Random p_48192_6_) {
      byte var7 = 2;

      for(int var8 = p_48192_4_ - var7; var8 <= p_48192_4_; ++var8) {
         int var9 = var8 - p_48192_4_;
         int var10 = p_48192_5_ + 1 - var9;

         for(int var11 = p_48192_2_ - var10; var11 <= p_48192_2_ + var10 + 1; ++var11) {
            int var12 = var11 - p_48192_2_;

            for(int var13 = p_48192_3_ - var10; var13 <= p_48192_3_ + var10 + 1; ++var13) {
               int var14 = var13 - p_48192_3_;
               if((var12 >= 0 || var14 >= 0 || var12 * var12 + var14 * var14 <= var10 * var10) && (var12 <= 0 && var14 <= 0 || var12 * var12 + var14 * var14 <= (var10 + 1) * (var10 + 1)) && (p_48192_6_.nextInt(4) != 0 || var12 * var12 + var14 * var14 <= (var10 - 1) * (var10 - 1)) && !Block.field_343_p[p_48192_1_.func_600_a(var11, var8, var13)]) {
                  this.func_41060_a(p_48192_1_, var11, var8, var13, Block.field_384_L.field_376_bc, this.field_48194_c);
               }
            }
         }
      }

   }
}
