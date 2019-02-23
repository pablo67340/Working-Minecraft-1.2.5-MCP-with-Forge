package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EnumAction;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderLiving;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class RenderPlayer extends RenderLiving {

   private ModelBiped field_209_f;
   private ModelBiped field_208_g;
   private ModelBiped field_207_h;
   private static final String[] field_206_i = new String[]{"cloth", "chain", "iron", "diamond", "gold"};


   public RenderPlayer() {
      super(new ModelBiped(0.0F), 0.5F);
      this.field_209_f = (ModelBiped)this.field_20920_e;
      this.field_208_g = new ModelBiped(1.0F);
      this.field_207_h = new ModelBiped(0.5F);
   }

   protected int func_187_a(EntityPlayer p_187_1_, int p_187_2_, float p_187_3_) {
      ItemStack var4 = p_187_1_.field_778_b.func_492_d(3 - p_187_2_);
      if(var4 != null) {
         Item var5 = var4.func_1091_a();
         if(var5 instanceof ItemArmor) {
            ItemArmor var6 = (ItemArmor)var5;
            this.func_151_a("/armor/" + field_206_i[var6.field_311_aZ] + "_" + (p_187_2_ == 2?2:1) + ".png");
            ModelBiped var7 = p_187_2_ == 2?this.field_207_h:this.field_208_g;
            var7.field_1286_a.field_1403_h = p_187_2_ == 0;
            var7.field_1285_b.field_1403_h = p_187_2_ == 0;
            var7.field_1284_c.field_1403_h = p_187_2_ == 1 || p_187_2_ == 2;
            var7.field_1283_d.field_1403_h = p_187_2_ == 1;
            var7.field_1282_e.field_1403_h = p_187_2_ == 1;
            var7.field_1281_f.field_1403_h = p_187_2_ == 2 || p_187_2_ == 3;
            var7.field_1280_g.field_1403_h = p_187_2_ == 2 || p_187_2_ == 3;
            this.func_4013_a(var7);
            if(var4.func_40711_u()) {
               return 15;
            }

            return 1;
         }
      }

      return -1;
   }

   public void func_188_a(EntityPlayer p_188_1_, double p_188_2_, double p_188_4_, double p_188_6_, float p_188_8_, float p_188_9_) {
      ItemStack var10 = p_188_1_.field_778_b.func_494_a();
      this.field_208_g.field_1278_i = this.field_207_h.field_1278_i = this.field_209_f.field_1278_i = var10 != null?1:0;
      if(var10 != null && p_188_1_.func_35205_Y() > 0) {
         EnumAction var11 = var10.func_35865_n();
         if(var11 == EnumAction.block) {
            this.field_208_g.field_1278_i = this.field_207_h.field_1278_i = this.field_209_f.field_1278_i = 3;
         } else if(var11 == EnumAction.bow) {
            this.field_208_g.field_40333_u = this.field_207_h.field_40333_u = this.field_209_f.field_40333_u = true;
         }
      }

      this.field_208_g.field_1277_j = this.field_207_h.field_1277_j = this.field_209_f.field_1277_j = p_188_1_.func_381_o();
      double var13 = p_188_4_ - (double)p_188_1_.field_9292_aO;
      if(p_188_1_.func_381_o() && !(p_188_1_ instanceof EntityPlayerSP)) {
         var13 -= 0.125D;
      }

      super.func_171_a(p_188_1_, p_188_2_, var13, p_188_6_, p_188_8_, p_188_9_);
      this.field_208_g.field_40333_u = this.field_207_h.field_40333_u = this.field_209_f.field_40333_u = false;
      this.field_208_g.field_1277_j = this.field_207_h.field_1277_j = this.field_209_f.field_1277_j = false;
      this.field_208_g.field_1278_i = this.field_207_h.field_1278_i = this.field_209_f.field_1278_i = 0;
   }

   protected void func_22015_a(EntityPlayer p_22015_1_, double p_22015_2_, double p_22015_4_, double p_22015_6_) {
      if(Minecraft.func_22006_t() && p_22015_1_ != this.field_191_a.field_22188_h) {
         float var8 = 1.6F;
         float var9 = 0.016666668F * var8;
         float var10 = p_22015_1_.func_379_d(this.field_191_a.field_22188_h);
         float var11 = p_22015_1_.func_381_o()?32.0F:64.0F;
         if(var10 < var11) {
            String var12 = p_22015_1_.field_771_i;
            if(!p_22015_1_.func_381_o()) {
               if(p_22015_1_.func_22051_K()) {
                  this.func_22013_a(p_22015_1_, var12, p_22015_2_, p_22015_4_ - 1.5D, p_22015_6_, 64);
               } else {
                  this.func_22013_a(p_22015_1_, var12, p_22015_2_, p_22015_4_, p_22015_6_, 64);
               }
            } else {
               FontRenderer var13 = this.func_6329_a();
               GL11.glPushMatrix();
               GL11.glTranslatef((float)p_22015_2_ + 0.0F, (float)p_22015_4_ + 2.3F, (float)p_22015_6_);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-this.field_191_a.field_1225_i, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(this.field_191_a.field_1224_j, 1.0F, 0.0F, 0.0F);
               GL11.glScalef(-var9, -var9, var9);
               GL11.glDisable(2896);
               GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
               GL11.glDepthMask(false);
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               Tessellator var14 = Tessellator.field_1512_a;
               GL11.glDisable(3553);
               var14.func_977_b();
               int var15 = var13.func_871_a(var12) / 2;
               var14.func_986_a(0.0F, 0.0F, 0.0F, 0.25F);
               var14.func_991_a((double)(-var15 - 1), -1.0D, 0.0D);
               var14.func_991_a((double)(-var15 - 1), 8.0D, 0.0D);
               var14.func_991_a((double)(var15 + 1), 8.0D, 0.0D);
               var14.func_991_a((double)(var15 + 1), -1.0D, 0.0D);
               var14.func_982_a();
               GL11.glEnable(3553);
               GL11.glDepthMask(true);
               var13.func_873_b(var12, -var13.func_871_a(var12) / 2, 0, 553648127);
               GL11.glEnable(2896);
               GL11.glDisable(3042);
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glPopMatrix();
            }
         }
      }

   }

   protected void func_4015_a(EntityPlayer p_4015_1_, float p_4015_2_) {
      super.func_6331_b(p_4015_1_, p_4015_2_);
      ItemStack var3 = p_4015_1_.field_778_b.func_492_d(3);
      if(var3 != null && var3.func_1091_a().field_291_aS < 256) {
         GL11.glPushMatrix();
         this.field_209_f.field_1286_a.func_926_b(0.0625F);
         if(RenderBlocks.func_1219_a(Block.field_345_n[var3.field_1617_c].func_210_f())) {
            float var4 = 0.625F;
            GL11.glTranslatef(0.0F, -0.25F, 0.0F);
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var4, -var4, var4);
         }

         this.field_191_a.field_4236_f.func_4132_a(p_4015_1_, var3, 0);
         GL11.glPopMatrix();
      }

      float var6;
      if(p_4015_1_.field_771_i.equals("deadmau5") && this.func_140_a(p_4015_1_.field_20047_bv, (String)null)) {
         for(int var19 = 0; var19 < 2; ++var19) {
            float var5 = p_4015_1_.field_603_as + (p_4015_1_.field_605_aq - p_4015_1_.field_603_as) * p_4015_2_ - (p_4015_1_.field_734_o + (p_4015_1_.field_735_n - p_4015_1_.field_734_o) * p_4015_2_);
            var6 = p_4015_1_.field_602_at + (p_4015_1_.field_604_ar - p_4015_1_.field_602_at) * p_4015_2_;
            GL11.glPushMatrix();
            GL11.glRotatef(var5, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var6, 1.0F, 0.0F, 0.0F);
            GL11.glTranslatef(0.375F * (float)(var19 * 2 - 1), 0.0F, 0.0F);
            GL11.glTranslatef(0.0F, -0.375F, 0.0F);
            GL11.glRotatef(-var6, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-var5, 0.0F, 1.0F, 0.0F);
            float var7 = 1.3333334F;
            GL11.glScalef(var7, var7, var7);
            this.field_209_f.func_20095_a(0.0625F);
            GL11.glPopMatrix();
         }
      }

      float var10;
      if(this.func_140_a(p_4015_1_.field_20067_q, (String)null)) {
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, 0.0F, 0.125F);
         double var20 = p_4015_1_.field_20066_r + (p_4015_1_.field_20063_u - p_4015_1_.field_20066_r) * (double)p_4015_2_ - (p_4015_1_.field_9285_at + (p_4015_1_.field_611_ak - p_4015_1_.field_9285_at) * (double)p_4015_2_);
         double var23 = p_4015_1_.field_20065_s + (p_4015_1_.field_20062_v - p_4015_1_.field_20065_s) * (double)p_4015_2_ - (p_4015_1_.field_9284_au + (p_4015_1_.field_610_al - p_4015_1_.field_9284_au) * (double)p_4015_2_);
         double var8 = p_4015_1_.field_20064_t + (p_4015_1_.field_20061_w - p_4015_1_.field_20064_t) * (double)p_4015_2_ - (p_4015_1_.field_9283_av + (p_4015_1_.field_609_am - p_4015_1_.field_9283_av) * (double)p_4015_2_);
         var10 = p_4015_1_.field_734_o + (p_4015_1_.field_735_n - p_4015_1_.field_734_o) * p_4015_2_;
         double var11 = (double)MathHelper.func_1106_a(var10 * 3.1415927F / 180.0F);
         double var13 = (double)(-MathHelper.func_1114_b(var10 * 3.1415927F / 180.0F));
         float var15 = (float)var23 * 10.0F;
         if(var15 < -6.0F) {
            var15 = -6.0F;
         }

         if(var15 > 32.0F) {
            var15 = 32.0F;
         }

         float var16 = (float)(var20 * var11 + var8 * var13) * 100.0F;
         float var17 = (float)(var20 * var13 - var8 * var11) * 100.0F;
         if(var16 < 0.0F) {
            var16 = 0.0F;
         }

         float var18 = p_4015_1_.field_775_e + (p_4015_1_.field_774_f - p_4015_1_.field_775_e) * p_4015_2_;
         var15 += MathHelper.func_1106_a((p_4015_1_.field_9291_aR + (p_4015_1_.field_9290_aS - p_4015_1_.field_9291_aR) * p_4015_2_) * 6.0F) * 32.0F * var18;
         if(p_4015_1_.func_381_o()) {
            var15 += 25.0F;
         }

         GL11.glRotatef(6.0F + var16 / 2.0F + var15, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var17 / 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var17 / 2.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         this.field_209_f.func_20096_b(0.0625F);
         GL11.glPopMatrix();
      }

      ItemStack var21 = p_4015_1_.field_778_b.func_494_a();
      if(var21 != null) {
         GL11.glPushMatrix();
         this.field_209_f.field_1283_d.func_926_b(0.0625F);
         GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
         if(p_4015_1_.field_4128_n != null) {
            var21 = new ItemStack(Item.field_266_B);
         }

         EnumAction var22 = null;
         if(p_4015_1_.func_35205_Y() > 0) {
            var22 = var21.func_35865_n();
         }

         if(var21.field_1617_c < 256 && RenderBlocks.func_1219_a(Block.field_345_n[var21.field_1617_c].func_210_f())) {
            var6 = 0.5F;
            GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
            var6 *= 0.75F;
            GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
         } else if(var21.field_1617_c == Item.field_227_i.field_291_aS) {
            var6 = 0.625F;
            GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
            GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else if(Item.field_233_c[var21.field_1617_c].func_4017_a()) {
            var6 = 0.625F;
            if(Item.field_233_c[var21.field_1617_c].func_4023_b()) {
               GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
               GL11.glTranslatef(0.0F, -0.125F, 0.0F);
            }

            if(p_4015_1_.func_35205_Y() > 0 && var22 == EnumAction.block) {
               GL11.glTranslatef(0.05F, 0.0F, -0.1F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
            }

            GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
            GL11.glScalef(var6, -var6, var6);
            GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         } else {
            var6 = 0.375F;
            GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
            GL11.glScalef(var6, var6, var6);
            GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
         }

         if(var21.func_1091_a().func_46058_c()) {
            for(int var25 = 0; var25 <= 1; ++var25) {
               int var24 = var21.func_1091_a().func_27010_f(var21.func_21181_i(), var25);
               float var26 = (float)(var24 >> 16 & 255) / 255.0F;
               float var9 = (float)(var24 >> 8 & 255) / 255.0F;
               var10 = (float)(var24 & 255) / 255.0F;
               GL11.glColor4f(var26, var9, var10, 1.0F);
               this.field_191_a.field_4236_f.func_4132_a(p_4015_1_, var21, var25);
            }
         } else {
            this.field_191_a.field_4236_f.func_4132_a(p_4015_1_, var21, 0);
         }

         GL11.glPopMatrix();
      }

   }

   protected void func_186_b(EntityPlayer p_186_1_, float p_186_2_) {
      float var3 = 0.9375F;
      GL11.glScalef(var3, var3, var3);
   }

   public void func_185_b() {
      this.field_209_f.field_1244_k = 0.0F;
      this.field_209_f.func_863_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
      this.field_209_f.field_1283_d.func_922_a(0.0625F);
   }

   protected void func_22016_b(EntityPlayer p_22016_1_, double p_22016_2_, double p_22016_4_, double p_22016_6_) {
      if(p_22016_1_.func_354_B() && p_22016_1_.func_22051_K()) {
         super.func_22012_b(p_22016_1_, p_22016_2_ + (double)p_22016_1_.field_22063_x, p_22016_4_ + (double)p_22016_1_.field_22062_y, p_22016_6_ + (double)p_22016_1_.field_22061_z);
      } else {
         super.func_22012_b(p_22016_1_, p_22016_2_, p_22016_4_, p_22016_6_);
      }

   }

   protected void func_22017_a(EntityPlayer p_22017_1_, float p_22017_2_, float p_22017_3_, float p_22017_4_) {
      if(p_22017_1_.func_354_B() && p_22017_1_.func_22051_K()) {
         GL11.glRotatef(p_22017_1_.func_22059_J(), 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.func_172_a(p_22017_1_), 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
      } else {
         super.func_21004_a(p_22017_1_, p_22017_2_, p_22017_3_, p_22017_4_);
      }

   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_22014_a(EntityLiving p_22014_1_, double p_22014_2_, double p_22014_4_, double p_22014_6_) {
      this.func_22015_a((EntityPlayer)p_22014_1_, p_22014_2_, p_22014_4_, p_22014_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6330_a(EntityLiving p_6330_1_, float p_6330_2_) {
      this.func_186_b((EntityPlayer)p_6330_1_, p_6330_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected int func_166_a(EntityLiving p_166_1_, int p_166_2_, float p_166_3_) {
      return this.func_187_a((EntityPlayer)p_166_1_, p_166_2_, p_166_3_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_6331_b(EntityLiving p_6331_1_, float p_6331_2_) {
      this.func_4015_a((EntityPlayer)p_6331_1_, p_6331_2_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_21004_a(EntityLiving p_21004_1_, float p_21004_2_, float p_21004_3_, float p_21004_4_) {
      this.func_22017_a((EntityPlayer)p_21004_1_, p_21004_2_, p_21004_3_, p_21004_4_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   protected void func_22012_b(EntityLiving p_22012_1_, double p_22012_2_, double p_22012_4_, double p_22012_6_) {
      this.func_22016_b((EntityPlayer)p_22012_1_, p_22012_2_, p_22012_4_, p_22012_6_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_171_a(EntityLiving p_171_1_, double p_171_2_, double p_171_4_, double p_171_6_, float p_171_8_, float p_171_9_) {
      this.func_188_a((EntityPlayer)p_171_1_, p_171_2_, p_171_4_, p_171_6_, p_171_8_, p_171_9_);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void func_147_a(Entity p_147_1_, double p_147_2_, double p_147_4_, double p_147_6_, float p_147_8_, float p_147_9_) {
      this.func_188_a((EntityPlayer)p_147_1_, p_147_2_, p_147_4_, p_147_6_, p_147_8_, p_147_9_);
   }

}
