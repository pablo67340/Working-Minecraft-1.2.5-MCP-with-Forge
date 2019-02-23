package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.MathHelper;

public class Vec3D {

   private static List field_1778_d = new ArrayList();
   private static int field_1777_e = 0;
   public double field_1776_a;
   public double field_1775_b;
   public double field_1779_c;


   public static Vec3D func_1260_a(double p_1260_0_, double p_1260_2_, double p_1260_4_) {
      return new Vec3D(p_1260_0_, p_1260_2_, p_1260_4_);
   }

   public static void func_28215_a() {
      field_1778_d.clear();
      field_1777_e = 0;
   }

   public static void func_1259_a() {
      field_1777_e = 0;
   }

   public static Vec3D func_1248_b(double p_1248_0_, double p_1248_2_, double p_1248_4_) {
      if(field_1777_e >= field_1778_d.size()) {
         field_1778_d.add(func_1260_a(0.0D, 0.0D, 0.0D));
      }

      return ((Vec3D)field_1778_d.get(field_1777_e++)).func_1254_e(p_1248_0_, p_1248_2_, p_1248_4_);
   }

   private Vec3D(double p_i247_1_, double p_i247_3_, double p_i247_5_) {
      if(p_i247_1_ == -0.0D) {
         p_i247_1_ = 0.0D;
      }

      if(p_i247_3_ == -0.0D) {
         p_i247_3_ = 0.0D;
      }

      if(p_i247_5_ == -0.0D) {
         p_i247_5_ = 0.0D;
      }

      this.field_1776_a = p_i247_1_;
      this.field_1775_b = p_i247_3_;
      this.field_1779_c = p_i247_5_;
   }

   private Vec3D func_1254_e(double p_1254_1_, double p_1254_3_, double p_1254_5_) {
      this.field_1776_a = p_1254_1_;
      this.field_1775_b = p_1254_3_;
      this.field_1779_c = p_1254_5_;
      return this;
   }

   public Vec3D func_1262_a(Vec3D p_1262_1_) {
      return func_1248_b(p_1262_1_.field_1776_a - this.field_1776_a, p_1262_1_.field_1775_b - this.field_1775_b, p_1262_1_.field_1779_c - this.field_1779_c);
   }

   public Vec3D func_1252_b() {
      double var1 = (double)MathHelper.func_1109_a(this.field_1776_a * this.field_1776_a + this.field_1775_b * this.field_1775_b + this.field_1779_c * this.field_1779_c);
      return var1 < 1.0E-4D?func_1248_b(0.0D, 0.0D, 0.0D):func_1248_b(this.field_1776_a / var1, this.field_1775_b / var1, this.field_1779_c / var1);
   }

   public double func_35612_b(Vec3D p_35612_1_) {
      return this.field_1776_a * p_35612_1_.field_1776_a + this.field_1775_b * p_35612_1_.field_1775_b + this.field_1779_c * p_35612_1_.field_1779_c;
   }

   public Vec3D func_1246_b(Vec3D p_1246_1_) {
      return func_1248_b(this.field_1775_b * p_1246_1_.field_1779_c - this.field_1779_c * p_1246_1_.field_1775_b, this.field_1779_c * p_1246_1_.field_1776_a - this.field_1776_a * p_1246_1_.field_1779_c, this.field_1776_a * p_1246_1_.field_1775_b - this.field_1775_b * p_1246_1_.field_1776_a);
   }

   public Vec3D func_1257_c(double p_1257_1_, double p_1257_3_, double p_1257_5_) {
      return func_1248_b(this.field_1776_a + p_1257_1_, this.field_1775_b + p_1257_3_, this.field_1779_c + p_1257_5_);
   }

   public double func_1251_c(Vec3D p_1251_1_) {
      double var2 = p_1251_1_.field_1776_a - this.field_1776_a;
      double var4 = p_1251_1_.field_1775_b - this.field_1775_b;
      double var6 = p_1251_1_.field_1779_c - this.field_1779_c;
      return (double)MathHelper.func_1109_a(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public double func_1261_d(Vec3D p_1261_1_) {
      double var2 = p_1261_1_.field_1776_a - this.field_1776_a;
      double var4 = p_1261_1_.field_1775_b - this.field_1775_b;
      double var6 = p_1261_1_.field_1779_c - this.field_1779_c;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public double func_1255_d(double p_1255_1_, double p_1255_3_, double p_1255_5_) {
      double var7 = p_1255_1_ - this.field_1776_a;
      double var9 = p_1255_3_ - this.field_1775_b;
      double var11 = p_1255_5_ - this.field_1779_c;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_1253_c() {
      return (double)MathHelper.func_1109_a(this.field_1776_a * this.field_1776_a + this.field_1775_b * this.field_1775_b + this.field_1779_c * this.field_1779_c);
   }

   public Vec3D func_1247_a(Vec3D p_1247_1_, double p_1247_2_) {
      double var4 = p_1247_1_.field_1776_a - this.field_1776_a;
      double var6 = p_1247_1_.field_1775_b - this.field_1775_b;
      double var8 = p_1247_1_.field_1779_c - this.field_1779_c;
      if(var4 * var4 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_1247_2_ - this.field_1776_a) / var4;
         return var10 >= 0.0D && var10 <= 1.0D?func_1248_b(this.field_1776_a + var4 * var10, this.field_1775_b + var6 * var10, this.field_1779_c + var8 * var10):null;
      }
   }

   public Vec3D func_1250_b(Vec3D p_1250_1_, double p_1250_2_) {
      double var4 = p_1250_1_.field_1776_a - this.field_1776_a;
      double var6 = p_1250_1_.field_1775_b - this.field_1775_b;
      double var8 = p_1250_1_.field_1779_c - this.field_1779_c;
      if(var6 * var6 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_1250_2_ - this.field_1775_b) / var6;
         return var10 >= 0.0D && var10 <= 1.0D?func_1248_b(this.field_1776_a + var4 * var10, this.field_1775_b + var6 * var10, this.field_1779_c + var8 * var10):null;
      }
   }

   public Vec3D func_1256_c(Vec3D p_1256_1_, double p_1256_2_) {
      double var4 = p_1256_1_.field_1776_a - this.field_1776_a;
      double var6 = p_1256_1_.field_1775_b - this.field_1775_b;
      double var8 = p_1256_1_.field_1779_c - this.field_1779_c;
      if(var8 * var8 < 1.0000000116860974E-7D) {
         return null;
      } else {
         double var10 = (p_1256_2_ - this.field_1779_c) / var8;
         return var10 >= 0.0D && var10 <= 1.0D?func_1248_b(this.field_1776_a + var4 * var10, this.field_1775_b + var6 * var10, this.field_1779_c + var8 * var10):null;
      }
   }

   public String toString() {
      return "(" + this.field_1776_a + ", " + this.field_1775_b + ", " + this.field_1779_c + ")";
   }

   public void func_1258_a(float p_1258_1_) {
      float var2 = MathHelper.func_1114_b(p_1258_1_);
      float var3 = MathHelper.func_1106_a(p_1258_1_);
      double var4 = this.field_1776_a;
      double var6 = this.field_1775_b * (double)var2 + this.field_1779_c * (double)var3;
      double var8 = this.field_1779_c * (double)var2 - this.field_1775_b * (double)var3;
      this.field_1776_a = var4;
      this.field_1775_b = var6;
      this.field_1779_c = var8;
   }

   public void func_1249_b(float p_1249_1_) {
      float var2 = MathHelper.func_1114_b(p_1249_1_);
      float var3 = MathHelper.func_1106_a(p_1249_1_);
      double var4 = this.field_1776_a * (double)var2 + this.field_1779_c * (double)var3;
      double var6 = this.field_1775_b;
      double var8 = this.field_1779_c * (double)var2 - this.field_1776_a * (double)var3;
      this.field_1776_a = var4;
      this.field_1775_b = var6;
      this.field_1779_c = var8;
   }

}
