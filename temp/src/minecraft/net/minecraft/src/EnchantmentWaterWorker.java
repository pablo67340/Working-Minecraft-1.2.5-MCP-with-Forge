package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentWaterWorker extends Enchantment {

   public EnchantmentWaterWorker(int p_i205_1_, int p_i205_2_) {
      super(p_i205_1_, p_i205_2_, EnumEnchantmentType.armor_head);
      this.func_40494_a("waterWorker");
   }

   public int func_40492_a(int p_40492_1_) {
      return 1;
   }

   public int func_40489_b(int p_40489_1_) {
      return this.func_40492_a(p_40489_1_) + 40;
   }

   public int func_40491_a() {
      return 1;
   }
}
