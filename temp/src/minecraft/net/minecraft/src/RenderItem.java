package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderItem extends Render {

   private RenderBlocks field_201_d = new RenderBlocks();
   private Random field_200_e = new Random();
   public boolean field_27004_a = true;
   public float field_40268_b = 0.0F;


   public RenderItem() {
      this.field_9246_c = 0.15F;
      this.field_194_c = 0.75F;
   }

   public void func_165_a(EntityItem p_165_1_, double p_165_2_, double p_165_4_, double p_165_6_, float p_165_8_, float p_165_9_) {
      this.field_200_e.setSeed(187L);
      ItemStack var10 = p_165_1_.field_801_a;
      GL11.glPushMatrix();
      float var11 = MathHelper.func_1106_a(((float)p_165_1_.field_800_b + p_165_9_) / 10.0F + p_165_1_.field_804_d) * 0.1F + 0.1F;
      float var12 = (((float)p_165_1_.field_800_b + p_165_9_) / 20.0F + p_165_1_.field_804_d) * 57.295776F;
      byte var13 = 1;
      if(p_165_1_.field_801_a.field_1615_a > 1) {
         var13 = 2;
      }

      if(p_165_1_.field_801_a.field_1615_a > 5) {
         var13 = 3;
      }

      if(p_165_1_.field_801_a.field_1615_a > 20) {
         var13 = 4;
      }

      GL11.glTranslatef((float)p_165_2_, (float)p_165_4_ + var11, (float)p_165_6_);
      GL11.glEnable('\u803a');
      int var15;
      float var18;
      float var19;
      float var23;
      if(var10.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var10.field_1617_c].func_210_f())) {
         GL11.glRotatef(var12, 0.0F, 1.0F, 0.0F);
         this.func_151_a("/terrain.png");
         float var21 = 0.25F;
         var15 = Block.field_345_n[var10.field_1617_c].func_210_f();
         if(var15 == 1 || var15 == 19 || var15 == 12 || var15 == 2) {
            var21 = 0.5F;
         }

         GL11.glScalef(var21, var21, var21);

         for(int var22 = 0; var22 < var13; ++var22) {
            GL11.glPushMatrix();
            if(var22 > 0) {
               var23 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F / var21;
               var18 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F / var21;
               var19 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.2F / var21;
               GL11.glTranslatef(var23, var18, var19);
            }

            var23 = 1.0F;
            this.field_201_d.func_1227_a(Block.field_345_n[var10.field_1617_c], var10.func_21181_i(), var23);
            GL11.glPopMatrix();
         }
      } else {
         int var14;
         float var16;
         if(var10.func_1091_a().func_46058_c()) {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.func_151_a("/gui/items.png");

            for(var14 = 0; var14 <= 1; ++var14) {
               var15 = var10.func_1091_a().func_46057_a(var10.func_21181_i(), var14);
               var16 = 1.0F;
               if(this.field_27004_a) {
                  int var17 = Item.field_233_c[var10.field_1617_c].func_27010_f(var10.func_21181_i(), var14);
                  var18 = (float)(var17 >> 16 & 255) / 255.0F;
                  var19 = (float)(var17 >> 8 & 255) / 255.0F;
                  float var20 = (float)(var17 & 255) / 255.0F;
                  GL11.glColor4f(var18 * var16, var19 * var16, var20 * var16, 1.0F);
               }

               this.func_40267_a(var15, var13);
            }
         } else {
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            var14 = var10.func_1088_b();
            if(var10.field_1617_c < 256) {
               this.func_151_a("/terrain.png");
            } else {
               this.func_151_a("/gui/items.png");
            }

            if(this.field_27004_a) {
               var15 = Item.field_233_c[var10.field_1617_c].func_27010_f(var10.func_21181_i(), 0);
               var16 = (float)(var15 >> 16 & 255) / 255.0F;
               var23 = (float)(var15 >> 8 & 255) / 255.0F;
               var18 = (float)(var15 & 255) / 255.0F;
               var19 = 1.0F;
               GL11.glColor4f(var16 * var19, var23 * var19, var18 * var19, 1.0F);
            }

            this.func_40267_a(var14, var13);
         }
      }

      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   private void func_40267_a(int p_40267_1_, int p_40267_2_) {
      Tessellator var3 = Tessellator.field_1512_a;
      float var4 = (float)(p_40267_1_ % 16 * 16 + 0) / 256.0F;
      float var5 = (float)(p_40267_1_ % 16 * 16 + 16) / 256.0F;
      float var6 = (float)(p_40267_1_ / 16 * 16 + 0) / 256.0F;
      float var7 = (float)(p_40267_1_ / 16 * 16 + 16) / 256.0F;
      float var8 = 1.0F;
      float var9 = 0.5F;
      float var10 = 0.25F;

      for(int var11 = 0; var11 < p_40267_2_; ++var11) {
         GL11.glPushMatrix();
         if(var11 > 0) {
            float var12 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
            float var13 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
            float var14 = (this.field_200_e.nextFloat() * 2.0F - 1.0F) * 0.3F;
            GL11.glTranslatef(var12, var13, var14);
         }

         GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
         var3.func_977_b();
         var3.func_980_b(0.0F, 1.0F, 0.0F);
         var3.func_983_a((double)(0.0F - var9), (double)(0.0F - var10), 0.0D, (double)var4, (double)var7);
         var3.func_983_a((double)(var8 - var9), (double)(0.0F - var10), 0.0D, (double)var5, (double)var7);
         var3.func_983_a((double)(var8 - var9), (double)(1.0F - var10), 0.0D, (double)var5, (double)var6);
         var3.func_983_a((double)(0.0F - var9), (double)(1.0F - var10), 0.0D, (double)var4, (double)var6);
         var3.func_982_a();
         GL11.glPopMatrix();
      }

   }

   public void func_27003_a(FontRenderer p_27003_1_, RenderEngine p_27003_2_, int p_27003_3_, int p_27003_4_, int p_27003_5_, int p_27003_6_, int p_27003_7_) {
      int var10;
      float var11;
      float var12;
      float var13;
      if(p_27003_3_ < 256 && RenderBlocks.func_1219_a(Block.field_345_n[p_27003_3_].func_210_f())) {
         p_27003_2_.func_1076_b(p_27003_2_.func_1070_a("/terrain.png"));
         Block var15 = Block.field_345_n[p_27003_3_];
         GL11.glPushMatrix();
         GL11.glTranslatef((float)(p_27003_6_ - 2), (float)(p_27003_7_ + 3), -3.0F + this.field_40268_b);
         GL11.glScalef(10.0F, 10.0F, 10.0F);
         GL11.glTranslatef(1.0F, 0.5F, 1.0F);
         GL11.glScalef(1.0F, 1.0F, -1.0F);
         GL11.glRotatef(210.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         var10 = Item.field_233_c[p_27003_3_].func_27010_f(p_27003_4_, 0);
         var11 = (float)(var10 >> 16 & 255) / 255.0F;
         var12 = (float)(var10 >> 8 & 255) / 255.0F;
         var13 = (float)(var10 & 255) / 255.0F;
         if(this.field_27004_a) {
            GL11.glColor4f(var11, var12, var13, 1.0F);
         }

         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         this.field_201_d.field_31088_b = this.field_27004_a;
         this.field_201_d.func_1227_a(var15, p_27003_4_, 1.0F);
         this.field_201_d.field_31088_b = true;
         GL11.glPopMatrix();
      } else {
         int var8;
         if(Item.field_233_c[p_27003_3_].func_46058_c()) {
            GL11.glDisable(2896);
            p_27003_2_.func_1076_b(p_27003_2_.func_1070_a("/gui/items.png"));

            for(var8 = 0; var8 <= 1; ++var8) {
               int var9 = Item.field_233_c[p_27003_3_].func_46057_a(p_27003_4_, var8);
               var10 = Item.field_233_c[p_27003_3_].func_27010_f(p_27003_4_, var8);
               var11 = (float)(var10 >> 16 & 255) / 255.0F;
               var12 = (float)(var10 >> 8 & 255) / 255.0F;
               var13 = (float)(var10 & 255) / 255.0F;
               if(this.field_27004_a) {
                  GL11.glColor4f(var11, var12, var13, 1.0F);
               }

               this.func_163_a(p_27003_6_, p_27003_7_, var9 % 16 * 16, var9 / 16 * 16, 16, 16);
            }

            GL11.glEnable(2896);
         } else if(p_27003_5_ >= 0) {
            GL11.glDisable(2896);
            if(p_27003_3_ < 256) {
               p_27003_2_.func_1076_b(p_27003_2_.func_1070_a("/terrain.png"));
            } else {
               p_27003_2_.func_1076_b(p_27003_2_.func_1070_a("/gui/items.png"));
            }

            var8 = Item.field_233_c[p_27003_3_].func_27010_f(p_27003_4_, 0);
            float var14 = (float)(var8 >> 16 & 255) / 255.0F;
            float var16 = (float)(var8 >> 8 & 255) / 255.0F;
            var11 = (float)(var8 & 255) / 255.0F;
            if(this.field_27004_a) {
               GL11.glColor4f(var14, var16, var11, 1.0F);
            }

            this.func_163_a(p_27003_6_, p_27003_7_, p_27003_5_ % 16 * 16, p_27003_5_ / 16 * 16, 16, 16);
            GL11.glEnable(2896);
         }
      }

      GL11.glEnable(2884);
   }

   public void func_161_a(FontRenderer p_161_1_, RenderEngine p_161_2_, ItemStack p_161_3_, int p_161_4_, int p_161_5_) {
      if(p_161_3_ != null) {
         this.func_27003_a(p_161_1_, p_161_2_, p_161_3_.field_1617_c, p_161_3_.func_21181_i(), p_161_3_.func_1088_b(), p_161_4_, p_161_5_);
         if(p_161_3_ != null && p_161_3_.func_40713_r()) {
            GL11.glDepthFunc(516);
            GL11.glDisable(2896);
            GL11.glDepthMask(false);
            p_161_2_.func_1076_b(p_161_2_.func_1070_a("%blur%/misc/glint.png"));
            this.field_40268_b -= 50.0F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(774, 774);
            GL11.glColor4f(0.5F, 0.25F, 0.8F, 1.0F);
            this.func_40266_a(p_161_4_ * 431278612 + p_161_5_ * 32178161, p_161_4_ - 2, p_161_5_ - 2, 20, 20);
            GL11.glDisable(3042);
            GL11.glDepthMask(true);
            this.field_40268_b += 50.0F;
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
         }

      }
   }

   private void func_40266_a(int p_40266_1_, int p_40266_2_, int p_40266_3_, int p_40266_4_, int p_40266_5_) {
      for(int var6 = 0; var6 < 2; ++var6) {
         if(var6 == 0) {
            GL11.glBlendFunc(768, 1);
         }

         if(var6 == 1) {
            GL11.glBlendFunc(768, 1);
         }

         float var7 = 0.00390625F;
         float var8 = 0.00390625F;
         float var9 = (float)(System.currentTimeMillis() % (long)(3000 + var6 * 1873)) / (3000.0F + (float)(var6 * 1873)) * 256.0F;
         float var10 = 0.0F;
         Tessellator var11 = Tessellator.field_1512_a;
         float var12 = 4.0F;
         if(var6 == 1) {
            var12 = -1.0F;
         }

         var11.func_977_b();
         var11.func_983_a((double)(p_40266_2_ + 0), (double)(p_40266_3_ + p_40266_5_), (double)this.field_40268_b, (double)((var9 + (float)p_40266_5_ * var12) * var7), (double)((var10 + (float)p_40266_5_) * var8));
         var11.func_983_a((double)(p_40266_2_ + p_40266_4_), (double)(p_40266_3_ + p_40266_5_), (double)this.field_40268_b, (double)((var9 + (float)p_40266_4_ + (float)p_40266_5_ * var12) * var7), (double)((var10 + (float)p_40266_5_) * var8));
         var11.func_983_a((double)(p_40266_2_ + p_40266_4_), (double)(p_40266_3_ + 0), (double)this.field_40268_b, (double)((var9 + (float)p_40266_4_) * var7), (double)((var10 + 0.0F) * var8));
         var11.func_983_a((double)(p_40266_2_ + 0), (double)(p_40266_3_ + 0), (double)this.field_40268_b, (double)((var9 + 0.0F) * var7), (double)((var10 + 0.0F) * var8));
         var11.func_982_a();
      }

   }

   public void func_164_b(FontRenderer p_164_1_, RenderEngine p_164_2_, ItemStack p_164_3_, int p_164_4_, int p_164_5_) {
      if(p_164_3_ != null) {
         if(p_164_3_.field_1615_a > 1) {
            String var6 = "" + p_164_3_.field_1615_a;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            p_164_1_.func_50103_a(var6, p_164_4_ + 19 - 2 - p_164_1_.func_871_a(var6), p_164_5_ + 6 + 3, 16777215);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
         }

         if(p_164_3_.func_21185_g()) {
            int var11 = (int)Math.round(13.0D - (double)p_164_3_.func_21179_h() * 13.0D / (double)p_164_3_.func_1094_d());
            int var7 = (int)Math.round(255.0D - (double)p_164_3_.func_21179_h() * 255.0D / (double)p_164_3_.func_1094_d());
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            GL11.glDisable(3553);
            Tessellator var8 = Tessellator.field_1512_a;
            int var9 = 255 - var7 << 16 | var7 << 8;
            int var10 = (255 - var7) / 4 << 16 | 16128;
            this.func_162_a(var8, p_164_4_ + 2, p_164_5_ + 13, 13, 2, 0);
            this.func_162_a(var8, p_164_4_ + 2, p_164_5_ + 13, 12, 1, var10);
            this.func_162_a(var8, p_164_4_ + 2, p_164_5_ + 13, var11, 1, var9);
            GL11.glEnable(3553);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   private void func_162_a(Tessellator p_162_1_, int p_162_2_, int p_162_3_, int p_162_4_, int p_162_5_, int p_162_6_) {
      p_162_1_.func_977_b();
      p_162_1_.func_990_b(p_162_6_);
      p_162_1_.func_991_a((double)(p_162_2_ + 0), (double)(p_162_3_ + 0), 0.0D);
      p_162_1_.func_991_a((double)(p_162_2_ + 0), (double)(p_162_3_ + p_162_5_), 0.0D);
      p_162_1_.func_991_a((double)(p_162_2_ + p_162_4_), (double)(p_162_3_ + p_162_5_), 0.0D);
      p_162_1_.func_991_a((double)(p_162_2_ + p_162_4_), (double)(p_162_3_ + 0), 0.0D);
      p_162_1_.func_982_a();
   }

   public void func_163_a(int p_163_1_, int p_163_2_, int p_163_3_, int p_163_4_, int p_163_5_, int p_163_6_) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.field_1512_a;
      var9.func_977_b();
      var9.func_983_a((double)(p_163_1_ + 0), (double)(p_163_2_ + p_163_6_), (double)this.field_40268_b, (double)((float)(p_163_3_ + 0) * var7), (double)((float)(p_163_4_ + p_163_6_) * var8));
      var9.func_983_a((double)(p_163_1_ + p_163_5_), (double)(p_163_2_ + p_163_6_), (double)this.field_40268_b, (double)((float)(p_163_3_ + p_163_5_) * var7), (double)((float)(p_163_4_ + p_163_6_) * var8));
      var9.func_983_a((double)(p_163_1_ + p_163_5_), (double)(p_163_2_ + 0), (double)this.field_40268_b, (double)((float)(p_163_3_ + p_163_5_) * var7), (double)((float)(p_163_4_ + 0) * var8));
      var9.func_983_a((double)(p_163_1_ + 0), (double)(p_163_2_ + 0), (double)this.field_40268_b, (double)((float)(p_163_3_ + 0) * var7), (double)((float)(p_163_4_ + 0) * var8));
      var9.func_982_a();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_165_a((EntityItem)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
