package net.minecraft.src;

import java.util.List;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.World;

public class EntityPigZombie extends EntityZombie {

   private int field_4117_a = 0;
   private int field_4116_b = 0;
   private static final ItemStack field_4118_c = new ItemStack(Item.field_261_E, 1);


   public EntityPigZombie(World p_i208_1_) {
      super(p_i208_1_);
      this.field_9357_z = "/mob/pigzombie.png";
      this.field_9333_am = 0.5F;
      this.field_762_e = 5;
      this.field_9304_bm = true;
   }

   protected boolean func_46006_aR() {
      return false;
   }

   public void func_370_e_() {
      this.field_9333_am = this.field_751_f != null?0.95F:0.5F;
      if(this.field_4116_b > 0 && --this.field_4116_b == 0) {
         this.field_615_ag.func_623_a(this, "mob.zombiepig.zpigangry", this.func_6393_h() * 2.0F, ((this.field_9312_bd.nextFloat() - this.field_9312_bd.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      super.func_370_e_();
   }

   public boolean func_433_a() {
      return this.field_615_ag.field_1039_l > 0 && this.field_615_ag.func_604_a(this.field_601_au) && this.field_615_ag.func_697_a(this, this.field_601_au).size() == 0 && !this.field_615_ag.func_662_b(this.field_601_au);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
      p_352_1_.func_749_a("Anger", (short)this.field_4117_a);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
      this.field_4117_a = p_357_1_.func_745_d("Anger");
   }

   protected Entity func_438_i() {
      return this.field_4117_a == 0?null:super.func_438_i();
   }

   public void func_425_j() {
      super.func_425_j();
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      Entity var3 = p_396_1_.func_35532_a();
      if(var3 instanceof EntityPlayer) {
         List var4 = this.field_615_ag.func_659_b(this, this.field_601_au.func_1177_b(32.0D, 32.0D, 32.0D));

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            Entity var6 = (Entity)var4.get(var5);
            if(var6 instanceof EntityPigZombie) {
               EntityPigZombie var7 = (EntityPigZombie)var6;
               var7.func_4049_h(var3);
            }
         }

         this.func_4049_h(var3);
      }

      return super.func_396_a(p_396_1_, p_396_2_);
   }

   private void func_4049_h(Entity p_4049_1_) {
      this.field_751_f = p_4049_1_;
      this.field_4117_a = 400 + this.field_9312_bd.nextInt(400);
      this.field_4116_b = this.field_9312_bd.nextInt(40);
   }

   protected String func_6389_d() {
      return "mob.zombiepig.zpig";
   }

   protected String func_6394_f_() {
      return "mob.zombiepig.zpighurt";
   }

   protected String func_6390_f() {
      return "mob.zombiepig.zpigdeath";
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.field_9312_bd.nextInt(2 + p_21066_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_35415_bn.field_291_aS, 1);
      }

      var3 = this.field_9312_bd.nextInt(2 + p_21066_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_40419_bq.field_291_aS, 1);
      }

   }

   protected void func_48085_j_(int p_48085_1_) {
      if(p_48085_1_ > 0) {
         ItemStack var2 = new ItemStack(Item.field_261_E);
         EnchantmentHelper.func_48441_a(this.field_9312_bd, var2, 5);
         this.func_21058_a(var2, 0.0F);
      } else {
         int var3 = this.field_9312_bd.nextInt(3);
         if(var3 == 0) {
            this.func_367_b(Item.field_222_n.field_291_aS, 1);
         } else if(var3 == 1) {
            this.func_367_b(Item.field_261_E.field_291_aS, 1);
         } else if(var3 == 2) {
            this.func_367_b(Item.field_277_aj.field_291_aS, 1);
         }
      }

   }

   protected int func_422_g() {
      return Item.field_35415_bn.field_291_aS;
   }

   public ItemStack func_4045_l() {
      return field_4118_c;
   }

}
