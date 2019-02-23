package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelBlaze extends ModelBase {

   private ModelRenderer[] field_40323_a = new ModelRenderer[12];
   private ModelRenderer field_40322_b;


   public ModelBlaze() {
      for(int var1 = 0; var1 < this.field_40323_a.length; ++var1) {
         this.field_40323_a[var1] = new ModelRenderer(this, 0, 16);
         this.field_40323_a[var1].func_40604_a(0.0F, 0.0F, 0.0F, 2, 8, 2);
      }

      this.field_40322_b = new ModelRenderer(this, 0, 0);
      this.field_40322_b.func_40604_a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
   }

   public int func_40321_a() {
      return 8;
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_40322_b.func_922_a(p_864_7_);

      for(int var8 = 0; var8 < this.field_40323_a.length; ++var8) {
         this.field_40323_a[var8].func_922_a(p_864_7_);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      float var7 = p_863_3_ * 3.1415927F * -0.1F;

      int var8;
      for(var8 = 0; var8 < 4; ++var8) {
         this.field_40323_a[var8].field_1409_b = -2.0F + MathHelper.func_1114_b(((float)(var8 * 2) + p_863_3_) * 0.25F);
         this.field_40323_a[var8].field_1410_a = MathHelper.func_1114_b(var7) * 9.0F;
         this.field_40323_a[var8].field_1408_c = MathHelper.func_1106_a(var7) * 9.0F;
         ++var7;
      }

      var7 = 0.7853982F + p_863_3_ * 3.1415927F * 0.03F;

      for(var8 = 4; var8 < 8; ++var8) {
         this.field_40323_a[var8].field_1409_b = 2.0F + MathHelper.func_1114_b(((float)(var8 * 2) + p_863_3_) * 0.25F);
         this.field_40323_a[var8].field_1410_a = MathHelper.func_1114_b(var7) * 7.0F;
         this.field_40323_a[var8].field_1408_c = MathHelper.func_1106_a(var7) * 7.0F;
         ++var7;
      }

      var7 = 0.47123894F + p_863_3_ * 3.1415927F * -0.05F;

      for(var8 = 8; var8 < 12; ++var8) {
         this.field_40323_a[var8].field_1409_b = 11.0F + MathHelper.func_1114_b(((float)var8 * 1.5F + p_863_3_) * 0.5F);
         this.field_40323_a[var8].field_1410_a = MathHelper.func_1114_b(var7) * 5.0F;
         this.field_40323_a[var8].field_1408_c = MathHelper.func_1106_a(var7) * 5.0F;
         ++var7;
      }

      this.field_40322_b.field_1406_e = p_863_4_ / 57.295776F;
      this.field_40322_b.field_1407_d = p_863_5_ / 57.295776F;
   }
}
