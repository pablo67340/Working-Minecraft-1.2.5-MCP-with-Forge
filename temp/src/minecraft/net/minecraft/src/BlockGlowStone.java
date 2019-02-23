package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;

public class BlockGlowStone extends Block {

   public BlockGlowStone(int p_i379_1_, int p_i379_2_, Material p_i379_3_) {
      super(p_i379_1_, p_i379_2_, p_i379_3_);
   }

   public int func_40198_a(int p_40198_1_, Random p_40198_2_) {
      return MathHelper.func_41084_a(this.func_229_a(p_40198_2_) + p_40198_2_.nextInt(p_40198_1_ + 1), 1, 4);
   }

   public int func_229_a(Random p_229_1_) {
      return 2 + p_229_1_.nextInt(3);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_4022_aR.field_291_aS;
   }
}
