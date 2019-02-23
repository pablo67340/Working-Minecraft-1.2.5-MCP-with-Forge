package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenReed extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      for(int var6 = 0; var6 < 20; ++var6) {
         int var7 = p_516_3_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         int var8 = p_516_4_;
         int var9 = p_516_5_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         if(p_516_1_.func_20084_d(var7, p_516_4_, var9) && (p_516_1_.func_599_f(var7 - 1, p_516_4_ - 1, var9) == Material.field_1332_f || p_516_1_.func_599_f(var7 + 1, p_516_4_ - 1, var9) == Material.field_1332_f || p_516_1_.func_599_f(var7, p_516_4_ - 1, var9 - 1) == Material.field_1332_f || p_516_1_.func_599_f(var7, p_516_4_ - 1, var9 + 1) == Material.field_1332_f)) {
            int var10 = 2 + p_516_2_.nextInt(p_516_2_.nextInt(3) + 1);

            for(int var11 = 0; var11 < var10; ++var11) {
               if(Block.field_423_aY.func_223_g(p_516_1_, var7, var8 + var11, var9)) {
                  p_516_1_.func_634_a(var7, var8 + var11, var9, Block.field_423_aY.field_376_bc);
               }
            }
         }
      }

      return true;
   }
}
