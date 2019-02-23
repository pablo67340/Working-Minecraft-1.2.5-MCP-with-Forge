package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class EntityLargeExplodeFX extends EntityFX {

   private int field_35130_a = 0;
   private int field_35129_ay = 0;
   private RenderEngine field_35128_az;
   private float field_35131_aA;


   public EntityLargeExplodeFX(RenderEngine p_i376_1_, World p_i376_2_, double p_i376_3_, double p_i376_5_, double p_i376_7_, double p_i376_9_, double p_i376_11_, double p_i376_13_) {
      super(p_i376_2_, p_i376_3_, p_i376_5_, p_i376_7_, 0.0D, 0.0D, 0.0D);
      this.field_35128_az = p_i376_1_;
      this.field_35129_ay = 6 + this.field_9312_bd.nextInt(4);
      this.field_663_i = this.field_662_j = this.field_661_k = this.field_9312_bd.nextFloat() * 0.6F + 0.4F;
      this.field_35131_aA = 1.0F - (float)p_i376_9_ * 0.5F;
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      int var8 = (int)(((float)this.field_35130_a + p_406_2_) * 15.0F / (float)this.field_35129_ay);
      if(var8 <= 15) {
         this.field_35128_az.func_1076_b(this.field_35128_az.func_1070_a("/misc/explosion.png"));
         float var9 = (float)(var8 % 4) / 4.0F;
         float var10 = var9 + 0.24975F;
         float var11 = (float)(var8 / 4) / 4.0F;
         float var12 = var11 + 0.24975F;
         float var13 = 2.0F * this.field_35131_aA;
         float var14 = (float)(this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)p_406_2_ - field_660_l);
         float var15 = (float)(this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)p_406_2_ - field_659_m);
         float var16 = (float)(this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)p_406_2_ - field_658_n);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(2896);
         RenderHelper.func_1159_a();
         p_406_1_.func_977_b();
         p_406_1_.func_986_a(this.field_663_i, this.field_662_j, this.field_661_k, 1.0F);
         p_406_1_.func_980_b(0.0F, 1.0F, 0.0F);
         p_406_1_.func_35835_b(240);
         p_406_1_.func_983_a((double)(var14 - p_406_3_ * var13 - p_406_6_ * var13), (double)(var15 - p_406_4_ * var13), (double)(var16 - p_406_5_ * var13 - p_406_7_ * var13), (double)var10, (double)var12);
         p_406_1_.func_983_a((double)(var14 - p_406_3_ * var13 + p_406_6_ * var13), (double)(var15 + p_406_4_ * var13), (double)(var16 - p_406_5_ * var13 + p_406_7_ * var13), (double)var10, (double)var11);
         p_406_1_.func_983_a((double)(var14 + p_406_3_ * var13 + p_406_6_ * var13), (double)(var15 + p_406_4_ * var13), (double)(var16 + p_406_5_ * var13 + p_406_7_ * var13), (double)var9, (double)var11);
         p_406_1_.func_983_a((double)(var14 + p_406_3_ * var13 - p_406_6_ * var13), (double)(var15 - p_406_4_ * var13), (double)(var16 + p_406_5_ * var13 - p_406_7_ * var13), (double)var9, (double)var12);
         p_406_1_.func_982_a();
         GL11.glPolygonOffset(0.0F, 0.0F);
         GL11.glEnable(2896);
      }
   }

   public int func_35115_a(float p_35115_1_) {
      return '\uf0f0';
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      ++this.field_35130_a;
      if(this.field_35130_a == this.field_35129_ay) {
         this.func_395_F();
      }

   }

   public int func_404_c() {
      return 3;
   }
}
