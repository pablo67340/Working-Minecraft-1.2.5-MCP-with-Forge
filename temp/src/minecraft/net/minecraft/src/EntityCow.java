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
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityCow extends EntityAnimal {

   public EntityCow(World p_i630_1_) {
      super(p_i630_1_);
      this.field_9357_z = "/mob/cow.png";
      this.func_371_a(0.9F, 1.3F);
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(0, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(1, new EntityAIPanic(this, 0.38F));
      this.field_46019_bU.func_46118_a(2, new EntityAIMate(this, 0.2F));
      this.field_46019_bU.func_46118_a(3, new EntityAITempt(this, 0.25F, Item.field_243_R.field_291_aS, false));
      this.field_46019_bU.func_46118_a(4, new EntityAIFollowParent(this, 0.25F));
      this.field_46019_bU.func_46118_a(5, new EntityAIWander(this, 0.2F));
      this.field_46019_bU.func_46118_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_46019_bU.func_46118_a(7, new EntityAILookIdle(this));
   }

   public boolean func_46006_aR() {
      return true;
   }

   public int func_40117_c() {
      return 10;
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected String func_6389_d() {
      return "mob.cow";
   }

   protected String func_6394_f_() {
      return "mob.cowhurt";
   }

   protected String func_6390_f() {
      return "mob.cowhurt";
   }

   protected float func_6393_h() {
      return 0.4F;
   }

   protected int func_422_g() {
      return Item.field_306_aD.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.field_9312_bd.nextInt(3) + this.field_9312_bd.nextInt(1 + p_21066_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_306_aD.field_291_aS, 1);
      }

      var3 = this.field_9312_bd.nextInt(3) + 1 + this.field_9312_bd.nextInt(1 + p_21066_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         if(this.func_21062_U()) {
            this.func_367_b(Item.field_35418_bk.field_291_aS, 1);
         } else {
            this.func_367_b(Item.field_35417_bj.field_291_aS, 1);
         }
      }

   }

   public boolean func_353_a(EntityPlayer p_353_1_) {
      ItemStack var2 = p_353_1_.field_778_b.func_494_a();
      if(var2 != null && var2.field_1617_c == Item.field_262_au.field_291_aS) {
         p_353_1_.field_778_b.func_472_a(p_353_1_.field_778_b.field_847_d, new ItemStack(Item.field_305_aE));
         return true;
      } else {
         return super.func_353_a(p_353_1_);
      }
   }

   public EntityAnimal func_40145_a(EntityAnimal p_40145_1_) {
      return new EntityCow(this.field_615_ag);
   }
}
