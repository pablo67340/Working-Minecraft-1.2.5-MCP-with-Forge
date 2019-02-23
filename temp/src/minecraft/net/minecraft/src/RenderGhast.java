package net.minecraft.src;

import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelGhast;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderGhast extends RenderLiving {

   public RenderGhast() {
      super(new ModelGhast(), 0.5F);
   }

   protected void func_4014_a(EntityGhast p_4014_1_, float p_4014_2_) {
      float var4 = ((float)p_4014_1_.field_4125_e + (float)(p_4014_1_.field_4124_f - p_4014_1_.field_4125_e) * p_4014_2_) / 20.0F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      var4 = 1.0F / (var4 * var4 * var4 * var4 * var4 * 2.0F + 1.0F);
      float var5 = (8.0F + var4) / 2.0F;
      float var6 = (8.0F + 1.0F / var4) / 2.0F;
      GL11.glScalef(var6, var5, var6);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_4014_a((EntityGhast)p_6330_1_, p_6330_2_);
   }
}
