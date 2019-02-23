package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.BlockBed;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class ItemBed extends Item {

   public ItemBed(int p_i18_1_) {
      super(p_i18_1_);
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_7_ != 1) {
         return false;
      } else {
         ++p_192_5_;
         BlockBed var8 = (BlockBed)Block.field_9262_S;
         int var9 = MathHelper.func_1108_b((double)(p_192_2_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
         byte var10 = 0;
         byte var11 = 0;
         if(var9 == 0) {
            var11 = 1;
         }

         if(var9 == 1) {
            var10 = -1;
         }

         if(var9 == 2) {
            var11 = -1;
         }

         if(var9 == 3) {
            var10 = 1;
         }

         if(p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_) && p_192_2_.func_35190_e(p_192_4_ + var10, p_192_5_, p_192_6_ + var11)) {
            if(p_192_3_.func_20084_d(p_192_4_, p_192_5_, p_192_6_) && p_192_3_.func_20084_d(p_192_4_ + var10, p_192_5_, p_192_6_ + var11) && p_192_3_.func_28100_h(p_192_4_, p_192_5_ - 1, p_192_6_) && p_192_3_.func_28100_h(p_192_4_ + var10, p_192_5_ - 1, p_192_6_ + var11)) {
               p_192_3_.func_688_b(p_192_4_, p_192_5_, p_192_6_, var8.field_376_bc, var9);
               if(p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_) == var8.field_376_bc) {
                  p_192_3_.func_688_b(p_192_4_ + var10, p_192_5_, p_192_6_ + var11, var8.field_376_bc, var9 + 8);
               }

               --p_192_1_.field_1615_a;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }
}
