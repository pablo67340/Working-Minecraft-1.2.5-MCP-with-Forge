package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntityEgg extends EntityThrowable {

   public EntityEgg(World p_i539_1_) {
      super(p_i539_1_);
   }

   public EntityEgg(World p_i540_1_, EntityLiving p_i540_2_) {
      super(p_i540_1_, p_i540_2_);
   }

   public EntityEgg(World p_i541_1_, double p_i541_2_, double p_i541_4_, double p_i541_6_) {
      super(p_i541_1_, p_i541_2_, p_i541_4_, p_i541_6_);
   }

   protected void func_40078_a(MovingObjectPosition p_40078_1_) {
      if(p_40078_1_.field_1168_g != null && p_40078_1_.field_1168_g.func_396_a(DamageSource.func_35524_a(this, this.field_40083_c), 0)) {
         ;
      }

      if(!this.field_615_ag.field_1026_y && this.field_9312_bd.nextInt(8) == 0) {
         byte var2 = 1;
         if(this.field_9312_bd.nextInt(32) == 0) {
            var2 = 4;
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            EntityChicken var4 = new EntityChicken(this.field_615_ag);
            var4.func_48122_d(-24000);
            var4.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, 0.0F);
            this.field_615_ag.func_674_a(var4);
         }
      }

      for(int var5 = 0; var5 < 8; ++var5) {
         this.field_615_ag.func_694_a("snowballpoof", this.field_611_ak, this.field_610_al, this.field_609_am, 0.0D, 0.0D, 0.0D);
      }

      if(!this.field_615_ag.field_1026_y) {
         this.func_395_F();
      }

   }
}
