package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MapData;
import net.minecraft.src.MapItemRenderer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RenderPlayer;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class ItemRenderer {

   private Minecraft field_1356_a;
   private ItemStack field_9451_b = null;
   private float field_9453_c = 0.0F;
   private float field_9452_d = 0.0F;
   private RenderBlocks field_1357_e = new RenderBlocks();
   private MapItemRenderer field_28131_f;
   private int field_20099_f = -1;


   public ItemRenderer(Minecraft p_i460_1_) {
      this.field_1356_a = p_i460_1_;
      this.field_28131_f = new MapItemRenderer(p_i460_1_.field_6314_o, p_i460_1_.field_6304_y, p_i460_1_.field_6315_n);
   }

   public void func_4132_a(EntityLiving p_4132_1_, ItemStack p_4132_2_, int p_4132_3_) {
      GL11.glPushMatrix();
      if(p_4132_2_.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[p_4132_2_.field_1617_c].func_210_f())) {
         GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1070_a("/terrain.png"));
         this.field_1357_e.func_1227_a(Block.field_345_n[p_4132_2_.field_1617_c], p_4132_2_.func_21181_i(), 1.0F);
      } else {
         if(p_4132_2_.field_1617_c < 256) {
            GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1070_a("/terrain.png"));
         } else {
            GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1070_a("/gui/items.png"));
         }

         Tessellator var4 = Tessellator.field_1512_a;
         int var5 = p_4132_1_.func_28021_c(p_4132_2_, p_4132_3_);
         float var6 = ((float)(var5 % 16 * 16) + 0.0F) / 256.0F;
         float var7 = ((float)(var5 % 16 * 16) + 15.99F) / 256.0F;
         float var8 = ((float)(var5 / 16 * 16) + 0.0F) / 256.0F;
         float var9 = ((float)(var5 / 16 * 16) + 15.99F) / 256.0F;
         float var10 = 0.0F;
         float var11 = 0.3F;
         GL11.glEnable('\u803a');
         GL11.glTranslatef(-var10, -var11, 0.0F);
         float var12 = 1.5F;
         GL11.glScalef(var12, var12, var12);
         GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
         this.func_40686_a(var4, var7, var8, var6, var9);
         if(p_4132_2_ != null && p_4132_2_.func_40713_r() && p_4132_3_ == 0) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            this.field_1356_a.field_6315_n.func_1076_b(this.field_1356_a.field_6315_n.func_1070_a("%blur%/misc/glint.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(768, 1);
            float var13 = 0.76F;
            GL11.glColor4f(0.5F * var13, 0.25F * var13, 0.8F * var13, 1.0F);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            float var14 = 0.125F;
            GL11.glScalef(var14, var14, var14);
            float var15 = (float)(System.currentTimeMillis() % 3000L) / 3000.0F * 8.0F;
            GL11.glTranslatef(var15, 0.0F, 0.0F);
            GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
            this.func_40686_a(var4, 0.0F, 0.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(var14, var14, var14);
            var15 = (float)(System.currentTimeMillis() % 4873L) / 4873.0F * 8.0F;
            GL11.glTranslatef(-var15, 0.0F, 0.0F);
            GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
            this.func_40686_a(var4, 0.0F, 0.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
         }

         GL11.glDisable('\u803a');
      }

      GL11.glPopMatrix();
   }

   private void func_40686_a(Tessellator p_40686_1_, float p_40686_2_, float p_40686_3_, float p_40686_4_, float p_40686_5_) {
      float var6 = 1.0F;
      float var7 = 0.0625F;
      p_40686_1_.func_977_b();
      p_40686_1_.func_980_b(0.0F, 0.0F, 1.0F);
      p_40686_1_.func_983_a(0.0D, 0.0D, 0.0D, (double)p_40686_2_, (double)p_40686_5_);
      p_40686_1_.func_983_a((double)var6, 0.0D, 0.0D, (double)p_40686_4_, (double)p_40686_5_);
      p_40686_1_.func_983_a((double)var6, 1.0D, 0.0D, (double)p_40686_4_, (double)p_40686_3_);
      p_40686_1_.func_983_a(0.0D, 1.0D, 0.0D, (double)p_40686_2_, (double)p_40686_3_);
      p_40686_1_.func_982_a();
      p_40686_1_.func_977_b();
      p_40686_1_.func_980_b(0.0F, 0.0F, -1.0F);
      p_40686_1_.func_983_a(0.0D, 1.0D, (double)(0.0F - var7), (double)p_40686_2_, (double)p_40686_3_);
      p_40686_1_.func_983_a((double)var6, 1.0D, (double)(0.0F - var7), (double)p_40686_4_, (double)p_40686_3_);
      p_40686_1_.func_983_a((double)var6, 0.0D, (double)(0.0F - var7), (double)p_40686_4_, (double)p_40686_5_);
      p_40686_1_.func_983_a(0.0D, 0.0D, (double)(0.0F - var7), (double)p_40686_2_, (double)p_40686_5_);
      p_40686_1_.func_982_a();
      p_40686_1_.func_977_b();
      p_40686_1_.func_980_b(-1.0F, 0.0F, 0.0F);

      int var8;
      float var9;
      float var10;
      float var11;
      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_40686_2_ + (p_40686_4_ - p_40686_2_) * var9 - 0.001953125F;
         var11 = var6 * var9;
         p_40686_1_.func_983_a((double)var11, 0.0D, (double)(0.0F - var7), (double)var10, (double)p_40686_5_);
         p_40686_1_.func_983_a((double)var11, 0.0D, 0.0D, (double)var10, (double)p_40686_5_);
         p_40686_1_.func_983_a((double)var11, 1.0D, 0.0D, (double)var10, (double)p_40686_3_);
         p_40686_1_.func_983_a((double)var11, 1.0D, (double)(0.0F - var7), (double)var10, (double)p_40686_3_);
      }

      p_40686_1_.func_982_a();
      p_40686_1_.func_977_b();
      p_40686_1_.func_980_b(1.0F, 0.0F, 0.0F);

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_40686_2_ + (p_40686_4_ - p_40686_2_) * var9 - 0.001953125F;
         var11 = var6 * var9 + 0.0625F;
         p_40686_1_.func_983_a((double)var11, 1.0D, (double)(0.0F - var7), (double)var10, (double)p_40686_3_);
         p_40686_1_.func_983_a((double)var11, 1.0D, 0.0D, (double)var10, (double)p_40686_3_);
         p_40686_1_.func_983_a((double)var11, 0.0D, 0.0D, (double)var10, (double)p_40686_5_);
         p_40686_1_.func_983_a((double)var11, 0.0D, (double)(0.0F - var7), (double)var10, (double)p_40686_5_);
      }

      p_40686_1_.func_982_a();
      p_40686_1_.func_977_b();
      p_40686_1_.func_980_b(0.0F, 1.0F, 0.0F);

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_40686_5_ + (p_40686_3_ - p_40686_5_) * var9 - 0.001953125F;
         var11 = var6 * var9 + 0.0625F;
         p_40686_1_.func_983_a(0.0D, (double)var11, 0.0D, (double)p_40686_2_, (double)var10);
         p_40686_1_.func_983_a((double)var6, (double)var11, 0.0D, (double)p_40686_4_, (double)var10);
         p_40686_1_.func_983_a((double)var6, (double)var11, (double)(0.0F - var7), (double)p_40686_4_, (double)var10);
         p_40686_1_.func_983_a(0.0D, (double)var11, (double)(0.0F - var7), (double)p_40686_2_, (double)var10);
      }

      p_40686_1_.func_982_a();
      p_40686_1_.func_977_b();
      p_40686_1_.func_980_b(0.0F, -1.0F, 0.0F);

      for(var8 = 0; var8 < 16; ++var8) {
         var9 = (float)var8 / 16.0F;
         var10 = p_40686_5_ + (p_40686_3_ - p_40686_5_) * var9 - 0.001953125F;
         var11 = var6 * var9;
         p_40686_1_.func_983_a((double)var6, (double)var11, 0.0D, (double)p_40686_4_, (double)var10);
         p_40686_1_.func_983_a(0.0D, (double)var11, 0.0D, (double)p_40686_2_, (double)var10);
         p_40686_1_.func_983_a(0.0D, (double)var11, (double)(0.0F - var7), (double)p_40686_2_, (double)var10);
         p_40686_1_.func_983_a((double)var6, (double)var11, (double)(0.0F - var7), (double)p_40686_4_, (double)var10);
      }

      p_40686_1_.func_982_a();
   }

   public void func_4133_a(float p_4133_1_) {
      float var2 = this.field_9452_d + (this.field_9453_c - this.field_9452_d) * p_4133_1_;
      EntityPlayerSP var3 = this.field_1356_a.field_6322_g;
      float var4 = var3.field_602_at + (var3.field_604_ar - var3.field_602_at) * p_4133_1_;
      GL11.glPushMatrix();
      GL11.glRotatef(var4, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(var3.field_603_as + (var3.field_605_aq - var3.field_603_as) * p_4133_1_, 0.0F, 1.0F, 0.0F);
      RenderHelper.func_1158_b();
      GL11.glPopMatrix();
      float var6;
      float var7;
      if(var3 instanceof EntityPlayerSP) {
         EntityPlayerSP var5 = (EntityPlayerSP)var3;
         var6 = var5.field_35225_ar + (var5.field_35223_ap - var5.field_35225_ar) * p_4133_1_;
         var7 = var5.field_35226_aq + (var5.field_35222_e - var5.field_35226_aq) * p_4133_1_;
         GL11.glRotatef((var3.field_604_ar - var6) * 0.1F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef((var3.field_605_aq - var7) * 0.1F, 0.0F, 1.0F, 0.0F);
      }

      ItemStack var14 = this.field_9451_b;
      var6 = this.field_1356_a.field_6324_e.func_598_c(MathHelper.func_1108_b(var3.field_611_ak), MathHelper.func_1108_b(var3.field_610_al), MathHelper.func_1108_b(var3.field_609_am));
      var6 = 1.0F;
      int var15 = this.field_1356_a.field_6324_e.func_35451_b(MathHelper.func_1108_b(var3.field_611_ak), MathHelper.func_1108_b(var3.field_610_al), MathHelper.func_1108_b(var3.field_609_am), 0);
      int var8 = var15 % 65536;
      int var9 = var15 / 65536;
      OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var8 / 1.0F, (float)var9 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var10;
      float var16;
      float var18;
      if(var14 != null) {
         var15 = Item.field_233_c[var14.field_1617_c].func_27010_f(var14.func_21181_i(), 0);
         var16 = (float)(var15 >> 16 & 255) / 255.0F;
         var18 = (float)(var15 >> 8 & 255) / 255.0F;
         var10 = (float)(var15 & 255) / 255.0F;
         GL11.glColor4f(var6 * var16, var6 * var18, var6 * var10, 1.0F);
      } else {
         GL11.glColor4f(var6, var6, var6, 1.0F);
      }

      float var11;
      float var13;
      if(var14 != null && var14.field_1617_c == Item.field_28010_bb.field_291_aS) {
         GL11.glPushMatrix();
         var7 = 0.8F;
         var16 = var3.func_431_d(p_4133_1_);
         var18 = MathHelper.func_1106_a(var16 * 3.1415927F);
         var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F);
         GL11.glTranslatef(-var10 * 0.4F, MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F * 2.0F) * 0.2F, -var18 * 0.2F);
         var16 = 1.0F - var4 / 45.0F + 0.1F;
         if(var16 < 0.0F) {
            var16 = 0.0F;
         }

         if(var16 > 1.0F) {
            var16 = 1.0F;
         }

         var16 = -MathHelper.func_1114_b(var16 * 3.1415927F) * 0.5F + 0.5F;
         GL11.glTranslatef(0.0F, 0.0F * var7 - (1.0F - var2) * 1.2F - var16 * 0.5F + 0.04F, -0.9F * var7);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(var16 * -85.0F, 0.0F, 0.0F, 1.0F);
         GL11.glEnable('\u803a');
         GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1071_a(this.field_1356_a.field_6322_g.field_20047_bv, this.field_1356_a.field_6322_g.func_6376_z()));

         for(var9 = 0; var9 < 2; ++var9) {
            int var24 = var9 * 2 - 1;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.0F, -0.6F, 1.1F * (float)var24);
            GL11.glRotatef((float)(-45 * var24), 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef((float)(-65 * var24), 0.0F, 1.0F, 0.0F);
            Render var22 = RenderManager.field_1233_a.func_855_a(this.field_1356_a.field_6322_g);
            RenderPlayer var26 = (RenderPlayer)var22;
            var13 = 1.0F;
            GL11.glScalef(var13, var13, var13);
            var26.func_185_b();
            GL11.glPopMatrix();
         }

         var18 = var3.func_431_d(p_4133_1_);
         var10 = MathHelper.func_1106_a(var18 * var18 * 3.1415927F);
         var11 = MathHelper.func_1106_a(MathHelper.func_1113_c(var18) * 3.1415927F);
         GL11.glRotatef(-var10 * 20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var11 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var11 * 80.0F, 1.0F, 0.0F, 0.0F);
         var18 = 0.38F;
         GL11.glScalef(var18, var18, var18);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
         var10 = 0.015625F;
         GL11.glScalef(var10, var10, var10);
         this.field_1356_a.field_6315_n.func_1076_b(this.field_1356_a.field_6315_n.func_1070_a("/misc/mapbg.png"));
         Tessellator var23 = Tessellator.field_1512_a;
         GL11.glNormal3f(0.0F, 0.0F, -1.0F);
         var23.func_977_b();
         byte var27 = 7;
         var23.func_983_a((double)(0 - var27), (double)(128 + var27), 0.0D, 0.0D, 1.0D);
         var23.func_983_a((double)(128 + var27), (double)(128 + var27), 0.0D, 1.0D, 1.0D);
         var23.func_983_a((double)(128 + var27), (double)(0 - var27), 0.0D, 1.0D, 0.0D);
         var23.func_983_a((double)(0 - var27), (double)(0 - var27), 0.0D, 0.0D, 0.0D);
         var23.func_982_a();
         MapData var25 = Item.field_28010_bb.func_28012_a(var14, this.field_1356_a.field_6324_e);
         this.field_28131_f.func_28157_a(this.field_1356_a.field_6322_g, this.field_1356_a.field_6315_n, var25);
         GL11.glPopMatrix();
      } else if(var14 != null) {
         GL11.glPushMatrix();
         var7 = 0.8F;
         float var12;
         if(var3.func_35205_Y() > 0) {
            EnumAction var17 = var14.func_35865_n();
            if(var17 == EnumAction.eat || var17 == EnumAction.drink) {
               var18 = (float)var3.func_35205_Y() - p_4133_1_ + 1.0F;
               var10 = 1.0F - var18 / (float)var14.func_35866_m();
               var12 = 1.0F - var10;
               var12 = var12 * var12 * var12;
               var12 = var12 * var12 * var12;
               var12 = var12 * var12 * var12;
               var13 = 1.0F - var12;
               GL11.glTranslatef(0.0F, MathHelper.func_1112_e(MathHelper.func_1114_b(var18 / 4.0F * 3.1415927F) * 0.1F) * (float)((double)var10 > 0.2D?1:0), 0.0F);
               GL11.glTranslatef(var13 * 0.6F, -var13 * 0.5F, 0.0F);
               GL11.glRotatef(var13 * 90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(var13 * 10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(var13 * 30.0F, 0.0F, 0.0F, 1.0F);
            }
         } else {
            var16 = var3.func_431_d(p_4133_1_);
            var18 = MathHelper.func_1106_a(var16 * 3.1415927F);
            var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F);
            GL11.glTranslatef(-var10 * 0.4F, MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F * 2.0F) * 0.2F, -var18 * 0.2F);
         }

         GL11.glTranslatef(0.7F * var7, -0.65F * var7 - (1.0F - var2) * 0.6F, -0.9F * var7);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glEnable('\u803a');
         var16 = var3.func_431_d(p_4133_1_);
         var18 = MathHelper.func_1106_a(var16 * var16 * 3.1415927F);
         var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F);
         GL11.glRotatef(-var18 * 20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var10 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var10 * 80.0F, 1.0F, 0.0F, 0.0F);
         var16 = 0.4F;
         GL11.glScalef(var16, var16, var16);
         if(var3.func_35205_Y() > 0) {
            EnumAction var20 = var14.func_35865_n();
            if(var20 == EnumAction.block) {
               GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
               GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
            } else if(var20 == EnumAction.bow) {
               GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
               var10 = (float)var14.func_35866_m() - ((float)var3.func_35205_Y() - p_4133_1_ + 1.0F);
               var11 = var10 / 20.0F;
               var11 = (var11 * var11 + var11 * 2.0F) / 3.0F;
               if(var11 > 1.0F) {
                  var11 = 1.0F;
               }

               if(var11 > 0.1F) {
                  GL11.glTranslatef(0.0F, MathHelper.func_1106_a((var10 - 0.1F) * 1.3F) * 0.01F * (var11 - 0.1F), 0.0F);
               }

               GL11.glTranslatef(0.0F, 0.0F, var11 * 0.1F);
               GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.0F, 0.5F, 0.0F);
               var12 = 1.0F + var11 * 0.2F;
               GL11.glScalef(1.0F, 1.0F, var12);
               GL11.glTranslatef(0.0F, -0.5F, 0.0F);
               GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            }
         }

         if(var14.func_1091_a().func_4023_b()) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var14.func_1091_a().func_46058_c()) {
            this.func_4132_a(var3, var14, 0);
            var9 = Item.field_233_c[var14.field_1617_c].func_27010_f(var14.func_21181_i(), 1);
            var10 = (float)(var9 >> 16 & 255) / 255.0F;
            var11 = (float)(var9 >> 8 & 255) / 255.0F;
            var12 = (float)(var9 & 255) / 255.0F;
            GL11.glColor4f(var6 * var10, var6 * var11, var6 * var12, 1.0F);
            this.func_4132_a(var3, var14, 1);
         } else {
            this.func_4132_a(var3, var14, 0);
         }

         GL11.glPopMatrix();
      } else {
         GL11.glPushMatrix();
         var7 = 0.8F;
         var16 = var3.func_431_d(p_4133_1_);
         var18 = MathHelper.func_1106_a(var16 * 3.1415927F);
         var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F);
         GL11.glTranslatef(-var10 * 0.3F, MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F * 2.0F) * 0.4F, -var18 * 0.4F);
         GL11.glTranslatef(0.8F * var7, -0.75F * var7 - (1.0F - var2) * 0.6F, -0.9F * var7);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glEnable('\u803a');
         var16 = var3.func_431_d(p_4133_1_);
         var18 = MathHelper.func_1106_a(var16 * var16 * 3.1415927F);
         var10 = MathHelper.func_1106_a(MathHelper.func_1113_c(var16) * 3.1415927F);
         GL11.glRotatef(var10 * 70.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var18 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glBindTexture(3553, this.field_1356_a.field_6315_n.func_1071_a(this.field_1356_a.field_6322_g.field_20047_bv, this.field_1356_a.field_6322_g.func_6376_z()));
         GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
         GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(1.0F, 1.0F, 1.0F);
         GL11.glTranslatef(5.6F, 0.0F, 0.0F);
         Render var19 = RenderManager.field_1233_a.func_855_a(this.field_1356_a.field_6322_g);
         RenderPlayer var21 = (RenderPlayer)var19;
         var10 = 1.0F;
         GL11.glScalef(var10, var10, var10);
         var21.func_185_b();
         GL11.glPopMatrix();
      }

      GL11.glDisable('\u803a');
      RenderHelper.func_1159_a();
   }

   public void func_893_b(float p_893_1_) {
      GL11.glDisable(3008);
      int var2;
      if(this.field_1356_a.field_6322_g.func_21062_U()) {
         var2 = this.field_1356_a.field_6315_n.func_1070_a("/terrain.png");
         GL11.glBindTexture(3553, var2);
         this.func_890_d(p_893_1_);
      }

      if(this.field_1356_a.field_6322_g.func_345_I()) {
         var2 = MathHelper.func_1108_b(this.field_1356_a.field_6322_g.field_611_ak);
         int var3 = MathHelper.func_1108_b(this.field_1356_a.field_6322_g.field_610_al);
         int var4 = MathHelper.func_1108_b(this.field_1356_a.field_6322_g.field_609_am);
         int var5 = this.field_1356_a.field_6315_n.func_1070_a("/terrain.png");
         GL11.glBindTexture(3553, var5);
         int var6 = this.field_1356_a.field_6324_e.func_600_a(var2, var3, var4);
         if(this.field_1356_a.field_6324_e.func_28100_h(var2, var3, var4)) {
            this.func_898_a(p_893_1_, Block.field_345_n[var6].func_218_a(2));
         } else {
            for(int var7 = 0; var7 < 8; ++var7) {
               float var8 = ((float)((var7 >> 0) % 2) - 0.5F) * this.field_1356_a.field_6322_g.field_644_aC * 0.9F;
               float var9 = ((float)((var7 >> 1) % 2) - 0.5F) * this.field_1356_a.field_6322_g.field_643_aD * 0.2F;
               float var10 = ((float)((var7 >> 2) % 2) - 0.5F) * this.field_1356_a.field_6322_g.field_644_aC * 0.9F;
               int var11 = MathHelper.func_1110_d((float)var2 + var8);
               int var12 = MathHelper.func_1110_d((float)var3 + var9);
               int var13 = MathHelper.func_1110_d((float)var4 + var10);
               if(this.field_1356_a.field_6324_e.func_28100_h(var11, var12, var13)) {
                  var6 = this.field_1356_a.field_6324_e.func_600_a(var11, var12, var13);
               }
            }
         }

         if(Block.field_345_n[var6] != null) {
            this.func_898_a(p_893_1_, Block.field_345_n[var6].func_218_a(2));
         }
      }

      if(this.field_1356_a.field_6322_g.func_393_a(Material.field_1332_f)) {
         var2 = this.field_1356_a.field_6315_n.func_1070_a("/misc/water.png");
         GL11.glBindTexture(3553, var2);
         this.func_892_c(p_893_1_);
      }

      GL11.glEnable(3008);
   }

   private void func_898_a(float p_898_1_, int p_898_2_) {
      Tessellator var3 = Tessellator.field_1512_a;
      this.field_1356_a.field_6322_g.func_382_a(p_898_1_);
      float var4 = 0.1F;
      GL11.glColor4f(var4, var4, var4, 0.5F);
      GL11.glPushMatrix();
      float var5 = -1.0F;
      float var6 = 1.0F;
      float var7 = -1.0F;
      float var8 = 1.0F;
      float var9 = -0.5F;
      float var10 = 0.0078125F;
      float var11 = (float)(p_898_2_ % 16) / 256.0F - var10;
      float var12 = ((float)(p_898_2_ % 16) + 15.99F) / 256.0F + var10;
      float var13 = (float)(p_898_2_ / 16) / 256.0F - var10;
      float var14 = ((float)(p_898_2_ / 16) + 15.99F) / 256.0F + var10;
      var3.func_977_b();
      var3.func_983_a((double)var5, (double)var7, (double)var9, (double)var12, (double)var14);
      var3.func_983_a((double)var6, (double)var7, (double)var9, (double)var11, (double)var14);
      var3.func_983_a((double)var6, (double)var8, (double)var9, (double)var11, (double)var13);
      var3.func_983_a((double)var5, (double)var8, (double)var9, (double)var12, (double)var13);
      var3.func_982_a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_892_c(float p_892_1_) {
      Tessellator var2 = Tessellator.field_1512_a;
      float var3 = this.field_1356_a.field_6322_g.func_382_a(p_892_1_);
      GL11.glColor4f(var3, var3, var3, 0.5F);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      float var4 = 4.0F;
      float var5 = -1.0F;
      float var6 = 1.0F;
      float var7 = -1.0F;
      float var8 = 1.0F;
      float var9 = -0.5F;
      float var10 = -this.field_1356_a.field_6322_g.field_605_aq / 64.0F;
      float var11 = this.field_1356_a.field_6322_g.field_604_ar / 64.0F;
      var2.func_977_b();
      var2.func_983_a((double)var5, (double)var7, (double)var9, (double)(var4 + var10), (double)(var4 + var11));
      var2.func_983_a((double)var6, (double)var7, (double)var9, (double)(0.0F + var10), (double)(var4 + var11));
      var2.func_983_a((double)var6, (double)var8, (double)var9, (double)(0.0F + var10), (double)(0.0F + var11));
      var2.func_983_a((double)var5, (double)var8, (double)var9, (double)(var4 + var10), (double)(0.0F + var11));
      var2.func_982_a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   private void func_890_d(float p_890_1_) {
      Tessellator var2 = Tessellator.field_1512_a;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      float var3 = 1.0F;

      for(int var4 = 0; var4 < 2; ++var4) {
         GL11.glPushMatrix();
         int var5 = Block.field_402_as.field_378_bb + var4 * 16;
         int var6 = (var5 & 15) << 4;
         int var7 = var5 & 240;
         float var8 = (float)var6 / 256.0F;
         float var9 = ((float)var6 + 15.99F) / 256.0F;
         float var10 = (float)var7 / 256.0F;
         float var11 = ((float)var7 + 15.99F) / 256.0F;
         float var12 = (0.0F - var3) / 2.0F;
         float var13 = var12 + var3;
         float var14 = 0.0F - var3 / 2.0F;
         float var15 = var14 + var3;
         float var16 = -0.5F;
         GL11.glTranslatef((float)(-(var4 * 2 - 1)) * 0.24F, -0.3F, 0.0F);
         GL11.glRotatef((float)(var4 * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
         var2.func_977_b();
         var2.func_983_a((double)var12, (double)var14, (double)var16, (double)var9, (double)var11);
         var2.func_983_a((double)var13, (double)var14, (double)var16, (double)var8, (double)var11);
         var2.func_983_a((double)var13, (double)var15, (double)var16, (double)var8, (double)var10);
         var2.func_983_a((double)var12, (double)var15, (double)var16, (double)var9, (double)var10);
         var2.func_982_a();
         GL11.glPopMatrix();
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   public void func_895_a() {
      this.field_9452_d = this.field_9453_c;
      EntityPlayerSP var1 = this.field_1356_a.field_6322_g;
      ItemStack var2 = var1.field_778_b.func_494_a();
      boolean var4 = this.field_20099_f == var1.field_778_b.field_847_d && var2 == this.field_9451_b;
      if(this.field_9451_b == null && var2 == null) {
         var4 = true;
      }

      if(var2 != null && this.field_9451_b != null && var2 != this.field_9451_b && var2.field_1617_c == this.field_9451_b.field_1617_c && var2.func_21181_i() == this.field_9451_b.func_21181_i()) {
         this.field_9451_b = var2;
         var4 = true;
      }

      float var5 = 0.4F;
      float var6 = var4?1.0F:0.0F;
      float var7 = var6 - this.field_9453_c;
      if(var7 < -var5) {
         var7 = -var5;
      }

      if(var7 > var5) {
         var7 = var5;
      }

      this.field_9453_c += var7;
      if(this.field_9453_c < 0.1F) {
         this.field_9451_b = var2;
         this.field_20099_f = var1.field_778_b.field_847_d;
      }

   }

   public void func_9449_b() {
      this.field_9453_c = 0.0F;
   }

   public void func_9450_c() {
      this.field_9453_c = 0.0F;
   }
}
