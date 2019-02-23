package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSpider extends ModelBase {

   public ModelRenderer field_1255_a;
   public ModelRenderer field_1254_b;
   public ModelRenderer field_1253_c;
   public ModelRenderer field_1252_d;
   public ModelRenderer field_1251_e;
   public ModelRenderer field_1250_f;
   public ModelRenderer field_1249_g;
   public ModelRenderer field_1248_h;
   public ModelRenderer field_1247_i;
   public ModelRenderer field_1246_j;
   public ModelRenderer field_1245_m;


   public ModelSpider() {
      float var1 = 0.0F;
      byte var2 = 15;
      this.field_1255_a = new ModelRenderer(this, 32, 4);
      this.field_1255_a.func_923_a(-4.0F, -4.0F, -8.0F, 8, 8, 8, var1);
      this.field_1255_a.func_925_a(0.0F, (float)var2, -3.0F);
      this.field_1254_b = new ModelRenderer(this, 0, 0);
      this.field_1254_b.func_923_a(-3.0F, -3.0F, -3.0F, 6, 6, 6, var1);
      this.field_1254_b.func_925_a(0.0F, (float)var2, 0.0F);
      this.field_1253_c = new ModelRenderer(this, 0, 12);
      this.field_1253_c.func_923_a(-5.0F, -4.0F, -6.0F, 10, 8, 12, var1);
      this.field_1253_c.func_925_a(0.0F, (float)var2, 9.0F);
      this.field_1252_d = new ModelRenderer(this, 18, 0);
      this.field_1252_d.func_923_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1252_d.func_925_a(-4.0F, (float)var2, 2.0F);
      this.field_1251_e = new ModelRenderer(this, 18, 0);
      this.field_1251_e.func_923_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1251_e.func_925_a(4.0F, (float)var2, 2.0F);
      this.field_1250_f = new ModelRenderer(this, 18, 0);
      this.field_1250_f.func_923_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1250_f.func_925_a(-4.0F, (float)var2, 1.0F);
      this.field_1249_g = new ModelRenderer(this, 18, 0);
      this.field_1249_g.func_923_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1249_g.func_925_a(4.0F, (float)var2, 1.0F);
      this.field_1248_h = new ModelRenderer(this, 18, 0);
      this.field_1248_h.func_923_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1248_h.func_925_a(-4.0F, (float)var2, 0.0F);
      this.field_1247_i = new ModelRenderer(this, 18, 0);
      this.field_1247_i.func_923_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1247_i.func_925_a(4.0F, (float)var2, 0.0F);
      this.field_1246_j = new ModelRenderer(this, 18, 0);
      this.field_1246_j.func_923_a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1246_j.func_925_a(-4.0F, (float)var2, -1.0F);
      this.field_1245_m = new ModelRenderer(this, 18, 0);
      this.field_1245_m.func_923_a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.field_1245_m.func_925_a(4.0F, (float)var2, -1.0F);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_1255_a.func_922_a(p_864_7_);
      this.field_1254_b.func_922_a(p_864_7_);
      this.field_1253_c.func_922_a(p_864_7_);
      this.field_1252_d.func_922_a(p_864_7_);
      this.field_1251_e.func_922_a(p_864_7_);
      this.field_1250_f.func_922_a(p_864_7_);
      this.field_1249_g.func_922_a(p_864_7_);
      this.field_1248_h.func_922_a(p_864_7_);
      this.field_1247_i.func_922_a(p_864_7_);
      this.field_1246_j.func_922_a(p_864_7_);
      this.field_1245_m.func_922_a(p_864_7_);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      this.field_1255_a.field_1406_e = p_863_4_ / 57.295776F;
      this.field_1255_a.field_1407_d = p_863_5_ / 57.295776F;
      float var7 = 0.7853982F;
      this.field_1252_d.field_1405_f = -var7;
      this.field_1251_e.field_1405_f = var7;
      this.field_1250_f.field_1405_f = -var7 * 0.74F;
      this.field_1249_g.field_1405_f = var7 * 0.74F;
      this.field_1248_h.field_1405_f = -var7 * 0.74F;
      this.field_1247_i.field_1405_f = var7 * 0.74F;
      this.field_1246_j.field_1405_f = -var7;
      this.field_1245_m.field_1405_f = var7;
      float var8 = -0.0F;
      float var9 = 0.3926991F;
      this.field_1252_d.field_1406_e = var9 * 2.0F + var8;
      this.field_1251_e.field_1406_e = -var9 * 2.0F - var8;
      this.field_1250_f.field_1406_e = var9 * 1.0F + var8;
      this.field_1249_g.field_1406_e = -var9 * 1.0F - var8;
      this.field_1248_h.field_1406_e = -var9 * 1.0F + var8;
      this.field_1247_i.field_1406_e = var9 * 1.0F - var8;
      this.field_1246_j.field_1406_e = -var9 * 2.0F + var8;
      this.field_1245_m.field_1406_e = var9 * 2.0F - var8;
      float var10 = -(MathHelper.func_1114_b(p_863_1_ * 0.6662F * 2.0F + 0.0F) * 0.4F) * p_863_2_;
      float var11 = -(MathHelper.func_1114_b(p_863_1_ * 0.6662F * 2.0F + 3.1415927F) * 0.4F) * p_863_2_;
      float var12 = -(MathHelper.func_1114_b(p_863_1_ * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * p_863_2_;
      float var13 = -(MathHelper.func_1114_b(p_863_1_ * 0.6662F * 2.0F + 4.712389F) * 0.4F) * p_863_2_;
      float var14 = Math.abs(MathHelper.func_1106_a(p_863_1_ * 0.6662F + 0.0F) * 0.4F) * p_863_2_;
      float var15 = Math.abs(MathHelper.func_1106_a(p_863_1_ * 0.6662F + 3.1415927F) * 0.4F) * p_863_2_;
      float var16 = Math.abs(MathHelper.func_1106_a(p_863_1_ * 0.6662F + 1.5707964F) * 0.4F) * p_863_2_;
      float var17 = Math.abs(MathHelper.func_1106_a(p_863_1_ * 0.6662F + 4.712389F) * 0.4F) * p_863_2_;
      this.field_1252_d.field_1406_e += var10;
      this.field_1251_e.field_1406_e += -var10;
      this.field_1250_f.field_1406_e += var11;
      this.field_1249_g.field_1406_e += -var11;
      this.field_1248_h.field_1406_e += var12;
      this.field_1247_i.field_1406_e += -var12;
      this.field_1246_j.field_1406_e += var13;
      this.field_1245_m.field_1406_e += -var13;
      this.field_1252_d.field_1405_f += var14;
      this.field_1251_e.field_1405_f += -var14;
      this.field_1250_f.field_1405_f += var15;
      this.field_1249_g.field_1405_f += -var15;
      this.field_1248_h.field_1405_f += var16;
      this.field_1247_i.field_1405_f += -var16;
      this.field_1246_j.field_1405_f += var17;
      this.field_1245_m.field_1405_f += -var17;
   }
}
