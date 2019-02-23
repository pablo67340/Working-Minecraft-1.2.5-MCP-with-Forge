package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenDesertWells extends WorldGenerator {

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      while(p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_) && p_516_4_ > 2) {
         --p_516_4_;
      }

      int var6 = p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_);
      if(var6 != Block.field_393_F.field_376_bc) {
         return false;
      } else {
         int var7;
         int var8;
         for(var7 = -2; var7 <= 2; ++var7) {
            for(var8 = -2; var8 <= 2; ++var8) {
               if(p_516_1_.func_20084_d(p_516_3_ + var7, p_516_4_ - 1, p_516_5_ + var8) && p_516_1_.func_20084_d(p_516_3_ + var7, p_516_4_ - 2, p_516_5_ + var8)) {
                  return false;
               }
            }
         }

         for(var7 = -1; var7 <= 0; ++var7) {
            for(var8 = -2; var8 <= 2; ++var8) {
               for(int var9 = -2; var9 <= 2; ++var9) {
                  p_516_1_.func_634_a(p_516_3_ + var8, p_516_4_ + var7, p_516_5_ + var9, Block.field_9264_Q.field_376_bc);
               }
            }
         }

         p_516_1_.func_634_a(p_516_3_, p_516_4_, p_516_5_, Block.field_401_B.field_376_bc);
         p_516_1_.func_634_a(p_516_3_ - 1, p_516_4_, p_516_5_, Block.field_401_B.field_376_bc);
         p_516_1_.func_634_a(p_516_3_ + 1, p_516_4_, p_516_5_, Block.field_401_B.field_376_bc);
         p_516_1_.func_634_a(p_516_3_, p_516_4_, p_516_5_ - 1, Block.field_401_B.field_376_bc);
         p_516_1_.func_634_a(p_516_3_, p_516_4_, p_516_5_ + 1, Block.field_401_B.field_376_bc);

         for(var7 = -2; var7 <= 2; ++var7) {
            for(var8 = -2; var8 <= 2; ++var8) {
               if(var7 == -2 || var7 == 2 || var8 == -2 || var8 == 2) {
                  p_516_1_.func_634_a(p_516_3_ + var7, p_516_4_ + 1, p_516_5_ + var8, Block.field_9264_Q.field_376_bc);
               }
            }
         }

         p_516_1_.func_643_a(p_516_3_ + 2, p_516_4_ + 1, p_516_5_, Block.field_410_al.field_376_bc, 1);
         p_516_1_.func_643_a(p_516_3_ - 2, p_516_4_ + 1, p_516_5_, Block.field_410_al.field_376_bc, 1);
         p_516_1_.func_643_a(p_516_3_, p_516_4_ + 1, p_516_5_ + 2, Block.field_410_al.field_376_bc, 1);
         p_516_1_.func_643_a(p_516_3_, p_516_4_ + 1, p_516_5_ - 2, Block.field_410_al.field_376_bc, 1);

         for(var7 = -1; var7 <= 1; ++var7) {
            for(var8 = -1; var8 <= 1; ++var8) {
               if(var7 == 0 && var8 == 0) {
                  p_516_1_.func_634_a(p_516_3_ + var7, p_516_4_ + 4, p_516_5_ + var8, Block.field_9264_Q.field_376_bc);
               } else {
                  p_516_1_.func_643_a(p_516_3_ + var7, p_516_4_ + 4, p_516_5_ + var8, Block.field_410_al.field_376_bc, 1);
               }
            }
         }

         for(var7 = 1; var7 <= 3; ++var7) {
            p_516_1_.func_634_a(p_516_3_ - 1, p_516_4_ + var7, p_516_5_ - 1, Block.field_9264_Q.field_376_bc);
            p_516_1_.func_634_a(p_516_3_ - 1, p_516_4_ + var7, p_516_5_ + 1, Block.field_9264_Q.field_376_bc);
            p_516_1_.func_634_a(p_516_3_ + 1, p_516_4_ + var7, p_516_5_ - 1, Block.field_9264_Q.field_376_bc);
            p_516_1_.func_634_a(p_516_3_ + 1, p_516_4_ + var7, p_516_5_ + 1, Block.field_9264_Q.field_376_bc);
         }

         return true;
      }
   }
}
