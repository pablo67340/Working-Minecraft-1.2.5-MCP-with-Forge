package net.minecraft.src;


public class WatchableObject {

   private final int field_21164_a;
   private final int field_21163_b;
   private Object field_21166_c;
   private boolean field_21165_d;


   public WatchableObject(int p_i27_1_, int p_i27_2_, Object p_i27_3_) {
      this.field_21163_b = p_i27_2_;
      this.field_21166_c = p_i27_3_;
      this.field_21164_a = p_i27_1_;
      this.field_21165_d = true;
   }

   public int func_21161_a() {
      return this.field_21163_b;
   }

   public void func_21160_a(Object p_21160_1_) {
      this.field_21166_c = p_21160_1_;
   }

   public Object func_21158_b() {
      return this.field_21166_c;
   }

   public int func_21159_c() {
      return this.field_21164_a;
   }

   public void func_21162_a(boolean p_21162_1_) {
      this.field_21165_d = p_21162_1_;
   }
}
