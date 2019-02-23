package net.minecraft.src;

import java.io.IOException;
import java.util.List;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.World;

public class ChunkProviderLoadOrGenerate implements IChunkProvider {

   private Chunk field_897_c;
   private IChunkProvider field_896_d;
   private IChunkLoader field_895_e;
   private Chunk[] field_894_f;
   private World field_893_g;
   int field_891_a;
   int field_890_b;
   private Chunk field_892_h;
   private int field_21113_i;
   private int field_21112_j;


   public void func_21110_c(int p_21110_1_, int p_21110_2_) {
      this.field_21113_i = p_21110_1_;
      this.field_21112_j = p_21110_2_;
   }

   public boolean func_21111_d(int p_21111_1_, int p_21111_2_) {
      byte var3 = 15;
      return p_21111_1_ >= this.field_21113_i - var3 && p_21111_2_ >= this.field_21112_j - var3 && p_21111_1_ <= this.field_21113_i + var3 && p_21111_2_ <= this.field_21112_j + var3;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      if(!this.func_21111_d(p_537_1_, p_537_2_)) {
         return false;
      } else if(p_537_1_ == this.field_891_a && p_537_2_ == this.field_890_b && this.field_892_h != null) {
         return true;
      } else {
         int var3 = p_537_1_ & 31;
         int var4 = p_537_2_ & 31;
         int var5 = var3 + var4 * 32;
         return this.field_894_f[var5] != null && (this.field_894_f[var5] == this.field_897_c || this.field_894_f[var5].func_1017_a(p_537_1_, p_537_2_));
      }
   }

   public Chunk func_538_d(int p_538_1_, int p_538_2_) {
      return this.func_533_b(p_538_1_, p_538_2_);
   }

   public Chunk func_533_b(int p_533_1_, int p_533_2_) {
      if(p_533_1_ == this.field_891_a && p_533_2_ == this.field_890_b && this.field_892_h != null) {
         return this.field_892_h;
      } else if(!this.field_893_g.field_9430_x && !this.func_21111_d(p_533_1_, p_533_2_)) {
         return this.field_897_c;
      } else {
         int var3 = p_533_1_ & 31;
         int var4 = p_533_2_ & 31;
         int var5 = var3 + var4 * 32;
         if(!this.func_537_a(p_533_1_, p_533_2_)) {
            if(this.field_894_f[var5] != null) {
               this.field_894_f[var5].func_998_e();
               this.func_540_b(this.field_894_f[var5]);
               this.func_541_a(this.field_894_f[var5]);
            }

            Chunk var6 = this.func_542_c(p_533_1_, p_533_2_);
            if(var6 == null) {
               if(this.field_896_d == null) {
                  var6 = this.field_897_c;
               } else {
                  var6 = this.field_896_d.func_533_b(p_533_1_, p_533_2_);
                  var6.func_25124_i();
               }
            }

            this.field_894_f[var5] = var6;
            var6.func_4143_d();
            if(this.field_894_f[var5] != null) {
               this.field_894_f[var5].func_995_d();
            }

            this.field_894_f[var5].func_35843_a(this, this, p_533_1_, p_533_2_);
         }

         this.field_891_a = p_533_1_;
         this.field_890_b = p_533_2_;
         this.field_892_h = this.field_894_f[var5];
         return this.field_894_f[var5];
      }
   }

   private Chunk func_542_c(int p_542_1_, int p_542_2_) {
      if(this.field_895_e == null) {
         return this.field_897_c;
      } else {
         try {
            Chunk var3 = this.field_895_e.func_813_a(this.field_893_g, p_542_1_, p_542_2_);
            if(var3 != null) {
               var3.field_1522_s = this.field_893_g.func_22139_r();
            }

            return var3;
         } catch (Exception var4) {
            var4.printStackTrace();
            return this.field_897_c;
         }
      }
   }

   private void func_541_a(Chunk p_541_1_) {
      if(this.field_895_e != null) {
         try {
            this.field_895_e.func_815_b(this.field_893_g, p_541_1_);
         } catch (Exception var3) {
            var3.printStackTrace();
         }

      }
   }

   private void func_540_b(Chunk p_540_1_) {
      if(this.field_895_e != null) {
         try {
            p_540_1_.field_1522_s = this.field_893_g.func_22139_r();
            this.field_895_e.func_812_a(this.field_893_g, p_540_1_);
         } catch (IOException var3) {
            var3.printStackTrace();
         }

      }
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {
      Chunk var4 = this.func_533_b(p_534_2_, p_534_3_);
      if(!var4.field_1527_n) {
         var4.field_1527_n = true;
         if(this.field_896_d != null) {
            this.field_896_d.func_534_a(p_534_1_, p_534_2_, p_534_3_);
            var4.func_1006_f();
         }
      }

   }

   public boolean func_535_a(boolean p_535_1_, IProgressUpdate p_535_2_) {
      int var3 = 0;
      int var4 = 0;
      int var5;
      if(p_535_2_ != null) {
         for(var5 = 0; var5 < this.field_894_f.length; ++var5) {
            if(this.field_894_f[var5] != null && this.field_894_f[var5].func_1012_a(p_535_1_)) {
               ++var4;
            }
         }
      }

      var5 = 0;

      for(int var6 = 0; var6 < this.field_894_f.length; ++var6) {
         if(this.field_894_f[var6] != null) {
            if(p_535_1_) {
               this.func_541_a(this.field_894_f[var6]);
            }

            if(this.field_894_f[var6].func_1012_a(p_535_1_)) {
               this.func_540_b(this.field_894_f[var6]);
               this.field_894_f[var6].field_1526_o = false;
               ++var3;
               if(var3 == 2 && !p_535_1_) {
                  return false;
               }

               if(p_535_2_ != null) {
                  ++var5;
                  if(var5 % 10 == 0) {
                     p_535_2_.func_593_a(var5 * 100 / var4);
                  }
               }
            }
         }
      }

      if(p_535_1_) {
         if(this.field_895_e == null) {
            return true;
         }

         this.field_895_e.func_811_b();
      }

      return true;
   }

   public boolean func_532_a() {
      if(this.field_895_e != null) {
         this.field_895_e.func_814_a();
      }

      return this.field_896_d.func_532_a();
   }

   public boolean func_536_b() {
      return true;
   }

   public String func_21109_c() {
      return "ChunkCache: " + this.field_894_f.length;
   }

   public List func_40377_a(EnumCreatureType p_40377_1_, int p_40377_2_, int p_40377_3_, int p_40377_4_) {
      return this.field_896_d.func_40377_a(p_40377_1_, p_40377_2_, p_40377_3_, p_40377_4_);
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return this.field_896_d.func_40376_a(p_40376_1_, p_40376_2_, p_40376_3_, p_40376_4_, p_40376_5_);
   }
}
