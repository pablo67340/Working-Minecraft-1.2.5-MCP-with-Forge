package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityTameable;

public class EntityAISit extends EntityAIBase {

   private EntityTameable field_48409_a;
   private boolean field_48408_b = false;


   public EntityAISit(EntityTameable p_i1035_1_) {
      this.field_48409_a = p_i1035_1_;
      this.func_46079_a(5);
   }

   public boolean func_46082_a() {
      if(!this.field_48409_a.func_48139_F_()) {
         return false;
      } else if(this.field_48409_a.func_27013_ag()) {
         return false;
      } else if(!this.field_48409_a.field_9298_aH) {
         return false;
      } else {
         EntityLiving var1 = this.field_48409_a.func_48144_ah();
         return var1 == null?true:(this.field_48409_a.func_387_e(var1) < 144.0D && var1.func_46007_aL() != null?false:this.field_48408_b);
      }
   }

   public void func_46080_e() {
      this.field_48409_a.func_48084_aL().func_48672_f();
      this.field_48409_a.func_48140_f(true);
   }

   public void func_46077_d() {
      this.field_48409_a.func_48140_f(false);
   }

   public void func_48407_a(boolean p_48407_1_) {
      this.field_48408_b = p_48407_1_;
   }
}
