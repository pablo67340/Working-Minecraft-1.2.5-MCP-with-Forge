package net.minecraft.src;

import net.minecraft.src.ModelBiped;
import net.minecraft.src.ModelRenderer;

public class ModelEnderman extends ModelBiped {

   public boolean field_35407_a = false;
   public boolean field_35406_b = false;


   public ModelEnderman() {
      super(0.0F, -14.0F);
      float var1 = -14.0F;
      float var2 = 0.0F;
      this.field_1285_b = new ModelRenderer(this, 0, 16);
      this.field_1285_b.func_923_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var2 - 0.5F);
      this.field_1285_b.func_925_a(0.0F, 0.0F + var1, 0.0F);
      this.field_1284_c = new ModelRenderer(this, 32, 16);
      this.field_1284_c.func_923_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, var2);
      this.field_1284_c.func_925_a(0.0F, 0.0F + var1, 0.0F);
      this.field_1283_d = new ModelRenderer(this, 56, 0);
      this.field_1283_d.func_923_a(-1.0F, -2.0F, -1.0F, 2, 30, 2, var2);
      this.field_1283_d.func_925_a(-3.0F, 2.0F + var1, 0.0F);
      this.field_1282_e = new ModelRenderer(this, 56, 0);
      this.field_1282_e.field_1404_g = true;
      this.field_1282_e.func_923_a(-1.0F, -2.0F, -1.0F, 2, 30, 2, var2);
      this.field_1282_e.func_925_a(5.0F, 2.0F + var1, 0.0F);
      this.field_1281_f = new ModelRenderer(this, 56, 0);
      this.field_1281_f.func_923_a(-1.0F, 0.0F, -1.0F, 2, 30, 2, var2);
      this.field_1281_f.func_925_a(-2.0F, 12.0F + var1, 0.0F);
      this.field_1280_g = new ModelRenderer(this, 56, 0);
      this.field_1280_g.field_1404_g = true;
      this.field_1280_g.func_923_a(-1.0F, 0.0F, -1.0F, 2, 30, 2, var2);
      this.field_1280_g.func_925_a(2.0F, 12.0F + var1, 0.0F);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
      this.field_1286_a.field_1403_h = true;
      float var7 = -14.0F;
      this.field_1284_c.field_1407_d = 0.0F;
      this.field_1284_c.field_1409_b = var7;
      this.field_1284_c.field_1408_c = -0.0F;
      this.field_1281_f.field_1407_d -= 0.0F;
      this.field_1280_g.field_1407_d -= 0.0F;
      this.field_1283_d.field_1407_d = (float)((double)this.field_1283_d.field_1407_d * 0.5D);
      this.field_1282_e.field_1407_d = (float)((double)this.field_1282_e.field_1407_d * 0.5D);
      this.field_1281_f.field_1407_d = (float)((double)this.field_1281_f.field_1407_d * 0.5D);
      this.field_1280_g.field_1407_d = (float)((double)this.field_1280_g.field_1407_d * 0.5D);
      float var8 = 0.4F;
      if(this.field_1283_d.field_1407_d > var8) {
         this.field_1283_d.field_1407_d = var8;
      }

      if(this.field_1282_e.field_1407_d > var8) {
         this.field_1282_e.field_1407_d = var8;
      }

      if(this.field_1283_d.field_1407_d < -var8) {
         this.field_1283_d.field_1407_d = -var8;
      }

      if(this.field_1282_e.field_1407_d < -var8) {
         this.field_1282_e.field_1407_d = -var8;
      }

      if(this.field_1281_f.field_1407_d > var8) {
         this.field_1281_f.field_1407_d = var8;
      }

      if(this.field_1280_g.field_1407_d > var8) {
         this.field_1280_g.field_1407_d = var8;
      }

      if(this.field_1281_f.field_1407_d < -var8) {
         this.field_1281_f.field_1407_d = -var8;
      }

      if(this.field_1280_g.field_1407_d < -var8) {
         this.field_1280_g.field_1407_d = -var8;
      }

      if(this.field_35407_a) {
         this.field_1283_d.field_1407_d = -0.5F;
         this.field_1282_e.field_1407_d = -0.5F;
         this.field_1283_d.field_1405_f = 0.05F;
         this.field_1282_e.field_1405_f = -0.05F;
      }

      this.field_1283_d.field_1408_c = 0.0F;
      this.field_1282_e.field_1408_c = 0.0F;
      this.field_1281_f.field_1408_c = 0.0F;
      this.field_1280_g.field_1408_c = 0.0F;
      this.field_1281_f.field_1409_b = 9.0F + var7;
      this.field_1280_g.field_1409_b = 9.0F + var7;
      this.field_1286_a.field_1408_c = -0.0F;
      this.field_1286_a.field_1409_b = var7 + 1.0F;
      this.field_1285_b.field_1410_a = this.field_1286_a.field_1410_a;
      this.field_1285_b.field_1409_b = this.field_1286_a.field_1409_b;
      this.field_1285_b.field_1408_c = this.field_1286_a.field_1408_c;
      this.field_1285_b.field_1407_d = this.field_1286_a.field_1407_d;
      this.field_1285_b.field_1406_e = this.field_1286_a.field_1406_e;
      this.field_1285_b.field_1405_f = this.field_1286_a.field_1405_f;
      if(this.field_35406_b) {
         float var9 = 1.0F;
         this.field_1286_a.field_1409_b -= var9 * 5.0F;
      }

   }
}
