package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockFluid;
import net.minecraft.src.DamageSource;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityList;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.NBTTagFloat;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Profiler;
import net.minecraft.src.StepSound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public abstract class Entity {

   private static int field_864_a = 0;
   public int field_620_ab;
   public double field_619_ac;
   public boolean field_618_ad;
   public Entity field_617_ae;
   public Entity field_616_af;
   public World field_615_ag;
   public double field_9285_at;
   public double field_9284_au;
   public double field_9283_av;
   public double field_611_ak;
   public double field_610_al;
   public double field_609_am;
   public double field_608_an;
   public double field_607_ao;
   public double field_606_ap;
   public float field_605_aq;
   public float field_604_ar;
   public float field_603_as;
   public float field_602_at;
   public final AxisAlignedBB field_601_au;
   public boolean field_9298_aH;
   public boolean field_9297_aI;
   public boolean field_9296_aJ;
   public boolean field_9295_aK;
   public boolean field_9294_aL;
   protected boolean field_27016_ba;
   public boolean field_9293_aM;
   public boolean field_646_aA;
   public float field_9292_aO;
   public float field_644_aC;
   public float field_643_aD;
   public float field_9291_aR;
   public float field_9290_aS;
   public float field_9288_aU;
   private int field_863_b;
   public double field_638_aI;
   public double field_637_aJ;
   public double field_636_aK;
   public float field_9287_aY;
   public float field_9286_aZ;
   public boolean field_9314_ba;
   public float field_632_aO;
   protected Random field_9312_bd;
   public int field_9311_be;
   public int field_9310_bf;
   private int field_9309_bg;
   protected boolean field_9307_bi;
   public int field_9306_bj;
   private boolean field_862_c;
   public String field_20047_bv;
   public String field_622_aY;
   protected boolean field_9304_bm;
   protected DataWatcher field_21064_bx;
   private double field_861_d;
   private double field_667_e;
   public boolean field_621_aZ;
   public int field_657_ba;
   public int field_656_bb;
   public int field_654_bc;
   public int field_9303_br;
   public int field_9302_bs;
   public int field_9301_bt;
   public boolean field_28016_bK;
   public boolean field_35118_ao;


   public Entity(World p_i480_1_) {
      this.field_620_ab = field_864_a++;
      this.field_619_ac = 1.0D;
      this.field_618_ad = false;
      this.field_601_au = AxisAlignedBB.func_1168_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
      this.field_9298_aH = false;
      this.field_9295_aK = false;
      this.field_9294_aL = false;
      this.field_9293_aM = true;
      this.field_646_aA = false;
      this.field_9292_aO = 0.0F;
      this.field_644_aC = 0.6F;
      this.field_643_aD = 1.8F;
      this.field_9291_aR = 0.0F;
      this.field_9290_aS = 0.0F;
      this.field_9288_aU = 0.0F;
      this.field_863_b = 1;
      this.field_9287_aY = 0.0F;
      this.field_9286_aZ = 0.0F;
      this.field_9314_ba = false;
      this.field_632_aO = 0.0F;
      this.field_9312_bd = new Random();
      this.field_9311_be = 0;
      this.field_9310_bf = 1;
      this.field_9309_bg = 0;
      this.field_9307_bi = false;
      this.field_9306_bj = 0;
      this.field_862_c = true;
      this.field_9304_bm = false;
      this.field_21064_bx = new DataWatcher();
      this.field_621_aZ = false;
      this.field_615_ag = p_i480_1_;
      this.func_347_a(0.0D, 0.0D, 0.0D);
      this.field_21064_bx.func_21124_a(0, Byte.valueOf((byte)0));
      this.field_21064_bx.func_21124_a(1, Short.valueOf((short)300));
      this.func_21057_b();
   }

   protected abstract void func_21057_b();

   public DataWatcher func_21061_O() {
      return this.field_21064_bx;
   }

   public boolean equals(Object p_equals_1_) {
      return p_equals_1_ instanceof Entity?((Entity)p_equals_1_).field_620_ab == this.field_620_ab:false;
   }

   public int hashCode() {
      return this.field_620_ab;
   }

   protected void func_374_q() {
      if(this.field_615_ag != null) {
         while(this.field_610_al > 0.0D) {
            this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
            if(this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0) {
               break;
            }

            ++this.field_610_al;
         }

         this.field_608_an = this.field_607_ao = this.field_606_ap = 0.0D;
         this.field_604_ar = 0.0F;
      }
   }

   public void func_395_F() {
      this.field_646_aA = true;
   }

   protected void func_371_a(float p_371_1_, float p_371_2_) {
      this.field_644_aC = p_371_1_;
      this.field_643_aD = p_371_2_;
   }

   protected void func_376_c(float p_376_1_, float p_376_2_) {
      this.field_605_aq = p_376_1_ % 360.0F;
      this.field_604_ar = p_376_2_ % 360.0F;
   }

   public void func_347_a(double p_347_1_, double p_347_3_, double p_347_5_) {
      this.field_611_ak = p_347_1_;
      this.field_610_al = p_347_3_;
      this.field_609_am = p_347_5_;
      float var7 = this.field_644_aC / 2.0F;
      float var8 = this.field_643_aD;
      this.field_601_au.func_1165_c(p_347_1_ - (double)var7, p_347_3_ - (double)this.field_9292_aO + (double)this.field_9287_aY, p_347_5_ - (double)var7, p_347_1_ + (double)var7, p_347_3_ - (double)this.field_9292_aO + (double)this.field_9287_aY + (double)var8, p_347_5_ + (double)var7);
   }

   public void func_346_d(float p_346_1_, float p_346_2_) {
      float var3 = this.field_604_ar;
      float var4 = this.field_605_aq;
      this.field_605_aq = (float)((double)this.field_605_aq + (double)p_346_1_ * 0.15D);
      this.field_604_ar = (float)((double)this.field_604_ar - (double)p_346_2_ * 0.15D);
      if(this.field_604_ar < -90.0F) {
         this.field_604_ar = -90.0F;
      }

      if(this.field_604_ar > 90.0F) {
         this.field_604_ar = 90.0F;
      }

      this.field_602_at += this.field_604_ar - var3;
      this.field_603_as += this.field_605_aq - var4;
   }

   public void func_370_e_() {
      this.func_391_y();
   }

   public void func_391_y() {
      Profiler.func_40663_a("entityBaseTick");
      if(this.field_616_af != null && this.field_616_af.field_646_aA) {
         this.field_616_af = null;
      }

      ++this.field_9311_be;
      this.field_9291_aR = this.field_9290_aS;
      this.field_9285_at = this.field_611_ak;
      this.field_9284_au = this.field_610_al;
      this.field_9283_av = this.field_609_am;
      this.field_602_at = this.field_604_ar;
      this.field_603_as = this.field_605_aq;
      int var3;
      if(this.func_35117_Q() && !this.func_27013_ag()) {
         int var1 = MathHelper.func_1108_b(this.field_611_ak);
         int var2 = MathHelper.func_1108_b(this.field_610_al - 0.20000000298023224D - (double)this.field_9292_aO);
         var3 = MathHelper.func_1108_b(this.field_609_am);
         int var4 = this.field_615_ag.func_600_a(var1, var2, var3);
         if(var4 > 0) {
            this.field_615_ag.func_694_a("tilecrack_" + var4, this.field_611_ak + ((double)this.field_9312_bd.nextFloat() - 0.5D) * (double)this.field_644_aC, this.field_601_au.field_1697_b + 0.1D, this.field_609_am + ((double)this.field_9312_bd.nextFloat() - 0.5D) * (double)this.field_644_aC, -this.field_608_an * 4.0D, 1.5D, -this.field_606_ap * 4.0D);
         }
      }

      if(this.func_397_g_()) {
         if(!this.field_9307_bi && !this.field_862_c) {
            float var6 = MathHelper.func_1109_a(this.field_608_an * this.field_608_an * 0.20000000298023224D + this.field_607_ao * this.field_607_ao + this.field_606_ap * this.field_606_ap * 0.20000000298023224D) * 0.2F;
            if(var6 > 1.0F) {
               var6 = 1.0F;
            }

            this.field_615_ag.func_623_a(this, "random.splash", var6, 1.0F + (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.4F);
            float var7 = (float)MathHelper.func_1108_b(this.field_601_au.field_1697_b);

            float var5;
            float var8;
            for(var3 = 0; (float)var3 < 1.0F + this.field_644_aC * 20.0F; ++var3) {
               var8 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
               var5 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
               this.field_615_ag.func_694_a("bubble", this.field_611_ak + (double)var8, (double)(var7 + 1.0F), this.field_609_am + (double)var5, this.field_608_an, this.field_607_ao - (double)(this.field_9312_bd.nextFloat() * 0.2F), this.field_606_ap);
            }

            for(var3 = 0; (float)var3 < 1.0F + this.field_644_aC * 20.0F; ++var3) {
               var8 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
               var5 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC;
               this.field_615_ag.func_694_a("splash", this.field_611_ak + (double)var8, (double)(var7 + 1.0F), this.field_609_am + (double)var5, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }
         }

         this.field_9288_aU = 0.0F;
         this.field_9307_bi = true;
         this.field_9309_bg = 0;
      } else {
         this.field_9307_bi = false;
      }

      if(this.field_615_ag.field_1026_y) {
         this.field_9309_bg = 0;
      } else if(this.field_9309_bg > 0) {
         if(this.field_9304_bm) {
            this.field_9309_bg -= 4;
            if(this.field_9309_bg < 0) {
               this.field_9309_bg = 0;
            }
         } else {
            if(this.field_9309_bg % 20 == 0) {
               this.func_396_a(DamageSource.field_35540_b, 1);
            }

            --this.field_9309_bg;
         }
      }

      if(this.func_359_G()) {
         this.func_4038_J();
         this.field_9288_aU *= 0.5F;
      }

      if(this.field_610_al < -64.0D) {
         this.func_4034_G();
      }

      if(!this.field_615_ag.field_1026_y) {
         this.func_21059_b(0, this.field_9309_bg > 0);
         this.func_21059_b(2, this.field_616_af != null);
      }

      this.field_862_c = false;
      Profiler.func_40662_b();
   }

   protected void func_4038_J() {
      if(!this.field_9304_bm) {
         this.func_396_a(DamageSource.field_35541_c, 4);
         this.func_40046_d(15);
      }

   }

   public void func_40046_d(int p_40046_1_) {
      int var2 = p_40046_1_ * 20;
      if(this.field_9309_bg < var2) {
         this.field_9309_bg = var2;
      }

   }

   public void func_40045_B() {
      this.field_9309_bg = 0;
   }

   protected void func_4034_G() {
      this.func_395_F();
   }

   public boolean func_403_b(double p_403_1_, double p_403_3_, double p_403_5_) {
      AxisAlignedBB var7 = this.field_601_au.func_1166_c(p_403_1_, p_403_3_, p_403_5_);
      List var8 = this.field_615_ag.func_697_a(this, var7);
      return var8.size() > 0?false:!this.field_615_ag.func_662_b(var7);
   }

   public void func_349_c(double p_349_1_, double p_349_3_, double p_349_5_) {
      if(this.field_9314_ba) {
         this.field_601_au.func_1174_d(p_349_1_, p_349_3_, p_349_5_);
         this.field_611_ak = (this.field_601_au.field_1698_a + this.field_601_au.field_1703_d) / 2.0D;
         this.field_610_al = this.field_601_au.field_1697_b + (double)this.field_9292_aO - (double)this.field_9287_aY;
         this.field_609_am = (this.field_601_au.field_1704_c + this.field_601_au.field_1701_f) / 2.0D;
      } else {
         Profiler.func_40663_a("move");
         this.field_9287_aY *= 0.4F;
         double var7 = this.field_611_ak;
         double var9 = this.field_609_am;
         if(this.field_27016_ba) {
            this.field_27016_ba = false;
            p_349_1_ *= 0.25D;
            p_349_3_ *= 0.05000000074505806D;
            p_349_5_ *= 0.25D;
            this.field_608_an = 0.0D;
            this.field_607_ao = 0.0D;
            this.field_606_ap = 0.0D;
         }

         double var11 = p_349_1_;
         double var13 = p_349_3_;
         double var15 = p_349_5_;
         AxisAlignedBB var17 = this.field_601_au.func_1160_c();
         boolean var18 = this.field_9298_aH && this.func_381_o() && this instanceof EntityPlayer;
         if(var18) {
            double var19;
            for(var19 = 0.05D; p_349_1_ != 0.0D && this.field_615_ag.func_697_a(this, this.field_601_au.func_1166_c(p_349_1_, -1.0D, 0.0D)).size() == 0; var11 = p_349_1_) {
               if(p_349_1_ < var19 && p_349_1_ >= -var19) {
                  p_349_1_ = 0.0D;
               } else if(p_349_1_ > 0.0D) {
                  p_349_1_ -= var19;
               } else {
                  p_349_1_ += var19;
               }
            }

            for(; p_349_5_ != 0.0D && this.field_615_ag.func_697_a(this, this.field_601_au.func_1166_c(0.0D, -1.0D, p_349_5_)).size() == 0; var15 = p_349_5_) {
               if(p_349_5_ < var19 && p_349_5_ >= -var19) {
                  p_349_5_ = 0.0D;
               } else if(p_349_5_ > 0.0D) {
                  p_349_5_ -= var19;
               } else {
                  p_349_5_ += var19;
               }
            }

            while(p_349_1_ != 0.0D && p_349_5_ != 0.0D && this.field_615_ag.func_697_a(this, this.field_601_au.func_1166_c(p_349_1_, -1.0D, p_349_5_)).size() == 0) {
               if(p_349_1_ < var19 && p_349_1_ >= -var19) {
                  p_349_1_ = 0.0D;
               } else if(p_349_1_ > 0.0D) {
                  p_349_1_ -= var19;
               } else {
                  p_349_1_ += var19;
               }

               if(p_349_5_ < var19 && p_349_5_ >= -var19) {
                  p_349_5_ = 0.0D;
               } else if(p_349_5_ > 0.0D) {
                  p_349_5_ -= var19;
               } else {
                  p_349_5_ += var19;
               }

               var11 = p_349_1_;
               var15 = p_349_5_;
            }
         }

         List var35 = this.field_615_ag.func_697_a(this, this.field_601_au.func_1170_a(p_349_1_, p_349_3_, p_349_5_));

         for(int var20 = 0; var20 < var35.size(); ++var20) {
            p_349_3_ = ((AxisAlignedBB)var35.get(var20)).func_1172_b(this.field_601_au, p_349_3_);
         }

         this.field_601_au.func_1174_d(0.0D, p_349_3_, 0.0D);
         if(!this.field_9293_aM && var13 != p_349_3_) {
            p_349_5_ = 0.0D;
            p_349_3_ = 0.0D;
            p_349_1_ = 0.0D;
         }

         boolean var36 = this.field_9298_aH || var13 != p_349_3_ && var13 < 0.0D;

         int var21;
         for(var21 = 0; var21 < var35.size(); ++var21) {
            p_349_1_ = ((AxisAlignedBB)var35.get(var21)).func_1163_a(this.field_601_au, p_349_1_);
         }

         this.field_601_au.func_1174_d(p_349_1_, 0.0D, 0.0D);
         if(!this.field_9293_aM && var11 != p_349_1_) {
            p_349_5_ = 0.0D;
            p_349_3_ = 0.0D;
            p_349_1_ = 0.0D;
         }

         for(var21 = 0; var21 < var35.size(); ++var21) {
            p_349_5_ = ((AxisAlignedBB)var35.get(var21)).func_1162_c(this.field_601_au, p_349_5_);
         }

         this.field_601_au.func_1174_d(0.0D, 0.0D, p_349_5_);
         if(!this.field_9293_aM && var15 != p_349_5_) {
            p_349_5_ = 0.0D;
            p_349_3_ = 0.0D;
            p_349_1_ = 0.0D;
         }

         double var23;
         int var28;
         double var37;
         if(this.field_9286_aZ > 0.0F && var36 && (var18 || this.field_9287_aY < 0.05F) && (var11 != p_349_1_ || var15 != p_349_5_)) {
            var37 = p_349_1_;
            var23 = p_349_3_;
            double var25 = p_349_5_;
            p_349_1_ = var11;
            p_349_3_ = (double)this.field_9286_aZ;
            p_349_5_ = var15;
            AxisAlignedBB var27 = this.field_601_au.func_1160_c();
            this.field_601_au.func_1171_b(var17);
            var35 = this.field_615_ag.func_697_a(this, this.field_601_au.func_1170_a(var11, p_349_3_, var15));

            for(var28 = 0; var28 < var35.size(); ++var28) {
               p_349_3_ = ((AxisAlignedBB)var35.get(var28)).func_1172_b(this.field_601_au, p_349_3_);
            }

            this.field_601_au.func_1174_d(0.0D, p_349_3_, 0.0D);
            if(!this.field_9293_aM && var13 != p_349_3_) {
               p_349_5_ = 0.0D;
               p_349_3_ = 0.0D;
               p_349_1_ = 0.0D;
            }

            for(var28 = 0; var28 < var35.size(); ++var28) {
               p_349_1_ = ((AxisAlignedBB)var35.get(var28)).func_1163_a(this.field_601_au, p_349_1_);
            }

            this.field_601_au.func_1174_d(p_349_1_, 0.0D, 0.0D);
            if(!this.field_9293_aM && var11 != p_349_1_) {
               p_349_5_ = 0.0D;
               p_349_3_ = 0.0D;
               p_349_1_ = 0.0D;
            }

            for(var28 = 0; var28 < var35.size(); ++var28) {
               p_349_5_ = ((AxisAlignedBB)var35.get(var28)).func_1162_c(this.field_601_au, p_349_5_);
            }

            this.field_601_au.func_1174_d(0.0D, 0.0D, p_349_5_);
            if(!this.field_9293_aM && var15 != p_349_5_) {
               p_349_5_ = 0.0D;
               p_349_3_ = 0.0D;
               p_349_1_ = 0.0D;
            }

            if(!this.field_9293_aM && var13 != p_349_3_) {
               p_349_5_ = 0.0D;
               p_349_3_ = 0.0D;
               p_349_1_ = 0.0D;
            } else {
               p_349_3_ = (double)(-this.field_9286_aZ);

               for(var28 = 0; var28 < var35.size(); ++var28) {
                  p_349_3_ = ((AxisAlignedBB)var35.get(var28)).func_1172_b(this.field_601_au, p_349_3_);
               }

               this.field_601_au.func_1174_d(0.0D, p_349_3_, 0.0D);
            }

            if(var37 * var37 + var25 * var25 >= p_349_1_ * p_349_1_ + p_349_5_ * p_349_5_) {
               p_349_1_ = var37;
               p_349_3_ = var23;
               p_349_5_ = var25;
               this.field_601_au.func_1171_b(var27);
            } else {
               double var40 = this.field_601_au.field_1697_b - (double)((int)this.field_601_au.field_1697_b);
               if(var40 > 0.0D) {
                  this.field_9287_aY = (float)((double)this.field_9287_aY + var40 + 0.01D);
               }
            }
         }

         Profiler.func_40662_b();
         Profiler.func_40663_a("rest");
         this.field_611_ak = (this.field_601_au.field_1698_a + this.field_601_au.field_1703_d) / 2.0D;
         this.field_610_al = this.field_601_au.field_1697_b + (double)this.field_9292_aO - (double)this.field_9287_aY;
         this.field_609_am = (this.field_601_au.field_1704_c + this.field_601_au.field_1701_f) / 2.0D;
         this.field_9297_aI = var11 != p_349_1_ || var15 != p_349_5_;
         this.field_9296_aJ = var13 != p_349_3_;
         this.field_9298_aH = var13 != p_349_3_ && var13 < 0.0D;
         this.field_9295_aK = this.field_9297_aI || this.field_9296_aJ;
         this.func_9279_a(p_349_3_, this.field_9298_aH);
         if(var11 != p_349_1_) {
            this.field_608_an = 0.0D;
         }

         if(var13 != p_349_3_) {
            this.field_607_ao = 0.0D;
         }

         if(var15 != p_349_5_) {
            this.field_606_ap = 0.0D;
         }

         var37 = this.field_611_ak - var7;
         var23 = this.field_609_am - var9;
         int var26;
         int var38;
         int var39;
         if(this.func_25021_m() && !var18 && this.field_616_af == null) {
            this.field_9290_aS = (float)((double)this.field_9290_aS + (double)MathHelper.func_1109_a(var37 * var37 + var23 * var23) * 0.6D);
            var38 = MathHelper.func_1108_b(this.field_611_ak);
            var26 = MathHelper.func_1108_b(this.field_610_al - 0.20000000298023224D - (double)this.field_9292_aO);
            var39 = MathHelper.func_1108_b(this.field_609_am);
            var28 = this.field_615_ag.func_600_a(var38, var26, var39);
            if(var28 == 0 && this.field_615_ag.func_600_a(var38, var26 - 1, var39) == Block.field_4057_ba.field_376_bc) {
               var28 = this.field_615_ag.func_600_a(var38, var26 - 1, var39);
            }

            if(this.field_9290_aS > (float)this.field_863_b && var28 > 0) {
               this.field_863_b = (int)this.field_9290_aS + 1;
               this.func_41002_a(var38, var26, var39, var28);
               Block.field_345_n[var28].func_254_a(this.field_615_ag, var38, var26, var39, this);
            }
         }

         var38 = MathHelper.func_1108_b(this.field_601_au.field_1698_a + 0.001D);
         var26 = MathHelper.func_1108_b(this.field_601_au.field_1697_b + 0.001D);
         var39 = MathHelper.func_1108_b(this.field_601_au.field_1704_c + 0.001D);
         var28 = MathHelper.func_1108_b(this.field_601_au.field_1703_d - 0.001D);
         int var29 = MathHelper.func_1108_b(this.field_601_au.field_1702_e - 0.001D);
         int var30 = MathHelper.func_1108_b(this.field_601_au.field_1701_f - 0.001D);
         if(this.field_615_ag.func_640_a(var38, var26, var39, var28, var29, var30)) {
            for(int var31 = var38; var31 <= var28; ++var31) {
               for(int var32 = var26; var32 <= var29; ++var32) {
                  for(int var33 = var39; var33 <= var30; ++var33) {
                     int var34 = this.field_615_ag.func_600_a(var31, var32, var33);
                     if(var34 > 0) {
                        Block.field_345_n[var34].func_236_b(this.field_615_ag, var31, var32, var33, this);
                     }
                  }
               }
            }
         }

         boolean var41 = this.func_27012_af();
         if(this.field_615_ag.func_605_c(this.field_601_au.func_28195_e(0.001D, 0.001D, 0.001D))) {
            this.func_355_a(1);
            if(!var41) {
               ++this.field_9309_bg;
               if(this.field_9309_bg == 0) {
                  this.func_40046_d(8);
               }
            }
         } else if(this.field_9309_bg <= 0) {
            this.field_9309_bg = -this.field_9310_bf;
         }

         if(var41 && this.field_9309_bg > 0) {
            this.field_615_ag.func_623_a(this, "random.fizz", 0.7F, 1.6F + (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.4F);
            this.field_9309_bg = -this.field_9310_bf;
         }

         Profiler.func_40662_b();
      }
   }

   protected void func_41002_a(int p_41002_1_, int p_41002_2_, int p_41002_3_, int p_41002_4_) {
      StepSound var5 = Block.field_345_n[p_41002_4_].field_358_bl;
      if(this.field_615_ag.func_600_a(p_41002_1_, p_41002_2_ + 1, p_41002_3_) == Block.field_428_aT.field_376_bc) {
         var5 = Block.field_428_aT.field_358_bl;
         this.field_615_ag.func_623_a(this, var5.func_1145_d(), var5.func_1147_b() * 0.15F, var5.func_1144_c());
      } else if(!Block.field_345_n[p_41002_4_].field_356_bn.func_879_d()) {
         this.field_615_ag.func_623_a(this, var5.func_1145_d(), var5.func_1147_b() * 0.15F, var5.func_1144_c());
      }

   }

   protected boolean func_25021_m() {
      return true;
   }

   protected void func_9279_a(double p_9279_1_, boolean p_9279_3_) {
      if(p_9279_3_) {
         if(this.field_9288_aU > 0.0F) {
            if(this instanceof EntityLiving) {
               int var4 = MathHelper.func_1108_b(this.field_611_ak);
               int var5 = MathHelper.func_1108_b(this.field_610_al - 0.20000000298023224D - (double)this.field_9292_aO);
               int var6 = MathHelper.func_1108_b(this.field_609_am);
               int var7 = this.field_615_ag.func_600_a(var4, var5, var6);
               if(var7 == 0 && this.field_615_ag.func_600_a(var4, var5 - 1, var6) == Block.field_4057_ba.field_376_bc) {
                  var7 = this.field_615_ag.func_600_a(var4, var5 - 1, var6);
               }

               if(var7 > 0) {
                  Block.field_345_n[var7].func_43001_a(this.field_615_ag, var4, var5, var6, this, this.field_9288_aU);
               }
            }

            this.func_400_c(this.field_9288_aU);
            this.field_9288_aU = 0.0F;
         }
      } else if(p_9279_1_ < 0.0D) {
         this.field_9288_aU = (float)((double)this.field_9288_aU - p_9279_1_);
      }

   }

   public AxisAlignedBB func_372_f_() {
      return null;
   }

   protected void func_355_a(int p_355_1_) {
      if(!this.field_9304_bm) {
         this.func_396_a(DamageSource.field_35542_a, p_355_1_);
      }

   }

   public final boolean func_40047_D() {
      return this.field_9304_bm;
   }

   protected void func_400_c(float p_400_1_) {
      if(this.field_617_ae != null) {
         this.field_617_ae.func_400_c(p_400_1_);
      }

   }

   public boolean func_27012_af() {
      return this.field_9307_bi || this.field_615_ag.func_27167_r(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
   }

   public boolean func_27013_ag() {
      return this.field_9307_bi;
   }

   public boolean func_397_g_() {
      return this.field_615_ag.func_682_a(this.field_601_au.func_1177_b(0.0D, -0.4000000059604645D, 0.0D).func_28195_e(0.001D, 0.001D, 0.001D), Material.field_1332_f, this);
   }

   public boolean func_393_a(Material p_393_1_) {
      double var2 = this.field_610_al + (double)this.func_373_s();
      int var4 = MathHelper.func_1108_b(this.field_611_ak);
      int var5 = MathHelper.func_1110_d((float)MathHelper.func_1108_b(var2));
      int var6 = MathHelper.func_1108_b(this.field_609_am);
      int var7 = this.field_615_ag.func_600_a(var4, var5, var6);
      if(var7 != 0 && Block.field_345_n[var7].field_356_bn == p_393_1_) {
         float var8 = BlockFluid.func_288_b(this.field_615_ag.func_602_e(var4, var5, var6)) - 0.11111111F;
         float var9 = (float)(var5 + 1) - var8;
         return var2 < (double)var9;
      } else {
         return false;
      }
   }

   public float func_373_s() {
      return 0.0F;
   }

   public boolean func_359_G() {
      return this.field_615_ag.func_689_a(this.field_601_au.func_1177_b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.field_1331_g);
   }

   public void func_351_a(float p_351_1_, float p_351_2_, float p_351_3_) {
      float var4 = MathHelper.func_1113_c(p_351_1_ * p_351_1_ + p_351_2_ * p_351_2_);
      if(var4 >= 0.01F) {
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = p_351_3_ / var4;
         p_351_1_ *= var4;
         p_351_2_ *= var4;
         float var5 = MathHelper.func_1106_a(this.field_605_aq * 3.1415927F / 180.0F);
         float var6 = MathHelper.func_1114_b(this.field_605_aq * 3.1415927F / 180.0F);
         this.field_608_an += (double)(p_351_1_ * var6 - p_351_2_ * var5);
         this.field_606_ap += (double)(p_351_2_ * var6 + p_351_1_ * var5);
      }
   }

   public int func_35115_a(float p_35115_1_) {
      int var2 = MathHelper.func_1108_b(this.field_611_ak);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      if(this.field_615_ag.func_630_d(var2, 0, var3)) {
         double var4 = (this.field_601_au.field_1702_e - this.field_601_au.field_1697_b) * 0.66D;
         int var6 = MathHelper.func_1108_b(this.field_610_al - (double)this.field_9292_aO + var4);
         return this.field_615_ag.func_35451_b(var2, var6, var3, 0);
      } else {
         return 0;
      }
   }

   public float func_382_a(float p_382_1_) {
      int var2 = MathHelper.func_1108_b(this.field_611_ak);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      if(this.field_615_ag.func_630_d(var2, 0, var3)) {
         double var4 = (this.field_601_au.field_1702_e - this.field_601_au.field_1697_b) * 0.66D;
         int var6 = MathHelper.func_1108_b(this.field_610_al - (double)this.field_9292_aO + var4);
         return this.field_615_ag.func_598_c(var2, var6, var3);
      } else {
         return 0.0F;
      }
   }

   public void func_398_a(World p_398_1_) {
      this.field_615_ag = p_398_1_;
   }

   public void func_399_b(double p_399_1_, double p_399_3_, double p_399_5_, float p_399_7_, float p_399_8_) {
      this.field_9285_at = this.field_611_ak = p_399_1_;
      this.field_9284_au = this.field_610_al = p_399_3_;
      this.field_9283_av = this.field_609_am = p_399_5_;
      this.field_603_as = this.field_605_aq = p_399_7_;
      this.field_602_at = this.field_604_ar = p_399_8_;
      this.field_9287_aY = 0.0F;
      double var9 = (double)(this.field_603_as - p_399_7_);
      if(var9 < -180.0D) {
         this.field_603_as += 360.0F;
      }

      if(var9 >= 180.0D) {
         this.field_603_as -= 360.0F;
      }

      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.func_376_c(p_399_7_, p_399_8_);
   }

   public void func_365_c(double p_365_1_, double p_365_3_, double p_365_5_, float p_365_7_, float p_365_8_) {
      this.field_638_aI = this.field_9285_at = this.field_611_ak = p_365_1_;
      this.field_637_aJ = this.field_9284_au = this.field_610_al = p_365_3_ + (double)this.field_9292_aO;
      this.field_636_aK = this.field_9283_av = this.field_609_am = p_365_5_;
      this.field_605_aq = p_365_7_;
      this.field_604_ar = p_365_8_;
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
   }

   public float func_379_d(Entity p_379_1_) {
      float var2 = (float)(this.field_611_ak - p_379_1_.field_611_ak);
      float var3 = (float)(this.field_610_al - p_379_1_.field_610_al);
      float var4 = (float)(this.field_609_am - p_379_1_.field_609_am);
      return MathHelper.func_1113_c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double func_360_d(double p_360_1_, double p_360_3_, double p_360_5_) {
      double var7 = this.field_611_ak - p_360_1_;
      double var9 = this.field_610_al - p_360_3_;
      double var11 = this.field_609_am - p_360_5_;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double func_361_e(double p_361_1_, double p_361_3_, double p_361_5_) {
      double var7 = this.field_611_ak - p_361_1_;
      double var9 = this.field_610_al - p_361_3_;
      double var11 = this.field_609_am - p_361_5_;
      return (double)MathHelper.func_1109_a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double func_387_e(Entity p_387_1_) {
      double var2 = this.field_611_ak - p_387_1_.field_611_ak;
      double var4 = this.field_610_al - p_387_1_.field_610_al;
      double var6 = this.field_609_am - p_387_1_.field_609_am;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void func_6378_b(EntityPlayer p_6378_1_) {}

   public void func_380_f(Entity p_380_1_) {
      if(p_380_1_.field_617_ae != this && p_380_1_.field_616_af != this) {
         double var2 = p_380_1_.field_611_ak - this.field_611_ak;
         double var4 = p_380_1_.field_609_am - this.field_609_am;
         double var6 = MathHelper.func_1107_a(var2, var4);
         if(var6 >= 0.009999999776482582D) {
            var6 = (double)MathHelper.func_1109_a(var6);
            var2 /= var6;
            var4 /= var6;
            double var8 = 1.0D / var6;
            if(var8 > 1.0D) {
               var8 = 1.0D;
            }

            var2 *= var8;
            var4 *= var8;
            var2 *= 0.05000000074505806D;
            var4 *= 0.05000000074505806D;
            var2 *= (double)(1.0F - this.field_632_aO);
            var4 *= (double)(1.0F - this.field_632_aO);
            this.func_348_f(-var2, 0.0D, -var4);
            p_380_1_.func_348_f(var2, 0.0D, var4);
         }

      }
   }

   public void func_348_f(double p_348_1_, double p_348_3_, double p_348_5_) {
      this.field_608_an += p_348_1_;
      this.field_607_ao += p_348_3_;
      this.field_606_ap += p_348_5_;
      this.field_35118_ao = true;
   }

   protected void func_9281_M() {
      this.field_9294_aL = true;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      this.func_9281_M();
      return false;
   }

   public boolean func_401_c_() {
      return false;
   }

   public boolean func_385_d_() {
      return false;
   }

   public void func_364_b(Entity p_364_1_, int p_364_2_) {}

   public boolean func_390_a(Vec3D p_390_1_) {
      double var2 = this.field_611_ak - p_390_1_.field_1776_a;
      double var4 = this.field_610_al - p_390_1_.field_1775_b;
      double var6 = this.field_609_am - p_390_1_.field_1779_c;
      double var8 = var2 * var2 + var4 * var4 + var6 * var6;
      return this.func_384_a(var8);
   }

   public boolean func_384_a(double p_384_1_) {
      double var3 = this.field_601_au.func_1164_b();
      var3 *= 64.0D * this.field_619_ac;
      return p_384_1_ < var3 * var3;
   }

   public String func_6376_z() {
      return null;
   }

   public boolean func_358_c(NBTTagCompound p_358_1_) {
      String var2 = this.func_389_H();
      if(!this.field_646_aA && var2 != null) {
         p_358_1_.func_754_a("id", var2);
         this.func_363_d(p_358_1_);
         return true;
      } else {
         return false;
      }
   }

   public void func_363_d(NBTTagCompound p_363_1_) {
      p_363_1_.func_762_a("Pos", this.func_375_a(new double[]{this.field_611_ak, this.field_610_al + (double)this.field_9287_aY, this.field_609_am}));
      p_363_1_.func_762_a("Motion", this.func_375_a(new double[]{this.field_608_an, this.field_607_ao, this.field_606_ap}));
      p_363_1_.func_762_a("Rotation", this.func_377_a(new float[]{this.field_605_aq, this.field_604_ar}));
      p_363_1_.func_744_a("FallDistance", this.field_9288_aU);
      p_363_1_.func_749_a("Fire", (short)this.field_9309_bg);
      p_363_1_.func_749_a("Air", (short)this.func_41001_Z());
      p_363_1_.func_748_a("OnGround", this.field_9298_aH);
      this.func_352_a(p_363_1_);
   }

   public void func_368_e(NBTTagCompound p_368_1_) {
      NBTTagList var2 = p_368_1_.func_753_l("Pos");
      NBTTagList var3 = p_368_1_.func_753_l("Motion");
      NBTTagList var4 = p_368_1_.func_753_l("Rotation");
      this.field_608_an = ((NBTTagDouble)var3.func_741_a(0)).field_1089_a;
      this.field_607_ao = ((NBTTagDouble)var3.func_741_a(1)).field_1089_a;
      this.field_606_ap = ((NBTTagDouble)var3.func_741_a(2)).field_1089_a;
      if(Math.abs(this.field_608_an) > 10.0D) {
         this.field_608_an = 0.0D;
      }

      if(Math.abs(this.field_607_ao) > 10.0D) {
         this.field_607_ao = 0.0D;
      }

      if(Math.abs(this.field_606_ap) > 10.0D) {
         this.field_606_ap = 0.0D;
      }

      this.field_9285_at = this.field_638_aI = this.field_611_ak = ((NBTTagDouble)var2.func_741_a(0)).field_1089_a;
      this.field_9284_au = this.field_637_aJ = this.field_610_al = ((NBTTagDouble)var2.func_741_a(1)).field_1089_a;
      this.field_9283_av = this.field_636_aK = this.field_609_am = ((NBTTagDouble)var2.func_741_a(2)).field_1089_a;
      this.field_603_as = this.field_605_aq = ((NBTTagFloat)var4.func_741_a(0)).field_1097_a;
      this.field_602_at = this.field_604_ar = ((NBTTagFloat)var4.func_741_a(1)).field_1097_a;
      this.field_9288_aU = p_368_1_.func_752_g("FallDistance");
      this.field_9309_bg = p_368_1_.func_745_d("Fire");
      this.func_41003_g(p_368_1_.func_745_d("Air"));
      this.field_9298_aH = p_368_1_.func_760_m("OnGround");
      this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
      this.func_376_c(this.field_605_aq, this.field_604_ar);
      this.func_357_b(p_368_1_);
   }

   protected final String func_389_H() {
      return EntityList.func_1083_b(this);
   }

   protected abstract void func_357_b(NBTTagCompound var1);

   protected abstract void func_352_a(NBTTagCompound var1);

   protected NBTTagList func_375_a(double ... p_375_1_) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = p_375_1_;
      int var4 = p_375_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.func_742_a(new NBTTagDouble((String)null, var6));
      }

      return var2;
   }

   protected NBTTagList func_377_a(float ... p_377_1_) {
      NBTTagList var2 = new NBTTagList();
      float[] var3 = p_377_1_;
      int var4 = p_377_1_.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.func_742_a(new NBTTagFloat((String)null, var6));
      }

      return var2;
   }

   public float func_392_h_() {
      return this.field_643_aD / 2.0F;
   }

   public EntityItem func_367_b(int p_367_1_, int p_367_2_) {
      return this.func_394_a(p_367_1_, p_367_2_, 0.0F);
   }

   public EntityItem func_394_a(int p_394_1_, int p_394_2_, float p_394_3_) {
      return this.func_21058_a(new ItemStack(p_394_1_, p_394_2_, 0), p_394_3_);
   }

   public EntityItem func_21058_a(ItemStack p_21058_1_, float p_21058_2_) {
      EntityItem var3 = new EntityItem(this.field_615_ag, this.field_611_ak, this.field_610_al + (double)p_21058_2_, this.field_609_am, p_21058_1_);
      var3.field_805_c = 10;
      this.field_615_ag.func_674_a(var3);
      return var3;
   }

   public boolean func_354_B() {
      return !this.field_646_aA;
   }

   public boolean func_345_I() {
      for(int var1 = 0; var1 < 8; ++var1) {
         float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.field_644_aC * 0.8F;
         float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
         float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.field_644_aC * 0.8F;
         int var5 = MathHelper.func_1108_b(this.field_611_ak + (double)var2);
         int var6 = MathHelper.func_1108_b(this.field_610_al + (double)this.func_373_s() + (double)var3);
         int var7 = MathHelper.func_1108_b(this.field_609_am + (double)var4);
         if(this.field_615_ag.func_28100_h(var5, var6, var7)) {
            return true;
         }
      }

      return false;
   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      return false;
   }

   public AxisAlignedBB func_383_b_(Entity p_383_1_) {
      return null;
   }

   public void func_350_p() {
      if(this.field_616_af.field_646_aA) {
         this.field_616_af = null;
      } else {
         this.field_608_an = 0.0D;
         this.field_607_ao = 0.0D;
         this.field_606_ap = 0.0D;
         this.func_370_e_();
         if(this.field_616_af != null) {
            this.field_616_af.func_366_i_();
            this.field_667_e += (double)(this.field_616_af.field_605_aq - this.field_616_af.field_603_as);

            for(this.field_861_d += (double)(this.field_616_af.field_604_ar - this.field_616_af.field_602_at); this.field_667_e >= 180.0D; this.field_667_e -= 360.0D) {
               ;
            }

            while(this.field_667_e < -180.0D) {
               this.field_667_e += 360.0D;
            }

            while(this.field_861_d >= 180.0D) {
               this.field_861_d -= 360.0D;
            }

            while(this.field_861_d < -180.0D) {
               this.field_861_d += 360.0D;
            }

            double var1 = this.field_667_e * 0.5D;
            double var3 = this.field_861_d * 0.5D;
            float var5 = 10.0F;
            if(var1 > (double)var5) {
               var1 = (double)var5;
            }

            if(var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if(var3 > (double)var5) {
               var3 = (double)var5;
            }

            if(var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.field_667_e -= var1;
            this.field_861_d -= var3;
            this.field_605_aq = (float)((double)this.field_605_aq + var1);
            this.field_604_ar = (float)((double)this.field_604_ar + var3);
         }
      }
   }

   public void func_366_i_() {
      this.field_617_ae.func_347_a(this.field_611_ak, this.field_610_al + this.func_402_h() + this.field_617_ae.func_388_v(), this.field_609_am);
   }

   public double func_388_v() {
      return (double)this.field_9292_aO;
   }

   public double func_402_h() {
      return (double)this.field_643_aD * 0.75D;
   }

   public void func_6377_h(Entity p_6377_1_) {
      this.field_861_d = 0.0D;
      this.field_667_e = 0.0D;
      if(p_6377_1_ == null) {
         if(this.field_616_af != null) {
            this.func_365_c(this.field_616_af.field_611_ak, this.field_616_af.field_601_au.field_1697_b + (double)this.field_616_af.field_643_aD, this.field_616_af.field_609_am, this.field_605_aq, this.field_604_ar);
            this.field_616_af.field_617_ae = null;
         }

         this.field_616_af = null;
      } else if(this.field_616_af == p_6377_1_) {
         this.field_616_af.field_617_ae = null;
         this.field_616_af = null;
         this.func_365_c(p_6377_1_.field_611_ak, p_6377_1_.field_601_au.field_1697_b + (double)p_6377_1_.field_643_aD, p_6377_1_.field_609_am, this.field_605_aq, this.field_604_ar);
      } else {
         if(this.field_616_af != null) {
            this.field_616_af.field_617_ae = null;
         }

         if(p_6377_1_.field_617_ae != null) {
            p_6377_1_.field_617_ae.field_616_af = null;
         }

         this.field_616_af = p_6377_1_;
         p_6377_1_.field_617_ae = this;
      }
   }

   public void func_378_a(double p_378_1_, double p_378_3_, double p_378_5_, float p_378_7_, float p_378_8_, int p_378_9_) {
      this.func_347_a(p_378_1_, p_378_3_, p_378_5_);
      this.func_376_c(p_378_7_, p_378_8_);
      List var10 = this.field_615_ag.func_697_a(this, this.field_601_au.func_28195_e(0.03125D, 0.0D, 0.03125D));
      if(var10.size() > 0) {
         double var11 = 0.0D;

         for(int var13 = 0; var13 < var10.size(); ++var13) {
            AxisAlignedBB var14 = (AxisAlignedBB)var10.get(var13);
            if(var14.field_1702_e > var11) {
               var11 = var14.field_1702_e;
            }
         }

         p_378_3_ += var11 - this.field_601_au.field_1697_b;
         this.func_347_a(p_378_1_, p_378_3_, p_378_5_);
      }

   }

   public float func_4035_j_() {
      return 0.1F;
   }

   public Vec3D func_4037_H() {
      return null;
   }

   public void func_4039_q() {}

   public void func_6375_a(double p_6375_1_, double p_6375_3_, double p_6375_5_) {
      this.field_608_an = p_6375_1_;
      this.field_607_ao = p_6375_3_;
      this.field_606_ap = p_6375_5_;
   }

   public void func_9282_a(byte p_9282_1_) {}

   public void func_9280_g() {}

   public void func_20046_s() {}

   public void func_20045_c(int p_20045_1_, int p_20045_2_, int p_20045_3_) {}

   public boolean func_21062_U() {
      return this.field_9309_bg > 0 || this.func_21060_d(0);
   }

   public boolean func_21063_V() {
      return this.field_616_af != null || this.func_21060_d(2);
   }

   public boolean func_381_o() {
      return this.func_21060_d(1);
   }

   public void func_48078_c(boolean p_48078_1_) {
      this.func_21059_b(1, p_48078_1_);
   }

   public boolean func_35117_Q() {
      return this.func_21060_d(3);
   }

   public void func_35113_c(boolean p_35113_1_) {
      this.func_21059_b(3, p_35113_1_);
   }

   public boolean func_35114_R() {
      return this.func_21060_d(4);
   }

   public void func_35116_d(boolean p_35116_1_) {
      this.func_21059_b(4, p_35116_1_);
   }

   protected boolean func_21060_d(int p_21060_1_) {
      return (this.field_21064_bx.func_21130_a(0) & 1 << p_21060_1_) != 0;
   }

   protected void func_21059_b(int p_21059_1_, boolean p_21059_2_) {
      byte var3 = this.field_21064_bx.func_21130_a(0);
      if(p_21059_2_) {
         this.field_21064_bx.func_21129_b(0, Byte.valueOf((byte)(var3 | 1 << p_21059_1_)));
      } else {
         this.field_21064_bx.func_21129_b(0, Byte.valueOf((byte)(var3 & ~(1 << p_21059_1_))));
      }

   }

   public int func_41001_Z() {
      return this.field_21064_bx.func_41062_b(1);
   }

   public void func_41003_g(int p_41003_1_) {
      this.field_21064_bx.func_21129_b(1, Short.valueOf((short)p_41003_1_));
   }

   public void func_27014_a(EntityLightningBolt p_27014_1_) {
      this.func_355_a(5);
      ++this.field_9309_bg;
      if(this.field_9309_bg == 0) {
         this.func_40046_d(8);
      }

   }

   public void func_27015_a(EntityLiving p_27015_1_) {}

   protected boolean func_28014_c(double p_28014_1_, double p_28014_3_, double p_28014_5_) {
      int var7 = MathHelper.func_1108_b(p_28014_1_);
      int var8 = MathHelper.func_1108_b(p_28014_3_);
      int var9 = MathHelper.func_1108_b(p_28014_5_);
      double var10 = p_28014_1_ - (double)var7;
      double var12 = p_28014_3_ - (double)var8;
      double var14 = p_28014_5_ - (double)var9;
      if(this.field_615_ag.func_28100_h(var7, var8, var9)) {
         boolean var16 = !this.field_615_ag.func_28100_h(var7 - 1, var8, var9);
         boolean var17 = !this.field_615_ag.func_28100_h(var7 + 1, var8, var9);
         boolean var18 = !this.field_615_ag.func_28100_h(var7, var8 - 1, var9);
         boolean var19 = !this.field_615_ag.func_28100_h(var7, var8 + 1, var9);
         boolean var20 = !this.field_615_ag.func_28100_h(var7, var8, var9 - 1);
         boolean var21 = !this.field_615_ag.func_28100_h(var7, var8, var9 + 1);
         byte var22 = -1;
         double var23 = 9999.0D;
         if(var16 && var10 < var23) {
            var23 = var10;
            var22 = 0;
         }

         if(var17 && 1.0D - var10 < var23) {
            var23 = 1.0D - var10;
            var22 = 1;
         }

         if(var18 && var12 < var23) {
            var23 = var12;
            var22 = 2;
         }

         if(var19 && 1.0D - var12 < var23) {
            var23 = 1.0D - var12;
            var22 = 3;
         }

         if(var20 && var14 < var23) {
            var23 = var14;
            var22 = 4;
         }

         if(var21 && 1.0D - var14 < var23) {
            var23 = 1.0D - var14;
            var22 = 5;
         }

         float var25 = this.field_9312_bd.nextFloat() * 0.2F + 0.1F;
         if(var22 == 0) {
            this.field_608_an = (double)(-var25);
         }

         if(var22 == 1) {
            this.field_608_an = (double)var25;
         }

         if(var22 == 2) {
            this.field_607_ao = (double)(-var25);
         }

         if(var22 == 3) {
            this.field_607_ao = (double)var25;
         }

         if(var22 == 4) {
            this.field_606_ap = (double)(-var25);
         }

         if(var22 == 5) {
            this.field_606_ap = (double)var25;
         }

         return true;
      } else {
         return false;
      }
   }

   public void func_35112_o() {
      this.field_27016_ba = true;
      this.field_9288_aU = 0.0F;
   }

   public Entity[] func_40048_X() {
      return null;
   }

   public boolean func_41004_h(Entity p_41004_1_) {
      return this == p_41004_1_;
   }

   public void func_48079_f(float p_48079_1_) {}

   public boolean func_48080_j() {
      return true;
   }

}
