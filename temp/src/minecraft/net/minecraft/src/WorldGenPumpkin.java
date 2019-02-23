package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenPumpkin extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      for(int var6 = 0; var6 < 64; ++var6) {
         int var7 = p_516_3_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         int var8 = p_516_4_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         int var9 = p_516_5_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         if(p_516_1_.func_20084_d(var7, var8, var9) && p_516_1_.func_600_a(var7, var8 - 1, var9) == Block.field_337_v.field_376_bc && Block.field_4055_bb.func_243_a(p_516_1_, var7, var8, var9)) {
            p_516_1_.func_643_a(var7, var8, var9, Block.field_4055_bb.field_376_bc, p_516_2_.nextInt(4));
         }
      }

      return true;
   }
}
