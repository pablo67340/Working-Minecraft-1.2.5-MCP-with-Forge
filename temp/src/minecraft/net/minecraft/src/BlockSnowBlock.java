package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSnowBlock extends Block {

   protected BlockSnowBlock(int p_i728_1_, int p_i728_2_) {
      super(p_i728_1_, p_i728_2_, Material.field_1318_t);
      this.func_253_b(true);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_308_aB.field_291_aS;
   }

   public int func_229_a(Random p_229_1_) {
      return 4;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(p_208_1_.func_641_a(EnumSkyBlock.Block, p_208_2_, p_208_3_, p_208_4_) > 11) {
         this.func_259_b_(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_), 0);
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
      }

   }
}
