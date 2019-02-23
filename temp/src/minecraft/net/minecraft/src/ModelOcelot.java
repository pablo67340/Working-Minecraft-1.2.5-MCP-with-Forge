package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class ModelOcelot extends ModelBase {

   ModelRenderer field_48225_a;
   ModelRenderer field_48223_b;
   ModelRenderer field_48224_c;
   ModelRenderer field_48221_d;
   ModelRenderer field_48222_e;
   ModelRenderer field_48219_f;
   ModelRenderer field_48220_g;
   ModelRenderer field_48226_n;
   int field_48227_o = 1;


   public ModelOcelot() {
      this.func_40298_a("head.main", 0, 0);
      this.func_40298_a("head.nose", 0, 24);
      this.func_40298_a("head.ear1", 0, 10);
      this.func_40298_a("head.ear2", 6, 10);
      this.field_48220_g = new ModelRenderer(this, "head");
      this.field_48220_g.func_40603_a("main", -2.5F, -2.0F, -3.0F, 5, 4, 5);
      this.field_48220_g.func_40603_a("nose", -1.5F, 0.0F, -4.0F, 3, 2, 2);
      this.field_48220_g.func_40603_a("ear1", -2.0F, -3.0F, 0.0F, 1, 1, 2);
      this.field_48220_g.func_40603_a("ear2", 1.0F, -3.0F, 0.0F, 1, 1, 2);
      this.field_48220_g.func_925_a(0.0F, 15.0F, -9.0F);
      this.field_48226_n = new ModelRenderer(this, 20, 0);
      this.field_48226_n.func_923_a(-2.0F, 3.0F, -8.0F, 4, 16, 6, 0.0F);
      this.field_48226_n.func_925_a(0.0F, 12.0F, -10.0F);
      this.field_48222_e = new ModelRenderer(this, 0, 15);
      this.field_48222_e.func_40604_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
      this.field_48222_e.field_1407_d = 0.9F;
      this.field_48222_e.func_925_a(0.0F, 15.0F, 8.0F);
      this.field_48219_f = new ModelRenderer(this, 4, 15);
      this.field_48219_f.func_40604_a(-0.5F, 0.0F, 0.0F, 1, 8, 1);
      this.field_48219_f.func_925_a(0.0F, 20.0F, 14.0F);
      this.field_48225_a = new ModelRenderer(this, 8, 13);
      this.field_48225_a.func_40604_a(-1.0F, 0.0F, 1.0F, 2, 6, 2);
      this.field_48225_a.func_925_a(1.1F, 18.0F, 5.0F);
      this.field_48223_b = new ModelRenderer(this, 8, 13);
      this.field_48223_b.func_40604_a(-1.0F, 0.0F, 1.0F, 2, 6, 2);
      this.field_48223_b.func_925_a(-1.1F, 18.0F, 5.0F);
      this.field_48224_c = new ModelRenderer(this, 40, 0);
      this.field_48224_c.func_40604_a(-1.0F, 0.0F, 0.0F, 2, 10, 2);
      this.field_48224_c.func_925_a(1.2F, 13.8F, -5.0F);
      this.field_48221_d = new ModelRenderer(this, 40, 0);
      this.field_48221_d.func_40604_a(-1.0F, 0.0F, 0.0F, 2, 10, 2);
      this.field_48221_d.func_925_a(-1.2F, 13.8F, -5.0F);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      if(this.field_40301_k) {
         float var8 = 2.0F;
         GL11.glPushMatrix();
         GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
         GL11.glTranslatef(0.0F, 10.0F * p_864_7_, 4.0F * p_864_7_);
         this.field_48220_g.func_922_a(p_864_7_);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GL11.glTranslatef(0.0F, 24.0F * p_864_7_, 0.0F);
         this.field_48226_n.func_922_a(p_864_7_);
         this.field_48225_a.func_922_a(p_864_7_);
         this.field_48223_b.func_922_a(p_864_7_);
         this.field_48224_c.func_922_a(p_864_7_);
         this.field_48221_d.func_922_a(p_864_7_);
         this.field_48222_e.func_922_a(p_864_7_);
         this.field_48219_f.func_922_a(p_864_7_);
         GL11.glPopMatrix();
      } else {
         this.field_48220_g.func_922_a(p_864_7_);
         this.field_48226_n.func_922_a(p_864_7_);
         this.field_48222_e.func_922_a(p_864_7_);
         this.field_48219_f.func_922_a(p_864_7_);
         this.field_48225_a.func_922_a(p_864_7_);
         this.field_48223_b.func_922_a(p_864_7_);
         this.field_48224_c.func_922_a(p_864_7_);
         this.field_48221_d.func_922_a(p_864_7_);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      this.field_48220_g.field_1407_d = p_863_5_ / 57.295776F;
      this.field_48220_g.field_1406_e = p_863_4_ / 57.295776F;
      if(this.field_48227_o != 3) {
         this.field_48226_n.field_1407_d = 1.5707964F;
         if(this.field_48227_o == 2) {
            this.field_48225_a.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 1.0F * p_863_2_;
            this.field_48223_b.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 0.3F) * 1.0F * p_863_2_;
            this.field_48224_c.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F + 0.3F) * 1.0F * p_863_2_;
            this.field_48221_d.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 1.0F * p_863_2_;
            this.field_48219_f.field_1407_d = 1.7278761F + 0.31415927F * MathHelper.func_1114_b(p_863_1_) * p_863_2_;
         } else {
            this.field_48225_a.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 1.0F * p_863_2_;
            this.field_48223_b.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 1.0F * p_863_2_;
            this.field_48224_c.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 1.0F * p_863_2_;
            this.field_48221_d.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 1.0F * p_863_2_;
            if(this.field_48227_o == 1) {
               this.field_48219_f.field_1407_d = 1.7278761F + 0.7853982F * MathHelper.func_1114_b(p_863_1_) * p_863_2_;
            } else {
               this.field_48219_f.field_1407_d = 1.7278761F + 0.47123894F * MathHelper.func_1114_b(p_863_1_) * p_863_2_;
            }
         }
      }

   }

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {
      EntityOcelot var5 = (EntityOcelot)p_25103_1_;
      this.field_48226_n.field_1409_b = 12.0F;
      this.field_48226_n.field_1408_c = -10.0F;
      this.field_48220_g.field_1409_b = 15.0F;
      this.field_48220_g.field_1408_c = -9.0F;
      this.field_48222_e.field_1409_b = 15.0F;
      this.field_48222_e.field_1408_c = 8.0F;
      this.field_48219_f.field_1409_b = 20.0F;
      this.field_48219_f.field_1408_c = 14.0F;
      this.field_48224_c.field_1409_b = this.field_48221_d.field_1409_b = 13.8F;
      this.field_48224_c.field_1408_c = this.field_48221_d.field_1408_c = -5.0F;
      this.field_48225_a.field_1409_b = this.field_48223_b.field_1409_b = 18.0F;
      this.field_48225_a.field_1408_c = this.field_48223_b.field_1408_c = 5.0F;
      this.field_48222_e.field_1407_d = 0.9F;
      if(var5.func_381_o()) {
         ++this.field_48226_n.field_1409_b;
         this.field_48220_g.field_1409_b += 2.0F;
         ++this.field_48222_e.field_1409_b;
         this.field_48219_f.field_1409_b += -4.0F;
         this.field_48219_f.field_1408_c += 2.0F;
         this.field_48222_e.field_1407_d = 1.5707964F;
         this.field_48219_f.field_1407_d = 1.5707964F;
         this.field_48227_o = 0;
      } else if(var5.func_35117_Q()) {
         this.field_48219_f.field_1409_b = this.field_48222_e.field_1409_b;
         this.field_48219_f.field_1408_c += 2.0F;
         this.field_48222_e.field_1407_d = 1.5707964F;
         this.field_48219_f.field_1407_d = 1.5707964F;
         this.field_48227_o = 2;
      } else if(var5.func_48141_af()) {
         this.field_48226_n.field_1407_d = 0.7853982F;
         this.field_48226_n.field_1409_b += -4.0F;
         this.field_48226_n.field_1408_c += 5.0F;
         this.field_48220_g.field_1409_b += -3.3F;
         ++this.field_48220_g.field_1408_c;
         this.field_48222_e.field_1409_b += 8.0F;
         this.field_48222_e.field_1408_c += -2.0F;
         this.field_48219_f.field_1409_b += 2.0F;
         this.field_48219_f.field_1408_c += -0.8F;
         this.field_48222_e.field_1407_d = 1.7278761F;
         this.field_48219_f.field_1407_d = 2.670354F;
         this.field_48224_c.field_1407_d = this.field_48221_d.field_1407_d = -0.15707964F;
         this.field_48224_c.field_1409_b = this.field_48221_d.field_1409_b = 15.8F;
         this.field_48224_c.field_1408_c = this.field_48221_d.field_1408_c = -7.0F;
         this.field_48225_a.field_1407_d = this.field_48223_b.field_1407_d = -1.5707964F;
         this.field_48225_a.field_1409_b = this.field_48223_b.field_1409_b = 21.0F;
         this.field_48225_a.field_1408_c = this.field_48223_b.field_1408_c = 1.0F;
         this.field_48227_o = 3;
      } else {
         this.field_48227_o = 1;
      }

   }
}
