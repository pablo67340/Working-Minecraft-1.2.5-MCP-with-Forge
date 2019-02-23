package net.minecraft.src;

import net.minecraft.src.IntHashMap;

class IntHashMapEntry {

   final int field_1106_a;
   Object field_1105_b;
   IntHashMapEntry field_1108_c;
   final int field_1107_d;


   IntHashMapEntry(int p_i560_1_, int p_i560_2_, Object p_i560_3_, IntHashMapEntry p_i560_4_) {
      this.field_1105_b = p_i560_3_;
      this.field_1108_c = p_i560_4_;
      this.field_1106_a = p_i560_2_;
      this.field_1107_d = p_i560_1_;
   }

   public final int func_768_a() {
      return this.field_1106_a;
   }

   public final Object func_767_b() {
      return this.field_1105_b;
   }

   public final boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof IntHashMapEntry)) {
         return false;
      } else {
         IntHashMapEntry var2 = (IntHashMapEntry)p_equals_1_;
         Integer var3 = Integer.valueOf(this.func_768_a());
         Integer var4 = Integer.valueOf(var2.func_768_a());
         if(var3 == var4 || var3 != null && var3.equals(var4)) {
            Object var5 = this.func_767_b();
            Object var6 = var2.func_767_b();
            if(var5 == var6 || var5 != null && var5.equals(var6)) {
               return true;
            }
         }

         return false;
      }
   }

   public final int hashCode() {
      return IntHashMap.func_1056_d(this.field_1106_a);
   }

   public final String toString() {
      return this.func_768_a() + "=" + this.func_767_b();
   }
}
