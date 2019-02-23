package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;

public class EntityAISwimming extends EntityAIBase {

   private EntityLiving field_46106_a;


   public EntityAISwimming(EntityLiving p_i154_1_) {
      this.field_46106_a = p_i154_1_;
      this.func_46079_a(4);
      p_i154_1_.func_48084_aL().func_48669_e(true);
   }

   public boolean func_46082_a() {
      return this.field_46106_a.func_27013_ag() || this.field_46106_a.func_359_G();
   }

   public void func_46081_b() {
      if(this.field_46106_a.func_46004_aK().nextFloat() < 0.8F) {
         this.field_46106_a.func_46005_aI().func_46129_a();
      }

   }
}
