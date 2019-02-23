package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockLever extends Block {

   protected BlockLever(int p_i201_1_, int p_i201_2_) {
      super(p_i201_1_, p_i201_2_, Material.field_1324_n);
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

   public int func_210_f() {
      return 12;
   }

   public boolean func_28030_e(World p_28030_1_, int p_28030_2_, int p_28030_3_, int p_28030_4_, int p_28030_5_) {
      return p_28030_5_ == 1 && p_28030_1_.func_28100_h(p_28030_2_, p_28030_3_ - 1, p_28030_4_)?true:(p_28030_5_ == 2 && p_28030_1_.func_28100_h(p_28030_2_, p_28030_3_, p_28030_4_ + 1)?true:(p_28030_5_ == 3 && p_28030_1_.func_28100_h(p_28030_2_, p_28030_3_, p_28030_4_ - 1)?true:(p_28030_5_ == 4 && p_28030_1_.func_28100_h(p_28030_2_ + 1, p_28030_3_, p_28030_4_)?true:p_28030_5_ == 5 && p_28030_1_.func_28100_h(p_28030_2_ - 1, p_28030_3_, p_28030_4_))));
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return p_243_1_.func_28100_h(p_243_2_ - 1, p_243_3_, p_243_4_)?true:(p_243_1_.func_28100_h(p_243_2_ + 1, p_243_3_, p_243_4_)?true:(p_243_1_.func_28100_h(p_243_2_, p_243_3_, p_243_4_ - 1)?true:(p_243_1_.func_28100_h(p_243_2_, p_243_3_, p_243_4_ + 1)?true:p_243_1_.func_28100_h(p_243_2_, p_243_3_ - 1, p_243_4_))));
   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      int var6 = p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_);
      int var7 = var6 & 8;
      var6 &= 7;
      var6 = -1;
      if(p_258_5_ == 1 && p_258_1_.func_28100_h(p_258_2_, p_258_3_ - 1, p_258_4_)) {
         var6 = 5 + p_258_1_.field_1037_n.nextInt(2);
      }

      if(p_258_5_ == 2 && p_258_1_.func_28100_h(p_258_2_, p_258_3_, p_258_4_ + 1)) {
         var6 = 4;
      }

      if(p_258_5_ == 3 && p_258_1_.func_28100_h(p_258_2_, p_258_3_, p_258_4_ - 1)) {
         var6 = 3;
      }

      if(p_258_5_ == 4 && p_258_1_.func_28100_h(p_258_2_ + 1, p_258_3_, p_258_4_)) {
         var6 = 2;
      }

      if(p_258_5_ == 5 && p_258_1_.func_28100_h(p_258_2_ - 1, p_258_3_, p_258_4_)) {
         var6 = 1;
      }

      if(var6 == -1) {
         this.func_259_b_(p_258_1_, p_258_2_, p_258_3_, p_258_4_, p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_), 0);
         p_258_1_.func_690_d(p_258_2_, p_258_3_, p_258_4_, 0);
      } else {
         p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6 + var7);
      }
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(this.func_267_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_)) {
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

         if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_ - 1, p_226_4_) && var6 == 5) {
            var7 = true;
         }

         if(!p_226_1_.func_28100_h(p_226_2_, p_226_3_ - 1, p_226_4_) && var6 == 6) {
            var7 = true;
         }

         if(var7) {
            this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_), 0);
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         }
      }

   }

   private boolean func_267_h(World p_267_1_, int p_267_2_, int p_267_3_, int p_267_4_) {
      if(!this.func_243_a(p_267_1_, p_267_2_, p_267_3_, p_267_4_)) {
         this.func_259_b_(p_267_1_, p_267_2_, p_267_3_, p_267_4_, p_267_1_.func_602_e(p_267_2_, p_267_3_, p_267_4_), 0);
         p_267_1_.func_690_d(p_267_2_, p_267_3_, p_267_4_, 0);
         return false;
      } else {
         return true;
      }
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_) & 7;
      float var6 = 0.1875F;
      if(var5 == 1) {
         this.func_213_a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 2) {
         this.func_213_a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == 3) {
         this.func_213_a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == 4) {
         this.func_213_a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else {
         var6 = 0.25F;
         this.func_213_a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.func_250_a(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         int var6 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
         int var7 = var6 & 7;
         int var8 = 8 - (var6 & 8);
         p_250_1_.func_691_b(p_250_2_, p_250_3_, p_250_4_, var7 + var8);
         p_250_1_.func_701_b(p_250_2_, p_250_3_, p_250_4_, p_250_2_, p_250_3_, p_250_4_);
         p_250_1_.func_684_a((double)p_250_2_ + 0.5D, (double)p_250_3_ + 0.5D, (double)p_250_4_ + 0.5D, "random.click", 0.3F, var8 > 0?0.6F:0.5F);
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
         return var7 == 6 && p_228_5_ == 1?true:(var7 == 5 && p_228_5_ == 1?true:(var7 == 4 && p_228_5_ == 2?true:(var7 == 3 && p_228_5_ == 3?true:(var7 == 2 && p_228_5_ == 4?true:var7 == 1 && p_228_5_ == 5))));
      }
   }

   public boolean func_209_d() {
      return true;
   }
}
