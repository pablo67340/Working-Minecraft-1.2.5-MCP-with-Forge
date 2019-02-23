package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Facing;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityPiston;
import net.minecraft.src.World;

public class BlockPistonMoving extends BlockContainer {

   public BlockPistonMoving(int p_i508_1_) {
      super(p_i508_1_, Material.field_31067_B);
      this.func_222_c(-1.0F);
   }

   public TileEntity func_283_a_() {
      return null;
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {}

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      TileEntity var5 = p_214_1_.func_603_b(p_214_2_, p_214_3_, p_214_4_);
      if(var5 != null && var5 instanceof TileEntityPiston) {
         ((TileEntityPiston)var5).func_31011_l();
      } else {
         super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
      }

   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return false;
   }

   public boolean func_28030_e(World p_28030_1_, int p_28030_2_, int p_28030_3_, int p_28030_4_, int p_28030_5_) {
      return false;
   }

   public int func_210_f() {
      return -1;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      if(!p_250_1_.field_1026_y && p_250_1_.func_603_b(p_250_2_, p_250_3_, p_250_4_) == null) {
         p_250_1_.func_690_d(p_250_2_, p_250_3_, p_250_4_, 0);
         return true;
      } else {
         return false;
      }
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return 0;
   }

   public void func_216_a(World p_216_1_, int p_216_2_, int p_216_3_, int p_216_4_, int p_216_5_, float p_216_6_, int p_216_7_) {
      if(!p_216_1_.field_1026_y) {
         TileEntityPiston var8 = this.func_31034_c(p_216_1_, p_216_2_, p_216_3_, p_216_4_);
         if(var8 != null) {
            Block.field_345_n[var8.func_31016_a()].func_259_b_(p_216_1_, p_216_2_, p_216_3_, p_216_4_, var8.func_479_f(), 0);
         }
      }
   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      if(!p_226_1_.field_1026_y && p_226_1_.func_603_b(p_226_2_, p_226_3_, p_226_4_) == null) {
         ;
      }

   }

   public static TileEntity func_31036_a(int p_31036_0_, int p_31036_1_, int p_31036_2_, boolean p_31036_3_, boolean p_31036_4_) {
      return new TileEntityPiston(p_31036_0_, p_31036_1_, p_31036_2_, p_31036_3_, p_31036_4_);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      TileEntityPiston var5 = this.func_31034_c(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
      if(var5 == null) {
         return null;
      } else {
         float var6 = var5.func_31008_a(0.0F);
         if(var5.func_31015_b()) {
            var6 = 1.0F - var6;
         }

         return this.func_31035_a(p_221_1_, p_221_2_, p_221_3_, p_221_4_, var5.func_31016_a(), var6, var5.func_31009_d());
      }
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      TileEntityPiston var5 = this.func_31034_c(p_238_1_, p_238_2_, p_238_3_, p_238_4_);
      if(var5 != null) {
         Block var6 = Block.field_345_n[var5.func_31016_a()];
         if(var6 == null || var6 == this) {
            return;
         }

         var6.func_238_a(p_238_1_, p_238_2_, p_238_3_, p_238_4_);
         float var7 = var5.func_31008_a(0.0F);
         if(var5.func_31015_b()) {
            var7 = 1.0F - var7;
         }

         int var8 = var5.func_31009_d();
         this.field_370_bf = var6.field_370_bf - (double)((float)Facing.field_31056_b[var8] * var7);
         this.field_368_bg = var6.field_368_bg - (double)((float)Facing.field_31059_c[var8] * var7);
         this.field_366_bh = var6.field_366_bh - (double)((float)Facing.field_31058_d[var8] * var7);
         this.field_364_bi = var6.field_364_bi - (double)((float)Facing.field_31056_b[var8] * var7);
         this.field_362_bj = var6.field_362_bj - (double)((float)Facing.field_31059_c[var8] * var7);
         this.field_360_bk = var6.field_360_bk - (double)((float)Facing.field_31058_d[var8] * var7);
      }

   }

   public AxisAlignedBB func_31035_a(World p_31035_1_, int p_31035_2_, int p_31035_3_, int p_31035_4_, int p_31035_5_, float p_31035_6_, int p_31035_7_) {
      if(p_31035_5_ != 0 && p_31035_5_ != this.field_376_bc) {
         AxisAlignedBB var8 = Block.field_345_n[p_31035_5_].func_221_d(p_31035_1_, p_31035_2_, p_31035_3_, p_31035_4_);
         if(var8 == null) {
            return null;
         } else {
            if(Facing.field_31056_b[p_31035_7_] < 0) {
               var8.field_1698_a -= (double)((float)Facing.field_31056_b[p_31035_7_] * p_31035_6_);
            } else {
               var8.field_1703_d -= (double)((float)Facing.field_31056_b[p_31035_7_] * p_31035_6_);
            }

            if(Facing.field_31059_c[p_31035_7_] < 0) {
               var8.field_1697_b -= (double)((float)Facing.field_31059_c[p_31035_7_] * p_31035_6_);
            } else {
               var8.field_1702_e -= (double)((float)Facing.field_31059_c[p_31035_7_] * p_31035_6_);
            }

            if(Facing.field_31058_d[p_31035_7_] < 0) {
               var8.field_1704_c -= (double)((float)Facing.field_31058_d[p_31035_7_] * p_31035_6_);
            } else {
               var8.field_1701_f -= (double)((float)Facing.field_31058_d[p_31035_7_] * p_31035_6_);
            }

            return var8;
         }
      } else {
         return null;
      }
   }

   private TileEntityPiston func_31034_c(IBlockAccess p_31034_1_, int p_31034_2_, int p_31034_3_, int p_31034_4_) {
      TileEntity var5 = p_31034_1_.func_603_b(p_31034_2_, p_31034_3_, p_31034_4_);
      return var5 != null && var5 instanceof TileEntityPiston?(TileEntityPiston)var5:null;
   }
}
