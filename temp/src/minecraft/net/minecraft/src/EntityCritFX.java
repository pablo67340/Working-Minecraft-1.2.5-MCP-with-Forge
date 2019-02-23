package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityCritFX extends EntityFX {

   float field_35137_a;


   public EntityCritFX(World p_i591_1_, double p_i591_2_, double p_i591_4_, double p_i591_6_, double p_i591_8_, double p_i591_10_, double p_i591_12_) {
      this(p_i591_1_, p_i591_2_, p_i591_4_, p_i591_6_, p_i591_8_, p_i591_10_, p_i591_12_, 1.0F);
   }

   public EntityCritFX(World p_i592_1_, double p_i592_2_, double p_i592_4_, double p_i592_6_, double p_i592_8_, double p_i592_10_, double p_i592_12_, float p_i592_14_) {
      super(p_i592_1_, p_i592_2_, p_i592_4_, p_i592_6_, 0.0D, 0.0D, 0.0D);
      this.field_608_an *= 0.10000000149011612D;
      this.field_607_ao *= 0.10000000149011612D;
      this.field_606_ap *= 0.10000000149011612D;
      this.field_608_an += p_i592_8_ * 0.4D;
      this.field_607_ao += p_i592_10_ * 0.4D;
      this.field_606_ap += p_i592_12_ * 0.4D;
      this.field_663_i = this.field_662_j = this.field_661_k = (float)(Math.random() * 0.30000001192092896D + 0.6000000238418579D);
      this.field_665_g *= 0.75F;
      this.field_665_g *= p_i592_14_;
      this.field_35137_a = this.field_665_g;
      this.field_666_f = (int)(6.0D / (Math.random() * 0.8D + 0.6D));
      this.field_666_f = (int)((float)this.field_666_f * p_i592_14_);
      this.field_9314_ba = false;
      this.func_40099_c(65);
      this.func_370_e_();
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_665_g = this.field_35137_a * var8;
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
      this.field_662_j = (float)((double)this.field_662_j * 0.96D);
      this.field_661_k = (float)((double)this.field_661_k * 0.9D);
      this.field_608_an *= 0.699999988079071D;
      this.field_607_ao *= 0.699999988079071D;
      this.field_606_ap *= 0.699999988079071D;
      this.field_607_ao -= 0.019999999552965164D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
