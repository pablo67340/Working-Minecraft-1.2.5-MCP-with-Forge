package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenTaiga2 extends WorldGenerator {

   public WorldGenTaiga2(boolean p_i565_1_) {
      super(p_i565_1_);
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_2_.nextInt(4) + 6;
      int var7 = 1 + p_516_2_.nextInt(2);
      int var8 = var6 - var7;
      int var9 = 2 + p_516_2_.nextInt(2);
      boolean var10 = true;
      if(p_516_4_ >= 1 && p_516_4_ + var6 + 1 <= 256) {
         int var11;
         int var13;
         int var15;
         int var21;
         for(var11 = p_516_4_; var11 <= p_516_4_ + 1 + var6 && var10; ++var11) {
            boolean var12 = true;
            if(var11 - p_516_4_ < var7) {
               var21 = 0;
            } else {
               var21 = var9;
            }

            for(var13 = p_516_3_ - var21; var13 <= p_516_3_ + var21 && var10; ++var13) {
               for(int var14 = p_516_5_ - var21; var14 <= p_516_5_ + var21 && var10; ++var14) {
                  if(var11 >= 0 && var11 < 256) {
                     var15 = p_516_1_.func_600_a(var13, var11, var14);
                     if(var15 != 0 && var15 != Block.field_384_L.field_376_bc) {
                        var10 = false;
                     }
                  } else {
                     var10 = false;
                  }
               }
            }
         }

         if(!var10) {
            return false;
         } else {
            var11 = p_516_1_.func_600_a(p_516_3_, p_516_4_ - 1, p_516_5_);
            if((var11 == Block.field_337_v.field_376_bc || var11 == Block.field_336_w.field_376_bc) && p_516_4_ < 256 - var6 - 1) {
               this.func_50073_a(p_516_1_, p_516_3_, p_516_4_ - 1, p_516_5_, Block.field_336_w.field_376_bc);
               var21 = p_516_2_.nextInt(2);
               var13 = 1;
               byte var22 = 0;

               int var16;
               int var17;
               for(var15 = 0; var15 <= var8; ++var15) {
                  var16 = p_516_4_ + var6 - var15;

                  for(var17 = p_516_3_ - var21; var17 <= p_516_3_ + var21; ++var17) {
                     int var18 = var17 - p_516_3_;

                     for(int var19 = p_516_5_ - var21; var19 <= p_516_5_ + var21; ++var19) {
                        int var20 = var19 - p_516_5_;
                        if((Math.abs(var18) != var21 || Math.abs(var20) != var21 || var21 <= 0) && !Block.field_343_p[p_516_1_.func_600_a(var17, var16, var19)]) {
                           this.func_41060_a(p_516_1_, var17, var16, var19, Block.field_384_L.field_376_bc, 1);
                        }
                     }
                  }

                  if(var21 >= var13) {
                     var21 = var22;
                     var22 = 1;
                     ++var13;
                     if(var13 > var9) {
                        var13 = var9;
                     }
                  } else {
                     ++var21;
                  }
               }

               var15 = p_516_2_.nextInt(3);

               for(var16 = 0; var16 < var6 - var15; ++var16) {
                  var17 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var16, p_516_5_);
                  if(var17 == 0 || var17 == Block.field_384_L.field_376_bc) {
                     this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var16, p_516_5_, Block.field_385_K.field_376_bc, 1);
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
}
