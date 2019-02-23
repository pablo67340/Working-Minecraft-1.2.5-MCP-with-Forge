package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityDamageSource;

public class EntityDamageSourceIndirect extends EntityDamageSource {

   private Entity field_35553_n;


   public EntityDamageSourceIndirect(String p_i331_1_, Entity p_i331_2_, Entity p_i331_3_) {
      super(p_i331_1_, p_i331_2_);
      this.field_35553_n = p_i331_3_;
   }

   public Entity func_35526_e() {
      return this.field_35552_n;
   }

   public Entity func_35532_a() {
      return this.field_35553_n;
   }
}
