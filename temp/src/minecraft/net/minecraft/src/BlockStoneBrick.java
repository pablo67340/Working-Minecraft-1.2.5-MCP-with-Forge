package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockStoneBrick extends Block {

   public BlockStoneBrick(int p_i106_1_) {
      super(p_i106_1_, 54, Material.field_1334_d);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      switch(p_232_2_) {
      case 1:
         return 100;
      case 2:
         return 101;
      case 3:
         return 213;
      default:
         return 54;
      }
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_;
   }
}
