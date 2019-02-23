package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class ModelQuadruped extends ModelBase {

   public ModelRenderer field_1266_d = new ModelRenderer(this, 0, 0);
   public ModelRenderer field_1265_e;
   public ModelRenderer field_1264_f;
   public ModelRenderer field_1263_g;
   public ModelRenderer field_1262_h;
   public ModelRenderer field_1261_i;
   protected float field_40331_g = 8.0F;
   protected float field_40332_n = 4.0F;


   public ModelQuadruped(int p_i408_1_, float p_i408_2_) {
      this.field_1266_d.func_923_a(-4.0F, -4.0F, -8.0F, 8, 8, 8, p_i408_2_);
      this.field_1266_d.func_925_a(0.0F, (float)(18 - p_i408_1_), -6.0F);
      this.field_1265_e = new ModelRenderer(this, 28, 8);
      this.field_1265_e.func_923_a(-5.0F, -10.0F, -7.0F, 10, 16, 8, p_i408_2_);
      this.field_1265_e.func_925_a(0.0F, (float)(17 - p_i408_1_), 2.0F);
      this.field_1264_f = new ModelRenderer(this, 0, 16);
      this.field_1264_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, p_i408_1_, 4, p_i408_2_);
      this.field_1264_f.func_925_a(-3.0F, (float)(24 - p_i408_1_), 7.0F);
      this.field_1263_g = new ModelRenderer(this, 0, 16);
      this.field_1263_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, p_i408_1_, 4, p_i408_2_);
      this.field_1263_g.func_925_a(3.0F, (float)(24 - p_i408_1_), 7.0F);
      this.field_1262_h = new ModelRenderer(this, 0, 16);
      this.field_1262_h.func_923_a(-2.0F, 0.0F, -2.0F, 4, p_i408_1_, 4, p_i408_2_);
      this.field_1262_h.func_925_a(-3.0F, (float)(24 - p_i408_1_), -5.0F);
      this.field_1261_i = new ModelRenderer(this, 0, 16);
      this.field_1261_i.func_923_a(-2.0F, 0.0F, -2.0F, 4, p_i408_1_, 4, p_i408_2_);
      this.field_1261_i.func_925_a(3.0F, (float)(24 - p_i408_1_), -5.0F);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      if(this.field_40301_k) {
         float var8 = 2.0F;
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, this.field_40331_g * p_864_7_, this.field_40332_n * p_864_7_);
         this.field_1266_d.func_922_a(p_864_7_);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GL11.glTranslatef(0.0F, 24.0F * p_864_7_, 0.0F);
         this.field_1265_e.func_922_a(p_864_7_);
         this.field_1264_f.func_922_a(p_864_7_);
         this.field_1263_g.func_922_a(p_864_7_);
         this.field_1262_h.func_922_a(p_864_7_);
         this.field_1261_i.func_922_a(p_864_7_);
         GL11.glPopMatrix();
      } else {
         this.field_1266_d.func_922_a(p_864_7_);
         this.field_1265_e.func_922_a(p_864_7_);
         this.field_1264_f.func_922_a(p_864_7_);
         this.field_1263_g.func_922_a(p_864_7_);
         this.field_1262_h.func_922_a(p_864_7_);
         this.field_1261_i.func_922_a(p_864_7_);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      this.field_1266_d.field_1407_d = p_863_5_ / 57.295776F;
      this.field_1266_d.field_1406_e = p_863_4_ / 57.295776F;
      this.field_1265_e.field_1407_d = 1.5707964F;
      this.field_1264_f.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 1.4F * p_863_2_;
      this.field_1263_g.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 1.4F * p_863_2_;
      this.field_1262_h.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F + 3.1415927F) * 1.4F * p_863_2_;
      this.field_1261_i.field_1407_d = MathHelper.func_1114_b(p_863_1_ * 0.6662F) * 1.4F * p_863_2_;
   }
}
