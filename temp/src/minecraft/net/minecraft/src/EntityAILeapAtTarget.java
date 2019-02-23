package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;

public class EntityAILeapAtTarget extends EntityAIBase {

   EntityLiving field_48252_a;
   EntityLiving field_48250_b;
   float field_48251_c;


   public EntityAILeapAtTarget(EntityLiving p_i1029_1_, float p_i1029_2_) {
      this.field_48252_a = p_i1029_1_;
      this.field_48251_c = p_i1029_2_;
      this.func_46079_a(5);
   }

   public boolean func_46082_a() {
      this.field_48250_b = this.field_48252_a.func_48094_aS();
      if(this.field_48250_b == null) {
         return false;
      } else {
         double var1 = this.field_48252_a.func_387_e(this.field_48250_b);
         return var1 >= 4.0D && var1 <= 16.0D?(!this.field_48252_a.field_9298_aH?false:this.field_48252_a.func_46004_aK().nextInt(5) == 0):false;
      }
   }

   public boolean func_46084_g() {
      return !this.field_48252_a.field_9298_aH;
   }

   public void func_46080_e() {
      double var1 = this.field_48250_b.field_611_ak - this.field_48252_a.field_611_ak;
      double var3 = this.field_48250_b.field_609_am - this.field_48252_a.field_609_am;
      float var5 = MathHelper.func_1109_a(var1 * var1 + var3 * var3);
      this.field_48252_a.field_608_an += var1 / (double)var5 * 0.5D * 0.800000011920929D + this.field_48252_a.field_608_an * 0.20000000298023224D;
      this.field_48252_a.field_606_ap += var3 / (double)var5 * 0.5D * 0.800000011920929D + this.field_48252_a.field_606_ap * 0.20000000298023224D;
      this.field_48252_a.field_607_ao = (double)this.field_48251_c;
   }
}
