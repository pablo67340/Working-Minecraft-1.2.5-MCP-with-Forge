package net.minecraft.src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GameSettings;
import net.minecraft.src.ImageBuffer;
import net.minecraft.src.IntHashMap;
import net.minecraft.src.TextureFX;
import net.minecraft.src.TexturePackBase;
import net.minecraft.src.TexturePackList;
import net.minecraft.src.ThreadDownloadImageData;
import org.lwjgl.opengl.GL11;

public class RenderEngine {

   public static boolean field_1609_a = false;
   private HashMap field_6528_b = new HashMap();
   private HashMap field_28151_c = new HashMap();
   private IntHashMap field_1607_c = new IntHashMap();
   private IntBuffer field_1606_d = GLAllocation.func_1125_c(1);
   private ByteBuffer field_1605_e = GLAllocation.func_1127_b(16777216);
   private List field_1604_f = new ArrayList();
   private Map field_1603_g = new HashMap();
   private GameSettings field_1602_h;
   public boolean field_4281_i = false;
   public boolean field_4280_j = false;
   private TexturePackList field_6527_k;
   private BufferedImage field_25189_l = new BufferedImage(64, 64, 2);
   private int field_48512_n = 16;


   public RenderEngine(TexturePackList p_i754_1_, GameSettings p_i754_2_) {
      this.field_6527_k = p_i754_1_;
      this.field_1602_h = p_i754_2_;
      Graphics var3 = this.field_25189_l.getGraphics();
      var3.setColor(Color.WHITE);
      var3.fillRect(0, 0, 64, 64);
      var3.setColor(Color.BLACK);
      var3.drawString("missingtex", 1, 10);
      var3.dispose();
   }

   public int[] func_28149_a(String p_28149_1_) {
      TexturePackBase var2 = this.field_6527_k.field_6534_a;
      int[] var3 = (int[])this.field_28151_c.get(p_28149_1_);
      if(var3 != null) {
         return var3;
      } else {
         try {
            Object var6 = null;
            if(p_28149_1_.startsWith("##")) {
               var3 = this.func_28148_b(this.func_1069_b(this.func_6526_a(var2.func_6481_a(p_28149_1_.substring(2)))));
            } else if(p_28149_1_.startsWith("%clamp%")) {
               this.field_4281_i = true;
               var3 = this.func_28148_b(this.func_6526_a(var2.func_6481_a(p_28149_1_.substring(7))));
               this.field_4281_i = false;
            } else if(p_28149_1_.startsWith("%blur%")) {
               this.field_4280_j = true;
               this.field_4281_i = true;
               var3 = this.func_28148_b(this.func_6526_a(var2.func_6481_a(p_28149_1_.substring(6))));
               this.field_4281_i = false;
               this.field_4280_j = false;
            } else {
               InputStream var7 = var2.func_6481_a(p_28149_1_);
               if(var7 == null) {
                  var3 = this.func_28148_b(this.field_25189_l);
               } else {
                  var3 = this.func_28148_b(this.func_6526_a(var7));
               }
            }

            this.field_28151_c.put(p_28149_1_, var3);
            return var3;
         } catch (IOException var5) {
            var5.printStackTrace();
            int[] var4 = this.func_28148_b(this.field_25189_l);
            this.field_28151_c.put(p_28149_1_, var4);
            return var4;
         }
      }
   }

   private int[] func_28148_b(BufferedImage p_28148_1_) {
      int var2 = p_28148_1_.getWidth();
      int var3 = p_28148_1_.getHeight();
      int[] var4 = new int[var2 * var3];
      p_28148_1_.getRGB(0, 0, var2, var3, var4, 0, var2);
      return var4;
   }

   private int[] func_28147_a(BufferedImage p_28147_1_, int[] p_28147_2_) {
      int var3 = p_28147_1_.getWidth();
      int var4 = p_28147_1_.getHeight();
      p_28147_1_.getRGB(0, 0, var3, var4, p_28147_2_, 0, var3);
      return p_28147_2_;
   }

   public int func_1070_a(String p_1070_1_) {
      TexturePackBase var2 = this.field_6527_k.field_6534_a;
      Integer var3 = (Integer)this.field_6528_b.get(p_1070_1_);
      if(var3 != null) {
         return var3.intValue();
      } else {
         try {
            this.field_1606_d.clear();
            GLAllocation.func_1128_a(this.field_1606_d);
            int var6 = this.field_1606_d.get(0);
            if(p_1070_1_.startsWith("##")) {
               this.func_1068_a(this.func_1069_b(this.func_6526_a(var2.func_6481_a(p_1070_1_.substring(2)))), var6);
            } else if(p_1070_1_.startsWith("%clamp%")) {
               this.field_4281_i = true;
               this.func_1068_a(this.func_6526_a(var2.func_6481_a(p_1070_1_.substring(7))), var6);
               this.field_4281_i = false;
            } else if(p_1070_1_.startsWith("%blur%")) {
               this.field_4280_j = true;
               this.func_1068_a(this.func_6526_a(var2.func_6481_a(p_1070_1_.substring(6))), var6);
               this.field_4280_j = false;
            } else if(p_1070_1_.startsWith("%blurclamp%")) {
               this.field_4280_j = true;
               this.field_4281_i = true;
               this.func_1068_a(this.func_6526_a(var2.func_6481_a(p_1070_1_.substring(11))), var6);
               this.field_4280_j = false;
               this.field_4281_i = false;
            } else {
               InputStream var7 = var2.func_6481_a(p_1070_1_);
               if(var7 == null) {
                  this.func_1068_a(this.field_25189_l, var6);
               } else {
                  this.func_1068_a(this.func_6526_a(var7), var6);
               }
            }

            this.field_6528_b.put(p_1070_1_, Integer.valueOf(var6));
            return var6;
         } catch (Exception var5) {
            var5.printStackTrace();
            GLAllocation.func_1128_a(this.field_1606_d);
            int var4 = this.field_1606_d.get(0);
            this.func_1068_a(this.field_25189_l, var4);
            this.field_6528_b.put(p_1070_1_, Integer.valueOf(var4));
            return var4;
         }
      }
   }

   private BufferedImage func_1069_b(BufferedImage p_1069_1_) {
      int var2 = p_1069_1_.getWidth() / 16;
      BufferedImage var3 = new BufferedImage(16, p_1069_1_.getHeight() * var2, 2);
      Graphics var4 = var3.getGraphics();

      for(int var5 = 0; var5 < var2; ++var5) {
         var4.drawImage(p_1069_1_, -var5 * 16, var5 * p_1069_1_.getHeight(), (ImageObserver)null);
      }

      var4.dispose();
      return var3;
   }

   public int func_1074_a(BufferedImage p_1074_1_) {
      this.field_1606_d.clear();
      GLAllocation.func_1128_a(this.field_1606_d);
      int var2 = this.field_1606_d.get(0);
      this.func_1068_a(p_1074_1_, var2);
      this.field_1607_c.func_1061_a(var2, p_1074_1_);
      return var2;
   }

   public void func_1068_a(BufferedImage p_1068_1_, int p_1068_2_) {
      GL11.glBindTexture(3553, p_1068_2_);
      if(field_1609_a) {
         GL11.glTexParameteri(3553, 10241, 9986);
         GL11.glTexParameteri(3553, 10240, 9728);
      } else {
         GL11.glTexParameteri(3553, 10241, 9728);
         GL11.glTexParameteri(3553, 10240, 9728);
      }

      if(this.field_4280_j) {
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
      }

      if(this.field_4281_i) {
         GL11.glTexParameteri(3553, 10242, 10496);
         GL11.glTexParameteri(3553, 10243, 10496);
      } else {
         GL11.glTexParameteri(3553, 10242, 10497);
         GL11.glTexParameteri(3553, 10243, 10497);
      }

      int var3 = p_1068_1_.getWidth();
      int var4 = p_1068_1_.getHeight();
      int[] var5 = new int[var3 * var4];
      byte[] var6 = new byte[var3 * var4 * 4];
      p_1068_1_.getRGB(0, 0, var3, var4, var5, 0, var3);

      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      for(var7 = 0; var7 < var5.length; ++var7) {
         var8 = var5[var7] >> 24 & 255;
         var9 = var5[var7] >> 16 & 255;
         var10 = var5[var7] >> 8 & 255;
         var11 = var5[var7] & 255;
         if(this.field_1602_h != null && this.field_1602_h.field_1578_g) {
            var12 = (var9 * 30 + var10 * 59 + var11 * 11) / 100;
            var13 = (var9 * 30 + var10 * 70) / 100;
            var14 = (var9 * 30 + var11 * 70) / 100;
            var9 = var12;
            var10 = var13;
            var11 = var14;
         }

         var6[var7 * 4 + 0] = (byte)var9;
         var6[var7 * 4 + 1] = (byte)var10;
         var6[var7 * 4 + 2] = (byte)var11;
         var6[var7 * 4 + 3] = (byte)var8;
      }

      this.field_1605_e.clear();
      this.field_1605_e.put(var6);
      this.field_1605_e.position(0).limit(var6.length);
      GL11.glTexImage2D(3553, 0, 6408, var3, var4, 0, 6408, 5121, this.field_1605_e);
      if(field_1609_a) {
         for(var7 = 1; var7 <= 4; ++var7) {
            var8 = var3 >> var7 - 1;
            var9 = var3 >> var7;
            var10 = var4 >> var7;

            for(var11 = 0; var11 < var9; ++var11) {
               for(var12 = 0; var12 < var10; ++var12) {
                  var13 = this.field_1605_e.getInt((var11 * 2 + 0 + (var12 * 2 + 0) * var8) * 4);
                  var14 = this.field_1605_e.getInt((var11 * 2 + 1 + (var12 * 2 + 0) * var8) * 4);
                  int var15 = this.field_1605_e.getInt((var11 * 2 + 1 + (var12 * 2 + 1) * var8) * 4);
                  int var16 = this.field_1605_e.getInt((var11 * 2 + 0 + (var12 * 2 + 1) * var8) * 4);
                  int var17 = this.func_1077_b(this.func_1077_b(var13, var14), this.func_1077_b(var15, var16));
                  this.field_1605_e.putInt((var11 + var12 * var9) * 4, var17);
               }
            }

            GL11.glTexImage2D(3553, var7, 6408, var9, var10, 0, 6408, 5121, this.field_1605_e);
         }
      }

   }

   public void func_28150_a(int[] p_28150_1_, int p_28150_2_, int p_28150_3_, int p_28150_4_) {
      GL11.glBindTexture(3553, p_28150_4_);
      if(field_1609_a) {
         GL11.glTexParameteri(3553, 10241, 9986);
         GL11.glTexParameteri(3553, 10240, 9728);
      } else {
         GL11.glTexParameteri(3553, 10241, 9728);
         GL11.glTexParameteri(3553, 10240, 9728);
      }

      if(this.field_4280_j) {
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
      }

      if(this.field_4281_i) {
         GL11.glTexParameteri(3553, 10242, 10496);
         GL11.glTexParameteri(3553, 10243, 10496);
      } else {
         GL11.glTexParameteri(3553, 10242, 10497);
         GL11.glTexParameteri(3553, 10243, 10497);
      }

      byte[] var5 = new byte[p_28150_2_ * p_28150_3_ * 4];

      for(int var6 = 0; var6 < p_28150_1_.length; ++var6) {
         int var7 = p_28150_1_[var6] >> 24 & 255;
         int var8 = p_28150_1_[var6] >> 16 & 255;
         int var9 = p_28150_1_[var6] >> 8 & 255;
         int var10 = p_28150_1_[var6] & 255;
         if(this.field_1602_h != null && this.field_1602_h.field_1578_g) {
            int var11 = (var8 * 30 + var9 * 59 + var10 * 11) / 100;
            int var12 = (var8 * 30 + var9 * 70) / 100;
            int var13 = (var8 * 30 + var10 * 70) / 100;
            var8 = var11;
            var9 = var12;
            var10 = var13;
         }

         var5[var6 * 4 + 0] = (byte)var8;
         var5[var6 * 4 + 1] = (byte)var9;
         var5[var6 * 4 + 2] = (byte)var10;
         var5[var6 * 4 + 3] = (byte)var7;
      }

      this.field_1605_e.clear();
      this.field_1605_e.put(var5);
      this.field_1605_e.position(0).limit(var5.length);
      GL11.glTexSubImage2D(3553, 0, 0, 0, p_28150_2_, p_28150_3_, 6408, 5121, this.field_1605_e);
   }

   public void func_1078_a(int p_1078_1_) {
      this.field_1607_c.func_1052_b(p_1078_1_);
      this.field_1606_d.clear();
      this.field_1606_d.put(p_1078_1_);
      this.field_1606_d.flip();
      GL11.glDeleteTextures(this.field_1606_d);
   }

   public int func_1071_a(String p_1071_1_, String p_1071_2_) {
      ThreadDownloadImageData var3 = (ThreadDownloadImageData)this.field_1603_g.get(p_1071_1_);
      if(var3 != null && var3.field_1706_a != null && !var3.field_1707_d) {
         if(var3.field_1708_c < 0) {
            var3.field_1708_c = this.func_1074_a(var3.field_1706_a);
         } else {
            this.func_1068_a(var3.field_1706_a, var3.field_1708_c);
         }

         var3.field_1707_d = true;
      }

      return var3 != null && var3.field_1708_c >= 0?var3.field_1708_c:(p_1071_2_ == null?-1:this.func_1070_a(p_1071_2_));
   }

   public ThreadDownloadImageData func_1075_a(String p_1075_1_, ImageBuffer p_1075_2_) {
      ThreadDownloadImageData var3 = (ThreadDownloadImageData)this.field_1603_g.get(p_1075_1_);
      if(var3 == null) {
         this.field_1603_g.put(p_1075_1_, new ThreadDownloadImageData(p_1075_1_, p_1075_2_));
      } else {
         ++var3.field_1705_b;
      }

      return var3;
   }

   public void func_1073_b(String p_1073_1_) {
      ThreadDownloadImageData var2 = (ThreadDownloadImageData)this.field_1603_g.get(p_1073_1_);
      if(var2 != null) {
         --var2.field_1705_b;
         if(var2.field_1705_b == 0) {
            if(var2.field_1708_c >= 0) {
               this.func_1078_a(var2.field_1708_c);
            }

            this.field_1603_g.remove(p_1073_1_);
         }
      }

   }

   public void func_1066_a(TextureFX p_1066_1_) {
      this.field_1604_f.add(p_1066_1_);
      p_1066_1_.func_783_a();
   }

   public void func_1067_a() {
      int var1 = -1;

      for(int var2 = 0; var2 < this.field_1604_f.size(); ++var2) {
         TextureFX var3 = (TextureFX)this.field_1604_f.get(var2);
         var3.field_1131_c = this.field_1602_h.field_1578_g;
         var3.func_783_a();
         this.field_1605_e.clear();
         this.field_1605_e.put(var3.field_1127_a);
         this.field_1605_e.position(0).limit(var3.field_1127_a.length);
         if(var3.field_1126_b != var1) {
            var3.func_782_a(this);
            var1 = var3.field_1126_b;
         }

         for(int var4 = 0; var4 < var3.field_1129_e; ++var4) {
            for(int var5 = 0; var5 < var3.field_1129_e; ++var5) {
               GL11.glTexSubImage2D(3553, 0, var3.field_1126_b % 16 * 16 + var4 * 16, var3.field_1126_b / 16 * 16 + var5 * 16, 16, 16, 6408, 5121, this.field_1605_e);
            }
         }
      }

   }

   private int func_1077_b(int p_1077_1_, int p_1077_2_) {
      int var3 = (p_1077_1_ & -16777216) >> 24 & 255;
      int var4 = (p_1077_2_ & -16777216) >> 24 & 255;
      short var5 = 255;
      short var15;
      short var16;
      if(var3 + var4 < 255) {
         var5 = 0;
         var15 = 1;
         var16 = 1;
      } else if(var3 > var4) {
         var15 = 255;
         var16 = 1;
      } else {
         var15 = 1;
         var16 = 255;
      }

      int var6 = (p_1077_1_ >> 16 & 255) * var15;
      int var7 = (p_1077_1_ >> 8 & 255) * var15;
      int var8 = (p_1077_1_ & 255) * var15;
      int var9 = (p_1077_2_ >> 16 & 255) * var16;
      int var10 = (p_1077_2_ >> 8 & 255) * var16;
      int var11 = (p_1077_2_ & 255) * var16;
      int var12 = (var6 + var9) / (var15 + var16);
      int var13 = (var7 + var10) / (var15 + var16);
      int var14 = (var8 + var11) / (var15 + var16);
      return var5 << 24 | var12 << 16 | var13 << 8 | var14;
   }

   public void func_1065_b() {
      TexturePackBase var1 = this.field_6527_k.field_6534_a;
      Iterator var2 = this.field_1607_c.func_35860_b().iterator();

      BufferedImage var4;
      while(var2.hasNext()) {
         int var3 = ((Integer)var2.next()).intValue();
         var4 = (BufferedImage)this.field_1607_c.func_1057_a(var3);
         this.func_1068_a(var4, var3);
      }

      ThreadDownloadImageData var8;
      for(var2 = this.field_1603_g.values().iterator(); var2.hasNext(); var8.field_1707_d = false) {
         var8 = (ThreadDownloadImageData)var2.next();
      }

      var2 = this.field_6528_b.keySet().iterator();

      String var9;
      while(var2.hasNext()) {
         var9 = (String)var2.next();

         try {
            if(var9.startsWith("##")) {
               var4 = this.func_1069_b(this.func_6526_a(var1.func_6481_a(var9.substring(2))));
            } else if(var9.startsWith("%clamp%")) {
               this.field_4281_i = true;
               var4 = this.func_6526_a(var1.func_6481_a(var9.substring(7)));
            } else if(var9.startsWith("%blur%")) {
               this.field_4280_j = true;
               var4 = this.func_6526_a(var1.func_6481_a(var9.substring(6)));
            } else if(var9.startsWith("%blurclamp%")) {
               this.field_4280_j = true;
               this.field_4281_i = true;
               var4 = this.func_6526_a(var1.func_6481_a(var9.substring(11)));
            } else {
               var4 = this.func_6526_a(var1.func_6481_a(var9));
            }

            int var5 = ((Integer)this.field_6528_b.get(var9)).intValue();
            this.func_1068_a(var4, var5);
            this.field_4280_j = false;
            this.field_4281_i = false;
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

      var2 = this.field_28151_c.keySet().iterator();

      while(var2.hasNext()) {
         var9 = (String)var2.next();

         try {
            if(var9.startsWith("##")) {
               var4 = this.func_1069_b(this.func_6526_a(var1.func_6481_a(var9.substring(2))));
            } else if(var9.startsWith("%clamp%")) {
               this.field_4281_i = true;
               var4 = this.func_6526_a(var1.func_6481_a(var9.substring(7)));
            } else if(var9.startsWith("%blur%")) {
               this.field_4280_j = true;
               var4 = this.func_6526_a(var1.func_6481_a(var9.substring(6)));
            } else {
               var4 = this.func_6526_a(var1.func_6481_a(var9));
            }

            this.func_28147_a(var4, (int[])this.field_28151_c.get(var9));
            this.field_4280_j = false;
            this.field_4281_i = false;
         } catch (IOException var6) {
            var6.printStackTrace();
         }
      }

   }

   private BufferedImage func_6526_a(InputStream p_6526_1_) throws IOException {
      BufferedImage var2 = ImageIO.read(p_6526_1_);
      p_6526_1_.close();
      return var2;
   }

   public void func_1076_b(int p_1076_1_) {
      if(p_1076_1_ >= 0) {
         GL11.glBindTexture(3553, p_1076_1_);
      }
   }

}
