package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.src.TexturePackBase;
import org.lwjgl.opengl.GL11;

public class TexturePackCustom extends TexturePackBase {

   private ZipFile field_6496_e;
   private int field_6495_f = -1;
   private BufferedImage field_6494_g;
   private File field_6493_h;


   public TexturePackCustom(File p_i167_1_) {
      this.field_6487_a = p_i167_1_.getName();
      this.field_6493_h = p_i167_1_;
   }

   private String func_6492_b(String p_6492_1_) {
      if(p_6492_1_ != null && p_6492_1_.length() > 34) {
         p_6492_1_ = p_6492_1_.substring(0, 34);
      }

      return p_6492_1_;
   }

   public void func_6485_a(Minecraft p_6485_1_) throws IOException {
      ZipFile var2 = null;
      InputStream var3 = null;

      try {
         var2 = new ZipFile(this.field_6493_h);

         try {
            var3 = var2.getInputStream(var2.getEntry("pack.txt"));
            BufferedReader var4 = new BufferedReader(new InputStreamReader(var3));
            this.field_6486_b = this.func_6492_b(var4.readLine());
            this.field_6489_c = this.func_6492_b(var4.readLine());
            var4.close();
            var3.close();
         } catch (Exception var20) {
            ;
         }

         try {
            var3 = var2.getInputStream(var2.getEntry("pack.png"));
            this.field_6494_g = ImageIO.read(var3);
            var3.close();
         } catch (Exception var19) {
            ;
         }

         var2.close();
      } catch (Exception var21) {
         var21.printStackTrace();
      } finally {
         try {
            var3.close();
         } catch (Exception var18) {
            ;
         }

         try {
            var2.close();
         } catch (Exception var17) {
            ;
         }

      }

   }

   public void func_6484_b(Minecraft p_6484_1_) {
      if(this.field_6494_g != null) {
         p_6484_1_.field_6315_n.func_1078_a(this.field_6495_f);
      }

      this.func_6480_b();
   }

   public void func_6483_c(Minecraft p_6483_1_) {
      if(this.field_6494_g != null && this.field_6495_f < 0) {
         this.field_6495_f = p_6483_1_.field_6315_n.func_1074_a(this.field_6494_g);
      }

      if(this.field_6494_g != null) {
         p_6483_1_.field_6315_n.func_1076_b(this.field_6495_f);
      } else {
         GL11.glBindTexture(3553, p_6483_1_.field_6315_n.func_1070_a("/gui/unknown_pack.png"));
      }

   }

   public void func_6482_a() {
      try {
         this.field_6496_e = new ZipFile(this.field_6493_h);
      } catch (Exception var2) {
         ;
      }

   }

   public void func_6480_b() {
      try {
         this.field_6496_e.close();
      } catch (Exception var2) {
         ;
      }

      this.field_6496_e = null;
   }

   public InputStream func_6481_a(String p_6481_1_) {
      try {
         ZipEntry var2 = this.field_6496_e.getEntry(p_6481_1_.substring(1));
         if(var2 != null) {
            return this.field_6496_e.getInputStream(var2);
         }
      } catch (Exception var3) {
         ;
      }

      return TexturePackBase.class.getResourceAsStream(p_6481_1_);
   }
}
