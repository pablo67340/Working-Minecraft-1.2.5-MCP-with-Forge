package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockFarmland extends Block {

   protected BlockFarmland(int p_i165_1_) {
      super(p_i165_1_, Material.field_1336_b);
      this.field_378_bb = 87;
      this.func_253_b(true);
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.func_256_d(255);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return AxisAlignedBB.func_1161_b((double)(p_221_2_ + 0), (double)(p_221_3_ + 0), (double)(p_221_4_ + 0), (double)(p_221_2_ + 1), (double)(p_221_3_ + 1), (double)(p_221_4_ + 1));
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return p_232_1_ == 1 && p_232_2_ > 0?this.field_378_bb - 1:(p_232_1_ == 1?this.field_378_bb:2);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      if(!this.func_274_i(p_208_1_, p_208_2_, p_208_3_, p_208_4_) && !p_208_1_.func_27167_r(p_208_2_, p_208_3_ + 1, p_208_4_)) {
         int var6 = p_208_1_.func_602_e(p_208_2_, p_208_3_, p_208_4_);
         if(var6 > 0) {
            p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, var6 - 1);
         } else if(!this.func_275_h(p_208_1_, p_208_2_, p_208_3_, p_208_4_)) {
            p_208_1_.func_690_d(p_208_2_, p_208_3_, p_208_4_, Block.field_336_w.field_376_bc);
         }
      } else {
         p_208_1_.func_691_b(p_208_2_, p_208_3_, p_208_4_, 7);
      }

   }

   public void func_43001_a(World p_43001_1_, int p_43001_2_, int p_43001_3_, int p_43001_4_, Entity p_43001_5_, float p_43001_6_) {
      if(p_43001_1_.field_1037_n.nextFloat() < p_43001_6_ - 0.5F) {
         p_43001_1_.func_690_d(p_43001_2_, p_43001_3_, p_43001_4_, Block.field_336_w.field_376_bc);
      }

   }

   private boolean func_275_h(World p_275_1_, int p_275_2_, int p_275_3_, int p_275_4_) {
      byte var5 = 0;

      for(int var6 = p_275_2_ - var5; var6 <= p_275_2_ + var5; ++var6) {
         for(int var7 = p_275_4_ - var5; var7 <= p_275_4_ + var5; ++var7) {
            int var8 = p_275_1_.func_600_a(var6, p_275_3_ + 1, var7);
            if(var8 == Block.field_447_aA.field_376_bc || var8 == Block.field_35283_bu.field_376_bc || var8 == Block.field_35284_bt.field_376_bc) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean func_274_i(World p_274_1_, int p_274_2_, int p_274_3_, int p_274_4_) {
      for(int var5 = p_274_2_ - 4; var5 <= p_274_2_ + 4; ++var5) {
         for(int var6 = p_274_3_; var6 <= p_274_3_ + 1; ++var6) {
            for(int var7 = p_274_4_ - 4; var7 <= p_274_4_ + 4; ++var7) {
               if(p_274_1_.func_599_f(var5, var6, var7) == Material.field_1332_f) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      super.func_226_a(p_226_1_, p_226_2_, p_226_3_, p_226_4_, p_226_5_);
      Material var6 = p_226_1_.func_599_f(p_226_2_, p_226_3_ + 1, p_226_4_);
      if(var6.func_878_a()) {
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, Block.field_336_w.field_376_bc);
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_336_w.func_240_a(0, p_240_2_, p_240_3_);
   }
}
