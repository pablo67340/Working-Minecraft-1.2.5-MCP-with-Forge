package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPig;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemSaddle extends Item {

   public ItemSaddle(int p_i472_1_) {
      super(p_i472_1_);
      this.field_290_aT = 1;
   }

   public void func_4019_b(ItemStack p_4019_1_, EntityLiving p_4019_2_) {
      if(p_4019_2_ instanceof EntityPig) {
         EntityPig var3 = (EntityPig)p_4019_2_;
         if(!var3.func_21068_q() && !var3.func_40127_l()) {
            var3.func_21069_a(true);
            --p_4019_1_.field_1615_a;
         }
      }

   }

   public boolean func_4021_a(ItemStack p_4021_1_, EntityLiving p_4021_2_, EntityLiving p_4021_3_) {
      this.func_4019_b(p_4021_1_, p_4021_2_);
      return true;
   }
}
