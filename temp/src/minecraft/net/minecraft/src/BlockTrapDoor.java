package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockTrapDoor extends Block {

   protected BlockTrapDoor(int p_i420_1_, Material p_i420_2_) {
      super(p_i420_1_, p_i420_2_);
      this.field_378_bb = 84;
      if(p_i420_2_ == Material.field_1333_e) {
         ++this.field_378_bb;
      }

      float var3 = 0.5F;
      float var4 = 1.0F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return !func_28041_d(p_48204_1_.func_602_e(p_48204_2_, p_48204_3_, p_48204_4_));
   }

   public int func_210_f() {
      return 0;
   }

   public AxisAlignedBB func_246_f(World p_246_1_, int p_246_2_, int p_246_3_, int p_246_4_) {
      this.func_238_a(p_246_1_, p_246_2_, p_246_3_, p_246_4_);
      return super.func_246_f(p_246_1_, p_246_2_, p_246_3_, p_246_4_);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      this.func_238_a(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
      return super.func_221_d(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      this.func_28043_c(p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_));
   }

   public void func_237_e() {
      float var1 = 0.1875F;
      this.func_213_a(0.0F, 0.5F - var1 / 2.0F, 0.0F, 1.0F, 0.5F + var1 / 2.0F, 1.0F);
   }

   public void func_28043_c(int p_28043_1_) {
      float var2 = 0.1875F;
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, var2, 1.0F);
      if(func_28041_d(p_28043_1_)) {
         if((p_28043_1_ & 3) == 0) {
            this.func_213_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
         }

         if((p_28043_1_ & 3) == 1) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
         }

         if((p_28043_1_ & 3) == 2) {
            this.func_213_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

         if((p_28043_1_ & 3) == 3) {
            this.func_213_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
         }
      }

   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.func_250_a(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(this.field_356_bn == Material.field_1333_e) {
         return true;
      } else {
         int var6 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
         p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var6 ^ 4);
         p_250_1_.func_28107_a(p_250_5_, 1003, p_250_2_, p_250_3_, p_250_4_, 0);
         return true;
      }
   }

   public void func_28042_a(World p_28042_1_, int p_28042_2_, int p_28042_3_, int p_28042_4_, boolean p_28042_5_) {
      int var6 = p_28042_1_.func_602_e(p_28042_2_, p_28042_3_, p_28042_4_);
      boolean var7 = (var6 & 4) > 0;
      if(var7 != p_28042_5_) {
         p_28042_1_.func_691_b(p_28042_2_, p_28042_3_, p_28042_4_, var6 ^ 4);
         p_28042_1_.func_28107_a((EntityPlayer)null, 1003, p_28042_2_, p_28042_3_, p_28042_4_, 0);
      }
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y) {
         int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
         int var7 = p_226_2_;
         int var8 = p_226_4_;
         if((var6 & 3) == 0) {
            var8 = p_226_4_ + 1;
         }

         if((var6 & 3) == 1) {
            --var8;
         }

         if((var6 & 3) == 2) {
            var7 = p_226_2_ + 1;
         }

         if((var6 & 3) == 3) {
            --var7;
         }

         if(!func_41052_f(p_226_1_.func_600_a(var7, p_226_3_, var8))) {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
            this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var6, 0);
         }

         boolean var9 = p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_);
         if(var9 || p_226_5_ > 0 && Block.field_345_n[p_226_5_].func_209_d() || p_226_5_ == 0) {
            this.func_28042_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var9);
         }

      }
   }

   public MovingObjectPosition func_255_a(World p_255_1_, int p_255_2_, int p_255_3_, int p_255_4_, Vec3D p_255_5_, Vec3D p_255_6_) {
      this.func_238_a(p_255_1_, p_255_2_, p_255_3_, p_255_4_);
      return super.func_255_a(p_255_1_, p_255_2_, p_255_3_, p_255_4_, p_255_5_, p_255_6_);
   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      byte var6 = 0;
      if(p_258_5_ == 2) {
         var6 = 0;
      }

      if(p_258_5_ == 3) {
         var6 = 1;
      }

      if(p_258_5_ == 4) {
         var6 = 2;
      }

      if(p_258_5_ == 5) {
         var6 = 3;
      }

      p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6);
   }

   public boolean func_28030_e(World p_28030_1_, int p_28030_2_, int p_28030_3_, int p_28030_4_, int p_28030_5_) {
      if(p_28030_5_ == 0) {
         return false;
      } else if(p_28030_5_ == 1) {
         return false;
      } else {
         if(p_28030_5_ == 2) {
            ++p_28030_4_;
         }

         if(p_28030_5_ == 3) {
            --p_28030_4_;
         }

         if(p_28030_5_ == 4) {
            ++p_28030_2_;
         }

         if(p_28030_5_ == 5) {
            --p_28030_2_;
         }

         return func_41052_f(p_28030_1_.func_600_a(p_28030_2_, p_28030_3_, p_28030_4_));
      }
   }

   public static boolean func_28041_d(int p_28041_0_) {
      return (p_28041_0_ & 4) != 0;
   }

   private static boolean func_41052_f(int p_41052_0_) {
      if(p_41052_0_ <= 0) {
         return false;
      } else {
         Block var1 = Block.field_345_n[p_41052_0_];
         return var1 != null && var1.field_356_bn.func_28126_h() && var1.func_242_c() || var1 == Block.field_4049_be;
      }
   }
}
