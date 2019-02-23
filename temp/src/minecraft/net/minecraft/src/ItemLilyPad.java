package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.ItemColored;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class ItemLilyPad extends ItemColored {

   public ItemLilyPad(int p_i109_1_) {
      super(p_i109_1_, false);
   }

   public ItemStack func_193_a(ItemStack p_193_1_, World p_193_2_, EntityPlayer p_193_3_) {
      MovingObjectPosition var4 = this.func_40402_a(p_193_2_, p_193_3_, true);
      if(var4 == null) {
         return p_193_1_;
      } else {
         if(var4.field_1167_a == EnumMovingObjectType.TILE) {
            int var5 = var4.field_1166_b;
            int var6 = var4.field_1172_c;
            int var7 = var4.field_1171_d;
            if(!p_193_2_.func_6466_a(p_193_3_, var5, var6, var7)) {
               return p_193_1_;
            }

            if(!p_193_3_.func_35190_e(var5, var6, var7)) {
               return p_193_1_;
            }

            if(p_193_2_.func_599_f(var5, var6, var7) == Material.field_1332_f && p_193_2_.func_602_e(var5, var6, var7) == 0 && p_193_2_.func_20084_d(var5, var6 + 1, var7)) {
               p_193_2_.func_690_d(var5, var6 + 1, var7, Block.field_40200_bA.field_376_bc);
               if(!p_193_3_.field_35212_aW.field_35756_d) {
                  --p_193_1_.field_1615_a;
               }
            }
         }

         return p_193_1_;
      }
   }

   public int func_27010_f(int p_27010_1_, int p_27010_2_) {
      return Block.field_40200_bA.func_31030_b(p_27010_1_);
   }
}
