package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityArrow extends Entity {

   private int field_9319_c = -1;
   private int field_9318_d = -1;
   private int field_9317_e = -1;
   private int field_9316_f = 0;
   private int field_28019_h = 0;
   private boolean field_9315_g = false;
   public boolean field_28020_a = false;
   public int field_688_a = 0;
   public Entity field_682_g;
   private int field_681_h;
   private int field_680_i = 0;
   private double field_46026_at = 2.0D;
   private int field_46027_au;
   public boolean field_35140_d = false;


   public EntityArrow(World p_i477_1_) {
      super(p_i477_1_);
      this.func_371_a(0.5F, 0.5F);
   }

   public EntityArrow(World p_i478_1_, double p_i478_2_, double p_i478_4_, double p_i478_6_) {
      super(p_i478_1_);
      this.func_371_a(0.5F, 0.5F);
      this.func_347_a(p_i478_2_, p_i478_4_, p_i478_6_);
      this.field_9292_aO = 0.0F;
   }

   public EntityArrow(World p_i1055_1_, EntityLiving p_i1055_2_, EntityLiving p_i1055_3_, float p_i1055_4_, float p_i1055_5_) {
      super(p_i1055_1_);
      this.field_682_g = p_i1055_2_;
      this.field_28020_a = p_i1055_2_ instanceof EntityPlayer;
      this.field_610_al = p_i1055_2_.field_610_al + (double)p_i1055_2_.func_373_s() - 0.10000000149011612D;
      double var6 = p_i1055_3_.field_611_ak - p_i1055_2_.field_611_ak;
      double var8 = p_i1055_3_.field_610_al + (double)p_i1055_3_.func_373_s() - 0.699999988079071D - this.field_610_al;
      double var10 = p_i1055_3_.field_609_am - p_i1055_2_.field_609_am;
      double var12 = (double)MathHelper.func_1109_a(var6 * var6 + var10 * var10);
      if(var12 >= 1.0E-7D) {
         float var14 = (float)(Math.atan2(var10, var6) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var15 = (float)(-(Math.atan2(var8, var12) * 180.0D / 3.1415927410125732D));
         double var16 = var6 / var12;
         double var18 = var10 / var12;
         this.func_365_c(p_i1055_2_.field_611_ak + var16, this.field_610_al, p_i1055_2_.field_609_am + var18, var14, var15);
         this.field_9292_aO = 0.0F;
         float var20 = (float)var12 * 0.2F;
         this.func_408_a(var6, var8 + (double)var20, var10, p_i1055_4_, p_i1055_5_);
      }
   }

   public EntityArrow(World p_i479_1_, EntityLiving p_i479_2_, float p_i479_3_) {
      super(p_i479_1_);
      this.field_682_g = p_i479_2_;
      this.field_28020_a = p_i479_2_ instanceof EntityPlayer;
      this.func_371_a(0.5F, 0.5F);
      this.func_365_c(p_i479_2_.field_611_ak, p_i479_2_.field_610_al + (double)p_i479_2_.func_373_s(), p_i479_2_.field_609_am, p_i479_2_.field_605_aq, p_i479_2_.field_604_ar);
      this.field_611_ak -= (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
      this.field_610_al -= 0.10000000149011612D;
      this.field_609_am -= (double)(MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * 0.16F);
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.field_9292_aO = 0.0F;
      this.field_608_an = (double)(-MathHelper.func_1106_a(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F));
      this.field_606_ap = (double)(MathHelper.func_1114_b(this.field_605_aq / 180.0F * 3.1415927F) * MathHelper.func_1114_b(this.field_604_ar / 180.0F * 3.1415927F));
      this.field_607_ao = (double)(-MathHelper.func_1106_a(this.field_604_ar / 180.0F * 3.1415927F));
      this.func_408_a(this.field_608_an, this.field_607_ao, this.field_606_ap, p_i479_3_ * 1.5F, 1.0F);
   }

   protected void func_21057_b() {}

   public void func_408_a(double p_408_1_, double p_408_3_, double p_408_5_, float p_408_7_, float p_408_8_) {
      float var9 = MathHelper.func_1109_a(p_408_1_ * p_408_1_ + p_408_3_ * p_408_3_ + p_408_5_ * p_408_5_);
      p_408_1_ /= (double)var9;
      p_408_3_ /= (double)var9;
      p_408_5_ /= (double)var9;
      p_408_1_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_408_8_;
      p_408_3_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_408_8_;
      p_408_5_ += this.field_9312_bd.nextGaussian() * 0.007499999832361937D * (double)p_408_8_;
      p_408_1_ *= (double)p_408_7_;
      p_408_3_ *= (double)p_408_7_;
      p_408_5_ *= (double)p_408_7_;
      this.field_608_an = p_408_1_;
      this.field_607_ao = p_408_3_;
      this.field_606_ap = p_408_5_;
      float var10 = MathHelper.func_1109_a(p_408_1_ * p_408_1_ + p_408_5_ * p_408_5_);
      this.field_603_as = this.field_605_aq = (float)(Math.atan2(p_408_1_, p_408_5_) * 180.0D / 3.1415927410125732D);
      this.field_602_at = this.field_604_ar = (float)(Math.atan2(p_408_3_, (double)var10) * 180.0D / 3.1415927410125732D);
      this.field_681_h = 0;
   }

   public void func_6375_a(double p_6375_1_, double p_6375_3_, double p_6375_5_) {
      this.field_608_an = p_6375_1_;
      this.field_607_ao = p_6375_3_;
      this.field_606_ap = p_6375_5_;
      if(this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
         float var7 = MathHelper.func_1109_a(p_6375_1_ * p_6375_1_ + p_6375_5_ * p_6375_5_);
         this.field_603_as = this.field_605_aq = (float)(Math.atan2(p_6375_1_, p_6375_5_) * 180.0D / 3.1415927410125732D);
         this.field_602_at = this.field_604_ar = (float)(Math.atan2(p_6375_3_, (double)var7) * 180.0D / 3.1415927410125732D);
         this.field_602_at = this.field_604_ar;
         this.field_603_as = this.field_605_aq;
         this.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar);
         this.field_681_h = 0;
      }

   }

   public void func_370_e_() {
      super.func_370_e_();
      if(this.field_602_at == 0.0F && this.field_603_as == 0.0F) {
         float var1 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
         this.field_603_as = this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);
         this.field_602_at = this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var1) * 180.0D / 3.1415927410125732D);
      }

      int var15 = this.field_615_ag.func_600_a(this.field_9319_c, this.field_9318_d, this.field_9317_e);
      if(var15 > 0) {
         Block.field_345_n[var15].func_238_a(this.field_615_ag, this.field_9319_c, this.field_9318_d, this.field_9317_e);
         AxisAlignedBB var2 = Block.field_345_n[var15].func_221_d(this.field_615_ag, this.field_9319_c, this.field_9318_d, this.field_9317_e);
         if(var2 != null && var2.func_4150_a(Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am))) {
            this.field_9315_g = true;
         }
      }

      if(this.field_688_a > 0) {
         --this.field_688_a;
      }

      if(this.field_9315_g) {
         var15 = this.field_615_ag.func_600_a(this.field_9319_c, this.field_9318_d, this.field_9317_e);
         int var18 = this.field_615_ag.func_602_e(this.field_9319_c, this.field_9318_d, this.field_9317_e);
         if(var15 == this.field_9316_f && var18 == this.field_28019_h) {
            ++this.field_681_h;
            if(this.field_681_h == 1200) {
               this.func_395_F();
            }

         } else {
            this.field_9315_g = false;
            this.field_608_an *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_607_ao *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_606_ap *= (double)(this.field_9312_bd.nextFloat() * 0.2F);
            this.field_681_h = 0;
            this.field_680_i = 0;
         }
      } else {
         ++this.field_680_i;
         Vec3D var16 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
         Vec3D var17 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
         MovingObjectPosition var3 = this.field_615_ag.func_28105_a(var16, var17, false, true);
         var16 = Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
         var17 = Vec3D.func_1248_b(this.field_611_ak + this.field_608_an, this.field_610_al + this.field_607_ao, this.field_609_am + this.field_606_ap);
         if(var3 != null) {
            var17 = Vec3D.func_1248_b(var3.field_1169_f.field_1776_a, var3.field_1169_f.field_1775_b, var3.field_1169_f.field_1779_c);
         }

         Entity var4 = null;
         List var5 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1170_a(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1177_b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         int var8;
         float var10;
         for(var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.func_401_c_() && (var9 != this.field_682_g || this.field_680_i >= 5)) {
               var10 = 0.3F;
               AxisAlignedBB var11 = var9.field_601_au.func_1177_b((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.func_1169_a(var16, var17);
               if(var12 != null) {
                  double var13 = var16.func_1251_c(var12.field_1169_f);
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

         float var19;
         if(var3 != null) {
            if(var3.field_1168_g != null) {
               var19 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_607_ao * this.field_607_ao + this.field_606_ap * this.field_606_ap);
               int var20 = (int)Math.ceil((double)var19 * this.field_46026_at);
               if(this.field_35140_d) {
                  var20 += this.field_9312_bd.nextInt(var20 / 2 + 2);
               }

               DamageSource var21 = null;
               if(this.field_682_g == null) {
                  var21 = DamageSource.func_35535_a(this, this);
               } else {
                  var21 = DamageSource.func_35535_a(this, this.field_682_g);
               }

               if(this.func_21062_U()) {
                  var3.field_1168_g.func_40046_d(5);
               }

               if(var3.field_1168_g.func_396_a(var21, var20)) {
                  if(var3.field_1168_g instanceof EntityLiving) {
                     ++((EntityLiving)var3.field_1168_g).field_35172_bP;
                     if(this.field_46027_au > 0) {
                        float var23 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
                        if(var23 > 0.0F) {
                           var3.field_1168_g.func_348_f(this.field_608_an * (double)this.field_46027_au * 0.6000000238418579D / (double)var23, 0.1D, this.field_606_ap * (double)this.field_46027_au * 0.6000000238418579D / (double)var23);
                        }
                     }
                  }

                  this.field_615_ag.func_623_a(this, "random.bowhit", 1.0F, 1.2F / (this.field_9312_bd.nextFloat() * 0.2F + 0.9F));
                  this.func_395_F();
               } else {
                  this.field_608_an *= -0.10000000149011612D;
                  this.field_607_ao *= -0.10000000149011612D;
                  this.field_606_ap *= -0.10000000149011612D;
                  this.field_605_aq += 180.0F;
                  this.field_603_as += 180.0F;
                  this.field_680_i = 0;
               }
            } else {
               this.field_9319_c = var3.field_1166_b;
               this.field_9318_d = var3.field_1172_c;
               this.field_9317_e = var3.field_1171_d;
               this.field_9316_f = this.field_615_ag.func_600_a(this.field_9319_c, this.field_9318_d, this.field_9317_e);
               this.field_28019_h = this.field_615_ag.func_602_e(this.field_9319_c, this.field_9318_d, this.field_9317_e);
               this.field_608_an = (double)((float)(var3.field_1169_f.field_1776_a - this.field_611_ak));
               this.field_607_ao = (double)((float)(var3.field_1169_f.field_1775_b - this.field_610_al));
               this.field_606_ap = (double)((float)(var3.field_1169_f.field_1779_c - this.field_609_am));
               var19 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_607_ao * this.field_607_ao + this.field_606_ap * this.field_606_ap);
               this.field_611_ak -= this.field_608_an / (double)var19 * 0.05000000074505806D;
               this.field_610_al -= this.field_607_ao / (double)var19 * 0.05000000074505806D;
               this.field_609_am -= this.field_606_ap / (double)var19 * 0.05000000074505806D;
               this.field_615_ag.func_623_a(this, "random.bowhit", 1.0F, 1.2F / (this.field_9312_bd.nextFloat() * 0.2F + 0.9F));
               this.field_9315_g = true;
               this.field_688_a = 7;
               this.field_35140_d = false;
            }
         }

         if(this.field_35140_d) {
            for(var8 = 0; var8 < 4; ++var8) {
               this.field_615_ag.func_694_a("crit", this.field_611_ak + this.field_608_an * (double)var8 / 4.0D, this.field_610_al + this.field_607_ao * (double)var8 / 4.0D, this.field_609_am + this.field_606_ap * (double)var8 / 4.0D, -this.field_608_an, -this.field_607_ao + 0.2D, -this.field_606_ap);
            }
         }

         this.field_611_ak += this.field_608_an;
         this.field_610_al += this.field_607_ao;
         this.field_609_am += this.field_606_ap;
         var19 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
         this.field_605_aq = (float)(Math.atan2(this.field_608_an, this.field_606_ap) * 180.0D / 3.1415927410125732D);

         for(this.field_604_ar = (float)(Math.atan2(this.field_607_ao, (double)var19) * 180.0D / 3.1415927410125732D); this.field_604_ar - this.field_602_at < -180.0F; this.field_602_at -= 360.0F) {
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
         float var22 = 0.99F;
         var10 = 0.05F;
         if(this.func_27013_ag()) {
            for(int var24 = 0; var24 < 4; ++var24) {
               float var25 = 0.25F;
               this.field_615_ag.func_694_a("bubble", this.field_611_ak - this.field_608_an * (double)var25, this.field_610_al - this.field_607_ao * (double)var25, this.field_609_am - this.field_606_ap * (double)var25, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }

            var22 = 0.8F;
         }

         this.field_608_an *= (double)var22;
         this.field_607_ao *= (double)var22;
         this.field_606_ap *= (double)var22;
         this.field_607_ao -= (double)var10;
         this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      }
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("xTile", (short)this.field_9319_c);
      p_352_1_.func_749_a("yTile", (short)this.field_9318_d);
      p_352_1_.func_749_a("zTile", (short)this.field_9317_e);
      p_352_1_.func_761_a("inTile", (byte)this.field_9316_f);
      p_352_1_.func_761_a("inData", (byte)this.field_28019_h);
      p_352_1_.func_761_a("shake", (byte)this.field_688_a);
      p_352_1_.func_761_a("inGround", (byte)(this.field_9315_g?1:0));
      p_352_1_.func_748_a("player", this.field_28020_a);
      p_352_1_.func_765_a("damage", this.field_46026_at);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      this.field_9319_c = p_357_1_.func_745_d("xTile");
      this.field_9318_d = p_357_1_.func_745_d("yTile");
      this.field_9317_e = p_357_1_.func_745_d("zTile");
      this.field_9316_f = p_357_1_.func_746_c("inTile") & 255;
      this.field_28019_h = p_357_1_.func_746_c("inData") & 255;
      this.field_688_a = p_357_1_.func_746_c("shake") & 255;
      this.field_9315_g = p_357_1_.func_746_c("inGround") == 1;
      this.field_28020_a = p_357_1_.func_760_m("player");
      if(p_357_1_.func_751_b("damage")) {
         this.field_46026_at = p_357_1_.func_757_h("damage");
      }

   }

   public void func_6378_b(EntityPlayer p_6378_1_) {
      if(!this.field_615_ag.field_1026_y) {
         if(this.field_9315_g && this.field_28020_a && this.field_688_a <= 0 && p_6378_1_.field_778_b.func_504_a(new ItemStack(Item.field_226_j, 1))) {
            this.field_615_ag.func_623_a(this, "random.pop", 0.2F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            p_6378_1_.func_443_a_(this, 1);
            this.func_395_F();
         }

      }
   }

   public float func_392_h_() {
      return 0.0F;
   }

   public void func_46024_b(double p_46024_1_) {
      this.field_46026_at = p_46024_1_;
   }

   public double func_46025_l() {
      return this.field_46026_at;
   }

   public void func_46023_b(int p_46023_1_) {
      this.field_46027_au = p_46023_1_;
   }

   public boolean func_48080_j() {
      return false;
   }
}
