package net.minecraft.src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EnumOS1;
import net.minecraft.src.IsoImageBuffer;
import net.minecraft.src.OsMap;
import net.minecraft.src.SaveHandler;
import net.minecraft.src.TerrainTextureManager;
import net.minecraft.src.ThreadRunIsoClient;
import net.minecraft.src.World;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;

public class CanvasIsomPreview extends Canvas implements KeyListener, MouseListener, MouseMotionListener, Runnable {

   private int field_1793_a = 0;
   private int field_1792_b = 2;
   private boolean field_1791_c = true;
   private World field_1790_d;
   private File field_1789_e = this.func_1263_a();
   private boolean field_1788_f = true;
   private List field_1787_g = Collections.synchronizedList(new LinkedList());
   private IsoImageBuffer[][] field_1786_h = new IsoImageBuffer[64][64];
   private int field_1785_i;
   private int field_1784_j;
   private int field_1783_k;
   private int field_1782_l;


   public File func_1263_a() {
      if(this.field_1789_e == null) {
         this.field_1789_e = this.func_1264_a("minecraft");
      }

      return this.field_1789_e;
   }

   public File func_1264_a(String p_1264_1_) {
      String var2 = System.getProperty("user.home", ".");
      File var3;
      switch(OsMap.field_1193_a[func_1269_e().ordinal()]) {
      case 1:
      case 2:
         var3 = new File(var2, '.' + p_1264_1_ + '/');
         break;
      case 3:
         String var4 = System.getenv("APPDATA");
         if(var4 != null) {
            var3 = new File(var4, "." + p_1264_1_ + '/');
         } else {
            var3 = new File(var2, '.' + p_1264_1_ + '/');
         }
         break;
      case 4:
         var3 = new File(var2, "Library/Application Support/" + p_1264_1_);
         break;
      default:
         var3 = new File(var2, p_1264_1_ + '/');
      }

      if(!var3.exists() && !var3.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + var3);
      } else {
         return var3;
      }
   }

   private static EnumOS1 func_1269_e() {
      String var0 = System.getProperty("os.name").toLowerCase();
      return var0.contains("win")?EnumOS1.windows:(var0.contains("mac")?EnumOS1.macos:(var0.contains("solaris")?EnumOS1.solaris:(var0.contains("sunos")?EnumOS1.solaris:(var0.contains("linux")?EnumOS1.linux:(var0.contains("unix")?EnumOS1.linux:EnumOS1.unknown)))));
   }

   public CanvasIsomPreview() {
      for(int var1 = 0; var1 < 64; ++var1) {
         for(int var2 = 0; var2 < 64; ++var2) {
            this.field_1786_h[var1][var2] = new IsoImageBuffer((World)null, var1, var2);
         }
      }

      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);
      this.setFocusable(true);
      this.requestFocus();
      this.setBackground(Color.red);
   }

   public void func_1270_b(String p_1270_1_) {
      this.field_1785_i = this.field_1784_j = 0;
      this.field_1790_d = new World(new SaveHandler(new File(this.field_1789_e, "saves"), p_1270_1_, false), p_1270_1_, new WorldSettings((new Random()).nextLong(), 0, true, false, WorldType.field_48635_b));
      this.field_1790_d.field_1046_e = 0;
      List var2 = this.field_1787_g;
      synchronized(this.field_1787_g) {
         this.field_1787_g.clear();

         for(int var3 = 0; var3 < 64; ++var3) {
            for(int var4 = 0; var4 < 64; ++var4) {
               this.field_1786_h[var3][var4].func_888_a(this.field_1790_d, var3, var4);
            }
         }

      }
   }

   private void func_1266_a(int p_1266_1_) {
      List var2 = this.field_1787_g;
      synchronized(this.field_1787_g) {
         this.field_1790_d.field_1046_e = p_1266_1_;
         this.field_1787_g.clear();

         for(int var3 = 0; var3 < 64; ++var3) {
            for(int var4 = 0; var4 < 64; ++var4) {
               this.field_1786_h[var3][var4].func_888_a(this.field_1790_d, var3, var4);
            }
         }

      }
   }

   public void func_1272_b() {
      (new ThreadRunIsoClient(this)).start();

      for(int var1 = 0; var1 < 8; ++var1) {
         (new Thread(this)).start();
      }

   }

   public void func_1273_c() {
      this.field_1788_f = false;
   }

   private IsoImageBuffer func_1267_a(int p_1267_1_, int p_1267_2_) {
      int var3 = p_1267_1_ & 63;
      int var4 = p_1267_2_ & 63;
      IsoImageBuffer var5 = this.field_1786_h[var3][var4];
      if(var5.field_1354_c == p_1267_1_ && var5.field_1353_d == p_1267_2_) {
         return var5;
      } else {
         List var6 = this.field_1787_g;
         synchronized(this.field_1787_g) {
            this.field_1787_g.remove(var5);
         }

         var5.func_889_a(p_1267_1_, p_1267_2_);
         return var5;
      }
   }

   public void run() {
      TerrainTextureManager var1 = new TerrainTextureManager();

      while(this.field_1788_f) {
         IsoImageBuffer var2 = null;
         List var3 = this.field_1787_g;
         synchronized(this.field_1787_g) {
            if(this.field_1787_g.size() > 0) {
               var2 = (IsoImageBuffer)this.field_1787_g.remove(0);
            }
         }

         if(var2 != null) {
            if(this.field_1793_a - var2.field_1350_g < 2) {
               var1.func_799_a(var2);
               this.repaint();
            } else {
               var2.field_1349_h = false;
            }
         }

         try {
            Thread.sleep(2L);
         } catch (InterruptedException var5) {
            var5.printStackTrace();
         }
      }

   }

   public void update(Graphics p_update_1_) {}

   public void paint(Graphics p_paint_1_) {}

   public void func_1265_d() {
      BufferStrategy var1 = this.getBufferStrategy();
      if(var1 == null) {
         this.createBufferStrategy(2);
      } else {
         this.func_1268_a((Graphics2D)var1.getDrawGraphics());
         var1.show();
      }
   }

   public void func_1268_a(Graphics2D p_1268_1_) {
      ++this.field_1793_a;
      AffineTransform var2 = p_1268_1_.getTransform();
      p_1268_1_.setClip(0, 0, this.getWidth(), this.getHeight());
      p_1268_1_.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
      p_1268_1_.translate(this.getWidth() / 2, this.getHeight() / 2);
      p_1268_1_.scale((double)this.field_1792_b, (double)this.field_1792_b);
      p_1268_1_.translate(this.field_1785_i, this.field_1784_j);
      if(this.field_1790_d != null) {
         ChunkCoordinates var3 = this.field_1790_d.func_22137_s();
         p_1268_1_.translate(-(var3.field_22395_a + var3.field_22396_c), -(-var3.field_22395_a + var3.field_22396_c) + 64);
      }

      Rectangle var17 = p_1268_1_.getClipBounds();
      p_1268_1_.setColor(new Color(-15724512));
      p_1268_1_.fillRect(var17.x, var17.y, var17.width, var17.height);
      byte var4 = 16;
      byte var5 = 3;
      int var6 = var17.x / var4 / 2 - 2 - var5;
      int var7 = (var17.x + var17.width) / var4 / 2 + 1 + var5;
      int var8 = var17.y / var4 - 1 - var5 * 2;
      int var9 = (var17.y + var17.height + 16 + 128) / var4 + 1 + var5 * 2;

      int var10;
      for(var10 = var8; var10 <= var9; ++var10) {
         for(int var11 = var6; var11 <= var7; ++var11) {
            int var12 = var11 - (var10 >> 1);
            int var13 = var11 + (var10 + 1 >> 1);
            IsoImageBuffer var14 = this.func_1267_a(var12, var13);
            var14.field_1350_g = this.field_1793_a;
            if(!var14.field_1352_e) {
               if(!var14.field_1349_h) {
                  var14.field_1349_h = true;
                  this.field_1787_g.add(var14);
               }
            } else {
               var14.field_1349_h = false;
               if(!var14.field_1351_f) {
                  int var15 = var11 * var4 * 2 + (var10 & 1) * var4;
                  int var16 = var10 * var4 - 128 - 16;
                  p_1268_1_.drawImage(var14.field_1348_a, var15, var16, (ImageObserver)null);
               }
            }
         }
      }

      if(this.field_1791_c) {
         p_1268_1_.setTransform(var2);
         var10 = this.getHeight() - 32 - 4;
         p_1268_1_.setColor(new Color(Integer.MIN_VALUE, true));
         p_1268_1_.fillRect(4, this.getHeight() - 32 - 4, this.getWidth() - 8, 32);
         p_1268_1_.setColor(Color.WHITE);
         String var18 = "F1 - F5: load levels   |   0-9: Set time of day   |   Space: return to spawn   |   Double click: zoom   |   Escape: hide this text";
         p_1268_1_.drawString(var18, this.getWidth() / 2 - p_1268_1_.getFontMetrics().stringWidth(var18) / 2, var10 + 20);
      }

      p_1268_1_.dispose();
   }

   public void mouseDragged(MouseEvent p_mouseDragged_1_) {
      int var2 = p_mouseDragged_1_.getX() / this.field_1792_b;
      int var3 = p_mouseDragged_1_.getY() / this.field_1792_b;
      this.field_1785_i += var2 - this.field_1783_k;
      this.field_1784_j += var3 - this.field_1782_l;
      this.field_1783_k = var2;
      this.field_1782_l = var3;
      this.repaint();
   }

   public void mouseMoved(MouseEvent p_mouseMoved_1_) {}

   public void mouseClicked(MouseEvent p_mouseClicked_1_) {
      if(p_mouseClicked_1_.getClickCount() == 2) {
         this.field_1792_b = 3 - this.field_1792_b;
         this.repaint();
      }

   }

   public void mouseEntered(MouseEvent p_mouseEntered_1_) {}

   public void mouseExited(MouseEvent p_mouseExited_1_) {}

   public void mousePressed(MouseEvent p_mousePressed_1_) {
      int var2 = p_mousePressed_1_.getX() / this.field_1792_b;
      int var3 = p_mousePressed_1_.getY() / this.field_1792_b;
      this.field_1783_k = var2;
      this.field_1782_l = var3;
   }

   public void mouseReleased(MouseEvent p_mouseReleased_1_) {}

   public void keyPressed(KeyEvent p_keyPressed_1_) {
      if(p_keyPressed_1_.getKeyCode() == 48) {
         this.func_1266_a(11);
      }

      if(p_keyPressed_1_.getKeyCode() == 49) {
         this.func_1266_a(10);
      }

      if(p_keyPressed_1_.getKeyCode() == 50) {
         this.func_1266_a(9);
      }

      if(p_keyPressed_1_.getKeyCode() == 51) {
         this.func_1266_a(7);
      }

      if(p_keyPressed_1_.getKeyCode() == 52) {
         this.func_1266_a(6);
      }

      if(p_keyPressed_1_.getKeyCode() == 53) {
         this.func_1266_a(5);
      }

      if(p_keyPressed_1_.getKeyCode() == 54) {
         this.func_1266_a(3);
      }

      if(p_keyPressed_1_.getKeyCode() == 55) {
         this.func_1266_a(2);
      }

      if(p_keyPressed_1_.getKeyCode() == 56) {
         this.func_1266_a(1);
      }

      if(p_keyPressed_1_.getKeyCode() == 57) {
         this.func_1266_a(0);
      }

      if(p_keyPressed_1_.getKeyCode() == 112) {
         this.func_1270_b("World1");
      }

      if(p_keyPressed_1_.getKeyCode() == 113) {
         this.func_1270_b("World2");
      }

      if(p_keyPressed_1_.getKeyCode() == 114) {
         this.func_1270_b("World3");
      }

      if(p_keyPressed_1_.getKeyCode() == 115) {
         this.func_1270_b("World4");
      }

      if(p_keyPressed_1_.getKeyCode() == 116) {
         this.func_1270_b("World5");
      }

      if(p_keyPressed_1_.getKeyCode() == 32) {
         this.field_1785_i = this.field_1784_j = 0;
      }

      if(p_keyPressed_1_.getKeyCode() == 27) {
         this.field_1791_c = !this.field_1791_c;
      }

      this.repaint();
   }

   public void keyReleased(KeyEvent p_keyReleased_1_) {}

   public void keyTyped(KeyEvent p_keyTyped_1_) {}

   // $FF: synthetic method
   static boolean func_1271_a(CanvasIsomPreview p_1271_0_) {
      return p_1271_0_.field_1788_f;
   }
}
