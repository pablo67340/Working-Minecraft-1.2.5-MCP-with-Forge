package net.minecraft.src;

import net.minecraft.src.EntityAIFollowParent;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAIMate;
import net.minecraft.src.EntityAIPanic;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAITempt;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityAnimal;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityChicken extends EntityAnimal {

   public boolean field_753_a = false;
   public float field_752_b = 0.0F;
   public float field_758_c = 0.0F;
   public float field_757_d;
   public float field_756_e;
   public float field_755_h = 1.0F;
   public int field_754_i;


   public EntityChicken(World p_i566_1_) {
      super(p_i566_1_);
      this.field_9357_z = "/mob/chicken.png";
      this.func_371_a(0.3F, 0.7F);
      this.field_754_i = this.field_9312_bd.nextInt(6000) + 6000;
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
      return 4;
   }

   public void func_425_j() {
      super.func_425_j();
      this.field_756_e = this.field_752_b;
      this.field_757_d = this.field_758_c;
      this.field_758_c = (float)((double)this.field_758_c + (double)(this.field_9298_aH?-1:4) * 0.3D);
      if(this.field_758_c < 0.0F) {
         this.field_758_c = 0.0F;
      }

      if(this.field_758_c > 1.0F) {
         this.field_758_c = 1.0F;
      }

      if(!this.field_9298_aH && this.field_755_h < 1.0F) {
         this.field_755_h = 1.0F;
      }

      this.field_755_h = (float)((double)this.field_755_h * 0.9D);
      if(!this.field_9298_aH && this.field_607_ao < 0.0D) {
         this.field_607_ao *= 0.6D;
      }

      this.field_752_b += this.field_755_h * 2.0F;
      if(!this.func_40127_l() && !this.field_615_ag.field_1026_y && --this.field_754_i <= 0) {
         this.field_615_ag.func_623_a(this, "mob.chickenplop", 1.0F, (this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F);
         this.func_367_b(Item.field_296_aN.field_291_aS, 1);
         this.field_754_i = this.field_9312_bd.nextInt(6000) + 6000;
      }

   }

   protected void func_400_c(float p_400_1_) {}

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected String func_6389_d() {
      return "mob.chicken";
   }

   protected String func_6394_f_() {
      return "mob.chickenhurt";
   }

   protected String func_6390_f() {
      return "mob.chickenhurt";
   }

   protected int func_422_g() {
      return Item.field_251_J.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.field_9312_bd.nextInt(3) + this.field_9312_bd.nextInt(1 + p_21066_2_);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_251_J.field_291_aS, 1);
      }

      if(this.func_21062_U()) {
         this.func_367_b(Item.field_35420_bm.field_291_aS, 1);
      } else {
         this.func_367_b(Item.field_35419_bl.field_291_aS, 1);
      }

   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      return new EntityChicken(this.field_615_ag);
   }
}
