package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.ActiveRenderInfo;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkProviderLoadOrGenerate;
import net.minecraft.src.ClippingHelperImpl;
import net.minecraft.src.EffectRenderer;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRainFX;
import net.minecraft.src.EntitySmokeFX;
import net.minecraft.src.Frustrum;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.ItemRenderer;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MouseFilter;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.Potion;
import net.minecraft.src.Profiler;
import net.minecraft.src.RenderGlobal;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public class EntityRenderer {

   public static boolean field_28135_a = false;
   public static int field_28134_b;
   private Minecraft field_1388_h;
   private float field_1387_i = 0.0F;
   public ItemRenderer field_1395_a;
   private int field_1386_j;
   private Entity field_1385_k = null;
   private MouseFilter field_22235_l = new MouseFilter();
   private MouseFilter field_22234_m = new MouseFilter();
   private MouseFilter field_22233_n = new MouseFilter();
   private MouseFilter field_22232_o = new MouseFilter();
   private MouseFilter field_22231_p = new MouseFilter();
   private MouseFilter field_22229_q = new MouseFilter();
   private float field_22228_r = 4.0F;
   private float field_22227_s = 4.0F;
   private float field_22226_t = 0.0F;
   private float field_22225_u = 0.0F;
   private float field_22224_v = 0.0F;
   private float field_22223_w = 0.0F;
   private float field_40682_H;
   private float field_40683_I;
   private float field_40684_J;
   private float field_40685_K;
   private float field_40681_L;
   private float field_22222_x = 0.0F;
   private float field_22221_y = 0.0F;
   private float field_22220_z = 0.0F;
   private float field_22230_A = 0.0F;
   public int field_35818_d;
   private int[] field_35811_L;
   private float field_35812_M;
   private float field_35813_N;
   private float field_35814_O;
   private boolean field_27288_B = false;
   private double field_21155_l = 1.0D;
   private double field_21154_m = 0.0D;
   private double field_21153_n = 0.0D;
   private long field_1384_l = System.currentTimeMillis();
   private long field_28133_I = 0L;
   private boolean field_35815_V = false;
   float field_35819_e = 0.0F;
   float field_35816_f = 0.0F;
   float field_35817_g = 0.0F;
   float field_35821_h = 0.0F;
   private Random field_1383_m = new Random();
   private int field_27287_H = 0;
   float[] field_35822_i;
   float[] field_35820_j;
   volatile int field_1394_b = 0;
   volatile int field_1393_c = 0;
   FloatBuffer field_1392_d = GLAllocation.func_1123_d(16);
   float field_4270_e;
   float field_4269_f;
   float field_4268_g;
   private float field_1382_n;
   private float field_1381_o;
   public int field_35823_q;


   public EntityRenderer(Minecraft p_i436_1_) {
      this.field_1388_h = p_i436_1_;
      this.field_1395_a = new ItemRenderer(p_i436_1_);
      this.field_35818_d = p_i436_1_.field_6315_n.func_1074_a(new BufferedImage(16, 16, 1));
      this.field_35811_L = new int[256];
   }

   public void func_911_a() {
      this.func_35809_c();
      this.func_35807_d();
      this.field_1382_n = this.field_1381_o;
      this.field_22227_s = this.field_22228_r;
      this.field_22225_u = this.field_22226_t;
      this.field_22223_w = this.field_22224_v;
      this.field_22221_y = this.field_22222_x;
      this.field_22230_A = this.field_22220_z;
      float var1;
      float var2;
      if(this.field_1388_h.field_6304_y.field_22274_D) {
         var1 = this.field_1388_h.field_6304_y.field_1582_c * 0.6F + 0.2F;
         var2 = var1 * var1 * var1 * 8.0F;
         this.field_40684_J = this.field_22235_l.func_22386_a(this.field_40682_H, 0.05F * var2);
         this.field_40685_K = this.field_22234_m.func_22386_a(this.field_40683_I, 0.05F * var2);
         this.field_40681_L = 0.0F;
         this.field_40682_H = 0.0F;
         this.field_40683_I = 0.0F;
      }

      if(this.field_1388_h.field_22009_h == null) {
         this.field_1388_h.field_22009_h = this.field_1388_h.field_6322_g;
      }

      var1 = this.field_1388_h.field_6324_e.func_598_c(MathHelper.func_1108_b(this.field_1388_h.field_22009_h.field_611_ak), MathHelper.func_1108_b(this.field_1388_h.field_22009_h.field_610_al), MathHelper.func_1108_b(this.field_1388_h.field_22009_h.field_609_am));
      var2 = (float)(3 - this.field_1388_h.field_6304_y.field_1580_e) / 3.0F;
      float var3 = var1 * (1.0F - var2) + var2;
      this.field_1381_o += (var3 - this.field_1381_o) * 0.1F;
      ++this.field_1386_j;
      this.field_1395_a.func_895_a();
      this.func_916_c();
   }

   public void func_910_a(float p_910_1_) {
      if(this.field_1388_h.field_22009_h != null) {
         if(this.field_1388_h.field_6324_e != null) {
            double var2 = (double)this.field_1388_h.field_6327_b.func_727_b();
            this.field_1388_h.field_6305_x = this.field_1388_h.field_22009_h.func_416_a(var2, p_910_1_);
            double var4 = var2;
            Vec3D var6 = this.field_1388_h.field_22009_h.func_427_e(p_910_1_);
            if(this.field_1388_h.field_6327_b.func_35636_i()) {
               var2 = 6.0D;
               var4 = 6.0D;
            } else {
               if(var2 > 3.0D) {
                  var4 = 3.0D;
               }

               var2 = var4;
            }

            if(this.field_1388_h.field_6305_x != null) {
               var4 = this.field_1388_h.field_6305_x.field_1169_f.func_1251_c(var6);
            }

            Vec3D var7 = this.field_1388_h.field_22009_h.func_430_f(p_910_1_);
            Vec3D var8 = var6.func_1257_c(var7.field_1776_a * var2, var7.field_1775_b * var2, var7.field_1779_c * var2);
            this.field_1385_k = null;
            float var9 = 1.0F;
            List var10 = this.field_1388_h.field_6324_e.func_659_b(this.field_1388_h.field_22009_h, this.field_1388_h.field_22009_h.field_601_au.func_1170_a(var7.field_1776_a * var2, var7.field_1775_b * var2, var7.field_1779_c * var2).func_1177_b((double)var9, (double)var9, (double)var9));
            double var11 = var4;

            for(int var13 = 0; var13 < var10.size(); ++var13) {
               Entity var14 = (Entity)var10.get(var13);
               if(var14.func_401_c_()) {
                  float var15 = var14.func_4035_j_();
                  AxisAlignedBB var16 = var14.field_601_au.func_1177_b((double)var15, (double)var15, (double)var15);
                  MovingObjectPosition var17 = var16.func_1169_a(var6, var8);
                  if(var16.func_4150_a(var6)) {
                     if(0.0D < var11 || var11 == 0.0D) {
                        this.field_1385_k = var14;
                        var11 = 0.0D;
                     }
                  } else if(var17 != null) {
                     double var18 = var6.func_1251_c(var17.field_1169_f);
                     if(var18 < var11 || var11 == 0.0D) {
                        this.field_1385_k = var14;
                        var11 = var18;
                     }
                  }
               }
            }

            if(this.field_1385_k != null && (var11 < var4 || this.field_1388_h.field_6305_x == null)) {
               this.field_1388_h.field_6305_x = new MovingObjectPosition(this.field_1385_k);
            }

         }
      }
   }

   private void func_35809_c() {
      EntityPlayerSP var1 = (EntityPlayerSP)this.field_1388_h.field_22009_h;
      this.field_35814_O = var1.func_35220_u_();
      this.field_35813_N = this.field_35812_M;
      this.field_35812_M += (this.field_35814_O - this.field_35812_M) * 0.5F;
   }

   private float func_914_d(float p_914_1_, boolean p_914_2_) {
      if(this.field_35823_q > 0) {
         return 90.0F;
      } else {
         EntityPlayer var3 = (EntityPlayer)this.field_1388_h.field_22009_h;
         float var4 = 70.0F;
         if(p_914_2_) {
            var4 += this.field_1388_h.field_6304_y.field_35379_L * 40.0F;
            var4 *= this.field_35813_N + (this.field_35812_M - this.field_35813_N) * p_914_1_;
         }

         if(var3.func_40114_aH() <= 0) {
            float var5 = (float)var3.field_712_J + p_914_1_;
            var4 /= (1.0F - 500.0F / (var5 + 500.0F)) * 2.0F + 1.0F;
         }

         int var6 = ActiveRenderInfo.func_41066_a(this.field_1388_h.field_6324_e, var3, p_914_1_);
         if(var6 != 0 && Block.field_345_n[var6].field_356_bn == Material.field_1332_f) {
            var4 = var4 * 60.0F / 70.0F;
         }

         return var4 + this.field_22221_y + (this.field_22222_x - this.field_22221_y) * p_914_1_;
      }
   }

   private void func_920_e(float p_920_1_) {
      EntityLiving var2 = this.field_1388_h.field_22009_h;
      float var3 = (float)var2.field_715_G - p_920_1_;
      float var4;
      if(var2.func_40114_aH() <= 0) {
         var4 = (float)var2.field_712_J + p_920_1_;
         GL11.glRotatef(40.0F - 8000.0F / (var4 + 200.0F), 0.0F, 0.0F, 1.0F);
      }

      if(var3 >= 0.0F) {
         var3 /= (float)var2.field_9332_M;
         var3 = MathHelper.func_1106_a(var3 * var3 * var3 * var3 * 3.1415927F);
         var4 = var2.field_9331_N;
         GL11.glRotatef(-var4, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-var3 * 14.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(var4, 0.0F, 1.0F, 0.0F);
      }
   }

   private void func_917_f(float p_917_1_) {
      if(this.field_1388_h.field_22009_h instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)this.field_1388_h.field_22009_h;
         float var3 = var2.field_9290_aS - var2.field_9291_aR;
         float var4 = -(var2.field_9290_aS + var3 * p_917_1_);
         float var5 = var2.field_775_e + (var2.field_774_f - var2.field_775_e) * p_917_1_;
         float var6 = var2.field_9329_Q + (var2.field_9328_R - var2.field_9329_Q) * p_917_1_;
         GL11.glTranslatef(MathHelper.func_1106_a(var4 * 3.1415927F) * var5 * 0.5F, -Math.abs(MathHelper.func_1114_b(var4 * 3.1415927F) * var5), 0.0F);
         GL11.glRotatef(MathHelper.func_1106_a(var4 * 3.1415927F) * var5 * 3.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(Math.abs(MathHelper.func_1114_b(var4 * 3.1415927F - 0.2F) * var5) * 5.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var6, 1.0F, 0.0F, 0.0F);
      }
   }

   private void func_4138_g(float p_4138_1_) {
      EntityLiving var2 = this.field_1388_h.field_22009_h;
      float var3 = var2.field_9292_aO - 1.62F;
      double var4 = var2.field_9285_at + (var2.field_611_ak - var2.field_9285_at) * (double)p_4138_1_;
      double var6 = var2.field_9284_au + (var2.field_610_al - var2.field_9284_au) * (double)p_4138_1_ - (double)var3;
      double var8 = var2.field_9283_av + (var2.field_609_am - var2.field_9283_av) * (double)p_4138_1_;
      GL11.glRotatef(this.field_22230_A + (this.field_22220_z - this.field_22230_A) * p_4138_1_, 0.0F, 0.0F, 1.0F);
      if(var2.func_22051_K()) {
         var3 = (float)((double)var3 + 1.0D);
         GL11.glTranslatef(0.0F, 0.3F, 0.0F);
         if(!this.field_1388_h.field_6304_y.field_22273_E) {
            int var10 = this.field_1388_h.field_6324_e.func_600_a(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_610_al), MathHelper.func_1108_b(var2.field_609_am));
            if(var10 == Block.field_9262_S.field_376_bc) {
               int var11 = this.field_1388_h.field_6324_e.func_602_e(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_610_al), MathHelper.func_1108_b(var2.field_609_am));
               int var12 = var11 & 3;
               GL11.glRotatef((float)(var12 * 90), 0.0F, 1.0F, 0.0F);
            }

            GL11.glRotatef(var2.field_603_as + (var2.field_605_aq - var2.field_603_as) * p_4138_1_ + 180.0F, 0.0F, -1.0F, 0.0F);
            GL11.glRotatef(var2.field_602_at + (var2.field_604_ar - var2.field_602_at) * p_4138_1_, -1.0F, 0.0F, 0.0F);
         }
      } else if(this.field_1388_h.field_6304_y.field_1560_x > 0) {
         double var27 = (double)(this.field_22227_s + (this.field_22228_r - this.field_22227_s) * p_4138_1_);
         float var13;
         float var28;
         if(this.field_1388_h.field_6304_y.field_22273_E) {
            var28 = this.field_22225_u + (this.field_22226_t - this.field_22225_u) * p_4138_1_;
            var13 = this.field_22223_w + (this.field_22224_v - this.field_22223_w) * p_4138_1_;
            GL11.glTranslatef(0.0F, 0.0F, (float)(-var27));
            GL11.glRotatef(var13, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var28, 0.0F, 1.0F, 0.0F);
         } else {
            var28 = var2.field_605_aq;
            var13 = var2.field_604_ar;
            if(this.field_1388_h.field_6304_y.field_1560_x == 2) {
               var13 += 180.0F;
            }

            double var14 = (double)(-MathHelper.func_1106_a(var28 / 180.0F * 3.1415927F) * MathHelper.func_1114_b(var13 / 180.0F * 3.1415927F)) * var27;
            double var16 = (double)(MathHelper.func_1114_b(var28 / 180.0F * 3.1415927F) * MathHelper.func_1114_b(var13 / 180.0F * 3.1415927F)) * var27;
            double var18 = (double)(-MathHelper.func_1106_a(var13 / 180.0F * 3.1415927F)) * var27;

            for(int var20 = 0; var20 < 8; ++var20) {
               float var21 = (float)((var20 & 1) * 2 - 1);
               float var22 = (float)((var20 >> 1 & 1) * 2 - 1);
               float var23 = (float)((var20 >> 2 & 1) * 2 - 1);
               var21 *= 0.1F;
               var22 *= 0.1F;
               var23 *= 0.1F;
               MovingObjectPosition var24 = this.field_1388_h.field_6324_e.func_645_a(Vec3D.func_1248_b(var4 + (double)var21, var6 + (double)var22, var8 + (double)var23), Vec3D.func_1248_b(var4 - var14 + (double)var21 + (double)var23, var6 - var18 + (double)var22, var8 - var16 + (double)var23));
               if(var24 != null) {
                  double var25 = var24.field_1169_f.func_1251_c(Vec3D.func_1248_b(var4, var6, var8));
                  if(var25 < var27) {
                     var27 = var25;
                  }
               }
            }

            if(this.field_1388_h.field_6304_y.field_1560_x == 2) {
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            GL11.glRotatef(var2.field_604_ar - var13, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(var2.field_605_aq - var28, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.0F, (float)(-var27));
            GL11.glRotatef(var28 - var2.field_605_aq, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(var13 - var2.field_604_ar, 1.0F, 0.0F, 0.0F);
         }
      } else {
         GL11.glTranslatef(0.0F, 0.0F, -0.1F);
      }

      if(!this.field_1388_h.field_6304_y.field_22273_E) {
         GL11.glRotatef(var2.field_602_at + (var2.field_604_ar - var2.field_602_at) * p_4138_1_, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var2.field_603_as + (var2.field_605_aq - var2.field_603_as) * p_4138_1_ + 180.0F, 0.0F, 1.0F, 0.0F);
      }

      GL11.glTranslatef(0.0F, var3, 0.0F);
      var4 = var2.field_9285_at + (var2.field_611_ak - var2.field_9285_at) * (double)p_4138_1_;
      var6 = var2.field_9284_au + (var2.field_610_al - var2.field_9284_au) * (double)p_4138_1_ - (double)var3;
      var8 = var2.field_9283_av + (var2.field_609_am - var2.field_9283_av) * (double)p_4138_1_;
      this.field_27288_B = this.field_1388_h.field_6323_f.func_27307_a(var4, var6, var8, p_4138_1_);
   }

   private void func_4139_a(float p_4139_1_, int p_4139_2_) {
      this.field_1387_i = (float)(256 >> this.field_1388_h.field_6304_y.field_1580_e);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      float var3 = 0.07F;
      if(this.field_1388_h.field_6304_y.field_1578_g) {
         GL11.glTranslatef((float)(-(p_4139_2_ * 2 - 1)) * var3, 0.0F, 0.0F);
      }

      if(this.field_21155_l != 1.0D) {
         GL11.glTranslatef((float)this.field_21154_m, (float)(-this.field_21153_n), 0.0F);
         GL11.glScaled(this.field_21155_l, this.field_21155_l, 1.0D);
      }

      GLU.gluPerspective(this.func_914_d(p_4139_1_, true), (float)this.field_1388_h.field_6326_c / (float)this.field_1388_h.field_6325_d, 0.05F, this.field_1387_i * 2.0F);
      float var4;
      if(this.field_1388_h.field_6327_b.func_35643_e()) {
         var4 = 0.6666667F;
         GL11.glScalef(1.0F, var4, 1.0F);
      }

      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      if(this.field_1388_h.field_6304_y.field_1578_g) {
         GL11.glTranslatef((float)(p_4139_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
      }

      this.func_920_e(p_4139_1_);
      if(this.field_1388_h.field_6304_y.field_1579_f) {
         this.func_917_f(p_4139_1_);
      }

      var4 = this.field_1388_h.field_6322_g.field_28025_B + (this.field_1388_h.field_6322_g.field_28026_A - this.field_1388_h.field_6322_g.field_28025_B) * p_4139_1_;
      if(var4 > 0.0F) {
         byte var5 = 20;
         if(this.field_1388_h.field_6322_g.func_35160_a(Potion.field_35684_k)) {
            var5 = 7;
         }

         float var6 = 5.0F / (var4 * var4 + 5.0F) - var4 * 0.04F;
         var6 *= var6;
         GL11.glRotatef(((float)this.field_1386_j + p_4139_1_) * (float)var5, 0.0F, 1.0F, 1.0F);
         GL11.glScalef(1.0F / var6, 1.0F, 1.0F);
         GL11.glRotatef(-((float)this.field_1386_j + p_4139_1_) * (float)var5, 0.0F, 1.0F, 1.0F);
      }

      this.func_4138_g(p_4139_1_);
      if(this.field_35823_q > 0) {
         int var7 = this.field_35823_q - 1;
         if(var7 == 1) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var7 == 2) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var7 == 3) {
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         }

         if(var7 == 4) {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         }

         if(var7 == 5) {
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
         }
      }

   }

   private void func_4135_b(float p_4135_1_, int p_4135_2_) {
      if(this.field_35823_q <= 0) {
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         float var3 = 0.07F;
         if(this.field_1388_h.field_6304_y.field_1578_g) {
            GL11.glTranslatef((float)(-(p_4135_2_ * 2 - 1)) * var3, 0.0F, 0.0F);
         }

         if(this.field_21155_l != 1.0D) {
            GL11.glTranslatef((float)this.field_21154_m, (float)(-this.field_21153_n), 0.0F);
            GL11.glScaled(this.field_21155_l, this.field_21155_l, 1.0D);
         }

         GLU.gluPerspective(this.func_914_d(p_4135_1_, false), (float)this.field_1388_h.field_6326_c / (float)this.field_1388_h.field_6325_d, 0.05F, this.field_1387_i * 2.0F);
         if(this.field_1388_h.field_6327_b.func_35643_e()) {
            float var4 = 0.6666667F;
            GL11.glScalef(1.0F, var4, 1.0F);
         }

         GL11.glMatrixMode(5888);
         GL11.glLoadIdentity();
         if(this.field_1388_h.field_6304_y.field_1578_g) {
            GL11.glTranslatef((float)(p_4135_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
         }

         GL11.glPushMatrix();
         this.func_920_e(p_4135_1_);
         if(this.field_1388_h.field_6304_y.field_1579_f) {
            this.func_917_f(p_4135_1_);
         }

         if(this.field_1388_h.field_6304_y.field_1560_x == 0 && !this.field_1388_h.field_22009_h.func_22051_K() && !this.field_1388_h.field_6304_y.field_22277_y && !this.field_1388_h.field_6327_b.func_35643_e()) {
            this.func_35806_b((double)p_4135_1_);
            this.field_1395_a.func_4133_a(p_4135_1_);
            this.func_35810_a((double)p_4135_1_);
         }

         GL11.glPopMatrix();
         if(this.field_1388_h.field_6304_y.field_1560_x == 0 && !this.field_1388_h.field_22009_h.func_22051_K()) {
            this.field_1395_a.func_893_b(p_4135_1_);
            this.func_920_e(p_4135_1_);
         }

         if(this.field_1388_h.field_6304_y.field_1579_f) {
            this.func_917_f(p_4135_1_);
         }

      }
   }

   public void func_35810_a(double p_35810_1_) {
      OpenGlHelper.func_40452_a(OpenGlHelper.field_40455_b);
      GL11.glDisable(3553);
      OpenGlHelper.func_40452_a(OpenGlHelper.field_40457_a);
   }

   public void func_35806_b(double p_35806_1_) {
      OpenGlHelper.func_40452_a(OpenGlHelper.field_40455_b);
      GL11.glMatrixMode(5890);
      GL11.glLoadIdentity();
      float var3 = 0.00390625F;
      GL11.glScalef(var3, var3, var3);
      GL11.glTranslatef(8.0F, 8.0F, 8.0F);
      GL11.glMatrixMode(5888);
      this.field_1388_h.field_6315_n.func_1076_b(this.field_35818_d);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 10496);
      GL11.glTexParameteri(3553, 10243, 10496);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(3553);
      OpenGlHelper.func_40452_a(OpenGlHelper.field_40457_a);
   }

   private void func_35807_d() {
      this.field_35816_f = (float)((double)this.field_35816_f + (Math.random() - Math.random()) * Math.random() * Math.random());
      this.field_35821_h = (float)((double)this.field_35821_h + (Math.random() - Math.random()) * Math.random() * Math.random());
      this.field_35816_f = (float)((double)this.field_35816_f * 0.9D);
      this.field_35821_h = (float)((double)this.field_35821_h * 0.9D);
      this.field_35819_e += (this.field_35816_f - this.field_35819_e) * 1.0F;
      this.field_35817_g += (this.field_35821_h - this.field_35817_g) * 1.0F;
      this.field_35815_V = true;
   }

   private void func_35808_e() {
      World var1 = this.field_1388_h.field_6324_e;
      if(var1 != null) {
         for(int var2 = 0; var2 < 256; ++var2) {
            float var3 = var1.func_35464_b(1.0F) * 0.95F + 0.05F;
            float var4 = var1.field_4209_q.field_4219_d[var2 / 16] * var3;
            float var5 = var1.field_4209_q.field_4219_d[var2 % 16] * (this.field_35819_e * 0.1F + 1.5F);
            if(var1.field_27172_i > 0) {
               var4 = var1.field_4209_q.field_4219_d[var2 / 16];
            }

            float var6 = var4 * (var1.func_35464_b(1.0F) * 0.65F + 0.35F);
            float var7 = var4 * (var1.func_35464_b(1.0F) * 0.65F + 0.35F);
            float var10 = var5 * ((var5 * 0.6F + 0.4F) * 0.6F + 0.4F);
            float var11 = var5 * (var5 * var5 * 0.6F + 0.4F);
            float var12 = var6 + var5;
            float var13 = var7 + var10;
            float var14 = var4 + var11;
            var12 = var12 * 0.96F + 0.03F;
            var13 = var13 * 0.96F + 0.03F;
            var14 = var14 * 0.96F + 0.03F;
            if(var1.field_4209_q.field_4218_e == 1) {
               var12 = 0.22F + var5 * 0.75F;
               var13 = 0.28F + var10 * 0.75F;
               var14 = 0.25F + var11 * 0.75F;
            }

            float var15 = this.field_1388_h.field_6304_y.field_35380_M;
            if(var12 > 1.0F) {
               var12 = 1.0F;
            }

            if(var13 > 1.0F) {
               var13 = 1.0F;
            }

            if(var14 > 1.0F) {
               var14 = 1.0F;
            }

            float var16 = 1.0F - var12;
            float var17 = 1.0F - var13;
            float var18 = 1.0F - var14;
            var16 = 1.0F - var16 * var16 * var16 * var16;
            var17 = 1.0F - var17 * var17 * var17 * var17;
            var18 = 1.0F - var18 * var18 * var18 * var18;
            var12 = var12 * (1.0F - var15) + var16 * var15;
            var13 = var13 * (1.0F - var15) + var17 * var15;
            var14 = var14 * (1.0F - var15) + var18 * var15;
            var12 = var12 * 0.96F + 0.03F;
            var13 = var13 * 0.96F + 0.03F;
            var14 = var14 * 0.96F + 0.03F;
            if(var12 > 1.0F) {
               var12 = 1.0F;
            }

            if(var13 > 1.0F) {
               var13 = 1.0F;
            }

            if(var14 > 1.0F) {
               var14 = 1.0F;
            }

            if(var12 < 0.0F) {
               var12 = 0.0F;
            }

            if(var13 < 0.0F) {
               var13 = 0.0F;
            }

            if(var14 < 0.0F) {
               var14 = 0.0F;
            }

            short var19 = 255;
            int var20 = (int)(var12 * 255.0F);
            int var21 = (int)(var13 * 255.0F);
            int var22 = (int)(var14 * 255.0F);
            this.field_35811_L[var2] = var19 << 24 | var20 << 16 | var21 << 8 | var22;
         }

         this.field_1388_h.field_6315_n.func_28150_a(this.field_35811_L, 16, 16, this.field_35818_d);
      }
   }

   public void func_4136_b(float p_4136_1_) {
      Profiler.func_40663_a("lightTex");
      if(this.field_35815_V) {
         this.func_35808_e();
      }

      Profiler.func_40662_b();
      if(!Display.isActive()) {
         if(System.currentTimeMillis() - this.field_1384_l > 500L) {
            this.field_1388_h.func_6252_g();
         }
      } else {
         this.field_1384_l = System.currentTimeMillis();
      }

      Profiler.func_40663_a("mouse");
      if(this.field_1388_h.field_6289_L) {
         this.field_1388_h.field_6299_B.func_772_c();
         float var2 = this.field_1388_h.field_6304_y.field_1582_c * 0.6F + 0.2F;
         float var3 = var2 * var2 * var2 * 8.0F;
         float var4 = (float)this.field_1388_h.field_6299_B.field_1114_a * var3;
         float var5 = (float)this.field_1388_h.field_6299_B.field_1113_b * var3;
         byte var6 = 1;
         if(this.field_1388_h.field_6304_y.field_1581_d) {
            var6 = -1;
         }

         if(this.field_1388_h.field_6304_y.field_22274_D) {
            this.field_40682_H += var4;
            this.field_40683_I += var5;
            float var7 = p_4136_1_ - this.field_40681_L;
            this.field_40681_L = p_4136_1_;
            var4 = this.field_40684_J * var7;
            var5 = this.field_40685_K * var7;
            this.field_1388_h.field_6322_g.func_346_d(var4, var5 * (float)var6);
         } else {
            this.field_1388_h.field_6322_g.func_346_d(var4, var5 * (float)var6);
         }
      }

      Profiler.func_40662_b();
      if(!this.field_1388_h.field_6307_v) {
         field_28135_a = this.field_1388_h.field_6304_y.field_1578_g;
         ScaledResolution var13 = new ScaledResolution(this.field_1388_h.field_6304_y, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
         int var14 = var13.func_903_a();
         int var15 = var13.func_902_b();
         int var16 = Mouse.getX() * var14 / this.field_1388_h.field_6326_c;
         int var17 = var15 - Mouse.getY() * var15 / this.field_1388_h.field_6325_d - 1;
         short var18 = 200;
         if(this.field_1388_h.field_6304_y.field_1577_h == 1) {
            var18 = 120;
         }

         if(this.field_1388_h.field_6304_y.field_1577_h == 2) {
            var18 = 40;
         }

         long var8;
         if(this.field_1388_h.field_6324_e != null) {
            Profiler.func_40663_a("level");
            if(this.field_1388_h.field_6304_y.field_1577_h == 0) {
               this.func_4134_c(p_4136_1_, 0L);
            } else {
               this.func_4134_c(p_4136_1_, this.field_28133_I + (long)(1000000000 / var18));
            }

            Profiler.func_40661_c("sleep");
            if(this.field_1388_h.field_6304_y.field_1577_h == 2) {
               var8 = (this.field_28133_I + (long)(1000000000 / var18) - System.nanoTime()) / 1000000L;
               if(var8 > 0L && var8 < 500L) {
                  try {
                     Thread.sleep(var8);
                  } catch (InterruptedException var12) {
                     var12.printStackTrace();
                  }
               }
            }

            this.field_28133_I = System.nanoTime();
            Profiler.func_40661_c("gui");
            if(!this.field_1388_h.field_6304_y.field_22277_y || this.field_1388_h.field_6313_p != null) {
               this.field_1388_h.field_6308_u.func_4066_a(p_4136_1_, this.field_1388_h.field_6313_p != null, var16, var17);
            }

            Profiler.func_40662_b();
         } else {
            GL11.glViewport(0, 0, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            this.func_905_b();
            var8 = (this.field_28133_I + (long)(1000000000 / var18) - System.nanoTime()) / 1000000L;
            if(var8 < 0L) {
               var8 += 10L;
            }

            if(var8 > 0L && var8 < 500L) {
               try {
                  Thread.sleep(var8);
               } catch (InterruptedException var11) {
                  var11.printStackTrace();
               }
            }

            this.field_28133_I = System.nanoTime();
         }

         if(this.field_1388_h.field_6313_p != null) {
            GL11.glClear(256);
            this.field_1388_h.field_6313_p.func_571_a(var16, var17, p_4136_1_);
            if(this.field_1388_h.field_6313_p != null && this.field_1388_h.field_6313_p.field_25091_h != null) {
               this.field_1388_h.field_6313_p.field_25091_h.func_25087_a(p_4136_1_);
            }
         }

      }
   }

   public void func_4134_c(float p_4134_1_, long p_4134_2_) {
      Profiler.func_40663_a("lightTex");
      if(this.field_35815_V) {
         this.func_35808_e();
      }

      GL11.glEnable(2884);
      GL11.glEnable(2929);
      if(this.field_1388_h.field_22009_h == null) {
         this.field_1388_h.field_22009_h = this.field_1388_h.field_6322_g;
      }

      Profiler.func_40661_c("pick");
      this.func_910_a(p_4134_1_);
      EntityLiving var4 = this.field_1388_h.field_22009_h;
      RenderGlobal var5 = this.field_1388_h.field_6323_f;
      EffectRenderer var6 = this.field_1388_h.field_6321_h;
      double var7 = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)p_4134_1_;
      double var9 = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)p_4134_1_;
      double var11 = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)p_4134_1_;
      Profiler.func_40661_c("center");
      IChunkProvider var13 = this.field_1388_h.field_6324_e.func_21118_q();
      int var16;
      if(var13 instanceof ChunkProviderLoadOrGenerate) {
         ChunkProviderLoadOrGenerate var14 = (ChunkProviderLoadOrGenerate)var13;
         int var15 = MathHelper.func_1110_d((float)((int)var7)) >> 4;
         var16 = MathHelper.func_1110_d((float)((int)var11)) >> 4;
         var14.func_21110_c(var15, var16);
      }

      for(int var18 = 0; var18 < 2; ++var18) {
         if(this.field_1388_h.field_6304_y.field_1578_g) {
            field_28134_b = var18;
            if(field_28134_b == 0) {
               GL11.glColorMask(false, true, true, false);
            } else {
               GL11.glColorMask(true, false, false, false);
            }
         }

         Profiler.func_40661_c("clear");
         GL11.glViewport(0, 0, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
         this.func_4137_h(p_4134_1_);
         GL11.glClear(16640);
         GL11.glEnable(2884);
         Profiler.func_40661_c("camera");
         this.func_4139_a(p_4134_1_, var18);
         ActiveRenderInfo.func_41067_a(this.field_1388_h.field_6322_g, this.field_1388_h.field_6304_y.field_1560_x == 2);
         Profiler.func_40661_c("frustrum");
         ClippingHelperImpl.func_1155_a();
         if(this.field_1388_h.field_6304_y.field_1580_e < 2) {
            this.func_4140_a(-1, p_4134_1_);
            Profiler.func_40661_c("sky");
            var5.func_4142_a(p_4134_1_);
         }

         GL11.glEnable(2912);
         this.func_4140_a(1, p_4134_1_);
         if(this.field_1388_h.field_6304_y.field_22278_j) {
            GL11.glShadeModel(7425);
         }

         Profiler.func_40661_c("culling");
         Frustrum var19 = new Frustrum();
         var19.func_343_a(var7, var9, var11);
         this.field_1388_h.field_6323_f.func_960_a(var19, p_4134_1_);
         if(var18 == 0) {
            Profiler.func_40661_c("updatechunks");

            while(!this.field_1388_h.field_6323_f.func_948_a(var4, false) && p_4134_2_ != 0L) {
               long var20 = p_4134_2_ - System.nanoTime();
               if(var20 < 0L || var20 > 1000000000L) {
                  break;
               }
            }
         }

         this.func_4140_a(0, p_4134_1_);
         GL11.glEnable(2912);
         GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/terrain.png"));
         RenderHelper.func_1159_a();
         Profiler.func_40661_c("terrain");
         var5.func_943_a(var4, 0, (double)p_4134_1_);
         GL11.glShadeModel(7424);
         EntityPlayer var21;
         if(this.field_35823_q == 0) {
            RenderHelper.func_1158_b();
            Profiler.func_40661_c("entities");
            var5.func_951_a(var4.func_427_e(p_4134_1_), var19, p_4134_1_);
            this.func_35806_b((double)p_4134_1_);
            Profiler.func_40661_c("litParticles");
            var6.func_1187_b(var4, p_4134_1_);
            RenderHelper.func_1159_a();
            this.func_4140_a(0, p_4134_1_);
            Profiler.func_40661_c("particles");
            var6.func_1189_a(var4, p_4134_1_);
            this.func_35810_a((double)p_4134_1_);
            if(this.field_1388_h.field_6305_x != null && var4.func_393_a(Material.field_1332_f) && var4 instanceof EntityPlayer && !this.field_1388_h.field_6304_y.field_22277_y) {
               var21 = (EntityPlayer)var4;
               GL11.glDisable(3008);
               Profiler.func_40661_c("outline");
               var5.func_959_a(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), p_4134_1_);
               var5.func_955_b(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), p_4134_1_);
               GL11.glEnable(3008);
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(2884);
         GL11.glBlendFunc(770, 771);
         GL11.glDepthMask(true);
         this.func_4140_a(0, p_4134_1_);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/terrain.png"));
         if(this.field_1388_h.field_6304_y.field_1576_i) {
            Profiler.func_40661_c("water");
            if(this.field_1388_h.field_6304_y.field_22278_j) {
               GL11.glShadeModel(7425);
            }

            GL11.glColorMask(false, false, false, false);
            var16 = var5.func_943_a(var4, 1, (double)p_4134_1_);
            if(this.field_1388_h.field_6304_y.field_1578_g) {
               if(field_28134_b == 0) {
                  GL11.glColorMask(false, true, true, true);
               } else {
                  GL11.glColorMask(true, false, false, true);
               }
            } else {
               GL11.glColorMask(true, true, true, true);
            }

            if(var16 > 0) {
               var5.func_944_a(1, (double)p_4134_1_);
            }

            GL11.glShadeModel(7424);
         } else {
            Profiler.func_40661_c("water");
            var5.func_943_a(var4, 1, (double)p_4134_1_);
         }

         GL11.glDepthMask(true);
         GL11.glEnable(2884);
         GL11.glDisable(3042);
         if(this.field_21155_l == 1.0D && var4 instanceof EntityPlayer && !this.field_1388_h.field_6304_y.field_22277_y && this.field_1388_h.field_6305_x != null && !var4.func_393_a(Material.field_1332_f)) {
            var21 = (EntityPlayer)var4;
            GL11.glDisable(3008);
            Profiler.func_40661_c("outline");
            var5.func_959_a(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), p_4134_1_);
            var5.func_955_b(var21, this.field_1388_h.field_6305_x, 0, var21.field_778_b.func_494_a(), p_4134_1_);
            GL11.glEnable(3008);
         }

         Profiler.func_40661_c("weather");
         this.func_27286_d(p_4134_1_);
         GL11.glDisable(2912);
         if(this.field_1385_k != null) {
            ;
         }

         if(this.field_1388_h.field_6304_y.func_40444_c()) {
            Profiler.func_40661_c("clouds");
            GL11.glPushMatrix();
            this.func_4140_a(0, p_4134_1_);
            GL11.glEnable(2912);
            var5.func_4141_b(p_4134_1_);
            GL11.glDisable(2912);
            this.func_4140_a(1, p_4134_1_);
            GL11.glPopMatrix();
         }

         Profiler.func_40661_c("hand");
         if(this.field_21155_l == 1.0D) {
            GL11.glClear(256);
            this.func_4135_b(p_4134_1_, var18);
         }

         if(!this.field_1388_h.field_6304_y.field_1578_g) {
            Profiler.func_40662_b();
            return;
         }
      }

      GL11.glColorMask(true, true, true, false);
      Profiler.func_40662_b();
   }

   private void func_916_c() {
      float var1 = this.field_1388_h.field_6324_e.func_27162_g(1.0F);
      if(!this.field_1388_h.field_6304_y.field_1576_i) {
         var1 /= 2.0F;
      }

      if(var1 != 0.0F) {
         this.field_1383_m.setSeed((long)this.field_1386_j * 312987231L);
         EntityLiving var2 = this.field_1388_h.field_22009_h;
         World var3 = this.field_1388_h.field_6324_e;
         int var4 = MathHelper.func_1108_b(var2.field_611_ak);
         int var5 = MathHelper.func_1108_b(var2.field_610_al);
         int var6 = MathHelper.func_1108_b(var2.field_609_am);
         byte var7 = 10;
         double var8 = 0.0D;
         double var10 = 0.0D;
         double var12 = 0.0D;
         int var14 = 0;
         int var15 = (int)(100.0F * var1 * var1);
         if(this.field_1388_h.field_6304_y.field_41087_P == 1) {
            var15 >>= 1;
         } else if(this.field_1388_h.field_6304_y.field_41087_P == 2) {
            var15 = 0;
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            int var17 = var4 + this.field_1383_m.nextInt(var7) - this.field_1383_m.nextInt(var7);
            int var18 = var6 + this.field_1383_m.nextInt(var7) - this.field_1383_m.nextInt(var7);
            int var19 = var3.func_35461_e(var17, var18);
            int var20 = var3.func_600_a(var17, var19 - 1, var18);
            BiomeGenBase var21 = var3.func_48454_a(var17, var18);
            if(var19 <= var5 + var7 && var19 >= var5 - var7 && var21.func_27077_d() && var21.func_48411_i() > 0.2F) {
               float var22 = this.field_1383_m.nextFloat();
               float var23 = this.field_1383_m.nextFloat();
               if(var20 > 0) {
                  if(Block.field_345_n[var20].field_356_bn == Material.field_1331_g) {
                     this.field_1388_h.field_6321_h.func_1192_a(new EntitySmokeFX(var3, (double)((float)var17 + var22), (double)((float)var19 + 0.1F) - Block.field_345_n[var20].field_368_bg, (double)((float)var18 + var23), 0.0D, 0.0D, 0.0D));
                  } else {
                     ++var14;
                     if(this.field_1383_m.nextInt(var14) == 0) {
                        var8 = (double)((float)var17 + var22);
                        var10 = (double)((float)var19 + 0.1F) - Block.field_345_n[var20].field_368_bg;
                        var12 = (double)((float)var18 + var23);
                     }

                     this.field_1388_h.field_6321_h.func_1192_a(new EntityRainFX(var3, (double)((float)var17 + var22), (double)((float)var19 + 0.1F) - Block.field_345_n[var20].field_368_bg, (double)((float)var18 + var23)));
                  }
               }
            }
         }

         if(var14 > 0 && this.field_1383_m.nextInt(3) < this.field_27287_H++) {
            this.field_27287_H = 0;
            if(var10 > var2.field_610_al + 1.0D && var3.func_35461_e(MathHelper.func_1108_b(var2.field_611_ak), MathHelper.func_1108_b(var2.field_609_am)) > MathHelper.func_1108_b(var2.field_610_al)) {
               this.field_1388_h.field_6324_e.func_684_a(var8, var10, var12, "ambient.weather.rain", 0.1F, 0.5F);
            } else {
               this.field_1388_h.field_6324_e.func_684_a(var8, var10, var12, "ambient.weather.rain", 0.2F, 1.0F);
            }
         }

      }
   }

   protected void func_27286_d(float p_27286_1_) {
      float var2 = this.field_1388_h.field_6324_e.func_27162_g(p_27286_1_);
      if(var2 > 0.0F) {
         this.func_35806_b((double)p_27286_1_);
         if(this.field_35822_i == null) {
            this.field_35822_i = new float[1024];
            this.field_35820_j = new float[1024];

            for(int var3 = 0; var3 < 32; ++var3) {
               for(int var4 = 0; var4 < 32; ++var4) {
                  float var5 = (float)(var4 - 16);
                  float var6 = (float)(var3 - 16);
                  float var7 = MathHelper.func_1113_c(var5 * var5 + var6 * var6);
                  this.field_35822_i[var3 << 5 | var4] = -var6 / var7;
                  this.field_35820_j[var3 << 5 | var4] = var5 / var7;
               }
            }
         }

         EntityLiving var41 = this.field_1388_h.field_22009_h;
         World var42 = this.field_1388_h.field_6324_e;
         int var43 = MathHelper.func_1108_b(var41.field_611_ak);
         int var44 = MathHelper.func_1108_b(var41.field_610_al);
         int var45 = MathHelper.func_1108_b(var41.field_609_am);
         Tessellator var8 = Tessellator.field_1512_a;
         GL11.glDisable(2884);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glAlphaFunc(516, 0.01F);
         GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/environment/snow.png"));
         double var9 = var41.field_638_aI + (var41.field_611_ak - var41.field_638_aI) * (double)p_27286_1_;
         double var11 = var41.field_637_aJ + (var41.field_610_al - var41.field_637_aJ) * (double)p_27286_1_;
         double var13 = var41.field_636_aK + (var41.field_609_am - var41.field_636_aK) * (double)p_27286_1_;
         int var15 = MathHelper.func_1108_b(var11);
         byte var16 = 5;
         if(this.field_1388_h.field_6304_y.field_1576_i) {
            var16 = 10;
         }

         boolean var17 = false;
         byte var18 = -1;
         float var19 = (float)this.field_1386_j + p_27286_1_;
         if(this.field_1388_h.field_6304_y.field_1576_i) {
            var16 = 10;
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         var17 = false;

         for(int var20 = var45 - var16; var20 <= var45 + var16; ++var20) {
            for(int var21 = var43 - var16; var21 <= var43 + var16; ++var21) {
               int var22 = (var20 - var45 + 16) * 32 + var21 - var43 + 16;
               float var23 = this.field_35822_i[var22] * 0.5F;
               float var24 = this.field_35820_j[var22] * 0.5F;
               BiomeGenBase var25 = var42.func_48454_a(var21, var20);
               if(var25.func_27077_d() || var25.func_27078_c()) {
                  int var26 = var42.func_35461_e(var21, var20);
                  int var27 = var44 - var16;
                  int var28 = var44 + var16;
                  if(var27 < var26) {
                     var27 = var26;
                  }

                  if(var28 < var26) {
                     var28 = var26;
                  }

                  float var29 = 1.0F;
                  int var30 = var26;
                  if(var26 < var15) {
                     var30 = var15;
                  }

                  if(var27 != var28) {
                     this.field_1383_m.setSeed((long)(var21 * var21 * 3121 + var21 * 45238971 ^ var20 * var20 * 418711 + var20 * 13761));
                     float var31 = var25.func_48411_i();
                     float var32;
                     double var35;
                     if(var42.func_4075_a().func_40540_a(var31, var26) >= 0.15F) {
                        if(var18 != 0) {
                           if(var18 >= 0) {
                              var8.func_982_a();
                           }

                           var18 = 0;
                           GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/environment/rain.png"));
                           var8.func_977_b();
                        }

                        var32 = ((float)(this.field_1386_j + var21 * var21 * 3121 + var21 * 45238971 + var20 * var20 * 418711 + var20 * 13761 & 31) + p_27286_1_) / 32.0F * (3.0F + this.field_1383_m.nextFloat());
                        double var33 = (double)((float)var21 + 0.5F) - var41.field_611_ak;
                        var35 = (double)((float)var20 + 0.5F) - var41.field_609_am;
                        float var37 = MathHelper.func_1109_a(var33 * var33 + var35 * var35) / (float)var16;
                        float var38 = 1.0F;
                        var8.func_35835_b(var42.func_35451_b(var21, var30, var20, 0));
                        var8.func_986_a(var38, var38, var38, ((1.0F - var37 * var37) * 0.5F + 0.5F) * var2);
                        var8.func_984_b(-var9 * 1.0D, -var11 * 1.0D, -var13 * 1.0D);
                        var8.func_983_a((double)((float)var21 - var23) + 0.5D, (double)var27, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29), (double)((float)var27 * var29 / 4.0F + var32 * var29));
                        var8.func_983_a((double)((float)var21 + var23) + 0.5D, (double)var27, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29), (double)((float)var27 * var29 / 4.0F + var32 * var29));
                        var8.func_983_a((double)((float)var21 + var23) + 0.5D, (double)var28, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29), (double)((float)var28 * var29 / 4.0F + var32 * var29));
                        var8.func_983_a((double)((float)var21 - var23) + 0.5D, (double)var28, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29), (double)((float)var28 * var29 / 4.0F + var32 * var29));
                        var8.func_984_b(0.0D, 0.0D, 0.0D);
                     } else {
                        if(var18 != 1) {
                           if(var18 >= 0) {
                              var8.func_982_a();
                           }

                           var18 = 1;
                           GL11.glBindTexture(3553, this.field_1388_h.field_6315_n.func_1070_a("/environment/snow.png"));
                           var8.func_977_b();
                        }

                        var32 = ((float)(this.field_1386_j & 511) + p_27286_1_) / 512.0F;
                        float var46 = this.field_1383_m.nextFloat() + var19 * 0.01F * (float)this.field_1383_m.nextGaussian();
                        float var34 = this.field_1383_m.nextFloat() + var19 * (float)this.field_1383_m.nextGaussian() * 0.001F;
                        var35 = (double)((float)var21 + 0.5F) - var41.field_611_ak;
                        double var47 = (double)((float)var20 + 0.5F) - var41.field_609_am;
                        float var39 = MathHelper.func_1109_a(var35 * var35 + var47 * var47) / (float)var16;
                        float var40 = 1.0F;
                        var8.func_35835_b((var42.func_35451_b(var21, var30, var20, 0) * 3 + 15728880) / 4);
                        var8.func_986_a(var40, var40, var40, ((1.0F - var39 * var39) * 0.3F + 0.5F) * var2);
                        var8.func_984_b(-var9 * 1.0D, -var11 * 1.0D, -var13 * 1.0D);
                        var8.func_983_a((double)((float)var21 - var23) + 0.5D, (double)var27, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29 + var46), (double)((float)var27 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_983_a((double)((float)var21 + var23) + 0.5D, (double)var27, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29 + var46), (double)((float)var27 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_983_a((double)((float)var21 + var23) + 0.5D, (double)var28, (double)((float)var20 + var24) + 0.5D, (double)(1.0F * var29 + var46), (double)((float)var28 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_983_a((double)((float)var21 - var23) + 0.5D, (double)var28, (double)((float)var20 - var24) + 0.5D, (double)(0.0F * var29 + var46), (double)((float)var28 * var29 / 4.0F + var32 * var29 + var34));
                        var8.func_984_b(0.0D, 0.0D, 0.0D);
                     }
                  }
               }
            }
         }

         if(var18 >= 0) {
            var8.func_982_a();
         }

         GL11.glEnable(2884);
         GL11.glDisable(3042);
         GL11.glAlphaFunc(516, 0.1F);
         this.func_35810_a((double)p_27286_1_);
      }
   }

   public void func_905_b() {
      ScaledResolution var1 = new ScaledResolution(this.field_1388_h.field_6304_y, this.field_1388_h.field_6326_c, this.field_1388_h.field_6325_d);
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0D, var1.field_25121_a, var1.field_25120_b, 0.0D, 1000.0D, 3000.0D);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
   }

   private void func_4137_h(float p_4137_1_) {
      World var2 = this.field_1388_h.field_6324_e;
      EntityLiving var3 = this.field_1388_h.field_22009_h;
      float var4 = 1.0F / (float)(4 - this.field_1388_h.field_6304_y.field_1580_e);
      var4 = 1.0F - (float)Math.pow((double)var4, 0.25D);
      Vec3D var5 = var2.func_4079_a(this.field_1388_h.field_22009_h, p_4137_1_);
      float var6 = (float)var5.field_1776_a;
      float var7 = (float)var5.field_1775_b;
      float var8 = (float)var5.field_1779_c;
      Vec3D var9 = var2.func_4082_d(p_4137_1_);
      this.field_4270_e = (float)var9.field_1776_a;
      this.field_4269_f = (float)var9.field_1775_b;
      this.field_4268_g = (float)var9.field_1779_c;
      float var11;
      if(this.field_1388_h.field_6304_y.field_1580_e < 2) {
         Vec3D var10 = MathHelper.func_1106_a(var2.func_35456_d(p_4137_1_)) > 0.0F?Vec3D.func_1248_b(-1.0D, 0.0D, 0.0D):Vec3D.func_1248_b(1.0D, 0.0D, 0.0D);
         var11 = (float)var3.func_430_f(p_4137_1_).func_35612_b(var10);
         if(var11 < 0.0F) {
            var11 = 0.0F;
         }

         if(var11 > 0.0F) {
            float[] var12 = var2.field_4209_q.func_4097_b(var2.func_619_c(p_4137_1_), p_4137_1_);
            if(var12 != null) {
               var11 *= var12[3];
               this.field_4270_e = this.field_4270_e * (1.0F - var11) + var12[0] * var11;
               this.field_4269_f = this.field_4269_f * (1.0F - var11) + var12[1] * var11;
               this.field_4268_g = this.field_4268_g * (1.0F - var11) + var12[2] * var11;
            }
         }
      }

      this.field_4270_e += (var6 - this.field_4270_e) * var4;
      this.field_4269_f += (var7 - this.field_4269_f) * var4;
      this.field_4268_g += (var8 - this.field_4268_g) * var4;
      float var19 = var2.func_27162_g(p_4137_1_);
      float var20;
      if(var19 > 0.0F) {
         var11 = 1.0F - var19 * 0.5F;
         var20 = 1.0F - var19 * 0.4F;
         this.field_4270_e *= var11;
         this.field_4269_f *= var11;
         this.field_4268_g *= var20;
      }

      var11 = var2.func_27166_f(p_4137_1_);
      if(var11 > 0.0F) {
         var20 = 1.0F - var11 * 0.5F;
         this.field_4270_e *= var20;
         this.field_4269_f *= var20;
         this.field_4268_g *= var20;
      }

      int var21 = ActiveRenderInfo.func_41066_a(this.field_1388_h.field_6324_e, var3, p_4137_1_);
      if(this.field_27288_B) {
         Vec3D var13 = var2.func_628_d(p_4137_1_);
         this.field_4270_e = (float)var13.field_1776_a;
         this.field_4269_f = (float)var13.field_1775_b;
         this.field_4268_g = (float)var13.field_1779_c;
      } else if(var21 != 0 && Block.field_345_n[var21].field_356_bn == Material.field_1332_f) {
         this.field_4270_e = 0.02F;
         this.field_4269_f = 0.02F;
         this.field_4268_g = 0.2F;
      } else if(var21 != 0 && Block.field_345_n[var21].field_356_bn == Material.field_1331_g) {
         this.field_4270_e = 0.6F;
         this.field_4269_f = 0.1F;
         this.field_4268_g = 0.0F;
      }

      float var22 = this.field_1382_n + (this.field_1381_o - this.field_1382_n) * p_4137_1_;
      this.field_4270_e *= var22;
      this.field_4269_f *= var22;
      this.field_4268_g *= var22;
      double var14 = (var3.field_637_aJ + (var3.field_610_al - var3.field_637_aJ) * (double)p_4137_1_) * var2.field_4209_q.func_46065_j();
      if(var3.func_35160_a(Potion.field_35693_q)) {
         int var16 = var3.func_35167_b(Potion.field_35693_q).func_35802_b();
         if(var16 < 20) {
            var14 *= (double)(1.0F - (float)var16 / 20.0F);
         } else {
            var14 = 0.0D;
         }
      }

      if(var14 < 1.0D) {
         if(var14 < 0.0D) {
            var14 = 0.0D;
         }

         var14 *= var14;
         this.field_4270_e = (float)((double)this.field_4270_e * var14);
         this.field_4269_f = (float)((double)this.field_4269_f * var14);
         this.field_4268_g = (float)((double)this.field_4268_g * var14);
      }

      if(this.field_1388_h.field_6304_y.field_1578_g) {
         float var23 = (this.field_4270_e * 30.0F + this.field_4269_f * 59.0F + this.field_4268_g * 11.0F) / 100.0F;
         float var17 = (this.field_4270_e * 30.0F + this.field_4269_f * 70.0F) / 100.0F;
         float var18 = (this.field_4270_e * 30.0F + this.field_4268_g * 70.0F) / 100.0F;
         this.field_4270_e = var23;
         this.field_4269_f = var17;
         this.field_4268_g = var18;
      }

      GL11.glClearColor(this.field_4270_e, this.field_4269_f, this.field_4268_g, 0.0F);
   }

   private void func_4140_a(int p_4140_1_, float p_4140_2_) {
      EntityLiving var3 = this.field_1388_h.field_22009_h;
      boolean var4 = false;
      if(var3 instanceof EntityPlayer) {
         var4 = ((EntityPlayer)var3).field_35212_aW.field_35756_d;
      }

      if(p_4140_1_ == 999) {
         GL11.glFog(2918, this.func_908_a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glFogi(2917, 9729);
         GL11.glFogf(2915, 0.0F);
         GL11.glFogf(2916, 8.0F);
         if(GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi('\u855a', '\u855b');
         }

         GL11.glFogf(2915, 0.0F);
      } else {
         GL11.glFog(2918, this.func_908_a(this.field_4270_e, this.field_4269_f, this.field_4268_g, 1.0F));
         GL11.glNormal3f(0.0F, -1.0F, 0.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int var5 = ActiveRenderInfo.func_41066_a(this.field_1388_h.field_6324_e, var3, p_4140_2_);
         float var6;
         if(var3.func_35160_a(Potion.field_35693_q)) {
            var6 = 5.0F;
            int var7 = var3.func_35167_b(Potion.field_35693_q).func_35802_b();
            if(var7 < 20) {
               var6 = 5.0F + (this.field_1387_i - 5.0F) * (1.0F - (float)var7 / 20.0F);
            }

            GL11.glFogi(2917, 9729);
            if(p_4140_1_ < 0) {
               GL11.glFogf(2915, 0.0F);
               GL11.glFogf(2916, var6 * 0.8F);
            } else {
               GL11.glFogf(2915, var6 * 0.25F);
               GL11.glFogf(2916, var6);
            }

            if(GLContext.getCapabilities().GL_NV_fog_distance) {
               GL11.glFogi('\u855a', '\u855b');
            }
         } else {
            float var8;
            float var9;
            float var10;
            float var11;
            float var12;
            if(this.field_27288_B) {
               GL11.glFogi(2917, 2048);
               GL11.glFogf(2914, 0.1F);
               var6 = 1.0F;
               var12 = 1.0F;
               var8 = 1.0F;
               if(this.field_1388_h.field_6304_y.field_1578_g) {
                  var9 = (var6 * 30.0F + var12 * 59.0F + var8 * 11.0F) / 100.0F;
                  var10 = (var6 * 30.0F + var12 * 70.0F) / 100.0F;
                  var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
               }
            } else if(var5 > 0 && Block.field_345_n[var5].field_356_bn == Material.field_1332_f) {
               GL11.glFogi(2917, 2048);
               if(!var3.func_35160_a(Potion.field_35680_o)) {
                  GL11.glFogf(2914, 0.1F);
               } else {
                  GL11.glFogf(2914, 0.05F);
               }

               var6 = 0.4F;
               var12 = 0.4F;
               var8 = 0.9F;
               if(this.field_1388_h.field_6304_y.field_1578_g) {
                  var9 = (var6 * 30.0F + var12 * 59.0F + var8 * 11.0F) / 100.0F;
                  var10 = (var6 * 30.0F + var12 * 70.0F) / 100.0F;
                  var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
               }
            } else if(var5 > 0 && Block.field_345_n[var5].field_356_bn == Material.field_1331_g) {
               GL11.glFogi(2917, 2048);
               GL11.glFogf(2914, 2.0F);
               var6 = 0.4F;
               var12 = 0.3F;
               var8 = 0.3F;
               if(this.field_1388_h.field_6304_y.field_1578_g) {
                  var9 = (var6 * 30.0F + var12 * 59.0F + var8 * 11.0F) / 100.0F;
                  var10 = (var6 * 30.0F + var12 * 70.0F) / 100.0F;
                  var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
               }
            } else {
               var6 = this.field_1387_i;
               if(this.field_1388_h.field_6324_e.field_4209_q.func_46064_i() && !var4) {
                  double var13 = (double)((var3.func_35115_a(p_4140_2_) & 15728640) >> 20) / 16.0D + (var3.field_637_aJ + (var3.field_610_al - var3.field_637_aJ) * (double)p_4140_2_ + 4.0D) / 32.0D;
                  if(var13 < 1.0D) {
                     if(var13 < 0.0D) {
                        var13 = 0.0D;
                     }

                     var13 *= var13;
                     var9 = 100.0F * (float)var13;
                     if(var9 < 5.0F) {
                        var9 = 5.0F;
                     }

                     if(var6 > var9) {
                        var6 = var9;
                     }
                  }
               }

               GL11.glFogi(2917, 9729);
               if(p_4140_1_ < 0) {
                  GL11.glFogf(2915, 0.0F);
                  GL11.glFogf(2916, var6 * 0.8F);
               } else {
                  GL11.glFogf(2915, var6 * 0.25F);
                  GL11.glFogf(2916, var6);
               }

               if(GLContext.getCapabilities().GL_NV_fog_distance) {
                  GL11.glFogi('\u855a', '\u855b');
               }

               if(this.field_1388_h.field_6324_e.field_4209_q.func_48218_b((int)var3.field_611_ak, (int)var3.field_609_am)) {
                  GL11.glFogf(2915, var6 * 0.05F);
                  GL11.glFogf(2916, Math.min(var6, 192.0F) * 0.5F);
               }
            }
         }

         GL11.glEnable(2903);
         GL11.glColorMaterial(1028, 4608);
      }
   }

   private FloatBuffer func_908_a(float p_908_1_, float p_908_2_, float p_908_3_, float p_908_4_) {
      this.field_1392_d.clear();
      this.field_1392_d.put(p_908_1_).put(p_908_2_).put(p_908_3_).put(p_908_4_);
      this.field_1392_d.flip();
      return this.field_1392_d;
   }

}
