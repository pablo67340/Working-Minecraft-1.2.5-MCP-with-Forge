package net.minecraft.src;

import net.minecraft.src.EntityAIDoorInteract;
import net.minecraft.src.EntityLiving;

public class EntityAIOpenDoor extends EntityAIDoorInteract {

   boolean field_48328_i;
   int field_48327_j;


   public EntityAIOpenDoor(EntityLiving p_i1003_1_, boolean p_i1003_2_) {
      super(p_i1003_1_);
      this.field_48325_a = p_i1003_1_;
      this.field_48328_i = p_i1003_2_;
   }

   public boolean func_46084_g() {
      return this.field_48328_i && this.field_48327_j > 0 && super.func_46084_g();
   }

   public void func_46080_e() {
      this.field_48327_j = 20;
      this.field_48322_e.func_311_a(this.field_48325_a.field_615_ag, this.field_48323_b, this.field_48324_c, this.field_48321_d, true);
   }

   public void func_46077_d() {
      if(this.field_48328_i) {
         this.field_48322_e.func_311_a(this.field_48325_a.field_615_ag, this.field_48323_b, this.field_48324_c, this.field_48321_d, false);
      }

   }

   public void func_46081_b() {
      --this.field_48327_j;
      super.func_46081_b();
   }
}
