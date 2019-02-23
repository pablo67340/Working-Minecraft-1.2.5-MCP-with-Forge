package net.minecraft.src;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityThrowable;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;

public class EntityExpBottle extends EntityThrowable {

   public EntityExpBottle(World p_i1041_1_) {
      super(p_i1041_1_);
   }

   public EntityExpBottle(World p_i1042_1_, EntityLiving p_i1042_2_) {
      super(p_i1042_1_, p_i1042_2_);
   }

   public EntityExpBottle(World p_i1043_1_, double p_i1043_2_, double p_i1043_4_, double p_i1043_6_) {
      super(p_i1043_1_, p_i1043_2_, p_i1043_4_, p_i1043_6_);
   }

   protected float func_40075_e() {
      return 0.07F;
   }

   protected float func_40077_c() {
      return 0.7F;
   }

   protected float func_40074_d() {
      return -20.0F;
   }

   protected void func_40078_a(MovingObjectPosition p_40078_1_) {
      if(!this.field_615_ag.field_1026_y) {
         this.field_615_ag.func_28106_e(2002, (int)Math.round(this.field_611_ak), (int)Math.round(this.field_610_al), (int)Math.round(this.field_609_am), 0);
         int var2 = 3 + this.field_615_ag.field_1037_n.nextInt(5) + this.field_615_ag.field_1037_n.nextInt(5);

         while(var2 > 0) {
            int var3 = EntityXPOrb.func_35121_b(var2);
            var2 -= var3;
            this.field_615_ag.func_674_a(new EntityXPOrb(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, var3));
         }

         this.func_395_F();
      }

   }
}
