package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathEntity;
import net.minecraft.src.World;

public class EntityAIAttackOnCollide extends EntityAIBase {

   World field_46095_a;
   EntityLiving field_48267_b;
   EntityLiving field_46094_c;
   int field_46091_d;
   float field_48266_e;
   boolean field_48264_f;
   PathEntity field_48265_g;
   Class field_48268_h;
   private int field_48269_i;


   public EntityAIAttackOnCollide(EntityLiving p_i1024_1_, Class p_i1024_2_, float p_i1024_3_, boolean p_i1024_4_) {
      this(p_i1024_1_, p_i1024_3_, p_i1024_4_);
      this.field_48268_h = p_i1024_2_;
   }

   public EntityAIAttackOnCollide(EntityLiving p_i1025_1_, float p_i1025_2_, boolean p_i1025_3_) {
      this.field_46091_d = 0;
      this.field_48267_b = p_i1025_1_;
      this.field_46095_a = p_i1025_1_.field_615_ag;
      this.field_48266_e = p_i1025_2_;
      this.field_48264_f = p_i1025_3_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      EntityLiving var1 = this.field_48267_b.func_48094_aS();
      if(var1 == null) {
         return false;
      } else if(this.field_48268_h != null && !this.field_48268_h.isAssignableFrom(var1.getClass())) {
         return false;
      } else {
         this.field_46094_c = var1;
         this.field_48265_g = this.field_48267_b.func_48084_aL().func_48679_a(this.field_46094_c);
         return this.field_48265_g != null;
      }
   }

   public boolean func_46084_g() {
      EntityLiving var1 = this.field_48267_b.func_48094_aS();
      return var1 == null?false:(!this.field_46094_c.func_354_B()?false:(!this.field_48264_f?!this.field_48267_b.func_48084_aL().func_46072_b():this.field_48267_b.func_48096_f(MathHelper.func_1108_b(this.field_46094_c.field_611_ak), MathHelper.func_1108_b(this.field_46094_c.field_610_al), MathHelper.func_1108_b(this.field_46094_c.field_609_am))));
   }

   public void func_46080_e() {
      this.field_48267_b.func_48084_aL().func_48678_a(this.field_48265_g, this.field_48266_e);
      this.field_48269_i = 0;
   }

   public void func_46077_d() {
      this.field_46094_c = null;
      this.field_48267_b.func_48084_aL().func_48672_f();
   }

   public void func_46081_b() {
      this.field_48267_b.func_46008_aG().func_46141_a(this.field_46094_c, 30.0F, 30.0F);
      if((this.field_48264_f || this.field_48267_b.func_48090_aM().func_48480_a(this.field_46094_c)) && --this.field_48269_i <= 0) {
         this.field_48269_i = 4 + this.field_48267_b.func_46004_aK().nextInt(7);
         this.field_48267_b.func_48084_aL().func_48667_a(this.field_46094_c, this.field_48266_e);
      }

      this.field_46091_d = Math.max(this.field_46091_d - 1, 0);
      double var1 = (double)(this.field_48267_b.field_644_aC * 2.0F * this.field_48267_b.field_644_aC * 2.0F);
      if(this.field_48267_b.func_360_d(this.field_46094_c.field_611_ak, this.field_46094_c.field_601_au.field_1697_b, this.field_46094_c.field_609_am) <= var1) {
         if(this.field_46091_d <= 0) {
            this.field_46091_d = 20;
            this.field_48267_b.func_35175_b(this.field_46094_c);
         }
      }
   }
}
