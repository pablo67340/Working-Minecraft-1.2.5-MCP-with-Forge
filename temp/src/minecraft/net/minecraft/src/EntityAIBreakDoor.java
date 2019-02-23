package net.minecraft.src;

import net.minecraft.src.EntityAIDoorInteract;
import net.minecraft.src.EntityLiving;

public class EntityAIBreakDoor extends EntityAIDoorInteract {

   private int field_48329_i;


   public EntityAIBreakDoor(EntityLiving p_i1071_1_) {
      super(p_i1071_1_);
   }

   public boolean func_46082_a() {
      return !super.func_46082_a()?false:!this.field_48322_e.func_48213_h(this.field_48325_a.field_615_ag, this.field_48323_b, this.field_48324_c, this.field_48321_d);
   }

   public void func_46080_e() {
      super.func_46080_e();
      this.field_48329_i = 240;
   }

   public boolean func_46084_g() {
      double var1 = this.field_48325_a.func_360_d((double)this.field_48323_b, (double)this.field_48324_c, (double)this.field_48321_d);
      return this.field_48329_i >= 0 && !this.field_48322_e.func_48213_h(this.field_48325_a.field_615_ag, this.field_48323_b, this.field_48324_c, this.field_48321_d) && var1 < 4.0D;
   }

   public void func_46081_b() {
      super.func_46081_b();
      if(this.field_48325_a.func_46004_aK().nextInt(20) == 0) {
         this.field_48325_a.field_615_ag.func_28106_e(1010, this.field_48323_b, this.field_48324_c, this.field_48321_d, 0);
      }

      if(--this.field_48329_i == 0 && this.field_48325_a.field_615_ag.field_1039_l == 3) {
         this.field_48325_a.field_615_ag.func_690_d(this.field_48323_b, this.field_48324_c, this.field_48321_d, 0);
         this.field_48325_a.field_615_ag.func_28106_e(1012, this.field_48323_b, this.field_48324_c, this.field_48321_d, 0);
         this.field_48325_a.field_615_ag.func_28106_e(2001, this.field_48323_b, this.field_48324_c, this.field_48321_d, this.field_48322_e.field_376_bc);
      }

   }
}
