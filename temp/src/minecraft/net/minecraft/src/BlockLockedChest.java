package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLockedChest extends Block {

   protected BlockLockedChest(int p_i775_1_) {
      super(p_i775_1_, Material.field_1335_c);
      this.field_378_bb = 26;
   }

   public int func_211_a(IBlockAccess p_211_1_, int p_211_2_, int p_211_3_, int p_211_4_, int p_211_5_) {
      if(p_211_5_ == 1) {
         return this.field_378_bb - 1;
      } else if(p_211_5_ == 0) {
         return this.field_378_bb - 1;
      } else {
         int var6 = p_211_1_.func_600_a(p_211_2_, p_211_3_, p_211_4_ - 1);
         int var7 = p_211_1_.func_600_a(p_211_2_, p_211_3_, p_211_4_ + 1);
         int var8 = p_211_1_.func_600_a(p_211_2_ - 1, p_211_3_, p_211_4_);
         int var9 = p_211_1_.func_600_a(p_211_2_ + 1, p_211_3_, p_211_4_);
         byte var10 = 3;
         if(Block.field_343_p[var6] && !Block.field_343_p[var7]) {
            var10 = 3;
         }

         if(Block.field_343_p[var7] && !Block.field_343_p[var6]) {
            var10 = 2;
         }

         if(Block.field_343_p[var8] && !Block.field_343_p[var9]) {
            var10 = 5;
         }

         if(Block.field_343_p[var9] && !Block.field_343_p[var8]) {
            var10 = 4;
         }

         return p_211_5_ == var10?this.field_378_bb + 1:this.field_378_bb;
      }
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb - 1:(p_218_1_ == 0?this.field_378_bb - 1:(p_218_1_ == 3?this.field_378_bb + 1:this.field_378_bb));
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return true;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
   }
}
