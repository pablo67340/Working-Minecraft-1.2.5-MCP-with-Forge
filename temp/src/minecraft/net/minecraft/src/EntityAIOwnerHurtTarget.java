package net.minecraft.src;

import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityTameable;

public class EntityAIOwnerHurtTarget extends EntityAITarget {

   EntityTameable field_48392_a;
   EntityLiving field_48391_b;


   public EntityAIOwnerHurtTarget(EntityTameable p_i1091_1_) {
      super(p_i1091_1_, 32.0F, false);
      this.field_48392_a = p_i1091_1_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(!this.field_48392_a.func_48139_F_()) {
         return false;
      } else {
         EntityLiving var1 = this.field_48392_a.func_48144_ah();
         if(var1 == null) {
            return false;
         } else {
            this.field_48391_b = var1.func_48088_aP();
            return this.func_48376_a(this.field_48391_b, false);
         }
      }
   }

   public void func_46080_e() {
      this.field_48382_c.func_48092_c(this.field_48391_b);
      super.func_46080_e();
   }
}
