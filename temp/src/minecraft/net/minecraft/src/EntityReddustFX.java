package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityReddustFX extends EntityFX {

   float field_673_a;


   public EntityReddustFX(World p_i732_1_, double p_i732_2_, double p_i732_4_, double p_i732_6_, float p_i732_8_, float p_i732_9_, float p_i732_10_) {
      this(p_i732_1_, p_i732_2_, p_i732_4_, p_i732_6_, 1.0F, p_i732_8_, p_i732_9_, p_i732_10_);
   }

   public EntityReddustFX(World p_i733_1_, double p_i733_2_, double p_i733_4_, double p_i733_6_, float p_i733_8_, float p_i733_9_, float p_i733_10_, float p_i733_11_) {
      super(p_i733_1_, p_i733_2_, p_i733_4_, p_i733_6_, 0.0D, 0.0D, 0.0D);
      this.field_608_an *= 0.10000000149011612D;
      this.field_607_ao *= 0.10000000149011612D;
      this.field_606_ap *= 0.10000000149011612D;
      if(p_i733_9_ == 0.0F) {
         p_i733_9_ = 1.0F;
      }

      float var12 = (float)Math.random() * 0.4F + 0.6F;
      this.field_663_i = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i733_9_ * var12;
      this.field_662_j = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i733_10_ * var12;
      this.field_661_k = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * p_i733_11_ * var12;
      this.field_665_g *= 0.75F;
      this.field_665_g *= p_i733_8_;
      this.field_673_a = this.field_665_g;
      this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.field_666_f = (int)((float)this.field_666_f * p_i733_8_);
      this.field_9314_ba = false;
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_665_g = this.field_673_a * var8;
      super.func_406_a(p_406_1_, p_406_2_, p_406_3_, p_406_4_, p_406_5_, p_406_6_, p_406_7_);
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

      this.func_40099_c(7 - this.field_20923_e * 8 / this.field_666_f);
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      if(this.field_610_al == this.field_9284_au) {
         this.field_608_an *= 1.1D;
         this.field_606_ap *= 1.1D;
      }

      this.field_608_an *= 0.9599999785423279D;
      this.field_607_ao *= 0.9599999785423279D;
      this.field_606_ap *= 0.9599999785423279D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
