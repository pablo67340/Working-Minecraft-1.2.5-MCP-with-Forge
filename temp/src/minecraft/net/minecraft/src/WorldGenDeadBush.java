package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenDeadBush extends WorldGenerator {

   private int field_28058_a;


   public WorldGenDeadBush(int p_i776_1_) {
      this.field_28058_a = p_i776_1_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var11;
      for(boolean var6 = false; ((var11 = p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_)) == 0 || var11 == Block.field_384_L.field_376_bc) && p_516_4_ > 0; --p_516_4_) {
         ;
      }

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_516_3_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         int var9 = p_516_4_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         int var10 = p_516_5_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         if(p_516_1_.func_20084_d(var8, var9, var10) && ((BlockFlower)Block.field_345_n[this.field_28058_a]).func_223_g(p_516_1_, var8, var9, var10)) {
            p_516_1_.func_634_a(var8, var9, var10, this.field_28058_a);
         }
      }

      return true;
   }
}
