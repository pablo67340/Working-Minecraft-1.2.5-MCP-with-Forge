package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;

public class RenderWolf extends RenderLiving {

   public RenderWolf(ModelBase p_i179_1_, float p_i179_2_) {
      super(p_i179_1_, p_i179_2_);
   }

   public void func_25005_a(EntityWolf p_25005_1_, double p_25005_2_, double p_25005_4_, double p_25005_6_, float p_25005_8_, float p_25005_9_) {
      super.func_171_a(p_25005_1_, p_25005_2_, p_25005_4_, p_25005_6_, p_25005_8_, p_25005_9_);
   }

   protected float func_25004_a(EntityWolf p_25004_1_, float p_25004_2_) {
      return p_25004_1_.func_25037_z();
   }

   protected void func_25006_b(EntityWolf p_25006_1_, float p_25006_2_) {}

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_25006_b((EntityWolf)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected float func_170_d(EntityLiving p_170_1_, float p_170_2_) {
      return this.func_25004_a((EntityWolf)p_170_1_, p_170_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_25005_a((EntityWolf)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_25005_a((EntityWolf)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
