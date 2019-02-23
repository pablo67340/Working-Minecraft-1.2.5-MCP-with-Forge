package net.minecraft.src;

import java.util.ArrayList;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.BlockPistonMoving;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Facing;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.World;

public class BlockPistonBase extends Block {

   private boolean field_31049_a;
   private static boolean field_31048_b;


   public BlockPistonBase(int p_i760_1_, int p_i760_2_, boolean p_i760_3_) {
      super(p_i760_1_, p_i760_2_, Material.field_31067_B);
      this.field_31049_a = p_i760_3_;
      this.func_4024_a(field_9251_h);
      this.func_222_c(0.5F);
   }

   public int func_31040_i() {
      return this.field_31049_a?106:107;
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      int var3 = func_31044_d(p_232_2_);
      return var3 > 5?this.field_378_bb:(p_232_1_ == var3?(!func_31046_e(p_232_2_) && this.field_370_bf <= 0.0D && this.field_368_bg <= 0.0D && this.field_366_bh <= 0.0D && this.field_364_bi >= 1.0D && this.field_362_bj >= 1.0D && this.field_360_bk >= 1.0D?this.field_378_bb:110):(p_232_1_ == Facing.field_31057_a[var3]?109:108));
   }

   public int func_210_f() {
      return 16;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      return false;
   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = func_31039_c(p_4026_1_, p_4026_2_, p_4026_3_, p_4026_4_, (EntityPlayer)p_4026_5_);
      p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, var6);
      if(!p_4026_1_.field_1026_y && !field_31048_b) {
         this.func_31043_h(p_4026_1_, p_4026_2_, p_4026_3_, p_4026_4_);
      }

   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y && !field_31048_b) {
         this.func_31043_h(p_226_1_, p_226_2_, p_226_3_, p_226_4_);
      }

   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      if(!p_235_1_.field_1026_y && p_235_1_.func_603_b(p_235_2_, p_235_3_, p_235_4_) == null && !field_31048_b) {
         this.func_31043_h(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
      }

   }

   private void func_31043_h(World p_31043_1_, int p_31043_2_, int p_31043_3_, int p_31043_4_) {
      int var5 = p_31043_1_.func_602_e(p_31043_2_, p_31043_3_, p_31043_4_);
      int var6 = func_31044_d(var5);
      boolean var7 = this.func_31041_f(p_31043_1_, p_31043_2_, p_31043_3_, p_31043_4_, var6);
      if(var5 != 7) {
         if(var7 && !func_31046_e(var5)) {
            if(func_31045_h(p_31043_1_, p_31043_2_, p_31043_3_, p_31043_4_, var6)) {
               p_31043_1_.func_635_c(p_31043_2_, p_31043_3_, p_31043_4_, var6 | 8);
               p_31043_1_.func_21116_c(p_31043_2_, p_31043_3_, p_31043_4_, 0, var6);
            }
         } else if(!var7 && func_31046_e(var5)) {
            p_31043_1_.func_635_c(p_31043_2_, p_31043_3_, p_31043_4_, var6);
            p_31043_1_.func_21116_c(p_31043_2_, p_31043_3_, p_31043_4_, 1, var6);
         }

      }
   }

   private boolean func_31041_f(World p_31041_1_, int p_31041_2_, int p_31041_3_, int p_31041_4_, int p_31041_5_) {
      return p_31041_5_ != 0 && p_31041_1_.func_706_k(p_31041_2_, p_31041_3_ - 1, p_31041_4_, 0)?true:(p_31041_5_ != 1 && p_31041_1_.func_706_k(p_31041_2_, p_31041_3_ + 1, p_31041_4_, 1)?true:(p_31041_5_ != 2 && p_31041_1_.func_706_k(p_31041_2_, p_31041_3_, p_31041_4_ - 1, 2)?true:(p_31041_5_ != 3 && p_31041_1_.func_706_k(p_31041_2_, p_31041_3_, p_31041_4_ + 1, 3)?true:(p_31041_5_ != 5 && p_31041_1_.func_706_k(p_31041_2_ + 1, p_31041_3_, p_31041_4_, 5)?true:(p_31041_5_ != 4 && p_31041_1_.func_706_k(p_31041_2_ - 1, p_31041_3_, p_31041_4_, 4)?true:(p_31041_1_.func_706_k(p_31041_2_, p_31041_3_, p_31041_4_, 0)?true:(p_31041_1_.func_706_k(p_31041_2_, p_31041_3_ + 2, p_31041_4_, 1)?true:(p_31041_1_.func_706_k(p_31041_2_, p_31041_3_ + 1, p_31041_4_ - 1, 2)?true:(p_31041_1_.func_706_k(p_31041_2_, p_31041_3_ + 1, p_31041_4_ + 1, 3)?true:(p_31041_1_.func_706_k(p_31041_2_ - 1, p_31041_3_ + 1, p_31041_4_, 4)?true:p_31041_1_.func_706_k(p_31041_2_ + 1, p_31041_3_ + 1, p_31041_4_, 5)))))))))));
   }

   public void func_21024_a(World p_21024_1_, int p_21024_2_, int p_21024_3_, int p_21024_4_, int p_21024_5_, int p_21024_6_) {
      field_31048_b = true;
      if(p_21024_5_ == 0) {
         if(this.func_31047_i(p_21024_1_, p_21024_2_, p_21024_3_, p_21024_4_, p_21024_6_)) {
            p_21024_1_.func_691_b(p_21024_2_, p_21024_3_, p_21024_4_, p_21024_6_ | 8);
            p_21024_1_.func_684_a((double)p_21024_2_ + 0.5D, (double)p_21024_3_ + 0.5D, (double)p_21024_4_ + 0.5D, "tile.piston.out", 0.5F, p_21024_1_.field_1037_n.nextFloat() * 0.25F + 0.6F);
         } else {
            p_21024_1_.func_635_c(p_21024_2_, p_21024_3_, p_21024_4_, p_21024_6_);
         }
      } else if(p_21024_5_ == 1) {
         TileEntity var8 = p_21024_1_.func_603_b(p_21024_2_ + Facing.field_31056_b[p_21024_6_], p_21024_3_ + Facing.field_31059_c[p_21024_6_], p_21024_4_ + Facing.field_31058_d[p_21024_6_]);
         if(var8 != null && var8 instanceof TileEntityPiston) {
            ((TileEntityPiston)var8).func_31011_l();
         }

         p_21024_1_.func_643_a(p_21024_2_, p_21024_3_, p_21024_4_, Block.field_9268_ac.field_376_bc, p_21024_6_);
         p_21024_1_.func_654_a(p_21024_2_, p_21024_3_, p_21024_4_, BlockPistonMoving.func_31036_a(this.field_376_bc, p_21024_6_, p_21024_6_, false, true));
         if(this.field_31049_a) {
            int var9 = p_21024_2_ + Facing.field_31056_b[p_21024_6_] * 2;
            int var10 = p_21024_3_ + Facing.field_31059_c[p_21024_6_] * 2;
            int var11 = p_21024_4_ + Facing.field_31058_d[p_21024_6_] * 2;
            int var12 = p_21024_1_.func_600_a(var9, var10, var11);
            int var13 = p_21024_1_.func_602_e(var9, var10, var11);
            boolean var14 = false;
            if(var12 == Block.field_9268_ac.field_376_bc) {
               TileEntity var15 = p_21024_1_.func_603_b(var9, var10, var11);
               if(var15 != null && var15 instanceof TileEntityPiston) {
                  TileEntityPiston var16 = (TileEntityPiston)var15;
                  if(var16.func_31009_d() == p_21024_6_ && var16.func_31015_b()) {
                     var16.func_31011_l();
                     var12 = var16.func_31016_a();
                     var13 = var16.func_479_f();
                     var14 = true;
                  }
               }
            }

            if(!var14 && var12 > 0 && func_31042_a(var12, p_21024_1_, var9, var10, var11, false) && (Block.field_345_n[var12].func_31029_h() == 0 || var12 == Block.field_9255_Z.field_376_bc || var12 == Block.field_9259_V.field_376_bc)) {
               p_21024_2_ += Facing.field_31056_b[p_21024_6_];
               p_21024_3_ += Facing.field_31059_c[p_21024_6_];
               p_21024_4_ += Facing.field_31058_d[p_21024_6_];
               p_21024_1_.func_643_a(p_21024_2_, p_21024_3_, p_21024_4_, Block.field_9268_ac.field_376_bc, var13);
               p_21024_1_.func_654_a(p_21024_2_, p_21024_3_, p_21024_4_, BlockPistonMoving.func_31036_a(var12, var13, p_21024_6_, false, false));
               field_31048_b = false;
               p_21024_1_.func_690_d(var9, var10, var11, 0);
               field_31048_b = true;
            } else if(!var14) {
               field_31048_b = false;
               p_21024_1_.func_690_d(p_21024_2_ + Facing.field_31056_b[p_21024_6_], p_21024_3_ + Facing.field_31059_c[p_21024_6_], p_21024_4_ + Facing.field_31058_d[p_21024_6_], 0);
               field_31048_b = true;
            }
         } else {
            field_31048_b = false;
            p_21024_1_.func_690_d(p_21024_2_ + Facing.field_31056_b[p_21024_6_], p_21024_3_ + Facing.field_31059_c[p_21024_6_], p_21024_4_ + Facing.field_31058_d[p_21024_6_], 0);
            field_31048_b = true;
         }

         p_21024_1_.func_684_a((double)p_21024_2_ + 0.5D, (double)p_21024_3_ + 0.5D, (double)p_21024_4_ + 0.5D, "tile.piston.in", 0.5F, p_21024_1_.field_1037_n.nextFloat() * 0.15F + 0.6F);
      }

      field_31048_b = false;
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_);
      if(func_31046_e(var5)) {
         switch(func_31044_d(var5)) {
         case 0:
            this.func_213_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 1:
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
            break;
         case 2:
            this.func_213_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
            break;
         case 3:
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
            break;
         case 4:
            this.func_213_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 5:
            this.func_213_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
         }
      } else {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public void func_237_e() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      this.func_238_a(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
      return super.func_221_d(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
   }

   public boolean func_242_c() {
      return false;
   }

   public static int func_31044_d(int p_31044_0_) {
      return p_31044_0_ & 7;
   }

   public static boolean func_31046_e(int p_31046_0_) {
      return (p_31046_0_ & 8) != 0;
   }

   private static int func_31039_c(World p_31039_0_, int p_31039_1_, int p_31039_2_, int p_31039_3_, EntityPlayer p_31039_4_) {
      if(MathHelper.func_1112_e((float)p_31039_4_.field_611_ak - (float)p_31039_1_) < 2.0F && MathHelper.func_1112_e((float)p_31039_4_.field_609_am - (float)p_31039_3_) < 2.0F) {
         double var5 = p_31039_4_.field_610_al + 1.82D - (double)p_31039_4_.field_9292_aO;
         if(var5 - (double)p_31039_2_ > 2.0D) {
            return 1;
         }

         if((double)p_31039_2_ - var5 > 0.0D) {
            return 0;
         }
      }

      int var7 = MathHelper.func_1108_b((double)(p_31039_4_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
      return var7 == 0?2:(var7 == 1?5:(var7 == 2?3:(var7 == 3?4:0)));
   }

   private static boolean func_31042_a(int p_31042_0_, World p_31042_1_, int p_31042_2_, int p_31042_3_, int p_31042_4_, boolean p_31042_5_) {
      if(p_31042_0_ == Block.field_405_aq.field_376_bc) {
         return false;
      } else {
         if(p_31042_0_ != Block.field_9255_Z.field_376_bc && p_31042_0_ != Block.field_9259_V.field_376_bc) {
            if(Block.field_345_n[p_31042_0_].func_31031_m() == -1.0F) {
               return false;
            }

            if(Block.field_345_n[p_31042_0_].func_31029_h() == 2) {
               return false;
            }

            if(!p_31042_5_ && Block.field_345_n[p_31042_0_].func_31029_h() == 1) {
               return false;
            }
         } else if(func_31046_e(p_31042_1_.func_602_e(p_31042_2_, p_31042_3_, p_31042_4_))) {
            return false;
         }

         return !(Block.field_345_n[p_31042_0_] instanceof BlockContainer);
      }
   }

   private static boolean func_31045_h(World p_31045_0_, int p_31045_1_, int p_31045_2_, int p_31045_3_, int p_31045_4_) {
      int var5 = p_31045_1_ + Facing.field_31056_b[p_31045_4_];
      int var6 = p_31045_2_ + Facing.field_31059_c[p_31045_4_];
      int var7 = p_31045_3_ + Facing.field_31058_d[p_31045_4_];
      int var8 = 0;

      while(true) {
         if(var8 < 13) {
            if(var6 <= 0 || var6 >= 255) {
               return false;
            }

            int var9 = p_31045_0_.func_600_a(var5, var6, var7);
            if(var9 != 0) {
               if(!func_31042_a(var9, p_31045_0_, var5, var6, var7, true)) {
                  return false;
               }

               if(Block.field_345_n[var9].func_31029_h() != 1) {
                  if(var8 == 12) {
                     return false;
                  }

                  var5 += Facing.field_31056_b[p_31045_4_];
                  var6 += Facing.field_31059_c[p_31045_4_];
                  var7 += Facing.field_31058_d[p_31045_4_];
                  ++var8;
                  continue;
               }
            }
         }

         return true;
      }
   }

   private boolean func_31047_i(World p_31047_1_, int p_31047_2_, int p_31047_3_, int p_31047_4_, int p_31047_5_) {
      int var6 = p_31047_2_ + Facing.field_31056_b[p_31047_5_];
      int var7 = p_31047_3_ + Facing.field_31059_c[p_31047_5_];
      int var8 = p_31047_4_ + Facing.field_31058_d[p_31047_5_];
      int var9 = 0;

      while(true) {
         int var10;
         if(var9 < 13) {
            if(var7 <= 0 || var7 >= 255) {
               return false;
            }

            var10 = p_31047_1_.func_600_a(var6, var7, var8);
            if(var10 != 0) {
               if(!func_31042_a(var10, p_31047_1_, var6, var7, var8, true)) {
                  return false;
               }

               if(Block.field_345_n[var10].func_31029_h() != 1) {
                  if(var9 == 12) {
                     return false;
                  }

                  var6 += Facing.field_31056_b[p_31047_5_];
                  var7 += Facing.field_31059_c[p_31047_5_];
                  var8 += Facing.field_31058_d[p_31047_5_];
                  ++var9;
                  continue;
               }

               Block.field_345_n[var10].func_259_b_(p_31047_1_, var6, var7, var8, p_31047_1_.func_602_e(var6, var7, var8), 0);
               p_31047_1_.func_690_d(var6, var7, var8, 0);
            }
         }

         while(var6 != p_31047_2_ || var7 != p_31047_3_ || var8 != p_31047_4_) {
            var9 = var6 - Facing.field_31056_b[p_31047_5_];
            var10 = var7 - Facing.field_31059_c[p_31047_5_];
            int var11 = var8 - Facing.field_31058_d[p_31047_5_];
            int var12 = p_31047_1_.func_600_a(var9, var10, var11);
            int var13 = p_31047_1_.func_602_e(var9, var10, var11);
            if(var12 == this.field_376_bc && var9 == p_31047_2_ && var10 == p_31047_3_ && var11 == p_31047_4_) {
               p_31047_1_.func_643_a(var6, var7, var8, Block.field_9268_ac.field_376_bc, p_31047_5_ | (this.field_31049_a?8:0));
               p_31047_1_.func_654_a(var6, var7, var8, BlockPistonMoving.func_31036_a(Block.field_9269_aa.field_376_bc, p_31047_5_ | (this.field_31049_a?8:0), p_31047_5_, true, false));
            } else {
               p_31047_1_.func_643_a(var6, var7, var8, Block.field_9268_ac.field_376_bc, var13);
               p_31047_1_.func_654_a(var6, var7, var8, BlockPistonMoving.func_31036_a(var12, var13, p_31047_5_, true, false));
            }

            var6 = var9;
            var7 = var10;
            var8 = var11;
         }

         return true;
      }
   }
}
