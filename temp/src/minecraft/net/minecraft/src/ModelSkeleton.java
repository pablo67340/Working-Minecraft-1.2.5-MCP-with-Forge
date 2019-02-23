package net.minecraft.src;

import net.minecraft.src.ModelRenderer;
import net.minecraft.src.ModelZombie;

public class ModelSkeleton extends ModelZombie {

   public ModelSkeleton() {
      float var1 = 0.0F;
      this.field_1283_d = new ModelRenderer(this, 40, 16);
      this.field_1283_d.func_923_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
      this.field_1283_d.func_925_a(-5.0F, 2.0F, 0.0F);
      this.field_1282_e = new ModelRenderer(this, 40, 16);
      this.field_1282_e.field_1404_g = true;
      this.field_1282_e.func_923_a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
      this.field_1282_e.func_925_a(5.0F, 2.0F, 0.0F);
      this.field_1281_f = new ModelRenderer(this, 0, 16);
      this.field_1281_f.func_923_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
      this.field_1281_f.func_925_a(-2.0F, 12.0F, 0.0F);
      this.field_1280_g = new ModelRenderer(this, 0, 16);
      this.field_1280_g.field_1404_g = true;
      this.field_1280_g.func_923_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
      this.field_1280_g.func_925_a(2.0F, 12.0F, 0.0F);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      this.field_40333_u = true;
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
   }
}
