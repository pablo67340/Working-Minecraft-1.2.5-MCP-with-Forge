package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ContainerPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

class SlotArmor extends Slot {

   // $FF: synthetic field
   final int field_1124_c;
   // $FF: synthetic field
   final ContainerPlayer field_1123_d;


   SlotArmor(ContainerPlayer p_i89_1_, IInventory p_i89_2_, int p_i89_3_, int p_i89_4_, int p_i89_5_, int p_i89_6_) {
      super(p_i89_2_, p_i89_3_, p_i89_4_, p_i89_5_);
      this.field_1123_d = p_i89_1_;
      this.field_1124_c = p_i89_6_;
   }

   public int func_4104_e() {
      return 1;
   }

   public boolean func_4105_a(ItemStack p_4105_1_) {
      return p_4105_1_.func_1091_a() instanceof ItemArmor?((ItemArmor)p_4105_1_.func_1091_a()).field_313_aX == this.field_1124_c:(p_4105_1_.func_1091_a().field_291_aS == Block.field_4055_bb.field_376_bc?this.field_1124_c == 0:false);
   }

   public int func_775_c() {
      return 15 + this.field_1124_c * 16;
   }
}
