package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BlockRail;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.World;

public class BlockDetectorRail extends BlockRail {

   public BlockDetectorRail(int p_i82_1_, int p_i82_2_) {
      super(p_i82_1_, p_i82_2_, true);
      this.func_253_b(true);
   }

   public int func_4025_d() {
      return 20;
   }

   public boolean func_209_d() {
      return true;
   }

   public void func_236_b(World p_236_1_, int p_236_2_, int p_236_3_, int p_236_4_, Entity p_236_5_) {
      if(!p_236_1_.field_1026_y) {
         int var6 = p_236_1_.func_602_e(p_236_2_, p_236_3_, p_236_4_);
         if((var6 & 8) == 0) {
            this.func_27046_f(p_236_1_, p_236_2_, p_236_3_, p_236_4_, var6);
         }
      }
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y) {
         int var6 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         if((var6 & 8) != 0) {
            this.func_27046_f(p_208_1_, p_208_2_, p_208_3_, p_208_4_, var6);
         }
      }
   }

   public boolean func_231_b(IBlockAccess p_231_1_, int p_231_2_, int p_231_3_, int p_231_4_, int p_231_5_) {
      return (p_231_1_.func_602_e(p_231_2_, p_231_3_, p_231_4_) & 8) != 0;
   }

   public boolean func_228_c(World p_228_1_, int p_228_2_, int p_228_3_, int p_228_4_, int p_228_5_) {
      return (p_228_1_.func_602_e(p_228_2_, p_228_3_, p_228_4_) & 8) == 0?false:p_228_5_ == 1;
   }

   private void func_27046_f(World p_27046_1_, int p_27046_2_, int p_27046_3_, int p_27046_4_, int p_27046_5_) {
      boolean var6 = (p_27046_5_ & 8) != 0;
      boolean var7 = false;
      float var8 = 0.125F;
      List var9 = p_27046_1_.func_657_a(EntityMinecart.class, AxisAlignedBB.func_1161_b((double)((float)p_27046_2_ + var8), (double)p_27046_3_, (double)((float)p_27046_4_ + var8), (double)((float)(p_27046_2_ + 1) - var8), (double)((float)(p_27046_3_ + 1) - var8), (double)((float)(p_27046_4_ + 1) - var8)));
      if(var9.size() > 0) {
         var7 = true;
      }

      if(var7 && !var6) {
         p_27046_1_.func_691_b(p_27046_2_, p_27046_3_, p_27046_4_, p_27046_5_ | 8);
         p_27046_1_.func_611_g(p_27046_2_, p_27046_3_, p_27046_4_, this.field_376_bc);
         p_27046_1_.func_611_g(p_27046_2_, p_27046_3_ - 1, p_27046_4_, this.field_376_bc);
         p_27046_1_.func_701_b(p_27046_2_, p_27046_3_, p_27046_4_, p_27046_2_, p_27046_3_, p_27046_4_);
      }

      if(!var7 && var6) {
         p_27046_1_.func_691_b(p_27046_2_, p_27046_3_, p_27046_4_, p_27046_5_ & 7);
         p_27046_1_.func_611_g(p_27046_2_, p_27046_3_, p_27046_4_, this.field_376_bc);
         p_27046_1_.func_611_g(p_27046_2_, p_27046_3_ - 1, p_27046_4_, this.field_376_bc);
         p_27046_1_.func_701_b(p_27046_2_, p_27046_3_, p_27046_4_, p_27046_2_, p_27046_3_, p_27046_4_);
      }

      if(var7) {
         p_27046_1_.func_22136_c(p_27046_2_, p_27046_3_, p_27046_4_, this.field_376_bc, this.func_4025_d());
      }

   }
}
