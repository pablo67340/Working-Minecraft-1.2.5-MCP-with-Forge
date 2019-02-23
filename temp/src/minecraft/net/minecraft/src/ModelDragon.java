package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class ModelDragon extends ModelBase {

   private ModelRenderer field_40314_a;
   private ModelRenderer field_40312_b;
   private ModelRenderer field_40313_c;
   private ModelRenderer field_40310_d;
   private ModelRenderer field_40311_e;
   private ModelRenderer field_40308_f;
   private ModelRenderer field_40309_g;
   private ModelRenderer field_40315_n;
   private ModelRenderer field_40316_o;
   private ModelRenderer field_40320_p;
   private ModelRenderer field_40319_q;
   private ModelRenderer field_40318_r;
   private float field_40317_s;


   public ModelDragon(float p_i186_1_) {
      this.field_40299_l = 256;
      this.field_40300_m = 256;
      this.func_40298_a("body.body", 0, 0);
      this.func_40298_a("wing.skin", -56, 88);
      this.func_40298_a("wingtip.skin", -56, 144);
      this.func_40298_a("rearleg.main", 0, 0);
      this.func_40298_a("rearfoot.main", 112, 0);
      this.func_40298_a("rearlegtip.main", 196, 0);
      this.func_40298_a("head.upperhead", 112, 30);
      this.func_40298_a("wing.bone", 112, 88);
      this.func_40298_a("head.upperlip", 176, 44);
      this.func_40298_a("jaw.jaw", 176, 65);
      this.func_40298_a("frontleg.main", 112, 104);
      this.func_40298_a("wingtip.bone", 112, 136);
      this.func_40298_a("frontfoot.main", 144, 104);
      this.func_40298_a("neck.box", 192, 104);
      this.func_40298_a("frontlegtip.main", 226, 138);
      this.func_40298_a("body.scale", 220, 53);
      this.func_40298_a("head.scale", 0, 0);
      this.func_40298_a("neck.scale", 48, 0);
      this.func_40298_a("head.nostril", 112, 0);
      float var2 = -16.0F;
      this.field_40314_a = new ModelRenderer(this, "head");
      this.field_40314_a.func_40603_a("upperlip", -6.0F, -1.0F, -8.0F + var2, 12, 5, 16);
      this.field_40314_a.func_40603_a("upperhead", -8.0F, -8.0F, 6.0F + var2, 16, 16, 16);
      this.field_40314_a.field_1404_g = true;
      this.field_40314_a.func_40603_a("scale", -5.0F, -12.0F, 12.0F + var2, 2, 4, 6);
      this.field_40314_a.func_40603_a("nostril", -5.0F, -3.0F, -6.0F + var2, 2, 2, 4);
      this.field_40314_a.field_1404_g = false;
      this.field_40314_a.func_40603_a("scale", 3.0F, -12.0F, 12.0F + var2, 2, 4, 6);
      this.field_40314_a.func_40603_a("nostril", 3.0F, -3.0F, -6.0F + var2, 2, 2, 4);
      this.field_40313_c = new ModelRenderer(this, "jaw");
      this.field_40313_c.func_925_a(0.0F, 4.0F, 8.0F + var2);
      this.field_40313_c.func_40603_a("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16);
      this.field_40314_a.func_35969_a(this.field_40313_c);
      this.field_40312_b = new ModelRenderer(this, "neck");
      this.field_40312_b.func_40603_a("box", -5.0F, -5.0F, -5.0F, 10, 10, 10);
      this.field_40312_b.func_40603_a("scale", -1.0F, -9.0F, -3.0F, 2, 4, 6);
      this.field_40310_d = new ModelRenderer(this, "body");
      this.field_40310_d.func_925_a(0.0F, 4.0F, 8.0F);
      this.field_40310_d.func_40603_a("body", -12.0F, 0.0F, -16.0F, 24, 24, 64);
      this.field_40310_d.func_40603_a("scale", -1.0F, -6.0F, -10.0F, 2, 6, 12);
      this.field_40310_d.func_40603_a("scale", -1.0F, -6.0F, 10.0F, 2, 6, 12);
      this.field_40310_d.func_40603_a("scale", -1.0F, -6.0F, 30.0F, 2, 6, 12);
      this.field_40319_q = new ModelRenderer(this, "wing");
      this.field_40319_q.func_925_a(-12.0F, 5.0F, 2.0F);
      this.field_40319_q.func_40603_a("bone", -56.0F, -4.0F, -4.0F, 56, 8, 8);
      this.field_40319_q.func_40603_a("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
      this.field_40318_r = new ModelRenderer(this, "wingtip");
      this.field_40318_r.func_925_a(-56.0F, 0.0F, 0.0F);
      this.field_40318_r.func_40603_a("bone", -56.0F, -2.0F, -2.0F, 56, 4, 4);
      this.field_40318_r.func_40603_a("skin", -56.0F, 0.0F, 2.0F, 56, 0, 56);
      this.field_40319_q.func_35969_a(this.field_40318_r);
      this.field_40308_f = new ModelRenderer(this, "frontleg");
      this.field_40308_f.func_925_a(-12.0F, 20.0F, 2.0F);
      this.field_40308_f.func_40603_a("main", -4.0F, -4.0F, -4.0F, 8, 24, 8);
      this.field_40315_n = new ModelRenderer(this, "frontlegtip");
      this.field_40315_n.func_925_a(0.0F, 20.0F, -1.0F);
      this.field_40315_n.func_40603_a("main", -3.0F, -1.0F, -3.0F, 6, 24, 6);
      this.field_40308_f.func_35969_a(this.field_40315_n);
      this.field_40320_p = new ModelRenderer(this, "frontfoot");
      this.field_40320_p.func_925_a(0.0F, 23.0F, 0.0F);
      this.field_40320_p.func_40603_a("main", -4.0F, 0.0F, -12.0F, 8, 4, 16);
      this.field_40315_n.func_35969_a(this.field_40320_p);
      this.field_40311_e = new ModelRenderer(this, "rearleg");
      this.field_40311_e.func_925_a(-16.0F, 16.0F, 42.0F);
      this.field_40311_e.func_40603_a("main", -8.0F, -4.0F, -8.0F, 16, 32, 16);
      this.field_40309_g = new ModelRenderer(this, "rearlegtip");
      this.field_40309_g.func_925_a(0.0F, 32.0F, -4.0F);
      this.field_40309_g.func_40603_a("main", -6.0F, -2.0F, 0.0F, 12, 32, 12);
      this.field_40311_e.func_35969_a(this.field_40309_g);
      this.field_40316_o = new ModelRenderer(this, "rearfoot");
      this.field_40316_o.func_925_a(0.0F, 31.0F, 4.0F);
      this.field_40316_o.func_40603_a("main", -9.0F, 0.0F, -20.0F, 18, 6, 24);
      this.field_40309_g.func_35969_a(this.field_40316_o);
   }

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {
      this.field_40317_s = p_25103_4_;
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      GL11.glPushMatrix();
      EntityDragon var8 = (EntityDragon)p_864_1_;
      float var9 = var8.field_40173_aw + (var8.field_40172_ax - var8.field_40173_aw) * this.field_40317_s;
      this.field_40313_c.field_1407_d = (float)(Math.sin((double)(var9 * 3.1415927F * 2.0F)) + 1.0D) * 0.2F;
      float var10 = (float)(Math.sin((double)(var9 * 3.1415927F * 2.0F - 1.0F)) + 1.0D);
      var10 = (var10 * var10 * 1.0F + var10 * 2.0F) * 0.05F;
      GL11.glTranslatef(0.0F, var10 - 2.0F, -3.0F);
      GL11.glRotatef(var10 * 2.0F, 1.0F, 0.0F, 0.0F);
      float var11 = -30.0F;
      float var13 = 0.0F;
      float var14 = 1.5F;
      double[] var15 = var8.func_40160_a(6, this.field_40317_s);
      float var16 = this.func_40307_a(var8.func_40160_a(5, this.field_40317_s)[0] - var8.func_40160_a(10, this.field_40317_s)[0]);
      float var17 = this.func_40307_a(var8.func_40160_a(5, this.field_40317_s)[0] + (double)(var16 / 2.0F));
      var11 += 2.0F;
      float var18 = var9 * 3.1415927F * 2.0F;
      var11 = 20.0F;
      float var12 = -12.0F;

      float var21;
      for(int var19 = 0; var19 < 5; ++var19) {
         double[] var20 = var8.func_40160_a(5 - var19, this.field_40317_s);
         var21 = (float)Math.cos((double)((float)var19 * 0.45F + var18)) * 0.15F;
         this.field_40312_b.field_1406_e = this.func_40307_a(var20[0] - var15[0]) * 3.1415927F / 180.0F * var14;
         this.field_40312_b.field_1407_d = var21 + (float)(var20[1] - var15[1]) * 3.1415927F / 180.0F * var14 * 5.0F;
         this.field_40312_b.field_1405_f = -this.func_40307_a(var20[0] - (double)var17) * 3.1415927F / 180.0F * var14;
         this.field_40312_b.field_1409_b = var11;
         this.field_40312_b.field_1408_c = var12;
         this.field_40312_b.field_1410_a = var13;
         var11 = (float)((double)var11 + Math.sin((double)this.field_40312_b.field_1407_d) * 10.0D);
         var12 = (float)((double)var12 - Math.cos((double)this.field_40312_b.field_1406_e) * Math.cos((double)this.field_40312_b.field_1407_d) * 10.0D);
         var13 = (float)((double)var13 - Math.sin((double)this.field_40312_b.field_1406_e) * Math.cos((double)this.field_40312_b.field_1407_d) * 10.0D);
         this.field_40312_b.func_922_a(p_864_7_);
      }

      this.field_40314_a.field_1409_b = var11;
      this.field_40314_a.field_1408_c = var12;
      this.field_40314_a.field_1410_a = var13;
      double[] var22 = var8.func_40160_a(0, this.field_40317_s);
      this.field_40314_a.field_1406_e = this.func_40307_a(var22[0] - var15[0]) * 3.1415927F / 180.0F * 1.0F;
      this.field_40314_a.field_1405_f = -this.func_40307_a(var22[0] - (double)var17) * 3.1415927F / 180.0F * 1.0F;
      this.field_40314_a.func_922_a(p_864_7_);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-var16 * var14 * 1.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(0.0F, -1.0F, 0.0F);
      this.field_40310_d.field_1405_f = 0.0F;
      this.field_40310_d.func_922_a(p_864_7_);

      for(int var23 = 0; var23 < 2; ++var23) {
         GL11.glEnable(2884);
         var21 = var9 * 3.1415927F * 2.0F;
         this.field_40319_q.field_1407_d = 0.125F - (float)Math.cos((double)var21) * 0.2F;
         this.field_40319_q.field_1406_e = 0.25F;
         this.field_40319_q.field_1405_f = (float)(Math.sin((double)var21) + 0.125D) * 0.8F;
         this.field_40318_r.field_1405_f = -((float)(Math.sin((double)(var21 + 2.0F)) + 0.5D)) * 0.75F;
         this.field_40311_e.field_1407_d = 1.0F + var10 * 0.1F;
         this.field_40309_g.field_1407_d = 0.5F + var10 * 0.1F;
         this.field_40316_o.field_1407_d = 0.75F + var10 * 0.1F;
         this.field_40308_f.field_1407_d = 1.3F + var10 * 0.1F;
         this.field_40315_n.field_1407_d = -0.5F - var10 * 0.1F;
         this.field_40320_p.field_1407_d = 0.75F + var10 * 0.1F;
         this.field_40319_q.func_922_a(p_864_7_);
         this.field_40308_f.func_922_a(p_864_7_);
         this.field_40311_e.func_922_a(p_864_7_);
         GL11.glScalef(-1.0F, 1.0F, 1.0F);
         if(var23 == 0) {
            GL11.glCullFace(1028);
         }
      }

      GL11.glPopMatrix();
      GL11.glCullFace(1029);
      GL11.glDisable(2884);
      float var24 = -((float)Math.sin((double)(var9 * 3.1415927F * 2.0F))) * 0.0F;
      var18 = var9 * 3.1415927F * 2.0F;
      var11 = 10.0F;
      var12 = 60.0F;
      var13 = 0.0F;
      var15 = var8.func_40160_a(11, this.field_40317_s);

      for(int var25 = 0; var25 < 12; ++var25) {
         var22 = var8.func_40160_a(12 + var25, this.field_40317_s);
         var24 = (float)((double)var24 + Math.sin((double)((float)var25 * 0.45F + var18)) * 0.05000000074505806D);
         this.field_40312_b.field_1406_e = (this.func_40307_a(var22[0] - var15[0]) * var14 + 180.0F) * 3.1415927F / 180.0F;
         this.field_40312_b.field_1407_d = var24 + (float)(var22[1] - var15[1]) * 3.1415927F / 180.0F * var14 * 5.0F;
         this.field_40312_b.field_1405_f = this.func_40307_a(var22[0] - (double)var17) * 3.1415927F / 180.0F * var14;
         this.field_40312_b.field_1409_b = var11;
         this.field_40312_b.field_1408_c = var12;
         this.field_40312_b.field_1410_a = var13;
         var11 = (float)((double)var11 + Math.sin((double)this.field_40312_b.field_1407_d) * 10.0D);
         var12 = (float)((double)var12 - Math.cos((double)this.field_40312_b.field_1406_e) * Math.cos((double)this.field_40312_b.field_1407_d) * 10.0D);
         var13 = (float)((double)var13 - Math.sin((double)this.field_40312_b.field_1406_e) * Math.cos((double)this.field_40312_b.field_1407_d) * 10.0D);
         this.field_40312_b.func_922_a(p_864_7_);
      }

      GL11.glPopMatrix();
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
   }

   private float func_40307_a(double p_40307_1_) {
      while(p_40307_1_ >= 180.0D) {
         p_40307_1_ -= 360.0D;
      }

      while(p_40307_1_ < -180.0D) {
         p_40307_1_ += 360.0D;
      }

      return (float)p_40307_1_;
   }
}
