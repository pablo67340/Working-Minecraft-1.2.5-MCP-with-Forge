package net.minecraft.src;


public class NextTickListEntry implements Comparable {

   private static long field_1363_f = 0L;
   public int field_1361_a;
   public int field_1360_b;
   public int field_1366_c;
   public int field_1365_d;
   public long field_1364_e;
   private long field_1362_g;


   public NextTickListEntry(int p_i458_1_, int p_i458_2_, int p_i458_3_, int p_i458_4_) {
      this.field_1362_g = (long)(field_1363_f++);
      this.field_1361_a = p_i458_1_;
      this.field_1360_b = p_i458_2_;
      this.field_1366_c = p_i458_3_;
      this.field_1365_d = p_i458_4_;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof NextTickListEntry)) {
         return false;
      } else {
         NextTickListEntry var2 = (NextTickListEntry)p_equals_1_;
         return this.field_1361_a == var2.field_1361_a && this.field_1360_b == var2.field_1360_b && this.field_1366_c == var2.field_1366_c && this.field_1365_d == var2.field_1365_d;
      }
   }

   public int hashCode() {
      return (this.field_1361_a * 1024 * 1024 + this.field_1366_c * 1024 + this.field_1360_b) * 256 + this.field_1365_d;
   }

   public NextTickListEntry func_900_a(long p_900_1_) {
      this.field_1364_e = p_900_1_;
      return this;
   }

   public int func_899_a(NextTickListEntry p_899_1_) {
      return this.field_1364_e < p_899_1_.field_1364_e?-1:(this.field_1364_e > p_899_1_.field_1364_e?1:(this.field_1362_g < p_899_1_.field_1362_g?-1:(this.field_1362_g > p_899_1_.field_1362_g?1:0)));
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_899_a((NextTickListEntry)p_compareTo_1_);
   }

}
