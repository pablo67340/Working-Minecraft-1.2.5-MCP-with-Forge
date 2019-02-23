package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderLiving extends Render {

   protected ModelBase field_20920_e;
   protected ModelBase field_6332_f;


   public RenderLiving(ModelBase p_i315_1_, float p_i315_2_) {
      this.field_20920_e = p_i315_1_;
      this.field_9246_c = p_i315_2_;
   }

   public void func_4013_a(ModelBase p_4013_1_) {
      this.field_6332_f = p_4013_1_;
   }

   private float func_48418_a(float p_48418_1_, float p_48418_2_, float p_48418_3_) {
      float var4;
      for(var4 = p_48418_2_ - p_48418_1_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return p_48418_1_ + p_48418_3_ * var4;
   }

   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      GL11.glPushMatrix();
      GL11.glDisable(2884);
      this.field_20920_e.field_1244_k = this.func_167_c(p_171_1_, p_171_9_);
      if(this.field_6332_f != null) {
         this.field_6332_f.field_1244_k = this.field_20920_e.field_1244_k;
      }

      this.field_20920_e.field_1243_l = p_171_1_.func_21063_V();
      if(this.field_6332_f != null) {
         this.field_6332_f.field_1243_l = this.field_20920_e.field_1243_l;
      }

      this.field_20920_e.field_40301_k = p_171_1_.func_40127_l();
      if(this.field_6332_f != null) {
         this.field_6332_f.field_40301_k = this.field_20920_e.field_40301_k;
      }

      try {
         float var10 = this.func_48418_a(p_171_1_.field_734_o, p_171_1_.field_735_n, p_171_9_);
         float var11 = this.func_48418_a(p_171_1_.field_46016_bg, p_171_1_.field_46015_bf, p_171_9_);
         float var12 = p_171_1_.field_602_at + (p_171_1_.field_604_ar - p_171_1_.field_602_at) * p_171_9_;
         this.func_22012_b(p_171_1_, p_171_2_, p_171_4_, p_171_6_);
         float var13 = this.func_170_d(p_171_1_, p_171_9_);
         this.func_21004_a(p_171_1_, var13, var10, p_171_9_);
         float var14 = 0.0625F;
         GL11.glEnable('\u803a');
         GL11.glScalef(-1.0F, -1.0F, 1.0F);
         this.func_6330_a(p_171_1_, p_171_9_);
         GL11.glTranslatef(0.0F, -24.0F * var14 - 0.0078125F, 0.0F);
         float var15 = p_171_1_.field_705_Q + (p_171_1_.field_704_R - p_171_1_.field_705_Q) * p_171_9_;
         float var16 = p_171_1_.field_703_S - p_171_1_.field_704_R * (1.0F - p_171_9_);
         if(p_171_1_.func_40127_l()) {
            var16 *= 3.0F;
         }

         if(var15 > 1.0F) {
            var15 = 1.0F;
         }

         GL11.glEnable(3008);
         this.field_20920_e.func_25103_a(p_171_1_, var16, var15, p_171_9_);
         this.func_40270_a(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);

         int var18;
         float var19;
         float var20;
         float var22;
         for(int var17 = 0; var17 < 4; ++var17) {
            var18 = this.func_166_a(p_171_1_, var17, p_171_9_);
            if(var18 > 0) {
               this.field_6332_f.func_25103_a(p_171_1_, var16, var15, p_171_9_);
               this.field_6332_f.func_864_b(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);
               if(var18 == 15) {
                  var19 = (float)p_171_1_.field_9311_be + p_171_9_;
                  this.func_151_a("%blur%/misc/glint.png");
                  GL11.glEnable(3042);
                  var20 = 0.5F;
                  GL11.glColor4f(var20, var20, var20, 1.0F);
                  GL11.glDepthFunc(514);
                  GL11.glDepthMask(false);

                  for(int var21 = 0; var21 < 2; ++var21) {
                     GL11.glDisable(2896);
                     var22 = 0.76F;
                     GL11.glColor4f(0.5F * var22, 0.25F * var22, 0.8F * var22, 1.0F);
                     GL11.glBlendFunc(768, 1);
                     GL11.glMatrixMode(5890);
                     GL11.glLoadIdentity();
                     float var23 = var19 * (0.001F + (float)var21 * 0.003F) * 20.0F;
                     float var24 = 0.33333334F;
                     GL11.glScalef(var24, var24, var24);
                     GL11.glRotatef(30.0F - (float)var21 * 60.0F, 0.0F, 0.0F, 1.0F);
                     GL11.glTranslatef(0.0F, var23, 0.0F);
                     GL11.glMatrixMode(5888);
                     this.field_6332_f.func_864_b(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);
                  }

                  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  GL11.glMatrixMode(5890);
                  GL11.glDepthMask(true);
                  GL11.glLoadIdentity();
                  GL11.glMatrixMode(5888);
                  GL11.glEnable(2896);
                  GL11.glDisable(3042);
                  GL11.glDepthFunc(515);
               }

               GL11.glDisable(3042);
               GL11.glEnable(3008);
            }
         }

         this.func_6331_b(p_171_1_, p_171_9_);
         float var26 = p_171_1_.func_382_a(p_171_9_);
         var18 = this.func_173_a(p_171_1_, var26, p_171_9_);
         OpenGlHelper.func_40452_a(OpenGlHelper.field_40455_b);
         GL11.glDisable(3553);
         OpenGlHelper.func_40452_a(OpenGlHelper.field_40457_a);
         if((var18 >> 24 & 255) > 0 || p_171_1_.field_715_G > 0 || p_171_1_.field_712_J > 0) {
            GL11.glDisable(3553);
            GL11.glDisable(3008);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glDepthFunc(514);
            if(p_171_1_.field_715_G > 0 || p_171_1_.field_712_J > 0) {
               GL11.glColor4f(var26, 0.0F, 0.0F, 0.4F);
               this.field_20920_e.func_864_b(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);

               for(int var27 = 0; var27 < 4; ++var27) {
                  if(this.func_27005_b(p_171_1_, var27, p_171_9_) >= 0) {
                     GL11.glColor4f(var26, 0.0F, 0.0F, 0.4F);
                     this.field_6332_f.func_864_b(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);
                  }
               }
            }

            if((var18 >> 24 & 255) > 0) {
               var19 = (float)(var18 >> 16 & 255) / 255.0F;
               var20 = (float)(var18 >> 8 & 255) / 255.0F;
               float var28 = (float)(var18 & 255) / 255.0F;
               var22 = (float)(var18 >> 24 & 255) / 255.0F;
               GL11.glColor4f(var19, var20, var28, var22);
               this.field_20920_e.func_864_b(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);

               for(int var29 = 0; var29 < 4; ++var29) {
                  if(this.func_27005_b(p_171_1_, var29, p_171_9_) >= 0) {
                     GL11.glColor4f(var19, var20, var28, var22);
                     this.field_6332_f.func_864_b(p_171_1_, var16, var15, var13, var11 - var10, var12, var14);
                  }
               }
            }

            GL11.glDepthFunc(515);
            GL11.glDisable(3042);
            GL11.glEnable(3008);
            GL11.glEnable(3553);
         }

         GL11.glDisable('\u803a');
      } catch (Exception var25) {
         var25.printStackTrace();
      }

      OpenGlHelper.func_40452_a(OpenGlHelper.field_40455_b);
      GL11.glEnable(3553);
      OpenGlHelper.func_40452_a(OpenGlHelper.field_40457_a);
      GL11.glEnable(2884);
      GL11.glPopMatrix();
      this.func_22014_a(p_171_1_, p_171_2_, p_171_4_, p_171_6_);
   }

   protected void func_40270_a(EntityLiving p_40270_1_, float p_40270_2_, float p_40270_3_, float p_40270_4_, float p_40270_5_, float p_40270_6_, float p_40270_7_) {
      this.func_140_a(p_40270_1_.field_20047_bv, p_40270_1_.func_6376_z());
      this.field_20920_e.func_864_b(p_40270_1_, p_40270_2_, p_40270_3_, p_40270_4_, p_40270_5_, p_40270_6_, p_40270_7_);
   }

   protected void func_22012_b(EntityLiving p_22012_1_, double p_22012_2_, double p_22012_4_, double p_22012_6_) {
      GL11.glTranslatef((float)p_22012_2_, (float)p_22012_4_, (float)p_22012_6_);
   }

   protected void func_21004_a(EntityLiving p_21004_1_, float p_21004_2_, float p_21004_3_, float p_21004_4_) {
      GL11.glRotatef(180.0F - p_21004_3_, 0.0F, 1.0F, 0.0F);
      if(p_21004_1_.field_712_J > 0) {
         float var5 = ((float)p_21004_1_.field_712_J + p_21004_4_ - 1.0F) / 20.0F * 1.6F;
         var5 = MathHelper.func_1113_c(var5);
         if(var5 > 1.0F) {
            var5 = 1.0F;
         }

         GL11.glRotatef(var5 * this.func_172_a(p_21004_1_), 0.0F, 0.0F, 1.0F);
      }

   }

   protected float func_167_c(EntityLiving p_167_1_, float p_167_2_) {
      return p_167_1_.func_431_d(p_167_2_);
   }

   protected float func_170_d(EntityLiving p_170_1_, float p_170_2_) {
      return (float)p_170_1_.field_9311_be + p_170_2_;
   }

   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {}

   protected int func_27005_b(EntityLiving p_27005_1_, int p_27005_2_, float p_27005_3_) {
      return this.func_166_a(p_27005_1_, p_27005_2_, p_27005_3_);
   }

   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return -1;
   }

   protected float func_172_a(EntityLiving p_172_1_) {
      return 90.0F;
   }

   protected int func_173_a(EntityLiving p_173_1_, float p_173_2_, float p_173_3_) {
      return 0;
   }

   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {}

   protected void func_22014_a(EntityLiving p_22014_1_, double p_22014_2_, double p_22014_4_, double p_22014_6_) {
      if(Minecraft.func_22007_w()) {
         ;
      }

   }

   protected void func_22013_a(EntityLiving p_22013_1_, String p_22013_2_, double p_22013_3_, double p_22013_5_, double p_22013_7_, int p_22013_9_) {
      float var10 = p_22013_1_.func_379_d(this.field_191_a.field_22188_h);
      if(var10 <= (float)p_22013_9_) {
         FontRenderer var11 = this.func_6329_a();
         float var12 = 1.6F;
         float var13 = 0.016666668F * var12;
         GL11.glPushMatrix();
         GL11.glTranslatef((float)p_22013_3_ + 0.0F, (float)p_22013_5_ + 2.3F, (float)p_22013_7_);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
         GL11.glScalef(-var13, -var13, var13);
         GL11.glDisable(2896);
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         Tessellator var14 = Tessellator.field_1512_a;
         byte var15 = 0;
         if(p_22013_2_.equals("deadmau5")) {
            var15 = -10;
         }

         GL11.glDisable(3553);
         var14.func_977_b();
         int var16 = var11.func_871_a(p_22013_2_) / 2;
         var14.func_986_a(0.0F, 0.0F, 0.0F, 0.25F);
         var14.func_991_a((double)(-var16 - 1), (double)(-1 + var15), 0.0D);
         var14.func_991_a((double)(-var16 - 1), (double)(8 + var15), 0.0D);
         var14.func_991_a((double)(var16 + 1), (double)(8 + var15), 0.0D);
         var14.func_991_a((double)(var16 + 1), (double)(-1 + var15), 0.0D);
         var14.func_982_a();
         GL11.glEnable(3553);
         var11.func_873_b(p_22013_2_, -var11.func_871_a(p_22013_2_) / 2, var15, 553648127);
         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         var11.func_873_b(p_22013_2_, -var11.func_871_a(p_22013_2_) / 2, var15, -1);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_171_a((EntityLiving)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
