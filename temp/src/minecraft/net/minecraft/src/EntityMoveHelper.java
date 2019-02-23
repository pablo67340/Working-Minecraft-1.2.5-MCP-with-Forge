package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;

public class EntityMoveHelper {

   private EntityLiving field_46041_a;
   private double field_46039_b;
   private double field_46040_c;
   private double field_46037_d;
   private float field_46038_e;
   private boolean field_46036_f = false;


   public EntityMoveHelper(EntityLiving p_i1046_1_) {
      this.field_46041_a = p_i1046_1_;
      this.field_46039_b = p_i1046_1_.field_611_ak;
      this.field_46040_c = p_i1046_1_.field_610_al;
      this.field_46037_d = p_i1046_1_.field_609_am;
   }

   public boolean func_48186_a() {
      return this.field_46036_f;
   }

   public float func_48184_b() {
      return this.field_46038_e;
   }

   public void func_48187_a(double p_48187_1_, double p_48187_3_, double p_48187_5_, float p_48187_7_) {
      this.field_46039_b = p_48187_1_;
      this.field_46040_c = p_48187_3_;
      this.field_46037_d = p_48187_5_;
      this.field_46038_e = p_48187_7_;
      this.field_46036_f = true;
   }

   public void func_46034_a() {
      this.field_46041_a.func_46010_f(0.0F);
      if(this.field_46036_f) {
         this.field_46036_f = false;
         int var1 = MathHelper.func_1108_b(this.field_46041_a.field_601_au.field_1697_b + 0.5D);
         double var2 = this.field_46039_b - this.field_46041_a.field_611_ak;
         double var4 = this.field_46037_d - this.field_46041_a.field_609_am;
         double var6 = this.field_46040_c - (double)var1;
         double var8 = var2 * var2 + var6 * var6 + var4 * var4;
         if(var8 >= 2.500000277905201E-7D) {
            float var10 = (float)(Math.atan2(var4, var2) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.field_46041_a.field_605_aq = this.func_48185_a(this.field_46041_a.field_605_aq, var10, 30.0F);
            this.field_46041_a.func_48098_g(this.field_46038_e);
            if(var6 > 0.0D && var2 * var2 + var4 * var4 < 1.0D) {
               this.field_46041_a.func_46005_aI().func_46129_a();
            }

         }
      }
   }

   private float func_48185_a(float p_48185_1_, float p_48185_2_, float p_48185_3_) {
      float var4;
      for(var4 = p_48185_2_ - p_48185_1_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      if(var4 > p_48185_3_) {
         var4 = p_48185_3_;
      }

      if(var4 < -p_48185_3_) {
         var4 = -p_48185_3_;
      }

      return p_48185_1_ + var4;
   }
}
