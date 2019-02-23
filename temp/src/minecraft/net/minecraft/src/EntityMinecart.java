package net.minecraft.src;

import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockRail;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityMinecart extends Entity implements IInventory {

   private ItemStack[] field_857_h;
   private int field_9418_e;
   private boolean field_856_i;
   public int field_20913_d;
   public double field_9417_f;
   public double field_9416_g;
   private static final int[][][] field_855_j = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
   private int field_9415_k;
   private double field_9414_l;
   private double field_9413_m;
   private double field_9412_n;
   private double field_9411_o;
   private double field_9410_p;
   private double field_9409_q;
   private double field_9408_r;
   private double field_9407_s;


   public EntityMinecart(World p_i214_1_) {
      super(p_i214_1_);
      this.field_857_h = new ItemStack[36];
      this.field_9418_e = 0;
      this.field_856_i = false;
      this.field_618_ad = true;
      this.func_371_a(0.98F, 0.7F);
      this.field_9292_aO = this.field_643_aD / 2.0F;
   }

   protected boolean func_25021_m() {
      return false;
   }

   protected void func_21057_b() {
      this.field_21064_bx.func_21124_a(16, new Byte((byte)0));
      this.field_21064_bx.func_21124_a(17, new Integer(0));
      this.field_21064_bx.func_21124_a(18, new Integer(1));
      this.field_21064_bx.func_21124_a(19, new Integer(0));
   }

   public AxisAlignedBB func_383_b_(Entity p_383_1_) {
      return p_383_1_.field_601_au;
   }

   public AxisAlignedBB func_372_f_() {
      return null;
   }

   public boolean func_385_d_() {
      return true;
   }

   public EntityMinecart(World p_i215_1_, double p_i215_2_, double p_i215_4_, double p_i215_6_, int p_i215_8_) {
      this(p_i215_1_);
      this.func_347_a(p_i215_2_, p_i215_4_ + (double)this.field_9292_aO, p_i215_6_);
      this.field_608_an = 0.0D;
      this.field_607_ao = 0.0D;
      this.field_606_ap = 0.0D;
      this.field_9285_at = p_i215_2_;
      this.field_9284_au = p_i215_4_;
      this.field_9283_av = p_i215_6_;
      this.field_20913_d = p_i215_8_;
   }

   public double func_402_h() {
      return (double)this.field_643_aD * 0.0D - 0.30000001192092896D;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(!this.field_615_ag.field_1026_y && !this.field_646_aA) {
         this.func_41029_h(-this.func_41030_m());
         this.func_41028_c(10);
         this.func_9281_M();
         this.func_41024_b(this.func_41025_i() + p_396_2_ * 10);
         if(this.func_41025_i() > 40) {
            if(this.field_617_ae != null) {
               this.field_617_ae.func_6377_h(this);
            }

            this.func_395_F();
            this.func_394_a(Item.field_256_ax.field_291_aS, 1, 0.0F);
            if(this.field_20913_d == 1) {
               EntityMinecart var3 = this;

               for(int var4 = 0; var4 < var3.func_469_c(); ++var4) {
                  ItemStack var5 = var3.func_468_c(var4);
                  if(var5 != null) {
                     float var6 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
                     float var7 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
                     float var8 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;

                     while(var5.field_1615_a > 0) {
                        int var9 = this.field_9312_bd.nextInt(21) + 10;
                        if(var9 > var5.field_1615_a) {
                           var9 = var5.field_1615_a;
                        }

                        var5.field_1615_a -= var9;
                        EntityItem var10 = new EntityItem(this.field_615_ag, this.field_611_ak + (double)var6, this.field_610_al + (double)var7, this.field_609_am + (double)var8, new ItemStack(var5.field_1617_c, var9, var5.func_21181_i()));
                        float var11 = 0.05F;
                        var10.field_608_an = (double)((float)this.field_9312_bd.nextGaussian() * var11);
                        var10.field_607_ao = (double)((float)this.field_9312_bd.nextGaussian() * var11 + 0.2F);
                        var10.field_606_ap = (double)((float)this.field_9312_bd.nextGaussian() * var11);
                        this.field_615_ag.func_674_a(var10);
                     }
                  }
               }

               this.func_394_a(Block.field_396_av.field_376_bc, 1, 0.0F);
            } else if(this.field_20913_d == 2) {
               this.func_394_a(Block.field_445_aC.field_376_bc, 1, 0.0F);
            }
         }

         return true;
      } else {
         return true;
      }
   }

   public void func_9280_g() {
      this.func_41029_h(-this.func_41030_m());
      this.func_41028_c(10);
      this.func_41024_b(this.func_41025_i() + this.func_41025_i() * 10);
   }

   public boolean func_401_c_() {
      return !this.field_646_aA;
   }

   public void func_395_F() {
      for(int var1 = 0; var1 < this.func_469_c(); ++var1) {
         ItemStack var2 = this.func_468_c(var1);
         if(var2 != null) {
            float var3 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
            float var4 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;
            float var5 = this.field_9312_bd.nextFloat() * 0.8F + 0.1F;

            while(var2.field_1615_a > 0) {
               int var6 = this.field_9312_bd.nextInt(21) + 10;
               if(var6 > var2.field_1615_a) {
                  var6 = var2.field_1615_a;
               }

               var2.field_1615_a -= var6;
               EntityItem var7 = new EntityItem(this.field_615_ag, this.field_611_ak + (double)var3, this.field_610_al + (double)var4, this.field_609_am + (double)var5, new ItemStack(var2.field_1617_c, var6, var2.func_21181_i()));
               if(var2.func_40710_n()) {
                  var7.field_801_a.func_40706_d((NBTTagCompound)var2.func_40709_o().func_40195_b());
               }

               float var8 = 0.05F;
               var7.field_608_an = (double)((float)this.field_9312_bd.nextGaussian() * var8);
               var7.field_607_ao = (double)((float)this.field_9312_bd.nextGaussian() * var8 + 0.2F);
               var7.field_606_ap = (double)((float)this.field_9312_bd.nextGaussian() * var8);
               this.field_615_ag.func_674_a(var7);
            }
         }
      }

      super.func_395_F();
   }

   public void func_370_e_() {
      if(this.func_41023_l() > 0) {
         this.func_41028_c(this.func_41023_l() - 1);
      }

      if(this.func_41025_i() > 0) {
         this.func_41024_b(this.func_41025_i() - 1);
      }

      if(this.field_610_al < -64.0D) {
         this.func_4034_G();
      }

      if(this.func_41026_g() && this.field_9312_bd.nextInt(4) == 0) {
         this.field_615_ag.func_694_a("largesmoke", this.field_611_ak, this.field_610_al + 0.8D, this.field_609_am, 0.0D, 0.0D, 0.0D);
      }

      if(this.field_615_ag.field_1026_y) {
         if(this.field_9415_k > 0) {
            double var45 = this.field_611_ak + (this.field_9414_l - this.field_611_ak) / (double)this.field_9415_k;
            double var46 = this.field_610_al + (this.field_9413_m - this.field_610_al) / (double)this.field_9415_k;
            double var5 = this.field_609_am + (this.field_9412_n - this.field_609_am) / (double)this.field_9415_k;

            double var7;
            for(var7 = this.field_9411_o - (double)this.field_605_aq; var7 < -180.0D; var7 += 360.0D) {
               ;
            }

            while(var7 >= 180.0D) {
               var7 -= 360.0D;
            }

            this.field_605_aq = (float)((double)this.field_605_aq + var7 / (double)this.field_9415_k);
            this.field_604_ar = (float)((double)this.field_604_ar + (this.field_9410_p - (double)this.field_604_ar) / (double)this.field_9415_k);
            --this.field_9415_k;
            this.func_347_a(var45, var46, var5);
            this.func_376_c(this.field_605_aq, this.field_604_ar);
         } else {
            this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
            this.func_376_c(this.field_605_aq, this.field_604_ar);
         }

      } else {
         this.field_9285_at = this.field_611_ak;
         this.field_9284_au = this.field_610_al;
         this.field_9283_av = this.field_609_am;
         this.field_607_ao -= 0.03999999910593033D;
         int var1 = MathHelper.func_1108_b(this.field_611_ak);
         int var2 = MathHelper.func_1108_b(this.field_610_al);
         int var3 = MathHelper.func_1108_b(this.field_609_am);
         if(BlockRail.func_27040_h(this.field_615_ag, var1, var2 - 1, var3)) {
            --var2;
         }

         double var4 = 0.4D;
         double var6 = 0.0078125D;
         int var8 = this.field_615_ag.func_600_a(var1, var2, var3);
         if(BlockRail.func_27041_c(var8)) {
            Vec3D var9 = this.func_514_g(this.field_611_ak, this.field_610_al, this.field_609_am);
            int var10 = this.field_615_ag.func_602_e(var1, var2, var3);
            this.field_610_al = (double)var2;
            boolean var11 = false;
            boolean var12 = false;
            if(var8 == Block.field_9261_T.field_376_bc) {
               var11 = (var10 & 8) != 0;
               var12 = !var11;
            }

            if(((BlockRail)Block.field_345_n[var8]).func_27042_h()) {
               var10 &= 7;
            }

            if(var10 >= 2 && var10 <= 5) {
               this.field_610_al = (double)(var2 + 1);
            }

            if(var10 == 2) {
               this.field_608_an -= var6;
            }

            if(var10 == 3) {
               this.field_608_an += var6;
            }

            if(var10 == 4) {
               this.field_606_ap += var6;
            }

            if(var10 == 5) {
               this.field_606_ap -= var6;
            }

            int[][] var13 = field_855_j[var10];
            double var14 = (double)(var13[1][0] - var13[0][0]);
            double var16 = (double)(var13[1][2] - var13[0][2]);
            double var18 = Math.sqrt(var14 * var14 + var16 * var16);
            double var20 = this.field_608_an * var14 + this.field_606_ap * var16;
            if(var20 < 0.0D) {
               var14 = -var14;
               var16 = -var16;
            }

            double var22 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
            this.field_608_an = var22 * var14 / var18;
            this.field_606_ap = var22 * var16 / var18;
            double var24;
            if(var12) {
               var24 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
               if(var24 < 0.03D) {
                  this.field_608_an *= 0.0D;
                  this.field_607_ao *= 0.0D;
                  this.field_606_ap *= 0.0D;
               } else {
                  this.field_608_an *= 0.5D;
                  this.field_607_ao *= 0.0D;
                  this.field_606_ap *= 0.5D;
               }
            }

            var24 = 0.0D;
            double var26 = (double)var1 + 0.5D + (double)var13[0][0] * 0.5D;
            double var28 = (double)var3 + 0.5D + (double)var13[0][2] * 0.5D;
            double var30 = (double)var1 + 0.5D + (double)var13[1][0] * 0.5D;
            double var32 = (double)var3 + 0.5D + (double)var13[1][2] * 0.5D;
            var14 = var30 - var26;
            var16 = var32 - var28;
            double var34;
            double var36;
            double var38;
            if(var14 == 0.0D) {
               this.field_611_ak = (double)var1 + 0.5D;
               var24 = this.field_609_am - (double)var3;
            } else if(var16 == 0.0D) {
               this.field_609_am = (double)var3 + 0.5D;
               var24 = this.field_611_ak - (double)var1;
            } else {
               var34 = this.field_611_ak - var26;
               var36 = this.field_609_am - var28;
               var38 = (var34 * var14 + var36 * var16) * 2.0D;
               var24 = var38;
            }

            this.field_611_ak = var26 + var14 * var24;
            this.field_609_am = var28 + var16 * var24;
            this.func_347_a(this.field_611_ak, this.field_610_al + (double)this.field_9292_aO, this.field_609_am);
            var34 = this.field_608_an;
            var36 = this.field_606_ap;
            if(this.field_617_ae != null) {
               var34 *= 0.75D;
               var36 *= 0.75D;
            }

            if(var34 < -var4) {
               var34 = -var4;
            }

            if(var34 > var4) {
               var34 = var4;
            }

            if(var36 < -var4) {
               var36 = -var4;
            }

            if(var36 > var4) {
               var36 = var4;
            }

            this.func_349_c(var34, 0.0D, var36);
            if(var13[0][1] != 0 && MathHelper.func_1108_b(this.field_611_ak) - var1 == var13[0][0] && MathHelper.func_1108_b(this.field_609_am) - var3 == var13[0][2]) {
               this.func_347_a(this.field_611_ak, this.field_610_al + (double)var13[0][1], this.field_609_am);
            } else if(var13[1][1] != 0 && MathHelper.func_1108_b(this.field_611_ak) - var1 == var13[1][0] && MathHelper.func_1108_b(this.field_609_am) - var3 == var13[1][2]) {
               this.func_347_a(this.field_611_ak, this.field_610_al + (double)var13[1][1], this.field_609_am);
            }

            if(this.field_617_ae != null) {
               this.field_608_an *= 0.996999979019165D;
               this.field_607_ao *= 0.0D;
               this.field_606_ap *= 0.996999979019165D;
            } else {
               if(this.field_20913_d == 2) {
                  var38 = (double)MathHelper.func_1109_a(this.field_9417_f * this.field_9417_f + this.field_9416_g * this.field_9416_g);
                  if(var38 > 0.01D) {
                     this.field_9417_f /= var38;
                     this.field_9416_g /= var38;
                     double var40 = 0.04D;
                     this.field_608_an *= 0.800000011920929D;
                     this.field_607_ao *= 0.0D;
                     this.field_606_ap *= 0.800000011920929D;
                     this.field_608_an += this.field_9417_f * var40;
                     this.field_606_ap += this.field_9416_g * var40;
                  } else {
                     this.field_608_an *= 0.8999999761581421D;
                     this.field_607_ao *= 0.0D;
                     this.field_606_ap *= 0.8999999761581421D;
                  }
               }

               this.field_608_an *= 0.9599999785423279D;
               this.field_607_ao *= 0.0D;
               this.field_606_ap *= 0.9599999785423279D;
            }

            Vec3D var51 = this.func_514_g(this.field_611_ak, this.field_610_al, this.field_609_am);
            if(var51 != null && var9 != null) {
               double var39 = (var9.field_1775_b - var51.field_1775_b) * 0.05D;
               var22 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
               if(var22 > 0.0D) {
                  this.field_608_an = this.field_608_an / var22 * (var22 + var39);
                  this.field_606_ap = this.field_606_ap / var22 * (var22 + var39);
               }

               this.func_347_a(this.field_611_ak, var51.field_1775_b, this.field_609_am);
            }

            int var52 = MathHelper.func_1108_b(this.field_611_ak);
            int var53 = MathHelper.func_1108_b(this.field_609_am);
            if(var52 != var1 || var53 != var3) {
               var22 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
               this.field_608_an = var22 * (double)(var52 - var1);
               this.field_606_ap = var22 * (double)(var53 - var3);
            }

            double var41;
            if(this.field_20913_d == 2) {
               var41 = (double)MathHelper.func_1109_a(this.field_9417_f * this.field_9417_f + this.field_9416_g * this.field_9416_g);
               if(var41 > 0.01D && this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap > 0.001D) {
                  this.field_9417_f /= var41;
                  this.field_9416_g /= var41;
                  if(this.field_9417_f * this.field_608_an + this.field_9416_g * this.field_606_ap < 0.0D) {
                     this.field_9417_f = 0.0D;
                     this.field_9416_g = 0.0D;
                  } else {
                     this.field_9417_f = this.field_608_an;
                     this.field_9416_g = this.field_606_ap;
                  }
               }
            }

            if(var11) {
               var41 = Math.sqrt(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap);
               if(var41 > 0.01D) {
                  double var43 = 0.06D;
                  this.field_608_an += this.field_608_an / var41 * var43;
                  this.field_606_ap += this.field_606_ap / var41 * var43;
               } else if(var10 == 1) {
                  if(this.field_615_ag.func_28100_h(var1 - 1, var2, var3)) {
                     this.field_608_an = 0.02D;
                  } else if(this.field_615_ag.func_28100_h(var1 + 1, var2, var3)) {
                     this.field_608_an = -0.02D;
                  }
               } else if(var10 == 0) {
                  if(this.field_615_ag.func_28100_h(var1, var2, var3 - 1)) {
                     this.field_606_ap = 0.02D;
                  } else if(this.field_615_ag.func_28100_h(var1, var2, var3 + 1)) {
                     this.field_606_ap = -0.02D;
                  }
               }
            }
         } else {
            if(this.field_608_an < -var4) {
               this.field_608_an = -var4;
            }

            if(this.field_608_an > var4) {
               this.field_608_an = var4;
            }

            if(this.field_606_ap < -var4) {
               this.field_606_ap = -var4;
            }

            if(this.field_606_ap > var4) {
               this.field_606_ap = var4;
            }

            if(this.field_9298_aH) {
               this.field_608_an *= 0.5D;
               this.field_607_ao *= 0.5D;
               this.field_606_ap *= 0.5D;
            }

            this.func_349_c(this.field_608_an, this.field_607_ao, this.field_606_ap);
            if(!this.field_9298_aH) {
               this.field_608_an *= 0.949999988079071D;
               this.field_607_ao *= 0.949999988079071D;
               this.field_606_ap *= 0.949999988079071D;
            }
         }

         this.field_604_ar = 0.0F;
         double var47 = this.field_9285_at - this.field_611_ak;
         double var48 = this.field_9283_av - this.field_609_am;
         if(var47 * var47 + var48 * var48 > 0.001D) {
            this.field_605_aq = (float)(Math.atan2(var48, var47) * 180.0D / 3.141592653589793D);
            if(this.field_856_i) {
               this.field_605_aq += 180.0F;
            }
         }

         double var49;
         for(var49 = (double)(this.field_605_aq - this.field_603_as); var49 >= 180.0D; var49 -= 360.0D) {
            ;
         }

         while(var49 < -180.0D) {
            var49 += 360.0D;
         }

         if(var49 < -170.0D || var49 >= 170.0D) {
            this.field_605_aq += 180.0F;
            this.field_856_i = !this.field_856_i;
         }

         this.func_376_c(this.field_605_aq, this.field_604_ar);
         List var15 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
         if(var15 != null && var15.size() > 0) {
            for(int var50 = 0; var50 < var15.size(); ++var50) {
               Entity var17 = (Entity)var15.get(var50);
               if(var17 != this.field_617_ae && var17.func_385_d_() && var17 instanceof EntityMinecart) {
                  var17.func_380_f(this);
               }
            }
         }

         if(this.field_617_ae != null && this.field_617_ae.field_646_aA) {
            if(this.field_617_ae.field_616_af == this) {
               this.field_617_ae.field_616_af = null;
            }

            this.field_617_ae = null;
         }

         if(this.field_9418_e > 0) {
            --this.field_9418_e;
         }

         if(this.field_9418_e <= 0) {
            this.field_9417_f = this.field_9416_g = 0.0D;
         }

         this.func_41027_b(this.field_9418_e > 0);
      }
   }

   public Vec3D func_515_a(double p_515_1_, double p_515_3_, double p_515_5_, double p_515_7_) {
      int var9 = MathHelper.func_1108_b(p_515_1_);
      int var10 = MathHelper.func_1108_b(p_515_3_);
      int var11 = MathHelper.func_1108_b(p_515_5_);
      if(BlockRail.func_27040_h(this.field_615_ag, var9, var10 - 1, var11)) {
         --var10;
      }

      int var12 = this.field_615_ag.func_600_a(var9, var10, var11);
      if(!BlockRail.func_27041_c(var12)) {
         return null;
      } else {
         int var13 = this.field_615_ag.func_602_e(var9, var10, var11);
         if(((BlockRail)Block.field_345_n[var12]).func_27042_h()) {
            var13 &= 7;
         }

         p_515_3_ = (double)var10;
         if(var13 >= 2 && var13 <= 5) {
            p_515_3_ = (double)(var10 + 1);
         }

         int[][] var14 = field_855_j[var13];
         double var15 = (double)(var14[1][0] - var14[0][0]);
         double var17 = (double)(var14[1][2] - var14[0][2]);
         double var19 = Math.sqrt(var15 * var15 + var17 * var17);
         var15 /= var19;
         var17 /= var19;
         p_515_1_ += var15 * p_515_7_;
         p_515_5_ += var17 * p_515_7_;
         if(var14[0][1] != 0 && MathHelper.func_1108_b(p_515_1_) - var9 == var14[0][0] && MathHelper.func_1108_b(p_515_5_) - var11 == var14[0][2]) {
            p_515_3_ += (double)var14[0][1];
         } else if(var14[1][1] != 0 && MathHelper.func_1108_b(p_515_1_) - var9 == var14[1][0] && MathHelper.func_1108_b(p_515_5_) - var11 == var14[1][2]) {
            p_515_3_ += (double)var14[1][1];
         }

         return this.func_514_g(p_515_1_, p_515_3_, p_515_5_);
      }
   }

   public Vec3D func_514_g(double p_514_1_, double p_514_3_, double p_514_5_) {
      int var7 = MathHelper.func_1108_b(p_514_1_);
      int var8 = MathHelper.func_1108_b(p_514_3_);
      int var9 = MathHelper.func_1108_b(p_514_5_);
      if(BlockRail.func_27040_h(this.field_615_ag, var7, var8 - 1, var9)) {
         --var8;
      }

      int var10 = this.field_615_ag.func_600_a(var7, var8, var9);
      if(BlockRail.func_27041_c(var10)) {
         int var11 = this.field_615_ag.func_602_e(var7, var8, var9);
         p_514_3_ = (double)var8;
         if(((BlockRail)Block.field_345_n[var10]).func_27042_h()) {
            var11 &= 7;
         }

         if(var11 >= 2 && var11 <= 5) {
            p_514_3_ = (double)(var8 + 1);
         }

         int[][] var12 = field_855_j[var11];
         double var13 = 0.0D;
         double var15 = (double)var7 + 0.5D + (double)var12[0][0] * 0.5D;
         double var17 = (double)var8 + 0.5D + (double)var12[0][1] * 0.5D;
         double var19 = (double)var9 + 0.5D + (double)var12[0][2] * 0.5D;
         double var21 = (double)var7 + 0.5D + (double)var12[1][0] * 0.5D;
         double var23 = (double)var8 + 0.5D + (double)var12[1][1] * 0.5D;
         double var25 = (double)var9 + 0.5D + (double)var12[1][2] * 0.5D;
         double var27 = var21 - var15;
         double var29 = (var23 - var17) * 2.0D;
         double var31 = var25 - var19;
         if(var27 == 0.0D) {
            p_514_1_ = (double)var7 + 0.5D;
            var13 = p_514_5_ - (double)var9;
         } else if(var31 == 0.0D) {
            p_514_5_ = (double)var9 + 0.5D;
            var13 = p_514_1_ - (double)var7;
         } else {
            double var33 = p_514_1_ - var15;
            double var35 = p_514_5_ - var19;
            double var37 = (var33 * var27 + var35 * var31) * 2.0D;
            var13 = var37;
         }

         p_514_1_ = var15 + var27 * var13;
         p_514_3_ = var17 + var29 * var13;
         p_514_5_ = var19 + var31 * var13;
         if(var29 < 0.0D) {
            ++p_514_3_;
         }

         if(var29 > 0.0D) {
            p_514_3_ += 0.5D;
         }

         return Vec3D.func_1248_b(p_514_1_, p_514_3_, p_514_5_);
      } else {
         return null;
      }
   }

   protected void func_352_a(NBTTagCompound p_352_1_) {
      p_352_1_.func_758_a("Type", this.field_20913_d);
      if(this.field_20913_d == 2) {
         p_352_1_.func_765_a("PushX", this.field_9417_f);
         p_352_1_.func_765_a("PushZ", this.field_9416_g);
         p_352_1_.func_749_a("Fuel", (short)this.field_9418_e);
      } else if(this.field_20913_d == 1) {
         NBTTagList var2 = new NBTTagList();

         for(int var3 = 0; var3 < this.field_857_h.length; ++var3) {
            if(this.field_857_h[var3] != null) {
               NBTTagCompound var4 = new NBTTagCompound();
               var4.func_761_a("Slot", (byte)var3);
               this.field_857_h[var3].func_1086_a(var4);
               var2.func_742_a(var4);
            }
         }

         p_352_1_.func_762_a("Items", var2);
      }

   }

   protected void func_357_b(NBTTagCompound p_357_1_) {
      this.field_20913_d = p_357_1_.func_756_e("Type");
      if(this.field_20913_d == 2) {
         this.field_9417_f = p_357_1_.func_757_h("PushX");
         this.field_9416_g = p_357_1_.func_757_h("PushZ");
         this.field_9418_e = p_357_1_.func_745_d("Fuel");
      } else if(this.field_20913_d == 1) {
         NBTTagList var2 = p_357_1_.func_753_l("Items");
         this.field_857_h = new ItemStack[this.func_469_c()];

         for(int var3 = 0; var3 < var2.func_740_c(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.func_741_a(var3);
            int var5 = var4.func_746_c("Slot") & 255;
            if(var5 >= 0 && var5 < this.field_857_h.length) {
               this.field_857_h[var5] = ItemStack.func_35864_a(var4);
            }
         }
      }

   }

   public float func_392_h_() {
      return 0.0F;
   }

   public void func_380_f(Entity p_380_1_) {
      if(!this.field_615_ag.field_1026_y) {
         if(p_380_1_ != this.field_617_ae) {
            if(p_380_1_ instanceof EntityLiving && !(p_380_1_ instanceof EntityPlayer) && !(p_380_1_ instanceof EntityIronGolem) && this.field_20913_d == 0 && this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap > 0.01D && this.field_617_ae == null && p_380_1_.field_616_af == null) {
               p_380_1_.func_6377_h(this);
            }

            double var2 = p_380_1_.field_611_ak - this.field_611_ak;
            double var4 = p_380_1_.field_609_am - this.field_609_am;
            double var6 = var2 * var2 + var4 * var4;
            if(var6 >= 9.999999747378752E-5D) {
               var6 = (double)MathHelper.func_1109_a(var6);
               var2 /= var6;
               var4 /= var6;
               double var8 = 1.0D / var6;
               if(var8 > 1.0D) {
                  var8 = 1.0D;
               }

               var2 *= var8;
               var4 *= var8;
               var2 *= 0.10000000149011612D;
               var4 *= 0.10000000149011612D;
               var2 *= (double)(1.0F - this.field_632_aO);
               var4 *= (double)(1.0F - this.field_632_aO);
               var2 *= 0.5D;
               var4 *= 0.5D;
               if(p_380_1_ instanceof EntityMinecart) {
                  double var10 = p_380_1_.field_611_ak - this.field_611_ak;
                  double var12 = p_380_1_.field_609_am - this.field_609_am;
                  Vec3D var14 = Vec3D.func_1248_b(var10, 0.0D, var12).func_1252_b();
                  Vec3D var15 = Vec3D.func_1248_b((double)MathHelper.func_1114_b(this.field_605_aq * 3.1415927F / 180.0F), 0.0D, (double)MathHelper.func_1106_a(this.field_605_aq * 3.1415927F / 180.0F)).func_1252_b();
                  double var16 = Math.abs(var14.func_35612_b(var15));
                  if(var16 < 0.800000011920929D) {
                     return;
                  }

                  double var18 = p_380_1_.field_608_an + this.field_608_an;
                  double var20 = p_380_1_.field_606_ap + this.field_606_ap;
                  if(((EntityMinecart)p_380_1_).field_20913_d == 2 && this.field_20913_d != 2) {
                     this.field_608_an *= 0.20000000298023224D;
                     this.field_606_ap *= 0.20000000298023224D;
                     this.func_348_f(p_380_1_.field_608_an - var2, 0.0D, p_380_1_.field_606_ap - var4);
                     p_380_1_.field_608_an *= 0.949999988079071D;
                     p_380_1_.field_606_ap *= 0.949999988079071D;
                  } else if(((EntityMinecart)p_380_1_).field_20913_d != 2 && this.field_20913_d == 2) {
                     p_380_1_.field_608_an *= 0.20000000298023224D;
                     p_380_1_.field_606_ap *= 0.20000000298023224D;
                     p_380_1_.func_348_f(this.field_608_an + var2, 0.0D, this.field_606_ap + var4);
                     this.field_608_an *= 0.949999988079071D;
                     this.field_606_ap *= 0.949999988079071D;
                  } else {
                     var18 /= 2.0D;
                     var20 /= 2.0D;
                     this.field_608_an *= 0.20000000298023224D;
                     this.field_606_ap *= 0.20000000298023224D;
                     this.func_348_f(var18 - var2, 0.0D, var20 - var4);
                     p_380_1_.field_608_an *= 0.20000000298023224D;
                     p_380_1_.field_606_ap *= 0.20000000298023224D;
                     p_380_1_.func_348_f(var18 + var2, 0.0D, var20 + var4);
                  }
               } else {
                  this.func_348_f(-var2, 0.0D, -var4);
                  p_380_1_.func_348_f(var2 / 4.0D, 0.0D, var4 / 4.0D);
               }
            }

         }
      }
   }

   public int func_469_c() {
      return 27;
   }

   public ItemStack func_468_c(int p_468_1_) {
      return this.field_857_h[p_468_1_];
   }

   public ItemStack func_473_a(int p_473_1_, int p_473_2_) {
      if(this.field_857_h[p_473_1_] != null) {
         ItemStack var3;
         if(this.field_857_h[p_473_1_].field_1615_a <= p_473_2_) {
            var3 = this.field_857_h[p_473_1_];
            this.field_857_h[p_473_1_] = null;
            return var3;
         } else {
            var3 = this.field_857_h[p_473_1_].func_1085_a(p_473_2_);
            if(this.field_857_h[p_473_1_].field_1615_a == 0) {
               this.field_857_h[p_473_1_] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack func_48081_b(int p_48081_1_) {
      if(this.field_857_h[p_48081_1_] != null) {
         ItemStack var2 = this.field_857_h[p_48081_1_];
         this.field_857_h[p_48081_1_] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void func_472_a(int p_472_1_, ItemStack p_472_2_) {
      this.field_857_h[p_472_1_] = p_472_2_;
      if(p_472_2_ != null && p_472_2_.field_1615_a > this.func_470_e()) {
         p_472_2_.field_1615_a = this.func_470_e();
      }

   }

   public String func_471_d() {
      return "container.minecart";
   }

   public int func_470_e() {
      return 64;
   }

   public void func_474_j_() {}

   public boolean func_353_a(EntityPlayer p_353_1_) {
      if(this.field_20913_d == 0) {
         if(this.field_617_ae != null && this.field_617_ae instanceof EntityPlayer && this.field_617_ae != p_353_1_) {
            return true;
         }

         if(!this.field_615_ag.field_1026_y) {
            p_353_1_.func_6377_h(this);
         }
      } else if(this.field_20913_d == 1) {
         if(!this.field_615_ag.field_1026_y) {
            p_353_1_.func_452_a(this);
         }
      } else if(this.field_20913_d == 2) {
         ItemStack var2 = p_353_1_.field_778_b.func_494_a();
         if(var2 != null && var2.field_1617_c == Item.field_225_k.field_291_aS) {
            if(--var2.field_1615_a == 0) {
               p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, (ItemStack)null);
            }

            this.field_9418_e += 3600;
         }

         this.field_9417_f = this.field_611_ak - p_353_1_.field_611_ak;
         this.field_9416_g = this.field_609_am - p_353_1_.field_609_am;
      }

      return true;
   }

   public void func_378_a(double p_378_1_, double p_378_3_, double p_378_5_, float p_378_7_, float p_378_8_, int p_378_9_) {
      this.field_9414_l = p_378_1_;
      this.field_9413_m = p_378_3_;
      this.field_9412_n = p_378_5_;
      this.field_9411_o = (double)p_378_7_;
      this.field_9410_p = (double)p_378_8_;
      this.field_9415_k = p_378_9_ + 2;
      this.field_608_an = this.field_9409_q;
      this.field_607_ao = this.field_9408_r;
      this.field_606_ap = this.field_9407_s;
   }

   public void func_6375_a(double p_6375_1_, double p_6375_3_, double p_6375_5_) {
      this.field_9409_q = this.field_608_an = p_6375_1_;
      this.field_9408_r = this.field_607_ao = p_6375_3_;
      this.field_9407_s = this.field_606_ap = p_6375_5_;
   }

   public boolean func_20070_a_(EntityPlayer p_20070_1_) {
      return this.field_646_aA?false:p_20070_1_.func_387_e(this) <= 64.0D;
   }

   protected boolean func_41026_g() {
      return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
   }

   protected void func_41027_b(boolean p_41027_1_) {
      if(p_41027_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(this.field_21064_bx.func_21130_a(16) | 1)));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(this.field_21064_bx.func_21130_a(16) & -2)));
      }

   }

   public void func_35142_x_() {}

   public void func_35141_y_() {}

   public void func_41024_b(int p_41024_1_) {
      this.field_21064_bx.func_21129_b(19, Integer.valueOf(p_41024_1_));
   }

   public int func_41025_i() {
      return this.field_21064_bx.func_25115_b(19);
   }

   public void func_41028_c(int p_41028_1_) {
      this.field_21064_bx.func_21129_b(17, Integer.valueOf(p_41028_1_));
   }

   public int func_41023_l() {
      return this.field_21064_bx.func_25115_b(17);
   }

   public void func_41029_h(int p_41029_1_) {
      this.field_21064_bx.func_21129_b(18, Integer.valueOf(p_41029_1_));
   }

   public int func_41030_m() {
      return this.field_21064_bx.func_25115_b(18);
   }

}
