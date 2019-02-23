package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class ModelEnderCrystal extends ModelBase {

   private ModelRenderer field_41057_g;
   private ModelRenderer field_41058_h = new ModelRenderer(this, "glass");
   private ModelRenderer field_41059_i;


   public ModelEnderCrystal(float p_i223_1_) {
      this.field_41058_h.func_40602_a(0, 0).func_40604_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      this.field_41057_g = new ModelRenderer(this, "cube");
      this.field_41057_g.func_40602_a(32, 0).func_40604_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      this.field_41059_i = new ModelRenderer(this, "base");
      this.field_41059_i.func_40602_a(0, 16).func_40604_a(-6.0F, 0.0F, -6.0F, 12, 4, 12);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      GL11.glPushMatrix();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      GL11.glTranslatef(0.0F, -0.5F, 0.0F);
      this.field_41059_i.func_922_a(p_864_7_);
      GL11.glRotatef(p_864_3_, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.8F + p_864_4_, 0.0F);
      GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
      this.field_41058_h.func_922_a(p_864_7_);
      float var8 = 0.875F;
      GL11.glScalef(var8, var8, var8);
      GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
      GL11.glRotatef(p_864_3_, 0.0F, 1.0F, 0.0F);
      this.field_41058_h.func_922_a(p_864_7_);
      GL11.glScalef(var8, var8, var8);
      GL11.glRotatef(60.0F, 0.7071F, 0.0F, 0.7071F);
      GL11.glRotatef(p_864_3_, 0.0F, 1.0F, 0.0F);
      this.field_41057_g.func_922_a(p_864_7_);
      GL11.glPopMatrix();
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
   }
}
