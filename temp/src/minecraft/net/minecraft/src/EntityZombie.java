package net.minecraft.src;

import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIBreakDoor;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMoveThroughVillage;
import net.minecraft.src.EntityAIMoveTwardsRestriction;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityZombie extends EntityMob {

   public EntityZombie(World p_i156_1_) {
      super(p_i156_1_);
      this.field_9357_z = "/mob/zombie.png";
      this.field_9333_am = 0.23F;
      this.field_762_e = 4;
      this.func_48084_aL().func_48673_b(true);
      this.field_46019_bU.func_46118_a(0, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(1, new EntityAIBreakDoor(this));
      this.field_46019_bU.func_46118_a(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.field_9333_am, false));
      this.field_46019_bU.func_46118_a(3, new EntityAIAttackOnCollide(this, EntityVillager.class, this.field_9333_am, true));
      this.field_46019_bU.func_46118_a(4, new EntityAIMoveTwardsRestriction(this, this.field_9333_am));
      this.field_46019_bU.func_46118_a(5, new EntityAIMoveThroughVillage(this, this.field_9333_am, false));
      this.field_46019_bU.func_46118_a(6, new EntityAIWander(this, this.field_9333_am));
      this.field_46019_bU.func_46118_a(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_46019_bU.func_46118_a(7, new EntityAILookIdle(this));
      this.field_48105_bU.func_46118_a(1, new EntityAIHurtByTarget(this, false));
      this.field_48105_bU.func_46118_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
      this.field_48105_bU.func_46118_a(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 16.0F, 0, false));
   }

   public int func_40117_c() {
      return 20;
   }

   public int func_40119_ar() {
      return 2;
   }

   protected boolean func_46006_aR() {
      return true;
   }

   public void func_425_j() {
      if(this.field_615_ag.func_624_b() && !this.field_615_ag.field_1026_y) {
         float var1 = this.func_382_a(1.0F);
         if(var1 > 0.5F && this.field_615_ag.func_647_i(MathHelper.func_1108_b(this.field_611_ak), MathHelper.func_1108_b(this.field_610_al), MathHelper.func_1108_b(this.field_609_am)) && this.field_9312_bd.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
            this.func_40046_d(8);
         }
      }

      super.func_425_j();
   }

   protected String func_6389_d() {
      return "mob.zombie";
   }

   protected String func_6394_f_() {
      return "mob.zombiehurt";
   }

   protected String func_6390_f() {
      return "mob.zombiedeath";
   }

   protected int func_422_g() {
      return Item.field_35415_bn.field_291_aS;
   }

   public EnumCreatureAttribute func_40124_t() {
      return EnumCreatureAttribute.UNDEAD;
   }

   protected void func_48085_j_(int p_48085_1_) {
      switch(this.field_9312_bd.nextInt(4)) {
      case 0:
         this.func_367_b(Item.field_221_o.field_291_aS, 1);
         break;
      case 1:
         this.func_367_b(Item.field_285_ab.field_291_aS, 1);
         break;
      case 2:
         this.func_367_b(Item.field_223_m.field_291_aS, 1);
         break;
      case 3:
         this.func_367_b(Item.field_232_d.field_291_aS, 1);
      }

   }
}
