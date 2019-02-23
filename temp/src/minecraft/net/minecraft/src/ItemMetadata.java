package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;

public class ItemMetadata extends ItemBlock {

   private Block field_35437_a;


   public ItemMetadata(int p_i759_1_, Block p_i759_2_) {
      super(p_i759_1_);
      this.field_35437_a = p_i759_2_;
      this.func_21013_d(0);
      this.func_21015_a(true);
   }

   public int func_27009_a(int p_27009_1_) {
      return this.field_35437_a.func_232_a(2, p_27009_1_);
   }

   public int func_21012_a(int p_21012_1_) {
      return p_21012_1_;
   }
}
