package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.StatList;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityFishHook extends Entity {

   private int field_4095_d;
   private int field_4094_e;
   private int field_4093_f;
   private int field_4092_g;
   private boolean field_4091_h;
   public int field_4098_a;
   public EntityPlayer field_4097_b;
   private int field_4090_i;
   private int field_4089_j;
   private int field_4088_k;
   public Entity field_4096_c;
   private int field_6388_l;
   private double field_6387_m;
   private double field_6386_n;
   private double field_6385_o;
   private double field_6384_p;
   private double field_6383_q;
   private double field_6382_r;
   private double field_6381_s;
   private double field_6380_t;


   public EntityFishHook(World p_i21_1_) {
      super(p_i21_1_);
      this.field_4095_d = -1;
      this.field_4094_e = -1;
      this.field_4093_f = -1;
      this.field_4092_g = 0;
      this.field_4091_h = false;
      this.field_4098_a = 0;
      this.field_4089_j = 0;
      this.field_4088_k = 0;
      this.field_4096_c = null;
      this.func_371_a(0.25F, 0.25F);
      this.field_28016_bK = true;
   }

   public EntityFishHook(World p_i22_1_, double p_i22_2_, double p_i22_4_, double p_i22_6_) {
      this(p_i22_1_);
      this.func_347_a(p_i22_2_, p_i22_4_, p_i22_6_);
      this.field_28016_bK = true;
   }

   public EntityFishHook(World p_i23_1_, EntityPlayer p_i23_2_) {
      super(p_i23_1_);
      this.field_4095_d = -1;
      this.field_4094_e = -1;
      this.field_4093_f = -1;
      this.field_4092_g = 0;
      this.field_4091_h = false;
      this.field_4098_a = 0;
      this.field_4089_j = 0;
      this.field_4088_k = 0;
      this.field_4096_c = null;
      this.field_28016_bK = true;
      this.field_4097_b = p_i23_2_;
      this.field_4097_b.field_4128_n = this;
      this.func_371_a(0.25F, 0.25F);
      this.func_365_c(p_i23_2_.field_611_ak, p_i23_2_.field_610_al + 1.62D - (double)p_i23_2_.field_9292_aO, p_i23_2_.field_609_am, p_i23_2_.field_605_aq, p_i23_2_.field_604_ar);
      this.field_611_ak -= (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
      this.field_610_al -= 0.10000000149011612D;
      this.field_609_am -= (double)(MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.field_9292_aO = 0.0F;
      float var3 = 0.4F;
      this.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var3);
      this.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F) * var3);
      this.field_607_ao = (double)(-MathHelper.func_1106_a(this.field_604_ar / 180.0F * 3.1415927F) * var3);
      this.func_4042_a(this.field_608_an, this.field_607_ao, this.field_606_ap, 1.5F, 1.0F);
   }

   protected void func_21057_b() {}

   public boolean func_384_a(double p_384_1_) {
      double var3 = this.field_601_au.func_1164_b() * 4.0D;
      var3 *= 64.0D;
      return p_384_1_ < var3 * var3;
   }

   public void func_4042_a(double p_4042_1_, double p_4042_3_, double p_4042_5_, float p_4042_7_, float p_4042_8_) {
      float var9 = MathHelper.func_1109_a(p_4042_1_ * p_4042_1_ + p_4042_3_ * p_4042_3_ + p_4042_5_ * p_4042_5_);
      p_4042_1_ /= (double)var9;
      p_4042_3_ /= (double)var9;
      p_4042_5_ /= (double)var9;
      p_4042_1_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_4042_8_;
      p_4042_3_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_4042_8_;
      p_4042_5_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_4042_8_;
      p_4042_1_ *= (double)p_4042_7_;
      p_4042_3_ *= (double)p_4042_7_;
      p_4042_5_ *= (double)p_4042_7_;
      this.field_608_an = p_4042_1_;
      this.field_607_ao = p_4042_3_;
      this.field_606_ap = p_4042_5_;
      float var10 = MathHelper.func_1109_a(p_4042_1_ * p_4042_1_ + p_4042_5_ * p_4042_5_);
      this.field_603_as = this.field_605_aq = (float)(Math.atan2(p_4042_1_, p_4042_5_) * 180.0D / 3.1415927410125732D);
      this.field_602_at = this.field_604_ar = (float)(Math.atan2(p_4042_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_4090_i = 0;
   }

   public void func_378_a(double p_378_1_, double p_378_3_, double p_378_5_, float p_378_7_, float p_378_8_, int p_378_9_) {
      this.field_6387_m = p_378_1_;
      this.field_6386_n = p_378_3_;
      this.field_6385_o = p_378_5_;
      this.field_6384_p = (double)p_378_7_;
      this.field_6383_q = (double)p_378_8_;
      this.field_6388_l = p_378_9_;
      this.field_608_an = this.field_6382_r;
      this.field_607_ao = this.field_6381_s;
      this.field_606_ap = this.field_6380_t;
   }

   public void func_6375_a(double p_6375_1_, double p_6375_3_, double p_6375_5_) {
      this.field_6382_r = this.field_608_an = p_6375_1_;
      this.field_6381_s = this.field_607_ao = p_6375_3_;
      this.field_6380_t = this.field_606_ap = p_6375_5_;
   }

   public void func_370_e_() {
      super.func_370_e_();
      if(this.field_6388_l > 0) {
         double var21 = this.field_611_ak + (this.field_6387_m - this.field_611_ak) / (double)this.field_6388_l;
         double var22 = this.field_610_al + (this.field_6386_n - this.field_610_al) / (double)this.field_6388_l;
         double var23 = this.field_609_am + (this.field_6385_o - this.field_609_am) / (double)this.field_6388_l;

         double var7;
         for(var7 = this.field_6384_p - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
            ;
         }

         while(var7 >= 180.0D) {
            var7 -= 360.0D;
         }

         this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_6388_l);
         this.field_604_ar = (float)((double)this.field_604_ar + (this.field_6383_q - (double)this.field_604_ar) / (double)this.field_6388_l);
         --this.field_6388_l;
         this.func_347_a(var21, var22, var23);
         this.func_376_c(this.field_605_aq, this.field_604_ar);
      } else {
         if(!this.field_615_ag.field_1026_y) {
            ItemStack var1 = this.field_4097_b.func_6416_v();
            if(this.field_4097_b.field_646_aA || !this.field_4097_b.func_354_B() || var1 == null || var1.func_1091_a() != Item.field_4024_aP || this.func_387_e(this.field_4097_b) > 1024.0D) {
               this.func_395_F();
               this.field_4097_b.field_4128_n = null;
               return;
            }

            if(this.field_4096_c != null) {
               if(!this.field_4096_c.field_646_aA) {
                  this.field_611_ak = this.field_4096_c.field_611_ak;
                  this.field_610_al = this.field_4096_c.field_601_au.field_1697_b + (double)this.field_4096_c.field_643_aD * 0.8D;
                  this.field_609_am = this.field_4096_c.field_609_am;
                  return;
               }

               this.field_4096_c = null;
            }
         }

         if(this.field_4098_a > 0) {
            --this.field_4098_a;
         }

         if(this.field_4091_h) {
            int var19 = this.field_615_ag.func_600_a(this.field_4095_d, this.field_4094_e, this.field_4093_f);
            if(var19 == this.field_4092_g) {
               ++this.field_4090_i;
               if(this.field_4090_i == 1200) {
                  this.func_395_F();
               }

               return;
            }

            this.field_4091_h = false;
            this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_4090_i = 0;
            this.field_4089_j = 0;
         } else {
            ++this.field_4089_j;
         }

         Vec3D var20 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
         Vec3D var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
         MovingObjectPosition var3 = this.field_615_ag.func_645_a(var20, var2);
         var20 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
         var2 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
         if(var3 != null) {
            var2 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
         }

         Entity var4 = null;
         List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         double var13;
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_401_c_() && (var9 != this.field_4097_b || this.field_4089_j >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_601_au.func_1177_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_1169_a(var20, var2);
               if(var12 != null) {
                  var13 = var20.func_1251_c(var12.field_1169_f);
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
            if(var3.field_1168_g != null) {
               if(var3.field_1168_g.func_396_a(DamageSource.func_35524_a(this, this.field_4097_b), 0)) {
                  this.field_4096_c = var3.field_1168_g;
               }
            } else {
               this.field_4091_h = true;
            }
         }

         if(!this.field_4091_h) {
            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            float var24 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
            this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

            for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var24) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
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
            float var25 = 0.92F;
            if(this.field_9298_aH || this.field_9297_aI) {
               var25 = 0.5F;
            }

            byte var26 = 5;
            double var27 = 0.0D;

            for(int var28 = 0; var28 < var26; ++var28) {
               double var14 = this.field_601_au.field_1697_b + (this.field_601_au.field_1702_e - this.field_601_au.field_1697_b) * (double)(var28 + 0) / (double)var26 - 0.125D + 0.125D;
               double var16 = this.field_601_au.field_1697_b + (this.field_601_au.field_1702_e - this.field_601_au.field_1697_b) * (double)(var28 + 1) / (double)var26 - 0.125D + 0.125D;
               AxisAlignedBB var18 = AxisAlignedBB.func_1161_b(this.field_601_au.field_1698_a, var14, this.field_601_au.field_1704_c, this.field_601_au.field_1703_d, var16, this.field_601_au.field_1701_f);
               if(this.field_615_ag.func_707_b(var18, Material.field_1332_f)) {
                  var27 += 1.0D / (double)var26;
               }
            }

            if(var27 > 0.0D) {
               if(this.field_4088_k > 0) {
                  --this.field_4088_k;
               } else {
                  short var29 = 500;
                  if(this.field_615_ag.func_27167_r(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al) + 1, MathHelper.func_1108_b(this.field_609_am))) {
                     var29 = 300;
                  }

                  if(this.field_9312_bd.nextInt(var29) == 0) {
                     this.field_4088_k = this.field_9312_bd.nextInt(30) + 10;
                     this.field_607_ao -= 0.20000000298023224D;
                     this.field_615_ag.func_623_a(this, "random.splash", 0.25F, 1.0F + (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.4F);
                     float var30 = (float)MathHelper.func_1108_b(this.field_601_au.field_1697_b);

                     int var15;
                     float var17;
                     float var31;
                     for(var15 = 0; (float)var15 < 1.0F + this.field_644_aC * 20.0F; ++var15) {
                        var31 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
                        var17 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
                        this.field_615_ag.func_694_a("bubble", this.field_611_ak + (double)var31, (double)(var30 + 1.0F), this.field_609_am + (double)var17, this.field_608_an, this.field_607_ao - (double)(this.field_9312_bd.nextFloat() * 0.2F), this.field_606_ap);
                     }

                     for(var15 = 0; (float)var15 < 1.0F + this.field_644_aC * 20.0F; ++var15) {
                        var31 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
                        var17 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
                        this.field_615_ag.func_694_a("splash", this.field_611_ak + (double)var31, (double)(var30 + 1.0F), this.field_609_am + (double)var17, this.field_608_an, this.field_607_ao, this.field_606_ap);
                     }
                  }
               }
            }

            if(this.field_4088_k > 0) {
               this.field_607_ao -= (double)(this.field_9312_bd.nextFloat() * this.field_9312_bd.nextFloat() * this.field_9312_bd.nextFloat()) * 0.2D;
            }

            var13 = var27 * 2.0D - 1.0D;
            this.field_607_ao += 0.03999999910593033D * var13;
            if(var27 > 0.0D) {
               var25 = (float)((double)var25 * 0.9D);
               this.field_607_ao *= 0.8D;
            }

            this.field_608_an *= (double)var25;
            this.field_607_ao *= (double)var25;
            this.field_606_ap *= (double)var25;
            this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
         }
      }
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("xTile", (short)this.field_4095_d);
      p_352_1_.func_749_a("yTile", (short)this.field_4094_e);
      p_352_1_.func_749_a("zTile", (short)this.field_4093_f);
      p_352_1_.func_761_a("inTile", (byte)this.field_4092_g);
      p_352_1_.func_761_a("shake", (byte)this.field_4098_a);
      p_352_1_.func_761_a("inGround", (byte)(this.field_4091_h?1:0));
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      this.field_4095_d = p_357_1_.func_745_d("xTile");
      this.field_4094_e = p_357_1_.func_745_d("yTile");
      this.field_4093_f = p_357_1_.func_745_d("zTile");
      this.field_4092_g = p_357_1_.func_746_c("inTile") & 255;
      this.field_4098_a = p_357_1_.func_746_c("shake") & 255;
      this.field_4091_h = p_357_1_.func_746_c("inGround") == 1;
   }

   public float func_392_h_() {
      return 0.0F;
   }

   public int func_4043_i() {
      byte var1 = 0;
      if(this.field_4096_c != null) {
         double var2 = this.field_4097_b.field_611_ak - this.field_611_ak;
         double var4 = this.field_4097_b.field_610_al - this.field_610_al;
         double var6 = this.field_4097_b.field_609_am - this.field_609_am;
         double var8 = (double)MathHelper.func_1109_a(var2 * var2 + var4 * var4 + var6 * var6);
         double var10 = 0.1D;
         this.field_4096_c.field_608_an += var2 * var10;
         this.field_4096_c.field_607_ao += var4 * var10 + (double)MathHelper.func_1109_a(var8) * 0.08D;
         this.field_4096_c.field_606_ap += var6 * var10;
         var1 = 3;
      } else if(this.field_4088_k > 0) {
         EntityItem var13 = new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, new ItemStack(Item.field_4021_aS));
         double var3 = this.field_4097_b.field_611_ak - this.field_611_ak;
         double var5 = this.field_4097_b.field_610_al - this.field_610_al;
         double var7 = this.field_4097_b.field_609_am - this.field_609_am;
         double var9 = (double)MathHelper.func_1109_a(var3 * var3 + var5 * var5 + var7 * var7);
         double var11 = 0.1D;
         var13.field_608_an = var3 * var11;
         var13.field_607_ao = var5 * var11 + (double)MathHelper.func_1109_a(var9) * 0.08D;
         var13.field_606_ap = var7 * var11;
         this.field_615_ag.func_674_a(var13);
         this.field_4097_b.func_25058_a(StatList.field_25160_x, 1);
         var1 = 1;
      }

      if(this.field_4091_h) {
         var1 = 2;
      }

      this.func_395_F();
      this.field_4097_b.field_4128_n = null;
      return var1;
   }
}
