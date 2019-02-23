package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ItemBlock;

public class ItemLeaves extends ItemBlock {

   public ItemLeaves(int p_i513_1_) {
      super(p_i513_1_);
      this.func_21013_d(0);
      this.func_21015_a(true);
   }

   public int func_21012_a(int p_21012_1_) {
      return p_21012_1_ | 4;
   }

   public int func_27009_a(int p_27009_1_) {
      return Block.field_384_L.func_232_a(0, p_27009_1_);
   }

   public int func_27010_f(int p_27010_1_, int p_27010_2_) {
      return (p_27010_1_ & 1) == 1?ColorizerFoliage.func_21175_a():((p_27010_1_ & 2) == 2?ColorizerFoliage.func_21174_b():ColorizerFoliage.func_31073_c());
   }
}
