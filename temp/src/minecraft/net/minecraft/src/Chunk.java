package net.minecraft.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Entity;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.ExtendedBlockStorage;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NibbleArray;
import net.minecraft.src.Profiler;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;

public class Chunk {

   public static boolean field_1540_a;
   private ExtendedBlockStorage[] field_48505_p;
   private byte[] field_48504_q;
   public int[] field_35845_c;
   public boolean[] field_35844_d;
   public boolean field_1538_c;
   public World field_1537_d;
   public int[] field_48501_f;
   public final int field_1531_j;
   public final int field_1530_k;
   private boolean field_40741_v;
   public Map field_1529_l;
   public List[] field_48502_j;
   public boolean field_1527_n;
   public boolean field_1526_o;
   public boolean field_1523_r;
   public long field_1522_s;
   public boolean field_50120_o;
   private int field_48503_s;
   boolean field_35846_u;


   public Chunk(World p_i13_1_, int p_i13_2_, int p_i13_3_) {
      this.field_48505_p = new ExtendedBlockStorage[16];
      this.field_48504_q = new byte[256];
      this.field_35845_c = new int[256];
      this.field_35844_d = new boolean[256];
      this.field_40741_v = false;
      this.field_1529_l = new HashMap();
      this.field_1527_n = false;
      this.field_1526_o = false;
      this.field_1523_r = false;
      this.field_1522_s = 0L;
      this.field_50120_o = false;
      this.field_48503_s = 4096;
      this.field_35846_u = false;
      this.field_48502_j = new List[16];
      this.field_1537_d = p_i13_1_;
      this.field_1531_j = p_i13_2_;
      this.field_1530_k = p_i13_3_;
      this.field_48501_f = new int[256];

      for(int var4 = 0; var4 < this.field_48502_j.length; ++var4) {
         this.field_48502_j[var4] = new ArrayList();
      }

      Arrays.fill(this.field_35845_c, -999);
      Arrays.fill(this.field_48504_q, (byte)-1);
   }

   public Chunk(World p_i14_1_, byte[] p_i14_2_, int p_i14_3_, int p_i14_4_) {
      this(p_i14_1_, p_i14_3_, p_i14_4_);
      int var5 = p_i14_2_.length / 256;

      for(int var6 = 0; var6 < 16; ++var6) {
         for(int var7 = 0; var7 < 16; ++var7) {
            for(int var8 = 0; var8 < var5; ++var8) {
               byte var9 = p_i14_2_[var6 << 11 | var7 << 7 | var8];
               if(var9 != 0) {
                  int var10 = var8 >> 4;
                  if(this.field_48505_p[var10] == null) {
                     this.field_48505_p[var10] = new ExtendedBlockStorage(var10 << 4);
                  }

                  this.field_48505_p[var10].func_48691_a(var6, var8 & 15, var7, var9);
               }
            }
         }
      }

   }

   public boolean func_1017_a(int p_1017_1_, int p_1017_2_) {
      return p_1017_1_ == this.field_1531_j && p_1017_2_ == this.field_1530_k;
   }

   public int func_999_b(int p_999_1_, int p_999_2_) {
      return this.field_48501_f[p_999_2_ << 4 | p_999_1_];
   }

   public int func_48498_h() {
      for(int var1 = this.field_48505_p.length - 1; var1 >= 0; --var1) {
         if(this.field_48505_p[var1] != null) {
            return this.field_48505_p[var1].func_48707_c();
         }
      }

      return 0;
   }

   public ExtendedBlockStorage[] func_48495_i() {
      return this.field_48505_p;
   }

   public void func_1018_b() {
      int var1 = this.func_48498_h();

      for(int var2 = 0; var2 < 16; ++var2) {
         int var3 = 0;

         while(var3 < 16) {
            this.field_35845_c[var2 + (var3 << 4)] = -999;
            int var4 = var1 + 16 - 1;

            while(true) {
               if(var4 > 0) {
                  int var5 = this.func_1008_a(var2, var4 - 1, var3);
                  if(Block.field_341_r[var5] == 0) {
                     --var4;
                     continue;
                  }

                  this.field_48501_f[var3 << 4 | var2] = var4;
               }

               ++var3;
               break;
            }
         }
      }

      this.field_1526_o = true;
   }

   public void func_1024_c() {
      int var1 = this.func_48498_h();

      int var2;
      int var3;
      for(var2 = 0; var2 < 16; ++var2) {
         var3 = 0;

         while(var3 < 16) {
            this.field_35845_c[var2 + (var3 << 4)] = -999;
            int var4 = var1 + 16 - 1;

            while(true) {
               if(var4 > 0) {
                  if(this.func_48499_b(var2, var4 - 1, var3) == 0) {
                     --var4;
                     continue;
                  }

                  this.field_48501_f[var3 << 4 | var2] = var4;
               }

               if(!this.field_1537_d.field_4209_q.field_6478_e) {
                  var4 = 15;
                  int var5 = var1 + 16 - 1;

                  do {
                     var4 -= this.func_48499_b(var2, var5, var3);
                     if(var4 > 0) {
                        ExtendedBlockStorage var6 = this.field_48505_p[var5 >> 4];
                        if(var6 != null) {
                           var6.func_48702_c(var2, var5 & 15, var3, var4);
                           this.field_1537_d.func_48464_p((this.field_1531_j << 4) + var2, var5, (this.field_1530_k << 4) + var3);
                        }
                     }

                     --var5;
                  } while(var5 > 0 && var4 > 0);
               }

               ++var3;
               break;
            }
         }
      }

      this.field_1526_o = true;

      for(var2 = 0; var2 < 16; ++var2) {
         for(var3 = 0; var3 < 16; ++var3) {
            this.func_996_c(var2, var3);
         }
      }

   }

   public void func_4143_d() {}

   private void func_996_c(int p_996_1_, int p_996_2_) {
      this.field_35844_d[p_996_1_ + p_996_2_ * 16] = true;
      this.field_40741_v = true;
   }

   private void func_35839_k() {
      Profiler.func_40663_a("recheckGaps");
      if(this.field_1537_d.func_21117_a(this.field_1531_j * 16 + 8, 0, this.field_1530_k * 16 + 8, 16)) {
         for(int var1 = 0; var1 < 16; ++var1) {
            for(int var2 = 0; var2 < 16; ++var2) {
               if(this.field_35844_d[var1 + var2 * 16]) {
                  this.field_35844_d[var1 + var2 * 16] = false;
                  int var3 = this.func_999_b(var1, var2);
                  int var4 = this.field_1531_j * 16 + var1;
                  int var5 = this.field_1530_k * 16 + var2;
                  int var6 = this.field_1537_d.func_666_c(var4 - 1, var5);
                  int var7 = this.field_1537_d.func_666_c(var4 + 1, var5);
                  int var8 = this.field_1537_d.func_666_c(var4, var5 - 1);
                  int var9 = this.field_1537_d.func_666_c(var4, var5 + 1);
                  if(var7 < var6) {
                     var6 = var7;
                  }

                  if(var8 < var6) {
                     var6 = var8;
                  }

                  if(var9 < var6) {
                     var6 = var9;
                  }

                  this.func_1020_f(var4, var5, var6);
                  this.func_1020_f(var4 - 1, var5, var3);
                  this.func_1020_f(var4 + 1, var5, var3);
                  this.func_1020_f(var4, var5 - 1, var3);
                  this.func_1020_f(var4, var5 + 1, var3);
               }
            }
         }

         this.field_40741_v = false;
      }

      Profiler.func_40662_b();
   }

   private void func_1020_f(int p_1020_1_, int p_1020_2_, int p_1020_3_) {
      int var4 = this.field_1537_d.func_666_c(p_1020_1_, p_1020_2_);
      if(var4 > p_1020_3_) {
         this.func_35842_d(p_1020_1_, p_1020_2_, p_1020_3_, var4 + 1);
      } else if(var4 < p_1020_3_) {
         this.func_35842_d(p_1020_1_, p_1020_2_, var4, p_1020_3_ + 1);
      }

   }

   private void func_35842_d(int p_35842_1_, int p_35842_2_, int p_35842_3_, int p_35842_4_) {
      if(p_35842_4_ > p_35842_3_ && this.field_1537_d.func_21117_a(p_35842_1_, 0, p_35842_2_, 16)) {
         for(int var5 = p_35842_3_; var5 < p_35842_4_; ++var5) {
            this.field_1537_d.func_35459_c(EnumSkyBlock.Sky, p_35842_1_, var5, p_35842_2_);
         }

         this.field_1526_o = true;
      }

   }

   private void func_1003_g(int p_1003_1_, int p_1003_2_, int p_1003_3_) {
      int var4 = this.field_48501_f[p_1003_3_ << 4 | p_1003_1_] & 255;
      int var5 = var4;
      if(p_1003_2_ > var4) {
         var5 = p_1003_2_;
      }

      while(var5 > 0 && this.func_48499_b(p_1003_1_, var5 - 1, p_1003_3_) == 0) {
         --var5;
      }

      if(var5 != var4) {
         this.field_1537_d.func_680_f(p_1003_1_, p_1003_3_, var5, var4);
         this.field_48501_f[p_1003_3_ << 4 | p_1003_1_] = var5;
         int var6 = this.field_1531_j * 16 + p_1003_1_;
         int var7 = this.field_1530_k * 16 + p_1003_3_;
         int var8;
         int var12;
         if(!this.field_1537_d.field_4209_q.field_6478_e) {
            ExtendedBlockStorage var9;
            if(var5 < var4) {
               for(var8 = var5; var8 < var4; ++var8) {
                  var9 = this.field_48505_p[var8 >> 4];
                  if(var9 != null) {
                     var9.func_48702_c(p_1003_1_, var8 & 15, p_1003_3_, 15);
                     this.field_1537_d.func_48464_p((this.field_1531_j << 4) + p_1003_1_, var8, (this.field_1530_k << 4) + p_1003_3_);
                  }
               }
            } else {
               for(var8 = var4; var8 < var5; ++var8) {
                  var9 = this.field_48505_p[var8 >> 4];
                  if(var9 != null) {
                     var9.func_48702_c(p_1003_1_, var8 & 15, p_1003_3_, 0);
                     this.field_1537_d.func_48464_p((this.field_1531_j << 4) + p_1003_1_, var8, (this.field_1530_k << 4) + p_1003_3_);
                  }
               }
            }

            var8 = 15;

            while(var5 > 0 && var8 > 0) {
               --var5;
               var12 = this.func_48499_b(p_1003_1_, var5, p_1003_3_);
               if(var12 == 0) {
                  var12 = 1;
               }

               var8 -= var12;
               if(var8 < 0) {
                  var8 = 0;
               }

               ExtendedBlockStorage var10 = this.field_48505_p[var5 >> 4];
               if(var10 != null) {
                  var10.func_48702_c(p_1003_1_, var5 & 15, p_1003_3_, var8);
               }
            }
         }

         var8 = this.field_48501_f[p_1003_3_ << 4 | p_1003_1_];
         var12 = var4;
         int var13 = var8;
         if(var8 < var4) {
            var12 = var8;
            var13 = var4;
         }

         if(!this.field_1537_d.field_4209_q.field_6478_e) {
            this.func_35842_d(var6 - 1, var7, var12, var13);
            this.func_35842_d(var6 + 1, var7, var12, var13);
            this.func_35842_d(var6, var7 - 1, var12, var13);
            this.func_35842_d(var6, var7 + 1, var12, var13);
            this.func_35842_d(var6, var7, var12, var13);
         }

         this.field_1526_o = true;
      }
   }

   public int func_48499_b(int p_48499_1_, int p_48499_2_, int p_48499_3_) {
      return Block.field_341_r[this.func_1008_a(p_48499_1_, p_48499_2_, p_48499_3_)];
   }

   public int func_1008_a(int p_1008_1_, int p_1008_2_, int p_1008_3_) {
      if(p_1008_2_ >> 4 >= this.field_48505_p.length) {
         return 0;
      } else {
         ExtendedBlockStorage var4 = this.field_48505_p[p_1008_2_ >> 4];
         return var4 != null?var4.func_48703_a(p_1008_1_, p_1008_2_ & 15, p_1008_3_):0;
      }
   }

   public int func_1021_b(int p_1021_1_, int p_1021_2_, int p_1021_3_) {
      if(p_1021_2_ >> 4 >= this.field_48505_p.length) {
         return 0;
      } else {
         ExtendedBlockStorage var4 = this.field_48505_p[p_1021_2_ >> 4];
         return var4 != null?var4.func_48694_b(p_1021_1_, p_1021_2_ & 15, p_1021_3_):0;
      }
   }

   public boolean func_1022_a(int p_1022_1_, int p_1022_2_, int p_1022_3_, int p_1022_4_) {
      return this.func_1010_a(p_1022_1_, p_1022_2_, p_1022_3_, p_1022_4_, 0);
   }

   public boolean func_1010_a(int p_1010_1_, int p_1010_2_, int p_1010_3_, int p_1010_4_, int p_1010_5_) {
      int var6 = p_1010_3_ << 4 | p_1010_1_;
      if(p_1010_2_ >= this.field_35845_c[var6] - 1) {
         this.field_35845_c[var6] = -999;
      }

      int var7 = this.field_48501_f[var6];
      int var8 = this.func_1008_a(p_1010_1_, p_1010_2_, p_1010_3_);
      if(var8 == p_1010_4_ && this.func_1021_b(p_1010_1_, p_1010_2_, p_1010_3_) == p_1010_5_) {
         return false;
      } else {
         ExtendedBlockStorage var9 = this.field_48505_p[p_1010_2_ >> 4];
         boolean var10 = false;
         if(var9 == null) {
            if(p_1010_4_ == 0) {
               return false;
            }

            var9 = this.field_48505_p[p_1010_2_ >> 4] = new ExtendedBlockStorage(p_1010_2_ >> 4 << 4);
            var10 = p_1010_2_ >= var7;
         }

         var9.func_48691_a(p_1010_1_, p_1010_2_ & 15, p_1010_3_, p_1010_4_);
         int var11 = this.field_1531_j * 16 + p_1010_1_;
         int var12 = this.field_1530_k * 16 + p_1010_3_;
         if(var8 != 0) {
            if(!this.field_1537_d.field_1026_y) {
               Block.field_345_n[var8].func_214_b(this.field_1537_d, var11, p_1010_2_, var12);
            } else if(Block.field_345_n[var8] instanceof BlockContainer && var8 != p_1010_4_) {
               this.field_1537_d.func_692_l(var11, p_1010_2_, var12);
            }
         }

         if(var9.func_48703_a(p_1010_1_, p_1010_2_ & 15, p_1010_3_) != p_1010_4_) {
            return false;
         } else {
            var9.func_48690_b(p_1010_1_, p_1010_2_ & 15, p_1010_3_, p_1010_5_);
            if(var10) {
               this.func_1024_c();
            } else {
               if(Block.field_341_r[p_1010_4_ & 4095] > 0) {
                  if(p_1010_2_ >= var7) {
                     this.func_1003_g(p_1010_1_, p_1010_2_ + 1, p_1010_3_);
                  }
               } else if(p_1010_2_ == var7 - 1) {
                  this.func_1003_g(p_1010_1_, p_1010_2_, p_1010_3_);
               }

               this.func_996_c(p_1010_1_, p_1010_3_);
            }

            TileEntity var13;
            if(p_1010_4_ != 0) {
               if(!this.field_1537_d.field_1026_y) {
                  Block.field_345_n[p_1010_4_].func_235_e(this.field_1537_d, var11, p_1010_2_, var12);
               }

               if(Block.field_345_n[p_1010_4_] instanceof BlockContainer) {
                  var13 = this.func_1002_d(p_1010_1_, p_1010_2_, p_1010_3_);
                  if(var13 == null) {
                     var13 = ((BlockContainer)Block.field_345_n[p_1010_4_]).func_283_a_();
                     this.field_1537_d.func_654_a(var11, p_1010_2_, var12, var13);
                  }

                  if(var13 != null) {
                     var13.func_35144_b();
                  }
               }
            } else if(var8 > 0 && Block.field_345_n[var8] instanceof BlockContainer) {
               var13 = this.func_1002_d(p_1010_1_, p_1010_2_, p_1010_3_);
               if(var13 != null) {
                  var13.func_35144_b();
               }
            }

            this.field_1526_o = true;
            return true;
         }
      }
   }

   public boolean func_1009_b(int p_1009_1_, int p_1009_2_, int p_1009_3_, int p_1009_4_) {
      ExtendedBlockStorage var5 = this.field_48505_p[p_1009_2_ >> 4];
      if(var5 == null) {
         return false;
      } else {
         int var6 = var5.func_48694_b(p_1009_1_, p_1009_2_ & 15, p_1009_3_);
         if(var6 == p_1009_4_) {
            return false;
         } else {
            this.field_1526_o = true;
            var5.func_48690_b(p_1009_1_, p_1009_2_ & 15, p_1009_3_, p_1009_4_);
            int var7 = var5.func_48703_a(p_1009_1_, p_1009_2_ & 15, p_1009_3_);
            if(var7 > 0 && Block.field_345_n[var7] instanceof BlockContainer) {
               TileEntity var8 = this.func_1002_d(p_1009_1_, p_1009_2_, p_1009_3_);
               if(var8 != null) {
                  var8.func_35144_b();
                  var8.field_35145_n = p_1009_4_;
               }
            }

            return true;
         }
      }
   }

   public int func_1025_a(EnumSkyBlock p_1025_1_, int p_1025_2_, int p_1025_3_, int p_1025_4_) {
      ExtendedBlockStorage var5 = this.field_48505_p[p_1025_3_ >> 4];
      return var5 == null?p_1025_1_.field_1722_c:(p_1025_1_ == EnumSkyBlock.Sky?var5.func_48709_c(p_1025_2_, p_1025_3_ & 15, p_1025_4_):(p_1025_1_ == EnumSkyBlock.Block?var5.func_48712_d(p_1025_2_, p_1025_3_ & 15, p_1025_4_):p_1025_1_.field_1722_c));
   }

   public void func_1011_a(EnumSkyBlock p_1011_1_, int p_1011_2_, int p_1011_3_, int p_1011_4_, int p_1011_5_) {
      ExtendedBlockStorage var6 = this.field_48505_p[p_1011_3_ >> 4];
      if(var6 == null) {
         var6 = this.field_48505_p[p_1011_3_ >> 4] = new ExtendedBlockStorage(p_1011_3_ >> 4 << 4);
         this.func_1024_c();
      }

      this.field_1526_o = true;
      if(p_1011_1_ == EnumSkyBlock.Sky) {
         if(!this.field_1537_d.field_4209_q.field_6478_e) {
            var6.func_48702_c(p_1011_2_, p_1011_3_ & 15, p_1011_4_, p_1011_5_);
         }
      } else {
         if(p_1011_1_ != EnumSkyBlock.Block) {
            return;
         }

         var6.func_48699_d(p_1011_2_, p_1011_3_ & 15, p_1011_4_, p_1011_5_);
      }

   }

   public int func_1019_c(int p_1019_1_, int p_1019_2_, int p_1019_3_, int p_1019_4_) {
      ExtendedBlockStorage var5 = this.field_48505_p[p_1019_2_ >> 4];
      if(var5 == null) {
         return !this.field_1537_d.field_4209_q.field_6478_e && p_1019_4_ < EnumSkyBlock.Sky.field_1722_c?EnumSkyBlock.Sky.field_1722_c - p_1019_4_:0;
      } else {
         int var6 = this.field_1537_d.field_4209_q.field_6478_e?0:var5.func_48709_c(p_1019_1_, p_1019_2_ & 15, p_1019_3_);
         if(var6 > 0) {
            field_1540_a = true;
         }

         var6 -= p_1019_4_;
         int var7 = var5.func_48712_d(p_1019_1_, p_1019_2_ & 15, p_1019_3_);
         if(var7 > var6) {
            var6 = var7;
         }

         return var6;
      }
   }

   public void func_1000_a(Entity p_1000_1_) {
      this.field_1523_r = true;
      int var2 = MathHelper.func_1108_b(p_1000_1_.field_611_ak / 16.0D);
      int var3 = MathHelper.func_1108_b(p_1000_1_.field_609_am / 16.0D);
      if(var2 != this.field_1531_j || var3 != this.field_1530_k) {
         System.out.println("Wrong location! " + p_1000_1_);
         Thread.dumpStack();
      }

      int var4 = MathHelper.func_1108_b(p_1000_1_.field_610_al / 16.0D);
      if(var4 < 0) {
         var4 = 0;
      }

      if(var4 >= this.field_48502_j.length) {
         var4 = this.field_48502_j.length - 1;
      }

      p_1000_1_.field_621_aZ = true;
      p_1000_1_.field_657_ba = this.field_1531_j;
      p_1000_1_.field_656_bb = var4;
      p_1000_1_.field_654_bc = this.field_1530_k;
      this.field_48502_j[var4].add(p_1000_1_);
   }

   public void func_1015_b(Entity p_1015_1_) {
      this.func_1016_a(p_1015_1_, p_1015_1_.field_656_bb);
   }

   public void func_1016_a(Entity p_1016_1_, int p_1016_2_) {
      if(p_1016_2_ < 0) {
         p_1016_2_ = 0;
      }

      if(p_1016_2_ >= this.field_48502_j.length) {
         p_1016_2_ = this.field_48502_j.length - 1;
      }

      this.field_48502_j[p_1016_2_].remove(p_1016_1_);
   }

   public boolean func_1007_c(int p_1007_1_, int p_1007_2_, int p_1007_3_) {
      return p_1007_2_ >= this.field_48501_f[p_1007_3_ << 4 | p_1007_1_];
   }

   public TileEntity func_1002_d(int p_1002_1_, int p_1002_2_, int p_1002_3_) {
      ChunkPosition var4 = new ChunkPosition(p_1002_1_, p_1002_2_, p_1002_3_);
      TileEntity var5 = (TileEntity)this.field_1529_l.get(var4);
      if(var5 == null) {
         int var6 = this.func_1008_a(p_1002_1_, p_1002_2_, p_1002_3_);
         if(var6 <= 0 || !Block.field_345_n[var6].func_48205_p()) {
            return null;
         }

         if(var5 == null) {
            var5 = ((BlockContainer)Block.field_345_n[var6]).func_283_a_();
            this.field_1537_d.func_654_a(this.field_1531_j * 16 + p_1002_1_, p_1002_2_, this.field_1530_k * 16 + p_1002_3_, var5);
         }

         var5 = (TileEntity)this.field_1529_l.get(var4);
      }

      if(var5 != null && var5.func_31006_g()) {
         this.field_1529_l.remove(var4);
         return null;
      } else {
         return var5;
      }
   }

   public void func_1001_a(TileEntity p_1001_1_) {
      int var2 = p_1001_1_.field_823_f - this.field_1531_j * 16;
      int var3 = p_1001_1_.field_822_g;
      int var4 = p_1001_1_.field_821_h - this.field_1530_k * 16;
      this.func_1005_a(var2, var3, var4, p_1001_1_);
      if(this.field_1538_c) {
         this.field_1537_d.field_1049_b.add(p_1001_1_);
      }

   }

   public void func_1005_a(int p_1005_1_, int p_1005_2_, int p_1005_3_, TileEntity p_1005_4_) {
      ChunkPosition var5 = new ChunkPosition(p_1005_1_, p_1005_2_, p_1005_3_);
      p_1005_4_.field_824_e = this.field_1537_d;
      p_1005_4_.field_823_f = this.field_1531_j * 16 + p_1005_1_;
      p_1005_4_.field_822_g = p_1005_2_;
      p_1005_4_.field_821_h = this.field_1530_k * 16 + p_1005_3_;
      if(this.func_1008_a(p_1005_1_, p_1005_2_, p_1005_3_) != 0 && Block.field_345_n[this.func_1008_a(p_1005_1_, p_1005_2_, p_1005_3_)] instanceof BlockContainer) {
         p_1005_4_.func_31004_j();
         this.field_1529_l.put(var5, p_1005_4_);
      }
   }

   public void func_1023_e(int p_1023_1_, int p_1023_2_, int p_1023_3_) {
      ChunkPosition var4 = new ChunkPosition(p_1023_1_, p_1023_2_, p_1023_3_);
      if(this.field_1538_c) {
         TileEntity var5 = (TileEntity)this.field_1529_l.remove(var4);
         if(var5 != null) {
            var5.func_31005_i();
         }
      }

   }

   public void func_995_d() {
      this.field_1538_c = true;
      this.field_1537_d.func_31054_a(this.field_1529_l.values());

      for(int var1 = 0; var1 < this.field_48502_j.length; ++var1) {
         this.field_1537_d.func_636_a(this.field_48502_j[var1]);
      }

   }

   public void func_998_e() {
      this.field_1538_c = false;
      Iterator var1 = this.field_1529_l.values().iterator();

      while(var1.hasNext()) {
         TileEntity var2 = (TileEntity)var1.next();
         this.field_1537_d.func_35455_a(var2);
      }

      for(int var3 = 0; var3 < this.field_48502_j.length; ++var3) {
         this.field_1537_d.func_632_b(this.field_48502_j[var3]);
      }

   }

   public void func_1006_f() {
      this.field_1526_o = true;
   }

   public void func_994_a(Entity p_994_1_, AxisAlignedBB p_994_2_, List p_994_3_) {
      int var4 = MathHelper.func_1108_b((p_994_2_.field_1697_b - 2.0D) / 16.0D);
      int var5 = MathHelper.func_1108_b((p_994_2_.field_1702_e + 2.0D) / 16.0D);
      if(var4 < 0) {
         var4 = 0;
      }

      if(var5 >= this.field_48502_j.length) {
         var5 = this.field_48502_j.length - 1;
      }

      for(int var6 = var4; var6 <= var5; ++var6) {
         List var7 = this.field_48502_j[var6];

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            Entity var9 = (Entity)var7.get(var8);
            if(var9 != p_994_1_ && var9.field_601_au.func_1178_a(p_994_2_)) {
               p_994_3_.add(var9);
               Entity[] var10 = var9.func_40048_X();
               if(var10 != null) {
                  for(int var11 = 0; var11 < var10.length; ++var11) {
                     var9 = var10[var11];
                     if(var9 != p_994_1_ && var9.field_601_au.func_1178_a(p_994_2_)) {
                        p_994_3_.add(var9);
                     }
                  }
               }
            }
         }
      }

   }

   public void func_1013_a(Class p_1013_1_, AxisAlignedBB p_1013_2_, List p_1013_3_) {
      int var4 = MathHelper.func_1108_b((p_1013_2_.field_1697_b - 2.0D) / 16.0D);
      int var5 = MathHelper.func_1108_b((p_1013_2_.field_1702_e + 2.0D) / 16.0D);
      if(var4 < 0) {
         var4 = 0;
      } else if(var4 >= this.field_48502_j.length) {
         var4 = this.field_48502_j.length - 1;
      }

      if(var5 >= this.field_48502_j.length) {
         var5 = this.field_48502_j.length - 1;
      } else if(var5 < 0) {
         var5 = 0;
      }

      for(int var6 = var4; var6 <= var5; ++var6) {
         List var7 = this.field_48502_j[var6];

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            Entity var9 = (Entity)var7.get(var8);
            if(p_1013_1_.isAssignableFrom(var9.getClass()) && var9.field_601_au.func_1178_a(p_1013_2_)) {
               p_1013_3_.add(var9);
            }
         }
      }

   }

   public boolean func_1012_a(boolean p_1012_1_) {
      if(p_1012_1_) {
         if(this.field_1523_r && this.field_1537_d.func_22139_r() != this.field_1522_s) {
            return true;
         }
      } else if(this.field_1523_r && this.field_1537_d.func_22139_r() >= this.field_1522_s + 600L) {
         return true;
      }

      return this.field_1526_o;
   }

   public Random func_997_a(long p_997_1_) {
      return new Random(this.field_1537_d.func_22138_q() + (long)(this.field_1531_j * this.field_1531_j * 4987142) + (long)(this.field_1531_j * 5947611) + (long)(this.field_1530_k * this.field_1530_k) * 4392871L + (long)(this.field_1530_k * 389711) ^ p_997_1_);
   }

   public boolean func_21167_h() {
      return false;
   }

   public void func_25124_i() {
      ExtendedBlockStorage[] var1 = this.field_48505_p;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ExtendedBlockStorage var4 = var1[var3];
         if(var4 != null) {
            var4.func_48711_e();
         }
      }

   }

   public void func_35843_a(IChunkProvider p_35843_1_, IChunkProvider p_35843_2_, int p_35843_3_, int p_35843_4_) {
      if(!this.field_1527_n && p_35843_1_.func_537_a(p_35843_3_ + 1, p_35843_4_ + 1) && p_35843_1_.func_537_a(p_35843_3_, p_35843_4_ + 1) && p_35843_1_.func_537_a(p_35843_3_ + 1, p_35843_4_)) {
         p_35843_1_.func_534_a(p_35843_2_, p_35843_3_, p_35843_4_);
      }

      if(p_35843_1_.func_537_a(p_35843_3_ - 1, p_35843_4_) && !p_35843_1_.func_533_b(p_35843_3_ - 1, p_35843_4_).field_1527_n && p_35843_1_.func_537_a(p_35843_3_ - 1, p_35843_4_ + 1) && p_35843_1_.func_537_a(p_35843_3_, p_35843_4_ + 1) && p_35843_1_.func_537_a(p_35843_3_ - 1, p_35843_4_ + 1)) {
         p_35843_1_.func_534_a(p_35843_2_, p_35843_3_ - 1, p_35843_4_);
      }

      if(p_35843_1_.func_537_a(p_35843_3_, p_35843_4_ - 1) && !p_35843_1_.func_533_b(p_35843_3_, p_35843_4_ - 1).field_1527_n && p_35843_1_.func_537_a(p_35843_3_ + 1, p_35843_4_ - 1) && p_35843_1_.func_537_a(p_35843_3_ + 1, p_35843_4_ - 1) && p_35843_1_.func_537_a(p_35843_3_ + 1, p_35843_4_)) {
         p_35843_1_.func_534_a(p_35843_2_, p_35843_3_, p_35843_4_ - 1);
      }

      if(p_35843_1_.func_537_a(p_35843_3_ - 1, p_35843_4_ - 1) && !p_35843_1_.func_533_b(p_35843_3_ - 1, p_35843_4_ - 1).field_1527_n && p_35843_1_.func_537_a(p_35843_3_, p_35843_4_ - 1) && p_35843_1_.func_537_a(p_35843_3_ - 1, p_35843_4_)) {
         p_35843_1_.func_534_a(p_35843_2_, p_35843_3_ - 1, p_35843_4_ - 1);
      }

   }

   public int func_35840_c(int p_35840_1_, int p_35840_2_) {
      int var3 = p_35840_1_ | p_35840_2_ << 4;
      int var4 = this.field_35845_c[var3];
      if(var4 == -999) {
         int var5 = this.func_48498_h() + 15;
         var4 = -1;

         while(var5 > 0 && var4 == -1) {
            int var6 = this.func_1008_a(p_35840_1_, var5, p_35840_2_);
            Material var7 = var6 == 0?Material.field_1337_a:Block.field_345_n[var6].field_356_bn;
            if(!var7.func_880_c() && !var7.func_879_d()) {
               --var5;
            } else {
               var4 = var5 + 1;
            }
         }

         this.field_35845_c[var3] = var4;
      }

      return var4;
   }

   public void func_35841_j() {
      if(this.field_40741_v && !this.field_1537_d.field_4209_q.field_6478_e) {
         this.func_35839_k();
      }

   }

   public ChunkCoordIntPair func_40740_k() {
      return new ChunkCoordIntPair(this.field_1531_j, this.field_1530_k);
   }

   public boolean func_48492_c(int p_48492_1_, int p_48492_2_) {
      if(p_48492_1_ < 0) {
         p_48492_1_ = 0;
      }

      if(p_48492_2_ >= 256) {
         p_48492_2_ = 255;
      }

      for(int var3 = p_48492_1_; var3 <= p_48492_2_; var3 += 16) {
         ExtendedBlockStorage var4 = this.field_48505_p[var3 >> 4];
         if(var4 != null && !var4.func_48693_a()) {
            return false;
         }
      }

      return true;
   }

   public void func_48500_a(ExtendedBlockStorage[] p_48500_1_) {
      this.field_48505_p = p_48500_1_;
   }

   public void func_48494_a(byte[] p_48494_1_, int p_48494_2_, int p_48494_3_, boolean p_48494_4_) {
      int var5 = 0;

      int var6;
      for(var6 = 0; var6 < this.field_48505_p.length; ++var6) {
         if((p_48494_2_ & 1 << var6) != 0) {
            if(this.field_48505_p[var6] == null) {
               this.field_48505_p[var6] = new ExtendedBlockStorage(var6 << 4);
            }

            byte[] var7 = this.field_48505_p[var6].func_48692_g();
            System.arraycopy(p_48494_1_, var5, var7, 0, var7.length);
            var5 += var7.length;
         } else if(p_48494_4_ && this.field_48505_p[var6] != null) {
            this.field_48505_p[var6] = null;
         }
      }

      NibbleArray var8;
      for(var6 = 0; var6 < this.field_48505_p.length; ++var6) {
         if((p_48494_2_ & 1 << var6) != 0 && this.field_48505_p[var6] != null) {
            var8 = this.field_48505_p[var6].func_48697_j();
            System.arraycopy(p_48494_1_, var5, var8.field_1109_a, 0, var8.field_1109_a.length);
            var5 += var8.field_1109_a.length;
         }
      }

      for(var6 = 0; var6 < this.field_48505_p.length; ++var6) {
         if((p_48494_2_ & 1 << var6) != 0 && this.field_48505_p[var6] != null) {
            var8 = this.field_48505_p[var6].func_48705_k();
            System.arraycopy(p_48494_1_, var5, var8.field_1109_a, 0, var8.field_1109_a.length);
            var5 += var8.field_1109_a.length;
         }
      }

      for(var6 = 0; var6 < this.field_48505_p.length; ++var6) {
         if((p_48494_2_ & 1 << var6) != 0 && this.field_48505_p[var6] != null) {
            var8 = this.field_48505_p[var6].func_48714_l();
            System.arraycopy(p_48494_1_, var5, var8.field_1109_a, 0, var8.field_1109_a.length);
            var5 += var8.field_1109_a.length;
         }
      }

      for(var6 = 0; var6 < this.field_48505_p.length; ++var6) {
         if((p_48494_3_ & 1 << var6) != 0) {
            if(this.field_48505_p[var6] == null) {
               var5 += 2048;
            } else {
               var8 = this.field_48505_p[var6].func_48704_i();
               if(var8 == null) {
                  var8 = this.field_48505_p[var6].func_48696_m();
               }

               System.arraycopy(p_48494_1_, var5, var8.field_1109_a, 0, var8.field_1109_a.length);
               var5 += var8.field_1109_a.length;
            }
         } else if(p_48494_4_ && this.field_48505_p[var6] != null && this.field_48505_p[var6].func_48704_i() != null) {
            this.field_48505_p[var6].func_48715_h();
         }
      }

      if(p_48494_4_) {
         System.arraycopy(p_48494_1_, var5, this.field_48504_q, 0, this.field_48504_q.length);
         int var10000 = var5 + this.field_48504_q.length;
      }

      for(var6 = 0; var6 < this.field_48505_p.length; ++var6) {
         if(this.field_48505_p[var6] != null && (p_48494_2_ & 1 << var6) != 0) {
            this.field_48505_p[var6].func_48708_d();
         }
      }

      this.func_1018_b();
      Iterator var10 = this.field_1529_l.values().iterator();

      while(var10.hasNext()) {
         TileEntity var9 = (TileEntity)var10.next();
         var9.func_35144_b();
      }

   }

   public BiomeGenBase func_48490_a(int p_48490_1_, int p_48490_2_, WorldChunkManager p_48490_3_) {
      int var4 = this.field_48504_q[p_48490_2_ << 4 | p_48490_1_] & 255;
      if(var4 == 255) {
         BiomeGenBase var5 = p_48490_3_.func_4073_a((this.field_1531_j << 4) + p_48490_1_, (this.field_1530_k << 4) + p_48490_2_);
         var4 = var5.field_35494_y;
         this.field_48504_q[p_48490_2_ << 4 | p_48490_1_] = (byte)(var4 & 255);
      }

      return BiomeGenBase.field_35486_a[var4] == null?BiomeGenBase.field_35485_c:BiomeGenBase.field_35486_a[var4];
   }

   public byte[] func_48493_m() {
      return this.field_48504_q;
   }

   public void func_48497_a(byte[] p_48497_1_) {
      this.field_48504_q = p_48497_1_;
   }

   public void func_48496_n() {
      this.field_48503_s = 0;
   }

   public void func_48491_o() {
      for(int var1 = 0; var1 < 8; ++var1) {
         if(this.field_48503_s >= 4096) {
            return;
         }

         int var2 = this.field_48503_s % 16;
         int var3 = this.field_48503_s / 16 % 16;
         int var4 = this.field_48503_s / 256;
         ++this.field_48503_s;
         int var5 = (this.field_1531_j << 4) + var3;
         int var6 = (this.field_1530_k << 4) + var4;

         for(int var7 = 0; var7 < 16; ++var7) {
            int var8 = (var2 << 4) + var7;
            if(this.field_48505_p[var2] == null && (var7 == 0 || var7 == 15 || var3 == 0 || var3 == 15 || var4 == 0 || var4 == 15) || this.field_48505_p[var2] != null && this.field_48505_p[var2].func_48703_a(var3, var7, var4) == 0) {
               if(Block.field_339_t[this.field_1537_d.func_600_a(var5, var8 - 1, var6)] > 0) {
                  this.field_1537_d.func_35463_p(var5, var8 - 1, var6);
               }

               if(Block.field_339_t[this.field_1537_d.func_600_a(var5, var8 + 1, var6)] > 0) {
                  this.field_1537_d.func_35463_p(var5, var8 + 1, var6);
               }

               if(Block.field_339_t[this.field_1537_d.func_600_a(var5 - 1, var8, var6)] > 0) {
                  this.field_1537_d.func_35463_p(var5 - 1, var8, var6);
               }

               if(Block.field_339_t[this.field_1537_d.func_600_a(var5 + 1, var8, var6)] > 0) {
                  this.field_1537_d.func_35463_p(var5 + 1, var8, var6);
               }

               if(Block.field_339_t[this.field_1537_d.func_600_a(var5, var8, var6 - 1)] > 0) {
                  this.field_1537_d.func_35463_p(var5, var8, var6 - 1);
               }

               if(Block.field_339_t[this.field_1537_d.func_600_a(var5, var8, var6 + 1)] > 0) {
                  this.field_1537_d.func_35463_p(var5, var8, var6 + 1);
               }

               this.field_1537_d.func_35463_p(var5, var8, var6);
            }
         }
      }

   }
}
