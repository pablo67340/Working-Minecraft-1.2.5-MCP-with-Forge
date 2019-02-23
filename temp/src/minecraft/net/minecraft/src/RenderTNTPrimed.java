package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import org.lwjgl.opengl.GL11;

public class RenderTNTPrimed extends Render {

   private RenderBlocks field_196_d = new RenderBlocks();


   public RenderTNTPrimed() {
      this.field_9246_c = 0.5F;
   }

   public void func_153_a(EntityTNTPrimed p_153_1_, double p_153_2_, double p_153_4_, double p_153_6_, float p_153_8_, float p_153_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_153_2_, (float)p_153_4_, (float)p_153_6_);
      float var10;
      if((float)p_153_1_.field_689_a - p_153_9_ + 1.0F < 10.0F) {
         var10 = 1.0F - ((float)p_153_1_.field_689_a - p_153_9_ + 1.0F) / 10.0F;
         if(var10 < 0.0F) {
            var10 = 0.0F;
         }

         if(var10 > 1.0F) {
            var10 = 1.0F;
         }

         var10 *= var10;
         var10 *= var10;
         float var11 = 1.0F + var10 * 0.3F;
         GL11.glScalef(var11, var11, var11);
      }

      var10 = (1.0F - ((float)p_153_1_.field_689_a - p_153_9_ + 1.0F) / 100.0F) * 0.8F;
      this.func_151_a("/terrain.png");
      this.field_196_d.func_1227_a(Block.field_408_an, 0, p_153_1_.func_382_a(p_153_9_));
      if(p_153_1_.field_689_a / 5 % 2 == 0) {
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 772);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var10);
         this.field_196_d.func_1227_a(Block.field_408_an, 0, 1.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glEnable(3553);
      }

      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_153_a((EntityTNTPrimed)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
