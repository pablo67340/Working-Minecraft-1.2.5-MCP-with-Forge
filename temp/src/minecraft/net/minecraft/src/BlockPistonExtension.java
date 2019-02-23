package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockPistonBase;
import net.minecraft.src.Facing;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPistonExtension extends Block {

   private int field_31053_a = -1;


   public BlockPistonExtension(int p_i598_1_, int p_i598_2_) {
      super(p_i598_1_, p_i598_2_, Material.field_31067_B);
      this.func_4024_a(field_9251_h);
      this.func_222_c(0.5F);
   }

   public void func_31052_a_(int p_31052_1_) {
      this.field_31053_a = p_31052_1_;
   }

   public void func_31051_a() {
      this.field_31053_a = -1;
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      super.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
      int var5 = p_214_1_.func_602_e(p_214_2_, p_214_3_, p_214_4_);
      int var6 = Facing.field_31057_a[func_31050_c(var5)];
      p_214_2_ += Facing.field_31056_b[var6];
      p_214_3_ += Facing.field_31059_c[var6];
      p_214_4_ += Facing.field_31058_d[var6];
      int var7 = p_214_1_.func_600_a(p_214_2_, p_214_3_, p_214_4_);
      if(var7 == Block.field_9255_Z.field_376_bc || var7 == Block.field_9259_V.field_376_bc) {
         var5 = p_214_1_.func_602_e(p_214_2_, p_214_3_, p_214_4_);
         if(BlockPistonBase.func_31046_e(var5)) {
            Block.field_345_n[var7].func_259_b_(p_214_1_, p_214_2_, p_214_3_, p_214_4_, var5, 0);
            p_214_1_.func_690_d(p_214_2_, p_214_3_, p_214_4_, 0);
         }
      }

   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      int var3 = func_31050_c(p_232_2_);
      return p_232_1_ == var3?(this.field_31053_a >= 0?this.field_31053_a:((p_232_2_ & 8) != 0?this.field_378_bb - 1:this.field_378_bb)):(p_232_1_ == Facing.field_31057_a[var3]?107:108);
   }

   public int func_210_f() {
      return 17;
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return false;
   }

   public boolean func_28030_e(World p_28030_1_, int p_28030_2_, int p_28030_3_, int p_28030_4_, int p_28030_5_) {
      return false;
   }

   public int func_229_a(Random p_229_1_) {
      return 0;
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      int var7 = p_230_1_.func_602_e(p_230_2_, p_230_3_, p_230_4_);
      switch(func_31050_c(var7)) {
      case 0:
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         this.func_213_a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         break;
      case 1:
         this.func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         this.func_213_a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         break;
      case 2:
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         this.func_213_a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         break;
      case 3:
         this.func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         this.func_213_a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         break;
      case 4:
         this.func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         this.func_213_a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         break;
      case 5:
         this.func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         this.func_213_a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      }

      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      int var5 = p_238_1_.func_602_e(p_238_2_, p_238_3_, p_238_4_);
      switch(func_31050_c(var5)) {
      case 0:
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
         break;
      case 1:
         this.func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
         break;
      case 2:
         this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
         break;
      case 3:
         this.func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
         break;
      case 4:
         this.func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
         break;
      case 5:
         this.func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public void func_226_a(World p_226_1_, int p_226_2_, int p_226_3_, int p_226_4_, int p_226_5_) {
      int var6 = func_31050_c(p_226_1_.func_602_e(p_226_2_, p_226_3_, p_226_4_));
      int var7 = p_226_1_.func_600_a(p_226_2_ - Facing.field_31056_b[var6], p_226_3_ - Facing.field_31059_c[var6], p_226_4_ - Facing.field_31058_d[var6]);
      if(var7 != Block.field_9255_Z.field_376_bc && var7 != Block.field_9259_V.field_376_bc) {
         p_226_1_.func_690_d(p_226_2_, p_226_3_, p_226_4_, 0);
      } else {
         Block.field_345_n[var7].func_226_a(p_226_1_, p_226_2_ - Facing.field_31056_b[var6], p_226_3_ - Facing.field_31059_c[var6], p_226_4_ - Facing.field_31058_d[var6], p_226_5_);
      }

   }

   public static int func_31050_c(int p_31050_0_) {
      return p_31050_0_ & 7;
   }
}
