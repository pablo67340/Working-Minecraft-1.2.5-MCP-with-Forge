package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelEnderCrystal;
import net.minecraft.src.Render;
import org.lwjgl.opengl.GL11;

public class RenderEnderCrystal extends Render {

   private int field_41037_a = -1;
   private ModelBase field_41036_b;


   public RenderEnderCrystal() {
      this.field_9246_c = 0.5F;
   }

   public void func_41035_a(EntityEnderCrystal p_41035_1_, double p_41035_2_, double p_41035_4_, double p_41035_6_, float p_41035_8_, float p_41035_9_) {
      if(this.field_41037_a != 1) {
         this.field_41036_b = new ModelEnderCrystal(0.0F);
         this.field_41037_a = 1;
      }

      float var10 = (float)p_41035_1_.field_41032_a + p_41035_9_;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_41035_2_, (float)p_41035_4_, (float)p_41035_6_);
      this.func_151_a("/mob/enderdragon/crystal.png");
      float var11 = MathHelper.func_1106_a(var10 * 0.2F) / 2.0F + 0.5F;
      var11 += var11 * var11;
      this.field_41036_b.func_864_b(p_41035_1_, 0.0F, var10 * 3.0F, var11 * 0.2F, 0.0F, 0.0F, 0.0625F);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_41035_a((EntityEnderCrystal)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
