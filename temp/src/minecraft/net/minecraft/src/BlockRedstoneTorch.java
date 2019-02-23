package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockTorch;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RedstoneUpdateInfo;
import net.minecraft.src.World;

public class BlockRedstoneTorch extends BlockTorch {

   private boolean field_451_a = false;
   private static List field_450_b = new ArrayList();


   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1?Block.field_394_aw.func_232_a(p_232_1_, p_232_2_):super.func_232_a(p_232_1_, p_232_2_);
   }

   private boolean func_273_a(World p_273_1_, int p_273_2_, int p_273_3_, int p_273_4_, boolean p_273_5_) {
      if(p_273_5_) {
         field_450_b.add(new RedstoneUpdateInfo(p_273_2_, p_273_3_, p_273_4_, p_273_1_.func_22139_r()));
      }

      int var6 = 0;

      for(int var7 = 0; var7 < field_450_b.size(); ++var7) {
         RedstoneUpdateInfo var8 = (RedstoneUpdateInfo)field_450_b.get(var7);
         if(var8.field_1009_a == p_273_2_ && var8.field_1008_b == p_273_3_ && var8.field_1011_c == p_273_4_) {
            ++var6;
            if(var6 >= 8) {
               return true;
            }
         }
      }

      return false;
   }

   protected BlockRedstoneTorch(int p_i649_1_, int p_i649_2_, boolean p_i649_3_) {
      super(p_i649_1_, p_i649_2_);
      this.field_451_a = p_i649_3_;
      this.func_253_b(true);
   }

   public int func_4025_d() {
      return 2;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      if(p_235_1_.func_602_e(p_235_2_, p_235_3_, p_235_4_) == 0) {
         super.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      }

      if(this.field_451_a) {
         p_235_1_.func_611_g(p_235_2_, p_235_3_ - 1, p_235_4_, this.field_376_bc);
         p_235_1_.func_611_g(p_235_2_, p_235_3_ + 1, p_235_4_, this.field_376_bc);
         p_235_1_.func_611_g(p_235_2_ - 1, p_235_3_, p_235_4_, this.field_376_bc);
         p_235_1_.func_611_g(p_235_2_ + 1, p_235_3_, p_235_4_, this.field_376_bc);
         p_235_1_.func_611_g(p_235_2_, p_235_3_, p_235_4_ - 1, this.field_376_bc);
         p_235_1_.func_611_g(p_235_2_, p_235_3_, p_235_4_ + 1, this.field_376_bc);
      }

   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      if(this.field_451_a) {
         p_214_1_.func_611_g(p_214_2_, p_214_3_ - 1, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_ + 1, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_ - 1, p_214_3_, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_ + 1, p_214_3_, p_214_4_, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_ - 1, this.field_376_bc);
         p_214_1_.func_611_g(p_214_2_, p_214_3_, p_214_4_ + 1, this.field_376_bc);
      }

   }

   public boolean func_231_b(IBlockAccess p_231_1_, int p_231_2_, int p_231_3_, int p_231_4_, int p_231_5_) {
      if(!this.field_451_a) {
         return false;
      } else {
         int var6 = p_231_1_.func_602_e(p_231_2_, p_231_3_, p_231_4_);
         return var6 == 5 && p_231_5_ == 1?false:(var6 == 3 && p_231_5_ == 3?false:(var6 == 4 && p_231_5_ == 2?false:(var6 == 1 && p_231_5_ == 5?false:var6 != 2 || p_231_5_ != 4)));
      }
   }

   private boolean func_30002_h(World p_30002_1_, int p_30002_2_, int p_30002_3_, int p_30002_4_) {
      int var5 = p_30002_1_.func_602_e(p_30002_2_, p_30002_3_, p_30002_4_);
      return var5 == 5 && p_30002_1_.func_706_k(p_30002_2_, p_30002_3_ - 1, p_30002_4_, 0)?true:(var5 == 3 && p_30002_1_.func_706_k(p_30002_2_, p_30002_3_, p_30002_4_ - 1, 2)?true:(var5 == 4 && p_30002_1_.func_706_k(p_30002_2_, p_30002_3_, p_30002_4_ + 1, 3)?true:(var5 == 1 && p_30002_1_.func_706_k(p_30002_2_ - 1, p_30002_3_, p_30002_4_, 4)?true:var5 == 2 && p_30002_1_.func_706_k(p_30002_2_ + 1, p_30002_3_, p_30002_4_, 5))));
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      boolean var6 = this.func_30002_h(p_208_1_, p_208_2_, p_208_3_, p_208_4_);

      while(field_450_b.size() > 0 && p_208_1_.func_22139_r() - ((RedstoneUpdateInfo)field_450_b.get(0)).field_1010_d > 60L) {
         field_450_b.remove(0);
      }

      if(this.field_451_a) {
         if(var6) {
            p_208_1_.func_688_b(p_208_2_, p_208_3_, p_208_4_, Block.field_431_aQ.field_376_bc, p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_));
            if(this.func_273_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, true)) {
               p_208_1_.func_684_a((double)((float)p_208_2_ + 0.5F), (double)((float)p_208_3_ + 0.5F), (double)((float)p_208_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_208_1_.field_1037_n.nextFloat() - p_208_1_.field_1037_n.nextFloat()) * 0.8F);

               for(int var7 = 0; var7 < 5; ++var7) {
                  double var8 = (double)p_208_2_ + p_208_5_.nextDouble() * 0.6D + 0.2D;
                  double var10 = (double)p_208_3_ + p_208_5_.nextDouble() * 0.6D + 0.2D;
                  double var12 = (double)p_208_4_ + p_208_5_.nextDouble() * 0.6D + 0.2D;
                  p_208_1_.func_694_a("smoke", var8, var10, var12, 0.0D, 0.0D, 0.0D);
               }
            }
         }
      } else if(!var6 && !this.func_273_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, false)) {
         p_208_1_.func_688_b(p_208_2_, p_208_3_, p_208_4_, Block.field_430_aR.field_376_bc, p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_));
      }

   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
      p_226_1_.func_22136_c(p_226_2_, p_226_3_, p_226_4_, this.field_376_bc, this.func_4025_d());
   }

   public boolean func_228_c(World p_228_1_, int p_228_2_, int p_228_3_, int p_228_4_, int p_228_5_) {
      return p_228_5_ == 0?this.func_231_b(p_228_1_, p_228_2_, p_228_3_, p_228_4_, p_228_5_):false;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_430_aR.field_376_bc;
   }

   public boolean func_209_d() {
      return true;
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      if(this.field_451_a) {
         int var6 = p_247_1_.func_602_e(p_247_2_, p_247_3_, p_247_4_);
         double var7 = (double)((float)p_247_2_ + 0.5F) + (double)(p_247_5_.nextFloat() - 0.5F) * 0.2D;
         double var9 = (double)((float)p_247_3_ + 0.7F) + (double)(p_247_5_.nextFloat() - 0.5F) * 0.2D;
         double var11 = (double)((float)p_247_4_ + 0.5F) + (double)(p_247_5_.nextFloat() - 0.5F) * 0.2D;
         double var13 = 0.2199999988079071D;
         double var15 = 0.27000001072883606D;
         if(var6 == 1) {
            p_247_1_.func_694_a("reddust", var7 - var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 2) {
            p_247_1_.func_694_a("reddust", var7 + var15, var9 + var13, var11, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 3) {
            p_247_1_.func_694_a("reddust", var7, var9 + var13, var11 - var15, 0.0D, 0.0D, 0.0D);
         } else if(var6 == 4) {
            p_247_1_.func_694_a("reddust", var7, var9 + var13, var11 + var15, 0.0D, 0.0D, 0.0D);
         } else {
            p_247_1_.func_694_a("reddust", var7, var9, var11, 0.0D, 0.0D, 0.0D);
         }

      }
   }

}
