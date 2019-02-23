package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class ModelWolf extends ModelBase {

   public ModelRenderer field_25114_a;
   public ModelRenderer field_25113_b;
   public ModelRenderer field_25112_c;
   public ModelRenderer field_25111_d;
   public ModelRenderer field_25110_e;
   public ModelRenderer field_25109_f;
   ModelRenderer field_25105_j;
   ModelRenderer field_25104_k;


   public ModelWolf() {
      float var1 = 0.0F;
      float var2 = 13.5F;
      this.field_25114_a = new ModelRenderer(this, 0, 0);
      this.field_25114_a.func_923_a(-3.0F, -3.0F, -2.0F, 6, 6, 4, var1);
      this.field_25114_a.func_925_a(-1.0F, var2, -7.0F);
      this.field_25113_b = new ModelRenderer(this, 18, 14);
      this.field_25113_b.func_923_a(-4.0F, -2.0F, -3.0F, 6, 9, 6, var1);
      this.field_25113_b.func_925_a(0.0F, 14.0F, 2.0F);
      this.field_25104_k = new ModelRenderer(this, 21, 0);
      this.field_25104_k.func_923_a(-4.0F, -3.0F, -3.0F, 8, 6, 7, var1);
      this.field_25104_k.func_925_a(-1.0F, 14.0F, 2.0F);
      this.field_25112_c = new ModelRenderer(this, 0, 18);
      this.field_25112_c.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.field_25112_c.func_925_a(-2.5F, 16.0F, 7.0F);
      this.field_25111_d = new ModelRenderer(this, 0, 18);
      this.field_25111_d.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.field_25111_d.func_925_a(0.5F, 16.0F, 7.0F);
      this.field_25110_e = new ModelRenderer(this, 0, 18);
      this.field_25110_e.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.field_25110_e.func_925_a(-2.5F, 16.0F, -4.0F);
      this.field_25109_f = new ModelRenderer(this, 0, 18);
      this.field_25109_f.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.field_25109_f.func_925_a(0.5F, 16.0F, -4.0F);
      this.field_25105_j = new ModelRenderer(this, 9, 18);
      this.field_25105_j.func_923_a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.field_25105_j.func_925_a(-1.0F, 12.0F, 8.0F);
      this.field_25114_a.func_40602_a(16, 14).func_923_a(-3.0F, -5.0F, 0.0F, 2, 2, 1, var1);
      this.field_25114_a.func_40602_a(16, 14).func_923_a(1.0F, -5.0F, 0.0F, 2, 2, 1, var1);
      this.field_25114_a.func_40602_a(0, 10).func_923_a(-1.5F, 0.0F, -5.0F, 3, 3, 4, var1);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      super.func_864_b(p_864_1_, p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      if(this.field_40301_k) {
         float var8 = 2.0F;
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 5.0F * p_864_7_, 2.0F * p_864_7_);
         this.field_25114_a.func_25122_b(p_864_7_);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GL11.glTranslatef(0.0F, 24.0F * p_864_7_, 0.0F);
         this.field_25113_b.func_922_a(p_864_7_);
         this.field_25112_c.func_922_a(p_864_7_);
         this.field_25111_d.func_922_a(p_864_7_);
         this.field_25110_e.func_922_a(p_864_7_);
         this.field_25109_f.func_922_a(p_864_7_);
         this.field_25105_j.func_25122_b(p_864_7_);
         this.field_25104_k.func_922_a(p_864_7_);
         GL11.glPopMatrix();
      } else {
         this.field_25114_a.func_25122_b(p_864_7_);
         this.field_25113_b.func_922_a(p_864_7_);
         this.field_25112_c.func_922_a(p_864_7_);
         this.field_25111_d.func_922_a(p_864_7_);
         this.field_25110_e.func_922_a(p_864_7_);
         this.field_25109_f.func_922_a(p_864_7_);
         this.field_25105_j.func_25122_b(p_864_7_);
         this.field_25104_k.func_922_a(p_864_7_);
      }

   }

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {
      EntityWolf var5 = (EntityWolf)p_25103_1_;
      if(var5.func_25040_C()) {
         this.field_25105_j.field_1406_e = 0.0F;
      } else {
         this.field_25105_j.field_1406_e = MathHelper.func_1114_b(p_25103_2_ * 0.6662F) * 1.4F * p_25103_3_;
      }

      if(var5.func_48141_af()) {
         this.field_25104_k.func_925_a(-1.0F, 16.0F, -3.0F);
         this.field_25104_k.field_1407_d = 1.2566371F;
         this.field_25104_k.field_1406_e = 0.0F;
         this.field_25113_b.func_925_a(0.0F, 18.0F, 0.0F);
         this.field_25113_b.field_1407_d = 0.7853982F;
         this.field_25105_j.func_925_a(-1.0F, 21.0F, 6.0F);
         this.field_25112_c.func_925_a(-2.5F, 22.0F, 2.0F);
         this.field_25112_c.field_1407_d = 4.712389F;
         this.field_25111_d.func_925_a(0.5F, 22.0F, 2.0F);
         this.field_25111_d.field_1407_d = 4.712389F;
         this.field_25110_e.field_1407_d = 5.811947F;
         this.field_25110_e.func_925_a(-2.49F, 17.0F, -4.0F);
         this.field_25109_f.field_1407_d = 5.811947F;
         this.field_25109_f.func_925_a(0.51F, 17.0F, -4.0F);
      } else {
         this.field_25113_b.func_925_a(0.0F, 14.0F, 2.0F);
         this.field_25113_b.field_1407_d = 1.5707964F;
         this.field_25104_k.func_925_a(-1.0F, 14.0F, -3.0F);
         this.field_25104_k.field_1407_d = this.field_25113_b.field_1407_d;
         this.field_25105_j.func_925_a(-1.0F, 12.0F, 8.0F);
         this.field_25112_c.func_925_a(-2.5F, 16.0F, 7.0F);
         this.field_25111_d.func_925_a(0.5F, 16.0F, 7.0F);
         this.field_25110_e.func_925_a(-2.5F, 16.0F, -4.0F);
         this.field_25109_f.func_925_a(0.5F, 16.0F, -4.0F);
         this.field_25112_c.field_1407_d = MathHelper.func_1114_b(p_25103_2_ * 0.6662F) * 1.4F * p_25103_3_;
         this.field_25111_d.field_1407_d = MathHelper.func_1114_b(p_25103_2_ * 0.6662F + 3.1415927F) * 1.4F * p_25103_3_;
         this.field_25110_e.field_1407_d = MathHelper.func_1114_b(p_25103_2_ * 0.6662F + 3.1415927F) * 1.4F * p_25103_3_;
         this.field_25109_f.field_1407_d = MathHelper.func_1114_b(p_25103_2_ * 0.6662F) * 1.4F * p_25103_3_;
      }

      this.field_25114_a.field_1405_f = var5.func_25033_c(p_25103_4_) + var5.func_25042_a(p_25103_4_, 0.0F);
      this.field_25104_k.field_1405_f = var5.func_25042_a(p_25103_4_, -0.08F);
      this.field_25113_b.field_1405_f = var5.func_25042_a(p_25103_4_, -0.16F);
      this.field_25105_j.field_1405_f = var5.func_25042_a(p_25103_4_, -0.2F);
      if(var5.func_25039_v()) {
         float var6 = var5.func_382_a(p_25103_4_) * var5.func_25043_b_(p_25103_4_);
         GL11.glColor3f(var6, var6, var6);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
      this.field_25114_a.field_1407_d = p_863_5_ / 57.295776F;
      this.field_25114_a.field_1406_e = p_863_4_ / 57.295776F;
      this.field_25105_j.field_1407_d = p_863_3_;
   }
}
