package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPressurePlate extends Block {

   private EnumMobType field_467_a;


   protected BlockPressurePlate(int p_i629_1_, int p_i629_2_, EnumMobType p_i629_3_, Material p_i629_4_) {
      super(p_i629_1_, p_i629_2_, p_i629_4_);
      this.field_467_a = p_i629_3_;
      this.func_253_b(true);
      float var5 = 0.0625F;
      this.func_213_a(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
   }

   public int func_4025_d() {
      return 20;
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return true;
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_28100_h(p_243_2_, p_243_3_ - 1, p_243_4_) || p_243_1_.func_600_a(p_243_2_, p_243_3_ - 1, p_243_4_) == Block.field_4057_ba.field_376_bc;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {}

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      boolean var6 = false;
      if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_ - 1, p_226_4_) && p_226_1_.func_600_a(p_226_2_, p_226_3_ - 1, p_226_4_) != Block.field_4057_ba.field_376_bc) {
         var6 = true;
      }

      if(var6) {
         this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      }

   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y) {
         if(p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_) != 0) {
            this.func_318_h(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
         }
      }
   }

   public void func_236_b(World p_236_1_, int p_236_2_, int p_236_3_, int p_236_4_, Entity p_236_5_) {
      if(!p_236_1_.field_1026_y) {
         if(p_236_1_.func_602_e(p_236_2_, p_236_3_, p_236_4_) != 1) {
            this.func_318_h(p_236_1_, p_236_2_, p_236_3_, p_236_4_);
         }
      }
   }

   private void func_318_h(World p_318_1_, int p_318_2_, int p_318_3_, int p_318_4_) {
      boolean var5 = p_318_1_.func_602_e(p_318_2_, p_318_3_, p_318_4_) == 1;
      boolean var6 = false;
      float var7 = 0.125F;
      List var8 = null;
      if(this.field_467_a == EnumMobType.everything) {
         var8 = p_318_1_.func_659_b((Entity)null, AxisAlignedBB.func_1161_b((double)((float)p_318_2_ + var7), (double)p_318_3_, (double)((float)p_318_4_ + var7), (double)((float)(p_318_2_ + 1) - var7), (double)p_318_3_ + 0.25D, (double)((float)(p_318_4_ + 1) - var7)));
      }

      if(this.field_467_a == EnumMobType.mobs) {
         var8 = p_318_1_.func_657_a(EntityLiving.class, AxisAlignedBB.func_1161_b((double)((float)p_318_2_ + var7), (double)p_318_3_, (double)((float)p_318_4_ + var7), (double)((float)(p_318_2_ + 1) - var7), (double)p_318_3_ + 0.25D, (double)((float)(p_318_4_ + 1) - var7)));
      }

      if(this.field_467_a == EnumMobType.players) {
         var8 = p_318_1_.func_657_a(EntityPlayer.class, AxisAlignedBB.func_1161_b((double)((float)p_318_2_ + var7), (double)p_318_3_, (double)((float)p_318_4_ + var7), (double)((float)(p_318_2_ + 1) - var7), (double)p_318_3_ + 0.25D, (double)((float)(p_318_4_ + 1) - var7)));
      }

      if(var8.size() > 0) {
         var6 = true;
      }

      if(var6 && !var5) {
         p_318_1_.func_691_b(p_318_2_, p_318_3_, p_318_4_, 1);
         p_318_1_.func_611_g(p_318_2_, p_318_3_, p_318_4_, this.field_376_bc);
         p_318_1_.func_611_g(p_318_2_, p_318_3_ - 1, p_318_4_, this.field_376_bc);
         p_318_1_.func_701_b(p_318_2_, p_318_3_, p_318_4_, p_318_2_, p_318_3_, p_318_4_);
         p_318_1_.func_684_a((double)p_318_2_ + 0.5D, (double)p_318_3_ + 0.1D, (double)p_318_4_ + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if(!var6 && var5) {
         p_318_1_.func_691_b(p_318_2_, p_318_3_, p_318_4_, 0);
         p_318_1_.func_611_g(p_318_2_, p_318_3_, p_318_4_, this.field_376_bc);
         p_318_1_.func_611_g(p_318_2_, p_318_3_ - 1, p_318_4_, this.field_376_bc);
         p_318_1_.func_701_b(p_318_2_, p_318_3_, p_318_4_, p_318_2_, p_318_3_, p_318_4_);
         p_318_1_.func_684_a((double)p_318_2_ + 0.5D, (double)p_318_3_ + 0.1D, (double)p_318_4_ + 0.5D, "random.click", 0.3F, 0.5F);
      }

      if(var6) {
         p_318_1_.func_22136_c(p_318_2_, p_318_3_, p_318_4_, this.field_376_bc, this.func_4025_d());
      }

   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      int var5 = p_214_1_.func_602_e(p_214_2_, p_214_3_, p_214_4_);
      if(var5 > 0) {
         p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_ - 1, p_214_4_, this.field_376_bc);
      }

      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      boolean var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_) == 1;
      float var6 = 0.0625F;
      if(var5) {
         this.func_213_a(var6, 0.0F, var6, 1.0F - var6, 0.03125F, 1.0F - var6);
      } else {
         this.func_213_a(var6, 0.0F, var6, 1.0F - var6, 0.0625F, 1.0F - var6);
      }

   }

   public boolean func_231_b(IBlockAccess p_231_1_, int p_231_2_, int p_231_3_, int p_231_4_, int p_231_5_) {
      return p_231_1_.func_602_e(p_231_2_, p_231_3_, p_231_4_) > 0;
   }

   public boolean func_228_c(World p_228_1_, int p_228_2_, int p_228_3_, int p_228_4_, int p_228_5_) {
      return p_228_1_.func_602_e(p_228_2_, p_228_3_, p_228_4_) == 0?false:p_228_5_ == 1;
   }

   public boolean func_209_d() {
      return true;
   }

   public void func_237_e() {
      float var1 = 0.5F;
      float var2 = 0.125F;
      float var3 = 0.5F;
      this.func_213_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   public int func_31029_h() {
      return 1;
   }
}
