package net.minecraft.src;

import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiParticle;
import net.minecraft.src.Tessellator;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiScreen extends Gui {

   protected Minecraft field_945_b;
   public int field_951_c;
   public int field_950_d;
   protected List field_949_e = new ArrayList();
   public boolean field_948_f = false;
   protected FontRenderer field_6451_g;
   public GuiParticle field_25091_h;
   private GuiButton field_946_a = null;


   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      for(int var4 = 0; var4 < this.field_949_e.size(); ++var4) {
         GuiButton var5 = (GuiButton)this.field_949_e.get(var4);
         var5.func_561_a(this.field_945_b, p_571_1_, p_571_2_);
      }

   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == 1) {
         this.field_945_b.func_6272_a((GuiScreen)null);
         this.field_945_b.func_6259_e();
      }

   }

   public static String func_574_c() {
      try {
         Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
         if(var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return (String)var0.getTransferData(DataFlavor.stringFlavor);
         }
      } catch (Exception var1) {
         ;
      }

      return "";
   }

   public static void func_50050_a(String p_50050_0_) {
      try {
         StringSelection var1 = new StringSelection(p_50050_0_);
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var1, (ClipboardOwner)null);
      } catch (Exception var2) {
         ;
      }

   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      if(p_565_3_ == 0) {
         for(int var4 = 0; var4 < this.field_949_e.size(); ++var4) {
            GuiButton var5 = (GuiButton)this.field_949_e.get(var4);
            if(var5.func_562_c(this.field_945_b, p_565_1_, p_565_2_)) {
               this.field_946_a = var5;
               this.field_945_b.field_6301_A.func_337_a("random.click", 1.0F, 1.0F);
               this.func_572_a(var5);
            }
         }
      }

   }

   protected void func_573_b(int p_573_1_, int p_573_2_, int p_573_3_) {
      if(this.field_946_a != null && p_573_3_ == 0) {
         this.field_946_a.func_559_a(p_573_1_, p_573_2_);
         this.field_946_a = null;
      }

   }

   protected void func_572_a(GuiButton p_572_1_) {}

   public void func_6447_a(Minecraft p_6447_1_, int p_6447_2_, int p_6447_3_) {
      this.field_25091_h = new GuiParticle(p_6447_1_);
      this.field_945_b = p_6447_1_;
      this.field_6451_g = p_6447_1_.field_6314_o;
      this.field_951_c = p_6447_2_;
      this.field_950_d = p_6447_3_;
      this.field_949_e.clear();
      this.func_6448_a();
   }

   public void func_6448_a() {}

   public void func_564_d() {
      while(Mouse.next()) {
         this.func_566_e();
      }

      while(Keyboard.next()) {
         this.func_569_f();
      }

   }

   public void func_566_e() {
      int var1;
      int var2;
      if(Mouse.getEventButtonState()) {
         var1 = Mouse.getEventX() * this.field_951_c / this.field_945_b.field_6326_c;
         var2 = this.field_950_d - Mouse.getEventY() * this.field_950_d / this.field_945_b.field_6325_d - 1;
         this.func_565_a(var1, var2, Mouse.getEventButton());
      } else {
         var1 = Mouse.getEventX() * this.field_951_c / this.field_945_b.field_6326_c;
         var2 = this.field_950_d - Mouse.getEventY() * this.field_950_d / this.field_945_b.field_6325_d - 1;
         this.func_573_b(var1, var2, Mouse.getEventButton());
      }

   }

   public void func_569_f() {
      if(Keyboard.getEventKeyState()) {
         if(Keyboard.getEventKey() == 87) {
            this.field_945_b.func_6270_h();
            return;
         }

         this.func_580_a(Keyboard.getEventCharacter(), Keyboard.getEventKey());
      }

   }

   public void func_570_g() {}

   public void func_6449_h() {}

   public void func_578_i() {
      this.func_567_a(0);
   }

   public void func_567_a(int p_567_1_) {
      if(this.field_945_b.field_6324_e != null) {
         this.func_549_a(0, 0, this.field_951_c, this.field_950_d, -1072689136, -804253680);
      } else {
         this.func_579_b(p_567_1_);
      }

   }

   public void func_579_b(int p_579_1_) {
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      Tessellator var2 = Tessellator.field_1512_a;
      GL11.glBindTexture(3553, this.field_945_b.field_6315_n.func_1070_a("/gui/background.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float var3 = 32.0F;
      var2.func_977_b();
      var2.func_990_b(4210752);
      var2.func_983_a(0.0D, (double)this.field_950_d, 0.0D, 0.0D, (double)((float)this.field_950_d / var3 + (float)p_579_1_));
      var2.func_983_a((double)this.field_951_c, (double)this.field_950_d, 0.0D, (double)((float)this.field_951_c / var3), (double)((float)this.field_950_d / var3 + (float)p_579_1_));
      var2.func_983_a((double)this.field_951_c, 0.0D, 0.0D, (double)((float)this.field_951_c / var3), (double)p_579_1_);
      var2.func_983_a(0.0D, 0.0D, 0.0D, 0.0D, (double)p_579_1_);
      var2.func_982_a();
   }

   public boolean func_6450_b() {
      return true;
   }

   public void func_568_a(boolean p_568_1_, int p_568_2_) {}

   public static boolean func_50051_l() {
      return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
   }

   public static boolean func_50049_m() {
      return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
   }
}
