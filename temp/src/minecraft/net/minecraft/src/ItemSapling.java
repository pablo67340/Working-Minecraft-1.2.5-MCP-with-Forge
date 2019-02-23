package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;

public class ItemSapling extends ItemBlock {

   public ItemSapling(int p_i391_1_) {
      super(p_i391_1_);
      this.func_21013_d(0);
      this.func_21015_a(true);
   }

   public int func_21012_a(int p_21012_1_) {
      return p_21012_1_;
   }

   public int func_27009_a(int p_27009_1_) {
      return Block.field_333_z.func_232_a(0, p_27009_1_);
   }
}
