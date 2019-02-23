package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockCauldron extends Block {

   public BlockCauldron(int p_i683_1_) {
      super(p_i683_1_, Material.field_1333_e);
      this.field_378_bb = 154;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1?138:(p_232_1_ == 0?155:154);
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      float var7 = 0.125F;
      this.func_213_a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      this.func_213_a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      this.func_213_a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      this.func_237_e();
   }

   public void func_237_e() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean func_217_b() {
      return false;
   }

   public int func_210_f() {
      return 24;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         ItemStack var6 = p_250_5_.field_778_b.func_494_a();
         if(var6 == null) {
            return true;
         } else {
            int var7 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
            if(var6.field_1617_c == Item.field_4016_av.field_291_aS) {
               if(var7 < 3) {
                  if(!p_250_5_.field_35212_aW.field_35756_d) {
                     p_250_5_.field_778_b.func_472_a(p_250_5_.field_778_b.field_847_d, new ItemStack(Item.field_262_au));
                  }

                  p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, 3);
               }

               return true;
            } else {
               if(var6.field_1617_c == Item.field_40416_bt.field_291_aS && var7 > 0) {
                  ItemStack var8 = new ItemStack(Item.field_40413_bs, 1, 0);
                  if(!p_250_5_.field_778_b.func_504_a(var8)) {
                     p_250_1_.func_674_a(new EntityItem(p_250_1_, (double)p_250_2_ + 0.5D, (double)p_250_3_ + 1.5D, (double)p_250_4_ + 0.5D, var8));
                  }

                  --var6.field_1615_a;
                  if(var6.field_1615_a <= 0) {
                     p_250_5_.field_778_b.func_472_a(p_250_5_.field_778_b.field_847_d, (ItemStack)null);
                  }

                  p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var7 - 1);
               }

               return true;
            }
         }
      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_40408_bz.field_291_aS;
   }
}
