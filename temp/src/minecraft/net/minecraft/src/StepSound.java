package net.minecraft.src;


public class StepSound {

   public final String field_1678_a;
   public final float field_1677_b;
   public final float field_1679_c;


   public StepSound(String p_i645_1_, float p_i645_2_, float p_i645_3_) {
      this.field_1678_a = p_i645_1_;
      this.field_1677_b = p_i645_2_;
      this.field_1679_c = p_i645_3_;
   }

   public float func_1147_b() {
      return this.field_1677_b;
   }

   public float func_1144_c() {
      return this.field_1679_c;
   }

   public String func_1146_a() {
      return "step." + this.field_1678_a;
   }

   public String func_1145_d() {
      return "step." + this.field_1678_a;
   }
}
