package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.WeightedRandomChoice;

public class EnchantmentData extends WeightedRandomChoice {

   public final Enchantment field_40264_a;
   public final int field_40263_b;


   public EnchantmentData(Enchantment p_i429_1_, int p_i429_2_) {
      super(p_i429_1_.func_40495_b());
      this.field_40264_a = p_i429_1_;
      this.field_40263_b = p_i429_2_;
   }
}
