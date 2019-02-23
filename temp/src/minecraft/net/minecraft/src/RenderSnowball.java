package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityPotion;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderSnowball extends Render {

   private int field_20003_a;


   public RenderSnowball(int p_i269_1_) {
      this.field_20003_a = p_i269_1_;
   }

   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_147_2_, (float)p_147_4_, (float)p_147_6_);
      GL11.glEnable('\u803a');
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      this.func_151_a("/gui/items.png");
      Tessellator var10 = Tessellator.field_1512_a;
      if(this.field_20003_a == 154) {
         int var11 = PotionHelper.func_40358_a(((EntityPotion)p_147_1_).func_40088_g(), false);
         float var12 = (float)(var11 >> 16 & 255) / 255.0F;
         float var13 = (float)(var11 >> 8 & 255) / 255.0F;
         float var14 = (float)(var11 & 255) / 255.0F;
         GL11.glColor3f(var12, var13, var14);
         GL11.glPushMatrix();
         this.func_40265_a(var10, 141);
         GL11.glPopMatrix();
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
      }

      this.func_40265_a(var10, this.field_20003_a);
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
   }

   private void func_40265_a(Tessellator p_40265_1_, int p_40265_2_) {
      float var3 = (float)(p_40265_2_ % 16 * 16 + 0) / 256.0F;
      float var4 = (float)(p_40265_2_ % 16 * 16 + 16) / 256.0F;
      float var5 = (float)(p_40265_2_ / 16 * 16 + 0) / 256.0F;
      float var6 = (float)(p_40265_2_ / 16 * 16 + 16) / 256.0F;
      float var7 = 1.0F;
      float var8 = 0.5F;
      float var9 = 0.25F;
      GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
      p_40265_1_.func_977_b();
      p_40265_1_.func_980_b(0.0F, 1.0F, 0.0F);
      p_40265_1_.func_983_a((double)(0.0F - var8), (double)(0.0F - var9), 0.0D, (double)var3, (double)var6);
      p_40265_1_.func_983_a((double)(var7 - var8), (double)(0.0F - var9), 0.0D, (double)var4, (double)var6);
      p_40265_1_.func_983_a((double)(var7 - var8), (double)(var7 - var9), 0.0D, (double)var4, (double)var5);
      p_40265_1_.func_983_a((double)(0.0F - var8), (double)(var7 - var9), 0.0D, (double)var3, (double)var5);
      p_40265_1_.func_982_a();
   }
}
