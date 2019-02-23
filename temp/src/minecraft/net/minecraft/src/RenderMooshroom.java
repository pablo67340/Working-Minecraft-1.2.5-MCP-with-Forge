package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMooshroom;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelQuadruped;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderMooshroom extends RenderLiving {

   public RenderMooshroom(ModelBase p_i265_1_, float p_i265_2_) {
      super(p_i265_1_, p_i265_2_);
   }

   public void func_40273_a(EntityMooshroom p_40273_1_, double p_40273_2_, double p_40273_4_, double p_40273_6_, float p_40273_8_, float p_40273_9_) {
      super.func_171_a(p_40273_1_, p_40273_2_, p_40273_4_, p_40273_6_, p_40273_8_, p_40273_9_);
   }

   protected void func_40272_a(EntityMooshroom p_40272_1_, float p_40272_2_) {
      super.func_6331_b(p_40272_1_, p_40272_2_);
      if(!p_40272_1_.func_40127_l()) {
         this.func_151_a("/terrain.png");
         GL11.glEnable(2884);
         GL11.glPushMatrix();
         GL11.glScalef(1.0F, -1.0F, 1.0F);
         GL11.glTranslatef(0.2F, 0.4F, 0.5F);
         GL11.glRotatef(42.0F, 0.0F, 1.0F, 0.0F);
         this.field_203_d.func_1227_a(Block.field_414_ah, 0, 1.0F);
         GL11.glTranslatef(0.1F, 0.0F, -0.6F);
         GL11.glRotatef(42.0F, 0.0F, 1.0F, 0.0F);
         this.field_203_d.func_1227_a(Block.field_414_ah, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         ((ModelQuadruped)this.field_20920_e).field_1266_d.func_926_b(0.0625F);
         GL11.glScalef(1.0F, -1.0F, 1.0F);
         GL11.glTranslatef(0.0F, 0.75F, -0.2F);
         GL11.glRotatef(12.0F, 0.0F, 1.0F, 0.0F);
         this.field_203_d.func_1227_a(Block.field_414_ah, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glDisable(2884);
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_40272_a((EntityMooshroom)p_6331_1_, p_6331_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_40273_a((EntityMooshroom)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_40273_a((EntityMooshroom)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
