package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelIronGolem;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderIronGolem extends RenderLiving {

   private ModelIronGolem field_48422_c;


   public RenderIronGolem() {
      super(new ModelIronGolem(), 0.5F);
      this.field_48422_c = (ModelIronGolem)this.field_20920_e;
   }

   public void func_48421_a(EntityIronGolem p_48421_1_, double p_48421_2_, double p_48421_4_, double p_48421_6_, float p_48421_8_, float p_48421_9_) {
      super.func_171_a(p_48421_1_, p_48421_2_, p_48421_4_, p_48421_6_, p_48421_8_, p_48421_9_);
   }

   protected void func_48420_a(EntityIronGolem p_48420_1_, float p_48420_2_, float p_48420_3_, float p_48420_4_) {
      super.func_21004_a(p_48420_1_, p_48420_2_, p_48420_3_, p_48420_4_);
      if((double)p_48420_1_.field_704_R >= 0.01D) {
         float var5 = 13.0F;
         float var6 = p_48420_1_.field_703_S - p_48420_1_.field_704_R * (1.0F - p_48420_4_) + 6.0F;
         float var7 = (Math.abs(var6 % var5 - var5 * 0.5F) - var5 * 0.25F) / (var5 * 0.25F);
         GL11.glRotatef(6.5F * var7, 0.0F, 0.0F, 1.0F);
      }
   }

   protected void func_48419_a(EntityIronGolem p_48419_1_, float p_48419_2_) {
      super.func_6331_b(p_48419_1_, p_48419_2_);
      if(p_48419_1_.func_48117_D_() != 0) {
         GL11.glEnable('\u803a');
         GL11.glPushMatrix();
         GL11.glRotatef(5.0F + 180.0F * this.field_48422_c.field_48233_c.field_1407_d / 3.1415927F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
         GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         float var3 = 0.8F;
         GL11.glScalef(var3, -var3, var3);
         int var4 = p_48419_1_.func_35115_a(p_48419_2_);
         int var5 = var4 % 65536;
         int var6 = var4 / 65536;
         OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var5 / 1.0F, (float)var6 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_151_a("/terrain.png");
         this.field_203_d.func_1227_a(Block.field_416_af, 0, 1.0F);
         GL11.glPopMatrix();
         GL11.glDisable('\u803a');
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_48419_a((EntityIronGolem)p_6331_1_, p_6331_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_21004_a(EntityLiving p_21004_1_, float p_21004_2_, float p_21004_3_, float p_21004_4_) {
      this.func_48420_a((EntityIronGolem)p_21004_1_, p_21004_2_, p_21004_3_, p_21004_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_48421_a((EntityIronGolem)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_48421_a((EntityIronGolem)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
