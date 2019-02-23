package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySnowman;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelSnowMan;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderSnowMan extends RenderLiving {

   private ModelSnowMan field_40289_c;


   public RenderSnowMan() {
      super(new ModelSnowMan(), 0.5F);
      this.field_40289_c = (ModelSnowMan)super.field_20920_e;
      this.func_4013_a(this.field_40289_c);
   }

   protected void func_40288_a(EntitySnowman p_40288_1_, float p_40288_2_) {
      super.func_6331_b(p_40288_1_, p_40288_2_);
      ItemStack var3 = new ItemStack(Block.field_4055_bb, 1);
      if(var3 != null && var3.func_1091_a().field_291_aS < 256) {
         GL11.glPushMatrix();
         this.field_40289_c.field_40305_c.func_926_b(0.0625F);
         if(RenderBlocks.func_1219_a(Block.field_345_n[var3.field_1617_c].func_210_f())) {
            float var4 = 0.625F;
            GL11.glTranslatef(0.0F, -0.34375F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
         }

         this.field_191_a.field_4236_f.func_4132_a(p_40288_1_, var3, 0);
         GL11.glPopMatrix();
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_40288_a((EntitySnowman)p_6331_1_, p_6331_2_);
   }
}
