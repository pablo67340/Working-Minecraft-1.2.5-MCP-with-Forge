package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.minecraft.src.PanelCrashReport;

class CanvasMojangLogo extends Canvas {

   private BufferedImage field_1672_a;


   public CanvasMojangLogo() {
      try {
         this.field_1672_a = ImageIO.read(PanelCrashReport.class.getResource("/gui/crash_logo.png"));
      } catch (IOException var2) {
         ;
      }

      byte var1 = 100;
      this.setPreferredSize(new Dimension(var1, var1));
      this.setMinimumSize(new Dimension(var1, var1));
   }

   public void paint(Graphics p_paint_1_) {
      super.paint(p_paint_1_);
      p_paint_1_.drawImage(this.field_1672_a, this.getWidth() / 2 - this.field_1672_a.getWidth() / 2, 32, (ImageObserver)null);
   }
}
