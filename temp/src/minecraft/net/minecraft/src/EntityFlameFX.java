package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityFlameFX extends EntityFX {

   private float field_672_a;


   public EntityFlameFX(World p_i454_1_, double p_i454_2_, double p_i454_4_, double p_i454_6_, double p_i454_8_, double p_i454_10_, double p_i454_12_) {
      super(p_i454_1_, p_i454_2_, p_i454_4_, p_i454_6_, p_i454_8_, p_i454_10_, p_i454_12_);
      this.field_608_an = this.field_608_an * 0.009999999776482582D + p_i454_8_;
      this.field_607_ao = this.field_607_ao * 0.009999999776482582D + p_i454_10_;
      this.field_606_ap = this.field_606_ap * 0.009999999776482582D + p_i454_12_;
      double var10000 = p_i454_2_ + (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.05F);
      var10000 = p_i454_4_ + (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.05F);
      var10000 = p_i454_6_ + (double)((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.05F);
      this.field_672_a = this.field_665_g;
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
      this.field_666_f = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
      this.field_9314_ba = true;
      this.func_40099_c(48);
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f;
      this.field_665_g = this.field_672_a * (1.0F - var8 * var8 * 0.5F);
      super.func_406_a(p_406_1_, p_406_2_, p_406_3_, p_406_4_, p_406_5_, p_406_6_, p_406_7_);
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
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if(var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public float func_382_a(float p_382_1_) {
      float var2 = ((float)this.field_20923_e + p_382_1_) / (float)this.field_666_f;
      if(var2 < 0.0F) {
         var2 = 0.0F;
      }

      if(var2 > 1.0F) {
         var2 = 1.0F;
      }

      float var3 = super.func_382_a(p_382_1_);
      return var3 * var2 + (1.0F - var2);
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.9599999785423279D;
      this.field_607_ao *= 0.9599999785423279D;
      this.field_606_ap *= 0.9599999785423279D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }
}
