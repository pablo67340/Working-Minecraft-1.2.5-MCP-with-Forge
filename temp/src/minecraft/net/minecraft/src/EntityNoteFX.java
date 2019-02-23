package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityNoteFX extends EntityFX {

   float field_21065_a;


   public EntityNoteFX(World p_i2_1_, double p_i2_2_, double p_i2_4_, double p_i2_6_, double p_i2_8_, double p_i2_10_, double p_i2_12_) {
      this(p_i2_1_, p_i2_2_, p_i2_4_, p_i2_6_, p_i2_8_, p_i2_10_, p_i2_12_, 2.0F);
   }

   public EntityNoteFX(World p_i3_1_, double p_i3_2_, double p_i3_4_, double p_i3_6_, double p_i3_8_, double p_i3_10_, double p_i3_12_, float p_i3_14_) {
      super(p_i3_1_, p_i3_2_, p_i3_4_, p_i3_6_, 0.0D, 0.0D, 0.0D);
      this.field_608_an *= 0.009999999776482582D;
      this.field_607_ao *= 0.009999999776482582D;
      this.field_606_ap *= 0.009999999776482582D;
      this.field_607_ao += 0.2D;
      this.field_663_i = MathHelper.func_1106_a(((float)p_i3_8_ + 0.0F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
      this.field_662_j = MathHelper.func_1106_a(((float)p_i3_8_ + 0.33333334F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
      this.field_661_k = MathHelper.func_1106_a(((float)p_i3_8_ + 0.6666667F) * 3.1415927F * 2.0F) * 0.65F + 0.35F;
      this.field_665_g *= 0.75F;
      this.field_665_g *= p_i3_14_;
      this.field_21065_a = this.field_665_g;
      this.field_666_f = 6;
      this.field_9314_ba = false;
      this.func_40099_c(64);
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f * 32.0F;
      if(var8 < 0.0F) {
         var8 = 0.0F;
      }

      if(var8 > 1.0F) {
         var8 = 1.0F;
      }

      this.field_665_g = this.field_21065_a * var8;
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

      this.field_608_an *= 0.6600000262260437D;
      this.field_607_ao *= 0.6600000262260437D;
      this.field_606_ap *= 0.6600000262260437D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
