package net.minecraft.src;

import net.minecraft.src.AchievementList;
import net.minecraft.src.DamageSource;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityAIArrowAttack;
import net.minecraft.src.EntityAIFleeSun;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIRestrictSun;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntitySkeleton extends EntityMob {

   private static final ItemStack field_4119_a = new ItemStack(Item.field_227_i, 1);


   public EntitySkeleton(World p_i687_1_) {
      super(p_i687_1_);
      this.field_9357_z = "/mob/skeleton.png";
      this.field_9333_am = 0.25F;
      this.field_46019_bU.func_46118_a(1, new EntityAISwimming(this));
      this.field_46019_bU.func_46118_a(2, new EntityAIRestrictSun(this));
      this.field_46019_bU.func_46118_a(3, new EntityAIFleeSun(this, this.field_9333_am));
      this.field_46019_bU.func_46118_a(4, new EntityAIArrowAttack(this, this.field_9333_am, 1, 60));
      this.field_46019_bU.func_46118_a(5, new EntityAIWander(this, this.field_9333_am));
      this.field_46019_bU.func_46118_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_46019_bU.func_46118_a(6, new EntityAILookIdle(this));
      this.field_48105_bU.func_46118_a(1, new EntityAIHurtByTarget(this, false));
      this.field_48105_bU.func_46118_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
   }

   public boolean func_46006_aR() {
      return true;
   }

   public int func_40117_c() {
      return 20;
   }

   protected String func_6389_d() {
      return "mob.skeleton";
   }

   protected String func_6394_f_() {
      return "mob.skeletonhurt";
   }

   protected String func_6390_f() {
      return "mob.skeletonhurt";
   }

   public ItemStack func_4045_l() {
      return field_4119_a;
   }

   public EnumCreatureAttribute func_40124_t() {
      return EnumCreatureAttribute.UNDEAD;
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

   public void func_419_b(DamageSource p_419_1_) {
      super.func_419_b(p_419_1_);
      if(p_419_1_.func_35526_e() instanceof EntityArrow && p_419_1_.func_35532_a() instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)p_419_1_.func_35532_a();
         double var3 = var2.field_611_ak - this.field_611_ak;
         double var5 = var2.field_609_am - this.field_609_am;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.func_27026_a(AchievementList.field_35608_v);
         }
      }

   }

   protected int func_422_g() {
      return Item.field_226_j.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      int var3 = this.field_9312_bd.nextInt(3 + p_21066_2_);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_226_j.field_291_aS, 1);
      }

      var3 = this.field_9312_bd.nextInt(3 + p_21066_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         this.func_367_b(Item.field_21020_aV.field_291_aS, 1);
      }

   }

   protected void func_48085_j_(int p_48085_1_) {
      if(p_48085_1_ > 0) {
         ItemStack var2 = new ItemStack(Item.field_227_i);
         EnchantmentHelper.func_48441_a(this.field_9312_bd, var2, 5);
         this.func_21058_a(var2, 0.0F);
      } else {
         this.func_367_b(Item.field_227_i.field_291_aS, 1);
      }

   }

}
