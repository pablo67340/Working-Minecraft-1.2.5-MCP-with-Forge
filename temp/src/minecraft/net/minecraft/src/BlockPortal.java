package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBreakable;
import net.minecraft.src.Entity;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPortal extends BlockBreakable {

   public BlockPortal(int p_i203_1_, int p_i203_2_) {
      super(p_i203_1_, p_i203_2_, Material.field_4260_x, false);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return null;
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      float var5;
      float var6;
      if(p_238_1_.func_600_a(p_238_2_ - 1, p_238_3_, p_238_4_) != this.field_376_bc && p_238_1_.func_600_a(p_238_2_ + 1, p_238_3_, p_238_4_) != this.field_376_bc) {
         var5 = 0.125F;
         var6 = 0.5F;
         this.func_213_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
      } else {
         var5 = 0.5F;
         var6 = 0.125F;
         this.func_213_a(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
      }

   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_4032_a_(World p_4032_1_, int p_4032_2_, int p_4032_3_, int p_4032_4_) {
      byte var5 = 0;
      byte var6 = 0;
      if(p_4032_1_.func_600_a(p_4032_2_ - 1, p_4032_3_, p_4032_4_) == Block.field_405_aq.field_376_bc || p_4032_1_.func_600_a(p_4032_2_ + 1, p_4032_3_, p_4032_4_) == Block.field_405_aq.field_376_bc) {
         var5 = 1;
      }

      if(p_4032_1_.func_600_a(p_4032_2_, p_4032_3_, p_4032_4_ - 1) == Block.field_405_aq.field_376_bc || p_4032_1_.func_600_a(p_4032_2_, p_4032_3_, p_4032_4_ + 1) == Block.field_405_aq.field_376_bc) {
         var6 = 1;
      }

      if(var5 == var6) {
         return false;
      } else {
         if(p_4032_1_.func_600_a(p_4032_2_ - var5, p_4032_3_, p_4032_4_ - var6) == 0) {
            p_4032_2_ -= var5;
            p_4032_4_ -= var6;
         }

         int var7;
         int var8;
         for(var7 = -1; var7 <= 2; ++var7) {
            for(var8 = -1; var8 <= 3; ++var8) {
               boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;
               if(var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3) {
                  int var10 = p_4032_1_.func_600_a(p_4032_2_ + var5 * var7, p_4032_3_ + var8, p_4032_4_ + var6 * var7);
                  if(var9) {
                     if(var10 != Block.field_405_aq.field_376_bc) {
                        return false;
                     }
                  } else if(var10 != 0 && var10 != Block.field_402_as.field_376_bc) {
                     return false;
                  }
               }
            }
         }

         p_4032_1_.field_1043_h = true;

         for(var7 = 0; var7 < 2; ++var7) {
            for(var8 = 0; var8 < 3; ++var8) {
               p_4032_1_.func_690_d(p_4032_2_ + var5 * var7, p_4032_3_ + var8, p_4032_4_ + var6 * var7, Block.field_4047_bf.field_376_bc);
            }
         }

         p_4032_1_.field_1043_h = false;
         return true;
      }
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      byte var6 = 0;
      byte var7 = 1;
      if(p_226_1_.func_600_a(p_226_2_ - 1, p_226_3_, p_226_4_) == this.field_376_bc || p_226_1_.func_600_a(p_226_2_ + 1, p_226_3_, p_226_4_) == this.field_376_bc) {
         var6 = 1;
         var7 = 0;
      }

      int var8;
      for(var8 = p_226_3_; p_226_1_.func_600_a(p_226_2_, var8 - 1, p_226_4_) == this.field_376_bc; --var8) {
         ;
      }

      if(p_226_1_.func_600_a(p_226_2_, var8 - 1, p_226_4_) != Block.field_405_aq.field_376_bc) {
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      } else {
         int var9;
         for(var9 = 1; var9 < 4 && p_226_1_.func_600_a(p_226_2_, var8 + var9, p_226_4_) == this.field_376_bc; ++var9) {
            ;
         }

         if(var9 == 3 && p_226_1_.func_600_a(p_226_2_, var8 + var9, p_226_4_) == Block.field_405_aq.field_376_bc) {
            boolean var10 = p_226_1_.func_600_a(p_226_2_ - 1, p_226_3_, p_226_4_) == this.field_376_bc || p_226_1_.func_600_a(p_226_2_ + 1, p_226_3_, p_226_4_) == this.field_376_bc;
            boolean var11 = p_226_1_.func_600_a(p_226_2_, p_226_3_, p_226_4_ - 1) == this.field_376_bc || p_226_1_.func_600_a(p_226_2_, p_226_3_, p_226_4_ + 1) == this.field_376_bc;
            if(var10 && var11) {
               p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
            } else if((p_226_1_.func_600_a(p_226_2_ + var6, p_226_3_, p_226_4_ + var7) != Block.field_405_aq.field_376_bc || p_226_1_.func_600_a(p_226_2_ - var6, p_226_3_, p_226_4_ - var7) != this.field_376_bc) && (p_226_1_.func_600_a(p_226_2_ - var6, p_226_3_, p_226_4_ - var7) != Block.field_405_aq.field_376_bc || p_226_1_.func_600_a(p_226_2_ + var6, p_226_3_, p_226_4_ + var7) != this.field_376_bc)) {
               p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
            }
         } else {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         }
      }
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      if(p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_) == this.field_376_bc) {
         return false;
      } else {
         boolean var6 = p_260_1_.func_600_a(p_260_2_ - 1, p_260_3_, p_260_4_) == this.field_376_bc && p_260_1_.func_600_a(p_260_2_ - 2, p_260_3_, p_260_4_) != this.field_376_bc;
         boolean var7 = p_260_1_.func_600_a(p_260_2_ + 1, p_260_3_, p_260_4_) == this.field_376_bc && p_260_1_.func_600_a(p_260_2_ + 2, p_260_3_, p_260_4_) != this.field_376_bc;
         boolean var8 = p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_ - 1) == this.field_376_bc && p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_ - 2) != this.field_376_bc;
         boolean var9 = p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_ + 1) == this.field_376_bc && p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_ + 2) != this.field_376_bc;
         boolean var10 = var6 || var7;
         boolean var11 = var8 || var9;
         return var10 && p_260_5_ == 4?true:(var10 && p_260_5_ == 5?true:(var11 && p_260_5_ == 2?true:var11 && p_260_5_ == 3));
      }
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public int func_234_g() {
      return 1;
   }

   public void func_236_b(World p_236_1_, int p_236_2_, int p_236_3_, int p_236_4_, Entity p_236_5_) {
      if(p_236_5_.field_616_af == null && p_236_5_.field_617_ae == null) {
         p_236_5_.func_4039_q();
      }

   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      if(p_247_5_.nextInt(100) == 0) {
         p_247_1_.func_684_a((double)p_247_2_ + 0.5D, (double)p_247_3_ + 0.5D, (double)p_247_4_ + 0.5D, "portal.portal", 0.5F, p_247_5_.nextFloat() * 0.4F + 0.8F);
      }

      for(int var6 = 0; var6 < 4; ++var6) {
         double var7 = (double)((float)p_247_2_ + p_247_5_.nextFloat());
         double var9 = (double)((float)p_247_3_ + p_247_5_.nextFloat());
         double var11 = (double)((float)p_247_4_ + p_247_5_.nextFloat());
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         int var19 = p_247_5_.nextInt(2) * 2 - 1;
         var13 = ((double)p_247_5_.nextFloat() - 0.5D) * 0.5D;
         var15 = ((double)p_247_5_.nextFloat() - 0.5D) * 0.5D;
         var17 = ((double)p_247_5_.nextFloat() - 0.5D) * 0.5D;
         if(p_247_1_.func_600_a(p_247_2_ - 1, p_247_3_, p_247_4_) != this.field_376_bc && p_247_1_.func_600_a(p_247_2_ + 1, p_247_3_, p_247_4_) != this.field_376_bc) {
            var7 = (double)p_247_2_ + 0.5D + 0.25D * (double)var19;
            var13 = (double)(p_247_5_.nextFloat() * 2.0F * (float)var19);
         } else {
            var11 = (double)p_247_4_ + 0.5D + 0.25D * (double)var19;
            var17 = (double)(p_247_5_.nextFloat() * 2.0F * (float)var19);
         }

         p_247_1_.func_694_a("portal", var7, var9, var11, var13, var15, var17);
      }

   }
}
