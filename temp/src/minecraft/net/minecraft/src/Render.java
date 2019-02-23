package net.minecraft.src;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderManager;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public abstract class Render {

   protected RenderManager field_191_a;
   private ModelBase field_195_d = new ModelBiped();
   protected RenderBlocks field_203_d = new RenderBlocks();
   protected float field_9246_c = 0.0F;
   protected float field_194_c = 1.0F;


   public abstract void func_147_a(Entity var1, double var2, double var4, double var6, float var8, float var9);

   protected void func_151_a(String p_151_1_) {
      RenderEngine var2 = this.field_191_a.field_1229_e;
      var2.func_1076_b(var2.func_1070_a(p_151_1_));
   }

   protected boolean func_140_a(String p_140_1_, String p_140_2_) {
      RenderEngine var3 = this.field_191_a.field_1229_e;
      int var4 = var3.func_1071_a(p_140_1_, p_140_2_);
      if(var4 >= 0) {
         var3.func_1076_b(var4);
         return true;
      } else {
         return false;
      }
   }

   private void func_148_a(Entity p_148_1_, double p_148_2_, double p_148_4_, double p_148_6_, float p_148_8_) {
      GL11.glDisable(2896);
      int var9 = Block.field_402_as.field_378_bb;
      int var10 = (var9 & 15) << 4;
      int var11 = var9 & 240;
      float var12 = (float)var10 / 256.0F;
      float var13 = ((float)var10 + 15.99F) / 256.0F;
      float var14 = (float)var11 / 256.0F;
      float var15 = ((float)var11 + 15.99F) / 256.0F;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_148_2_, (float)p_148_4_, (float)p_148_6_);
      float var16 = p_148_1_.field_644_aC * 1.4F;
      GL11.glScalef(var16, var16, var16);
      this.func_151_a("/terrain.png");
      Tessellator var17 = Tessellator.field_1512_a;
      float var18 = 0.5F;
      float var19 = 0.0F;
      float var20 = p_148_1_.field_643_aD / var16;
      float var21 = (float)(p_148_1_.field_610_al - p_148_1_.field_601_au.field_1697_b);
      GL11.glRotatef(-this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.0F, -0.3F + (float)((int)var20) * 0.02F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var22 = 0.0F;
      int var23 = 0;
      var17.func_977_b();

      while(var20 > 0.0F) {
         if(var23 % 2 == 0) {
            var12 = (float)var10 / 256.0F;
            var13 = ((float)var10 + 15.99F) / 256.0F;
            var14 = (float)var11 / 256.0F;
            var15 = ((float)var11 + 15.99F) / 256.0F;
         } else {
            var12 = (float)var10 / 256.0F;
            var13 = ((float)var10 + 15.99F) / 256.0F;
            var14 = (float)(var11 + 16) / 256.0F;
            var15 = ((float)(var11 + 16) + 15.99F) / 256.0F;
         }

         if(var23 / 2 % 2 == 0) {
            float var24 = var13;
            var13 = var12;
            var12 = var24;
         }

         var17.func_983_a((double)(var18 - var19), (double)(0.0F - var21), (double)var22, (double)var13, (double)var15);
         var17.func_983_a((double)(-var18 - var19), (double)(0.0F - var21), (double)var22, (double)var12, (double)var15);
         var17.func_983_a((double)(-var18 - var19), (double)(1.4F - var21), (double)var22, (double)var12, (double)var14);
         var17.func_983_a((double)(var18 - var19), (double)(1.4F - var21), (double)var22, (double)var13, (double)var14);
         var20 -= 0.45F;
         var21 -= 0.45F;
         var18 *= 0.9F;
         var22 += 0.03F;
         ++var23;
      }

      var17.func_982_a();
      GL11.glPopMatrix();
      GL11.glEnable(2896);
   }

   private void func_144_c(Entity p_144_1_, double p_144_2_, double p_144_4_, double p_144_6_, float p_144_8_, float p_144_9_) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      RenderEngine var10 = this.field_191_a.field_1229_e;
      var10.func_1076_b(var10.func_1070_a("%clamp%/misc/shadow.png"));
      World var11 = this.func_149_b();
      GL11.glDepthMask(false);
      float var12 = this.field_9246_c;
      if(p_144_1_ instanceof EntityLiving) {
         EntityLiving var13 = (EntityLiving)p_144_1_;
         var12 *= var13.func_35159_aC();
         if(var13 instanceof EntityAnimal) {
            EntityAnimal var14 = (EntityAnimal)var13;
            if(var14.func_40127_l()) {
               var12 *= 0.5F;
            }
         }
      }

      double var36 = p_144_1_.field_638_aI + (p_144_1_.field_611_ak - p_144_1_.field_638_aI) * (double)p_144_9_;
      double var15 = p_144_1_.field_637_aJ + (p_144_1_.field_610_al - p_144_1_.field_637_aJ) * (double)p_144_9_ + (double)p_144_1_.func_392_h_();
      double var17 = p_144_1_.field_636_aK + (p_144_1_.field_609_am - p_144_1_.field_636_aK) * (double)p_144_9_;
      int var19 = MathHelper.func_1108_b(var36 - (double)var12);
      int var20 = MathHelper.func_1108_b(var36 + (double)var12);
      int var21 = MathHelper.func_1108_b(var15 - (double)var12);
      int var22 = MathHelper.func_1108_b(var15);
      int var23 = MathHelper.func_1108_b(var17 - (double)var12);
      int var24 = MathHelper.func_1108_b(var17 + (double)var12);
      double var25 = p_144_2_ - var36;
      double var27 = p_144_4_ - var15;
      double var29 = p_144_6_ - var17;
      Tessellator var31 = Tessellator.field_1512_a;
      var31.func_977_b();

      for(int var32 = var19; var32 <= var20; ++var32) {
         for(int var33 = var21; var33 <= var22; ++var33) {
            for(int var34 = var23; var34 <= var24; ++var34) {
               int var35 = var11.func_600_a(var32, var33 - 1, var34);
               if(var35 > 0 && var11.func_618_j(var32, var33, var34) > 3) {
                  this.func_145_a(Block.field_345_n[var35], p_144_2_, p_144_4_ + (double)p_144_1_.func_392_h_(), p_144_6_, var32, var33, var34, p_144_8_, var12, var25, var27 + (double)p_144_1_.func_392_h_(), var29);
               }
            }
         }
      }

      var31.func_982_a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glDepthMask(true);
   }

   private World func_149_b() {
      return this.field_191_a.field_1227_g;
   }

   private void func_145_a(Block p_145_1_, double p_145_2_, double p_145_4_, double p_145_6_, int p_145_8_, int p_145_9_, int p_145_10_, float p_145_11_, float p_145_12_, double p_145_13_, double p_145_15_, double p_145_17_) {
      Tessellator var19 = Tessellator.field_1512_a;
      if(p_145_1_.func_242_c()) {
         double var20 = ((double)p_145_11_ - (p_145_4_ - ((double)p_145_9_ + p_145_15_)) / 2.0D) * 0.5D * (double)this.func_149_b().func_598_c(p_145_8_, p_145_9_, p_145_10_);
         if(var20 >= 0.0D) {
            if(var20 > 1.0D) {
               var20 = 1.0D;
            }

            var19.func_986_a(1.0F, 1.0F, 1.0F, (float)var20);
            double var22 = (double)p_145_8_ + p_145_1_.field_370_bf + p_145_13_;
            double var24 = (double)p_145_8_ + p_145_1_.field_364_bi + p_145_13_;
            double var26 = (double)p_145_9_ + p_145_1_.field_368_bg + p_145_15_ + 0.015625D;
            double var28 = (double)p_145_10_ + p_145_1_.field_366_bh + p_145_17_;
            double var30 = (double)p_145_10_ + p_145_1_.field_360_bk + p_145_17_;
            float var32 = (float)((p_145_2_ - var22) / 2.0D / (double)p_145_12_ + 0.5D);
            float var33 = (float)((p_145_2_ - var24) / 2.0D / (double)p_145_12_ + 0.5D);
            float var34 = (float)((p_145_6_ - var28) / 2.0D / (double)p_145_12_ + 0.5D);
            float var35 = (float)((p_145_6_ - var30) / 2.0D / (double)p_145_12_ + 0.5D);
            var19.func_983_a(var22, var26, var28, (double)var32, (double)var34);
            var19.func_983_a(var22, var26, var30, (double)var32, (double)var35);
            var19.func_983_a(var24, var26, var30, (double)var33, (double)var35);
            var19.func_983_a(var24, var26, var28, (double)var33, (double)var34);
         }
      }
   }

   public static void func_146_a(AxisAlignedBB p_146_0_, double p_146_1_, double p_146_3_, double p_146_5_) {
      GL11.glDisable(3553);
      Tessellator var7 = Tessellator.field_1512_a;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      var7.func_977_b();
      var7.func_984_b(p_146_1_, p_146_3_, p_146_5_);
      var7.func_980_b(0.0F, 0.0F, -1.0F);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1702_e, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1702_e, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1697_b, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1697_b, p_146_0_.field_1704_c);
      var7.func_980_b(0.0F, 0.0F, 1.0F);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1697_b, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1697_b, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1702_e, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1702_e, p_146_0_.field_1701_f);
      var7.func_980_b(0.0F, -1.0F, 0.0F);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1697_b, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1697_b, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1697_b, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1697_b, p_146_0_.field_1701_f);
      var7.func_980_b(0.0F, 1.0F, 0.0F);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1702_e, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1702_e, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1702_e, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1702_e, p_146_0_.field_1704_c);
      var7.func_980_b(-1.0F, 0.0F, 0.0F);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1697_b, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1702_e, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1702_e, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1698_a, p_146_0_.field_1697_b, p_146_0_.field_1704_c);
      var7.func_980_b(1.0F, 0.0F, 0.0F);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1697_b, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1702_e, p_146_0_.field_1704_c);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1702_e, p_146_0_.field_1701_f);
      var7.func_991_a(p_146_0_.field_1703_d, p_146_0_.field_1697_b, p_146_0_.field_1701_f);
      var7.func_984_b(0.0D, 0.0D, 0.0D);
      var7.func_982_a();
      GL11.glEnable(3553);
   }

   public static void func_142_a(AxisAlignedBB p_142_0_) {
      Tessellator var1 = Tessellator.field_1512_a;
      var1.func_977_b();
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1702_e, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1702_e, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1697_b, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1697_b, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1697_b, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1697_b, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1702_e, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1702_e, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1697_b, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1697_b, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1697_b, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1697_b, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1702_e, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1702_e, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1702_e, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1702_e, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1697_b, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1702_e, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1702_e, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1698_a, p_142_0_.field_1697_b, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1697_b, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1702_e, p_142_0_.field_1704_c);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1702_e, p_142_0_.field_1701_f);
      var1.func_991_a(p_142_0_.field_1703_d, p_142_0_.field_1697_b, p_142_0_.field_1701_f);
      var1.func_982_a();
   }

   public void func_4009_a(RenderManager p_4009_1_) {
      this.field_191_a = p_4009_1_;
   }

   public void func_141_b(Entity p_141_1_, double p_141_2_, double p_141_4_, double p_141_6_, float p_141_8_, float p_141_9_) {
      if(this.field_191_a.field_1223_k.field_1576_i && this.field_9246_c > 0.0F) {
         double var10 = this.field_191_a.func_851_a(p_141_1_.field_611_ak, p_141_1_.field_610_al, p_141_1_.field_609_am);
         float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.field_194_c);
         if(var12 > 0.0F) {
            this.func_144_c(p_141_1_, p_141_2_, p_141_4_, p_141_6_, var12, p_141_9_);
         }
      }

      if(p_141_1_.func_21062_U()) {
         this.func_148_a(p_141_1_, p_141_2_, p_141_4_, p_141_6_, p_141_9_);
      }

   }

   public FontRenderer func_6329_a() {
      return this.field_191_a.func_6500_a();
   }
}
