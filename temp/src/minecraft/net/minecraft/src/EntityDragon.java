package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockEndPortal;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDragonBase;
import net.minecraft.src.EntityDragonPart;
import net.minecraft.src.EntityEnderCrystal;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityDragon extends EntityDragonBase {

   public double field_40167_a;
   public double field_40165_b;
   public double field_40166_c;
   public double[][] field_40162_d = new double[64][3];
   public int field_40164_e = -1;
   public EntityDragonPart[] field_40176_ao;
   public EntityDragonPart field_40177_ap;
   public EntityDragonPart field_40171_aq;
   public EntityDragonPart field_40170_ar;
   public EntityDragonPart field_40169_as;
   public EntityDragonPart field_40168_at;
   public EntityDragonPart field_40175_au;
   public EntityDragonPart field_40174_av;
   public float field_40173_aw = 0.0F;
   public float field_40172_ax = 0.0F;
   public boolean field_40163_ay = false;
   public boolean field_40161_az = false;
   private Entity field_40179_aC;
   public int field_40178_aA = 0;
   public EntityEnderCrystal field_41013_bH = null;


   public EntityDragon(World p_i499_1_) {
      super(p_i499_1_);
      this.field_40176_ao = new EntityDragonPart[]{this.field_40177_ap = new EntityDragonPart(this, "head", 6.0F, 6.0F), this.field_40171_aq = new EntityDragonPart(this, "body", 8.0F, 8.0F), this.field_40170_ar = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_40169_as = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_40168_at = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_40175_au = new EntityDragonPart(this, "wing", 4.0F, 4.0F), this.field_40174_av = new EntityDragonPart(this, "wing", 4.0F, 4.0F)};
      this.field_40157_aB = 200;
      this.func_40121_k(this.field_40157_aB);
      this.field_9357_z = "/mob/enderdragon/ender.png";
      this.func_371_a(16.0F, 8.0F);
      this.field_9314_ba = true;
      this.field_9304_bm = true;
      this.field_40165_b = 100.0D;
      this.field_28016_bK = true;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, new Integer(this.field_40157_aB));
   }

   public double[] func_40160_a(int p_40160_1_, float p_40160_2_) {
      if(this.field_9337_J <= 0) {
         p_40160_2_ = 0.0F;
      }

      p_40160_2_ = 1.0F - p_40160_2_;
      int var3 = this.field_40164_e - p_40160_1_ * 1 & 63;
      int var4 = this.field_40164_e - p_40160_1_ * 1 - 1 & 63;
      double[] var5 = new double[3];
      double var6 = this.field_40162_d[var3][0];

      double var8;
      for(var8 = this.field_40162_d[var4][0] - var6; var8 < -180.0D; var8 += 360.0D) {
         ;
      }

      while(var8 >= 180.0D) {
         var8 -= 360.0D;
      }

      var5[0] = var6 + var8 * (double)p_40160_2_;
      var6 = this.field_40162_d[var3][1];
      var8 = this.field_40162_d[var4][1] - var6;
      var5[1] = var6 + var8 * (double)p_40160_2_;
      var5[2] = this.field_40162_d[var3][2] + (this.field_40162_d[var4][2] - this.field_40162_d[var3][2]) * (double)p_40160_2_;
      return var5;
   }

   public void func_425_j() {
      this.field_40173_aw = this.field_40172_ax;
      if(!this.field_615_ag.field_1026_y) {
         this.field_21064_bx.func_21129_b(16, Integer.valueOf(this.field_9337_J));
      }

      float var1;
      float var3;
      float var26;
      if(this.field_9337_J <= 0) {
         var1 = (this.field_9312_bd.nextFloat() - 0.5F) * 8.0F;
         var26 = (this.field_9312_bd.nextFloat() - 0.5F) * 4.0F;
         var3 = (this.field_9312_bd.nextFloat() - 0.5F) * 8.0F;
         this.field_615_ag.func_694_a("largeexplode", this.field_611_ak + (double)var1, this.field_610_al + 2.0D + (double)var26, this.field_609_am + (double)var3, 0.0D, 0.0D, 0.0D);
      } else {
         this.func_41011_ay();
         var1 = 0.2F / (MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap) * 10.0F + 1.0F);
         var1 *= (float)Math.pow(2.0D, this.field_607_ao);
         if(this.field_40161_az) {
            this.field_40172_ax += var1 * 0.5F;
         } else {
            this.field_40172_ax += var1;
         }

         while(this.field_605_aq >= 180.0F) {
            this.field_605_aq -= 360.0F;
         }

         while(this.field_605_aq < -180.0F) {
            this.field_605_aq += 360.0F;
         }

         if(this.field_40164_e < 0) {
            for(int var2 = 0; var2 < this.field_40162_d.length; ++var2) {
               this.field_40162_d[var2][0] = (double)this.field_605_aq;
               this.field_40162_d[var2][1] = this.field_610_al;
            }
         }

         if(++this.field_40164_e == this.field_40162_d.length) {
            this.field_40164_e = 0;
         }

         this.field_40162_d[this.field_40164_e][0] = (double)this.field_605_aq;
         this.field_40162_d[this.field_40164_e][1] = this.field_610_al;
         double var4;
         double var6;
         double var8;
         double var25;
         float var31;
         if(this.field_615_ag.field_1026_y) {
            if(this.field_9324_Y > 0) {
               var25 = this.field_611_ak + (this.field_9323_Z - this.field_611_ak) / (double)this.field_9324_Y;
               var4 = this.field_610_al + (this.field_9356_aa - this.field_610_al) / (double)this.field_9324_Y;
               var6 = this.field_609_am + (this.field_9354_ab - this.field_609_am) / (double)this.field_9324_Y;

               for(var8 = this.field_9352_ac - (double)this.field_605_aq; var8 < -180.0D; var8 += 360.0D) {
                  ;
               }

               while(var8 >= 180.0D) {
                  var8 -= 360.0D;
               }

               this.field_605_aq = (float)((double)this.field_605_aq + var8 / (double)this.field_9324_Y);
               this.field_604_ar = (float)((double)this.field_604_ar + (this.field_9350_ad - (double)this.field_604_ar) / (double)this.field_9324_Y);
               --this.field_9324_Y;
               this.func_347_a(var25, var4, var6);
               this.func_376_c(this.field_605_aq, this.field_604_ar);
            }
         } else {
            var25 = this.field_40167_a - this.field_611_ak;
            var4 = this.field_40165_b - this.field_610_al;
            var6 = this.field_40166_c - this.field_609_am;
            var8 = var25 * var25 + var4 * var4 + var6 * var6;
            if(this.field_40179_aC != null) {
               this.field_40167_a = this.field_40179_aC.field_611_ak;
               this.field_40166_c = this.field_40179_aC.field_609_am;
               double var10 = this.field_40167_a - this.field_611_ak;
               double var12 = this.field_40166_c - this.field_609_am;
               double var14 = Math.sqrt(var10 * var10 + var12 * var12);
               double var16 = 0.4000000059604645D + var14 / 80.0D - 1.0D;
               if(var16 > 10.0D) {
                  var16 = 10.0D;
               }

               this.field_40165_b = this.field_40179_aC.field_601_au.field_1697_b + var16;
            } else {
               this.field_40167_a += this.field_9312_bd.nextGaussian() * 2.0D;
               this.field_40166_c += this.field_9312_bd.nextGaussian() * 2.0D;
            }

            if(this.field_40163_ay || var8 < 100.0D || var8 > 22500.0D || this.field_9297_aI || this.field_9296_aJ) {
               this.func_41006_aA();
            }

            var4 /= (double)MathHelper.func_1109_a(var25 * var25 + var6 * var6);
            var31 = 0.6F;
            if(var4 < (double)(-var31)) {
               var4 = (double)(-var31);
            }

            if(var4 > (double)var31) {
               var4 = (double)var31;
            }

            for(this.field_607_ao += var4 * 0.10000000149011612D; this.field_605_aq < -180.0F; this.field_605_aq += 360.0F) {
               ;
            }

            while(this.field_605_aq >= 180.0F) {
               this.field_605_aq -= 360.0F;
            }

            double var11 = 180.0D - Math.atan2(var25, var6) * 180.0D / 3.1415927410125732D;

            double var13;
            for(var13 = var11 - (double)this.field_605_aq; var13 < -180.0D; var13 += 360.0D) {
               ;
            }

            while(var13 >= 180.0D) {
               var13 -= 360.0D;
            }

            if(var13 > 50.0D) {
               var13 = 50.0D;
            }

            if(var13 < -50.0D) {
               var13 = -50.0D;
            }

            Vec3D var15 = Vec3D.func_1248_b(this.field_40167_a - this.field_611_ak, this.field_40165_b - this.field_610_al, this.field_40166_c - this.field_609_am).func_1252_b();
            Vec3D var39 = Vec3D.func_1248_b((double)MathHelper.func_1106_a(this.field_605_aq * 3.1415927F / 180.0F), this.field_607_ao, (double)(-MathHelper.func_1114_b(this.field_605_aq * 3.1415927F / 180.0F))).func_1252_b();
            float var17 = (float)(var39.func_35612_b(var15) + 0.5D) / 1.5F;
            if(var17 < 0.0F) {
               var17 = 0.0F;
            }

            this.field_9338_aj *= 0.8F;
            float var18 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap) * 1.0F + 1.0F;
            double var19 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap) * 1.0D + 1.0D;
            if(var19 > 40.0D) {
               var19 = 40.0D;
            }

            this.field_9338_aj = (float)((double)this.field_9338_aj + var13 * (0.699999988079071D / var19 / (double)var18));
            this.field_605_aq += this.field_9338_aj * 0.1F;
            float var21 = (float)(2.0D / (var19 + 1.0D));
            float var22 = 0.06F;
            this.func_351_a(0.0F, -1.0F, var22 * (var17 * var21 + (1.0F - var21)));
            if(this.field_40161_az) {
               this.func_349_c(this.field_608_an * 0.800000011920929D, this.field_607_ao * 0.800000011920929D, this.field_606_ap * 0.800000011920929D);
            } else {
               this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            }

            Vec3D var23 = Vec3D.func_1248_b(this.field_608_an, this.field_607_ao, this.field_606_ap).func_1252_b();
            float var24 = (float)(var23.func_35612_b(var39) + 1.0D) / 2.0F;
            var24 = 0.8F + 0.15F * var24;
            this.field_608_an *= (double)var24;
            this.field_606_ap *= (double)var24;
            this.field_607_ao *= 0.9100000262260437D;
         }

         this.field_735_n = this.field_605_aq;
         this.field_40177_ap.field_644_aC = this.field_40177_ap.field_643_aD = 3.0F;
         this.field_40170_ar.field_644_aC = this.field_40170_ar.field_643_aD = 2.0F;
         this.field_40169_as.field_644_aC = this.field_40169_as.field_643_aD = 2.0F;
         this.field_40168_at.field_644_aC = this.field_40168_at.field_643_aD = 2.0F;
         this.field_40171_aq.field_643_aD = 3.0F;
         this.field_40171_aq.field_644_aC = 5.0F;
         this.field_40175_au.field_643_aD = 2.0F;
         this.field_40175_au.field_644_aC = 4.0F;
         this.field_40174_av.field_643_aD = 3.0F;
         this.field_40174_av.field_644_aC = 4.0F;
         var26 = (float)(this.func_40160_a(5, 1.0F)[1] - this.func_40160_a(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
         var3 = MathHelper.func_1114_b(var26);
         float var27 = -MathHelper.func_1106_a(var26);
         float var5 = this.field_605_aq * 3.1415927F / 180.0F;
         float var28 = MathHelper.func_1106_a(var5);
         float var7 = MathHelper.func_1114_b(var5);
         this.field_40171_aq.func_370_e_();
         this.field_40171_aq.func_365_c(this.field_611_ak + (double)(var28 * 0.5F), this.field_610_al, this.field_609_am - (double)(var7 * 0.5F), 0.0F, 0.0F);
         this.field_40175_au.func_370_e_();
         this.field_40175_au.func_365_c(this.field_611_ak + (double)(var7 * 4.5F), this.field_610_al + 2.0D, this.field_609_am + (double)(var28 * 4.5F), 0.0F, 0.0F);
         this.field_40174_av.func_370_e_();
         this.field_40174_av.func_365_c(this.field_611_ak - (double)(var7 * 4.5F), this.field_610_al + 2.0D, this.field_609_am - (double)(var28 * 4.5F), 0.0F, 0.0F);
         if(!this.field_615_ag.field_1026_y) {
            this.func_41007_az();
         }

         if(!this.field_615_ag.field_1026_y && this.field_9332_M == 0) {
            this.func_41008_a(this.field_615_ag.func_659_b(this, this.field_40175_au.field_601_au.func_1177_b(4.0D, 2.0D, 4.0D).func_1174_d(0.0D, -2.0D, 0.0D)));
            this.func_41008_a(this.field_615_ag.func_659_b(this, this.field_40174_av.field_601_au.func_1177_b(4.0D, 2.0D, 4.0D).func_1174_d(0.0D, -2.0D, 0.0D)));
            this.func_41009_b(this.field_615_ag.func_659_b(this, this.field_40177_ap.field_601_au.func_1177_b(1.0D, 1.0D, 1.0D)));
         }

         double[] var29 = this.func_40160_a(5, 1.0F);
         double[] var9 = this.func_40160_a(0, 1.0F);
         var31 = MathHelper.func_1106_a(this.field_605_aq * 3.1415927F / 180.0F - this.field_9338_aj * 0.01F);
         float var33 = MathHelper.func_1114_b(this.field_605_aq * 3.1415927F / 180.0F - this.field_9338_aj * 0.01F);
         this.field_40177_ap.func_370_e_();
         this.field_40177_ap.func_365_c(this.field_611_ak + (double)(var31 * 5.5F * var3), this.field_610_al + (var9[1] - var29[1]) * 1.0D + (double)(var27 * 5.5F), this.field_609_am - (double)(var33 * 5.5F * var3), 0.0F, 0.0F);

         for(int var30 = 0; var30 < 3; ++var30) {
            EntityDragonPart var32 = null;
            if(var30 == 0) {
               var32 = this.field_40170_ar;
            }

            if(var30 == 1) {
               var32 = this.field_40169_as;
            }

            if(var30 == 2) {
               var32 = this.field_40168_at;
            }

            double[] var34 = this.func_40160_a(12 + var30 * 2, 1.0F);
            float var35 = this.field_605_aq * 3.1415927F / 180.0F + this.func_40159_b(var34[0] - var29[0]) * 3.1415927F / 180.0F * 1.0F;
            float var37 = MathHelper.func_1106_a(var35);
            float var36 = MathHelper.func_1114_b(var35);
            float var38 = 1.5F;
            float var40 = (float)(var30 + 1) * 2.0F;
            var32.func_370_e_();
            var32.func_365_c(this.field_611_ak - (double)((var28 * var38 + var37 * var40) * var3), this.field_610_al + (var34[1] - var29[1]) * 1.0D - (double)((var40 + var38) * var27) + 1.5D, this.field_609_am + (double)((var7 * var38 + var36 * var40) * var3), 0.0F, 0.0F);
         }

         if(!this.field_615_ag.field_1026_y) {
            this.field_40161_az = this.func_40158_a(this.field_40177_ap.field_601_au) | this.func_40158_a(this.field_40171_aq.field_601_au);
         }

      }
   }

   private void func_41011_ay() {
      if(this.field_41013_bH != null) {
         if(this.field_41013_bH.field_646_aA) {
            if(!this.field_615_ag.field_1026_y) {
               this.func_40156_a(this.field_40177_ap, DamageSource.field_35548_k, 10);
            }

            this.field_41013_bH = null;
         } else if(this.field_9311_be % 10 == 0 && this.field_9337_J < this.field_40157_aB) {
            ++this.field_9337_J;
         }
      }

      if(this.field_9312_bd.nextInt(10) == 0) {
         float var1 = 32.0F;
         List var2 = this.field_615_ag.func_657_a(EntityEnderCrystal.class, this.field_601_au.func_1177_b((double)var1, (double)var1, (double)var1));
         EntityEnderCrystal var3 = null;
         double var4 = Double.MAX_VALUE;
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            Entity var7 = (Entity)var6.next();
            double var8 = var7.func_387_e(this);
            if(var8 < var4) {
               var4 = var8;
               var3 = (EntityEnderCrystal)var7;
            }
         }

         this.field_41013_bH = var3;
      }

   }

   private void func_41007_az() {}

   private void func_41008_a(List p_41008_1_) {
      double var2 = (this.field_40171_aq.field_601_au.field_1698_a + this.field_40171_aq.field_601_au.field_1703_d) / 2.0D;
      double var4 = (this.field_40171_aq.field_601_au.field_1704_c + this.field_40171_aq.field_601_au.field_1701_f) / 2.0D;
      Iterator var6 = p_41008_1_.iterator();

      while(var6.hasNext()) {
         Entity var7 = (Entity)var6.next();
         if(var7 instanceof EntityLiving) {
            double var8 = var7.field_611_ak - var2;
            double var10 = var7.field_609_am - var4;
            double var12 = var8 * var8 + var10 * var10;
            var7.func_348_f(var8 / var12 * 4.0D, 0.20000000298023224D, var10 / var12 * 4.0D);
         }
      }

   }

   private void func_41009_b(List p_41009_1_) {
      for(int var2 = 0; var2 < p_41009_1_.size(); ++var2) {
         Entity var3 = (Entity)p_41009_1_.get(var2);
         if(var3 instanceof EntityLiving) {
            var3.func_396_a(DamageSource.func_35525_a(this), 10);
         }
      }

   }

   private void func_41006_aA() {
      this.field_40163_ay = false;
      if(this.field_9312_bd.nextInt(2) == 0 && this.field_615_ag.field_1040_k.size() > 0) {
         this.field_40179_aC = (Entity)this.field_615_ag.field_1040_k.get(this.field_9312_bd.nextInt(this.field_615_ag.field_1040_k.size()));
      } else {
         boolean var1 = false;

         do {
            this.field_40167_a = 0.0D;
            this.field_40165_b = (double)(70.0F + this.field_9312_bd.nextFloat() * 50.0F);
            this.field_40166_c = 0.0D;
            this.field_40167_a += (double)(this.field_9312_bd.nextFloat() * 120.0F - 60.0F);
            this.field_40166_c += (double)(this.field_9312_bd.nextFloat() * 120.0F - 60.0F);
            double var2 = this.field_611_ak - this.field_40167_a;
            double var4 = this.field_610_al - this.field_40165_b;
            double var6 = this.field_609_am - this.field_40166_c;
            var1 = var2 * var2 + var4 * var4 + var6 * var6 > 100.0D;
         } while(!var1);

         this.field_40179_aC = null;
      }

   }

   private float func_40159_b(double p_40159_1_) {
      while(p_40159_1_ >= 180.0D) {
         p_40159_1_ -= 360.0D;
      }

      while(p_40159_1_ < -180.0D) {
         p_40159_1_ += 360.0D;
      }

      return (float)p_40159_1_;
   }

   private boolean func_40158_a(AxisAlignedBB p_40158_1_) {
      int var2 = MathHelper.func_1108_b(p_40158_1_.field_1698_a);
      int var3 = MathHelper.func_1108_b(p_40158_1_.field_1697_b);
      int var4 = MathHelper.func_1108_b(p_40158_1_.field_1704_c);
      int var5 = MathHelper.func_1108_b(p_40158_1_.field_1703_d);
      int var6 = MathHelper.func_1108_b(p_40158_1_.field_1702_e);
      int var7 = MathHelper.func_1108_b(p_40158_1_.field_1701_f);
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var2; var10 <= var5; ++var10) {
         for(int var11 = var3; var11 <= var6; ++var11) {
            for(int var12 = var4; var12 <= var7; ++var12) {
               int var13 = this.field_615_ag.func_600_a(var10, var11, var12);
               if(var13 != 0) {
                  if(var13 != Block.field_405_aq.field_376_bc && var13 != Block.field_40203_bK.field_376_bc && var13 != Block.field_403_A.field_376_bc) {
                     var9 = true;
                     this.field_615_ag.func_690_d(var10, var11, var12, 0);
                  } else {
                     var8 = true;
                  }
               }
            }
         }
      }

      if(var9) {
         double var16 = p_40158_1_.field_1698_a + (p_40158_1_.field_1703_d - p_40158_1_.field_1698_a) * (double)this.field_9312_bd.nextFloat();
         double var17 = p_40158_1_.field_1697_b + (p_40158_1_.field_1702_e - p_40158_1_.field_1697_b) * (double)this.field_9312_bd.nextFloat();
         double var14 = p_40158_1_.field_1704_c + (p_40158_1_.field_1701_f - p_40158_1_.field_1704_c) * (double)this.field_9312_bd.nextFloat();
         this.field_615_ag.func_694_a("largeexplode", var16, var17, var14, 0.0D, 0.0D, 0.0D);
      }

      return var8;
   }

   public boolean func_40156_a(EntityDragonPart p_40156_1_, DamageSource p_40156_2_, int p_40156_3_) {
      if(p_40156_1_ != this.field_40177_ap) {
         p_40156_3_ = p_40156_3_ / 4 + 1;
      }

      float var4 = this.field_605_aq * 3.1415927F / 180.0F;
      float var5 = MathHelper.func_1106_a(var4);
      float var6 = MathHelper.func_1114_b(var4);
      this.field_40167_a = this.field_611_ak + (double)(var5 * 5.0F) + (double)((this.field_9312_bd.nextFloat() - 0.5F) * 2.0F);
      this.field_40165_b = this.field_610_al + (double)(this.field_9312_bd.nextFloat() * 3.0F) + 1.0D;
      this.field_40166_c = this.field_609_am - (double)(var6 * 5.0F) + (double)((this.field_9312_bd.nextFloat() - 0.5F) * 2.0F);
      this.field_40179_aC = null;
      if(p_40156_2_.func_35532_a() instanceof EntityPlayer || p_40156_2_ == DamageSource.field_35548_k) {
         this.func_40155_e(p_40156_2_, p_40156_3_);
      }

      return true;
   }

   protected void func_40120_m_() {
      ++this.field_40178_aA;
      if(this.field_40178_aA >= 180 && this.field_40178_aA <= 200) {
         float var1 = (this.field_9312_bd.nextFloat() - 0.5F) * 8.0F;
         float var2 = (this.field_9312_bd.nextFloat() - 0.5F) * 4.0F;
         float var3 = (this.field_9312_bd.nextFloat() - 0.5F) * 8.0F;
         this.field_615_ag.func_694_a("hugeexplosion", this.field_611_ak + (double)var1, this.field_610_al + 2.0D + (double)var2, this.field_609_am + (double)var3, 0.0D, 0.0D, 0.0D);
      }

      int var4;
      int var5;
      if(!this.field_615_ag.field_1026_y && this.field_40178_aA > 150 && this.field_40178_aA % 5 == 0) {
         var4 = 1000;

         while(var4 > 0) {
            var5 = EntityXPOrb.func_35121_b(var4);
            var4 -= var5;
            this.field_615_ag.func_674_a(new EntityXPOrb(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, var5));
         }
      }

      this.func_349_c(0.0D, 0.10000000149011612D, 0.0D);
      this.field_735_n = this.field_605_aq += 20.0F;
      if(this.field_40178_aA == 200) {
         var4 = 10000;

         while(var4 > 0) {
            var5 = EntityXPOrb.func_35121_b(var4);
            var4 -= var5;
            this.field_615_ag.func_674_a(new EntityXPOrb(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, var5));
         }

         this.func_41012_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_609_am));
         this.func_6392_F();
         this.func_395_F();
      }

   }

   private void func_41012_a(int p_41012_1_, int p_41012_2_) {
      byte var3 = 64;
      BlockEndPortal.field_41051_a = true;
      byte var4 = 4;

      for(int var5 = var3 - 1; var5 <= var3 + 32; ++var5) {
         for(int var6 = p_41012_1_ - var4; var6 <= p_41012_1_ + var4; ++var6) {
            for(int var7 = p_41012_2_ - var4; var7 <= p_41012_2_ + var4; ++var7) {
               double var8 = (double)(var6 - p_41012_1_);
               double var10 = (double)(var7 - p_41012_2_);
               double var12 = (double)MathHelper.func_1109_a(var8 * var8 + var10 * var10);
               if(var12 <= (double)var4 - 0.5D) {
                  if(var5 < var3) {
                     if(var12 <= (double)(var4 - 1) - 0.5D) {
                        this.field_615_ag.func_690_d(var6, var5, var7, Block.field_403_A.field_376_bc);
                     }
                  } else if(var5 > var3) {
                     this.field_615_ag.func_690_d(var6, var5, var7, 0);
                  } else if(var12 > (double)(var4 - 1) - 0.5D) {
                     this.field_615_ag.func_690_d(var6, var5, var7, Block.field_403_A.field_376_bc);
                  } else {
                     this.field_615_ag.func_690_d(var6, var5, var7, Block.field_40209_bI.field_376_bc);
                  }
               }
            }
         }
      }

      this.field_615_ag.func_690_d(p_41012_1_, var3 + 0, p_41012_2_, Block.field_403_A.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_, var3 + 1, p_41012_2_, Block.field_403_A.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_, var3 + 2, p_41012_2_, Block.field_403_A.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_ - 1, var3 + 2, p_41012_2_, Block.field_404_ar.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_ + 1, var3 + 2, p_41012_2_, Block.field_404_ar.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_, var3 + 2, p_41012_2_ - 1, Block.field_404_ar.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_, var3 + 2, p_41012_2_ + 1, Block.field_404_ar.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_, var3 + 3, p_41012_2_, Block.field_403_A.field_376_bc);
      this.field_615_ag.func_690_d(p_41012_1_, var3 + 4, p_41012_2_, Block.field_41050_bK.field_376_bc);
      BlockEndPortal.field_41051_a = false;
   }

   protected void func_27021_X() {}

   public Entity[] func_40048_X() {
      return this.field_40176_ao;
   }

   public boolean func_401_c_() {
      return false;
   }

   public int func_41010_ax() {
      return this.field_21064_bx.func_25115_b(16);
   }
}
