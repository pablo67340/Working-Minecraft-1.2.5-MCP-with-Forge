package net.minecraft.src;

import java.awt.image.BufferedImage;
import net.minecraft.src.ImageBuffer;
import net.minecraft.src.ThreadDownloadImage;

public class ThreadDownloadImageData {

   public BufferedImage field_1706_a;
   public int field_1705_b = 1;
   public int field_1708_c = -1;
   public boolean field_1707_d = false;


   public ThreadDownloadImageData(String p_i287_1_, ImageBuffer p_i287_2_) {
      (new ThreadDownloadImage(this, p_i287_1_, p_i287_2_)).start();
   }
}
