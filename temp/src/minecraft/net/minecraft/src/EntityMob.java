package net.minecraft.src;

import net.minecraft.src.DamageSource;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumSkyBlock;
import net.minecraft.src.IMob;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Potion;
import net.minecraft.src.World;

public abstract class EntityMob extends EntityCreature implements IMob {

   protected int field_762_e = 2;


   public EntityMob(World p_i712_1_) {
      super(p_i712_1_);
      this.field_35171_bJ = 5;
   }

   public void func_425_j() {
      float var1 = this.func_382_a(1.0F);
      if(var1 > 0.5F) {
         this.field_9344_ag += 2;
      }

      super.func_425_j();
   }

   public void func_370_e_() {
      super.func_370_e_();
      if(!this.field_615_ag.field_1026_y && this.field_615_ag.field_1039_l == 0) {
         this.func_395_F();
      }

   }

   protected Entity func_438_i() {
      EntityPlayer var1 = this.field_615_ag.func_40480_b(this, 16.0D);
      return var1 != null && this.func_420_c(var1)?var1:null;
   }

   public boolean func_396_a(DamageSource p_396_1_, int p_396_2_) {
      if(super.func_396_a(p_396_1_, p_396_2_)) {
         Entity var3 = p_396_1_.func_35532_a();
         if(this.field_617_ae != var3 && this.field_616_af != var3) {
            if(var3 != this) {
               this.field_751_f = var3;
            }

            return true;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean func_35175_b(Entity p_35175_1_) {
      int var2 = this.field_762_e;
      if(this.func_35160_a(Potion.field_35673_g)) {
         var2 += 3 << this.func_35167_b(Potion.field_35673_g).func_35801_c();
      }

      if(this.func_35160_a(Potion.field_35690_t)) {
         var2 -= 2 << this.func_35167_b(Potion.field_35690_t).func_35801_c();
      }

      return p_35175_1_.func_396_a(DamageSource.func_35525_a(this), var2);
   }

   protected void func_437_a(Entity p_437_1_, float p_437_2_) {
      if(this.field_9330_P <= 0 && p_437_2_ < 2.0F && p_437_1_.field_601_au.field_1702_e > this.field_601_au.field_1697_b && p_437_1_.field_601_au.field_1697_b < this.field_601_au.field_1702_e) {
         this.field_9330_P = 20;
         this.func_35175_b(p_437_1_);
      }

   }

   public float func_439_a(int p_439_1_, int p_439_2_, int p_439_3_) {
      return 0.5F - this.field_615_ag.func_598_c(p_439_1_, p_439_2_, p_439_3_);
   }

   public void func_352_a(NBTTagCompound p_352_1_) {
      super.func_352_a(p_352_1_);
   }

   public void func_357_b(NBTTagCompound p_357_1_) {
      super.func_357_b(p_357_1_);
   }

   protected boolean func_40147_Y() {
      int var1 = MathHelper.func_1108_b(this.field_611_ak);
      int var2 = MathHelper.func_1108_b(this.field_601_au.field_1697_b);
      int var3 = MathHelper.func_1108_b(this.field_609_am);
      if(this.field_615_ag.func_641_a(EnumSkyBlock.Sky, var1, var2, var3) > this.field_9312_bd.nextInt(32)) {
         return false;
      } else {
         int var4 = this.field_615_ag.func_618_j(var1, var2, var3);
         if(this.field_615_ag.func_27160_B()) {
            int var5 = this.field_615_ag.field_1046_e;
            this.field_615_ag.field_1046_e = 10;
            var4 = this.field_615_ag.func_618_j(var1, var2, var3);
            this.field_615_ag.field_1046_e = var5;
         }

         return var4 <= this.field_9312_bd.nextInt(8);
      }
   }

   public boolean func_433_a() {
      return this.func_40147_Y() && super.func_433_a();
   }
}
