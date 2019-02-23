package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.Material;

public class BlockClay extends Block {

   public BlockClay(int p_i117_1_, int p_i117_2_) {
      super(p_i117_1_, p_i117_2_, Material.field_1316_v);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_303_aG.field_291_aS;
   }

   public int func_229_a(Random p_229_1_) {
      return 4;
   }
}
