package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemTool;

public class ItemSpade extends ItemTool {

   private static Block[] field_326_aX = new Block[]{Block.field_337_v, Block.field_336_w, Block.field_393_F, Block.field_392_G, Block.field_428_aT, Block.field_426_aV, Block.field_424_aX, Block.field_446_aB, Block.field_4051_bd, Block.field_40199_bz};


   public ItemSpade(int p_i177_1_, EnumToolMaterial p_i177_2_) {
      super(p_i177_1_, 1, p_i177_2_, field_326_aX);
   }

   public boolean func_4018_a(Block p_4018_1_) {
      return p_4018_1_ == Block.field_428_aT?true:p_4018_1_ == Block.field_426_aV;
   }

}
