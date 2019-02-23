package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityAIOcelotAttack extends EntityAIBase {

   World field_48363_a;
   EntityLiving field_48361_b;
   EntityLiving field_48362_c;
   int field_48360_d = 0;


   public EntityAIOcelotAttack(EntityLiving p_i1073_1_) {
      this.field_48361_b = p_i1073_1_;
      this.field_48363_a = p_i1073_1_.field_615_ag;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      EntityLiving var1 = this.field_48361_b.func_48094_aS();
      if(var1 == null) {
         return false;
      } else {
         this.field_48362_c = var1;
         return true;
      }
   }

   public boolean func_46084_g() {
      return !this.field_48362_c.func_354_B()?false:(this.field_48361_b.func_387_e(this.field_48362_c) > 225.0D?false:!this.field_48361_b.func_48084_aL().func_46072_b() || this.func_46082_a());
   }

   public void func_46077_d() {
      this.field_48362_c = null;
      this.field_48361_b.func_48084_aL().func_48672_f();
   }

   public void func_46081_b() {
      this.field_48361_b.func_46008_aG().func_46141_a(this.field_48362_c, 30.0F, 30.0F);
      double var1 = (double)(this.field_48361_b.field_644_aC * 2.0F * this.field_48361_b.field_644_aC * 2.0F);
      double var3 = this.field_48361_b.func_360_d(this.field_48362_c.field_611_ak, this.field_48362_c.field_601_au.field_1697_b, this.field_48362_c.field_609_am);
      float var5 = 0.23F;
      if(var3 > var1 && var3 < 16.0D) {
         var5 = 0.4F;
      } else if(var3 < 225.0D) {
         var5 = 0.18F;
      }

      this.field_48361_b.func_48084_aL().func_48667_a(this.field_48362_c, var5);
      this.field_48360_d = Math.max(this.field_48360_d - 1, 0);
      if(var3 <= var1) {
         if(this.field_48360_d <= 0) {
            this.field_48360_d = 20;
            this.field_48361_b.func_35175_b(this.field_48362_c);
         }
      }
   }
}
