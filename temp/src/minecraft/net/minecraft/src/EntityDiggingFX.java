package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityDiggingFX extends EntityFX {

   private Block field_4082_a;


   public EntityDiggingFX(World p_i446_1_, double p_i446_2_, double p_i446_4_, double p_i446_6_, double p_i446_8_, double p_i446_10_, double p_i446_12_, Block p_i446_14_, int p_i446_15_, int p_i446_16_) {
      super(p_i446_1_, p_i446_2_, p_i446_4_, p_i446_6_, p_i446_8_, p_i446_10_, p_i446_12_);
      this.field_4082_a = p_i446_14_;
      this.func_40099_c(p_i446_14_.func_232_a(0, p_i446_16_));
      this.field_664_h = p_i446_14_.field_357_bm;
      this.field_663_i = this.field_662_j = this.field_661_k = 0.6F;
      this.field_665_g /= 2.0F;
   }

   public EntityDiggingFX func_4041_a(int p_4041_1_, int p_4041_2_, int p_4041_3_) {
      if(this.field_4082_a == Block.field_337_v) {
         return this;
      } else {
         int var4 = this.field_4082_a.func_207_d(this.field_615_ag, p_4041_1_, p_4041_2_, p_4041_3_);
         this.field_663_i *= (float)(var4 >> 16 & 255) / 255.0F;
         this.field_662_j *= (float)(var4 >> 8 & 255) / 255.0F;
         this.field_661_k *= (float)(var4 & 255) / 255.0F;
         return this;
      }
   }

   public int func_404_c() {
      return 1;
   }

   public void func_406_a(Tessellator p_406_1_, float p_406_2_, float p_406_3_, float p_406_4_, float p_406_5_, float p_406_6_, float p_406_7_) {
      float var8 = ((float)(this.func_40100_q() % 16) + this.field_669_c / 4.0F) / 16.0F;
      float var9 = var8 + 0.015609375F;
      float var10 = ((float)(this.func_40100_q() / 16) + this.field_668_d / 4.0F) / 16.0F;
      float var11 = var10 + 0.015609375F;
      float var12 = 0.1F * this.field_665_g;
      float var13 = (float)(this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)p_406_2_ - field_660_l);
      float var14 = (float)(this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)p_406_2_ - field_659_m);
      float var15 = (float)(this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)p_406_2_ - field_658_n);
      float var16 = 1.0F;
      p_406_1_.func_987_a(var16 * this.field_663_i, var16 * this.field_662_j, var16 * this.field_661_k);
      p_406_1_.func_983_a((double)(var13 - p_406_3_ * var12 - p_406_6_ * var12), (double)(var14 - p_406_4_ * var12), (double)(var15 - p_406_5_ * var12 - p_406_7_ * var12), (double)var8, (double)var11);
      p_406_1_.func_983_a((double)(var13 - p_406_3_ * var12 + p_406_6_ * var12), (double)(var14 + p_406_4_ * var12), (double)(var15 - p_406_5_ * var12 + p_406_7_ * var12), (double)var8, (double)var10);
      p_406_1_.func_983_a((double)(var13 + p_406_3_ * var12 + p_406_6_ * var12), (double)(var14 + p_406_4_ * var12), (double)(var15 + p_406_5_ * var12 + p_406_7_ * var12), (double)var9, (double)var10);
      p_406_1_.func_983_a((double)(var13 + p_406_3_ * var12 - p_406_6_ * var12), (double)(var14 - p_406_4_ * var12), (double)(var15 + p_406_5_ * var12 - p_406_7_ * var12), (double)var9, (double)var11);
   }
}
