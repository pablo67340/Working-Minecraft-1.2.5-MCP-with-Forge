package net.minecraft.src;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class ItemGlassBottle extends Item {

   public ItemGlassBottle(int p_i145_1_) {
      super(p_i145_1_);
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

            if(p_193_2_.func_599_f(var5, var6, var7) == Material.field_1332_f) {
               --p_193_1_.field_1615_a;
               if(p_193_1_.field_1615_a <= 0) {
                  return new ItemStack(Item.field_40413_bs);
               }

               if(!p_193_3_.field_778_b.func_504_a(new ItemStack(Item.field_40413_bs))) {
                  p_193_3_.func_48153_a(new ItemStack(Item.field_40413_bs.field_291_aS, 1, 0));
               }
            }
         }

         return p_193_1_;
      }
   }
}
