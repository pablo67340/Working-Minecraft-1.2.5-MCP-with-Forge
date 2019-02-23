package net.minecraft.src;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAITasks;
import net.minecraft.src.EntityBodyHelper;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityJumpHelper;
import net.minecraft.src.EntityLookHelper;
import net.minecraft.src.EntityMoveHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySenses;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.PotionHelper;
import net.minecraft.src.Profiler;
import net.minecraft.src.StepSound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class EntityLiving extends Entity {

   public int field_9366_o = 20;
   public float field_9365_p;
   public float field_9363_r;
   public float field_735_n = 0.0F;
   public float field_734_o = 0.0F;
   public float field_46015_bf = 0.0F;
   public float field_46016_bg = 0.0F;
   protected float field_9362_u;
   protected float field_9361_v;
   protected float field_9360_w;
   protected float field_9359_x;
   protected boolean field_9358_y = true;
   protected String field_9357_z = "/mob/char.png";
   protected boolean field_9355_A = true;
   protected float field_9353_B = 0.0F;
   protected String field_9351_C = null;
   protected float field_9349_D = 1.0F;
   protected int field_9347_E = 0;
   protected float field_9345_F = 0.0F;
   public float field_35169_bv = 0.1F;
   public float field_35168_bw = 0.02F;
   public float field_9341_H;
   public float field_9339_I;
   protected int field_9337_J = this.func_40117_c();
   public int field_9335_K;
   protected int field_40129_bA;
   private int field_4121_a;
   public int field_715_G;
   public int field_9332_M;
   public float field_9331_N = 0.0F;
   public int field_712_J = 0;
   public int field_9330_P = 0;
   public float field_9329_Q;
   public float field_9328_R;
   protected boolean field_9327_S = false;
   protected int field_35171_bJ;
   public int field_9326_T = -1;
   public float field_9325_U = (float)(Math.random() * 0.8999999761581421D + 0.10000000149011612D);
   public float field_705_Q;
   public float field_704_R;
   public float field_703_S;
   protected EntityPlayer field_34904_b = null;
   protected int field_34905_c = 0;
   private EntityLiving field_46020_bQ = null;
   private int field_48103_c = 0;
   private EntityLiving field_48102_d = null;
   public int field_35172_bP = 0;
   public int field_35173_bQ = 0;
   protected HashMap field_35170_bR = new HashMap();
   private boolean field_39001_b = true;
   private int field_39002_c;
   private EntityLookHelper field_46017_d;
   private EntityMoveHelper field_46018_e;
   private EntityJumpHelper field_46021_am;
   private EntityBodyHelper field_48108_aq;
   private PathNavigate field_48107_ar;
   protected EntityAITasks field_46019_bU = new EntityAITasks();
   protected EntityAITasks field_48105_bU = new EntityAITasks();
   private EntityLiving field_48106_as;
   private EntitySenses field_48104_at;
   private float field_48111_au;
   private ChunkCoordinates field_48110_av = new ChunkCoordinates(0, 0, 0);
   private float field_48109_aw = -1.0F;
   protected int field_9324_Y;
   protected double field_9323_Z;
   protected double field_9356_aa;
   protected double field_9354_ab;
   protected double field_9352_ac;
   protected double field_9350_ad;
   float field_9348_ae = 0.0F;
   protected int field_9346_af = 0;
   protected int field_9344_ag = 0;
   protected float field_9342_ah;
   protected float field_9340_ai;
   protected float field_9338_aj;
   protected boolean field_9336_ak = false;
   protected float field_9334_al = 0.0F;
   protected float field_9333_am = 0.7F;
   private int field_39003_d = 0;
   private Entity field_4120_b;
   protected int field_4127_c = 0;


   public EntityLiving(World p_i19_1_) {
      super(p_i19_1_);
      this.field_618_ad = true;
      this.field_46017_d = new EntityLookHelper(this);
      this.field_46018_e = new EntityMoveHelper(this);
      this.field_46021_am = new EntityJumpHelper(this);
      this.field_48108_aq = new EntityBodyHelper(this);
      this.field_48107_ar = new PathNavigate(this, p_i19_1_, 16.0F);
      this.field_48104_at = new EntitySenses(this);
      this.field_9363_r = (float)(Math.random() + 1.0D) * 0.01F;
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.field_9365_p = (float)Math.random() * 12398.0F;
      this.field_605_aq = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.field_46015_bf = this.field_605_aq;
      this.field_9286_aZ = 0.5F;
   }

   public EntityLookHelper func_46008_aG() {
      return this.field_46017_d;
   }

   public EntityMoveHelper func_46009_aH() {
      return this.field_46018_e;
   }

   public EntityJumpHelper func_46005_aI() {
      return this.field_46021_am;
   }

   public PathNavigate func_48084_aL() {
      return this.field_48107_ar;
   }

   public EntitySenses func_48090_aM() {
      return this.field_48104_at;
   }

   public Random func_46004_aK() {
      return this.field_9312_bd;
   }

   public EntityLiving func_46007_aL() {
      return this.field_46020_bQ;
   }

   public EntityLiving func_48088_aP() {
      return this.field_48102_d;
   }

   public void func_48089_l(Entity p_48089_1_) {
      if(p_48089_1_ instanceof EntityLiving) {
         this.field_48102_d = (EntityLiving)p_48089_1_;
      }

   }

   public int func_46011_aM() {
      return this.field_9344_ag;
   }

   public void func_48079_f(float p_48079_1_) {
      this.field_46015_bf = p_48079_1_;
   }

   public float func_48101_aR() {
      return this.field_48111_au;
   }

   public void func_48098_g(float p_48098_1_) {
      this.field_48111_au = p_48098_1_;
      this.func_46010_f(p_48098_1_);
   }

   public boolean func_35175_b(Entity p_35175_1_) {
      this.func_48089_l(p_35175_1_);
      return false;
   }

   public EntityLiving func_48094_aS() {
      return this.field_48106_as;
   }

   public void func_48092_c(EntityLiving p_48092_1_) {
      this.field_48106_as = p_48092_1_;
   }

   public boolean func_48100_a(Class p_48100_1_) {
      return EntityCreeper.class != p_48100_1_ && EntityGhast.class != p_48100_1_;
   }

   public void func_48095_u() {}

   public boolean func_48093_aT() {
      return this.func_48096_f(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
   }

   public boolean func_48096_f(int p_48096_1_, int p_48096_2_, int p_48096_3_) {
      return this.field_48109_aw == -1.0F?true:this.field_48110_av.func_48655_c(p_48096_1_, p_48096_2_, p_48096_3_) < this.field_48109_aw * this.field_48109_aw;
   }

   public void func_48082_b(int p_48082_1_, int p_48082_2_, int p_48082_3_, int p_48082_4_) {
      this.field_48110_av.func_48656_a(p_48082_1_, p_48082_2_, p_48082_3_);
      this.field_48109_aw = (float)p_48082_4_;
   }

   public ChunkCoordinates func_48091_aU() {
      return this.field_48110_av;
   }

   public float func_48099_aV() {
      return this.field_48109_aw;
   }

   public void func_48083_aW() {
      this.field_48109_aw = -1.0F;
   }

   public boolean func_48087_aX() {
      return this.field_48109_aw != -1.0F;
   }

   public void func_48086_a(EntityLiving p_48086_1_) {
      this.field_46020_bQ = p_48086_1_;
      this.field_48103_c = this.field_46020_bQ != null?60:0;
   }

   protected void func_21057_b() {
      this.field_21064_bx.func_21124_a(8, Integer.valueOf(this.field_39002_c));
   }

   public boolean func_420_c(Entity p_420_1_) {
      return this.field_615_ag.func_645_a(Vec3D.func_1248_b(this.field_611_ak, this.field_610_al + (double)this.func_373_s(), this.field_609_am), Vec3D.func_1248_b(p_420_1_.field_611_ak, p_420_1_.field_610_al + (double)p_420_1_.func_373_s(), p_420_1_.field_609_am)) == null;
   }

   public String func_6376_z() {
      return this.field_9357_z;
   }

   public boolean func_401_c_() {
      return !this.field_646_aA;
   }

   public boolean func_385_d_() {
      return !this.field_646_aA;
   }

   public float func_373_s() {
      return this.field_643_aD * 0.85F;
   }

   public int func_421_b() {
      return 80;
   }

   public void func_22050_O() {
      String var1 = this.func_6389_d();
      if(var1 != null) {
         this.field_615_ag.func_623_a(this, var1, this.func_6393_h(), this.func_40123_ac());
      }

   }

   public void func_391_y() {
      this.field_9341_H = this.field_9339_I;
      super.func_391_y();
      Profiler.func_40663_a("mobBaseTick");
      if(this.func_354_B() && this.field_9312_bd.nextInt(1000) < this.field_4121_a++) {
         this.field_4121_a = -this.func_421_b();
         this.func_22050_O();
      }

      if(this.func_354_B() && this.func_345_I() && this.func_396_a(DamageSource.field_35538_d, 1)) {
         ;
      }

      if(this.func_40047_D() || this.field_615_ag.field_1026_y) {
         this.func_40045_B();
      }

      if(this.func_354_B() && this.func_393_a(Material.field_1332_f) && !this.func_21067_c_() && !this.field_35170_bR.containsKey(Integer.valueOf(Potion.field_35680_o.field_35670_H))) {
         this.func_41003_g(this.func_40116_f(this.func_41001_Z()));
         if(this.func_41001_Z() == -20) {
            this.func_41003_g(0);

            for(int var1 = 0; var1 < 8; ++var1) {
               float var2 = this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat();
               float var3 = this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat();
               float var4 = this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat();
               this.field_615_ag.func_694_a("bubble", this.field_611_ak + (double)var2, this.field_610_al + (double)var3, this.field_609_am + (double)var4, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }

            this.func_396_a(DamageSource.field_35539_e, 2);
         }

         this.func_40045_B();
      } else {
         this.func_41003_g(300);
      }

      this.field_9329_Q = this.field_9328_R;
      if(this.field_9330_P > 0) {
         --this.field_9330_P;
      }

      if(this.field_715_G > 0) {
         --this.field_715_G;
      }

      if(this.field_9306_bj > 0) {
         --this.field_9306_bj;
      }

      if(this.field_9337_J <= 0) {
         this.func_40120_m_();
      }

      if(this.field_34905_c > 0) {
         --this.field_34905_c;
      } else {
         this.field_34904_b = null;
      }

      if(this.field_48102_d != null && !this.field_48102_d.func_354_B()) {
         this.field_48102_d = null;
      }

      if(this.field_46020_bQ != null) {
         if(!this.field_46020_bQ.func_354_B()) {
            this.func_48086_a((EntityLiving)null);
         } else if(this.field_48103_c > 0) {
            --this.field_48103_c;
         } else {
            this.func_48086_a((EntityLiving)null);
         }
      }

      this.func_36000_g();
      this.field_9359_x = this.field_9360_w;
      this.field_734_o = this.field_735_n;
      this.field_46016_bg = this.field_46015_bf;
      this.field_603_as = this.field_605_aq;
      this.field_602_at = this.field_604_ar;
      Profiler.func_40662_b();
   }

   protected void func_40120_m_() {
      ++this.field_712_J;
      if(this.field_712_J == 20) {
         int var1;
         if(!this.field_615_ag.field_1026_y && (this.field_34905_c > 0 || this.func_35163_av()) && !this.func_40127_l()) {
            var1 = this.func_36001_a(this.field_34904_b);

            while(var1 > 0) {
               int var2 = EntityXPOrb.func_35121_b(var1);
               var1 -= var2;
               this.field_615_ag.func_674_a(new EntityXPOrb(this.field_615_ag, this.field_611_ak, this.field_610_al, this.field_609_am, var2));
            }
         }

         this.func_6392_F();
         this.func_395_F();

         for(var1 = 0; var1 < 20; ++var1) {
            double var8 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
            double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
            this.field_615_ag.func_694_a("explode", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, this.field_610_al + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD), this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC, var8, var4, var6);
         }
      }

   }

   protected int func_40116_f(int p_40116_1_) {
      return p_40116_1_ - 1;
   }

   protected int func_36001_a(EntityPlayer p_36001_1_) {
      return this.field_35171_bJ;
   }

   protected boolean func_35163_av() {
      return false;
   }

   public void func_415_z() {
      for(int var1 = 0; var1 < 20; ++var1) {
         double var2 = this.field_9312_bd.nextGaussian() * 0.02D;
         double var4 = this.field_9312_bd.nextGaussian() * 0.02D;
         double var6 = this.field_9312_bd.nextGaussian() * 0.02D;
         double var8 = 10.0D;
         this.field_615_ag.func_694_a("explode", this.field_611_ak + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC - var2 * var8, this.field_610_al + (double)(this.field_9312_bd.nextFloat() * this.field_643_aD) - var4 * var8, this.field_609_am + (double)(this.field_9312_bd.nextFloat() * this.field_644_aC * 2.0F) - (double)this.field_644_aC - var6 * var8, var2, var4, var6);
      }

   }

   public void func_350_p() {
      super.func_350_p();
      this.field_9362_u = this.field_9361_v;
      this.field_9361_v = 0.0F;
      this.field_9288_aU = 0.0F;
   }

   public void func_378_a(double p_378_1_, double p_378_3_, double p_378_5_, float p_378_7_, float p_378_8_, int p_378_9_) {
      this.field_9292_aO = 0.0F;
      this.field_9323_Z = p_378_1_;
      this.field_9356_aa = p_378_3_;
      this.field_9354_ab = p_378_5_;
      this.field_9352_ac = (double)p_378_7_;
      this.field_9350_ad = (double)p_378_8_;
      this.field_9324_Y = p_378_9_;
   }

   public void func_370_e_() {
      super.func_370_e_();
      if(this.field_35172_bP > 0) {
         if(this.field_35173_bQ <= 0) {
            this.field_35173_bQ = 60;
         }

         --this.field_35173_bQ;
         if(this.field_35173_bQ <= 0) {
            --this.field_35172_bP;
         }
      }

      this.func_425_j();
      double var1 = this.field_611_ak - this.field_9285_at;
      double var3 = this.field_609_am - this.field_9283_av;
      float var5 = MathHelper.func_1109_a(var1 * var1 + var3 * var3);
      float var6 = this.field_735_n;
      float var7 = 0.0F;
      this.field_9362_u = this.field_9361_v;
      float var8 = 0.0F;
      if(var5 > 0.05F) {
         var8 = 1.0F;
         var7 = var5 * 3.0F;
         var6 = (float)Math.atan2(var3, var1) * 180.0F / 3.1415927F - 90.0F;
      }

      if(this.field_9339_I > 0.0F) {
         var6 = this.field_605_aq;
      }

      if(!this.field_9298_aH) {
         var8 = 0.0F;
      }

      this.field_9361_v += (var8 - this.field_9361_v) * 0.3F;
      if(this.func_46006_aR()) {
         this.field_48108_aq.func_48650_a();
      } else {
         float var9;
         for(var9 = var6 - this.field_735_n; var9 < -180.0F; var9 += 360.0F) {
            ;
         }

         while(var9 >= 180.0F) {
            var9 -= 360.0F;
         }

         this.field_735_n += var9 * 0.3F;

         float var10;
         for(var10 = this.field_605_aq - this.field_735_n; var10 < -180.0F; var10 += 360.0F) {
            ;
         }

         while(var10 >= 180.0F) {
            var10 -= 360.0F;
         }

         boolean var11 = var10 < -90.0F || var10 >= 90.0F;
         if(var10 < -75.0F) {
            var10 = -75.0F;
         }

         if(var10 >= 75.0F) {
            var10 = 75.0F;
         }

         this.field_735_n = this.field_605_aq - var10;
         if(var10 * var10 > 2500.0F) {
            this.field_735_n += var10 * 0.2F;
         }

         if(var11) {
            var7 *= -1.0F;
         }
      }

      while(this.field_605_aq - this.field_603_as < -180.0F) {
         this.field_603_as -= 360.0F;
      }

      while(this.field_605_aq - this.field_603_as >= 180.0F) {
         this.field_603_as += 360.0F;
      }

      while(this.field_735_n - this.field_734_o < -180.0F) {
         this.field_734_o -= 360.0F;
      }

      while(this.field_735_n - this.field_734_o >= 180.0F) {
         this.field_734_o += 360.0F;
      }

      while(this.field_604_ar - this.field_602_at < -180.0F) {
         this.field_602_at -= 360.0F;
      }

      while(this.field_604_ar - this.field_602_at >= 180.0F) {
         this.field_602_at += 360.0F;
      }

      while(this.field_46015_bf - this.field_46016_bg < -180.0F) {
         this.field_46016_bg -= 360.0F;
      }

      while(this.field_46015_bf - this.field_46016_bg >= 180.0F) {
         this.field_46016_bg += 360.0F;
      }

      this.field_9360_w += var7;
   }

   protected void func_371_a(float p_371_1_, float p_371_2_) {
      super.func_371_a(p_371_1_, p_371_2_);
   }

   public void func_432_b(int p_432_1_) {
      if(this.field_9337_J > 0) {
         this.field_9337_J += p_432_1_;
         if(this.field_9337_J > this.func_40117_c()) {
            this.field_9337_J = this.func_40117_c();
         }

         this.field_9306_bj = this.field_9366_o / 2;
      }
   }

   public abstract int func_40117_c();

   public int func_40114_aH() {
      return this.field_9337_J;
   }

   public void func_40121_k(int p_40121_1_) {
      this.field_9337_J = p_40121_1_;
      if(p_40121_1_ > this.func_40117_c()) {
         p_40121_1_ = this.func_40117_c();
      }

   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(this.field_615_ag.field_1026_y) {
         return false;
      } else {
         this.field_9344_ag = 0;
         if(this.field_9337_J <= 0) {
            return false;
         } else if(p_396_1_.func_40543_k() && this.func_35160_a(Potion.field_35679_n)) {
            return false;
         } else {
            this.field_704_R = 1.5F;
            boolean var3 = true;
            if((float)this.field_9306_bj > (float)this.field_9366_o / 2.0F) {
               if(p_396_2_ <= this.field_9346_af) {
                  return false;
               }

               this.func_4044_a(p_396_1_, p_396_2_ - this.field_9346_af);
               this.field_9346_af = p_396_2_;
               var3 = false;
            } else {
               this.field_9346_af = p_396_2_;
               this.field_9335_K = this.field_9337_J;
               this.field_9306_bj = this.field_9366_o;
               this.func_4044_a(p_396_1_, p_396_2_);
               this.field_715_G = this.field_9332_M = 10;
            }

            this.field_9331_N = 0.0F;
            Entity var4 = p_396_1_.func_35532_a();
            if(var4 != null) {
               if(var4 instanceof EntityLiving) {
                  this.func_48086_a((EntityLiving)var4);
               }

               if(var4 instanceof EntityPlayer) {
                  this.field_34905_c = 60;
                  this.field_34904_b = (EntityPlayer)var4;
               } else if(var4 instanceof EntityWolf) {
                  EntityWolf var5 = (EntityWolf)var4;
                  if(var5.func_48139_F_()) {
                     this.field_34905_c = 60;
                     this.field_34904_b = null;
                  }
               }
            }

            if(var3) {
               this.field_615_ag.func_9425_a(this, (byte)2);
               this.func_9281_M();
               if(var4 != null) {
                  double var9 = var4.field_611_ak - this.field_611_ak;

                  double var7;
                  for(var7 = var4.field_609_am - this.field_609_am; var9 * var9 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
                     var9 = (Math.random() - Math.random()) * 0.01D;
                  }

                  this.field_9331_N = (float)(Math.atan2(var7, var9) * 180.0D / 3.1415927410125732D) - this.field_605_aq;
                  this.func_434_a(var4, p_396_2_, var9, var7);
               } else {
                  this.field_9331_N = (float)((int)(Math.random() * 2.0D) * 180);
               }
            }

            if(this.field_9337_J <= 0) {
               if(var3) {
                  this.field_615_ag.func_623_a(this, this.func_6390_f(), this.func_6393_h(), this.func_40123_ac());
               }

               this.func_419_b(p_396_1_);
            } else if(var3) {
               this.field_615_ag.func_623_a(this, this.func_6394_f_(), this.func_6393_h(), this.func_40123_ac());
            }

            return true;
         }
      }
   }

   private float func_40123_ac() {
      return this.func_40127_l()?(this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.5F:(this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F;
   }

   public void func_9280_g() {
      this.field_715_G = this.field_9332_M = 10;
      this.field_9331_N = 0.0F;
   }

   public int func_40119_ar() {
      return 0;
   }

   protected void func_40125_g(int p_40125_1_) {}

   protected int func_40115_d(DamageSource p_40115_1_, int p_40115_2_) {
      if(!p_40115_1_.func_35534_b()) {
         int var3 = 25 - this.func_40119_ar();
         int var4 = p_40115_2_ * var3 + this.field_40129_bA;
         this.func_40125_g(p_40115_2_);
         p_40115_2_ = var4 / 25;
         this.field_40129_bA = var4 % 25;
      }

      return p_40115_2_;
   }

   protected int func_40128_b(DamageSource p_40128_1_, int p_40128_2_) {
      if(this.func_35160_a(Potion.field_35682_m)) {
         int var3 = (this.func_35167_b(Potion.field_35682_m).func_35801_c() + 1) * 5;
         int var4 = 25 - var3;
         int var5 = p_40128_2_ * var4 + this.field_40129_bA;
         p_40128_2_ = var5 / 25;
         this.field_40129_bA = var5 % 25;
      }

      return p_40128_2_;
   }

   protected void func_4044_a(DamageSource p_4044_1_, int p_4044_2_) {
      p_4044_2_ = this.func_40115_d(p_4044_1_, p_4044_2_);
      p_4044_2_ = this.func_40128_b(p_4044_1_, p_4044_2_);
      this.field_9337_J -= p_4044_2_;
   }

   protected float func_6393_h() {
      return 1.0F;
   }

   protected String func_6389_d() {
      return null;
   }

   protected String func_6394_f_() {
      return "damage.hurtflesh";
   }

   protected String func_6390_f() {
      return "damage.hurtflesh";
   }

   public void func_434_a(Entity p_434_1_, int p_434_2_, double p_434_3_, double p_434_5_) {
      this.field_35118_ao = true;
      float var7 = MathHelper.func_1109_a(p_434_3_ * p_434_3_ + p_434_5_ * p_434_5_);
      float var8 = 0.4F;
      this.field_608_an /= 2.0D;
      this.field_607_ao /= 2.0D;
      this.field_606_ap /= 2.0D;
      this.field_608_an -= p_434_3_ / (double)var7 * (double)var8;
      this.field_607_ao += (double)var8;
      this.field_606_ap -= p_434_5_ / (double)var7 * (double)var8;
      if(this.field_607_ao > 0.4000000059604645D) {
         this.field_607_ao = 0.4000000059604645D;
      }

   }

   public void func_419_b(DamageSource p_419_1_) {
      Entity var2 = p_419_1_.func_35532_a();
      if(this.field_9347_E >= 0 && var2 != null) {
         var2.func_364_b(this, this.field_9347_E);
      }

      if(var2 != null) {
         var2.func_27015_a(this);
      }

      this.field_9327_S = true;
      if(!this.field_615_ag.field_1026_y) {
         int var3 = 0;
         if(var2 instanceof EntityPlayer) {
            var3 = EnchantmentHelper.func_40637_f(((EntityPlayer)var2).field_778_b);
         }

         if(!this.func_40127_l()) {
            this.func_21066_o(this.field_34905_c > 0, var3);
            if(this.field_34905_c > 0) {
               int var4 = this.field_9312_bd.nextInt(200) - var3;
               if(var4 < 5) {
                  this.func_48085_j_(var4 <= 0?1:0);
               }
            }
         }
      }

      this.field_615_ag.func_9425_a(this, (byte)3);
   }

   protected void func_48085_j_(int p_48085_1_) {}

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.func_422_g();
      if(var3 > 0) {
         int var4 = this.field_9312_bd.nextInt(3);
         if(p_21066_2_ > 0) {
            var4 += this.field_9312_bd.nextInt(p_21066_2_ + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.func_367_b(var3, 1);
         }
      }

   }

   protected int func_422_g() {
      return 0;
   }

   protected void func_400_c(float p_400_1_) {
      super.func_400_c(p_400_1_);
      int var2 = (int)Math.ceil((double)(p_400_1_ - 3.0F));
      if(var2 > 0) {
         if(var2 > 4) {
            this.field_615_ag.func_623_a(this, "damage.fallbig", 1.0F, 1.0F);
         } else {
            this.field_615_ag.func_623_a(this, "damage.fallsmall", 1.0F, 1.0F);
         }

         this.func_396_a(DamageSource.field_35549_h, var2);
         int var3 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al - 0.20000000298023224D - (double)this.field_9292_aO), MathHelper.func_1108_b(this.field_609_am));
         if(var3 > 0) {
            StepSound var4 = Block.field_345_n[var3].field_358_bl;
            this.field_615_ag.func_623_a(this, var4.func_1145_d(), var4.func_1147_b() * 0.5F, var4.func_1144_c() * 0.75F);
         }
      }

   }

   public void func_435_b(float p_435_1_, float p_435_2_) {
      double var3;
      if(this.func_27013_ag()) {
         var3 = this.field_610_al;
         this.func_351_a(p_435_1_, p_435_2_, this.func_46006_aR()?0.04F:0.02F);
         this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
         this.field_608_an *= 0.800000011920929D;
         this.field_607_ao *= 0.800000011920929D;
         this.field_606_ap *= 0.800000011920929D;
         this.field_607_ao -= 0.02D;
         if(this.field_9297_aI && this.func_403_b(this.field_608_an, this.field_607_ao + 0.6000000238418579D - this.field_610_al + var3, this.field_606_ap)) {
            this.field_607_ao = 0.30000001192092896D;
         }
      } else if(this.func_359_G()) {
         var3 = this.field_610_al;
         this.func_351_a(p_435_1_, p_435_2_, 0.02F);
         this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
         this.field_608_an *= 0.5D;
         this.field_607_ao *= 0.5D;
         this.field_606_ap *= 0.5D;
         this.field_607_ao -= 0.02D;
         if(this.field_9297_aI && this.func_403_b(this.field_608_an, this.field_607_ao + 0.6000000238418579D - this.field_610_al + var3, this.field_606_ap)) {
            this.field_607_ao = 0.30000001192092896D;
         }
      } else {
         float var8 = 0.91F;
         if(this.field_9298_aH) {
            var8 = 0.54600006F;
            int var4 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
            if(var4 > 0) {
               var8 = Block.field_345_n[var4].field_355_bo * 0.91F;
            }
         }

         float var9 = 0.16277136F / (var8 * var8 * var8);
         float var5;
         if(this.field_9298_aH) {
            if(this.func_46006_aR()) {
               var5 = this.func_48101_aR();
            } else {
               var5 = this.field_35169_bv;
            }

            var5 *= var9;
         } else {
            var5 = this.field_35168_bw;
         }

         this.func_351_a(p_435_1_, p_435_2_, var5);
         var8 = 0.91F;
         if(this.field_9298_aH) {
            var8 = 0.54600006F;
            int var6 = this.field_615_ag.func_600_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_601_au.field_1697_b) - 1, MathHelper.func_1108_b(this.field_609_am));
            if(var6 > 0) {
               var8 = Block.field_345_n[var6].field_355_bo * 0.91F;
            }
         }

         if(this.func_429_A()) {
            float var10 = 0.15F;
            if(this.field_608_an < (double)(-var10)) {
               this.field_608_an = (double)(-var10);
            }

            if(this.field_608_an > (double)var10) {
               this.field_608_an = (double)var10;
            }

            if(this.field_606_ap < (double)(-var10)) {
               this.field_606_ap = (double)(-var10);
            }

            if(this.field_606_ap > (double)var10) {
               this.field_606_ap = (double)var10;
            }

            this.field_9288_aU = 0.0F;
            if(this.field_607_ao < -0.15D) {
               this.field_607_ao = -0.15D;
            }

            boolean var7 = this.func_381_o() && this instanceof EntityPlayer;
            if(var7 && this.field_607_ao < 0.0D) {
               this.field_607_ao = 0.0D;
            }
         }

         this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
         if(this.field_9297_aI && this.func_429_A()) {
            this.field_607_ao = 0.2D;
         }

         this.field_607_ao -= 0.08D;
         this.field_607_ao *= 0.9800000190734863D;
         this.field_608_an *= (double)var8;
         this.field_606_ap *= (double)var8;
      }

      this.field_705_Q = this.field_704_R;
      var3 = this.field_611_ak - this.field_9285_at;
      double var11 = this.field_609_am - this.field_9283_av;
      float var12 = MathHelper.func_1109_a(var3 * var3 + var11 * var11) * 4.0F;
      if(var12 > 1.0F) {
         var12 = 1.0F;
      }

      this.field_704_R += (var12 - this.field_704_R) * 0.4F;
      this.field_703_S += this.field_704_R;
   }

   public boolean func_429_A() {
      int var1 = MathHelper.func_1108_b(this.field_611_ak);
      int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      int var4 = this.field_615_ag.func_600_a(var1, var2, var3);
      return var4 == Block.field_441_aG.field_376_bc || var4 == Block.field_35278_bv.field_376_bc;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_749_a("Health", (short)this.field_9337_J);
      p_352_1_.func_749_a("HurtTime", (short)this.field_715_G);
      p_352_1_.func_749_a("DeathTime", (short)this.field_712_J);
      p_352_1_.func_749_a("AttackTime", (short)this.field_9330_P);
      if(!this.field_35170_bR.isEmpty()) {
         NBTTagList var2 = new NBTTagList();
         Iterator var3 = this.field_35170_bR.values().iterator();

         while(var3.hasNext()) {
            PotionEffect var4 = (PotionEffect)var3.next();
            NBTTagCompound var5 = new NBTTagCompound();
            var5.func_761_a("Id", (byte)var4.func_35799_a());
            var5.func_761_a("Amplifier", (byte)var4.func_35801_c());
            var5.func_758_a("Duration", var4.func_35802_b());
            var2.func_742_a(var5);
         }

         p_352_1_.func_762_a("ActiveEffects", var2);
      }

   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      if(this.field_9337_J < -32768) {
         this.field_9337_J = -32768;
      }

      this.field_9337_J = p_357_1_.func_745_d("Health");
      if(!p_357_1_.func_751_b("Health")) {
         this.field_9337_J = this.func_40117_c();
      }

      this.field_715_G = p_357_1_.func_745_d("HurtTime");
      this.field_712_J = p_357_1_.func_745_d("DeathTime");
      this.field_9330_P = p_357_1_.func_745_d("AttackTime");
      if(p_357_1_.func_751_b("ActiveEffects")) {
         NBTTagList var2 = p_357_1_.func_753_l("ActiveEffects");

         for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
            byte var5 = var4.func_746_c("Id");
            byte var6 = var4.func_746_c("Amplifier");
            int var7 = var4.func_756_e("Duration");
            this.field_35170_bR.put(Integer.valueOf(var5), new PotionEffect(var5, var7, var6));
         }
      }

   }

   public boolean func_354_B() {
      return !this.field_646_aA && this.field_9337_J > 0;
   }

   public boolean func_21067_c_() {
      return false;
   }

   public void func_46010_f(float p_46010_1_) {
      this.field_9340_ai = p_46010_1_;
   }

   public void func_46003_g(boolean p_46003_1_) {
      this.field_9336_ak = p_46003_1_;
   }

   public void func_425_j() {
      if(this.field_39003_d > 0) {
         --this.field_39003_d;
      }

      if(this.field_9324_Y > 0) {
         double var1 = this.field_611_ak + (this.field_9323_Z - this.field_611_ak) / (double)this.field_9324_Y;
         double var3 = this.field_610_al + (this.field_9356_aa - this.field_610_al) / (double)this.field_9324_Y;
         double var5 = this.field_609_am + (this.field_9354_ab - this.field_609_am) / (double)this.field_9324_Y;

         double var7;
         for(var7 = this.field_9352_ac - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
            ;
         }

         while(var7 >= 180.0D) {
            var7 -= 360.0D;
         }

         this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_9324_Y);
         this.field_604_ar = (float)((double)this.field_604_ar + (this.field_9350_ad - (double)this.field_604_ar) / (double)this.field_9324_Y);
         --this.field_9324_Y;
         this.func_347_a(var1, var3, var5);
         this.func_376_c(this.field_605_aq, this.field_604_ar);
         List var9 = this.field_615_ag.func_697_a(this, this.field_601_au.func_28195_e(0.03125D, 0.0D, 0.03125D));
         if(var9.size() > 0) {
            double var10 = 0.0D;

            for(int var12 = 0; var12 < var9.size(); ++var12) {
               AxisAlignedBB var13 = (AxisAlignedBB)var9.get(var12);
               if(var13.field_1702_e > var10) {
                  var10 = var13.field_1702_e;
               }
            }

            var3 += var10 - this.field_601_au.field_1697_b;
            this.func_347_a(var1, var3, var5);
         }
      }

      Profiler.func_40663_a("ai");
      if(this.func_22049_v()) {
         this.field_9336_ak = false;
         this.field_9342_ah = 0.0F;
         this.field_9340_ai = 0.0F;
         this.field_9338_aj = 0.0F;
      } else if(this.func_44001_ad()) {
         if(this.func_46006_aR()) {
            Profiler.func_40663_a("newAi");
            this.func_46014_aS();
            Profiler.func_40662_b();
         } else {
            Profiler.func_40663_a("oldAi");
            this.func_418_b_();
            Profiler.func_40662_b();
            this.field_46015_bf = this.field_605_aq;
         }
      }

      Profiler.func_40662_b();
      boolean var14 = this.func_27013_ag();
      boolean var2 = this.func_359_G();
      if(this.field_9336_ak) {
         if(var14) {
            this.field_607_ao += 0.03999999910593033D;
         } else if(var2) {
            this.field_607_ao += 0.03999999910593033D;
         } else if(this.field_9298_aH && this.field_39003_d == 0) {
            this.func_424_C();
            this.field_39003_d = 10;
         }
      } else {
         this.field_39003_d = 0;
      }

      this.field_9342_ah *= 0.98F;
      this.field_9340_ai *= 0.98F;
      this.field_9338_aj *= 0.9F;
      float var15 = this.field_35169_bv;
      this.field_35169_bv *= this.func_35166_t_();
      this.func_435_b(this.field_9342_ah, this.field_9340_ai);
      this.field_35169_bv = var15;
      Profiler.func_40663_a("push");
      List var4 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
      if(var4 != null && var4.size() > 0) {
         for(int var16 = 0; var16 < var4.size(); ++var16) {
            Entity var6 = (Entity)var4.get(var16);
            if(var6.func_385_d_()) {
               var6.func_380_f(this);
            }
         }
      }

      Profiler.func_40662_b();
   }

   protected boolean func_46006_aR() {
      return false;
   }

   protected boolean func_44001_ad() {
      return !this.field_615_ag.field_1026_y;
   }

   protected boolean func_22049_v() {
      return this.field_9337_J <= 0;
   }

   public boolean func_35162_ad() {
      return false;
   }

   protected void func_424_C() {
      this.field_607_ao = 0.41999998688697815D;
      if(this.func_35160_a(Potion.field_35683_j)) {
         this.field_607_ao += (double)((float)(this.func_35167_b(Potion.field_35683_j).func_35801_c() + 1) * 0.1F);
      }

      if(this.func_35117_Q()) {
         float var1 = this.field_605_aq * 0.017453292F;
         this.field_608_an -= (double)(MathHelper.func_1106_a(var1) * 0.2F);
         this.field_606_ap += (double)(MathHelper.func_1114_b(var1) * 0.2F);
      }

      this.field_35118_ao = true;
   }

   protected boolean func_25023_u() {
      return true;
   }

   protected void func_27021_X() {
      EntityPlayer var1 = this.field_615_ag.func_609_a(this, -1.0D);
      if(var1 != null) {
         double var2 = var1.field_611_ak - this.field_611_ak;
         double var4 = var1.field_610_al - this.field_610_al;
         double var6 = var1.field_609_am - this.field_609_am;
         double var8 = var2 * var2 + var4 * var4 + var6 * var6;
         if(this.func_25023_u() && var8 > 16384.0D) {
            this.func_395_F();
         }

         if(this.field_9344_ag > 600 && this.field_9312_bd.nextInt(800) == 0 && var8 > 1024.0D && this.func_25023_u()) {
            this.func_395_F();
         } else if(var8 < 1024.0D) {
            this.field_9344_ag = 0;
         }
      }

   }

   protected void func_46014_aS() {
      ++this.field_9344_ag;
      Profiler.func_40663_a("checkDespawn");
      this.func_27021_X();
      Profiler.func_40662_b();
      Profiler.func_40663_a("sensing");
      this.field_48104_at.func_48481_a();
      Profiler.func_40662_b();
      Profiler.func_40663_a("targetSelector");
      this.field_48105_bU.func_46115_a();
      Profiler.func_40662_b();
      Profiler.func_40663_a("goalSelector");
      this.field_46019_bU.func_46115_a();
      Profiler.func_40662_b();
      Profiler.func_40663_a("navigation");
      this.field_48107_ar.func_46069_a();
      Profiler.func_40662_b();
      Profiler.func_40663_a("mob tick");
      this.func_48097_s_();
      Profiler.func_40662_b();
      Profiler.func_40663_a("controls");
      this.field_46018_e.func_46034_a();
      this.field_46017_d.func_46142_a();
      this.field_46021_am.func_46130_b();
      Profiler.func_40662_b();
   }

   protected void func_48097_s_() {}

   protected void func_418_b_() {
      ++this.field_9344_ag;
      this.func_27021_X();
      this.field_9342_ah = 0.0F;
      this.field_9340_ai = 0.0F;
      float var1 = 8.0F;
      if(this.field_9312_bd.nextFloat() < 0.02F) {
         EntityPlayer var2 = this.field_615_ag.func_609_a(this, (double)var1);
         if(var2 != null) {
            this.field_4120_b = var2;
            this.field_4127_c = 10 + this.field_9312_bd.nextInt(20);
         } else {
            this.field_9338_aj = (this.field_9312_bd.nextFloat() - 0.5F) * 20.0F;
         }
      }

      if(this.field_4120_b != null) {
         this.func_426_b(this.field_4120_b, 10.0F, (float)this.func_25026_x());
         if(this.field_4127_c-- <= 0 || this.field_4120_b.field_646_aA || this.field_4120_b.func_387_e(this) > (double)(var1 * var1)) {
            this.field_4120_b = null;
         }
      } else {
         if(this.field_9312_bd.nextFloat() < 0.05F) {
            this.field_9338_aj = (this.field_9312_bd.nextFloat() - 0.5F) * 20.0F;
         }

         this.field_605_aq += this.field_9338_aj;
         this.field_604_ar = this.field_9334_al;
      }

      boolean var4 = this.func_27013_ag();
      boolean var3 = this.func_359_G();
      if(var4 || var3) {
         this.field_9336_ak = this.field_9312_bd.nextFloat() < 0.8F;
      }

   }

   public int func_25026_x() {
      return 40;
   }

   public void func_426_b(Entity p_426_1_, float p_426_2_, float p_426_3_) {
      double var4 = p_426_1_.field_611_ak - this.field_611_ak;
      double var8 = p_426_1_.field_609_am - this.field_609_am;
      double var6;
      if(p_426_1_ instanceof EntityLiving) {
         EntityLiving var10 = (EntityLiving)p_426_1_;
         var6 = this.field_610_al + (double)this.func_373_s() - (var10.field_610_al + (double)var10.func_373_s());
      } else {
         var6 = (p_426_1_.field_601_au.field_1697_b + p_426_1_.field_601_au.field_1702_e) / 2.0D - (this.field_610_al + (double)this.func_373_s());
      }

      double var14 = (double)MathHelper.func_1109_a(var4 * var4 + var8 * var8);
      float var12 = (float)(Math.atan2(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var13 = (float)(-(Math.atan2(var6, var14) * 180.0D / 3.1415927410125732D));
      this.field_604_ar = -this.func_417_b(this.field_604_ar, var13, p_426_3_);
      this.field_605_aq = this.func_417_b(this.field_605_aq, var12, p_426_2_);
   }

   private float func_417_b(float p_417_1_, float p_417_2_, float p_417_3_) {
      float var4;
      for(var4 = p_417_2_ - p_417_1_; var4 < -180.0F; var4 += 360.0F) {
         ;
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      if(var4 > p_417_3_) {
         var4 = p_417_3_;
      }

      if(var4 < -p_417_3_) {
         var4 = -p_417_3_;
      }

      return p_417_1_ + var4;
   }

   public void func_6392_F() {}

   public boolean func_433_a() {
      return this.field_615_ag.func_604_a(this.field_601_au) && this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au);
   }

   protected void func_4034_G() {
      this.func_396_a(DamageSource.field_35550_i, 4);
   }

   public float func_431_d(float p_431_1_) {
      float var2 = this.field_9339_I - this.field_9341_H;
      if(var2 < 0.0F) {
         ++var2;
      }

      return this.field_9341_H + var2 * p_431_1_;
   }

   public Vec3D func_427_e(float p_427_1_) {
      if(p_427_1_ == 1.0F) {
         return Vec3D.func_1248_b(this.field_611_ak, this.field_610_al, this.field_609_am);
      } else {
         double var2 = this.field_9285_at + (this.field_611_ak - this.field_9285_at) * (double)p_427_1_;
         double var4 = this.field_9284_au + (this.field_610_al - this.field_9284_au) * (double)p_427_1_;
         double var6 = this.field_9283_av + (this.field_609_am - this.field_9283_av) * (double)p_427_1_;
         return Vec3D.func_1248_b(var2, var4, var6);
      }
   }

   public Vec3D func_4037_H() {
      return this.func_430_f(1.0F);
   }

   public Vec3D func_430_f(float p_430_1_) {
      float var2;
      float var3;
      float var4;
      float var5;
      if(p_430_1_ == 1.0F) {
         var2 = MathHelper.func_1114_b(-this.field_605_aq * 0.017453292F - 3.1415927F);
         var3 = MathHelper.func_1106_a(-this.field_605_aq * 0.017453292F - 3.1415927F);
         var4 = -MathHelper.func_1114_b(-this.field_604_ar * 0.017453292F);
         var5 = MathHelper.func_1106_a(-this.field_604_ar * 0.017453292F);
         return Vec3D.func_1248_b((double)(var3 * var4), (double)var5, (double)(var2 * var4));
      } else {
         var2 = this.field_602_at + (this.field_604_ar - this.field_602_at) * p_430_1_;
         var3 = this.field_603_as + (this.field_605_aq - this.field_603_as) * p_430_1_;
         var4 = MathHelper.func_1114_b(-var3 * 0.017453292F - 3.1415927F);
         var5 = MathHelper.func_1106_a(-var3 * 0.017453292F - 3.1415927F);
         float var6 = -MathHelper.func_1114_b(-var2 * 0.017453292F);
         float var7 = MathHelper.func_1106_a(-var2 * 0.017453292F);
         return Vec3D.func_1248_b((double)(var5 * var6), (double)var7, (double)(var4 * var6));
      }
   }

   public float func_35159_aC() {
      return 1.0F;
   }

   public MovingObjectPosition func_416_a(double p_416_1_, float p_416_3_) {
      Vec3D var4 = this.func_427_e(p_416_3_);
      Vec3D var5 = this.func_430_f(p_416_3_);
      Vec3D var6 = var4.func_1257_c(var5.field_1776_a * p_416_1_, var5.field_1775_b * p_416_1_, var5.field_1779_c * p_416_1_);
      return this.field_615_ag.func_645_a(var4, var6);
   }

   public int func_6391_i() {
      return 4;
   }

   public ItemStack func_4045_l() {
      return null;
   }

   public void func_9282_a(byte p_9282_1_) {
      if(p_9282_1_ == 2) {
         this.field_704_R = 1.5F;
         this.field_9306_bj = this.field_9366_o;
         this.field_715_G = this.field_9332_M = 10;
         this.field_9331_N = 0.0F;
         this.field_615_ag.func_623_a(this, this.func_6394_f_(), this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
         this.func_396_a(DamageSource.field_35547_j, 0);
      } else if(p_9282_1_ == 3) {
         this.field_615_ag.func_623_a(this, this.func_6390_f(), this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
         this.field_9337_J = 0;
         this.func_419_b(DamageSource.field_35547_j);
      } else {
         super.func_9282_a(p_9282_1_);
      }

   }

   public boolean func_22051_K() {
      return false;
   }

   public int func_28021_c(ItemStack p_28021_1_, int p_28021_2_) {
      return p_28021_1_.func_1088_b();
   }

   protected void func_36000_g() {
      Iterator var1 = this.field_35170_bR.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         PotionEffect var3 = (PotionEffect)this.field_35170_bR.get(var2);
         if(!var3.func_35798_a(this) && !this.field_615_ag.field_1026_y) {
            var1.remove();
            this.func_35158_d(var3);
         }
      }

      int var9;
      if(this.field_39001_b) {
         if(!this.field_615_ag.field_1026_y) {
            if(!this.field_35170_bR.isEmpty()) {
               var9 = PotionHelper.func_40354_a(this.field_35170_bR.values());
               this.field_21064_bx.func_21129_b(8, Integer.valueOf(var9));
            } else {
               this.field_21064_bx.func_21129_b(8, Integer.valueOf(0));
            }
         }

         this.field_39001_b = false;
      }

      if(this.field_9312_bd.nextBoolean()) {
         var9 = this.field_21064_bx.func_25115_b(8);
         if(var9 > 0) {
            double var10 = (double)(var9 >> 16 & 255) / 255.0D;
            double var5 = (double)(var9 >> 8 & 255) / 255.0D;
            double var7 = (double)(var9 >> 0 & 255) / 255.0D;
            this.field_615_ag.func_694_a("mobSpell", this.field_611_ak + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC, this.field_610_al + this.field_9312_bd.nextDouble() * (double)this.field_643_aD - (double)this.field_9292_aO, this.field_609_am + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC, var10, var5, var7);
         }
      }

   }

   public void func_40112_aN() {
      Iterator var1 = this.field_35170_bR.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         PotionEffect var3 = (PotionEffect)this.field_35170_bR.get(var2);
         if(!this.field_615_ag.field_1026_y) {
            var1.remove();
            this.func_35158_d(var3);
         }
      }

   }

   public Collection func_40118_aO() {
      return this.field_35170_bR.values();
   }

   public boolean func_35160_a(Potion p_35160_1_) {
      return this.field_35170_bR.containsKey(Integer.valueOf(p_35160_1_.field_35670_H));
   }

   public PotionEffect func_35167_b(Potion p_35167_1_) {
      return (PotionEffect)this.field_35170_bR.get(Integer.valueOf(p_35167_1_.field_35670_H));
   }

   public void func_35165_a(PotionEffect p_35165_1_) {
      if(this.func_40126_a(p_35165_1_)) {
         if(this.field_35170_bR.containsKey(Integer.valueOf(p_35165_1_.func_35799_a()))) {
            ((PotionEffect)this.field_35170_bR.get(Integer.valueOf(p_35165_1_.func_35799_a()))).func_35796_a(p_35165_1_);
            this.func_35161_c((PotionEffect)this.field_35170_bR.get(Integer.valueOf(p_35165_1_.func_35799_a())));
         } else {
            this.field_35170_bR.put(Integer.valueOf(p_35165_1_.func_35799_a()), p_35165_1_);
            this.func_35164_b(p_35165_1_);
         }

      }
   }

   public boolean func_40126_a(PotionEffect p_40126_1_) {
      if(this.func_40124_t() == EnumCreatureAttribute.UNDEAD) {
         int var2 = p_40126_1_.func_35799_a();
         if(var2 == Potion.field_35681_l.field_35670_H || var2 == Potion.field_35689_u.field_35670_H) {
            return false;
         }
      }

      return true;
   }

   public boolean func_40122_aP() {
      return this.func_40124_t() == EnumCreatureAttribute.UNDEAD;
   }

   public void func_36002_f(int p_36002_1_) {
      this.field_35170_bR.remove(Integer.valueOf(p_36002_1_));
   }

   protected void func_35164_b(PotionEffect p_35164_1_) {
      this.field_39001_b = true;
   }

   protected void func_35161_c(PotionEffect p_35161_1_) {
      this.field_39001_b = true;
   }

   protected void func_35158_d(PotionEffect p_35158_1_) {
      this.field_39001_b = true;
   }

   protected float func_35166_t_() {
      float var1 = 1.0F;
      if(this.func_35160_a(Potion.field_35677_c)) {
         var1 *= 1.0F + 0.2F * (float)(this.func_35167_b(Potion.field_35677_c).func_35801_c() + 1);
      }

      if(this.func_35160_a(Potion.field_35674_d)) {
         var1 *= 1.0F - 0.15F * (float)(this.func_35167_b(Potion.field_35674_d).func_35801_c() + 1);
      }

      return var1;
   }

   public void func_40113_j(double p_40113_1_, double p_40113_3_, double p_40113_5_) {
      this.func_365_c(p_40113_1_, p_40113_3_, p_40113_5_, this.field_605_aq, this.field_604_ar);
   }

   public boolean func_40127_l() {
      return false;
   }

   public EnumCreatureAttribute func_40124_t() {
      return EnumCreatureAttribute.UNDEFINED;
   }

   public void func_41005_b(ItemStack p_41005_1_) {
      this.field_615_ag.func_623_a(this, "random.break", 0.8F, 0.8F + this.field_615_ag.field_1037_n.nextFloat() * 0.4F);

      for(int var2 = 0; var2 < 5; ++var2) {
         Vec3D var3 = Vec3D.func_1248_b(((double)this.field_9312_bd.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
         var3.func_1258_a(-this.field_604_ar * 3.1415927F / 180.0F);
         var3.func_1249_b(-this.field_605_aq * 3.1415927F / 180.0F);
         Vec3D var4 = Vec3D.func_1248_b(((double)this.field_9312_bd.nextFloat() - 0.5D) * 0.3D, (double)(-this.field_9312_bd.nextFloat()) * 0.6D - 0.3D, 0.6D);
         var4.func_1258_a(-this.field_604_ar * 3.1415927F / 180.0F);
         var4.func_1249_b(-this.field_605_aq * 3.1415927F / 180.0F);
         var4 = var4.func_1257_c(this.field_611_ak, this.field_610_al + (double)this.func_373_s(), this.field_609_am);
         this.field_615_ag.func_694_a("iconcrack_" + p_41005_1_.func_1091_a().field_291_aS, var4.field_1776_a, var4.field_1775_b, var4.field_1779_c, var3.field_1776_a, var3.field_1775_b + 0.05D, var3.field_1779_c);
      }

   }
}
