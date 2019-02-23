package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockWorkbench extends Block {

   protected BlockWorkbench(int p_i298_1_) {
      super(p_i298_1_, Material.field_1335_c);
      this.field_378_bb = 59;
   }

   public int func_218_a(int p_218_1_) {
      return p_218_1_ == 1?this.field_378_bb - 16:(p_218_1_ == 0?Block.field_334_y.func_218_a(0):(p_218_1_ != 2 && p_218_1_ != 4?this.field_378_bb:this.field_378_bb + 1));
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         p_250_5_.func_445_l(p_250_2_, p_250_3_, p_250_4_);
         return true;
      }
   }
}
