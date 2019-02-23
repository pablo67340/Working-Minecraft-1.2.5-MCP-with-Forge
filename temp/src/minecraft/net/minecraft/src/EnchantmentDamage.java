package net.minecraft.src;

import net.minecraft.src.Enchantment;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentDamage extends Enchantment {

   private static final String[] field_40525_w = new String[]{"all", "undead", "arthropods"};
   private static final int[] field_40529_x = new int[]{1, 5, 5};
   private static final int[] field_40528_y = new int[]{16, 8, 8};
   private static final int[] field_40527_z = new int[]{20, 20, 20};
   public final int field_40526_v;


   public EnchantmentDamage(int p_i5_1_, int p_i5_2_, int p_i5_3_) {
      super(p_i5_1_, p_i5_2_, EnumEnchantmentType.weapon);
      this.field_40526_v = p_i5_3_;
   }

   public int func_40492_a(int p_40492_1_) {
      return field_40529_x[this.field_40526_v] + (p_40492_1_ - 1) * field_40528_y[this.field_40526_v];
   }

   public int func_40489_b(int p_40489_1_) {
      return this.func_40492_a(p_40489_1_) + field_40527_z[this.field_40526_v];
   }

   public int func_40491_a() {
      return 5;
   }

   public int func_40490_a(int p_40490_1_, EntityLiving p_40490_2_) {
      return this.field_40526_v == 0?p_40490_1_ * 3:(this.field_40526_v == 1 && p_40490_2_.func_40124_t() == EnumCreatureAttribute.UNDEAD?p_40490_1_ * 4:(this.field_40526_v == 2 && p_40490_2_.func_40124_t() == EnumCreatureAttribute.ARTHROPOD?p_40490_1_ * 4:0));
   }

   public String func_40488_d() {
      return "enchantment.damage." + field_40525_w[this.field_40526_v];
   }

   public boolean func_40496_a(Enchantment p_40496_1_) {
      return !(p_40496_1_ instanceof EnchantmentDamage);
   }

}
