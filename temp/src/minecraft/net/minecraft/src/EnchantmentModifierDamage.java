package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Empty3;
import net.minecraft.src.Enchantment;
import net.minecraft.src.IEnchantmentModifier;

final class EnchantmentModifierDamage implements IEnchantmentModifier {

   public int field_40246_a;
   public DamageSource field_40245_b;


   private EnchantmentModifierDamage() {}

   public void func_40244_a(Enchantment p_40244_1_, int p_40244_2_) {
      this.field_40246_a += p_40244_1_.func_40497_a(p_40244_2_, this.field_40245_b);
   }

   // $FF: synthetic method
   EnchantmentModifierDamage(Empty3 p_i370_1_) {
      this();
   }
}
