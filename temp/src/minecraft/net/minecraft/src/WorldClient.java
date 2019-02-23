package net.minecraft.src;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkCoordIntPair;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.ChunkProviderClient;
import net.minecraft.src.Entity;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IntHashMap;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet255KickDisconnect;
import net.minecraft.src.Profiler;
import net.minecraft.src.SaveHandlerMP;
import net.minecraft.src.World;
import net.minecraft.src.WorldBlockPositionType;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldSettings;

public class WorldClient extends World {

   private LinkedList field_1057_z = new LinkedList();
   private NetClientHandler field_1052_A;
   private ChunkProviderClient field_20915_C;
   private IntHashMap field_1055_D = new IntHashMap();
   private Set field_20914_E = new HashSet();
   private Set field_1053_F = new HashSet();


   public WorldClient(NetClientHandler p_i387_1_, WorldSettings p_i387_2_, int p_i387_3_, int p_i387_4_) {
      super(new SaveHandlerMP(), "MpServer", WorldProvider.func_4101_a(p_i387_3_), p_i387_2_);
      this.field_1052_A = p_i387_1_;
      this.field_1039_l = p_i387_4_;
      this.func_22143_a(new ChunkCoordinates(8, 64, 8));
      this.field_28108_z = p_i387_1_.field_28118_b;
   }

   public void func_649_g() {
      this.func_648_a(this.func_22139_r() + 1L);

      int var1;
      for(var1 = 0; var1 < 10 && !this.field_1053_F.isEmpty(); ++var1) {
         Entity var2 = (Entity)this.field_1053_F.iterator().next();
         this.field_1053_F.remove(var2);
         if(!this.field_1050_a.contains(var2)) {
            this.func_674_a(var2);
         }
      }

      this.field_1052_A.func_848_a();

      for(var1 = 0; var1 < this.field_1057_z.size(); ++var1) {
         WorldBlockPositionType var3 = (WorldBlockPositionType)this.field_1057_z.get(var1);
         if(--var3.field_1206_d == 0) {
            super.func_643_a(var3.field_1202_a, var3.field_1201_b, var3.field_1207_c, var3.field_1205_e, var3.field_1204_f);
            super.func_665_h(var3.field_1202_a, var3.field_1201_b, var3.field_1207_c);
            this.field_1057_z.remove(var1--);
         }
      }

      this.field_20915_C.func_532_a();
      this.func_4080_j();
   }

   public void func_711_c(int p_711_1_, int p_711_2_, int p_711_3_, int p_711_4_, int p_711_5_, int p_711_6_) {
      for(int var7 = 0; var7 < this.field_1057_z.size(); ++var7) {
         WorldBlockPositionType var8 = (WorldBlockPositionType)this.field_1057_z.get(var7);
         if(var8.field_1202_a >= p_711_1_ && var8.field_1201_b >= p_711_2_ && var8.field_1207_c >= p_711_3_ && var8.field_1202_a <= p_711_4_ && var8.field_1201_b <= p_711_5_ && var8.field_1207_c <= p_711_6_) {
            this.field_1057_z.remove(var7--);
         }
      }

   }

   protected IChunkProvider func_4081_a() {
      this.field_20915_C = new ChunkProviderClient(this);
      return this.field_20915_C;
   }

   public void func_4076_b() {
      this.func_22143_a(new ChunkCoordinates(8, 64, 8));
   }

   protected void func_4080_j() {
      this.func_48461_r();
      Iterator var1 = this.field_9427_K.iterator();

      while(var1.hasNext()) {
         ChunkCoordIntPair var2 = (ChunkCoordIntPair)var1.next();
         int var3 = var2.field_189_a * 16;
         int var4 = var2.field_188_b * 16;
         Profiler.func_40663_a("getChunk");
         Chunk var5 = this.func_704_b(var2.field_189_a, var2.field_188_b);
         this.func_48458_a(var3, var4, var5);
         Profiler.func_40662_b();
      }

   }

   public void func_22136_c(int p_22136_1_, int p_22136_2_, int p_22136_3_, int p_22136_4_, int p_22136_5_) {}

   public boolean func_700_a(boolean p_700_1_) {
      return false;
   }

   public void func_713_a(int p_713_1_, int p_713_2_, boolean p_713_3_) {
      if(p_713_3_) {
         this.field_20915_C.func_538_d(p_713_1_, p_713_2_);
      } else {
         this.field_20915_C.func_539_c(p_713_1_, p_713_2_);
      }

      if(!p_713_3_) {
         this.func_701_b(p_713_1_ * 16, 0, p_713_2_ * 16, p_713_1_ * 16 + 15, 256, p_713_2_ * 16 + 15);
      }

   }

   public boolean func_674_a(Entity p_674_1_) {
      boolean var2 = super.func_674_a(p_674_1_);
      this.field_20914_E.add(p_674_1_);
      if(!var2) {
         this.field_1053_F.add(p_674_1_);
      }

      return var2;
   }

   public void func_607_d(Entity p_607_1_) {
      super.func_607_d(p_607_1_);
      this.field_20914_E.remove(p_607_1_);
   }

   protected void func_606_b(Entity p_606_1_) {
      super.func_606_b(p_606_1_);
      if(this.field_1053_F.contains(p_606_1_)) {
         this.field_1053_F.remove(p_606_1_);
      }

   }

   protected void func_678_c(Entity p_678_1_) {
      super.func_678_c(p_678_1_);
      if(this.field_20914_E.contains(p_678_1_)) {
         if(p_678_1_.func_354_B()) {
            this.field_1053_F.add(p_678_1_);
         } else {
            this.field_20914_E.remove(p_678_1_);
         }
      }

   }

   public void func_712_a(int p_712_1_, Entity p_712_2_) {
      Entity var3 = this.func_709_b(p_712_1_);
      if(var3 != null) {
         this.func_607_d(var3);
      }

      this.field_20914_E.add(p_712_2_);
      p_712_2_.field_620_ab = p_712_1_;
      if(!this.func_674_a(p_712_2_)) {
         this.field_1053_F.add(p_712_2_);
      }

      this.field_1055_D.func_1061_a(p_712_1_, p_712_2_);
   }

   public Entity func_709_b(int p_709_1_) {
      return (Entity)this.field_1055_D.func_1057_a(p_709_1_);
   }

   public Entity func_710_c(int p_710_1_) {
      Entity var2 = (Entity)this.field_1055_D.func_1052_b(p_710_1_);
      if(var2 != null) {
         this.field_20914_E.remove(var2);
         this.func_607_d(var2);
      }

      return var2;
   }

   public boolean func_714_c(int p_714_1_, int p_714_2_, int p_714_3_, int p_714_4_, int p_714_5_) {
      this.func_711_c(p_714_1_, p_714_2_, p_714_3_, p_714_1_, p_714_2_, p_714_3_);
      return super.func_688_b(p_714_1_, p_714_2_, p_714_3_, p_714_4_, p_714_5_);
   }

   public void func_660_k() {
      this.field_1052_A.func_28117_a(new Packet255KickDisconnect("Quitting"));
   }

   protected void func_27165_m() {
      if(!this.field_4209_q.field_6478_e) {
         if(this.field_27168_F > 0) {
            --this.field_27168_F;
         }

         this.field_26901_B = this.field_27171_C;
         if(this.field_22145_q.func_27397_o()) {
            this.field_27171_C = (float)((double)this.field_27171_C + 0.01D);
         } else {
            this.field_27171_C = (float)((double)this.field_27171_C - 0.01D);
         }

         if(this.field_27171_C < 0.0F) {
            this.field_27171_C = 0.0F;
         }

         if(this.field_27171_C > 1.0F) {
            this.field_27171_C = 1.0F;
         }

         this.field_27170_D = this.field_27169_E;
         if(this.field_22145_q.func_27396_m()) {
            this.field_27169_E = (float)((double)this.field_27169_E + 0.01D);
         } else {
            this.field_27169_E = (float)((double)this.field_27169_E - 0.01D);
         }

         if(this.field_27169_E < 0.0F) {
            this.field_27169_E = 0.0F;
         }

         if(this.field_27169_E > 1.0F) {
            this.field_27169_E = 1.0F;
         }

      }
   }
}
