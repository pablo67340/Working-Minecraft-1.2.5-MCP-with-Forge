package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderSlime extends RenderLiving {

   private ModelBase field_205_f;


   public RenderSlime(ModelBase p_i386_1_, ModelBase p_i386_2_, float p_i386_3_) {
      super(p_i386_1_, p_i386_3_);
      this.field_205_f = p_i386_2_;
   }

   protected int func_40287_a(EntitySlime p_40287_1_, int p_40287_2_, float p_40287_3_) {
      if(p_40287_2_ == 0) {
         this.func_4013_a(this.field_205_f);
         GL11.glEnable(2977);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         return 1;
      } else {
         if(p_40287_2_ == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         }

         return -1;
      }
   }

   protected void func_178_a(EntitySlime p_178_1_, float p_178_2_) {
      int var3 = p_178_1_.func_25027_v();
      float var4 = (p_178_1_.field_767_b + (p_178_1_.field_768_a - p_178_1_.field_767_b) * p_178_2_) / ((float)var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      float var6 = (float)var3;
      GL11.glScalef(var5 * var6, 1.0F / var5 * var6, var5 * var6);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_178_a((EntitySlime)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_40287_a((EntitySlime)p_166_1_, p_166_2_, p_166_3_);
   }
}
