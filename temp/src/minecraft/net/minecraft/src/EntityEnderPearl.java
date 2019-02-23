package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntityEnderPearl extends EntityThrowable {

   public EntityEnderPearl(World p_i47_1_) {
      super(p_i47_1_);
   }

   public EntityEnderPearl(World p_i48_1_, EntityLiving p_i48_2_) {
      super(p_i48_1_, p_i48_2_);
   }

   public EntityEnderPearl(World p_i49_1_, double p_i49_2_, double p_i49_4_, double p_i49_6_) {
      super(p_i49_1_, p_i49_2_, p_i49_4_, p_i49_6_);
   }

   protected void func_40078_a(MovingObjectPosition p_40078_1_) {
      if(p_40078_1_.field_1168_g != null && p_40078_1_.field_1168_g.func_396_a(DamageSource.func_35524_a(this, this.field_40083_c), 0)) {
         ;
      }

      for(int var2 = 0; var2 < 32; ++var2) {
         this.field_615_ag.func_694_a("portal", this.field_611_ak, this.field_610_al + this.field_9312_bd.nextDouble() * 2.0D, this.field_609_am, this.field_9312_bd.nextGaussian(), 0.0D, this.field_9312_bd.nextGaussian());
      }

      if(!this.field_615_ag.field_1026_y) {
         if(this.field_40083_c != null) {
            this.field_40083_c.func_40113_j(this.field_611_ak, this.field_610_al, this.field_609_am);
            this.field_40083_c.field_9288_aU = 0.0F;
            this.field_40083_c.func_396_a(DamageSource.field_35549_h, 5);
         }

         this.func_395_F();
      }

   }
}
