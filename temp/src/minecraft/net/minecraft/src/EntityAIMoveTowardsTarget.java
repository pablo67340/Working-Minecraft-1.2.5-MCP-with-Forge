package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;

public class EntityAIMoveTowardsTarget extends EntityAIBase {

   private EntityCreature field_48336_a;
   private EntityLiving field_48334_b;
   private double field_48335_c;
   private double field_48332_d;
   private double field_48333_e;
   private float field_48330_f;
   private float field_48331_g;


   public EntityAIMoveTowardsTarget(EntityCreature p_i1090_1_, float p_i1090_2_, float p_i1090_3_) {
      this.field_48336_a = p_i1090_1_;
      this.field_48330_f = p_i1090_2_;
      this.field_48331_g = p_i1090_3_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      this.field_48334_b = this.field_48336_a.func_48094_aS();
      if(this.field_48334_b == null) {
         return false;
      } else if(this.field_48334_b.func_387_e(this.field_48336_a) > (double)(this.field_48331_g * this.field_48331_g)) {
         return false;
      } else {
         Vec3D var1 = RandomPositionGenerator.func_48620_a(this.field_48336_a, 16, 7, Vec3D.func_1248_b(this.field_48334_b.field_611_ak, this.field_48334_b.field_610_al, this.field_48334_b.field_609_am));
         if(var1 == null) {
            return false;
         } else {
            this.field_48335_c = var1.field_1776_a;
            this.field_48332_d = var1.field_1775_b;
            this.field_48333_e = var1.field_1779_c;
            return true;
         }
      }
   }

   public boolean func_46084_g() {
      return !this.field_48336_a.func_48084_aL().func_46072_b() && this.field_48334_b.func_354_B() && this.field_48334_b.func_387_e(this.field_48336_a) < (double)(this.field_48331_g * this.field_48331_g);
   }

   public void func_46077_d() {
      this.field_48334_b = null;
   }

   public void func_46080_e() {
      this.field_48336_a.func_48084_aL().func_48666_a(this.field_48335_c, this.field_48332_d, this.field_48333_e, this.field_48330_f);
   }
}
