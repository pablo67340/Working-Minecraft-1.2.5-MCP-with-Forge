package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockSandStone extends Block {

   public BlockSandStone(int p_i461_1_) {
      super(p_i461_1_, 192, Material.field_1334_d);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ != 1 && (p_232_1_ != 0 || p_232_2_ != 1 && p_232_2_ != 2)?(p_232_1_ == 0?208:(p_232_2_ == 1?229:(p_232_2_ == 2?230:192))):176;
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb - 16:(p_218_1_ == 0?this.field_378_bb + 16:this.field_378_bb);
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_;
   }
}
