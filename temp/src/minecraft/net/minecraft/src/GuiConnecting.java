package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.ThreadConnectToServer;
import net.minecraft.src.World;

public class GuiConnecting extends GuiScreen {

   private NetClientHandler field_952_a;
   private boolean field_953_h = false;


   public GuiConnecting(Minecraft p_i172_1_, String p_i172_2_, int p_i172_3_) {
      System.out.println("Connecting to " + p_i172_2_ + ", " + p_i172_3_);
      p_i172_1_.func_6261_a((World)null);
      (new ThreadConnectToServer(this, p_i172_1_, p_i172_2_, p_i172_3_)).start();
   }

   public void func_570_g() {
      if(this.field_952_a != null) {
         this.field_952_a.func_848_a();
      }

   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {}

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 0) {
         this.field_953_h = true;
         if(this.field_952_a != null) {
            this.field_952_a.func_849_b();
         }

         this.field_945_b.func_6272_a(new GuiMainMenu());
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      StringTranslate var4 = StringTranslate.func_20162_a();
      if(this.field_952_a == null) {
         this.func_548_a(this.field_6451_g, var4.func_20163_a("connect.connecting"), this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
         this.func_548_a(this.field_6451_g, "", this.field_951_c / 2, this.field_950_d / 2 - 10, 16777215);
      } else {
         this.func_548_a(this.field_6451_g, var4.func_20163_a("connect.authorizing"), this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
         this.func_548_a(this.field_6451_g, this.field_952_a.field_1209_a, this.field_951_c / 2, this.field_950_d / 2 - 10, 16777215);
      }

      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

   // $FF: synthetic method
   static NetClientHandler func_582_a(GuiConnecting p_582_0_, NetClientHandler p_582_1_) {
      return p_582_0_.field_952_a = p_582_1_;
   }

   // $FF: synthetic method
   static boolean func_581_a(GuiConnecting p_581_0_) {
      return p_581_0_.field_953_h;
   }

   // $FF: synthetic method
   static NetClientHandler func_583_b(GuiConnecting p_583_0_) {
      return p_583_0_.field_952_a;
   }
}
