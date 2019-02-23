package net.minecraft.src;

import net.minecraft.src.EntityLiving;

public class EntityJumpHelper {

   private EntityLiving field_46132_a;
   private boolean field_46131_b = false;


   public EntityJumpHelper(EntityLiving p_i64_1_) {
      this.field_46132_a = p_i64_1_;
   }

   public void func_46129_a() {
      this.field_46131_b = true;
   }

   public void func_46130_b() {
      this.field_46132_a.func_46003_g(this.field_46131_b);
      this.field_46131_b = false;
   }
}
