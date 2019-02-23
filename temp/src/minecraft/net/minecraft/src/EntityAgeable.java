package net.minecraft.src;

import net.minecraft.src.EntityCreature;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public abstract class EntityAgeable extends EntityCreature {

   public EntityAgeable(World p_i1016_1_) {
      super(p_i1016_1_);
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(12, new Integer(0));
   }

   public int func_48123_at() {
      return this.field_21064_bx.func_25115_b(12);
   }

   public void func_48122_d(int p_48122_1_) {
      this.field_21064_bx.func_21129_b(12, Integer.valueOf(p_48122_1_));
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_758_a("Age", this.func_48123_at());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_48122_d(p_357_1_.func_756_e("Age"));
   }

   public void func_425_j() {
      super.func_425_j();
      int var1 = this.func_48123_at();
      if(var1 < 0) {
         ++var1;
         this.func_48122_d(var1);
      } else if(var1 > 0) {
         --var1;
         this.func_48122_d(var1);
      }

   }

   public boolean func_40127_l() {
      return this.func_48123_at() < 0;
   }
}
