package net.minecraft.src;


public final class ProfilerResult implements Comparable {

   public double field_40704_a;
   public double field_40702_b;
   public String field_40703_c;


   public ProfilerResult(String p_i736_1_, double p_i736_2_, double p_i736_4_) {
      this.field_40703_c = p_i736_1_;
      this.field_40704_a = p_i736_2_;
      this.field_40702_b = p_i736_4_;
   }

   public int func_40701_a(ProfilerResult p_40701_1_) {
      return p_40701_1_.field_40704_a < this.field_40704_a?-1:(p_40701_1_.field_40704_a > this.field_40704_a?1:p_40701_1_.field_40703_c.compareTo(this.field_40703_c));
   }

   public int func_40700_a() {
      return (this.field_40703_c.hashCode() & 11184810) + 4473924;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_40701_a((ProfilerResult)p_compareTo_1_);
   }
}
