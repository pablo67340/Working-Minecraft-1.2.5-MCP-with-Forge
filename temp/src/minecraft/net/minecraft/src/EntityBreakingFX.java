package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityFX;
import net.minecraft.src.Item;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;

public class EntityBreakingFX extends EntityFX {

   public EntityBreakingFX(World p_i426_1_, double p_i426_2_, double p_i426_4_, double p_i426_6_, Item p_i426_8_) {
      super(p_i426_1_, p_i426_2_, p_i426_4_, p_i426_6_, 0.0D, 0.0D, 0.0D);
      this.func_40099_c(p_i426_8_.func_27009_a(0));
      this.field_663_i = this.field_662_j = this.field_661_k = 1.0F;
      this.field_664_h = Block.field_426_aV.field_357_bm;
      this.field_665_g /= 2.0F;
   }

   public EntityBreakingFX(World p_i427_1_, double p_i427_2_, double p_i427_4_, double p_i427_6_, double p_i427_8_, double p_i427_10_, double p_i427_12_, Item p_i427_14_) {
      this(p_i427_1_, p_i427_2_, p_i427_4_, p_i427_6_, p_i427_14_);
      this.field_608_an *= 0.10000000149011612D;
      this.field_607_ao *= 0.10000000149011612D;
      this.field_606_ap *= 0.10000000149011612D;
      this.field_608_an += p_i427_8_;
      this.field_607_ao += p_i427_10_;
      this.field_606_ap += p_i427_12_;
   }

   public int func_404_c() {
      return 2;
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
