package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelEnderman;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderEnderman extends RenderLiving {

   private ModelEnderman field_35444_c;
   private Random field_35445_h = new Random();


   public RenderEnderman() {
      super(new ModelEnderman(), 0.5F);
      this.field_35444_c = (ModelEnderman)super.field_20920_e;
      this.func_4013_a(this.field_35444_c);
   }

   public void func_35442_a(EntityEnderman p_35442_1_, double p_35442_2_, double p_35442_4_, double p_35442_6_, float p_35442_8_, float p_35442_9_) {
      this.field_35444_c.field_35407_a = p_35442_1_.func_35176_r() > 0;
      this.field_35444_c.field_35406_b = p_35442_1_.field_35187_a;
      if(p_35442_1_.field_35187_a) {
         double var10 = 0.02D;
         p_35442_2_ += this.field_35445_h.nextGaussian() * var10;
         p_35442_6_ += this.field_35445_h.nextGaussian() * var10;
      }

      super.func_171_a(p_35442_1_, p_35442_2_, p_35442_4_, p_35442_6_, p_35442_8_, p_35442_9_);
   }

   protected void func_35443_a(EntityEnderman p_35443_1_, float p_35443_2_) {
      super.func_6331_b(p_35443_1_, p_35443_2_);
      if(p_35443_1_.func_35176_r() > 0) {
         GL11.glEnable('\u803a');
         GL11.glPushMatrix();
         float var3 = 0.5F;
         GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
         var3 *= 1.0F;
         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(var3, -var3, var3);
         int var4 = p_35443_1_.func_35115_a(p_35443_2_);
         int var5 = var4 % 65536;
         int var6 = var4 / 65536;
         OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var5 / 1.0F, (float)var6 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.func_151_a("/terrain.png");
         this.field_203_d.func_1227_a(Block.field_345_n[p_35443_1_.func_35176_r()], p_35443_1_.func_35180_s(), 1.0F);
         GL11.glPopMatrix();
         GL11.glDisable('\u803a');
      }

   }

   protected int func_35441_a(EntityEnderman p_35441_1_, int p_35441_2_, float p_35441_3_) {
      if(p_35441_2_ != 0) {
         return -1;
      } else {
         this.func_151_a("/mob/enderman_eyes.png");
         float var4 = 1.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3008);
         GL11.glBlendFunc(1, 1);
         GL11.glDisable(2896);
         char var5 = '\uf0f0';
         int var6 = var5 % 65536;
         int var7 = var5 / 65536;
         OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var6 / 1.0F, (float)var7 / 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glEnable(2896);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
         return 1;
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_35441_a((EntityEnderman)p_166_1_, p_166_2_, p_166_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_35443_a((EntityEnderman)p_6331_1_, p_6331_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_35442_a((EntityEnderman)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_35442_a((EntityEnderman)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
