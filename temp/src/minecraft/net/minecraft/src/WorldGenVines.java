package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Direction;
import net.minecraft.src.Facing;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenVines extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var6 = p_516_3_;

      for(int var7 = p_516_5_; p_516_4_ < 128; ++p_516_4_) {
         if(p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_)) {
            for(int var8 = 2; var8 <= 5; ++var8) {
               if(Block.field_35278_bv.func_28030_e(p_516_1_, p_516_3_, p_516_4_, p_516_5_, var8)) {
                  p_516_1_.func_643_a(p_516_3_, p_516_4_, p_516_5_, Block.field_35278_bv.field_376_bc, 1 << Direction.field_35869_d[Facing.field_31057_a[var8]]);
                  break;
               }
            }
         } else {
            p_516_3_ = var6 + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
            p_516_5_ = var7 + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         }
      }

      return true;
   }
}
