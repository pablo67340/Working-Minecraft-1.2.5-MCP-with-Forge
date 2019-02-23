package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityBlaze;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntitySnowball extends EntityThrowable {

   public EntitySnowball(World p_i631_1_) {
      super(p_i631_1_);
   }

   public EntitySnowball(World p_i632_1_, EntityLiving p_i632_2_) {
      super(p_i632_1_, p_i632_2_);
   }

   public EntitySnowball(World p_i633_1_, double p_i633_2_, double p_i633_4_, double p_i633_6_) {
      super(p_i633_1_, p_i633_2_, p_i633_4_, p_i633_6_);
   }

   protected void func_40078_a(MovingObjectPosition p_40078_1_) {
      if(p_40078_1_.field_1168_g != null) {
         byte var2 = 0;
         if(p_40078_1_.field_1168_g instanceof EntityBlaze) {
            var2 = 3;
         }

         if(p_40078_1_.field_1168_g.func_396_a(DamageSource.func_35524_a(this, this.field_40083_c), var2)) {
            ;
         }
      }

      for(int var3 = 0; var3 < 8; ++var3) {
         this.field_615_ag.func_694_a("snowballpoof", this.field_611_ak, this.field_610_al, this.field_609_am, 0.0D, 0.0D, 0.0D);
      }

      if(!this.field_615_ag.field_1026_y) {
         this.func_395_F();
      }

   }
}
