package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIDefendVillage;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookAtVillager;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMoveThroughVillage;
import net.minecraft.src.EntityAIMoveTowardsTarget;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityGolem;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Village;
import net.minecraft.src.World;

public class EntityIronGolem extends EntityGolem {

   private int field_48119_b = 0;
   Village field_48121_a = null;
   private int field_48120_c;
   private int field_48118_d;


   public EntityIronGolem(World p_i1069_1_) {
      super(p_i1069_1_);
      this.field_9357_z = "/mob/villager_golem.png";
      this.func_371_a(1.4F, 2.9F);
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(1, new EntityAIAttackOnCollide(this, 0.25F, true));
      this.field_46019_bU.func_46118_a(2, new EntityAIMoveTowardsTarget(this, 0.22F, 32.0F));
      this.field_46019_bU.func_46118_a(3, new EntityAIMoveThroughVillage(this, 0.16F, true));
      this.field_46019_bU.func_46118_a(4, new EntityAIMoveTwardsRestriction(this, 0.16F));
      this.field_46019_bU.func_46118_a(5, new EntityAILookAtVillager(this));
      this.field_46019_bU.func_46118_a(6, new EntityAIWander(this, 0.16F));
      this.field_46019_bU.func_46118_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_46019_bU.func_46118_a(8, new EntityAILookIdle(this));
      this.field_48105_bU.func_46118_a(1, new EntityAIDefendVillage(this));
      this.field_48105_bU.func_46118_a(2, new EntityAIHurtByTarget(this, false));
      this.field_48105_bU.func_46118_a(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 16.0F, 0, false, true));
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
   }

   public boolean func_46006_aR() {
      return true;
   }

   protected void func_48097_s_() {
      if(--this.field_48119_b <= 0) {
         this.field_48119_b = 70 + this.field_9312_bd.nextInt(50);
         this.field_48121_a = this.field_615_ag.field_48465_A.func_48564_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am), 32);
         if(this.field_48121_a == null) {
            this.func_48083_aW();
         } else {
            ChunkCoordinates var1 = this.field_48121_a.func_48539_a();
            this.func_48082_b(var1.field_22395_a, var1.field_22394_b, var1.field_22396_c, this.field_48121_a.func_48531_b());
         }
      }

      super.func_48097_s_();
   }

   public int func_40117_c() {
      return 100;
   }

   protected int func_40116_f(int p_40116_1_) {
      return p_40116_1_;
   }

   public void func_425_j() {
      super.func_425_j();
      if(this.field_48120_c > 0) {
         --this.field_48120_c;
      }

      if(this.field_48118_d > 0) {
         --this.field_48118_d;
      }

      if(this.field_608_an * this.field_608_an + this.field_606_ap * this.field_606_ap > 2.500000277905201E-7D && this.field_9312_bd.nextInt(5) == 0) {
         int var1 = MathHelper.func_1108_b(this.field_611_ak);
         int var2 = MathHelper.func_1108_b(this.field_610_al - 0.20000000298023224D - (double)this.field_9292_aO);
         int var3 = MathHelper.func_1108_b(this.field_609_am);
         int var4 = this.field_615_ag.func_600_a(var1, var2, var3);
         if(var4 > 0) {
            this.field_615_ag.func_694_a("tilecrack_" + var4, this.field_611_ak + ((double)this.field_9312_bd.nextFloat() - 0.5D) * (double)this.field_644_aC, this.field_601_au.field_1697_b + 0.1D, this.field_609_am + ((double)this.field_9312_bd.nextFloat() - 0.5D) * (double)this.field_644_aC, 4.0D * ((double)this.field_9312_bd.nextFloat() - 0.5D), 0.5D, ((double)this.field_9312_bd.nextFloat() - 0.5D) * 4.0D);
         }
      }

   }

   public boolean func_48100_a(Class p_48100_1_) {
      return this.func_48112_E_() && EntityPlayer.class.isAssignableFrom(p_48100_1_)?false:super.func_48100_a(p_48100_1_);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_748_a("PlayerCreated", this.func_48112_E_());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_48115_b(p_357_1_.func_760_m("PlayerCreated"));
   }

   public boolean func_35175_b(Entity p_35175_1_) {
      this.field_48120_c = 10;
      this.field_615_ag.func_9425_a(this, (byte)4);
      boolean var2 = p_35175_1_.func_396_a(DamageSource.func_35525_a(this), 7 + this.field_9312_bd.nextInt(15));
      if(var2) {
         p_35175_1_.field_607_ao += 0.4000000059604645D;
      }

      this.field_615_ag.func_623_a(this, "mob.irongolem.throw", 1.0F, 1.0F);
      return var2;
   }

   public void func_9282_a(byte p_9282_1_) {
      if(p_9282_1_ == 4) {
         this.field_48120_c = 10;
         this.field_615_ag.func_623_a(this, "mob.irongolem.throw", 1.0F, 1.0F);
      } else if(p_9282_1_ == 11) {
         this.field_48118_d = 400;
      } else {
         super.func_9282_a(p_9282_1_);
      }

   }

   public Village func_48113_aa() {
      return this.field_48121_a;
   }

   public int func_48114_ab() {
      return this.field_48120_c;
   }

   public void func_48116_a(boolean p_48116_1_) {
      this.field_48118_d = p_48116_1_?400:0;
      this.field_615_ag.func_9425_a(this, (byte)11);
   }

   protected String func_6389_d() {
      return "none";
   }

   protected String func_6394_f_() {
      return "mob.irongolem.hit";
   }

   protected String func_6390_f() {
      return "mob.irongolem.death";
   }

   protected void func_41002_a(int p_41002_1_, int p_41002_2_, int p_41002_3_, int p_41002_4_) {
      this.field_615_ag.func_623_a(this, "mob.irongolem.walk", 1.0F, 1.0F);
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.field_9312_bd.nextInt(3);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Block.field_416_af.field_376_bc, 1);
      }

      var4 = 3 + this.field_9312_bd.nextInt(3);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.func_367_b(Item.field_223_m.field_291_aS, 1);
      }

   }

   public int func_48117_D_() {
      return this.field_48118_d;
   }

   public boolean func_48112_E_() {
      return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
   }

   public void func_48115_b(boolean p_48115_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_48115_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)(var2 & -2)));
      }

   }
}
