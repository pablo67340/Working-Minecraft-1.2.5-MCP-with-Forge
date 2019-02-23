package net.minecraft.src;

import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemPainting extends Item {

   public ItemPainting(int p_i216_1_) {
      super(p_i216_1_);
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_7_ == 0) {
         return false;
      } else if(p_192_7_ == 1) {
         return false;
      } else {
         byte var8 = 0;
         if(p_192_7_ == 4) {
            var8 = 1;
         }

         if(p_192_7_ == 3) {
            var8 = 2;
         }

         if(p_192_7_ == 5) {
            var8 = 3;
         }

         if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
            return false;
         } else {
            EntityPainting var9 = new EntityPainting(p_192_3_, p_192_4_, p_192_5_, p_192_6_, var8);
            if(var9.func_410_i()) {
               if(!p_192_3_.field_1026_y) {
                  p_192_3_.func_674_a(var9);
               }

               --p_192_1_.field_1615_a;
            }

            return true;
         }
      }
   }
}
