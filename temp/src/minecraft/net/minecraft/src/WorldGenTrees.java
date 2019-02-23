package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenTrees extends WorldGenerator {

   private final int field_48202_a;
   private final boolean field_48200_b;
   private final int field_48201_c;
   private final int field_48199_d;


   public WorldGenTrees(boolean p_i586_1_) {
      this(p_i586_1_, 4, 0, 0, false);
   }

   public WorldGenTrees(boolean p_i1064_1_, int p_i1064_2_, int p_i1064_3_, int p_i1064_4_, boolean p_i1064_5_) {
      super(p_i1064_1_);
      this.field_48202_a = p_i1064_2_;
      this.field_48201_c = p_i1064_3_;
      this.field_48199_d = p_i1064_4_;
      this.field_48200_b = p_i1064_5_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_2_.nextInt(3) + this.field_48202_a;
      boolean var7 = true;
      if(p_516_4_ >= 1 && p_516_4_ + var6 + 1 <= 256) {
         int var8;
         byte var9;
         int var11;
         int var12;
         for(var8 = p_516_4_; var8 <= p_516_4_ + 1 + var6; ++var8) {
            var9 = 1;
            if(var8 == p_516_4_) {
               var9 = 0;
            }

            if(var8 >= p_516_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(int var10 = p_516_3_ - var9; var10 <= p_516_3_ + var9 && var7; ++var10) {
               for(var11 = p_516_5_ - var9; var11 <= p_516_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     var12 = p_516_1_.func_600_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_384_L.field_376_bc && var12 != Block.field_337_v.field_376_bc && var12 != Block.field_336_w.field_376_bc && var12 != Block.field_385_K.field_376_bc) {
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
               this.func_50073_a(p_516_1_, p_516_3_, p_516_4_ - 1, p_516_5_, Block.field_336_w.field_376_bc);
               var9 = 3;
               byte var18 = 0;

               int var13;
               int var14;
               int var15;
               for(var11 = p_516_4_ - var9 + var6; var11 <= p_516_4_ + var6; ++var11) {
                  var12 = var11 - (p_516_4_ + var6);
                  var13 = var18 + 1 - var12 / 2;

                  for(var14 = p_516_3_ - var13; var14 <= p_516_3_ + var13; ++var14) {
                     var15 = var14 - p_516_3_;

                     for(int var16 = p_516_5_ - var13; var16 <= p_516_5_ + var13; ++var16) {
                        int var17 = var16 - p_516_5_;
                        if((Math.abs(var15) != var13 || Math.abs(var17) != var13 || p_516_2_.nextInt(2) != 0 && var12 != 0) && !Block.field_343_p[p_516_1_.func_600_a(var14, var11, var16)]) {
                           this.func_41060_a(p_516_1_, var14, var11, var16, Block.field_384_L.field_376_bc, this.field_48199_d);
                        }
                     }
                  }
               }

               for(var11 = 0; var11 < var6; ++var11) {
                  var12 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var11, p_516_5_);
                  if(var12 == 0 || var12 == Block.field_384_L.field_376_bc) {
                     this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var11, p_516_5_, Block.field_385_K.field_376_bc, this.field_48201_c);
                     if(this.field_48200_b && var11 > 0) {
                        if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ - 1, p_516_4_ + var11, p_516_5_)) {
                           this.func_41060_a(p_516_1_, p_516_3_ - 1, p_516_4_ + var11, p_516_5_, Block.field_35278_bv.field_376_bc, 8);
                        }

                        if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_ + 1, p_516_4_ + var11, p_516_5_)) {
                           this.func_41060_a(p_516_1_, p_516_3_ + 1, p_516_4_ + var11, p_516_5_, Block.field_35278_bv.field_376_bc, 2);
                        }

                        if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_, p_516_4_ + var11, p_516_5_ - 1)) {
                           this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var11, p_516_5_ - 1, Block.field_35278_bv.field_376_bc, 1);
                        }

                        if(p_516_2_.nextInt(3) > 0 && p_516_1_.func_20084_d(p_516_3_, p_516_4_ + var11, p_516_5_ + 1)) {
                           this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var11, p_516_5_ + 1, Block.field_35278_bv.field_376_bc, 4);
                        }
                     }
                  }
               }

               if(this.field_48200_b) {
                  for(var11 = p_516_4_ - 3 + var6; var11 <= p_516_4_ + var6; ++var11) {
                     var12 = var11 - (p_516_4_ + var6);
                     var13 = 2 - var12 / 2;

                     for(var14 = p_516_3_ - var13; var14 <= p_516_3_ + var13; ++var14) {
                        for(var15 = p_516_5_ - var13; var15 <= p_516_5_ + var13; ++var15) {
                           if(p_516_1_.func_600_a(var14, var11, var15) == Block.field_384_L.field_376_bc) {
                              if(p_516_2_.nextInt(4) == 0 && p_516_1_.func_600_a(var14 - 1, var11, var15) == 0) {
                                 this.func_48198_a(p_516_1_, var14 - 1, var11, var15, 8);
                              }

                              if(p_516_2_.nextInt(4) == 0 && p_516_1_.func_600_a(var14 + 1, var11, var15) == 0) {
                                 this.func_48198_a(p_516_1_, var14 + 1, var11, var15, 2);
                              }

                              if(p_516_2_.nextInt(4) == 0 && p_516_1_.func_600_a(var14, var11, var15 - 1) == 0) {
                                 this.func_48198_a(p_516_1_, var14, var11, var15 - 1, 1);
                              }

                              if(p_516_2_.nextInt(4) == 0 && p_516_1_.func_600_a(var14, var11, var15 + 1) == 0) {
                                 this.func_48198_a(p_516_1_, var14, var11, var15 + 1, 4);
                              }
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

   private void func_48198_a(World p_48198_1_, int p_48198_2_, int p_48198_3_, int p_48198_4_, int p_48198_5_) {
      this.func_41060_a(p_48198_1_, p_48198_2_, p_48198_3_, p_48198_4_, Block.field_35278_bv.field_376_bc, p_48198_5_);
      int var6 = 4;

      while(true) {
         --p_48198_3_;
         if(p_48198_1_.func_600_a(p_48198_2_, p_48198_3_, p_48198_4_) != 0 || var6 <= 0) {
            return;
         }

         this.func_41060_a(p_48198_1_, p_48198_2_, p_48198_3_, p_48198_4_, Block.field_35278_bv.field_376_bc, p_48198_5_);
         --var6;
      }
   }
}
