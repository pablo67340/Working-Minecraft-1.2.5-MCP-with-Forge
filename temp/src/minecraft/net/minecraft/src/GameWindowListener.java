package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.minecraft.client.Minecraft;

public final class GameWindowListener extends WindowAdapter {

   // $FF: synthetic field
   final Minecraft field_1587_a;
   // $FF: synthetic field
   final Thread field_1586_b;


   public GameWindowListener(Minecraft p_i358_1_, Thread p_i358_2_) {
      this.field_1587_a = p_i358_1_;
      this.field_1586_b = p_i358_2_;
   }

   public void windowClosing(WindowEvent p_windowClosing_1_) {
      this.field_1587_a.func_6244_d();

      try {
         this.field_1586_b.join();
      } catch (InterruptedException var3) {
         var3.printStackTrace();
      }

      System.exit(0);
   }
}
