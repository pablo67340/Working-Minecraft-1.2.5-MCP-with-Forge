package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockCloth extends Block {

   public BlockCloth() {
      super(35, 64, Material.field_4264_k);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      if(p_232_2_ == 0) {
         return this.field_378_bb;
      } else {
         p_232_2_ = ~(p_232_2_ & 15);
         return 113 + ((p_232_2_ & 8) >> 3) + (p_232_2_ & 7) * 16;
      }
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_;
   }

   public static int func_21034_c(int p_21034_0_) {
      return ~p_21034_0_ & 15;
   }

   public static int func_21035_d(int p_21035_0_) {
      return ~p_21035_0_ & 15;
   }
}
