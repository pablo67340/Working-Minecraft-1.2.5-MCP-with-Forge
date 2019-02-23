package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockButton extends Block {

   protected BlockButton(int p_i414_1_, int p_i414_2_) {
      super(p_i414_1_, p_i414_2_, Material.field_1324_n);
      this.func_253_b(true);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public int func_4025_d() {
      return 20;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_28030_e(World p_28030_1_, int p_28030_2_, int p_28030_3_, int p_28030_4_, int p_28030_5_) {
      return p_28030_5_ == 2 && p_28030_1_.func_28100_h(p_28030_2_, p_28030_3_, p_28030_4_ + 1)?true:(p_28030_5_ == 3 && p_28030_1_.func_28100_h(p_28030_2_, p_28030_3_, p_28030_4_ - 1)?true:(p_28030_5_ == 4 && p_28030_1_.func_28100_h(p_28030_2_ + 1, p_28030_3_, p_28030_4_)?true:p_28030_5_ == 5 && p_28030_1_.func_28100_h(p_28030_2_ - 1, p_28030_3_, p_28030_4_)));
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_28100_h(p_243_2_ - 1, p_243_3_, p_243_4_)?true:(p_243_1_.func_28100_h(p_243_2_ + 1, p_243_3_, p_243_4_)?true:(p_243_1_.func_28100_h(p_243_2_, p_243_3_, p_243_4_ - 1)?true:p_243_1_.func_28100_h(p_243_2_, p_243_3_, p_243_4_ + 1)));
   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      int var6 = p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_);
      int var7 = var6 & 8;
      var6 &= 7;
      if(p_258_5_ == 2 && p_258_1_.func_28100_h(p_258_2_, p_258_3_, p_258_4_ + 1)) {
         var6 = 4;
      } else if(p_258_5_ == 3 && p_258_1_.func_28100_h(p_258_2_, p_258_3_, p_258_4_ - 1)) {
         var6 = 3;
      } else if(p_258_5_ == 4 && p_258_1_.func_28100_h(p_258_2_ + 1, p_258_3_, p_258_4_)) {
         var6 = 2;
      } else if(p_258_5_ == 5 && p_258_1_.func_28100_h(p_258_2_ - 1, p_258_3_, p_258_4_)) {
         var6 = 1;
      } else {
         var6 = this.func_22036_h(p_258_1_, p_258_2_, p_258_3_, p_258_4_);
      }

      p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6 + var7);
   }

   private int func_22036_h(World p_22036_1_, int p_22036_2_, int p_22036_3_, int p_22036_4_) {
      return p_22036_1_.func_28100_h(p_22036_2_ - 1, p_22036_3_, p_22036_4_)?1:(p_22036_1_.func_28100_h(p_22036_2_ + 1, p_22036_3_, p_22036_4_)?2:(p_22036_1_.func_28100_h(p_22036_2_, p_22036_3_, p_22036_4_ - 1)?3:(p_22036_1_.func_28100_h(p_22036_2_, p_22036_3_, p_22036_4_ + 1)?4:1)));
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(this.func_305_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_)) {
         int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_) & 7;
         boolean var7 = false;
         if(!p_226_1_.func_28100_h(p_226_2_ - 1, p_226_3_, p_226_4_) && var6 == 1) {
            var7 = true;
         }

         if(!p_226_1_.func_28100_h(p_226_2_ + 1, p_226_3_, p_226_4_) && var6 == 2) {
            var7 = true;
         }

         if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_, p_226_4_ - 1) && var6 == 3) {
            var7 = true;
         }

         if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_, p_226_4_ + 1) && var6 == 4) {
            var7 = true;
         }

         if(var7) {
            this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         }
      }

   }

   private boolean func_305_h(World p_305_1_, int p_305_2_, int p_305_3_, int p_305_4_) {
      if(!this.func_243_a(p_305_1_, p_305_2_, p_305_3_, p_305_4_)) {
         this.func_259_b_(p_305_1_, p_305_2_, p_305_3_, p_305_4_, p_305_1_.func_602_e(p_305_2_, p_305_3_, p_305_4_), 0);
         p_305_1_.func_690_d(p_305_2_, p_305_3_, p_305_4_, 0);
         return false;
      } else {
         return true;
      }
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) > 0;
      float var8 = 0.375F;
      float var9 = 0.625F;
      float var10 = 0.1875F;
      float var11 = 0.125F;
      if(var7) {
         var11 = 0.0625F;
      }

      if(var6 == 1) {
         this.func_213_a(0.0F, var8, 0.5F - var10, var11, var9, 0.5F + var10);
      } else if(var6 == 2) {
         this.func_213_a(1.0F - var11, var8, 0.5F - var10, 1.0F, var9, 0.5F + var10);
      } else if(var6 == 3) {
         this.func_213_a(0.5F - var10, var8, 0.0F, 0.5F + var10, var9, var11);
      } else if(var6 == 4) {
         this.func_213_a(0.5F - var10, var8, 1.0F - var11, 0.5F + var10, var9, 1.0F);
      }

   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.func_250_a(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      int var6 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
      int var7 = var6 & 7;
      int var8 = 8 - (var6 & 8);
      if(var8 == 0) {
         return true;
      } else {
         p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var7 + var8);
         p_250_1_.func_701_b(p_250_2_, p_250_3_, p_250_4_, p_250_2_, p_250_3_, p_250_4_);
         p_250_1_.func_684_a((double)p_250_2_ + 0.5D, (double)p_250_3_ + 0.5D, (double)p_250_4_ + 0.5D, "random.click", 0.3F, 0.6F);
         p_250_1_.func_611_g(p_250_2_, p_250_3_, p_250_4_, this.field_376_bc);
         if(var7 == 1) {
            p_250_1_.func_611_g(p_250_2_ - 1, p_250_3_, p_250_4_, this.field_376_bc);
         } else if(var7 == 2) {
            p_250_1_.func_611_g(p_250_2_ + 1, p_250_3_, p_250_4_, this.field_376_bc);
         } else if(var7 == 3) {
            p_250_1_.func_611_g(p_250_2_, p_250_3_, p_250_4_ - 1, this.field_376_bc);
         } else if(var7 == 4) {
            p_250_1_.func_611_g(p_250_2_, p_250_3_, p_250_4_ + 1, this.field_376_bc);
         } else {
            p_250_1_.func_611_g(p_250_2_, p_250_3_ - 1, p_250_4_, this.field_376_bc);
         }

         p_250_1_.func_22136_c(p_250_2_, p_250_3_, p_250_4_, this.field_376_bc, this.func_4025_d());
         return true;
      }
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      int var5 = p_214_1_.func_602_e(p_214_2_, p_214_3_, p_214_4_);
      if((var5 & 8) > 0) {
         p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_, this.field_376_bc);
         int var6 = var5 & 7;
         if(var6 == 1) {
            p_214_1_.func_611_g(p_214_2_ - 1, p_214_3_, p_214_4_, this.field_376_bc);
         } else if(var6 == 2) {
            p_214_1_.func_611_g(p_214_2_ + 1, p_214_3_, p_214_4_, this.field_376_bc);
         } else if(var6 == 3) {
            p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_ - 1, this.field_376_bc);
         } else if(var6 == 4) {
            p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_ + 1, this.field_376_bc);
         } else {
            p_214_1_.func_611_g(p_214_2_, p_214_3_ - 1, p_214_4_, this.field_376_bc);
         }
      }

      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

   public boolean func_231_b(IBlockAccess p_231_1_, int p_231_2_, int p_231_3_, int p_231_4_, int p_231_5_) {
      return (p_231_1_.func_602_e(p_231_2_, p_231_3_, p_231_4_) & 8) > 0;
   }

   public boolean func_228_c(World p_228_1_, int p_228_2_, int p_228_3_, int p_228_4_, int p_228_5_) {
      int var6 = p_228_1_.func_602_e(p_228_2_, p_228_3_, p_228_4_);
      if((var6 & 8) == 0) {
         return false;
      } else {
         int var7 = var6 & 7;
         return var7 == 5 && p_228_5_ == 1?true:(var7 == 4 && p_228_5_ == 2?true:(var7 == 3 && p_228_5_ == 3?true:(var7 == 2 && p_228_5_ == 4?true:var7 == 1 && p_228_5_ == 5)));
      }
   }

   public boolean func_209_d() {
      return true;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!p_208_1_.field_1026_y) {
         int var6 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         if((var6 & 8) != 0) {
            p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var6 & 7);
            p_208_1_.func_611_g(p_208_2_, p_208_3_, p_208_4_, this.field_376_bc);
            int var7 = var6 & 7;
            if(var7 == 1) {
               p_208_1_.func_611_g(p_208_2_ - 1, p_208_3_, p_208_4_, this.field_376_bc);
            } else if(var7 == 2) {
               p_208_1_.func_611_g(p_208_2_ + 1, p_208_3_, p_208_4_, this.field_376_bc);
            } else if(var7 == 3) {
               p_208_1_.func_611_g(p_208_2_, p_208_3_, p_208_4_ - 1, this.field_376_bc);
            } else if(var7 == 4) {
               p_208_1_.func_611_g(p_208_2_, p_208_3_, p_208_4_ + 1, this.field_376_bc);
            } else {
               p_208_1_.func_611_g(p_208_2_, p_208_3_ - 1, p_208_4_, this.field_376_bc);
            }

            p_208_1_.func_684_a((double)p_208_2_ + 0.5D, (double)p_208_3_ + 0.5D, (double)p_208_4_ + 0.5D, "random.click", 0.3F, 0.5F);
            p_208_1_.func_701_b(p_208_2_, p_208_3_, p_208_4_, p_208_2_, p_208_3_, p_208_4_);
         }
      }
   }

   public void func_237_e() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.func_213_a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }
}
