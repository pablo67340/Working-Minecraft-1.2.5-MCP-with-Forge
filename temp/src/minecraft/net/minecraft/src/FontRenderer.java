package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.Bidi;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.GameSettings;
import net.minecraft.src.RenderEngine;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class FontRenderer {

   private static final Pattern field_52015_r = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
   private int[] field_1307_b = new int[256];
   public int field_1308_a = 0;
   public int field_41063_b = 8;
   public Random field_41064_c = new Random();
   private byte[] field_44036_e = new byte[65536];
   private final int[] field_44034_f = new int[256];
   private int[] field_44035_g = new int[32];
   private int field_44038_h;
   private final RenderEngine field_44039_i;
   private float field_46126_j;
   private float field_46127_k;
   private boolean field_44037_j;
   private boolean field_46125_m;
   private float field_50115_n;
   private float field_50116_o;
   private float field_50118_p;
   private float field_50117_q;


   FontRenderer() {
      this.field_44039_i = null;
   }

   public FontRenderer(GameSettings p_i476_1_, String p_i476_2_, RenderEngine p_i476_3_, boolean p_i476_4_) {
      this.field_44039_i = p_i476_3_;
      this.field_44037_j = p_i476_4_;

      BufferedImage var5;
      try {
         var5 = ImageIO.read(RenderEngine.class.getResourceAsStream(p_i476_2_));
         InputStream var6 = RenderEngine.class.getResourceAsStream("/font/glyph_sizes.bin");
         var6.read(this.field_44036_e);
      } catch (IOException var18) {
         throw new RuntimeException(var18);
      }

      int var19 = var5.getWidth();
      int var7 = var5.getHeight();
      int[] var8 = new int[var19 * var7];
      var5.getRGB(0, 0, var19, var7, var8, 0, var19);
      int var9 = 0;

      int var10;
      int var11;
      int var12;
      int var13;
      int var15;
      int var16;
      while(var9 < 256) {
         var10 = var9 % 16;
         var11 = var9 / 16;
         var12 = 7;

         while(true) {
            if(var12 >= 0) {
               var13 = var10 * 8 + var12;
               boolean var14 = true;

               for(var15 = 0; var15 < 8 && var14; ++var15) {
                  var16 = (var11 * 8 + var15) * var19;
                  int var17 = var8[var13 + var16] & 255;
                  if(var17 > 0) {
                     var14 = false;
                  }
               }

               if(var14) {
                  --var12;
                  continue;
               }
            }

            if(var9 == 32) {
               var12 = 2;
            }

            this.field_1307_b[var9] = var12 + 2;
            ++var9;
            break;
         }
      }

      this.field_1308_a = p_i476_3_.func_1074_a(var5);

      for(var9 = 0; var9 < 32; ++var9) {
         var10 = (var9 >> 3 & 1) * 85;
         var11 = (var9 >> 2 & 1) * 170 + var10;
         var12 = (var9 >> 1 & 1) * 170 + var10;
         var13 = (var9 >> 0 & 1) * 170 + var10;
         if(var9 == 6) {
            var11 += 85;
         }

         if(p_i476_1_.field_1578_g) {
            int var20 = (var11 * 30 + var12 * 59 + var13 * 11) / 100;
            var15 = (var11 * 30 + var12 * 70) / 100;
            var16 = (var11 * 30 + var13 * 70) / 100;
            var11 = var20;
            var12 = var15;
            var13 = var16;
         }

         if(var9 >= 16) {
            var11 /= 4;
            var12 /= 4;
            var13 /= 4;
         }

         this.field_44035_g[var9] = (var11 & 255) << 16 | (var12 & 255) << 8 | var13 & 255;
      }

   }

   private float func_50112_a(int p_50112_1_, char p_50112_2_, boolean p_50112_3_) {
      return p_50112_2_ == 32?4.0F:(p_50112_1_ > 0 && !this.field_44037_j?this.func_50106_a(p_50112_1_ + 32, p_50112_3_):this.func_50111_a(p_50112_2_, p_50112_3_));
   }

   private float func_50106_a(int p_50106_1_, boolean p_50106_2_) {
      float var3 = (float)(p_50106_1_ % 16 * 8);
      float var4 = (float)(p_50106_1_ / 16 * 8);
      float var5 = p_50106_2_?1.0F:0.0F;
      if(this.field_44038_h != this.field_1308_a) {
         GL11.glBindTexture(3553, this.field_1308_a);
         this.field_44038_h = this.field_1308_a;
      }

      float var6 = (float)this.field_1307_b[p_50106_1_] - 0.01F;
      GL11.glBegin(5);
      GL11.glTexCoord2f(var3 / 128.0F, var4 / 128.0F);
      GL11.glVertex3f(this.field_46126_j + var5, this.field_46127_k, 0.0F);
      GL11.glTexCoord2f(var3 / 128.0F, (var4 + 7.99F) / 128.0F);
      GL11.glVertex3f(this.field_46126_j - var5, this.field_46127_k + 7.99F, 0.0F);
      GL11.glTexCoord2f((var3 + var6) / 128.0F, var4 / 128.0F);
      GL11.glVertex3f(this.field_46126_j + var6 + var5, this.field_46127_k, 0.0F);
      GL11.glTexCoord2f((var3 + var6) / 128.0F, (var4 + 7.99F) / 128.0F);
      GL11.glVertex3f(this.field_46126_j + var6 - var5, this.field_46127_k + 7.99F, 0.0F);
      GL11.glEnd();
      return (float)this.field_1307_b[p_50106_1_];
   }

   private void func_44030_b(int p_44030_1_) {
      String var3 = String.format("/font/glyph_%02X.png", new Object[]{Integer.valueOf(p_44030_1_)});

      BufferedImage var2;
      try {
         var2 = ImageIO.read(RenderEngine.class.getResourceAsStream(var3));
      } catch (IOException var5) {
         throw new RuntimeException(var5);
      }

      this.field_44034_f[p_44030_1_] = this.field_44039_i.func_1074_a(var2);
      this.field_44038_h = this.field_44034_f[p_44030_1_];
   }

   private float func_50111_a(char p_50111_1_, boolean p_50111_2_) {
      if(this.field_44036_e[p_50111_1_] == 0) {
         return 0.0F;
      } else {
         int var3 = p_50111_1_ / 256;
         if(this.field_44034_f[var3] == 0) {
            this.func_44030_b(var3);
         }

         if(this.field_44038_h != this.field_44034_f[var3]) {
            GL11.glBindTexture(3553, this.field_44034_f[var3]);
            this.field_44038_h = this.field_44034_f[var3];
         }

         int var4 = this.field_44036_e[p_50111_1_] >>> 4;
         int var5 = this.field_44036_e[p_50111_1_] & 15;
         float var6 = (float)var4;
         float var7 = (float)(var5 + 1);
         float var8 = (float)(p_50111_1_ % 16 * 16) + var6;
         float var9 = (float)((p_50111_1_ & 255) / 16 * 16);
         float var10 = var7 - var6 - 0.02F;
         float var11 = p_50111_2_?1.0F:0.0F;
         GL11.glBegin(5);
         GL11.glTexCoord2f(var8 / 256.0F, var9 / 256.0F);
         GL11.glVertex3f(this.field_46126_j + var11, this.field_46127_k, 0.0F);
         GL11.glTexCoord2f(var8 / 256.0F, (var9 + 15.98F) / 256.0F);
         GL11.glVertex3f(this.field_46126_j - var11, this.field_46127_k + 7.99F, 0.0F);
         GL11.glTexCoord2f((var8 + var10) / 256.0F, var9 / 256.0F);
         GL11.glVertex3f(this.field_46126_j + var10 / 2.0F + var11, this.field_46127_k, 0.0F);
         GL11.glTexCoord2f((var8 + var10) / 256.0F, (var9 + 15.98F) / 256.0F);
         GL11.glVertex3f(this.field_46126_j + var10 / 2.0F - var11, this.field_46127_k + 7.99F, 0.0F);
         GL11.glEnd();
         return (var7 - var6) / 2.0F + 1.0F;
      }
   }

   public int func_50103_a(String p_50103_1_, int p_50103_2_, int p_50103_3_, int p_50103_4_) {
      if(this.field_46125_m) {
         p_50103_1_ = this.func_46121_b(p_50103_1_);
      }

      int var5 = this.func_50101_a(p_50103_1_, p_50103_2_ + 1, p_50103_3_ + 1, p_50103_4_, true);
      var5 = Math.max(var5, this.func_50101_a(p_50103_1_, p_50103_2_, p_50103_3_, p_50103_4_, false));
      return var5;
   }

   public void func_873_b(String p_873_1_, int p_873_2_, int p_873_3_, int p_873_4_) {
      if(this.field_46125_m) {
         p_873_1_ = this.func_46121_b(p_873_1_);
      }

      this.func_50101_a(p_873_1_, p_873_2_, p_873_3_, p_873_4_, false);
   }

   private String func_46121_b(String p_46121_1_) {
      if(p_46121_1_ != null && Bidi.requiresBidi(p_46121_1_.toCharArray(), 0, p_46121_1_.length())) {
         Bidi var2 = new Bidi(p_46121_1_, -2);
         byte[] var3 = new byte[var2.getRunCount()];
         String[] var4 = new String[var3.length];

         int var7;
         for(int var5 = 0; var5 < var3.length; ++var5) {
            int var6 = var2.getRunStart(var5);
            var7 = var2.getRunLimit(var5);
            int var8 = var2.getRunLevel(var5);
            String var9 = p_46121_1_.substring(var6, var7);
            var3[var5] = (byte)var8;
            var4[var5] = var9;
         }

         String[] var11 = (String[])var4.clone();
         Bidi.reorderVisually(var3, 0, var4, 0, var3.length);
         StringBuilder var12 = new StringBuilder();
         var7 = 0;

         while(var7 < var4.length) {
            byte var13 = var3[var7];
            int var14 = 0;

            while(true) {
               if(var14 < var11.length) {
                  if(!var11[var14].equals(var4[var7])) {
                     ++var14;
                     continue;
                  }

                  var13 = var3[var14];
               }

               if((var13 & 1) == 0) {
                  var12.append(var4[var7]);
               } else {
                  for(var14 = var4[var7].length() - 1; var14 >= 0; --var14) {
                     char var10 = var4[var7].charAt(var14);
                     if(var10 == 40) {
                        var10 = 41;
                     } else if(var10 == 41) {
                        var10 = 40;
                     }

                     var12.append(var10);
                  }
               }

               ++var7;
               break;
            }
         }

         return var12.toString();
      } else {
         return p_46121_1_;
      }
   }

   private void func_44029_a(String p_44029_1_, boolean p_44029_2_) {
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;

      for(int var8 = 0; var8 < p_44029_1_.length(); ++var8) {
         char var9 = p_44029_1_.charAt(var8);
         int var10;
         int var11;
         if(var9 == 167 && var8 + 1 < p_44029_1_.length()) {
            var10 = "0123456789abcdefklmnor".indexOf(p_44029_1_.toLowerCase().charAt(var8 + 1));
            if(var10 < 16) {
               var3 = false;
               var4 = false;
               var7 = false;
               var6 = false;
               var5 = false;
               if(var10 < 0 || var10 > 15) {
                  var10 = 15;
               }

               if(p_44029_2_) {
                  var10 += 16;
               }

               var11 = this.field_44035_g[var10];
               GL11.glColor3f((float)(var11 >> 16) / 255.0F, (float)(var11 >> 8 & 255) / 255.0F, (float)(var11 & 255) / 255.0F);
            } else if(var10 == 16) {
               var3 = true;
            } else if(var10 == 17) {
               var4 = true;
            } else if(var10 == 18) {
               var7 = true;
            } else if(var10 == 19) {
               var6 = true;
            } else if(var10 == 20) {
               var5 = true;
            } else if(var10 == 21) {
               var3 = false;
               var4 = false;
               var7 = false;
               var6 = false;
               var5 = false;
               GL11.glColor4f(this.field_50115_n, this.field_50116_o, this.field_50118_p, this.field_50117_q);
            }

            ++var8;
         } else {
            var10 = ChatAllowedCharacters.field_20157_a.indexOf(var9);
            if(var3 && var10 > 0) {
               do {
                  var11 = this.field_41064_c.nextInt(ChatAllowedCharacters.field_20157_a.length());
               } while(this.field_1307_b[var10 + 32] != this.field_1307_b[var11 + 32]);

               var10 = var11;
            }

            float var14 = this.func_50112_a(var10, var9, var5);
            if(var4) {
               ++this.field_46126_j;
               this.func_50112_a(var10, var9, var5);
               --this.field_46126_j;
               ++var14;
            }

            Tessellator var12;
            if(var7) {
               var12 = Tessellator.field_1512_a;
               GL11.glDisable(3553);
               var12.func_977_b();
               var12.func_991_a((double)this.field_46126_j, (double)(this.field_46127_k + (float)(this.field_41063_b / 2)), 0.0D);
               var12.func_991_a((double)(this.field_46126_j + var14), (double)(this.field_46127_k + (float)(this.field_41063_b / 2)), 0.0D);
               var12.func_991_a((double)(this.field_46126_j + var14), (double)(this.field_46127_k + (float)(this.field_41063_b / 2) - 1.0F), 0.0D);
               var12.func_991_a((double)this.field_46126_j, (double)(this.field_46127_k + (float)(this.field_41063_b / 2) - 1.0F), 0.0D);
               var12.func_982_a();
               GL11.glEnable(3553);
            }

            if(var6) {
               var12 = Tessellator.field_1512_a;
               GL11.glDisable(3553);
               var12.func_977_b();
               int var13 = var6?-1:0;
               var12.func_991_a((double)(this.field_46126_j + (float)var13), (double)(this.field_46127_k + (float)this.field_41063_b), 0.0D);
               var12.func_991_a((double)(this.field_46126_j + var14), (double)(this.field_46127_k + (float)this.field_41063_b), 0.0D);
               var12.func_991_a((double)(this.field_46126_j + var14), (double)(this.field_46127_k + (float)this.field_41063_b - 1.0F), 0.0D);
               var12.func_991_a((double)(this.field_46126_j + (float)var13), (double)(this.field_46127_k + (float)this.field_41063_b - 1.0F), 0.0D);
               var12.func_982_a();
               GL11.glEnable(3553);
            }

            this.field_46126_j += var14;
         }
      }

   }

   public int func_50101_a(String p_50101_1_, int p_50101_2_, int p_50101_3_, int p_50101_4_, boolean p_50101_5_) {
      if(p_50101_1_ != null) {
         this.field_44038_h = 0;
         if((p_50101_4_ & -67108864) == 0) {
            p_50101_4_ |= -16777216;
         }

         if(p_50101_5_) {
            p_50101_4_ = (p_50101_4_ & 16579836) >> 2 | p_50101_4_ & -16777216;
         }

         this.field_50115_n = (float)(p_50101_4_ >> 16 & 255) / 255.0F;
         this.field_50116_o = (float)(p_50101_4_ >> 8 & 255) / 255.0F;
         this.field_50118_p = (float)(p_50101_4_ & 255) / 255.0F;
         this.field_50117_q = (float)(p_50101_4_ >> 24 & 255) / 255.0F;
         GL11.glColor4f(this.field_50115_n, this.field_50116_o, this.field_50118_p, this.field_50117_q);
         this.field_46126_j = (float)p_50101_2_;
         this.field_46127_k = (float)p_50101_3_;
         this.func_44029_a(p_50101_1_, p_50101_5_);
         return (int)this.field_46126_j;
      } else {
         return 0;
      }
   }

   public int func_871_a(String p_871_1_) {
      if(p_871_1_ == null) {
         return 0;
      } else {
         int var2 = 0;
         boolean var3 = false;

         for(int var4 = 0; var4 < p_871_1_.length(); ++var4) {
            char var5 = p_871_1_.charAt(var4);
            int var6 = this.func_50105_a(var5);
            if(var6 < 0 && var4 < p_871_1_.length() - 1) {
               ++var4;
               var5 = p_871_1_.charAt(var4);
               if(var5 != 108 && var5 != 76) {
                  if(var5 == 114 || var5 == 82) {
                     var3 = false;
                  }
               } else {
                  var3 = true;
               }

               var6 = this.func_50105_a(var5);
            }

            var2 += var6;
            if(var3) {
               ++var2;
            }
         }

         return var2;
      }
   }

   public int func_50105_a(char p_50105_1_) {
      if(p_50105_1_ == 167) {
         return -1;
      } else {
         int var2 = ChatAllowedCharacters.field_20157_a.indexOf(p_50105_1_);
         if(var2 >= 0 && !this.field_44037_j) {
            return this.field_1307_b[var2 + 32];
         } else if(this.field_44036_e[p_50105_1_] != 0) {
            int var3 = this.field_44036_e[p_50105_1_] >> 4;
            int var4 = this.field_44036_e[p_50105_1_] & 15;
            if(var4 > 7) {
               var4 = 15;
               var3 = 0;
            }

            ++var4;
            return (var4 - var3) / 2 + 1;
         } else {
            return 0;
         }
      }
   }

   public String func_50107_a(String p_50107_1_, int p_50107_2_) {
      return this.func_50104_a(p_50107_1_, p_50107_2_, false);
   }

   public String func_50104_a(String p_50104_1_, int p_50104_2_, boolean p_50104_3_) {
      StringBuilder var4 = new StringBuilder();
      int var5 = 0;
      int var6 = p_50104_3_?p_50104_1_.length() - 1:0;
      int var7 = p_50104_3_?-1:1;
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var6; var10 >= 0 && var10 < p_50104_1_.length() && var5 < p_50104_2_; var10 += var7) {
         char var11 = p_50104_1_.charAt(var10);
         int var12 = this.func_50105_a(var11);
         if(var8) {
            var8 = false;
            if(var11 != 108 && var11 != 76) {
               if(var11 == 114 || var11 == 82) {
                  var9 = false;
               }
            } else {
               var9 = true;
            }
         } else if(var12 < 0) {
            var8 = true;
         } else {
            var5 += var12;
            if(var9) {
               ++var5;
            }
         }

         if(var5 > p_50104_2_) {
            break;
         }

         if(p_50104_3_) {
            var4.insert(0, var11);
         } else {
            var4.append(var11);
         }
      }

      return var4.toString();
   }

   public void func_27278_a(String p_27278_1_, int p_27278_2_, int p_27278_3_, int p_27278_4_, int p_27278_5_) {
      if(this.field_46125_m) {
         p_27278_1_ = this.func_46121_b(p_27278_1_);
      }

      this.func_46124_b(p_27278_1_, p_27278_2_, p_27278_3_, p_27278_4_, p_27278_5_);
   }

   private void func_46124_b(String p_46124_1_, int p_46124_2_, int p_46124_3_, int p_46124_4_, int p_46124_5_) {
      this.func_46122_b(p_46124_1_, p_46124_2_, p_46124_3_, p_46124_4_, p_46124_5_, false);
   }

   private void func_46122_b(String p_46122_1_, int p_46122_2_, int p_46122_3_, int p_46122_4_, int p_46122_5_, boolean p_46122_6_) {
      String[] var7 = p_46122_1_.split("\n");
      if(var7.length > 1) {
         for(int var14 = 0; var14 < var7.length; ++var14) {
            this.func_46124_b(var7[var14], p_46122_2_, p_46122_3_, p_46122_4_, p_46122_5_);
            p_46122_3_ += this.func_27277_a(var7[var14], p_46122_4_);
         }

      } else {
         String[] var8 = p_46122_1_.split(" ");
         int var9 = 0;
         String var10 = "";

         while(var9 < var8.length) {
            String var11;
            for(var11 = var10 + var8[var9++] + " "; var9 < var8.length && this.func_871_a(var11 + var8[var9]) < p_46122_4_; var11 = var11 + var8[var9++] + " ") {
               ;
            }

            int var12;
            for(; this.func_871_a(var11) > p_46122_4_; var11 = var10 + var11.substring(var12)) {
               for(var12 = 0; this.func_871_a(var11.substring(0, var12 + 1)) <= p_46122_4_; ++var12) {
                  ;
               }

               if(var11.substring(0, var12).trim().length() > 0) {
                  String var13 = var11.substring(0, var12);
                  if(var13.lastIndexOf("\u00a7") >= 0) {
                     var10 = "\u00a7" + var13.charAt(var13.lastIndexOf("\u00a7") + 1);
                  }

                  this.func_50101_a(var13, p_46122_2_, p_46122_3_, p_46122_5_, p_46122_6_);
                  p_46122_3_ += this.field_41063_b;
               }
            }

            if(this.func_871_a(var11.trim()) > 0) {
               if(var11.lastIndexOf("\u00a7") >= 0) {
                  var10 = "\u00a7" + var11.charAt(var11.lastIndexOf("\u00a7") + 1);
               }

               this.func_50101_a(var11, p_46122_2_, p_46122_3_, p_46122_5_, p_46122_6_);
               p_46122_3_ += this.field_41063_b;
            }
         }

      }
   }

   public int func_27277_a(String p_27277_1_, int p_27277_2_) {
      String[] var3 = p_27277_1_.split("\n");
      int var5;
      if(var3.length > 1) {
         int var9 = 0;

         for(var5 = 0; var5 < var3.length; ++var5) {
            var9 += this.func_27277_a(var3[var5], p_27277_2_);
         }

         return var9;
      } else {
         String[] var4 = p_27277_1_.split(" ");
         var5 = 0;
         int var6 = 0;

         while(var5 < var4.length) {
            String var7;
            for(var7 = var4[var5++] + " "; var5 < var4.length && this.func_871_a(var7 + var4[var5]) < p_27277_2_; var7 = var7 + var4[var5++] + " ") {
               ;
            }

            int var8;
            for(; this.func_871_a(var7) > p_27277_2_; var7 = var7.substring(var8)) {
               for(var8 = 0; this.func_871_a(var7.substring(0, var8 + 1)) <= p_27277_2_; ++var8) {
                  ;
               }

               if(var7.substring(0, var8).trim().length() > 0) {
                  var6 += this.field_41063_b;
               }
            }

            if(var7.trim().length() > 0) {
               var6 += this.field_41063_b;
            }
         }

         if(var6 < this.field_41063_b) {
            var6 += this.field_41063_b;
         }

         return var6;
      }
   }

   public void func_44032_a(boolean p_44032_1_) {
      this.field_44037_j = p_44032_1_;
   }

   public void func_46123_b(boolean p_46123_1_) {
      this.field_46125_m = p_46123_1_;
   }

   public List func_50108_c(String p_50108_1_, int p_50108_2_) {
      return Arrays.asList(this.func_50113_d(p_50108_1_, p_50108_2_).split("\n"));
   }

   String func_50113_d(String p_50113_1_, int p_50113_2_) {
      int var3 = this.func_50102_e(p_50113_1_, p_50113_2_);
      if(p_50113_1_.length() <= var3) {
         return p_50113_1_;
      } else {
         String var4 = p_50113_1_.substring(0, var3);
         String var5 = func_50114_c(var4) + p_50113_1_.substring(var3 + (p_50113_1_.charAt(var3) == 32?1:0));
         return var4 + "\n" + this.func_50113_d(var5, p_50113_2_);
      }
   }

   private int func_50102_e(String p_50102_1_, int p_50102_2_) {
      int var3 = p_50102_1_.length();
      int var4 = 0;
      int var5 = 0;
      int var6 = -1;

      for(boolean var7 = false; var5 < var3; ++var5) {
         char var8 = p_50102_1_.charAt(var5);
         switch(var8) {
         case 32:
            var6 = var5;
         case 167:
            if(var5 != var3) {
               ++var5;
               char var9 = p_50102_1_.charAt(var5);
               if(var9 != 108 && var9 != 76) {
                  if(var9 == 114 || var9 == 82) {
                     var7 = false;
                  }
               } else {
                  var7 = true;
               }
            }
            break;
         default:
            var4 += this.func_50105_a(var8);
            if(var7) {
               ++var4;
            }
         }

         if(var8 == 10) {
            ++var5;
            var6 = var5;
            break;
         }

         if(var4 > p_50102_2_) {
            break;
         }
      }

      return var5 != var3 && var6 != -1 && var6 < var5?var6:var5;
   }

   private static boolean func_50110_b(char p_50110_0_) {
      return p_50110_0_ >= 48 && p_50110_0_ <= 57 || p_50110_0_ >= 97 && p_50110_0_ <= 102 || p_50110_0_ >= 65 && p_50110_0_ <= 70;
   }

   private static boolean func_50109_c(char p_50109_0_) {
      return p_50109_0_ >= 107 && p_50109_0_ <= 111 || p_50109_0_ >= 75 && p_50109_0_ <= 79 || p_50109_0_ == 114 || p_50109_0_ == 82;
   }

   private static String func_50114_c(String p_50114_0_) {
      String var1 = "";
      int var2 = -1;
      int var3 = p_50114_0_.length();

      while((var2 = p_50114_0_.indexOf(167, var2 + 1)) != -1) {
         if(var2 < var3 - 1) {
            char var4 = p_50114_0_.charAt(var2 + 1);
            if(func_50110_b(var4)) {
               var1 = "\u00a7" + var4;
            } else if(func_50109_c(var4)) {
               var1 = var1 + "\u00a7" + var4;
            }
         }
      }

      return var1;
   }

   public static String func_52014_d(String p_52014_0_) {
      return field_52015_r.matcher(p_52014_0_).replaceAll("");
   }

}
