package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderFallingSand extends Render {

   private RenderBlocks field_197_d = new RenderBlocks();


   public RenderFallingSand() {
      this.field_9246_c = 0.5F;
   }

   public void func_156_a(EntityFallingSand p_156_1_, double p_156_2_, double p_156_4_, double p_156_6_, float p_156_8_, float p_156_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_156_2_, (float)p_156_4_, (float)p_156_6_);
      this.func_151_a("/terrain.png");
      Block var10 = Block.field_345_n[p_156_1_.field_799_a];
      World var11 = p_156_1_.func_465_i();
      GL11.glDisable(2896);
      if(var10 == Block.field_41050_bK) {
         this.field_197_d.field_1772_a = var11;
         Tessellator var12 = Tessellator.field_1512_a;
         var12.func_977_b();
         var12.func_984_b((double)((float)(-MathHelper.func_1108_b(p_156_1_.field_611_ak)) - 0.5F), (double)((float)(-MathHelper.func_1108_b(p_156_1_.field_610_al)) - 0.5F), (double)((float)(-MathHelper.func_1108_b(p_156_1_.field_609_am)) - 0.5F));
         this.field_197_d.func_1234_a(var10, MathHelper.func_1108_b(p_156_1_.field_611_ak), MathHelper.func_1108_b(p_156_1_.field_610_al), MathHelper.func_1108_b(p_156_1_.field_609_am));
         var12.func_984_b(0.0D, 0.0D, 0.0D);
         var12.func_982_a();
      } else {
         this.field_197_d.func_1243_a(var10, var11, MathHelper.func_1108_b(p_156_1_.field_611_ak), MathHelper.func_1108_b(p_156_1_.field_610_al), MathHelper.func_1108_b(p_156_1_.field_609_am));
      }

      GL11.glEnable(2896);
      GL11.glPopMatrix();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_156_a((EntityFallingSand)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
