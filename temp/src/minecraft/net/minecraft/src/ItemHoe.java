package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemHoe extends Item {

   public ItemHoe(int p_i369_1_, EnumToolMaterial p_i369_2_) {
      super(p_i369_1_);
      this.field_290_aT = 1;
      this.func_21013_d(p_i369_2_.func_21207_a());
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(!p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_)) {
         return false;
      } else {
         int var8 = p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_);
         int var9 = p_192_3_.func_600_a(p_192_4_, p_192_5_ + 1, p_192_6_);
         if((p_192_7_ == 0 || var9 != 0 || var8 != Block.field_337_v.field_376_bc) && var8 != Block.field_336_w.field_376_bc) {
            return false;
         } else {
            Block var10 = Block.field_446_aB;
            p_192_3_.func_684_a((double)((float)p_192_4_ + 0.5F), (double)((float)p_192_5_ + 0.5F), (double)((float)p_192_6_ + 0.5F), var10.field_358_bl.func_1145_d(), (var10.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var10.field_358_bl.func_1144_c() * 0.8F);
            if(p_192_3_.field_1026_y) {
               return true;
            } else {
               p_192_3_.func_690_d(p_192_4_, p_192_5_, p_192_6_, var10.field_376_bc);
               p_192_1_.func_25190_a(1, p_192_2_);
               return true;
            }
         }
      }
   }

   public boolean func_4017_a() {
      return true;
   }
}
