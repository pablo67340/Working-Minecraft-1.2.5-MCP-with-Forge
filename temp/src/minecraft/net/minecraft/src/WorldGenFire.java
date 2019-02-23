package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenFire extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      for(int var6 = 0; var6 < 64; ++var6) {
         int var7 = p_516_3_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         int var8 = p_516_4_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         int var9 = p_516_5_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         if(p_516_1_.func_20084_d(var7, var8, var9) && p_516_1_.func_600_a(var7, var8 - 1, var9) == Block.field_4053_bc.field_376_bc) {
            p_516_1_.func_690_d(var7, var8, var9, Block.field_402_as.field_376_bc);
         }
      }

      return true;
   }
}
