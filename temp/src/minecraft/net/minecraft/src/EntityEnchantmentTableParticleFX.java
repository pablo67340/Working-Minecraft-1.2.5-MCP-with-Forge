package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.World;

public class EntityEnchantmentTableParticleFX extends EntityFX {

   private float field_40107_a;
   private double field_40109_aw;
   private double field_40108_ax;
   private double field_40106_ay;


   public EntityEnchantmentTableParticleFX(World p_i80_1_, double p_i80_2_, double p_i80_4_, double p_i80_6_, double p_i80_8_, double p_i80_10_, double p_i80_12_) {
      super(p_i80_1_, p_i80_2_, p_i80_4_, p_i80_6_, p_i80_8_, p_i80_10_, p_i80_12_);
      this.field_608_an = p_i80_8_;
      this.field_607_ao = p_i80_10_;
      this.field_606_ap = p_i80_12_;
      this.field_40109_aw = this.field_611_ak = p_i80_2_;
      this.field_40108_ax = this.field_610_al = p_i80_4_;
      this.field_40106_ay = this.field_609_am = p_i80_6_;
      float var14 = this.field_9312_bd.nextFloat() * 0.6F + 0.4F;
      this.field_40107_a = this.field_665_g = this.field_9312_bd.nextFloat() * 0.5F + 0.2F;
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F * var14;
      this.field_662_j *= 0.9F;
      this.field_663_i *= 0.9F;
      this.field_666_f = (int)(Math.random() * 10.0D) + 30;
      this.field_9314_ba = true;
      this.func_40099_c((int)(Math.random() * 26.0D + 1.0D + 224.0D));
   }

   public int func_35115_a(float p_35115_1_) {
      int var2 = super.func_35115_a(p_35115_1_);
      float var3 = (float)this.field_20923_e / (float)this.field_666_f;
      var3 *= var3;
      var3 *= var3;
      int var4 = var2 & 255;
      int var5 = var2 >> 16 & 255;
      var5 += (int)(var3 * 15.0F * 16.0F);
      if(var5 > 240) {
         var5 = 240;
      }

      return var4 | var5 << 16;
   }

   public float func_382_a(float p_382_1_) {
      float var2 = super.func_382_a(p_382_1_);
      float var3 = (float)this.field_20923_e / (float)this.field_666_f;
      var3 *= var3;
      var3 *= var3;
      return var2 * (1.0F - var3) + var3;
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      float var1 = (float)this.field_20923_e / (float)this.field_666_f;
      var1 = 1.0F - var1;
      float var2 = 1.0F - var1;
      var2 *= var2;
      var2 *= var2;
      this.field_611_ak = this.field_40109_aw + this.field_608_an * (double)var1;
      this.field_610_al = this.field_40108_ax + this.field_607_ao * (double)var1 - (double)(var2 * 1.2F);
      this.field_609_am = this.field_40106_ay + this.field_606_ap * (double)var1;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

   }
}
