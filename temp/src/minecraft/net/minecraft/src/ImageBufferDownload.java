package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import net.minecraft.src.ImageBuffer;

public class ImageBufferDownload implements ImageBuffer {

   private int[] field_1343_a;
   private int field_1342_b;
   private int field_1344_c;


   public BufferedImage func_883_a(BufferedImage p_883_1_) {
      if(p_883_1_ == null) {
         return null;
      } else {
         this.field_1342_b = 64;
         this.field_1344_c = 32;
         BufferedImage var2 = new BufferedImage(this.field_1342_b, this.field_1344_c, 2);
         Graphics var3 = var2.getGraphics();
         var3.drawImage(p_883_1_, 0, 0, (ImageObserver)null);
         var3.dispose();
         this.field_1343_a = ((DataBufferInt)var2.getRaster().getDataBuffer()).getData();
         this.func_884_b(0, 0, 32, 16);
         this.func_885_a(32, 0, 64, 32);
         this.func_884_b(0, 16, 64, 32);
         boolean var4 = false;

         int var5;
         int var6;
         int var7;
         for(var5 = 32; var5 < 64; ++var5) {
            for(var6 = 0; var6 < 16; ++var6) {
               var7 = this.field_1343_a[var5 + var6 * 64];
               if((var7 >> 24 & 255) < 128) {
                  var4 = true;
               }
            }
         }

         if(!var4) {
            for(var5 = 32; var5 < 64; ++var5) {
               for(var6 = 0; var6 < 16; ++var6) {
                  var7 = this.field_1343_a[var5 + var6 * 64];
                  if((var7 >> 24 & 255) < 128) {
                     var4 = true;
                  }
               }
            }
         }

         return var2;
      }
   }

   private void func_885_a(int p_885_1_, int p_885_2_, int p_885_3_, int p_885_4_) {
      if(!this.func_886_c(p_885_1_, p_885_2_, p_885_3_, p_885_4_)) {
         for(int var5 = p_885_1_; var5 < p_885_3_; ++var5) {
            for(int var6 = p_885_2_; var6 < p_885_4_; ++var6) {
               this.field_1343_a[var5 + var6 * this.field_1342_b] &= 16777215;
            }
         }

      }
   }

   private void func_884_b(int p_884_1_, int p_884_2_, int p_884_3_, int p_884_4_) {
      for(int var5 = p_884_1_; var5 < p_884_3_; ++var5) {
         for(int var6 = p_884_2_; var6 < p_884_4_; ++var6) {
            this.field_1343_a[var5 + var6 * this.field_1342_b] |= -16777216;
         }
      }

   }

   private boolean func_886_c(int p_886_1_, int p_886_2_, int p_886_3_, int p_886_4_) {
      for(int var5 = p_886_1_; var5 < p_886_3_; ++var5) {
         for(int var6 = p_886_2_; var6 < p_886_4_; ++var6) {
            int var7 = this.field_1343_a[var5 + var6 * this.field_1342_b];
            if((var7 >> 24 & 255) < 128) {
               return true;
            }
         }
      }

      return false;
   }
}
