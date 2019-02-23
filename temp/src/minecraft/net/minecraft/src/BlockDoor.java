package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockDoor extends Block {

   protected BlockDoor(int p_i6_1_, Material p_i6_2_) {
      super(p_i6_1_, p_i6_2_);
      this.field_378_bb = 97;
      if(p_i6_2_ == Material.field_1333_e) {
         ++this.field_378_bb;
      }

      float var3 = 0.5F;
      float var4 = 1.0F;
      this.func_213_a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
   }

   public int func_211_a(IBlockAccess p_211_1_, int p_211_2_, int p_211_3_, int p_211_4_, int p_211_5_) {
      if(p_211_5_ != 0 && p_211_5_ != 1) {
         int var6 = this.func_48212_i(p_211_1_, p_211_2_, p_211_3_, p_211_4_);
         int var7 = this.field_378_bb;
         if((var6 & 8) != 0) {
            var7 -= 16;
         }

         int var8 = var6 & 3;
         boolean var9 = (var6 & 4) != 0;
         if(!var9) {
            if(var8 == 0 && p_211_5_ == 5) {
               var7 = -var7;
            } else if(var8 == 1 && p_211_5_ == 3) {
               var7 = -var7;
            } else if(var8 == 2 && p_211_5_ == 4) {
               var7 = -var7;
            } else if(var8 == 3 && p_211_5_ == 2) {
               var7 = -var7;
            }

            if((var6 & 16) != 0) {
               var7 = -var7;
            }
         } else if(var8 == 0 && p_211_5_ == 2) {
            var7 = -var7;
         } else if(var8 == 1 && p_211_5_ == 5) {
            var7 = -var7;
         } else if(var8 == 2 && p_211_5_ == 3) {
            var7 = -var7;
         } else if(var8 == 3 && p_211_5_ == 4) {
            var7 = -var7;
         }

         return var7;
      } else {
         return this.field_378_bb;
      }
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      int var5 = this.func_48212_i(p_48204_1_, p_48204_2_, p_48204_3_, p_48204_4_);
      return (var5 & 4) != 0;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 7;
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
      this.func_313_b(this.func_48212_i(p_238_1_, p_238_2_, p_238_3_, p_238_4_));
   }

   public int func_48214_g(IBlockAccess p_48214_1_, int p_48214_2_, int p_48214_3_, int p_48214_4_) {
      return this.func_48212_i(p_48214_1_, p_48214_2_, p_48214_3_, p_48214_4_) & 3;
   }

   public boolean func_48213_h(IBlockAccess p_48213_1_, int p_48213_2_, int p_48213_3_, int p_48213_4_) {
      return (this.func_48212_i(p_48213_1_, p_48213_2_, p_48213_3_, p_48213_4_) & 4) != 0;
   }

   private void func_313_b(int p_313_1_) {
      float var2 = 0.1875F;
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      int var3 = p_313_1_ & 3;
      boolean var4 = (p_313_1_ & 4) != 0;
      boolean var5 = (p_313_1_ & 16) != 0;
      if(var3 == 0) {
         if(!var4) {
            this.func_213_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
         } else if(!var5) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
         } else {
            this.func_213_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
         }
      } else if(var3 == 1) {
         if(!var4) {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
         } else if(!var5) {
            this.func_213_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.func_213_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
         }
      } else if(var3 == 2) {
         if(!var4) {
            this.func_213_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if(!var5) {
            this.func_213_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
         } else {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
         }
      } else if(var3 == 3) {
         if(!var4) {
            this.func_213_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
         } else if(!var5) {
            this.func_213_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
         } else {
            this.func_213_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
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
         int var6 = this.func_48212_i(p_250_1_, p_250_2_, p_250_3_, p_250_4_);
         int var7 = var6 & 7;
         var7 ^= 4;
         if((var6 & 8) != 0) {
            p_250_1_.func_691_b(p_250_2_, p_250_3_ - 1, p_250_4_, var7);
            p_250_1_.func_701_b(p_250_2_, p_250_3_ - 1, p_250_4_, p_250_2_, p_250_3_, p_250_4_);
         } else {
            p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var7);
            p_250_1_.func_701_b(p_250_2_, p_250_3_, p_250_4_, p_250_2_, p_250_3_, p_250_4_);
         }

         p_250_1_.func_28107_a(p_250_5_, 1003, p_250_2_, p_250_3_, p_250_4_, 0);
         return true;
      }
   }

   public void func_311_a(World p_311_1_, int p_311_2_, int p_311_3_, int p_311_4_, boolean p_311_5_) {
      int var6 = this.func_48212_i(p_311_1_, p_311_2_, p_311_3_, p_311_4_);
      boolean var7 = (var6 & 4) != 0;
      if(var7 != p_311_5_) {
         int var8 = var6 & 7;
         var8 ^= 4;
         if((var6 & 8) != 0) {
            p_311_1_.func_691_b(p_311_2_, p_311_3_ - 1, p_311_4_, var8);
            p_311_1_.func_701_b(p_311_2_, p_311_3_ - 1, p_311_4_, p_311_2_, p_311_3_, p_311_4_);
         } else {
            p_311_1_.func_691_b(p_311_2_, p_311_3_, p_311_4_, var8);
            p_311_1_.func_701_b(p_311_2_, p_311_3_, p_311_4_, p_311_2_, p_311_3_, p_311_4_);
         }

         p_311_1_.func_28107_a((EntityPlayer)null, 1003, p_311_2_, p_311_3_, p_311_4_, 0);
      }
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
      if((var6 & 8) != 0) {
         if(p_226_1_.func_600_a(p_226_2_, p_226_3_ - 1, p_226_4_) != this.field_376_bc) {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         }

         if(p_226_5_ > 0 && p_226_5_ != this.field_376_bc) {
            this.func_226_a(p_226_1_, p_226_2_, p_226_3_ - 1, p_226_4_, p_226_5_);
         }
      } else {
         boolean var7 = false;
         if(p_226_1_.func_600_a(p_226_2_, p_226_3_ + 1, p_226_4_) != this.field_376_bc) {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
            var7 = true;
         }

         if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_ - 1, p_226_4_)) {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
            var7 = true;
            if(p_226_1_.func_600_a(p_226_2_, p_226_3_ + 1, p_226_4_) == this.field_376_bc) {
               p_226_1_.func_690_d(p_226_2_, p_226_3_ + 1, p_226_4_, 0);
            }
         }

         if(var7) {
            if(!p_226_1_.field_1026_y) {
               this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var6, 0);
            }
         } else {
            boolean var8 = p_226_1_.func_625_o(p_226_2_, p_226_3_, p_226_4_) || p_226_1_.func_625_o(p_226_2_, p_226_3_ + 1, p_226_4_);
            if((var8 || p_226_5_ > 0 && Block.field_345_n[p_226_5_].func_209_d() || p_226_5_ == 0) && p_226_5_ != this.field_376_bc) {
               this.func_311_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var8);
            }
         }
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return (p_240_1_ & 8) != 0?0:(this.field_356_bn == Material.field_1333_e?Item.field_252_az.field_291_aS:Item.field_265_at.field_291_aS);
   }

   public MovingObjectPosition func_255_a(World p_255_1_, int p_255_2_, int p_255_3_, int p_255_4_, Vec3D p_255_5_, Vec3D p_255_6_) {
      this.func_238_a(p_255_1_, p_255_2_, p_255_3_, p_255_4_);
      return super.func_255_a(p_255_1_, p_255_2_, p_255_3_, p_255_4_, p_255_5_, p_255_6_);
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_3_ >= 255?false:p_243_1_.func_28100_h(p_243_2_, p_243_3_ - 1, p_243_4_) && super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_) && super.func_243_a(p_243_1_, p_243_2_, p_243_3_ + 1, p_243_4_);
   }

   public int func_31029_h() {
      return 1;
   }

   public int func_48212_i(IBlockAccess p_48212_1_, int p_48212_2_, int p_48212_3_, int p_48212_4_) {
      int var5 = p_48212_1_.func_602_e(p_48212_2_, p_48212_3_, p_48212_4_);
      boolean var6 = (var5 & 8) != 0;
      int var7;
      int var8;
      if(var6) {
         var7 = p_48212_1_.func_602_e(p_48212_2_, p_48212_3_ - 1, p_48212_4_);
         var8 = var5;
      } else {
         var7 = var5;
         var8 = p_48212_1_.func_602_e(p_48212_2_, p_48212_3_ + 1, p_48212_4_);
      }

      boolean var9 = (var8 & 1) != 0;
      int var10 = var7 & 7 | (var6?8:0) | (var9?16:0);
      return var10;
   }
}
