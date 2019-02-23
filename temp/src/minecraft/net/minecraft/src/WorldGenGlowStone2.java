package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenGlowStone2 extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      if(!p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_)) {
         return false;
      } else if(p_516_1_.func_600_a(p_516_3_, p_516_4_ + 1, p_516_5_) != Block.field_4053_bc.field_376_bc) {
         return false;
      } else {
         p_516_1_.func_690_d(p_516_3_, p_516_4_, p_516_5_, Block.field_4049_be.field_376_bc);

         for(int var6 = 0; var6 < 1500; ++var6) {
            int var7 = p_516_3_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
            int var8 = p_516_4_ - p_516_2_.nextInt(12);
            int var9 = p_516_5_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
            if(p_516_1_.func_600_a(var7, var8, var9) == 0) {
               int var10 = 0;

               for(int var11 = 0; var11 < 6; ++var11) {
                  int var12 = 0;
                  if(var11 == 0) {
                     var12 = p_516_1_.func_600_a(var7 - 1, var8, var9);
                  }

                  if(var11 == 1) {
                     var12 = p_516_1_.func_600_a(var7 + 1, var8, var9);
                  }

                  if(var11 == 2) {
                     var12 = p_516_1_.func_600_a(var7, var8 - 1, var9);
                  }

                  if(var11 == 3) {
                     var12 = p_516_1_.func_600_a(var7, var8 + 1, var9);
                  }

                  if(var11 == 4) {
                     var12 = p_516_1_.func_600_a(var7, var8, var9 - 1);
                  }

                  if(var11 == 5) {
                     var12 = p_516_1_.func_600_a(var7, var8, var9 + 1);
                  }

                  if(var12 == Block.field_4049_be.field_376_bc) {
                     ++var10;
                  }
               }

               if(var10 == 1) {
                  p_516_1_.func_690_d(var7, var8, var9, Block.field_4049_be.field_376_bc);
               }
            }
         }

         return true;
      }
   }
}
