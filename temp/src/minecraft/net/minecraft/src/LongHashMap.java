package net.minecraft.src;

import net.minecraft.src.LongHashMapEntry;

public class LongHashMap {

   private transient LongHashMapEntry[] field_35584_a = new LongHashMapEntry[16];
   private transient int field_35582_b;
   private int field_35583_c = 12;
   private final float field_35580_d = 0.75F;
   private transient volatile int field_35581_e;


   private static int func_35568_g(long p_35568_0_) {
      return func_35571_a((int)(p_35568_0_ ^ p_35568_0_ >>> 32));
   }

   private static int func_35571_a(int p_35571_0_) {
      p_35571_0_ ^= p_35571_0_ >>> 20 ^ p_35571_0_ >>> 12;
      return p_35571_0_ ^ p_35571_0_ >>> 7 ^ p_35571_0_ >>> 4;
   }

   private static int func_35573_a(int p_35573_0_, int p_35573_1_) {
      return p_35573_0_ & p_35573_1_ - 1;
   }

   public int func_35576_a() {
      return this.field_35582_b;
   }

   public Object func_35578_a(long p_35578_1_) {
      int var3 = func_35568_g(p_35578_1_);

      for(LongHashMapEntry var4 = this.field_35584_a[func_35573_a(var3, this.field_35584_a.length)]; var4 != null; var4 = var4.field_35833_c) {
         if(var4.field_35834_a == p_35578_1_) {
            return var4.field_35832_b;
         }
      }

      return null;
   }

   public boolean func_35575_b(long p_35575_1_) {
      return this.func_35569_c(p_35575_1_) != null;
   }

   final LongHashMapEntry func_35569_c(long p_35569_1_) {
      int var3 = func_35568_g(p_35569_1_);

      for(LongHashMapEntry var4 = this.field_35584_a[func_35573_a(var3, this.field_35584_a.length)]; var4 != null; var4 = var4.field_35833_c) {
         if(var4.field_35834_a == p_35569_1_) {
            return var4;
         }
      }

      return null;
   }

   public void func_35577_a(long p_35577_1_, Object p_35577_3_) {
      int var4 = func_35568_g(p_35577_1_);
      int var5 = func_35573_a(var4, this.field_35584_a.length);

      for(LongHashMapEntry var6 = this.field_35584_a[var5]; var6 != null; var6 = var6.field_35833_c) {
         if(var6.field_35834_a == p_35577_1_) {
            var6.field_35832_b = p_35577_3_;
         }
      }

      ++this.field_35581_e;
      this.func_35570_a(var4, p_35577_1_, p_35577_3_, var5);
   }

   private void func_35567_b(int p_35567_1_) {
      LongHashMapEntry[] var2 = this.field_35584_a;
      int var3 = var2.length;
      if(var3 == 1073741824) {
         this.field_35583_c = Integer.MAX_VALUE;
      } else {
         LongHashMapEntry[] var4 = new LongHashMapEntry[p_35567_1_];
         this.func_35579_a(var4);
         this.field_35584_a = var4;
         this.field_35583_c = (int)((float)p_35567_1_ * this.field_35580_d);
      }
   }

   private void func_35579_a(LongHashMapEntry[] p_35579_1_) {
      LongHashMapEntry[] var2 = this.field_35584_a;
      int var3 = p_35579_1_.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         LongHashMapEntry var5 = var2[var4];
         if(var5 != null) {
            var2[var4] = null;

            LongHashMapEntry var6;
            do {
               var6 = var5.field_35833_c;
               int var7 = func_35573_a(var5.field_35831_d, var3);
               var5.field_35833_c = p_35579_1_[var7];
               p_35579_1_[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   public Object func_35574_d(long p_35574_1_) {
      LongHashMapEntry var3 = this.func_35572_e(p_35574_1_);
      return var3 == null?null:var3.field_35832_b;
   }

   final LongHashMapEntry func_35572_e(long p_35572_1_) {
      int var3 = func_35568_g(p_35572_1_);
      int var4 = func_35573_a(var3, this.field_35584_a.length);
      LongHashMapEntry var5 = this.field_35584_a[var4];

      LongHashMapEntry var6;
      LongHashMapEntry var7;
      for(var6 = var5; var6 != null; var6 = var7) {
         var7 = var6.field_35833_c;
         if(var6.field_35834_a == p_35572_1_) {
            ++this.field_35581_e;
            --this.field_35582_b;
            if(var5 == var6) {
               this.field_35584_a[var4] = var7;
            } else {
               var5.field_35833_c = var7;
            }

            return var6;
         }

         var5 = var6;
      }

      return var6;
   }

   private void func_35570_a(int p_35570_1_, long p_35570_2_, Object p_35570_4_, int p_35570_5_) {
      LongHashMapEntry var6 = this.field_35584_a[p_35570_5_];
      this.field_35584_a[p_35570_5_] = new LongHashMapEntry(p_35570_1_, p_35570_2_, p_35570_4_, var6);
      if(this.field_35582_b++ >= this.field_35583_c) {
         this.func_35567_b(2 * this.field_35584_a.length);
      }

   }

   // $FF: synthetic method
   static int func_35566_f(long p_35566_0_) {
      return func_35568_g(p_35566_0_);
   }
}
