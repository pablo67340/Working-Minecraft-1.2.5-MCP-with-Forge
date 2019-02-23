package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenFlowers extends WorldGenerator {

   private int field_885_a;


   public WorldGenFlowers(int p_i619_1_) {
      this.field_885_a = p_i619_1_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      for(int var6 = 0; var6 < 64; ++var6) {
         int var7 = p_516_3_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         int var8 = p_516_4_ + p_516_2_.nextInt(4) - p_516_2_.nextInt(4);
         int var9 = p_516_5_ + p_516_2_.nextInt(8) - p_516_2_.nextInt(8);
         if(p_516_1_.func_20084_d(var7, var8, var9) && ((BlockFlower)Block.field_345_n[this.field_885_a]).func_223_g(p_516_1_, var7, var8, var9)) {
            p_516_1_.func_634_a(var7, var8, var9, this.field_885_a);
         }
      }

      return true;
   }
}
