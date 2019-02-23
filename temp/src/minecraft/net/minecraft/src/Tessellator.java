package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.OpenGlHelper;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Tessellator {

   private static boolean field_1511_b = false;
   private static boolean field_1510_c = false;
   private ByteBuffer field_1509_d;
   private IntBuffer field_1508_e;
   private FloatBuffer field_1507_f;
   private ShortBuffer field_35836_g;
   private int[] field_1506_g;
   private int field_1505_h = 0;
   private double field_1504_i;
   private double field_1503_j;
   private int field_35837_l;
   private int field_1502_k;
   private boolean field_1501_l = false;
   private boolean field_1500_m = false;
   private boolean field_35838_p = false;
   private boolean field_1499_n = false;
   private int field_1498_o = 0;
   private int field_1497_p = 0;
   private boolean field_1495_q = false;
   private int field_1493_r;
   private double field_1492_s;
   private double field_1491_t;
   private double field_1490_u;
   private int field_1489_v;
   public static final Tessellator field_1512_a = new Tessellator(2097152);
   private boolean field_1488_w = false;
   private boolean field_1487_x = false;
   private IntBuffer field_1486_y;
   private int field_1485_z = 0;
   private int field_1496_A = 10;
   private int field_1494_B;


   private Tessellator(int p_i52_1_) {
      this.field_1494_B = p_i52_1_;
      this.field_1509_d = GLAllocation.func_1127_b(p_i52_1_ * 4);
      this.field_1508_e = this.field_1509_d.asIntBuffer();
      this.field_1507_f = this.field_1509_d.asFloatBuffer();
      this.field_35836_g = this.field_1509_d.asShortBuffer();
      this.field_1506_g = new int[p_i52_1_];
      this.field_1487_x = field_1510_c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
      if(this.field_1487_x) {
         this.field_1486_y = GLAllocation.func_1125_c(this.field_1496_A);
         ARBVertexBufferObject.glGenBuffersARB(this.field_1486_y);
      }

   }

   public int func_982_a() {
      if(!this.field_1488_w) {
         throw new IllegalStateException("Not tesselating!");
      } else {
         this.field_1488_w = false;
         if(this.field_1505_h > 0) {
            this.field_1508_e.clear();
            this.field_1508_e.put(this.field_1506_g, 0, this.field_1498_o);
            this.field_1509_d.position(0);
            this.field_1509_d.limit(this.field_1498_o * 4);
            if(this.field_1487_x) {
               this.field_1485_z = (this.field_1485_z + 1) % this.field_1496_A;
               ARBVertexBufferObject.glBindBufferARB('\u8892', this.field_1486_y.get(this.field_1485_z));
               ARBVertexBufferObject.glBufferDataARB('\u8892', this.field_1509_d, '\u88e0');
            }

            if(this.field_1500_m) {
               if(this.field_1487_x) {
                  GL11.glTexCoordPointer(2, 5126, 32, 12L);
               } else {
                  this.field_1507_f.position(3);
                  GL11.glTexCoordPointer(2, 32, this.field_1507_f);
               }

               GL11.glEnableClientState('\u8078');
            }

            if(this.field_35838_p) {
               OpenGlHelper.func_40451_b(OpenGlHelper.field_40455_b);
               if(this.field_1487_x) {
                  GL11.glTexCoordPointer(2, 5122, 32, 28L);
               } else {
                  this.field_35836_g.position(14);
                  GL11.glTexCoordPointer(2, 32, this.field_35836_g);
               }

               GL11.glEnableClientState('\u8078');
               OpenGlHelper.func_40451_b(OpenGlHelper.field_40457_a);
            }

            if(this.field_1501_l) {
               if(this.field_1487_x) {
                  GL11.glColorPointer(4, 5121, 32, 20L);
               } else {
                  this.field_1509_d.position(20);
                  GL11.glColorPointer(4, true, 32, this.field_1509_d);
               }

               GL11.glEnableClientState('\u8076');
            }

            if(this.field_1499_n) {
               if(this.field_1487_x) {
                  GL11.glNormalPointer(5121, 32, 24L);
               } else {
                  this.field_1509_d.position(24);
                  GL11.glNormalPointer(32, this.field_1509_d);
               }

               GL11.glEnableClientState('\u8075');
            }

            if(this.field_1487_x) {
               GL11.glVertexPointer(3, 5126, 32, 0L);
            } else {
               this.field_1507_f.position(0);
               GL11.glVertexPointer(3, 32, this.field_1507_f);
            }

            GL11.glEnableClientState('\u8074');
            if(this.field_1493_r == 7 && field_1511_b) {
               GL11.glDrawArrays(4, 0, this.field_1505_h);
            } else {
               GL11.glDrawArrays(this.field_1493_r, 0, this.field_1505_h);
            }

            GL11.glDisableClientState('\u8074');
            if(this.field_1500_m) {
               GL11.glDisableClientState('\u8078');
            }

            if(this.field_35838_p) {
               OpenGlHelper.func_40451_b(OpenGlHelper.field_40455_b);
               GL11.glDisableClientState('\u8078');
               OpenGlHelper.func_40451_b(OpenGlHelper.field_40457_a);
            }

            if(this.field_1501_l) {
               GL11.glDisableClientState('\u8076');
            }

            if(this.field_1499_n) {
               GL11.glDisableClientState('\u8075');
            }
         }

         int var1 = this.field_1498_o * 4;
         this.func_985_d();
         return var1;
      }
   }

   private void func_985_d() {
      this.field_1505_h = 0;
      this.field_1509_d.clear();
      this.field_1498_o = 0;
      this.field_1497_p = 0;
   }

   public void func_977_b() {
      this.func_992_a(7);
   }

   public void func_992_a(int p_992_1_) {
      if(this.field_1488_w) {
         throw new IllegalStateException("Already tesselating!");
      } else {
         this.field_1488_w = true;
         this.func_985_d();
         this.field_1493_r = p_992_1_;
         this.field_1499_n = false;
         this.field_1501_l = false;
         this.field_1500_m = false;
         this.field_35838_p = false;
         this.field_1495_q = false;
      }
   }

   public void func_981_a(double p_981_1_, double p_981_3_) {
      this.field_1500_m = true;
      this.field_1504_i = p_981_1_;
      this.field_1503_j = p_981_3_;
   }

   public void func_35835_b(int p_35835_1_) {
      this.field_35838_p = true;
      this.field_35837_l = p_35835_1_;
   }

   public void func_987_a(float p_987_1_, float p_987_2_, float p_987_3_) {
      this.func_979_a((int)(p_987_1_ * 255.0F), (int)(p_987_2_ * 255.0F), (int)(p_987_3_ * 255.0F));
   }

   public void func_986_a(float p_986_1_, float p_986_2_, float p_986_3_, float p_986_4_) {
      this.func_978_a((int)(p_986_1_ * 255.0F), (int)(p_986_2_ * 255.0F), (int)(p_986_3_ * 255.0F), (int)(p_986_4_ * 255.0F));
   }

   public void func_979_a(int p_979_1_, int p_979_2_, int p_979_3_) {
      this.func_978_a(p_979_1_, p_979_2_, p_979_3_, 255);
   }

   public void func_978_a(int p_978_1_, int p_978_2_, int p_978_3_, int p_978_4_) {
      if(!this.field_1495_q) {
         if(p_978_1_ > 255) {
            p_978_1_ = 255;
         }

         if(p_978_2_ > 255) {
            p_978_2_ = 255;
         }

         if(p_978_3_ > 255) {
            p_978_3_ = 255;
         }

         if(p_978_4_ > 255) {
            p_978_4_ = 255;
         }

         if(p_978_1_ < 0) {
            p_978_1_ = 0;
         }

         if(p_978_2_ < 0) {
            p_978_2_ = 0;
         }

         if(p_978_3_ < 0) {
            p_978_3_ = 0;
         }

         if(p_978_4_ < 0) {
            p_978_4_ = 0;
         }

         this.field_1501_l = true;
         if(ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.field_1502_k = p_978_4_ << 24 | p_978_3_ << 16 | p_978_2_ << 8 | p_978_1_;
         } else {
            this.field_1502_k = p_978_1_ << 24 | p_978_2_ << 16 | p_978_3_ << 8 | p_978_4_;
         }

      }
   }

   public void func_983_a(double p_983_1_, double p_983_3_, double p_983_5_, double p_983_7_, double p_983_9_) {
      this.func_981_a(p_983_7_, p_983_9_);
      this.func_991_a(p_983_1_, p_983_3_, p_983_5_);
   }

   public void func_991_a(double p_991_1_, double p_991_3_, double p_991_5_) {
      ++this.field_1497_p;
      if(this.field_1493_r == 7 && field_1511_b && this.field_1497_p % 4 == 0) {
         for(int var7 = 0; var7 < 2; ++var7) {
            int var8 = 8 * (3 - var7);
            if(this.field_1500_m) {
               this.field_1506_g[this.field_1498_o + 3] = this.field_1506_g[this.field_1498_o - var8 + 3];
               this.field_1506_g[this.field_1498_o + 4] = this.field_1506_g[this.field_1498_o - var8 + 4];
            }

            if(this.field_35838_p) {
               this.field_1506_g[this.field_1498_o + 7] = this.field_1506_g[this.field_1498_o - var8 + 7];
            }

            if(this.field_1501_l) {
               this.field_1506_g[this.field_1498_o + 5] = this.field_1506_g[this.field_1498_o - var8 + 5];
            }

            this.field_1506_g[this.field_1498_o + 0] = this.field_1506_g[this.field_1498_o - var8 + 0];
            this.field_1506_g[this.field_1498_o + 1] = this.field_1506_g[this.field_1498_o - var8 + 1];
            this.field_1506_g[this.field_1498_o + 2] = this.field_1506_g[this.field_1498_o - var8 + 2];
            ++this.field_1505_h;
            this.field_1498_o += 8;
         }
      }

      if(this.field_1500_m) {
         this.field_1506_g[this.field_1498_o + 3] = Float.floatToRawIntBits((float)this.field_1504_i);
         this.field_1506_g[this.field_1498_o + 4] = Float.floatToRawIntBits((float)this.field_1503_j);
      }

      if(this.field_35838_p) {
         this.field_1506_g[this.field_1498_o + 7] = this.field_35837_l;
      }

      if(this.field_1501_l) {
         this.field_1506_g[this.field_1498_o + 5] = this.field_1502_k;
      }

      if(this.field_1499_n) {
         this.field_1506_g[this.field_1498_o + 6] = this.field_1489_v;
      }

      this.field_1506_g[this.field_1498_o + 0] = Float.floatToRawIntBits((float)(p_991_1_ + this.field_1492_s));
      this.field_1506_g[this.field_1498_o + 1] = Float.floatToRawIntBits((float)(p_991_3_ + this.field_1491_t));
      this.field_1506_g[this.field_1498_o + 2] = Float.floatToRawIntBits((float)(p_991_5_ + this.field_1490_u));
      this.field_1498_o += 8;
      ++this.field_1505_h;
      if(this.field_1505_h % 4 == 0 && this.field_1498_o >= this.field_1494_B - 32) {
         this.func_982_a();
         this.field_1488_w = true;
      }

   }

   public void func_990_b(int p_990_1_) {
      int var2 = p_990_1_ >> 16 & 255;
      int var3 = p_990_1_ >> 8 & 255;
      int var4 = p_990_1_ & 255;
      this.func_979_a(var2, var3, var4);
   }

   public void func_6513_a(int p_6513_1_, int p_6513_2_) {
      int var3 = p_6513_1_ >> 16 & 255;
      int var4 = p_6513_1_ >> 8 & 255;
      int var5 = p_6513_1_ & 255;
      this.func_978_a(var3, var4, var5, p_6513_2_);
   }

   public void func_989_c() {
      this.field_1495_q = true;
   }

   public void func_980_b(float p_980_1_, float p_980_2_, float p_980_3_) {
      this.field_1499_n = true;
      byte var4 = (byte)((int)(p_980_1_ * 127.0F));
      byte var5 = (byte)((int)(p_980_2_ * 127.0F));
      byte var6 = (byte)((int)(p_980_3_ * 127.0F));
      this.field_1489_v = var4 & 255 | (var5 & 255) << 8 | (var6 & 255) << 16;
   }

   public void func_984_b(double p_984_1_, double p_984_3_, double p_984_5_) {
      this.field_1492_s = p_984_1_;
      this.field_1491_t = p_984_3_;
      this.field_1490_u = p_984_5_;
   }

   public void func_988_c(float p_988_1_, float p_988_2_, float p_988_3_) {
      this.field_1492_s += (double)p_988_1_;
      this.field_1491_t += (double)p_988_2_;
      this.field_1490_u += (double)p_988_3_;
   }

}
