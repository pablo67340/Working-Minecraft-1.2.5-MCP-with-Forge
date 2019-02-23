package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSlime extends ModelBase {

   ModelRenderer field_1258_a;
   ModelRenderer field_1257_b;
   ModelRenderer field_1260_c;
   ModelRenderer field_1259_d;


   public ModelSlime(int p_i45_1_) {
      this.field_1258_a = new ModelRenderer(this, 0, p_i45_1_);
      this.field_1258_a.func_40604_a(-4.0F, 16.0F, -4.0F, 8, 8, 8);
      if(p_i45_1_ > 0) {
         this.field_1258_a = new ModelRenderer(this, 0, p_i45_1_);
         this.field_1258_a.func_40604_a(-3.0F, 17.0F, -3.0F, 6, 6, 6);
         this.field_1257_b = new ModelRenderer(this, 32, 0);
         this.field_1257_b.func_40604_a(-3.25F, 18.0F, -3.5F, 2, 2, 2);
         this.field_1260_c = new ModelRenderer(this, 32, 4);
         this.field_1260_c.func_40604_a(1.25F, 18.0F, -3.5F, 2, 2, 2);
         this.field_1259_d = new ModelRenderer(this, 32, 8);
         this.field_1259_d.func_40604_a(0.0F, 21.0F, -3.5F, 1, 1, 1);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {}

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_1258_a.func_922_a(p_864_7_);
      if(this.field_1257_b != null) {
         this.field_1257_b.func_922_a(p_864_7_);
         this.field_1260_c.func_922_a(p_864_7_);
         this.field_1259_d.func_922_a(p_864_7_);
      }

   }
}
