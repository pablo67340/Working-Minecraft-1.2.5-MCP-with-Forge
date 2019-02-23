package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentArrowDamage extends Enchantment {

   public EnchantmentArrowDamage(int p_i118_1_, int p_i118_2_) {
      super(p_i118_1_, p_i118_2_, EnumEnchantmentType.bow);
      this.func_40494_a("arrowDamage");
   }

   public int func_40492_a(int p_40492_1_) {
      return 1 + (p_40492_1_ - 1) * 10;
   }

   public int func_40489_b(int p_40489_1_) {
      return this.func_40492_a(p_40489_1_) + 15;
   }

   public int func_40491_a() {
      return 5;
   }
}
