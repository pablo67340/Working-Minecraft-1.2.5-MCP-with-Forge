package net.minecraft.src;

import net.minecraft.src.ItemArmor;

public enum EnumArmorMaterial {

   CLOTH("CLOTH", 0, 5, new int[]{1, 3, 2, 1}, 15),
   CHAIN("CHAIN", 1, 15, new int[]{2, 5, 4, 1}, 12),
   IRON("IRON", 2, 15, new int[]{2, 6, 5, 2}, 9),
   GOLD("GOLD", 3, 7, new int[]{2, 5, 3, 1}, 25),
   DIAMOND("DIAMOND", 4, 33, new int[]{3, 8, 6, 3}, 10);
   private int field_40577_f;
   private int[] field_40578_g;
   private int field_40584_h;
   // $FF: synthetic field
   private static final EnumArmorMaterial[] $VALUES = new EnumArmorMaterial[]{CLOTH, CHAIN, IRON, GOLD, DIAMOND};


   private EnumArmorMaterial(String p_i262_1_, int p_i262_2_, int p_i262_3_, int[] p_i262_4_, int p_i262_5_) {
      this.field_40577_f = p_i262_3_;
      this.field_40578_g = p_i262_4_;
      this.field_40584_h = p_i262_5_;
   }

   public int func_40576_a(int p_40576_1_) {
      return ItemArmor.func_40436_c()[p_40576_1_] * this.field_40577_f;
   }

   public int func_40574_b(int p_40574_1_) {
      return this.field_40578_g[p_40574_1_];
   }

   public int func_40575_a() {
      return this.field_40584_h;
   }

}
