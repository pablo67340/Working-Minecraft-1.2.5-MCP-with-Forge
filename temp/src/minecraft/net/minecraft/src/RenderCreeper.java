package net.minecraft.src;

import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelCreeper;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderCreeper extends RenderLiving {

   private ModelBase field_27008_a = new ModelCreeper(2.0F);


   public RenderCreeper() {
      super(new ModelCreeper(), 0.5F);
   }

   protected void func_184_a(EntityCreeper p_184_1_, float p_184_2_) {
      float var4 = p_184_1_.func_440_b(p_184_2_);
      float var5 = 1.0F + MathHelper.func_1106_a(var4 * 100.0F) * var4 * 0.01F;
      if(var4 < 0.0F) {
         var4 = 0.0F;
      }

      if(var4 > 1.0F) {
         var4 = 1.0F;
      }

      var4 *= var4;
      var4 *= var4;
      float var6 = (1.0F + var4 * 0.4F) * var5;
      float var7 = (1.0F + var4 * 0.1F) / var5;
      GL11.glScalef(var6, var7, var6);
   }

   protected int func_183_a(EntityCreeper p_183_1_, float p_183_2_, float p_183_3_) {
      float var5 = p_183_1_.func_440_b(p_183_3_);
      if((int)(var5 * 10.0F) % 2 == 0) {
         return 0;
      } else {
         int var6 = (int)(var5 * 0.2F * 255.0F);
         if(var6 < 0) {
            var6 = 0;
         }

         if(var6 > 255) {
            var6 = 255;
         }

         short var7 = 255;
         short var8 = 255;
         short var9 = 255;
         return var6 << 24 | var7 << 16 | var8 << 8 | var9;
      }
   }

   protected int func_27006_a(EntityCreeper p_27006_1_, int p_27006_2_, float p_27006_3_) {
      if(p_27006_1_.func_27022_s()) {
         if(p_27006_2_ == 1) {
            float var4 = (float)p_27006_1_.field_9311_be + p_27006_3_;
            this.func_151_a("/armor/power.png");
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            float var5 = var4 * 0.01F;
            float var6 = var4 * 0.01F;
            GL11.glTranslatef(var5, var6, 0.0F);
            this.func_4013_a(this.field_27008_a);
            GL11.glMatrixMode(5888);
            GL11.glEnable(3042);
            float var7 = 0.5F;
            GL11.glColor4f(var7, var7, var7, 1.0F);
            GL11.glDisable(2896);
            GL11.glBlendFunc(1, 1);
            return 1;
         }

         if(p_27006_2_ == 2) {
            GL11.glMatrixMode(5890);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
         }
      }

      return -1;
   }

   protected int func_27007_b(EntityCreeper p_27007_1_, int p_27007_2_, float p_27007_3_) {
      return -1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_184_a((EntityCreeper)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_173_a(EntityLiving p_173_1_, float p_173_2_, float p_173_3_) {
      return this.func_183_a((EntityCreeper)p_173_1_, p_173_2_, p_173_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_27006_a((EntityCreeper)p_166_1_, p_166_2_, p_166_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_27005_b(EntityLiving p_27005_1_, int p_27005_2_, float p_27005_3_) {
      return this.func_27007_b((EntityCreeper)p_27005_1_, p_27005_2_, p_27005_3_);
   }
}
