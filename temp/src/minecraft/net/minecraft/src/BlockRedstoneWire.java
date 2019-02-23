package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Direction;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockRedstoneWire extends Block {

   private boolean field_453_a = true;
   private Set field_21031_b = new HashSet();


   public BlockRedstoneWire(int p_i123_1_, int p_i123_2_) {
      super(p_i123_1_, p_i123_2_, Material.field_1324_n);
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return this.field_378_bb;
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
      return 5;
   }

   public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_) {
      return 8388608;
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_28100_h(p_243_2_, p_243_3_ - 1, p_243_4_) || p_243_1_.func_600_a(p_243_2_, p_243_3_ - 1, p_243_4_) == Block.field_4049_be.field_376_bc;
   }

   private void func_280_h(World p_280_1_, int p_280_2_, int p_280_3_, int p_280_4_) {
      this.func_21030_a(p_280_1_, p_280_2_, p_280_3_, p_280_4_, p_280_2_, p_280_3_, p_280_4_);
      ArrayList var5 = new ArrayList(this.field_21031_b);
      this.field_21031_b.clear();

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         ChunkPosition var7 = (ChunkPosition)var5.get(var6);
         p_280_1_.func_611_g(var7.field_1111_a, var7.field_1110_b, var7.field_1112_c, this.field_376_bc);
      }

   }

   private void func_21030_a(World p_21030_1_, int p_21030_2_, int p_21030_3_, int p_21030_4_, int p_21030_5_, int p_21030_6_, int p_21030_7_) {
      int var8 = p_21030_1_.func_602_e(p_21030_2_, p_21030_3_, p_21030_4_);
      int var9 = 0;
      this.field_453_a = false;
      boolean var10 = p_21030_1_.func_625_o(p_21030_2_, p_21030_3_, p_21030_4_);
      this.field_453_a = true;
      int var11;
      int var12;
      int var13;
      if(var10) {
         var9 = 15;
      } else {
         for(var11 = 0; var11 < 4; ++var11) {
            var12 = p_21030_2_;
            var13 = p_21030_4_;
            if(var11 == 0) {
               var12 = p_21030_2_ - 1;
            }

            if(var11 == 1) {
               ++var12;
            }

            if(var11 == 2) {
               var13 = p_21030_4_ - 1;
            }

            if(var11 == 3) {
               ++var13;
            }

            if(var12 != p_21030_5_ || p_21030_3_ != p_21030_6_ || var13 != p_21030_7_) {
               var9 = this.func_281_g(p_21030_1_, var12, p_21030_3_, var13, var9);
            }

            if(p_21030_1_.func_28100_h(var12, p_21030_3_, var13) && !p_21030_1_.func_28100_h(p_21030_2_, p_21030_3_ + 1, p_21030_4_)) {
               if(var12 != p_21030_5_ || p_21030_3_ + 1 != p_21030_6_ || var13 != p_21030_7_) {
                  var9 = this.func_281_g(p_21030_1_, var12, p_21030_3_ + 1, var13, var9);
               }
            } else if(!p_21030_1_.func_28100_h(var12, p_21030_3_, var13) && (var12 != p_21030_5_ || p_21030_3_ - 1 != p_21030_6_ || var13 != p_21030_7_)) {
               var9 = this.func_281_g(p_21030_1_, var12, p_21030_3_ - 1, var13, var9);
            }
         }

         if(var9 > 0) {
            --var9;
         } else {
            var9 = 0;
         }
      }

      if(var8 != var9) {
         p_21030_1_.field_1043_h = true;
         p_21030_1_.func_691_b(p_21030_2_, p_21030_3_, p_21030_4_, var9);
         p_21030_1_.func_701_b(p_21030_2_, p_21030_3_, p_21030_4_, p_21030_2_, p_21030_3_, p_21030_4_);
         p_21030_1_.field_1043_h = false;

         for(var11 = 0; var11 < 4; ++var11) {
            var12 = p_21030_2_;
            var13 = p_21030_4_;
            int var14 = p_21030_3_ - 1;
            if(var11 == 0) {
               var12 = p_21030_2_ - 1;
            }

            if(var11 == 1) {
               ++var12;
            }

            if(var11 == 2) {
               var13 = p_21030_4_ - 1;
            }

            if(var11 == 3) {
               ++var13;
            }

            if(p_21030_1_.func_28100_h(var12, p_21030_3_, var13)) {
               var14 += 2;
            }

            boolean var15 = false;
            int var16 = this.func_281_g(p_21030_1_, var12, p_21030_3_, var13, -1);
            var9 = p_21030_1_.func_602_e(p_21030_2_, p_21030_3_, p_21030_4_);
            if(var9 > 0) {
               --var9;
            }

            if(var16 >= 0 && var16 != var9) {
               this.func_21030_a(p_21030_1_, var12, p_21030_3_, var13, p_21030_2_, p_21030_3_, p_21030_4_);
            }

            var16 = this.func_281_g(p_21030_1_, var12, var14, var13, -1);
            var9 = p_21030_1_.func_602_e(p_21030_2_, p_21030_3_, p_21030_4_);
            if(var9 > 0) {
               --var9;
            }

            if(var16 >= 0 && var16 != var9) {
               this.func_21030_a(p_21030_1_, var12, var14, var13, p_21030_2_, p_21030_3_, p_21030_4_);
            }
         }

         if(var8 < var9 || var9 == 0) {
            this.field_21031_b.add(new ChunkPosition(p_21030_2_, p_21030_3_, p_21030_4_));
            this.field_21031_b.add(new ChunkPosition(p_21030_2_ - 1, p_21030_3_, p_21030_4_));
            this.field_21031_b.add(new ChunkPosition(p_21030_2_ + 1, p_21030_3_, p_21030_4_));
            this.field_21031_b.add(new ChunkPosition(p_21030_2_, p_21030_3_ - 1, p_21030_4_));
            this.field_21031_b.add(new ChunkPosition(p_21030_2_, p_21030_3_ + 1, p_21030_4_));
            this.field_21031_b.add(new ChunkPosition(p_21030_2_, p_21030_3_, p_21030_4_ - 1));
            this.field_21031_b.add(new ChunkPosition(p_21030_2_, p_21030_3_, p_21030_4_ + 1));
         }
      }

   }

   private void func_282_i(World p_282_1_, int p_282_2_, int p_282_3_, int p_282_4_) {
      if(p_282_1_.func_600_a(p_282_2_, p_282_3_, p_282_4_) == this.field_376_bc) {
         p_282_1_.func_611_g(p_282_2_, p_282_3_, p_282_4_, this.field_376_bc);
         p_282_1_.func_611_g(p_282_2_ - 1, p_282_3_, p_282_4_, this.field_376_bc);
         p_282_1_.func_611_g(p_282_2_ + 1, p_282_3_, p_282_4_, this.field_376_bc);
         p_282_1_.func_611_g(p_282_2_, p_282_3_, p_282_4_ - 1, this.field_376_bc);
         p_282_1_.func_611_g(p_282_2_, p_282_3_, p_282_4_ + 1, this.field_376_bc);
         p_282_1_.func_611_g(p_282_2_, p_282_3_ - 1, p_282_4_, this.field_376_bc);
         p_282_1_.func_611_g(p_282_2_, p_282_3_ + 1, p_282_4_, this.field_376_bc);
      }
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      if(!p_235_1_.field_1026_y) {
         this.func_280_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
         p_235_1_.func_611_g(p_235_2_, p_235_3_ + 1, p_235_4_, this.field_376_bc);
         p_235_1_.func_611_g(p_235_2_, p_235_3_ - 1, p_235_4_, this.field_376_bc);
         this.func_282_i(p_235_1_, p_235_2_ - 1, p_235_3_, p_235_4_);
         this.func_282_i(p_235_1_, p_235_2_ + 1, p_235_3_, p_235_4_);
         this.func_282_i(p_235_1_, p_235_2_, p_235_3_, p_235_4_ - 1);
         this.func_282_i(p_235_1_, p_235_2_, p_235_3_, p_235_4_ + 1);
         if(p_235_1_.func_28100_h(p_235_2_ - 1, p_235_3_, p_235_4_)) {
            this.func_282_i(p_235_1_, p_235_2_ - 1, p_235_3_ + 1, p_235_4_);
         } else {
            this.func_282_i(p_235_1_, p_235_2_ - 1, p_235_3_ - 1, p_235_4_);
         }

         if(p_235_1_.func_28100_h(p_235_2_ + 1, p_235_3_, p_235_4_)) {
            this.func_282_i(p_235_1_, p_235_2_ + 1, p_235_3_ + 1, p_235_4_);
         } else {
            this.func_282_i(p_235_1_, p_235_2_ + 1, p_235_3_ - 1, p_235_4_);
         }

         if(p_235_1_.func_28100_h(p_235_2_, p_235_3_, p_235_4_ - 1)) {
            this.func_282_i(p_235_1_, p_235_2_, p_235_3_ + 1, p_235_4_ - 1);
         } else {
            this.func_282_i(p_235_1_, p_235_2_, p_235_3_ - 1, p_235_4_ - 1);
         }

         if(p_235_1_.func_28100_h(p_235_2_, p_235_3_, p_235_4_ + 1)) {
            this.func_282_i(p_235_1_, p_235_2_, p_235_3_ + 1, p_235_4_ + 1);
         } else {
            this.func_282_i(p_235_1_, p_235_2_, p_235_3_ - 1, p_235_4_ + 1);
         }

      }
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
      if(!p_214_1_.field_1026_y) {
         p_214_1_.func_611_g(p_214_2_, p_214_3_ + 1, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_ - 1, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_ + 1, p_214_3_, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_ - 1, p_214_3_, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_ + 1, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_ - 1, this.field_376_bc);
         this.func_280_h(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
         this.func_282_i(p_214_1_, p_214_2_ - 1, p_214_3_, p_214_4_);
         this.func_282_i(p_214_1_, p_214_2_ + 1, p_214_3_, p_214_4_);
         this.func_282_i(p_214_1_, p_214_2_, p_214_3_, p_214_4_ - 1);
         this.func_282_i(p_214_1_, p_214_2_, p_214_3_, p_214_4_ + 1);
         if(p_214_1_.func_28100_h(p_214_2_ - 1, p_214_3_, p_214_4_)) {
            this.func_282_i(p_214_1_, p_214_2_ - 1, p_214_3_ + 1, p_214_4_);
         } else {
            this.func_282_i(p_214_1_, p_214_2_ - 1, p_214_3_ - 1, p_214_4_);
         }

         if(p_214_1_.func_28100_h(p_214_2_ + 1, p_214_3_, p_214_4_)) {
            this.func_282_i(p_214_1_, p_214_2_ + 1, p_214_3_ + 1, p_214_4_);
         } else {
            this.func_282_i(p_214_1_, p_214_2_ + 1, p_214_3_ - 1, p_214_4_);
         }

         if(p_214_1_.func_28100_h(p_214_2_, p_214_3_, p_214_4_ - 1)) {
            this.func_282_i(p_214_1_, p_214_2_, p_214_3_ + 1, p_214_4_ - 1);
         } else {
            this.func_282_i(p_214_1_, p_214_2_, p_214_3_ - 1, p_214_4_ - 1);
         }

         if(p_214_1_.func_28100_h(p_214_2_, p_214_3_, p_214_4_ + 1)) {
            this.func_282_i(p_214_1_, p_214_2_, p_214_3_ + 1, p_214_4_ + 1);
         } else {
            this.func_282_i(p_214_1_, p_214_2_, p_214_3_ - 1, p_214_4_ + 1);
         }

      }
   }

   private int func_281_g(World p_281_1_, int p_281_2_, int p_281_3_, int p_281_4_, int p_281_5_) {
      if(p_281_1_.func_600_a(p_281_2_, p_281_3_, p_281_4_) != this.field_376_bc) {
         return p_281_5_;
      } else {
         int var6 = p_281_1_.func_602_e(p_281_2_, p_281_3_, p_281_4_);
         return var6 > p_281_5_?var6:p_281_5_;
      }
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y) {
         int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
         boolean var7 = this.func_243_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
         if(!var7) {
            this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var6, 0);
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         } else {
            this.func_280_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
         }

         super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_309_aA.field_291_aS;
   }

   public boolean func_228_c(World p_228_1_, int p_228_2_, int p_228_3_, int p_228_4_, int p_228_5_) {
      return !this.field_453_a?false:this.func_231_b(p_228_1_, p_228_2_, p_228_3_, p_228_4_, p_228_5_);
   }

   public boolean func_231_b(IBlockAccess p_231_1_, int p_231_2_, int p_231_3_, int p_231_4_, int p_231_5_) {
      if(!this.field_453_a) {
         return false;
      } else if(p_231_1_.func_602_e(p_231_2_, p_231_3_, p_231_4_) == 0) {
         return false;
      } else if(p_231_5_ == 1) {
         return true;
      } else {
         boolean var6 = func_41053_d(p_231_1_, p_231_2_ - 1, p_231_3_, p_231_4_, 1) || !p_231_1_.func_28100_h(p_231_2_ - 1, p_231_3_, p_231_4_) && func_41053_d(p_231_1_, p_231_2_ - 1, p_231_3_ - 1, p_231_4_, -1);
         boolean var7 = func_41053_d(p_231_1_, p_231_2_ + 1, p_231_3_, p_231_4_, 3) || !p_231_1_.func_28100_h(p_231_2_ + 1, p_231_3_, p_231_4_) && func_41053_d(p_231_1_, p_231_2_ + 1, p_231_3_ - 1, p_231_4_, -1);
         boolean var8 = func_41053_d(p_231_1_, p_231_2_, p_231_3_, p_231_4_ - 1, 2) || !p_231_1_.func_28100_h(p_231_2_, p_231_3_, p_231_4_ - 1) && func_41053_d(p_231_1_, p_231_2_, p_231_3_ - 1, p_231_4_ - 1, -1);
         boolean var9 = func_41053_d(p_231_1_, p_231_2_, p_231_3_, p_231_4_ + 1, 0) || !p_231_1_.func_28100_h(p_231_2_, p_231_3_, p_231_4_ + 1) && func_41053_d(p_231_1_, p_231_2_, p_231_3_ - 1, p_231_4_ + 1, -1);
         if(!p_231_1_.func_28100_h(p_231_2_, p_231_3_ + 1, p_231_4_)) {
            if(p_231_1_.func_28100_h(p_231_2_ - 1, p_231_3_, p_231_4_) && func_41053_d(p_231_1_, p_231_2_ - 1, p_231_3_ + 1, p_231_4_, -1)) {
               var6 = true;
            }

            if(p_231_1_.func_28100_h(p_231_2_ + 1, p_231_3_, p_231_4_) && func_41053_d(p_231_1_, p_231_2_ + 1, p_231_3_ + 1, p_231_4_, -1)) {
               var7 = true;
            }

            if(p_231_1_.func_28100_h(p_231_2_, p_231_3_, p_231_4_ - 1) && func_41053_d(p_231_1_, p_231_2_, p_231_3_ + 1, p_231_4_ - 1, -1)) {
               var8 = true;
            }

            if(p_231_1_.func_28100_h(p_231_2_, p_231_3_, p_231_4_ + 1) && func_41053_d(p_231_1_, p_231_2_, p_231_3_ + 1, p_231_4_ + 1, -1)) {
               var9 = true;
            }
         }

         return !var8 && !var7 && !var6 && !var9 && p_231_5_ >= 2 && p_231_5_ <= 5?true:(p_231_5_ == 2 && var8 && !var6 && !var7?true:(p_231_5_ == 3 && var9 && !var6 && !var7?true:(p_231_5_ == 4 && var6 && !var8 && !var9?true:p_231_5_ == 5 && var7 && !var8 && !var9)));
      }
   }

   public boolean func_209_d() {
      return this.field_453_a;
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      int var6 = p_247_1_.func_602_e(p_247_2_, p_247_3_, p_247_4_);
      if(var6 > 0) {
         double var7 = (double)p_247_2_ + 0.5D + ((double)p_247_5_.nextFloat() - 0.5D) * 0.2D;
         double var9 = (double)((float)p_247_3_ + 0.0625F);
         double var11 = (double)p_247_4_ + 0.5D + ((double)p_247_5_.nextFloat() - 0.5D) * 0.2D;
         float var13 = (float)var6 / 15.0F;
         float var14 = var13 * 0.6F + 0.4F;
         if(var6 == 0) {
            var14 = 0.0F;
         }

         float var15 = var13 * var13 * 0.7F - 0.5F;
         float var16 = var13 * var13 * 0.6F - 0.7F;
         if(var15 < 0.0F) {
            var15 = 0.0F;
         }

         if(var16 < 0.0F) {
            var16 = 0.0F;
         }

         p_247_1_.func_694_a("reddust", var7, var9, var11, (double)var14, (double)var15, (double)var16);
      }

   }

   public static boolean func_279_b(IBlockAccess p_279_0_, int p_279_1_, int p_279_2_, int p_279_3_, int p_279_4_) {
      int var5 = p_279_0_.func_600_a(p_279_1_, p_279_2_, p_279_3_);
      if(var5 == Block.field_394_aw.field_376_bc) {
         return true;
      } else if(var5 == 0) {
         return false;
      } else if(var5 != Block.field_22021_bh.field_376_bc && var5 != Block.field_22020_bi.field_376_bc) {
         return Block.field_345_n[var5].func_209_d() && p_279_4_ != -1;
      } else {
         int var6 = p_279_0_.func_602_e(p_279_1_, p_279_2_, p_279_3_);
         return p_279_4_ == (var6 & 3) || p_279_4_ == Direction.field_22279_b[var6 & 3];
      }
   }

   public static boolean func_41053_d(IBlockAccess p_41053_0_, int p_41053_1_, int p_41053_2_, int p_41053_3_, int p_41053_4_) {
      if(func_279_b(p_41053_0_, p_41053_1_, p_41053_2_, p_41053_3_, p_41053_4_)) {
         return true;
      } else {
         int var5 = p_41053_0_.func_600_a(p_41053_1_, p_41053_2_, p_41053_3_);
         if(var5 == Block.field_22020_bi.field_376_bc) {
            int var6 = p_41053_0_.func_602_e(p_41053_1_, p_41053_2_, p_41053_3_);
            return p_41053_4_ == (var6 & 3);
         } else {
            return false;
         }
      }
   }
}
