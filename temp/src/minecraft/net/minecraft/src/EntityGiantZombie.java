package net.minecraft.src;

import net.minecraft.src.EntityMob;
import net.minecraft.src.World;

public class EntityGiantZombie extends EntityMob {

   public EntityGiantZombie(World p_i410_1_) {
      super(p_i410_1_);
      this.field_9357_z = "/mob/zombie.png";
      this.field_9333_am = 0.5F;
      this.field_762_e = 50;
      this.field_9292_aO *= 6.0F;
      this.func_371_a(this.field_644_aC * 6.0F, this.field_643_aD * 6.0F);
   }

   public int func_40117_c() {
      return 100;
   }

   public float func_439_a(int p_439_1_, int p_439_2_, int p_439_3_) {
      return this.field_615_ag.func_598_c(p_439_1_, p_439_2_, p_439_3_) - 0.5F;
   }
}
