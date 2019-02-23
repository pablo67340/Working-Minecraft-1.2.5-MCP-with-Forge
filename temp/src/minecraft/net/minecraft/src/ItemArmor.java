package net.minecraft.src;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.Item;

public class ItemArmor extends Item {

   private static final int[] field_314_bb = new int[]{11, 16, 15, 13};
   public final int field_313_aX;
   public final int field_312_aY;
   public final int field_311_aZ;
   private final EnumArmorMaterial field_40437_bT;


   public ItemArmor(int p_i549_1_, EnumArmorMaterial p_i549_2_, int p_i549_3_, int p_i549_4_) {
      super(p_i549_1_);
      this.field_40437_bT = p_i549_2_;
      this.field_313_aX = p_i549_4_;
      this.field_311_aZ = p_i549_3_;
      this.field_312_aY = p_i549_2_.func_40574_b(p_i549_4_);
      this.func_21013_d(p_i549_2_.func_40576_a(p_i549_4_));
      this.field_290_aT = 1;
   }

   public int func_40399_b() {
      return this.field_40437_bT.func_40575_a();
   }

   // $FF: synthetic method
   static int[] func_40436_c() {
      return field_314_bb;
   }

}
