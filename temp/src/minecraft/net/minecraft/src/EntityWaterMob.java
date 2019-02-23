package net.minecraft.src;

import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public abstract class EntityWaterMob extends EntityCreature {

   public EntityWaterMob(World p_i613_1_) {
      super(p_i613_1_);
   }

   public boolean func_21067_c_() {
      return true;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   public boolean func_433_a() {
      return this.field_615_ag.func_604_a(this.field_601_au);
   }

   public int func_421_b() {
      return 120;
   }

   protected boolean func_25023_u() {
      return true;
   }

   protected int func_36001_a(EntityPlayer p_36001_1_) {
      return 1 + this.field_615_ag.field_1037_n.nextInt(3);
   }
}
