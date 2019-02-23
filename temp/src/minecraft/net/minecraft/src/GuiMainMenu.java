package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiButtonLanguage;
import net.minecraft.src.GuiLanguage;
import net.minecraft.src.GuiMultiplayer;
import net.minecraft.src.GuiOptions;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSelectWorld;
import net.minecraft.src.GuiTexturePacks;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiMainMenu extends GuiScreen {

   private static final Random field_6463_h = new Random();
   private float field_989_j = 0.0F;
   private String field_6462_l = "missingno";
   private GuiButton field_25096_l;
   private int field_35357_f = 0;
   private int field_35358_g;


   public GuiMainMenu() {
      try {
         ArrayList var1 = new ArrayList();
         BufferedReader var2 = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8")));
         String var3 = "";

         while((var3 = var2.readLine()) != null) {
            var3 = var3.trim();
            if(var3.length() > 0) {
               var1.add(var3);
            }
         }

         do {
            this.field_6462_l = (String)var1.get(field_6463_h.nextInt(var1.size()));
         } while(this.field_6462_l.hashCode() == 125780783);
      } catch (Exception var4) {
         ;
      }

      this.field_989_j = field_6463_h.nextFloat();
   }

   public void func_570_g() {
      ++this.field_35357_f;
   }

   public boolean func_6450_b() {
      return false;
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {}

   public void func_6448_a() {
      this.field_35358_g = this.field_945_b.field_6315_n.func_1074_a(new BufferedImage(256, 256, 2));
      Calendar var1 = Calendar.getInstance();
      var1.setTime(new Date());
      if(var1.get(2) + 1 == 11 && var1.get(5) == 9) {
         this.field_6462_l = "Happy birthday, ez!";
      } else if(var1.get(2) + 1 == 6 && var1.get(5) == 1) {
         this.field_6462_l = "Happy birthday, Notch!";
      } else if(var1.get(2) + 1 == 12 && var1.get(5) == 24) {
         this.field_6462_l = "Merry X-mas!";
      } else if(var1.get(2) + 1 == 1 && var1.get(5) == 1) {
         this.field_6462_l = "Happy new year!";
      }

      StringTranslate var2 = StringTranslate.func_20162_a();
      int var4 = this.field_950_d / 4 + 48;
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, var4, var2.func_20163_a("menu.singleplayer")));
      this.field_949_e.add(this.field_25096_l = new GuiButton(2, this.field_951_c / 2 - 100, var4 + 24, var2.func_20163_a("menu.multiplayer")));
      this.field_949_e.add(new GuiButton(3, this.field_951_c / 2 - 100, var4 + 48, var2.func_20163_a("menu.mods")));
      if(this.field_945_b.field_6317_l) {
         this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, var4 + 72, var2.func_20163_a("menu.options")));
      } else {
         this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, var4 + 72 + 12, 98, 20, var2.func_20163_a("menu.options")));
         this.field_949_e.add(new GuiButton(4, this.field_951_c / 2 + 2, var4 + 72 + 12, 98, 20, var2.func_20163_a("menu.quit")));
      }

      this.field_949_e.add(new GuiButtonLanguage(5, this.field_951_c / 2 - 124, var4 + 72 + 12));
      if(this.field_945_b.field_6320_i == null) {
         this.field_25096_l.field_937_g = false;
      }

   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 0) {
         this.field_945_b.func_6272_a(new GuiOptions(this, this.field_945_b.field_6304_y));
      }

      if(p_572_1_.field_938_f == 5) {
         this.field_945_b.func_6272_a(new GuiLanguage(this, this.field_945_b.field_6304_y));
      }

      if(p_572_1_.field_938_f == 1) {
         this.field_945_b.func_6272_a(new GuiSelectWorld(this));
      }

      if(p_572_1_.field_938_f == 2) {
         this.field_945_b.func_6272_a(new GuiMultiplayer(this));
      }

      if(p_572_1_.field_938_f == 3) {
         this.field_945_b.func_6272_a(new GuiTexturePacks(this));
      }

      if(p_572_1_.field_938_f == 4) {
         this.field_945_b.func_6244_d();
      }

   }

   private void func_35355_b(int p_35355_1_, int p_35355_2_, float p_35355_3_) {
      Tessellator var4 = Tessellator.field_1512_a;
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GLU.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GL11.glMatrixMode(5888);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      GL11.glEnable(3042);
      GL11.glDisable(3008);
      GL11.glDisable(2884);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      byte var5 = 8;

      for(int var6 = 0; var6 < var5 * var5; ++var6) {
         GL11.glPushMatrix();
         float var7 = ((float)(var6 % var5) / (float)var5 - 0.5F) / 64.0F;
         float var8 = ((float)(var6 / var5) / (float)var5 - 0.5F) / 64.0F;
         float var9 = 0.0F;
         GL11.glTranslatef(var7, var8, var9);
         GL11.glRotatef(MathHelper.func_1106_a(((float)this.field_35357_f + p_35355_3_) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(-((float)this.field_35357_f + p_35355_3_) * 0.1F, 0.0F, 1.0F, 0.0F);

         for(int var10 = 0; var10 < 6; ++var10) {
            GL11.glPushMatrix();
            if(var10 == 1) {
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if(var10 == 2) {
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if(var10 == 3) {
               GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if(var10 == 4) {
               GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if(var10 == 5) {
               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("/title/bg/panorama" + var10 + ".png"));
            var4.func_977_b();
            var4.func_6513_a(16777215, 255 / (var6 + 1));
            float var11 = 0.0F;
            var4.func_983_a(-1.0D, -1.0D, 1.0D, (double)(0.0F + var11), (double)(0.0F + var11));
            var4.func_983_a(1.0D, -1.0D, 1.0D, (double)(1.0F - var11), (double)(0.0F + var11));
            var4.func_983_a(1.0D, 1.0D, 1.0D, (double)(1.0F - var11), (double)(1.0F - var11));
            var4.func_983_a(-1.0D, 1.0D, 1.0D, (double)(0.0F + var11), (double)(1.0F - var11));
            var4.func_982_a();
            GL11.glPopMatrix();
         }

         GL11.glPopMatrix();
         GL11.glColorMask(true, true, true, false);
      }

      var4.func_984_b(0.0D, 0.0D, 0.0D);
      GL11.glColorMask(true, true, true, true);
      GL11.glMatrixMode(5889);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glEnable(2884);
      GL11.glEnable(3008);
      GL11.glEnable(2929);
   }

   private void func_35354_a(float p_35354_1_) {
      GL11.glBindTexture(3553, this.field_35358_g);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glColorMask(true, true, true, false);
      Tessellator var2 = Tessellator.field_1512_a;
      var2.func_977_b();
      byte var3 = 3;

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.func_986_a(1.0F, 1.0F, 1.0F, 1.0F / (float)(var4 + 1));
         int var5 = this.field_951_c;
         int var6 = this.field_950_d;
         float var7 = (float)(var4 - var3 / 2) / 256.0F;
         var2.func_983_a((double)var5, (double)var6, (double)this.field_923_k, (double)(0.0F + var7), 0.0D);
         var2.func_983_a((double)var5, 0.0D, (double)this.field_923_k, (double)(1.0F + var7), 0.0D);
         var2.func_983_a(0.0D, 0.0D, (double)this.field_923_k, (double)(1.0F + var7), 1.0D);
         var2.func_983_a(0.0D, (double)var6, (double)this.field_923_k, (double)(0.0F + var7), 1.0D);
      }

      var2.func_982_a();
      GL11.glColorMask(true, true, true, true);
   }

   private void func_35356_c(int p_35356_1_, int p_35356_2_, float p_35356_3_) {
      GL11.glViewport(0, 0, 256, 256);
      this.func_35355_b(p_35356_1_, p_35356_2_, p_35356_3_);
      GL11.glDisable(3553);
      GL11.glEnable(3553);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      this.func_35354_a(p_35356_3_);
      GL11.glViewport(0, 0, this.field_945_b.field_6326_c, this.field_945_b.field_6325_d);
      Tessellator var4 = Tessellator.field_1512_a;
      var4.func_977_b();
      float var5 = this.field_951_c > this.field_950_d?120.0F / (float)this.field_951_c:120.0F / (float)this.field_950_d;
      float var6 = (float)this.field_950_d * var5 / 256.0F;
      float var7 = (float)this.field_951_c * var5 / 256.0F;
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      var4.func_986_a(1.0F, 1.0F, 1.0F, 1.0F);
      int var8 = this.field_951_c;
      int var9 = this.field_950_d;
      var4.func_983_a(0.0D, (double)var9, (double)this.field_923_k, (double)(0.5F - var6), (double)(0.5F + var7));
      var4.func_983_a((double)var8, (double)var9, (double)this.field_923_k, (double)(0.5F - var6), (double)(0.5F - var7));
      var4.func_983_a((double)var8, 0.0D, (double)this.field_923_k, (double)(0.5F + var6), (double)(0.5F - var7));
      var4.func_983_a(0.0D, 0.0D, (double)this.field_923_k, (double)(0.5F + var6), (double)(0.5F + var7));
      var4.func_982_a();
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_35356_c(p_571_1_, p_571_2_, p_571_3_);
      Tessellator var4 = Tessellator.field_1512_a;
      short var5 = 274;
      int var6 = this.field_951_c / 2 - var5 / 2;
      byte var7 = 30;
      this.func_549_a(0, 0, this.field_951_c, this.field_950_d, -2130706433, 16777215);
      this.func_549_a(0, 0, this.field_951_c, this.field_950_d, 0, Integer.MIN_VALUE);
      GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("/title/mclogo.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if((double)this.field_989_j < 1.0E-4D) {
         this.func_550_b(var6 + 0, var7 + 0, 0, 0, 99, 44);
         this.func_550_b(var6 + 99, var7 + 0, 129, 0, 27, 44);
         this.func_550_b(var6 + 99 + 26, var7 + 0, 126, 0, 3, 44);
         this.func_550_b(var6 + 99 + 26 + 3, var7 + 0, 99, 0, 26, 44);
         this.func_550_b(var6 + 155, var7 + 0, 0, 45, 155, 44);
      } else {
         this.func_550_b(var6 + 0, var7 + 0, 0, 0, 155, 44);
         this.func_550_b(var6 + 155, var7 + 0, 0, 45, 155, 44);
      }

      var4.func_990_b(16777215);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)(this.field_951_c / 2 + 90), 70.0F, 0.0F);
      GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
      float var8 = 1.8F - MathHelper.func_1112_e(MathHelper.func_1106_a((float)(System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F) * 0.1F);
      var8 = var8 * 100.0F / (float)(this.field_6451_g.func_871_a(this.field_6462_l) + 32);
      GL11.glScalef(var8, var8, var8);
      this.func_548_a(this.field_6451_g, this.field_6462_l, 0, -8, 16776960);
      GL11.glPopMatrix();
      this.func_547_b(this.field_6451_g, "Minecraft 1.2.5", 2, this.field_950_d - 10, 16777215);
      String var9 = "Copyright Mojang AB. Do not distribute!";
      this.func_547_b(this.field_6451_g, var9, this.field_951_c - this.field_6451_g.func_871_a(var9) - 2, this.field_950_d - 10, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

}
