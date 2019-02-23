package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.Vec3D;

public class AxisAlignedBB {

   private static List field_1700_g = new ArrayList();
   private static int field_1699_h = 0;
   public double field_1698_a;
   public double field_1697_b;
   public double field_1704_c;
   public double field_1703_d;
   public double field_1702_e;
   public double field_1701_f;


   public static AxisAlignedBB func_1168_a(double p_1168_0_, double p_1168_2_, double p_1168_4_, double p_1168_6_, double p_1168_8_, double p_1168_10_) {
      return new AxisAlignedBB(p_1168_0_, p_1168_2_, p_1168_4_, p_1168_6_, p_1168_8_, p_1168_10_);
   }

   public static void func_28196_a() {
      field_1700_g.clear();
      field_1699_h = 0;
   }

   public static void func_4149_a() {
      field_1699_h = 0;
   }

   public static AxisAlignedBB func_1161_b(double p_1161_0_, double p_1161_2_, double p_1161_4_, double p_1161_6_, double p_1161_8_, double p_1161_10_) {
      if(field_1699_h >= field_1700_g.size()) {
         field_1700_g.add(func_1168_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D));
      }

      return ((AxisAlignedBB)field_1700_g.get(field_1699_h++)).func_1165_c(p_1161_0_, p_1161_2_, p_1161_4_, p_1161_6_, p_1161_8_, p_1161_10_);
   }

   private AxisAlignedBB(double p_i667_1_, double p_i667_3_, double p_i667_5_, double p_i667_7_, double p_i667_9_, double p_i667_11_) {
      this.field_1698_a = p_i667_1_;
      this.field_1697_b = p_i667_3_;
      this.field_1704_c = p_i667_5_;
      this.field_1703_d = p_i667_7_;
      this.field_1702_e = p_i667_9_;
      this.field_1701_f = p_i667_11_;
   }

   public AxisAlignedBB func_1165_c(double p_1165_1_, double p_1165_3_, double p_1165_5_, double p_1165_7_, double p_1165_9_, double p_1165_11_) {
      this.field_1698_a = p_1165_1_;
      this.field_1697_b = p_1165_3_;
      this.field_1704_c = p_1165_5_;
      this.field_1703_d = p_1165_7_;
      this.field_1702_e = p_1165_9_;
      this.field_1701_f = p_1165_11_;
      return this;
   }

   public AxisAlignedBB func_1170_a(double p_1170_1_, double p_1170_3_, double p_1170_5_) {
      double var7 = this.field_1698_a;
      double var9 = this.field_1697_b;
      double var11 = this.field_1704_c;
      double var13 = this.field_1703_d;
      double var15 = this.field_1702_e;
      double var17 = this.field_1701_f;
      if(p_1170_1_ < 0.0D) {
         var7 += p_1170_1_;
      }

      if(p_1170_1_ > 0.0D) {
         var13 += p_1170_1_;
      }

      if(p_1170_3_ < 0.0D) {
         var9 += p_1170_3_;
      }

      if(p_1170_3_ > 0.0D) {
         var15 += p_1170_3_;
      }

      if(p_1170_5_ < 0.0D) {
         var11 += p_1170_5_;
      }

      if(p_1170_5_ > 0.0D) {
         var17 += p_1170_5_;
      }

      return func_1161_b(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_1177_b(double p_1177_1_, double p_1177_3_, double p_1177_5_) {
      double var7 = this.field_1698_a - p_1177_1_;
      double var9 = this.field_1697_b - p_1177_3_;
      double var11 = this.field_1704_c - p_1177_5_;
      double var13 = this.field_1703_d + p_1177_1_;
      double var15 = this.field_1702_e + p_1177_3_;
      double var17 = this.field_1701_f + p_1177_5_;
      return func_1161_b(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_1166_c(double p_1166_1_, double p_1166_3_, double p_1166_5_) {
      return func_1161_b(this.field_1698_a + p_1166_1_, this.field_1697_b + p_1166_3_, this.field_1704_c + p_1166_5_, this.field_1703_d + p_1166_1_, this.field_1702_e + p_1166_3_, this.field_1701_f + p_1166_5_);
   }

   public double func_1163_a(AxisAlignedBB p_1163_1_, double p_1163_2_) {
      if(p_1163_1_.field_1702_e > this.field_1697_b && p_1163_1_.field_1697_b < this.field_1702_e) {
         if(p_1163_1_.field_1701_f > this.field_1704_c && p_1163_1_.field_1704_c < this.field_1701_f) {
            double var4;
            if(p_1163_2_ > 0.0D && p_1163_1_.field_1703_d <= this.field_1698_a) {
               var4 = this.field_1698_a - p_1163_1_.field_1703_d;
               if(var4 < p_1163_2_) {
                  p_1163_2_ = var4;
               }
            }

            if(p_1163_2_ < 0.0D && p_1163_1_.field_1698_a >= this.field_1703_d) {
               var4 = this.field_1703_d - p_1163_1_.field_1698_a;
               if(var4 > p_1163_2_) {
                  p_1163_2_ = var4;
               }
            }

            return p_1163_2_;
         } else {
            return p_1163_2_;
         }
      } else {
         return p_1163_2_;
      }
   }

   public double func_1172_b(AxisAlignedBB p_1172_1_, double p_1172_2_) {
      if(p_1172_1_.field_1703_d > this.field_1698_a && p_1172_1_.field_1698_a < this.field_1703_d) {
         if(p_1172_1_.field_1701_f > this.field_1704_c && p_1172_1_.field_1704_c < this.field_1701_f) {
            double var4;
            if(p_1172_2_ > 0.0D && p_1172_1_.field_1702_e <= this.field_1697_b) {
               var4 = this.field_1697_b - p_1172_1_.field_1702_e;
               if(var4 < p_1172_2_) {
                  p_1172_2_ = var4;
               }
            }

            if(p_1172_2_ < 0.0D && p_1172_1_.field_1697_b >= this.field_1702_e) {
               var4 = this.field_1702_e - p_1172_1_.field_1697_b;
               if(var4 > p_1172_2_) {
                  p_1172_2_ = var4;
               }
            }

            return p_1172_2_;
         } else {
            return p_1172_2_;
         }
      } else {
         return p_1172_2_;
      }
   }

   public double func_1162_c(AxisAlignedBB p_1162_1_, double p_1162_2_) {
      if(p_1162_1_.field_1703_d > this.field_1698_a && p_1162_1_.field_1698_a < this.field_1703_d) {
         if(p_1162_1_.field_1702_e > this.field_1697_b && p_1162_1_.field_1697_b < this.field_1702_e) {
            double var4;
            if(p_1162_2_ > 0.0D && p_1162_1_.field_1701_f <= this.field_1704_c) {
               var4 = this.field_1704_c - p_1162_1_.field_1701_f;
               if(var4 < p_1162_2_) {
                  p_1162_2_ = var4;
               }
            }

            if(p_1162_2_ < 0.0D && p_1162_1_.field_1704_c >= this.field_1701_f) {
               var4 = this.field_1701_f - p_1162_1_.field_1704_c;
               if(var4 > p_1162_2_) {
                  p_1162_2_ = var4;
               }
            }

            return p_1162_2_;
         } else {
            return p_1162_2_;
         }
      } else {
         return p_1162_2_;
      }
   }

   public boolean func_1178_a(AxisAlignedBB p_1178_1_) {
      return p_1178_1_.field_1703_d > this.field_1698_a && p_1178_1_.field_1698_a < this.field_1703_d?(p_1178_1_.field_1702_e > this.field_1697_b && p_1178_1_.field_1697_b < this.field_1702_e?p_1178_1_.field_1701_f > this.field_1704_c && p_1178_1_.field_1704_c < this.field_1701_f:false):false;
   }

   public AxisAlignedBB func_1174_d(double p_1174_1_, double p_1174_3_, double p_1174_5_) {
      this.field_1698_a += p_1174_1_;
      this.field_1697_b += p_1174_3_;
      this.field_1704_c += p_1174_5_;
      this.field_1703_d += p_1174_1_;
      this.field_1702_e += p_1174_3_;
      this.field_1701_f += p_1174_5_;
      return this;
   }

   public boolean func_4150_a(Vec3D p_4150_1_) {
      return p_4150_1_.field_1776_a > this.field_1698_a && p_4150_1_.field_1776_a < this.field_1703_d?(p_4150_1_.field_1775_b > this.field_1697_b && p_4150_1_.field_1775_b < this.field_1702_e?p_4150_1_.field_1779_c > this.field_1704_c && p_4150_1_.field_1779_c < this.field_1701_f:false):false;
   }

   public double func_1164_b() {
      double var1 = this.field_1703_d - this.field_1698_a;
      double var3 = this.field_1702_e - this.field_1697_b;
      double var5 = this.field_1701_f - this.field_1704_c;
      return (var1 + var3 + var5) / 3.0D;
   }

   public AxisAlignedBB func_28195_e(double p_28195_1_, double p_28195_3_, double p_28195_5_) {
      double var7 = this.field_1698_a + p_28195_1_;
      double var9 = this.field_1697_b + p_28195_3_;
      double var11 = this.field_1704_c + p_28195_5_;
      double var13 = this.field_1703_d - p_28195_1_;
      double var15 = this.field_1702_e - p_28195_3_;
      double var17 = this.field_1701_f - p_28195_5_;
      return func_1161_b(var7, var9, var11, var13, var15, var17);
   }

   public AxisAlignedBB func_1160_c() {
      return func_1161_b(this.field_1698_a, this.field_1697_b, this.field_1704_c, this.field_1703_d, this.field_1702_e, this.field_1701_f);
   }

   public MovingObjectPosition func_1169_a(Vec3D p_1169_1_, Vec3D p_1169_2_) {
      Vec3D var3 = p_1169_1_.func_1247_a(p_1169_2_, this.field_1698_a);
      Vec3D var4 = p_1169_1_.func_1247_a(p_1169_2_, this.field_1703_d);
      Vec3D var5 = p_1169_1_.func_1250_b(p_1169_2_, this.field_1697_b);
      Vec3D var6 = p_1169_1_.func_1250_b(p_1169_2_, this.field_1702_e);
      Vec3D var7 = p_1169_1_.func_1256_c(p_1169_2_, this.field_1704_c);
      Vec3D var8 = p_1169_1_.func_1256_c(p_1169_2_, this.field_1701_f);
      if(!this.func_1167_a(var3)) {
         var3 = null;
      }

      if(!this.func_1167_a(var4)) {
         var4 = null;
      }

      if(!this.func_1175_b(var5)) {
         var5 = null;
      }

      if(!this.func_1175_b(var6)) {
         var6 = null;
      }

      if(!this.func_1176_c(var7)) {
         var7 = null;
      }

      if(!this.func_1176_c(var8)) {
         var8 = null;
      }

      Vec3D var9 = null;
      if(var3 != null && (var9 == null || p_1169_1_.func_1261_d(var3) < p_1169_1_.func_1261_d(var9))) {
         var9 = var3;
      }

      if(var4 != null && (var9 == null || p_1169_1_.func_1261_d(var4) < p_1169_1_.func_1261_d(var9))) {
         var9 = var4;
      }

      if(var5 != null && (var9 == null || p_1169_1_.func_1261_d(var5) < p_1169_1_.func_1261_d(var9))) {
         var9 = var5;
      }

      if(var6 != null && (var9 == null || p_1169_1_.func_1261_d(var6) < p_1169_1_.func_1261_d(var9))) {
         var9 = var6;
      }

      if(var7 != null && (var9 == null || p_1169_1_.func_1261_d(var7) < p_1169_1_.func_1261_d(var9))) {
         var9 = var7;
      }

      if(var8 != null && (var9 == null || p_1169_1_.func_1261_d(var8) < p_1169_1_.func_1261_d(var9))) {
         var9 = var8;
      }

      if(var9 == null) {
         return null;
      } else {
         byte var10 = -1;
         if(var9 == var3) {
            var10 = 4;
         }

         if(var9 == var4) {
            var10 = 5;
         }

         if(var9 == var5) {
            var10 = 0;
         }

         if(var9 == var6) {
            var10 = 1;
         }

         if(var9 == var7) {
            var10 = 2;
         }

         if(var9 == var8) {
            var10 = 3;
         }

         return new MovingObjectPosition(0, 0, 0, var10, var9);
      }
   }

   private boolean func_1167_a(Vec3D p_1167_1_) {
      return p_1167_1_ == null?false:p_1167_1_.field_1775_b >= this.field_1697_b && p_1167_1_.field_1775_b <= this.field_1702_e && p_1167_1_.field_1779_c >= this.field_1704_c && p_1167_1_.field_1779_c <= this.field_1701_f;
   }

   private boolean func_1175_b(Vec3D p_1175_1_) {
      return p_1175_1_ == null?false:p_1175_1_.field_1776_a >= this.field_1698_a && p_1175_1_.field_1776_a <= this.field_1703_d && p_1175_1_.field_1779_c >= this.field_1704_c && p_1175_1_.field_1779_c <= this.field_1701_f;
   }

   private boolean func_1176_c(Vec3D p_1176_1_) {
      return p_1176_1_ == null?false:p_1176_1_.field_1776_a >= this.field_1698_a && p_1176_1_.field_1776_a <= this.field_1703_d && p_1176_1_.field_1775_b >= this.field_1697_b && p_1176_1_.field_1775_b <= this.field_1702_e;
   }

   public void func_1171_b(AxisAlignedBB p_1171_1_) {
      this.field_1698_a = p_1171_1_.field_1698_a;
      this.field_1697_b = p_1171_1_.field_1697_b;
      this.field_1704_c = p_1171_1_.field_1704_c;
      this.field_1703_d = p_1171_1_.field_1703_d;
      this.field_1702_e = p_1171_1_.field_1702_e;
      this.field_1701_f = p_1171_1_.field_1701_f;
   }

   public String toString() {
      return "box[" + this.field_1698_a + ", " + this.field_1697_b + ", " + this.field_1704_c + " -> " + this.field_1703_d + ", " + this.field_1702_e + ", " + this.field_1701_f + "]";
   }

}
