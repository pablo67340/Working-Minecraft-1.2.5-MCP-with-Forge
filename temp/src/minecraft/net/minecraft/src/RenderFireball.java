package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityFireball;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderFireball extends Render {

   private float field_40269_a;


   public RenderFireball(float p_i774_1_) {
      this.field_40269_a = p_i774_1_;
   }

   public void func_4012_a(EntityFireball p_4012_1_, double p_4012_2_, double p_4012_4_, double p_4012_6_, float p_4012_8_, float p_4012_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_4012_2_, (float)p_4012_4_, (float)p_4012_6_);
      GL11.glEnable('\u803a');
      float var10 = this.field_40269_a;
      GL11.glScalef(var10 / 1.0F, var10 / 1.0F, var10 / 1.0F);
      byte var11 = 46;
      this.func_151_a("/gui/items.png");
      Tessellator var12 = Tessellator.field_1512_a;
      float var13 = (float)(var11 % 16 * 16 + 0) / 256.0F;
      float var14 = (float)(var11 % 16 * 16 + 16) / 256.0F;
      float var15 = (float)(var11 / 16 * 16 + 0) / 256.0F;
      float var16 = (float)(var11 / 16 * 16 + 16) / 256.0F;
      float var17 = 1.0F;
      float var18 = 0.5F;
      float var19 = 0.25F;
      GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
      var12.func_977_b();
      var12.func_980_b(0.0F, 1.0F, 0.0F);
      var12.func_983_a((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
      var12.func_983_a((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
      var12.func_983_a((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
      var12.func_983_a((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
      var12.func_982_a();
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_4012_a((EntityFireball)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
