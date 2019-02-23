package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockWeb extends Block {

   public BlockWeb(int p_i468_1_, int p_i468_2_) {
      super(p_i468_1_, p_i468_2_, Material.field_31068_A);
   }

   public void func_236_b(World p_236_1_, int p_236_2_, int p_236_3_, int p_236_4_, Entity p_236_5_) {
      p_236_5_.func_35112_o();
   }

   public boolean func_217_b() {
      return false;
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public int func_210_f() {
      return 1;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_253_I.field_291_aS;
   }
}
