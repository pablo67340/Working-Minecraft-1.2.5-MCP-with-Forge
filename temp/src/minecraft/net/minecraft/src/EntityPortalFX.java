package net.minecraft.src;

import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityPortalFX extends EntityFX {

   private float field_4083_a;
   private double field_4086_p;
   private double field_4085_q;
   private double field_4084_r;


   public EntityPortalFX(World p_i68_1_, double p_i68_2_, double p_i68_4_, double p_i68_6_, double p_i68_8_, double p_i68_10_, double p_i68_12_) {
      super(p_i68_1_, p_i68_2_, p_i68_4_, p_i68_6_, p_i68_8_, p_i68_10_, p_i68_12_);
      this.field_608_an = p_i68_8_;
      this.field_607_ao = p_i68_10_;
      this.field_606_ap = p_i68_12_;
      this.field_4086_p = this.field_611_ak = p_i68_2_;
      this.field_4085_q = this.field_610_al = p_i68_4_;
      this.field_4084_r = this.field_609_am = p_i68_6_;
      float var14 = this.field_9312_bd.nextFloat() * 0.6F + 0.4F;
      this.field_4083_a = this.field_665_g = this.field_9312_bd.nextFloat() * 0.2F + 0.5F;
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F * var14;
      this.field_662_j *= 0.3F;
      this.field_663_i *= 0.9F;
      this.field_666_f = (int)(Math.random() * 10.0D) + 40;
      this.field_9314_ba = true;
      this.func_40099_c((int)(Math.random() * 8.0D));
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)this.field_20923_e + p_406_2_) / (float)this.field_666_f;
      var8 = 1.0F - var8;
      var8 *= var8;
      var8 = 1.0F - var8;
      this.field_665_g = this.field_4083_a * var8;
      super.func_406_a(p_406_1_, p_406_2_, p_406_3_, p_406_4_, p_406_5_, p_406_6_, p_406_7_);
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
      var3 = var3 * var3 * var3 * var3;
      return var2 * (1.0F - var3) + var3;
   }

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      float var1 = (float)this.field_20923_e / (float)this.field_666_f;
      float var2 = var1;
      var1 = -var1 + var1 * var1 * 2.0F;
      var1 = 1.0F - var1;
      this.field_611_ak = this.field_4086_p + this.field_608_an * (double)var1;
      this.field_610_al = this.field_4085_q + this.field_607_ao * (double)var1 + (double)(1.0F - var2);
      this.field_609_am = this.field_4084_r + this.field_606_ap * (double)var1;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

   }
}
