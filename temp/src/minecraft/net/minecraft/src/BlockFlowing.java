package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFlowing extends BlockFluid {

   int field_460_a = 0;
   boolean[] field_459_b = new boolean[4];
   int[] field_461_c = new int[4];


   protected BlockFlowing(int p_i419_1_, Material p_i419_2_) {
      super(p_i419_1_, p_i419_2_);
   }

   private void func_30003_j(World p_30003_1_, int p_30003_2_, int p_30003_3_, int p_30003_4_) {
      int var5 = p_30003_1_.func_602_e(p_30003_2_, p_30003_3_, p_30003_4_);
      p_30003_1_.func_643_a(p_30003_2_, p_30003_3_, p_30003_4_, this.field_376_bc + 1, var5);
      p_30003_1_.func_701_b(p_30003_2_, p_30003_3_, p_30003_4_, p_30003_2_, p_30003_3_, p_30003_4_);
      p_30003_1_.func_665_h(p_30003_2_, p_30003_3_, p_30003_4_);
   }

   public boolean func_48204_b(IBlockAccess p_48204_1_, int p_48204_2_, int p_48204_3_, int p_48204_4_) {
      return this.field_356_bn != Material.field_1331_g;
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      int var6 = this.func_290_h(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
      byte var7 = 1;
      if(this.field_356_bn == Material.field_1331_g && !p_208_1_.field_4209_q.field_6479_d) {
         var7 = 2;
      }

      boolean var8 = true;
      int var10;
      if(var6 > 0) {
         byte var9 = -100;
         this.field_460_a = 0;
         int var12 = this.func_296_f(p_208_1_, p_208_2_ - 1, p_208_3_, p_208_4_, var9);
         var12 = this.func_296_f(p_208_1_, p_208_2_ + 1, p_208_3_, p_208_4_, var12);
         var12 = this.func_296_f(p_208_1_, p_208_2_, p_208_3_, p_208_4_ - 1, var12);
         var12 = this.func_296_f(p_208_1_, p_208_2_, p_208_3_, p_208_4_ + 1, var12);
         var10 = var12 + var7;
         if(var10 >= 8 || var12 < 0) {
            var10 = -1;
         }

         if(this.func_290_h(p_208_1_, p_208_2_, p_208_3_ + 1, p_208_4_) >= 0) {
            int var11 = this.func_290_h(p_208_1_, p_208_2_, p_208_3_ + 1, p_208_4_);
            if(var11 >= 8) {
               var10 = var11;
            } else {
               var10 = var11 + 8;
            }
         }

         if(this.field_460_a >= 2 && this.field_356_bn == Material.field_1332_f) {
            if(p_208_1_.func_599_f(p_208_2_, p_208_3_ - 1, p_208_4_).func_878_a()) {
               var10 = 0;
            } else if(p_208_1_.func_599_f(p_208_2_, p_208_3_ - 1, p_208_4_) == this.field_356_bn && p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_) == 0) {
               var10 = 0;
            }
         }

         if(this.field_356_bn == Material.field_1331_g && var6 < 8 && var10 < 8 && var10 > var6 && p_208_5_.nextInt(4) != 0) {
            var10 = var6;
            var8 = false;
         }

         if(var10 != var6) {
            var6 = var10;
            if(var10 < 0) {
               p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, 0);
            } else {
               p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var10);
               p_208_1_.func_22136_c(p_208_2_, p_208_3_, p_208_4_, this.field_376_bc, this.func_4025_d());
               p_208_1_.func_611_g(p_208_2_, p_208_3_, p_208_4_, this.field_376_bc);
            }
         } else if(var8) {
            this.func_30003_j(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
         }
      } else {
         this.func_30003_j(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
      }

      if(this.func_298_m(p_208_1_, p_208_2_, p_208_3_ - 1, p_208_4_)) {
         if(this.field_356_bn == Material.field_1331_g && p_208_1_.func_599_f(p_208_2_, p_208_3_ - 1, p_208_4_) == Material.field_1332_f) {
            p_208_1_.func_690_d(p_208_2_, p_208_3_ - 1, p_208_4_, Block.field_338_u.field_376_bc);
            this.func_292_i(p_208_1_, p_208_2_, p_208_3_ - 1, p_208_4_);
            return;
         }

         if(var6 >= 8) {
            p_208_1_.func_688_b(p_208_2_, p_208_3_ - 1, p_208_4_, this.field_376_bc, var6);
         } else {
            p_208_1_.func_688_b(p_208_2_, p_208_3_ - 1, p_208_4_, this.field_376_bc, var6 + 8);
         }
      } else if(var6 >= 0 && (var6 == 0 || this.func_295_l(p_208_1_, p_208_2_, p_208_3_ - 1, p_208_4_))) {
         boolean[] var13 = this.func_297_k(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
         var10 = var6 + var7;
         if(var6 >= 8) {
            var10 = 1;
         }

         if(var10 >= 8) {
            return;
         }

         if(var13[0]) {
            this.func_299_g(p_208_1_, p_208_2_ - 1, p_208_3_, p_208_4_, var10);
         }

         if(var13[1]) {
            this.func_299_g(p_208_1_, p_208_2_ + 1, p_208_3_, p_208_4_, var10);
         }

         if(var13[2]) {
            this.func_299_g(p_208_1_, p_208_2_, p_208_3_, p_208_4_ - 1, var10);
         }

         if(var13[3]) {
            this.func_299_g(p_208_1_, p_208_2_, p_208_3_, p_208_4_ + 1, var10);
         }
      }

   }

   private void func_299_g(World p_299_1_, int p_299_2_, int p_299_3_, int p_299_4_, int p_299_5_) {
      if(this.func_298_m(p_299_1_, p_299_2_, p_299_3_, p_299_4_)) {
         int var6 = p_299_1_.func_600_a(p_299_2_, p_299_3_, p_299_4_);
         if(var6 > 0) {
            if(this.field_356_bn == Material.field_1331_g) {
               this.func_292_i(p_299_1_, p_299_2_, p_299_3_, p_299_4_);
            } else {
               Block.field_345_n[var6].func_259_b_(p_299_1_, p_299_2_, p_299_3_, p_299_4_, p_299_1_.func_602_e(p_299_2_, p_299_3_, p_299_4_), 0);
            }
         }

         p_299_1_.func_688_b(p_299_2_, p_299_3_, p_299_4_, this.field_376_bc, p_299_5_);
      }

   }

   private int func_300_a(World p_300_1_, int p_300_2_, int p_300_3_, int p_300_4_, int p_300_5_, int p_300_6_) {
      int var7 = 1000;

      for(int var8 = 0; var8 < 4; ++var8) {
         if((var8 != 0 || p_300_6_ != 1) && (var8 != 1 || p_300_6_ != 0) && (var8 != 2 || p_300_6_ != 3) && (var8 != 3 || p_300_6_ != 2)) {
            int var9 = p_300_2_;
            int var11 = p_300_4_;
            if(var8 == 0) {
               var9 = p_300_2_ - 1;
            }

            if(var8 == 1) {
               ++var9;
            }

            if(var8 == 2) {
               var11 = p_300_4_ - 1;
            }

            if(var8 == 3) {
               ++var11;
            }

            if(!this.func_295_l(p_300_1_, var9, p_300_3_, var11) && (p_300_1_.func_599_f(var9, p_300_3_, var11) != this.field_356_bn || p_300_1_.func_602_e(var9, p_300_3_, var11) != 0)) {
               if(!this.func_295_l(p_300_1_, var9, p_300_3_ - 1, var11)) {
                  return p_300_5_;
               }

               if(p_300_5_ < 4) {
                  int var12 = this.func_300_a(p_300_1_, var9, p_300_3_, var11, p_300_5_ + 1, var8);
                  if(var12 < var7) {
                     var7 = var12;
                  }
               }
            }
         }
      }

      return var7;
   }

   private boolean[] func_297_k(World p_297_1_, int p_297_2_, int p_297_3_, int p_297_4_) {
      int var5;
      int var6;
      for(var5 = 0; var5 < 4; ++var5) {
         this.field_461_c[var5] = 1000;
         var6 = p_297_2_;
         int var8 = p_297_4_;
         if(var5 == 0) {
            var6 = p_297_2_ - 1;
         }

         if(var5 == 1) {
            ++var6;
         }

         if(var5 == 2) {
            var8 = p_297_4_ - 1;
         }

         if(var5 == 3) {
            ++var8;
         }

         if(!this.func_295_l(p_297_1_, var6, p_297_3_, var8) && (p_297_1_.func_599_f(var6, p_297_3_, var8) != this.field_356_bn || p_297_1_.func_602_e(var6, p_297_3_, var8) != 0)) {
            if(!this.func_295_l(p_297_1_, var6, p_297_3_ - 1, var8)) {
               this.field_461_c[var5] = 0;
            } else {
               this.field_461_c[var5] = this.func_300_a(p_297_1_, var6, p_297_3_, var8, 1, var5);
            }
         }
      }

      var5 = this.field_461_c[0];

      for(var6 = 1; var6 < 4; ++var6) {
         if(this.field_461_c[var6] < var5) {
            var5 = this.field_461_c[var6];
         }
      }

      for(var6 = 0; var6 < 4; ++var6) {
         this.field_459_b[var6] = this.field_461_c[var6] == var5;
      }

      return this.field_459_b;
   }

   private boolean func_295_l(World p_295_1_, int p_295_2_, int p_295_3_, int p_295_4_) {
      int var5 = p_295_1_.func_600_a(p_295_2_, p_295_3_, p_295_4_);
      if(var5 != Block.field_442_aF.field_376_bc && var5 != Block.field_435_aM.field_376_bc && var5 != Block.field_443_aE.field_376_bc && var5 != Block.field_441_aG.field_376_bc && var5 != Block.field_423_aY.field_376_bc) {
         if(var5 == 0) {
            return false;
         } else {
            Material var6 = Block.field_345_n[var5].field_356_bn;
            return var6 == Material.field_4260_x?true:var6.func_880_c();
         }
      } else {
         return true;
      }
   }

   protected int func_296_f(World p_296_1_, int p_296_2_, int p_296_3_, int p_296_4_, int p_296_5_) {
      int var6 = this.func_290_h(p_296_1_, p_296_2_, p_296_3_, p_296_4_);
      if(var6 < 0) {
         return p_296_5_;
      } else {
         if(var6 == 0) {
            ++this.field_460_a;
         }

         if(var6 >= 8) {
            var6 = 0;
         }

         return p_296_5_ >= 0 && var6 >= p_296_5_?p_296_5_:var6;
      }
   }

   private boolean func_298_m(World p_298_1_, int p_298_2_, int p_298_3_, int p_298_4_) {
      Material var5 = p_298_1_.func_599_f(p_298_2_, p_298_3_, p_298_4_);
      return var5 == this.field_356_bn?false:(var5 == Material.field_1331_g?false:!this.func_295_l(p_298_1_, p_298_2_, p_298_3_, p_298_4_));
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      if(p_235_1_.func_600_a(p_235_2_, p_235_3_, p_235_4_) == this.field_376_bc) {
         p_235_1_.func_22136_c(p_235_2_, p_235_3_, p_235_4_, this.field_376_bc, this.func_4025_d());
      }

   }
}
