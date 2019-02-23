package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntitySnowShovelFX extends EntityFX {

   float field_27017_a;


   public EntitySnowShovelFX(World p_i393_1_, double p_i393_2_, double p_i393_4_, double p_i393_6_, double p_i393_8_, double p_i393_10_, double p_i393_12_) {
      this(p_i393_1_, p_i393_2_, p_i393_4_, p_i393_6_, p_i393_8_, p_i393_10_, p_i393_12_, 1.0F);
   }

   public EntitySnowShovelFX(World p_i394_1_, double p_i394_2_, double p_i394_4_, double p_i394_6_, double p_i394_8_, double p_i394_10_, double p_i394_12_, float p_i394_14_) {
      super(p_i394_1_, p_i394_2_, p_i394_4_, p_i394_6_, p_i394_8_, p_i394_10_, p_i394_12_);
      this.field_608_an *= 0.10000000149011612D;
      this.field_607_ao *= 0.10000000149011612D;
      this.field_606_ap *= 0.10000000149011612D;
      this.field_608_an += p_i394_8_;
      this.field_607_ao += p_i394_10_;
      this.field_606_ap += p_i394_12_;
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F - (float)(Math.random() * 0.30000001192092896D);
      this.field_665_g *= 0.75F;
      this.field_665_g *= p_i394_14_;
      this.field_27017_a = this.field_665_g;
      this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.field_666_f = (int)((float)this.field_666_f * p_i394_14_);
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

      this.field_665_g = this.field_27017_a * var8;
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
      this.field_607_ao -= 0.03D;
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.9900000095367432D;
      this.field_607_ao *= 0.9900000095367432D;
      this.field_606_ap *= 0.9900000095367432D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
