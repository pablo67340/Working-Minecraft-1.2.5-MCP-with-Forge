package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIBeg;
import net.minecraft.src.EntityAIFollowOwner;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILeapAtTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIOwnerHurtByTarget;
import net.minecraft.src.EntityAIOwnerHurtTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITargetNonTamed;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.Item;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.PathEntity;
import net.minecraft.src.World;

public class EntityWolf extends EntityTameable {

   private boolean field_25049_a = false;
   private float field_25048_b;
   private float field_25054_c;
   private boolean field_25053_f;
   private boolean field_25052_g;
   private float field_25051_h;
   private float field_25050_i;


   public EntityWolf(World p_i701_1_) {
      super(p_i701_1_);
      this.field_9357_z = "/mob/wolf.png";
      this.func_371_a(0.6F, 0.8F);
      this.field_9333_am = 0.3F;
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(2, this.field_48146_a);
      this.field_46019_bU.func_46118_a(3, new EntityAILeapAtTarget(this, 0.4F));
      this.field_46019_bU.func_46118_a(4, new EntityAIAttackOnCollide(this, this.field_9333_am, true));
      this.field_46019_bU.func_46118_a(5, new EntityAIFollowOwner(this, this.field_9333_am, 10.0F, 2.0F));
      this.field_46019_bU.func_46118_a(6, new EntityAIMate(this, this.field_9333_am));
      this.field_46019_bU.func_46118_a(7, new EntityAIWander(this, this.field_9333_am));
      this.field_46019_bU.func_46118_a(8, new EntityAIBeg(this, 8.0F));
      this.field_46019_bU.func_46118_a(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_46019_bU.func_46118_a(9, new EntityAILookIdle(this));
      this.field_48105_bU.func_46118_a(1, new EntityAIOwnerHurtByTarget(this));
      this.field_48105_bU.func_46118_a(2, new EntityAIOwnerHurtTarget(this));
      this.field_48105_bU.func_46118_a(3, new EntityAIHurtByTarget(this, true));
      this.field_48105_bU.func_46118_a(4, new EntityAITargetNonTamed(this, EntitySheep.class, 16.0F, 200, false));
   }

   public boolean func_46006_aR() {
      return true;
   }

   public void func_48092_c(EntityLiving p_48092_1_) {
      super.func_48092_c(p_48092_1_);
      if(p_48092_1_ instanceof EntityPlayer) {
         this.func_25041_c(true);
      }

   }

   protected void func_48097_s_() {
      this.field_21064_bx.func_21129_b(18, Integer.valueOf(this.func_40114_aH()));
   }

   public int func_40117_c() {
      return this.func_48139_F_()?20:8;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(18, new Integer(this.func_40114_aH()));
   }

   protected boolean func_25021_m() {
      return false;
   }

   public String func_6376_z() {
      return this.func_48139_F_()?"/mob/wolf_tame.png":(this.func_25040_C()?"/mob/wolf_angry.png":super.func_6376_z());
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_748_a("Angry", this.func_25040_C());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_25041_c(p_357_1_.func_760_m("Angry"));
   }

   protected boolean func_25023_u() {
      return this.func_25040_C();
   }

   protected String func_6389_d() {
      return this.func_25040_C()?"mob.wolf.growl":(this.field_9312_bd.nextInt(3) == 0?(this.func_48139_F_() && this.field_21064_bx.func_25115_b(18) < 10?"mob.wolf.whine":"mob.wolf.panting"):"mob.wolf.bark");
   }

   protected String func_6394_f_() {
      return "mob.wolf.hurt";
   }

   protected String func_6390_f() {
      return "mob.wolf.death";
   }

   protected float func_6393_h() {
      return 0.4F;
   }

   protected int func_422_g() {
      return -1;
   }

   public void func_425_j() {
      super.func_425_j();
      if(!this.field_615_ag.field_1026_y && this.field_25053_f && !this.field_25052_g && !this.func_25031_E() && this.field_9298_aH) {
         this.field_25052_g = true;
         this.field_25051_h = 0.0F;
         this.field_25050_i = 0.0F;
         this.field_615_ag.func_9425_a(this, (byte)8);
      }

   }

   public void func_370_e_() {
      super.func_370_e_();
      this.field_25054_c = this.field_25048_b;
      if(this.field_25049_a) {
         this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
      } else {
         this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
      }

      if(this.field_25049_a) {
         this.field_4127_c = 10;
      }

      if(this.func_27012_af()) {
         this.field_25053_f = true;
         this.field_25052_g = false;
         this.field_25051_h = 0.0F;
         this.field_25050_i = 0.0F;
      } else if((this.field_25053_f || this.field_25052_g) && this.field_25052_g) {
         if(this.field_25051_h == 0.0F) {
            this.field_615_ag.func_623_a(this, "mob.wolf.shake", this.func_6393_h(), (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
         }

         this.field_25050_i = this.field_25051_h;
         this.field_25051_h += 0.05F;
         if(this.field_25050_i >= 2.0F) {
            this.field_25053_f = false;
            this.field_25052_g = false;
            this.field_25050_i = 0.0F;
            this.field_25051_h = 0.0F;
         }

         if(this.field_25051_h > 0.4F) {
            float var1 = (float)this.field_601_au.field_1697_b;
            int var2 = (int)(MathHelper.func_1106_a((this.field_25051_h - 0.4F) * 3.1415927F) * 7.0F);

            for(int var3 = 0; var3 < var2; ++var3) {
               float var4 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC * 0.5F;
               float var5 = (this.field_9312_bd.nextFloat() * 2.0F - 1.0F) * this.field_644_aC * 0.5F;
               this.field_615_ag.func_694_a("splash", this.field_611_ak + (double)var4, (double)(var1 + 0.8F), this.field_609_am + (double)var5, this.field_608_an, this.field_607_ao, this.field_606_ap);
            }
         }
      }

   }

   public boolean func_25039_v() {
      return this.field_25053_f;
   }

   public float func_25043_b_(float p_25043_1_) {
      return 0.75F + (this.field_25050_i + (this.field_25051_h - this.field_25050_i) * p_25043_1_) / 2.0F * 0.25F;
   }

   public float func_25042_a(float p_25042_1_, float p_25042_2_) {
      float var3 = (this.field_25050_i + (this.field_25051_h - this.field_25050_i) * p_25042_1_ + p_25042_2_) / 1.8F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      } else if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      return MathHelper.func_1106_a(var3 * 3.1415927F) * MathHelper.func_1106_a(var3 * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
   }

   public float func_25033_c(float p_25033_1_) {
      return (this.field_25054_c + (this.field_25048_b - this.field_25054_c) * p_25033_1_) * 0.15F * 3.1415927F;
   }

   public float func_373_s() {
      return this.field_643_aD * 0.8F;
   }

   public int func_25026_x() {
      return this.func_48141_af()?20:super.func_25026_x();
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      Entity var3 = p_396_1_.func_35532_a();
      this.field_48146_a.func_48407_a(false);
      if(var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow)) {
         p_396_2_ = (p_396_2_ + 1) / 2;
      }

      return super.func_396_a(p_396_1_, p_396_2_);
   }

   public boolean func_35175_b(Entity p_35175_1_) {
      int var2 = this.func_48139_F_()?4:2;
      return p_35175_1_.func_396_a(DamageSource.func_35525_a(this), var2);
   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      ItemStack var2 = p_353_1_.field_778_b.func_494_a();
      if(!this.func_48139_F_()) {
         if(var2 != null && var2.field_1617_c == Item.field_21020_aV.field_291_aS && !this.func_25040_C()) {
            if(!p_353_1_.field_35212_aW.field_35756_d) {
               --var2.field_1615_a;
            }

            if(var2.field_1615_a <= 0) {
               p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, (ItemStack)null);
            }

            if(!this.field_615_ag.field_1026_y) {
               if(this.field_9312_bd.nextInt(3) == 0) {
                  this.func_48138_b(true);
                  this.func_25029_a((PathEntity)null);
                  this.func_48092_c((EntityLiving)null);
                  this.field_48146_a.func_48407_a(true);
                  this.func_40121_k(20);
                  this.func_48143_a(p_353_1_.field_771_i);
                  this.func_48142_a(true);
                  this.field_615_ag.func_9425_a(this, (byte)7);
               } else {
                  this.func_48142_a(false);
                  this.field_615_ag.func_9425_a(this, (byte)6);
               }
            }

            return true;
         }
      } else {
         if(var2 != null && Item.field_233_c[var2.field_1617_c] instanceof ItemFood) {
            ItemFood var3 = (ItemFood)Item.field_233_c[var2.field_1617_c];
            if(var3.func_25012_m() && this.field_21064_bx.func_25115_b(18) < 20) {
               if(!p_353_1_.field_35212_aW.field_35756_d) {
                  --var2.field_1615_a;
               }

               this.func_432_b(var3.func_25011_l());
               if(var2.field_1615_a <= 0) {
                  p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, (ItemStack)null);
               }

               return true;
            }
         }

         if(p_353_1_.field_771_i.equalsIgnoreCase(this.func_48145_ag()) && !this.field_615_ag.field_1026_y && !this.func_40143_a(var2)) {
            this.field_48146_a.func_48407_a(!this.func_48141_af());
            this.field_9336_ak = false;
            this.func_25029_a((PathEntity)null);
         }
      }

      return super.func_353_a(p_353_1_);
   }

   public void func_9282_a(byte p_9282_1_) {
      if(p_9282_1_ == 8) {
         this.field_25052_g = true;
         this.field_25051_h = 0.0F;
         this.field_25050_i = 0.0F;
      } else {
         super.func_9282_a(p_9282_1_);
      }

   }

   public float func_25037_z() {
      return this.func_25040_C()?1.5393804F:(this.func_48139_F_()?(0.55F - (float)(20 - this.field_21064_bx.func_25115_b(18)) * 0.02F) * 3.1415927F:0.62831855F);
   }

   public boolean func_40143_a(ItemStack p_40143_1_) {
      return p_40143_1_ == null?false:(!(Item.field_233_c[p_40143_1_.field_1617_c] instanceof ItemFood)?false:((ItemFood)Item.field_233_c[p_40143_1_.field_1617_c]).func_25012_m());
   }

   public int func_6391_i() {
      return 8;
   }

   public boolean func_25040_C() {
      return (this.field_21064_bx.func_21130_a(16) & 2) != 0;
   }

   public void func_25041_c(boolean p_25041_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_25041_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 | 2)));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 & -3)));
      }

   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      EntityWolf var2 = new EntityWolf(this.field_615_ag);
      var2.func_48143_a(this.func_48145_ag());
      var2.func_48138_b(true);
      return var2;
   }

   public void func_48150_h(boolean p_48150_1_) {
      this.field_25049_a = p_48150_1_;
   }

   public boolean func_48135_b(EntityAnimal p_48135_1_) {
      if(p_48135_1_ == this) {
         return false;
      } else if(!this.func_48139_F_()) {
         return false;
      } else if(!(p_48135_1_ instanceof EntityWolf)) {
         return false;
      } else {
         EntityWolf var2 = (EntityWolf)p_48135_1_;
         return !var2.func_48139_F_()?false:(var2.func_48141_af()?false:this.func_48136_o_() && var2.func_48136_o_());
      }
   }
}
