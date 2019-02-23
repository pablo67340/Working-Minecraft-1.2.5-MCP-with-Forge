package net.minecraft.src;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelChest extends ModelBase {

   public ModelRenderer field_35405_a = (new ModelRenderer(this, 0, 0)).func_35968_a(64, 64);
   public ModelRenderer field_35403_b;
   public ModelRenderer field_35404_c;


   public ModelChest() {
      this.field_35405_a.func_923_a(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
      this.field_35405_a.field_1410_a = 1.0F;
      this.field_35405_a.field_1409_b = 7.0F;
      this.field_35405_a.field_1408_c = 15.0F;
      this.field_35404_c = (new ModelRenderer(this, 0, 0)).func_35968_a(64, 64);
      this.field_35404_c.func_923_a(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
      this.field_35404_c.field_1410_a = 8.0F;
      this.field_35404_c.field_1409_b = 7.0F;
      this.field_35404_c.field_1408_c = 15.0F;
      this.field_35403_b = (new ModelRenderer(this, 0, 19)).func_35968_a(64, 64);
      this.field_35403_b.func_923_a(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
      this.field_35403_b.field_1410_a = 1.0F;
      this.field_35403_b.field_1409_b = 6.0F;
      this.field_35403_b.field_1408_c = 1.0F;
   }

   public void func_35402_a() {
      this.field_35404_c.field_1407_d = this.field_35405_a.field_1407_d;
      this.field_35405_a.func_922_a(0.0625F);
      this.field_35404_c.func_922_a(0.0625F);
      this.field_35403_b.func_922_a(0.0625F);
   }
}
