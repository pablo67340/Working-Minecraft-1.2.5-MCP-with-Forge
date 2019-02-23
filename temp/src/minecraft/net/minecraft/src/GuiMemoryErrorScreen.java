package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.StringTranslate;

public class GuiMemoryErrorScreen extends GuiScreen {

   public void func_570_g() {}

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.clear();
      this.field_949_e.add(new GuiSmallButton(0, this.field_951_c / 2 - 155, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.toMenu")));
      this.field_949_e.add(new GuiSmallButton(1, this.field_951_c / 2 - 155 + 160, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("menu.quit")));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 0) {
         this.field_945_b.func_6272_a(new GuiMainMenu());
      } else if(p_572_1_.field_938_f == 1) {
         this.field_945_b.func_6244_d();
      }

   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {}

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, "Out of memory!", this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
      this.func_547_b(this.field_6451_g, "Minecraft has run out of memory.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 0, 10526880);
      this.func_547_b(this.field_6451_g, "This could be caused by a bug in the game or by the", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 18, 10526880);
      this.func_547_b(this.field_6451_g, "Java Virtual Machine not being allocated enough", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 27, 10526880);
      this.func_547_b(this.field_6451_g, "memory. If you are playing in a web browser, try", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 36, 10526880);
      this.func_547_b(this.field_6451_g, "downloading the game and playing it offline.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 45, 10526880);
      this.func_547_b(this.field_6451_g, "To prevent level corruption, the current game has quit.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 63, 10526880);
      this.func_547_b(this.field_6451_g, "We\'ve tried to free up enough memory to let you go back to", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 81, 10526880);
      this.func_547_b(this.field_6451_g, "the main menu and back to playing, but this may not have worked.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 90, 10526880);
      this.func_547_b(this.field_6451_g, "Please restart the game if you see this message again.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 99, 10526880);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
