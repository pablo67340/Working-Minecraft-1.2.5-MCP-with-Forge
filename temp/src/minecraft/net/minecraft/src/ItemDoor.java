package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class ItemDoor extends Item {

   private Material field_321_a;


   public ItemDoor(int p_i723_1_, Material p_i723_2_) {
      super(p_i723_1_);
      this.field_321_a = p_i723_2_;
      this.field_290_aT = 1;
   }

   public boolean func_192_a(ItemStack p_192_1_, EntityPlayer p_192_2_, World p_192_3_, int p_192_4_, int p_192_5_, int p_192_6_, int p_192_7_) {
      if(p_192_7_ != 1) {
         return false;
      } else {
         ++p_192_5_;
         Block var8;
         if(this.field_321_a == Material.field_1335_c) {
            var8 = Block.field_442_aF;
         } else {
            var8 = Block.field_435_aM;
         }

         if(p_192_2_.func_35190_e(p_192_4_, p_192_5_, p_192_6_) && p_192_2_.func_35190_e(p_192_4_, p_192_5_ + 1, p_192_6_)) {
            if(!var8.func_243_a(p_192_3_, p_192_4_, p_192_5_, p_192_6_)) {
               return false;
            } else {
               int var9 = MathHelper.func_1108_b((double)((p_192_2_.field_605_aq + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
               func_35434_a(p_192_3_, p_192_4_, p_192_5_, p_192_6_, var9, var8);
               --p_192_1_.field_1615_a;
               return true;
            }
         } else {
            return false;
         }
      }
   }

   public static void func_35434_a(World p_35434_0_, int p_35434_1_, int p_35434_2_, int p_35434_3_, int p_35434_4_, Block p_35434_5_) {
      byte var6 = 0;
      byte var7 = 0;
      if(p_35434_4_ == 0) {
         var7 = 1;
      }

      if(p_35434_4_ == 1) {
         var6 = -1;
      }

      if(p_35434_4_ == 2) {
         var7 = -1;
      }

      if(p_35434_4_ == 3) {
         var6 = 1;
      }

      int var8 = (p_35434_0_.func_28100_h(p_35434_1_ - var6, p_35434_2_, p_35434_3_ - var7)?1:0) + (p_35434_0_.func_28100_h(p_35434_1_ - var6, p_35434_2_ + 1, p_35434_3_ - var7)?1:0);
      int var9 = (p_35434_0_.func_28100_h(p_35434_1_ + var6, p_35434_2_, p_35434_3_ + var7)?1:0) + (p_35434_0_.func_28100_h(p_35434_1_ + var6, p_35434_2_ + 1, p_35434_3_ + var7)?1:0);
      boolean var10 = p_35434_0_.func_600_a(p_35434_1_ - var6, p_35434_2_, p_35434_3_ - var7) == p_35434_5_.field_376_bc || p_35434_0_.func_600_a(p_35434_1_ - var6, p_35434_2_ + 1, p_35434_3_ - var7) == p_35434_5_.field_376_bc;
      boolean var11 = p_35434_0_.func_600_a(p_35434_1_ + var6, p_35434_2_, p_35434_3_ + var7) == p_35434_5_.field_376_bc || p_35434_0_.func_600_a(p_35434_1_ + var6, p_35434_2_ + 1, p_35434_3_ + var7) == p_35434_5_.field_376_bc;
      boolean var12 = false;
      if(var10 && !var11) {
         var12 = true;
      } else if(var9 > var8) {
         var12 = true;
      }

      p_35434_0_.field_1043_h = true;
      p_35434_0_.func_688_b(p_35434_1_, p_35434_2_, p_35434_3_, p_35434_5_.field_376_bc, p_35434_4_);
      p_35434_0_.func_688_b(p_35434_1_, p_35434_2_ + 1, p_35434_3_, p_35434_5_.field_376_bc, 8 | (var12?1:0));
      p_35434_0_.field_1043_h = false;
      p_35434_0_.func_611_g(p_35434_1_, p_35434_2_, p_35434_3_, p_35434_5_.field_376_bc);
      p_35434_0_.func_611_g(p_35434_1_, p_35434_2_ + 1, p_35434_3_, p_35434_5_.field_376_bc);
   }
}
