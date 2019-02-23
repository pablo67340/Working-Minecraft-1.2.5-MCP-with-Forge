package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityDragonPart;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.World;

public class EntityDragonBase extends EntityLiving {

   protected int field_40157_aB = 100;


   public EntityDragonBase(World p_i163_1_) {
      super(p_i163_1_);
   }

   public int func_40117_c() {
      return this.field_40157_aB;
   }

   public boolean func_40156_a(EntityDragonPart p_40156_1_, DamageSource p_40156_2_, int p_40156_3_) {
      return this.func_396_a(p_40156_2_, p_40156_3_);
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      return false;
   }

   protected boolean func_40155_e(DamageSource p_40155_1_, int p_40155_2_) {
      return super.func_396_a(p_40155_1_, p_40155_2_);
   }
}
