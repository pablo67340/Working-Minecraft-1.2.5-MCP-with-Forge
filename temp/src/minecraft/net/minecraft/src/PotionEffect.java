package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.Potion;

public class PotionEffect {

   private int field_35805_a;
   private int field_35803_b;
   private int field_35804_c;


   public PotionEffect(int p_i196_1_, int p_i196_2_, int p_i196_3_) {
      this.field_35805_a = p_i196_1_;
      this.field_35803_b = p_i196_2_;
      this.field_35804_c = p_i196_3_;
   }

   public PotionEffect(PotionEffect p_i197_1_) {
      this.field_35805_a = p_i197_1_.field_35805_a;
      this.field_35803_b = p_i197_1_.field_35803_b;
      this.field_35804_c = p_i197_1_.field_35804_c;
   }

   public void func_35796_a(PotionEffect p_35796_1_) {
      if(this.field_35805_a != p_35796_1_.field_35805_a) {
         System.err.println("This method should only be called for matching effects!");
      }

      if(p_35796_1_.field_35804_c > this.field_35804_c) {
         this.field_35804_c = p_35796_1_.field_35804_c;
         this.field_35803_b = p_35796_1_.field_35803_b;
      } else if(p_35796_1_.field_35804_c == this.field_35804_c && this.field_35803_b < p_35796_1_.field_35803_b) {
         this.field_35803_b = p_35796_1_.field_35803_b;
      }

   }

   public int func_35799_a() {
      return this.field_35805_a;
   }

   public int func_35802_b() {
      return this.field_35803_b;
   }

   public int func_35801_c() {
      return this.field_35804_c;
   }

   public boolean func_35798_a(EntityLiving p_35798_1_) {
      if(this.field_35803_b > 0) {
         if(Potion.field_35678_a[this.field_35805_a].func_35660_a(this.field_35803_b, this.field_35804_c)) {
            this.func_35800_b(p_35798_1_);
         }

         this.func_35797_d();
      }

      return this.field_35803_b > 0;
   }

   private int func_35797_d() {
      return --this.field_35803_b;
   }

   public void func_35800_b(EntityLiving p_35800_1_) {
      if(this.field_35803_b > 0) {
         Potion.field_35678_a[this.field_35805_a].func_35662_a(p_35800_1_, this.field_35804_c);
      }

   }

   public String func_40468_d() {
      return Potion.field_35678_a[this.field_35805_a].func_40623_c();
   }

   public int hashCode() {
      return this.field_35805_a;
   }

   public String toString() {
      String var1 = "";
      if(this.func_35801_c() > 0) {
         var1 = this.func_40468_d() + " x " + (this.func_35801_c() + 1) + ", Duration: " + this.func_35802_b();
      } else {
         var1 = this.func_40468_d() + ", Duration: " + this.func_35802_b();
      }

      return Potion.field_35678_a[this.field_35805_a].func_40612_i()?"(" + var1 + ")":var1;
   }

   public boolean equals(Object p_equals_1_) {
      if(!(p_equals_1_ instanceof PotionEffect)) {
         return false;
      } else {
         PotionEffect var2 = (PotionEffect)p_equals_1_;
         return this.field_35805_a == var2.field_35805_a && this.field_35804_c == var2.field_35804_c && this.field_35803_b == var2.field_35803_b;
      }
   }
}
