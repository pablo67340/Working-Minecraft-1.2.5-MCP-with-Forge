package net.minecraft.src;

import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EntityAIAvoidEntity;
import net.minecraft.src.EntityAIFollowGolem;
import net.minecraft.src.EntityAIMoveIndoors;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAIOpenDoor;
import net.minecraft.src.EntityAIPlay;
import net.minecraft.src.EntityAIRestrictOpenDoor;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIVillagerMate;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAIWatchClosest2;
import net.minecraft.src.EntityAgeable;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Village;
import net.minecraft.src.World;

public class EntityVillager extends EntityAgeable {

   private int field_48131_b;
   private boolean field_48132_c;
   private boolean field_48130_d;
   Village field_48133_a;


   public EntityVillager(World p_i295_1_) {
      this(p_i295_1_, 0);
   }

   public EntityVillager(World p_i296_1_, int p_i296_2_) {
      super(p_i296_1_);
      this.field_48131_b = 0;
      this.field_48132_c = false;
      this.field_48130_d = false;
      this.field_48133_a = null;
      this.func_48124_d_(p_i296_2_);
      this.field_9357_z = "/mob/villager/villager.png";
      this.field_9333_am = 0.5F;
      this.func_48084_aL().func_48673_b(true);
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(0, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.3F, 0.35F));
      this.field_46019_bU.func_46118_a(2, new EntityAIMoveIndoors(this));
      this.field_46019_bU.func_46118_a(3, new EntityAIRestrictOpenDoor(this));
      this.field_46019_bU.func_46118_a(4, new EntityAIOpenDoor(this, true));
      this.field_46019_bU.func_46118_a(5, new EntityAIMoveTwardsRestriction(this, 0.3F));
      this.field_46019_bU.func_46118_a(6, new EntityAIVillagerMate(this));
      this.field_46019_bU.func_46118_a(7, new EntityAIFollowGolem(this));
      this.field_46019_bU.func_46118_a(8, new EntityAIPlay(this, 0.32F));
      this.field_46019_bU.func_46118_a(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.field_46019_bU.func_46118_a(9, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
      this.field_46019_bU.func_46118_a(9, new EntityAIWander(this, 0.3F));
      this.field_46019_bU.func_46118_a(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
   }

   public boolean func_46006_aR() {
      return true;
   }

   protected void func_48097_s_() {
      if(--this.field_48131_b <= 0) {
         this.field_615_ag.field_48465_A.func_48565_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am));
         this.field_48131_b = 70 + this.field_9312_bd.nextInt(50);
         this.field_48133_a = this.field_615_ag.field_48465_A.func_48564_a(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am), 32);
         if(this.field_48133_a == null) {
            this.func_48083_aW();
         } else {
            ChunkCoordinates var1 = this.field_48133_a.func_48539_a();
            this.func_48082_b(var1.field_22395_a, var1.field_22394_b, var1.field_22396_c, this.field_48133_a.func_48531_b());
         }
      }

      super.func_48097_s_();
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, Integer.valueOf(0));
   }

   public int func_40117_c() {
      return 20;
   }

   public void func_425_j() {
      super.func_425_j();
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_758_a("Profession", this.func_48129_t());
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.func_48124_d_(p_357_1_.func_756_e("Profession"));
   }

   public String func_6376_z() {
      switch(this.func_48129_t()) {
      case 0:
         return "/mob/villager/farmer.png";
      case 1:
         return "/mob/villager/librarian.png";
      case 2:
         return "/mob/villager/priest.png";
      case 3:
         return "/mob/villager/smith.png";
      case 4:
         return "/mob/villager/butcher.png";
      default:
         return super.func_6376_z();
      }
   }

   protected boolean func_25023_u() {
      return false;
   }

   protected String func_6389_d() {
      return "mob.villager.default";
   }

   protected String func_6394_f_() {
      return "mob.villager.defaulthurt";
   }

   protected String func_6390_f() {
      return "mob.villager.defaultdeath";
   }

   public void func_48124_d_(int p_48124_1_) {
      this.field_21064_bx.func_21129_b(16, Integer.valueOf(p_48124_1_));
   }

   public int func_48129_t() {
      return this.field_21064_bx.func_25115_b(16);
   }

   public boolean func_48126_w_() {
      return this.field_48132_c;
   }

   public void func_48128_a(boolean p_48128_1_) {
      this.field_48132_c = p_48128_1_;
   }

   public void func_48127_b(boolean p_48127_1_) {
      this.field_48130_d = p_48127_1_;
   }

   public boolean func_48125_w() {
      return this.field_48130_d;
   }

   public void func_48086_a(EntityLiving p_48086_1_) {
      super.func_48086_a(p_48086_1_);
      if(this.field_48133_a != null && p_48086_1_ != null) {
         this.field_48133_a.func_48534_a(p_48086_1_);
      }

   }
}
