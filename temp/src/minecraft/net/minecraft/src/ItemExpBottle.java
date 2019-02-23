package net.minecraft.src;

import net.minecraft.src.EntityExpBottle;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemExpBottle extends Item {

   public ItemExpBottle(int p_i1087_1_) {
      super(p_i1087_1_);
   }

   public boolean func_40403_e(ItemStack p_40403_1_) {
      return true;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      if(!p_193_3_.field_35212_aW.field_35756_d) {
         --p_193_1_.field_1615_a;
      }

      p_193_2_.func_623_a(p_193_3_, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
      if(!p_193_2_.field_1026_y) {
         p_193_2_.func_674_a(new EntityExpBottle(p_193_2_, p_193_3_));
      }

      return p_193_1_;
   }
}
