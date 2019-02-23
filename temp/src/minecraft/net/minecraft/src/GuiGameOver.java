package net.minecraft.src;

import java.util.Iterator;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;
import org.lwjgl.opengl.GL11;

public class GuiGameOver extends GuiScreen {

   private int field_48154_a;


   public void func_6448_a() {
      this.field_949_e.clear();
      if(this.field_945_b.field_6324_e.func_22144_v().func_40724_s()) {
         this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96, StatCollector.func_25200_a("deathScreen.deleteWorld")));
      } else {
         this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 72, StatCollector.func_25200_a("deathScreen.respawn")));
         this.field_949_e.add(new GuiButton(2, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96, StatCollector.func_25200_a("deathScreen.titleScreen")));
         if(this.field_945_b.field_6320_i == null) {
            ((GuiButton)this.field_949_e.get(1)).field_937_g = false;
         }
      }

      GuiButton var2;
      for(Iterator var1 = this.field_949_e.iterator(); var1.hasNext(); var2.field_937_g = false) {
         var2 = (GuiButton)var1.next();
      }

   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {}

   protected void func_572_a(GuiButton p_572_1_) {
      switch(p_572_1_.field_938_f) {
      case 1:
         if(this.field_945_b.field_6324_e.func_22144_v().func_40724_s()) {
            String var2 = this.field_945_b.field_6324_e.func_40479_y().func_40530_d();
            this.field_945_b.func_40002_b("Deleting world");
            ISaveFormat var3 = this.field_945_b.func_22004_c();
            var3.func_22177_c();
            var3.func_22172_c(var2);
            this.field_945_b.func_6272_a(new GuiMainMenu());
         } else {
            this.field_945_b.field_6322_g.func_9367_r();
            this.field_945_b.func_6272_a((GuiScreen)null);
         }
         break;
      case 2:
         if(this.field_945_b.func_6260_j()) {
            this.field_945_b.field_6324_e.func_660_k();
         }

         this.field_945_b.func_6261_a((World)null);
         this.field_945_b.func_6272_a(new GuiMainMenu());
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_549_a(0, 0, this.field_951_c, this.field_950_d, 1615855616, -1602211792);
      GL11.glPushMatrix();
      GL11.glScalef(2.0F, 2.0F, 2.0F);
      boolean var4 = this.field_945_b.field_6324_e.func_22144_v().func_40724_s();
      String var5 = var4?StatCollector.func_25200_a("deathScreen.title.hardcore"):StatCollector.func_25200_a("deathScreen.title");
      this.func_548_a(this.field_6451_g, var5, this.field_951_c / 2 / 2, 30, 16777215);
      GL11.glPopMatrix();
      if(var4) {
         this.func_548_a(this.field_6451_g, StatCollector.func_25200_a("deathScreen.hardcoreInfo"), this.field_951_c / 2, 144, 16777215);
      }

      this.func_548_a(this.field_6451_g, StatCollector.func_25200_a("deathScreen.score") + ": \u00a7e" + this.field_945_b.field_6322_g.func_6417_t(), this.field_951_c / 2, 100, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

   public boolean func_6450_b() {
      return false;
   }

   public void func_570_g() {
      super.func_570_g();
      ++this.field_48154_a;
      GuiButton var2;
      if(this.field_48154_a == 20) {
         for(Iterator var1 = this.field_949_e.iterator(); var1.hasNext(); var2.field_937_g = true) {
            var2 = (GuiButton)var1.next();
         }
      }

   }
}
