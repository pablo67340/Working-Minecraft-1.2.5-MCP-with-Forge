package net.minecraft.src;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public class EntitySpider extends EntityMob {

   public EntitySpider(World p_i258_1_) {
      super(p_i258_1_);
      this.field_9357_z = "/mob/spider.png";
      this.func_371_a(1.4F, 0.9F);
      this.field_9333_am = 0.8F;
   }

   protected void func_21057_b() {
      super.func_21057_b();
      this.field_21064_bx.func_21124_a(16, new Byte((byte)0));
   }

   public void func_425_j() {
      super.func_425_j();
   }

   public void func_370_e_() {
      super.func_370_e_();
      if(!this.field_615_ag.field_1026_y) {
         this.func_40148_a(this.field_9297_aI);
      }

   }

   public int func_40117_c() {
      return 16;
   }

   public double func_402_h() {
      return (double)this.field_643_aD * 0.75D - 0.5D;
   }

   protected boolean func_25021_m() {
      return false;
   }

   protected Entity func_438_i() {
      float var1 = this.func_382_a(1.0F);
      if(var1 < 0.5F) {
         double var2 = 16.0D;
         return this.field_615_ag.func_40480_b(this, var2);
      } else {
         return null;
      }
   }

   protected String func_6389_d() {
      return "mob.spider";
   }

   protected String func_6394_f_() {
      return "mob.spider";
   }

   protected String func_6390_f() {
      return "mob.spiderdeath";
   }

   protected void func_437_a(Entity p_437_1_, float p_437_2_) {
      float var3 = this.func_382_a(1.0F);
      if(var3 > 0.5F && this.field_9312_bd.nextInt(100) == 0) {
         this.field_751_f = null;
      } else {
         if(p_437_2_ > 2.0F && p_437_2_ < 6.0F && this.field_9312_bd.nextInt(10) == 0) {
            if(this.field_9298_aH) {
               double var4 = p_437_1_.field_611_ak - this.field_611_ak;
               double var6 = p_437_1_.field_609_am - this.field_609_am;
               float var8 = MathHelper.func_1109_a(var4 * var4 + var6 * var6);
               this.field_608_an = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.field_608_an * 0.20000000298023224D;
               this.field_606_ap = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.field_606_ap * 0.20000000298023224D;
               this.field_607_ao = 0.4000000059604645D;
            }
         } else {
            super.func_437_a(p_437_1_, p_437_2_);
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
      return Item.field_253_I.field_291_aS;
   }

   protected void func_21066_o(boolean p_21066_1_, int p_21066_2_) {
      super.func_21066_o(p_21066_1_, p_21066_2_);
      if(p_21066_1_ && (this.field_9312_bd.nextInt(3) == 0 || this.field_9312_bd.nextInt(1 + p_21066_2_) > 0)) {
         this.func_367_b(Item.field_40415_bu.field_291_aS, 1);
      }

   }

   public boolean func_429_A() {
      return this.func_40149_l_();
   }

   public void func_35112_o() {}

   public float func_35188_k_() {
      return 1.0F;
   }

   public EnumCreatureAttribute func_40124_t() {
      return EnumCreatureAttribute.ARTHROPOD;
   }

   public boolean func_40126_a(PotionEffect p_40126_1_) {
      return p_40126_1_.func_35799_a() == Potion.field_35689_u.field_35670_H?false:super.func_40126_a(p_40126_1_);
   }

   public boolean func_40149_l_() {
      return (this.field_21064_bx.func_21130_a(16) & 1) != 0;
   }

   public void func_40148_a(boolean p_40148_1_) {
      byte var2 = this.field_21064_bx.func_21130_a(16);
      if(p_40148_1_) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.field_21064_bx.func_21129_b(16, Byte.valueOf(var2));
   }
}
