package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathPoint;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class PathNavigate {

   private EntityLiving field_46076_a;
   private World field_46074_b;
   private PathEntity field_46075_c;
   private float field_46073_d;
   private float field_48683_e;
   private boolean field_48681_f = false;
   private int field_48682_g;
   private int field_48688_h;
   private Vec3D field_48689_i = Vec3D.func_1260_a(0.0D, 0.0D, 0.0D);
   private boolean field_48686_j = true;
   private boolean field_48687_k = false;
   private boolean field_48684_l = false;
   private boolean field_48685_m = false;


   public PathNavigate(EntityLiving p_i1060_1_, World p_i1060_2_, float p_i1060_3_) {
      this.field_46076_a = p_i1060_1_;
      this.field_46074_b = p_i1060_2_;
      this.field_48683_e = p_i1060_3_;
   }

   public void func_48664_a(boolean p_48664_1_) {
      this.field_48684_l = p_48664_1_;
   }

   public boolean func_48658_a() {
      return this.field_48684_l;
   }

   public void func_48673_b(boolean p_48673_1_) {
      this.field_48687_k = p_48673_1_;
   }

   public void func_48663_c(boolean p_48663_1_) {
      this.field_48686_j = p_48663_1_;
   }

   public boolean func_48665_b() {
      return this.field_48687_k;
   }

   public void func_48680_d(boolean p_48680_1_) {
      this.field_48681_f = p_48680_1_;
   }

   public void func_48660_a(float p_48660_1_) {
      this.field_46073_d = p_48660_1_;
   }

   public void func_48669_e(boolean p_48669_1_) {
      this.field_48685_m = p_48669_1_;
   }

   public PathEntity func_48671_a(double p_48671_1_, double p_48671_3_, double p_48671_5_) {
      return !this.func_48659_j()?null:this.field_46074_b.func_48460_a(this.field_46076_a, MathHelper.func_1108_b(p_48671_1_), (int)p_48671_3_, MathHelper.func_1108_b(p_48671_5_), this.field_48683_e, this.field_48686_j, this.field_48687_k, this.field_48684_l, this.field_48685_m);
   }

   public boolean func_48666_a(double p_48666_1_, double p_48666_3_, double p_48666_5_, float p_48666_7_) {
      PathEntity var8 = this.func_48671_a((double)MathHelper.func_1108_b(p_48666_1_), (double)((int)p_48666_3_), (double)MathHelper.func_1108_b(p_48666_5_));
      return this.func_48678_a(var8, p_48666_7_);
   }

   public PathEntity func_48679_a(EntityLiving p_48679_1_) {
      return !this.func_48659_j()?null:this.field_46074_b.func_48463_a(this.field_46076_a, p_48679_1_, this.field_48683_e, this.field_48686_j, this.field_48687_k, this.field_48684_l, this.field_48685_m);
   }

   public boolean func_48667_a(EntityLiving p_48667_1_, float p_48667_2_) {
      PathEntity var3 = this.func_48679_a(p_48667_1_);
      return var3 != null?this.func_48678_a(var3, p_48667_2_):false;
   }

   public boolean func_48678_a(PathEntity p_48678_1_, float p_48678_2_) {
      if(p_48678_1_ == null) {
         this.field_46075_c = null;
         return false;
      } else {
         if(!p_48678_1_.func_48647_a(this.field_46075_c)) {
            this.field_46075_c = p_48678_1_;
         }

         if(this.field_48681_f) {
            this.func_48677_l();
         }

         if(this.field_46075_c.func_48644_d() == 0) {
            return false;
         } else {
            this.field_46073_d = p_48678_2_;
            Vec3D var3 = this.func_48661_h();
            this.field_48688_h = this.field_48682_g;
            this.field_48689_i.field_1776_a = var3.field_1776_a;
            this.field_48689_i.field_1775_b = var3.field_1775_b;
            this.field_48689_i.field_1779_c = var3.field_1779_c;
            return true;
         }
      }
   }

   public PathEntity func_48670_c() {
      return this.field_46075_c;
   }

   public void func_46069_a() {
      ++this.field_48682_g;
      if(!this.func_46072_b()) {
         if(this.func_48659_j()) {
            this.func_48674_g();
         }

         if(!this.func_46072_b()) {
            Vec3D var1 = this.field_46075_c.func_48640_a(this.field_46076_a);
            if(var1 != null) {
               this.field_46076_a.func_46009_aH().func_48187_a(var1.field_1776_a, var1.field_1775_b, var1.field_1779_c, this.field_46073_d);
            }
         }
      }
   }

   private void func_48674_g() {
      Vec3D var1 = this.func_48661_h();
      int var2 = this.field_46075_c.func_48644_d();

      for(int var3 = this.field_46075_c.func_48643_e(); var3 < this.field_46075_c.func_48644_d(); ++var3) {
         if(this.field_46075_c.func_48648_a(var3).field_1717_b != (int)var1.field_1775_b) {
            var2 = var3;
            break;
         }
      }

      float var8 = this.field_46076_a.field_644_aC * this.field_46076_a.field_644_aC;

      int var4;
      for(var4 = this.field_46075_c.func_48643_e(); var4 < var2; ++var4) {
         if(var1.func_1261_d(this.field_46075_c.func_48646_a(this.field_46076_a, var4)) < (double)var8) {
            this.field_46075_c.func_48642_c(var4 + 1);
         }
      }

      var4 = (int)Math.ceil((double)this.field_46076_a.field_644_aC);
      int var5 = (int)this.field_46076_a.field_643_aD + 1;
      int var6 = var4;

      for(int var7 = var2 - 1; var7 >= this.field_46075_c.func_48643_e(); --var7) {
         if(this.func_48662_a(var1, this.field_46075_c.func_48646_a(this.field_46076_a, var7), var4, var5, var6)) {
            this.field_46075_c.func_48642_c(var7);
            break;
         }
      }

      if(this.field_48682_g - this.field_48688_h > 100) {
         if(var1.func_1261_d(this.field_48689_i) < 2.25D) {
            this.func_48672_f();
         }

         this.field_48688_h = this.field_48682_g;
         this.field_48689_i.field_1776_a = var1.field_1776_a;
         this.field_48689_i.field_1775_b = var1.field_1775_b;
         this.field_48689_i.field_1779_c = var1.field_1779_c;
      }

   }

   public boolean func_46072_b() {
      return this.field_46075_c == null || this.field_46075_c.func_1207_b();
   }

   public void func_48672_f() {
      this.field_46075_c = null;
   }

   private Vec3D func_48661_h() {
      return Vec3D.func_1248_b(this.field_46076_a.field_611_ak, (double)this.func_48668_i(), this.field_46076_a.field_609_am);
   }

   private int func_48668_i() {
      if(this.field_46076_a.func_27013_ag() && this.field_48685_m) {
         int var1 = (int)this.field_46076_a.field_601_au.field_1697_b;
         int var2 = this.field_46074_b.func_600_a(MathHelper.func_1108_b(this.field_46076_a.field_611_ak), var1, MathHelper.func_1108_b(this.field_46076_a.field_609_am));
         int var3 = 0;

         do {
            if(var2 != Block.field_401_B.field_376_bc && var2 != Block.field_399_C.field_376_bc) {
               return var1;
            }

            ++var1;
            var2 = this.field_46074_b.func_600_a(MathHelper.func_1108_b(this.field_46076_a.field_611_ak), var1, MathHelper.func_1108_b(this.field_46076_a.field_609_am));
            ++var3;
         } while(var3 <= 16);

         return (int)this.field_46076_a.field_601_au.field_1697_b;
      } else {
         return (int)(this.field_46076_a.field_601_au.field_1697_b + 0.5D);
      }
   }

   private boolean func_48659_j() {
      return this.field_46076_a.field_9298_aH || this.field_48685_m && this.func_48657_k();
   }

   private boolean func_48657_k() {
      return this.field_46076_a.func_27013_ag() || this.field_46076_a.func_359_G();
   }

   private void func_48677_l() {
      if(!this.field_46074_b.func_647_i(MathHelper.func_1108_b(this.field_46076_a.field_611_ak), (int)(this.field_46076_a.field_601_au.field_1697_b + 0.5D), MathHelper.func_1108_b(this.field_46076_a.field_609_am))) {
         for(int var1 = 0; var1 < this.field_46075_c.func_48644_d(); ++var1) {
            PathPoint var2 = this.field_46075_c.func_48648_a(var1);
            if(this.field_46074_b.func_647_i(var2.field_1718_a, var2.field_1717_b, var2.field_1716_c)) {
               this.field_46075_c.func_48641_b(var1 - 1);
               return;
            }
         }

      }
   }

   private boolean func_48662_a(Vec3D p_48662_1_, Vec3D p_48662_2_, int p_48662_3_, int p_48662_4_, int p_48662_5_) {
      int var6 = MathHelper.func_1108_b(p_48662_1_.field_1776_a);
      int var7 = MathHelper.func_1108_b(p_48662_1_.field_1779_c);
      double var8 = p_48662_2_.field_1776_a - p_48662_1_.field_1776_a;
      double var10 = p_48662_2_.field_1779_c - p_48662_1_.field_1779_c;
      double var12 = var8 * var8 + var10 * var10;
      if(var12 < 1.0E-8D) {
         return false;
      } else {
         double var14 = 1.0D / Math.sqrt(var12);
         var8 *= var14;
         var10 *= var14;
         p_48662_3_ += 2;
         p_48662_5_ += 2;
         if(!this.func_48675_a(var6, (int)p_48662_1_.field_1775_b, var7, p_48662_3_, p_48662_4_, p_48662_5_, p_48662_1_, var8, var10)) {
            return false;
         } else {
            p_48662_3_ -= 2;
            p_48662_5_ -= 2;
            double var16 = 1.0D / Math.abs(var8);
            double var18 = 1.0D / Math.abs(var10);
            double var20 = (double)(var6 * 1) - p_48662_1_.field_1776_a;
            double var22 = (double)(var7 * 1) - p_48662_1_.field_1779_c;
            if(var8 >= 0.0D) {
               ++var20;
            }

            if(var10 >= 0.0D) {
               ++var22;
            }

            var20 /= var8;
            var22 /= var10;
            int var24 = var8 < 0.0D?-1:1;
            int var25 = var10 < 0.0D?-1:1;
            int var26 = MathHelper.func_1108_b(p_48662_2_.field_1776_a);
            int var27 = MathHelper.func_1108_b(p_48662_2_.field_1779_c);
            int var28 = var26 - var6;
            int var29 = var27 - var7;

            do {
               if(var28 * var24 <= 0 && var29 * var25 <= 0) {
                  return true;
               }

               if(var20 < var22) {
                  var20 += var16;
                  var6 += var24;
                  var28 = var26 - var6;
               } else {
                  var22 += var18;
                  var7 += var25;
                  var29 = var27 - var7;
               }
            } while(this.func_48675_a(var6, (int)p_48662_1_.field_1775_b, var7, p_48662_3_, p_48662_4_, p_48662_5_, p_48662_1_, var8, var10));

            return false;
         }
      }
   }

   private boolean func_48675_a(int p_48675_1_, int p_48675_2_, int p_48675_3_, int p_48675_4_, int p_48675_5_, int p_48675_6_, Vec3D p_48675_7_, double p_48675_8_, double p_48675_10_) {
      int var12 = p_48675_1_ - p_48675_4_ / 2;
      int var13 = p_48675_3_ - p_48675_6_ / 2;
      if(!this.func_48676_b(var12, p_48675_2_, var13, p_48675_4_, p_48675_5_, p_48675_6_, p_48675_7_, p_48675_8_, p_48675_10_)) {
         return false;
      } else {
         for(int var14 = var12; var14 < var12 + p_48675_4_; ++var14) {
            for(int var15 = var13; var15 < var13 + p_48675_6_; ++var15) {
               double var16 = (double)var14 + 0.5D - p_48675_7_.field_1776_a;
               double var18 = (double)var15 + 0.5D - p_48675_7_.field_1779_c;
               if(var16 * p_48675_8_ + var18 * p_48675_10_ >= 0.0D) {
                  int var20 = this.field_46074_b.func_600_a(var14, p_48675_2_ - 1, var15);
                  if(var20 <= 0) {
                     return false;
                  }

                  Material var21 = Block.field_345_n[var20].field_356_bn;
                  if(var21 == Material.field_1332_f && !this.field_46076_a.func_27013_ag()) {
                     return false;
                  }

                  if(var21 == Material.field_1331_g) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean func_48676_b(int p_48676_1_, int p_48676_2_, int p_48676_3_, int p_48676_4_, int p_48676_5_, int p_48676_6_, Vec3D p_48676_7_, double p_48676_8_, double p_48676_10_) {
      for(int var12 = p_48676_1_; var12 < p_48676_1_ + p_48676_4_; ++var12) {
         for(int var13 = p_48676_2_; var13 < p_48676_2_ + p_48676_5_; ++var13) {
            for(int var14 = p_48676_3_; var14 < p_48676_3_ + p_48676_6_; ++var14) {
               double var15 = (double)var12 + 0.5D - p_48676_7_.field_1776_a;
               double var17 = (double)var14 + 0.5D - p_48676_7_.field_1779_c;
               if(var15 * p_48676_8_ + var17 * p_48676_10_ >= 0.0D) {
                  int var19 = this.field_46074_b.func_600_a(var12, var13, var14);
                  if(var19 > 0 && !Block.field_345_n[var19].func_48204_b(this.field_46074_b, var12, var13, var14)) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }
}
