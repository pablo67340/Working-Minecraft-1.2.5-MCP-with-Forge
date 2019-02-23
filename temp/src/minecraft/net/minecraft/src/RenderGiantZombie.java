package net.minecraft.src;

import net.minecraft.src.EntityGiantZombie;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderGiantZombie extends RenderLiving {

   private float field_204_f;


   public RenderGiantZombie(ModelBase p_i213_1_, float p_i213_2_, float p_i213_3_) {
      super(p_i213_1_, p_i213_2_ * p_i213_3_);
      this.field_204_f = p_i213_3_;
   }

   protected void func_175_a(EntityGiantZombie p_175_1_, float p_175_2_) {
      GL11.glScalef(this.field_204_f, this.field_204_f, this.field_204_f);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_175_a((EntityGiantZombie)p_6330_1_, p_6330_2_);
   }
}
