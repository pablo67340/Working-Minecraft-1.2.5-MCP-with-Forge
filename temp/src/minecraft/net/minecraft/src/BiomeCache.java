package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.BiomeCacheBlock;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.LongHashMap;
import net.minecraft.src.WorldChunkManager;

public class BiomeCache {

   private final WorldChunkManager field_35731_a;
   private long field_35729_b = 0L;
   private LongHashMap field_35730_c = new LongHashMap();
   private List field_35728_d = new ArrayList();


   public BiomeCache(WorldChunkManager p_i519_1_) {
      this.field_35731_a = p_i519_1_;
   }

   public BiomeCacheBlock func_35726_e(int p_35726_1_, int p_35726_2_) {
      p_35726_1_ >>= 4;
      p_35726_2_ >>= 4;
      long var3 = (long)p_35726_1_ & 4294967295L | ((long)p_35726_2_ & 4294967295L) << 32;
      BiomeCacheBlock var5 = (BiomeCacheBlock)this.field_35730_c.func_35578_a(var3);
      if(var5 == null) {
         var5 = new BiomeCacheBlock(this, p_35726_1_, p_35726_2_);
         this.field_35730_c.func_35577_a(var3, var5);
         this.field_35728_d.add(var5);
      }

      var5.field_35653_f = System.currentTimeMillis();
      return var5;
   }

   public BiomeGenBase func_35725_a(int p_35725_1_, int p_35725_2_) {
      return this.func_35726_e(p_35725_1_, p_35725_2_).func_35651_a(p_35725_1_, p_35725_2_);
   }

   public void func_35724_a() {
      long var1 = System.currentTimeMillis();
      long var3 = var1 - this.field_35729_b;
      if(var3 > 7500L || var3 < 0L) {
         this.field_35729_b = var1;

         for(int var5 = 0; var5 < this.field_35728_d.size(); ++var5) {
            BiomeCacheBlock var6 = (BiomeCacheBlock)this.field_35728_d.get(var5);
            long var7 = var1 - var6.field_35653_f;
            if(var7 > 30000L || var7 < 0L) {
               this.field_35728_d.remove(var5--);
               long var9 = (long)var6.field_35655_d & 4294967295L | ((long)var6.field_35656_e & 4294967295L) << 32;
               this.field_35730_c.func_35574_d(var9);
            }
         }
      }

   }

   public BiomeGenBase[] func_35723_d(int p_35723_1_, int p_35723_2_) {
      return this.func_35726_e(p_35723_1_, p_35723_2_).field_35658_c;
   }

   // $FF: synthetic method
   static WorldChunkManager func_35721_a(BiomeCache p_35721_0_) {
      return p_35721_0_.field_35731_a;
   }
}
