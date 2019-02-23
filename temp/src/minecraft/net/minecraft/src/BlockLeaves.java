package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockLeavesBase;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class BlockLeaves extends BlockLeavesBase {

   private int field_463_b;
   int[] field_20017_a;


   protected BlockLeaves(int p_i622_1_, int p_i622_2_) {
      super(p_i622_1_, p_i622_2_, Material.field_4265_h, false);
      this.field_463_b = p_i622_2_;
      this.func_253_b(true);
   }

   public int func_35274_i() {
      double var1 = 0.5D;
      double var3 = 1.0D;
      return ColorizerFoliage.func_4146_a(var1, var3);
   }

   public int func_31030_b(int p_31030_1_) {
      return (p_31030_1_ & 3) == 1?ColorizerFoliage.func_21175_a():((p_31030_1_ & 3) == 2?ColorizerFoliage.func_21174_b():ColorizerFoliage.func_31073_c());
   }

   public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_) {
      int var5 = p_207_1_.func_602_e(p_207_2_, p_207_3_, p_207_4_);
      if((var5 & 3) == 1) {
         return ColorizerFoliage.func_21175_a();
      } else if((var5 & 3) == 2) {
         return ColorizerFoliage.func_21174_b();
      } else {
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;

         for(int var9 = -1; var9 <= 1; ++var9) {
            for(int var10 = -1; var10 <= 1; ++var10) {
               int var11 = p_207_1_.func_48454_a(p_207_2_ + var10, p_207_4_ + var9).func_48412_k();
               var6 += (var11 & 16711680) >> 16;
               var7 += (var11 & '\uff00') >> 8;
               var8 += var11 & 255;
            }
         }

         return (var6 / 9 & 255) << 16 | (var7 / 9 & 255) << 8 | var8 / 9 & 255;
      }
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      byte var5 = 1;
      int var6 = var5 + 1;
      if(p_214_1_.func_640_a(p_214_2_ - var6, p_214_3_ - var6, p_214_4_ - var6, p_214_2_ + var6, p_214_3_ + var6, p_214_4_ + var6)) {
         for(int var7 = -var5; var7 <= var5; ++var7) {
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  int var10 = p_214_1_.func_600_a(p_214_2_ + var7, p_214_3_ + var8, p_214_4_ + var9);
                  if(var10 == Block.field_384_L.field_376_bc) {
                     int var11 = p_214_1_.func_602_e(p_214_2_ + var7, p_214_3_ + var8, p_214_4_ + var9);
                     p_214_1_.func_635_c(p_214_2_ + var7, p_214_3_ + var8, p_214_4_ + var9, var11 | 8);
                  }
               }
            }
         }
      }

   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y) {
         int var6 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         if((var6 & 8) != 0 && (var6 & 4) == 0) {
            byte var7 = 4;
            int var8 = var7 + 1;
            byte var9 = 32;
            int var10 = var9 * var9;
            int var11 = var9 / 2;
            if(this.field_20017_a == null) {
               this.field_20017_a = new int[var9 * var9 * var9];
            }

            int var12;
            if(p_208_1_.func_640_a(p_208_2_ - var8, p_208_3_ - var8, p_208_4_ - var8, p_208_2_ + var8, p_208_3_ + var8, p_208_4_ + var8)) {
               int var13;
               int var14;
               int var15;
               for(var12 = -var7; var12 <= var7; ++var12) {
                  for(var13 = -var7; var13 <= var7; ++var13) {
                     for(var14 = -var7; var14 <= var7; ++var14) {
                        var15 = p_208_1_.func_600_a(p_208_2_ + var12, p_208_3_ + var13, p_208_4_ + var14);
                        if(var15 == Block.field_385_K.field_376_bc) {
                           this.field_20017_a[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                        } else if(var15 == Block.field_384_L.field_376_bc) {
                           this.field_20017_a[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                        } else {
                           this.field_20017_a[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                        }
                     }
                  }
               }

               for(var12 = 1; var12 <= 4; ++var12) {
                  for(var13 = -var7; var13 <= var7; ++var13) {
                     for(var14 = -var7; var14 <= var7; ++var14) {
                        for(var15 = -var7; var15 <= var7; ++var15) {
                           if(this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
                              if(this.field_20017_a[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                 this.field_20017_a[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                              }

                              if(this.field_20017_a[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
                                 this.field_20017_a[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                              }

                              if(this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
                                 this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                              }

                              if(this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
                                 this.field_20017_a[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                              }

                              if(this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
                                 this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                              }

                              if(this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
                                 this.field_20017_a[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                              }
                           }
                        }
                     }
                  }
               }
            }

            var12 = this.field_20017_a[var11 * var10 + var11 * var9 + var11];
            if(var12 >= 0) {
               p_208_1_.func_635_c(p_208_2_, p_208_3_, p_208_4_, var6 & -9);
            } else {
               this.func_6360_i(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
            }
         }

      }
   }

   private void func_6360_i(World p_6360_1_, int p_6360_2_, int p_6360_3_, int p_6360_4_) {
      this.func_259_b_(p_6360_1_, p_6360_2_, p_6360_3_, p_6360_4_, p_6360_1_.func_602_e(p_6360_2_, p_6360_3_, p_6360_4_), 0);
      p_6360_1_.func_690_d(p_6360_2_, p_6360_3_, p_6360_4_, 0);
   }

   public int func_229_a(Random p_229_1_) {
      return p_229_1_.nextInt(20) == 0?1:0;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_333_z.field_376_bc;
   }

   public void func_216_a(World p_216_1_, int p_216_2_, int p_216_3_, int p_216_4_, int p_216_5_, float p_216_6_, int p_216_7_) {
      if(!p_216_1_.field_1026_y) {
         byte var8 = 20;
         if((p_216_5_ & 3) == 3) {
            var8 = 40;
         }

         if(p_216_1_.field_1037_n.nextInt(var8) == 0) {
            int var9 = this.func_240_a(p_216_5_, p_216_1_.field_1037_n, p_216_7_);
            this.func_31027_a(p_216_1_, p_216_2_, p_216_3_, p_216_4_, new ItemStack(var9, 1, this.func_21025_b(p_216_5_)));
         }

         if((p_216_5_ & 3) == 0 && p_216_1_.field_1037_n.nextInt(200) == 0) {
            this.func_31027_a(p_216_1_, p_216_2_, p_216_3_, p_216_4_, new ItemStack(Item.field_228_h, 1, 0));
         }
      }

   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      if(!p_220_1_.field_1026_y && p_220_2_.func_6416_v() != null && p_220_2_.func_6416_v().field_1617_c == Item.field_31001_bc.field_291_aS) {
         p_220_2_.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
         this.func_31027_a(p_220_1_, p_220_3_, p_220_4_, p_220_5_, new ItemStack(Block.field_384_L.field_376_bc, 1, p_220_6_ & 3));
      } else {
         super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
      }

   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_ & 3;
   }

   public boolean func_217_b() {
      return !this.field_6359_a;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return (p_232_2_ & 3) == 1?this.field_378_bb + 80:((p_232_2_ & 3) == 3?this.field_378_bb + 144:this.field_378_bb);
   }

   public void func_310_a(boolean p_310_1_) {
      this.field_6359_a = p_310_1_;
      this.field_378_bb = this.field_463_b + (p_310_1_?0:1);
   }

   public void func_254_a(World p_254_1_, int p_254_2_, int p_254_3_, int p_254_4_, Entity p_254_5_) {
      super.func_254_a(p_254_1_, p_254_2_, p_254_3_, p_254_4_, p_254_5_);
   }
}
