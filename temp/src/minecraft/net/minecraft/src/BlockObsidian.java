package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockStone;

public class BlockObsidian extends BlockStone {

   public BlockObsidian(int p_i672_1_, int p_i672_2_) {
      super(p_i672_1_, p_i672_2_);
   }

   public int func_229_a(Random p_229_1_) {
      return 1;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_405_aq.field_376_bc;
   }
}
