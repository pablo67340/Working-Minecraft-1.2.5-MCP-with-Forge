package net.minecraft.src;

import net.minecraft.src.GuiAchievements;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiOptions;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiStats;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatList;
import net.minecraft.src.World;

public class GuiIngameMenu extends GuiScreen {

   private int field_966_a = 0;
   private int field_967_h = 0;


   public void func_6448_a() {
      this.field_966_a = 0;
      this.field_949_e.clear();
      byte var1 = -16;
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + var1, StatCollector.func_25200_a("menu.returnToMenu")));
      if(this.field_945_b.func_6260_j()) {
         ((GuiButton)this.field_949_e.get(0)).field_939_e = StatCollector.func_25200_a("menu.disconnect");
      }

      this.field_949_e.add(new GuiButton(4, this.field_951_c / 2 - 100, this.field_950_d / 4 + 24 + var1, StatCollector.func_25200_a("menu.returnToGame")));
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + var1, StatCollector.func_25200_a("menu.options")));
      this.field_949_e.add(new GuiButton(5, this.field_951_c / 2 - 100, this.field_950_d / 4 + 48 + var1, 98, 20, StatCollector.func_25200_a("gui.achievements")));
      this.field_949_e.add(new GuiButton(6, this.field_951_c / 2 + 2, this.field_950_d / 4 + 48 + var1, 98, 20, StatCollector.func_25200_a("gui.stats")));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      switch(p_572_1_.field_938_f) {
      case 0:
         this.field_945_b.func_6272_a(new GuiOptions(this, this.field_945_b.field_6304_y));
         break;
      case 1:
         this.field_945_b.field_25001_G.func_25100_a(StatList.field_25180_i, 1);
         if(this.field_945_b.func_6260_j()) {
            this.field_945_b.field_6324_e.func_660_k();
         }

         this.field_945_b.func_6261_a((World)null);
         this.field_945_b.func_6272_a(new GuiMainMenu());
      case 2:
      case 3:
      default:
         break;
      case 4:
         this.field_945_b.func_6272_a((GuiScreen)null);
         this.field_945_b.func_6259_e();
         break;
      case 5:
         this.field_945_b.func_6272_a(new GuiAchievements(this.field_945_b.field_25001_G));
         break;
      case 6:
         this.field_945_b.func_6272_a(new GuiStats(this, this.field_945_b.field_25001_G));
      }

   }

   public void func_570_g() {
      super.func_570_g();
      ++this.field_967_h;
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      boolean var4 = !this.field_945_b.field_6324_e.func_650_a(this.field_966_a++);
      if(var4 || this.field_967_h < 20) {
         float var5 = ((float)(this.field_967_h % 10) + p_571_3_) / 10.0F;
         var5 = MathHelper.func_1106_a(var5 * 3.1415927F * 2.0F) * 0.2F + 0.8F;
         int var6 = (int)(255.0F * var5);
         this.func_547_b(this.field_6451_g, "Saving level..", 8, this.field_950_d - 16, var6 << 16 | var6 << 8 | var6);
      }

      this.func_548_a(this.field_6451_g, "Game menu", this.field_951_c / 2, 40, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
