package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenClay extends WorldGenerator {

   private int field_867_a;
   private int field_866_b;


   public WorldGenClay(int p_i390_1_) {
      this.field_867_a = Block.field_424_aX.field_376_bc;
      this.field_866_b = p_i390_1_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      if(p_516_1_.func_599_f(p_516_3_, p_516_4_, p_516_5_) != Material.field_1332_f) {
         return false;
      } else {
         int var6 = p_516_2_.nextInt(this.field_866_b - 2) + 2;
         byte var7 = 1;

         for(int var8 = p_516_3_ - var6; var8 <= p_516_3_ + var6; ++var8) {
            for(int var9 = p_516_5_ - var6; var9 <= p_516_5_ + var6; ++var9) {
               int var10 = var8 - p_516_3_;
               int var11 = var9 - p_516_5_;
               if(var10 * var10 + var11 * var11 <= var6 * var6) {
                  for(int var12 = p_516_4_ - var7; var12 <= p_516_4_ + var7; ++var12) {
                     int var13 = p_516_1_.func_600_a(var8, var12, var9);
                     if(var13 == Block.field_336_w.field_376_bc || var13 == Block.field_424_aX.field_376_bc) {
                        p_516_1_.func_634_a(var8, var12, var9, this.field_867_a);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
