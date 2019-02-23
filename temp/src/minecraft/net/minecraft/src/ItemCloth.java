package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockCloth;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemDye;
import net.minecraft.src.ItemStack;

public class ItemCloth extends ItemBlock {

   public ItemCloth(int p_i621_1_) {
      super(p_i621_1_);
      this.func_21013_d(0);
      this.func_21015_a(true);
   }

   public int func_27009_a(int p_27009_1_) {
      return Block.field_419_ac.func_232_a(2, BlockCloth.func_21034_c(p_27009_1_));
   }

   public int func_21012_a(int p_21012_1_) {
      return p_21012_1_;
   }

   public String func_21011_b(ItemStack p_21011_1_) {
      return super.func_20009_a() + "." + ItemDye.field_21023_a[BlockCloth.func_21034_c(p_21011_1_.func_21181_i())];
   }
}
