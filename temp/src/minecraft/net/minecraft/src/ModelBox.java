package net.minecraft.src;

import net.minecraft.src.ModelRenderer;
import net.minecraft.src.PositionTextureVertex;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TexturedQuad;

public class ModelBox {

   private PositionTextureVertex[] field_40679_h;
   private TexturedQuad[] field_40680_i;
   public final float field_40678_a;
   public final float field_40676_b;
   public final float field_40677_c;
   public final float field_40674_d;
   public final float field_40675_e;
   public final float field_40672_f;
   public String field_40673_g;


   public ModelBox(ModelRenderer p_i435_1_, int p_i435_2_, int p_i435_3_, float p_i435_4_, float p_i435_5_, float p_i435_6_, int p_i435_7_, int p_i435_8_, int p_i435_9_, float p_i435_10_) {
      this.field_40678_a = p_i435_4_;
      this.field_40676_b = p_i435_5_;
      this.field_40677_c = p_i435_6_;
      this.field_40674_d = p_i435_4_ + (float)p_i435_7_;
      this.field_40675_e = p_i435_5_ + (float)p_i435_8_;
      this.field_40672_f = p_i435_6_ + (float)p_i435_9_;
      this.field_40679_h = new PositionTextureVertex[8];
      this.field_40680_i = new TexturedQuad[6];
      float var11 = p_i435_4_ + (float)p_i435_7_;
      float var12 = p_i435_5_ + (float)p_i435_8_;
      float var13 = p_i435_6_ + (float)p_i435_9_;
      p_i435_4_ -= p_i435_10_;
      p_i435_5_ -= p_i435_10_;
      p_i435_6_ -= p_i435_10_;
      var11 += p_i435_10_;
      var12 += p_i435_10_;
      var13 += p_i435_10_;
      if(p_i435_1_.field_1404_g) {
         float var14 = var11;
         var11 = p_i435_4_;
         p_i435_4_ = var14;
      }

      PositionTextureVertex var23 = new PositionTextureVertex(p_i435_4_, p_i435_5_, p_i435_6_, 0.0F, 0.0F);
      PositionTextureVertex var15 = new PositionTextureVertex(var11, p_i435_5_, p_i435_6_, 0.0F, 8.0F);
      PositionTextureVertex var16 = new PositionTextureVertex(var11, var12, p_i435_6_, 8.0F, 8.0F);
      PositionTextureVertex var17 = new PositionTextureVertex(p_i435_4_, var12, p_i435_6_, 8.0F, 0.0F);
      PositionTextureVertex var18 = new PositionTextureVertex(p_i435_4_, p_i435_5_, var13, 0.0F, 0.0F);
      PositionTextureVertex var19 = new PositionTextureVertex(var11, p_i435_5_, var13, 0.0F, 8.0F);
      PositionTextureVertex var20 = new PositionTextureVertex(var11, var12, var13, 8.0F, 8.0F);
      PositionTextureVertex var21 = new PositionTextureVertex(p_i435_4_, var12, var13, 8.0F, 0.0F);
      this.field_40679_h[0] = var23;
      this.field_40679_h[1] = var15;
      this.field_40679_h[2] = var16;
      this.field_40679_h[3] = var17;
      this.field_40679_h[4] = var18;
      this.field_40679_h[5] = var19;
      this.field_40679_h[6] = var20;
      this.field_40679_h[7] = var21;
      this.field_40680_i[0] = new TexturedQuad(new PositionTextureVertex[]{var19, var15, var16, var20}, p_i435_2_ + p_i435_9_ + p_i435_7_, p_i435_3_ + p_i435_9_, p_i435_2_ + p_i435_9_ + p_i435_7_ + p_i435_9_, p_i435_3_ + p_i435_9_ + p_i435_8_, p_i435_1_.field_35971_a, p_i435_1_.field_35970_b);
      this.field_40680_i[1] = new TexturedQuad(new PositionTextureVertex[]{var23, var18, var21, var17}, p_i435_2_, p_i435_3_ + p_i435_9_, p_i435_2_ + p_i435_9_, p_i435_3_ + p_i435_9_ + p_i435_8_, p_i435_1_.field_35971_a, p_i435_1_.field_35970_b);
      this.field_40680_i[2] = new TexturedQuad(new PositionTextureVertex[]{var19, var18, var23, var15}, p_i435_2_ + p_i435_9_, p_i435_3_, p_i435_2_ + p_i435_9_ + p_i435_7_, p_i435_3_ + p_i435_9_, p_i435_1_.field_35971_a, p_i435_1_.field_35970_b);
      this.field_40680_i[3] = new TexturedQuad(new PositionTextureVertex[]{var16, var17, var21, var20}, p_i435_2_ + p_i435_9_ + p_i435_7_, p_i435_3_ + p_i435_9_, p_i435_2_ + p_i435_9_ + p_i435_7_ + p_i435_7_, p_i435_3_, p_i435_1_.field_35971_a, p_i435_1_.field_35970_b);
      this.field_40680_i[4] = new TexturedQuad(new PositionTextureVertex[]{var15, var23, var17, var16}, p_i435_2_ + p_i435_9_, p_i435_3_ + p_i435_9_, p_i435_2_ + p_i435_9_ + p_i435_7_, p_i435_3_ + p_i435_9_ + p_i435_8_, p_i435_1_.field_35971_a, p_i435_1_.field_35970_b);
      this.field_40680_i[5] = new TexturedQuad(new PositionTextureVertex[]{var18, var19, var20, var21}, p_i435_2_ + p_i435_9_ + p_i435_7_ + p_i435_9_, p_i435_3_ + p_i435_9_, p_i435_2_ + p_i435_9_ + p_i435_7_ + p_i435_9_ + p_i435_7_, p_i435_3_ + p_i435_9_ + p_i435_8_, p_i435_1_.field_35971_a, p_i435_1_.field_35970_b);
      if(p_i435_1_.field_1404_g) {
         for(int var22 = 0; var22 < this.field_40680_i.length; ++var22) {
            this.field_40680_i[var22].func_809_a();
         }
      }

   }

   public void func_40670_a(Tessellator p_40670_1_, float p_40670_2_) {
      for(int var3 = 0; var3 < this.field_40680_i.length; ++var3) {
         this.field_40680_i[var3].func_808_a(p_40670_1_, p_40670_2_);
      }

   }

   public ModelBox func_40671_a(String p_40671_1_) {
      this.field_40673_g = p_40671_1_;
      return this;
   }
}
