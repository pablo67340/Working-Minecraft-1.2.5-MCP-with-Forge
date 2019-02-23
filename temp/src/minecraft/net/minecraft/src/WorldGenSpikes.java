package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenSpikes extends WorldGenerator {

   private int field_40197_a;


   public WorldGenSpikes(int p_i62_1_) {
      this.field_40197_a = p_i62_1_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      if(p_516_1_.func_20084_d(p_516_3_, p_516_4_, p_516_5_) && p_516_1_.func_600_a(p_516_3_, p_516_4_ - 1, p_516_5_) == this.field_40197_a) {
         int var6 = p_516_2_.nextInt(32) + 6;
         int var7 = p_516_2_.nextInt(4) + 1;

         int var8;
         int var9;
         int var10;
         int var11;
         for(var8 = p_516_3_ - var7; var8 <= p_516_3_ + var7; ++var8) {
            for(var9 = p_516_5_ - var7; var9 <= p_516_5_ + var7; ++var9) {
               var10 = var8 - p_516_3_;
               var11 = var9 - p_516_5_;
               if(var10 * var10 + var11 * var11 <= var7 * var7 + 1 && p_516_1_.func_600_a(var8, p_516_4_ - 1, var9) != this.field_40197_a) {
                  return false;
               }
            }
         }

         for(var8 = p_516_4_; var8 < p_516_4_ + var6 && var8 < 128; ++var8) {
            for(var9 = p_516_3_ - var7; var9 <= p_516_3_ + var7; ++var9) {
               for(var10 = p_516_5_ - var7; var10 <= p_516_5_ + var7; ++var10) {
                  var11 = var9 - p_516_3_;
                  int var12 = var10 - p_516_5_;
                  if(var11 * var11 + var12 * var12 <= var7 * var7 + 1) {
                     p_516_1_.func_690_d(var9, var8, var10, Block.field_405_aq.field_376_bc);
                  }
               }
            }
         }

         EntityEnderCrystal var13 = new EntityEnderCrystal(p_516_1_);
         var13.func_365_c((double)((float)p_516_3_ + 0.5F), (double)(p_516_4_ + var6), (double)((float)p_516_5_ + 0.5F), p_516_2_.nextFloat() * 360.0F, 0.0F);
         p_516_1_.func_674_a(var13);
         p_516_1_.func_690_d(p_516_3_, p_516_4_ + var6, p_516_5_, Block.field_403_A.field_376_bc);
         return true;
      } else {
         return false;
      }
   }
}
