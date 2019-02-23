package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MapGenVillage;
import net.minecraft.src.World;

public class ChunkProviderFlat implements IChunkProvider {

   private World field_46055_a;
   private Random field_46053_b;
   private final boolean field_46054_c;
   private MapGenVillage field_46052_d = new MapGenVillage(1);


   public ChunkProviderFlat(World p_i696_1_, long p_i696_2_, boolean p_i696_4_) {
      this.field_46055_a = p_i696_1_;
      this.field_46054_c = p_i696_4_;
      this.field_46053_b = new Random(p_i696_2_);
   }

   private void func_46051_a(byte[] p_46051_1_) {
      int var2 = p_46051_1_.length / 256;

      for(int var3 = 0; var3 < 16; ++var3) {
         for(int var4 = 0; var4 < 16; ++var4) {
            for(int var5 = 0; var5 < var2; ++var5) {
               int var6 = 0;
               if(var5 == 0) {
                  var6 = Block.field_403_A.field_376_bc;
               } else if(var5 <= 2) {
                  var6 = Block.field_336_w.field_376_bc;
               } else if(var5 == 3) {
                  var6 = Block.field_337_v.field_376_bc;
               }

               p_46051_1_[var3 << 11 | var4 << 7 | var5] = (byte)var6;
            }
         }
      }

   }

   public Chunk func_538_d(int p_538_1_, int p_538_2_) {
      return this.func_533_b(p_538_1_, p_538_2_);
   }

   public Chunk func_533_b(int p_533_1_, int p_533_2_) {
      byte[] var3 = new byte['\u8000'];
      this.func_46051_a(var3);
      Chunk var4 = new Chunk(this.field_46055_a, var3, p_533_1_, p_533_2_);
      if(this.field_46054_c) {
         this.field_46052_d.func_867_a(this, this.field_46055_a, p_533_1_, p_533_2_, var3);
      }

      BiomeGenBase[] var5 = this.field_46055_a.func_4075_a().func_4070_a((BiomeGenBase[])null, p_533_1_ * 16, p_533_2_ * 16, 16, 16);
      byte[] var6 = var4.func_48493_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].field_35494_y;
      }

      var4.func_1024_c();
      return var4;
   }

   public boolean func_537_a(int p_537_1_, int p_537_2_) {
      return true;
   }

   public void func_534_a(IChunkProvider p_534_1_, int p_534_2_, int p_534_3_) {
      this.field_46053_b.setSeed(this.field_46055_a.func_22138_q());
      long var4 = this.field_46053_b.nextLong() / 2L * 2L + 1L;
      long var6 = this.field_46053_b.nextLong() / 2L * 2L + 1L;
      this.field_46053_b.setSeed((long)p_534_2_ * var4 + (long)p_534_3_ * var6 ^ this.field_46055_a.func_22138_q());
      if(this.field_46054_c) {
         this.field_46052_d.func_35629_a(this.field_46055_a, this.field_46053_b, p_534_2_, p_534_3_);
      }

   }

   public boolean func_535_a(boolean p_535_1_, IProgressUpdate p_535_2_) {
      return true;
   }

   public boolean func_532_a() {
      return false;
   }

   public boolean func_536_b() {
      return true;
   }

   public String func_21109_c() {
      return "FlatLevelSource";
   }

   public List func_40377_a(EnumCreatureType p_40377_1_, int p_40377_2_, int p_40377_3_, int p_40377_4_) {
      BiomeGenBase var5 = this.field_46055_a.func_48454_a(p_40377_2_, p_40377_4_);
      return var5 == null?null:var5.func_25063_a(p_40377_1_);
   }

   public ChunkPosition func_40376_a(World p_40376_1_, String p_40376_2_, int p_40376_3_, int p_40376_4_, int p_40376_5_) {
      return null;
   }
}
