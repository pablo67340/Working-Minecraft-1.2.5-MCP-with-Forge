package net.minecraft.src;

import net.minecraft.src.EntityLiving;

public class EntityBodyHelper {

   private EntityLiving field_48654_a;
   private int field_48652_b = 0;
   private float field_48653_c = 0.0F;


   public EntityBodyHelper(EntityLiving p_i1075_1_) {
      this.field_48654_a = p_i1075_1_;
   }

   public void func_48650_a() {
      double var1 = this.field_48654_a.field_611_ak - this.field_48654_a.field_9285_at;
      double var3 = this.field_48654_a.field_609_am - this.field_48654_a.field_9283_av;
      if(var1 * var1 + var3 * var3 > 2.500000277905201E-7D) {
         this.field_48654_a.field_735_n = this.field_48654_a.field_605_aq;
         this.field_48654_a.field_46015_bf = this.func_48651_a(this.field_48654_a.field_735_n, this.field_48654_a.field_46015_bf, 75.0F);
         this.field_48653_c = this.field_48654_a.field_46015_bf;
         this.field_48652_b = 0;
      } else {
         float var5 = 75.0F;
         if(Math.abs(this.field_48654_a.field_46015_bf - this.field_48653_c) > 15.0F) {
            this.field_48652_b = 0;
            this.field_48653_c = this.field_48654_a.field_46015_bf;
         } else {
            ++this.field_48652_b;
            if(this.field_48652_b > 10) {
               var5 = Math.max(1.0F - (float)(this.field_48652_b - 10) / 10.0F, 0.0F) * 75.0F;
            }
         }

         this.field_48654_a.field_735_n = this.func_48651_a(this.field_48654_a.field_46015_bf, this.field_48654_a.field_735_n, var5);
      }
   }

   private float func_48651_a(float p_48651_1_, float p_48651_2_, float p_48651_3_) {
      float var4;
      for(var4 = p_48651_1_ - p_48651_2_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      if(var4 < -p_48651_3_) {
         var4 = -p_48651_3_;
      }

      if(var4 >= p_48651_3_) {
         var4 = p_48651_3_;
      }

      return p_48651_1_ - var4;
   }
}
