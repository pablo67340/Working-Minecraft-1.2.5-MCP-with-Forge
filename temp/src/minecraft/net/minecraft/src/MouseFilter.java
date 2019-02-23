package net.minecraft.src;


public class MouseFilter {

   private float field_22388_a;
   private float field_22387_b;
   private float field_22389_c;


   public float func_22386_a(float p_22386_1_, float p_22386_2_) {
      this.field_22388_a += p_22386_1_;
      p_22386_1_ = (this.field_22388_a - this.field_22387_b) * p_22386_2_;
      this.field_22389_c += (p_22386_1_ - this.field_22389_c) * 0.5F;
      if(p_22386_1_ > 0.0F && p_22386_1_ > this.field_22389_c || p_22386_1_ < 0.0F && p_22386_1_ < this.field_22389_c) {
         p_22386_1_ = this.field_22389_c;
      }

      this.field_22387_b += p_22386_1_;
      return p_22386_1_;
   }
}
