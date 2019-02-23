package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ItemTool;
import net.minecraft.src.Material;

public class ItemPickaxe extends ItemTool {

   private static Block[] field_329_aX = new Block[]{Block.field_335_x, Block.field_411_ak, Block.field_410_al, Block.field_338_u, Block.field_9264_Q, Block.field_406_ap, Block.field_388_I, Block.field_412_aj, Block.field_386_J, Block.field_413_ai, Block.field_390_H, Block.field_391_ax, Block.field_389_ay, Block.field_4063_aU, Block.field_4053_bc, Block.field_9267_N, Block.field_9266_O, Block.field_433_aO, Block.field_432_aP, Block.field_440_aH, Block.field_9260_U, Block.field_9261_T};


   protected ItemPickaxe(int p_i232_1_, EnumToolMaterial p_i232_2_) {
      super(p_i232_1_, 2, p_i232_2_, field_329_aX);
   }

   public boolean func_4018_a(Block p_4018_1_) {
      return p_4018_1_ == Block.field_405_aq?this.field_20927_a.func_21208_d() == 3:(p_4018_1_ != Block.field_389_ay && p_4018_1_ != Block.field_391_ax?(p_4018_1_ != Block.field_413_ai && p_4018_1_ != Block.field_390_H?(p_4018_1_ != Block.field_412_aj && p_4018_1_ != Block.field_388_I?(p_4018_1_ != Block.field_9266_O && p_4018_1_ != Block.field_9267_N?(p_4018_1_ != Block.field_433_aO && p_4018_1_ != Block.field_432_aP?(p_4018_1_.field_356_bn == Material.field_1334_d?true:p_4018_1_.field_356_bn == Material.field_1333_e):this.field_20927_a.func_21208_d() >= 2):this.field_20927_a.func_21208_d() >= 1):this.field_20927_a.func_21208_d() >= 1):this.field_20927_a.func_21208_d() >= 2):this.field_20927_a.func_21208_d() >= 2);
   }

   public float func_204_a(ItemStack p_204_1_, Block p_204_2_) {
      return p_204_2_ != null && (p_204_2_.field_356_bn == Material.field_1333_e || p_204_2_.field_356_bn == Material.field_1334_d)?this.field_324_aY:super.func_204_a(p_204_1_, p_204_2_);
   }

}
