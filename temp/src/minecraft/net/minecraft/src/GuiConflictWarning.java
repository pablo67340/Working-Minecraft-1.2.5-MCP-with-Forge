package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;

public class GuiConflictWarning extends GuiScreen {

   private int field_965_a = 0;


   public void func_570_g() {
      ++this.field_965_a;
   }

   public void func_6448_a() {
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, "Back to title screen"));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 0) {
            this.field_945_b.func_6272_a(new GuiMainMenu());
         }

      }
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, "Level save conflict", this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
      this.func_547_b(this.field_6451_g, "Minecraft detected a conflict in the level save data.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 0, 10526880);
      this.func_547_b(this.field_6451_g, "This could be caused by two copies of the game", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 18, 10526880);
      this.func_547_b(this.field_6451_g, "accessing the same level.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 27, 10526880);
      this.func_547_b(this.field_6451_g, "To prevent level corruption, the current game has quit.", this.field_951_c / 2 - 140, this.field_950_d / 4 - 60 + 60 + 45, 10526880);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
