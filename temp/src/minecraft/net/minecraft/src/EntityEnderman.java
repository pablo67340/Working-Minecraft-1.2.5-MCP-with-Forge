package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityDamageSourceIndirect;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityEnderman extends EntityMob {

   private static boolean[] field_35186_b = new boolean[256];
   public boolean field_35187_a = false;
   private int field_35184_d = 0;
   private int field_35185_e = 0;


   public EntityEnderman(World p_i389_1_) {
      super(p_i389_1_);
      this.field_9357_z = "/mob/enderman.png";
      this.field_9333_am = 0.2F;
      this.field_762_e = 7;
      this.func_371_a(0.6F, 2.9F);
      this.field_9286_aZ = 1.0F;
   }

   public int func_40117_c() {
      return 40;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, new Byte((byte)0));
      this.field_21064_bx.func_21124_a(17, new Byte((byte)0));
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_749_a("carried", (short)this.func_35176_r());
      p_352_1_.func_749_a("carriedData", (short)this.func_35180_s());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_35177_b(p_357_1_.func_745_d("carried"));
      this.func_35181_c(p_357_1_.func_745_d("carriedData"));
   }

   protected Entity func_438_i() {
      EntityPlayer var1 = this.field_615_ag.func_40480_b(this, 64.0D);
      if(var1 != null) {
         if(this.func_35183_c(var1)) {
            if(this.field_35185_e++ == 5) {
               this.field_35185_e = 0;
               return var1;
            }
         } else {
            this.field_35185_e = 0;
         }
      }

      return null;
   }

   public int func_35115_a(float p_35115_1_) {
      return super.func_35115_a(p_35115_1_);
   }

   public float func_382_a(float p_382_1_) {
      return super.func_382_a(p_382_1_);
   }

   private boolean func_35183_c(EntityPlayer p_35183_1_) {
      ItemStack var2 = p_35183_1_.field_778_b.field_842_b[3];
      if(var2 != null && var2.field_1617_c == Block.field_4055_bb.field_376_bc) {
         return false;
      } else {
         Vec3D var3 = p_35183_1_.func_430_f(1.0F).func_1252_b();
         Vec3D var4 = Vec3D.func_1248_b(this.field_611_ak - p_35183_1_.field_611_ak, this.field_601_au.field_1697_b + (double)(this.field_643_aD / 2.0F) - (p_35183_1_.field_610_al + (double)p_35183_1_.func_373_s()), this.field_609_am - p_35183_1_.field_609_am);
         double var5 = var4.func_1253_c();
         var4 = var4.func_1252_b();
         double var7 = var3.func_35612_b(var4);
         return var7 > 1.0D - 0.025D / var5?p_35183_1_.func_420_c(this):false;
      }
   }

   public void func_425_j() {
      if(this.func_27012_af()) {
         this.func_396_a(DamageSource.field_35539_e, 1);
      }

      this.field_35187_a = this.field_751_f != null;
      this.field_9333_am = this.field_751_f != null?6.5F:0.3F;
      int var1;
      if(!this.field_615_ag.field_1026_y) {
         int var2;
         int var3;
         int var4;
         if(this.func_35176_r() == 0) {
            if(this.field_9312_bd.nextInt(20) == 0) {
               var1 = MathHelper.func_1108_b(this.field_611_ak - 2.0D + this.field_9312_bd.nextDouble() * 4.0D);
               var2 = MathHelper.func_1108_b(this.field_610_al + this.field_9312_bd.nextDouble() * 3.0D);
               var3 = MathHelper.func_1108_b(this.field_609_am - 2.0D + this.field_9312_bd.nextDouble() * 4.0D);
               var4 = this.field_615_ag.func_600_a(var1, var2, var3);
               if(field_35186_b[var4]) {
                  this.func_35177_b(this.field_615_ag.func_600_a(var1, var2, var3));
                  this.func_35181_c(this.field_615_ag.func_602_e(var1, var2, var3));
                  this.field_615_ag.func_690_d(var1, var2, var3, 0);
               }
            }
         } else if(this.field_9312_bd.nextInt(2000) == 0) {
            var1 = MathHelper.func_1108_b(this.field_611_ak - 1.0D + this.field_9312_bd.nextDouble() * 2.0D);
            var2 = MathHelper.func_1108_b(this.field_610_al + this.field_9312_bd.nextDouble() * 2.0D);
            var3 = MathHelper.func_1108_b(this.field_609_am - 1.0D + this.field_9312_bd.nextDouble() * 2.0D);
            var4 = this.field_615_ag.func_600_a(var1, var2, var3);
            int var5 = this.field_615_ag.func_600_a(var1, var2 - 1, var3);
            if(var4 == 0 && var5 > 0 && Block.field_345_n[var5].func_242_c()) {
               this.field_615_ag.func_688_b(var1, var2, var3, this.func_35176_r(), this.func_35180_s());
               this.func_35177_b(0);
            }
         }
      }

      for(var1 = 0; var1 < 2; ++var1) {
         this.field_615_ag.func_694_a("portal", this.field_611_ak + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC, this.field_610_al + this.field_9312_bd.nextDouble() * (double)this.field_643_aD - 0.25D, this.field_609_am + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC, (this.field_9312_bd.nextDouble() - 0.5D) * 2.0D, -this.field_9312_bd.nextDouble(), (this.field_9312_bd.nextDouble() - 0.5D) * 2.0D);
      }

      if(this.field_615_ag.func_624_b() && !this.field_615_ag.field_1026_y) {
         float var6 = this.func_382_a(1.0F);
         if(var6 > 0.5F && this.field_615_ag.func_647_i(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) && this.field_9312_bd.nextFloat() * 30.0F < (var6 - 0.4F) * 2.0F) {
            this.field_751_f = null;
            this.func_35178_q();
         }
      }

      if(this.func_27012_af()) {
         this.field_751_f = null;
         this.func_35178_q();
      }

      this.field_9336_ak = false;
      if(this.field_751_f != null) {
         this.func_426_b(this.field_751_f, 100.0F, 100.0F);
      }

      if(!this.field_615_ag.field_1026_y && this.func_354_B()) {
         if(this.field_751_f != null) {
            if(this.field_751_f instanceof EntityPlayer && this.func_35183_c((EntityPlayer)this.field_751_f)) {
               this.field_9342_ah = this.field_9340_ai = 0.0F;
               this.field_9333_am = 0.0F;
               if(this.field_751_f.func_387_e(this) < 16.0D) {
                  this.func_35178_q();
               }

               this.field_35184_d = 0;
            } else if(this.field_751_f.func_387_e(this) > 256.0D && this.field_35184_d++ >= 30 && this.func_35182_c(this.field_751_f)) {
               this.field_35184_d = 0;
            }
         } else {
            this.field_35184_d = 0;
         }
      }

      super.func_425_j();
   }

   protected boolean func_35178_q() {
      double var1 = this.field_611_ak + (this.field_9312_bd.nextDouble() - 0.5D) * 64.0D;
      double var3 = this.field_610_al + (double)(this.field_9312_bd.nextInt(64) - 32);
      double var5 = this.field_609_am + (this.field_9312_bd.nextDouble() - 0.5D) * 64.0D;
      return this.func_35179_a_(var1, var3, var5);
   }

   protected boolean func_35182_c(Entity p_35182_1_) {
      Vec3D var2 = Vec3D.func_1248_b(this.field_611_ak - p_35182_1_.field_611_ak, this.field_601_au.field_1697_b + (double)(this.field_643_aD / 2.0F) - p_35182_1_.field_610_al + (double)p_35182_1_.func_373_s(), this.field_609_am - p_35182_1_.field_609_am);
      var2 = var2.func_1252_b();
      double var3 = 16.0D;
      double var5 = this.field_611_ak + (this.field_9312_bd.nextDouble() - 0.5D) * 8.0D - var2.field_1776_a * var3;
      double var7 = this.field_610_al + (double)(this.field_9312_bd.nextInt(16) - 8) - var2.field_1775_b * var3;
      double var9 = this.field_609_am + (this.field_9312_bd.nextDouble() - 0.5D) * 8.0D - var2.field_1779_c * var3;
      return this.func_35179_a_(var5, var7, var9);
   }

   protected boolean func_35179_a_(double p_35179_1_, double p_35179_3_, double p_35179_5_) {
      double var7 = this.field_611_ak;
      double var9 = this.field_610_al;
      double var11 = this.field_609_am;
      this.field_611_ak = p_35179_1_;
      this.field_610_al = p_35179_3_;
      this.field_609_am = p_35179_5_;
      boolean var13 = false;
      int var14 = MathHelper.func_1108_b(this.field_611_ak);
      int var15 = MathHelper.func_1108_b(this.field_610_al);
      int var16 = MathHelper.func_1108_b(this.field_609_am);
      int var18;
      if(this.field_615_ag.func_630_d(var14, var15, var16)) {
         boolean var17 = false;

         while(!var17 && var15 > 0) {
            var18 = this.field_615_ag.func_600_a(var14, var15 - 1, var16);
            if(var18 != 0 && Block.field_345_n[var18].field_356_bn.func_880_c()) {
               var17 = true;
            } else {
               --this.field_610_al;
               --var15;
            }
         }

         if(var17) {
            this.func_347_a(this.field_611_ak, this.field_610_al, this.field_609_am);
            if(this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au)) {
               var13 = true;
            }
         }
      }

      if(!var13) {
         this.func_347_a(var7, var9, var11);
         return false;
      } else {
         short var30 = 128;

         for(var18 = 0; var18 < var30; ++var18) {
            double var19 = (double)var18 / ((double)var30 - 1.0D);
            float var21 = (this.field_9312_bd.nextFloat() - 0.5F) * 0.2F;
            float var22 = (this.field_9312_bd.nextFloat() - 0.5F) * 0.2F;
            float var23 = (this.field_9312_bd.nextFloat() - 0.5F) * 0.2F;
            double var24 = var7 + (this.field_611_ak - var7) * var19 + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC * 2.0D;
            double var26 = var9 + (this.field_610_al - var9) * var19 + this.field_9312_bd.nextDouble() * (double)this.field_643_aD;
            double var28 = var11 + (this.field_609_am - var11) * var19 + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC * 2.0D;
            this.field_615_ag.func_694_a("portal", var24, var26, var28, (double)var21, (double)var22, (double)var23);
         }

         this.field_615_ag.func_684_a(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
         this.field_615_ag.func_623_a(this, "mob.endermen.portal", 1.0F, 1.0F);
         return true;
      }
   }

   protected String func_6389_d() {
      return "mob.endermen.idle";
   }

   protected String func_6394_f_() {
      return "mob.endermen.hit";
   }

   protected String func_6390_f() {
      return "mob.endermen.death";
   }

   protected int func_422_g() {
      return Item.field_35416_bo.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.func_422_g();
      if(var3 > 0) {
         int var4 = this.field_9312_bd.nextInt(2 + p_21066_2_);

         for(int var5 = 0; var5 < var4; ++var5) {
            this.func_367_b(var3, 1);
         }
      }

   }

   public void func_35177_b(int p_35177_1_) {
      this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(p_35177_1_ & 255)));
   }

   public int func_35176_r() {
      return this.field_21064_bx.func_21130_a(16);
   }

   public void func_35181_c(int p_35181_1_) {
      this.field_21064_bx.func_21129_b(17, Byte.valueOf((byte)(p_35181_1_ & 255)));
   }

   public int func_35180_s() {
      return this.field_21064_bx.func_21130_a(17);
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(p_396_1_ instanceof EntityDamageSourceIndirect) {
         for(int var3 = 0; var3 < 64; ++var3) {
            if(this.func_35178_q()) {
               return true;
            }
         }

         return false;
      } else {
         return super.func_396_a(p_396_1_, p_396_2_);
      }
   }

   static {
      field_35186_b[Block.field_337_v.field_376_bc] = true;
      field_35186_b[Block.field_336_w.field_376_bc] = true;
      field_35186_b[Block.field_393_F.field_376_bc] = true;
      field_35186_b[Block.field_392_G.field_376_bc] = true;
      field_35186_b[Block.field_417_ae.field_376_bc] = true;
      field_35186_b[Block.field_416_af.field_376_bc] = true;
      field_35186_b[Block.field_415_ag.field_376_bc] = true;
      field_35186_b[Block.field_414_ah.field_376_bc] = true;
      field_35186_b[Block.field_408_an.field_376_bc] = true;
      field_35186_b[Block.field_425_aW.field_376_bc] = true;
      field_35186_b[Block.field_424_aX.field_376_bc] = true;
      field_35186_b[Block.field_4055_bb.field_376_bc] = true;
      field_35186_b[Block.field_35281_bs.field_376_bc] = true;
      field_35186_b[Block.field_40199_bz.field_376_bc] = true;
   }
}
