package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Village;
import net.minecraft.src.World;

public class EntityAIVillagerMate extends EntityAIBase {

   private EntityVillager field_48342_b;
   private EntityVillager field_48343_c;
   private World field_48340_d;
   private int field_48341_e = 0;
   Village field_48344_a;


   public EntityAIVillagerMate(EntityVillager p_i1086_1_) {
      this.field_48342_b = p_i1086_1_;
      this.field_48340_d = p_i1086_1_.field_615_ag;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      if(this.field_48342_b.func_48123_at() != 0) {
         return false;
      } else if(this.field_48342_b.func_46004_aK().nextInt(500) != 0) {
         return false;
      } else {
         this.field_48344_a = this.field_48340_d.field_48465_A.func_48564_a(MathHelper.func_1108_b(this.field_48342_b.field_611_ak), MathHelper.func_1108_b(this.field_48342_b.field_610_al), MathHelper.func_1108_b(this.field_48342_b.field_609_am), 0);
         if(this.field_48344_a == null) {
            return false;
         } else if(!this.func_48337_h()) {
            return false;
         } else {
            Entity var1 = this.field_48340_d.func_48459_a(EntityVillager.class, this.field_48342_b.field_601_au.func_1177_b(8.0D, 3.0D, 8.0D), this.field_48342_b);
            if(var1 == null) {
               return false;
            } else {
               this.field_48343_c = (EntityVillager)var1;
               return this.field_48343_c.func_48123_at() == 0;
            }
         }
      }
   }

   public void func_46080_e() {
      this.field_48341_e = 300;
      this.field_48342_b.func_48128_a(true);
   }

   public void func_46077_d() {
      this.field_48344_a = null;
      this.field_48343_c = null;
      this.field_48342_b.func_48128_a(false);
   }

   public boolean func_46084_g() {
      return this.field_48341_e >= 0 && this.func_48337_h() && this.field_48342_b.func_48123_at() == 0;
   }

   public void func_46081_b() {
      --this.field_48341_e;
      this.field_48342_b.func_46008_aG().func_46141_a(this.field_48343_c, 10.0F, 30.0F);
      if(this.field_48342_b.func_387_e(this.field_48343_c) > 2.25D) {
         this.field_48342_b.func_48084_aL().func_48667_a(this.field_48343_c, 0.25F);
      } else if(this.field_48341_e == 0 && this.field_48343_c.func_48126_w_()) {
         this.func_48339_i();
      }

      if(this.field_48342_b.func_46004_aK().nextInt(35) == 0) {
         this.func_48338_a(this.field_48342_b);
      }

   }

   private boolean func_48337_h() {
      int var1 = (int)((double)((float)this.field_48344_a.func_48530_c()) * 0.35D);
      return this.field_48344_a.func_48524_e() < var1;
   }

   private void func_48339_i() {
      EntityVillager var1 = new EntityVillager(this.field_48340_d);
      this.field_48343_c.func_48122_d(6000);
      this.field_48342_b.func_48122_d(6000);
      var1.func_48122_d(-24000);
      var1.func_48124_d_(this.field_48342_b.func_46004_aK().nextInt(5));
      var1.func_365_c(this.field_48342_b.field_611_ak, this.field_48342_b.field_610_al, this.field_48342_b.field_609_am, 0.0F, 0.0F);
      this.field_48340_d.func_674_a(var1);
      this.func_48338_a(var1);
   }

   private void func_48338_a(EntityLiving p_48338_1_) {
      Random var2 = p_48338_1_.func_46004_aK();

      for(int var3 = 0; var3 < 5; ++var3) {
         double var4 = var2.nextGaussian() * 0.02D;
         double var6 = var2.nextGaussian() * 0.02D;
         double var8 = var2.nextGaussian() * 0.02D;
         this.field_48340_d.func_694_a("heart", p_48338_1_.field_611_ak + (double)(var2.nextFloat() * p_48338_1_.field_644_aC * 2.0F) - (double)p_48338_1_.field_644_aC, p_48338_1_.field_610_al + 1.0D + (double)(var2.nextFloat() * p_48338_1_.field_643_aD), p_48338_1_.field_609_am + (double)(var2.nextFloat() * p_48338_1_.field_644_aC * 2.0F) - (double)p_48338_1_.field_644_aC, var4, var6, var8);
      }

   }
}
