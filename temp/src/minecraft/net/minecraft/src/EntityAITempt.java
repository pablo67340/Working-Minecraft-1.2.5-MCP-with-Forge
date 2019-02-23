package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;

public class EntityAITempt extends EntityAIBase {

   private EntityCreature field_48277_a;
   private float field_48275_b;
   private double field_48276_c;
   private double field_48273_d;
   private double field_48274_e;
   private double field_48271_f;
   private double field_48272_g;
   private EntityPlayer field_48282_h;
   private int field_48283_i = 0;
   private boolean field_48280_j;
   private int field_48281_k;
   private boolean field_48278_l;
   private boolean field_48279_m;


   public EntityAITempt(EntityCreature p_i1020_1_, float p_i1020_2_, int p_i1020_3_, boolean p_i1020_4_) {
      this.field_48277_a = p_i1020_1_;
      this.field_48275_b = p_i1020_2_;
      this.field_48281_k = p_i1020_3_;
      this.field_48278_l = p_i1020_4_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      if(this.field_48283_i > 0) {
         --this.field_48283_i;
         return false;
      } else {
         this.field_48282_h = this.field_48277_a.field_615_ag.func_609_a(this.field_48277_a, 10.0D);
         if(this.field_48282_h == null) {
            return false;
         } else {
            ItemStack var1 = this.field_48282_h.func_6416_v();
            return var1 == null?false:var1.field_1617_c == this.field_48281_k;
         }
      }
   }

   public boolean func_46084_g() {
      if(this.field_48278_l) {
         if(this.field_48277_a.func_387_e(this.field_48282_h) < 36.0D) {
            if(this.field_48282_h.func_360_d(this.field_48276_c, this.field_48273_d, this.field_48274_e) > 0.010000000000000002D) {
               return false;
            }

            if(Math.abs((double)this.field_48282_h.field_604_ar - this.field_48271_f) > 5.0D || Math.abs((double)this.field_48282_h.field_605_aq - this.field_48272_g) > 5.0D) {
               return false;
            }
         } else {
            this.field_48276_c = this.field_48282_h.field_611_ak;
            this.field_48273_d = this.field_48282_h.field_610_al;
            this.field_48274_e = this.field_48282_h.field_609_am;
         }

         this.field_48271_f = (double)this.field_48282_h.field_604_ar;
         this.field_48272_g = (double)this.field_48282_h.field_605_aq;
      }

      return this.func_46082_a();
   }

   public void func_46080_e() {
      this.field_48276_c = this.field_48282_h.field_611_ak;
      this.field_48273_d = this.field_48282_h.field_610_al;
      this.field_48274_e = this.field_48282_h.field_609_am;
      this.field_48280_j = true;
      this.field_48279_m = this.field_48277_a.func_48084_aL().func_48658_a();
      this.field_48277_a.func_48084_aL().func_48664_a(false);
   }

   public void func_46077_d() {
      this.field_48282_h = null;
      this.field_48277_a.func_48084_aL().func_48672_f();
      this.field_48283_i = 100;
      this.field_48280_j = false;
      this.field_48277_a.func_48084_aL().func_48664_a(this.field_48279_m);
   }

   public void func_46081_b() {
      this.field_48277_a.func_46008_aG().func_46141_a(this.field_48282_h, 30.0F, (float)this.field_48277_a.func_25026_x());
      if(this.field_48277_a.func_387_e(this.field_48282_h) < 6.25D) {
         this.field_48277_a.func_48084_aL().func_48672_f();
      } else {
         this.field_48277_a.func_48084_aL().func_48667_a(this.field_48282_h, this.field_48275_b);
      }

   }

   public boolean func_48270_h() {
      return this.field_48280_j;
   }
}
