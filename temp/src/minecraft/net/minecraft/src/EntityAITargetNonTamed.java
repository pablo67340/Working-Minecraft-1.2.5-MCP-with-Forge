package net.minecraft.src;

import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityTameable;

public class EntityAITargetNonTamed extends EntityAINearestAttackableTarget {

   private EntityTameable field_48390_g;


   public EntityAITargetNonTamed(EntityTameable p_i1010_1_, Class p_i1010_2_, float p_i1010_3_, int p_i1010_4_, boolean p_i1010_5_) {
      super(p_i1010_1_, p_i1010_2_, p_i1010_3_, p_i1010_4_, p_i1010_5_);
      this.field_48390_g = p_i1010_1_;
   }

   public boolean func_46082_a() {
      return this.field_48390_g.func_48139_F_()?false:super.func_46082_a();
   }
}
