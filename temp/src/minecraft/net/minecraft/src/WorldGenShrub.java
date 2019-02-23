package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class WorldGenShrub extends WorldGenerator {

   private int field_48197_a;
   private int field_48196_b;


   public WorldGenShrub(int p_i1008_1_, int p_i1008_2_) {
      this.field_48196_b = p_i1008_1_;
      this.field_48197_a = p_i1008_2_;
   }

   public boolean func_516_a(World p_516_1_, Random p_516_2_, int p_516_3_, int p_516_4_, int p_516_5_) {
      int var15;
      for(boolean var6 = false; ((var15 = p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_)) == 0 || var15 == Block.field_384_L.field_376_bc) && p_516_4_ > 0; --p_516_4_) {
         ;
      }

      int var7 = p_516_1_.func_600_a(p_516_3_, p_516_4_, p_516_5_);
      if(var7 == Block.field_336_w.field_376_bc || var7 == Block.field_337_v.field_376_bc) {
         ++p_516_4_;
         this.func_41060_a(p_516_1_, p_516_3_, p_516_4_, p_516_5_, Block.field_385_K.field_376_bc, this.field_48196_b);

         for(int var8 = p_516_4_; var8 <= p_516_4_ + 2; ++var8) {
            int var9 = var8 - p_516_4_;
            int var10 = 2 - var9;

            for(int var11 = p_516_3_ - var10; var11 <= p_516_3_ + var10; ++var11) {
               int var12 = var11 - p_516_3_;

               for(int var13 = p_516_5_ - var10; var13 <= p_516_5_ + var10; ++var13) {
                  int var14 = var13 - p_516_5_;
                  if((Math.abs(var12) != var10 || Math.abs(var14) != var10 || p_516_2_.nextInt(2) != 0) && !Block.field_343_p[p_516_1_.func_600_a(var11, var8, var13)]) {
                     this.func_41060_a(p_516_1_, var11, var8, var13, Block.field_384_L.field_376_bc, this.field_48197_a);
                  }
               }
            }
         }
      }

      return true;
   }
}
