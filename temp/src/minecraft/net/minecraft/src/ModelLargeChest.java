package net.minecraft.src;

import net.minecraft.src.ModelChest;
import net.minecraft.src.ModelRenderer;

public class ModelLargeChest extends ModelChest {

   public ModelLargeChest() {
      this.field_35405_a = (new ModelRenderer(this, 0, 0)).func_35968_a(128, 64);
      this.field_35405_a.func_923_a(0.0F, -5.0F, -14.0F, 30, 5, 14, 0.0F);
      this.field_35405_a.field_1410_a = 1.0F;
      this.field_35405_a.field_1409_b = 7.0F;
      this.field_35405_a.field_1408_c = 15.0F;
      this.field_35404_c = (new ModelRenderer(this, 0, 0)).func_35968_a(128, 64);
      this.field_35404_c.func_923_a(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
      this.field_35404_c.field_1410_a = 16.0F;
      this.field_35404_c.field_1409_b = 7.0F;
      this.field_35404_c.field_1408_c = 15.0F;
      this.field_35403_b = (new ModelRenderer(this, 0, 19)).func_35968_a(128, 64);
      this.field_35403_b.func_923_a(0.0F, 0.0F, 0.0F, 30, 10, 14, 0.0F);
      this.field_35403_b.field_1410_a = 1.0F;
      this.field_35403_b.field_1409_b = 6.0F;
      this.field_35403_b.field_1408_c = 1.0F;
   }
}
