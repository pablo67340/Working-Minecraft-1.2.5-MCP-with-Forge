package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;
import org.lwjgl.opengl.GL11;

public class ModelGhast extends ModelBase {

   ModelRenderer field_4258_a;
   ModelRenderer[] field_4257_b = new ModelRenderer[9];


   public ModelGhast() {
      byte var1 = -16;
      this.field_4258_a = new ModelRenderer(this, 0, 0);
      this.field_4258_a.func_40604_a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
      this.field_4258_a.field_1409_b += (float)(24 + var1);
      Random var2 = new Random(1660L);

      for(int var3 = 0; var3 < this.field_4257_b.length; ++var3) {
         this.field_4257_b[var3] = new ModelRenderer(this, 0, 0);
         float var4 = (((float)(var3 % 3) - (float)(var3 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
         float var5 = ((float)(var3 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
         int var6 = var2.nextInt(7) + 8;
         this.field_4257_b[var3].func_40604_a(-1.0F, 0.0F, -1.0F, 2, var6, 2);
         this.field_4257_b[var3].field_1410_a = var4;
         this.field_4257_b[var3].field_1408_c = var5;
         this.field_4257_b[var3].field_1409_b = (float)(31 + var1);
      }

   }

   public void func_863_a(float p_863_1_, float p_863_2_, float p_863_3_, float p_863_4_, float p_863_5_, float p_863_6_) {
      for(int var7 = 0; var7 < this.field_4257_b.length; ++var7) {
         this.field_4257_b[var7].field_1407_d = 0.2F * MathHelper.func_1106_a(p_863_3_ * 0.3F + (float)var7) + 0.4F;
      }

   }

   public void func_864_b(Entity p_864_1_, float p_864_2_, float p_864_3_, float p_864_4_, float p_864_5_, float p_864_6_, float p_864_7_) {
      this.func_863_a(p_864_2_, p_864_3_, p_864_4_, p_864_5_, p_864_6_, p_864_7_);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.6F, 0.0F);
      this.field_4258_a.func_922_a(p_864_7_);
      ModelRenderer[] var8 = this.field_4257_b;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         ModelRenderer var11 = var8[var10];
         var11.func_922_a(p_864_7_);
      }

      GL11.glPopMatrix();
   }
}
