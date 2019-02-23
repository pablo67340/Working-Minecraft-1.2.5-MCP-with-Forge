package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MinecraftError;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class LoadingScreenRenderer implements IProgressUpdate {

   private String field_1004_a = "";
   private Minecraft field_1003_b;
   private String field_1007_c = "";
   private long field_1006_d = System.currentTimeMillis();
   private boolean field_1005_e = false;


   public LoadingScreenRenderer(Minecraft p_i385_1_) {
      this.field_1003_b = p_i385_1_;
   }

   public void func_596_a(String p_596_1_) {
      this.field_1005_e = false;
      this.func_597_c(p_596_1_);
   }

   public void func_594_b(String p_594_1_) {
      this.field_1005_e = true;
      this.func_597_c(this.field_1007_c);
   }

   public void func_597_c(String p_597_1_) {
      if(!this.field_1003_b.field_6293_H) {
         if(!this.field_1005_e) {
            throw new MinecraftError();
         }
      } else {
         this.field_1007_c = p_597_1_;
         ScaledResolution var2 = new ScaledResolution(this.field_1003_b.field_6304_y, this.field_1003_b.field_6326_c, this.field_1003_b.field_6325_d);
         GL11.glClear(256);
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         GL11.glOrtho(0.0D, var2.field_25121_a, var2.field_25120_b, 0.0D, 100.0D, 300.0D);
         GL11.glMatrixMode(5888);
         GL11.glLoadIdentity();
         GL11.glTranslatef(0.0F, 0.0F, -200.0F);
      }
   }

   public void func_595_d(String p_595_1_) {
      if(!this.field_1003_b.field_6293_H) {
         if(!this.field_1005_e) {
            throw new MinecraftError();
         }
      } else {
         this.field_1006_d = 0L;
         this.field_1004_a = p_595_1_;
         this.func_593_a(-1);
         this.field_1006_d = 0L;
      }
   }

   public void func_593_a(int p_593_1_) {
      if(!this.field_1003_b.field_6293_H) {
         if(!this.field_1005_e) {
            throw new MinecraftError();
         }
      } else {
         long var2 = System.currentTimeMillis();
         if(var2 - this.field_1006_d >= 100L) {
            this.field_1006_d = var2;
            ScaledResolution var4 = new ScaledResolution(this.field_1003_b.field_6304_y, this.field_1003_b.field_6326_c, this.field_1003_b.field_6325_d);
            int var5 = var4.func_903_a();
            int var6 = var4.func_902_b();
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, var4.field_25121_a, var4.field_25120_b, 0.0D, 100.0D, 300.0D);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -200.0F);
            GL11.glClear(16640);
            Tessellator var7 = Tessellator.field_1512_a;
            int var8 = this.field_1003_b.field_6315_n.func_1070_a("/gui/background.png");
            GL11.glBindTexture(3553, var8);
            float var9 = 32.0F;
            var7.func_977_b();
            var7.func_990_b(4210752);
            var7.func_983_a(0.0D, (double)var6, 0.0D, 0.0D, (double)((float)var6 / var9));
            var7.func_983_a((double)var5, (double)var6, 0.0D, (double)((float)var5 / var9), (double)((float)var6 / var9));
            var7.func_983_a((double)var5, 0.0D, 0.0D, (double)((float)var5 / var9), 0.0D);
            var7.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
            var7.func_982_a();
            if(p_593_1_ >= 0) {
               byte var10 = 100;
               byte var11 = 2;
               int var12 = var5 / 2 - var10 / 2;
               int var13 = var6 / 2 + 16;
               GL11.glDisable(3553);
               var7.func_977_b();
               var7.func_990_b(8421504);
               var7.func_991_a((double)var12, (double)var13, 0.0D);
               var7.func_991_a((double)var12, (double)(var13 + var11), 0.0D);
               var7.func_991_a((double)(var12 + var10), (double)(var13 + var11), 0.0D);
               var7.func_991_a((double)(var12 + var10), (double)var13, 0.0D);
               var7.func_990_b(8454016);
               var7.func_991_a((double)var12, (double)var13, 0.0D);
               var7.func_991_a((double)var12, (double)(var13 + var11), 0.0D);
               var7.func_991_a((double)(var12 + p_593_1_), (double)(var13 + var11), 0.0D);
               var7.func_991_a((double)(var12 + p_593_1_), (double)var13, 0.0D);
               var7.func_982_a();
               GL11.glEnable(3553);
            }

            this.field_1003_b.field_6314_o.func_50103_a(this.field_1007_c, (var5 - this.field_1003_b.field_6314_o.func_871_a(this.field_1007_c)) / 2, var6 / 2 - 4 - 16, 16777215);
            this.field_1003_b.field_6314_o.func_50103_a(this.field_1004_a, (var5 - this.field_1003_b.field_6314_o.func_871_a(this.field_1004_a)) / 2, var6 / 2 - 4 + 8, 16777215);
            Display.update();

            try {
               Thread.yield();
            } catch (Exception var14) {
               ;
            }

         }
      }
   }
}
