package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;

public class EntityLookHelper {

   private EntityLiving field_46151_a;
   private float field_46149_b;
   private float field_46150_c;
   private boolean field_46147_d = false;
   private double field_46148_e;
   private double field_46145_f;
   private double field_46146_g;


   public EntityLookHelper(EntityLiving p_i655_1_) {
      this.field_46151_a = p_i655_1_;
   }

   public void func_46141_a(Entity p_46141_1_, float p_46141_2_, float p_46141_3_) {
      this.field_46148_e = p_46141_1_.field_611_ak;
      if(p_46141_1_ instanceof EntityLiving) {
         this.field_46145_f = p_46141_1_.field_610_al + (double)((EntityLiving)p_46141_1_).func_373_s();
      } else {
         this.field_46145_f = (p_46141_1_.field_601_au.field_1697_b + p_46141_1_.field_601_au.field_1702_e) / 2.0D;
      }

      this.field_46146_g = p_46141_1_.field_609_am;
      this.field_46149_b = p_46141_2_;
      this.field_46150_c = p_46141_3_;
      this.field_46147_d = true;
   }

   public void func_46143_a(double p_46143_1_, double p_46143_3_, double p_46143_5_, float p_46143_7_, float p_46143_8_) {
      this.field_46148_e = p_46143_1_;
      this.field_46145_f = p_46143_3_;
      this.field_46146_g = p_46143_5_;
      this.field_46149_b = p_46143_7_;
      this.field_46150_c = p_46143_8_;
      this.field_46147_d = true;
   }

   public void func_46142_a() {
      this.field_46151_a.field_604_ar = 0.0F;
      if(this.field_46147_d) {
         this.field_46147_d = false;
         double var1 = this.field_46148_e - this.field_46151_a.field_611_ak;
         double var3 = this.field_46145_f - (this.field_46151_a.field_610_al + (double)this.field_46151_a.func_373_s());
         double var5 = this.field_46146_g - this.field_46151_a.field_609_am;
         double var7 = (double)MathHelper.func_1109_a(var1 * var1 + var5 * var5);
         float var9 = (float)(Math.atan2(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var10 = (float)(-(Math.atan2(var3, var7) * 180.0D / 3.1415927410125732D));
         this.field_46151_a.field_604_ar = this.func_46144_a(this.field_46151_a.field_604_ar, var10, this.field_46150_c);
         this.field_46151_a.field_46015_bf = this.func_46144_a(this.field_46151_a.field_46015_bf, var9, this.field_46149_b);
      } else {
         this.field_46151_a.field_46015_bf = this.func_46144_a(this.field_46151_a.field_46015_bf, this.field_46151_a.field_735_n, 10.0F);
      }

      float var11;
      for(var11 = this.field_46151_a.field_46015_bf - this.field_46151_a.field_735_n; var11 < -180.0F; var11 += 360.0F) {
         ;
      }

      while(var11 >= 180.0F) {
         var11 -= 360.0F;
      }

      if(!this.field_46151_a.func_48084_aL().func_46072_b()) {
         if(var11 < -75.0F) {
            this.field_46151_a.field_46015_bf = this.field_46151_a.field_735_n - 75.0F;
         }

         if(var11 > 75.0F) {
            this.field_46151_a.field_46015_bf = this.field_46151_a.field_735_n + 75.0F;
         }
      }

   }

   private float func_46144_a(float p_46144_1_, float p_46144_2_, float p_46144_3_) {
      float var4;
      for(var4 = p_46144_2_ - p_46144_1_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      if(var4 > p_46144_3_) {
         var4 = p_46144_3_;
      }

      if(var4 < -p_46144_3_) {
         var4 = -p_46144_3_;
      }

      return p_46144_1_ + var4;
   }
}
