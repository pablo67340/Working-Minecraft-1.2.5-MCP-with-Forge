package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityAIArrowAttack;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityGolem;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntitySnowman extends EntityGolem {

   public EntitySnowman(World p_i561_1_) {
      super(p_i561_1_);
      this.field_9357_z = "/mob/snowman.png";
      this.func_371_a(0.4F, 1.8F);
      this.func_48084_aL().func_48664_a(true);
      this.field_46019_bU.func_46118_a(1, new EntityAIArrowAttack(this, 0.25F, 2, 20));
      this.field_46019_bU.func_46118_a(2, new EntityAIWander(this, 0.2F));
      this.field_46019_bU.func_46118_a(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.field_46019_bU.func_46118_a(4, new EntityAILookIdle(this));
      this.field_48105_bU.func_46118_a(1, new EntityAINearestAttackableTarget(this, EntityMob.class, 16.0F, 0, true));
   }

   public boolean func_46006_aR() {
      return true;
   }

   public int func_40117_c() {
      return 4;
   }

   public void func_425_j() {
      super.func_425_j();
      if(this.func_27012_af()) {
         this.func_396_a(DamageSource.field_35539_e, 1);
      }

      int var1 = MathHelper.func_1108_b(this.field_611_ak);
      int var2 = MathHelper.func_1108_b(this.field_609_am);
      if(this.field_615_ag.func_48454_a(var1, var2).func_48411_i() > 1.0F) {
         this.func_396_a(DamageSource.field_35540_b, 1);
      }

      for(var1 = 0; var1 < 4; ++var1) {
         var2 = MathHelper.func_1108_b(this.field_611_ak + (double)((float)(var1 % 2 * 2 - 1) * 0.25F));
         int var3 = MathHelper.func_1108_b(this.field_610_al);
         int var4 = MathHelper.func_1108_b(this.field_609_am + (double)((float)(var1 / 2 % 2 * 2 - 1) * 0.25F));
         if(this.field_615_ag.func_600_a(var2, var3, var4) == 0 && this.field_615_ag.func_48454_a(var2, var4).func_48411_i() < 0.8F && Block.field_428_aT.func_243_a(this.field_615_ag, var2, var3, var4)) {
            this.field_615_ag.func_690_d(var2, var3, var4, Block.field_428_aT.field_376_bc);
         }
      }

   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected int func_422_g() {
      return Item.field_308_aB.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.field_9312_bd.nextInt(16);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_308_aB.field_291_aS, 1);
      }

   }
}
