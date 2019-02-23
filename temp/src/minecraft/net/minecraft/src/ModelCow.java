package net.minecraft.src;

import net.minecraft.src.ModelQuadruped;
import net.minecraft.src.ModelRenderer;

public class ModelCow extends ModelQuadruped {

   public ModelCow() {
      super(12, 0.0F);
      this.field_1266_d = new ModelRenderer(this, 0, 0);
      this.field_1266_d.func_923_a(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
      this.field_1266_d.func_925_a(0.0F, 4.0F, -8.0F);
      this.field_1266_d.func_40602_a(22, 0).func_923_a(-5.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
      this.field_1266_d.func_40602_a(22, 0).func_923_a(4.0F, -5.0F, -4.0F, 1, 3, 1, 0.0F);
      this.field_1265_e = new ModelRenderer(this, 18, 4);
      this.field_1265_e.func_923_a(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
      this.field_1265_e.func_925_a(0.0F, 5.0F, 2.0F);
      this.field_1265_e.func_40602_a(52, 0).func_40604_a(-2.0F, 2.0F, -8.0F, 4, 6, 1);
      --this.field_1264_f.field_1410_a;
      ++this.field_1263_g.field_1410_a;
      this.field_1264_f.field_1408_c += 0.0F;
      this.field_1263_g.field_1408_c += 0.0F;
      --this.field_1262_h.field_1410_a;
      ++this.field_1261_i.field_1410_a;
      --this.field_1262_h.field_1408_c;
      --this.field_1261_i.field_1408_c;
      this.field_40332_n += 2.0F;
   }
}
