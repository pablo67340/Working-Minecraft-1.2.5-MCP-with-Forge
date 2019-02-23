package net.minecraft.src;

import net.minecraft.src.ContainerEnchantment;
import net.minecraft.src.InventoryBasic;

class SlotEnchantmentTable extends InventoryBasic {

   // $FF: synthetic field
   final ContainerEnchantment field_40070_a;


   SlotEnchantmentTable(ContainerEnchantment p_i608_1_, String p_i608_2_, int p_i608_3_) {
      super(p_i608_2_, p_i608_3_);
      this.field_40070_a = p_i608_1_;
   }

   public int func_470_e() {
      return 1;
   }

   public void func_474_j_() {
      super.func_474_j_();
      this.field_40070_a.func_1103_a(this);
   }
}
