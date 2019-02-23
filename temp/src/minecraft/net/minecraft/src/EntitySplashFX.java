package net.minecraft.src;

import net.minecraft.src.EntityRainFX;
import net.minecraft.src.World;

public class EntitySplashFX extends EntityRainFX {

   public EntitySplashFX(World p_i486_1_, double p_i486_2_, double p_i486_4_, double p_i486_6_, double p_i486_8_, double p_i486_10_, double p_i486_12_) {
      super(p_i486_1_, p_i486_2_, p_i486_4_, p_i486_6_);
      this.field_664_h = 0.04F;
      this.func_40099_c(this.func_40100_q() + 1);
      if(p_i486_10_ == 0.0D && (p_i486_8_ != 0.0D || p_i486_12_ != 0.0D)) {
         this.field_608_an = p_i486_8_;
         this.field_607_ao = p_i486_10_ + 0.1D;
         this.field_606_ap = p_i486_12_;
      }

   }
}
