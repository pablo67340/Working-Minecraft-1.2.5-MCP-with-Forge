package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockPane extends Block {

   private int field_35300_a;
   private final boolean field_40213_b;


   protected BlockPane(int p_i185_1_, int p_i185_2_, int p_i185_3_, Material p_i185_4_, boolean p_i185_5_) {
      super(p_i185_1_, p_i185_2_, p_i185_4_);
      this.field_35300_a = p_i185_3_;
      this.field_40213_b = p_i185_5_;
   }

   public int func_240_a(int p_240_1_, Random p_240_2_, int p_240_3_) {
      return !this.field_40213_b?0:super.func_240_a(p_240_1_, p_240_2_, p_240_3_);
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 18;
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      int var6 = p_260_1_.func_600_a(p_260_2_, p_260_3_, p_260_4_);
      return var6 == this.field_376_bc?false:super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_);
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      boolean var7 = this.func_35298_d(p_230_1_.func_600_a(p_230_2_, p_230_3_, p_230_4_ - 1));
      boolean var8 = this.func_35298_d(p_230_1_.func_600_a(p_230_2_, p_230_3_, p_230_4_ + 1));
      boolean var9 = this.func_35298_d(p_230_1_.func_600_a(p_230_2_ - 1, p_230_3_, p_230_4_));
      boolean var10 = this.func_35298_d(p_230_1_.func_600_a(p_230_2_ + 1, p_230_3_, p_230_4_));
      if((!var9 || !var10) && (var9 || var10 || var7 || var8)) {
         if(var9 && !var10) {
            this.func_213_a(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         } else if(!var9 && var10) {
            this.func_213_a(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         }
      } else {
         this.func_213_a(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      }

      if((!var7 || !var8) && (var9 || var10 || var7 || var8)) {
         if(var7 && !var8) {
            this.func_213_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         } else if(!var7 && var8) {
            this.func_213_a(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
         }
      } else {
         this.func_213_a(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      }

   }

   public void func_237_e() {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      float var5 = 0.4375F;
      float var6 = 0.5625F;
      float var7 = 0.4375F;
      float var8 = 0.5625F;
      boolean var9 = this.func_35298_d(p_238_1_.func_600_a(p_238_2_, p_238_3_, p_238_4_ - 1));
      boolean var10 = this.func_35298_d(p_238_1_.func_600_a(p_238_2_, p_238_3_, p_238_4_ + 1));
      boolean var11 = this.func_35298_d(p_238_1_.func_600_a(p_238_2_ - 1, p_238_3_, p_238_4_));
      boolean var12 = this.func_35298_d(p_238_1_.func_600_a(p_238_2_ + 1, p_238_3_, p_238_4_));
      if((!var11 || !var12) && (var11 || var12 || var9 || var10)) {
         if(var11 && !var12) {
            var5 = 0.0F;
         } else if(!var11 && var12) {
            var6 = 1.0F;
         }
      } else {
         var5 = 0.0F;
         var6 = 1.0F;
      }

      if((!var9 || !var10) && (var11 || var12 || var9 || var10)) {
         if(var9 && !var10) {
            var7 = 0.0F;
         } else if(!var9 && var10) {
            var8 = 1.0F;
         }
      } else {
         var7 = 0.0F;
         var8 = 1.0F;
      }

      this.func_213_a(var5, 0.0F, var7, var6, 1.0F, var8);
   }

   public int func_35299_s() {
      return this.field_35300_a;
   }

   public final boolean func_35298_d(int p_35298_1_) {
      return Block.field_343_p[p_35298_1_] || p_35298_1_ == this.field_376_bc || p_35298_1_ == Block.field_382_N.field_376_bc;
   }
}
