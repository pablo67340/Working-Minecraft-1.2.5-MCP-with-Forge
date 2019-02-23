package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.MathHelper;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderXPOrb extends Render {

   private RenderBlocks field_35439_b = new RenderBlocks();
   public boolean field_35440_a = true;


   public RenderXPOrb() {
      this.field_9246_c = 0.15F;
      this.field_194_c = 0.75F;
   }

   public void func_35438_a(EntityXPOrb p_35438_1_, double p_35438_2_, double p_35438_4_, double p_35438_6_, float p_35438_8_, float p_35438_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_35438_2_, (float)p_35438_4_, (float)p_35438_6_);
      int var10 = p_35438_1_.func_35120_i();
      this.func_151_a("/item/xporb.png");
      Tessellator var11 = Tessellator.field_1512_a;
      float var12 = (float)(var10 % 4 * 16 + 0) / 64.0F;
      float var13 = (float)(var10 % 4 * 16 + 16) / 64.0F;
      float var14 = (float)(var10 / 4 * 16 + 0) / 64.0F;
      float var15 = (float)(var10 / 4 * 16 + 16) / 64.0F;
      float var16 = 1.0F;
      float var17 = 0.5F;
      float var18 = 0.25F;
      int var19 = p_35438_1_.func_35115_a(p_35438_9_);
      int var20 = var19 % 65536;
      int var21 = var19 / 65536;
      OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var20 / 1.0F, (float)var21 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var26 = 255.0F;
      float var27 = ((float)p_35438_1_.field_35127_a + p_35438_9_) / 2.0F;
      var21 = (int)((MathHelper.func_1106_a(var27 + 0.0F) + 1.0F) * 0.5F * var26);
      int var22 = (int)var26;
      int var23 = (int)((MathHelper.func_1106_a(var27 + 4.1887903F) + 1.0F) * 0.1F * var26);
      int var24 = var21 << 16 | var22 << 8 | var23;
      GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
      float var25 = 0.3F;
      GL11.glScalef(var25, var25, var25);
      var11.func_977_b();
      var11.func_6513_a(var24, 128);
      var11.func_980_b(0.0F, 1.0F, 0.0F);
      var11.func_983_a((double)(0.0F - var17), (double)(0.0F - var18), 0.0D, (double)var12, (double)var15);
      var11.func_983_a((double)(var16 - var17), (double)(0.0F - var18), 0.0D, (double)var13, (double)var15);
      var11.func_983_a((double)(var16 - var17), (double)(1.0F - var18), 0.0D, (double)var13, (double)var14);
      var11.func_983_a((double)(0.0F - var17), (double)(1.0F - var18), 0.0D, (double)var12, (double)var14);
      var11.func_982_a();
      GL11.glDisable(3042);
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_35438_a((EntityXPOrb)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
