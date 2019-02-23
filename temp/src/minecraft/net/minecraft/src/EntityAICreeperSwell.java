package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityLiving;

public class EntityAICreeperSwell extends EntityAIBase {

   EntityCreeper field_48237_a;
   EntityLiving field_48236_b;


   public EntityAICreeperSwell(EntityCreeper p_i1009_1_) {
      this.field_48237_a = p_i1009_1_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      EntityLiving var1 = this.field_48237_a.func_48094_aS();
      return this.field_48237_a.func_21091_q() > 0 || var1 != null && this.field_48237_a.func_387_e(var1) < 9.0D;
   }

   public void func_46080_e() {
      this.field_48237_a.func_48084_aL().func_48672_f();
      this.field_48236_b = this.field_48237_a.func_48094_aS();
   }

   public void func_46077_d() {
      this.field_48236_b = null;
   }

   public void func_46081_b() {
      if(this.field_48236_b == null) {
         this.field_48237_a.func_21090_e(-1);
      } else if(this.field_48237_a.func_387_e(this.field_48236_b) > 49.0D) {
         this.field_48237_a.func_21090_e(-1);
      } else if(!this.field_48237_a.func_48090_aM().func_48480_a(this.field_48236_b)) {
         this.field_48237_a.func_21090_e(-1);
      } else {
         this.field_48237_a.func_21090_e(1);
      }
   }
}
