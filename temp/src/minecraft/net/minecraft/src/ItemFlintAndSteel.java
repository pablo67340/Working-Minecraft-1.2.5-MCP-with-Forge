package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemFlintAndSteel extends Item {

   public ItemFlintAndSteel(int p_i212_1_) {
      super(p_i212_1_);
      this.field_290_aT = 1;
      this.func_21013_d(64);
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_7_ == 0) {
         --p_192_5_;
      }

      if(p_192_7_ == 1) {
         ++p_192_5_;
      }

      if(p_192_7_ == 2) {
         --p_192_6_;
      }

      if(p_192_7_ == 3) {
         ++p_192_6_;
      }

      if(p_192_7_ == 4) {
         --p_192_4_;
      }

      if(p_192_7_ == 5) {
         ++p_192_4_;
      }

      if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
         return false;
      } else {
         int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
         if(var8 == 0) {
            p_192_3_.func_684_a((double)p_192_4_ + 0.5D, (double)p_192_5_ + 0.5D, (double)p_192_6_ + 0.5D, "fire.ignite", 1.0F, field_4015_b.nextFloat() * 0.4F + 0.8F);
            p_192_3_.func_690_d(p_192_4_, p_192_5_, p_192_6_, Block.field_402_as.field_376_bc);
         }

         p_192_1_.func_25190_a(1, p_192_2_);
         return true;
      }
   }
}
