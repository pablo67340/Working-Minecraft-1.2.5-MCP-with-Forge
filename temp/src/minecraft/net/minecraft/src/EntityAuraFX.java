package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.World;

public class EntityAuraFX extends EntityFX {

   public EntityAuraFX(World p_i691_1_, double p_i691_2_, double p_i691_4_, double p_i691_6_, double p_i691_8_, double p_i691_10_, double p_i691_12_) {
      super(p_i691_1_, p_i691_2_, p_i691_4_, p_i691_6_, p_i691_8_, p_i691_10_, p_i691_12_);
      float var14 = this.field_9312_bd.nextFloat() * 0.1F + 0.2F;
      this.field_663_i = var14;
      this.field_662_j = var14;
      this.field_661_k = var14;
      this.func_40099_c(0);
      this.func_371_a(0.02F, 0.02F);
      this.field_665_g *= this.field_9312_bd.nextFloat() * 0.6F + 0.5F;
      this.field_608_an *= 0.019999999552965164D;
      this.field_607_ao *= 0.019999999552965164D;
      this.field_606_ap *= 0.019999999552965164D;
      this.field_666_f = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
      this.field_9314_ba = true;
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.99D;
      this.field_607_ao *= 0.99D;
      this.field_606_ap *= 0.99D;
      if(this.field_666_f-- <= 0) {
         this.func_395_F();
      }

   }
}
