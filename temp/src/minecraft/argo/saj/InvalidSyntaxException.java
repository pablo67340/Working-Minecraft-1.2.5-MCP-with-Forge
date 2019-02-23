package argo.saj;

import argo.saj.ThingWithPosition;

public final class InvalidSyntaxException extends Exception {

   private final int field_27191_a;
   private final int field_27190_b;


   InvalidSyntaxException(String p_i193_1_, ThingWithPosition p_i193_2_) {
      super("At line " + p_i193_2_.func_27330_b() + ", column " + p_i193_2_.func_27331_a() + ":  " + p_i193_1_);
      this.field_27191_a = p_i193_2_.func_27331_a();
      this.field_27190_b = p_i193_2_.func_27330_b();
   }

   InvalidSyntaxException(String p_i194_1_, Throwable p_i194_2_, ThingWithPosition p_i194_3_) {
      super("At line " + p_i194_3_.func_27330_b() + ", column " + p_i194_3_.func_27331_a() + ":  " + p_i194_1_, p_i194_2_);
      this.field_27191_a = p_i194_3_.func_27331_a();
      this.field_27190_b = p_i194_3_.func_27330_b();
   }
}
