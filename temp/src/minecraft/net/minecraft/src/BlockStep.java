package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Facing;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockStep extends Block {

   public static final String[] field_22037_a = new String[]{"stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick"};
   private boolean field_20922_a;


   public BlockStep(int p_i219_1_, boolean p_i219_2_) {
      super(p_i219_1_, 6, Material.field_1334_d);
      this.field_20922_a = p_i219_2_;
      if(!p_i219_2_) {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         field_343_p[p_i219_1_] = true;
      }

      this.func_256_d(255);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      if(this.field_20922_a) {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         boolean var5 = (p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_) & 8) != 0;
         if(var5) {
            this.func_213_a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
         }
      }

   }

   public void func_237_e() {
      if(this.field_20922_a) {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      this.func_238_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      int var3 = p_232_2_ & 7;
      return var3 == 0?(p_232_1_ <= 1?6:5):(var3 == 1?(p_232_1_ == 0?208:(p_232_1_ == 1?176:192)):(var3 == 2?4:(var3 == 3?16:(var3 == 4?Block.field_409_am.field_378_bb:(var3 == 5?Block.field_35285_bn.field_378_bb:6)))));
   }

   public int func_218_a(int p_218_1_) {
      return this.func_232_a(p_218_1_, 0);
   }

   public boolean func_217_b() {
      return this.field_20922_a;
   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      if(p_258_5_ == 0 && !this.field_20922_a) {
         int var6 = p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_) & 7;
         p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6 | 8);
      }

   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return Block.field_410_al.field_376_bc;
   }

   public int func_229_a(Random p_229_1_) {
      return this.field_20922_a?2:1;
   }

   protected int func_21025_b(int p_21025_1_) {
      return p_21025_1_ & 7;
   }

   public boolean func_242_c() {
      return this.field_20922_a;
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      if(this.field_20922_a) {
         super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_);
      }

      if(p_260_5_ != 1 && p_260_5_ != 0 && !super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_)) {
         return false;
      } else {
         int var6 = p_260_2_ + Facing.field_31056_b[Facing.field_31057_a[p_260_5_]];
         int var7 = p_260_3_ + Facing.field_31059_c[Facing.field_31057_a[p_260_5_]];
         int var8 = p_260_4_ + Facing.field_31058_d[Facing.field_31057_a[p_260_5_]];
         boolean var9 = (p_260_1_.func_602_e(var6, var7, var8) & 8) != 0;
         return !var9?(p_260_5_ == 1?true:(p_260_5_ == 0 && super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_)?true:p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_) != this.field_376_bc || (p_260_1_.func_602_e(p_260_2_, p_260_3_, p_260_4_) & 8) != 0)):(p_260_5_ == 0?true:(p_260_5_ == 1 && super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_)?true:p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_) != this.field_376_bc || (p_260_1_.func_602_e(p_260_2_, p_260_3_, p_260_4_) & 8) == 0));
      }
   }

   protected ItemStack func_41049_c_(int p_41049_1_) {
      return new ItemStack(Block.field_410_al.field_376_bc, 1, p_41049_1_ & 7);
   }

}
