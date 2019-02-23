package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelDragon;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderDragon extends RenderLiving {

   public static EntityDragon field_41038_a;
   private static int field_40284_d = 0;
   protected ModelDragon field_40285_c;


   public RenderDragon() {
      super(new ModelDragon(0.0F), 0.5F);
      this.field_40285_c = (ModelDragon)this.field_20920_e;
      this.func_4013_a(this.field_20920_e);
   }

   protected void func_40282_a(EntityDragon p_40282_1_, float p_40282_2_, float p_40282_3_, float p_40282_4_) {
      float var5 = (float)p_40282_1_.func_40160_a(7, p_40282_4_)[0];
      float var6 = (float)(p_40282_1_.func_40160_a(5, p_40282_4_)[1] - p_40282_1_.func_40160_a(10, p_40282_4_)[1]);
      GL11.glRotatef(-var5, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(var6 * 10.0F, 1.0F, 0.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.0F, 1.0F);
      if(p_40282_1_.field_712_J > 0) {
         float var7 = ((float)p_40282_1_.field_712_J + p_40282_4_ - 1.0F) / 20.0F * 1.6F;
         var7 = MathHelper.func_1113_c(var7);
         if(var7 > 1.0F) {
            var7 = 1.0F;
         }

         GL11.glRotatef(var7 * this.func_172_a(p_40282_1_), 0.0F, 0.0F, 1.0F);
      }

   }

   protected void func_40280_a(EntityDragon p_40280_1_, float p_40280_2_, float p_40280_3_, float p_40280_4_, float p_40280_5_, float p_40280_6_, float p_40280_7_) {
      if(p_40280_1_.field_40178_aA > 0) {
         float var8 = (float)p_40280_1_.field_40178_aA / 200.0F;
         GL11.glDepthFunc(515);
         GL11.glEnable(3008);
         GL11.glAlphaFunc(516, var8);
         this.func_140_a(p_40280_1_.field_20047_bv, "/mob/enderdragon/shuffle.png");
         this.field_20920_e.func_864_b(p_40280_1_, p_40280_2_, p_40280_3_, p_40280_4_, p_40280_5_, p_40280_6_, p_40280_7_);
         GL11.glAlphaFunc(516, 0.1F);
         GL11.glDepthFunc(514);
      }

      this.func_140_a(p_40280_1_.field_20047_bv, p_40280_1_.func_6376_z());
      this.field_20920_e.func_864_b(p_40280_1_, p_40280_2_, p_40280_3_, p_40280_4_, p_40280_5_, p_40280_6_, p_40280_7_);
      if(p_40280_1_.field_715_G > 0) {
         GL11.glDepthFunc(514);
         GL11.glDisable(3553);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(1.0F, 0.0F, 0.0F, 0.5F);
         this.field_20920_e.func_864_b(p_40280_1_, p_40280_2_, p_40280_3_, p_40280_4_, p_40280_5_, p_40280_6_, p_40280_7_);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
         GL11.glDepthFunc(515);
      }

   }

   public void func_40281_a(EntityDragon p_40281_1_, double p_40281_2_, double p_40281_4_, double p_40281_6_, float p_40281_8_, float p_40281_9_) {
      field_41038_a = p_40281_1_;
      if(field_40284_d != 4) {
         this.field_20920_e = new ModelDragon(0.0F);
         field_40284_d = 4;
      }

      super.func_171_a(p_40281_1_, p_40281_2_, p_40281_4_, p_40281_6_, p_40281_8_, p_40281_9_);
      if(p_40281_1_.field_41013_bH != null) {
         float var10 = (float)p_40281_1_.field_41013_bH.field_41032_a + p_40281_9_;
         float var11 = MathHelper.func_1106_a(var10 * 0.2F) / 2.0F + 0.5F;
         var11 = (var11 * var11 + var11) * 0.2F;
         float var12 = (float)(p_40281_1_.field_41013_bH.field_611_ak - p_40281_1_.field_611_ak - (p_40281_1_.field_9285_at - p_40281_1_.field_611_ak) * (double)(1.0F - p_40281_9_));
         float var13 = (float)((double)var11 + p_40281_1_.field_41013_bH.field_610_al - 1.0D - p_40281_1_.field_610_al - (p_40281_1_.field_9284_au - p_40281_1_.field_610_al) * (double)(1.0F - p_40281_9_));
         float var14 = (float)(p_40281_1_.field_41013_bH.field_609_am - p_40281_1_.field_609_am - (p_40281_1_.field_9283_av - p_40281_1_.field_609_am) * (double)(1.0F - p_40281_9_));
         float var15 = MathHelper.func_1113_c(var12 * var12 + var14 * var14);
         float var16 = MathHelper.func_1113_c(var12 * var12 + var13 * var13 + var14 * var14);
         GL11.glPushMatrix();
         GL11.glTranslatef((float)p_40281_2_, (float)p_40281_4_ + 2.0F, (float)p_40281_6_);
         GL11.glRotatef((float)(-Math.atan2((double)var14, (double)var12)) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef((float)(-Math.atan2((double)var15, (double)var13)) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
         Tessellator var17 = Tessellator.field_1512_a;
         RenderHelper.func_1159_a();
         GL11.glDisable(2884);
         this.func_151_a("/mob/enderdragon/beam.png");
         GL11.glShadeModel(7425);
         float var18 = 0.0F - ((float)p_40281_1_.field_9311_be + p_40281_9_) * 0.01F;
         float var19 = MathHelper.func_1113_c(var12 * var12 + var13 * var13 + var14 * var14) / 32.0F - ((float)p_40281_1_.field_9311_be + p_40281_9_) * 0.01F;
         var17.func_992_a(5);
         byte var20 = 8;

         for(int var21 = 0; var21 <= var20; ++var21) {
            float var22 = MathHelper.func_1106_a((float)(var21 % var20) * 3.1415927F * 2.0F / (float)var20) * 0.75F;
            float var23 = MathHelper.func_1114_b((float)(var21 % var20) * 3.1415927F * 2.0F / (float)var20) * 0.75F;
            float var24 = (float)(var21 % var20) * 1.0F / (float)var20;
            var17.func_990_b(0);
            var17.func_983_a((double)(var22 * 0.2F), (double)(var23 * 0.2F), 0.0D, (double)var24, (double)var19);
            var17.func_990_b(16777215);
            var17.func_983_a((double)var22, (double)var23, (double)var16, (double)var24, (double)var18);
         }

         var17.func_982_a();
         GL11.glEnable(2884);
         GL11.glShadeModel(7424);
         RenderHelper.func_1158_b();
         GL11.glPopMatrix();
      }

   }

   protected void func_40279_a(EntityDragon p_40279_1_, float p_40279_2_) {
      super.func_6331_b(p_40279_1_, p_40279_2_);
      Tessellator var3 = Tessellator.field_1512_a;
      if(p_40279_1_.field_40178_aA > 0) {
         RenderHelper.func_1159_a();
         float var4 = ((float)p_40279_1_.field_40178_aA + p_40279_2_) / 200.0F;
         float var5 = 0.0F;
         if(var4 > 0.8F) {
            var5 = (var4 - 0.8F) / 0.2F;
         }

         Random var6 = new Random(432L);
         GL11.glDisable(3553);
         GL11.glShadeModel(7425);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         GL11.glDisable(3008);
         GL11.glEnable(2884);
         GL11.glDepthMask(false);
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, -1.0F, -2.0F);

         for(int var7 = 0; (float)var7 < (var4 + var4 * var4) / 2.0F * 60.0F; ++var7) {
            GL11.glRotatef(var6.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var6.nextFloat() * 360.0F + var4 * 90.0F, 0.0F, 0.0F, 1.0F);
            var3.func_992_a(6);
            float var8 = var6.nextFloat() * 20.0F + 5.0F + var5 * 10.0F;
            float var9 = var6.nextFloat() * 2.0F + 1.0F + var5 * 2.0F;
            var3.func_6513_a(16777215, (int)(255.0F * (1.0F - var5)));
            var3.func_991_a(0.0D, 0.0D, 0.0D);
            var3.func_6513_a(16711935, 0);
            var3.func_991_a(-0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
            var3.func_991_a(0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
            var3.func_991_a(0.0D, (double)var8, (double)(1.0F * var9));
            var3.func_991_a(-0.866D * (double)var9, (double)var8, (double)(-0.5F * var9));
            var3.func_982_a();
         }

         GL11.glPopMatrix();
         GL11.glDepthMask(true);
         GL11.glDisable(2884);
         GL11.glDisable(3042);
         GL11.glShadeModel(7424);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glEnable(3553);
         GL11.glEnable(3008);
         RenderHelper.func_1158_b();
      }

   }

   protected int func_40283_a(EntityDragon p_40283_1_, int p_40283_2_, float p_40283_3_) {
      if(p_40283_2_ == 1) {
         GL11.glDepthFunc(515);
      }

      if(p_40283_2_ != 0) {
         return -1;
      } else {
         this.func_151_a("/mob/enderdragon/ender_eyes.png");
         float var4 = 1.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3008);
         GL11.glBlendFunc(1, 1);
         GL11.glDisable(2896);
         GL11.glDepthFunc(514);
         char var5 = '\uf0f0';
         int var6 = var5 % 65536;
         int var7 = var5 / 65536;
         OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glEnable(2896);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
         return 1;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_40283_a((EntityDragon)p_166_1_, p_166_2_, p_166_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_40279_a((EntityDragon)p_6331_1_, p_6331_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_21004_a(EntityLiving p_21004_1_, float p_21004_2_, float p_21004_3_, float p_21004_4_) {
      this.func_40282_a((EntityDragon)p_21004_1_, p_21004_2_, p_21004_3_, p_21004_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_40270_a(EntityLiving p_40270_1_, float p_40270_2_, float p_40270_3_, float p_40270_4_, float p_40270_5_, float p_40270_6_, float p_40270_7_) {
      this.func_40280_a((EntityDragon)p_40270_1_, p_40270_2_, p_40270_3_, p_40270_4_, p_40270_5_, p_40270_6_, p_40270_7_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_40281_a((EntityDragon)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_40281_a((EntityDragon)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }

}
