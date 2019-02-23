package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockWood extends Block {

   public BlockWood(int p_i1205_1_) {
      super(p_i1205_1_, 4, Material.field_1335_c);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      switch(p_232_2_) {
      case 1:
         return 198;
      case 2:
         return 214;
      case 3:
         return 199;
      default:
         return 4;
      }
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_;
   }
}
