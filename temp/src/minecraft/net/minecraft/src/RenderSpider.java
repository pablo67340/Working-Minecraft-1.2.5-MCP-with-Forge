package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.ModelSpider;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderSpider extends RenderLiving {

   public RenderSpider() {
      super(new ModelSpider(), 1.0F);
      this.func_4013_a(new ModelSpider());
   }

   protected float func_191_a(EntitySpider p_191_1_) {
      return 180.0F;
   }

   protected int func_190_a(EntitySpider p_190_1_, int p_190_2_, float p_190_3_) {
      if(p_190_2_ != 0) {
         return -1;
      } else {
         this.func_151_a("/mob/spider_eyes.png");
         float var4 = 1.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3008);
         GL11.glBlendFunc(1, 1);
         char var5 = '\uf0f0';
         int var6 = var5 % 65536;
         int var7 = var5 / 65536;
         OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
         return 1;
      }
   }

   protected void func_35446_a(EntitySpider p_35446_1_, float p_35446_2_) {
      float var3 = p_35446_1_.func_35188_k_();
      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_35446_a((EntitySpider)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected float func_172_a(EntityLiving p_172_1_) {
      return this.func_191_a((EntitySpider)p_172_1_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_190_a((EntitySpider)p_166_1_, p_166_2_, p_166_3_);
   }
}
