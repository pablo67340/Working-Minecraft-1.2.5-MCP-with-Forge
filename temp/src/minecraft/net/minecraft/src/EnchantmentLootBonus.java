package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentLootBonus extends Enchantment {

   protected EnchantmentLootBonus(int p_i428_1_, int p_i428_2_, EnumEnchantmentType p_i428_3_) {
      super(p_i428_1_, p_i428_2_, p_i428_3_);
      this.func_40494_a("lootBonus");
      if(p_i428_3_ == EnumEnchantmentType.digger) {
         this.func_40494_a("lootBonusDigger");
      }

   }

   public int func_40492_a(int p_40492_1_) {
      return 20 + (p_40492_1_ - 1) * 12;
   }

   public int func_40489_b(int p_40489_1_) {
      return super.func_40492_a(p_40489_1_) + 50;
   }

   public int func_40491_a() {
      return 3;
   }

   public boolean func_40496_a(Enchantment p_40496_1_) {
      return super.func_40496_a(p_40496_1_) && p_40496_1_.field_40516_s != field_40519_p.field_40516_s;
   }
}
