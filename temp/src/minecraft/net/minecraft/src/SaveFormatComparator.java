package net.minecraft.src;


public class SaveFormatComparator implements Comparable {

   private final String field_22166_a;
   private final String field_22165_b;
   private final long field_22169_c;
   private final long field_22168_d;
   private final boolean field_22167_e;
   private final int field_35720_f;
   private final boolean field_40595_g;


   public SaveFormatComparator(String p_i515_1_, String p_i515_2_, long p_i515_3_, long p_i515_5_, int p_i515_7_, boolean p_i515_8_, boolean p_i515_9_) {
      this.field_22166_a = p_i515_1_;
      this.field_22165_b = p_i515_2_;
      this.field_22169_c = p_i515_3_;
      this.field_22168_d = p_i515_5_;
      this.field_35720_f = p_i515_7_;
      this.field_22167_e = p_i515_8_;
      this.field_40595_g = p_i515_9_;
   }

   public String func_22164_a() {
      return this.field_22166_a;
   }

   public String func_22162_b() {
      return this.field_22165_b;
   }

   public boolean func_22161_d() {
      return this.field_22167_e;
   }

   public long func_22163_e() {
      return this.field_22169_c;
   }

   public int func_22160_a(SaveFormatComparator p_22160_1_) {
      return this.field_22169_c < p_22160_1_.field_22169_c?1:(this.field_22169_c > p_22160_1_.field_22169_c?-1:this.field_22166_a.compareTo(p_22160_1_.field_22166_a));
   }

   public int func_35719_f() {
      return this.field_35720_f;
   }

   public boolean func_40594_g() {
      return this.field_40595_g;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compareTo(Object p_compareTo_1_) {
      return this.func_22160_a((SaveFormatComparator)p_compareTo_1_);
   }
}
