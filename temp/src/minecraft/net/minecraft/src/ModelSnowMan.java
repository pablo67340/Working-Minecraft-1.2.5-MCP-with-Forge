package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSnowMan extends ModelBase {

   public ModelRenderer field_40306_a;
   public ModelRenderer field_40304_b;
   public ModelRenderer field_40305_c;
   public ModelRenderer field_40302_d;
   public ModelRenderer field_40303_e;


   public ModelSnowMan() {
      float var1 = 4.0F;
      float var2 = 0.0F;
      this.field_40305_c = (new ModelRenderer(this, 0, 0)).func_35968_a(64, 64);
      this.field_40305_c.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var2 - 0.5F);
      this.field_40305_c.func_925_a(0.0F, 0.0F + var1, 0.0F);
      this.field_40302_d = (new ModelRenderer(this, 32, 0)).func_35968_a(64, 64);
      this.field_40302_d.func_923_a(-1.0F, 0.0F, -1.0F, 12, 2, 2, var2 - 0.5F);
      this.field_40302_d.func_925_a(0.0F, 0.0F + var1 + 9.0F - 7.0F, 0.0F);
      this.field_40303_e = (new ModelRenderer(this, 32, 0)).func_35968_a(64, 64);
      this.field_40303_e.func_923_a(-1.0F, 0.0F, -1.0F, 12, 2, 2, var2 - 0.5F);
      this.field_40303_e.func_925_a(0.0F, 0.0F + var1 + 9.0F - 7.0F, 0.0F);
      this.field_40306_a = (new ModelRenderer(this, 0, 16)).func_35968_a(64, 64);
      this.field_40306_a.func_923_a(-5.0F, -10.0F, -5.0F, 10, 10, 10, var2 - 0.5F);
      this.field_40306_a.func_925_a(0.0F, 0.0F + var1 + 9.0F, 0.0F);
      this.field_40304_b = (new ModelRenderer(this, 0, 36)).func_35968_a(64, 64);
      this.field_40304_b.func_923_a(-6.0F, -12.0F, -6.0F, 12, 12, 12, var2 - 0.5F);
      this.field_40304_b.func_925_a(0.0F, 0.0F + var1 + 20.0F, 0.0F);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
      this.field_40305_c.field_1406_e = p_863_4_ / 57.295776F;
      this.field_40305_c.field_1407_d = p_863_5_ / 57.295776F;
      this.field_40306_a.field_1406_e = p_863_4_ / 57.295776F * 0.25F;
      float var7 = MathHelper.func_1106_a(this.field_40306_a.field_1406_e);
      float var8 = MathHelper.func_1114_b(this.field_40306_a.field_1406_e);
      this.field_40302_d.field_1405_f = 1.0F;
      this.field_40303_e.field_1405_f = -1.0F;
      this.field_40302_d.field_1406_e = 0.0F + this.field_40306_a.field_1406_e;
      this.field_40303_e.field_1406_e = 3.1415927F + this.field_40306_a.field_1406_e;
      this.field_40302_d.field_1410_a = var8 * 5.0F;
      this.field_40302_d.field_1408_c = -var7 * 5.0F;
      this.field_40303_e.field_1410_a = -var8 * 5.0F;
      this.field_40303_e.field_1408_c = var7 * 5.0F;
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_40306_a.func_922_a(p_864_7_);
      this.field_40304_b.func_922_a(p_864_7_);
      this.field_40305_c.func_922_a(p_864_7_);
      this.field_40302_d.func_922_a(p_864_7_);
      this.field_40303_e.func_922_a(p_864_7_);
   }
}
