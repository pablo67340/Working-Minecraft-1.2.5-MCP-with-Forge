package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class BlockStairs extends Block {

   private Block field_452_a;


   protected BlockStairs(int p_i482_1_, Block p_i482_2_) {
      super(p_i482_1_, p_i482_2_.field_378_bb, p_i482_2_.field_356_bn);
      this.field_452_a = p_i482_2_;
      this.func_222_c(p_i482_2_.field_374_bd);
      this.func_219_b(p_i482_2_.field_372_be / 3.0F);
      this.func_4024_a(p_i482_2_.field_358_bl);
      this.func_256_d(255);
   }

   public void func_238_a(IBlockAccess p_238_1_, int p_238_2_, int p_238_3_, int p_238_4_) {
      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public AxisAlignedBB func_221_d(World p_221_1_, int p_221_2_, int p_221_3_, int p_221_4_) {
      return super.func_221_d(p_221_1_, p_221_2_, p_221_3_, p_221_4_);
   }

   public boolean func_217_b() {
      return false;
   }

   public boolean func_242_c() {
      return false;
   }

   public int func_210_f() {
      return 10;
   }

   public boolean func_260_c(IBlockAccess p_260_1_, int p_260_2_, int p_260_3_, int p_260_4_, int p_260_5_) {
      return super.func_260_c(p_260_1_, p_260_2_, p_260_3_, p_260_4_, p_260_5_);
   }

   public void func_230_a(World p_230_1_, int p_230_2_, int p_230_3_, int p_230_4_, AxisAlignedBB p_230_5_, ArrayList p_230_6_) {
      int var7 = p_230_1_.func_602_e(p_230_2_, p_230_3_, p_230_4_);
      int var8 = var7 & 3;
      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      if((var7 & 4) != 0) {
         var9 = 0.5F;
         var10 = 1.0F;
         var11 = 0.0F;
         var12 = 0.5F;
      }

      this.func_213_a(0.0F, var9, 0.0F, 1.0F, var10, 1.0F);
      super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      if(var8 == 0) {
         this.func_213_a(0.5F, var11, 0.0F, 1.0F, var12, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      } else if(var8 == 1) {
         this.func_213_a(0.0F, var11, 0.0F, 0.5F, var12, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      } else if(var8 == 2) {
         this.func_213_a(0.0F, var11, 0.5F, 1.0F, var12, 1.0F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      } else if(var8 == 3) {
         this.func_213_a(0.0F, var11, 0.0F, 1.0F, var12, 0.5F);
         super.func_230_a(p_230_1_, p_230_2_, p_230_3_, p_230_4_, p_230_5_, p_230_6_);
      }

      this.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void func_247_b(World p_247_1_, int p_247_2_, int p_247_3_, int p_247_4_, Random p_247_5_) {
      this.field_452_a.func_247_b(p_247_1_, p_247_2_, p_247_3_, p_247_4_, p_247_5_);
   }

   public void func_233_b(World p_233_1_, int p_233_2_, int p_233_3_, int p_233_4_, EntityPlayer p_233_5_) {
      this.field_452_a.func_233_b(p_233_1_, p_233_2_, p_233_3_, p_233_4_, p_233_5_);
   }

   public void func_252_b(World p_252_1_, int p_252_2_, int p_252_3_, int p_252_4_, int p_252_5_) {
      this.field_452_a.func_252_b(p_252_1_, p_252_2_, p_252_3_, p_252_4_, p_252_5_);
   }

   public int func_35275_c(IBlockAccess p_35275_1_, int p_35275_2_, int p_35275_3_, int p_35275_4_) {
      return this.field_452_a.func_35275_c(p_35275_1_, p_35275_2_, p_35275_3_, p_35275_4_);
   }

   public float func_241_c(IBlockAccess p_241_1_, int p_241_2_, int p_241_3_, int p_241_4_) {
      return this.field_452_a.func_241_c(p_241_1_, p_241_2_, p_241_3_, p_241_4_);
   }

   public float func_227_a(Entity p_227_1_) {
      return this.field_452_a.func_227_a(p_227_1_);
   }

   public int func_234_g() {
      return this.field_452_a.func_234_g();
   }

   public int func_232_a(int p_232_1_, int p_232_2_) {
      return this.field_452_a.func_232_a(p_232_1_, 0);
   }

   public int func_218_a(int p_218_1_) {
      return this.field_452_a.func_232_a(p_218_1_, 0);
   }

   public int func_4025_d() {
      return this.field_452_a.func_4025_d();
   }

   public AxisAlignedBB func_246_f(World p_246_1_, int p_246_2_, int p_246_3_, int p_246_4_) {
      return this.field_452_a.func_246_f(p_246_1_, p_246_2_, p_246_3_, p_246_4_);
   }

   public void func_257_a(World p_257_1_, int p_257_2_, int p_257_3_, int p_257_4_, Entity p_257_5_, Vec3D p_257_6_) {
      this.field_452_a.func_257_a(p_257_1_, p_257_2_, p_257_3_, p_257_4_, p_257_5_, p_257_6_);
   }

   public boolean func_245_h() {
      return this.field_452_a.func_245_h();
   }

   public boolean func_224_a(int p_224_1_, boolean p_224_2_) {
      return this.field_452_a.func_224_a(p_224_1_, p_224_2_);
   }

   public boolean func_243_a(World p_243_1_, int p_243_2_, int p_243_3_, int p_243_4_) {
      return this.field_452_a.func_243_a(p_243_1_, p_243_2_, p_243_3_, p_243_4_);
   }

   public void func_235_e(World p_235_1_, int p_235_2_, int p_235_3_, int p_235_4_) {
      this.func_226_a(p_235_1_, p_235_2_, p_235_3_, p_235_4_, 0);
      this.field_452_a.func_235_e(p_235_1_, p_235_2_, p_235_3_, p_235_4_);
   }

   public void func_214_b(World p_214_1_, int p_214_2_, int p_214_3_, int p_214_4_) {
      this.field_452_a.func_214_b(p_214_1_, p_214_2_, p_214_3_, p_214_4_);
   }

   public void func_254_a(World p_254_1_, int p_254_2_, int p_254_3_, int p_254_4_, Entity p_254_5_) {
      this.field_452_a.func_254_a(p_254_1_, p_254_2_, p_254_3_, p_254_4_, p_254_5_);
   }

   public void func_208_a(World p_208_1_, int p_208_2_, int p_208_3_, int p_208_4_, Random p_208_5_) {
      this.field_452_a.func_208_a(p_208_1_, p_208_2_, p_208_3_, p_208_4_, p_208_5_);
   }

   public boolean func_250_a(World p_250_1_, int p_250_2_, int p_250_3_, int p_250_4_, EntityPlayer p_250_5_) {
      return this.field_452_a.func_250_a(p_250_1_, p_250_2_, p_250_3_, p_250_4_, p_250_5_);
   }

   public void func_4027_c(World p_4027_1_, int p_4027_2_, int p_4027_3_, int p_4027_4_) {
      this.field_452_a.func_4027_c(p_4027_1_, p_4027_2_, p_4027_3_, p_4027_4_);
   }

   public void func_4026_a(World p_4026_1_, int p_4026_2_, int p_4026_3_, int p_4026_4_, EntityLiving p_4026_5_) {
      int var6 = MathHelper.func_1108_b((double)(p_4026_5_.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3;
      int var7 = p_4026_1_.func_602_e(p_4026_2_, p_4026_3_, p_4026_4_) & 4;
      if(var6 == 0) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 2 | var7);
      }

      if(var6 == 1) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 1 | var7);
      }

      if(var6 == 2) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 3 | var7);
      }

      if(var6 == 3) {
         p_4026_1_.func_691_b(p_4026_2_, p_4026_3_, p_4026_4_, 0 | var7);
      }

   }

   public void func_258_d(World p_258_1_, int p_258_2_, int p_258_3_, int p_258_4_, int p_258_5_) {
      if(p_258_5_ == 0) {
         int var6 = p_258_1_.func_602_e(p_258_2_, p_258_3_, p_258_4_);
         p_258_1_.func_691_b(p_258_2_, p_258_3_, p_258_4_, var6 | 4);
      }

   }
}
