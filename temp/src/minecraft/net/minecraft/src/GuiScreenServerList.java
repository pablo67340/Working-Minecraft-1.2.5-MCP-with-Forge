package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.ServerNBTStorage;
import net.minecraft.src.StringTranslate;
import org.lwjgl.input.Keyboard;

public class GuiScreenServerList extends GuiScreen {

   private static String field_52009_d = "";
   private final GuiScreen field_35319_a;
   private final ServerNBTStorage field_35318_c;
   private GuiTextField field_35317_b;


   public GuiScreenServerList(GuiScreen p_i28_1_, ServerNBTStorage p_i28_2_) {
      this.field_35319_a = p_i28_1_;
      this.field_35318_c = p_i28_2_;
   }

   public void func_570_g() {
      this.field_35317_b.func_22070_b();
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      Keyboard.enableRepeatEvents(true);
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + 12, var1.func_20163_a("selectServer.select")));
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
      this.field_35317_b = new GuiTextField(this.field_6451_g, this.field_951_c / 2 - 100, 116, 200, 20);
      this.field_35317_b.func_22066_a(128);
      this.field_35317_b.func_50033_b(true);
      this.field_35317_b.func_22068_a(field_52009_d);
      ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_35317_b.func_22071_a().length() > 0 && this.field_35317_b.func_22071_a().split(":").length > 0;
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
      field_52009_d = this.field_35317_b.func_22071_a();
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 1) {
            this.field_35319_a.func_568_a(false, 0);
         } else if(p_572_1_.field_938_f == 0) {
            this.field_35318_c.field_35793_b = this.field_35317_b.func_22071_a();
            this.field_35319_a.func_568_a(true, 0);
         }

      }
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      this.field_35317_b.func_50037_a(p_580_1_, p_580_2_);
      if(p_580_1_ == 28) {
         this.func_572_a((GuiButton)this.field_949_e.get(0));
      }

      ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_35317_b.func_22071_a().length() > 0 && this.field_35317_b.func_22071_a().split(":").length > 0;
   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      this.field_35317_b.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_578_i();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("selectServer.direct"), this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
      this.func_547_b(this.field_6451_g, var4.func_20163_a("addServer.enterIp"), this.field_951_c / 2 - 100, 100, 10526880);
      this.field_35317_b.func_22067_c();
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

}
