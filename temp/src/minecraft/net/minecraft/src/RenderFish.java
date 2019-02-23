package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityFishHook;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Render;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3D;
import org.lwjgl.opengl.GL11;

public class RenderFish extends Render {

   public void func_4011_a(EntityFishHook p_4011_1_, double p_4011_2_, double p_4011_4_, double p_4011_6_, float p_4011_8_, float p_4011_9_) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)p_4011_2_, (float)p_4011_4_, (float)p_4011_6_);
      GL11.glEnable('\u803a');
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      byte var10 = 1;
      byte var11 = 2;
      this.func_151_a("/particles.png");
      Tessellator var12 = Tessellator.field_1512_a;
      float var13 = (float)(var10 * 8 + 0) / 128.0F;
      float var14 = (float)(var10 * 8 + 8) / 128.0F;
      float var15 = (float)(var11 * 8 + 0) / 128.0F;
      float var16 = (float)(var11 * 8 + 8) / 128.0F;
      float var17 = 1.0F;
      float var18 = 0.5F;
      float var19 = 0.5F;
      GL11.glRotatef(180.0F - this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
      var12.func_977_b();
      var12.func_980_b(0.0F, 1.0F, 0.0F);
      var12.func_983_a((double)(0.0F - var18), (double)(0.0F - var19), 0.0D, (double)var13, (double)var16);
      var12.func_983_a((double)(var17 - var18), (double)(0.0F - var19), 0.0D, (double)var14, (double)var16);
      var12.func_983_a((double)(var17 - var18), (double)(1.0F - var19), 0.0D, (double)var14, (double)var15);
      var12.func_983_a((double)(0.0F - var18), (double)(1.0F - var19), 0.0D, (double)var13, (double)var15);
      var12.func_982_a();
      GL11.glDisable('\u803a');
      GL11.glPopMatrix();
      if(p_4011_1_.field_4097_b != null) {
         float var20 = (p_4011_1_.field_4097_b.field_603_as + (p_4011_1_.field_4097_b.field_605_aq - p_4011_1_.field_4097_b.field_603_as) * p_4011_9_) * 3.1415927F / 180.0F;
         double var21 = (double)MathHelper.func_1106_a(var20);
         double var23 = (double)MathHelper.func_1114_b(var20);
         float var25 = p_4011_1_.field_4097_b.func_431_d(p_4011_9_);
         float var26 = MathHelper.func_1106_a(MathHelper.func_1113_c(var25) * 3.1415927F);
         Vec3D var27 = Vec3D.func_1248_b(-0.5D, 0.03D, 0.8D);
         var27.func_1258_a(-(p_4011_1_.field_4097_b.field_602_at + (p_4011_1_.field_4097_b.field_604_ar - p_4011_1_.field_4097_b.field_602_at) * p_4011_9_) * 3.1415927F / 180.0F);
         var27.func_1249_b(-(p_4011_1_.field_4097_b.field_603_as + (p_4011_1_.field_4097_b.field_605_aq - p_4011_1_.field_4097_b.field_603_as) * p_4011_9_) * 3.1415927F / 180.0F);
         var27.func_1249_b(var26 * 0.5F);
         var27.func_1258_a(-var26 * 0.7F);
         double var28 = p_4011_1_.field_4097_b.field_9285_at + (p_4011_1_.field_4097_b.field_611_ak - p_4011_1_.field_4097_b.field_9285_at) * (double)p_4011_9_ + var27.field_1776_a;
         double var30 = p_4011_1_.field_4097_b.field_9284_au + (p_4011_1_.field_4097_b.field_610_al - p_4011_1_.field_4097_b.field_9284_au) * (double)p_4011_9_ + var27.field_1775_b;
         double var32 = p_4011_1_.field_4097_b.field_9283_av + (p_4011_1_.field_4097_b.field_609_am - p_4011_1_.field_4097_b.field_9283_av) * (double)p_4011_9_ + var27.field_1779_c;
         if(this.field_191_a.field_1223_k.field_1560_x > 0) {
            var20 = (p_4011_1_.field_4097_b.field_734_o + (p_4011_1_.field_4097_b.field_735_n - p_4011_1_.field_4097_b.field_734_o) * p_4011_9_) * 3.1415927F / 180.0F;
            var21 = (double)MathHelper.func_1106_a(var20);
            var23 = (double)MathHelper.func_1114_b(var20);
            var28 = p_4011_1_.field_4097_b.field_9285_at + (p_4011_1_.field_4097_b.field_611_ak - p_4011_1_.field_4097_b.field_9285_at) * (double)p_4011_9_ - var23 * 0.35D - var21 * 0.85D;
            var30 = p_4011_1_.field_4097_b.field_9284_au + (p_4011_1_.field_4097_b.field_610_al - p_4011_1_.field_4097_b.field_9284_au) * (double)p_4011_9_ - 0.45D;
            var32 = p_4011_1_.field_4097_b.field_9283_av + (p_4011_1_.field_4097_b.field_609_am - p_4011_1_.field_4097_b.field_9283_av) * (double)p_4011_9_ - var21 * 0.35D + var23 * 0.85D;
         }

         double var34 = p_4011_1_.field_9285_at + (p_4011_1_.field_611_ak - p_4011_1_.field_9285_at) * (double)p_4011_9_;
         double var36 = p_4011_1_.field_9284_au + (p_4011_1_.field_610_al - p_4011_1_.field_9284_au) * (double)p_4011_9_ + 0.25D;
         double var38 = p_4011_1_.field_9283_av + (p_4011_1_.field_609_am - p_4011_1_.field_9283_av) * (double)p_4011_9_;
         double var40 = (double)((float)(var28 - var34));
         double var42 = (double)((float)(var30 - var36));
         double var44 = (double)((float)(var32 - var38));
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         var12.func_992_a(3);
         var12.func_990_b(0);
         byte var46 = 16;

         for(int var47 = 0; var47 <= var46; ++var47) {
            float var48 = (float)var47 / (float)var46;
            var12.func_991_a(p_4011_2_ + var40 * (double)var48, p_4011_4_ + var42 * (double)(var48 * var48 + var48) * 0.5D + 0.25D, p_4011_6_ + var44 * (double)var48);
         }

         var12.func_982_a();
         GL11.glEnable(2896);
         GL11.glEnable(3553);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_4011_a((EntityFishHook)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }
}
