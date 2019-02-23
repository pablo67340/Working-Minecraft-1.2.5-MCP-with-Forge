package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.Render;
import org.lwjgl.opengl.GL11;

public class RenderEntity extends Render {

   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      GL11.glPushMatrix();
      func_146_a(p_147_1_.field_601_au, p_147_2_ - p_147_1_.field_638_aI, p_147_4_ - p_147_1_.field_637_aJ, p_147_6_ - p_147_1_.field_636_aK);
      GL11.glPopMatrix();
   }
}
