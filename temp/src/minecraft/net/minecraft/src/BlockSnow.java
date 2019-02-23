package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class BlockSnow extends Block {

   protected BlockSnow(int p_i351_1_, int p_i351_2_) {
      super(p_i351_1_, p_i351_2_, Material.field_1319_s);
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.func_253_b(true);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      int var5 = p_221_1_.func_602_e(p_221_2_, p_221_3_, p_221_4_) & 7;
      return var5 >= 3?AxisAlignedBB.func_1161_b((double)p_221_2_ + this.field_370_bf, (double)p_221_3_ + this.field_368_bg, (double)p_221_4_ + this.field_366_bh, (double)p_221_2_ + this.field_364_bi, (double)((float)p_221_3_ + 0.5F), (double)p_221_4_ + this.field_360_bk):null;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_) & 7;
      float var6 = (float)(2 * (1 + var5)) / 16.0F;
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, var6, 1.0F);
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      int var5 = p_243_1_.func_600_a(p_243_2_, p_243_3_ - 1, p_243_4_);
      return var5 != 0 && (var5 == Block.field_384_L.field_376_bc || Block.field_345_n[var5].func_217_b())?p_243_1_.func_599_f(p_243_2_, p_243_3_ - 1, p_243_4_).func_880_c():false;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      this.func_314_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
   }

   private boolean func_314_h(World p_314_1_, int p_314_2_, int p_314_3_, int p_314_4_) {
      if(!this.func_243_a(p_314_1_, p_314_2_, p_314_3_, p_314_4_)) {
         this.func_259_b_(p_314_1_, p_314_2_, p_314_3_, p_314_4_, p_314_1_.func_602_e(p_314_2_, p_314_3_, p_314_4_), 0);
         p_314_1_.func_690_d(p_314_2_, p_314_3_, p_314_4_, 0);
         return false;
      } else {
         return true;
      }
   }

   public void func_220_a_(World p_220_1_, EntityPlayer p_220_2_, int p_220_3_, int p_220_4_, int p_220_5_, int p_220_6_) {
      int var7 = Item.field_308_aB.field_291_aS;
      float var8 = 0.7F;
      double var9 = (double)(p_220_1_.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
      double var11 = (double)(p_220_1_.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
      double var13 = (double)(p_220_1_.field_1037_n.nextFloat() * var8) + (double)(1.0F - var8) * 0.5D;
      EntityItem var15 = new EntityItem(p_220_1_, (double)p_220_3_ + var9, (double)p_220_4_ + var11, (double)p_220_5_ + var13, new ItemStack(var7, 1, 0));
      var15.field_805_c = 10;
      p_220_1_.func_674_a(var15);
      p_220_1_.func_690_d(p_220_3_, p_220_4_, p_220_5_, 0);
      p_220_2_.func_25058_a(StatList.field_25159_y[this.field_376_bc], 1);
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Item.field_308_aB.field_291_aS;
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(p_208_1_.func_641_a(EnumSkyBlock.Block, p_208_2_, p_208_3_, p_208_4_) > 11) {
         this.func_259_b_(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_), 0);
         p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
      }

   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      return p_260_5_ == 1?true:super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_);
   }
}
