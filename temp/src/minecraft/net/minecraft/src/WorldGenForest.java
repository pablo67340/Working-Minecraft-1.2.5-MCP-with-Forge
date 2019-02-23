package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenForest extends WorldGenerator {

   public WorldGenForest(boolean p_i396_1_) {
      super(p_i396_1_);
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_2_.nextInt(3) + 5;
      boolean var7 = true;
      if(p_516_4_ >= 1 && p_516_4_ + var6 + 1 <= 256) {
         int var8;
         int var10;
         int var11;
         int var12;
         for(var8 = p_516_4_; var8 <= p_516_4_ + 1 + var6; ++var8) {
            byte var9 = 1;
            if(var8 == p_516_4_) {
               var9 = 0;
            }

            if(var8 >= p_516_4_ + 1 + var6 - 2) {
               var9 = 2;
            }

            for(var10 = p_516_3_ - var9; var10 <= p_516_3_ + var9 && var7; ++var10) {
               for(var11 = p_516_5_ - var9; var11 <= p_516_5_ + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 256) {
                     var12 = p_516_1_.func_600_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_384_L.field_376_bc) {
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

               int var16;
               for(var16 = p_516_4_ - 3 + var6; var16 <= p_516_4_ + var6; ++var16) {
                  var10 = var16 - (p_516_4_ + var6);
                  var11 = 1 - var10 / 2;

                  for(var12 = p_516_3_ - var11; var12 <= p_516_3_ + var11; ++var12) {
                     int var13 = var12 - p_516_3_;

                     for(int var14 = p_516_5_ - var11; var14 <= p_516_5_ + var11; ++var14) {
                        int var15 = var14 - p_516_5_;
                        if((Math.abs(var13) != var11 || Math.abs(var15) != var11 || p_516_2_.nextInt(2) != 0 && var10 != 0) && !Block.field_343_p[p_516_1_.func_600_a(var12, var16, var14)]) {
                           this.func_41060_a(p_516_1_, var12, var16, var14, Block.field_384_L.field_376_bc, 2);
                        }
                     }
                  }
               }

               for(var16 = 0; var16 < var6; ++var16) {
                  var10 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var16, p_516_5_);
                  if(var10 == 0 || var10 == Block.field_384_L.field_376_bc) {
                     this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var16, p_516_5_, Block.field_385_K.field_376_bc, 2);
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
