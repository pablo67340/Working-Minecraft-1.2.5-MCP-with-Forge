package net.minecraft.src;

import net.minecraft.src.EntityFishHook;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemFishingRod extends Item {

   public ItemFishingRod(int p_i646_1_) {
      super(p_i646_1_);
      this.func_21013_d(64);
      this.func_21009_c(1);
   }

   public boolean func_4017_a() {
      return true;
   }

   public boolean func_4023_b() {
      return true;
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      if(p_193_3_.field_4128_n != null) {
         int var4 = p_193_3_.field_4128_n.func_4043_i();
         p_193_1_.func_25190_a(var4, p_193_3_);
         p_193_3_.func_457_w();
      } else {
         p_193_2_.func_623_a(p_193_3_, "random.bow", 0.5F, 0.4F / (field_4015_b.nextFloat() * 0.4F + 0.8F));
         if(!p_193_2_.field_1026_y) {
            p_193_2_.func_674_a(new EntityFishHook(p_193_2_, p_193_3_));
         }

         p_193_3_.func_457_w();
      }

      return p_193_1_;
   }
}
