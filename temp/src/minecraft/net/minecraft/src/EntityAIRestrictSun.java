package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;

public class EntityAIRestrictSun extends EntityAIBase {

   private EntityCreature field_48235_a;


   public EntityAIRestrictSun(EntityCreature p_i1017_1_) {
      this.field_48235_a = p_i1017_1_;
   }

   public boolean func_46082_a() {
      return this.field_48235_a.field_615_ag.func_624_b();
   }

   public void func_46080_e() {
      this.field_48235_a.func_48084_aL().func_48680_d(true);
   }

   public void func_46077_d() {
      this.field_48235_a.func_48084_aL().func_48680_d(false);
   }
}
