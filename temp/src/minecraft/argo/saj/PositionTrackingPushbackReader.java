package argo.saj;

import argo.saj.ThingWithPosition;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

final class PositionTrackingPushbackReader implements ThingWithPosition {

   private final PushbackReader field_27338_a;
   private int field_27337_b = 0;
   private int field_27340_c = 1;
   private boolean field_27339_d = false;


   public PositionTrackingPushbackReader(Reader p_i7_1_) {
      this.field_27338_a = new PushbackReader(p_i7_1_);
   }

   public void func_27334_a(char p_27334_1_) throws IOException {
      --this.field_27337_b;
      if(this.field_27337_b < 0) {
         this.field_27337_b = 0;
      }

      this.field_27338_a.unread(p_27334_1_);
   }

   public void func_27335_a(char[] p_27335_1_) {
      this.field_27337_b -= p_27335_1_.length;
      if(this.field_27337_b < 0) {
         this.field_27337_b = 0;
      }

   }

   public int func_27333_c() throws IOException {
      int var1 = this.field_27338_a.read();
      this.func_27332_a(var1);
      return var1;
   }

   public int func_27336_b(char[] p_27336_1_) throws IOException {
      int var2 = this.field_27338_a.read(p_27336_1_);
      char[] var3 = p_27336_1_;
      int var4 = p_27336_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         char var6 = var3[var5];
         this.func_27332_a(var6);
      }

      return var2;
   }

   private void func_27332_a(int p_27332_1_) {
      if(13 == p_27332_1_) {
         this.field_27337_b = 0;
         ++this.field_27340_c;
         this.field_27339_d = true;
      } else {
         if(10 == p_27332_1_ && !this.field_27339_d) {
            this.field_27337_b = 0;
            ++this.field_27340_c;
         } else {
            ++this.field_27337_b;
         }

         this.field_27339_d = false;
      }

   }

   public int func_27331_a() {
      return this.field_27337_b;
   }

   public int func_27330_b() {
      return this.field_27340_c;
   }
}
