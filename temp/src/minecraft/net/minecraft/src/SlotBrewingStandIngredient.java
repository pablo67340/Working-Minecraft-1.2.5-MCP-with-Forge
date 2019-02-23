package net.minecraft.src;

import net.minecraft.src.ContainerBrewingStand;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

class SlotBrewingStandIngredient extends Slot {

   // $FF: synthetic field
   final ContainerBrewingStand field_40442_a;


   public SlotBrewingStandIngredient(ContainerBrewingStand p_i648_1_, IInventory p_i648_2_, int p_i648_3_, int p_i648_4_, int p_i648_5_) {
      super(p_i648_2_, p_i648_3_, p_i648_4_, p_i648_5_);
      this.field_40442_a = p_i648_1_;
   }

   public boolean func_4105_a(ItemStack p_4105_1_) {
      return p_4105_1_ != null?Item.field_233_c[p_4105_1_.field_1617_c].func_40406_n():false;
   }

   public int func_4104_e() {
      return 64;
   }
}
