package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBiped extends ModelBase {

   public ModelRenderer field_1286_a;
   public ModelRenderer field_1285_b;
   public ModelRenderer field_1284_c;
   public ModelRenderer field_1283_d;
   public ModelRenderer field_1282_e;
   public ModelRenderer field_1281_f;
   public ModelRenderer field_1280_g;
   public ModelRenderer field_20098_h;
   public ModelRenderer field_20097_i;
   public int field_1279_h;
   public int field_1278_i;
   public boolean field_1277_j;
   public boolean field_40333_u;


   public ModelBiped() {
      this(0.0F);
   }

   public ModelBiped(float p_i678_1_) {
      this(p_i678_1_, 0.0F);
   }

   public ModelBiped(float p_i679_1_, float p_i679_2_) {
      this.field_1279_h = 0;
      this.field_1278_i = 0;
      this.field_1277_j = false;
      this.field_40333_u = false;
      this.field_20097_i = new ModelRenderer(this, 0, 0);
      this.field_20097_i.func_923_a(-5.0F, 0.0F, -1.0F, 10, 16, 1, p_i679_1_);
      this.field_20098_h = new ModelRenderer(this, 24, 0);
      this.field_20098_h.func_923_a(-3.0F, -6.0F, -1.0F, 6, 6, 1, p_i679_1_);
      this.field_1286_a = new ModelRenderer(this, 0, 0);
      this.field_1286_a.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i679_1_);
      this.field_1286_a.func_925_a(0.0F, 0.0F + p_i679_2_, 0.0F);
      this.field_1285_b = new ModelRenderer(this, 32, 0);
      this.field_1285_b.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, p_i679_1_ + 0.5F);
      this.field_1285_b.func_925_a(0.0F, 0.0F + p_i679_2_, 0.0F);
      this.field_1284_c = new ModelRenderer(this, 16, 16);
      this.field_1284_c.func_923_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, p_i679_1_);
      this.field_1284_c.func_925_a(0.0F, 0.0F + p_i679_2_, 0.0F);
      this.field_1283_d = new ModelRenderer(this, 40, 16);
      this.field_1283_d.func_923_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, p_i679_1_);
      this.field_1283_d.func_925_a(-5.0F, 2.0F + p_i679_2_, 0.0F);
      this.field_1282_e = new ModelRenderer(this, 40, 16);
      this.field_1282_e.field_1404_g = true;
      this.field_1282_e.func_923_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, p_i679_1_);
      this.field_1282_e.func_925_a(5.0F, 2.0F + p_i679_2_, 0.0F);
      this.field_1281_f = new ModelRenderer(this, 0, 16);
      this.field_1281_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i679_1_);
      this.field_1281_f.func_925_a(-2.0F, 12.0F + p_i679_2_, 0.0F);
      this.field_1280_g = new ModelRenderer(this, 0, 16);
      this.field_1280_g.field_1404_g = true;
      this.field_1280_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, p_i679_1_);
      this.field_1280_g.func_925_a(2.0F, 12.0F + p_i679_2_, 0.0F);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_1286_a.func_922_a(p_864_7_);
      this.field_1284_c.func_922_a(p_864_7_);
      this.field_1283_d.func_922_a(p_864_7_);
      this.field_1282_e.func_922_a(p_864_7_);
      this.field_1281_f.func_922_a(p_864_7_);
      this.field_1280_g.func_922_a(p_864_7_);
      this.field_1285_b.func_922_a(p_864_7_);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      this.field_1286_a.field_1406_e = p_863_4_ / 57.295776F;
      this.field_1286_a.field_1407_d = p_863_5_ / 57.295776F;
      this.field_1285_b.field_1406_e = this.field_1286_a.field_1406_e;
      this.field_1285_b.field_1407_d = this.field_1286_a.field_1407_d;
      this.field_1283_d.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 2.0F * p_863_2_ * 0.5F;
      this.field_1282_e.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 2.0F * p_863_2_ * 0.5F;
      this.field_1283_d.field_1405_f = 0.0F;
      this.field_1282_e.field_1405_f = 0.0F;
      this.field_1281_f.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 1.4F * p_863_2_;
      this.field_1280_g.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 1.4F * p_863_2_;
      this.field_1281_f.field_1406_e = 0.0F;
      this.field_1280_g.field_1406_e = 0.0F;
      if(this.field_1243_l) {
         this.field_1283_d.field_1407_d += -0.62831855F;
         this.field_1282_e.field_1407_d += -0.62831855F;
         this.field_1281_f.field_1407_d = -1.2566371F;
         this.field_1280_g.field_1407_d = -1.2566371F;
         this.field_1281_f.field_1406_e = 0.31415927F;
         this.field_1280_g.field_1406_e = -0.31415927F;
      }

      if(this.field_1279_h != 0) {
         this.field_1282_e.field_1407_d = this.field_1282_e.field_1407_d * 0.5F - 0.31415927F * (float)this.field_1279_h;
      }

      if(this.field_1278_i != 0) {
         this.field_1283_d.field_1407_d = this.field_1283_d.field_1407_d * 0.5F - 0.31415927F * (float)this.field_1278_i;
      }

      this.field_1283_d.field_1406_e = 0.0F;
      this.field_1282_e.field_1406_e = 0.0F;
      float var7;
      float var8;
      if(this.field_1244_k > -9990.0F) {
         var7 = this.field_1244_k;
         this.field_1284_c.field_1406_e = MathHelper.func_1106_a(MathHelper.func_1113_c(var7) * 3.1415927F * 2.0F) * 0.2F;
         this.field_1283_d.field_1408_c = MathHelper.func_1106_a(this.field_1284_c.field_1406_e) * 5.0F;
         this.field_1283_d.field_1410_a = -MathHelper.func_1114_b(this.field_1284_c.field_1406_e) * 5.0F;
         this.field_1282_e.field_1408_c = -MathHelper.func_1106_a(this.field_1284_c.field_1406_e) * 5.0F;
         this.field_1282_e.field_1410_a = MathHelper.func_1114_b(this.field_1284_c.field_1406_e) * 5.0F;
         this.field_1283_d.field_1406_e += this.field_1284_c.field_1406_e;
         this.field_1282_e.field_1406_e += this.field_1284_c.field_1406_e;
         this.field_1282_e.field_1407_d += this.field_1284_c.field_1406_e;
         var7 = 1.0F - this.field_1244_k;
         var7 *= var7;
         var7 *= var7;
         var7 = 1.0F - var7;
         var8 = MathHelper.func_1106_a(var7 * 3.1415927F);
         float var9 = MathHelper.func_1106_a(this.field_1244_k * 3.1415927F) * -(this.field_1286_a.field_1407_d - 0.7F) * 0.75F;
         this.field_1283_d.field_1407_d = (float)((double)this.field_1283_d.field_1407_d - ((double)var8 * 1.2D + (double)var9));
         this.field_1283_d.field_1406_e += this.field_1284_c.field_1406_e * 2.0F;
         this.field_1283_d.field_1405_f = MathHelper.func_1106_a(this.field_1244_k * 3.1415927F) * -0.4F;
      }

      if(this.field_1277_j) {
         this.field_1284_c.field_1407_d = 0.5F;
         this.field_1283_d.field_1407_d += 0.4F;
         this.field_1282_e.field_1407_d += 0.4F;
         this.field_1281_f.field_1408_c = 4.0F;
         this.field_1280_g.field_1408_c = 4.0F;
         this.field_1281_f.field_1409_b = 9.0F;
         this.field_1280_g.field_1409_b = 9.0F;
         this.field_1286_a.field_1409_b = 1.0F;
      } else {
         this.field_1284_c.field_1407_d = 0.0F;
         this.field_1281_f.field_1408_c = 0.0F;
         this.field_1280_g.field_1408_c = 0.0F;
         this.field_1281_f.field_1409_b = 12.0F;
         this.field_1280_g.field_1409_b = 12.0F;
         this.field_1286_a.field_1409_b = 0.0F;
      }

      this.field_1283_d.field_1405_f += MathHelper.func_1114_b(p_863_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_1282_e.field_1405_f -= MathHelper.func_1114_b(p_863_3_ * 0.09F) * 0.05F + 0.05F;
      this.field_1283_d.field_1407_d += MathHelper.func_1106_a(p_863_3_ * 0.067F) * 0.05F;
      this.field_1282_e.field_1407_d -= MathHelper.func_1106_a(p_863_3_ * 0.067F) * 0.05F;
      if(this.field_40333_u) {
         var7 = 0.0F;
         var8 = 0.0F;
         this.field_1283_d.field_1405_f = 0.0F;
         this.field_1282_e.field_1405_f = 0.0F;
         this.field_1283_d.field_1406_e = -(0.1F - var7 * 0.6F) + this.field_1286_a.field_1406_e;
         this.field_1282_e.field_1406_e = 0.1F - var7 * 0.6F + this.field_1286_a.field_1406_e + 0.4F;
         this.field_1283_d.field_1407_d = -1.5707964F + this.field_1286_a.field_1407_d;
         this.field_1282_e.field_1407_d = -1.5707964F + this.field_1286_a.field_1407_d;
         this.field_1283_d.field_1407_d -= var7 * 1.2F - var8 * 0.4F;
         this.field_1282_e.field_1407_d -= var7 * 1.2F - var8 * 0.4F;
         this.field_1283_d.field_1405_f += MathHelper.func_1114_b(p_863_3_ * 0.09F) * 0.05F + 0.05F;
         this.field_1282_e.field_1405_f -= MathHelper.func_1114_b(p_863_3_ * 0.09F) * 0.05F + 0.05F;
         this.field_1283_d.field_1407_d += MathHelper.func_1106_a(p_863_3_ * 0.067F) * 0.05F;
         this.field_1282_e.field_1407_d -= MathHelper.func_1106_a(p_863_3_ * 0.067F) * 0.05F;
      }

   }

   public void func_20095_a(float p_20095_1_) {
      this.field_20098_h.field_1406_e = this.field_1286_a.field_1406_e;
      this.field_20098_h.field_1407_d = this.field_1286_a.field_1407_d;
      this.field_20098_h.field_1410_a = 0.0F;
      this.field_20098_h.field_1409_b = 0.0F;
      this.field_20098_h.func_922_a(p_20095_1_);
   }

   public void func_20096_b(float p_20096_1_) {
      this.field_20097_i.func_922_a(p_20096_1_);
   }
}
