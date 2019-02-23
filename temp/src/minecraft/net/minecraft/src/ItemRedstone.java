package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemRedstone extends Item {

   public ItemRedstone(int p_i729_1_) {
      super(p_i729_1_);
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_) != Block.field_428_aT.field_376_bc) {
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

         if(!p_192_3_.func_20084_d(p_192_4_, p_192_5_, p_192_6_)) {
            return false;
         }
      }

      if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
         return false;
      } else {
         if(Block.field_394_aw.func_243_a(p_192_3_, p_192_4_, p_192_5_, p_192_6_)) {
            --p_192_1_.field_1615_a;
            p_192_3_.func_690_d(p_192_4_, p_192_5_, p_192_6_, Block.field_394_aw.field_376_bc);
         }

         return true;
      }
   }
}
