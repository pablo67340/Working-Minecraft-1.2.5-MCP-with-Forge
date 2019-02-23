package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class SlotFurnace extends Slot {

   private EntityPlayer field_27011_d;
   private int field_48437_f;


   public SlotFurnace(EntityPlayer p_i168_1_, IInventory p_i168_2_, int p_i168_3_, int p_i168_4_, int p_i168_5_) {
      super(p_i168_2_, p_i168_3_, p_i168_4_, p_i168_5_);
      this.field_27011_d = p_i168_1_;
   }

   public boolean func_4105_a(ItemStack p_4105_1_) {
      return false;
   }

   public ItemStack func_20004_a(int p_20004_1_) {
      if(this.func_20005_c()) {
         this.field_48437_f += Math.min(p_20004_1_, this.func_777_b().field_1615_a);
      }

      return super.func_20004_a(p_20004_1_);
   }

   public void func_4103_a(ItemStack p_4103_1_) {
      this.func_48434_c(p_4103_1_);
      super.func_4103_a(p_4103_1_);
   }

   protected void func_48435_a(ItemStack p_48435_1_, int p_48435_2_) {
      this.field_48437_f += p_48435_2_;
      this.func_48434_c(p_48435_1_);
   }

   protected void func_48434_c(ItemStack p_48434_1_) {
      p_48434_1_.func_48507_a(this.field_27011_d.field_615_ag, this.field_27011_d, this.field_48437_f);
      this.field_48437_f = 0;
      if(p_48434_1_.field_1617_c == Item.field_223_m.field_291_aS) {
         this.field_27011_d.func_25058_a(AchievementList.field_27385_k, 1);
      }

      if(p_48434_1_.field_1617_c == Item.field_4020_aT.field_291_aS) {
         this.field_27011_d.func_25058_a(AchievementList.field_27380_p, 1);
      }

   }
}
