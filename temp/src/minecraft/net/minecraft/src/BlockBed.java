package net.minecraft.src;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.Direction;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumStatus;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockBed extends BlockDirectional {

   public static final int[][] field_22033_a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};


   public BlockBed(int p_i518_1_) {
      super(p_i518_1_, 134, Material.field_4264_k);
      this.func_22027_j();
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(p_250_1_.field_1026_y) {
         return true;
      } else {
         int var6 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
         if(!func_22032_d(var6)) {
            int var7 = func_48216_a(var6);
            p_250_2_ += field_22033_a[var7][0];
            p_250_4_ += field_22033_a[var7][1];
            if(p_250_1_.func_600_a(p_250_2_, p_250_3_, p_250_4_) != this.field_376_bc) {
               return true;
            }

            var6 = p_250_1_.func_602_e(p_250_2_, p_250_3_, p_250_4_);
         }

         if(!p_250_1_.field_4209_q.func_6477_d()) {
            double var16 = (double)p_250_2_ + 0.5D;
            double var17 = (double)p_250_3_ + 0.5D;
            double var11 = (double)p_250_4_ + 0.5D;
            p_250_1_.func_690_d(p_250_2_, p_250_3_, p_250_4_, 0);
            int var13 = func_48216_a(var6);
            p_250_2_ += field_22033_a[var13][0];
            p_250_4_ += field_22033_a[var13][1];
            if(p_250_1_.func_600_a(p_250_2_, p_250_3_, p_250_4_) == this.field_376_bc) {
               p_250_1_.func_690_d(p_250_2_, p_250_3_, p_250_4_, 0);
               var16 = (var16 + (double)p_250_2_ + 0.5D) / 2.0D;
               var17 = (var17 + (double)p_250_3_ + 0.5D) / 2.0D;
               var11 = (var11 + (double)p_250_4_ + 0.5D) / 2.0D;
            }

            p_250_1_.func_12244_a((Entity)null, (double)((float)p_250_2_ + 0.5F), (double)((float)p_250_3_ + 0.5F), (double)((float)p_250_4_ + 0.5F), 5.0F, true);
            return true;
         } else {
            if(func_22029_f(var6)) {
               EntityPlayer var14 = null;
               Iterator var8 = p_250_1_.field_1040_k.iterator();

               while(var8.hasNext()) {
                  EntityPlayer var9 = (EntityPlayer)var8.next();
                  if(var9.func_22051_K()) {
                     ChunkCoordinates var10 = var9.field_21908_b;
                     if(var10.field_22395_a == p_250_2_ && var10.field_22394_b == p_250_3_ && var10.field_22396_c == p_250_4_) {
                        var14 = var9;
                     }
                  }
               }

               if(var14 != null) {
                  p_250_5_.func_22055_b("tile.bed.occupied");
                  return true;
               }

               func_22031_a(p_250_1_, p_250_2_, p_250_3_, p_250_4_, false);
            }

            EnumStatus var15 = p_250_5_.func_22053_b(p_250_2_, p_250_3_, p_250_4_);
            if(var15 == EnumStatus.OK) {
               func_22031_a(p_250_1_, p_250_2_, p_250_3_, p_250_4_, true);
               return true;
            } else {
               if(var15 == EnumStatus.NOT_POSSIBLE_NOW) {
                  p_250_5_.func_22055_b("tile.bed.noSleep");
               } else if(var15 == EnumStatus.NOT_SAFE) {
                  p_250_5_.func_22055_b("tile.bed.notSafe");
               }

               return true;
            }
         }
      }
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      if(p_232_1_ == 0) {
         return Block.field_334_y.field_378_bb;
      } else {
         int var3 = func_48216_a(p_232_2_);
         int var4 = Direction.field_22281_c[var3][p_232_1_];
         return func_22032_d(p_232_2_)?(var4 == 2?this.field_378_bb + 2 + 16:(var4 != 5 && var4 != 4?this.field_378_bb + 1:this.field_378_bb + 1 + 16)):(var4 == 3?this.field_378_bb - 1 + 16:(var4 != 5 && var4 != 4?this.field_378_bb:this.field_378_bb + 16));
      }
   }

   public int func_210_f() {
      return 14;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_217_b() {
      return false;
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      this.func_22027_j();
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      int var6 = p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_);
      int var7 = func_48216_a(var6);
      if(func_22032_d(var6)) {
         if(p_226_1_.func_600_a(p_226_2_ - field_22033_a[var7][0], p_226_3_, p_226_4_ - field_22033_a[var7][1]) != this.field_376_bc) {
            p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         }
      } else if(p_226_1_.func_600_a(p_226_2_ + field_22033_a[var7][0], p_226_3_, p_226_4_ + field_22033_a[var7][1]) != this.field_376_bc) {
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
         if(!p_226_1_.field_1026_y) {
            this.func_259_b_(p_226_1_, p_226_2_, p_226_3_, p_226_4_, var6, 0);
         }
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return func_22032_d(p_240_1_)?0:Item.field_22019_aY.field_291_aS;
   }

   private void func_22027_j() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public static boolean func_22032_d(int p_22032_0_) {
      return (p_22032_0_ & 8) != 0;
   }

   public static boolean func_22029_f(int p_22029_0_) {
      return (p_22029_0_ & 4) != 0;
   }

   public static void func_22031_a(World p_22031_0_, int p_22031_1_, int p_22031_2_, int p_22031_3_, boolean p_22031_4_) {
      int var5 = p_22031_0_.func_602_e(p_22031_1_, p_22031_2_, p_22031_3_);
      if(p_22031_4_) {
         var5 |= 4;
      } else {
         var5 &= -5;
      }

      p_22031_0_.func_691_b(p_22031_1_, p_22031_2_, p_22031_3_, var5);
   }

   public static ChunkCoordinates func_22028_g(World p_22028_0_, int p_22028_1_, int p_22028_2_, int p_22028_3_, int p_22028_4_) {
      int var5 = p_22028_0_.func_602_e(p_22028_1_, p_22028_2_, p_22028_3_);
      int var6 = BlockDirectional.func_48216_a(var5);

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = p_22028_1_ - field_22033_a[var6][0] * var7 - 1;
         int var9 = p_22028_3_ - field_22033_a[var6][1] * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               if(p_22028_0_.func_28100_h(var12, p_22028_2_ - 1, var13) && p_22028_0_.func_20084_d(var12, p_22028_2_, var13) && p_22028_0_.func_20084_d(var12, p_22028_2_ + 1, var13)) {
                  if(p_22028_4_ <= 0) {
                     return new ChunkCoordinates(var12, p_22028_2_, var13);
                  }

                  --p_22028_4_;
               }
            }
         }
      }

      return null;
   }

   public void func_216_a(World p_216_1_, int p_216_2_, int p_216_3_, int p_216_4_, int p_216_5_, float p_216_6_, int p_216_7_) {
      if(!func_22032_d(p_216_5_)) {
         super.func_216_a(p_216_1_, p_216_2_, p_216_3_, p_216_4_, p_216_5_, p_216_6_, 0);
      }

   }

   public int func_31029_h() {
      return 1;
   }

}
