package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnumEnchantmentType;

public class EnchantmentProtection extends Enchantment {

   private static final String[] field_40520_w = new String[]{"all", "fire", "fall", "explosion", "projectile"};
   private static final int[] field_40524_x = new int[]{1, 10, 5, 5, 3};
   private static final int[] field_40523_y = new int[]{16, 8, 6, 8, 6};
   private static final int[] field_40522_z = new int[]{20, 12, 10, 12, 15};
   public final int field_40521_v;


   public EnchantmentProtection(int p_i463_1_, int p_i463_2_, int p_i463_3_) {
      super(p_i463_1_, p_i463_2_, EnumEnchantmentType.armor);
      this.field_40521_v = p_i463_3_;
      if(p_i463_3_ == 2) {
         this.field_40515_t = EnumEnchantmentType.armor_feet;
      }

   }

   public int func_40492_a(int p_40492_1_) {
      return field_40524_x[this.field_40521_v] + (p_40492_1_ - 1) * field_40523_y[this.field_40521_v];
   }

   public int func_40489_b(int p_40489_1_) {
      return this.func_40492_a(p_40489_1_) + field_40522_z[this.field_40521_v];
   }

   public int func_40491_a() {
      return 4;
   }

   public int func_40497_a(int p_40497_1_, DamageSource p_40497_2_) {
      if(p_40497_2_.func_35529_d()) {
         return 0;
      } else {
         int var3 = (6 + p_40497_1_ * p_40497_1_) / 2;
         return this.field_40521_v == 0?var3:(this.field_40521_v == 1 && p_40497_2_.func_40543_k()?var3:(this.field_40521_v == 2 && p_40497_2_ == DamageSource.field_35549_h?var3 * 2:(this.field_40521_v == 3 && p_40497_2_ == DamageSource.field_35548_k?var3:(this.field_40521_v == 4 && p_40497_2_.func_40547_b()?var3:0))));
      }
   }

   public String func_40488_d() {
      return "enchantment.protect." + field_40520_w[this.field_40521_v];
   }

   public boolean func_40496_a(Enchantment p_40496_1_) {
      if(p_40496_1_ instanceof EnchantmentProtection) {
         EnchantmentProtection var2 = (EnchantmentProtection)p_40496_1_;
         return var2.field_40521_v == this.field_40521_v?false:this.field_40521_v == 2 || var2.field_40521_v == 2;
      } else {
         return super.func_40496_a(p_40496_1_);
      }
   }

}
