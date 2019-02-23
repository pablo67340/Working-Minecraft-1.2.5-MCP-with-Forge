package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderBiped extends RenderLiving {

   protected ModelBiped field_4013_a;
   protected float field_40296_d;


   public RenderBiped(ModelBiped p_i605_1_, float p_i605_2_) {
      this(p_i605_1_, p_i605_2_, 1.0F);
      this.field_4013_a = p_i605_1_;
   }

   public RenderBiped(ModelBiped p_i606_1_, float p_i606_2_, float p_i606_3_) {
      super(p_i606_1_, p_i606_2_);
      this.field_4013_a = p_i606_1_;
      this.field_40296_d = p_i606_3_;
   }

   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      super.func_6331_b(p_6331_1_, p_6331_2_);
      ItemStack var3 = p_6331_1_.func_4045_l();
      if(var3 != null) {
         GL11.glPushMatrix();
         this.field_4013_a.field_1283_d.func_926_b(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         float var4;
         if(var3.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var3.field_1617_c].func_210_f())) {
            var4 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var4 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
         } else if(var3.field_1617_c == Item.field_227_i.field_291_aS) {
            var4 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(Item.field_233_c[var3.field_1617_c].func_4017_a()) {
            var4 = 0.625F;
            GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var4 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var4, var4, var4);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         this.field_191_a.field_4236_f.func_4132_a(p_6331_1_, var3, 0);
         if(var3.func_1091_a().func_46058_c()) {
            this.field_191_a.field_4236_f.func_4132_a(p_6331_1_, var3, 1);
         }

         GL11.glPopMatrix();
      }

   }
}
