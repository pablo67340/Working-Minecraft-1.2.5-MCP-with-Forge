package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.ChatClickData;
import net.minecraft.src.ChatLine;
import net.minecraft.src.Chunk;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.EntityDragon;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.FoodStats;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiPlayerInfo;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Potion;
import net.minecraft.src.RenderDragon;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class GuiIngame extends Gui {

   private static RenderItem field_930_d = new RenderItem();
   private List field_929_e = new ArrayList();
   private List field_50016_f = new ArrayList();
   private Random field_9423_f = new Random();
   private Minecraft field_9422_g;
   private int field_9421_h = 0;
   private String field_9420_i = "";
   private int field_9419_j = 0;
   private boolean field_22065_l = false;
   private int field_50017_n = 0;
   private boolean field_50018_o = false;
   public float field_6446_b;
   float field_931_c = 1.0F;


   public GuiIngame(Minecraft p_i149_1_) {
      this.field_9422_g = p_i149_1_;
   }

   public void func_4066_a(float p_4066_1_, boolean p_4066_2_, int p_4066_3_, int p_4066_4_) {
      ScaledResolution var5 = new ScaledResolution(this.field_9422_g.field_6304_y, this.field_9422_g.field_6326_c, this.field_9422_g.field_6325_d);
      int var6 = var5.func_903_a();
      int var7 = var5.func_902_b();
      FontRenderer var8 = this.field_9422_g.field_6314_o;
      this.field_9422_g.field_9243_r.func_905_b();
      GL11.glEnable(3042);
      if(Minecraft.func_22001_u()) {
         this.func_4064_a(this.field_9422_g.field_6322_g.func_382_a(p_4066_1_), var6, var7);
      } else {
         GL11.glBlendFunc(770, 771);
      }

      ItemStack var9 = this.field_9422_g.field_6322_g.field_778_b.func_492_d(3);
      if(this.field_9422_g.field_6304_y.field_1560_x == 0 && var9 != null && var9.field_1617_c == Block.field_4055_bb.field_376_bc) {
         this.func_4063_a(var6, var7);
      }

      if(!this.field_9422_g.field_6322_g.func_35160_a(Potion.field_35684_k)) {
         float var10 = this.field_9422_g.field_6322_g.field_28025_B + (this.field_9422_g.field_6322_g.field_28026_A - this.field_9422_g.field_6322_g.field_28025_B) * p_4066_1_;
         if(var10 > 0.0F) {
            this.func_4065_b(var10, var6, var7);
         }
      }

      boolean var11;
      int var12;
      int var13;
      int var16;
      int var17;
      int var19;
      int var20;
      int var22;
      int var23;
      int var45;
      if(!this.field_9422_g.field_6327_b.func_35643_e()) {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/gui/gui.png"));
         InventoryPlayer var31 = this.field_9422_g.field_6322_g.field_778_b;
         this.field_923_k = -90.0F;
         this.func_550_b(var6 / 2 - 91, var7 - 22, 0, 0, 182, 22);
         this.func_550_b(var6 / 2 - 91 - 1 + var31.field_847_d * 20, var7 - 22 - 1, 0, 22, 24, 22);
         GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
         GL11.glEnable(3042);
         GL11.glBlendFunc(775, 769);
         this.func_550_b(var6 / 2 - 7, var7 / 2 - 7, 0, 0, 16, 16);
         GL11.glDisable(3042);
         var11 = this.field_9422_g.field_6322_g.field_9306_bj / 3 % 2 == 1;
         if(this.field_9422_g.field_6322_g.field_9306_bj < 10) {
            var11 = false;
         }

         var12 = this.field_9422_g.field_6322_g.func_40114_aH();
         var13 = this.field_9422_g.field_6322_g.field_9335_K;
         this.field_9423_f.setSeed((long)(this.field_9421_h * 312871));
         boolean var14 = false;
         FoodStats var15 = this.field_9422_g.field_6322_g.func_35191_at();
         var16 = var15.func_35765_a();
         var17 = var15.func_35769_b();
         this.func_41039_c();
         int var18;
         if(this.field_9422_g.field_6327_b.func_6469_d()) {
            var18 = var6 / 2 - 91;
            var19 = var6 / 2 + 91;
            var20 = this.field_9422_g.field_6322_g.func_35193_as();
            if(var20 > 0) {
               short var21 = 182;
               var22 = (int)(this.field_9422_g.field_6322_g.field_35211_aX * (float)(var21 + 1));
               var23 = var7 - 32 + 3;
               this.func_550_b(var18, var23, 0, 64, var21, 5);
               if(var22 > 0) {
                  this.func_550_b(var18, var23, 0, 69, var22, 5);
               }
            }

            var45 = var7 - 39;
            var22 = var45 - 10;
            var23 = this.field_9422_g.field_6322_g.func_40119_ar();
            int var24 = -1;
            if(this.field_9422_g.field_6322_g.func_35160_a(Potion.field_35681_l)) {
               var24 = this.field_9421_h % 25;
            }

            int var25;
            int var26;
            int var28;
            int var29;
            for(var25 = 0; var25 < 10; ++var25) {
               if(var23 > 0) {
                  var26 = var18 + var25 * 8;
                  if(var25 * 2 + 1 < var23) {
                     this.func_550_b(var26, var22, 34, 9, 9, 9);
                  }

                  if(var25 * 2 + 1 == var23) {
                     this.func_550_b(var26, var22, 25, 9, 9, 9);
                  }

                  if(var25 * 2 + 1 > var23) {
                     this.func_550_b(var26, var22, 16, 9, 9, 9);
                  }
               }

               var26 = 16;
               if(this.field_9422_g.field_6322_g.func_35160_a(Potion.field_35689_u)) {
                  var26 += 36;
               }

               byte var27 = 0;
               if(var11) {
                  var27 = 1;
               }

               var28 = var18 + var25 * 8;
               var29 = var45;
               if(var12 <= 4) {
                  var29 = var45 + this.field_9423_f.nextInt(2);
               }

               if(var25 == var24) {
                  var29 -= 2;
               }

               byte var30 = 0;
               if(this.field_9422_g.field_6324_e.func_22144_v().func_40724_s()) {
                  var30 = 5;
               }

               this.func_550_b(var28, var29, 16 + var27 * 9, 9 * var30, 9, 9);
               if(var11) {
                  if(var25 * 2 + 1 < var13) {
                     this.func_550_b(var28, var29, var26 + 54, 9 * var30, 9, 9);
                  }

                  if(var25 * 2 + 1 == var13) {
                     this.func_550_b(var28, var29, var26 + 63, 9 * var30, 9, 9);
                  }
               }

               if(var25 * 2 + 1 < var12) {
                  this.func_550_b(var28, var29, var26 + 36, 9 * var30, 9, 9);
               }

               if(var25 * 2 + 1 == var12) {
                  this.func_550_b(var28, var29, var26 + 45, 9 * var30, 9, 9);
               }
            }

            int var51;
            for(var25 = 0; var25 < 10; ++var25) {
               var26 = var45;
               var51 = 16;
               byte var52 = 0;
               if(this.field_9422_g.field_6322_g.func_35160_a(Potion.field_35691_s)) {
                  var51 += 36;
                  var52 = 13;
               }

               if(this.field_9422_g.field_6322_g.func_35191_at().func_35760_d() <= 0.0F && this.field_9421_h % (var16 * 3 + 1) == 0) {
                  var26 = var45 + (this.field_9423_f.nextInt(3) - 1);
               }

               if(var14) {
                  var52 = 1;
               }

               var29 = var19 - var25 * 8 - 9;
               this.func_550_b(var29, var26, 16 + var52 * 9, 27, 9, 9);
               if(var14) {
                  if(var25 * 2 + 1 < var17) {
                     this.func_550_b(var29, var26, var51 + 54, 27, 9, 9);
                  }

                  if(var25 * 2 + 1 == var17) {
                     this.func_550_b(var29, var26, var51 + 63, 27, 9, 9);
                  }
               }

               if(var25 * 2 + 1 < var16) {
                  this.func_550_b(var29, var26, var51 + 36, 27, 9, 9);
               }

               if(var25 * 2 + 1 == var16) {
                  this.func_550_b(var29, var26, var51 + 45, 27, 9, 9);
               }
            }

            if(this.field_9422_g.field_6322_g.func_393_a(Material.field_1332_f)) {
               var25 = this.field_9422_g.field_6322_g.func_41001_Z();
               var26 = (int)Math.ceil((double)(var25 - 2) * 10.0D / 300.0D);
               var51 = (int)Math.ceil((double)var25 * 10.0D / 300.0D) - var26;

               for(var28 = 0; var28 < var26 + var51; ++var28) {
                  if(var28 < var26) {
                     this.func_550_b(var19 - var28 * 8 - 9, var22, 16, 18, 9, 9);
                  } else {
                     this.func_550_b(var19 - var28 * 8 - 9, var22, 25, 18, 9, 9);
                  }
               }
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable('\u803a');
         RenderHelper.func_41089_c();

         for(var18 = 0; var18 < 9; ++var18) {
            var19 = var6 / 2 - 90 + var18 * 20 + 2;
            var20 = var7 - 16 - 3;
            this.func_554_a(var18, var19, var20, p_4066_1_);
         }

         RenderHelper.func_1159_a();
         GL11.glDisable('\u803a');
      }

      float var33;
      if(this.field_9422_g.field_6322_g.func_22060_M() > 0) {
         GL11.glDisable(2929);
         GL11.glDisable(3008);
         int var32 = this.field_9422_g.field_6322_g.func_22060_M();
         var33 = (float)var32 / 100.0F;
         if(var33 > 1.0F) {
            var33 = 1.0F - (float)(var32 - 100) / 10.0F;
         }

         var12 = (int)(220.0F * var33) << 24 | 1052704;
         func_551_a(0, 0, var6, var7, var12);
         GL11.glEnable(3008);
         GL11.glEnable(2929);
      }

      int var39;
      int var40;
      if(this.field_9422_g.field_6327_b.func_35642_f() && this.field_9422_g.field_6322_g.field_35210_aY > 0) {
         var11 = false;
         var12 = var11?16777215:8453920;
         String var34 = "" + this.field_9422_g.field_6322_g.field_35210_aY;
         var39 = (var6 - var8.func_871_a(var34)) / 2;
         var40 = var7 - 31 - 4;
         var8.func_873_b(var34, var39 + 1, var40, 0);
         var8.func_873_b(var34, var39 - 1, var40, 0);
         var8.func_873_b(var34, var39, var40 + 1, 0);
         var8.func_873_b(var34, var39, var40 - 1, 0);
         var8.func_873_b(var34, var39, var40, var12);
      }

      if(this.field_9422_g.field_6304_y.field_22276_A) {
         GL11.glPushMatrix();
         if(Minecraft.field_28005_H > 0L) {
            GL11.glTranslatef(0.0F, 32.0F, 0.0F);
         }

         var8.func_50103_a("Minecraft 1.2.5 (" + this.field_9422_g.field_6292_I + ")", 2, 2, 16777215);
         var8.func_50103_a(this.field_9422_g.func_6241_m(), 2, 12, 16777215);
         var8.func_50103_a(this.field_9422_g.func_6262_n(), 2, 22, 16777215);
         var8.func_50103_a(this.field_9422_g.func_6245_o(), 2, 32, 16777215);
         var8.func_50103_a(this.field_9422_g.func_21002_o(), 2, 42, 16777215);
         long var35 = Runtime.getRuntime().maxMemory();
         long var36 = Runtime.getRuntime().totalMemory();
         long var41 = Runtime.getRuntime().freeMemory();
         long var42 = var36 - var41;
         String var44 = "Used memory: " + var42 * 100L / var35 + "% (" + var42 / 1024L / 1024L + "MB) of " + var35 / 1024L / 1024L + "MB";
         this.func_547_b(var8, var44, var6 - var8.func_871_a(var44) - 2, 2, 14737632);
         var44 = "Allocated memory: " + var36 * 100L / var35 + "% (" + var36 / 1024L / 1024L + "MB)";
         this.func_547_b(var8, var44, var6 - var8.func_871_a(var44) - 2, 12, 14737632);
         this.func_547_b(var8, "x: " + this.field_9422_g.field_6322_g.field_611_ak, 2, 64, 14737632);
         this.func_547_b(var8, "y: " + this.field_9422_g.field_6322_g.field_610_al, 2, 72, 14737632);
         this.func_547_b(var8, "z: " + this.field_9422_g.field_6322_g.field_609_am, 2, 80, 14737632);
         this.func_547_b(var8, "f: " + (MathHelper.func_1108_b((double)(this.field_9422_g.field_6322_g.field_605_aq * 4.0F / 360.0F) + 0.5D) & 3), 2, 88, 14737632);
         var45 = MathHelper.func_1108_b(this.field_9422_g.field_6322_g.field_611_ak);
         var22 = MathHelper.func_1108_b(this.field_9422_g.field_6322_g.field_610_al);
         var23 = MathHelper.func_1108_b(this.field_9422_g.field_6322_g.field_609_am);
         if(this.field_9422_g.field_6324_e != null && this.field_9422_g.field_6324_e.func_630_d(var45, var22, var23)) {
            Chunk var48 = this.field_9422_g.field_6324_e.func_673_a(var45, var23);
            this.func_547_b(var8, "lc: " + (var48.func_48498_h() + 15) + " b: " + var48.func_48490_a(var45 & 15, var23 & 15, this.field_9422_g.field_6324_e.func_4075_a()).field_6504_m + " bl: " + var48.func_1025_a(EnumSkyBlock.Block, var45 & 15, var22, var23 & 15) + " sl: " + var48.func_1025_a(EnumSkyBlock.Sky, var45 & 15, var22, var23 & 15) + " rl: " + var48.func_1019_c(var45 & 15, var22, var23 & 15, 0), 2, 96, 14737632);
         }

         if(!this.field_9422_g.field_6324_e.field_1026_y) {
            this.func_547_b(var8, "Seed: " + this.field_9422_g.field_6324_e.func_22138_q(), 2, 112, 14737632);
         }

         GL11.glPopMatrix();
      }

      if(this.field_9419_j > 0) {
         var33 = (float)this.field_9419_j - p_4066_1_;
         var12 = (int)(var33 * 256.0F / 20.0F);
         if(var12 > 255) {
            var12 = 255;
         }

         if(var12 > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(var6 / 2), (float)(var7 - 48), 0.0F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            var13 = 16777215;
            if(this.field_22065_l) {
               var13 = Color.HSBtoRGB(var33 / 50.0F, 0.7F, 0.6F) & 16777215;
            }

            var8.func_873_b(this.field_9420_i, -var8.func_871_a(this.field_9420_i) / 2, -4, var13 + (var12 << 24));
            GL11.glDisable(3042);
            GL11.glPopMatrix();
         }
      }

      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, (float)(var7 - 48), 0.0F);
      this.func_50010_a(var8);
      GL11.glPopMatrix();
      if(this.field_9422_g.field_6322_g instanceof EntityClientPlayerMP && this.field_9422_g.field_6304_y.field_35384_x.field_35965_e) {
         NetClientHandler var37 = ((EntityClientPlayerMP)this.field_9422_g.field_6322_g).field_797_bg;
         List var38 = var37.field_35786_c;
         var13 = var37.field_35785_d;
         var39 = var13;

         for(var40 = 1; var39 > 20; var39 = (var13 + var40 - 1) / var40) {
            ++var40;
         }

         var16 = 300 / var40;
         if(var16 > 150) {
            var16 = 150;
         }

         var17 = (var6 - var40 * var16) / 2;
         byte var43 = 10;
         func_551_a(var17 - 1, var43 - 1, var17 + var16 * var40, var43 + 9 * var39, Integer.MIN_VALUE);

         for(var19 = 0; var19 < var13; ++var19) {
            var20 = var17 + var19 % var40 * var16;
            var45 = var43 + var19 / var40 * 9;
            func_551_a(var20, var45, var20 + var16 - 1, var45 + 8, 553648127);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3008);
            if(var19 < var38.size()) {
               GuiPlayerInfo var46 = (GuiPlayerInfo)var38.get(var19);
               var8.func_50103_a(var46.field_35624_a, var20, var45, 16777215);
               this.field_9422_g.field_6315_n.func_1076_b(this.field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
               byte var47 = 0;
               boolean var49 = false;
               byte var50;
               if(var46.field_35623_b < 0) {
                  var50 = 5;
               } else if(var46.field_35623_b < 150) {
                  var50 = 0;
               } else if(var46.field_35623_b < 300) {
                  var50 = 1;
               } else if(var46.field_35623_b < 600) {
                  var50 = 2;
               } else if(var46.field_35623_b < 1000) {
                  var50 = 3;
               } else {
                  var50 = 4;
               }

               this.field_923_k += 100.0F;
               this.func_550_b(var20 + var16 - 12, var45, 0 + var47 * 10, 176 + var50 * 8, 10, 8);
               this.field_923_k -= 100.0F;
            }
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2896);
      GL11.glEnable(3008);
   }

   private void func_50010_a(FontRenderer p_50010_1_) {
      byte var2 = 10;
      boolean var3 = false;
      int var4 = 0;
      int var5 = this.field_929_e.size();
      if(var5 > 0) {
         if(this.func_50015_e()) {
            var2 = 20;
            var3 = true;
         }

         int var6;
         int var10;
         for(var6 = 0; var6 + this.field_50017_n < this.field_929_e.size() && var6 < var2; ++var6) {
            if(((ChatLine)this.field_929_e.get(var6)).field_1296_b < 200 || var3) {
               ChatLine var7 = (ChatLine)this.field_929_e.get(var6 + this.field_50017_n);
               double var8 = (double)var7.field_1296_b / 200.0D;
               var8 = 1.0D - var8;
               var8 *= 10.0D;
               if(var8 < 0.0D) {
                  var8 = 0.0D;
               }

               if(var8 > 1.0D) {
                  var8 = 1.0D;
               }

               var8 *= var8;
               var10 = (int)(255.0D * var8);
               if(var3) {
                  var10 = 255;
               }

               ++var4;
               if(var10 > 2) {
                  byte var11 = 3;
                  int var12 = -var6 * 9;
                  String var13 = var7.field_1297_a;
                  func_551_a(var11, var12 - 1, var11 + 320 + 4, var12 + 8, var10 / 2 << 24);
                  GL11.glEnable(3042);
                  p_50010_1_.func_50103_a(var13, var11, var12, 16777215 + (var10 << 24));
               }
            }
         }

         if(var3) {
            GL11.glTranslatef(0.0F, (float)p_50010_1_.field_41063_b, 0.0F);
            var6 = var5 * p_50010_1_.field_41063_b + var5;
            int var14 = var4 * p_50010_1_.field_41063_b + var4;
            int var15 = this.field_50017_n * var14 / var5;
            int var9 = var14 * var14 / var6;
            if(var6 != var14) {
               var10 = var15 > 0?170:96;
               int var16 = this.field_50018_o?13382451:3355562;
               func_551_a(0, -var15, 2, -var15 - var9, var16 + (var10 << 24));
               func_551_a(2, -var15, 1, -var15 - var9, 13421772 + (var10 << 24));
            }
         }

      }
   }

   private void func_41039_c() {
      if(RenderDragon.field_41038_a != null) {
         EntityDragon var1 = RenderDragon.field_41038_a;
         RenderDragon.field_41038_a = null;
         FontRenderer var2 = this.field_9422_g.field_6314_o;
         ScaledResolution var3 = new ScaledResolution(this.field_9422_g.field_6304_y, this.field_9422_g.field_6326_c, this.field_9422_g.field_6325_d);
         int var4 = var3.func_903_a();
         short var5 = 182;
         int var6 = var4 / 2 - var5 / 2;
         int var7 = (int)((float)var1.func_41010_ax() / (float)var1.func_40117_c() * (float)(var5 + 1));
         byte var8 = 12;
         this.func_550_b(var6, var8, 0, 74, var5, 5);
         this.func_550_b(var6, var8, 0, 74, var5, 5);
         if(var7 > 0) {
            this.func_550_b(var6, var8, 0, 79, var7, 5);
         }

         String var9 = "Boss health";
         var2.func_50103_a(var9, var4 / 2 - var2.func_871_a(var9) / 2, var8 - 10, 16711935);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/gui/icons.png"));
      }
   }

   private void func_4063_a(int p_4063_1_, int p_4063_2_) {
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("%blur%/misc/pumpkinblur.png"));
      Tessellator var3 = Tessellator.field_1512_a;
      var3.func_977_b();
      var3.func_983_a(0.0D, (double)p_4063_2_, -90.0D, 0.0D, 1.0D);
      var3.func_983_a((double)p_4063_1_, (double)p_4063_2_, -90.0D, 1.0D, 1.0D);
      var3.func_983_a((double)p_4063_1_, 0.0D, -90.0D, 1.0D, 0.0D);
      var3.func_983_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var3.func_982_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_4064_a(float p_4064_1_, int p_4064_2_, int p_4064_3_) {
      p_4064_1_ = 1.0F - p_4064_1_;
      if(p_4064_1_ < 0.0F) {
         p_4064_1_ = 0.0F;
      }

      if(p_4064_1_ > 1.0F) {
         p_4064_1_ = 1.0F;
      }

      this.field_931_c = (float)((double)this.field_931_c + (double)(p_4064_1_ - this.field_931_c) * 0.01D);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(0, 769);
      GL11.glColor4f(this.field_931_c, this.field_931_c, this.field_931_c, 1.0F);
      GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("%blur%/misc/vignette.png"));
      Tessellator var4 = Tessellator.field_1512_a;
      var4.func_977_b();
      var4.func_983_a(0.0D, (double)p_4064_3_, -90.0D, 0.0D, 1.0D);
      var4.func_983_a((double)p_4064_2_, (double)p_4064_3_, -90.0D, 1.0D, 1.0D);
      var4.func_983_a((double)p_4064_2_, 0.0D, -90.0D, 1.0D, 0.0D);
      var4.func_983_a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var4.func_982_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glBlendFunc(770, 771);
   }

   private void func_4065_b(float p_4065_1_, int p_4065_2_, int p_4065_3_) {
      if(p_4065_1_ < 1.0F) {
         p_4065_1_ *= p_4065_1_;
         p_4065_1_ *= p_4065_1_;
         p_4065_1_ = p_4065_1_ * 0.8F + 0.2F;
      }

      GL11.glDisable(3008);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, p_4065_1_);
      GL11.glBindTexture(3553, this.field_9422_g.field_6315_n.func_1070_a("/terrain.png"));
      float var4 = (float)(Block.field_4047_bf.field_378_bb % 16) / 16.0F;
      float var5 = (float)(Block.field_4047_bf.field_378_bb / 16) / 16.0F;
      float var6 = (float)(Block.field_4047_bf.field_378_bb % 16 + 1) / 16.0F;
      float var7 = (float)(Block.field_4047_bf.field_378_bb / 16 + 1) / 16.0F;
      Tessellator var8 = Tessellator.field_1512_a;
      var8.func_977_b();
      var8.func_983_a(0.0D, (double)p_4065_3_, -90.0D, (double)var4, (double)var7);
      var8.func_983_a((double)p_4065_2_, (double)p_4065_3_, -90.0D, (double)var6, (double)var7);
      var8.func_983_a((double)p_4065_2_, 0.0D, -90.0D, (double)var6, (double)var5);
      var8.func_983_a(0.0D, 0.0D, -90.0D, (double)var4, (double)var5);
      var8.func_982_a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void func_554_a(int p_554_1_, int p_554_2_, int p_554_3_, float p_554_4_) {
      ItemStack var5 = this.field_9422_g.field_6322_g.field_778_b.field_843_a[p_554_1_];
      if(var5 != null) {
         float var6 = (float)var5.field_1614_b - p_554_4_;
         if(var6 > 0.0F) {
            GL11.glPushMatrix();
            float var7 = 1.0F + var6 / 5.0F;
            GL11.glTranslatef((float)(p_554_2_ + 8), (float)(p_554_3_ + 12), 0.0F);
            GL11.glScalef(1.0F / var7, (var7 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef((float)(-(p_554_2_ + 8)), (float)(-(p_554_3_ + 12)), 0.0F);
         }

         field_930_d.func_161_a(this.field_9422_g.field_6314_o, this.field_9422_g.field_6315_n, var5, p_554_2_, p_554_3_);
         if(var6 > 0.0F) {
            GL11.glPopMatrix();
         }

         field_930_d.func_164_b(this.field_9422_g.field_6314_o, this.field_9422_g.field_6315_n, var5, p_554_2_, p_554_3_);
      }
   }

   public void func_555_a() {
      if(this.field_9419_j > 0) {
         --this.field_9419_j;
      }

      ++this.field_9421_h;

      for(int var1 = 0; var1 < this.field_929_e.size(); ++var1) {
         ++((ChatLine)this.field_929_e.get(var1)).field_1296_b;
      }

   }

   public void func_28097_b() {
      this.field_929_e.clear();
      this.field_50016_f.clear();
   }

   public void func_552_a(String p_552_1_) {
      boolean var2 = this.func_50015_e();
      boolean var3 = true;
      Iterator var4 = this.field_9422_g.field_6314_o.func_50108_c(p_552_1_, 320).iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         if(var2 && this.field_50017_n > 0) {
            this.field_50018_o = true;
            this.func_50011_a(1);
         }

         if(!var3) {
            var5 = " " + var5;
         }

         var3 = false;
         this.field_929_e.add(0, new ChatLine(var5));
      }

      while(this.field_929_e.size() > 100) {
         this.field_929_e.remove(this.field_929_e.size() - 1);
      }

   }

   public List func_50013_c() {
      return this.field_50016_f;
   }

   public void func_50014_d() {
      this.field_50017_n = 0;
      this.field_50018_o = false;
   }

   public void func_50011_a(int p_50011_1_) {
      this.field_50017_n += p_50011_1_;
      int var2 = this.field_929_e.size();
      if(this.field_50017_n > var2 - 20) {
         this.field_50017_n = var2 - 20;
      }

      if(this.field_50017_n <= 0) {
         this.field_50017_n = 0;
         this.field_50018_o = false;
      }

   }

   public ChatClickData func_50012_a(int p_50012_1_, int p_50012_2_) {
      if(!this.func_50015_e()) {
         return null;
      } else {
         ScaledResolution var3 = new ScaledResolution(this.field_9422_g.field_6304_y, this.field_9422_g.field_6326_c, this.field_9422_g.field_6325_d);
         p_50012_2_ = p_50012_2_ / var3.field_1368_a - 40;
         p_50012_1_ = p_50012_1_ / var3.field_1368_a - 3;
         if(p_50012_1_ >= 0 && p_50012_2_ >= 0) {
            int var4 = Math.min(20, this.field_929_e.size());
            if(p_50012_1_ <= 320 && p_50012_2_ < this.field_9422_g.field_6314_o.field_41063_b * var4 + var4) {
               int var5 = p_50012_2_ / (this.field_9422_g.field_6314_o.field_41063_b + 1) + this.field_50017_n;
               return new ChatClickData(this.field_9422_g.field_6314_o, (ChatLine)this.field_929_e.get(var5), p_50012_1_, p_50012_2_ - (var5 - this.field_50017_n) * this.field_9422_g.field_6314_o.field_41063_b + var5);
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   public void func_553_b(String p_553_1_) {
      this.field_9420_i = "Now playing: " + p_553_1_;
      this.field_9419_j = 60;
      this.field_22065_l = true;
   }

   public boolean func_50015_e() {
      return this.field_9422_g.field_6313_p instanceof GuiChat;
   }

   public void func_22064_c(String p_22064_1_) {
      StringTranslate var2 = StringTranslate.func_20162_a();
      String var3 = var2.func_20163_a(p_22064_1_);
      this.func_552_a(var3);
   }

}
