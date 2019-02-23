package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderArrow extends Render {

   public void func_154_a(EntityArrow p_154_1_, double p_154_2_, double p_154_4_, double p_154_6_, float p_154_8_, float p_154_9_) {
      this.func_151_a("/item/arrows.png");
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_154_2_, (float)p_154_4_, (float)p_154_6_);
      GL11.glRotatef(p_154_1_.field_603_as + (p_154_1_.field_605_aq - p_154_1_.field_603_as) * p_154_9_ - 90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(p_154_1_.field_602_at + (p_154_1_.field_604_ar - p_154_1_.field_602_at) * p_154_9_, 0.0F, 0.0F, 1.0F);
      Tessellator var10 = Tessellator.field_1512_a;
      byte var11 = 0;
      float var12 = 0.0F;
      float var13 = 0.5F;
      float var14 = (float)(0 + var11 * 10) / 32.0F;
      float var15 = (float)(5 + var11 * 10) / 32.0F;
      float var16 = 0.0F;
      float var17 = 0.15625F;
      float var18 = (float)(5 + var11 * 10) / 32.0F;
      float var19 = (float)(10 + var11 * 10) / 32.0F;
      float var20 = 0.05625F;
      GL11.glEnable('\u803a');
      float var21 = (float)p_154_1_.field_688_a - p_154_9_;
      if(var21 > 0.0F) {
         float var22 = -MathHelper.func_1106_a(var21 * 3.0F) * var21;
         GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
      }

      GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
      GL11.glScalef(var20, var20, var20);
      GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
      GL11.glNormal3f(var20, 0.0F, 0.0F);
      var10.func_977_b();
      var10.func_983_a(-7.0D, -2.0D, -2.0D, (double)var16, (double)var18);
      var10.func_983_a(-7.0D, -2.0D, 2.0D, (double)var17, (double)var18);
      var10.func_983_a(-7.0D, 2.0D, 2.0D, (double)var17, (double)var19);
      var10.func_983_a(-7.0D, 2.0D, -2.0D, (double)var16, (double)var19);
      var10.func_982_a();
      GL11.glNormal3f(-var20, 0.0F, 0.0F);
      var10.func_977_b();
      var10.func_983_a(-7.0D, 2.0D, -2.0D, (double)var16, (double)var18);
      var10.func_983_a(-7.0D, 2.0D, 2.0D, (double)var17, (double)var18);
      var10.func_983_a(-7.0D, -2.0D, 2.0D, (double)var17, (double)var19);
      var10.func_983_a(-7.0D, -2.0D, -2.0D, (double)var16, (double)var19);
      var10.func_982_a();

      for(int var23 = 0; var23 < 4; ++var23) {
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glNormal3f(0.0F, 0.0F, var20);
         var10.func_977_b();
         var10.func_983_a(-8.0D, -2.0D, 0.0D, (double)var12, (double)var14);
         var10.func_983_a(8.0D, -2.0D, 0.0D, (double)var13, (double)var14);
         var10.func_983_a(8.0D, 2.0D, 0.0D, (double)var13, (double)var15);
         var10.func_983_a(-8.0D, 2.0D, 0.0D, (double)var12, (double)var15);
         var10.func_982_a();
      }

      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_154_a((EntityArrow)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
