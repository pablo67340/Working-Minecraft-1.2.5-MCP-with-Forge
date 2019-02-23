package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityLavaFX extends EntityFX {

   private float field_674_a;


   public EntityLavaFX(World p_i294_1_, double p_i294_2_, double p_i294_4_, double p_i294_6_) {
      super(p_i294_1_, p_i294_2_, p_i294_4_, p_i294_6_, 0.0D, 0.0D, 0.0D);
      this.field_608_an *= 0.800000011920929D;
      this.field_607_ao *= 0.800000011920929D;
      this.field_606_ap *= 0.800000011920929D;
      this.field_607_ao = (double)(this.field_9312_bd.nextFloat() * 0.4F + 0.05F);
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
      this.field_665_g *= this.field_9312_bd.nextFloat() * 2.0F + 0.2F;
      this.field_674_a = this.field_665_g;
      this.field_666_f = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
      this.field_9314_ba = false;
      this.func_40099_c(49);
   }

   public int func_35115_a(float p_35115_1_) {
      float var2 = ((float)this.field_20923_e + p_35115_1_) / (float)this.field_666_f;
      if(var2 < 0.0F) {
         var2 = 0.0F;
      }

      if(var2 > 1.0F) {
         var2 = 1.0F;
      }

      int var3 = super.func_35115_a(p_35115_1_);
      short var4 = 240;
      int var5 = var3 >> 16 & 255;
      return var4 | var5 << 16;
   }

   public float func_382_a(float p_382_1_) {
      return 1.0F;
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f;
      this.field_665_g = this.field_674_a * (1.0F - var8 * var8);
      super.func_406_a(p_406_1_, p_406_2_, p_406_3_, p_406_4_, p_406_5_, p_406_6_, p_406_7_);
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

      float var1 = (float)this.field_20923_e / (float)this.field_666_f;
      if(this.field_9312_bd.nextFloat() > var1) {
         this.field_615_ag.func_694_a("smoke", this.field_611_ak, this.field_610_al, this.field_609_am, this.field_608_an, this.field_607_ao, this.field_606_ap);
      }

      this.field_607_ao -= 0.03D;
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.9990000128746033D;
      this.field_607_ao *= 0.9990000128746033D;
      this.field_606_ap *= 0.9990000128746033D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
