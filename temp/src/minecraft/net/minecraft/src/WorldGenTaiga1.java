package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenTaiga1 extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_2_.nextInt(5) + 7;
      int var7 = var6 - p_516_2_.nextInt(2) - 3;
      int var8 = var6 - var7;
      int var9 = 1 + p_516_2_.nextInt(var8 + 1);
      boolean var10 = true;
      if(p_516_4_ >= 1 && p_516_4_ + var6 + 1 <= 128) {
         int var11;
         int var13;
         int var14;
         int var15;
         int var18;
         for(var11 = p_516_4_; var11 <= p_516_4_ + 1 + var6 && var10; ++var11) {
            boolean var12 = true;
            if(var11 - p_516_4_ < var7) {
               var18 = 0;
            } else {
               var18 = var9;
            }

            for(var13 = p_516_3_ - var18; var13 <= p_516_3_ + var18 && var10; ++var13) {
               for(var14 = p_516_5_ - var18; var14 <= p_516_5_ + var18 && var10; ++var14) {
                  if(var11 >= 0 && var11 < 128) {
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
            if((var11 == Block.field_337_v.field_376_bc || var11 == Block.field_336_w.field_376_bc) && p_516_4_ < 128 - var6 - 1) {
               this.func_50073_a(p_516_1_, p_516_3_, p_516_4_ - 1, p_516_5_, Block.field_336_w.field_376_bc);
               var18 = 0;

               for(var13 = p_516_4_ + var6; var13 >= p_516_4_ + var7; --var13) {
                  for(var14 = p_516_3_ - var18; var14 <= p_516_3_ + var18; ++var14) {
                     var15 = var14 - p_516_3_;

                     for(int var16 = p_516_5_ - var18; var16 <= p_516_5_ + var18; ++var16) {
                        int var17 = var16 - p_516_5_;
                        if((Math.abs(var15) != var18 || Math.abs(var17) != var18 || var18 <= 0) && !Block.field_343_p[p_516_1_.func_600_a(var14, var13, var16)]) {
                           this.func_41060_a(p_516_1_, var14, var13, var16, Block.field_384_L.field_376_bc, 1);
                        }
                     }
                  }

                  if(var18 >= 1 && var13 == p_516_4_ + var7 + 1) {
                     --var18;
                  } else if(var18 < var9) {
                     ++var18;
                  }
               }

               for(var13 = 0; var13 < var6 - 1; ++var13) {
                  var14 = p_516_1_.func_600_a(p_516_3_, p_516_4_ + var13, p_516_5_);
                  if(var14 == 0 || var14 == Block.field_384_L.field_376_bc) {
                     this.func_41060_a(p_516_1_, p_516_3_, p_516_4_ + var13, p_516_5_, Block.field_385_K.field_376_bc, 1);
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
