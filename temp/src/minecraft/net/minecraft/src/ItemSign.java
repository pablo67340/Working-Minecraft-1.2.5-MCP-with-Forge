package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntitySign;
import net.minecraft.src.World;

public class ItemSign extends Item {

   public ItemSign(int p_i159_1_) {
      super(p_i159_1_);
      this.field_290_aT = 1;
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_7_ == 0) {
         return false;
      } else if(!p_192_3_.func_599_f(p_192_4_, p_192_5_, p_192_6_).func_878_a()) {
         return false;
      } else {
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
         } else if(!Block.field_443_aE.func_243_a(p_192_3_, p_192_4_, p_192_5_, p_192_6_)) {
            return false;
         } else {
            if(p_192_7_ == 1) {
               int var8 = MathHelper.func_1108_b((double)((p_192_2_.field_605_aq + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               p_192_3_.func_688_b(p_192_4_, p_192_5_, p_192_6_, Block.field_443_aE.field_376_bc, var8);
            } else {
               p_192_3_.func_688_b(p_192_4_, p_192_5_, p_192_6_, Block.field_4068_aJ.field_376_bc, p_192_7_);
            }

            --p_192_1_.field_1615_a;
            TileEntitySign var9 = (TileEntitySign)p_192_3_.func_603_b(p_192_4_, p_192_5_, p_192_6_);
            if(var9 != null) {
               p_192_2_.func_4052_a(var9);
            }

            return true;
         }
      }
   }
}
