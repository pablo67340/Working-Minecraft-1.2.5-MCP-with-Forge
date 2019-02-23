package net.minecraft.src;

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class CanvasMinecraftApplet extends Canvas {

   // $FF: synthetic field
   final MinecraftApplet field_1696_a;


   public CanvasMinecraftApplet(MinecraftApplet p_i506_1_) {
      this.field_1696_a = p_i506_1_;
   }

   public synchronized void addNotify() {
      super.addNotify();
      this.field_1696_a.func_6233_a();
   }

   public synchronized void removeNotify() {
      this.field_1696_a.func_6232_b();
      super.removeNotify();
   }
}
