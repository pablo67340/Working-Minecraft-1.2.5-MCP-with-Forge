package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelSilverfish extends ModelBase {

   private ModelRenderer[] field_35400_a = new ModelRenderer[7];
   private ModelRenderer[] field_35398_b;
   private float[] field_35399_c = new float[7];
   private static final int[][] field_35396_d = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
   private static final int[][] field_35397_e = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};


   public ModelSilverfish() {
      float var1 = -3.5F;

      for(int var2 = 0; var2 < this.field_35400_a.length; ++var2) {
         this.field_35400_a[var2] = new ModelRenderer(this, field_35397_e[var2][0], field_35397_e[var2][1]);
         this.field_35400_a[var2].func_40604_a((float)field_35396_d[var2][0] * -0.5F, 0.0F, (float)field_35396_d[var2][2] * -0.5F, field_35396_d[var2][0], field_35396_d[var2][1], field_35396_d[var2][2]);
         this.field_35400_a[var2].func_925_a(0.0F, (float)(24 - field_35396_d[var2][1]), var1);
         this.field_35399_c[var2] = var1;
         if(var2 < this.field_35400_a.length - 1) {
            var1 += (float)(field_35396_d[var2][2] + field_35396_d[var2 + 1][2]) * 0.5F;
         }
      }

      this.field_35398_b = new ModelRenderer[3];
      this.field_35398_b[0] = new ModelRenderer(this, 20, 0);
      this.field_35398_b[0].func_40604_a(-5.0F, 0.0F, (float)field_35396_d[2][2] * -0.5F, 10, 8, field_35396_d[2][2]);
      this.field_35398_b[0].func_925_a(0.0F, 16.0F, this.field_35399_c[2]);
      this.field_35398_b[1] = new ModelRenderer(this, 20, 11);
      this.field_35398_b[1].func_40604_a(-3.0F, 0.0F, (float)field_35396_d[4][2] * -0.5F, 6, 4, field_35396_d[4][2]);
      this.field_35398_b[1].func_925_a(0.0F, 20.0F, this.field_35399_c[4]);
      this.field_35398_b[2] = new ModelRenderer(this, 20, 18);
      this.field_35398_b[2].func_40604_a(-3.0F, 0.0F, (float)field_35396_d[4][2] * -0.5F, 6, 5, field_35396_d[1][2]);
      this.field_35398_b[2].func_925_a(0.0F, 19.0F, this.field_35399_c[1]);
   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);

      int var8;
      for(var8 = 0; var8 < this.field_35400_a.length; ++var8) {
         this.field_35400_a[var8].func_922_a(p_864_7_);
      }

      for(var8 = 0; var8 < this.field_35398_b.length; ++var8) {
         this.field_35398_b[var8].func_922_a(p_864_7_);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      for(int var7 = 0; var7 < this.field_35400_a.length; ++var7) {
         this.field_35400_a[var7].field_1406_e = MathHelper.func_1114_b(p_863_3_ * 0.9F + (float)var7 * 0.15F * 3.1415927F) * 3.1415927F * 0.05F * (float)(1 + Math.abs(var7 - 2));
         this.field_35400_a[var7].field_1410_a = MathHelper.func_1106_a(p_863_3_ * 0.9F + (float)var7 * 0.15F * 3.1415927F) * 3.1415927F * 0.2F * (float)Math.abs(var7 - 2);
      }

      this.field_35398_b[0].field_1406_e = this.field_35400_a[2].field_1406_e;
      this.field_35398_b[1].field_1406_e = this.field_35400_a[4].field_1406_e;
      this.field_35398_b[1].field_1410_a = this.field_35400_a[4].field_1410_a;
      this.field_35398_b[2].field_1406_e = this.field_35400_a[1].field_1406_e;
      this.field_35398_b[2].field_1410_a = this.field_35400_a[1].field_1410_a;
   }

}
