package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Item;

public class BlockGravel extends BlockSand {

   public BlockGravel(int p_i399_1_, int p_i399_2_) {
      super(p_i399_1_, p_i399_2_);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return p_240_2_.nextInt(10 - p_240_3_ * 3) == 0?Item.field_273_an.field_291_aS:this.field_376_bc;
   }
}
