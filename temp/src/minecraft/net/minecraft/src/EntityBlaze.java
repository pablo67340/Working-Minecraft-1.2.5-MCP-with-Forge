package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySmallFireball;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityBlaze extends EntityMob {

   private float field_40154_a = 0.5F;
   private int field_40153_b;
   private int field_40152_d;


   public EntityBlaze(World p_i36_1_) {
      super(p_i36_1_);
      this.field_9357_z = "/mob/fire.png";
      this.field_9304_bm = true;
      this.field_762_e = 6;
      this.field_35171_bJ = 10;
   }

   public int func_40117_c() {
      return 20;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, new Byte((byte)0));
   }

   protected String func_6389_d() {
      return "mob.blaze.breathe";
   }

   protected String func_6394_f_() {
      return "mob.blaze.hit";
   }

   protected String func_6390_f() {
      return "mob.blaze.death";
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      return super.func_396_a(p_396_1_, p_396_2_);
   }

   public void func_419_b(DamageSource p_419_1_) {
      super.func_419_b(p_419_1_);
   }

   public int func_35115_a(float p_35115_1_) {
      return 15728880;
   }

   public float func_382_a(float p_382_1_) {
      return 1.0F;
   }

   public void func_425_j() {
      if(!this.field_615_ag.field_1026_y) {
         if(this.func_27012_af()) {
            this.func_396_a(DamageSource.field_35539_e, 1);
         }

         --this.field_40153_b;
         if(this.field_40153_b <= 0) {
            this.field_40153_b = 100;
            this.field_40154_a = 0.5F + (float)this.field_9312_bd.nextGaussian() * 3.0F;
         }

         if(this.func_25030_F() != null && this.func_25030_F().field_610_al + (double)this.func_25030_F().func_373_s() > this.field_610_al + (double)this.func_373_s() + (double)this.field_40154_a) {
            this.field_607_ao += (0.30000001192092896D - this.field_607_ao) * 0.30000001192092896D;
         }
      }

      if(this.field_9312_bd.nextInt(24) == 0) {
         this.field_615_ag.func_684_a(this.field_611_ak + 0.5D, this.field_610_al + 0.5D, this.field_609_am + 0.5D, "fire.fire", 1.0F + this.field_9312_bd.nextFloat(), this.field_9312_bd.nextFloat() * 0.7F + 0.3F);
      }

      if(!this.field_9298_aH && this.field_607_ao < 0.0D) {
         this.field_607_ao *= 0.6D;
      }

      for(int var1 = 0; var1 < 2; ++var1) {
         this.field_615_ag.func_694_a("largesmoke", this.field_611_ak + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC, this.field_610_al + this.field_9312_bd.nextDouble() * (double)this.field_643_aD, this.field_609_am + (this.field_9312_bd.nextDouble() - 0.5D) * (double)this.field_644_aC, 0.0D, 0.0D, 0.0D);
      }

      super.func_425_j();
   }

   protected void func_437_a(Entity p_437_1_, float p_437_2_) {
      if(this.field_9330_P <= 0 && p_437_2_ < 2.0F && p_437_1_.field_601_au.field_1702_e > this.field_601_au.field_1697_b && p_437_1_.field_601_au.field_1697_b < this.field_601_au.field_1702_e) {
         this.field_9330_P = 20;
         this.func_35175_b(p_437_1_);
      } else if(p_437_2_ < 30.0F) {
         double var3 = p_437_1_.field_611_ak - this.field_611_ak;
         double var5 = p_437_1_.field_601_au.field_1697_b + (double)(p_437_1_.field_643_aD / 2.0F) - (this.field_610_al + (double)(this.field_643_aD / 2.0F));
         double var7 = p_437_1_.field_609_am - this.field_609_am;
         if(this.field_9330_P == 0) {
            ++this.field_40152_d;
            if(this.field_40152_d == 1) {
               this.field_9330_P = 60;
               this.func_40150_a(true);
            } else if(this.field_40152_d <= 4) {
               this.field_9330_P = 6;
            } else {
               this.field_9330_P = 100;
               this.field_40152_d = 0;
               this.func_40150_a(false);
            }

            if(this.field_40152_d > 1) {
               float var9 = MathHelper.func_1113_c(p_437_2_) * 0.5F;
               this.field_615_ag.func_28107_a((EntityPlayer)null, 1009, (int)this.field_611_ak, (int)this.field_610_al, (int)this.field_609_am, 0);

               for(int var10 = 0; var10 < 1; ++var10) {
                  EntitySmallFireball var11 = new EntitySmallFireball(this.field_615_ag, this, var3 + this.field_9312_bd.nextGaussian() * (double)var9, var5, var7 + this.field_9312_bd.nextGaussian() * (double)var9);
                  var11.field_610_al = this.field_610_al + (double)(this.field_643_aD / 2.0F) + 0.5D;
                  this.field_615_ag.func_674_a(var11);
               }
            }
         }

         this.field_605_aq = (float)(Math.atan2(var7, var3) * 180.0D / 3.1415927410125732D) - 90.0F;
         this.field_750_g = true;
      }

   }

   protected void func_400_c(float p_400_1_) {}

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected int func_422_g() {
      return Item.field_40417_bo.field_291_aS;
   }

   public boolean func_21062_U() {
      return this.func_40151_ac();
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      if(p_21066_1_) {
         int var3 = this.field_9312_bd.nextInt(2 + p_21066_2_);

         for(int var4 = 0; var4 < var3; ++var4) {
            this.func_367_b(Item.field_40417_bo.field_291_aS, 1);
         }
      }

   }

   public boolean func_40151_ac() {
      return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
   }

   public void func_40150_a(boolean p_40150_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_40150_1_) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.field_21064_bx.func_21129_b(16, Byte.valueOf(var2));
   }

   protected boolean func_40147_Y() {
      return true;
   }
}
