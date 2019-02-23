package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;

public class EntityAILookIdle extends EntityAIBase {

   private EntityLiving field_46089_a;
   private double field_46087_b;
   private double field_46088_c;
   private int field_46086_d = 0;


   public EntityAILookIdle(EntityLiving p_i240_1_) {
      this.field_46089_a = p_i240_1_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      return this.field_46089_a.func_46004_aK().nextFloat() < 0.02F;
   }

   public boolean func_46084_g() {
      return this.field_46086_d >= 0;
   }

   public void func_46080_e() {
      double var1 = 6.283185307179586D * this.field_46089_a.func_46004_aK().nextDouble();
      this.field_46087_b = Math.cos(var1);
      this.field_46088_c = Math.sin(var1);
      this.field_46086_d = 20 + this.field_46089_a.func_46004_aK().nextInt(20);
   }

   public void func_46081_b() {
      --this.field_46086_d;
      this.field_46089_a.func_46008_aG().func_46143_a(this.field_46089_a.field_611_ak + this.field_46087_b, this.field_46089_a.field_610_al + (double)this.field_46089_a.func_373_s(), this.field_46089_a.field_609_am + this.field_46088_c, 10.0F, (float)this.field_46089_a.func_25026_x());
   }
}
