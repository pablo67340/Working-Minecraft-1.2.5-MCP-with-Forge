package net.minecraft.src;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import net.minecraft.src.RegionFileChunkBuffer;

public class RegionFile {

   private static final byte[] field_22213_a = new byte[4096];
   private final File field_22212_b;
   private RandomAccessFile field_22219_c;
   private final int[] field_22218_d = new int[1024];
   private final int[] field_22217_e = new int[1024];
   private ArrayList field_22216_f;
   private int field_22215_g;
   private long field_22214_h = 0L;


   public RegionFile(File p_i442_1_) {
      this.field_22212_b = p_i442_1_;
      this.func_22204_b("REGION LOAD " + this.field_22212_b);
      this.field_22215_g = 0;

      try {
         if(p_i442_1_.exists()) {
            this.field_22214_h = p_i442_1_.lastModified();
         }

         this.field_22219_c = new RandomAccessFile(p_i442_1_, "rw");
         int var2;
         if(this.field_22219_c.length() < 4096L) {
            for(var2 = 0; var2 < 1024; ++var2) {
               this.field_22219_c.writeInt(0);
            }

            for(var2 = 0; var2 < 1024; ++var2) {
               this.field_22219_c.writeInt(0);
            }

            this.field_22215_g += 8192;
         }

         if((this.field_22219_c.length() & 4095L) != 0L) {
            for(var2 = 0; (long)var2 < (this.field_22219_c.length() & 4095L); ++var2) {
               this.field_22219_c.write(0);
            }
         }

         var2 = (int)this.field_22219_c.length() / 4096;
         this.field_22216_f = new ArrayList(var2);

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field_22216_f.add(Boolean.valueOf(true));
         }

         this.field_22216_f.set(0, Boolean.valueOf(false));
         this.field_22216_f.set(1, Boolean.valueOf(false));
         this.field_22219_c.seek(0L);

         int var4;
         for(var3 = 0; var3 < 1024; ++var3) {
            var4 = this.field_22219_c.readInt();
            this.field_22218_d[var3] = var4;
            if(var4 != 0 && (var4 >> 8) + (var4 & 255) <= this.field_22216_f.size()) {
               for(int var5 = 0; var5 < (var4 & 255); ++var5) {
                  this.field_22216_f.set((var4 >> 8) + var5, Boolean.valueOf(false));
               }
            }
         }

         for(var3 = 0; var3 < 1024; ++var3) {
            var4 = this.field_22219_c.readInt();
            this.field_22217_e[var3] = var4;
         }
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   private void func_22211_a(String p_22211_1_) {}

   private void func_22204_b(String p_22204_1_) {
      this.func_22211_a(p_22204_1_ + "\n");
   }

   private void func_22199_a(String p_22199_1_, int p_22199_2_, int p_22199_3_, String p_22199_4_) {
      this.func_22211_a("REGION " + p_22199_1_ + " " + this.field_22212_b.getName() + "[" + p_22199_2_ + "," + p_22199_3_ + "] = " + p_22199_4_);
   }

   private void func_22197_a(String p_22197_1_, int p_22197_2_, int p_22197_3_, int p_22197_4_, String p_22197_5_) {
      this.func_22211_a("REGION " + p_22197_1_ + " " + this.field_22212_b.getName() + "[" + p_22197_2_ + "," + p_22197_3_ + "] " + p_22197_4_ + "B = " + p_22197_5_);
   }

   private void func_22201_b(String p_22201_1_, int p_22201_2_, int p_22201_3_, String p_22201_4_) {
      this.func_22199_a(p_22201_1_, p_22201_2_, p_22201_3_, p_22201_4_ + "\n");
   }

   public synchronized DataInputStream func_22210_a(int p_22210_1_, int p_22210_2_) {
      if(this.func_22206_d(p_22210_1_, p_22210_2_)) {
         this.func_22201_b("READ", p_22210_1_, p_22210_2_, "out of bounds");
         return null;
      } else {
         try {
            int var3 = this.func_22207_e(p_22210_1_, p_22210_2_);
            if(var3 == 0) {
               return null;
            } else {
               int var4 = var3 >> 8;
               int var5 = var3 & 255;
               if(var4 + var5 > this.field_22216_f.size()) {
                  this.func_22201_b("READ", p_22210_1_, p_22210_2_, "invalid sector");
                  return null;
               } else {
                  this.field_22219_c.seek((long)(var4 * 4096));
                  int var6 = this.field_22219_c.readInt();
                  if(var6 > 4096 * var5) {
                     this.func_22201_b("READ", p_22210_1_, p_22210_2_, "invalid length: " + var6 + " > 4096 * " + var5);
                     return null;
                  } else if(var6 <= 0) {
                     this.func_22201_b("READ", p_22210_1_, p_22210_2_, "invalid length: " + var6 + " < 1");
                     return null;
                  } else {
                     byte var7 = this.field_22219_c.readByte();
                     byte[] var8;
                     DataInputStream var9;
                     if(var7 == 1) {
                        var8 = new byte[var6 - 1];
                        this.field_22219_c.read(var8);
                        var9 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(var8))));
                        return var9;
                     } else if(var7 == 2) {
                        var8 = new byte[var6 - 1];
                        this.field_22219_c.read(var8);
                        var9 = new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(var8))));
                        return var9;
                     } else {
                        this.func_22201_b("READ", p_22210_1_, p_22210_2_, "unknown version " + var7);
                        return null;
                     }
                  }
               }
            }
         } catch (IOException var10) {
            this.func_22201_b("READ", p_22210_1_, p_22210_2_, "exception");
            return null;
         }
      }
   }

   public DataOutputStream func_22205_b(int p_22205_1_, int p_22205_2_) {
      return this.func_22206_d(p_22205_1_, p_22205_2_)?null:new DataOutputStream(new DeflaterOutputStream(new RegionFileChunkBuffer(this, p_22205_1_, p_22205_2_)));
   }

   protected synchronized void func_22203_a(int p_22203_1_, int p_22203_2_, byte[] p_22203_3_, int p_22203_4_) {
      try {
         int var5 = this.func_22207_e(p_22203_1_, p_22203_2_);
         int var6 = var5 >> 8;
         int var7 = var5 & 255;
         int var8 = (p_22203_4_ + 5) / 4096 + 1;
         if(var8 >= 256) {
            return;
         }

         if(var6 != 0 && var7 == var8) {
            this.func_22197_a("SAVE", p_22203_1_, p_22203_2_, p_22203_4_, "rewrite");
            this.func_22200_a(var6, p_22203_3_, p_22203_4_);
         } else {
            int var9;
            for(var9 = 0; var9 < var7; ++var9) {
               this.field_22216_f.set(var6 + var9, Boolean.valueOf(true));
            }

            var9 = this.field_22216_f.indexOf(Boolean.valueOf(true));
            int var10 = 0;
            int var11;
            if(var9 != -1) {
               for(var11 = var9; var11 < this.field_22216_f.size(); ++var11) {
                  if(var10 != 0) {
                     if(((Boolean)this.field_22216_f.get(var11)).booleanValue()) {
                        ++var10;
                     } else {
                        var10 = 0;
                     }
                  } else if(((Boolean)this.field_22216_f.get(var11)).booleanValue()) {
                     var9 = var11;
                     var10 = 1;
                  }

                  if(var10 >= var8) {
                     break;
                  }
               }
            }

            if(var10 >= var8) {
               this.func_22197_a("SAVE", p_22203_1_, p_22203_2_, p_22203_4_, "reuse");
               var6 = var9;
               this.func_22198_a(p_22203_1_, p_22203_2_, var9 << 8 | var8);

               for(var11 = 0; var11 < var8; ++var11) {
                  this.field_22216_f.set(var6 + var11, Boolean.valueOf(false));
               }

               this.func_22200_a(var6, p_22203_3_, p_22203_4_);
            } else {
               this.func_22197_a("SAVE", p_22203_1_, p_22203_2_, p_22203_4_, "grow");
               this.field_22219_c.seek(this.field_22219_c.length());
               var6 = this.field_22216_f.size();

               for(var11 = 0; var11 < var8; ++var11) {
                  this.field_22219_c.write(field_22213_a);
                  this.field_22216_f.add(Boolean.valueOf(false));
               }

               this.field_22215_g += 4096 * var8;
               this.func_22200_a(var6, p_22203_3_, p_22203_4_);
               this.func_22198_a(p_22203_1_, p_22203_2_, var6 << 8 | var8);
            }
         }

         this.func_22208_b(p_22203_1_, p_22203_2_, (int)(System.currentTimeMillis() / 1000L));
      } catch (IOException var12) {
         var12.printStackTrace();
      }

   }

   private void func_22200_a(int p_22200_1_, byte[] p_22200_2_, int p_22200_3_) throws IOException {
      this.func_22204_b(" " + p_22200_1_);
      this.field_22219_c.seek((long)(p_22200_1_ * 4096));
      this.field_22219_c.writeInt(p_22200_3_ + 1);
      this.field_22219_c.writeByte(2);
      this.field_22219_c.write(p_22200_2_, 0, p_22200_3_);
   }

   private boolean func_22206_d(int p_22206_1_, int p_22206_2_) {
      return p_22206_1_ < 0 || p_22206_1_ >= 32 || p_22206_2_ < 0 || p_22206_2_ >= 32;
   }

   private int func_22207_e(int p_22207_1_, int p_22207_2_) {
      return this.field_22218_d[p_22207_1_ + p_22207_2_ * 32];
   }

   public boolean func_22202_c(int p_22202_1_, int p_22202_2_) {
      return this.func_22207_e(p_22202_1_, p_22202_2_) != 0;
   }

   private void func_22198_a(int p_22198_1_, int p_22198_2_, int p_22198_3_) throws IOException {
      this.field_22218_d[p_22198_1_ + p_22198_2_ * 32] = p_22198_3_;
      this.field_22219_c.seek((long)((p_22198_1_ + p_22198_2_ * 32) * 4));
      this.field_22219_c.writeInt(p_22198_3_);
   }

   private void func_22208_b(int p_22208_1_, int p_22208_2_, int p_22208_3_) throws IOException {
      this.field_22217_e[p_22208_1_ + p_22208_2_ * 32] = p_22208_3_;
      this.field_22219_c.seek((long)(4096 + (p_22208_1_ + p_22208_2_ * 32) * 4));
      this.field_22219_c.writeInt(p_22208_3_);
   }

   public void func_22196_b() throws IOException {
      this.field_22219_c.close();
   }

}
