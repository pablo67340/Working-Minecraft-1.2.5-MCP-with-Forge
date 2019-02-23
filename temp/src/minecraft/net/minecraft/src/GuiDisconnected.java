package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.StringTranslate;

public class GuiDisconnected extends GuiScreen {

   private String field_992_a;
   private String field_993_h;


   public GuiDisconnected(String p_i292_1_, String p_i292_2_, Object ... p_i292_3_) {
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.field_992_a = var4.func_20163_a(p_i292_1_);
      if(p_i292_3_ != null) {
         this.field_993_h = var4.func_20160_a(p_i292_2_, p_i292_3_);
      } else {
         this.field_993_h = var4.func_20163_a(p_i292_2_);
      }

   }

   public void func_570_g() {}

   protected void func_580_a(char p_580_1_, int p_580_2_) {}

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.toMenu")));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 0) {
         this.field_945_b.func_6272_a(new GuiMainMenu());
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, this.field_992_a, this.field_951_c / 2, this.field_950_d / 2 - 50, 16777215);
      this.func_548_a(this.field_6451_g, this.field_993_h, this.field_951_c / 2, this.field_950_d / 2 - 10, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
