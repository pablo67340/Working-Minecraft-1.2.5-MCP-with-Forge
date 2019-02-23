package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBook extends ModelBase {

   public ModelRenderer field_40330_a = (new ModelRenderer(this)).func_40602_a(0, 0).func_40604_a(-6.0F, -5.0F, 0.0F, 6, 10, 0);
   public ModelRenderer field_40328_b = (new ModelRenderer(this)).func_40602_a(16, 0).func_40604_a(0.0F, -5.0F, 0.0F, 6, 10, 0);
   public ModelRenderer field_40329_c = (new ModelRenderer(this)).func_40602_a(0, 10).func_40604_a(0.0F, -4.0F, -0.99F, 5, 8, 1);
   public ModelRenderer field_40326_d = (new ModelRenderer(this)).func_40602_a(12, 10).func_40604_a(0.0F, -4.0F, -0.01F, 5, 8, 1);
   public ModelRenderer field_40327_e = (new ModelRenderer(this)).func_40602_a(24, 10).func_40604_a(0.0F, -4.0F, 0.0F, 5, 8, 0);
   public ModelRenderer field_40324_f = (new ModelRenderer(this)).func_40602_a(24, 10).func_40604_a(0.0F, -4.0F, 0.0F, 5, 8, 0);
   public ModelRenderer field_40325_g = (new ModelRenderer(this)).func_40602_a(12, 0).func_40604_a(-1.0F, -5.0F, 0.0F, 2, 10, 0);


   public ModelBook() {
      this.field_40330_a.func_925_a(0.0F, 0.0F, -1.0F);
      this.field_40328_b.func_925_a(0.0F, 0.0F, 1.0F);
      this.field_40325_g.field_1406_e = 1.5707964F;
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_40330_a.func_922_a(p_864_7_);
      this.field_40328_b.func_922_a(p_864_7_);
      this.field_40325_g.func_922_a(p_864_7_);
      this.field_40329_c.func_922_a(p_864_7_);
      this.field_40326_d.func_922_a(p_864_7_);
      this.field_40327_e.func_922_a(p_864_7_);
      this.field_40324_f.func_922_a(p_864_7_);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      float var7 = (MathHelper.func_1106_a(p_863_1_ * 0.02F) * 0.1F + 1.25F) * p_863_4_;
      this.field_40330_a.field_1406_e = 3.1415927F + var7;
      this.field_40328_b.field_1406_e = -var7;
      this.field_40329_c.field_1406_e = var7;
      this.field_40326_d.field_1406_e = -var7;
      this.field_40327_e.field_1406_e = var7 - var7 * 2.0F * p_863_2_;
      this.field_40324_f.field_1406_e = var7 - var7 * 2.0F * p_863_3_;
      this.field_40329_c.field_1410_a = MathHelper.func_1106_a(var7);
      this.field_40326_d.field_1410_a = MathHelper.func_1106_a(var7);
      this.field_40327_e.field_1410_a = MathHelper.func_1106_a(var7);
      this.field_40324_f.field_1410_a = MathHelper.func_1106_a(var7);
   }
}
