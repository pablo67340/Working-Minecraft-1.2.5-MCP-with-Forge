package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelMinecart;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Vec3D;
import org.lwjgl.opengl.GL11;

public class RenderMinecart extends Render {

   protected ModelBase field_20925_a;


   public RenderMinecart() {
      this.field_9246_c = 0.5F;
      this.field_20925_a = new ModelMinecart();
   }

   public void func_152_a(EntityMinecart p_152_1_, double p_152_2_, double p_152_4_, double p_152_6_, float p_152_8_, float p_152_9_) {
      GL11.glPushMatrix();
      long var10 = (long)p_152_1_.field_620_ab * 493286711L;
      var10 = var10 * var10 * 4392167121L + var10 * 98761L;
      float var12 = (((float)(var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      float var13 = (((float)(var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      float var14 = (((float)(var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      GL11.glTranslatef(var12, var13, var14);
      double var15 = p_152_1_.field_638_aI + (p_152_1_.field_611_ak - p_152_1_.field_638_aI) * (double)p_152_9_;
      double var17 = p_152_1_.field_637_aJ + (p_152_1_.field_610_al - p_152_1_.field_637_aJ) * (double)p_152_9_;
      double var19 = p_152_1_.field_636_aK + (p_152_1_.field_609_am - p_152_1_.field_636_aK) * (double)p_152_9_;
      double var21 = 0.30000001192092896D;
      Vec3D var23 = p_152_1_.func_514_g(var15, var17, var19);
      float var24 = p_152_1_.field_602_at + (p_152_1_.field_604_ar - p_152_1_.field_602_at) * p_152_9_;
      if(var23 != null) {
         Vec3D var25 = p_152_1_.func_515_a(var15, var17, var19, var21);
         Vec3D var26 = p_152_1_.func_515_a(var15, var17, var19, -var21);
         if(var25 == null) {
            var25 = var23;
         }

         if(var26 == null) {
            var26 = var23;
         }

         p_152_2_ += var23.field_1776_a - var15;
         p_152_4_ += (var25.field_1775_b + var26.field_1775_b) / 2.0D - var17;
         p_152_6_ += var23.field_1779_c - var19;
         Vec3D var27 = var26.func_1257_c(-var25.field_1776_a, -var25.field_1775_b, -var25.field_1779_c);
         if(var27.func_1253_c() != 0.0D) {
            var27 = var27.func_1252_b();
            p_152_8_ = (float)(Math.atan2(var27.field_1779_c, var27.field_1776_a) * 180.0D / 3.141592653589793D);
            var24 = (float)(Math.atan(var27.field_1775_b) * 73.0D);
         }
      }

      GL11.glTranslatef((float)p_152_2_, (float)p_152_4_, (float)p_152_6_);
      GL11.glRotatef(180.0F - p_152_8_, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
      float var28 = (float)p_152_1_.func_41023_l() - p_152_9_;
      float var29 = (float)p_152_1_.func_41025_i() - p_152_9_;
      if(var29 < 0.0F) {
         var29 = 0.0F;
      }

      if(var28 > 0.0F) {
         GL11.glRotatef(MathHelper.func_1106_a(var28) * var28 * var29 / 10.0F * (float)p_152_1_.func_41030_m(), 1.0F, 0.0F, 0.0F);
      }

      if(p_152_1_.field_20913_d != 0) {
         this.func_151_a("/terrain.png");
         float var30 = 0.75F;
         GL11.glScalef(var30, var30, var30);
         if(p_152_1_.field_20913_d == 1) {
            GL11.glTranslatef(-0.5F, 0.0F, 0.5F);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            (new RenderBlocks()).func_1227_a(Block.field_396_av, 0, p_152_1_.func_382_a(p_152_9_));
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.5F, 0.0F, -0.5F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         } else if(p_152_1_.field_20913_d == 2) {
            GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            (new RenderBlocks()).func_1227_a(Block.field_445_aC, 0, p_152_1_.func_382_a(p_152_9_));
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         GL11.glScalef(1.0F / var30, 1.0F / var30, 1.0F / var30);
      }

      this.func_151_a("/item/cart.png");
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.field_20925_a.func_864_b(p_152_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_152_a((EntityMinecart)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
