package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.EntityAIFollowParent;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityLightningBolt;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPig extends EntityAnimal {

   public EntityPig(World p_i557_1_) {
      super(p_i557_1_);
      this.field_9357_z = "/mob/pig.png";
      this.func_371_a(0.9F, 0.9F);
      this.func_48084_aL().func_48664_a(true);
      float var2 = 0.25F;
      this.field_46019_bU.func_46118_a(0, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(1, new EntityAIPanic(this, 0.38F));
      this.field_46019_bU.func_46118_a(2, new EntityAIMate(this, var2));
      this.field_46019_bU.func_46118_a(3, new EntityAITempt(this, 0.25F, Item.field_243_R.field_291_aS, false));
      this.field_46019_bU.func_46118_a(4, new EntityAIFollowParent(this, 0.28F));
      this.field_46019_bU.func_46118_a(5, new EntityAIWander(this, var2));
      this.field_46019_bU.func_46118_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_46019_bU.func_46118_a(7, new EntityAILookIdle(this));
   }

   public boolean func_46006_aR() {
      return true;
   }

   public int func_40117_c() {
      return 10;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, Byte.valueOf((byte)0));
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_748_a("Saddle", this.func_21068_q());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_21069_a(p_357_1_.func_760_m("Saddle"));
   }

   protected String func_6389_d() {
      return "mob.pig";
   }

   protected String func_6394_f_() {
      return "mob.pig";
   }

   protected String func_6390_f() {
      return "mob.pigdeath";
   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      if(super.func_353_a(p_353_1_)) {
         return true;
      } else if(this.func_21068_q() && !this.field_615_ag.field_1026_y && (this.field_617_ae == null || this.field_617_ae == p_353_1_)) {
         p_353_1_.func_6377_h(this);
         return true;
      } else {
         return false;
      }
   }

   protected int func_422_g() {
      return this.func_21062_U()?Item.field_4017_ap.field_291_aS:Item.field_272_ao.field_291_aS;
   }

   public boolean func_21068_q() {
      return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
   }

   public void func_21069_a(boolean p_21069_1_) {
      if(p_21069_1_) {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)1));
      } else {
         this.field_21064_bx.func_21129_b(16, Byte.valueOf((byte)0));
      }

   }

   public void func_27014_a(EntityLightningBolt p_27014_1_) {
      if(!this.field_615_ag.field_1026_y) {
         EntityPigZombie var2 = new EntityPigZombie(this.field_615_ag);
         var2.func_365_c(this.field_611_ak, this.field_610_al, this.field_609_am, this.field_605_aq, this.field_604_ar);
         this.field_615_ag.func_674_a(var2);
         this.func_395_F();
      }
   }

   protected void func_400_c(float p_400_1_) {
      super.func_400_c(p_400_1_);
      if(p_400_1_ > 5.0F && this.field_617_ae instanceof EntityPlayer) {
         ((EntityPlayer)this.field_617_ae).func_27026_a(AchievementList.field_27375_u);
      }

   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      return new EntityPig(this.field_615_ag);
   }
}
