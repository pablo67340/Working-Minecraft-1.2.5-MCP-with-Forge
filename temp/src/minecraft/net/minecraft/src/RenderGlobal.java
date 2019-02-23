package net.minecraft.src;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAuraFX;
import net.minecraft.src.EntityBreakingFX;
import net.minecraft.src.EntityBubbleFX;
import net.minecraft.src.EntityCloudFX;
import net.minecraft.src.EntityCritFX;
import net.minecraft.src.EntityDiggingFX;
import net.minecraft.src.EntityDropParticleFX;
import net.minecraft.src.EntityEnchantmentTableParticleFX;
import net.minecraft.src.EntityExplodeFX;
import net.minecraft.src.EntityFX;
import net.minecraft.src.EntityFlameFX;
import net.minecraft.src.EntityFootStepFX;
import net.minecraft.src.EntityHeartFX;
import net.minecraft.src.EntityHugeExplodeFX;
import net.minecraft.src.EntityLargeExplodeFX;
import net.minecraft.src.EntityLavaFX;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityNoteFX;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPortalFX;
import net.minecraft.src.EntityReddustFX;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EntitySmokeFX;
import net.minecraft.src.EntitySnowShovelFX;
import net.minecraft.src.EntitySorter;
import net.minecraft.src.EntitySpellParticleFX;
import net.minecraft.src.EntitySplashFX;
import net.minecraft.src.EntitySuspendFX;
import net.minecraft.src.EnumMovingObjectType;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.ICamera;
import net.minecraft.src.IWorldAccess;
import net.minecraft.src.ImageBufferDownload;
import net.minecraft.src.Item;
import net.minecraft.src.ItemRecord;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.OpenGlCapsChecker;
import net.minecraft.src.Profiler;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderList;
import net.minecraft.src.RenderManager;
import net.minecraft.src.RenderSorter;
import net.minecraft.src.Tessellator;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import net.minecraft.src.WorldRenderer;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class RenderGlobal implements IWorldAccess {

   public List field_1458_a = new ArrayList();
   private World field_1448_k;
   private RenderEngine field_1447_l;
   private List field_1446_m = new ArrayList();
   private WorldRenderer[] field_1445_n;
   private WorldRenderer[] field_1444_o;
   private int field_1443_p;
   private int field_1442_q;
   private int field_1441_r;
   private int field_1440_s;
   private Minecraft field_1439_t;
   private RenderBlocks field_1438_u;
   private IntBuffer field_1437_v;
   private boolean field_1436_w = false;
   private int field_1435_x = 0;
   private int field_1434_y;
   private int field_1433_z;
   private int field_1432_A;
   private int field_1431_B;
   private int field_1430_C;
   private int field_1429_D;
   private int field_1428_E;
   private int field_1427_F;
   private int field_1426_G;
   private int field_1425_H = -1;
   private int field_1424_I = 2;
   private int field_1423_J;
   private int field_1422_K;
   private int field_1421_L;
   int[] field_1457_b = new int['\uc350'];
   IntBuffer field_1456_c = GLAllocation.func_1125_c(64);
   private int field_1420_M;
   private int field_1419_N;
   private int field_1418_O;
   private int field_1417_P;
   private int field_1416_Q;
   private int field_40194_P;
   private int field_21156_R;
   private List field_1415_R = new ArrayList();
   private RenderList[] field_1414_S = new RenderList[]{new RenderList(), new RenderList(), new RenderList(), new RenderList()};
   double field_1453_f = -9999.0D;
   double field_1452_g = -9999.0D;
   double field_1451_h = -9999.0D;
   public float field_1450_i;
   int field_1449_j = 0;


   public RenderGlobal(Minecraft p_i437_1_, RenderEngine p_i437_2_) {
      this.field_1439_t = p_i437_1_;
      this.field_1447_l = p_i437_2_;
      byte var3 = 34;
      byte var4 = 32;
      this.field_1440_s = GLAllocation.func_1124_a(var3 * var3 * var4 * 3);
      this.field_1436_w = OpenGlCapsChecker.func_1213_a();
      if(this.field_1436_w) {
         this.field_1456_c.clear();
         this.field_1437_v = GLAllocation.func_1125_c(var3 * var3 * var4);
         this.field_1437_v.clear();
         this.field_1437_v.position(0);
         this.field_1437_v.limit(var3 * var3 * var4);
         ARBOcclusionQuery.glGenQueriesARB(this.field_1437_v);
      }

      this.field_1434_y = GLAllocation.func_1124_a(3);
      GL11.glPushMatrix();
      GL11.glNewList(this.field_1434_y, 4864);
      this.func_950_f();
      GL11.glEndList();
      GL11.glPopMatrix();
      Tessellator var5 = Tessellator.field_1512_a;
      this.field_1433_z = this.field_1434_y + 1;
      GL11.glNewList(this.field_1433_z, 4864);
      byte var7 = 64;
      int var8 = 256 / var7 + 2;
      float var6 = 16.0F;

      int var9;
      int var10;
      for(var9 = -var7 * var8; var9 <= var7 * var8; var9 += var7) {
         for(var10 = -var7 * var8; var10 <= var7 * var8; var10 += var7) {
            var5.func_977_b();
            var5.func_991_a((double)(var9 + 0), (double)var6, (double)(var10 + 0));
            var5.func_991_a((double)(var9 + var7), (double)var6, (double)(var10 + 0));
            var5.func_991_a((double)(var9 + var7), (double)var6, (double)(var10 + var7));
            var5.func_991_a((double)(var9 + 0), (double)var6, (double)(var10 + var7));
            var5.func_982_a();
         }
      }

      GL11.glEndList();
      this.field_1432_A = this.field_1434_y + 2;
      GL11.glNewList(this.field_1432_A, 4864);
      var6 = -16.0F;
      var5.func_977_b();

      for(var9 = -var7 * var8; var9 <= var7 * var8; var9 += var7) {
         for(var10 = -var7 * var8; var10 <= var7 * var8; var10 += var7) {
            var5.func_991_a((double)(var9 + var7), (double)var6, (double)(var10 + 0));
            var5.func_991_a((double)(var9 + 0), (double)var6, (double)(var10 + 0));
            var5.func_991_a((double)(var9 + 0), (double)var6, (double)(var10 + var7));
            var5.func_991_a((double)(var9 + var7), (double)var6, (double)(var10 + var7));
         }
      }

      var5.func_982_a();
      GL11.glEndList();
   }

   private void func_950_f() {
      Random var1 = new Random(10842L);
      Tessellator var2 = Tessellator.field_1512_a;
      var2.func_977_b();

      for(int var3 = 0; var3 < 1500; ++var3) {
         double var4 = (double)(var1.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(var1.nextFloat() * 2.0F - 1.0F);
         double var8 = (double)(var1.nextFloat() * 2.0F - 1.0F);
         double var10 = (double)(0.25F + var1.nextFloat() * 0.25F);
         double var12 = var4 * var4 + var6 * var6 + var8 * var8;
         if(var12 < 1.0D && var12 > 0.01D) {
            var12 = 1.0D / Math.sqrt(var12);
            var4 *= var12;
            var6 *= var12;
            var8 *= var12;
            double var14 = var4 * 100.0D;
            double var16 = var6 * 100.0D;
            double var18 = var8 * 100.0D;
            double var20 = Math.atan2(var4, var8);
            double var22 = Math.sin(var20);
            double var24 = Math.cos(var20);
            double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
            double var28 = Math.sin(var26);
            double var30 = Math.cos(var26);
            double var32 = var1.nextDouble() * 3.141592653589793D * 2.0D;
            double var34 = Math.sin(var32);
            double var36 = Math.cos(var32);

            for(int var38 = 0; var38 < 4; ++var38) {
               double var39 = 0.0D;
               double var41 = (double)((var38 & 2) - 1) * var10;
               double var43 = (double)((var38 + 1 & 2) - 1) * var10;
               double var47 = var41 * var36 - var43 * var34;
               double var49 = var43 * var36 + var41 * var34;
               double var53 = var47 * var28 + var39 * var30;
               double var55 = var39 * var28 - var47 * var30;
               double var57 = var55 * var22 - var49 * var24;
               double var61 = var49 * var22 + var55 * var24;
               var2.func_991_a(var14 + var57, var16 + var53, var18 + var61);
            }
         }
      }

      var2.func_982_a();
   }

   public void func_946_a(World p_946_1_) {
      if(this.field_1448_k != null) {
         this.field_1448_k.func_672_b(this);
      }

      this.field_1453_f = -9999.0D;
      this.field_1452_g = -9999.0D;
      this.field_1451_h = -9999.0D;
      RenderManager.field_1233_a.func_852_a(p_946_1_);
      this.field_1448_k = p_946_1_;
      this.field_1438_u = new RenderBlocks(p_946_1_);
      if(p_946_1_ != null) {
         p_946_1_.func_613_a(this);
         this.func_958_a();
      }

   }

   public void func_958_a() {
      if(this.field_1448_k != null) {
         Block.field_384_L.func_310_a(this.field_1439_t.field_6304_y.field_1576_i);
         this.field_1425_H = this.field_1439_t.field_6304_y.field_1580_e;
         int var1;
         if(this.field_1444_o != null) {
            for(var1 = 0; var1 < this.field_1444_o.length; ++var1) {
               this.field_1444_o[var1].func_1204_c();
            }
         }

         var1 = 64 << 3 - this.field_1425_H;
         if(var1 > 400) {
            var1 = 400;
         }

         this.field_1443_p = var1 / 16 + 1;
         this.field_1442_q = 16;
         this.field_1441_r = var1 / 16 + 1;
         this.field_1444_o = new WorldRenderer[this.field_1443_p * this.field_1442_q * this.field_1441_r];
         this.field_1445_n = new WorldRenderer[this.field_1443_p * this.field_1442_q * this.field_1441_r];
         int var2 = 0;
         int var3 = 0;
         this.field_1431_B = 0;
         this.field_1430_C = 0;
         this.field_1429_D = 0;
         this.field_1428_E = this.field_1443_p;
         this.field_1427_F = this.field_1442_q;
         this.field_1426_G = this.field_1441_r;

         int var4;
         for(var4 = 0; var4 < this.field_1446_m.size(); ++var4) {
            ((WorldRenderer)this.field_1446_m.get(var4)).field_1738_u = false;
         }

         this.field_1446_m.clear();
         this.field_1458_a.clear();

         for(var4 = 0; var4 < this.field_1443_p; ++var4) {
            for(int var5 = 0; var5 < this.field_1442_q; ++var5) {
               for(int var6 = 0; var6 < this.field_1441_r; ++var6) {
                  this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4] = new WorldRenderer(this.field_1448_k, this.field_1458_a, var4 * 16, var5 * 16, var6 * 16, this.field_1440_s + var2);
                  if(this.field_1436_w) {
                     this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1732_z = this.field_1437_v.get(var3);
                  }

                  this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1733_y = false;
                  this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1734_x = true;
                  this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1749_o = true;
                  this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].field_1735_w = var3++;
                  this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4].func_1194_f();
                  this.field_1445_n[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4] = this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4];
                  this.field_1446_m.add(this.field_1444_o[(var6 * this.field_1442_q + var5) * this.field_1443_p + var4]);
                  var2 += 3;
               }
            }
         }

         if(this.field_1448_k != null) {
            EntityLiving var7 = this.field_1439_t.field_22009_h;
            if(var7 != null) {
               this.func_956_b(MathHelper.func_1108_b(var7.field_611_ak), MathHelper.func_1108_b(var7.field_610_al), MathHelper.func_1108_b(var7.field_609_am));
               Arrays.sort(this.field_1445_n, new EntitySorter(var7));
            }
         }

         this.field_1424_I = 2;
      }
   }

   public void func_951_a(Vec3D p_951_1_, ICamera p_951_2_, float p_951_3_) {
      if(this.field_1424_I > 0) {
         --this.field_1424_I;
      } else {
         Profiler.func_40663_a("prepare");
         TileEntityRenderer.field_1554_a.func_22267_a(this.field_1448_k, this.field_1447_l, this.field_1439_t.field_6314_o, this.field_1439_t.field_22009_h, p_951_3_);
         RenderManager.field_1233_a.func_22187_a(this.field_1448_k, this.field_1447_l, this.field_1439_t.field_6314_o, this.field_1439_t.field_22009_h, this.field_1439_t.field_6304_y, p_951_3_);
         TileEntityRenderer.field_1554_a.func_40742_a();
         this.field_1423_J = 0;
         this.field_1422_K = 0;
         this.field_1421_L = 0;
         EntityLiving var4 = this.field_1439_t.field_22009_h;
         RenderManager.field_1232_b = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)p_951_3_;
         RenderManager.field_1231_c = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)p_951_3_;
         RenderManager.field_1230_d = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)p_951_3_;
         TileEntityRenderer.field_1553_b = var4.field_638_aI + (var4.field_611_ak - var4.field_638_aI) * (double)p_951_3_;
         TileEntityRenderer.field_1552_c = var4.field_637_aJ + (var4.field_610_al - var4.field_637_aJ) * (double)p_951_3_;
         TileEntityRenderer.field_1551_d = var4.field_636_aK + (var4.field_609_am - var4.field_636_aK) * (double)p_951_3_;
         this.field_1439_t.field_9243_r.func_35806_b((double)p_951_3_);
         Profiler.func_40661_c("global");
         List var5 = this.field_1448_k.func_658_i();
         this.field_1423_J = var5.size();

         int var6;
         Entity var7;
         for(var6 = 0; var6 < this.field_1448_k.field_27173_e.size(); ++var6) {
            var7 = (Entity)this.field_1448_k.field_27173_e.get(var6);
            ++this.field_1422_K;
            if(var7.func_390_a(p_951_1_)) {
               RenderManager.field_1233_a.func_854_a(var7, p_951_3_);
            }
         }

         Profiler.func_40661_c("entities");

         for(var6 = 0; var6 < var5.size(); ++var6) {
            var7 = (Entity)var5.get(var6);
            if(var7.func_390_a(p_951_1_) && (var7.field_28016_bK || p_951_2_.func_342_a(var7.field_601_au)) && (var7 != this.field_1439_t.field_22009_h || this.field_1439_t.field_6304_y.field_1560_x != 0 || this.field_1439_t.field_22009_h.func_22051_K()) && this.field_1448_k.func_630_d(MathHelper.func_1108_b(var7.field_611_ak), 0, MathHelper.func_1108_b(var7.field_609_am))) {
               ++this.field_1422_K;
               RenderManager.field_1233_a.func_854_a(var7, p_951_3_);
            }
         }

         Profiler.func_40661_c("tileentities");
         RenderHelper.func_1158_b();

         for(var6 = 0; var6 < this.field_1458_a.size(); ++var6) {
            TileEntityRenderer.field_1554_a.func_1030_a((TileEntity)this.field_1458_a.get(var6), p_951_3_);
         }

         this.field_1439_t.field_9243_r.func_35810_a((double)p_951_3_);
         Profiler.func_40662_b();
      }
   }

   public String func_953_b() {
      return "C: " + this.field_1417_P + "/" + this.field_1420_M + ". F: " + this.field_1419_N + ", O: " + this.field_1418_O + ", E: " + this.field_1416_Q;
   }

   public String func_957_c() {
      return "E: " + this.field_1422_K + "/" + this.field_1423_J + ". B: " + this.field_1421_L + ", I: " + (this.field_1423_J - this.field_1421_L - this.field_1422_K);
   }

   private void func_956_b(int p_956_1_, int p_956_2_, int p_956_3_) {
      p_956_1_ -= 8;
      p_956_2_ -= 8;
      p_956_3_ -= 8;
      this.field_1431_B = Integer.MAX_VALUE;
      this.field_1430_C = Integer.MAX_VALUE;
      this.field_1429_D = Integer.MAX_VALUE;
      this.field_1428_E = Integer.MIN_VALUE;
      this.field_1427_F = Integer.MIN_VALUE;
      this.field_1426_G = Integer.MIN_VALUE;
      int var4 = this.field_1443_p * 16;
      int var5 = var4 / 2;

      for(int var6 = 0; var6 < this.field_1443_p; ++var6) {
         int var7 = var6 * 16;
         int var8 = var7 + var5 - p_956_1_;
         if(var8 < 0) {
            var8 -= var4 - 1;
         }

         var8 /= var4;
         var7 -= var8 * var4;
         if(var7 < this.field_1431_B) {
            this.field_1431_B = var7;
         }

         if(var7 > this.field_1428_E) {
            this.field_1428_E = var7;
         }

         for(int var9 = 0; var9 < this.field_1441_r; ++var9) {
            int var10 = var9 * 16;
            int var11 = var10 + var5 - p_956_3_;
            if(var11 < 0) {
               var11 -= var4 - 1;
            }

            var11 /= var4;
            var10 -= var11 * var4;
            if(var10 < this.field_1429_D) {
               this.field_1429_D = var10;
            }

            if(var10 > this.field_1426_G) {
               this.field_1426_G = var10;
            }

            for(int var12 = 0; var12 < this.field_1442_q; ++var12) {
               int var13 = var12 * 16;
               if(var13 < this.field_1430_C) {
                  this.field_1430_C = var13;
               }

               if(var13 > this.field_1427_F) {
                  this.field_1427_F = var13;
               }

               WorldRenderer var14 = this.field_1444_o[(var9 * this.field_1442_q + var12) * this.field_1443_p + var6];
               boolean var15 = var14.field_1738_u;
               var14.func_1197_a(var7, var13, var10);
               if(!var15 && var14.field_1738_u) {
                  this.field_1446_m.add(var14);
               }
            }
         }
      }

   }

   public int func_943_a(EntityLiving p_943_1_, int p_943_2_, double p_943_3_) {
      Profiler.func_40663_a("sortchunks");

      for(int var5 = 0; var5 < 10; ++var5) {
         this.field_21156_R = (this.field_21156_R + 1) % this.field_1444_o.length;
         WorldRenderer var6 = this.field_1444_o[this.field_21156_R];
         if(var6.field_1738_u && !this.field_1446_m.contains(var6)) {
            this.field_1446_m.add(var6);
         }
      }

      if(this.field_1439_t.field_6304_y.field_1580_e != this.field_1425_H) {
         this.func_958_a();
      }

      if(p_943_2_ == 0) {
         this.field_1420_M = 0;
         this.field_40194_P = 0;
         this.field_1419_N = 0;
         this.field_1418_O = 0;
         this.field_1417_P = 0;
         this.field_1416_Q = 0;
      }

      double var33 = p_943_1_.field_638_aI + (p_943_1_.field_611_ak - p_943_1_.field_638_aI) * p_943_3_;
      double var7 = p_943_1_.field_637_aJ + (p_943_1_.field_610_al - p_943_1_.field_637_aJ) * p_943_3_;
      double var9 = p_943_1_.field_636_aK + (p_943_1_.field_609_am - p_943_1_.field_636_aK) * p_943_3_;
      double var11 = p_943_1_.field_611_ak - this.field_1453_f;
      double var13 = p_943_1_.field_610_al - this.field_1452_g;
      double var15 = p_943_1_.field_609_am - this.field_1451_h;
      if(var11 * var11 + var13 * var13 + var15 * var15 > 16.0D) {
         this.field_1453_f = p_943_1_.field_611_ak;
         this.field_1452_g = p_943_1_.field_610_al;
         this.field_1451_h = p_943_1_.field_609_am;
         this.func_956_b(MathHelper.func_1108_b(p_943_1_.field_611_ak), MathHelper.func_1108_b(p_943_1_.field_610_al), MathHelper.func_1108_b(p_943_1_.field_609_am));
         Arrays.sort(this.field_1445_n, new EntitySorter(p_943_1_));
      }

      RenderHelper.func_1159_a();
      byte var17 = 0;
      int var34;
      if(this.field_1436_w && this.field_1439_t.field_6304_y.field_27342_h && !this.field_1439_t.field_6304_y.field_1578_g && p_943_2_ == 0) {
         byte var18 = 0;
         int var19 = 16;
         this.func_962_a(var18, var19);

         for(int var20 = var18; var20 < var19; ++var20) {
            this.field_1445_n[var20].field_1734_x = true;
         }

         Profiler.func_40661_c("render");
         var34 = var17 + this.func_952_a(var18, var19, p_943_2_, p_943_3_);

         do {
            Profiler.func_40661_c("occ");
            int var35 = var19;
            var19 *= 2;
            if(var19 > this.field_1445_n.length) {
               var19 = this.field_1445_n.length;
            }

            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glDisable(3008);
            GL11.glDisable(2912);
            GL11.glColorMask(false, false, false, false);
            GL11.glDepthMask(false);
            Profiler.func_40663_a("check");
            this.func_962_a(var35, var19);
            Profiler.func_40662_b();
            GL11.glPushMatrix();
            float var36 = 0.0F;
            float var21 = 0.0F;
            float var22 = 0.0F;

            for(int var23 = var35; var23 < var19; ++var23) {
               if(this.field_1445_n[var23].func_1196_e()) {
                  this.field_1445_n[var23].field_1749_o = false;
               } else {
                  if(!this.field_1445_n[var23].field_1749_o) {
                     this.field_1445_n[var23].field_1734_x = true;
                  }

                  if(this.field_1445_n[var23].field_1749_o && !this.field_1445_n[var23].field_1733_y) {
                     float var24 = MathHelper.func_1113_c(this.field_1445_n[var23].func_1202_a(p_943_1_));
                     int var25 = (int)(1.0F + var24 / 128.0F);
                     if(this.field_1435_x % var25 == var23 % var25) {
                        WorldRenderer var26 = this.field_1445_n[var23];
                        float var27 = (float)((double)var26.field_1755_i - var33);
                        float var28 = (float)((double)var26.field_1754_j - var7);
                        float var29 = (float)((double)var26.field_1753_k - var9);
                        float var30 = var27 - var36;
                        float var31 = var28 - var21;
                        float var32 = var29 - var22;
                        if(var30 != 0.0F || var31 != 0.0F || var32 != 0.0F) {
                           GL11.glTranslatef(var30, var31, var32);
                           var36 += var30;
                           var21 += var31;
                           var22 += var32;
                        }

                        Profiler.func_40663_a("bb");
                        ARBOcclusionQuery.glBeginQueryARB('\u8914', this.field_1445_n[var23].field_1732_z);
                        this.field_1445_n[var23].func_1201_d();
                        ARBOcclusionQuery.glEndQueryARB('\u8914');
                        Profiler.func_40662_b();
                        this.field_1445_n[var23].field_1733_y = true;
                     }
                  }
               }
            }

            GL11.glPopMatrix();
            if(this.field_1439_t.field_6304_y.field_1578_g) {
               if(EntityRenderer.field_28134_b == 0) {
                  GL11.glColorMask(false, true, true, true);
               } else {
                  GL11.glColorMask(true, false, false, true);
               }
            } else {
               GL11.glColorMask(true, true, true, true);
            }

            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            GL11.glEnable(2912);
            Profiler.func_40661_c("render");
            var34 += this.func_952_a(var35, var19, p_943_2_, p_943_3_);
         } while(var19 < this.field_1445_n.length);
      } else {
         Profiler.func_40661_c("render");
         var34 = var17 + this.func_952_a(0, this.field_1445_n.length, p_943_2_, p_943_3_);
      }

      Profiler.func_40662_b();
      return var34;
   }

   private void func_962_a(int p_962_1_, int p_962_2_) {
      for(int var3 = p_962_1_; var3 < p_962_2_; ++var3) {
         if(this.field_1445_n[var3].field_1733_y) {
            this.field_1456_c.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(this.field_1445_n[var3].field_1732_z, '\u8867', this.field_1456_c);
            if(this.field_1456_c.get(0) != 0) {
               this.field_1445_n[var3].field_1733_y = false;
               this.field_1456_c.clear();
               ARBOcclusionQuery.glGetQueryObjectuARB(this.field_1445_n[var3].field_1732_z, '\u8866', this.field_1456_c);
               this.field_1445_n[var3].field_1734_x = this.field_1456_c.get(0) != 0;
            }
         }
      }

   }

   private int func_952_a(int p_952_1_, int p_952_2_, int p_952_3_, double p_952_4_) {
      this.field_1415_R.clear();
      int var6 = 0;

      for(int var7 = p_952_1_; var7 < p_952_2_; ++var7) {
         if(p_952_3_ == 0) {
            ++this.field_1420_M;
            if(this.field_1445_n[var7].field_1748_p[p_952_3_]) {
               ++this.field_1416_Q;
            } else if(!this.field_1445_n[var7].field_1749_o) {
               ++this.field_1419_N;
            } else if(this.field_1436_w && !this.field_1445_n[var7].field_1734_x) {
               ++this.field_1418_O;
            } else {
               ++this.field_1417_P;
            }
         }

         if(!this.field_1445_n[var7].field_1748_p[p_952_3_] && this.field_1445_n[var7].field_1749_o && (!this.field_1436_w || this.field_1445_n[var7].field_1734_x)) {
            int var8 = this.field_1445_n[var7].func_1200_a(p_952_3_);
            if(var8 >= 0) {
               this.field_1415_R.add(this.field_1445_n[var7]);
               ++var6;
            }
         }
      }

      EntityLiving var19 = this.field_1439_t.field_22009_h;
      double var20 = var19.field_638_aI + (var19.field_611_ak - var19.field_638_aI) * p_952_4_;
      double var10 = var19.field_637_aJ + (var19.field_610_al - var19.field_637_aJ) * p_952_4_;
      double var12 = var19.field_636_aK + (var19.field_609_am - var19.field_636_aK) * p_952_4_;
      int var14 = 0;

      int var15;
      for(var15 = 0; var15 < this.field_1414_S.length; ++var15) {
         this.field_1414_S[var15].func_859_b();
      }

      for(var15 = 0; var15 < this.field_1415_R.size(); ++var15) {
         WorldRenderer var16 = (WorldRenderer)this.field_1415_R.get(var15);
         int var17 = -1;

         for(int var18 = 0; var18 < var14; ++var18) {
            if(this.field_1414_S[var18].func_862_a(var16.field_1755_i, var16.field_1754_j, var16.field_1753_k)) {
               var17 = var18;
            }
         }

         if(var17 < 0) {
            var17 = var14++;
            this.field_1414_S[var17].func_861_a(var16.field_1755_i, var16.field_1754_j, var16.field_1753_k, var20, var10, var12);
         }

         this.field_1414_S[var17].func_858_a(var16.func_1200_a(p_952_3_));
      }

      this.func_944_a(p_952_3_, p_952_4_);
      return var6;
   }

   public void func_944_a(int p_944_1_, double p_944_2_) {
      this.field_1439_t.field_9243_r.func_35806_b(p_944_2_);

      for(int var4 = 0; var4 < this.field_1414_S.length; ++var4) {
         this.field_1414_S[var4].func_860_a();
      }

      this.field_1439_t.field_9243_r.func_35810_a(p_944_2_);
   }

   public void func_945_d() {
      ++this.field_1435_x;
   }

   public void func_4142_a(float p_4142_1_) {
      if(this.field_1439_t.field_6324_e.field_4209_q.field_4218_e == 1) {
         GL11.glDisable(2912);
         GL11.glDisable(3008);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         RenderHelper.func_1159_a();
         GL11.glDepthMask(false);
         this.field_1447_l.func_1076_b(this.field_1447_l.func_1070_a("/misc/tunnel.png"));
         Tessellator var19 = Tessellator.field_1512_a;

         for(int var20 = 0; var20 < 6; ++var20) {
            GL11.glPushMatrix();
            if(var20 == 1) {
               GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var20 == 2) {
               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var20 == 3) {
               GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var20 == 4) {
               GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            }

            if(var20 == 5) {
               GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
            }

            var19.func_977_b();
            var19.func_990_b(1579032);
            var19.func_983_a(-100.0D, -100.0D, -100.0D, 0.0D, 0.0D);
            var19.func_983_a(-100.0D, -100.0D, 100.0D, 0.0D, 16.0D);
            var19.func_983_a(100.0D, -100.0D, 100.0D, 16.0D, 16.0D);
            var19.func_983_a(100.0D, -100.0D, -100.0D, 16.0D, 0.0D);
            var19.func_982_a();
            GL11.glPopMatrix();
         }

         GL11.glDepthMask(true);
         GL11.glEnable(3553);
         GL11.glEnable(3008);
      } else if(this.field_1439_t.field_6324_e.field_4209_q.func_48217_e()) {
         GL11.glDisable(3553);
         Vec3D var2 = this.field_1448_k.func_4079_a(this.field_1439_t.field_22009_h, p_4142_1_);
         float var3 = (float)var2.field_1776_a;
         float var4 = (float)var2.field_1775_b;
         float var5 = (float)var2.field_1779_c;
         float var7;
         float var8;
         if(this.field_1439_t.field_6304_y.field_1578_g) {
            float var6 = (var3 * 30.0F + var4 * 59.0F + var5 * 11.0F) / 100.0F;
            var7 = (var3 * 30.0F + var4 * 70.0F) / 100.0F;
            var8 = (var3 * 30.0F + var5 * 70.0F) / 100.0F;
            var3 = var6;
            var4 = var7;
            var5 = var8;
         }

         GL11.glColor3f(var3, var4, var5);
         Tessellator var21 = Tessellator.field_1512_a;
         GL11.glDepthMask(false);
         GL11.glEnable(2912);
         GL11.glColor3f(var3, var4, var5);
         GL11.glCallList(this.field_1433_z);
         GL11.glDisable(2912);
         GL11.glDisable(3008);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         RenderHelper.func_1159_a();
         float[] var22 = this.field_1448_k.field_4209_q.func_4097_b(this.field_1448_k.func_619_c(p_4142_1_), p_4142_1_);
         float var9;
         float var10;
         float var11;
         float var12;
         float var15;
         int var25;
         if(var22 != null) {
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glPushMatrix();
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(MathHelper.func_1106_a(this.field_1448_k.func_35456_d(p_4142_1_)) < 0.0F?180.0F:0.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            var8 = var22[0];
            var9 = var22[1];
            var10 = var22[2];
            float var13;
            if(this.field_1439_t.field_6304_y.field_1578_g) {
               var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
               var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
               var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
               var8 = var11;
               var9 = var12;
               var10 = var13;
            }

            var21.func_992_a(6);
            var21.func_986_a(var8, var9, var10, var22[3]);
            var21.func_991_a(0.0D, 100.0D, 0.0D);
            byte var24 = 16;
            var21.func_986_a(var22[0], var22[1], var22[2], 0.0F);

            for(var25 = 0; var25 <= var24; ++var25) {
               var13 = (float)var25 * 3.1415927F * 2.0F / (float)var24;
               float var14 = MathHelper.func_1106_a(var13);
               var15 = MathHelper.func_1114_b(var13);
               var21.func_991_a((double)(var14 * 120.0F), (double)(var15 * 120.0F), (double)(-var15 * 40.0F * var22[3]));
            }

            var21.func_982_a();
            GL11.glPopMatrix();
            GL11.glShadeModel(7424);
         }

         GL11.glEnable(3553);
         GL11.glBlendFunc(770, 1);
         GL11.glPushMatrix();
         var7 = 1.0F - this.field_1448_k.func_27162_g(p_4142_1_);
         var8 = 0.0F;
         var9 = 0.0F;
         var10 = 0.0F;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, var7);
         GL11.glTranslatef(var8, var9, var10);
         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.field_1448_k.func_619_c(p_4142_1_) * 360.0F, 1.0F, 0.0F, 0.0F);
         var11 = 30.0F;
         GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/terrain/sun.png"));
         var21.func_977_b();
         var21.func_983_a((double)(-var11), 100.0D, (double)(-var11), 0.0D, 0.0D);
         var21.func_983_a((double)var11, 100.0D, (double)(-var11), 1.0D, 0.0D);
         var21.func_983_a((double)var11, 100.0D, (double)var11, 1.0D, 1.0D);
         var21.func_983_a((double)(-var11), 100.0D, (double)var11, 0.0D, 1.0D);
         var21.func_982_a();
         var11 = 20.0F;
         GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/terrain/moon_phases.png"));
         var25 = this.field_1448_k.func_40475_d(p_4142_1_);
         int var26 = var25 % 4;
         int var27 = var25 / 4 % 2;
         var15 = (float)(var26 + 0) / 4.0F;
         float var16 = (float)(var27 + 0) / 2.0F;
         float var17 = (float)(var26 + 1) / 4.0F;
         float var18 = (float)(var27 + 1) / 2.0F;
         var21.func_977_b();
         var21.func_983_a((double)(-var11), -100.0D, (double)var11, (double)var17, (double)var18);
         var21.func_983_a((double)var11, -100.0D, (double)var11, (double)var15, (double)var18);
         var21.func_983_a((double)var11, -100.0D, (double)(-var11), (double)var15, (double)var16);
         var21.func_983_a((double)(-var11), -100.0D, (double)(-var11), (double)var17, (double)var16);
         var21.func_982_a();
         GL11.glDisable(3553);
         var12 = this.field_1448_k.func_679_f(p_4142_1_) * var7;
         if(var12 > 0.0F) {
            GL11.glColor4f(var12, var12, var12, var12);
            GL11.glCallList(this.field_1434_y);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(3008);
         GL11.glEnable(2912);
         GL11.glPopMatrix();
         GL11.glDisable(3553);
         GL11.glColor3f(0.0F, 0.0F, 0.0F);
         double var23 = this.field_1439_t.field_6322_g.func_427_e(p_4142_1_).field_1775_b - this.field_1448_k.func_46068_G();
         if(var23 < 0.0D) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(this.field_1432_A);
            GL11.glPopMatrix();
            var9 = 1.0F;
            var10 = -((float)(var23 + 65.0D));
            var11 = -var9;
            var21.func_977_b();
            var21.func_6513_a(0, 255);
            var21.func_991_a((double)(-var9), (double)var10, (double)var9);
            var21.func_991_a((double)var9, (double)var10, (double)var9);
            var21.func_991_a((double)var9, (double)var11, (double)var9);
            var21.func_991_a((double)(-var9), (double)var11, (double)var9);
            var21.func_991_a((double)(-var9), (double)var11, (double)(-var9));
            var21.func_991_a((double)var9, (double)var11, (double)(-var9));
            var21.func_991_a((double)var9, (double)var10, (double)(-var9));
            var21.func_991_a((double)(-var9), (double)var10, (double)(-var9));
            var21.func_991_a((double)var9, (double)var11, (double)(-var9));
            var21.func_991_a((double)var9, (double)var11, (double)var9);
            var21.func_991_a((double)var9, (double)var10, (double)var9);
            var21.func_991_a((double)var9, (double)var10, (double)(-var9));
            var21.func_991_a((double)(-var9), (double)var10, (double)(-var9));
            var21.func_991_a((double)(-var9), (double)var10, (double)var9);
            var21.func_991_a((double)(-var9), (double)var11, (double)var9);
            var21.func_991_a((double)(-var9), (double)var11, (double)(-var9));
            var21.func_991_a((double)(-var9), (double)var11, (double)(-var9));
            var21.func_991_a((double)(-var9), (double)var11, (double)var9);
            var21.func_991_a((double)var9, (double)var11, (double)var9);
            var21.func_991_a((double)var9, (double)var11, (double)(-var9));
            var21.func_982_a();
         }

         if(this.field_1448_k.field_4209_q.func_28112_c()) {
            GL11.glColor3f(var3 * 0.2F + 0.04F, var4 * 0.2F + 0.04F, var5 * 0.6F + 0.1F);
         } else {
            GL11.glColor3f(var3, var4, var5);
         }

         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, -((float)(var23 - 16.0D)), 0.0F);
         GL11.glCallList(this.field_1432_A);
         GL11.glPopMatrix();
         GL11.glEnable(3553);
         GL11.glDepthMask(true);
      }
   }

   public void func_4141_b(float p_4141_1_) {
      if(this.field_1439_t.field_6324_e.field_4209_q.func_48217_e()) {
         if(this.field_1439_t.field_6304_y.field_1576_i) {
            this.func_6510_c(p_4141_1_);
         } else {
            GL11.glDisable(2884);
            float var2 = (float)(this.field_1439_t.field_22009_h.field_637_aJ + (this.field_1439_t.field_22009_h.field_610_al - this.field_1439_t.field_22009_h.field_637_aJ) * (double)p_4141_1_);
            byte var3 = 32;
            int var4 = 256 / var3;
            Tessellator var5 = Tessellator.field_1512_a;
            GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/environment/clouds.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            Vec3D var6 = this.field_1448_k.func_628_d(p_4141_1_);
            float var7 = (float)var6.field_1776_a;
            float var8 = (float)var6.field_1775_b;
            float var9 = (float)var6.field_1779_c;
            float var10;
            if(this.field_1439_t.field_6304_y.field_1578_g) {
               var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
               float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
               float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
               var7 = var10;
               var8 = var11;
               var9 = var12;
            }

            var10 = 4.8828125E-4F;
            double var24 = (double)((float)this.field_1435_x + p_4141_1_);
            double var13 = this.field_1439_t.field_22009_h.field_9285_at + (this.field_1439_t.field_22009_h.field_611_ak - this.field_1439_t.field_22009_h.field_9285_at) * (double)p_4141_1_ + var24 * 0.029999999329447746D;
            double var15 = this.field_1439_t.field_22009_h.field_9283_av + (this.field_1439_t.field_22009_h.field_609_am - this.field_1439_t.field_22009_h.field_9283_av) * (double)p_4141_1_;
            int var17 = MathHelper.func_1108_b(var13 / 2048.0D);
            int var18 = MathHelper.func_1108_b(var15 / 2048.0D);
            var13 -= (double)(var17 * 2048);
            var15 -= (double)(var18 * 2048);
            float var19 = this.field_1448_k.field_4209_q.func_28111_d() - var2 + 0.33F;
            float var20 = (float)(var13 * (double)var10);
            float var21 = (float)(var15 * (double)var10);
            var5.func_977_b();
            var5.func_986_a(var7, var8, var9, 0.8F);

            for(int var22 = -var3 * var4; var22 < var3 * var4; var22 += var3) {
               for(int var23 = -var3 * var4; var23 < var3 * var4; var23 += var3) {
                  var5.func_983_a((double)(var22 + 0), (double)var19, (double)(var23 + var3), (double)((float)(var22 + 0) * var10 + var20), (double)((float)(var23 + var3) * var10 + var21));
                  var5.func_983_a((double)(var22 + var3), (double)var19, (double)(var23 + var3), (double)((float)(var22 + var3) * var10 + var20), (double)((float)(var23 + var3) * var10 + var21));
                  var5.func_983_a((double)(var22 + var3), (double)var19, (double)(var23 + 0), (double)((float)(var22 + var3) * var10 + var20), (double)((float)(var23 + 0) * var10 + var21));
                  var5.func_983_a((double)(var22 + 0), (double)var19, (double)(var23 + 0), (double)((float)(var22 + 0) * var10 + var20), (double)((float)(var23 + 0) * var10 + var21));
               }
            }

            var5.func_982_a();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(2884);
         }
      }
   }

   public boolean func_27307_a(double p_27307_1_, double p_27307_3_, double p_27307_5_, float p_27307_7_) {
      return false;
   }

   public void func_6510_c(float p_6510_1_) {
      GL11.glDisable(2884);
      float var2 = (float)(this.field_1439_t.field_22009_h.field_637_aJ + (this.field_1439_t.field_22009_h.field_610_al - this.field_1439_t.field_22009_h.field_637_aJ) * (double)p_6510_1_);
      Tessellator var3 = Tessellator.field_1512_a;
      float var4 = 12.0F;
      float var5 = 4.0F;
      double var6 = (double)((float)this.field_1435_x + p_6510_1_);
      double var8 = (this.field_1439_t.field_22009_h.field_9285_at + (this.field_1439_t.field_22009_h.field_611_ak - this.field_1439_t.field_22009_h.field_9285_at) * (double)p_6510_1_ + var6 * 0.029999999329447746D) / (double)var4;
      double var10 = (this.field_1439_t.field_22009_h.field_9283_av + (this.field_1439_t.field_22009_h.field_609_am - this.field_1439_t.field_22009_h.field_9283_av) * (double)p_6510_1_) / (double)var4 + 0.33000001311302185D;
      float var12 = this.field_1448_k.field_4209_q.func_28111_d() - var2 + 0.33F;
      int var13 = MathHelper.func_1108_b(var8 / 2048.0D);
      int var14 = MathHelper.func_1108_b(var10 / 2048.0D);
      var8 -= (double)(var13 * 2048);
      var10 -= (double)(var14 * 2048);
      GL11.glBindTexture(3553, this.field_1447_l.func_1070_a("/environment/clouds.png"));
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      Vec3D var15 = this.field_1448_k.func_628_d(p_6510_1_);
      float var16 = (float)var15.field_1776_a;
      float var17 = (float)var15.field_1775_b;
      float var18 = (float)var15.field_1779_c;
      float var19;
      float var20;
      float var21;
      if(this.field_1439_t.field_6304_y.field_1578_g) {
         var19 = (var16 * 30.0F + var17 * 59.0F + var18 * 11.0F) / 100.0F;
         var20 = (var16 * 30.0F + var17 * 70.0F) / 100.0F;
         var21 = (var16 * 30.0F + var18 * 70.0F) / 100.0F;
         var16 = var19;
         var17 = var20;
         var18 = var21;
      }

      var19 = (float)(var8 * 0.0D);
      var20 = (float)(var10 * 0.0D);
      var21 = 0.00390625F;
      var19 = (float)MathHelper.func_1108_b(var8) * var21;
      var20 = (float)MathHelper.func_1108_b(var10) * var21;
      float var22 = (float)(var8 - (double)MathHelper.func_1108_b(var8));
      float var23 = (float)(var10 - (double)MathHelper.func_1108_b(var10));
      byte var24 = 8;
      byte var25 = 4;
      float var26 = 9.765625E-4F;
      GL11.glScalef(var4, 1.0F, var4);

      for(int var27 = 0; var27 < 2; ++var27) {
         if(var27 == 0) {
            GL11.glColorMask(false, false, false, false);
         } else if(this.field_1439_t.field_6304_y.field_1578_g) {
            if(EntityRenderer.field_28134_b == 0) {
               GL11.glColorMask(false, true, true, true);
            } else {
               GL11.glColorMask(true, false, false, true);
            }
         } else {
            GL11.glColorMask(true, true, true, true);
         }

         for(int var28 = -var25 + 1; var28 <= var25; ++var28) {
            for(int var29 = -var25 + 1; var29 <= var25; ++var29) {
               var3.func_977_b();
               float var30 = (float)(var28 * var24);
               float var31 = (float)(var29 * var24);
               float var32 = var30 - var22;
               float var33 = var31 - var23;
               if(var12 > -var5 - 1.0F) {
                  var3.func_986_a(var16 * 0.7F, var17 * 0.7F, var18 * 0.7F, 0.8F);
                  var3.func_980_b(0.0F, -1.0F, 0.0F);
                  var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
               }

               if(var12 <= var5 + 1.0F) {
                  var3.func_986_a(var16, var17, var18, 0.8F);
                  var3.func_980_b(0.0F, 1.0F, 0.0F);
                  var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + var5 - var26), (double)(var33 + (float)var24), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + var5 - var26), (double)(var33 + (float)var24), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                  var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + var5 - var26), (double)(var33 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + var5 - var26), (double)(var33 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
               }

               var3.func_986_a(var16 * 0.9F, var17 * 0.9F, var18 * 0.9F, 0.8F);
               int var34;
               if(var28 > -1) {
                  var3.func_980_b(-1.0F, 0.0F, 0.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_983_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + var5), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + var5), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var34 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  }
               }

               if(var28 <= 1) {
                  var3.func_980_b(1.0F, 0.0F, 0.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_983_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + 0.0F), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + var5), (double)(var33 + (float)var24), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + (float)var24) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + var5), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var34 + 1.0F - var26), (double)(var12 + 0.0F), (double)(var33 + 0.0F), (double)((var30 + (float)var34 + 0.5F) * var21 + var19), (double)((var31 + 0.0F) * var21 + var20));
                  }
               }

               var3.func_986_a(var16 * 0.8F, var17 * 0.8F, var18 * 0.8F, 0.8F);
               if(var29 > -1) {
                  var3.func_980_b(0.0F, 0.0F, -1.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + var5), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + var5), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 0.0F), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                  }
               }

               if(var29 <= 1) {
                  var3.func_980_b(0.0F, 0.0F, 1.0F);

                  for(var34 = 0; var34 < var24; ++var34) {
                     var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + var5), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + var5), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_983_a((double)(var32 + (float)var24), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + (float)var24) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                     var3.func_983_a((double)(var32 + 0.0F), (double)(var12 + 0.0F), (double)(var33 + (float)var34 + 1.0F - var26), (double)((var30 + 0.0F) * var21 + var19), (double)((var31 + (float)var34 + 0.5F) * var21 + var20));
                  }
               }

               var3.func_982_a();
            }
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glEnable(2884);
   }

   public boolean func_948_a(EntityLiving p_948_1_, boolean p_948_2_) {
      boolean var3 = false;
      if(var3) {
         Collections.sort(this.field_1446_m, new RenderSorter(p_948_1_));
         int var17 = this.field_1446_m.size() - 1;
         int var18 = this.field_1446_m.size();

         for(int var19 = 0; var19 < var18; ++var19) {
            WorldRenderer var20 = (WorldRenderer)this.field_1446_m.get(var17 - var19);
            if(!p_948_2_) {
               if(var20.func_1202_a(p_948_1_) > 256.0F) {
                  if(var20.field_1749_o) {
                     if(var19 >= 30) {
                        return false;
                     }
                  } else if(var19 >= 1) {
                     return false;
                  }
               }
            } else if(!var20.field_1749_o) {
               continue;
            }

            var20.func_1198_a();
            this.field_1446_m.remove(var20);
            var20.field_1738_u = false;
         }

         return this.field_1446_m.size() == 0;
      } else {
         byte var4 = 2;
         RenderSorter var5 = new RenderSorter(p_948_1_);
         WorldRenderer[] var6 = new WorldRenderer[var4];
         ArrayList var7 = null;
         int var8 = this.field_1446_m.size();
         int var9 = 0;

         int var10;
         WorldRenderer var11;
         int var12;
         int var13;
         label168:
         for(var10 = 0; var10 < var8; ++var10) {
            var11 = (WorldRenderer)this.field_1446_m.get(var10);
            if(!p_948_2_) {
               if(var11.func_1202_a(p_948_1_) > 256.0F) {
                  for(var12 = 0; var12 < var4 && (var6[var12] == null || var5.func_993_a(var6[var12], var11) <= 0); ++var12) {
                     ;
                  }

                  --var12;
                  if(var12 > 0) {
                     var13 = var12;

                     while(true) {
                        --var13;
                        if(var13 == 0) {
                           var6[var12] = var11;
                           continue label168;
                        }

                        var6[var13 - 1] = var6[var13];
                     }
                  }
                  continue;
               }
            } else if(!var11.field_1749_o) {
               continue;
            }

            if(var7 == null) {
               var7 = new ArrayList();
            }

            ++var9;
            var7.add(var11);
            this.field_1446_m.set(var10, (Object)null);
         }

         if(var7 != null) {
            if(var7.size() > 1) {
               Collections.sort(var7, var5);
            }

            for(var10 = var7.size() - 1; var10 >= 0; --var10) {
               var11 = (WorldRenderer)var7.get(var10);
               var11.func_1198_a();
               var11.field_1738_u = false;
            }
         }

         var10 = 0;

         int var21;
         for(var21 = var4 - 1; var21 >= 0; --var21) {
            WorldRenderer var22 = var6[var21];
            if(var22 != null) {
               if(!var22.field_1749_o && var21 != var4 - 1) {
                  var6[var21] = null;
                  var6[0] = null;
                  break;
               }

               var6[var21].func_1198_a();
               var6[var21].field_1738_u = false;
               ++var10;
            }
         }

         var21 = 0;
         var12 = 0;

         for(var13 = this.field_1446_m.size(); var21 != var13; ++var21) {
            WorldRenderer var14 = (WorldRenderer)this.field_1446_m.get(var21);
            if(var14 != null) {
               boolean var15 = false;

               for(int var16 = 0; var16 < var4 && !var15; ++var16) {
                  if(var14 == var6[var16]) {
                     var15 = true;
                  }
               }

               if(!var15) {
                  if(var12 != var21) {
                     this.field_1446_m.set(var12, var14);
                  }

                  ++var12;
               }
            }
         }

         while(true) {
            --var21;
            if(var21 < var12) {
               return var8 == var9 + var10;
            }

            this.field_1446_m.remove(var21);
         }
      }
   }

   public void func_959_a(EntityPlayer p_959_1_, MovingObjectPosition p_959_2_, int p_959_3_, ItemStack p_959_4_, float p_959_5_) {
      Tessellator var6 = Tessellator.field_1512_a;
      GL11.glEnable(3042);
      GL11.glEnable(3008);
      GL11.glBlendFunc(770, 1);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, (MathHelper.func_1106_a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.4F) * 0.5F);
      int var8;
      if(p_959_3_ == 0) {
         if(this.field_1450_i > 0.0F) {
            GL11.glBlendFunc(774, 768);
            int var7 = this.field_1447_l.func_1070_a("/terrain.png");
            GL11.glBindTexture(3553, var7);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
            GL11.glPushMatrix();
            var8 = this.field_1448_k.func_600_a(p_959_2_.field_1166_b, p_959_2_.field_1172_c, p_959_2_.field_1171_d);
            Block var9 = var8 > 0?Block.field_345_n[var8]:null;
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3.0F, -3.0F);
            GL11.glEnable('\u8037');
            double var10 = p_959_1_.field_638_aI + (p_959_1_.field_611_ak - p_959_1_.field_638_aI) * (double)p_959_5_;
            double var12 = p_959_1_.field_637_aJ + (p_959_1_.field_610_al - p_959_1_.field_637_aJ) * (double)p_959_5_;
            double var14 = p_959_1_.field_636_aK + (p_959_1_.field_609_am - p_959_1_.field_636_aK) * (double)p_959_5_;
            if(var9 == null) {
               var9 = Block.field_338_u;
            }

            GL11.glEnable(3008);
            var6.func_977_b();
            var6.func_984_b(-var10, -var12, -var14);
            var6.func_989_c();
            this.field_1438_u.func_1223_a(var9, p_959_2_.field_1166_b, p_959_2_.field_1172_c, p_959_2_.field_1171_d, 240 + (int)(this.field_1450_i * 10.0F));
            var6.func_982_a();
            var6.func_984_b(0.0D, 0.0D, 0.0D);
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0F, 0.0F);
            GL11.glDisable('\u8037');
            GL11.glEnable(3008);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
         }
      } else if(p_959_4_ != null) {
         GL11.glBlendFunc(770, 771);
         float var16 = MathHelper.func_1106_a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.8F;
         GL11.glColor4f(var16, var16, var16, MathHelper.func_1106_a((float)System.currentTimeMillis() / 200.0F) * 0.2F + 0.5F);
         var8 = this.field_1447_l.func_1070_a("/terrain.png");
         GL11.glBindTexture(3553, var8);
         int var17 = p_959_2_.field_1166_b;
         int var18 = p_959_2_.field_1172_c;
         int var11 = p_959_2_.field_1171_d;
         if(p_959_2_.field_1170_e == 0) {
            --var18;
         }

         if(p_959_2_.field_1170_e == 1) {
            ++var18;
         }

         if(p_959_2_.field_1170_e == 2) {
            --var11;
         }

         if(p_959_2_.field_1170_e == 3) {
            ++var11;
         }

         if(p_959_2_.field_1170_e == 4) {
            --var17;
         }

         if(p_959_2_.field_1170_e == 5) {
            ++var17;
         }
      }

      GL11.glDisable(3042);
      GL11.glDisable(3008);
   }

   public void func_955_b(EntityPlayer p_955_1_, MovingObjectPosition p_955_2_, int p_955_3_, ItemStack p_955_4_, float p_955_5_) {
      if(p_955_3_ == 0 && p_955_2_.field_1167_a == EnumMovingObjectType.TILE) {
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
         GL11.glLineWidth(2.0F);
         GL11.glDisable(3553);
         GL11.glDepthMask(false);
         float var6 = 0.002F;
         int var7 = this.field_1448_k.func_600_a(p_955_2_.field_1166_b, p_955_2_.field_1172_c, p_955_2_.field_1171_d);
         if(var7 > 0) {
            Block.field_345_n[var7].func_238_a(this.field_1448_k, p_955_2_.field_1166_b, p_955_2_.field_1172_c, p_955_2_.field_1171_d);
            double var8 = p_955_1_.field_638_aI + (p_955_1_.field_611_ak - p_955_1_.field_638_aI) * (double)p_955_5_;
            double var10 = p_955_1_.field_637_aJ + (p_955_1_.field_610_al - p_955_1_.field_637_aJ) * (double)p_955_5_;
            double var12 = p_955_1_.field_636_aK + (p_955_1_.field_609_am - p_955_1_.field_636_aK) * (double)p_955_5_;
            this.func_942_a(Block.field_345_n[var7].func_246_f(this.field_1448_k, p_955_2_.field_1166_b, p_955_2_.field_1172_c, p_955_2_.field_1171_d).func_1177_b((double)var6, (double)var6, (double)var6).func_1166_c(-var8, -var10, -var12));
         }

         GL11.glDepthMask(true);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
      }

   }

   private void func_942_a(AxisAlignedBB p_942_1_) {
      Tessellator var2 = Tessellator.field_1512_a;
      var2.func_992_a(3);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
      var2.func_982_a();
      var2.func_992_a(3);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
      var2.func_982_a();
      var2.func_992_a(1);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1704_c);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1703_d, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1697_b, p_942_1_.field_1701_f);
      var2.func_991_a(p_942_1_.field_1698_a, p_942_1_.field_1702_e, p_942_1_.field_1701_f);
      var2.func_982_a();
   }

   public void func_949_a(int p_949_1_, int p_949_2_, int p_949_3_, int p_949_4_, int p_949_5_, int p_949_6_) {
      int var7 = MathHelper.func_1111_a(p_949_1_, 16);
      int var8 = MathHelper.func_1111_a(p_949_2_, 16);
      int var9 = MathHelper.func_1111_a(p_949_3_, 16);
      int var10 = MathHelper.func_1111_a(p_949_4_, 16);
      int var11 = MathHelper.func_1111_a(p_949_5_, 16);
      int var12 = MathHelper.func_1111_a(p_949_6_, 16);

      for(int var13 = var7; var13 <= var10; ++var13) {
         int var14 = var13 % this.field_1443_p;
         if(var14 < 0) {
            var14 += this.field_1443_p;
         }

         for(int var15 = var8; var15 <= var11; ++var15) {
            int var16 = var15 % this.field_1442_q;
            if(var16 < 0) {
               var16 += this.field_1442_q;
            }

            for(int var17 = var9; var17 <= var12; ++var17) {
               int var18 = var17 % this.field_1441_r;
               if(var18 < 0) {
                  var18 += this.field_1441_r;
               }

               int var19 = (var18 * this.field_1442_q + var16) * this.field_1443_p + var14;
               WorldRenderer var20 = this.field_1444_o[var19];
               if(!var20.field_1738_u) {
                  this.field_1446_m.add(var20);
                  var20.func_1194_f();
               }
            }
         }
      }

   }

   public void func_934_a(int p_934_1_, int p_934_2_, int p_934_3_) {
      this.func_949_a(p_934_1_ - 1, p_934_2_ - 1, p_934_3_ - 1, p_934_1_ + 1, p_934_2_ + 1, p_934_3_ + 1);
   }

   public void func_48180_b(int p_48180_1_, int p_48180_2_, int p_48180_3_) {
      this.func_949_a(p_48180_1_ - 1, p_48180_2_ - 1, p_48180_3_ - 1, p_48180_1_ + 1, p_48180_2_ + 1, p_48180_3_ + 1);
   }

   public void func_937_b(int p_937_1_, int p_937_2_, int p_937_3_, int p_937_4_, int p_937_5_, int p_937_6_) {
      this.func_949_a(p_937_1_ - 1, p_937_2_ - 1, p_937_3_ - 1, p_937_4_ + 1, p_937_5_ + 1, p_937_6_ + 1);
   }

   public void func_960_a(ICamera p_960_1_, float p_960_2_) {
      for(int var3 = 0; var3 < this.field_1444_o.length; ++var3) {
         if(!this.field_1444_o[var3].func_1196_e() && (!this.field_1444_o[var3].field_1749_o || (var3 + this.field_1449_j & 15) == 0)) {
            this.field_1444_o[var3].func_1199_a(p_960_1_);
         }
      }

      ++this.field_1449_j;
   }

   public void func_933_a(String p_933_1_, int p_933_2_, int p_933_3_, int p_933_4_) {
      if(p_933_1_ != null) {
         this.field_1439_t.field_6308_u.func_553_b("C418 - " + p_933_1_);
      }

      this.field_1439_t.field_6301_A.func_331_a(p_933_1_, (float)p_933_2_, (float)p_933_3_, (float)p_933_4_, 1.0F, 1.0F);
   }

   public void func_940_a(String p_940_1_, double p_940_2_, double p_940_4_, double p_940_6_, float p_940_8_, float p_940_9_) {
      float var10 = 16.0F;
      if(p_940_8_ > 1.0F) {
         var10 *= p_940_8_;
      }

      if(this.field_1439_t.field_22009_h.func_360_d(p_940_2_, p_940_4_, p_940_6_) < (double)(var10 * var10)) {
         this.field_1439_t.field_6301_A.func_336_b(p_940_1_, (float)p_940_2_, (float)p_940_4_, (float)p_940_6_, p_940_8_, p_940_9_);
      }

   }

   public void func_939_a(String p_939_1_, double p_939_2_, double p_939_4_, double p_939_6_, double p_939_8_, double p_939_10_, double p_939_12_) {
      this.func_40193_b(p_939_1_, p_939_2_, p_939_4_, p_939_6_, p_939_8_, p_939_10_, p_939_12_);
   }

   public EntityFX func_40193_b(String p_40193_1_, double p_40193_2_, double p_40193_4_, double p_40193_6_, double p_40193_8_, double p_40193_10_, double p_40193_12_) {
      if(this.field_1439_t != null && this.field_1439_t.field_22009_h != null && this.field_1439_t.field_6321_h != null) {
         int var14 = this.field_1439_t.field_6304_y.field_41087_P;
         if(var14 == 1 && this.field_1448_k.field_1037_n.nextInt(3) == 0) {
            var14 = 2;
         }

         double var15 = this.field_1439_t.field_22009_h.field_611_ak - p_40193_2_;
         double var17 = this.field_1439_t.field_22009_h.field_610_al - p_40193_4_;
         double var19 = this.field_1439_t.field_22009_h.field_609_am - p_40193_6_;
         Object var21 = null;
         if(p_40193_1_.equals("hugeexplosion")) {
            this.field_1439_t.field_6321_h.func_1192_a(var21 = new EntityHugeExplodeFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_));
         } else if(p_40193_1_.equals("largeexplode")) {
            this.field_1439_t.field_6321_h.func_1192_a(var21 = new EntityLargeExplodeFX(this.field_1447_l, this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_));
         }

         if(var21 != null) {
            return (EntityFX)var21;
         } else {
            double var22 = 16.0D;
            if(var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
               return null;
            } else if(var14 > 1) {
               return null;
            } else {
               if(p_40193_1_.equals("bubble")) {
                  var21 = new EntityBubbleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("suspended")) {
                  var21 = new EntitySuspendFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("depthsuspend")) {
                  var21 = new EntityAuraFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("townaura")) {
                  var21 = new EntityAuraFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("crit")) {
                  var21 = new EntityCritFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("magicCrit")) {
                  var21 = new EntityCritFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
                  ((EntityFX)var21).func_40097_b(((EntityFX)var21).func_40098_n() * 0.3F, ((EntityFX)var21).func_40101_o() * 0.8F, ((EntityFX)var21).func_40102_p());
                  ((EntityFX)var21).func_40099_c(((EntityFX)var21).func_40100_q() + 1);
               } else if(p_40193_1_.equals("smoke")) {
                  var21 = new EntitySmokeFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("mobSpell")) {
                  var21 = new EntitySpellParticleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, 0.0D, 0.0D, 0.0D);
                  ((EntityFX)var21).func_40097_b((float)p_40193_8_, (float)p_40193_10_, (float)p_40193_12_);
               } else if(p_40193_1_.equals("spell")) {
                  var21 = new EntitySpellParticleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("instantSpell")) {
                  var21 = new EntitySpellParticleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
                  ((EntitySpellParticleFX)var21).func_40110_b(144);
               } else if(p_40193_1_.equals("note")) {
                  var21 = new EntityNoteFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("portal")) {
                  var21 = new EntityPortalFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("enchantmenttable")) {
                  var21 = new EntityEnchantmentTableParticleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("explode")) {
                  var21 = new EntityExplodeFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("flame")) {
                  var21 = new EntityFlameFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("lava")) {
                  var21 = new EntityLavaFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_);
               } else if(p_40193_1_.equals("footstep")) {
                  var21 = new EntityFootStepFX(this.field_1447_l, this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_);
               } else if(p_40193_1_.equals("splash")) {
                  var21 = new EntitySplashFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("largesmoke")) {
                  var21 = new EntitySmokeFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_, 2.5F);
               } else if(p_40193_1_.equals("cloud")) {
                  var21 = new EntityCloudFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("reddust")) {
                  var21 = new EntityReddustFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, (float)p_40193_8_, (float)p_40193_10_, (float)p_40193_12_);
               } else if(p_40193_1_.equals("snowballpoof")) {
                  var21 = new EntityBreakingFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Item.field_308_aB);
               } else if(p_40193_1_.equals("dripWater")) {
                  var21 = new EntityDropParticleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Material.field_1332_f);
               } else if(p_40193_1_.equals("dripLava")) {
                  var21 = new EntityDropParticleFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Material.field_1331_g);
               } else if(p_40193_1_.equals("snowshovel")) {
                  var21 = new EntitySnowShovelFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else if(p_40193_1_.equals("slime")) {
                  var21 = new EntityBreakingFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, Item.field_299_aK);
               } else if(p_40193_1_.equals("heart")) {
                  var21 = new EntityHeartFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_);
               } else {
                  int var24;
                  if(p_40193_1_.startsWith("iconcrack_")) {
                     var24 = Integer.parseInt(p_40193_1_.substring(p_40193_1_.indexOf("_") + 1));
                     var21 = new EntityBreakingFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_, Item.field_233_c[var24]);
                  } else if(p_40193_1_.startsWith("tilecrack_")) {
                     var24 = Integer.parseInt(p_40193_1_.substring(p_40193_1_.indexOf("_") + 1));
                     var21 = new EntityDiggingFX(this.field_1448_k, p_40193_2_, p_40193_4_, p_40193_6_, p_40193_8_, p_40193_10_, p_40193_12_, Block.field_345_n[var24], 0, 0);
                  }
               }

               if(var21 != null) {
                  this.field_1439_t.field_6321_h.func_1192_a((EntityFX)var21);
               }

               return (EntityFX)var21;
            }
         }
      } else {
         return null;
      }
   }

   public void func_941_a(Entity p_941_1_) {
      p_941_1_.func_20046_s();
      if(p_941_1_.field_20047_bv != null) {
         this.field_1447_l.func_1075_a(p_941_1_.field_20047_bv, new ImageBufferDownload());
      }

      if(p_941_1_.field_622_aY != null) {
         this.field_1447_l.func_1075_a(p_941_1_.field_622_aY, new ImageBufferDownload());
      }

   }

   public void func_938_b(Entity p_938_1_) {
      if(p_938_1_.field_20047_bv != null) {
         this.field_1447_l.func_1073_b(p_938_1_.field_20047_bv);
      }

      if(p_938_1_.field_622_aY != null) {
         this.field_1447_l.func_1073_b(p_938_1_.field_622_aY);
      }

   }

   public void func_935_a(int p_935_1_, int p_935_2_, int p_935_3_, TileEntity p_935_4_) {}

   public void func_28137_f() {
      GLAllocation.func_28194_b(this.field_1440_s);
   }

   public void func_28136_a(EntityPlayer p_28136_1_, int p_28136_2_, int p_28136_3_, int p_28136_4_, int p_28136_5_, int p_28136_6_) {
      Random var7 = this.field_1448_k.field_1037_n;
      int var8;
      double var10;
      double var12;
      String var14;
      int var15;
      double var21;
      double var23;
      double var25;
      double var27;
      double var29;
      double var33;
      switch(p_28136_2_) {
      case 1000:
         this.field_1448_k.func_684_a((double)p_28136_3_, (double)p_28136_4_, (double)p_28136_5_, "random.click", 1.0F, 1.0F);
         break;
      case 1001:
         this.field_1448_k.func_684_a((double)p_28136_3_, (double)p_28136_4_, (double)p_28136_5_, "random.click", 1.0F, 1.2F);
         break;
      case 1002:
         this.field_1448_k.func_684_a((double)p_28136_3_, (double)p_28136_4_, (double)p_28136_5_, "random.bow", 1.0F, 1.2F);
         break;
      case 1003:
         if(Math.random() < 0.5D) {
            this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "random.door_open", 1.0F, this.field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
         } else {
            this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "random.door_close", 1.0F, this.field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
         }
         break;
      case 1004:
         this.field_1448_k.func_684_a((double)((float)p_28136_3_ + 0.5F), (double)((float)p_28136_4_ + 0.5F), (double)((float)p_28136_5_ + 0.5F), "random.fizz", 0.5F, 2.6F + (var7.nextFloat() - var7.nextFloat()) * 0.8F);
         break;
      case 1005:
         if(Item.field_233_c[p_28136_6_] instanceof ItemRecord) {
            this.field_1448_k.func_670_a(((ItemRecord)Item.field_233_c[p_28136_6_]).field_316_a, p_28136_3_, p_28136_4_, p_28136_5_);
         } else {
            this.field_1448_k.func_670_a((String)null, p_28136_3_, p_28136_4_, p_28136_5_);
         }
         break;
      case 1007:
         this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.ghast.charge", 10.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F);
         break;
      case 1008:
         this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.ghast.fireball", 10.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F);
         break;
      case 1010:
         this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.zombie.wood", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F);
         break;
      case 1011:
         this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.zombie.metal", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F);
         break;
      case 1012:
         this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "mob.zombie.woodbreak", 2.0F, (var7.nextFloat() - var7.nextFloat()) * 0.2F + 1.0F);
         break;
      case 2000:
         var8 = p_28136_6_ % 3 - 1;
         int var35 = p_28136_6_ / 3 % 3 - 1;
         var10 = (double)p_28136_3_ + (double)var8 * 0.6D + 0.5D;
         var12 = (double)p_28136_4_ + 0.5D;
         double var36 = (double)p_28136_5_ + (double)var35 * 0.6D + 0.5D;

         for(int var38 = 0; var38 < 10; ++var38) {
            double var39 = var7.nextDouble() * 0.2D + 0.01D;
            double var40 = var10 + (double)var8 * 0.01D + (var7.nextDouble() - 0.5D) * (double)var35 * 0.5D;
            var21 = var12 + (var7.nextDouble() - 0.5D) * 0.5D;
            var23 = var36 + (double)var35 * 0.01D + (var7.nextDouble() - 0.5D) * (double)var8 * 0.5D;
            var25 = (double)var8 * var39 + var7.nextGaussian() * 0.01D;
            var27 = -0.03D + var7.nextGaussian() * 0.01D;
            var29 = (double)var35 * var39 + var7.nextGaussian() * 0.01D;
            this.func_939_a("smoke", var40, var21, var23, var25, var27, var29);
         }

         return;
      case 2001:
         var8 = p_28136_6_ & 4095;
         if(var8 > 0) {
            Block var34 = Block.field_345_n[var8];
            this.field_1439_t.field_6301_A.func_336_b(var34.field_358_bl.func_1146_a(), (float)p_28136_3_ + 0.5F, (float)p_28136_4_ + 0.5F, (float)p_28136_5_ + 0.5F, (var34.field_358_bl.func_1147_b() + 1.0F) / 2.0F, var34.field_358_bl.func_1144_c() * 0.8F);
         }

         this.field_1439_t.field_6321_h.func_1186_a(p_28136_3_, p_28136_4_, p_28136_5_, p_28136_6_ & 4095, p_28136_6_ >> 12 & 255);
         break;
      case 2002:
         var33 = (double)p_28136_3_;
         var10 = (double)p_28136_4_;
         var12 = (double)p_28136_5_;
         var14 = "iconcrack_" + Item.field_40413_bs.field_291_aS;

         for(var15 = 0; var15 < 8; ++var15) {
            this.func_939_a(var14, var33, var10, var12, var7.nextGaussian() * 0.15D, var7.nextDouble() * 0.2D, var7.nextGaussian() * 0.15D);
         }

         var15 = Item.field_40413_bs.func_27010_f(p_28136_6_, 0);
         float var16 = (float)(var15 >> 16 & 255) / 255.0F;
         float var17 = (float)(var15 >> 8 & 255) / 255.0F;
         float var18 = (float)(var15 >> 0 & 255) / 255.0F;
         String var19 = "spell";
         if(Item.field_40413_bs.func_40432_e(p_28136_6_)) {
            var19 = "instantSpell";
         }

         for(int var20 = 0; var20 < 100; ++var20) {
            var21 = var7.nextDouble() * 4.0D;
            var23 = var7.nextDouble() * 3.141592653589793D * 2.0D;
            var25 = Math.cos(var23) * var21;
            var27 = 0.01D + var7.nextDouble() * 0.5D;
            var29 = Math.sin(var23) * var21;
            EntityFX var31 = this.func_40193_b(var19, var33 + var25 * 0.1D, var10 + 0.3D, var12 + var29 * 0.1D, var25, var27, var29);
            if(var31 != null) {
               float var32 = 0.75F + var7.nextFloat() * 0.25F;
               var31.func_40097_b(var16 * var32, var17 * var32, var18 * var32);
               var31.func_407_b((float)var21);
            }
         }

         this.field_1448_k.func_684_a((double)p_28136_3_ + 0.5D, (double)p_28136_4_ + 0.5D, (double)p_28136_5_ + 0.5D, "random.glass", 1.0F, this.field_1448_k.field_1037_n.nextFloat() * 0.1F + 0.9F);
         break;
      case 2003:
         var33 = (double)p_28136_3_ + 0.5D;
         var10 = (double)p_28136_4_;
         var12 = (double)p_28136_5_ + 0.5D;
         var14 = "iconcrack_" + Item.field_40420_bA.field_291_aS;

         for(var15 = 0; var15 < 8; ++var15) {
            this.func_939_a(var14, var33, var10, var12, var7.nextGaussian() * 0.15D, var7.nextDouble() * 0.2D, var7.nextGaussian() * 0.15D);
         }

         for(double var37 = 0.0D; var37 < 6.283185307179586D; var37 += 0.15707963267948966D) {
            this.func_939_a("portal", var33 + Math.cos(var37) * 5.0D, var10 - 0.4D, var12 + Math.sin(var37) * 5.0D, Math.cos(var37) * -5.0D, 0.0D, Math.sin(var37) * -5.0D);
            this.func_939_a("portal", var33 + Math.cos(var37) * 5.0D, var10 - 0.4D, var12 + Math.sin(var37) * 5.0D, Math.cos(var37) * -7.0D, 0.0D, Math.sin(var37) * -7.0D);
         }

         return;
      case 2004:
         for(var8 = 0; var8 < 20; ++var8) {
            double var9 = (double)p_28136_3_ + 0.5D + ((double)this.field_1448_k.field_1037_n.nextFloat() - 0.5D) * 2.0D;
            double var11 = (double)p_28136_4_ + 0.5D + ((double)this.field_1448_k.field_1037_n.nextFloat() - 0.5D) * 2.0D;
            double var13 = (double)p_28136_5_ + 0.5D + ((double)this.field_1448_k.field_1037_n.nextFloat() - 0.5D) * 2.0D;
            this.field_1448_k.func_694_a("smoke", var9, var11, var13, 0.0D, 0.0D, 0.0D);
            this.field_1448_k.func_694_a("flame", var9, var11, var13, 0.0D, 0.0D, 0.0D);
         }
      }

   }
}
