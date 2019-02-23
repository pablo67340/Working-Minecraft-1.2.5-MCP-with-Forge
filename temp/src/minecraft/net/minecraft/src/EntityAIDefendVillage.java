package net.minecraft.src;

import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Village;

public class EntityAIDefendVillage extends EntityAITarget {

   EntityIronGolem field_48385_a;
   EntityLiving field_48384_b;


   public EntityAIDefendVillage(EntityIronGolem p_i1040_1_) {
      super(p_i1040_1_, 16.0F, false, true);
      this.field_48385_a = p_i1040_1_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      Village var1 = this.field_48385_a.func_48113_aa();
      if(var1 == null) {
         return false;
      } else {
         this.field_48384_b = var1.func_48537_b(this.field_48385_a);
         return this.func_48376_a(this.field_48384_b, false);
      }
   }

   public void func_46080_e() {
      this.field_48385_a.func_48092_c(this.field_48384_b);
      super.func_46080_e();
   }
}
