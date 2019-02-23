package net.minecraft.src;

import net.minecraft.src.ContainerEnchantment;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

class SlotEnchantment extends Slot {

   // $FF: synthetic field
   final ContainerEnchantment field_40443_a;


   SlotEnchantment(ContainerEnchantment p_i593_1_, IInventory p_i593_2_, int p_i593_3_, int p_i593_4_, int p_i593_5_) {
      super(p_i593_2_, p_i593_3_, p_i593_4_, p_i593_5_);
      this.field_40443_a = p_i593_1_;
   }

   public boolean func_4105_a(ItemStack p_4105_1_) {
      return true;
   }
}
