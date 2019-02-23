package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;

public class EntityAIWatchClosest extends EntityAIBase {

   private EntityLiving field_46105_a;
   private Entity field_48295_b;
   private float field_46101_d;
   private int field_46102_e;
   private float field_48294_e;
   private Class field_48293_f;


   public EntityAIWatchClosest(EntityLiving p_i1056_1_, Class p_i1056_2_, float p_i1056_3_) {
      this.field_46105_a = p_i1056_1_;
      this.field_48293_f = p_i1056_2_;
      this.field_46101_d = p_i1056_3_;
      this.field_48294_e = 0.02F;
      this.func_46079_a(2);
   }

   public EntityAIWatchClosest(EntityLiving p_i1057_1_, Class p_i1057_2_, float p_i1057_3_, float p_i1057_4_) {
      this.field_46105_a = p_i1057_1_;
      this.field_48293_f = p_i1057_2_;
      this.field_46101_d = p_i1057_3_;
      this.field_48294_e = p_i1057_4_;
      this.func_46079_a(2);
   }

   public boolean func_46082_a() {
      if(this.field_46105_a.func_46004_aK().nextFloat() >= this.field_48294_e) {
         return false;
      } else {
         if(this.field_48293_f == EntityPlayer.class) {
            this.field_48295_b = this.field_46105_a.field_615_ag.func_609_a(this.field_46105_a, (double)this.field_46101_d);
         } else {
            this.field_48295_b = this.field_46105_a.field_615_ag.func_48459_a(this.field_48293_f, this.field_46105_a.field_601_au.func_1177_b((double)this.field_46101_d, 3.0D, (double)this.field_46101_d), this.field_46105_a);
         }

         return this.field_48295_b != null;
      }
   }

   public boolean func_46084_g() {
      return !this.field_48295_b.func_354_B()?false:(this.field_46105_a.func_387_e(this.field_48295_b) > (double)(this.field_46101_d * this.field_46101_d)?false:this.field_46102_e > 0);
   }

   public void func_46080_e() {
      this.field_46102_e = 40 + this.field_46105_a.func_46004_aK().nextInt(40);
   }

   public void func_46077_d() {
      this.field_48295_b = null;
   }

   public void func_46081_b() {
      this.field_46105_a.func_46008_aG().func_46143_a(this.field_48295_b.field_611_ak, this.field_48295_b.field_610_al + (double)this.field_48295_b.func_373_s(), this.field_48295_b.field_609_am, 10.0F, (float)this.field_46105_a.func_25026_x());
      --this.field_46102_e;
   }
}
