package net.minecraft.src;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemCoal extends Item {

   public ItemCoal(int p_i471_1_) {
      super(p_i471_1_);
      this.func_21015_a(true);
      this.func_21013_d(0);
   }

   public String func_21011_b(ItemStack p_21011_1_) {
      return p_21011_1_.func_21181_i() == 1?"item.charcoal":"item.coal";
   }
}
