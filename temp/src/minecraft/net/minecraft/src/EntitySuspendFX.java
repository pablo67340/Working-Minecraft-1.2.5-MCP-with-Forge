package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntitySuspendFX extends EntityFX {

   public EntitySuspendFX(World p_i424_1_, double p_i424_2_, double p_i424_4_, double p_i424_6_, double p_i424_8_, double p_i424_10_, double p_i424_12_) {
      super(p_i424_1_, p_i424_2_, p_i424_4_ - 0.125D, p_i424_6_, p_i424_8_, p_i424_10_, p_i424_12_);
      this.field_663_i = 0.4F;
      this.field_662_j = 0.4F;
      this.field_661_k = 0.7F;
      this.func_40099_c(0);
      this.func_371_a(0.01F, 0.01F);
      this.field_665_g *= this.field_9312_bd.nextFloat() * 0.6F + 0.2F;
      this.field_608_an = p_i424_8_ * 0.0D;
      this.field_607_ao = p_i424_10_ * 0.0D;
      this.field_606_ap = p_i424_12_ * 0.0D;
      this.field_666_f = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      if(this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) != Material.field_1332_f) {
         this.func_395_F();
      }

      if(this.field_666_f-- <= 0) {
         this.func_395_F();
      }

   }
}
