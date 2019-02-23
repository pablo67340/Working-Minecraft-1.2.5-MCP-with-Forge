package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.ModelMagmaCube;
import net.minecraft.src.RenderLiving;
import org.lwjgl.opengl.GL11;

public class RenderMagmaCube extends RenderLiving {

   private int field_40276_c;


   public RenderMagmaCube() {
      super(new ModelMagmaCube(), 0.25F);
      this.field_40276_c = ((ModelMagmaCube)this.field_20920_e).func_40343_a();
   }

   public void func_40275_a(EntityMagmaCube p_40275_1_, double p_40275_2_, double p_40275_4_, double p_40275_6_, float p_40275_8_, float p_40275_9_) {
      int var10 = ((ModelMagmaCube)this.field_20920_e).func_40343_a();
      if(var10 != this.field_40276_c) {
         this.field_40276_c = var10;
         this.field_20920_e = new ModelMagmaCube();
         System.out.println("new lava slime model");
      }

      super.func_171_a(p_40275_1_, p_40275_2_, p_40275_4_, p_40275_6_, p_40275_8_, p_40275_9_);
   }

   protected void func_40274_a(EntityMagmaCube p_40274_1_, float p_40274_2_) {
      int var3 = p_40274_1_.func_25027_v();
      float var4 = (p_40274_1_.field_767_b + (p_40274_1_.field_768_a - p_40274_1_.field_767_b) * p_40274_2_) / ((float)var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      float var6 = (float)var3;
      GL11.glScalef(var5 * var6, 1.0F / var5 * var6, var5 * var6);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_40274_a((EntityMagmaCube)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_40275_a((EntityMagmaCube)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_40275_a((EntityMagmaCube)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
