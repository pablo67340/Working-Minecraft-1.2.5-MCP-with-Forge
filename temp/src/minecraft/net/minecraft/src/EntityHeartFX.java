package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityHeartFX extends EntityFX {

   float field_25022_a;


   public EntityHeartFX(World p_i767_1_, double p_i767_2_, double p_i767_4_, double p_i767_6_, double p_i767_8_, double p_i767_10_, double p_i767_12_) {
      this(p_i767_1_, p_i767_2_, p_i767_4_, p_i767_6_, p_i767_8_, p_i767_10_, p_i767_12_, 2.0F);
   }

   public EntityHeartFX(World p_i768_1_, double p_i768_2_, double p_i768_4_, double p_i768_6_, double p_i768_8_, double p_i768_10_, double p_i768_12_, float p_i768_14_) {
      super(p_i768_1_, p_i768_2_, p_i768_4_, p_i768_6_, 0.0D, 0.0D, 0.0D);
      this.field_608_an *= 0.009999999776482582D;
      this.field_607_ao *= 0.009999999776482582D;
      this.field_606_ap *= 0.009999999776482582D;
      this.field_607_ao += 0.1D;
      this.field_665_g *= 0.75F;
      this.field_665_g *= p_i768_14_;
      this.field_25022_a = this.field_665_g;
      this.field_666_f = 16;
      this.field_9314_ba = false;
      this.func_40099_c(80);
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_665_g = this.field_25022_a * var8;
      super.func_406_a(p_406_1_, p_406_2_, p_406_3_, p_406_4_, p_406_5_, p_406_6_, p_406_7_);
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      if(this.field_610_al == this.field_9284_au) {
         this.field_608_an *= 1.1D;
         this.field_606_ap *= 1.1D;
      }

      this.field_608_an *= 0.8600000143051147D;
      this.field_607_ao *= 0.8600000143051147D;
      this.field_606_ap *= 0.8600000143051147D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
