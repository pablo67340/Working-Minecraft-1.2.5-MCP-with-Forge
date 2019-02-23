package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.ModelQuadruped;
import net.minecraft.src.ModelRenderer;

public class ModelSheep1 extends ModelQuadruped {

   private float field_44016_o;


   public ModelSheep1() {
      super(12, 0.0F);
      this.field_1266_d = new ModelRenderer(this, 0, 0);
      this.field_1266_d.func_923_a(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
      this.field_1266_d.func_925_a(0.0F, 6.0F, -8.0F);
      this.field_1265_e = new ModelRenderer(this, 28, 8);
      this.field_1265_e.func_923_a(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
      this.field_1265_e.func_925_a(0.0F, 5.0F, 2.0F);
      float var1 = 0.5F;
      this.field_1264_f = new ModelRenderer(this, 0, 16);
      this.field_1264_f.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
      this.field_1264_f.func_925_a(-3.0F, 12.0F, 7.0F);
      this.field_1263_g = new ModelRenderer(this, 0, 16);
      this.field_1263_g.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
      this.field_1263_g.func_925_a(3.0F, 12.0F, 7.0F);
      this.field_1262_h = new ModelRenderer(this, 0, 16);
      this.field_1262_h.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
      this.field_1262_h.func_925_a(-3.0F, 12.0F, -5.0F);
      this.field_1261_i = new ModelRenderer(this, 0, 16);
      this.field_1261_i.func_923_a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
      this.field_1261_i.func_925_a(3.0F, 12.0F, -5.0F);
   }

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {
      super.func_25103_a(p_25103_1_, p_25103_2_, p_25103_3_, p_25103_4_);
      this.field_1266_d.field_1409_b = 6.0F + ((EntitySheep)p_25103_1_).func_44003_c(p_25103_4_) * 9.0F;
      this.field_44016_o = ((EntitySheep)p_25103_1_).func_44002_d(p_25103_4_);
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      super.func_863_a(p_863_1_, p_863_2_, p_863_3_, p_863_4_, p_863_5_, p_863_6_);
      this.field_1266_d.field_1407_d = this.field_44016_o;
   }
}
