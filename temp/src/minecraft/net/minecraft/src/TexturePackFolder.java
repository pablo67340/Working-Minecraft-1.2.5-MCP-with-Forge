package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.src.TexturePackBase;
import org.lwjgl.opengl.GL11;

public class TexturePackFolder extends TexturePackBase {

   private int field_48191_e = -1;
   private BufferedImage field_48189_f;
   private File field_48190_g;


   public TexturePackFolder(File p_i1013_1_) {
      this.field_6487_a = p_i1013_1_.getName();
      this.field_48190_g = p_i1013_1_;
   }

   private String func_48188_b(String p_48188_1_) {
      if(p_48188_1_ != null && p_48188_1_.length() > 34) {
         p_48188_1_ = p_48188_1_.substring(0, 34);
      }

      return p_48188_1_;
   }

   public void func_6485_a(Minecraft p_6485_1_) throws IOException {
      InputStream var2 = null;

      try {
         try {
            var2 = this.func_6481_a("pack.txt");
            BufferedReader var3 = new BufferedReader(new InputStreamReader(var2));
            this.field_6486_b = this.func_48188_b(var3.readLine());
            this.field_6489_c = this.func_48188_b(var3.readLine());
            var3.close();
            var2.close();
         } catch (Exception var15) {
            ;
         }

         try {
            var2 = this.func_6481_a("pack.png");
            this.field_48189_f = ImageIO.read(var2);
            var2.close();
         } catch (Exception var14) {
            ;
         }
      } catch (Exception var16) {
         var16.printStackTrace();
      } finally {
         try {
            var2.close();
         } catch (Exception var13) {
            ;
         }

      }

   }

   public void func_6484_b(Minecraft p_6484_1_) {
      if(this.field_48189_f != null) {
         p_6484_1_.field_6315_n.func_1078_a(this.field_48191_e);
      }

      this.func_6480_b();
   }

   public void func_6483_c(Minecraft p_6483_1_) {
      if(this.field_48189_f != null && this.field_48191_e < 0) {
         this.field_48191_e = p_6483_1_.field_6315_n.func_1074_a(this.field_48189_f);
      }

      if(this.field_48189_f != null) {
         p_6483_1_.field_6315_n.func_1076_b(this.field_48191_e);
      } else {
         GL11.glBindTexture(3553, p_6483_1_.field_6315_n.func_1070_a("/gui/unknown_pack.png"));
      }

   }

   public void func_6482_a() {}

   public void func_6480_b() {}

   public InputStream func_6481_a(String p_6481_1_) {
      try {
         File var2 = new File(this.field_48190_g, p_6481_1_.substring(1));
         if(var2.exists()) {
            return new BufferedInputStream(new FileInputStream(var2));
         }
      } catch (Exception var3) {
         ;
      }

      return TexturePackBase.class.getResourceAsStream(p_6481_1_);
   }
}
