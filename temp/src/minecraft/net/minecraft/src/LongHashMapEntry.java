package net.minecraft.src;

import net.minecraft.src.LongHashMap;

class LongHashMapEntry {

   final long field_35834_a;
   Object field_35832_b;
   LongHashMapEntry field_35833_c;
   final int field_35831_d;


   LongHashMapEntry(int p_i452_1_, long p_i452_2_, Object p_i452_4_, LongHashMapEntry p_i452_5_) {
      this.field_35832_b = p_i452_4_;
      this.field_35833_c = p_i452_5_;
      this.field_35834_a = p_i452_2_;
      this.field_35831_d = p_i452_1_;
   }

   public final long func_35830_a() {
      return this.field_35834_a;
   }

   public final Object func_35829_b() {
      return this.field_35832_b;
   }

   public final boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof LongHashMapEntry)) {
         return false;
      } else {
         LongHashMapEntry var2 = (LongHashMapEntry)p_equals_1_;
         Long var3 = Long.valueOf(this.func_35830_a());
         Long var4 = Long.valueOf(var2.func_35830_a());
         if(var3 == var4 || var3 != null && var3.equals(var4)) {
            Object var5 = this.func_35829_b();
            Object var6 = var2.func_35829_b();
            if(var5 == var6 || var5 != null && var5.equals(var6)) {
               return true;
            }
         }

         return false;
      }
   }

   public final int hashCode() {
      return LongHashMap.func_35566_f(this.field_35834_a);
   }

   public final String toString() {
      return this.func_35830_a() + "=" + this.func_35829_b();
   }
}
