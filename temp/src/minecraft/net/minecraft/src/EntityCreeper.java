package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIAvoidEntity;
import net.minecraft.src.EntityAICreeperSwell;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityCreeper extends EntityMob {

   int field_764_a;
   int field_763_b;


   public EntityCreeper(World p_i693_1_) {
      super(p_i693_1_);
      this.field_9357_z = "/mob/creeper.png";
      this.field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(2, new EntityAICreeperSwell(this));
      this.field_46019_bU.func_46118_a(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 0.25F, 0.3F));
      this.field_46019_bU.func_46118_a(4, new EntityAIAttackOnCollide(this, 0.25F, false));
      this.field_46019_bU.func_46118_a(5, new EntityAIWander(this, 0.2F));
      this.field_46019_bU.func_46118_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_46019_bU.func_46118_a(6, new EntityAILookIdle(this));
      this.field_48105_bU.func_46118_a(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
      this.field_48105_bU.func_46118_a(2, new EntityAIHurtByTarget(this, false));
   }

   public boolean func_46006_aR() {
      return true;
   }

   public int func_40117_c() {
      return 20;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, Byte.valueOf((byte)-1));
      this.field_21064_bx.func_21124_a(17, Byte.valueOf((byte)0));
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      if(this.field_21064_bx.func_21130_a(17) == 1) {
         p_352_1_.func_748_a("powered", true);
      }

   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.field_21064_bx.func_21129_b(17, Byte.valueOf((byte)(p_357_1_.func_760_m("powered")?1:0)));
   }

   public void func_370_e_() {
      if(this.func_354_B()) {
         this.field_763_b = this.field_764_a;
         int var1 = this.func_21091_q();
         if(var1 > 0 && this.field_764_a == 0) {
            this.field_615_ag.func_623_a(this, "random.fuse", 1.0F, 0.5F);
         }

         this.field_764_a += var1;
         if(this.field_764_a < 0) {
            this.field_764_a = 0;
         }

         if(this.field_764_a >= 30) {
            this.field_764_a = 30;
            if(!this.field_615_ag.field_1026_y) {
               if(this.func_27022_s()) {
                  this.field_615_ag.func_12243_a(this, this.field_611_ak, this.field_610_al, this.field_609_am, 6.0F);
               } else {
                  this.field_615_ag.func_12243_a(this, this.field_611_ak, this.field_610_al, this.field_609_am, 3.0F);
               }

               this.func_395_F();
            }
         }
      }

      super.func_370_e_();
   }

   protected String func_6394_f_() {
      return "mob.creeper";
   }

   protected String func_6390_f() {
      return "mob.creeperdeath";
   }

   public void func_419_b(DamageSource p_419_1_) {
      super.func_419_b(p_419_1_);
      if(p_419_1_.func_35532_a() instanceof EntitySkeleton) {
         this.func_367_b(Item.field_293_aQ.field_291_aS + this.field_9312_bd.nextInt(10), 1);
      }

   }

   public boolean func_35175_b(Entity p_35175_1_) {
      return true;
   }

   public boolean func_27022_s() {
      return this.field_21064_bx.func_21130_a(17) == 1;
   }

   public float func_440_b(float p_440_1_) {
      return ((float)this.field_763_b + (float)(this.field_764_a - this.field_763_b) * p_440_1_) / 28.0F;
   }

   protected int func_422_g() {
      return Item.field_250_K.field_291_aS;
   }

   public int func_21091_q() {
      return this.field_21064_bx.func_21130_a(16);
   }

   public void func_21090_e(int p_21090_1_) {
      this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)p_21090_1_));
   }

   public void func_27014_a(EntityLightningBolt p_27014_1_) {
      super.func_27014_a(p_27014_1_);
      this.field_21064_bx.func_21129_b(17, Byte.valueOf((byte)1));
   }
}
