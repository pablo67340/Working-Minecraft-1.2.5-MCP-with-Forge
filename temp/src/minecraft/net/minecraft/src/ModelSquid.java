package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSquid extends ModelBase {

   ModelRenderer field_21123_a;
   ModelRenderer[] field_21122_b = new ModelRenderer[8];


   public ModelSquid() {
      byte var1 = -16;
      this.field_21123_a = new ModelRenderer(this, 0, 0);
      this.field_21123_a.func_40604_a(-6.0F, -8.0F, -6.0F, 12, 16, 12);
      this.field_21123_a.field_1409_b += (float)(24 + var1);

      for(int var2 = 0; var2 < this.field_21122_b.length; ++var2) {
         this.field_21122_b[var2] = new ModelRenderer(this, 48, 0);
         double var3 = (double)var2 * 3.141592653589793D * 2.0D / (double)this.field_21122_b.length;
         float var5 = (float)Math.cos(var3) * 5.0F;
         float var6 = (float)Math.sin(var3) * 5.0F;
         this.field_21122_b[var2].func_40604_a(-1.0F, 0.0F, -1.0F, 2, 18, 2);
         this.field_21122_b[var2].field_1410_a = var5;
         this.field_21122_b[var2].field_1408_c = var6;
         this.field_21122_b[var2].field_1409_b = (float)(31 + var1);
         var3 = (double)var2 * 3.141592653589793D * -2.0D / (double)this.field_21122_b.length + 1.5707963267948966D;
         this.field_21122_b[var2].field_1406_e = (float)var3;
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      ModelRenderer[] var7 = this.field_21122_b;
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         ModelRenderer var10 = var7[var9];
         var10.field_1407_d = p_863_3_;
      }

   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_21123_a.func_922_a(p_864_7_);

      for(int var8 = 0; var8 < this.field_21122_b.length; ++var8) {
         this.field_21122_b[var8].func_922_a(p_864_7_);
      }

   }
}
