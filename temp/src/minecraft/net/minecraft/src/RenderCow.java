package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderCow extends RenderLiving {

   public RenderCow(ModelBase p_i157_1_, float p_i157_2_) {
      super(p_i157_1_, p_i157_2_);
   }

   public void func_177_a(EntityCow p_177_1_, double p_177_2_, double p_177_4_, double p_177_6_, float p_177_8_, float p_177_9_) {
      super.func_171_a(p_177_1_, p_177_2_, p_177_4_, p_177_6_, p_177_8_, p_177_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_177_a((EntityCow)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_177_a((EntityCow)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
