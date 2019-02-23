package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSoup extends ItemFood {

   public ItemSoup(int p_i248_1_, int p_i248_2_) {
      super(p_i248_1_, p_i248_2_, false);
      this.func_21009_c(1);
   }

   public ItemStack func_35413_b(ItemStack p_35413_1_, World p_35413_2_, EntityPlayer p_35413_3_) {
      super.func_35413_b(p_35413_1_, p_35413_2_, p_35413_3_);
      return new ItemStack(Item.field_264_C);
   }
}
