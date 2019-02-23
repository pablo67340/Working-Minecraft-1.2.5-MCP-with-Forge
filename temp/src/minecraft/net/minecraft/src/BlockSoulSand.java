package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSoulSand extends Block {

   public BlockSoulSand(int p_i60_1_, int p_i60_2_) {
      super(p_i60_1_, p_i60_2_, Material.field_1325_m);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      float var5 = 0.125F;
      return AxisAlignedBB.func_1161_b((double)p_221_2_, (double)p_221_3_, (double)p_221_4_, (double)(p_221_2_ + 1), (double)((float)(p_221_3_ + 1) - var5), (double)(p_221_4_ + 1));
   }

   public void func_236_b(World p_236_1_, int p_236_2_, int p_236_3_, int p_236_4_, Entity p_236_5_) {
      p_236_5_.field_608_an *= 0.4D;
      p_236_5_.field_606_ap *= 0.4D;
   }
}
