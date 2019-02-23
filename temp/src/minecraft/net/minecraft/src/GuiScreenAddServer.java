package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.ServerNBTStorage;
import net.minecraft.src.StringTranslate;
import org.lwjgl.input.Keyboard;

public class GuiScreenAddServer extends GuiScreen {

   private GuiScreen field_35362_a;
   private GuiTextField field_35360_b;
   private GuiTextField field_35361_c;
   private ServerNBTStorage field_35359_d;


   public GuiScreenAddServer(GuiScreen p_i688_1_, ServerNBTStorage p_i688_2_) {
      this.field_35362_a = p_i688_1_;
      this.field_35359_d = p_i688_2_;
   }

   public void func_570_g() {
      this.field_35361_c.func_22070_b();
      this.field_35360_b.func_22070_b();
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      Keyboard.enableRepeatEvents(true);
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + 12, var1.func_20163_a("addServer.add")));
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
      this.field_35361_c = new GuiTextField(this.field_6451_g, this.field_951_c / 2 - 100, 76, 200, 20);
      this.field_35361_c.func_50033_b(true);
      this.field_35361_c.func_22068_a(this.field_35359_d.field_35795_a);
      this.field_35360_b = new GuiTextField(this.field_6451_g, this.field_951_c / 2 - 100, 116, 200, 20);
      this.field_35360_b.func_22066_a(128);
      this.field_35360_b.func_22068_a(this.field_35359_d.field_35793_b);
      ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_35360_b.func_22071_a().length() > 0 && this.field_35360_b.func_22071_a().split(":").length > 0 && this.field_35361_c.func_22071_a().length() > 0;
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 1) {
            this.field_35362_a.func_568_a(false, 0);
         } else if(p_572_1_.field_938_f == 0) {
            this.field_35359_d.field_35795_a = this.field_35361_c.func_22071_a();
            this.field_35359_d.field_35793_b = this.field_35360_b.func_22071_a();
            this.field_35362_a.func_568_a(true, 0);
         }

      }
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      this.field_35361_c.func_50037_a(p_580_1_, p_580_2_);
      this.field_35360_b.func_50037_a(p_580_1_, p_580_2_);
      if(p_580_1_ == 9) {
         if(this.field_35361_c.func_50025_j()) {
            this.field_35361_c.func_50033_b(false);
            this.field_35360_b.func_50033_b(true);
         } else {
            this.field_35361_c.func_50033_b(true);
            this.field_35360_b.func_50033_b(false);
         }
      }

      if(p_580_1_ == 13) {
         this.func_572_a((GuiButton)this.field_949_e.get(0));
      }

      ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_35360_b.func_22071_a().length() > 0 && this.field_35360_b.func_22071_a().split(":").length > 0 && this.field_35361_c.func_22071_a().length() > 0;
      if(((GuiButton)this.field_949_e.get(0)).field_937_g) {
         String var3 = this.field_35360_b.func_22071_a().trim();
         String[] var4 = var3.split(":");
         if(var4.length > 2) {
            ((GuiButton)this.field_949_e.get(0)).field_937_g = false;
         }
      }

   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      this.field_35360_b.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
      this.field_35361_c.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_578_i();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("addServer.title"), this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
      this.func_547_b(this.field_6451_g, var4.func_20163_a("addServer.enterName"), this.field_951_c / 2 - 100, 63, 10526880);
      this.func_547_b(this.field_6451_g, var4.func_20163_a("addServer.enterIp"), this.field_951_c / 2 - 100, 104, 10526880);
      this.field_35361_c.func_22067_c();
      this.field_35360_b.func_22067_c();
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
