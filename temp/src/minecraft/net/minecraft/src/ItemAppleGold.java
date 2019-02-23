package net.minecraft.src;

import net.minecraft.src.EnumRarity;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;

public class ItemAppleGold extends ItemFood {

   public ItemAppleGold(int p_i587_1_, int p_i587_2_, float p_i587_3_, boolean p_i587_4_) {
      super(p_i587_1_, p_i587_2_, p_i587_3_, p_i587_4_);
   }

   public boolean func_40403_e(ItemStack p_40403_1_) {
      return true;
   }

   public EnumRarity func_40398_f(ItemStack p_40398_1_) {
      return EnumRarity.epic;
   }
}
