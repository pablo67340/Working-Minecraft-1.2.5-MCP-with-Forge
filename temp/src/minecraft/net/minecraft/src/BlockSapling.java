package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenForest;
import net.minecraft.src.WorldGenHugeTrees;
import net.minecraft.src.WorldGenTaiga2;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public class BlockSapling extends BlockFlower {

   protected BlockSapling(int p_i714_1_, int p_i714_2_) {
      super(p_i714_1_, p_i714_2_);
      float var3 = 0.4F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y) {
         super.func_208_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
         if(p_208_1_.func_618_j(p_208_2_, p_208_3_ + 1, p_208_4_) >= 9 && p_208_5_.nextInt(7) == 0) {
            int var6 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
            if((var6 & 8) == 0) {
               p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var6 | 8);
            } else {
               this.func_21028_c(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
            }
         }

      }
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      p_232_2_ &= 3;
      return p_232_2_ == 1?63:(p_232_2_ == 2?79:(p_232_2_ == 3?30:super.func_232_a(p_232_1_, p_232_2_)));
   }

   public void func_21028_c(World p_21028_1_, int p_21028_2_, int p_21028_3_, int p_21028_4_, Random p_21028_5_) {
      int var6 = p_21028_1_.func_602_e(p_21028_2_, p_21028_3_, p_21028_4_) & 3;
      Object var7 = null;
      int var8 = 0;
      int var9 = 0;
      boolean var10 = false;
      if(var6 == 1) {
         var7 = new WorldGenTaiga2(true);
      } else if(var6 == 2) {
         var7 = new WorldGenForest(true);
      } else if(var6 == 3) {
         for(var8 = 0; var8 >= -1; --var8) {
            for(var9 = 0; var9 >= -1; --var9) {
               if(this.func_50076_f(p_21028_1_, p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9, 3) && this.func_50076_f(p_21028_1_, p_21028_2_ + var8 + 1, p_21028_3_, p_21028_4_ + var9, 3) && this.func_50076_f(p_21028_1_, p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9 + 1, 3) && this.func_50076_f(p_21028_1_, p_21028_2_ + var8 + 1, p_21028_3_, p_21028_4_ + var9 + 1, 3)) {
                  var7 = new WorldGenHugeTrees(true, 10 + p_21028_5_.nextInt(20), 3, 3);
                  var10 = true;
                  break;
               }
            }

            if(var7 != null) {
               break;
            }
         }

         if(var7 == null) {
            var9 = 0;
            var8 = 0;
            var7 = new WorldGenTrees(true, 4 + p_21028_5_.nextInt(7), 3, 3, false);
         }
      } else {
         var7 = new WorldGenTrees(true);
         if(p_21028_5_.nextInt(10) == 0) {
            var7 = new WorldGenBigTree(true);
         }
      }

      if(var10) {
         p_21028_1_.func_634_a(p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9, 0);
         p_21028_1_.func_634_a(p_21028_2_ + var8 + 1, p_21028_3_, p_21028_4_ + var9, 0);
         p_21028_1_.func_634_a(p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9 + 1, 0);
         p_21028_1_.func_634_a(p_21028_2_ + var8 + 1, p_21028_3_, p_21028_4_ + var9 + 1, 0);
      } else {
         p_21028_1_.func_634_a(p_21028_2_, p_21028_3_, p_21028_4_, 0);
      }

      if(!((WorldGenerator)var7).func_516_a(p_21028_1_, p_21028_5_, p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9)) {
         if(var10) {
            p_21028_1_.func_643_a(p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9, this.field_376_bc, var6);
            p_21028_1_.func_643_a(p_21028_2_ + var8 + 1, p_21028_3_, p_21028_4_ + var9, this.field_376_bc, var6);
            p_21028_1_.func_643_a(p_21028_2_ + var8, p_21028_3_, p_21028_4_ + var9 + 1, this.field_376_bc, var6);
            p_21028_1_.func_643_a(p_21028_2_ + var8 + 1, p_21028_3_, p_21028_4_ + var9 + 1, this.field_376_bc, var6);
         } else {
            p_21028_1_.func_643_a(p_21028_2_, p_21028_3_, p_21028_4_, this.field_376_bc, var6);
         }
      }

   }

   public boolean func_50076_f(World p_50076_1_, int p_50076_2_, int p_50076_3_, int p_50076_4_, int p_50076_5_) {
      return p_50076_1_.func_600_a(p_50076_2_, p_50076_3_, p_50076_4_) == this.field_376_bc && (p_50076_1_.func_602_e(p_50076_2_, p_50076_3_, p_50076_4_) & 3) == p_50076_5_;
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_ & 3;
   }
}
