package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelMagmaCube extends ModelBase {

   ModelRenderer[] field_40345_a = new ModelRenderer[8];
   ModelRenderer field_40344_b;


   public ModelMagmaCube() {
      for(int var1 = 0; var1 < this.field_40345_a.length; ++var1) {
         byte var2 = 0;
         int var3 = var1;
         if(var1 == 2) {
            var2 = 24;
            var3 = 10;
         } else if(var1 == 3) {
            var2 = 24;
            var3 = 19;
         }

         this.field_40345_a[var1] = new ModelRenderer(this, var2, var3);
         this.field_40345_a[var1].func_40604_a(-4.0F, (float)(16 + var1), -4.0F, 8, 1, 8);
      }

      this.field_40344_b = new ModelRenderer(this, 0, 16);
      this.field_40344_b.func_40604_a(-2.0F, 18.0F, -2.0F, 4, 4, 4);
   }

   public int func_40343_a() {
      return 5;
   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {}

   public void func_25103_a(EntityLiving p_25103_1_, float p_25103_2_, float p_25103_3_, float p_25103_4_) {
      EntityMagmaCube var5 = (EntityMagmaCube)p_25103_1_;
      float var6 = var5.field_767_b + (var5.field_768_a - var5.field_767_b) * p_25103_4_;
      if(var6 < 0.0F) {
         var6 = 0.0F;
      }

      for(int var7 = 0; var7 < this.field_40345_a.length; ++var7) {
         this.field_40345_a[var7].field_1409_b = (float)(-(4 - var7)) * var6 * 1.7F;
      }

   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      this.field_40344_b.func_922_a(p_864_7_);

      for(int var8 = 0; var8 < this.field_40345_a.length; ++var8) {
         this.field_40345_a[var8].func_922_a(p_864_7_);
      }

   }
}
