package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityFX extends Entity {

   private int field_670_b;
   protected float field_669_c;
   protected float field_668_d;
   protected int field_20923_e = 0;
   protected int field_666_f = 0;
   protected float field_665_g;
   protected float field_664_h;
   protected float field_663_i;
   protected float field_662_j;
   protected float field_661_k;
   public static double field_660_l;
   public static double field_659_m;
   public static double field_658_n;


   public EntityFX(World p_i579_1_, double p_i579_2_, double p_i579_4_, double p_i579_6_, double p_i579_8_, double p_i579_10_, double p_i579_12_) {
      super(p_i579_1_);
      this.func_371_a(0.2F, 0.2F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
      this.func_347_a(p_i579_2_, p_i579_4_, p_i579_6_);
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
      this.field_608_an = p_i579_8_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
      this.field_607_ao = p_i579_10_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
      this.field_606_ap = p_i579_12_ + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
      float var14 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
      float var15 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_607_ao * this.field_607_ao + this.field_606_ap * this.field_606_ap);
      this.field_608_an = this.field_608_an / (double)var15 * (double)var14 * 0.4000000059604645D;
      this.field_607_ao = this.field_607_ao / (double)var15 * (double)var14 * 0.4000000059604645D + 0.10000000149011612D;
      this.field_606_ap = this.field_606_ap / (double)var15 * (double)var14 * 0.4000000059604645D;
      this.field_669_c = this.field_9312_bd.nextFloat() * 3.0F;
      this.field_668_d = this.field_9312_bd.nextFloat() * 3.0F;
      this.field_665_g = (this.field_9312_bd.nextFloat() * 0.5F + 0.5F) * 2.0F;
      this.field_666_f = (int)(4.0F / (this.field_9312_bd.nextFloat() * 0.9F + 0.1F));
      this.field_20923_e = 0;
   }

   public EntityFX func_407_b(float p_407_1_) {
      this.field_608_an *= (double)p_407_1_;
      this.field_607_ao = (this.field_607_ao - 0.10000000149011612D) * (double)p_407_1_ + 0.10000000149011612D;
      this.field_606_ap *= (double)p_407_1_;
      return this;
   }

   public EntityFX func_405_d(float p_405_1_) {
      this.func_371_a(0.2F * p_405_1_, 0.2F * p_405_1_);
      this.field_665_g *= p_405_1_;
      return this;
   }

   public void func_40097_b(float p_40097_1_, float p_40097_2_, float p_40097_3_) {
      this.field_663_i = p_40097_1_;
      this.field_662_j = p_40097_2_;
      this.field_661_k = p_40097_3_;
   }

   public float func_40098_n() {
      return this.field_663_i;
   }

   public float func_40101_o() {
      return this.field_662_j;
   }

   public float func_40102_p() {
      return this.field_661_k;
   }

   protected boolean func_25021_m() {
      return false;
   }

   protected void func_21057_b() {}

   public void func_370_e_() {
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      if(this.field_20923_e++ >= this.field_666_f) {
         this.func_395_F();
      }

      this.field_607_ao -= 0.04D * (double)this.field_664_h;
      this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
      this.field_608_an *= 0.9800000190734863D;
      this.field_607_ao *= 0.9800000190734863D;
      this.field_606_ap *= 0.9800000190734863D;
      if(this.field_9298_aH) {
         this.field_608_an *= 0.699999988079071D;
         this.field_606_ap *= 0.699999988079071D;
      }

   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = (float)(this.field_670_b % 16) / 16.0F;
      float var9 = var8 + 0.0624375F;
      float var10 = (float)(this.field_670_b / 16) / 16.0F;
      float var11 = var10 + 0.0624375F;
      float var12 = 0.1F * this.field_665_g;
      float var13 = (float)(this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)p_406_2_ - field_660_l);
      float var14 = (float)(this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)p_406_2_ - field_659_m);
      float var15 = (float)(this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)p_406_2_ - field_658_n);
      float var16 = 1.0F;
      p_406_1_.func_987_a(this.field_663_i * var16, this.field_662_j * var16, this.field_661_k * var16);
      p_406_1_.func_983_a((double)(var13 - p_406_3_ * var12 - p_406_6_ * var12), (double)(var14 - p_406_4_ * var12), (double)(var15 - p_406_5_ * var12 - p_406_7_ * var12), (double)var9, (double)var11);
      p_406_1_.func_983_a((double)(var13 - p_406_3_ * var12 + p_406_6_ * var12), (double)(var14 + p_406_4_ * var12), (double)(var15 - p_406_5_ * var12 + p_406_7_ * var12), (double)var9, (double)var10);
      p_406_1_.func_983_a((double)(var13 + p_406_3_ * var12 + p_406_6_ * var12), (double)(var14 + p_406_4_ * var12), (double)(var15 + p_406_5_ * var12 + p_406_7_ * var12), (double)var8, (double)var10);
      p_406_1_.func_983_a((double)(var13 + p_406_3_ * var12 - p_406_6_ * var12), (double)(var14 - p_406_4_ * var12), (double)(var15 + p_406_5_ * var12 - p_406_7_ * var12), (double)var8, (double)var11);
   }

   public int func_404_c() {
      return 0;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {}

   public void func_357_b(NBTTagCompound p_357_1_) {}

   public void func_40099_c(int p_40099_1_) {
      this.field_670_b = p_40099_1_;
   }

   public int func_40100_q() {
      return this.field_670_b;
   }

   public boolean func_48080_j() {
      return false;
   }
}
