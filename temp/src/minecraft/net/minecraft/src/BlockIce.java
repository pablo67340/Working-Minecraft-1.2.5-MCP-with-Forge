package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockIce extends BlockBreakable {

   public BlockIce(int p_i405_1_, int p_i405_2_) {
      super(p_i405_1_, p_i405_2_, Material.field_1320_r, false);
      this.field_355_bo = 0.98F;
      this.func_253_b(true);
   }

   public int func_234_g() {
      return 1;
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      return super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, 1 - p_260_5_);
   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      super.func_220_a_(p_220_1_, p_220_2_, p_220_3_, p_220_4_, p_220_5_, p_220_6_);
      Material var7 = p_220_1_.func_599_f(p_220_3_, p_220_4_ - 1, p_220_5_);
      if(var7.func_880_c() || var7.func_879_d()) {
         p_220_1_.func_690_d(p_220_3_, p_220_4_, p_220_5_, Block.field_401_B.field_376_bc);
      }

   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(p_208_1_.func_641_a(EnumSkyBlock.Block, p_208_2_, p_208_3_, p_208_4_) > 11 - Block.field_341_r[this.field_376_bc]) {
         this.func_259_b_(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_), 0);
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, Block.field_399_C.field_376_bc);
      }

   }

   public int func_31029_h() {
      return 0;
   }

   protected ItemStack func_41049_c_(int p_41049_1_) {
      return null;
   }
}
