package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.PathPoint;

public abstract class EntityAITarget extends EntityAIBase {

   protected EntityLiving field_48382_c;
   protected float field_48379_d;
   protected boolean field_48380_e;
   private boolean field_48383_a;
   private int field_48381_b;
   private int field_48377_f;
   private int field_48378_g;


   public EntityAITarget(EntityLiving p_i1061_1_, float p_i1061_2_, boolean p_i1061_3_) {
      this(p_i1061_1_, p_i1061_2_, p_i1061_3_, false);
   }

   public EntityAITarget(EntityLiving p_i1062_1_, float p_i1062_2_, boolean p_i1062_3_, boolean p_i1062_4_) {
      this.field_48381_b = 0;
      this.field_48377_f = 0;
      this.field_48378_g = 0;
      this.field_48382_c = p_i1062_1_;
      this.field_48379_d = p_i1062_2_;
      this.field_48380_e = p_i1062_3_;
      this.field_48383_a = p_i1062_4_;
   }

   public boolean func_46084_g() {
      EntityLiving var1 = this.field_48382_c.func_48094_aS();
      if(var1 == null) {
         return false;
      } else if(!var1.func_354_B()) {
         return false;
      } else if(this.field_48382_c.func_387_e(var1) > (double)(this.field_48379_d * this.field_48379_d)) {
         return false;
      } else {
         if(this.field_48380_e) {
            if(!this.field_48382_c.func_48090_aM().func_48480_a(var1)) {
               if(++this.field_48378_g > 60) {
                  return false;
               }
            } else {
               this.field_48378_g = 0;
            }
         }

         return true;
      }
   }

   public void func_46080_e() {
      this.field_48381_b = 0;
      this.field_48377_f = 0;
      this.field_48378_g = 0;
   }

   public void func_46077_d() {
      this.field_48382_c.func_48092_c((EntityLiving)null);
   }

   protected boolean func_48376_a(EntityLiving p_48376_1_, boolean p_48376_2_) {
      if(p_48376_1_ == null) {
         return false;
      } else if(p_48376_1_ == this.field_48382_c) {
         return false;
      } else if(!p_48376_1_.func_354_B()) {
         return false;
      } else if(p_48376_1_.field_601_au.field_1702_e > this.field_48382_c.field_601_au.field_1697_b && p_48376_1_.field_601_au.field_1697_b < this.field_48382_c.field_601_au.field_1702_e) {
         if(!this.field_48382_c.func_48100_a(p_48376_1_.getClass())) {
            return false;
         } else {
            if(this.field_48382_c instanceof EntityTameable && ((EntityTameable)this.field_48382_c).func_48139_F_()) {
               if(p_48376_1_ instanceof EntityTameable && ((EntityTameable)p_48376_1_).func_48139_F_()) {
                  return false;
               }

               if(p_48376_1_ == ((EntityTameable)this.field_48382_c).func_48144_ah()) {
                  return false;
               }
            } else if(p_48376_1_ instanceof EntityPlayer && !p_48376_2_ && ((EntityPlayer)p_48376_1_).field_35212_aW.field_35759_a) {
               return false;
            }

            if(!this.field_48382_c.func_48096_f(MathHelper.func_1108_b(p_48376_1_.field_611_ak), MathHelper.func_1108_b(p_48376_1_.field_610_al), MathHelper.func_1108_b(p_48376_1_.field_609_am))) {
               return false;
            } else if(this.field_48380_e && !this.field_48382_c.func_48090_aM().func_48480_a(p_48376_1_)) {
               return false;
            } else {
               if(this.field_48383_a) {
                  if(--this.field_48377_f <= 0) {
                     this.field_48381_b = 0;
                  }

                  if(this.field_48381_b == 0) {
                     this.field_48381_b = this.func_48375_a(p_48376_1_)?1:2;
                  }

                  if(this.field_48381_b == 2) {
                     return false;
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   private boolean func_48375_a(EntityLiving p_48375_1_) {
      this.field_48377_f = 10 + this.field_48382_c.func_46004_aK().nextInt(5);
      PathEntity var2 = this.field_48382_c.func_48084_aL().func_48679_a(p_48375_1_);
      if(var2 == null) {
         return false;
      } else {
         PathPoint var3 = var2.func_48645_c();
         if(var3 == null) {
            return false;
         } else {
            int var4 = var3.field_1718_a - MathHelper.func_1108_b(p_48375_1_.field_611_ak);
            int var5 = var3.field_1716_c - MathHelper.func_1108_b(p_48375_1_.field_609_am);
            return (double)(var4 * var4 + var5 * var5) <= 2.25D;
         }
      }
   }
}
