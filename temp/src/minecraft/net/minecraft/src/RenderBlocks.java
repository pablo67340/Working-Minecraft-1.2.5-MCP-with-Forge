package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.BlockBed;
import net.minecraft.src.BlockBrewingStand;
import net.minecraft.src.BlockCauldron;
import net.minecraft.src.BlockDirectional;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.BlockDragonEgg;
import net.minecraft.src.BlockEndPortalFrame;
import net.minecraft.src.BlockFence;
import net.minecraft.src.BlockFenceGate;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.BlockPane;
import net.minecraft.src.BlockPistonBase;
import net.minecraft.src.BlockPistonExtension;
import net.minecraft.src.BlockRail;
import net.minecraft.src.BlockRedstoneRepeater;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.BlockStem;
import net.minecraft.src.ChestItemRenderHelper;
import net.minecraft.src.Direction;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class RenderBlocks {

   public IBlockAccess field_1772_a;
   private int field_1771_b = -1;
   private boolean field_1774_c = false;
   private boolean field_1773_d = false;
   public static boolean field_27406_a = true;
   public boolean field_31088_b = true;
   private int field_31087_g = 0;
   private int field_31086_h = 0;
   private int field_31085_i = 0;
   private int field_31084_j = 0;
   private int field_31083_k = 0;
   private int field_31082_l = 0;
   private boolean field_22385_e;
   private float field_22384_f;
   private float field_22383_g;
   private float field_22382_h;
   private float field_22381_i;
   private float field_22380_j;
   private float field_22379_k;
   private float field_22378_l;
   private float field_22377_m;
   private float field_22376_n;
   private float field_22375_o;
   private float field_22374_p;
   private float field_22373_q;
   private float field_22372_r;
   private float field_22371_s;
   private float field_22370_t;
   private float field_22369_u;
   private float field_22368_v;
   private float field_22367_w;
   private float field_22366_x;
   private float field_22365_y;
   private float field_22364_z;
   private float field_22362_A;
   private float field_22360_B;
   private float field_22358_C;
   private float field_22356_D;
   private float field_22354_E;
   private float field_22353_F;
   private int field_35936_P;
   private int field_35935_Q;
   private int field_35938_R;
   private int field_35937_S;
   private int field_35932_T;
   private int field_35931_U;
   private int field_35934_V;
   private int field_35933_W;
   private int field_35940_X;
   private int field_35939_Y;
   private int field_35941_Z;
   private int field_35951_aa;
   private int field_35952_ab;
   private int field_35949_ac;
   private int field_35950_ad;
   private int field_35955_ae;
   private int field_35956_af;
   private int field_35953_ag;
   private int field_35954_ah;
   private int field_35945_ai;
   private int field_35946_aj = 1;
   private int field_35943_ak;
   private int field_35944_al;
   private int field_35947_am;
   private int field_35948_an;
   private float field_22351_H;
   private float field_22350_I;
   private float field_22349_J;
   private float field_22348_K;
   private float field_22347_L;
   private float field_22346_M;
   private float field_22345_N;
   private float field_22344_O;
   private float field_22343_P;
   private float field_22342_Q;
   private float field_22341_R;
   private float field_22340_S;
   private boolean field_22339_T;
   private boolean field_22338_U;
   private boolean field_22337_V;
   private boolean field_22336_W;
   private boolean field_22335_X;
   private boolean field_22334_Y;
   private boolean field_22333_Z;
   private boolean field_22363_aa;
   private boolean field_22361_ab;
   private boolean field_22359_ac;
   private boolean field_22357_ad;
   private boolean field_22355_ae;


   public RenderBlocks(IBlockAccess p_i647_1_) {
      this.field_1772_a = p_i647_1_;
   }

   public RenderBlocks() {}

   public void func_40727_a() {
      this.field_1771_b = -1;
   }

   public void func_1223_a(Block p_1223_1_, int p_1223_2_, int p_1223_3_, int p_1223_4_, int p_1223_5_) {
      this.field_1771_b = p_1223_5_;
      this.func_1234_a(p_1223_1_, p_1223_2_, p_1223_3_, p_1223_4_);
      this.field_1771_b = -1;
   }

   public void func_31075_a(Block p_31075_1_, int p_31075_2_, int p_31075_3_, int p_31075_4_) {
      this.field_1773_d = true;
      this.func_1234_a(p_31075_1_, p_31075_2_, p_31075_3_, p_31075_4_);
      this.field_1773_d = false;
   }

   public boolean func_1234_a(Block p_1234_1_, int p_1234_2_, int p_1234_3_, int p_1234_4_) {
      int var5 = p_1234_1_.func_210_f();
      p_1234_1_.func_238_a(this.field_1772_a, p_1234_2_, p_1234_3_, p_1234_4_);
      return var5 == 0?this.func_1228_k(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 4?this.func_1222_j(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 13?this.func_1233_l(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 1?this.func_1226_h(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 19?this.func_1232_i(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 23?this.func_40726_m(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 6?this.func_35930_l(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 2?this.func_1241_b(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 3?this.func_1235_d(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 5?this.func_1242_e(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 8?this.func_1221_g(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 7?this.func_1218_o(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 9?this.func_1216_f((BlockRail)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 10?this.func_1214_n(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 27?this.func_41088_a((BlockDragonEgg)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 11?this.func_35925_a((BlockFence)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 12?this.func_1229_c(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 14?this.func_22331_p(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 15?this.func_22332_q(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 16?this.func_31074_b(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_, false):(var5 == 17?this.func_31080_c(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_, true):(var5 == 18?this.func_35922_a((BlockPane)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 20?this.func_35929_i(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 21?this.func_35923_a((BlockFenceGate)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 24?this.func_40728_a((BlockCauldron)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 25?this.func_40730_a((BlockBrewingStand)p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):(var5 == 26?this.func_40729_s(p_1234_1_, p_1234_2_, p_1234_3_, p_1234_4_):false))))))))))))))))))))))))));
   }

   private boolean func_40729_s(Block p_40729_1_, int p_40729_2_, int p_40729_3_, int p_40729_4_) {
      int var5 = this.field_1772_a.func_602_e(p_40729_2_, p_40729_3_, p_40729_4_);
      int var6 = var5 & 3;
      if(var6 == 0) {
         this.field_31083_k = 3;
      } else if(var6 == 3) {
         this.field_31083_k = 1;
      } else if(var6 == 1) {
         this.field_31083_k = 2;
      }

      if(!BlockEndPortalFrame.func_40212_d(var5)) {
         p_40729_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
         this.func_1228_k(p_40729_1_, p_40729_2_, p_40729_3_, p_40729_4_);
         p_40729_1_.func_237_e();
         this.field_31083_k = 0;
         return true;
      } else {
         p_40729_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
         this.func_1228_k(p_40729_1_, p_40729_2_, p_40729_3_, p_40729_4_);
         this.field_1771_b = 174;
         p_40729_1_.func_213_a(0.25F, 0.8125F, 0.25F, 0.75F, 1.0F, 0.75F);
         this.func_1228_k(p_40729_1_, p_40729_2_, p_40729_3_, p_40729_4_);
         this.func_40727_a();
         p_40729_1_.func_237_e();
         this.field_31083_k = 0;
         return true;
      }
   }

   private boolean func_22331_p(Block p_22331_1_, int p_22331_2_, int p_22331_3_, int p_22331_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = this.field_1772_a.func_602_e(p_22331_2_, p_22331_3_, p_22331_4_);
      int var7 = BlockBed.func_48216_a(var6);
      boolean var8 = BlockBed.func_22032_d(var6);
      float var9 = 0.5F;
      float var10 = 1.0F;
      float var11 = 0.8F;
      float var12 = 0.6F;
      int var25 = p_22331_1_.func_35275_c(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_);
      var5.func_35835_b(var25);
      var5.func_987_a(var9, var9, var9);
      int var27 = p_22331_1_.func_211_a(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 0);
      int var28 = (var27 & 15) << 4;
      int var29 = var27 & 240;
      double var30 = (double)((float)var28 / 256.0F);
      double var32 = ((double)(var28 + 16) - 0.01D) / 256.0D;
      double var34 = (double)((float)var29 / 256.0F);
      double var36 = ((double)(var29 + 16) - 0.01D) / 256.0D;
      double var38 = (double)p_22331_2_ + p_22331_1_.field_370_bf;
      double var40 = (double)p_22331_2_ + p_22331_1_.field_364_bi;
      double var42 = (double)p_22331_3_ + p_22331_1_.field_368_bg + 0.1875D;
      double var44 = (double)p_22331_4_ + p_22331_1_.field_366_bh;
      double var46 = (double)p_22331_4_ + p_22331_1_.field_360_bk;
      var5.func_983_a(var38, var42, var46, var30, var36);
      var5.func_983_a(var38, var42, var44, var30, var34);
      var5.func_983_a(var40, var42, var44, var32, var34);
      var5.func_983_a(var40, var42, var46, var32, var36);
      var5.func_35835_b(p_22331_1_.func_35275_c(this.field_1772_a, p_22331_2_, p_22331_3_ + 1, p_22331_4_));
      var5.func_987_a(var10, var10, var10);
      var27 = p_22331_1_.func_211_a(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 1);
      var28 = (var27 & 15) << 4;
      var29 = var27 & 240;
      var30 = (double)((float)var28 / 256.0F);
      var32 = ((double)(var28 + 16) - 0.01D) / 256.0D;
      var34 = (double)((float)var29 / 256.0F);
      var36 = ((double)(var29 + 16) - 0.01D) / 256.0D;
      var38 = var30;
      var40 = var32;
      var42 = var34;
      var44 = var34;
      var46 = var30;
      double var48 = var32;
      double var50 = var36;
      double var52 = var36;
      if(var7 == 0) {
         var40 = var30;
         var42 = var36;
         var46 = var32;
         var52 = var34;
      } else if(var7 == 2) {
         var38 = var32;
         var44 = var36;
         var48 = var30;
         var50 = var34;
      } else if(var7 == 3) {
         var38 = var32;
         var44 = var36;
         var48 = var30;
         var50 = var34;
         var40 = var30;
         var42 = var36;
         var46 = var32;
         var52 = var34;
      }

      double var54 = (double)p_22331_2_ + p_22331_1_.field_370_bf;
      double var56 = (double)p_22331_2_ + p_22331_1_.field_364_bi;
      double var58 = (double)p_22331_3_ + p_22331_1_.field_362_bj;
      double var60 = (double)p_22331_4_ + p_22331_1_.field_366_bh;
      double var62 = (double)p_22331_4_ + p_22331_1_.field_360_bk;
      var5.func_983_a(var56, var58, var62, var46, var50);
      var5.func_983_a(var56, var58, var60, var38, var42);
      var5.func_983_a(var54, var58, var60, var40, var44);
      var5.func_983_a(var54, var58, var62, var48, var52);
      var27 = Direction.field_22280_a[var7];
      if(var8) {
         var27 = Direction.field_22280_a[Direction.field_22279_b[var7]];
      }

      byte var64 = 4;
      switch(var7) {
      case 0:
         var64 = 5;
         break;
      case 1:
         var64 = 3;
      case 2:
      default:
         break;
      case 3:
         var64 = 2;
      }

      if(var27 != 2 && (this.field_1773_d || p_22331_1_.func_260_c(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ - 1, 2))) {
         var5.func_35835_b(p_22331_1_.field_366_bh > 0.0D?var25:p_22331_1_.func_35275_c(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ - 1));
         var5.func_987_a(var11, var11, var11);
         this.field_1774_c = var64 == 2;
         this.func_1220_c(p_22331_1_, (double)p_22331_2_, (double)p_22331_3_, (double)p_22331_4_, p_22331_1_.func_211_a(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 2));
      }

      if(var27 != 3 && (this.field_1773_d || p_22331_1_.func_260_c(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ + 1, 3))) {
         var5.func_35835_b(p_22331_1_.field_360_bk < 1.0D?var25:p_22331_1_.func_35275_c(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_ + 1));
         var5.func_987_a(var11, var11, var11);
         this.field_1774_c = var64 == 3;
         this.func_1225_d(p_22331_1_, (double)p_22331_2_, (double)p_22331_3_, (double)p_22331_4_, p_22331_1_.func_211_a(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 3));
      }

      if(var27 != 4 && (this.field_1773_d || p_22331_1_.func_260_c(this.field_1772_a, p_22331_2_ - 1, p_22331_3_, p_22331_4_, 4))) {
         var5.func_35835_b(p_22331_1_.field_366_bh > 0.0D?var25:p_22331_1_.func_35275_c(this.field_1772_a, p_22331_2_ - 1, p_22331_3_, p_22331_4_));
         var5.func_987_a(var12, var12, var12);
         this.field_1774_c = var64 == 4;
         this.func_1231_e(p_22331_1_, (double)p_22331_2_, (double)p_22331_3_, (double)p_22331_4_, p_22331_1_.func_211_a(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 4));
      }

      if(var27 != 5 && (this.field_1773_d || p_22331_1_.func_260_c(this.field_1772_a, p_22331_2_ + 1, p_22331_3_, p_22331_4_, 5))) {
         var5.func_35835_b(p_22331_1_.field_360_bk < 1.0D?var25:p_22331_1_.func_35275_c(this.field_1772_a, p_22331_2_ + 1, p_22331_3_, p_22331_4_));
         var5.func_987_a(var12, var12, var12);
         this.field_1774_c = var64 == 5;
         this.func_1236_f(p_22331_1_, (double)p_22331_2_, (double)p_22331_3_, (double)p_22331_4_, p_22331_1_.func_211_a(this.field_1772_a, p_22331_2_, p_22331_3_, p_22331_4_, 5));
      }

      this.field_1774_c = false;
      return true;
   }

   private boolean func_40730_a(BlockBrewingStand p_40730_1_, int p_40730_2_, int p_40730_3_, int p_40730_4_) {
      p_40730_1_.func_213_a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      this.func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
      this.field_1771_b = 156;
      p_40730_1_.func_213_a(0.5625F, 0.0F, 0.3125F, 0.9375F, 0.125F, 0.6875F);
      this.func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
      p_40730_1_.func_213_a(0.125F, 0.0F, 0.0625F, 0.5F, 0.125F, 0.4375F);
      this.func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
      p_40730_1_.func_213_a(0.125F, 0.0F, 0.5625F, 0.5F, 0.125F, 0.9375F);
      this.func_1228_k(p_40730_1_, p_40730_2_, p_40730_3_, p_40730_4_);
      this.func_40727_a();
      Tessellator var5 = Tessellator.field_1512_a;
      var5.func_35835_b(p_40730_1_.func_35275_c(this.field_1772_a, p_40730_2_, p_40730_3_, p_40730_4_));
      float var6 = 1.0F;
      int var7 = p_40730_1_.func_207_d(this.field_1772_a, p_40730_2_, p_40730_3_, p_40730_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_28135_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_987_a(var6 * var8, var6 * var9, var6 * var10);
      int var34 = p_40730_1_.func_232_a(0, 0);
      if(this.field_1771_b >= 0) {
         var34 = this.field_1771_b;
      }

      int var35 = (var34 & 15) << 4;
      int var36 = var34 & 240;
      double var14 = (double)((float)var36 / 256.0F);
      double var16 = (double)(((float)var36 + 15.99F) / 256.0F);
      int var18 = this.field_1772_a.func_602_e(p_40730_2_, p_40730_3_, p_40730_4_);

      for(int var19 = 0; var19 < 3; ++var19) {
         double var20 = (double)var19 * 3.141592653589793D * 2.0D / 3.0D + 1.5707963267948966D;
         double var22 = (double)(((float)var35 + 8.0F) / 256.0F);
         double var24 = (double)(((float)var35 + 15.99F) / 256.0F);
         if((var18 & 1 << var19) != 0) {
            var22 = (double)(((float)var35 + 7.99F) / 256.0F);
            var24 = (double)(((float)var35 + 0.0F) / 256.0F);
         }

         double var26 = (double)p_40730_2_ + 0.5D;
         double var28 = (double)p_40730_2_ + 0.5D + Math.sin(var20) * 8.0D / 16.0D;
         double var30 = (double)p_40730_4_ + 0.5D;
         double var32 = (double)p_40730_4_ + 0.5D + Math.cos(var20) * 8.0D / 16.0D;
         var5.func_983_a(var26, (double)(p_40730_3_ + 1), var30, var22, var14);
         var5.func_983_a(var26, (double)(p_40730_3_ + 0), var30, var22, var16);
         var5.func_983_a(var28, (double)(p_40730_3_ + 0), var32, var24, var16);
         var5.func_983_a(var28, (double)(p_40730_3_ + 1), var32, var24, var14);
         var5.func_983_a(var28, (double)(p_40730_3_ + 1), var32, var24, var14);
         var5.func_983_a(var28, (double)(p_40730_3_ + 0), var32, var24, var16);
         var5.func_983_a(var26, (double)(p_40730_3_ + 0), var30, var22, var16);
         var5.func_983_a(var26, (double)(p_40730_3_ + 1), var30, var22, var14);
      }

      p_40730_1_.func_237_e();
      return true;
   }

   private boolean func_40728_a(BlockCauldron p_40728_1_, int p_40728_2_, int p_40728_3_, int p_40728_4_) {
      this.func_1228_k(p_40728_1_, p_40728_2_, p_40728_3_, p_40728_4_);
      Tessellator var5 = Tessellator.field_1512_a;
      var5.func_35835_b(p_40728_1_.func_35275_c(this.field_1772_a, p_40728_2_, p_40728_3_, p_40728_4_));
      float var6 = 1.0F;
      int var7 = p_40728_1_.func_207_d(this.field_1772_a, p_40728_2_, p_40728_3_, p_40728_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      float var12;
      if(EntityRenderer.field_28135_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_987_a(var6 * var8, var6 * var9, var6 * var10);
      short var16 = 154;
      var12 = 0.125F;
      this.func_1236_f(p_40728_1_, (double)((float)p_40728_2_ - 1.0F + var12), (double)p_40728_3_, (double)p_40728_4_, var16);
      this.func_1231_e(p_40728_1_, (double)((float)p_40728_2_ + 1.0F - var12), (double)p_40728_3_, (double)p_40728_4_, var16);
      this.func_1225_d(p_40728_1_, (double)p_40728_2_, (double)p_40728_3_, (double)((float)p_40728_4_ - 1.0F + var12), var16);
      this.func_1220_c(p_40728_1_, (double)p_40728_2_, (double)p_40728_3_, (double)((float)p_40728_4_ + 1.0F - var12), var16);
      short var17 = 139;
      this.func_1217_b(p_40728_1_, (double)p_40728_2_, (double)((float)p_40728_3_ - 1.0F + 0.25F), (double)p_40728_4_, var17);
      this.func_1244_a(p_40728_1_, (double)p_40728_2_, (double)((float)p_40728_3_ + 1.0F - 0.75F), (double)p_40728_4_, var17);
      int var14 = this.field_1772_a.func_602_e(p_40728_2_, p_40728_3_, p_40728_4_);
      if(var14 > 0) {
         short var15 = 205;
         if(var14 > 3) {
            var14 = 3;
         }

         this.func_1217_b(p_40728_1_, (double)p_40728_2_, (double)((float)p_40728_3_ - 1.0F + (6.0F + (float)var14 * 3.0F) / 16.0F), (double)p_40728_4_, var15);
      }

      return true;
   }

   public boolean func_1241_b(Block p_1241_1_, int p_1241_2_, int p_1241_3_, int p_1241_4_) {
      int var5 = this.field_1772_a.func_602_e(p_1241_2_, p_1241_3_, p_1241_4_);
      Tessellator var6 = Tessellator.field_1512_a;
      var6.func_35835_b(p_1241_1_.func_35275_c(this.field_1772_a, p_1241_2_, p_1241_3_, p_1241_4_));
      var6.func_987_a(1.0F, 1.0F, 1.0F);
      double var7 = 0.4000000059604645D;
      double var9 = 0.5D - var7;
      double var11 = 0.20000000298023224D;
      if(var5 == 1) {
         this.func_1237_a(p_1241_1_, (double)p_1241_2_ - var9, (double)p_1241_3_ + var11, (double)p_1241_4_, -var7, 0.0D);
      } else if(var5 == 2) {
         this.func_1237_a(p_1241_1_, (double)p_1241_2_ + var9, (double)p_1241_3_ + var11, (double)p_1241_4_, var7, 0.0D);
      } else if(var5 == 3) {
         this.func_1237_a(p_1241_1_, (double)p_1241_2_, (double)p_1241_3_ + var11, (double)p_1241_4_ - var9, 0.0D, -var7);
      } else if(var5 == 4) {
         this.func_1237_a(p_1241_1_, (double)p_1241_2_, (double)p_1241_3_ + var11, (double)p_1241_4_ + var9, 0.0D, var7);
      } else {
         this.func_1237_a(p_1241_1_, (double)p_1241_2_, (double)p_1241_3_, (double)p_1241_4_, 0.0D, 0.0D);
      }

      return true;
   }

   private boolean func_22332_q(Block p_22332_1_, int p_22332_2_, int p_22332_3_, int p_22332_4_) {
      int var5 = this.field_1772_a.func_602_e(p_22332_2_, p_22332_3_, p_22332_4_);
      int var6 = var5 & 3;
      int var7 = (var5 & 12) >> 2;
      this.func_1228_k(p_22332_1_, p_22332_2_, p_22332_3_, p_22332_4_);
      Tessellator var8 = Tessellator.field_1512_a;
      var8.func_35835_b(p_22332_1_.func_35275_c(this.field_1772_a, p_22332_2_, p_22332_3_, p_22332_4_));
      var8.func_987_a(1.0F, 1.0F, 1.0F);
      double var9 = -0.1875D;
      double var11 = 0.0D;
      double var13 = 0.0D;
      double var15 = 0.0D;
      double var17 = 0.0D;
      switch(var6) {
      case 0:
         var17 = -0.3125D;
         var13 = BlockRedstoneRepeater.field_22024_a[var7];
         break;
      case 1:
         var15 = 0.3125D;
         var11 = -BlockRedstoneRepeater.field_22024_a[var7];
         break;
      case 2:
         var17 = 0.3125D;
         var13 = -BlockRedstoneRepeater.field_22024_a[var7];
         break;
      case 3:
         var15 = -0.3125D;
         var11 = BlockRedstoneRepeater.field_22024_a[var7];
      }

      this.func_1237_a(p_22332_1_, (double)p_22332_2_ + var11, (double)p_22332_3_ + var9, (double)p_22332_4_ + var13, 0.0D, 0.0D);
      this.func_1237_a(p_22332_1_, (double)p_22332_2_ + var15, (double)p_22332_3_ + var9, (double)p_22332_4_ + var17, 0.0D, 0.0D);
      int var19 = p_22332_1_.func_218_a(1);
      int var20 = (var19 & 15) << 4;
      int var21 = var19 & 240;
      double var22 = (double)((float)var20 / 256.0F);
      double var24 = (double)(((float)var20 + 15.99F) / 256.0F);
      double var26 = (double)((float)var21 / 256.0F);
      double var28 = (double)(((float)var21 + 15.99F) / 256.0F);
      double var30 = 0.125D;
      double var32 = (double)(p_22332_2_ + 1);
      double var34 = (double)(p_22332_2_ + 1);
      double var36 = (double)(p_22332_2_ + 0);
      double var38 = (double)(p_22332_2_ + 0);
      double var40 = (double)(p_22332_4_ + 0);
      double var42 = (double)(p_22332_4_ + 1);
      double var44 = (double)(p_22332_4_ + 1);
      double var46 = (double)(p_22332_4_ + 0);
      double var48 = (double)p_22332_3_ + var30;
      if(var6 == 2) {
         var32 = var34 = (double)(p_22332_2_ + 0);
         var36 = var38 = (double)(p_22332_2_ + 1);
         var40 = var46 = (double)(p_22332_4_ + 1);
         var42 = var44 = (double)(p_22332_4_ + 0);
      } else if(var6 == 3) {
         var32 = var38 = (double)(p_22332_2_ + 0);
         var34 = var36 = (double)(p_22332_2_ + 1);
         var40 = var42 = (double)(p_22332_4_ + 0);
         var44 = var46 = (double)(p_22332_4_ + 1);
      } else if(var6 == 1) {
         var32 = var38 = (double)(p_22332_2_ + 1);
         var34 = var36 = (double)(p_22332_2_ + 0);
         var40 = var42 = (double)(p_22332_4_ + 1);
         var44 = var46 = (double)(p_22332_4_ + 0);
      }

      var8.func_983_a(var38, var48, var46, var22, var26);
      var8.func_983_a(var36, var48, var44, var22, var28);
      var8.func_983_a(var34, var48, var42, var24, var28);
      var8.func_983_a(var32, var48, var40, var24, var26);
      return true;
   }

   public void func_31078_d(Block p_31078_1_, int p_31078_2_, int p_31078_3_, int p_31078_4_) {
      this.field_1773_d = true;
      this.func_31074_b(p_31078_1_, p_31078_2_, p_31078_3_, p_31078_4_, true);
      this.field_1773_d = false;
   }

   private boolean func_31074_b(Block p_31074_1_, int p_31074_2_, int p_31074_3_, int p_31074_4_, boolean p_31074_5_) {
      int var6 = this.field_1772_a.func_602_e(p_31074_2_, p_31074_3_, p_31074_4_);
      boolean var7 = p_31074_5_ || (var6 & 8) != 0;
      int var8 = BlockPistonBase.func_31044_d(var6);
      if(var7) {
         switch(var8) {
         case 0:
            this.field_31087_g = 3;
            this.field_31086_h = 3;
            this.field_31085_i = 3;
            this.field_31084_j = 3;
            p_31074_1_.func_213_a(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 1:
            p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
            break;
         case 2:
            this.field_31085_i = 1;
            this.field_31084_j = 2;
            p_31074_1_.func_213_a(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
            break;
         case 3:
            this.field_31085_i = 2;
            this.field_31084_j = 1;
            this.field_31083_k = 3;
            this.field_31082_l = 3;
            p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
            break;
         case 4:
            this.field_31087_g = 1;
            this.field_31086_h = 2;
            this.field_31083_k = 2;
            this.field_31082_l = 1;
            p_31074_1_.func_213_a(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 5:
            this.field_31087_g = 2;
            this.field_31086_h = 1;
            this.field_31083_k = 1;
            this.field_31082_l = 2;
            p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
         }

         this.func_1228_k(p_31074_1_, p_31074_2_, p_31074_3_, p_31074_4_);
         this.field_31087_g = 0;
         this.field_31086_h = 0;
         this.field_31085_i = 0;
         this.field_31084_j = 0;
         this.field_31083_k = 0;
         this.field_31082_l = 0;
         p_31074_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         switch(var8) {
         case 0:
            this.field_31087_g = 3;
            this.field_31086_h = 3;
            this.field_31085_i = 3;
            this.field_31084_j = 3;
         case 1:
         default:
            break;
         case 2:
            this.field_31085_i = 1;
            this.field_31084_j = 2;
            break;
         case 3:
            this.field_31085_i = 2;
            this.field_31084_j = 1;
            this.field_31083_k = 3;
            this.field_31082_l = 3;
            break;
         case 4:
            this.field_31087_g = 1;
            this.field_31086_h = 2;
            this.field_31083_k = 2;
            this.field_31082_l = 1;
            break;
         case 5:
            this.field_31087_g = 2;
            this.field_31086_h = 1;
            this.field_31083_k = 1;
            this.field_31082_l = 2;
         }

         this.func_1228_k(p_31074_1_, p_31074_2_, p_31074_3_, p_31074_4_);
         this.field_31087_g = 0;
         this.field_31086_h = 0;
         this.field_31085_i = 0;
         this.field_31084_j = 0;
         this.field_31083_k = 0;
         this.field_31082_l = 0;
      }

      return true;
   }

   private void func_31076_a(double p_31076_1_, double p_31076_3_, double p_31076_5_, double p_31076_7_, double p_31076_9_, double p_31076_11_, float p_31076_13_, double p_31076_14_) {
      int var16 = 108;
      if(this.field_1771_b >= 0) {
         var16 = this.field_1771_b;
      }

      int var17 = (var16 & 15) << 4;
      int var18 = var16 & 240;
      Tessellator var19 = Tessellator.field_1512_a;
      double var20 = (double)((float)(var17 + 0) / 256.0F);
      double var22 = (double)((float)(var18 + 0) / 256.0F);
      double var24 = ((double)var17 + p_31076_14_ - 0.01D) / 256.0D;
      double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
      var19.func_987_a(p_31076_13_, p_31076_13_, p_31076_13_);
      var19.func_983_a(p_31076_1_, p_31076_7_, p_31076_9_, var24, var22);
      var19.func_983_a(p_31076_1_, p_31076_5_, p_31076_9_, var20, var22);
      var19.func_983_a(p_31076_3_, p_31076_5_, p_31076_11_, var20, var26);
      var19.func_983_a(p_31076_3_, p_31076_7_, p_31076_11_, var24, var26);
   }

   private void func_31081_b(double p_31081_1_, double p_31081_3_, double p_31081_5_, double p_31081_7_, double p_31081_9_, double p_31081_11_, float p_31081_13_, double p_31081_14_) {
      int var16 = 108;
      if(this.field_1771_b >= 0) {
         var16 = this.field_1771_b;
      }

      int var17 = (var16 & 15) << 4;
      int var18 = var16 & 240;
      Tessellator var19 = Tessellator.field_1512_a;
      double var20 = (double)((float)(var17 + 0) / 256.0F);
      double var22 = (double)((float)(var18 + 0) / 256.0F);
      double var24 = ((double)var17 + p_31081_14_ - 0.01D) / 256.0D;
      double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
      var19.func_987_a(p_31081_13_, p_31081_13_, p_31081_13_);
      var19.func_983_a(p_31081_1_, p_31081_5_, p_31081_11_, var24, var22);
      var19.func_983_a(p_31081_1_, p_31081_5_, p_31081_9_, var20, var22);
      var19.func_983_a(p_31081_3_, p_31081_7_, p_31081_9_, var20, var26);
      var19.func_983_a(p_31081_3_, p_31081_7_, p_31081_11_, var24, var26);
   }

   private void func_31077_c(double p_31077_1_, double p_31077_3_, double p_31077_5_, double p_31077_7_, double p_31077_9_, double p_31077_11_, float p_31077_13_, double p_31077_14_) {
      int var16 = 108;
      if(this.field_1771_b >= 0) {
         var16 = this.field_1771_b;
      }

      int var17 = (var16 & 15) << 4;
      int var18 = var16 & 240;
      Tessellator var19 = Tessellator.field_1512_a;
      double var20 = (double)((float)(var17 + 0) / 256.0F);
      double var22 = (double)((float)(var18 + 0) / 256.0F);
      double var24 = ((double)var17 + p_31077_14_ - 0.01D) / 256.0D;
      double var26 = ((double)((float)var18 + 4.0F) - 0.01D) / 256.0D;
      var19.func_987_a(p_31077_13_, p_31077_13_, p_31077_13_);
      var19.func_983_a(p_31077_3_, p_31077_5_, p_31077_9_, var24, var22);
      var19.func_983_a(p_31077_1_, p_31077_5_, p_31077_9_, var20, var22);
      var19.func_983_a(p_31077_1_, p_31077_7_, p_31077_11_, var20, var26);
      var19.func_983_a(p_31077_3_, p_31077_7_, p_31077_11_, var24, var26);
   }

   public void func_31079_a(Block p_31079_1_, int p_31079_2_, int p_31079_3_, int p_31079_4_, boolean p_31079_5_) {
      this.field_1773_d = true;
      this.func_31080_c(p_31079_1_, p_31079_2_, p_31079_3_, p_31079_4_, p_31079_5_);
      this.field_1773_d = false;
   }

   private boolean func_31080_c(Block p_31080_1_, int p_31080_2_, int p_31080_3_, int p_31080_4_, boolean p_31080_5_) {
      int var6 = this.field_1772_a.func_602_e(p_31080_2_, p_31080_3_, p_31080_4_);
      int var7 = BlockPistonExtension.func_31050_c(var6);
      float var11 = p_31080_1_.func_241_c(this.field_1772_a, p_31080_2_, p_31080_3_, p_31080_4_);
      float var12 = p_31080_5_?1.0F:0.5F;
      double var13 = p_31080_5_?16.0D:8.0D;
      switch(var7) {
      case 0:
         this.field_31087_g = 3;
         this.field_31086_h = 3;
         this.field_31085_i = 3;
         this.field_31084_j = 3;
         p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
         this.func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
         this.func_31076_a((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ + 0.25F), (double)((float)p_31080_3_ + 0.25F + var12), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.625F), var11 * 0.8F, var13);
         this.func_31076_a((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ + 0.25F), (double)((float)p_31080_3_ + 0.25F + var12), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.8F, var13);
         this.func_31076_a((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ + 0.25F), (double)((float)p_31080_3_ + 0.25F + var12), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), var11 * 0.6F, var13);
         this.func_31076_a((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ + 0.25F), (double)((float)p_31080_3_ + 0.25F + var12), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.6F, var13);
         break;
      case 1:
         p_31080_1_.func_213_a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
         this.func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
         this.func_31076_a((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ - 0.25F + 1.0F - var12), (double)((float)p_31080_3_ - 0.25F + 1.0F), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.625F), var11 * 0.8F, var13);
         this.func_31076_a((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ - 0.25F + 1.0F - var12), (double)((float)p_31080_3_ - 0.25F + 1.0F), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.8F, var13);
         this.func_31076_a((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ - 0.25F + 1.0F - var12), (double)((float)p_31080_3_ - 0.25F + 1.0F), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), var11 * 0.6F, var13);
         this.func_31076_a((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ - 0.25F + 1.0F - var12), (double)((float)p_31080_3_ - 0.25F + 1.0F), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.6F, var13);
         break;
      case 2:
         this.field_31085_i = 1;
         this.field_31084_j = 2;
         p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
         this.func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
         this.func_31081_b((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ + 0.25F), (double)((float)p_31080_4_ + 0.25F + var12), var11 * 0.6F, var13);
         this.func_31081_b((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ + 0.25F), (double)((float)p_31080_4_ + 0.25F + var12), var11 * 0.6F, var13);
         this.func_31081_b((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ + 0.25F), (double)((float)p_31080_4_ + 0.25F + var12), var11 * 0.5F, var13);
         this.func_31081_b((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ + 0.25F), (double)((float)p_31080_4_ + 0.25F + var12), var11, var13);
         break;
      case 3:
         this.field_31085_i = 2;
         this.field_31084_j = 1;
         this.field_31083_k = 3;
         this.field_31082_l = 3;
         p_31080_1_.func_213_a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
         this.func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
         this.func_31081_b((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ - 0.25F + 1.0F - var12), (double)((float)p_31080_4_ - 0.25F + 1.0F), var11 * 0.6F, var13);
         this.func_31081_b((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ - 0.25F + 1.0F - var12), (double)((float)p_31080_4_ - 0.25F + 1.0F), var11 * 0.6F, var13);
         this.func_31081_b((double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ - 0.25F + 1.0F - var12), (double)((float)p_31080_4_ - 0.25F + 1.0F), var11 * 0.5F, var13);
         this.func_31081_b((double)((float)p_31080_2_ + 0.625F), (double)((float)p_31080_2_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ - 0.25F + 1.0F - var12), (double)((float)p_31080_4_ - 0.25F + 1.0F), var11, var13);
         break;
      case 4:
         this.field_31087_g = 1;
         this.field_31086_h = 2;
         this.field_31083_k = 2;
         this.field_31082_l = 1;
         p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
         this.func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
         this.func_31077_c((double)((float)p_31080_2_ + 0.25F), (double)((float)p_31080_2_ + 0.25F + var12), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.5F, var13);
         this.func_31077_c((double)((float)p_31080_2_ + 0.25F), (double)((float)p_31080_2_ + 0.25F + var12), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), var11, var13);
         this.func_31077_c((double)((float)p_31080_2_ + 0.25F), (double)((float)p_31080_2_ + 0.25F + var12), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.6F, var13);
         this.func_31077_c((double)((float)p_31080_2_ + 0.25F), (double)((float)p_31080_2_ + 0.25F + var12), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.625F), var11 * 0.6F, var13);
         break;
      case 5:
         this.field_31087_g = 2;
         this.field_31086_h = 1;
         this.field_31083_k = 1;
         this.field_31082_l = 2;
         p_31080_1_.func_213_a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         this.func_1228_k(p_31080_1_, p_31080_2_, p_31080_3_, p_31080_4_);
         this.func_31077_c((double)((float)p_31080_2_ - 0.25F + 1.0F - var12), (double)((float)p_31080_2_ - 0.25F + 1.0F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.5F, var13);
         this.func_31077_c((double)((float)p_31080_2_ - 0.25F + 1.0F - var12), (double)((float)p_31080_2_ - 0.25F + 1.0F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), var11, var13);
         this.func_31077_c((double)((float)p_31080_2_ - 0.25F + 1.0F - var12), (double)((float)p_31080_2_ - 0.25F + 1.0F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_4_ + 0.375F), (double)((float)p_31080_4_ + 0.375F), var11 * 0.6F, var13);
         this.func_31077_c((double)((float)p_31080_2_ - 0.25F + 1.0F - var12), (double)((float)p_31080_2_ - 0.25F + 1.0F), (double)((float)p_31080_3_ + 0.625F), (double)((float)p_31080_3_ + 0.375F), (double)((float)p_31080_4_ + 0.625F), (double)((float)p_31080_4_ + 0.625F), var11 * 0.6F, var13);
      }

      this.field_31087_g = 0;
      this.field_31086_h = 0;
      this.field_31085_i = 0;
      this.field_31084_j = 0;
      this.field_31083_k = 0;
      this.field_31082_l = 0;
      p_31080_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return true;
   }

   public boolean func_1229_c(Block p_1229_1_, int p_1229_2_, int p_1229_3_, int p_1229_4_) {
      int var5 = this.field_1772_a.func_602_e(p_1229_2_, p_1229_3_, p_1229_4_);
      int var6 = var5 & 7;
      boolean var7 = (var5 & 8) > 0;
      Tessellator var8 = Tessellator.field_1512_a;
      boolean var9 = this.field_1771_b >= 0;
      if(!var9) {
         this.field_1771_b = Block.field_335_x.field_378_bb;
      }

      float var10 = 0.25F;
      float var11 = 0.1875F;
      float var12 = 0.1875F;
      if(var6 == 5) {
         p_1229_1_.func_213_a(0.5F - var11, 0.0F, 0.5F - var10, 0.5F + var11, var12, 0.5F + var10);
      } else if(var6 == 6) {
         p_1229_1_.func_213_a(0.5F - var10, 0.0F, 0.5F - var11, 0.5F + var10, var12, 0.5F + var11);
      } else if(var6 == 4) {
         p_1229_1_.func_213_a(0.5F - var11, 0.5F - var10, 1.0F - var12, 0.5F + var11, 0.5F + var10, 1.0F);
      } else if(var6 == 3) {
         p_1229_1_.func_213_a(0.5F - var11, 0.5F - var10, 0.0F, 0.5F + var11, 0.5F + var10, var12);
      } else if(var6 == 2) {
         p_1229_1_.func_213_a(1.0F - var12, 0.5F - var10, 0.5F - var11, 1.0F, 0.5F + var10, 0.5F + var11);
      } else if(var6 == 1) {
         p_1229_1_.func_213_a(0.0F, 0.5F - var10, 0.5F - var11, var12, 0.5F + var10, 0.5F + var11);
      }

      this.func_1228_k(p_1229_1_, p_1229_2_, p_1229_3_, p_1229_4_);
      if(!var9) {
         this.field_1771_b = -1;
      }

      var8.func_35835_b(p_1229_1_.func_35275_c(this.field_1772_a, p_1229_2_, p_1229_3_, p_1229_4_));
      float var13 = 1.0F;
      if(Block.field_339_t[p_1229_1_.field_376_bc] > 0) {
         var13 = 1.0F;
      }

      var8.func_987_a(var13, var13, var13);
      int var14 = p_1229_1_.func_218_a(0);
      if(this.field_1771_b >= 0) {
         var14 = this.field_1771_b;
      }

      int var15 = (var14 & 15) << 4;
      int var16 = var14 & 240;
      float var17 = (float)var15 / 256.0F;
      float var18 = ((float)var15 + 15.99F) / 256.0F;
      float var19 = (float)var16 / 256.0F;
      float var20 = ((float)var16 + 15.99F) / 256.0F;
      Vec3D[] var21 = new Vec3D[8];
      float var22 = 0.0625F;
      float var23 = 0.0625F;
      float var24 = 0.625F;
      var21[0] = Vec3D.func_1248_b((double)(-var22), 0.0D, (double)(-var23));
      var21[1] = Vec3D.func_1248_b((double)var22, 0.0D, (double)(-var23));
      var21[2] = Vec3D.func_1248_b((double)var22, 0.0D, (double)var23);
      var21[3] = Vec3D.func_1248_b((double)(-var22), 0.0D, (double)var23);
      var21[4] = Vec3D.func_1248_b((double)(-var22), (double)var24, (double)(-var23));
      var21[5] = Vec3D.func_1248_b((double)var22, (double)var24, (double)(-var23));
      var21[6] = Vec3D.func_1248_b((double)var22, (double)var24, (double)var23);
      var21[7] = Vec3D.func_1248_b((double)(-var22), (double)var24, (double)var23);

      for(int var25 = 0; var25 < 8; ++var25) {
         if(var7) {
            var21[var25].field_1779_c -= 0.0625D;
            var21[var25].func_1258_a(0.69813174F);
         } else {
            var21[var25].field_1779_c += 0.0625D;
            var21[var25].func_1258_a(-0.69813174F);
         }

         if(var6 == 6) {
            var21[var25].func_1249_b(1.5707964F);
         }

         if(var6 < 5) {
            var21[var25].field_1775_b -= 0.375D;
            var21[var25].func_1258_a(1.5707964F);
            if(var6 == 4) {
               var21[var25].func_1249_b(0.0F);
            }

            if(var6 == 3) {
               var21[var25].func_1249_b(3.1415927F);
            }

            if(var6 == 2) {
               var21[var25].func_1249_b(1.5707964F);
            }

            if(var6 == 1) {
               var21[var25].func_1249_b(-1.5707964F);
            }

            var21[var25].field_1776_a += (double)p_1229_2_ + 0.5D;
            var21[var25].field_1775_b += (double)((float)p_1229_3_ + 0.5F);
            var21[var25].field_1779_c += (double)p_1229_4_ + 0.5D;
         } else {
            var21[var25].field_1776_a += (double)p_1229_2_ + 0.5D;
            var21[var25].field_1775_b += (double)((float)p_1229_3_ + 0.125F);
            var21[var25].field_1779_c += (double)p_1229_4_ + 0.5D;
         }
      }

      Vec3D var30 = null;
      Vec3D var26 = null;
      Vec3D var27 = null;
      Vec3D var28 = null;

      for(int var29 = 0; var29 < 6; ++var29) {
         if(var29 == 0) {
            var17 = (float)(var15 + 7) / 256.0F;
            var18 = ((float)(var15 + 9) - 0.01F) / 256.0F;
            var19 = (float)(var16 + 6) / 256.0F;
            var20 = ((float)(var16 + 8) - 0.01F) / 256.0F;
         } else if(var29 == 2) {
            var17 = (float)(var15 + 7) / 256.0F;
            var18 = ((float)(var15 + 9) - 0.01F) / 256.0F;
            var19 = (float)(var16 + 6) / 256.0F;
            var20 = ((float)(var16 + 16) - 0.01F) / 256.0F;
         }

         if(var29 == 0) {
            var30 = var21[0];
            var26 = var21[1];
            var27 = var21[2];
            var28 = var21[3];
         } else if(var29 == 1) {
            var30 = var21[7];
            var26 = var21[6];
            var27 = var21[5];
            var28 = var21[4];
         } else if(var29 == 2) {
            var30 = var21[1];
            var26 = var21[0];
            var27 = var21[4];
            var28 = var21[5];
         } else if(var29 == 3) {
            var30 = var21[2];
            var26 = var21[1];
            var27 = var21[5];
            var28 = var21[6];
         } else if(var29 == 4) {
            var30 = var21[3];
            var26 = var21[2];
            var27 = var21[6];
            var28 = var21[7];
         } else if(var29 == 5) {
            var30 = var21[0];
            var26 = var21[3];
            var27 = var21[7];
            var28 = var21[4];
         }

         var8.func_983_a(var30.field_1776_a, var30.field_1775_b, var30.field_1779_c, (double)var17, (double)var20);
         var8.func_983_a(var26.field_1776_a, var26.field_1775_b, var26.field_1779_c, (double)var18, (double)var20);
         var8.func_983_a(var27.field_1776_a, var27.field_1775_b, var27.field_1779_c, (double)var18, (double)var19);
         var8.func_983_a(var28.field_1776_a, var28.field_1775_b, var28.field_1779_c, (double)var17, (double)var19);
      }

      return true;
   }

   public boolean func_1235_d(Block p_1235_1_, int p_1235_2_, int p_1235_3_, int p_1235_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = p_1235_1_.func_218_a(0);
      if(this.field_1771_b >= 0) {
         var6 = this.field_1771_b;
      }

      var5.func_987_a(1.0F, 1.0F, 1.0F);
      var5.func_35835_b(p_1235_1_.func_35275_c(this.field_1772_a, p_1235_2_, p_1235_3_, p_1235_4_));
      int var7 = (var6 & 15) << 4;
      int var8 = var6 & 240;
      double var9 = (double)((float)var7 / 256.0F);
      double var11 = (double)(((float)var7 + 15.99F) / 256.0F);
      double var13 = (double)((float)var8 / 256.0F);
      double var15 = (double)(((float)var8 + 15.99F) / 256.0F);
      float var17 = 1.4F;
      double var20;
      double var22;
      double var24;
      double var26;
      double var28;
      double var30;
      double var32;
      if(!this.field_1772_a.func_28100_h(p_1235_2_, p_1235_3_ - 1, p_1235_4_) && !Block.field_402_as.func_261_b(this.field_1772_a, p_1235_2_, p_1235_3_ - 1, p_1235_4_)) {
         float var36 = 0.2F;
         float var19 = 0.0625F;
         if((p_1235_2_ + p_1235_3_ + p_1235_4_ & 1) == 1) {
            var9 = (double)((float)var7 / 256.0F);
            var11 = (double)(((float)var7 + 15.99F) / 256.0F);
            var13 = (double)((float)(var8 + 16) / 256.0F);
            var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
         }

         if((p_1235_2_ / 2 + p_1235_3_ / 2 + p_1235_4_ / 2 & 1) == 1) {
            var20 = var11;
            var11 = var9;
            var9 = var20;
         }

         if(Block.field_402_as.func_261_b(this.field_1772_a, p_1235_2_ - 1, p_1235_3_, p_1235_4_)) {
            var5.func_983_a((double)((float)p_1235_2_ + var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 1), var11, var13);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1), var11, var15);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var9, var15);
            var5.func_983_a((double)((float)p_1235_2_ + var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 0), var9, var13);
            var5.func_983_a((double)((float)p_1235_2_ + var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 0), var9, var13);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var9, var15);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1), var11, var15);
            var5.func_983_a((double)((float)p_1235_2_ + var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 1), var11, var13);
         }

         if(Block.field_402_as.func_261_b(this.field_1772_a, p_1235_2_ + 1, p_1235_3_, p_1235_4_)) {
            var5.func_983_a((double)((float)(p_1235_2_ + 1) - var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 0), var9, var13);
            var5.func_983_a((double)(p_1235_2_ + 1 - 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var9, var15);
            var5.func_983_a((double)(p_1235_2_ + 1 - 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1), var11, var15);
            var5.func_983_a((double)((float)(p_1235_2_ + 1) - var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 1), var11, var13);
            var5.func_983_a((double)((float)(p_1235_2_ + 1) - var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 1), var11, var13);
            var5.func_983_a((double)(p_1235_2_ + 1 - 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1), var11, var15);
            var5.func_983_a((double)(p_1235_2_ + 1 - 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var9, var15);
            var5.func_983_a((double)((float)(p_1235_2_ + 1) - var36), (double)((float)p_1235_3_ + var17 + var19), (double)(p_1235_4_ + 0), var9, var13);
         }

         if(Block.field_402_as.func_261_b(this.field_1772_a, p_1235_2_, p_1235_3_, p_1235_4_ - 1)) {
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17 + var19), (double)((float)p_1235_4_ + var36), var11, var13);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var11, var15);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var9, var15);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17 + var19), (double)((float)p_1235_4_ + var36), var9, var13);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17 + var19), (double)((float)p_1235_4_ + var36), var9, var13);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var9, var15);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 0), var11, var15);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17 + var19), (double)((float)p_1235_4_ + var36), var11, var13);
         }

         if(Block.field_402_as.func_261_b(this.field_1772_a, p_1235_2_, p_1235_3_, p_1235_4_ + 1)) {
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17 + var19), (double)((float)(p_1235_4_ + 1) - var36), var9, var13);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1 - 0), var9, var15);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1 - 0), var11, var15);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17 + var19), (double)((float)(p_1235_4_ + 1) - var36), var11, var13);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17 + var19), (double)((float)(p_1235_4_ + 1) - var36), var11, var13);
            var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1 - 0), var11, var15);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)(p_1235_3_ + 0) + var19), (double)(p_1235_4_ + 1 - 0), var9, var15);
            var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17 + var19), (double)((float)(p_1235_4_ + 1) - var36), var9, var13);
         }

         if(Block.field_402_as.func_261_b(this.field_1772_a, p_1235_2_, p_1235_3_ + 1, p_1235_4_)) {
            var20 = (double)p_1235_2_ + 0.5D + 0.5D;
            var22 = (double)p_1235_2_ + 0.5D - 0.5D;
            var24 = (double)p_1235_4_ + 0.5D + 0.5D;
            var26 = (double)p_1235_4_ + 0.5D - 0.5D;
            var28 = (double)p_1235_2_ + 0.5D - 0.5D;
            var30 = (double)p_1235_2_ + 0.5D + 0.5D;
            var32 = (double)p_1235_4_ + 0.5D - 0.5D;
            double var34 = (double)p_1235_4_ + 0.5D + 0.5D;
            var9 = (double)((float)var7 / 256.0F);
            var11 = (double)(((float)var7 + 15.99F) / 256.0F);
            var13 = (double)((float)var8 / 256.0F);
            var15 = (double)(((float)var8 + 15.99F) / 256.0F);
            ++p_1235_3_;
            var17 = -0.2F;
            if((p_1235_2_ + p_1235_3_ + p_1235_4_ & 1) == 0) {
               var5.func_983_a(var28, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 0), var11, var13);
               var5.func_983_a(var20, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 0), var11, var15);
               var5.func_983_a(var20, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 1), var9, var15);
               var5.func_983_a(var28, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 1), var9, var13);
               var9 = (double)((float)var7 / 256.0F);
               var11 = (double)(((float)var7 + 15.99F) / 256.0F);
               var13 = (double)((float)(var8 + 16) / 256.0F);
               var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
               var5.func_983_a(var30, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 1), var11, var13);
               var5.func_983_a(var22, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 1), var11, var15);
               var5.func_983_a(var22, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 0), var9, var15);
               var5.func_983_a(var30, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 0), var9, var13);
            } else {
               var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17), var34, var11, var13);
               var5.func_983_a((double)(p_1235_2_ + 0), (double)(p_1235_3_ + 0), var26, var11, var15);
               var5.func_983_a((double)(p_1235_2_ + 1), (double)(p_1235_3_ + 0), var26, var9, var15);
               var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17), var34, var9, var13);
               var9 = (double)((float)var7 / 256.0F);
               var11 = (double)(((float)var7 + 15.99F) / 256.0F);
               var13 = (double)((float)(var8 + 16) / 256.0F);
               var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
               var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17), var32, var11, var13);
               var5.func_983_a((double)(p_1235_2_ + 1), (double)(p_1235_3_ + 0), var24, var11, var15);
               var5.func_983_a((double)(p_1235_2_ + 0), (double)(p_1235_3_ + 0), var24, var9, var15);
               var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17), var32, var9, var13);
            }
         }
      } else {
         double var18 = (double)p_1235_2_ + 0.5D + 0.2D;
         var20 = (double)p_1235_2_ + 0.5D - 0.2D;
         var22 = (double)p_1235_4_ + 0.5D + 0.2D;
         var24 = (double)p_1235_4_ + 0.5D - 0.2D;
         var26 = (double)p_1235_2_ + 0.5D - 0.3D;
         var28 = (double)p_1235_2_ + 0.5D + 0.3D;
         var30 = (double)p_1235_4_ + 0.5D - 0.3D;
         var32 = (double)p_1235_4_ + 0.5D + 0.3D;
         var5.func_983_a(var26, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 1), var11, var13);
         var5.func_983_a(var18, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 1), var11, var15);
         var5.func_983_a(var18, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 0), var9, var15);
         var5.func_983_a(var26, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 0), var9, var13);
         var5.func_983_a(var28, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 0), var11, var13);
         var5.func_983_a(var20, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 0), var11, var15);
         var5.func_983_a(var20, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 1), var9, var15);
         var5.func_983_a(var28, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 1), var9, var13);
         var9 = (double)((float)var7 / 256.0F);
         var11 = (double)(((float)var7 + 15.99F) / 256.0F);
         var13 = (double)((float)(var8 + 16) / 256.0F);
         var15 = (double)(((float)var8 + 15.99F + 16.0F) / 256.0F);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17), var32, var11, var13);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)(p_1235_3_ + 0), var24, var11, var15);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)(p_1235_3_ + 0), var24, var9, var15);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17), var32, var9, var13);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17), var30, var11, var13);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)(p_1235_3_ + 0), var22, var11, var15);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)(p_1235_3_ + 0), var22, var9, var15);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17), var30, var9, var13);
         var18 = (double)p_1235_2_ + 0.5D - 0.5D;
         var20 = (double)p_1235_2_ + 0.5D + 0.5D;
         var22 = (double)p_1235_4_ + 0.5D - 0.5D;
         var24 = (double)p_1235_4_ + 0.5D + 0.5D;
         var26 = (double)p_1235_2_ + 0.5D - 0.4D;
         var28 = (double)p_1235_2_ + 0.5D + 0.4D;
         var30 = (double)p_1235_4_ + 0.5D - 0.4D;
         var32 = (double)p_1235_4_ + 0.5D + 0.4D;
         var5.func_983_a(var26, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 0), var9, var13);
         var5.func_983_a(var18, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 0), var9, var15);
         var5.func_983_a(var18, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 1), var11, var15);
         var5.func_983_a(var26, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 1), var11, var13);
         var5.func_983_a(var28, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 1), var9, var13);
         var5.func_983_a(var20, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 1), var9, var15);
         var5.func_983_a(var20, (double)(p_1235_3_ + 0), (double)(p_1235_4_ + 0), var11, var15);
         var5.func_983_a(var28, (double)((float)p_1235_3_ + var17), (double)(p_1235_4_ + 0), var11, var13);
         var9 = (double)((float)var7 / 256.0F);
         var11 = (double)(((float)var7 + 15.99F) / 256.0F);
         var13 = (double)((float)var8 / 256.0F);
         var15 = (double)(((float)var8 + 15.99F) / 256.0F);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17), var32, var9, var13);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)(p_1235_3_ + 0), var24, var9, var15);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)(p_1235_3_ + 0), var24, var11, var15);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17), var32, var11, var13);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)((float)p_1235_3_ + var17), var30, var9, var13);
         var5.func_983_a((double)(p_1235_2_ + 1), (double)(p_1235_3_ + 0), var22, var9, var15);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)(p_1235_3_ + 0), var22, var11, var15);
         var5.func_983_a((double)(p_1235_2_ + 0), (double)((float)p_1235_3_ + var17), var30, var11, var13);
      }

      return true;
   }

   public boolean func_1242_e(Block p_1242_1_, int p_1242_2_, int p_1242_3_, int p_1242_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = this.field_1772_a.func_602_e(p_1242_2_, p_1242_3_, p_1242_4_);
      int var7 = p_1242_1_.func_232_a(1, var6);
      if(this.field_1771_b >= 0) {
         var7 = this.field_1771_b;
      }

      var5.func_35835_b(p_1242_1_.func_35275_c(this.field_1772_a, p_1242_2_, p_1242_3_, p_1242_4_));
      float var8 = 1.0F;
      float var9 = (float)var6 / 15.0F;
      float var10 = var9 * 0.6F + 0.4F;
      if(var6 == 0) {
         var10 = 0.3F;
      }

      float var11 = var9 * var9 * 0.7F - 0.5F;
      float var12 = var9 * var9 * 0.6F - 0.7F;
      if(var11 < 0.0F) {
         var11 = 0.0F;
      }

      if(var12 < 0.0F) {
         var12 = 0.0F;
      }

      var5.func_987_a(var10, var11, var12);
      int var13 = (var7 & 15) << 4;
      int var14 = var7 & 240;
      double var15 = (double)((float)var13 / 256.0F);
      double var17 = (double)(((float)var13 + 15.99F) / 256.0F);
      double var19 = (double)((float)var14 / 256.0F);
      double var21 = (double)(((float)var14 + 15.99F) / 256.0F);
      boolean var29 = BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_ - 1, p_1242_3_, p_1242_4_, 1) || !this.field_1772_a.func_28100_h(p_1242_2_ - 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_ - 1, p_1242_3_ - 1, p_1242_4_, -1);
      boolean var30 = BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_ + 1, p_1242_3_, p_1242_4_, 3) || !this.field_1772_a.func_28100_h(p_1242_2_ + 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_ + 1, p_1242_3_ - 1, p_1242_4_, -1);
      boolean var31 = BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_, p_1242_3_, p_1242_4_ - 1, 2) || !this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ - 1) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_, p_1242_3_ - 1, p_1242_4_ - 1, -1);
      boolean var32 = BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_, p_1242_3_, p_1242_4_ + 1, 0) || !this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ + 1) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_, p_1242_3_ - 1, p_1242_4_ + 1, -1);
      if(!this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_ + 1, p_1242_4_)) {
         if(this.field_1772_a.func_28100_h(p_1242_2_ - 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_ - 1, p_1242_3_ + 1, p_1242_4_, -1)) {
            var29 = true;
         }

         if(this.field_1772_a.func_28100_h(p_1242_2_ + 1, p_1242_3_, p_1242_4_) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_ + 1, p_1242_3_ + 1, p_1242_4_, -1)) {
            var30 = true;
         }

         if(this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ - 1) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_, p_1242_3_ + 1, p_1242_4_ - 1, -1)) {
            var31 = true;
         }

         if(this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ + 1) && BlockRedstoneWire.func_279_b(this.field_1772_a, p_1242_2_, p_1242_3_ + 1, p_1242_4_ + 1, -1)) {
            var32 = true;
         }
      }

      float var34 = (float)(p_1242_2_ + 0);
      float var35 = (float)(p_1242_2_ + 1);
      float var36 = (float)(p_1242_4_ + 0);
      float var37 = (float)(p_1242_4_ + 1);
      byte var38 = 0;
      if((var29 || var30) && !var31 && !var32) {
         var38 = 1;
      }

      if((var31 || var32) && !var30 && !var29) {
         var38 = 2;
      }

      if(var38 != 0) {
         var15 = (double)((float)(var13 + 16) / 256.0F);
         var17 = (double)(((float)(var13 + 16) + 15.99F) / 256.0F);
         var19 = (double)((float)var14 / 256.0F);
         var21 = (double)(((float)var14 + 15.99F) / 256.0F);
      }

      if(var38 == 0) {
         if(!var29) {
            var34 += 0.3125F;
         }

         if(!var29) {
            var15 += 0.01953125D;
         }

         if(!var30) {
            var35 -= 0.3125F;
         }

         if(!var30) {
            var17 -= 0.01953125D;
         }

         if(!var31) {
            var36 += 0.3125F;
         }

         if(!var31) {
            var19 += 0.01953125D;
         }

         if(!var32) {
            var37 -= 0.3125F;
         }

         if(!var32) {
            var21 -= 0.01953125D;
         }

         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var21);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var36, var17, var19);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var19);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var37, var15, var21);
         var5.func_987_a(var8, var8, var8);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var21 + 0.0625D);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var36, var17, var19 + 0.0625D);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var19 + 0.0625D);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var37, var15, var21 + 0.0625D);
      } else if(var38 == 1) {
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var21);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var36, var17, var19);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var19);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var37, var15, var21);
         var5.func_987_a(var8, var8, var8);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var21 + 0.0625D);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var36, var17, var19 + 0.0625D);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var19 + 0.0625D);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var37, var15, var21 + 0.0625D);
      } else if(var38 == 2) {
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var21);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var21);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var19);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var19);
         var5.func_987_a(var8, var8, var8);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var21 + 0.0625D);
         var5.func_983_a((double)var35, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var21 + 0.0625D);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var36, var15, var19 + 0.0625D);
         var5.func_983_a((double)var34, (double)p_1242_3_ + 0.015625D, (double)var37, var17, var19 + 0.0625D);
      }

      if(!this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_ + 1, p_1242_4_)) {
         var15 = (double)((float)(var13 + 16) / 256.0F);
         var17 = (double)(((float)(var13 + 16) + 15.99F) / 256.0F);
         var19 = (double)((float)var14 / 256.0F);
         var21 = (double)(((float)var14 + 15.99F) / 256.0F);
         if(this.field_1772_a.func_28100_h(p_1242_2_ - 1, p_1242_3_, p_1242_4_) && this.field_1772_a.func_600_a(p_1242_2_ - 1, p_1242_3_ + 1, p_1242_4_) == Block.field_394_aw.field_376_bc) {
            var5.func_987_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1), var17, var19);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1), var15, var19);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 0), var15, var21);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 0), var17, var21);
            var5.func_987_a(var8, var8, var8);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1), var17, var19 + 0.0625D);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1), var15, var19 + 0.0625D);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 0), var15, var21 + 0.0625D);
            var5.func_983_a((double)p_1242_2_ + 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 0), var17, var21 + 0.0625D);
         }

         if(this.field_1772_a.func_28100_h(p_1242_2_ + 1, p_1242_3_, p_1242_4_) && this.field_1772_a.func_600_a(p_1242_2_ + 1, p_1242_3_ + 1, p_1242_4_) == Block.field_394_aw.field_376_bc) {
            var5.func_987_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1), var15, var21);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1), var17, var21);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 0), var17, var19);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 0), var15, var19);
            var5.func_987_a(var8, var8, var8);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1), var15, var21 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1), var17, var21 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 0), var17, var19 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 1) - 0.015625D, (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 0), var15, var19 + 0.0625D);
         }

         if(this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ - 1) && this.field_1772_a.func_600_a(p_1242_2_, p_1242_3_ + 1, p_1242_4_ - 1) == Block.field_394_aw.field_376_bc) {
            var5.func_987_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)(p_1242_3_ + 0), (double)p_1242_4_ + 0.015625D, var15, var21);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)p_1242_4_ + 0.015625D, var17, var21);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)p_1242_4_ + 0.015625D, var17, var19);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)(p_1242_3_ + 0), (double)p_1242_4_ + 0.015625D, var15, var19);
            var5.func_987_a(var8, var8, var8);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)(p_1242_3_ + 0), (double)p_1242_4_ + 0.015625D, var15, var21 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)p_1242_4_ + 0.015625D, var17, var21 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)p_1242_4_ + 0.015625D, var17, var19 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)(p_1242_3_ + 0), (double)p_1242_4_ + 0.015625D, var15, var19 + 0.0625D);
         }

         if(this.field_1772_a.func_28100_h(p_1242_2_, p_1242_3_, p_1242_4_ + 1) && this.field_1772_a.func_600_a(p_1242_2_, p_1242_3_ + 1, p_1242_4_ + 1) == Block.field_394_aw.field_376_bc) {
            var5.func_987_a(var8 * var10, var8 * var11, var8 * var12);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1) - 0.015625D, var17, var19);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1) - 0.015625D, var15, var19);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1) - 0.015625D, var15, var21);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1) - 0.015625D, var17, var21);
            var5.func_987_a(var8, var8, var8);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1) - 0.015625D, var17, var19 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 1), (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1) - 0.015625D, var15, var19 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)(p_1242_3_ + 0), (double)(p_1242_4_ + 1) - 0.015625D, var15, var21 + 0.0625D);
            var5.func_983_a((double)(p_1242_2_ + 0), (double)((float)(p_1242_3_ + 1) + 0.021875F), (double)(p_1242_4_ + 1) - 0.015625D, var17, var21 + 0.0625D);
         }
      }

      return true;
   }

   public boolean func_1216_f(BlockRail p_1216_1_, int p_1216_2_, int p_1216_3_, int p_1216_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = this.field_1772_a.func_602_e(p_1216_2_, p_1216_3_, p_1216_4_);
      int var7 = p_1216_1_.func_232_a(0, var6);
      if(this.field_1771_b >= 0) {
         var7 = this.field_1771_b;
      }

      if(p_1216_1_.func_27042_h()) {
         var6 &= 7;
      }

      var5.func_35835_b(p_1216_1_.func_35275_c(this.field_1772_a, p_1216_2_, p_1216_3_, p_1216_4_));
      var5.func_987_a(1.0F, 1.0F, 1.0F);
      int var8 = (var7 & 15) << 4;
      int var9 = var7 & 240;
      double var10 = (double)((float)var8 / 256.0F);
      double var12 = (double)(((float)var8 + 15.99F) / 256.0F);
      double var14 = (double)((float)var9 / 256.0F);
      double var16 = (double)(((float)var9 + 15.99F) / 256.0F);
      double var18 = 0.0625D;
      double var20 = (double)(p_1216_2_ + 1);
      double var22 = (double)(p_1216_2_ + 1);
      double var24 = (double)(p_1216_2_ + 0);
      double var26 = (double)(p_1216_2_ + 0);
      double var28 = (double)(p_1216_4_ + 0);
      double var30 = (double)(p_1216_4_ + 1);
      double var32 = (double)(p_1216_4_ + 1);
      double var34 = (double)(p_1216_4_ + 0);
      double var36 = (double)p_1216_3_ + var18;
      double var38 = (double)p_1216_3_ + var18;
      double var40 = (double)p_1216_3_ + var18;
      double var42 = (double)p_1216_3_ + var18;
      if(var6 != 1 && var6 != 2 && var6 != 3 && var6 != 7) {
         if(var6 == 8) {
            var20 = var22 = (double)(p_1216_2_ + 0);
            var24 = var26 = (double)(p_1216_2_ + 1);
            var28 = var34 = (double)(p_1216_4_ + 1);
            var30 = var32 = (double)(p_1216_4_ + 0);
         } else if(var6 == 9) {
            var20 = var26 = (double)(p_1216_2_ + 0);
            var22 = var24 = (double)(p_1216_2_ + 1);
            var28 = var30 = (double)(p_1216_4_ + 0);
            var32 = var34 = (double)(p_1216_4_ + 1);
         }
      } else {
         var20 = var26 = (double)(p_1216_2_ + 1);
         var22 = var24 = (double)(p_1216_2_ + 0);
         var28 = var30 = (double)(p_1216_4_ + 1);
         var32 = var34 = (double)(p_1216_4_ + 0);
      }

      if(var6 != 2 && var6 != 4) {
         if(var6 == 3 || var6 == 5) {
            ++var38;
            ++var40;
         }
      } else {
         ++var36;
         ++var42;
      }

      var5.func_983_a(var20, var36, var28, var12, var14);
      var5.func_983_a(var22, var38, var30, var12, var16);
      var5.func_983_a(var24, var40, var32, var10, var16);
      var5.func_983_a(var26, var42, var34, var10, var14);
      var5.func_983_a(var26, var42, var34, var10, var14);
      var5.func_983_a(var24, var40, var32, var10, var16);
      var5.func_983_a(var22, var38, var30, var12, var16);
      var5.func_983_a(var20, var36, var28, var12, var14);
      return true;
   }

   public boolean func_1221_g(Block p_1221_1_, int p_1221_2_, int p_1221_3_, int p_1221_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = p_1221_1_.func_218_a(0);
      if(this.field_1771_b >= 0) {
         var6 = this.field_1771_b;
      }

      var5.func_35835_b(p_1221_1_.func_35275_c(this.field_1772_a, p_1221_2_, p_1221_3_, p_1221_4_));
      float var7 = 1.0F;
      var5.func_987_a(var7, var7, var7);
      int var22 = (var6 & 15) << 4;
      int var8 = var6 & 240;
      double var9 = (double)((float)var22 / 256.0F);
      double var11 = (double)(((float)var22 + 15.99F) / 256.0F);
      double var13 = (double)((float)var8 / 256.0F);
      double var15 = (double)(((float)var8 + 15.99F) / 256.0F);
      int var17 = this.field_1772_a.func_602_e(p_1221_2_, p_1221_3_, p_1221_4_);
      double var18 = 0.0D;
      double var20 = 0.05000000074505806D;
      if(var17 == 5) {
         var5.func_983_a((double)p_1221_2_ + var20, (double)(p_1221_3_ + 1) + var18, (double)(p_1221_4_ + 1) + var18, var9, var13);
         var5.func_983_a((double)p_1221_2_ + var20, (double)(p_1221_3_ + 0) - var18, (double)(p_1221_4_ + 1) + var18, var9, var15);
         var5.func_983_a((double)p_1221_2_ + var20, (double)(p_1221_3_ + 0) - var18, (double)(p_1221_4_ + 0) - var18, var11, var15);
         var5.func_983_a((double)p_1221_2_ + var20, (double)(p_1221_3_ + 1) + var18, (double)(p_1221_4_ + 0) - var18, var11, var13);
      }

      if(var17 == 4) {
         var5.func_983_a((double)(p_1221_2_ + 1) - var20, (double)(p_1221_3_ + 0) - var18, (double)(p_1221_4_ + 1) + var18, var11, var15);
         var5.func_983_a((double)(p_1221_2_ + 1) - var20, (double)(p_1221_3_ + 1) + var18, (double)(p_1221_4_ + 1) + var18, var11, var13);
         var5.func_983_a((double)(p_1221_2_ + 1) - var20, (double)(p_1221_3_ + 1) + var18, (double)(p_1221_4_ + 0) - var18, var9, var13);
         var5.func_983_a((double)(p_1221_2_ + 1) - var20, (double)(p_1221_3_ + 0) - var18, (double)(p_1221_4_ + 0) - var18, var9, var15);
      }

      if(var17 == 3) {
         var5.func_983_a((double)(p_1221_2_ + 1) + var18, (double)(p_1221_3_ + 0) - var18, (double)p_1221_4_ + var20, var11, var15);
         var5.func_983_a((double)(p_1221_2_ + 1) + var18, (double)(p_1221_3_ + 1) + var18, (double)p_1221_4_ + var20, var11, var13);
         var5.func_983_a((double)(p_1221_2_ + 0) - var18, (double)(p_1221_3_ + 1) + var18, (double)p_1221_4_ + var20, var9, var13);
         var5.func_983_a((double)(p_1221_2_ + 0) - var18, (double)(p_1221_3_ + 0) - var18, (double)p_1221_4_ + var20, var9, var15);
      }

      if(var17 == 2) {
         var5.func_983_a((double)(p_1221_2_ + 1) + var18, (double)(p_1221_3_ + 1) + var18, (double)(p_1221_4_ + 1) - var20, var9, var13);
         var5.func_983_a((double)(p_1221_2_ + 1) + var18, (double)(p_1221_3_ + 0) - var18, (double)(p_1221_4_ + 1) - var20, var9, var15);
         var5.func_983_a((double)(p_1221_2_ + 0) - var18, (double)(p_1221_3_ + 0) - var18, (double)(p_1221_4_ + 1) - var20, var11, var15);
         var5.func_983_a((double)(p_1221_2_ + 0) - var18, (double)(p_1221_3_ + 1) + var18, (double)(p_1221_4_ + 1) - var20, var11, var13);
      }

      return true;
   }

   public boolean func_35929_i(Block p_35929_1_, int p_35929_2_, int p_35929_3_, int p_35929_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = p_35929_1_.func_218_a(0);
      if(this.field_1771_b >= 0) {
         var6 = this.field_1771_b;
      }

      float var7 = 1.0F;
      var5.func_35835_b(p_35929_1_.func_35275_c(this.field_1772_a, p_35929_2_, p_35929_3_, p_35929_4_));
      int var8 = p_35929_1_.func_207_d(this.field_1772_a, p_35929_2_, p_35929_3_, p_35929_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      var5.func_987_a(var7 * var9, var7 * var10, var7 * var11);
      var8 = (var6 & 15) << 4;
      int var21 = var6 & 240;
      double var22 = (double)((float)var8 / 256.0F);
      double var12 = (double)(((float)var8 + 15.99F) / 256.0F);
      double var14 = (double)((float)var21 / 256.0F);
      double var16 = (double)(((float)var21 + 15.99F) / 256.0F);
      double var18 = 0.05000000074505806D;
      int var20 = this.field_1772_a.func_602_e(p_35929_2_, p_35929_3_, p_35929_4_);
      if((var20 & 2) != 0) {
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1), var22, var14);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1), var22, var16);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 0), var12, var16);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 0), var12, var14);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 0), var12, var14);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 0), var12, var16);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1), var22, var16);
         var5.func_983_a((double)p_35929_2_ + var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1), var22, var14);
      }

      if((var20 & 8) != 0) {
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1), var12, var16);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1), var12, var14);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 0), var22, var14);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 0), var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 0), var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 0), var22, var14);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1), var12, var14);
         var5.func_983_a((double)(p_35929_2_ + 1) - var18, (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1), var12, var16);
      }

      if((var20 & 4) != 0) {
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 0), (double)p_35929_4_ + var18, var12, var16);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 1), (double)p_35929_4_ + var18, var12, var14);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 1), (double)p_35929_4_ + var18, var22, var14);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 0), (double)p_35929_4_ + var18, var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 0), (double)p_35929_4_ + var18, var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 1), (double)p_35929_4_ + var18, var22, var14);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 1), (double)p_35929_4_ + var18, var12, var14);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 0), (double)p_35929_4_ + var18, var12, var16);
      }

      if((var20 & 1) != 0) {
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1) - var18, var22, var14);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1) - var18, var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1) - var18, var12, var16);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1) - var18, var12, var14);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1) - var18, var12, var14);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1) - var18, var12, var16);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 0), (double)(p_35929_4_ + 1) - var18, var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 1), (double)(p_35929_4_ + 1) - var18, var22, var14);
      }

      if(this.field_1772_a.func_28100_h(p_35929_2_, p_35929_3_ + 1, p_35929_4_)) {
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 1) - var18, (double)(p_35929_4_ + 0), var22, var14);
         var5.func_983_a((double)(p_35929_2_ + 1), (double)(p_35929_3_ + 1) - var18, (double)(p_35929_4_ + 1), var22, var16);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 1) - var18, (double)(p_35929_4_ + 1), var12, var16);
         var5.func_983_a((double)(p_35929_2_ + 0), (double)(p_35929_3_ + 1) - var18, (double)(p_35929_4_ + 0), var12, var14);
      }

      return true;
   }

   public boolean func_35922_a(BlockPane p_35922_1_, int p_35922_2_, int p_35922_3_, int p_35922_4_) {
      int var5 = this.field_1772_a.func_48453_b();
      Tessellator var6 = Tessellator.field_1512_a;
      var6.func_35835_b(p_35922_1_.func_35275_c(this.field_1772_a, p_35922_2_, p_35922_3_, p_35922_4_));
      float var7 = 1.0F;
      int var8 = p_35922_1_.func_207_d(this.field_1772_a, p_35922_2_, p_35922_3_, p_35922_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_28135_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_987_a(var7 * var9, var7 * var10, var7 * var11);
      boolean var64 = false;
      boolean var66 = false;
      int var65;
      int var67;
      int var68;
      if(this.field_1771_b >= 0) {
         var65 = this.field_1771_b;
         var67 = this.field_1771_b;
      } else {
         var68 = this.field_1772_a.func_602_e(p_35922_2_, p_35922_3_, p_35922_4_);
         var65 = p_35922_1_.func_232_a(0, var68);
         var67 = p_35922_1_.func_35299_s();
      }

      var68 = (var65 & 15) << 4;
      int var15 = var65 & 240;
      double var16 = (double)((float)var68 / 256.0F);
      double var18 = (double)(((float)var68 + 7.99F) / 256.0F);
      double var20 = (double)(((float)var68 + 15.99F) / 256.0F);
      double var22 = (double)((float)var15 / 256.0F);
      double var24 = (double)(((float)var15 + 15.99F) / 256.0F);
      int var26 = (var67 & 15) << 4;
      int var27 = var67 & 240;
      double var28 = (double)((float)(var26 + 7) / 256.0F);
      double var30 = (double)(((float)var26 + 8.99F) / 256.0F);
      double var32 = (double)((float)var27 / 256.0F);
      double var34 = (double)((float)(var27 + 8) / 256.0F);
      double var36 = (double)(((float)var27 + 15.99F) / 256.0F);
      double var38 = (double)p_35922_2_;
      double var40 = (double)p_35922_2_ + 0.5D;
      double var42 = (double)(p_35922_2_ + 1);
      double var44 = (double)p_35922_4_;
      double var46 = (double)p_35922_4_ + 0.5D;
      double var48 = (double)(p_35922_4_ + 1);
      double var50 = (double)p_35922_2_ + 0.5D - 0.0625D;
      double var52 = (double)p_35922_2_ + 0.5D + 0.0625D;
      double var54 = (double)p_35922_4_ + 0.5D - 0.0625D;
      double var56 = (double)p_35922_4_ + 0.5D + 0.0625D;
      boolean var58 = p_35922_1_.func_35298_d(this.field_1772_a.func_600_a(p_35922_2_, p_35922_3_, p_35922_4_ - 1));
      boolean var59 = p_35922_1_.func_35298_d(this.field_1772_a.func_600_a(p_35922_2_, p_35922_3_, p_35922_4_ + 1));
      boolean var60 = p_35922_1_.func_35298_d(this.field_1772_a.func_600_a(p_35922_2_ - 1, p_35922_3_, p_35922_4_));
      boolean var61 = p_35922_1_.func_35298_d(this.field_1772_a.func_600_a(p_35922_2_ + 1, p_35922_3_, p_35922_4_));
      boolean var62 = p_35922_1_.func_260_c(this.field_1772_a, p_35922_2_, p_35922_3_ + 1, p_35922_4_, 1);
      boolean var63 = p_35922_1_.func_260_c(this.field_1772_a, p_35922_2_, p_35922_3_ - 1, p_35922_4_, 0);
      if((!var60 || !var61) && (var60 || var61 || var58 || var59)) {
         if(var60 && !var61) {
            var6.func_983_a(var38, (double)(p_35922_3_ + 1), var46, var16, var22);
            var6.func_983_a(var38, (double)(p_35922_3_ + 0), var46, var16, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var18, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var18, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var16, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var16, var24);
            var6.func_983_a(var38, (double)(p_35922_3_ + 0), var46, var18, var24);
            var6.func_983_a(var38, (double)(p_35922_3_ + 1), var46, var18, var22);
            if(!var59 && !var58) {
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var56, var28, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var56, var28, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var54, var30, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var54, var30, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var54, var28, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var54, var28, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var56, var30, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var56, var30, var32);
            }

            if(var62 || p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ + 1, p_35922_4_)) {
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
            }

            if(var63 || p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ - 1, p_35922_4_)) {
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var36);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var36);
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var56, var30, var36);
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var54, var28, var36);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var34);
            }
         } else if(!var60 && var61) {
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var18, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var18, var24);
            var6.func_983_a(var42, (double)(p_35922_3_ + 0), var46, var20, var24);
            var6.func_983_a(var42, (double)(p_35922_3_ + 1), var46, var20, var22);
            var6.func_983_a(var42, (double)(p_35922_3_ + 1), var46, var18, var22);
            var6.func_983_a(var42, (double)(p_35922_3_ + 0), var46, var18, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var20, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var20, var22);
            if(!var59 && !var58) {
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var54, var28, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var54, var28, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var56, var30, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var56, var30, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var56, var28, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var56, var28, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 0), var54, var30, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1), var54, var30, var32);
            }

            if(var62 || p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ + 1, p_35922_4_)) {
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var32);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var32);
            }

            if(var63 || p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ - 1, p_35922_4_)) {
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var32);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var32);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var56, var30, var32);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var34);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var54, var28, var32);
            }
         }
      } else {
         var6.func_983_a(var38, (double)(p_35922_3_ + 1), var46, var16, var22);
         var6.func_983_a(var38, (double)(p_35922_3_ + 0), var46, var16, var24);
         var6.func_983_a(var42, (double)(p_35922_3_ + 0), var46, var20, var24);
         var6.func_983_a(var42, (double)(p_35922_3_ + 1), var46, var20, var22);
         var6.func_983_a(var42, (double)(p_35922_3_ + 1), var46, var16, var22);
         var6.func_983_a(var42, (double)(p_35922_3_ + 0), var46, var16, var24);
         var6.func_983_a(var38, (double)(p_35922_3_ + 0), var46, var20, var24);
         var6.func_983_a(var38, (double)(p_35922_3_ + 1), var46, var20, var22);
         if(var62) {
            var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var36);
            var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var32);
            var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var32);
            var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var36);
            var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var36);
            var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var32);
            var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var32);
            var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var36);
         } else {
            if(p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ + 1, p_35922_4_)) {
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var36);
               var6.func_983_a(var38, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var36);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
            }

            if(p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ + 1, p_35922_4_)) {
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var32);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var32);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var34);
               var6.func_983_a(var42, (double)(p_35922_3_ + 1) + 0.01D, var54, var28, var32);
            }
         }

         if(var63) {
            var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var56, var30, var36);
            var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var56, var30, var32);
            var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var54, var28, var32);
            var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var54, var28, var36);
            var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var56, var30, var36);
            var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var56, var30, var32);
            var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var54, var28, var32);
            var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var54, var28, var36);
         } else {
            if(p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_ - 1, p_35922_3_ - 1, p_35922_4_)) {
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var36);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var36);
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var56, var30, var36);
               var6.func_983_a(var38, (double)p_35922_3_ - 0.01D, var54, var28, var36);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var34);
            }

            if(p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_ + 1, p_35922_3_ - 1, p_35922_4_)) {
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var32);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var54, var28, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var32);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var56, var30, var32);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var56, var30, var34);
               var6.func_983_a(var40, (double)p_35922_3_ - 0.01D, var54, var28, var34);
               var6.func_983_a(var42, (double)p_35922_3_ - 0.01D, var54, var28, var32);
            }
         }
      }

      if((!var58 || !var59) && (var60 || var61 || var58 || var59)) {
         if(var58 && !var59) {
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var44, var16, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var44, var16, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var18, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var18, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var16, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var16, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var44, var18, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var44, var18, var22);
            if(!var61 && !var60) {
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var28, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 0), var46, var28, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 0), var46, var30, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var30, var32);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var28, var32);
               var6.func_983_a(var52, (double)(p_35922_3_ + 0), var46, var28, var36);
               var6.func_983_a(var50, (double)(p_35922_3_ + 0), var46, var30, var36);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var30, var32);
            }

            if(var62 || p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ - 1)) {
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var44, var30, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var30, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var28, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var44, var28, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var30, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var44, var30, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var44, var28, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var28, var32);
            }

            if(var63 || p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ - 1)) {
               var6.func_983_a(var50, (double)p_35922_3_, var44, var30, var32);
               var6.func_983_a(var50, (double)p_35922_3_, var46, var30, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var28, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var44, var28, var32);
               var6.func_983_a(var50, (double)p_35922_3_, var46, var30, var32);
               var6.func_983_a(var50, (double)p_35922_3_, var44, var30, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var44, var28, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var28, var32);
            }
         } else if(!var58 && var59) {
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var18, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var18, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var48, var20, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var48, var20, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var48, var18, var22);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var48, var18, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 0), var46, var20, var24);
            var6.func_983_a(var40, (double)(p_35922_3_ + 1), var46, var20, var22);
            if(!var61 && !var60) {
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var28, var32);
               var6.func_983_a(var52, (double)(p_35922_3_ + 0), var46, var28, var36);
               var6.func_983_a(var50, (double)(p_35922_3_ + 0), var46, var30, var36);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var30, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var28, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 0), var46, var28, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 0), var46, var30, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var30, var32);
            }

            if(var62 || p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ + 1)) {
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var28, var34);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var48, var28, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var48, var30, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var30, var34);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var48, var28, var34);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var28, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var30, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var48, var30, var34);
            }

            if(var63 || p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ + 1)) {
               var6.func_983_a(var50, (double)p_35922_3_, var46, var28, var34);
               var6.func_983_a(var50, (double)p_35922_3_, var48, var28, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var48, var30, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var30, var34);
               var6.func_983_a(var50, (double)p_35922_3_, var48, var28, var34);
               var6.func_983_a(var50, (double)p_35922_3_, var46, var28, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var30, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var48, var30, var34);
            }
         }
      } else {
         var6.func_983_a(var40, (double)(p_35922_3_ + 1), var48, var16, var22);
         var6.func_983_a(var40, (double)(p_35922_3_ + 0), var48, var16, var24);
         var6.func_983_a(var40, (double)(p_35922_3_ + 0), var44, var20, var24);
         var6.func_983_a(var40, (double)(p_35922_3_ + 1), var44, var20, var22);
         var6.func_983_a(var40, (double)(p_35922_3_ + 1), var44, var16, var22);
         var6.func_983_a(var40, (double)(p_35922_3_ + 0), var44, var16, var24);
         var6.func_983_a(var40, (double)(p_35922_3_ + 0), var48, var20, var24);
         var6.func_983_a(var40, (double)(p_35922_3_ + 1), var48, var20, var22);
         if(var62) {
            var6.func_983_a(var52, (double)(p_35922_3_ + 1), var48, var30, var36);
            var6.func_983_a(var52, (double)(p_35922_3_ + 1), var44, var30, var32);
            var6.func_983_a(var50, (double)(p_35922_3_ + 1), var44, var28, var32);
            var6.func_983_a(var50, (double)(p_35922_3_ + 1), var48, var28, var36);
            var6.func_983_a(var52, (double)(p_35922_3_ + 1), var44, var30, var36);
            var6.func_983_a(var52, (double)(p_35922_3_ + 1), var48, var30, var32);
            var6.func_983_a(var50, (double)(p_35922_3_ + 1), var48, var28, var32);
            var6.func_983_a(var50, (double)(p_35922_3_ + 1), var44, var28, var36);
         } else {
            if(p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ - 1)) {
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var44, var30, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var30, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var28, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var44, var28, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var30, var32);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var44, var30, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var44, var28, var34);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var28, var32);
            }

            if(p_35922_3_ < var5 - 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ + 1, p_35922_4_ + 1)) {
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var28, var34);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var48, var28, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var48, var30, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var30, var34);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var48, var28, var34);
               var6.func_983_a(var50, (double)(p_35922_3_ + 1), var46, var28, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var46, var30, var36);
               var6.func_983_a(var52, (double)(p_35922_3_ + 1), var48, var30, var34);
            }
         }

         if(var63) {
            var6.func_983_a(var52, (double)p_35922_3_, var48, var30, var36);
            var6.func_983_a(var52, (double)p_35922_3_, var44, var30, var32);
            var6.func_983_a(var50, (double)p_35922_3_, var44, var28, var32);
            var6.func_983_a(var50, (double)p_35922_3_, var48, var28, var36);
            var6.func_983_a(var52, (double)p_35922_3_, var44, var30, var36);
            var6.func_983_a(var52, (double)p_35922_3_, var48, var30, var32);
            var6.func_983_a(var50, (double)p_35922_3_, var48, var28, var32);
            var6.func_983_a(var50, (double)p_35922_3_, var44, var28, var36);
         } else {
            if(p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ - 1)) {
               var6.func_983_a(var50, (double)p_35922_3_, var44, var30, var32);
               var6.func_983_a(var50, (double)p_35922_3_, var46, var30, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var28, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var44, var28, var32);
               var6.func_983_a(var50, (double)p_35922_3_, var46, var30, var32);
               var6.func_983_a(var50, (double)p_35922_3_, var44, var30, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var44, var28, var34);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var28, var32);
            }

            if(p_35922_3_ > 1 && this.field_1772_a.func_20084_d(p_35922_2_, p_35922_3_ - 1, p_35922_4_ + 1)) {
               var6.func_983_a(var50, (double)p_35922_3_, var46, var28, var34);
               var6.func_983_a(var50, (double)p_35922_3_, var48, var28, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var48, var30, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var30, var34);
               var6.func_983_a(var50, (double)p_35922_3_, var48, var28, var34);
               var6.func_983_a(var50, (double)p_35922_3_, var46, var28, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var46, var30, var36);
               var6.func_983_a(var52, (double)p_35922_3_, var48, var30, var34);
            }
         }
      }

      return true;
   }

   public boolean func_1226_h(Block p_1226_1_, int p_1226_2_, int p_1226_3_, int p_1226_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      var5.func_35835_b(p_1226_1_.func_35275_c(this.field_1772_a, p_1226_2_, p_1226_3_, p_1226_4_));
      float var6 = 1.0F;
      int var7 = p_1226_1_.func_207_d(this.field_1772_a, p_1226_2_, p_1226_3_, p_1226_4_);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      if(EntityRenderer.field_28135_a) {
         float var11 = (var8 * 30.0F + var9 * 59.0F + var10 * 11.0F) / 100.0F;
         float var12 = (var8 * 30.0F + var9 * 70.0F) / 100.0F;
         float var13 = (var8 * 30.0F + var10 * 70.0F) / 100.0F;
         var8 = var11;
         var9 = var12;
         var10 = var13;
      }

      var5.func_987_a(var6 * var8, var6 * var9, var6 * var10);
      double var19 = (double)p_1226_2_;
      double var20 = (double)p_1226_3_;
      double var15 = (double)p_1226_4_;
      if(p_1226_1_ == Block.field_9257_X) {
         long var17 = (long)(p_1226_2_ * 3129871) ^ (long)p_1226_4_ * 116129781L ^ (long)p_1226_3_;
         var17 = var17 * var17 * 42317861L + var17 * 11L;
         var19 += ((double)((float)(var17 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var20 += ((double)((float)(var17 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         var15 += ((double)((float)(var17 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
      }

      this.func_1239_a(p_1226_1_, this.field_1772_a.func_602_e(p_1226_2_, p_1226_3_, p_1226_4_), var19, var20, var15);
      return true;
   }

   public boolean func_1232_i(Block p_1232_1_, int p_1232_2_, int p_1232_3_, int p_1232_4_) {
      BlockStem var5 = (BlockStem)p_1232_1_;
      Tessellator var6 = Tessellator.field_1512_a;
      var6.func_35835_b(var5.func_35275_c(this.field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_));
      float var7 = 1.0F;
      int var8 = var5.func_207_d(this.field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_);
      float var9 = (float)(var8 >> 16 & 255) / 255.0F;
      float var10 = (float)(var8 >> 8 & 255) / 255.0F;
      float var11 = (float)(var8 & 255) / 255.0F;
      if(EntityRenderer.field_28135_a) {
         float var12 = (var9 * 30.0F + var10 * 59.0F + var11 * 11.0F) / 100.0F;
         float var13 = (var9 * 30.0F + var10 * 70.0F) / 100.0F;
         float var14 = (var9 * 30.0F + var11 * 70.0F) / 100.0F;
         var9 = var12;
         var10 = var13;
         var11 = var14;
      }

      var6.func_987_a(var7 * var9, var7 * var10, var7 * var11);
      var5.func_238_a(this.field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_);
      int var15 = var5.func_35296_f(this.field_1772_a, p_1232_2_, p_1232_3_, p_1232_4_);
      if(var15 < 0) {
         this.func_35928_a(var5, this.field_1772_a.func_602_e(p_1232_2_, p_1232_3_, p_1232_4_), var5.field_362_bj, (double)p_1232_2_, (double)p_1232_3_, (double)p_1232_4_);
      } else {
         this.func_35928_a(var5, this.field_1772_a.func_602_e(p_1232_2_, p_1232_3_, p_1232_4_), 0.5D, (double)p_1232_2_, (double)p_1232_3_, (double)p_1232_4_);
         this.func_35926_a(var5, this.field_1772_a.func_602_e(p_1232_2_, p_1232_3_, p_1232_4_), var15, var5.field_362_bj, (double)p_1232_2_, (double)p_1232_3_, (double)p_1232_4_);
      }

      return true;
   }

   public boolean func_35930_l(Block p_35930_1_, int p_35930_2_, int p_35930_3_, int p_35930_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      var5.func_35835_b(p_35930_1_.func_35275_c(this.field_1772_a, p_35930_2_, p_35930_3_, p_35930_4_));
      var5.func_987_a(1.0F, 1.0F, 1.0F);
      this.func_1245_b(p_35930_1_, this.field_1772_a.func_602_e(p_35930_2_, p_35930_3_, p_35930_4_), (double)p_35930_2_, (double)((float)p_35930_3_ - 0.0625F), (double)p_35930_4_);
      return true;
   }

   public void func_1237_a(Block p_1237_1_, double p_1237_2_, double p_1237_4_, double p_1237_6_, double p_1237_8_, double p_1237_10_) {
      Tessellator var12 = Tessellator.field_1512_a;
      int var13 = p_1237_1_.func_218_a(0);
      if(this.field_1771_b >= 0) {
         var13 = this.field_1771_b;
      }

      int var14 = (var13 & 15) << 4;
      int var15 = var13 & 240;
      float var16 = (float)var14 / 256.0F;
      float var17 = ((float)var14 + 15.99F) / 256.0F;
      float var18 = (float)var15 / 256.0F;
      float var19 = ((float)var15 + 15.99F) / 256.0F;
      double var20 = (double)var16 + 0.02734375D;
      double var22 = (double)var18 + 0.0234375D;
      double var24 = (double)var16 + 0.03515625D;
      double var26 = (double)var18 + 0.03125D;
      p_1237_2_ += 0.5D;
      p_1237_6_ += 0.5D;
      double var28 = p_1237_2_ - 0.5D;
      double var30 = p_1237_2_ + 0.5D;
      double var32 = p_1237_6_ - 0.5D;
      double var34 = p_1237_6_ + 0.5D;
      double var36 = 0.0625D;
      double var38 = 0.625D;
      var12.func_983_a(p_1237_2_ + p_1237_8_ * (1.0D - var38) - var36, p_1237_4_ + var38, p_1237_6_ + p_1237_10_ * (1.0D - var38) - var36, var20, var22);
      var12.func_983_a(p_1237_2_ + p_1237_8_ * (1.0D - var38) - var36, p_1237_4_ + var38, p_1237_6_ + p_1237_10_ * (1.0D - var38) + var36, var20, var26);
      var12.func_983_a(p_1237_2_ + p_1237_8_ * (1.0D - var38) + var36, p_1237_4_ + var38, p_1237_6_ + p_1237_10_ * (1.0D - var38) + var36, var24, var26);
      var12.func_983_a(p_1237_2_ + p_1237_8_ * (1.0D - var38) + var36, p_1237_4_ + var38, p_1237_6_ + p_1237_10_ * (1.0D - var38) - var36, var24, var22);
      var12.func_983_a(p_1237_2_ - var36, p_1237_4_ + 1.0D, var32, (double)var16, (double)var18);
      var12.func_983_a(p_1237_2_ - var36 + p_1237_8_, p_1237_4_ + 0.0D, var32 + p_1237_10_, (double)var16, (double)var19);
      var12.func_983_a(p_1237_2_ - var36 + p_1237_8_, p_1237_4_ + 0.0D, var34 + p_1237_10_, (double)var17, (double)var19);
      var12.func_983_a(p_1237_2_ - var36, p_1237_4_ + 1.0D, var34, (double)var17, (double)var18);
      var12.func_983_a(p_1237_2_ + var36, p_1237_4_ + 1.0D, var34, (double)var16, (double)var18);
      var12.func_983_a(p_1237_2_ + p_1237_8_ + var36, p_1237_4_ + 0.0D, var34 + p_1237_10_, (double)var16, (double)var19);
      var12.func_983_a(p_1237_2_ + p_1237_8_ + var36, p_1237_4_ + 0.0D, var32 + p_1237_10_, (double)var17, (double)var19);
      var12.func_983_a(p_1237_2_ + var36, p_1237_4_ + 1.0D, var32, (double)var17, (double)var18);
      var12.func_983_a(var28, p_1237_4_ + 1.0D, p_1237_6_ + var36, (double)var16, (double)var18);
      var12.func_983_a(var28 + p_1237_8_, p_1237_4_ + 0.0D, p_1237_6_ + var36 + p_1237_10_, (double)var16, (double)var19);
      var12.func_983_a(var30 + p_1237_8_, p_1237_4_ + 0.0D, p_1237_6_ + var36 + p_1237_10_, (double)var17, (double)var19);
      var12.func_983_a(var30, p_1237_4_ + 1.0D, p_1237_6_ + var36, (double)var17, (double)var18);
      var12.func_983_a(var30, p_1237_4_ + 1.0D, p_1237_6_ - var36, (double)var16, (double)var18);
      var12.func_983_a(var30 + p_1237_8_, p_1237_4_ + 0.0D, p_1237_6_ - var36 + p_1237_10_, (double)var16, (double)var19);
      var12.func_983_a(var28 + p_1237_8_, p_1237_4_ + 0.0D, p_1237_6_ - var36 + p_1237_10_, (double)var17, (double)var19);
      var12.func_983_a(var28, p_1237_4_ + 1.0D, p_1237_6_ - var36, (double)var17, (double)var18);
   }

   public void func_1239_a(Block p_1239_1_, int p_1239_2_, double p_1239_3_, double p_1239_5_, double p_1239_7_) {
      Tessellator var9 = Tessellator.field_1512_a;
      int var10 = p_1239_1_.func_232_a(0, p_1239_2_);
      if(this.field_1771_b >= 0) {
         var10 = this.field_1771_b;
      }

      int var11 = (var10 & 15) << 4;
      int var12 = var10 & 240;
      double var13 = (double)((float)var11 / 256.0F);
      double var15 = (double)(((float)var11 + 15.99F) / 256.0F);
      double var17 = (double)((float)var12 / 256.0F);
      double var19 = (double)(((float)var12 + 15.99F) / 256.0F);
      double var21 = p_1239_3_ + 0.5D - 0.45D;
      double var23 = p_1239_3_ + 0.5D + 0.45D;
      double var25 = p_1239_7_ + 0.5D - 0.45D;
      double var27 = p_1239_7_ + 0.5D + 0.45D;
      var9.func_983_a(var21, p_1239_5_ + 1.0D, var25, var13, var17);
      var9.func_983_a(var21, p_1239_5_ + 0.0D, var25, var13, var19);
      var9.func_983_a(var23, p_1239_5_ + 0.0D, var27, var15, var19);
      var9.func_983_a(var23, p_1239_5_ + 1.0D, var27, var15, var17);
      var9.func_983_a(var23, p_1239_5_ + 1.0D, var27, var13, var17);
      var9.func_983_a(var23, p_1239_5_ + 0.0D, var27, var13, var19);
      var9.func_983_a(var21, p_1239_5_ + 0.0D, var25, var15, var19);
      var9.func_983_a(var21, p_1239_5_ + 1.0D, var25, var15, var17);
      var9.func_983_a(var21, p_1239_5_ + 1.0D, var27, var13, var17);
      var9.func_983_a(var21, p_1239_5_ + 0.0D, var27, var13, var19);
      var9.func_983_a(var23, p_1239_5_ + 0.0D, var25, var15, var19);
      var9.func_983_a(var23, p_1239_5_ + 1.0D, var25, var15, var17);
      var9.func_983_a(var23, p_1239_5_ + 1.0D, var25, var13, var17);
      var9.func_983_a(var23, p_1239_5_ + 0.0D, var25, var13, var19);
      var9.func_983_a(var21, p_1239_5_ + 0.0D, var27, var15, var19);
      var9.func_983_a(var21, p_1239_5_ + 1.0D, var27, var15, var17);
   }

   public void func_35928_a(Block p_35928_1_, int p_35928_2_, double p_35928_3_, double p_35928_5_, double p_35928_7_, double p_35928_9_) {
      Tessellator var11 = Tessellator.field_1512_a;
      int var12 = p_35928_1_.func_232_a(0, p_35928_2_);
      if(this.field_1771_b >= 0) {
         var12 = this.field_1771_b;
      }

      int var13 = (var12 & 15) << 4;
      int var14 = var12 & 240;
      double var15 = (double)((float)var13 / 256.0F);
      double var17 = (double)(((float)var13 + 15.99F) / 256.0F);
      double var19 = (double)((float)var14 / 256.0F);
      double var21 = ((double)var14 + 15.989999771118164D * p_35928_3_) / 256.0D;
      double var23 = p_35928_5_ + 0.5D - 0.44999998807907104D;
      double var25 = p_35928_5_ + 0.5D + 0.44999998807907104D;
      double var27 = p_35928_9_ + 0.5D - 0.44999998807907104D;
      double var29 = p_35928_9_ + 0.5D + 0.44999998807907104D;
      var11.func_983_a(var23, p_35928_7_ + p_35928_3_, var27, var15, var19);
      var11.func_983_a(var23, p_35928_7_ + 0.0D, var27, var15, var21);
      var11.func_983_a(var25, p_35928_7_ + 0.0D, var29, var17, var21);
      var11.func_983_a(var25, p_35928_7_ + p_35928_3_, var29, var17, var19);
      var11.func_983_a(var25, p_35928_7_ + p_35928_3_, var29, var15, var19);
      var11.func_983_a(var25, p_35928_7_ + 0.0D, var29, var15, var21);
      var11.func_983_a(var23, p_35928_7_ + 0.0D, var27, var17, var21);
      var11.func_983_a(var23, p_35928_7_ + p_35928_3_, var27, var17, var19);
      var11.func_983_a(var23, p_35928_7_ + p_35928_3_, var29, var15, var19);
      var11.func_983_a(var23, p_35928_7_ + 0.0D, var29, var15, var21);
      var11.func_983_a(var25, p_35928_7_ + 0.0D, var27, var17, var21);
      var11.func_983_a(var25, p_35928_7_ + p_35928_3_, var27, var17, var19);
      var11.func_983_a(var25, p_35928_7_ + p_35928_3_, var27, var15, var19);
      var11.func_983_a(var25, p_35928_7_ + 0.0D, var27, var15, var21);
      var11.func_983_a(var23, p_35928_7_ + 0.0D, var29, var17, var21);
      var11.func_983_a(var23, p_35928_7_ + p_35928_3_, var29, var17, var19);
   }

   public boolean func_40726_m(Block p_40726_1_, int p_40726_2_, int p_40726_3_, int p_40726_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = p_40726_1_.field_378_bb;
      if(this.field_1771_b >= 0) {
         var6 = this.field_1771_b;
      }

      int var7 = (var6 & 15) << 4;
      int var8 = var6 & 240;
      float var9 = 0.015625F;
      double var10 = (double)((float)var7 / 256.0F);
      double var12 = (double)(((float)var7 + 15.99F) / 256.0F);
      double var14 = (double)((float)var8 / 256.0F);
      double var16 = (double)(((float)var8 + 15.99F) / 256.0F);
      long var18 = (long)(p_40726_2_ * 3129871) ^ (long)p_40726_4_ * 116129781L ^ (long)p_40726_3_;
      var18 = var18 * var18 * 42317861L + var18 * 11L;
      int var20 = (int)(var18 >> 16 & 3L);
      var5.func_35835_b(p_40726_1_.func_35275_c(this.field_1772_a, p_40726_2_, p_40726_3_, p_40726_4_));
      float var21 = (float)p_40726_2_ + 0.5F;
      float var22 = (float)p_40726_4_ + 0.5F;
      float var23 = (float)(var20 & 1) * 0.5F * (float)(1 - var20 / 2 % 2 * 2);
      float var24 = (float)(var20 + 1 & 1) * 0.5F * (float)(1 - (var20 + 1) / 2 % 2 * 2);
      var5.func_990_b(p_40726_1_.func_35274_i());
      var5.func_983_a((double)(var21 + var23 - var24), (double)((float)p_40726_3_ + var9), (double)(var22 + var23 + var24), var10, var14);
      var5.func_983_a((double)(var21 + var23 + var24), (double)((float)p_40726_3_ + var9), (double)(var22 - var23 + var24), var12, var14);
      var5.func_983_a((double)(var21 - var23 + var24), (double)((float)p_40726_3_ + var9), (double)(var22 - var23 - var24), var12, var16);
      var5.func_983_a((double)(var21 - var23 - var24), (double)((float)p_40726_3_ + var9), (double)(var22 + var23 - var24), var10, var16);
      var5.func_990_b((p_40726_1_.func_35274_i() & 16711422) >> 1);
      var5.func_983_a((double)(var21 - var23 - var24), (double)((float)p_40726_3_ + var9), (double)(var22 + var23 - var24), var10, var16);
      var5.func_983_a((double)(var21 - var23 + var24), (double)((float)p_40726_3_ + var9), (double)(var22 - var23 - var24), var12, var16);
      var5.func_983_a((double)(var21 + var23 + var24), (double)((float)p_40726_3_ + var9), (double)(var22 - var23 + var24), var12, var14);
      var5.func_983_a((double)(var21 + var23 - var24), (double)((float)p_40726_3_ + var9), (double)(var22 + var23 + var24), var10, var14);
      return true;
   }

   public void func_35926_a(Block p_35926_1_, int p_35926_2_, int p_35926_3_, double p_35926_4_, double p_35926_6_, double p_35926_8_, double p_35926_10_) {
      Tessellator var12 = Tessellator.field_1512_a;
      int var13 = p_35926_1_.func_232_a(0, p_35926_2_) + 16;
      if(this.field_1771_b >= 0) {
         var13 = this.field_1771_b;
      }

      int var14 = (var13 & 15) << 4;
      int var15 = var13 & 240;
      double var16 = (double)((float)var14 / 256.0F);
      double var18 = (double)(((float)var14 + 15.99F) / 256.0F);
      double var20 = (double)((float)var15 / 256.0F);
      double var22 = ((double)var15 + 15.989999771118164D * p_35926_4_) / 256.0D;
      double var24 = p_35926_6_ + 0.5D - 0.5D;
      double var26 = p_35926_6_ + 0.5D + 0.5D;
      double var28 = p_35926_10_ + 0.5D - 0.5D;
      double var30 = p_35926_10_ + 0.5D + 0.5D;
      double var32 = p_35926_6_ + 0.5D;
      double var34 = p_35926_10_ + 0.5D;
      if((p_35926_3_ + 1) / 2 % 2 == 1) {
         double var36 = var18;
         var18 = var16;
         var16 = var36;
      }

      if(p_35926_3_ < 2) {
         var12.func_983_a(var24, p_35926_8_ + p_35926_4_, var34, var16, var20);
         var12.func_983_a(var24, p_35926_8_ + 0.0D, var34, var16, var22);
         var12.func_983_a(var26, p_35926_8_ + 0.0D, var34, var18, var22);
         var12.func_983_a(var26, p_35926_8_ + p_35926_4_, var34, var18, var20);
         var12.func_983_a(var26, p_35926_8_ + p_35926_4_, var34, var18, var20);
         var12.func_983_a(var26, p_35926_8_ + 0.0D, var34, var18, var22);
         var12.func_983_a(var24, p_35926_8_ + 0.0D, var34, var16, var22);
         var12.func_983_a(var24, p_35926_8_ + p_35926_4_, var34, var16, var20);
      } else {
         var12.func_983_a(var32, p_35926_8_ + p_35926_4_, var30, var16, var20);
         var12.func_983_a(var32, p_35926_8_ + 0.0D, var30, var16, var22);
         var12.func_983_a(var32, p_35926_8_ + 0.0D, var28, var18, var22);
         var12.func_983_a(var32, p_35926_8_ + p_35926_4_, var28, var18, var20);
         var12.func_983_a(var32, p_35926_8_ + p_35926_4_, var28, var18, var20);
         var12.func_983_a(var32, p_35926_8_ + 0.0D, var28, var18, var22);
         var12.func_983_a(var32, p_35926_8_ + 0.0D, var30, var16, var22);
         var12.func_983_a(var32, p_35926_8_ + p_35926_4_, var30, var16, var20);
      }

   }

   public void func_1245_b(Block p_1245_1_, int p_1245_2_, double p_1245_3_, double p_1245_5_, double p_1245_7_) {
      Tessellator var9 = Tessellator.field_1512_a;
      int var10 = p_1245_1_.func_232_a(0, p_1245_2_);
      if(this.field_1771_b >= 0) {
         var10 = this.field_1771_b;
      }

      int var11 = (var10 & 15) << 4;
      int var12 = var10 & 240;
      double var13 = (double)((float)var11 / 256.0F);
      double var15 = (double)(((float)var11 + 15.99F) / 256.0F);
      double var17 = (double)((float)var12 / 256.0F);
      double var19 = (double)(((float)var12 + 15.99F) / 256.0F);
      double var21 = p_1245_3_ + 0.5D - 0.25D;
      double var23 = p_1245_3_ + 0.5D + 0.25D;
      double var25 = p_1245_7_ + 0.5D - 0.5D;
      double var27 = p_1245_7_ + 0.5D + 0.5D;
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var25, var13, var17);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var25, var13, var19);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var27, var15, var19);
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var27, var15, var17);
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var27, var13, var17);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var27, var13, var19);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var25, var15, var19);
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var25, var15, var17);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var27, var13, var17);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var27, var13, var19);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var25, var15, var19);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var25, var15, var17);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var25, var13, var17);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var25, var13, var19);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var27, var15, var19);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var27, var15, var17);
      var21 = p_1245_3_ + 0.5D - 0.5D;
      var23 = p_1245_3_ + 0.5D + 0.5D;
      var25 = p_1245_7_ + 0.5D - 0.25D;
      var27 = p_1245_7_ + 0.5D + 0.25D;
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var25, var13, var17);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var25, var13, var19);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var25, var15, var19);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var25, var15, var17);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var25, var13, var17);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var25, var13, var19);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var25, var15, var19);
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var25, var15, var17);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var27, var13, var17);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var27, var13, var19);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var27, var15, var19);
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var27, var15, var17);
      var9.func_983_a(var21, p_1245_5_ + 1.0D, var27, var13, var17);
      var9.func_983_a(var21, p_1245_5_ + 0.0D, var27, var13, var19);
      var9.func_983_a(var23, p_1245_5_ + 0.0D, var27, var15, var19);
      var9.func_983_a(var23, p_1245_5_ + 1.0D, var27, var15, var17);
   }

   public boolean func_1222_j(Block p_1222_1_, int p_1222_2_, int p_1222_3_, int p_1222_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      int var6 = p_1222_1_.func_207_d(this.field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_);
      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      boolean var10 = p_1222_1_.func_260_c(this.field_1772_a, p_1222_2_, p_1222_3_ + 1, p_1222_4_, 1);
      boolean var11 = p_1222_1_.func_260_c(this.field_1772_a, p_1222_2_, p_1222_3_ - 1, p_1222_4_, 0);
      boolean[] var12 = new boolean[]{p_1222_1_.func_260_c(this.field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_ - 1, 2), p_1222_1_.func_260_c(this.field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_ + 1, 3), p_1222_1_.func_260_c(this.field_1772_a, p_1222_2_ - 1, p_1222_3_, p_1222_4_, 4), p_1222_1_.func_260_c(this.field_1772_a, p_1222_2_ + 1, p_1222_3_, p_1222_4_, 5)};
      if(!var10 && !var11 && !var12[0] && !var12[1] && !var12[2] && !var12[3]) {
         return false;
      } else {
         boolean var13 = false;
         float var14 = 0.5F;
         float var15 = 1.0F;
         float var16 = 0.8F;
         float var17 = 0.6F;
         double var18 = 0.0D;
         double var20 = 1.0D;
         Material var22 = p_1222_1_.field_356_bn;
         int var23 = this.field_1772_a.func_602_e(p_1222_2_, p_1222_3_, p_1222_4_);
         double var24 = (double)this.func_1224_a(p_1222_2_, p_1222_3_, p_1222_4_, var22);
         double var26 = (double)this.func_1224_a(p_1222_2_, p_1222_3_, p_1222_4_ + 1, var22);
         double var28 = (double)this.func_1224_a(p_1222_2_ + 1, p_1222_3_, p_1222_4_ + 1, var22);
         double var30 = (double)this.func_1224_a(p_1222_2_ + 1, p_1222_3_, p_1222_4_, var22);
         double var32 = 0.0010000000474974513D;
         int var34;
         int var37;
         if(this.field_1773_d || var10) {
            var13 = true;
            var34 = p_1222_1_.func_232_a(1, var23);
            float var35 = (float)BlockFluid.func_293_a(this.field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_, var22);
            if(var35 > -999.0F) {
               var34 = p_1222_1_.func_232_a(2, var23);
            }

            var24 -= var32;
            var26 -= var32;
            var28 -= var32;
            var30 -= var32;
            int var36 = (var34 & 15) << 4;
            var37 = var34 & 240;
            double var38 = ((double)var36 + 8.0D) / 256.0D;
            double var40 = ((double)var37 + 8.0D) / 256.0D;
            if(var35 < -999.0F) {
               var35 = 0.0F;
            } else {
               var38 = (double)((float)(var36 + 16) / 256.0F);
               var40 = (double)((float)(var37 + 16) / 256.0F);
            }

            double var42 = (double)(MathHelper.func_1106_a(var35) * 8.0F) / 256.0D;
            double var44 = (double)(MathHelper.func_1114_b(var35) * 8.0F) / 256.0D;
            var5.func_35835_b(p_1222_1_.func_35275_c(this.field_1772_a, p_1222_2_, p_1222_3_, p_1222_4_));
            float var46 = 1.0F;
            var5.func_987_a(var15 * var46 * var7, var15 * var46 * var8, var15 * var46 * var9);
            var5.func_983_a((double)(p_1222_2_ + 0), (double)p_1222_3_ + var24, (double)(p_1222_4_ + 0), var38 - var44 - var42, var40 - var44 + var42);
            var5.func_983_a((double)(p_1222_2_ + 0), (double)p_1222_3_ + var26, (double)(p_1222_4_ + 1), var38 - var44 + var42, var40 + var44 + var42);
            var5.func_983_a((double)(p_1222_2_ + 1), (double)p_1222_3_ + var28, (double)(p_1222_4_ + 1), var38 + var44 + var42, var40 + var44 - var42);
            var5.func_983_a((double)(p_1222_2_ + 1), (double)p_1222_3_ + var30, (double)(p_1222_4_ + 0), var38 + var44 - var42, var40 - var44 - var42);
         }

         if(this.field_1773_d || var11) {
            var5.func_35835_b(p_1222_1_.func_35275_c(this.field_1772_a, p_1222_2_, p_1222_3_ - 1, p_1222_4_));
            float var64 = 1.0F;
            var5.func_987_a(var14 * var64, var14 * var64, var14 * var64);
            this.func_1244_a(p_1222_1_, (double)p_1222_2_, (double)p_1222_3_ + var32, (double)p_1222_4_, p_1222_1_.func_218_a(0));
            var13 = true;
         }

         for(var34 = 0; var34 < 4; ++var34) {
            int var65 = p_1222_2_;
            var37 = p_1222_4_;
            if(var34 == 0) {
               var37 = p_1222_4_ - 1;
            }

            if(var34 == 1) {
               ++var37;
            }

            if(var34 == 2) {
               var65 = p_1222_2_ - 1;
            }

            if(var34 == 3) {
               ++var65;
            }

            int var66 = p_1222_1_.func_232_a(var34 + 2, var23);
            int var39 = (var66 & 15) << 4;
            int var67 = var66 & 240;
            if(this.field_1773_d || var12[var34]) {
               double var41;
               double var43;
               double var45;
               double var47;
               double var49;
               double var51;
               if(var34 == 0) {
                  var41 = var24;
                  var43 = var30;
                  var45 = (double)p_1222_2_;
                  var49 = (double)(p_1222_2_ + 1);
                  var47 = (double)p_1222_4_ + var32;
                  var51 = (double)p_1222_4_ + var32;
               } else if(var34 == 1) {
                  var41 = var28;
                  var43 = var26;
                  var45 = (double)(p_1222_2_ + 1);
                  var49 = (double)p_1222_2_;
                  var47 = (double)(p_1222_4_ + 1) - var32;
                  var51 = (double)(p_1222_4_ + 1) - var32;
               } else if(var34 == 2) {
                  var41 = var26;
                  var43 = var24;
                  var45 = (double)p_1222_2_ + var32;
                  var49 = (double)p_1222_2_ + var32;
                  var47 = (double)(p_1222_4_ + 1);
                  var51 = (double)p_1222_4_;
               } else {
                  var41 = var30;
                  var43 = var28;
                  var45 = (double)(p_1222_2_ + 1) - var32;
                  var49 = (double)(p_1222_2_ + 1) - var32;
                  var47 = (double)p_1222_4_;
                  var51 = (double)(p_1222_4_ + 1);
               }

               var13 = true;
               double var53 = (double)((float)(var39 + 0) / 256.0F);
               double var55 = ((double)(var39 + 16) - 0.01D) / 256.0D;
               double var57 = ((double)var67 + (1.0D - var41) * 16.0D) / 256.0D;
               double var59 = ((double)var67 + (1.0D - var43) * 16.0D) / 256.0D;
               double var61 = ((double)(var67 + 16) - 0.01D) / 256.0D;
               var5.func_35835_b(p_1222_1_.func_35275_c(this.field_1772_a, var65, p_1222_3_, var37));
               float var63 = 1.0F;
               if(var34 < 2) {
                  var63 *= var16;
               } else {
                  var63 *= var17;
               }

               var5.func_987_a(var15 * var63 * var7, var15 * var63 * var8, var15 * var63 * var9);
               var5.func_983_a(var45, (double)p_1222_3_ + var41, var47, var53, var57);
               var5.func_983_a(var49, (double)p_1222_3_ + var43, var51, var55, var59);
               var5.func_983_a(var49, (double)(p_1222_3_ + 0), var51, var55, var61);
               var5.func_983_a(var45, (double)(p_1222_3_ + 0), var47, var53, var61);
            }
         }

         p_1222_1_.field_368_bg = var18;
         p_1222_1_.field_362_bj = var20;
         return var13;
      }
   }

   private float func_1224_a(int p_1224_1_, int p_1224_2_, int p_1224_3_, Material p_1224_4_) {
      int var5 = 0;
      float var6 = 0.0F;

      for(int var7 = 0; var7 < 4; ++var7) {
         int var8 = p_1224_1_ - (var7 & 1);
         int var10 = p_1224_3_ - (var7 >> 1 & 1);
         if(this.field_1772_a.func_599_f(var8, p_1224_2_ + 1, var10) == p_1224_4_) {
            return 1.0F;
         }

         Material var11 = this.field_1772_a.func_599_f(var8, p_1224_2_, var10);
         if(var11 == p_1224_4_) {
            int var12 = this.field_1772_a.func_602_e(var8, p_1224_2_, var10);
            if(var12 >= 8 || var12 == 0) {
               var6 += BlockFluid.func_288_b(var12) * 10.0F;
               var5 += 10;
            }

            var6 += BlockFluid.func_288_b(var12);
            ++var5;
         } else if(!var11.func_878_a()) {
            ++var6;
            ++var5;
         }
      }

      return 1.0F - var6 / (float)var5;
   }

   public void func_1243_a(Block p_1243_1_, World p_1243_2_, int p_1243_3_, int p_1243_4_, int p_1243_5_) {
      float var6 = 0.5F;
      float var7 = 1.0F;
      float var8 = 0.8F;
      float var9 = 0.6F;
      Tessellator var10 = Tessellator.field_1512_a;
      var10.func_977_b();
      var10.func_35835_b(p_1243_1_.func_35275_c(p_1243_2_, p_1243_3_, p_1243_4_, p_1243_5_));
      float var11 = 1.0F;
      float var12 = 1.0F;
      if(var12 < var11) {
         var12 = var11;
      }

      var10.func_987_a(var6 * var12, var6 * var12, var6 * var12);
      this.func_1244_a(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(0));
      var12 = 1.0F;
      if(var12 < var11) {
         var12 = var11;
      }

      var10.func_987_a(var7 * var12, var7 * var12, var7 * var12);
      this.func_1217_b(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(1));
      var12 = 1.0F;
      if(var12 < var11) {
         var12 = var11;
      }

      var10.func_987_a(var8 * var12, var8 * var12, var8 * var12);
      this.func_1220_c(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(2));
      var12 = 1.0F;
      if(var12 < var11) {
         var12 = var11;
      }

      var10.func_987_a(var8 * var12, var8 * var12, var8 * var12);
      this.func_1225_d(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(3));
      var12 = 1.0F;
      if(var12 < var11) {
         var12 = var11;
      }

      var10.func_987_a(var9 * var12, var9 * var12, var9 * var12);
      this.func_1231_e(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(4));
      var12 = 1.0F;
      if(var12 < var11) {
         var12 = var11;
      }

      var10.func_987_a(var9 * var12, var9 * var12, var9 * var12);
      this.func_1236_f(p_1243_1_, -0.5D, -0.5D, -0.5D, p_1243_1_.func_218_a(5));
      var10.func_982_a();
   }

   public boolean func_1228_k(Block p_1228_1_, int p_1228_2_, int p_1228_3_, int p_1228_4_) {
      int var5 = p_1228_1_.func_207_d(this.field_1772_a, p_1228_2_, p_1228_3_, p_1228_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_28135_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return Minecraft.func_22005_v() && Block.field_339_t[p_1228_1_.field_376_bc] == 0?this.func_22330_a(p_1228_1_, p_1228_2_, p_1228_3_, p_1228_4_, var6, var7, var8):this.func_4152_a(p_1228_1_, p_1228_2_, p_1228_3_, p_1228_4_, var6, var7, var8);
   }

   public boolean func_22330_a(Block p_22330_1_, int p_22330_2_, int p_22330_3_, int p_22330_4_, float p_22330_5_, float p_22330_6_, float p_22330_7_) {
      this.field_22385_e = true;
      boolean var8 = false;
      float var9 = this.field_22384_f;
      float var10 = this.field_22384_f;
      float var11 = this.field_22384_f;
      float var12 = this.field_22384_f;
      boolean var13 = true;
      boolean var14 = true;
      boolean var15 = true;
      boolean var16 = true;
      boolean var17 = true;
      boolean var18 = true;
      this.field_22384_f = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_);
      this.field_22383_g = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
      this.field_22382_h = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
      this.field_22381_i = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
      this.field_22380_j = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
      this.field_22379_k = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
      this.field_22378_l = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
      int var19 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_);
      int var20 = var19;
      int var21 = var19;
      int var22 = var19;
      int var23 = var19;
      int var24 = var19;
      int var25 = var19;
      if(p_22330_1_.field_368_bg <= 0.0D) {
         var21 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
      }

      if(p_22330_1_.field_362_bj >= 1.0D) {
         var24 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
      }

      if(p_22330_1_.field_370_bf <= 0.0D) {
         var20 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
      }

      if(p_22330_1_.field_364_bi >= 1.0D) {
         var23 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
      }

      if(p_22330_1_.field_366_bh <= 0.0D) {
         var22 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
      }

      if(p_22330_1_.field_360_bk >= 1.0D) {
         var25 = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
      }

      Tessellator var26 = Tessellator.field_1512_a;
      var26.func_35835_b(983055);
      this.field_22338_U = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_)];
      this.field_22359_ac = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_)];
      this.field_22334_Y = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1)];
      this.field_22363_aa = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1)];
      this.field_22337_V = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_)];
      this.field_22357_ad = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_)];
      this.field_22335_X = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1)];
      this.field_22333_Z = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1)];
      this.field_22336_W = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1)];
      this.field_22339_T = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1)];
      this.field_22355_ae = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1)];
      this.field_22361_ab = Block.field_340_s[this.field_1772_a.func_600_a(p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1)];
      if(p_22330_1_.field_378_bb == 3) {
         var18 = false;
         var17 = false;
         var16 = false;
         var15 = false;
         var13 = false;
      }

      if(this.field_1771_b >= 0) {
         var18 = false;
         var17 = false;
         var16 = false;
         var15 = false;
         var13 = false;
      }

      if(this.field_1773_d || p_22330_1_.func_260_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_, 0)) {
         if(this.field_35946_aj > 0) {
            if(p_22330_1_.field_368_bg <= 0.0D) {
               --p_22330_3_;
            }

            this.field_35935_Q = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_35937_S = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_35932_T = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_35934_V = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            this.field_22376_n = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_22374_p = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_22373_q = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_22371_s = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            if(!this.field_22361_ab && !this.field_22357_ad) {
               this.field_22377_m = this.field_22376_n;
               this.field_35936_P = this.field_35935_Q;
            } else {
               this.field_22377_m = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
               this.field_35936_P = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
            }

            if(!this.field_22355_ae && !this.field_22357_ad) {
               this.field_22375_o = this.field_22376_n;
               this.field_35938_R = this.field_35935_Q;
            } else {
               this.field_22375_o = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
               this.field_35938_R = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
            }

            if(!this.field_22361_ab && !this.field_22359_ac) {
               this.field_22372_r = this.field_22371_s;
               this.field_35931_U = this.field_35934_V;
            } else {
               this.field_22372_r = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
               this.field_35931_U = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
            }

            if(!this.field_22355_ae && !this.field_22359_ac) {
               this.field_22370_t = this.field_22371_s;
               this.field_35933_W = this.field_35934_V;
            } else {
               this.field_22370_t = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
               this.field_35933_W = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
            }

            if(p_22330_1_.field_368_bg <= 0.0D) {
               ++p_22330_3_;
            }

            var9 = (this.field_22375_o + this.field_22376_n + this.field_22373_q + this.field_22382_h) / 4.0F;
            var12 = (this.field_22373_q + this.field_22382_h + this.field_22370_t + this.field_22371_s) / 4.0F;
            var11 = (this.field_22382_h + this.field_22374_p + this.field_22371_s + this.field_22372_r) / 4.0F;
            var10 = (this.field_22376_n + this.field_22377_m + this.field_22382_h + this.field_22374_p) / 4.0F;
            this.field_35943_ak = this.func_35924_c(this.field_35938_R, this.field_35935_Q, this.field_35932_T, var21);
            this.field_35948_an = this.func_35924_c(this.field_35932_T, this.field_35933_W, this.field_35934_V, var21);
            this.field_35947_am = this.func_35924_c(this.field_35937_S, this.field_35934_V, this.field_35931_U, var21);
            this.field_35944_al = this.func_35924_c(this.field_35935_Q, this.field_35936_P, this.field_35937_S, var21);
         } else {
            var12 = this.field_22382_h;
            var11 = this.field_22382_h;
            var10 = this.field_22382_h;
            var9 = this.field_22382_h;
            this.field_35943_ak = this.field_35944_al = this.field_35947_am = this.field_35948_an = this.field_35935_Q;
         }

         this.field_22351_H = this.field_22350_I = this.field_22349_J = this.field_22348_K = (var13?p_22330_5_:1.0F) * 0.5F;
         this.field_22347_L = this.field_22346_M = this.field_22345_N = this.field_22344_O = (var13?p_22330_6_:1.0F) * 0.5F;
         this.field_22343_P = this.field_22342_Q = this.field_22341_R = this.field_22340_S = (var13?p_22330_7_:1.0F) * 0.5F;
         this.field_22351_H *= var9;
         this.field_22347_L *= var9;
         this.field_22343_P *= var9;
         this.field_22350_I *= var10;
         this.field_22346_M *= var10;
         this.field_22342_Q *= var10;
         this.field_22349_J *= var11;
         this.field_22345_N *= var11;
         this.field_22341_R *= var11;
         this.field_22348_K *= var12;
         this.field_22344_O *= var12;
         this.field_22340_S *= var12;
         this.func_1244_a(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 0));
         var8 = true;
      }

      if(this.field_1773_d || p_22330_1_.func_260_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_, 1)) {
         if(this.field_35946_aj > 0) {
            if(p_22330_1_.field_362_bj >= 1.0D) {
               ++p_22330_3_;
            }

            this.field_35939_Y = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_35949_ac = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            this.field_35951_aa = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_35950_ad = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_22368_v = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_22364_z = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            this.field_22366_x = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_22362_A = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            if(!this.field_22339_T && !this.field_22337_V) {
               this.field_22369_u = this.field_22368_v;
               this.field_35940_X = this.field_35939_Y;
            } else {
               this.field_22369_u = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
               this.field_35940_X = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ - 1);
            }

            if(!this.field_22339_T && !this.field_22338_U) {
               this.field_22365_y = this.field_22364_z;
               this.field_35952_ab = this.field_35949_ac;
            } else {
               this.field_22365_y = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
               this.field_35952_ab = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ - 1);
            }

            if(!this.field_22336_W && !this.field_22337_V) {
               this.field_22367_w = this.field_22368_v;
               this.field_35941_Z = this.field_35939_Y;
            } else {
               this.field_22367_w = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
               this.field_35941_Z = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_ + 1);
            }

            if(!this.field_22336_W && !this.field_22338_U) {
               this.field_22360_B = this.field_22364_z;
               this.field_35955_ae = this.field_35949_ac;
            } else {
               this.field_22360_B = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
               this.field_35955_ae = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_ + 1);
            }

            if(p_22330_1_.field_362_bj >= 1.0D) {
               --p_22330_3_;
            }

            var12 = (this.field_22367_w + this.field_22368_v + this.field_22362_A + this.field_22379_k) / 4.0F;
            var9 = (this.field_22362_A + this.field_22379_k + this.field_22360_B + this.field_22364_z) / 4.0F;
            var10 = (this.field_22379_k + this.field_22366_x + this.field_22364_z + this.field_22365_y) / 4.0F;
            var11 = (this.field_22368_v + this.field_22369_u + this.field_22379_k + this.field_22366_x) / 4.0F;
            this.field_35948_an = this.func_35924_c(this.field_35941_Z, this.field_35939_Y, this.field_35950_ad, var24);
            this.field_35943_ak = this.func_35924_c(this.field_35950_ad, this.field_35955_ae, this.field_35949_ac, var24);
            this.field_35944_al = this.func_35924_c(this.field_35951_aa, this.field_35949_ac, this.field_35952_ab, var24);
            this.field_35947_am = this.func_35924_c(this.field_35939_Y, this.field_35940_X, this.field_35951_aa, var24);
         } else {
            var12 = this.field_22379_k;
            var11 = this.field_22379_k;
            var10 = this.field_22379_k;
            var9 = this.field_22379_k;
            this.field_35943_ak = this.field_35944_al = this.field_35947_am = this.field_35948_an = var24;
         }

         this.field_22351_H = this.field_22350_I = this.field_22349_J = this.field_22348_K = var14?p_22330_5_:1.0F;
         this.field_22347_L = this.field_22346_M = this.field_22345_N = this.field_22344_O = var14?p_22330_6_:1.0F;
         this.field_22343_P = this.field_22342_Q = this.field_22341_R = this.field_22340_S = var14?p_22330_7_:1.0F;
         this.field_22351_H *= var9;
         this.field_22347_L *= var9;
         this.field_22343_P *= var9;
         this.field_22350_I *= var10;
         this.field_22346_M *= var10;
         this.field_22342_Q *= var10;
         this.field_22349_J *= var11;
         this.field_22345_N *= var11;
         this.field_22341_R *= var11;
         this.field_22348_K *= var12;
         this.field_22344_O *= var12;
         this.field_22340_S *= var12;
         this.func_1217_b(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 1));
         var8 = true;
      }

      int var27;
      if(this.field_1773_d || p_22330_1_.func_260_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1, 2)) {
         if(this.field_35946_aj > 0) {
            if(p_22330_1_.field_366_bh <= 0.0D) {
               --p_22330_4_;
            }

            this.field_22358_C = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_22374_p = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_22366_x = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            this.field_22356_D = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            this.field_35956_af = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_35937_S = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_35951_aa = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            this.field_35953_ag = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            if(!this.field_22335_X && !this.field_22361_ab) {
               this.field_22377_m = this.field_22358_C;
               this.field_35936_P = this.field_35956_af;
            } else {
               this.field_22377_m = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
               this.field_35936_P = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
            }

            if(!this.field_22335_X && !this.field_22339_T) {
               this.field_22369_u = this.field_22358_C;
               this.field_35940_X = this.field_35956_af;
            } else {
               this.field_22369_u = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
               this.field_35940_X = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
            }

            if(!this.field_22363_aa && !this.field_22361_ab) {
               this.field_22372_r = this.field_22356_D;
               this.field_35931_U = this.field_35953_ag;
            } else {
               this.field_22372_r = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
               this.field_35931_U = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
            }

            if(!this.field_22363_aa && !this.field_22339_T) {
               this.field_22365_y = this.field_22356_D;
               this.field_35952_ab = this.field_35953_ag;
            } else {
               this.field_22365_y = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
               this.field_35952_ab = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
            }

            if(p_22330_1_.field_366_bh <= 0.0D) {
               ++p_22330_4_;
            }

            var9 = (this.field_22358_C + this.field_22369_u + this.field_22381_i + this.field_22366_x) / 4.0F;
            var10 = (this.field_22381_i + this.field_22366_x + this.field_22356_D + this.field_22365_y) / 4.0F;
            var11 = (this.field_22374_p + this.field_22381_i + this.field_22372_r + this.field_22356_D) / 4.0F;
            var12 = (this.field_22377_m + this.field_22358_C + this.field_22374_p + this.field_22381_i) / 4.0F;
            this.field_35943_ak = this.func_35924_c(this.field_35956_af, this.field_35940_X, this.field_35951_aa, var22);
            this.field_35944_al = this.func_35924_c(this.field_35951_aa, this.field_35953_ag, this.field_35952_ab, var22);
            this.field_35947_am = this.func_35924_c(this.field_35937_S, this.field_35931_U, this.field_35953_ag, var22);
            this.field_35948_an = this.func_35924_c(this.field_35936_P, this.field_35956_af, this.field_35937_S, var22);
         } else {
            var12 = this.field_22381_i;
            var11 = this.field_22381_i;
            var10 = this.field_22381_i;
            var9 = this.field_22381_i;
            this.field_35943_ak = this.field_35944_al = this.field_35947_am = this.field_35948_an = var22;
         }

         this.field_22351_H = this.field_22350_I = this.field_22349_J = this.field_22348_K = (var15?p_22330_5_:1.0F) * 0.8F;
         this.field_22347_L = this.field_22346_M = this.field_22345_N = this.field_22344_O = (var15?p_22330_6_:1.0F) * 0.8F;
         this.field_22343_P = this.field_22342_Q = this.field_22341_R = this.field_22340_S = (var15?p_22330_7_:1.0F) * 0.8F;
         this.field_22351_H *= var9;
         this.field_22347_L *= var9;
         this.field_22343_P *= var9;
         this.field_22350_I *= var10;
         this.field_22346_M *= var10;
         this.field_22342_Q *= var10;
         this.field_22349_J *= var11;
         this.field_22345_N *= var11;
         this.field_22341_R *= var11;
         this.field_22348_K *= var12;
         this.field_22344_O *= var12;
         this.field_22340_S *= var12;
         var27 = p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 2);
         this.func_1220_c(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, var27);
         if(field_27406_a && var27 == 3 && this.field_1771_b < 0) {
            this.field_22351_H *= p_22330_5_;
            this.field_22350_I *= p_22330_5_;
            this.field_22349_J *= p_22330_5_;
            this.field_22348_K *= p_22330_5_;
            this.field_22347_L *= p_22330_6_;
            this.field_22346_M *= p_22330_6_;
            this.field_22345_N *= p_22330_6_;
            this.field_22344_O *= p_22330_6_;
            this.field_22343_P *= p_22330_7_;
            this.field_22342_Q *= p_22330_7_;
            this.field_22341_R *= p_22330_7_;
            this.field_22340_S *= p_22330_7_;
            this.func_1220_c(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, 38);
         }

         var8 = true;
      }

      if(this.field_1773_d || p_22330_1_.func_260_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1, 3)) {
         if(this.field_35946_aj > 0) {
            if(p_22330_1_.field_360_bk >= 1.0D) {
               ++p_22330_4_;
            }

            this.field_22354_E = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_22353_F = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            this.field_22373_q = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_22362_A = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            this.field_35954_ah = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_);
            this.field_35945_ai = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_);
            this.field_35932_T = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_35950_ad = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            if(!this.field_22333_Z && !this.field_22355_ae) {
               this.field_22375_o = this.field_22354_E;
               this.field_35938_R = this.field_35954_ah;
            } else {
               this.field_22375_o = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
               this.field_35938_R = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ - 1, p_22330_4_);
            }

            if(!this.field_22333_Z && !this.field_22336_W) {
               this.field_22367_w = this.field_22354_E;
               this.field_35941_Z = this.field_35954_ah;
            } else {
               this.field_22367_w = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
               this.field_35941_Z = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_ + 1, p_22330_4_);
            }

            if(!this.field_22334_Y && !this.field_22355_ae) {
               this.field_22370_t = this.field_22353_F;
               this.field_35933_W = this.field_35945_ai;
            } else {
               this.field_22370_t = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
               this.field_35933_W = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ - 1, p_22330_4_);
            }

            if(!this.field_22334_Y && !this.field_22336_W) {
               this.field_22360_B = this.field_22353_F;
               this.field_35955_ae = this.field_35945_ai;
            } else {
               this.field_22360_B = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
               this.field_35955_ae = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_ + 1, p_22330_4_);
            }

            if(p_22330_1_.field_360_bk >= 1.0D) {
               --p_22330_4_;
            }

            var9 = (this.field_22354_E + this.field_22367_w + this.field_22378_l + this.field_22362_A) / 4.0F;
            var12 = (this.field_22378_l + this.field_22362_A + this.field_22353_F + this.field_22360_B) / 4.0F;
            var11 = (this.field_22373_q + this.field_22378_l + this.field_22370_t + this.field_22353_F) / 4.0F;
            var10 = (this.field_22375_o + this.field_22354_E + this.field_22373_q + this.field_22378_l) / 4.0F;
            this.field_35943_ak = this.func_35924_c(this.field_35954_ah, this.field_35941_Z, this.field_35950_ad, var25);
            this.field_35948_an = this.func_35924_c(this.field_35950_ad, this.field_35945_ai, this.field_35955_ae, var25);
            this.field_35947_am = this.func_35924_c(this.field_35932_T, this.field_35933_W, this.field_35945_ai, var25);
            this.field_35944_al = this.func_35924_c(this.field_35938_R, this.field_35954_ah, this.field_35932_T, var25);
         } else {
            var12 = this.field_22378_l;
            var11 = this.field_22378_l;
            var10 = this.field_22378_l;
            var9 = this.field_22378_l;
            this.field_35943_ak = this.field_35944_al = this.field_35947_am = this.field_35948_an = var25;
         }

         this.field_22351_H = this.field_22350_I = this.field_22349_J = this.field_22348_K = (var16?p_22330_5_:1.0F) * 0.8F;
         this.field_22347_L = this.field_22346_M = this.field_22345_N = this.field_22344_O = (var16?p_22330_6_:1.0F) * 0.8F;
         this.field_22343_P = this.field_22342_Q = this.field_22341_R = this.field_22340_S = (var16?p_22330_7_:1.0F) * 0.8F;
         this.field_22351_H *= var9;
         this.field_22347_L *= var9;
         this.field_22343_P *= var9;
         this.field_22350_I *= var10;
         this.field_22346_M *= var10;
         this.field_22342_Q *= var10;
         this.field_22349_J *= var11;
         this.field_22345_N *= var11;
         this.field_22341_R *= var11;
         this.field_22348_K *= var12;
         this.field_22344_O *= var12;
         this.field_22340_S *= var12;
         var27 = p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 3);
         this.func_1225_d(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 3));
         if(field_27406_a && var27 == 3 && this.field_1771_b < 0) {
            this.field_22351_H *= p_22330_5_;
            this.field_22350_I *= p_22330_5_;
            this.field_22349_J *= p_22330_5_;
            this.field_22348_K *= p_22330_5_;
            this.field_22347_L *= p_22330_6_;
            this.field_22346_M *= p_22330_6_;
            this.field_22345_N *= p_22330_6_;
            this.field_22344_O *= p_22330_6_;
            this.field_22343_P *= p_22330_7_;
            this.field_22342_Q *= p_22330_7_;
            this.field_22341_R *= p_22330_7_;
            this.field_22340_S *= p_22330_7_;
            this.func_1225_d(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, 38);
         }

         var8 = true;
      }

      if(this.field_1773_d || p_22330_1_.func_260_c(this.field_1772_a, p_22330_2_ - 1, p_22330_3_, p_22330_4_, 4)) {
         if(this.field_35946_aj > 0) {
            if(p_22330_1_.field_370_bf <= 0.0D) {
               --p_22330_2_;
            }

            this.field_22376_n = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_22358_C = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_22354_E = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_22368_v = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            this.field_35935_Q = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_35956_af = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_35954_ah = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_35939_Y = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            if(!this.field_22335_X && !this.field_22357_ad) {
               this.field_22377_m = this.field_22358_C;
               this.field_35936_P = this.field_35956_af;
            } else {
               this.field_22377_m = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
               this.field_35936_P = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
            }

            if(!this.field_22333_Z && !this.field_22357_ad) {
               this.field_22375_o = this.field_22354_E;
               this.field_35938_R = this.field_35954_ah;
            } else {
               this.field_22375_o = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
               this.field_35938_R = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
            }

            if(!this.field_22335_X && !this.field_22337_V) {
               this.field_22369_u = this.field_22358_C;
               this.field_35940_X = this.field_35956_af;
            } else {
               this.field_22369_u = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
               this.field_35940_X = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
            }

            if(!this.field_22333_Z && !this.field_22337_V) {
               this.field_22367_w = this.field_22354_E;
               this.field_35941_Z = this.field_35954_ah;
            } else {
               this.field_22367_w = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
               this.field_35941_Z = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
            }

            if(p_22330_1_.field_370_bf <= 0.0D) {
               ++p_22330_2_;
            }

            var12 = (this.field_22376_n + this.field_22375_o + this.field_22383_g + this.field_22354_E) / 4.0F;
            var9 = (this.field_22383_g + this.field_22354_E + this.field_22368_v + this.field_22367_w) / 4.0F;
            var10 = (this.field_22358_C + this.field_22383_g + this.field_22369_u + this.field_22368_v) / 4.0F;
            var11 = (this.field_22377_m + this.field_22376_n + this.field_22358_C + this.field_22383_g) / 4.0F;
            this.field_35948_an = this.func_35924_c(this.field_35935_Q, this.field_35938_R, this.field_35954_ah, var20);
            this.field_35943_ak = this.func_35924_c(this.field_35954_ah, this.field_35939_Y, this.field_35941_Z, var20);
            this.field_35944_al = this.func_35924_c(this.field_35956_af, this.field_35940_X, this.field_35939_Y, var20);
            this.field_35947_am = this.func_35924_c(this.field_35936_P, this.field_35935_Q, this.field_35956_af, var20);
         } else {
            var12 = this.field_22383_g;
            var11 = this.field_22383_g;
            var10 = this.field_22383_g;
            var9 = this.field_22383_g;
            this.field_35943_ak = this.field_35944_al = this.field_35947_am = this.field_35948_an = var20;
         }

         this.field_22351_H = this.field_22350_I = this.field_22349_J = this.field_22348_K = (var17?p_22330_5_:1.0F) * 0.6F;
         this.field_22347_L = this.field_22346_M = this.field_22345_N = this.field_22344_O = (var17?p_22330_6_:1.0F) * 0.6F;
         this.field_22343_P = this.field_22342_Q = this.field_22341_R = this.field_22340_S = (var17?p_22330_7_:1.0F) * 0.6F;
         this.field_22351_H *= var9;
         this.field_22347_L *= var9;
         this.field_22343_P *= var9;
         this.field_22350_I *= var10;
         this.field_22346_M *= var10;
         this.field_22342_Q *= var10;
         this.field_22349_J *= var11;
         this.field_22345_N *= var11;
         this.field_22341_R *= var11;
         this.field_22348_K *= var12;
         this.field_22344_O *= var12;
         this.field_22340_S *= var12;
         var27 = p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 4);
         this.func_1231_e(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, var27);
         if(field_27406_a && var27 == 3 && this.field_1771_b < 0) {
            this.field_22351_H *= p_22330_5_;
            this.field_22350_I *= p_22330_5_;
            this.field_22349_J *= p_22330_5_;
            this.field_22348_K *= p_22330_5_;
            this.field_22347_L *= p_22330_6_;
            this.field_22346_M *= p_22330_6_;
            this.field_22345_N *= p_22330_6_;
            this.field_22344_O *= p_22330_6_;
            this.field_22343_P *= p_22330_7_;
            this.field_22342_Q *= p_22330_7_;
            this.field_22341_R *= p_22330_7_;
            this.field_22340_S *= p_22330_7_;
            this.func_1231_e(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, 38);
         }

         var8 = true;
      }

      if(this.field_1773_d || p_22330_1_.func_260_c(this.field_1772_a, p_22330_2_ + 1, p_22330_3_, p_22330_4_, 5)) {
         if(this.field_35946_aj > 0) {
            if(p_22330_1_.field_364_bi >= 1.0D) {
               ++p_22330_2_;
            }

            this.field_22371_s = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_22356_D = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_22353_F = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_22364_z = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            this.field_35934_V = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_);
            this.field_35953_ag = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ - 1);
            this.field_35945_ai = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_ + 1);
            this.field_35949_ac = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_);
            if(!this.field_22359_ac && !this.field_22363_aa) {
               this.field_22372_r = this.field_22356_D;
               this.field_35931_U = this.field_35953_ag;
            } else {
               this.field_22372_r = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
               this.field_35931_U = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ - 1);
            }

            if(!this.field_22359_ac && !this.field_22334_Y) {
               this.field_22370_t = this.field_22353_F;
               this.field_35933_W = this.field_35945_ai;
            } else {
               this.field_22370_t = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
               this.field_35933_W = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ - 1, p_22330_4_ + 1);
            }

            if(!this.field_22338_U && !this.field_22363_aa) {
               this.field_22365_y = this.field_22356_D;
               this.field_35952_ab = this.field_35953_ag;
            } else {
               this.field_22365_y = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
               this.field_35952_ab = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ - 1);
            }

            if(!this.field_22338_U && !this.field_22334_Y) {
               this.field_22360_B = this.field_22353_F;
               this.field_35955_ae = this.field_35945_ai;
            } else {
               this.field_22360_B = p_22330_1_.func_35276_e(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
               this.field_35955_ae = p_22330_1_.func_35275_c(this.field_1772_a, p_22330_2_, p_22330_3_ + 1, p_22330_4_ + 1);
            }

            if(p_22330_1_.field_364_bi >= 1.0D) {
               --p_22330_2_;
            }

            var9 = (this.field_22371_s + this.field_22370_t + this.field_22380_j + this.field_22353_F) / 4.0F;
            var12 = (this.field_22380_j + this.field_22353_F + this.field_22364_z + this.field_22360_B) / 4.0F;
            var11 = (this.field_22356_D + this.field_22380_j + this.field_22365_y + this.field_22364_z) / 4.0F;
            var10 = (this.field_22372_r + this.field_22371_s + this.field_22356_D + this.field_22380_j) / 4.0F;
            this.field_35943_ak = this.func_35924_c(this.field_35934_V, this.field_35933_W, this.field_35945_ai, var23);
            this.field_35948_an = this.func_35924_c(this.field_35945_ai, this.field_35949_ac, this.field_35955_ae, var23);
            this.field_35947_am = this.func_35924_c(this.field_35953_ag, this.field_35952_ab, this.field_35949_ac, var23);
            this.field_35944_al = this.func_35924_c(this.field_35931_U, this.field_35934_V, this.field_35953_ag, var23);
         } else {
            var12 = this.field_22380_j;
            var11 = this.field_22380_j;
            var10 = this.field_22380_j;
            var9 = this.field_22380_j;
            this.field_35943_ak = this.field_35944_al = this.field_35947_am = this.field_35948_an = var23;
         }

         this.field_22351_H = this.field_22350_I = this.field_22349_J = this.field_22348_K = (var18?p_22330_5_:1.0F) * 0.6F;
         this.field_22347_L = this.field_22346_M = this.field_22345_N = this.field_22344_O = (var18?p_22330_6_:1.0F) * 0.6F;
         this.field_22343_P = this.field_22342_Q = this.field_22341_R = this.field_22340_S = (var18?p_22330_7_:1.0F) * 0.6F;
         this.field_22351_H *= var9;
         this.field_22347_L *= var9;
         this.field_22343_P *= var9;
         this.field_22350_I *= var10;
         this.field_22346_M *= var10;
         this.field_22342_Q *= var10;
         this.field_22349_J *= var11;
         this.field_22345_N *= var11;
         this.field_22341_R *= var11;
         this.field_22348_K *= var12;
         this.field_22344_O *= var12;
         this.field_22340_S *= var12;
         var27 = p_22330_1_.func_211_a(this.field_1772_a, p_22330_2_, p_22330_3_, p_22330_4_, 5);
         this.func_1236_f(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, var27);
         if(field_27406_a && var27 == 3 && this.field_1771_b < 0) {
            this.field_22351_H *= p_22330_5_;
            this.field_22350_I *= p_22330_5_;
            this.field_22349_J *= p_22330_5_;
            this.field_22348_K *= p_22330_5_;
            this.field_22347_L *= p_22330_6_;
            this.field_22346_M *= p_22330_6_;
            this.field_22345_N *= p_22330_6_;
            this.field_22344_O *= p_22330_6_;
            this.field_22343_P *= p_22330_7_;
            this.field_22342_Q *= p_22330_7_;
            this.field_22341_R *= p_22330_7_;
            this.field_22340_S *= p_22330_7_;
            this.func_1236_f(p_22330_1_, (double)p_22330_2_, (double)p_22330_3_, (double)p_22330_4_, 38);
         }

         var8 = true;
      }

      this.field_22385_e = false;
      return var8;
   }

   private int func_35924_c(int p_35924_1_, int p_35924_2_, int p_35924_3_, int p_35924_4_) {
      if(p_35924_1_ == 0) {
         p_35924_1_ = p_35924_4_;
      }

      if(p_35924_2_ == 0) {
         p_35924_2_ = p_35924_4_;
      }

      if(p_35924_3_ == 0) {
         p_35924_3_ = p_35924_4_;
      }

      return p_35924_1_ + p_35924_2_ + p_35924_3_ + p_35924_4_ >> 2 & 16711935;
   }

   public boolean func_4152_a(Block p_4152_1_, int p_4152_2_, int p_4152_3_, int p_4152_4_, float p_4152_5_, float p_4152_6_, float p_4152_7_) {
      this.field_22385_e = false;
      Tessellator var8 = Tessellator.field_1512_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var11 * p_4152_5_;
      float var15 = var11 * p_4152_6_;
      float var16 = var11 * p_4152_7_;
      float var17 = var10;
      float var18 = var12;
      float var19 = var13;
      float var20 = var10;
      float var21 = var12;
      float var22 = var13;
      float var23 = var10;
      float var24 = var12;
      float var25 = var13;
      if(p_4152_1_ != Block.field_337_v) {
         var17 = var10 * p_4152_5_;
         var18 = var12 * p_4152_5_;
         var19 = var13 * p_4152_5_;
         var20 = var10 * p_4152_6_;
         var21 = var12 * p_4152_6_;
         var22 = var13 * p_4152_6_;
         var23 = var10 * p_4152_7_;
         var24 = var12 * p_4152_7_;
         var25 = var13 * p_4152_7_;
      }

      int var26 = p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_);
      if(this.field_1773_d || p_4152_1_.func_260_c(this.field_1772_a, p_4152_2_, p_4152_3_ - 1, p_4152_4_, 0)) {
         var8.func_35835_b(p_4152_1_.field_368_bg > 0.0D?var26:p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_, p_4152_3_ - 1, p_4152_4_));
         var8.func_987_a(var17, var20, var23);
         this.func_1244_a(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, p_4152_1_.func_211_a(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 0));
         var9 = true;
      }

      if(this.field_1773_d || p_4152_1_.func_260_c(this.field_1772_a, p_4152_2_, p_4152_3_ + 1, p_4152_4_, 1)) {
         var8.func_35835_b(p_4152_1_.field_362_bj < 1.0D?var26:p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_, p_4152_3_ + 1, p_4152_4_));
         var8.func_987_a(var14, var15, var16);
         this.func_1217_b(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, p_4152_1_.func_211_a(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 1));
         var9 = true;
      }

      int var28;
      if(this.field_1773_d || p_4152_1_.func_260_c(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ - 1, 2)) {
         var8.func_35835_b(p_4152_1_.field_366_bh > 0.0D?var26:p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ - 1));
         var8.func_987_a(var18, var21, var24);
         var28 = p_4152_1_.func_211_a(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 2);
         this.func_1220_c(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, var28);
         if(field_27406_a && var28 == 3 && this.field_1771_b < 0) {
            var8.func_987_a(var18 * p_4152_5_, var21 * p_4152_6_, var24 * p_4152_7_);
            this.func_1220_c(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, 38);
         }

         var9 = true;
      }

      if(this.field_1773_d || p_4152_1_.func_260_c(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ + 1, 3)) {
         var8.func_35835_b(p_4152_1_.field_360_bk < 1.0D?var26:p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_ + 1));
         var8.func_987_a(var18, var21, var24);
         var28 = p_4152_1_.func_211_a(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 3);
         this.func_1225_d(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, var28);
         if(field_27406_a && var28 == 3 && this.field_1771_b < 0) {
            var8.func_987_a(var18 * p_4152_5_, var21 * p_4152_6_, var24 * p_4152_7_);
            this.func_1225_d(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, 38);
         }

         var9 = true;
      }

      if(this.field_1773_d || p_4152_1_.func_260_c(this.field_1772_a, p_4152_2_ - 1, p_4152_3_, p_4152_4_, 4)) {
         var8.func_35835_b(p_4152_1_.field_370_bf > 0.0D?var26:p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_ - 1, p_4152_3_, p_4152_4_));
         var8.func_987_a(var19, var22, var25);
         var28 = p_4152_1_.func_211_a(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 4);
         this.func_1231_e(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, var28);
         if(field_27406_a && var28 == 3 && this.field_1771_b < 0) {
            var8.func_987_a(var19 * p_4152_5_, var22 * p_4152_6_, var25 * p_4152_7_);
            this.func_1231_e(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, 38);
         }

         var9 = true;
      }

      if(this.field_1773_d || p_4152_1_.func_260_c(this.field_1772_a, p_4152_2_ + 1, p_4152_3_, p_4152_4_, 5)) {
         var8.func_35835_b(p_4152_1_.field_364_bi < 1.0D?var26:p_4152_1_.func_35275_c(this.field_1772_a, p_4152_2_ + 1, p_4152_3_, p_4152_4_));
         var8.func_987_a(var19, var22, var25);
         var28 = p_4152_1_.func_211_a(this.field_1772_a, p_4152_2_, p_4152_3_, p_4152_4_, 5);
         this.func_1236_f(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, var28);
         if(field_27406_a && var28 == 3 && this.field_1771_b < 0) {
            var8.func_987_a(var19 * p_4152_5_, var22 * p_4152_6_, var25 * p_4152_7_);
            this.func_1236_f(p_4152_1_, (double)p_4152_2_, (double)p_4152_3_, (double)p_4152_4_, 38);
         }

         var9 = true;
      }

      return var9;
   }

   public boolean func_1233_l(Block p_1233_1_, int p_1233_2_, int p_1233_3_, int p_1233_4_) {
      int var5 = p_1233_1_.func_207_d(this.field_1772_a, p_1233_2_, p_1233_3_, p_1233_4_);
      float var6 = (float)(var5 >> 16 & 255) / 255.0F;
      float var7 = (float)(var5 >> 8 & 255) / 255.0F;
      float var8 = (float)(var5 & 255) / 255.0F;
      if(EntityRenderer.field_28135_a) {
         float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
         float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
         float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
         var6 = var9;
         var7 = var10;
         var8 = var11;
      }

      return this.func_1230_b(p_1233_1_, p_1233_2_, p_1233_3_, p_1233_4_, var6, var7, var8);
   }

   public boolean func_1230_b(Block p_1230_1_, int p_1230_2_, int p_1230_3_, int p_1230_4_, float p_1230_5_, float p_1230_6_, float p_1230_7_) {
      Tessellator var8 = Tessellator.field_1512_a;
      boolean var9 = false;
      float var10 = 0.5F;
      float var11 = 1.0F;
      float var12 = 0.8F;
      float var13 = 0.6F;
      float var14 = var10 * p_1230_5_;
      float var15 = var11 * p_1230_5_;
      float var16 = var12 * p_1230_5_;
      float var17 = var13 * p_1230_5_;
      float var18 = var10 * p_1230_6_;
      float var19 = var11 * p_1230_6_;
      float var20 = var12 * p_1230_6_;
      float var21 = var13 * p_1230_6_;
      float var22 = var10 * p_1230_7_;
      float var23 = var11 * p_1230_7_;
      float var24 = var12 * p_1230_7_;
      float var25 = var13 * p_1230_7_;
      float var26 = 0.0625F;
      int var28 = p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_);
      if(this.field_1773_d || p_1230_1_.func_260_c(this.field_1772_a, p_1230_2_, p_1230_3_ - 1, p_1230_4_, 0)) {
         var8.func_35835_b(p_1230_1_.field_368_bg > 0.0D?var28:p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_, p_1230_3_ - 1, p_1230_4_));
         var8.func_987_a(var14, var18, var22);
         this.func_1244_a(p_1230_1_, (double)p_1230_2_, (double)p_1230_3_, (double)p_1230_4_, p_1230_1_.func_211_a(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 0));
         var9 = true;
      }

      if(this.field_1773_d || p_1230_1_.func_260_c(this.field_1772_a, p_1230_2_, p_1230_3_ + 1, p_1230_4_, 1)) {
         var8.func_35835_b(p_1230_1_.field_362_bj < 1.0D?var28:p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_, p_1230_3_ + 1, p_1230_4_));
         var8.func_987_a(var15, var19, var23);
         this.func_1217_b(p_1230_1_, (double)p_1230_2_, (double)p_1230_3_, (double)p_1230_4_, p_1230_1_.func_211_a(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 1));
         var9 = true;
      }

      if(this.field_1773_d || p_1230_1_.func_260_c(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ - 1, 2)) {
         var8.func_35835_b(p_1230_1_.field_366_bh > 0.0D?var28:p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ - 1));
         var8.func_987_a(var16, var20, var24);
         var8.func_988_c(0.0F, 0.0F, var26);
         this.func_1220_c(p_1230_1_, (double)p_1230_2_, (double)p_1230_3_, (double)p_1230_4_, p_1230_1_.func_211_a(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 2));
         var8.func_988_c(0.0F, 0.0F, -var26);
         var9 = true;
      }

      if(this.field_1773_d || p_1230_1_.func_260_c(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ + 1, 3)) {
         var8.func_35835_b(p_1230_1_.field_360_bk < 1.0D?var28:p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_ + 1));
         var8.func_987_a(var16, var20, var24);
         var8.func_988_c(0.0F, 0.0F, -var26);
         this.func_1225_d(p_1230_1_, (double)p_1230_2_, (double)p_1230_3_, (double)p_1230_4_, p_1230_1_.func_211_a(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 3));
         var8.func_988_c(0.0F, 0.0F, var26);
         var9 = true;
      }

      if(this.field_1773_d || p_1230_1_.func_260_c(this.field_1772_a, p_1230_2_ - 1, p_1230_3_, p_1230_4_, 4)) {
         var8.func_35835_b(p_1230_1_.field_370_bf > 0.0D?var28:p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_ - 1, p_1230_3_, p_1230_4_));
         var8.func_987_a(var17, var21, var25);
         var8.func_988_c(var26, 0.0F, 0.0F);
         this.func_1231_e(p_1230_1_, (double)p_1230_2_, (double)p_1230_3_, (double)p_1230_4_, p_1230_1_.func_211_a(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 4));
         var8.func_988_c(-var26, 0.0F, 0.0F);
         var9 = true;
      }

      if(this.field_1773_d || p_1230_1_.func_260_c(this.field_1772_a, p_1230_2_ + 1, p_1230_3_, p_1230_4_, 5)) {
         var8.func_35835_b(p_1230_1_.field_364_bi < 1.0D?var28:p_1230_1_.func_35275_c(this.field_1772_a, p_1230_2_ + 1, p_1230_3_, p_1230_4_));
         var8.func_987_a(var17, var21, var25);
         var8.func_988_c(-var26, 0.0F, 0.0F);
         this.func_1236_f(p_1230_1_, (double)p_1230_2_, (double)p_1230_3_, (double)p_1230_4_, p_1230_1_.func_211_a(this.field_1772_a, p_1230_2_, p_1230_3_, p_1230_4_, 5));
         var8.func_988_c(var26, 0.0F, 0.0F);
         var9 = true;
      }

      return var9;
   }

   public boolean func_35925_a(BlockFence p_35925_1_, int p_35925_2_, int p_35925_3_, int p_35925_4_) {
      boolean var5 = false;
      float var6 = 0.375F;
      float var7 = 0.625F;
      p_35925_1_.func_213_a(var6, 0.0F, var6, var7, 1.0F, var7);
      this.func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
      var5 = true;
      boolean var8 = false;
      boolean var9 = false;
      if(p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_ - 1, p_35925_3_, p_35925_4_) || p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_ + 1, p_35925_3_, p_35925_4_)) {
         var8 = true;
      }

      if(p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ - 1) || p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ + 1)) {
         var9 = true;
      }

      boolean var10 = p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_ - 1, p_35925_3_, p_35925_4_);
      boolean var11 = p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_ + 1, p_35925_3_, p_35925_4_);
      boolean var12 = p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ - 1);
      boolean var13 = p_35925_1_.func_35303_f(this.field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_ + 1);
      if(!var8 && !var9) {
         var8 = true;
      }

      var6 = 0.4375F;
      var7 = 0.5625F;
      float var14 = 0.75F;
      float var15 = 0.9375F;
      float var16 = var10?0.0F:var6;
      float var17 = var11?1.0F:var7;
      float var18 = var12?0.0F:var6;
      float var19 = var13?1.0F:var7;
      if(var8) {
         p_35925_1_.func_213_a(var16, var14, var6, var17, var15, var7);
         this.func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
         var5 = true;
      }

      if(var9) {
         p_35925_1_.func_213_a(var6, var14, var18, var7, var15, var19);
         this.func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
         var5 = true;
      }

      var14 = 0.375F;
      var15 = 0.5625F;
      if(var8) {
         p_35925_1_.func_213_a(var16, var14, var6, var17, var15, var7);
         this.func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
         var5 = true;
      }

      if(var9) {
         p_35925_1_.func_213_a(var6, var14, var18, var7, var15, var19);
         this.func_1228_k(p_35925_1_, p_35925_2_, p_35925_3_, p_35925_4_);
         var5 = true;
      }

      p_35925_1_.func_238_a(this.field_1772_a, p_35925_2_, p_35925_3_, p_35925_4_);
      return var5;
   }

   public boolean func_41088_a(BlockDragonEgg p_41088_1_, int p_41088_2_, int p_41088_3_, int p_41088_4_) {
      boolean var5 = false;
      int var6 = 0;

      for(int var7 = 0; var7 < 8; ++var7) {
         byte var8 = 0;
         byte var9 = 1;
         if(var7 == 0) {
            var8 = 2;
         }

         if(var7 == 1) {
            var8 = 3;
         }

         if(var7 == 2) {
            var8 = 4;
         }

         if(var7 == 3) {
            var8 = 5;
            var9 = 2;
         }

         if(var7 == 4) {
            var8 = 6;
            var9 = 3;
         }

         if(var7 == 5) {
            var8 = 7;
            var9 = 5;
         }

         if(var7 == 6) {
            var8 = 6;
            var9 = 2;
         }

         if(var7 == 7) {
            var8 = 3;
         }

         float var10 = (float)var8 / 16.0F;
         float var11 = 1.0F - (float)var6 / 16.0F;
         float var12 = 1.0F - (float)(var6 + var9) / 16.0F;
         var6 += var9;
         p_41088_1_.func_213_a(0.5F - var10, var12, 0.5F - var10, 0.5F + var10, var11, 0.5F + var10);
         this.func_1228_k(p_41088_1_, p_41088_2_, p_41088_3_, p_41088_4_);
      }

      var5 = true;
      p_41088_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return var5;
   }

   public boolean func_35923_a(BlockFenceGate p_35923_1_, int p_35923_2_, int p_35923_3_, int p_35923_4_) {
      boolean var5 = true;
      int var6 = this.field_1772_a.func_602_e(p_35923_2_, p_35923_3_, p_35923_4_);
      boolean var7 = BlockFenceGate.func_35291_d(var6);
      int var8 = BlockDirectional.func_48216_a(var6);
      float var15;
      float var16;
      float var17;
      float var18;
      if(var8 != 3 && var8 != 1) {
         var15 = 0.0F;
         var16 = 0.125F;
         var17 = 0.4375F;
         var18 = 0.5625F;
         p_35923_1_.func_213_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         var15 = 0.875F;
         var16 = 1.0F;
         p_35923_1_.func_213_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
      } else {
         var15 = 0.4375F;
         var16 = 0.5625F;
         var17 = 0.0F;
         var18 = 0.125F;
         p_35923_1_.func_213_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         var17 = 0.875F;
         var18 = 1.0F;
         p_35923_1_.func_213_a(var15, 0.3125F, var17, var16, 1.0F, var18);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
      }

      if(!var7) {
         if(var8 != 3 && var8 != 1) {
            var15 = 0.375F;
            var16 = 0.5F;
            var17 = 0.4375F;
            var18 = 0.5625F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            var15 = 0.5F;
            var16 = 0.625F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            var15 = 0.625F;
            var16 = 0.875F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.5625F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(var15, 0.75F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            var15 = 0.125F;
            var16 = 0.375F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.5625F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(var15, 0.75F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         } else {
            var15 = 0.4375F;
            var16 = 0.5625F;
            var17 = 0.375F;
            var18 = 0.5F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            var17 = 0.5F;
            var18 = 0.625F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            var17 = 0.625F;
            var18 = 0.875F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.5625F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(var15, 0.75F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            var17 = 0.125F;
            var18 = 0.375F;
            p_35923_1_.func_213_a(var15, 0.375F, var17, var16, 0.5625F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
            p_35923_1_.func_213_a(var15, 0.75F, var17, var16, 0.9375F, var18);
            this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         }
      } else if(var8 == 3) {
         p_35923_1_.func_213_a(0.8125F, 0.375F, 0.0F, 0.9375F, 0.9375F, 0.125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.8125F, 0.375F, 0.875F, 0.9375F, 0.9375F, 1.0F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.5625F, 0.375F, 0.0F, 0.8125F, 0.5625F, 0.125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.5625F, 0.375F, 0.875F, 0.8125F, 0.5625F, 1.0F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.5625F, 0.75F, 0.0F, 0.8125F, 0.9375F, 0.125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.5625F, 0.75F, 0.875F, 0.8125F, 0.9375F, 1.0F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
      } else if(var8 == 1) {
         p_35923_1_.func_213_a(0.0625F, 0.375F, 0.0F, 0.1875F, 0.9375F, 0.125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.0625F, 0.375F, 0.875F, 0.1875F, 0.9375F, 1.0F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.1875F, 0.375F, 0.0F, 0.4375F, 0.5625F, 0.125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.1875F, 0.375F, 0.875F, 0.4375F, 0.5625F, 1.0F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.1875F, 0.75F, 0.0F, 0.4375F, 0.9375F, 0.125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.1875F, 0.75F, 0.875F, 0.4375F, 0.9375F, 1.0F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
      } else if(var8 == 0) {
         p_35923_1_.func_213_a(0.0F, 0.375F, 0.8125F, 0.125F, 0.9375F, 0.9375F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.875F, 0.375F, 0.8125F, 1.0F, 0.9375F, 0.9375F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.0F, 0.375F, 0.5625F, 0.125F, 0.5625F, 0.8125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.875F, 0.375F, 0.5625F, 1.0F, 0.5625F, 0.8125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.0F, 0.75F, 0.5625F, 0.125F, 0.9375F, 0.8125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.875F, 0.75F, 0.5625F, 1.0F, 0.9375F, 0.8125F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
      } else if(var8 == 2) {
         p_35923_1_.func_213_a(0.0F, 0.375F, 0.0625F, 0.125F, 0.9375F, 0.1875F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.875F, 0.375F, 0.0625F, 1.0F, 0.9375F, 0.1875F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.0F, 0.375F, 0.1875F, 0.125F, 0.5625F, 0.4375F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.875F, 0.375F, 0.1875F, 1.0F, 0.5625F, 0.4375F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.0F, 0.75F, 0.1875F, 0.125F, 0.9375F, 0.4375F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
         p_35923_1_.func_213_a(0.875F, 0.75F, 0.1875F, 1.0F, 0.9375F, 0.4375F);
         this.func_1228_k(p_35923_1_, p_35923_2_, p_35923_3_, p_35923_4_);
      }

      p_35923_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return var5;
   }

   public boolean func_1214_n(Block p_1214_1_, int p_1214_2_, int p_1214_3_, int p_1214_4_) {
      int var5 = this.field_1772_a.func_602_e(p_1214_2_, p_1214_3_, p_1214_4_);
      int var6 = var5 & 3;
      float var7 = 0.0F;
      float var8 = 0.5F;
      float var9 = 0.5F;
      float var10 = 1.0F;
      if((var5 & 4) != 0) {
         var7 = 0.5F;
         var8 = 1.0F;
         var9 = 0.0F;
         var10 = 0.5F;
      }

      p_1214_1_.func_213_a(0.0F, var7, 0.0F, 1.0F, var8, 1.0F);
      this.func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
      if(var6 == 0) {
         p_1214_1_.func_213_a(0.5F, var9, 0.0F, 1.0F, var10, 1.0F);
         this.func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
      } else if(var6 == 1) {
         p_1214_1_.func_213_a(0.0F, var9, 0.0F, 0.5F, var10, 1.0F);
         this.func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
      } else if(var6 == 2) {
         p_1214_1_.func_213_a(0.0F, var9, 0.5F, 1.0F, var10, 1.0F);
         this.func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
      } else if(var6 == 3) {
         p_1214_1_.func_213_a(0.0F, var9, 0.0F, 1.0F, var10, 0.5F);
         this.func_1228_k(p_1214_1_, p_1214_2_, p_1214_3_, p_1214_4_);
      }

      p_1214_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      return true;
   }

   public boolean func_1218_o(Block p_1218_1_, int p_1218_2_, int p_1218_3_, int p_1218_4_) {
      Tessellator var5 = Tessellator.field_1512_a;
      BlockDoor var6 = (BlockDoor)p_1218_1_;
      boolean var7 = false;
      float var8 = 0.5F;
      float var9 = 1.0F;
      float var10 = 0.8F;
      float var11 = 0.6F;
      int var12 = p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_);
      var5.func_35835_b(p_1218_1_.field_368_bg > 0.0D?var12:p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_, p_1218_3_ - 1, p_1218_4_));
      var5.func_987_a(var8, var8, var8);
      this.func_1244_a(p_1218_1_, (double)p_1218_2_, (double)p_1218_3_, (double)p_1218_4_, p_1218_1_.func_211_a(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 0));
      var7 = true;
      var5.func_35835_b(p_1218_1_.field_362_bj < 1.0D?var12:p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_, p_1218_3_ + 1, p_1218_4_));
      var5.func_987_a(var9, var9, var9);
      this.func_1217_b(p_1218_1_, (double)p_1218_2_, (double)p_1218_3_, (double)p_1218_4_, p_1218_1_.func_211_a(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 1));
      var7 = true;
      var5.func_35835_b(p_1218_1_.field_366_bh > 0.0D?var12:p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_ - 1));
      var5.func_987_a(var10, var10, var10);
      int var14 = p_1218_1_.func_211_a(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 2);
      if(var14 < 0) {
         this.field_1774_c = true;
         var14 = -var14;
      }

      this.func_1220_c(p_1218_1_, (double)p_1218_2_, (double)p_1218_3_, (double)p_1218_4_, var14);
      var7 = true;
      this.field_1774_c = false;
      var5.func_35835_b(p_1218_1_.field_360_bk < 1.0D?var12:p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_ + 1));
      var5.func_987_a(var10, var10, var10);
      var14 = p_1218_1_.func_211_a(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 3);
      if(var14 < 0) {
         this.field_1774_c = true;
         var14 = -var14;
      }

      this.func_1225_d(p_1218_1_, (double)p_1218_2_, (double)p_1218_3_, (double)p_1218_4_, var14);
      var7 = true;
      this.field_1774_c = false;
      var5.func_35835_b(p_1218_1_.field_370_bf > 0.0D?var12:p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_ - 1, p_1218_3_, p_1218_4_));
      var5.func_987_a(var11, var11, var11);
      var14 = p_1218_1_.func_211_a(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 4);
      if(var14 < 0) {
         this.field_1774_c = true;
         var14 = -var14;
      }

      this.func_1231_e(p_1218_1_, (double)p_1218_2_, (double)p_1218_3_, (double)p_1218_4_, var14);
      var7 = true;
      this.field_1774_c = false;
      var5.func_35835_b(p_1218_1_.field_364_bi < 1.0D?var12:p_1218_1_.func_35275_c(this.field_1772_a, p_1218_2_ + 1, p_1218_3_, p_1218_4_));
      var5.func_987_a(var11, var11, var11);
      var14 = p_1218_1_.func_211_a(this.field_1772_a, p_1218_2_, p_1218_3_, p_1218_4_, 5);
      if(var14 < 0) {
         this.field_1774_c = true;
         var14 = -var14;
      }

      this.func_1236_f(p_1218_1_, (double)p_1218_2_, (double)p_1218_3_, (double)p_1218_4_, var14);
      var7 = true;
      this.field_1774_c = false;
      return var7;
   }

   public void func_1244_a(Block p_1244_1_, double p_1244_2_, double p_1244_4_, double p_1244_6_, int p_1244_8_) {
      Tessellator var9 = Tessellator.field_1512_a;
      if(this.field_1771_b >= 0) {
         p_1244_8_ = this.field_1771_b;
      }

      int var10 = (p_1244_8_ & 15) << 4;
      int var11 = p_1244_8_ & 240;
      double var12 = ((double)var10 + p_1244_1_.field_370_bf * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_1244_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)var11 + p_1244_1_.field_366_bh * 16.0D) / 256.0D;
      double var18 = ((double)var11 + p_1244_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
      if(p_1244_1_.field_370_bf < 0.0D || p_1244_1_.field_364_bi > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_1244_1_.field_366_bh < 0.0D || p_1244_1_.field_360_bk > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      double var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_31082_l == 2) {
         var12 = ((double)var10 + p_1244_1_.field_366_bh * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1244_1_.field_364_bi * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_1244_1_.field_360_bk * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1244_1_.field_370_bf * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_31082_l == 1) {
         var12 = ((double)(var10 + 16) - p_1244_1_.field_360_bk * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_1244_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1244_1_.field_366_bh * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1244_1_.field_364_bi * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_31082_l == 3) {
         var12 = ((double)(var10 + 16) - p_1244_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1244_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1244_1_.field_366_bh * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1244_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_1244_2_ + p_1244_1_.field_370_bf;
      double var30 = p_1244_2_ + p_1244_1_.field_364_bi;
      double var32 = p_1244_4_ + p_1244_1_.field_368_bg;
      double var34 = p_1244_6_ + p_1244_1_.field_366_bh;
      double var36 = p_1244_6_ + p_1244_1_.field_360_bk;
      if(this.field_22385_e) {
         var9.func_987_a(this.field_22351_H, this.field_22347_L, this.field_22343_P);
         var9.func_35835_b(this.field_35943_ak);
         var9.func_983_a(var28, var32, var36, var22, var26);
         var9.func_987_a(this.field_22350_I, this.field_22346_M, this.field_22342_Q);
         var9.func_35835_b(this.field_35944_al);
         var9.func_983_a(var28, var32, var34, var12, var16);
         var9.func_987_a(this.field_22349_J, this.field_22345_N, this.field_22341_R);
         var9.func_35835_b(this.field_35947_am);
         var9.func_983_a(var30, var32, var34, var20, var24);
         var9.func_987_a(this.field_22348_K, this.field_22344_O, this.field_22340_S);
         var9.func_35835_b(this.field_35948_an);
         var9.func_983_a(var30, var32, var36, var14, var18);
      } else {
         var9.func_983_a(var28, var32, var36, var22, var26);
         var9.func_983_a(var28, var32, var34, var12, var16);
         var9.func_983_a(var30, var32, var34, var20, var24);
         var9.func_983_a(var30, var32, var36, var14, var18);
      }

   }

   public void func_1217_b(Block p_1217_1_, double p_1217_2_, double p_1217_4_, double p_1217_6_, int p_1217_8_) {
      Tessellator var9 = Tessellator.field_1512_a;
      if(this.field_1771_b >= 0) {
         p_1217_8_ = this.field_1771_b;
      }

      int var10 = (p_1217_8_ & 15) << 4;
      int var11 = p_1217_8_ & 240;
      double var12 = ((double)var10 + p_1217_1_.field_370_bf * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_1217_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)var11 + p_1217_1_.field_366_bh * 16.0D) / 256.0D;
      double var18 = ((double)var11 + p_1217_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
      if(p_1217_1_.field_370_bf < 0.0D || p_1217_1_.field_364_bi > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_1217_1_.field_366_bh < 0.0D || p_1217_1_.field_360_bk > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      double var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_31083_k == 1) {
         var12 = ((double)var10 + p_1217_1_.field_366_bh * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1217_1_.field_364_bi * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_1217_1_.field_360_bk * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1217_1_.field_370_bf * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_31083_k == 2) {
         var12 = ((double)(var10 + 16) - p_1217_1_.field_360_bk * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_1217_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1217_1_.field_366_bh * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1217_1_.field_364_bi * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_31083_k == 3) {
         var12 = ((double)(var10 + 16) - p_1217_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1217_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1217_1_.field_366_bh * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1217_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_1217_2_ + p_1217_1_.field_370_bf;
      double var30 = p_1217_2_ + p_1217_1_.field_364_bi;
      double var32 = p_1217_4_ + p_1217_1_.field_362_bj;
      double var34 = p_1217_6_ + p_1217_1_.field_366_bh;
      double var36 = p_1217_6_ + p_1217_1_.field_360_bk;
      if(this.field_22385_e) {
         var9.func_987_a(this.field_22351_H, this.field_22347_L, this.field_22343_P);
         var9.func_35835_b(this.field_35943_ak);
         var9.func_983_a(var30, var32, var36, var14, var18);
         var9.func_987_a(this.field_22350_I, this.field_22346_M, this.field_22342_Q);
         var9.func_35835_b(this.field_35944_al);
         var9.func_983_a(var30, var32, var34, var20, var24);
         var9.func_987_a(this.field_22349_J, this.field_22345_N, this.field_22341_R);
         var9.func_35835_b(this.field_35947_am);
         var9.func_983_a(var28, var32, var34, var12, var16);
         var9.func_987_a(this.field_22348_K, this.field_22344_O, this.field_22340_S);
         var9.func_35835_b(this.field_35948_an);
         var9.func_983_a(var28, var32, var36, var22, var26);
      } else {
         var9.func_983_a(var30, var32, var36, var14, var18);
         var9.func_983_a(var30, var32, var34, var20, var24);
         var9.func_983_a(var28, var32, var34, var12, var16);
         var9.func_983_a(var28, var32, var36, var22, var26);
      }

   }

   public void func_1220_c(Block p_1220_1_, double p_1220_2_, double p_1220_4_, double p_1220_6_, int p_1220_8_) {
      Tessellator var9 = Tessellator.field_1512_a;
      if(this.field_1771_b >= 0) {
         p_1220_8_ = this.field_1771_b;
      }

      int var10 = (p_1220_8_ & 15) << 4;
      int var11 = p_1220_8_ & 240;
      double var12 = ((double)var10 + p_1220_1_.field_370_bf * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_1220_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_1220_1_.field_362_bj * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_1220_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_1774_c) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_1220_1_.field_370_bf < 0.0D || p_1220_1_.field_364_bi > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_1220_1_.field_368_bg < 0.0D || p_1220_1_.field_362_bj > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_31087_g == 2) {
         var12 = ((double)var10 + p_1220_1_.field_368_bg * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1220_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_1220_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1220_1_.field_364_bi * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_31087_g == 1) {
         var12 = ((double)(var10 + 16) - p_1220_1_.field_362_bj * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_1220_1_.field_364_bi * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1220_1_.field_368_bg * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1220_1_.field_370_bf * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_31087_g == 3) {
         var12 = ((double)(var10 + 16) - p_1220_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1220_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_1220_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1220_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_1220_2_ + p_1220_1_.field_370_bf;
      double var30 = p_1220_2_ + p_1220_1_.field_364_bi;
      double var32 = p_1220_4_ + p_1220_1_.field_368_bg;
      double var34 = p_1220_4_ + p_1220_1_.field_362_bj;
      double var36 = p_1220_6_ + p_1220_1_.field_366_bh;
      if(this.field_22385_e) {
         var9.func_987_a(this.field_22351_H, this.field_22347_L, this.field_22343_P);
         var9.func_35835_b(this.field_35943_ak);
         var9.func_983_a(var28, var34, var36, var20, var24);
         var9.func_987_a(this.field_22350_I, this.field_22346_M, this.field_22342_Q);
         var9.func_35835_b(this.field_35944_al);
         var9.func_983_a(var30, var34, var36, var12, var16);
         var9.func_987_a(this.field_22349_J, this.field_22345_N, this.field_22341_R);
         var9.func_35835_b(this.field_35947_am);
         var9.func_983_a(var30, var32, var36, var22, var26);
         var9.func_987_a(this.field_22348_K, this.field_22344_O, this.field_22340_S);
         var9.func_35835_b(this.field_35948_an);
         var9.func_983_a(var28, var32, var36, var14, var18);
      } else {
         var9.func_983_a(var28, var34, var36, var20, var24);
         var9.func_983_a(var30, var34, var36, var12, var16);
         var9.func_983_a(var30, var32, var36, var22, var26);
         var9.func_983_a(var28, var32, var36, var14, var18);
      }

   }

   public void func_1225_d(Block p_1225_1_, double p_1225_2_, double p_1225_4_, double p_1225_6_, int p_1225_8_) {
      Tessellator var9 = Tessellator.field_1512_a;
      if(this.field_1771_b >= 0) {
         p_1225_8_ = this.field_1771_b;
      }

      int var10 = (p_1225_8_ & 15) << 4;
      int var11 = p_1225_8_ & 240;
      double var12 = ((double)var10 + p_1225_1_.field_370_bf * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_1225_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_1225_1_.field_362_bj * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_1225_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_1774_c) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_1225_1_.field_370_bf < 0.0D || p_1225_1_.field_364_bi > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_1225_1_.field_368_bg < 0.0D || p_1225_1_.field_362_bj > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_31086_h == 1) {
         var12 = ((double)var10 + p_1225_1_.field_368_bg * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1225_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_1225_1_.field_362_bj * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1225_1_.field_364_bi * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_31086_h == 2) {
         var12 = ((double)(var10 + 16) - p_1225_1_.field_362_bj * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_1225_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1225_1_.field_368_bg * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1225_1_.field_364_bi * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_31086_h == 3) {
         var12 = ((double)(var10 + 16) - p_1225_1_.field_370_bf * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1225_1_.field_364_bi * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_1225_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1225_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_1225_2_ + p_1225_1_.field_370_bf;
      double var30 = p_1225_2_ + p_1225_1_.field_364_bi;
      double var32 = p_1225_4_ + p_1225_1_.field_368_bg;
      double var34 = p_1225_4_ + p_1225_1_.field_362_bj;
      double var36 = p_1225_6_ + p_1225_1_.field_360_bk;
      if(this.field_22385_e) {
         var9.func_987_a(this.field_22351_H, this.field_22347_L, this.field_22343_P);
         var9.func_35835_b(this.field_35943_ak);
         var9.func_983_a(var28, var34, var36, var12, var16);
         var9.func_987_a(this.field_22350_I, this.field_22346_M, this.field_22342_Q);
         var9.func_35835_b(this.field_35944_al);
         var9.func_983_a(var28, var32, var36, var22, var26);
         var9.func_987_a(this.field_22349_J, this.field_22345_N, this.field_22341_R);
         var9.func_35835_b(this.field_35947_am);
         var9.func_983_a(var30, var32, var36, var14, var18);
         var9.func_987_a(this.field_22348_K, this.field_22344_O, this.field_22340_S);
         var9.func_35835_b(this.field_35948_an);
         var9.func_983_a(var30, var34, var36, var20, var24);
      } else {
         var9.func_983_a(var28, var34, var36, var12, var16);
         var9.func_983_a(var28, var32, var36, var22, var26);
         var9.func_983_a(var30, var32, var36, var14, var18);
         var9.func_983_a(var30, var34, var36, var20, var24);
      }

   }

   public void func_1231_e(Block p_1231_1_, double p_1231_2_, double p_1231_4_, double p_1231_6_, int p_1231_8_) {
      Tessellator var9 = Tessellator.field_1512_a;
      if(this.field_1771_b >= 0) {
         p_1231_8_ = this.field_1771_b;
      }

      int var10 = (p_1231_8_ & 15) << 4;
      int var11 = p_1231_8_ & 240;
      double var12 = ((double)var10 + p_1231_1_.field_366_bh * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_1231_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_1231_1_.field_362_bj * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_1231_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_1774_c) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_1231_1_.field_366_bh < 0.0D || p_1231_1_.field_360_bk > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_1231_1_.field_368_bg < 0.0D || p_1231_1_.field_362_bj > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_31084_j == 1) {
         var12 = ((double)var10 + p_1231_1_.field_368_bg * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1231_1_.field_360_bk * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_1231_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1231_1_.field_366_bh * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_31084_j == 2) {
         var12 = ((double)(var10 + 16) - p_1231_1_.field_362_bj * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_1231_1_.field_366_bh * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1231_1_.field_368_bg * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1231_1_.field_360_bk * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_31084_j == 3) {
         var12 = ((double)(var10 + 16) - p_1231_1_.field_366_bh * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1231_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_1231_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1231_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_1231_2_ + p_1231_1_.field_370_bf;
      double var30 = p_1231_4_ + p_1231_1_.field_368_bg;
      double var32 = p_1231_4_ + p_1231_1_.field_362_bj;
      double var34 = p_1231_6_ + p_1231_1_.field_366_bh;
      double var36 = p_1231_6_ + p_1231_1_.field_360_bk;
      if(this.field_22385_e) {
         var9.func_987_a(this.field_22351_H, this.field_22347_L, this.field_22343_P);
         var9.func_35835_b(this.field_35943_ak);
         var9.func_983_a(var28, var32, var36, var20, var24);
         var9.func_987_a(this.field_22350_I, this.field_22346_M, this.field_22342_Q);
         var9.func_35835_b(this.field_35944_al);
         var9.func_983_a(var28, var32, var34, var12, var16);
         var9.func_987_a(this.field_22349_J, this.field_22345_N, this.field_22341_R);
         var9.func_35835_b(this.field_35947_am);
         var9.func_983_a(var28, var30, var34, var22, var26);
         var9.func_987_a(this.field_22348_K, this.field_22344_O, this.field_22340_S);
         var9.func_35835_b(this.field_35948_an);
         var9.func_983_a(var28, var30, var36, var14, var18);
      } else {
         var9.func_983_a(var28, var32, var36, var20, var24);
         var9.func_983_a(var28, var32, var34, var12, var16);
         var9.func_983_a(var28, var30, var34, var22, var26);
         var9.func_983_a(var28, var30, var36, var14, var18);
      }

   }

   public void func_1236_f(Block p_1236_1_, double p_1236_2_, double p_1236_4_, double p_1236_6_, int p_1236_8_) {
      Tessellator var9 = Tessellator.field_1512_a;
      if(this.field_1771_b >= 0) {
         p_1236_8_ = this.field_1771_b;
      }

      int var10 = (p_1236_8_ & 15) << 4;
      int var11 = p_1236_8_ & 240;
      double var12 = ((double)var10 + p_1236_1_.field_366_bh * 16.0D) / 256.0D;
      double var14 = ((double)var10 + p_1236_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
      double var16 = ((double)(var11 + 16) - p_1236_1_.field_362_bj * 16.0D) / 256.0D;
      double var18 = ((double)(var11 + 16) - p_1236_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
      double var20;
      if(this.field_1774_c) {
         var20 = var12;
         var12 = var14;
         var14 = var20;
      }

      if(p_1236_1_.field_366_bh < 0.0D || p_1236_1_.field_360_bk > 1.0D) {
         var12 = (double)(((float)var10 + 0.0F) / 256.0F);
         var14 = (double)(((float)var10 + 15.99F) / 256.0F);
      }

      if(p_1236_1_.field_368_bg < 0.0D || p_1236_1_.field_362_bj > 1.0D) {
         var16 = (double)(((float)var11 + 0.0F) / 256.0F);
         var18 = (double)(((float)var11 + 15.99F) / 256.0F);
      }

      var20 = var14;
      double var22 = var12;
      double var24 = var16;
      double var26 = var18;
      if(this.field_31085_i == 2) {
         var12 = ((double)var10 + p_1236_1_.field_368_bg * 16.0D) / 256.0D;
         var16 = ((double)(var11 + 16) - p_1236_1_.field_366_bh * 16.0D) / 256.0D;
         var14 = ((double)var10 + p_1236_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)(var11 + 16) - p_1236_1_.field_360_bk * 16.0D) / 256.0D;
         var24 = var16;
         var26 = var18;
         var20 = var12;
         var22 = var14;
         var16 = var18;
         var18 = var24;
      } else if(this.field_31085_i == 1) {
         var12 = ((double)(var10 + 16) - p_1236_1_.field_362_bj * 16.0D) / 256.0D;
         var16 = ((double)var11 + p_1236_1_.field_360_bk * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1236_1_.field_368_bg * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1236_1_.field_366_bh * 16.0D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var12 = var14;
         var14 = var22;
         var24 = var18;
         var26 = var16;
      } else if(this.field_31085_i == 3) {
         var12 = ((double)(var10 + 16) - p_1236_1_.field_366_bh * 16.0D) / 256.0D;
         var14 = ((double)(var10 + 16) - p_1236_1_.field_360_bk * 16.0D - 0.01D) / 256.0D;
         var16 = ((double)var11 + p_1236_1_.field_362_bj * 16.0D) / 256.0D;
         var18 = ((double)var11 + p_1236_1_.field_368_bg * 16.0D - 0.01D) / 256.0D;
         var20 = var14;
         var22 = var12;
         var24 = var16;
         var26 = var18;
      }

      double var28 = p_1236_2_ + p_1236_1_.field_364_bi;
      double var30 = p_1236_4_ + p_1236_1_.field_368_bg;
      double var32 = p_1236_4_ + p_1236_1_.field_362_bj;
      double var34 = p_1236_6_ + p_1236_1_.field_366_bh;
      double var36 = p_1236_6_ + p_1236_1_.field_360_bk;
      if(this.field_22385_e) {
         var9.func_987_a(this.field_22351_H, this.field_22347_L, this.field_22343_P);
         var9.func_35835_b(this.field_35943_ak);
         var9.func_983_a(var28, var30, var36, var22, var26);
         var9.func_987_a(this.field_22350_I, this.field_22346_M, this.field_22342_Q);
         var9.func_35835_b(this.field_35944_al);
         var9.func_983_a(var28, var30, var34, var14, var18);
         var9.func_987_a(this.field_22349_J, this.field_22345_N, this.field_22341_R);
         var9.func_35835_b(this.field_35947_am);
         var9.func_983_a(var28, var32, var34, var20, var24);
         var9.func_987_a(this.field_22348_K, this.field_22344_O, this.field_22340_S);
         var9.func_35835_b(this.field_35948_an);
         var9.func_983_a(var28, var32, var36, var12, var16);
      } else {
         var9.func_983_a(var28, var30, var36, var22, var26);
         var9.func_983_a(var28, var30, var34, var14, var18);
         var9.func_983_a(var28, var32, var34, var20, var24);
         var9.func_983_a(var28, var32, var36, var12, var16);
      }

   }

   public void func_1227_a(Block p_1227_1_, int p_1227_2_, float p_1227_3_) {
      Tessellator var4 = Tessellator.field_1512_a;
      boolean var5 = p_1227_1_.field_376_bc == Block.field_337_v.field_376_bc;
      int var6;
      float var7;
      float var8;
      float var9;
      if(this.field_31088_b) {
         var6 = p_1227_1_.func_31030_b(p_1227_2_);
         if(var5) {
            var6 = 16777215;
         }

         var7 = (float)(var6 >> 16 & 255) / 255.0F;
         var8 = (float)(var6 >> 8 & 255) / 255.0F;
         var9 = (float)(var6 & 255) / 255.0F;
         GL11.glColor4f(var7 * p_1227_3_, var8 * p_1227_3_, var9 * p_1227_3_, 1.0F);
      }

      var6 = p_1227_1_.func_210_f();
      int var14;
      if(var6 != 0 && var6 != 16) {
         if(var6 == 1) {
            var4.func_977_b();
            var4.func_980_b(0.0F, -1.0F, 0.0F);
            this.func_1239_a(p_1227_1_, p_1227_2_, -0.5D, -0.5D, -0.5D);
            var4.func_982_a();
         } else if(var6 == 19) {
            var4.func_977_b();
            var4.func_980_b(0.0F, -1.0F, 0.0F);
            p_1227_1_.func_237_e();
            this.func_35928_a(p_1227_1_, p_1227_2_, p_1227_1_.field_362_bj, -0.5D, -0.5D, -0.5D);
            var4.func_982_a();
         } else if(var6 == 23) {
            var4.func_977_b();
            var4.func_980_b(0.0F, -1.0F, 0.0F);
            p_1227_1_.func_237_e();
            var4.func_982_a();
         } else if(var6 == 13) {
            p_1227_1_.func_237_e();
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var7 = 0.0625F;
            var4.func_977_b();
            var4.func_980_b(0.0F, -1.0F, 0.0F);
            this.func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
            var4.func_982_a();
            var4.func_977_b();
            var4.func_980_b(0.0F, 1.0F, 0.0F);
            this.func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
            var4.func_982_a();
            var4.func_977_b();
            var4.func_980_b(0.0F, 0.0F, -1.0F);
            var4.func_988_c(0.0F, 0.0F, var7);
            this.func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
            var4.func_988_c(0.0F, 0.0F, -var7);
            var4.func_982_a();
            var4.func_977_b();
            var4.func_980_b(0.0F, 0.0F, 1.0F);
            var4.func_988_c(0.0F, 0.0F, -var7);
            this.func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
            var4.func_988_c(0.0F, 0.0F, var7);
            var4.func_982_a();
            var4.func_977_b();
            var4.func_980_b(-1.0F, 0.0F, 0.0F);
            var4.func_988_c(var7, 0.0F, 0.0F);
            this.func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
            var4.func_988_c(-var7, 0.0F, 0.0F);
            var4.func_982_a();
            var4.func_977_b();
            var4.func_980_b(1.0F, 0.0F, 0.0F);
            var4.func_988_c(-var7, 0.0F, 0.0F);
            this.func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
            var4.func_988_c(var7, 0.0F, 0.0F);
            var4.func_982_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
         } else if(var6 == 22) {
            ChestItemRenderHelper.field_35611_a.func_35609_a(p_1227_1_, p_1227_2_, p_1227_3_);
            GL11.glEnable('\u803a');
         } else if(var6 == 6) {
            var4.func_977_b();
            var4.func_980_b(0.0F, -1.0F, 0.0F);
            this.func_1245_b(p_1227_1_, p_1227_2_, -0.5D, -0.5D, -0.5D);
            var4.func_982_a();
         } else if(var6 == 2) {
            var4.func_977_b();
            var4.func_980_b(0.0F, -1.0F, 0.0F);
            this.func_1237_a(p_1227_1_, -0.5D, -0.5D, -0.5D, 0.0D, 0.0D);
            var4.func_982_a();
         } else if(var6 == 10) {
            for(var14 = 0; var14 < 2; ++var14) {
               if(var14 == 0) {
                  p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.5F);
               }

               if(var14 == 1) {
                  p_1227_1_.func_213_a(0.0F, 0.0F, 0.5F, 1.0F, 0.5F, 1.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_977_b();
               var4.func_980_b(0.0F, -1.0F, 0.0F);
               this.func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 1.0F, 0.0F);
               this.func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 0.0F, -1.0F);
               this.func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 0.0F, 1.0F);
               this.func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(-1.0F, 0.0F, 0.0F);
               this.func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(1.0F, 0.0F, 0.0F);
               this.func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
               var4.func_982_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }
         } else if(var6 == 27) {
            var14 = 0;
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            var4.func_977_b();

            for(int var15 = 0; var15 < 8; ++var15) {
               byte var16 = 0;
               byte var17 = 1;
               if(var15 == 0) {
                  var16 = 2;
               }

               if(var15 == 1) {
                  var16 = 3;
               }

               if(var15 == 2) {
                  var16 = 4;
               }

               if(var15 == 3) {
                  var16 = 5;
                  var17 = 2;
               }

               if(var15 == 4) {
                  var16 = 6;
                  var17 = 3;
               }

               if(var15 == 5) {
                  var16 = 7;
                  var17 = 5;
               }

               if(var15 == 6) {
                  var16 = 6;
                  var17 = 2;
               }

               if(var15 == 7) {
                  var16 = 3;
               }

               float var11 = (float)var16 / 16.0F;
               float var12 = 1.0F - (float)var14 / 16.0F;
               float var13 = 1.0F - (float)(var14 + var17) / 16.0F;
               var14 += var17;
               p_1227_1_.func_213_a(0.5F - var11, var13, 0.5F - var11, 0.5F + var11, var12, 0.5F + var11);
               var4.func_980_b(0.0F, -1.0F, 0.0F);
               this.func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
               var4.func_980_b(0.0F, 1.0F, 0.0F);
               this.func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
               var4.func_980_b(0.0F, 0.0F, -1.0F);
               this.func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
               var4.func_980_b(0.0F, 0.0F, 1.0F);
               this.func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
               var4.func_980_b(-1.0F, 0.0F, 0.0F);
               this.func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
               var4.func_980_b(1.0F, 0.0F, 0.0F);
               this.func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
            }

            var4.func_982_a();
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if(var6 == 11) {
            for(var14 = 0; var14 < 4; ++var14) {
               var8 = 0.125F;
               if(var14 == 0) {
                  p_1227_1_.func_213_a(0.5F - var8, 0.0F, 0.0F, 0.5F + var8, 1.0F, var8 * 2.0F);
               }

               if(var14 == 1) {
                  p_1227_1_.func_213_a(0.5F - var8, 0.0F, 1.0F - var8 * 2.0F, 0.5F + var8, 1.0F, 1.0F);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  p_1227_1_.func_213_a(0.5F - var8, 1.0F - var8 * 3.0F, -var8 * 2.0F, 0.5F + var8, 1.0F - var8, 1.0F + var8 * 2.0F);
               }

               if(var14 == 3) {
                  p_1227_1_.func_213_a(0.5F - var8, 0.5F - var8 * 3.0F, -var8 * 2.0F, 0.5F + var8, 0.5F - var8, 1.0F + var8 * 2.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_977_b();
               var4.func_980_b(0.0F, -1.0F, 0.0F);
               this.func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 1.0F, 0.0F);
               this.func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 0.0F, -1.0F);
               this.func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 0.0F, 1.0F);
               this.func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(-1.0F, 0.0F, 0.0F);
               this.func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(1.0F, 0.0F, 0.0F);
               this.func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
               var4.func_982_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else if(var6 == 21) {
            for(var14 = 0; var14 < 3; ++var14) {
               var8 = 0.0625F;
               if(var14 == 0) {
                  p_1227_1_.func_213_a(0.5F - var8, 0.3F, 0.0F, 0.5F + var8, 1.0F, var8 * 2.0F);
               }

               if(var14 == 1) {
                  p_1227_1_.func_213_a(0.5F - var8, 0.3F, 1.0F - var8 * 2.0F, 0.5F + var8, 1.0F, 1.0F);
               }

               var8 = 0.0625F;
               if(var14 == 2) {
                  p_1227_1_.func_213_a(0.5F - var8, 0.5F, 0.0F, 0.5F + var8, 1.0F - var8, 1.0F);
               }

               GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
               var4.func_977_b();
               var4.func_980_b(0.0F, -1.0F, 0.0F);
               this.func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(0));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 1.0F, 0.0F);
               this.func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(1));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 0.0F, -1.0F);
               this.func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(2));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(0.0F, 0.0F, 1.0F);
               this.func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(3));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(-1.0F, 0.0F, 0.0F);
               this.func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(4));
               var4.func_982_a();
               var4.func_977_b();
               var4.func_980_b(1.0F, 0.0F, 0.0F);
               this.func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_218_a(5));
               var4.func_982_a();
               GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            }

            p_1227_1_.func_213_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }
      } else {
         if(var6 == 16) {
            p_1227_2_ = 1;
         }

         p_1227_1_.func_237_e();
         GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
         var4.func_977_b();
         var4.func_980_b(0.0F, -1.0F, 0.0F);
         this.func_1244_a(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(0, p_1227_2_));
         var4.func_982_a();
         if(var5 && this.field_31088_b) {
            var14 = p_1227_1_.func_31030_b(p_1227_2_);
            var8 = (float)(var14 >> 16 & 255) / 255.0F;
            var9 = (float)(var14 >> 8 & 255) / 255.0F;
            float var10 = (float)(var14 & 255) / 255.0F;
            GL11.glColor4f(var8 * p_1227_3_, var9 * p_1227_3_, var10 * p_1227_3_, 1.0F);
         }

         var4.func_977_b();
         var4.func_980_b(0.0F, 1.0F, 0.0F);
         this.func_1217_b(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(1, p_1227_2_));
         var4.func_982_a();
         if(var5 && this.field_31088_b) {
            GL11.glColor4f(p_1227_3_, p_1227_3_, p_1227_3_, 1.0F);
         }

         var4.func_977_b();
         var4.func_980_b(0.0F, 0.0F, -1.0F);
         this.func_1220_c(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(2, p_1227_2_));
         var4.func_982_a();
         var4.func_977_b();
         var4.func_980_b(0.0F, 0.0F, 1.0F);
         this.func_1225_d(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(3, p_1227_2_));
         var4.func_982_a();
         var4.func_977_b();
         var4.func_980_b(-1.0F, 0.0F, 0.0F);
         this.func_1231_e(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(4, p_1227_2_));
         var4.func_982_a();
         var4.func_977_b();
         var4.func_980_b(1.0F, 0.0F, 0.0F);
         this.func_1236_f(p_1227_1_, 0.0D, 0.0D, 0.0D, p_1227_1_.func_232_a(5, p_1227_2_));
         var4.func_982_a();
         GL11.glTranslatef(0.5F, 0.5F, 0.5F);
      }

   }

   public static boolean func_1219_a(int p_1219_0_) {
      return p_1219_0_ == 0?true:(p_1219_0_ == 13?true:(p_1219_0_ == 10?true:(p_1219_0_ == 11?true:(p_1219_0_ == 27?true:(p_1219_0_ == 22?true:(p_1219_0_ == 21?true:p_1219_0_ == 16))))));
   }

}
