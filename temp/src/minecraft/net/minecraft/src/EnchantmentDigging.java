package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentDigging extends Enchantment {

   protected EnchantmentDigging(int p_i654_1_, int p_i654_2_) {
      super(p_i654_1_, p_i654_2_, EnumEnchantmentType.digger);
      this.func_40494_a("digging");
   }

   public int func_40492_a(int p_40492_1_) {
      return 1 + 15 * (p_40492_1_ - 1);
   }

   public int func_40489_b(int p_40489_1_) {
      return super.func_40492_a(p_40489_1_) + 50;
   }

   public int func_40491_a() {
      return 5;
   }
}
