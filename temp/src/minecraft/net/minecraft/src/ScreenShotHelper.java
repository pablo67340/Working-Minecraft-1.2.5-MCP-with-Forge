package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper {

   private static DateFormat field_4287_a = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
   private static ByteBuffer field_4286_b;
   private static byte[] field_4289_c;
   private static int[] field_4288_d;


   public static String func_4148_a(File p_4148_0_, int p_4148_1_, int p_4148_2_) {
      return func_35879_a(p_4148_0_, (String)null, p_4148_1_, p_4148_2_);
   }

   public static String func_35879_a(File p_35879_0_, String p_35879_1_, int p_35879_2_, int p_35879_3_) {
      try {
         File var4 = new File(p_35879_0_, "screenshots");
         var4.mkdir();
         if(field_4286_b == null || field_4286_b.capacity() < p_35879_2_ * p_35879_3_) {
            field_4286_b = BufferUtils.createByteBuffer(p_35879_2_ * p_35879_3_ * 3);
         }

         if(field_4288_d == null || field_4288_d.length < p_35879_2_ * p_35879_3_ * 3) {
            field_4289_c = new byte[p_35879_2_ * p_35879_3_ * 3];
            field_4288_d = new int[p_35879_2_ * p_35879_3_];
         }

         GL11.glPixelStorei(3333, 1);
         GL11.glPixelStorei(3317, 1);
         field_4286_b.clear();
         GL11.glReadPixels(0, 0, p_35879_2_, p_35879_3_, 6407, 5121, field_4286_b);
         field_4286_b.clear();
         String var5 = "" + field_4287_a.format(new Date());
         File var6;
         int var7;
         if(p_35879_1_ == null) {
            for(var7 = 1; (var6 = new File(var4, var5 + (var7 == 1?"":"_" + var7) + ".png")).exists(); ++var7) {
               ;
            }
         } else {
            var6 = new File(var4, p_35879_1_);
         }

         field_4286_b.get(field_4289_c);

         for(var7 = 0; var7 < p_35879_2_; ++var7) {
            for(int var8 = 0; var8 < p_35879_3_; ++var8) {
               int var9 = var7 + (p_35879_3_ - var8 - 1) * p_35879_2_;
               int var10 = field_4289_c[var9 * 3 + 0] & 255;
               int var11 = field_4289_c[var9 * 3 + 1] & 255;
               int var12 = field_4289_c[var9 * 3 + 2] & 255;
               int var13 = -16777216 | var10 << 16 | var11 << 8 | var12;
               field_4288_d[var7 + var8 * p_35879_2_] = var13;
            }
         }

         BufferedImage var15 = new BufferedImage(p_35879_2_, p_35879_3_, 1);
         var15.setRGB(0, 0, p_35879_2_, p_35879_3_, field_4288_d, 0, p_35879_2_);
         ImageIO.write(var15, "png", var6);
         return "Saved screenshot as " + var6.getName();
      } catch (Exception var14) {
         var14.printStackTrace();
         return "Failed to save: " + var14;
      }
   }

}
