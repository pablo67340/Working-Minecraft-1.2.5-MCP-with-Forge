package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockDragonEgg extends Block {

   public BlockDragonEgg(int p_i281_1_, int p_i281_2_) {
      super(p_i281_1_, p_i281_2_, Material.field_41056_z);
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      p_235_1_.func_22136_c(p_235_2_, p_235_3_, p_235_4_, this.field_376_bc, this.func_4025_d());
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      p_226_1_.func_22136_c(p_226_2_, p_226_3_, p_226_4_, this.field_376_bc, this.func_4025_d());
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      this.func_41055_g(p_208_1_, p_208_2_, p_208_3_, p_208_4_);
   }

   private void func_41055_g(World p_41055_1_, int p_41055_2_, int p_41055_3_, int p_41055_4_) {
      if(BlockSand.func_316_a_(p_41055_1_, p_41055_2_, p_41055_3_ - 1, p_41055_4_) && p_41055_3_ >= 0) {
         byte var8 = 32;
         if(!BlockSand.field_466_a && p_41055_1_.func_640_a(p_41055_2_ - var8, p_41055_3_ - var8, p_41055_4_ - var8, p_41055_2_ + var8, p_41055_3_ + var8, p_41055_4_ + var8)) {
            EntityFallingSand var9 = new EntityFallingSand(p_41055_1_, (double)((float)p_41055_2_ + 0.5F), (double)((float)p_41055_3_ + 0.5F), (double)((float)p_41055_4_ + 0.5F), this.field_376_bc);
            p_41055_1_.func_674_a(var9);
         } else {
            p_41055_1_.func_690_d(p_41055_2_, p_41055_3_, p_41055_4_, 0);

            while(BlockSand.func_316_a_(p_41055_1_, p_41055_2_, p_41055_3_ - 1, p_41055_4_) && p_41055_3_ > 0) {
               --p_41055_3_;
            }

            if(p_41055_3_ > 0) {
               p_41055_1_.func_690_d(p_41055_2_, p_41055_3_, p_41055_4_, this.field_376_bc);
            }
         }
      }

   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      this.func_41054_h(p_250_1_, p_250_2_, p_250_3_, p_250_4_);
      return true;
   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.func_41054_h(p_233_1_, p_233_2_, p_233_3_, p_233_4_);
   }

   private void func_41054_h(World p_41054_1_, int p_41054_2_, int p_41054_3_, int p_41054_4_) {
      if(p_41054_1_.func_600_a(p_41054_2_, p_41054_3_, p_41054_4_) == this.field_376_bc) {
         if(!p_41054_1_.field_1026_y) {
            for(int var5 = 0; var5 < 1000; ++var5) {
               int var6 = p_41054_2_ + p_41054_1_.field_1037_n.nextInt(16) - p_41054_1_.field_1037_n.nextInt(16);
               int var7 = p_41054_3_ + p_41054_1_.field_1037_n.nextInt(8) - p_41054_1_.field_1037_n.nextInt(8);
               int var8 = p_41054_4_ + p_41054_1_.field_1037_n.nextInt(16) - p_41054_1_.field_1037_n.nextInt(16);
               if(p_41054_1_.func_600_a(var6, var7, var8) == 0) {
                  p_41054_1_.func_688_b(var6, var7, var8, this.field_376_bc, p_41054_1_.func_602_e(p_41054_2_, p_41054_3_, p_41054_4_));
                  p_41054_1_.func_690_d(p_41054_2_, p_41054_3_, p_41054_4_, 0);
                  short var9 = 128;

                  for(int var10 = 0; var10 < var9; ++var10) {
                     double var11 = p_41054_1_.field_1037_n.nextDouble();
                     float var13 = (p_41054_1_.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                     float var14 = (p_41054_1_.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                     float var15 = (p_41054_1_.field_1037_n.nextFloat() - 0.5F) * 0.2F;
                     double var16 = (double)var6 + (double)(p_41054_2_ - var6) * var11 + (p_41054_1_.field_1037_n.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     double var18 = (double)var7 + (double)(p_41054_3_ - var7) * var11 + p_41054_1_.field_1037_n.nextDouble() * 1.0D - 0.5D;
                     double var20 = (double)var8 + (double)(p_41054_4_ - var8) * var11 + (p_41054_1_.field_1037_n.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     p_41054_1_.func_694_a("portal", var16, var18, var20, (double)var13, (double)var14, (double)var15);
                  }

                  return;
               }
            }

         }
      }
   }

   public int func_4025_d() {
      return 3;
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return super.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 27;
   }
}
