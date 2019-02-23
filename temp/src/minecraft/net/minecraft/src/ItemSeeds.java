package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemSeeds extends Item {

   private int field_318_a;
   private int field_40438_b;


   public ItemSeeds(int p_i467_1_, int p_i467_2_, int p_i467_3_) {
      super(p_i467_1_);
      this.field_318_a = p_i467_2_;
      this.field_40438_b = p_i467_3_;
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_7_ != 1) {
         return false;
      } else if(p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_) && p_192_2_.func_35190_e(p_192_4_, p_192_5_ + 1, p_192_6_)) {
         int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
         if(var8 == this.field_40438_b && p_192_3_.func_20084_d(p_192_4_, p_192_5_ + 1, p_192_6_)) {
            p_192_3_.func_690_d(p_192_4_, p_192_5_ + 1, p_192_6_, this.field_318_a);
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
