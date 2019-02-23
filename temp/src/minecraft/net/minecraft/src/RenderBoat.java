package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityBoat;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelBoat;
import net.minecraft.src.Render;
import org.lwjgl.opengl.GL11;

public class RenderBoat extends Render {

   protected ModelBase field_198_d;


   public RenderBoat() {
      this.field_9246_c = 0.5F;
      this.field_198_d = new ModelBoat();
   }

   public void func_157_a(EntityBoat p_157_1_, double p_157_2_, double p_157_4_, double p_157_6_, float p_157_8_, float p_157_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_157_2_, (float)p_157_4_, (float)p_157_6_);
      GL11.glRotatef(180.0F - p_157_8_, 0.0F, 1.0F, 0.0F);
      float var10 = (float)p_157_1_.func_41018_h() - p_157_9_;
      float var11 = (float)p_157_1_.func_41020_g() - p_157_9_;
      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var10 > 0.0F) {
         GL11.glRotatef(MathHelper.func_1106_a(var10) * var10 * var11 / 10.0F * (float)p_157_1_.func_41016_i(), 1.0F, 0.0F, 0.0F);
      }

      this.func_151_a("/terrain.png");
      float var12 = 0.75F;
      GL11.glScalef(var12, var12, var12);
      GL11.glScalef(1.0F / var12, 1.0F / var12, 1.0F / var12);
      this.func_151_a("/item/boat.png");
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.field_198_d.func_864_b(p_157_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_157_a((EntityBoat)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
