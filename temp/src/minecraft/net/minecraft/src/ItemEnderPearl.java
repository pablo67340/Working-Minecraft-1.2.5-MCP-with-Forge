package net.minecraft.src;

import net.minecraft.src.EntityEnderPearl;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemEnderPearl extends Item {

   public ItemEnderPearl(int p_i773_1_) {
      super(p_i773_1_);
      this.field_290_aT = 16;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      if(p_193_3_.field_35212_aW.field_35756_d) {
         return p_193_1_;
      } else if(p_193_3_.field_616_af != null) {
         return p_193_1_;
      } else {
         --p_193_1_.field_1615_a;
         p_193_2_.func_623_a(p_193_3_, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
         if(!p_193_2_.field_1026_y) {
            p_193_2_.func_674_a(new EntityEnderPearl(p_193_2_, p_193_3_));
         }

         return p_193_1_;
      }
   }
}
