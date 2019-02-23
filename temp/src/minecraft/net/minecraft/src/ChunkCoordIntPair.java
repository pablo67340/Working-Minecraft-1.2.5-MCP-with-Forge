package net.minecraft.src;

import net.minecraft.src.ChunkPosition;

public class ChunkCoordIntPair {

   public final int field_189_a;
   public final int field_188_b;


   public ChunkCoordIntPair(int p_i590_1_, int p_i590_2_) {
      this.field_189_a = p_i590_1_;
      this.field_188_b = p_i590_2_;
   }

   public static long func_22011_a(int p_22011_0_, int p_22011_1_) {
      long var2 = (long)p_22011_0_;
      long var4 = (long)p_22011_1_;
      return var2 & 4294967295L | (var4 & 4294967295L) << 32;
   }

   public int hashCode() {
      long var1 = func_22011_a(this.field_189_a, this.field_188_b);
      int var3 = (int)var1;
      int var4 = (int)(var1 >> 32);
      return var3 ^ var4;
   }

   public boolean equals(Object p_equals_1_) {
      ChunkCoordIntPair var2 = (ChunkCoordIntPair)p_equals_1_;
      return var2.field_189_a == this.field_189_a && var2.field_188_b == this.field_188_b;
   }

   public int func_40735_a() {
      return (this.field_189_a << 4) + 8;
   }

   public int func_40736_b() {
      return (this.field_188_b << 4) + 8;
   }

   public ChunkPosition func_40737_a(int p_40737_1_) {
      return new ChunkPosition(this.func_40735_a(), p_40737_1_, this.func_40736_b());
   }

   public String toString() {
      return "[" + this.field_189_a + ", " + this.field_188_b + "]";
   }
}
