package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Achievement;
import net.minecraft.src.AchievementList;
import net.minecraft.src.Block;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.MathHelper;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatFileWriter;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiAchievements extends GuiScreen {

   private static final int field_27126_s = AchievementList.field_27392_a * 24 - 112;
   private static final int field_27125_t = AchievementList.field_27391_b * 24 - 112;
   private static final int field_27124_u = AchievementList.field_27390_c * 24 - 77;
   private static final int field_27123_v = AchievementList.field_27389_d * 24 - 77;
   protected int field_27121_a = 256;
   protected int field_27119_i = 202;
   protected int field_27118_j = 0;
   protected int field_27117_l = 0;
   protected double field_27116_m;
   protected double field_27115_n;
   protected double field_27114_o;
   protected double field_27113_p;
   protected double field_27112_q;
   protected double field_27111_r;
   private int field_27122_w = 0;
   private StatFileWriter field_27120_x;


   public GuiAchievements(StatFileWriter p_i575_1_) {
      this.field_27120_x = p_i575_1_;
      short var2 = 141;
      short var3 = 141;
      this.field_27116_m = this.field_27114_o = this.field_27112_q = (double)(AchievementList.field_25195_b.field_25075_a * 24 - var2 / 2 - 12);
      this.field_27115_n = this.field_27113_p = this.field_27111_r = (double)(AchievementList.field_25195_b.field_25074_b * 24 - var3 / 2);
   }

   public void func_6448_a() {
      this.field_949_e.clear();
      this.field_949_e.add(new GuiSmallButton(1, this.field_951_c / 2 + 24, this.field_950_d / 2 + 74, 80, 20, StatCollector.func_25200_a("gui.done")));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 1) {
         this.field_945_b.func_6272_a((GuiScreen)null);
         this.field_945_b.func_6259_e();
      }

      super.func_572_a(p_572_1_);
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == this.field_945_b.field_6304_y.field_1570_o.field_1370_b) {
         this.field_945_b.func_6272_a((GuiScreen)null);
         this.field_945_b.func_6259_e();
      } else {
         super.func_580_a(p_580_1_, p_580_2_);
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      if(Mouse.isButtonDown(0)) {
         int var4 = (this.field_951_c - this.field_27121_a) / 2;
         int var5 = (this.field_950_d - this.field_27119_i) / 2;
         int var6 = var4 + 8;
         int var7 = var5 + 17;
         if((this.field_27122_w == 0 || this.field_27122_w == 1) && p_571_1_ >= var6 && p_571_1_ < var6 + 224 && p_571_2_ >= var7 && p_571_2_ < var7 + 155) {
            if(this.field_27122_w == 0) {
               this.field_27122_w = 1;
            } else {
               this.field_27114_o -= (double)(p_571_1_ - this.field_27118_j);
               this.field_27113_p -= (double)(p_571_2_ - this.field_27117_l);
               this.field_27112_q = this.field_27116_m = this.field_27114_o;
               this.field_27111_r = this.field_27115_n = this.field_27113_p;
            }

            this.field_27118_j = p_571_1_;
            this.field_27117_l = p_571_2_;
         }

         if(this.field_27112_q < (double)field_27126_s) {
            this.field_27112_q = (double)field_27126_s;
         }

         if(this.field_27111_r < (double)field_27125_t) {
            this.field_27111_r = (double)field_27125_t;
         }

         if(this.field_27112_q >= (double)field_27124_u) {
            this.field_27112_q = (double)(field_27124_u - 1);
         }

         if(this.field_27111_r >= (double)field_27123_v) {
            this.field_27111_r = (double)(field_27123_v - 1);
         }
      } else {
         this.field_27122_w = 0;
      }

      this.func_578_i();
      this.func_27109_b(p_571_1_, p_571_2_, p_571_3_);
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      this.func_27110_k();
      GL11.glEnable(2896);
      GL11.glEnable(2929);
   }

   public void func_570_g() {
      this.field_27116_m = this.field_27114_o;
      this.field_27115_n = this.field_27113_p;
      double var1 = this.field_27112_q - this.field_27114_o;
      double var3 = this.field_27111_r - this.field_27113_p;
      if(var1 * var1 + var3 * var3 < 4.0D) {
         this.field_27114_o += var1;
         this.field_27113_p += var3;
      } else {
         this.field_27114_o += var1 * 0.85D;
         this.field_27113_p += var3 * 0.85D;
      }

   }

   protected void func_27110_k() {
      int var1 = (this.field_951_c - this.field_27121_a) / 2;
      int var2 = (this.field_950_d - this.field_27119_i) / 2;
      this.field_6451_g.func_873_b("Achievements", var1 + 15, var2 + 5, 4210752);
   }

   protected void func_27109_b(int p_27109_1_, int p_27109_2_, float p_27109_3_) {
      int var4 = MathHelper.func_1108_b(this.field_27116_m + (this.field_27114_o - this.field_27116_m) * (double)p_27109_3_);
      int var5 = MathHelper.func_1108_b(this.field_27115_n + (this.field_27113_p - this.field_27115_n) * (double)p_27109_3_);
      if(var4 < field_27126_s) {
         var4 = field_27126_s;
      }

      if(var5 < field_27125_t) {
         var5 = field_27125_t;
      }

      if(var4 >= field_27124_u) {
         var4 = field_27124_u - 1;
      }

      if(var5 >= field_27123_v) {
         var5 = field_27123_v - 1;
      }

      int var6 = this.field_945_b.field_6315_n.func_1070_a("/terrain.png");
      int var7 = this.field_945_b.field_6315_n.func_1070_a("/achievement/bg.png");
      int var8 = (this.field_951_c - this.field_27121_a) / 2;
      int var9 = (this.field_950_d - this.field_27119_i) / 2;
      int var10 = var8 + 16;
      int var11 = var9 + 17;
      this.field_923_k = 0.0F;
      GL11.glDepthFunc(518);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.0F, -200.0F);
      GL11.glEnable(3553);
      GL11.glDisable(2896);
      GL11.glEnable('\u803a');
      GL11.glEnable(2903);
      this.field_945_b.field_6315_n.func_1076_b(var6);
      int var12 = var4 + 288 >> 4;
      int var13 = var5 + 288 >> 4;
      int var14 = (var4 + 288) % 16;
      int var15 = (var5 + 288) % 16;
      Random var21 = new Random();

      int var22;
      int var24;
      int var25;
      int var26;
      for(var22 = 0; var22 * 16 - var15 < 155; ++var22) {
         float var23 = 0.6F - (float)(var13 + var22) / 25.0F * 0.3F;
         GL11.glColor4f(var23, var23, var23, 1.0F);

         for(var24 = 0; var24 * 16 - var14 < 224; ++var24) {
            var21.setSeed((long)(1234 + var12 + var24));
            var21.nextInt();
            var25 = var21.nextInt(1 + var13 + var22) + (var13 + var22) / 2;
            var26 = Block.field_393_F.field_378_bb;
            if(var25 <= 37 && var13 + var22 != 35) {
               if(var25 == 22) {
                  if(var21.nextInt(2) == 0) {
                     var26 = Block.field_391_ax.field_378_bb;
                  } else {
                     var26 = Block.field_433_aO.field_378_bb;
                  }
               } else if(var25 == 10) {
                  var26 = Block.field_388_I.field_378_bb;
               } else if(var25 == 8) {
                  var26 = Block.field_386_J.field_378_bb;
               } else if(var25 > 4) {
                  var26 = Block.field_338_u.field_378_bb;
               } else if(var25 > 0) {
                  var26 = Block.field_336_w.field_378_bb;
               }
            } else {
               var26 = Block.field_403_A.field_378_bb;
            }

            this.func_550_b(var10 + var24 * 16 - var14, var11 + var22 * 16 - var15, var26 % 16 << 4, var26 >> 4 << 4, 16, 16);
         }
      }

      GL11.glEnable(2929);
      GL11.glDepthFunc(515);
      GL11.glDisable(3553);

      int var27;
      int var30;
      for(var22 = 0; var22 < AchievementList.field_27388_e.size(); ++var22) {
         Achievement var33 = (Achievement)AchievementList.field_27388_e.get(var22);
         if(var33.field_25076_c != null) {
            var24 = var33.field_25075_a * 24 - var4 + 11 + var10;
            var25 = var33.field_25074_b * 24 - var5 + 11 + var11;
            var26 = var33.field_25076_c.field_25075_a * 24 - var4 + 11 + var10;
            var27 = var33.field_25076_c.field_25074_b * 24 - var5 + 11 + var11;
            boolean var28 = this.field_27120_x.func_27183_a(var33);
            boolean var29 = this.field_27120_x.func_27181_b(var33);
            var30 = Math.sin((double)(System.currentTimeMillis() % 600L) / 600.0D * 3.141592653589793D * 2.0D) > 0.6D?255:130;
            int var31 = -16777216;
            if(var28) {
               var31 = -9408400;
            } else if(var29) {
               var31 = '\uff00' + (var30 << 24);
            }

            this.func_27100_a(var24, var26, var25, var31);
            this.func_27099_b(var26, var25, var27, var31);
         }
      }

      Achievement var32 = null;
      RenderItem var34 = new RenderItem();
      RenderHelper.func_41089_c();
      GL11.glDisable(2896);
      GL11.glEnable('\u803a');
      GL11.glEnable(2903);

      int var39;
      int var40;
      for(var24 = 0; var24 < AchievementList.field_27388_e.size(); ++var24) {
         Achievement var35 = (Achievement)AchievementList.field_27388_e.get(var24);
         var26 = var35.field_25075_a * 24 - var4;
         var27 = var35.field_25074_b * 24 - var5;
         if(var26 >= -24 && var27 >= -24 && var26 <= 224 && var27 <= 155) {
            float var38;
            if(this.field_27120_x.func_27183_a(var35)) {
               var38 = 1.0F;
               GL11.glColor4f(var38, var38, var38, 1.0F);
            } else if(this.field_27120_x.func_27181_b(var35)) {
               var38 = Math.sin((double)(System.currentTimeMillis() % 600L) / 600.0D * 3.141592653589793D * 2.0D) < 0.6D?0.6F:0.8F;
               GL11.glColor4f(var38, var38, var38, 1.0F);
            } else {
               var38 = 0.3F;
               GL11.glColor4f(var38, var38, var38, 1.0F);
            }

            this.field_945_b.field_6315_n.func_1076_b(var7);
            var39 = var10 + var26;
            var40 = var11 + var27;
            if(var35.func_27093_f()) {
               this.func_550_b(var39 - 2, var40 - 2, 26, 202, 26, 26);
            } else {
               this.func_550_b(var39 - 2, var40 - 2, 0, 202, 26, 26);
            }

            if(!this.field_27120_x.func_27181_b(var35)) {
               float var41 = 0.1F;
               GL11.glColor4f(var41, var41, var41, 1.0F);
               var34.field_27004_a = false;
            }

            GL11.glEnable(2896);
            GL11.glEnable(2884);
            var34.func_161_a(this.field_945_b.field_6314_o, this.field_945_b.field_6315_n, var35.field_27097_d, var39 + 3, var40 + 3);
            GL11.glDisable(2896);
            if(!this.field_27120_x.func_27181_b(var35)) {
               var34.field_27004_a = true;
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            if(p_27109_1_ >= var10 && p_27109_2_ >= var11 && p_27109_1_ < var10 + 224 && p_27109_2_ < var11 + 155 && p_27109_1_ >= var39 && p_27109_1_ <= var39 + 22 && p_27109_2_ >= var40 && p_27109_2_ <= var40 + 22) {
               var32 = var35;
            }
         }
      }

      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_945_b.field_6315_n.func_1076_b(var7);
      this.func_550_b(var8, var9, 0, 0, this.field_27121_a, this.field_27119_i);
      GL11.glPopMatrix();
      this.field_923_k = 0.0F;
      GL11.glDepthFunc(515);
      GL11.glDisable(2929);
      GL11.glEnable(3553);
      super.func_571_a(p_27109_1_, p_27109_2_, p_27109_3_);
      if(var32 != null) {
         String var36 = StatCollector.func_25200_a(var32.func_44020_i());
         String var37 = var32.func_27090_e();
         var26 = p_27109_1_ + 12;
         var27 = p_27109_2_ - 4;
         if(this.field_27120_x.func_27181_b(var32)) {
            var39 = Math.max(this.field_6451_g.func_871_a(var36), 120);
            var40 = this.field_6451_g.func_27277_a(var37, var39);
            if(this.field_27120_x.func_27183_a(var32)) {
               var40 += 12;
            }

            this.func_549_a(var26 - 3, var27 - 3, var26 + var39 + 3, var27 + var40 + 3 + 12, -1073741824, -1073741824);
            this.field_6451_g.func_27278_a(var37, var26, var27 + 12, var39, -6250336);
            if(this.field_27120_x.func_27183_a(var32)) {
               this.field_6451_g.func_50103_a(StatCollector.func_25200_a("achievement.taken"), var26, var27 + var40 + 4, -7302913);
            }
         } else {
            var39 = Math.max(this.field_6451_g.func_871_a(var36), 120);
            String var42 = StatCollector.func_25199_a("achievement.requires", new Object[]{StatCollector.func_25200_a(var32.field_25076_c.func_44020_i())});
            var30 = this.field_6451_g.func_27277_a(var42, var39);
            this.func_549_a(var26 - 3, var27 - 3, var26 + var39 + 3, var27 + var30 + 12 + 3, -1073741824, -1073741824);
            this.field_6451_g.func_27278_a(var42, var26, var27 + 12, var39, -9416624);
         }

         this.field_6451_g.func_50103_a(var36, var26, var27, this.field_27120_x.func_27181_b(var32)?(var32.func_27093_f()?-128:-1):(var32.func_27093_f()?-8355776:-8355712));
      }

      GL11.glEnable(2929);
      GL11.glEnable(2896);
      RenderHelper.func_1159_a();
   }

   public boolean func_6450_b() {
      return true;
   }

}
