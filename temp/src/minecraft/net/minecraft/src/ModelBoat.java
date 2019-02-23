package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBoat extends ModelBase {

   public ModelRenderer[] field_1287_a = new ModelRenderer[5];


   public ModelBoat() {
      this.field_1287_a[0] = new ModelRenderer(this, 0, 8);
      this.field_1287_a[1] = new ModelRenderer(this, 0, 0);
      this.field_1287_a[2] = new ModelRenderer(this, 0, 0);
      this.field_1287_a[3] = new ModelRenderer(this, 0, 0);
      this.field_1287_a[4] = new ModelRenderer(this, 0, 0);
      byte var1 = 24;
      byte var2 = 6;
      byte var3 = 20;
      byte var4 = 4;
      this.field_1287_a[0].func_923_a((float)(-var1 / 2), (float)(-var3 / 2 + 2), -3.0F, var1, var3 - 4, 4, 0.0F);
      this.field_1287_a[0].func_925_a(0.0F, (float)var4, 0.0F);
      this.field_1287_a[1].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_1287_a[1].func_925_a((float)(-var1 / 2 + 1), (float)var4, 0.0F);
      this.field_1287_a[2].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_1287_a[2].func_925_a((float)(var1 / 2 - 1), (float)var4, 0.0F);
      this.field_1287_a[3].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_1287_a[3].func_925_a(0.0F, (float)var4, (float)(-var3 / 2 + 1));
      this.field_1287_a[4].func_923_a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.field_1287_a[4].func_925_a(0.0F, (float)var4, (float)(var3 / 2 - 1));
      this.field_1287_a[0].field_1407_d = 1.5707964F;
      this.field_1287_a[1].field_1406_e = 4.712389F;
      this.field_1287_a[2].field_1406_e = 1.5707964F;
      this.field_1287_a[3].field_1406_e = 3.1415927F;
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      for(int var8 = 0; var8 < 5; ++var8) {
         this.field_1287_a[var8].func_922_a(p_864_7_);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {}
}
