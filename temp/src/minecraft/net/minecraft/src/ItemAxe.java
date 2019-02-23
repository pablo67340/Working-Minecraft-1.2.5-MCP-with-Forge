package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemTool;
import net.minecraft.src.Material;

public class ItemAxe extends ItemTool {

   private static Block[] field_327_aX = new Block[]{Block.field_334_y, Block.field_407_ao, Block.field_385_K, Block.field_396_av, Block.field_411_ak, Block.field_410_al, Block.field_4055_bb, Block.field_4045_bg};


   protected ItemAxe(int p_i487_1_, EnumToolMaterial p_i487_2_) {
      super(p_i487_1_, 3, p_i487_2_, field_327_aX);
   }

   public float func_204_a(ItemStack p_204_1_, Block p_204_2_) {
      return p_204_2_ != null && p_204_2_.field_356_bn == Material.field_1335_c?this.field_324_aY:super.func_204_a(p_204_1_, p_204_2_);
   }

}
