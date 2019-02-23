package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockGrass extends Block {

   protected BlockGrass(int p_i563_1_) {
      super(p_i563_1_, Material.field_28130_b);
      this.field_378_bb = 3;
      this.func_253_b(true);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1?0:(p_232_1_ == 0?2:3);
   }

   public int func_211_a(IBlockAccess p_211_1_, int p_211_2_, int p_211_3_, int p_211_4_, int p_211_5_) {
      if(p_211_5_ == 1) {
         return 0;
      } else if(p_211_5_ == 0) {
         return 2;
      } else {
         Material var6 = p_211_1_.func_599_f(p_211_2_, p_211_3_ + 1, p_211_4_);
         return var6 != Material.field_1319_s && var6 != Material.field_1318_t?3:68;
      }
   }

   public int func_35274_i() {
      double var1 = 0.5D;
      double var3 = 1.0D;
      return ColorizerGrass.func_4147_a(var1, var3);
   }

   public int func_31030_b(int p_31030_1_) {
      return this.func_35274_i();
   }

   public int func_207_d(IBlockAccess p_207_1_, int p_207_2_, int p_207_3_, int p_207_4_) {
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;

      for(int var8 = -1; var8 <= 1; ++var8) {
         for(int var9 = -1; var9 <= 1; ++var9) {
            int var10 = p_207_1_.func_48454_a(p_207_2_ + var9, p_207_4_ + var8).func_48415_j();
            var5 += (var10 & 16711680) >> 16;
            var6 += (var10 & '\uff00') >> 8;
            var7 += var10 & 255;
         }
      }

      return (var5 / 9 & 255) << 16 | (var6 / 9 & 255) << 8 | var7 / 9 & 255;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y) {
         if(p_208_1_.func_618_j(p_208_2_, p_208_3_ + 1, p_208_4_) < 4 && Block.field_341_r[p_208_1_.func_600_a(p_208_2_, p_208_3_ + 1, p_208_4_)] > 2) {
            p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, Block.field_336_w.field_376_bc);
         } else if(p_208_1_.func_618_j(p_208_2_, p_208_3_ + 1, p_208_4_) >= 9) {
            for(int var6 = 0; var6 < 4; ++var6) {
               int var7 = p_208_2_ + p_208_5_.nextInt(3) - 1;
               int var8 = p_208_3_ + p_208_5_.nextInt(5) - 3;
               int var9 = p_208_4_ + p_208_5_.nextInt(3) - 1;
               int var10 = p_208_1_.func_600_a(var7, var8 + 1, var9);
               if(p_208_1_.func_600_a(var7, var8, var9) == Block.field_336_w.field_376_bc && p_208_1_.func_618_j(var7, var8 + 1, var9) >= 4 && Block.field_341_r[var10] <= 2) {
                  p_208_1_.func_690_d(var7, var8, var9, Block.field_337_v.field_376_bc);
               }
            }
         }

      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_336_w.func_240_a(0, p_240_2_, p_240_3_);
   }
}
