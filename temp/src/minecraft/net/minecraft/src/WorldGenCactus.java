package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenCactus extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      for(int var6 = 0; var6 < 10; ++var6) {
         int var7 = p_516_3_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         int var8 = p_516_4_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         int var9 = p_516_5_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         if(p_516_1_.func_20084_d(var7, var8, var9)) {
            int var10 = 1 + p_516_2_.nextInt(p_516_2_.nextInt(3) + 1);

            for(int var11 = 0; var11 < var10; ++var11) {
               if(Block.field_425_aW.func_223_g(p_516_1_, var7, var8 + var11, var9)) {
                  p_516_1_.func_634_a(var7, var8 + var11, var9, Block.field_425_aW.field_376_bc);
               }
            }
         }
      }

      return true;
   }
}
