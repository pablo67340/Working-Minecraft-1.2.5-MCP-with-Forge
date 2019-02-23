package net.minecraft.src;

import net.minecraft.src.EntityCreature;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public abstract class EntityGolem extends EntityCreature {

   public EntityGolem(World p_i1018_1_) {
      super(p_i1018_1_);
   }

   protected void func_400_c(float p_400_1_) {}

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected String func_6389_d() {
      return "none";
   }

   protected String func_6394_f_() {
      return "none";
   }

   protected String func_6390_f() {
      return "none";
   }

   public int func_421_b() {
      return 120;
   }

   protected boolean func_25023_u() {
      return false;
   }
}
