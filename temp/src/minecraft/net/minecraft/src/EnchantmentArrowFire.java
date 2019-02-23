package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentArrowFire extends Enchantment {

   public EnchantmentArrowFire(int p_i312_1_, int p_i312_2_) {
      super(p_i312_1_, p_i312_2_, EnumEnchantmentType.bow);
      this.func_40494_a("arrowFire");
   }

   public int func_40492_a(int p_40492_1_) {
      return 20;
   }

   public int func_40489_b(int p_40489_1_) {
      return 50;
   }

   public int func_40491_a() {
      return 1;
   }
}
