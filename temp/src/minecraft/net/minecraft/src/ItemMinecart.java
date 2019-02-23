package net.minecraft.src;

import net.minecraft.src.BlockRail;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemMinecart extends Item {

   public int field_317_a;


   public ItemMinecart(int p_i110_1_, int p_i110_2_) {
      super(p_i110_1_);
      this.field_290_aT = 1;
      this.field_317_a = p_i110_2_;
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
      if(BlockRail.func_27041_c(var8)) {
         if(!p_192_3_.field_1026_y) {
            p_192_3_.func_674_a(new EntityMinecart(p_192_3_, (double)((float)p_192_4_ + 0.5F), (double)((float)p_192_5_ + 0.5F), (double)((float)p_192_6_ + 0.5F), this.field_317_a));
         }

         --p_192_1_.field_1615_a;
         return true;
      } else {
         return false;
      }
   }
}
