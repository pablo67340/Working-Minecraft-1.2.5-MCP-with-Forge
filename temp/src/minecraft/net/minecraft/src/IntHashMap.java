package net.minecraft.src;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.src.IntHashMapEntry;

public class IntHashMap {

   private transient IntHashMapEntry[] field_1590_a = new IntHashMapEntry[16];
   private transient int field_1589_b;
   private int field_1593_c = 12;
   private final float field_1592_d = 0.75F;
   private transient volatile int field_1591_e;
   private Set field_35861_f = new HashSet();


   private static int func_1055_e(int p_1055_0_) {
      p_1055_0_ ^= p_1055_0_ >>> 20 ^ p_1055_0_ >>> 12;
      return p_1055_0_ ^ p_1055_0_ >>> 7 ^ p_1055_0_ >>> 4;
   }

   private static int func_1062_a(int p_1062_0_, int p_1062_1_) {
      return p_1062_0_ & p_1062_1_ - 1;
   }

   public Object func_1057_a(int p_1057_1_) {
      int var2 = func_1055_e(p_1057_1_);

      for(IntHashMapEntry var3 = this.field_1590_a[func_1062_a(var2, this.field_1590_a.length)]; var3 != null; var3 = var3.field_1108_c) {
         if(var3.field_1106_a == p_1057_1_) {
            return var3.field_1105_b;
         }
      }

      return null;
   }

   public boolean func_35858_b(int p_35858_1_) {
      return this.func_35859_c(p_35858_1_) != null;
   }

   final IntHashMapEntry func_35859_c(int p_35859_1_) {
      int var2 = func_1055_e(p_35859_1_);

      for(IntHashMapEntry var3 = this.field_1590_a[func_1062_a(var2, this.field_1590_a.length)]; var3 != null; var3 = var3.field_1108_c) {
         if(var3.field_1106_a == p_35859_1_) {
            return var3;
         }
      }

      return null;
   }

   public void func_1061_a(int p_1061_1_, Object p_1061_2_) {
      this.field_35861_f.add(Integer.valueOf(p_1061_1_));
      int var3 = func_1055_e(p_1061_1_);
      int var4 = func_1062_a(var3, this.field_1590_a.length);

      for(IntHashMapEntry var5 = this.field_1590_a[var4]; var5 != null; var5 = var5.field_1108_c) {
         if(var5.field_1106_a == p_1061_1_) {
            var5.field_1105_b = p_1061_2_;
         }
      }

      ++this.field_1591_e;
      this.func_1053_a(var3, p_1061_1_, p_1061_2_, var4);
   }

   private void func_1060_f(int p_1060_1_) {
      IntHashMapEntry[] var2 = this.field_1590_a;
      int var3 = var2.length;
      if(var3 == 1073741824) {
         this.field_1593_c = Integer.MAX_VALUE;
      } else {
         IntHashMapEntry[] var4 = new IntHashMapEntry[p_1060_1_];
         this.func_1059_a(var4);
         this.field_1590_a = var4;
         this.field_1593_c = (int)((float)p_1060_1_ * this.field_1592_d);
      }
   }

   private void func_1059_a(IntHashMapEntry[] p_1059_1_) {
      IntHashMapEntry[] var2 = this.field_1590_a;
      int var3 = p_1059_1_.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         IntHashMapEntry var5 = var2[var4];
         if(var5 != null) {
            var2[var4] = null;

            IntHashMapEntry var6;
            do {
               var6 = var5.field_1108_c;
               int var7 = func_1062_a(var5.field_1107_d, var3);
               var5.field_1108_c = p_1059_1_[var7];
               p_1059_1_[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   public Object func_1052_b(int p_1052_1_) {
      this.field_35861_f.remove(Integer.valueOf(p_1052_1_));
      IntHashMapEntry var2 = this.func_1054_c(p_1052_1_);
      return var2 == null?null:var2.field_1105_b;
   }

   final IntHashMapEntry func_1054_c(int p_1054_1_) {
      int var2 = func_1055_e(p_1054_1_);
      int var3 = func_1062_a(var2, this.field_1590_a.length);
      IntHashMapEntry var4 = this.field_1590_a[var3];

      IntHashMapEntry var5;
      IntHashMapEntry var6;
      for(var5 = var4; var5 != null; var5 = var6) {
         var6 = var5.field_1108_c;
         if(var5.field_1106_a == p_1054_1_) {
            ++this.field_1591_e;
            --this.field_1589_b;
            if(var4 == var5) {
               this.field_1590_a[var3] = var6;
            } else {
               var4.field_1108_c = var6;
            }

            return var5;
         }

         var4 = var5;
      }

      return var5;
   }

   public void func_1058_a() {
      ++this.field_1591_e;
      IntHashMapEntry[] var1 = this.field_1590_a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = null;
      }

      this.field_1589_b = 0;
   }

   private void func_1053_a(int p_1053_1_, int p_1053_2_, Object p_1053_3_, int p_1053_4_) {
      IntHashMapEntry var5 = this.field_1590_a[p_1053_4_];
      this.field_1590_a[p_1053_4_] = new IntHashMapEntry(p_1053_1_, p_1053_2_, p_1053_3_, var5);
      if(this.field_1589_b++ >= this.field_1593_c) {
         this.func_1060_f(2 * this.field_1590_a.length);
      }

   }

   public Set func_35860_b() {
      return this.field_35861_f;
   }

   // $FF: synthetic method
   static int func_1056_d(int p_1056_0_) {
      return func_1055_e(p_1056_0_);
   }
}
