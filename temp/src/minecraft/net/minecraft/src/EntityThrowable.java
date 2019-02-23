package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class EntityThrowable extends Entity {

   private int field_40079_d = -1;
   private int field_40080_e = -1;
   private int field_40082_ao = -1;
   private int field_40084_ap = 0;
   protected boolean field_40085_a = false;
   public int field_40081_b = 0;
   protected EntityLiving field_40083_c;
   private int field_40087_aq;
   private int field_40086_ar = 0;


   public EntityThrowable(World p_i233_1_) {
      super(p_i233_1_);
      this.func_371_a(0.25F, 0.25F);
   }

   protected void func_21057_b() {}

   public boolean func_384_a(double p_384_1_) {
      double var3 = this.field_601_au.func_1164_b() * 4.0D;
      var3 *= 64.0D;
      return p_384_1_ < var3 * var3;
   }

   public EntityThrowable(World p_i234_1_, EntityLiving p_i234_2_) {
      super(p_i234_1_);
      this.field_40083_c = p_i234_2_;
      this.func_371_a(0.25F, 0.25F);
      this.func_365_c(p_i234_2_.field_611_ak, p_i234_2_.field_610_al + (double)p_i234_2_.func_373_s(), p_i234_2_.field_609_am, p_i234_2_.field_605_aq, p_i234_2_.field_604_ar);
      this.field_611_ak -= (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
      this.field_610_al -= 0.10000000149011612D;
      this.field_609_am -= (double)(MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.field_9292_aO = 0.0F;
      float var3 = 0.4F;
      this.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var3);
      this.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var3);
      this.field_607_ao = (double)(-MathHelper.func_1106_a((this.field_604_ar + this.func_40074_d()) / 180.0F * 3.1415927F) * var3);
      this.func_40076_a(this.field_608_an, this.field_607_ao, this.field_606_ap, this.func_40077_c(), 1.0F);
   }

   public EntityThrowable(World p_i235_1_, double p_i235_2_, double p_i235_4_, double p_i235_6_) {
      super(p_i235_1_);
      this.field_40087_aq = 0;
      this.func_371_a(0.25F, 0.25F);
      this.func_347_a(p_i235_2_, p_i235_4_, p_i235_6_);
      this.field_9292_aO = 0.0F;
   }

   protected float func_40077_c() {
      return 1.5F;
   }

   protected float func_40074_d() {
      return 0.0F;
   }

   public void func_40076_a(double p_40076_1_, double p_40076_3_, double p_40076_5_, float p_40076_7_, float p_40076_8_) {
      float var9 = MathHelper.func_1109_a(p_40076_1_ * p_40076_1_ + p_40076_3_ * p_40076_3_ + p_40076_5_ * p_40076_5_);
      p_40076_1_ /= (double)var9;
      p_40076_3_ /= (double)var9;
      p_40076_5_ /= (double)var9;
      p_40076_1_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_40076_8_;
      p_40076_3_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_40076_8_;
      p_40076_5_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_40076_8_;
      p_40076_1_ *= (double)p_40076_7_;
      p_40076_3_ *= (double)p_40076_7_;
      p_40076_5_ *= (double)p_40076_7_;
      this.field_608_an = p_40076_1_;
      this.field_607_ao = p_40076_3_;
      this.field_606_ap = p_40076_5_;
      float var10 = MathHelper.func_1109_a(p_40076_1_ * p_40076_1_ + p_40076_5_ * p_40076_5_);
      this.field_603_as = this.field_605_aq = (float)(Math.atan2(p_40076_1_, p_40076_5_) * 180.0D / 3.1415927410125732D);
      this.field_602_at = this.field_604_ar = (float)(Math.atan2(p_40076_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_40087_aq = 0;
   }

   public void func_6375_a(double p_6375_1_, double p_6375_3_, double p_6375_5_) {
      this.field_608_an = p_6375_1_;
      this.field_607_ao = p_6375_3_;
      this.field_606_ap = p_6375_5_;
      if(this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
         float var7 = MathHelper.func_1109_a(p_6375_1_ * p_6375_1_ + p_6375_5_ * p_6375_5_);
         this.field_603_as = this.field_605_aq = (float)(Math.atan2(p_6375_1_, p_6375_5_) * 180.0D / 3.1415927410125732D);
         this.field_602_at = this.field_604_ar = (float)(Math.atan2(p_6375_3_, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void func_370_e_() {
      this.field_638_aI = this.field_611_ak;
      this.field_637_aJ = this.field_610_al;
      this.field_636_aK = this.field_609_am;
      super.func_370_e_();
      if(this.field_40081_b > 0) {
         --this.field_40081_b;
      }

      if(this.field_40085_a) {
         int var1 = this.field_615_ag.func_600_a(this.field_40079_d, this.field_40080_e, this.field_40082_ao);
         if(var1 == this.field_40084_ap) {
            ++this.field_40087_aq;
            if(this.field_40087_aq == 1200) {
               this.func_395_F();
            }

            return;
         }

         this.field_40085_a = false;
         this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
         this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
         this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
         this.field_40087_aq = 0;
         this.field_40086_ar = 0;
      } else {
         ++this.field_40086_ar;
      }

      Vec3D var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
      Vec3D var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
      MovingObjectPosition var3 = this.field_615_ag.func_645_a(var15, var2);
      var15 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
      var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
      if(var3 != null) {
         var2 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
      }

      if(!this.field_615_ag.field_1026_y) {
         Entity var4 = null;
         List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_401_c_() && (var9 != this.field_40083_c || this.field_40086_ar >= 5)) {
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
      }

      if(var3 != null) {
         this.func_40078_a(var3);
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
      float var17 = 0.99F;
      float var18 = this.func_40075_e();
      if(this.func_27013_ag()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var19, this.field_610_al - this.field_607_ao * (double)var19, this.field_609_am - this.field_606_ap * (double)var19, this.field_608_an, this.field_607_ao, this.field_606_ap);
         }

         var17 = 0.8F;
      }

      this.field_608_an *= (double)var17;
      this.field_607_ao *= (double)var17;
      this.field_606_ap *= (double)var17;
      this.field_607_ao -= (double)var18;
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
   }

   protected float func_40075_e() {
      return 0.03F;
   }

   protected abstract void func_40078_a(MovingObjectPosition var1);

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("xTile", (short)this.field_40079_d);
      p_352_1_.func_749_a("yTile", (short)this.field_40080_e);
      p_352_1_.func_749_a("zTile", (short)this.field_40082_ao);
      p_352_1_.func_761_a("inTile", (byte)this.field_40084_ap);
      p_352_1_.func_761_a("shake", (byte)this.field_40081_b);
      p_352_1_.func_761_a("inGround", (byte)(this.field_40085_a?1:0));
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      this.field_40079_d = p_357_1_.func_745_d("xTile");
      this.field_40080_e = p_357_1_.func_745_d("yTile");
      this.field_40082_ao = p_357_1_.func_745_d("zTile");
      this.field_40084_ap = p_357_1_.func_746_c("inTile") & 255;
      this.field_40081_b = p_357_1_.func_746_c("shake") & 255;
      this.field_40085_a = p_357_1_.func_746_c("inGround") == 1;
   }

   public void func_6378_b(EntityPlayer p_6378_1_) {}

   public float func_392_h_() {
      return 0.0F;
   }
}
