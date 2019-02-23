package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Packet9Respawn;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class GuiWinGame extends GuiScreen {

   private int field_41046_a = 0;
   private List field_41044_b;
   private int field_41042_d = 0;
   private float field_41043_e = 0.5F;


   public void func_570_g() {
      ++this.field_41046_a;
      float var1 = (float)(this.field_41042_d + this.field_950_d + this.field_950_d + 24) / this.field_41043_e;
      if((float)this.field_41046_a > var1) {
         this.func_41041_e();
      }

   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == 1) {
         this.func_41041_e();
      }

   }

   private void func_41041_e() {
      if(this.field_945_b.field_6324_e.field_1026_y) {
         EntityClientPlayerMP var1 = (EntityClientPlayerMP)this.field_945_b.field_6322_g;
         var1.field_797_bg.func_847_a(new Packet9Respawn(var1.field_4129_m, (byte)this.field_945_b.field_6324_e.field_1039_l, this.field_945_b.field_6324_e.func_22144_v().func_46133_t(), this.field_945_b.field_6324_e.func_48453_b(), 0));
      } else {
         this.field_945_b.func_6272_a((GuiScreen)null);
         this.field_945_b.func_6239_p(this.field_945_b.field_6324_e.field_1026_y, 0, true);
      }

   }

   public boolean func_6450_b() {
      return true;
   }

   public void func_6448_a() {
      if(this.field_41044_b == null) {
         this.field_41044_b = new ArrayList();

         try {
            String var1 = "";
            String var2 = "\u00a7f\u00a7k\u00a7a\u00a7b";
            short var3 = 274;
            BufferedReader var4 = new BufferedReader(new InputStreamReader(GuiWinGame.class.getResourceAsStream("/title/win.txt"), Charset.forName("UTF-8")));
            Random var5 = new Random(8124371L);

            int var6;
            while((var1 = var4.readLine()) != null) {
               String var7;
               String var8;
               for(var1 = var1.replaceAll("PLAYERNAME", this.field_945_b.field_6320_i.field_1666_b); var1.indexOf(var2) >= 0; var1 = var7 + "\u00a7f\u00a7k" + "XXXXXXXX".substring(0, var5.nextInt(4) + 3) + var8) {
                  var6 = var1.indexOf(var2);
                  var7 = var1.substring(0, var6);
                  var8 = var1.substring(var6 + var2.length());
               }

               this.field_41044_b.addAll(this.field_945_b.field_6314_o.func_50108_c(var1, var3));
               this.field_41044_b.add("");
            }

            for(var6 = 0; var6 < 8; ++var6) {
               this.field_41044_b.add("");
            }

            var4 = new BufferedReader(new InputStreamReader(GuiWinGame.class.getResourceAsStream("/title/credits.txt"), Charset.forName("UTF-8")));

            while((var1 = var4.readLine()) != null) {
               var1 = var1.replaceAll("PLAYERNAME", this.field_945_b.field_6320_i.field_1666_b);
               var1 = var1.replaceAll("\t", "    ");
               this.field_41044_b.addAll(this.field_945_b.field_6314_o.func_50108_c(var1, var3));
               this.field_41044_b.add("");
            }

            this.field_41042_d = this.field_41044_b.size() * 12;
         } catch (Exception var9) {
            var9.printStackTrace();
         }

      }
   }

   protected void func_572_a(GuiButton p_572_1_) {}

   private void func_41040_b(int p_41040_1_, int p_41040_2_, float p_41040_3_) {
      Tessellator var4 = Tessellator.field_1512_a;
      GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("%blur%/gui/background.png"));
      var4.func_977_b();
      var4.func_986_a(1.0F, 1.0F, 1.0F, 1.0F);
      int var5 = this.field_951_c;
      float var6 = 0.0F - ((float)this.field_41046_a + p_41040_3_) * 0.5F * this.field_41043_e;
      float var7 = (float)this.field_950_d - ((float)this.field_41046_a + p_41040_3_) * 0.5F * this.field_41043_e;
      float var8 = 0.015625F;
      float var9 = ((float)this.field_41046_a + p_41040_3_ - 0.0F) * 0.02F;
      float var10 = (float)(this.field_41042_d + this.field_950_d + this.field_950_d + 24) / this.field_41043_e;
      float var11 = (var10 - 20.0F - ((float)this.field_41046_a + p_41040_3_)) * 0.005F;
      if(var11 < var9) {
         var9 = var11;
      }

      if(var9 > 1.0F) {
         var9 = 1.0F;
      }

      var9 *= var9;
      var9 = var9 * 96.0F / 255.0F;
      var4.func_987_a(var9, var9, var9);
      var4.func_983_a(0.0D, (double)this.field_950_d, (double)this.field_923_k, 0.0D, (double)(var6 * var8));
      var4.func_983_a((double)var5, (double)this.field_950_d, (double)this.field_923_k, (double)((float)var5 * var8), (double)(var6 * var8));
      var4.func_983_a((double)var5, 0.0D, (double)this.field_923_k, (double)((float)var5 * var8), (double)(var7 * var8));
      var4.func_983_a(0.0D, 0.0D, (double)this.field_923_k, 0.0D, (double)(var7 * var8));
      var4.func_982_a();
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_41040_b(p_571_1_, p_571_2_, p_571_3_);
      Tessellator var4 = Tessellator.field_1512_a;
      short var5 = 274;
      int var6 = this.field_951_c / 2 - var5 / 2;
      int var7 = this.field_950_d + 50;
      float var8 = -((float)this.field_41046_a + p_571_3_) * this.field_41043_e;
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, var8, 0.0F);
      GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("/title/mclogo.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.func_550_b(var6, var7, 0, 0, 155, 44);
      this.func_550_b(var6 + 155, var7, 0, 45, 155, 44);
      var4.func_990_b(16777215);
      int var9 = var7 + 200;

      int var10;
      for(var10 = 0; var10 < this.field_41044_b.size(); ++var10) {
         if(var10 == this.field_41044_b.size() - 1) {
            float var11 = (float)var9 + var8 - (float)(this.field_950_d / 2 - 6);
            if(var11 < 0.0F) {
               GL11.glTranslatef(0.0F, -var11, 0.0F);
            }
         }

         if((float)var9 + var8 + 12.0F + 8.0F > 0.0F && (float)var9 + var8 < (float)this.field_950_d) {
            String var12 = (String)this.field_41044_b.get(var10);
            if(var12.startsWith("[C]")) {
               this.field_6451_g.func_50103_a(var12.substring(3), var6 + (var5 - this.field_6451_g.func_871_a(var12.substring(3))) / 2, var9, 16777215);
            } else {
               this.field_6451_g.field_41064_c.setSeed((long)var10 * 4238972211L + (long)(this.field_41046_a / 4));
               this.field_6451_g.func_50101_a(var12, var6 + 1, var9 + 1, 16777215, true);
               this.field_6451_g.field_41064_c.setSeed((long)var10 * 4238972211L + (long)(this.field_41046_a / 4));
               this.field_6451_g.func_50101_a(var12, var6, var9, 16777215, false);
            }
         }

         var9 += 12;
      }

      GL11.glPopMatrix();
      GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("%blur%/misc/vignette.png"));
      GL11.glEnable(3042);
      GL11.glBlendFunc(0, 769);
      var4.func_977_b();
      var4.func_986_a(1.0F, 1.0F, 1.0F, 1.0F);
      var10 = this.field_951_c;
      int var13 = this.field_950_d;
      var4.func_983_a(0.0D, (double)var13, (double)this.field_923_k, 0.0D, 1.0D);
      var4.func_983_a((double)var10, (double)var13, (double)this.field_923_k, 1.0D, 1.0D);
      var4.func_983_a((double)var10, 0.0D, (double)this.field_923_k, 1.0D, 0.0D);
      var4.func_983_a(0.0D, 0.0D, (double)this.field_923_k, 0.0D, 0.0D);
      var4.func_982_a();
      GL11.glDisable(3042);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
