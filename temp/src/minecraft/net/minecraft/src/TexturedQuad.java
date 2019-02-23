package net.minecraft.src;

import net.minecraft.src.PositionTextureVertex;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3D;

public class TexturedQuad {

   public PositionTextureVertex[] field_1195_a;
   public int field_1194_b;
   private boolean field_1196_c;


   public TexturedQuad(PositionTextureVertex[] p_i496_1_) {
      this.field_1194_b = 0;
      this.field_1196_c = false;
      this.field_1195_a = p_i496_1_;
      this.field_1194_b = p_i496_1_.length;
   }

   public TexturedQuad(PositionTextureVertex[] p_i497_1_, int p_i497_2_, int p_i497_3_, int p_i497_4_, int p_i497_5_, float p_i497_6_, float p_i497_7_) {
      this(p_i497_1_);
      float var8 = 0.0F / p_i497_6_;
      float var9 = 0.0F / p_i497_7_;
      p_i497_1_[0] = p_i497_1_[0].func_1115_a((float)p_i497_4_ / p_i497_6_ - var8, (float)p_i497_3_ / p_i497_7_ + var9);
      p_i497_1_[1] = p_i497_1_[1].func_1115_a((float)p_i497_2_ / p_i497_6_ + var8, (float)p_i497_3_ / p_i497_7_ + var9);
      p_i497_1_[2] = p_i497_1_[2].func_1115_a((float)p_i497_2_ / p_i497_6_ + var8, (float)p_i497_5_ / p_i497_7_ - var9);
      p_i497_1_[3] = p_i497_1_[3].func_1115_a((float)p_i497_4_ / p_i497_6_ - var8, (float)p_i497_5_ / p_i497_7_ - var9);
   }

   public void func_809_a() {
      PositionTextureVertex[] var1 = new PositionTextureVertex[this.field_1195_a.length];

      for(int var2 = 0; var2 < this.field_1195_a.length; ++var2) {
         var1[var2] = this.field_1195_a[this.field_1195_a.length - var2 - 1];
      }

      this.field_1195_a = var1;
   }

   public void func_808_a(Tessellator p_808_1_, float p_808_2_) {
      Vec3D var3 = this.field_1195_a[1].field_1655_a.func_1262_a(this.field_1195_a[0].field_1655_a);
      Vec3D var4 = this.field_1195_a[1].field_1655_a.func_1262_a(this.field_1195_a[2].field_1655_a);
      Vec3D var5 = var4.func_1246_b(var3).func_1252_b();
      p_808_1_.func_977_b();
      if(this.field_1196_c) {
         p_808_1_.func_980_b(-((float)var5.field_1776_a), -((float)var5.field_1775_b), -((float)var5.field_1779_c));
      } else {
         p_808_1_.func_980_b((float)var5.field_1776_a, (float)var5.field_1775_b, (float)var5.field_1779_c);
      }

      for(int var6 = 0; var6 < 4; ++var6) {
         PositionTextureVertex var7 = this.field_1195_a[var6];
         p_808_1_.func_983_a((double)((float)var7.field_1655_a.field_1776_a * p_808_2_), (double)((float)var7.field_1655_a.field_1775_b * p_808_2_), (double)((float)var7.field_1655_a.field_1779_c * p_808_2_), (double)var7.field_1654_b, (double)var7.field_1656_c);
      }

      p_808_1_.func_982_a();
   }
}
