package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.Random;
import net.minecraft.src.ActiveRenderInfo;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEndPortal;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class RenderEndPortal extends TileEntitySpecialRenderer {

   FloatBuffer field_40448_a = GLAllocation.func_1123_d(16);


   public void func_40446_a(TileEntityEndPortal p_40446_1_, double p_40446_2_, double p_40446_4_, double p_40446_6_, float p_40446_8_) {
      float var9 = (float)this.field_6509_a.field_1545_j;
      float var10 = (float)this.field_6509_a.field_1544_k;
      float var11 = (float)this.field_6509_a.field_1543_l;
      GL11.glDisable(2896);
      Random var12 = new Random(31100L);
      float var13 = 0.75F;

      for(int var14 = 0; var14 < 16; ++var14) {
         GL11.glPushMatrix();
         float var15 = (float)(16 - var14);
         float var16 = 0.0625F;
         float var17 = 1.0F / (var15 + 1.0F);
         if(var14 == 0) {
            this.func_6507_a("/misc/tunnel.png");
            var17 = 0.1F;
            var15 = 65.0F;
            var16 = 0.125F;
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
         }

         if(var14 == 1) {
            this.func_6507_a("/misc/particlefield.png");
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            var16 = 0.5F;
         }

         float var18 = (float)(-(p_40446_4_ + (double)var13));
         float var19 = var18 + ActiveRenderInfo.field_41072_b;
         float var20 = var18 + var15 + ActiveRenderInfo.field_41072_b;
         float var21 = var19 / var20;
         var21 += (float)(p_40446_4_ + (double)var13);
         GL11.glTranslatef(var9, var21, var11);
         GL11.glTexGeni(8192, 9472, 9217);
         GL11.glTexGeni(8193, 9472, 9217);
         GL11.glTexGeni(8194, 9472, 9217);
         GL11.glTexGeni(8195, 9472, 9216);
         GL11.glTexGen(8192, 9473, this.func_40447_a(1.0F, 0.0F, 0.0F, 0.0F));
         GL11.glTexGen(8193, 9473, this.func_40447_a(0.0F, 0.0F, 1.0F, 0.0F));
         GL11.glTexGen(8194, 9473, this.func_40447_a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glTexGen(8195, 9474, this.func_40447_a(0.0F, 1.0F, 0.0F, 0.0F));
         GL11.glEnable(3168);
         GL11.glEnable(3169);
         GL11.glEnable(3170);
         GL11.glEnable(3171);
         GL11.glPopMatrix();
         GL11.glMatrixMode(5890);
         GL11.glPushMatrix();
         GL11.glLoadIdentity();
         GL11.glTranslatef(0.0F, (float)(System.currentTimeMillis() % 700000L) / 700000.0F, 0.0F);
         GL11.glScalef(var16, var16, var16);
         GL11.glTranslatef(0.5F, 0.5F, 0.0F);
         GL11.glRotatef((float)(var14 * var14 * 4321 + var14 * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
         GL11.glTranslatef(-var9, -var11, -var10);
         var19 = var18 + ActiveRenderInfo.field_41072_b;
         GL11.glTranslatef(ActiveRenderInfo.field_41074_a * var15 / var19, ActiveRenderInfo.field_41073_c * var15 / var19, -var10);
         Tessellator var24 = Tessellator.field_1512_a;
         var24.func_977_b();
         var21 = var12.nextFloat() * 0.5F + 0.1F;
         float var22 = var12.nextFloat() * 0.5F + 0.4F;
         float var23 = var12.nextFloat() * 0.5F + 0.5F;
         if(var14 == 0) {
            var23 = 1.0F;
            var22 = 1.0F;
            var21 = 1.0F;
         }

         var24.func_986_a(var21 * var17, var22 * var17, var23 * var17, 1.0F);
         var24.func_991_a(p_40446_2_, p_40446_4_ + (double)var13, p_40446_6_);
         var24.func_991_a(p_40446_2_, p_40446_4_ + (double)var13, p_40446_6_ + 1.0D);
         var24.func_991_a(p_40446_2_ + 1.0D, p_40446_4_ + (double)var13, p_40446_6_ + 1.0D);
         var24.func_991_a(p_40446_2_ + 1.0D, p_40446_4_ + (double)var13, p_40446_6_);
         var24.func_982_a();
         GL11.glPopMatrix();
         GL11.glMatrixMode(5888);
      }

      GL11.glDisable(3042);
      GL11.glDisable(3168);
      GL11.glDisable(3169);
      GL11.glDisable(3170);
      GL11.glDisable(3171);
      GL11.glEnable(2896);
   }

   private FloatBuffer func_40447_a(float p_40447_1_, float p_40447_2_, float p_40447_3_, float p_40447_4_) {
      this.field_40448_a.clear();
      this.field_40448_a.put(p_40447_1_).put(p_40447_2_).put(p_40447_3_).put(p_40447_4_);
      this.field_40448_a.flip();
      return this.field_40448_a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_930_a(TileEntity p_930_1_, double p_930_2_, double p_930_4_, double p_930_6_, float p_930_8_) {
      this.func_40446_a((TileEntityEndPortal)p_930_1_, p_930_2_, p_930_4_, p_930_6_, p_930_8_);
   }
}
