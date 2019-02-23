package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;

public class EntityDamageSource extends DamageSource {

   protected Entity field_35552_n;


   public EntityDamageSource(String p_i322_1_, Entity p_i322_2_) {
      super(p_i322_1_);
      this.field_35552_n = p_i322_2_;
   }

   public Entity func_35532_a() {
      return this.field_35552_n;
   }
}
