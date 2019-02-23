package net.minecraft.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EmptyChunk;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.LongHashMap;
import net.minecraft.src.World;

public class ChunkProvider implements IChunkProvider {

   private Set field_28065_a = new HashSet();
   private Chunk field_28064_b;
   private IChunkProvider field_28070_c;
   private IChunkLoader field_28069_d;
   private LongHashMap field_28068_e = new LongHashMap();
   private List field_28067_f = new ArrayList();
   private World field_28066_g;
   private int field_35392_h;


   public ChunkProvider(World p_i415_1_, IChunkLoader p_i415_2_, IChunkProvider p_i415_3_) {
      this.field_28064_b = new EmptyChunk(p_i415_1_, 0, 0);
      this.field_28066_g = p_i415_1_;
      this.field_28069_d = p_i415_2_;
      this.field_28070_c = p_i415_3_;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      return this.field_28068_e.func_35575_b(ChunkCoordIntPair.func_22011_a(p_537_1_, p_537_2_));
   }

   public void func_35391_d(int p_35391_1_, int p_35391_2_) {
      ChunkCoordinates var3 = this.field_28066_g.func_22137_s();
      int var4 = p_35391_1_ * 16 + 8 - var3.field_22395_a;
      int var5 = p_35391_2_ * 16 + 8 - var3.field_22396_c;
      short var6 = 128;
      if(var4 < -var6 || var4 > var6 || var5 < -var6 || var5 > var6) {
         this.field_28065_a.add(Long.valueOf(ChunkCoordIntPair.func_22011_a(p_35391_1_, p_35391_2_)));
      }

   }

   public Chunk func_538_d(int p_538_1_, int p_538_2_) {
      long var3 = ChunkCoordIntPair.func_22011_a(p_538_1_, p_538_2_);
      this.field_28065_a.remove(Long.valueOf(var3));
      Chunk var5 = (Chunk)this.field_28068_e.func_35578_a(var3);
      if(var5 == null) {
         int var6 = 1875004;
         if(p_538_1_ < -var6 || p_538_2_ < -var6 || p_538_1_ >= var6 || p_538_2_ >= var6) {
            return this.field_28064_b;
         }

         var5 = this.func_28061_d(p_538_1_, p_538_2_);
         if(var5 == null) {
            if(this.field_28070_c == null) {
               var5 = this.field_28064_b;
            } else {
               var5 = this.field_28070_c.func_533_b(p_538_1_, p_538_2_);
            }
         }

         this.field_28068_e.func_35577_a(var3, var5);
         this.field_28067_f.add(var5);
         if(var5 != null) {
            var5.func_4143_d();
            var5.func_995_d();
         }

         var5.func_35843_a(this, this, p_538_1_, p_538_2_);
      }

      return var5;
   }

   public Chunk func_533_b(int p_533_1_, int p_533_2_) {
      Chunk var3 = (Chunk)this.field_28068_e.func_35578_a(ChunkCoordIntPair.func_22011_a(p_533_1_, p_533_2_));
      return var3 == null?this.func_538_d(p_533_1_, p_533_2_):var3;
   }

   private Chunk func_28061_d(int p_28061_1_, int p_28061_2_) {
      if(this.field_28069_d == null) {
         return null;
      } else {
         try {
            Chunk var3 = this.field_28069_d.func_813_a(this.field_28066_g, p_28061_1_, p_28061_2_);
            if(var3 != null) {
               var3.field_1522_s = this.field_28066_g.func_22139_r();
            }

            return var3;
         } catch (Exception var4) {
            var4.printStackTrace();
            return null;
         }
      }
   }

   private void func_28063_a(Chunk p_28063_1_) {
      if(this.field_28069_d != null) {
         try {
            this.field_28069_d.func_815_b(this.field_28066_g, p_28063_1_);
         } catch (Exception var3) {
            var3.printStackTrace();
         }

      }
   }

   private void func_28062_b(Chunk p_28062_1_) {
      if(this.field_28069_d != null) {
         try {
            p_28062_1_.field_1522_s = this.field_28066_g.func_22139_r();
            this.field_28069_d.func_812_a(this.field_28066_g, p_28062_1_);
         } catch (IOException var3) {
            var3.printStackTrace();
         }

      }
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {
      Chunk var4 = this.func_533_b(p_534_2_, p_534_3_);
      if(!var4.field_1527_n) {
         var4.field_1527_n = true;
         if(this.field_28070_c != null) {
            this.field_28070_c.func_534_a(p_534_1_, p_534_2_, p_534_3_);
            var4.func_1006_f();
         }
      }

   }

   public boolean func_535_a(boolean p_535_1_, IProgressUpdate p_535_2_) {
      int var3 = 0;

      for(int var4 = 0; var4 < this.field_28067_f.size(); ++var4) {
         Chunk var5 = (Chunk)this.field_28067_f.get(var4);
         if(p_535_1_) {
            this.func_28063_a(var5);
         }

         if(var5.func_1012_a(p_535_1_)) {
            this.func_28062_b(var5);
            var5.field_1526_o = false;
            ++var3;
            if(var3 == 24 && !p_535_1_) {
               return false;
            }
         }
      }

      if(p_535_1_) {
         if(this.field_28069_d == null) {
            return true;
         }

         this.field_28069_d.func_811_b();
      }

      return true;
   }

   public boolean func_532_a() {
      int var1;
      for(var1 = 0; var1 < 100; ++var1) {
         if(!this.field_28065_a.isEmpty()) {
            Long var2 = (Long)this.field_28065_a.iterator().next();
            Chunk var3 = (Chunk)this.field_28068_e.func_35578_a(var2.longValue());
            var3.func_998_e();
            this.func_28062_b(var3);
            this.func_28063_a(var3);
            this.field_28065_a.remove(var2);
            this.field_28068_e.func_35574_d(var2.longValue());
            this.field_28067_f.remove(var3);
         }
      }

      for(var1 = 0; var1 < 10; ++var1) {
         if(this.field_35392_h >= this.field_28067_f.size()) {
            this.field_35392_h = 0;
            break;
         }

         Chunk var4 = (Chunk)this.field_28067_f.get(this.field_35392_h++);
         EntityPlayer var5 = this.field_28066_g.func_48456_a((double)(var4.field_1531_j << 4) + 8.0D, (double)(var4.field_1530_k << 4) + 8.0D, 288.0D);
         if(var5 == null) {
            this.func_35391_d(var4.field_1531_j, var4.field_1530_k);
         }
      }

      if(this.field_28069_d != null) {
         this.field_28069_d.func_814_a();
      }

      return this.field_28070_c.func_532_a();
   }

   public boolean func_536_b() {
      return true;
   }

   public String func_21109_c() {
      return "ServerChunkCache: " + this.field_28068_e.func_35576_a() + " Drop: " + this.field_28065_a.size();
   }

   public List func_40377_a(EnumCreatureType p_40377_1_, int p_40377_2_, int p_40377_3_, int p_40377_4_) {
      return this.field_28070_c.func_40377_a(p_40377_1_, p_40377_2_, p_40377_3_, p_40377_4_);
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return this.field_28070_c.func_40376_a(p_40376_1_, p_40376_2_, p_40376_3_, p_40376_4_, p_40376_5_);
   }
}
