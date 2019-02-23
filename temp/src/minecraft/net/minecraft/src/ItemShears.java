package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemShears extends Item {

   public ItemShears(int p_i242_1_) {
      super(p_i242_1_);
      this.func_21009_c(1);
      this.func_21013_d(238);
   }

   public boolean func_25008_a(ItemStack p_25008_1_, int p_25008_2_, int p_25008_3_, int p_25008_4_, int p_25008_5_, EntityLiving p_25008_6_) {
      if(p_25008_2_ != Block.field_384_L.field_376_bc && p_25008_2_ != Block.field_9258_W.field_376_bc && p_25008_2_ != Block.field_9257_X.field_376_bc && p_25008_2_ != Block.field_35278_bv.field_376_bc) {
         return super.func_25008_a(p_25008_1_, p_25008_2_, p_25008_3_, p_25008_4_, p_25008_5_, p_25008_6_);
      } else {
         p_25008_1_.func_25190_a(1, p_25008_6_);
         return true;
      }
   }

   public boolean func_4018_a(Block p_4018_1_) {
      return p_4018_1_.field_376_bc == Block.field_9258_W.field_376_bc;
   }

   public float func_204_a(ItemStack p_204_1_, Block p_204_2_) {
      return p_204_2_.field_376_bc != Block.field_9258_W.field_376_bc && p_204_2_.field_376_bc != Block.field_384_L.field_376_bc?(p_204_2_.field_376_bc == Block.field_419_ac.field_376_bc?5.0F:super.func_204_a(p_204_1_, p_204_2_)):15.0F;
   }
}
