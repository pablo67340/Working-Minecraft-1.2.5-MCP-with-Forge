package net.minecraft.src;

import net.minecraft.src.BlockFluid;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityDropParticleFX extends EntityFX {

   private Material field_40103_a;
   private int field_40104_aw;


   public EntityDropParticleFX(World p_i334_1_, double p_i334_2_, double p_i334_4_, double p_i334_6_, Material p_i334_8_) {
      super(p_i334_1_, p_i334_2_, p_i334_4_, p_i334_6_, 0.0D, 0.0D, 0.0D);
      this.field_608_an = this.field_607_ao = this.field_606_ap = 0.0D;
      if(p_i334_8_ == Material.field_1332_f) {
         this.field_663_i = 0.0F;
         this.field_662_j = 0.0F;
         this.field_661_k = 1.0F;
      } else {
         this.field_663_i = 1.0F;
         this.field_662_j = 0.0F;
         this.field_661_k = 0.0F;
      }

      this.func_40099_c(113);
      this.func_371_a(0.01F, 0.01F);
      this.field_664_h = 0.06F;
      this.field_40103_a = p_i334_8_;
      this.field_40104_aw = 40;
      this.field_666_f = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
      this.field_608_an = this.field_607_ao = this.field_606_ap = 0.0D;
   }

   public int func_35115_a(float p_35115_1_) {
      return this.field_40103_a == Material.field_1332_f?super.func_35115_a(p_35115_1_):257;
   }

   public float func_382_a(float p_382_1_) {
      return this.field_40103_a == Material.field_1332_f?super.func_382_a(p_382_1_):1.0F;
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      if(this.field_40103_a == Material.field_1332_f) {
         this.field_663_i = 0.2F;
         this.field_662_j = 0.3F;
         this.field_661_k = 1.0F;
      } else {
         this.field_663_i = 1.0F;
         this.field_662_j = 16.0F / (float)(40 - this.field_40104_aw + 16);
         this.field_661_k = 4.0F / (float)(40 - this.field_40104_aw + 8);
      }

      this.field_607_ao -= (double)this.field_664_h;
      if(this.field_40104_aw-- > 0) {
         this.field_608_an *= 0.02D;
         this.field_607_ao *= 0.02D;
         this.field_606_ap *= 0.02D;
         this.func_40099_c(113);
      } else {
         this.func_40099_c(112);
      }

      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.9800000190734863D;
      this.field_607_ao *= 0.9800000190734863D;
      this.field_606_ap *= 0.9800000190734863D;
      if(this.field_666_f-- <= 0) {
         this.func_395_F();
      }

      if(this.field_9298_aH) {
         if(this.field_40103_a == Material.field_1332_f) {
            this.func_395_F();
            this.field_615_ag.func_694_a("splash", this.field_611_ak, this.field_610_al, this.field_609_am, 0.0D, 0.0D, 0.0D);
         } else {
            this.func_40099_c(114);
         }

         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

      Material var1 = this.field_615_ag.func_599_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
      if(var1.func_879_d() || var1.func_878_a()) {
         double var2 = (double)((float)(MathHelper.func_1108_b(this.field_610_al) + 1) - BlockFluid.func_288_b(this.field_615_ag.func_602_e(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am))));
         if(this.field_610_al < var2) {
            this.func_395_F();
         }
      }

   }
}
