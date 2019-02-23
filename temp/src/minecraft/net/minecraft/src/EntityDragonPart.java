package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDragonBase;
import net.minecraft.src.NBTTagCompound;

public class EntityDragonPart extends Entity {

   public final EntityDragonBase field_40073_a;
   public final String field_40072_b;


   public EntityDragonPart(EntityDragonBase p_i283_1_, String p_i283_2_, float p_i283_3_, float p_i283_4_) {
      super(p_i283_1_.field_615_ag);
      this.func_371_a(p_i283_3_, p_i283_4_);
      this.field_40073_a = p_i283_1_;
      this.field_40072_b = p_i283_2_;
   }

   protected void func_21057_b() {}

   protected void func_357_b(NBTTagCompound p_357_1_) {}

   protected void func_352_a(NBTTagCompound p_352_1_) {}

   public boolean func_401_c_() {
      return true;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      return this.field_40073_a.func_40156_a(this, p_396_1_, p_396_2_);
   }

   public boolean func_41004_h(Entity p_41004_1_) {
      return this == p_41004_1_ || this.field_40073_a == p_41004_1_;
   }
}
