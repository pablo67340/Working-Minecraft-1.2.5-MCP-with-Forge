package net.minecraft.src;

import net.minecraft.src.Empty3;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.IEnchantmentModifier;

final class EnchantmentModifierLiving implements IEnchantmentModifier {

   public int field_40248_a;
   public EntityLiving field_40247_b;


   private EnchantmentModifierLiving() {}

   public void func_40244_a(Enchantment p_40244_1_, int p_40244_2_) {
      this.field_40248_a += p_40244_1_.func_40490_a(p_40244_2_, this.field_40247_b);
   }

   // $FF: synthetic method
   EnchantmentModifierLiving(Empty3 p_i583_1_) {
      this();
   }
}
