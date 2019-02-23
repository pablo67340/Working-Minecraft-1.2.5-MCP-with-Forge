package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class BlockOreStorage extends Block {

   public BlockOreStorage(int p_i601_1_, int p_i601_2_) {
      super(p_i601_1_, Material.field_1333_e);
      this.field_378_bb = p_i601_2_;
   }

   public int func_218_a(int p_218_1_) {
      return this.field_378_bb;
   }
}
