package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Block;
import net.minecraft.src.BlockJukeBox;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumRarity;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemRecord extends Item {

   public final String field_316_a;


   protected ItemRecord(int p_i138_1_, String p_i138_2_) {
      super(p_i138_1_);
      this.field_316_a = p_i138_2_;
      this.field_290_aT = 1;
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_3_.func_600_a(p_192_4_, p_192_5_, p_192_6_) == Block.field_422_aZ.field_376_bc && p_192_3_.func_602_e(p_192_4_, p_192_5_, p_192_6_) == 0) {
         if(p_192_3_.field_1026_y) {
            return true;
         } else {
            ((BlockJukeBox)Block.field_422_aZ).func_317_e(p_192_3_, p_192_4_, p_192_5_, p_192_6_, this.field_291_aS);
            p_192_3_.func_28107_a((EntityPlayer)null, 1005, p_192_4_, p_192_5_, p_192_6_, this.field_291_aS);
            --p_192_1_.field_1615_a;
            return true;
         }
      } else {
         return false;
      }
   }

   public void func_40404_a(ItemStack p_40404_1_, List p_40404_2_) {
      p_40404_2_.add("C418 - " + this.field_316_a);
   }

   public EnumRarity func_40398_f(ItemStack p_40398_1_) {
      return EnumRarity.rare;
   }
}
