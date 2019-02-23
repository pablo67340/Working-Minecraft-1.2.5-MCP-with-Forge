package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.Material;

public class BlockGlass extends BlockBreakable {

   public BlockGlass(int p_i681_1_, int p_i681_2_, Material p_i681_3_, boolean p_i681_4_) {
      super(p_i681_1_, p_i681_2_, p_i681_3_, p_i681_4_);
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public int func_234_g() {
      return 0;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   protected boolean func_50074_q() {
      return true;
   }
}
