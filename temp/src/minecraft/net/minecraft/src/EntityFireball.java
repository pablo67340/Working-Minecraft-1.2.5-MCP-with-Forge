package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityFireball extends Entity {

   private int field_9402_e = -1;
   private int field_9401_f = -1;
   private int field_9400_g = -1;
   private int field_9399_h = 0;
   private boolean field_9398_i = false;
   public EntityLiving field_9397_j;
   private int field_9396_k;
   private int field_9395_l = 0;
   public double field_9405_b;
   public double field_9404_c;
   public double field_9403_d;


   public EntityFireball(World p_i250_1_) {
      super(p_i250_1_);
      this.func_371_a(1.0F, 1.0F);
   }

   protected void func_21057_b() {}

   public boolean func_384_a(double p_384_1_) {
      double var3 = this.field_601_au.func_1164_b() * 4.0D;
      var3 *= 64.0D;
      return p_384_1_ < var3 * var3;
   }

   public EntityFireball(World p_i251_1_, double p_i251_2_, double p_i251_4_, double p_i251_6_, double p_i251_8_, double p_i251_10_, double p_i251_12_) {
      super(p_i251_1_);
      this.func_371_a(1.0F, 1.0F);
      this.func_365_c(p_i251_2_, p_i251_4_, p_i251_6_, this.field_605_aq, this.field_604_ar);
      this.func_347_a(p_i251_2_, p_i251_4_, p_i251_6_);
      double var14 = (double)MathHelper.func_1109_a(p_i251_8_ * p_i251_8_ + p_i251_10_ * p_i251_10_ + p_i251_12_ * p_i251_12_);
      this.field_9405_b = p_i251_8_ / var14 * 0.1D;
      this.field_9404_c = p_i251_10_ / var14 * 0.1D;
      this.field_9403_d = p_i251_12_ / var14 * 0.1D;
   }

   public EntityFireball(World p_i252_1_, EntityLiving p_i252_2_, double p_i252_3_, double p_i252_5_, double p_i252_7_) {
      super(p_i252_1_);
      this.field_9397_j = p_i252_2_;
      this.func_371_a(1.0F, 1.0F);
      this.func_365_c(p_i252_2_.field_611_ak, p_i252_2_.field_610_al, p_i252_2_.field_609_am, p_i252_2_.field_605_aq, p_i252_2_.field_604_ar);
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.field_9292_aO = 0.0F;
      this.field_608_an = this.field_607_ao = this.field_606_ap = 0.0D;
      p_i252_3_ += this.field_9312_bd.nextGaussian() * 0.4D;
      p_i252_5_ += this.field_9312_bd.nextGaussian() * 0.4D;
      p_i252_7_ += this.field_9312_bd.nextGaussian() * 0.4D;
      double var9 = (double)MathHelper.func_1109_a(p_i252_3_ * p_i252_3_ + p_i252_5_ * p_i252_5_ + p_i252_7_ * p_i252_7_);
      this.field_9405_b = p_i252_3_ / var9 * 0.1D;
      this.field_9404_c = p_i252_5_ / var9 * 0.1D;
      this.field_9403_d = p_i252_7_ / var9 * 0.1D;
   }

   public void func_370_e_() {
      if(!this.field_615_ag.field_1026_y && (this.field_9397_j != null && this.field_9397_j.field_646_aA || !this.field_615_ag.func_630_d((int)this.field_611_ak, (int)this.field_610_al, (int)this.field_609_am))) {
         this.func_395_F();
      } else {
         super.func_370_e_();
         this.func_40046_d(1);
         if(this.field_9398_i) {
            int var1 = this.field_615_ag.func_600_a(this.field_9402_e, this.field_9401_f, this.field_9400_g);
            if(var1 == this.field_9399_h) {
               ++this.field_9396_k;
               if(this.field_9396_k == 600) {
                  this.func_395_F();
               }

               return;
            }

            this.field_9398_i = false;
            this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_9396_k = 0;
            this.field_9395_l = 0;
         } else {
            ++this.field_9395_l;
         }

         Vec3D var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
         Vec3D var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
         MovingObjectPosition var3 = this.field_615_ag.func_645_a(var15, var2);
         var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
         var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
         if(var3 != null) {
            var2 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
         }

         Entity var4 = null;
         List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_401_c_() && (!var9.func_41004_h(this.field_9397_j) || this.field_9395_l >= 25)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_601_au.func_1177_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_1169_a(var15, var2);
               if(var12 != null) {
                  double var13 = var15.func_1251_c(var12.field_1169_f);
                  if(var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }

         if(var3 != null) {
            this.func_40071_a(var3);
         }

         this.field_611_ak += this.field_608_an;
         this.field_610_al += this.field_607_ao;
         this.field_609_am += this.field_606_ap;
         float var16 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
         this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

         for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var16) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
            ;
         }

         while(this.field_604_ar - this.field_602_at >= 180.0F) {
            this.field_602_at += 360.0F;
         }

         while(this.field_605_aq - this.field_603_as < -180.0F) {
            this.field_603_as -= 360.0F;
         }

         while(this.field_605_aq - this.field_603_as >= 180.0F) {
            this.field_603_as += 360.0F;
         }

         this.field_604_ar = this.field_602_at + (this.field_604_ar - this.field_602_at) * 0.2F;
         this.field_605_aq = this.field_603_as + (this.field_605_aq - this.field_603_as) * 0.2F;
         float var17 = 0.95F;
         if(this.func_27013_ag()) {
            for(int var18 = 0; var18 < 4; ++var18) {
               float var19 = 0.25F;
               this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var19, this.field_610_al - this.field_607_ao * (double)var19, this.field_609_am - this.field_606_ap * (double)var19, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }

            var17 = 0.8F;
         }

         this.field_608_an += this.field_9405_b;
         this.field_607_ao += this.field_9404_c;
         this.field_606_ap += this.field_9403_d;
         this.field_608_an *= (double)var17;
         this.field_607_ao *= (double)var17;
         this.field_606_ap *= (double)var17;
         this.field_615_ag.func_694_a("smoke", this.field_611_ak, this.field_610_al + 0.5D, this.field_609_am, 0.0D, 0.0D, 0.0D);
         this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      }
   }

   protected void func_40071_a(MovingObjectPosition p_40071_1_) {
      if(!this.field_615_ag.field_1026_y) {
         if(p_40071_1_.field_1168_g != null && p_40071_1_.field_1168_g.func_396_a(DamageSource.func_35530_a(this, this.field_9397_j), 4)) {
            ;
         }

         this.field_615_ag.func_12244_a((Entity)null, this.field_611_ak, this.field_610_al, this.field_609_am, 1.0F, true);
         this.func_395_F();
      }

   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("xTile", (short)this.field_9402_e);
      p_352_1_.func_749_a("yTile", (short)this.field_9401_f);
      p_352_1_.func_749_a("zTile", (short)this.field_9400_g);
      p_352_1_.func_761_a("inTile", (byte)this.field_9399_h);
      p_352_1_.func_761_a("inGround", (byte)(this.field_9398_i?1:0));
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      this.field_9402_e = p_357_1_.func_745_d("xTile");
      this.field_9401_f = p_357_1_.func_745_d("yTile");
      this.field_9400_g = p_357_1_.func_745_d("zTile");
      this.field_9399_h = p_357_1_.func_746_c("inTile") & 255;
      this.field_9398_i = p_357_1_.func_746_c("inGround") == 1;
   }

   public boolean func_401_c_() {
      return true;
   }

   public float func_4035_j_() {
      return 1.0F;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      this.func_9281_M();
      if(p_396_1_.func_35532_a() != null) {
         Vec3D var3 = p_396_1_.func_35532_a().func_4037_H();
         if(var3 != null) {
            this.field_608_an = var3.field_1776_a;
            this.field_607_ao = var3.field_1775_b;
            this.field_606_ap = var3.field_1779_c;
            this.field_9405_b = this.field_608_an * 0.1D;
            this.field_9404_c = this.field_607_ao * 0.1D;
            this.field_9403_d = this.field_606_ap * 0.1D;
         }

         if(p_396_1_.func_35532_a() instanceof EntityLiving) {
            this.field_9397_j = (EntityLiving)p_396_1_.func_35532_a();
         }

         return true;
      } else {
         return false;
      }
   }

   public float func_392_h_() {
      return 0.0F;
   }

   public float func_382_a(float p_382_1_) {
      return 1.0F;
   }

   public int func_35115_a(float p_35115_1_) {
      return 15728880;
   }
}
