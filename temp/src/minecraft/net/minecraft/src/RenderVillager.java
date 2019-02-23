package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.ModelVillager;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderVillager extends RenderLiving {

   protected ModelVillager field_40295_c;


   public RenderVillager() {
      super(new ModelVillager(0.0F), 0.5F);
      this.field_40295_c = (ModelVillager)this.field_20920_e;
   }

   protected int func_40293_a(EntityVillager p_40293_1_, int p_40293_2_, float p_40293_3_) {
      return -1;
   }

   public void func_40294_a(EntityVillager p_40294_1_, double p_40294_2_, double p_40294_4_, double p_40294_6_, float p_40294_8_, float p_40294_9_) {
      super.func_171_a(p_40294_1_, p_40294_2_, p_40294_4_, p_40294_6_, p_40294_8_, p_40294_9_);
   }

   protected void func_40290_a(EntityVillager p_40290_1_, double p_40290_2_, double p_40290_4_, double p_40290_6_) {}

   protected void func_40291_a(EntityVillager p_40291_1_, float p_40291_2_) {
      super.func_6331_b(p_40291_1_, p_40291_2_);
   }

   protected void func_40292_b(EntityVillager p_40292_1_, float p_40292_2_) {
      float var3 = 0.9375F;
      if(p_40292_1_.func_48123_at() < 0) {
         var3 = (float)((double)var3 * 0.5D);
         this.field_9246_c = 0.25F;
      } else {
         this.field_9246_c = 0.5F;
      }

      GL11.glScalef(var3, var3, var3);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_22014_a(EntityLiving p_22014_1_, double p_22014_2_, double p_22014_4_, double p_22014_6_) {
      this.func_40290_a((EntityVillager)p_22014_1_, p_22014_2_, p_22014_4_, p_22014_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_40292_b((EntityVillager)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_40293_a((EntityVillager)p_166_1_, p_166_2_, p_166_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_40291_a((EntityVillager)p_6331_1_, p_6331_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_40294_a((EntityVillager)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_40294_a((EntityVillager)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
