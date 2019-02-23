package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Achievement;
import net.minecraft.src.Gui;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiAchievement extends Gui {

   private Minecraft field_25082_a;
   private int field_25081_b;
   private int field_25086_c;
   private String field_25085_d;
   private String field_25084_e;
   private Achievement field_27105_f;
   private long field_25083_f;
   private RenderItem field_27104_h;
   private boolean field_27103_i;


   public GuiAchievement(Minecraft p_i538_1_) {
      this.field_25082_a = p_i538_1_;
      this.field_27104_h = new RenderItem();
   }

   public void func_27102_a(Achievement p_27102_1_) {
      this.field_25085_d = StatCollector.func_25200_a("achievement.get");
      this.field_25084_e = StatCollector.func_25200_a(p_27102_1_.func_44020_i());
      this.field_25083_f = System.currentTimeMillis();
      this.field_27105_f = p_27102_1_;
      this.field_27103_i = false;
   }

   public void func_27101_b(Achievement p_27101_1_) {
      this.field_25085_d = StatCollector.func_25200_a(p_27101_1_.func_44020_i());
      this.field_25084_e = p_27101_1_.func_27090_e();
      this.field_25083_f = System.currentTimeMillis() - 2500L;
      this.field_27105_f = p_27101_1_;
      this.field_27103_i = true;
   }

   private void func_25079_b() {
      GL11.glViewport(0, 0, this.field_25082_a.field_6326_c, this.field_25082_a.field_6325_d);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      this.field_25081_b = this.field_25082_a.field_6326_c;
      this.field_25086_c = this.field_25082_a.field_6325_d;
      ScaledResolution var1 = new ScaledResolution(this.field_25082_a.field_6304_y, this.field_25082_a.field_6326_c, this.field_25082_a.field_6325_d);
      this.field_25081_b = var1.func_903_a();
      this.field_25086_c = var1.func_902_b();
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0D, (double)this.field_25081_b, (double)this.field_25086_c, 0.0D, 1000.0D, 3000.0D);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
   }

   public void func_25080_a() {
      if(this.field_27105_f != null && this.field_25083_f != 0L) {
         double var1 = (double)(System.currentTimeMillis() - this.field_25083_f) / 3000.0D;
         if(!this.field_27103_i && (var1 < 0.0D || var1 > 1.0D)) {
            this.field_25083_f = 0L;
         } else {
            this.func_25079_b();
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            double var3 = var1 * 2.0D;
            if(var3 > 1.0D) {
               var3 = 2.0D - var3;
            }

            var3 *= 4.0D;
            var3 = 1.0D - var3;
            if(var3 < 0.0D) {
               var3 = 0.0D;
            }

            var3 *= var3;
            var3 *= var3;
            int var5 = this.field_25081_b - 160;
            int var6 = 0 - (int)(var3 * 36.0D);
            int var7 = this.field_25082_a.field_6315_n.func_1070_a("/achievement/bg.png");
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3553);
            GL11.glBindTexture(3553, var7);
            GL11.glDisable(2896);
            this.func_550_b(var5, var6, 96, 202, 160, 32);
            if(this.field_27103_i) {
               this.field_25082_a.field_6314_o.func_27278_a(this.field_25084_e, var5 + 30, var6 + 7, 120, -1);
            } else {
               this.field_25082_a.field_6314_o.func_873_b(this.field_25085_d, var5 + 30, var6 + 7, -256);
               this.field_25082_a.field_6314_o.func_873_b(this.field_25084_e, var5 + 30, var6 + 18, -1);
            }

            RenderHelper.func_41089_c();
            GL11.glDisable(2896);
            GL11.glEnable('\u803a');
            GL11.glEnable(2903);
            GL11.glEnable(2896);
            this.field_27104_h.func_161_a(this.field_25082_a.field_6314_o, this.field_25082_a.field_6315_n, this.field_27105_f.field_27097_d, var5 + 8, var6 + 8);
            GL11.glDisable(2896);
            GL11.glDepthMask(true);
            GL11.glEnable(2929);
         }
      }
   }
}
