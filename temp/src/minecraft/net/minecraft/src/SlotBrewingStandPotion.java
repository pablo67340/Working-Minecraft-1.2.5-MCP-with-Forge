package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.ContainerBrewingStand;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

class SlotBrewingStandPotion extends Slot {

   private EntityPlayer field_40440_f;
   // $FF: synthetic field
   final ContainerBrewingStand field_40441_a;


   public SlotBrewingStandPotion(ContainerBrewingStand p_i373_1_, EntityPlayer p_i373_2_, IInventory p_i373_3_, int p_i373_4_, int p_i373_5_, int p_i373_6_) {
      super(p_i373_3_, p_i373_4_, p_i373_5_, p_i373_6_);
      this.field_40441_a = p_i373_1_;
      this.field_40440_f = p_i373_2_;
   }

   public boolean func_4105_a(ItemStack p_4105_1_) {
      return p_4105_1_ != null && (p_4105_1_.field_1617_c == Item.field_40413_bs.field_291_aS || p_4105_1_.field_1617_c == Item.field_40416_bt.field_291_aS);
   }

   public int func_4104_e() {
      return 1;
   }

   public void func_4103_a(ItemStack p_4103_1_) {
      if(p_4103_1_.field_1617_c == Item.field_40413_bs.field_291_aS && p_4103_1_.func_21181_i() > 0) {
         this.field_40440_f.func_25058_a(AchievementList.field_40461_A, 1);
      }

      super.func_4103_a(p_4103_1_);
   }
}
