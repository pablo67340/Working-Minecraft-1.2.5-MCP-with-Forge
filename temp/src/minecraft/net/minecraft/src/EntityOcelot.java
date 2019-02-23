package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAvoidEntity;
import net.minecraft.src.EntityAIFollowOwner;
import net.minecraft.src.EntityAILeapAtTarget;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIOcelotAttack;
import net.minecraft.src.EntityAIOcelotSit;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITargetNonTamed;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityOcelot extends EntityTameable {

   private EntityAITempt field_48149_b;


   public EntityOcelot(World p_i1072_1_) {
      super(p_i1072_1_);
      this.field_9357_z = "/mob/ozelot.png";
      this.func_371_a(0.6F, 0.8F);
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(2, this.field_48146_a);
      this.field_46019_bU.func_46118_a(3, this.field_48149_b = new EntityAITempt(this, 0.18F, Item.field_4021_aS.field_291_aS, true));
      this.field_46019_bU.func_46118_a(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 16.0F, 0.23F, 0.4F));
      this.field_46019_bU.func_46118_a(5, new EntityAIFollowOwner(this, 0.3F, 10.0F, 5.0F));
      this.field_46019_bU.func_46118_a(6, new EntityAIOcelotSit(this, 0.4F));
      this.field_46019_bU.func_46118_a(7, new EntityAILeapAtTarget(this, 0.3F));
      this.field_46019_bU.func_46118_a(8, new EntityAIOcelotAttack(this));
      this.field_46019_bU.func_46118_a(9, new EntityAIMate(this, 0.23F));
      this.field_46019_bU.func_46118_a(10, new EntityAIWander(this, 0.23F));
      this.field_46019_bU.func_46118_a(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
      this.field_48105_bU.func_46118_a(1, new EntityAITargetNonTamed(this, EntityChicken.class, 14.0F, 750, false));
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(18, Byte.valueOf((byte)0));
   }

   public void func_48097_s_() {
      if(!this.func_46009_aH().func_48186_a()) {
         this.func_48078_c(false);
         this.func_35113_c(false);
      } else {
         float var1 = this.func_46009_aH().func_48184_b();
         if(var1 == 0.18F) {
            this.func_48078_c(true);
            this.func_35113_c(false);
         } else if(var1 == 0.4F) {
            this.func_48078_c(false);
            this.func_35113_c(true);
         } else {
            this.func_48078_c(false);
            this.func_35113_c(false);
         }
      }

   }

   protected boolean func_25023_u() {
      return !this.func_48139_F_();
   }

   public String func_6376_z() {
      switch(this.func_48148_ad()) {
      case 0:
         return "/mob/ozelot.png";
      case 1:
         return "/mob/cat_black.png";
      case 2:
         return "/mob/cat_red.png";
      case 3:
         return "/mob/cat_siamese.png";
      default:
         return super.func_6376_z();
      }
   }

   public boolean func_46006_aR() {
      return true;
   }

   public int func_40117_c() {
      return 10;
   }

   protected void func_400_c(float p_400_1_) {}

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_758_a("CatType", this.func_48148_ad());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_48147_c(p_357_1_.func_756_e("CatType"));
   }

   protected String func_6389_d() {
      return this.func_48139_F_()?(this.func_48136_o_()?"mob.cat.purr":(this.field_9312_bd.nextInt(4) == 0?"mob.cat.purreow":"mob.cat.meow")):"";
   }

   protected String func_6394_f_() {
      return "mob.cat.hitt";
   }

   protected String func_6390_f() {
      return "mob.cat.hitt";
   }

   protected float func_6393_h() {
      return 0.4F;
   }

   protected int func_422_g() {
      return Item.field_306_aD.field_291_aS;
   }

   public boolean func_35175_b(Entity p_35175_1_) {
      return p_35175_1_.func_396_a(DamageSource.func_35525_a(this), 3);
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      this.field_48146_a.func_48407_a(false);
      return super.func_396_a(p_396_1_, p_396_2_);
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {}

   public boolean func_353_a(EntityPlayer p_353_1_) {
      ItemStack var2 = p_353_1_.field_778_b.func_494_a();
      if(!this.func_48139_F_()) {
         if(this.field_48149_b.func_48270_h() && var2 != null && var2.field_1617_c == Item.field_4021_aS.field_291_aS && p_353_1_.func_387_e(this) < 9.0D) {
            --var2.field_1615_a;
            if(var2.field_1615_a <= 0) {
               p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, (ItemStack)null);
            }

            if(!this.field_615_ag.field_1026_y) {
               if(this.field_9312_bd.nextInt(3) == 0) {
                  this.func_48138_b(true);
                  this.func_48147_c(1 + this.field_615_ag.field_1037_n.nextInt(3));
                  this.func_48143_a(p_353_1_.field_771_i);
                  this.func_48142_a(true);
                  this.field_48146_a.func_48407_a(true);
                  this.field_615_ag.func_9425_a(this, (byte)7);
               } else {
                  this.func_48142_a(false);
                  this.field_615_ag.func_9425_a(this, (byte)6);
               }
            }
         }

         return true;
      } else {
         if(p_353_1_.field_771_i.equalsIgnoreCase(this.func_48145_ag()) && !this.field_615_ag.field_1026_y && !this.func_40143_a(var2)) {
            this.field_48146_a.func_48407_a(!this.func_48141_af());
         }

         return super.func_353_a(p_353_1_);
      }
   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      EntityOcelot var2 = new EntityOcelot(this.field_615_ag);
      if(this.func_48139_F_()) {
         var2.func_48143_a(this.func_48145_ag());
         var2.func_48138_b(true);
         var2.func_48147_c(this.func_48148_ad());
      }

      return var2;
   }

   public boolean func_40143_a(ItemStack p_40143_1_) {
      return p_40143_1_ != null && p_40143_1_.field_1617_c == Item.field_4021_aS.field_291_aS;
   }

   public boolean func_48135_b(EntityAnimal p_48135_1_) {
      if(p_48135_1_ == this) {
         return false;
      } else if(!this.func_48139_F_()) {
         return false;
      } else if(!(p_48135_1_ instanceof EntityOcelot)) {
         return false;
      } else {
         EntityOcelot var2 = (EntityOcelot)p_48135_1_;
         return !var2.func_48139_F_()?false:this.func_48136_o_() && var2.func_48136_o_();
      }
   }

   public int func_48148_ad() {
      return this.field_21064_bx.func_21130_a(18);
   }

   public void func_48147_c(int p_48147_1_) {
      this.field_21064_bx.func_21129_b(18, Byte.valueOf((byte)p_48147_1_));
   }

   public boolean func_433_a() {
      if(this.field_615_ag.field_1037_n.nextInt(3) == 0) {
         return false;
      } else {
         if(this.field_615_ag.func_604_a(this.field_601_au) && this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au)) {
            int var1 = MathHelper.func_1108_b(this.field_611_ak);
            int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
            int var3 = MathHelper.func_1108_b(this.field_609_am);
            if(var2 < 63) {
               return false;
            }

            int var4 = this.field_615_ag.func_600_a(var1, var2 - 1, var3);
            if(var4 == Block.field_337_v.field_376_bc || var4 == Block.field_384_L.field_376_bc) {
               return true;
            }
         }

         return false;
      }
   }
}
