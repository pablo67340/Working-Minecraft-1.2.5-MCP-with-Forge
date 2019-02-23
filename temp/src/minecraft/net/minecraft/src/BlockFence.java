package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFence extends Block {

   public BlockFence(int p_i765_1_, int p_i765_2_) {
      super(p_i765_1_, p_i765_2_, Material.field_1335_c);
   }

   public BlockFence(int p_i766_1_, int p_i766_2_, Material p_i766_3_) {
      super(p_i766_1_, p_i766_2_, p_i766_3_);
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      boolean var5 = this.func_35303_f(p_221_1_, p_221_2_, p_221_3_, p_221_4_ - 1);
      boolean var6 = this.func_35303_f(p_221_1_, p_221_2_, p_221_3_, p_221_4_ + 1);
      boolean var7 = this.func_35303_f(p_221_1_, p_221_2_ - 1, p_221_3_, p_221_4_);
      boolean var8 = this.func_35303_f(p_221_1_, p_221_2_ + 1, p_221_3_, p_221_4_);
      float var9 = 0.375F;
      float var10 = 0.625F;
      float var11 = 0.375F;
      float var12 = 0.625F;
      if(var5) {
         var11 = 0.0F;
      }

      if(var6) {
         var12 = 1.0F;
      }

      if(var7) {
         var9 = 0.0F;
      }

      if(var8) {
         var10 = 1.0F;
      }

      return AxisAlignedBB.func_1161_b((double)((float)p_221_2_ + var9), (double)p_221_3_, (double)((float)p_221_4_ + var11), (double)((float)p_221_2_ + var10), (double)((float)p_221_3_ + 1.5F), (double)((float)p_221_4_ + var12));
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      boolean var5 = this.func_35303_f(p_238_1_, p_238_2_, p_238_3_, p_238_4_ - 1);
      boolean var6 = this.func_35303_f(p_238_1_, p_238_2_, p_238_3_, p_238_4_ + 1);
      boolean var7 = this.func_35303_f(p_238_1_, p_238_2_ - 1, p_238_3_, p_238_4_);
      boolean var8 = this.func_35303_f(p_238_1_, p_238_2_ + 1, p_238_3_, p_238_4_);
      float var9 = 0.375F;
      float var10 = 0.625F;
      float var11 = 0.375F;
      float var12 = 0.625F;
      if(var5) {
         var11 = 0.0F;
      }

      if(var6) {
         var12 = 1.0F;
      }

      if(var7) {
         var9 = 0.0F;
      }

      if(var8) {
         var10 = 1.0F;
      }

      this.func_213_a(var9, 0.0F, var11, var10, 1.0F, var12);
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return false;
   }

   public int func_210_f() {
      return 11;
   }

   public boolean func_35303_f(IBlockAccess p_35303_1_, int p_35303_2_, int p_35303_3_, int p_35303_4_) {
      int var5 = p_35303_1_.func_600_a(p_35303_2_, p_35303_3_, p_35303_4_);
      if(var5 != this.field_376_bc && var5 != Block.field_35277_bw.field_376_bc) {
         Block var6 = Block.field_345_n[var5];
         return var6 != null && var6.field_356_bn.func_28126_h() && var6.func_242_c()?var6.field_356_bn != Material.field_4261_w:false;
      } else {
         return true;
      }
   }
}
