package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentFireAspect extends Enchantment {

   protected EnchantmentFireAspect(int p_i11_1_, int p_i11_2_) {
      super(p_i11_1_, p_i11_2_, EnumEnchantmentType.weapon);
      this.func_40494_a("fire");
   }

   public int func_40492_a(int p_40492_1_) {
      return 10 + 20 * (p_40492_1_ - 1);
   }

   public int func_40489_b(int p_40489_1_) {
      return super.func_40492_a(p_40489_1_) + 50;
   }

   public int func_40491_a() {
      return 2;
   }
}
