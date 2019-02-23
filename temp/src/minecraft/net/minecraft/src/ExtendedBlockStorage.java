package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.NibbleArray;

public class ExtendedBlockStorage {

   private int field_48722_a;
   private int field_48720_b;
   private int field_48721_c;
   private byte[] field_48718_d;
   private NibbleArray field_48719_e;
   private NibbleArray field_48716_f;
   private NibbleArray field_48717_g;
   private NibbleArray field_48723_h;


   public ExtendedBlockStorage(int p_i1094_1_) {
      this.field_48722_a = p_i1094_1_;
      this.field_48718_d = new byte[4096];
      this.field_48716_f = new NibbleArray(this.field_48718_d.length, 4);
      this.field_48723_h = new NibbleArray(this.field_48718_d.length, 4);
      this.field_48717_g = new NibbleArray(this.field_48718_d.length, 4);
   }

   public int func_48703_a(int p_48703_1_, int p_48703_2_, int p_48703_3_) {
      int var4 = this.field_48718_d[p_48703_2_ << 8 | p_48703_3_ << 4 | p_48703_1_] & 255;
      return this.field_48719_e != null?this.field_48719_e.func_771_a(p_48703_1_, p_48703_2_, p_48703_3_) << 8 | var4:var4;
   }

   public void func_48691_a(int p_48691_1_, int p_48691_2_, int p_48691_3_, int p_48691_4_) {
      int var5 = this.field_48718_d[p_48691_2_ << 8 | p_48691_3_ << 4 | p_48691_1_] & 255;
      if(this.field_48719_e != null) {
         var5 |= this.field_48719_e.func_771_a(p_48691_1_, p_48691_2_, p_48691_3_) << 8;
      }

      if(var5 == 0 && p_48691_4_ != 0) {
         ++this.field_48720_b;
         if(Block.field_345_n[p_48691_4_] != null && Block.field_345_n[p_48691_4_].func_48203_o()) {
            ++this.field_48721_c;
         }
      } else if(var5 != 0 && p_48691_4_ == 0) {
         --this.field_48720_b;
         if(Block.field_345_n[var5] != null && Block.field_345_n[var5].func_48203_o()) {
            --this.field_48721_c;
         }
      } else if(Block.field_345_n[var5] != null && Block.field_345_n[var5].func_48203_o() && (Block.field_345_n[p_48691_4_] == null || !Block.field_345_n[p_48691_4_].func_48203_o())) {
         --this.field_48721_c;
      } else if((Block.field_345_n[var5] == null || !Block.field_345_n[var5].func_48203_o()) && Block.field_345_n[p_48691_4_] != null && Block.field_345_n[p_48691_4_].func_48203_o()) {
         ++this.field_48721_c;
      }

      this.field_48718_d[p_48691_2_ << 8 | p_48691_3_ << 4 | p_48691_1_] = (byte)(p_48691_4_ & 255);
      if(p_48691_4_ > 255) {
         if(this.field_48719_e == null) {
            this.field_48719_e = new NibbleArray(this.field_48718_d.length, 4);
         }

         this.field_48719_e.func_770_a(p_48691_1_, p_48691_2_, p_48691_3_, (p_48691_4_ & 3840) >> 8);
      } else if(this.field_48719_e != null) {
         this.field_48719_e.func_770_a(p_48691_1_, p_48691_2_, p_48691_3_, 0);
      }

   }

   public int func_48694_b(int p_48694_1_, int p_48694_2_, int p_48694_3_) {
      return this.field_48716_f.func_771_a(p_48694_1_, p_48694_2_, p_48694_3_);
   }

   public void func_48690_b(int p_48690_1_, int p_48690_2_, int p_48690_3_, int p_48690_4_) {
      this.field_48716_f.func_770_a(p_48690_1_, p_48690_2_, p_48690_3_, p_48690_4_);
   }

   public boolean func_48693_a() {
      return this.field_48720_b == 0;
   }

   public boolean func_48698_b() {
      return this.field_48721_c > 0;
   }

   public int func_48707_c() {
      return this.field_48722_a;
   }

   public void func_48702_c(int p_48702_1_, int p_48702_2_, int p_48702_3_, int p_48702_4_) {
      this.field_48723_h.func_770_a(p_48702_1_, p_48702_2_, p_48702_3_, p_48702_4_);
   }

   public int func_48709_c(int p_48709_1_, int p_48709_2_, int p_48709_3_) {
      return this.field_48723_h.func_771_a(p_48709_1_, p_48709_2_, p_48709_3_);
   }

   public void func_48699_d(int p_48699_1_, int p_48699_2_, int p_48699_3_, int p_48699_4_) {
      this.field_48717_g.func_770_a(p_48699_1_, p_48699_2_, p_48699_3_, p_48699_4_);
   }

   public int func_48712_d(int p_48712_1_, int p_48712_2_, int p_48712_3_) {
      return this.field_48717_g.func_771_a(p_48712_1_, p_48712_2_, p_48712_3_);
   }

   public void func_48708_d() {
      this.field_48720_b = 0;
      this.field_48721_c = 0;

      for(int var1 = 0; var1 < 16; ++var1) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               int var4 = this.func_48703_a(var1, var2, var3);
               if(var4 > 0) {
                  if(Block.field_345_n[var4] == null) {
                     this.field_48718_d[var2 << 8 | var3 << 4 | var1] = 0;
                     if(this.field_48719_e != null) {
                        this.field_48719_e.func_770_a(var1, var2, var3, 0);
                     }
                  } else {
                     ++this.field_48720_b;
                     if(Block.field_345_n[var4].func_48203_o()) {
                        ++this.field_48721_c;
                     }
                  }
               }
            }
         }
      }

   }

   public void func_48711_e() {}

   public int func_48700_f() {
      return this.field_48720_b;
   }

   public byte[] func_48692_g() {
      return this.field_48718_d;
   }

   public void func_48715_h() {
      this.field_48719_e = null;
   }

   public NibbleArray func_48704_i() {
      return this.field_48719_e;
   }

   public NibbleArray func_48697_j() {
      return this.field_48716_f;
   }

   public NibbleArray func_48705_k() {
      return this.field_48717_g;
   }

   public NibbleArray func_48714_l() {
      return this.field_48723_h;
   }

   public void func_48706_a(byte[] p_48706_1_) {
      this.field_48718_d = p_48706_1_;
   }

   public void func_48710_a(NibbleArray p_48710_1_) {
      this.field_48719_e = p_48710_1_;
   }

   public void func_48701_b(NibbleArray p_48701_1_) {
      this.field_48716_f = p_48701_1_;
   }

   public void func_48695_c(NibbleArray p_48695_1_) {
      this.field_48717_g = p_48695_1_;
   }

   public void func_48713_d(NibbleArray p_48713_1_) {
      this.field_48723_h = p_48713_1_;
   }

   public NibbleArray func_48696_m() {
      this.field_48719_e = new NibbleArray(this.field_48718_d.length, 4);
      return this.field_48719_e;
   }
}
