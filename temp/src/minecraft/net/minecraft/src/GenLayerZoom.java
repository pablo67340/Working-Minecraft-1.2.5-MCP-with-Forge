package net.minecraft.src;

import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class GenLayerZoom extends GenLayer {

   public GenLayerZoom(long p_i658_1_, GenLayer p_i658_3_) {
      super(p_i658_1_);
      super.field_35504_a = p_i658_3_;
   }

   public int[] func_35500_a(int p_35500_1_, int p_35500_2_, int p_35500_3_, int p_35500_4_) {
      int var5 = p_35500_1_ >> 1;
      int var6 = p_35500_2_ >> 1;
      int var7 = (p_35500_3_ >> 1) + 3;
      int var8 = (p_35500_4_ >> 1) + 3;
      int[] var9 = this.field_35504_a.func_35500_a(var5, var6, var7, var8);
      int[] var10 = IntCache.func_35267_a(var7 * 2 * var8 * 2);
      int var11 = var7 << 1;

      int var13;
      for(int var12 = 0; var12 < var8 - 1; ++var12) {
         var13 = var12 << 1;
         int var14 = var13 * var11;
         int var15 = var9[0 + (var12 + 0) * var7];
         int var16 = var9[0 + (var12 + 1) * var7];

         for(int var17 = 0; var17 < var7 - 1; ++var17) {
            this.func_35499_a((long)(var17 + var5 << 1), (long)(var12 + var6 << 1));
            int var18 = var9[var17 + 1 + (var12 + 0) * var7];
            int var19 = var9[var17 + 1 + (var12 + 1) * var7];
            var10[var14] = var15;
            var10[var14++ + var11] = this.func_35516_a(var15, var16);
            var10[var14] = this.func_35516_a(var15, var18);
            var10[var14++ + var11] = this.func_35514_b(var15, var18, var16, var19);
            var15 = var18;
            var16 = var19;
         }
      }

      int[] var20 = IntCache.func_35267_a(p_35500_3_ * p_35500_4_);

      for(var13 = 0; var13 < p_35500_4_; ++var13) {
         System.arraycopy(var10, (var13 + (p_35500_2_ & 1)) * (var7 << 1) + (p_35500_1_ & 1), var20, var13 * p_35500_3_, p_35500_3_);
      }

      return var20;
   }

   protected int func_35516_a(int p_35516_1_, int p_35516_2_) {
      return this.func_35498_a(2) == 0?p_35516_1_:p_35516_2_;
   }

   protected int func_35514_b(int p_35514_1_, int p_35514_2_, int p_35514_3_, int p_35514_4_) {
      if(p_35514_2_ == p_35514_3_ && p_35514_3_ == p_35514_4_) {
         return p_35514_2_;
      } else if(p_35514_1_ == p_35514_2_ && p_35514_1_ == p_35514_3_) {
         return p_35514_1_;
      } else if(p_35514_1_ == p_35514_2_ && p_35514_1_ == p_35514_4_) {
         return p_35514_1_;
      } else if(p_35514_1_ == p_35514_3_ && p_35514_1_ == p_35514_4_) {
         return p_35514_1_;
      } else if(p_35514_1_ == p_35514_2_ && p_35514_3_ != p_35514_4_) {
         return p_35514_1_;
      } else if(p_35514_1_ == p_35514_3_ && p_35514_2_ != p_35514_4_) {
         return p_35514_1_;
      } else if(p_35514_1_ == p_35514_4_ && p_35514_2_ != p_35514_3_) {
         return p_35514_1_;
      } else if(p_35514_2_ == p_35514_1_ && p_35514_3_ != p_35514_4_) {
         return p_35514_2_;
      } else if(p_35514_2_ == p_35514_3_ && p_35514_1_ != p_35514_4_) {
         return p_35514_2_;
      } else if(p_35514_2_ == p_35514_4_ && p_35514_1_ != p_35514_3_) {
         return p_35514_2_;
      } else if(p_35514_3_ == p_35514_1_ && p_35514_2_ != p_35514_4_) {
         return p_35514_3_;
      } else if(p_35514_3_ == p_35514_2_ && p_35514_1_ != p_35514_4_) {
         return p_35514_3_;
      } else if(p_35514_3_ == p_35514_4_ && p_35514_1_ != p_35514_2_) {
         return p_35514_3_;
      } else if(p_35514_4_ == p_35514_1_ && p_35514_2_ != p_35514_3_) {
         return p_35514_3_;
      } else if(p_35514_4_ == p_35514_2_ && p_35514_1_ != p_35514_3_) {
         return p_35514_3_;
      } else if(p_35514_4_ == p_35514_3_ && p_35514_1_ != p_35514_2_) {
         return p_35514_3_;
      } else {
         int var5 = this.func_35498_a(4);
         return var5 == 0?p_35514_1_:(var5 == 1?p_35514_2_:(var5 == 2?p_35514_3_:p_35514_4_));
      }
   }

   public static GenLayer func_35515_a(long p_35515_0_, GenLayer p_35515_2_, int p_35515_3_) {
      Object var4 = p_35515_2_;

      for(int var5 = 0; var5 < p_35515_3_; ++var5) {
         var4 = new GenLayerZoom(p_35515_0_ + (long)var5, (GenLayer)var4);
      }

      return (GenLayer)var4;
   }
}
