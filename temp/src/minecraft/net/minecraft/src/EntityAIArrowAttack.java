package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityAIArrowAttack extends EntityAIBase {

   World field_48373_a;
   EntityLiving field_48371_b;
   EntityLiving field_48372_c;
   int field_48369_d = 0;
   float field_48370_e;
   int field_48367_f = 0;
   int field_48368_g;
   int field_48374_h;


   public EntityAIArrowAttack(EntityLiving p_i1065_1_, float p_i1065_2_, int p_i1065_3_, int p_i1065_4_) {
      this.field_48371_b = p_i1065_1_;
      this.field_48373_a = p_i1065_1_.field_615_ag;
      this.field_48370_e = p_i1065_2_;
      this.field_48368_g = p_i1065_3_;
      this.field_48374_h = p_i1065_4_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      EntityLiving var1 = this.field_48371_b.func_48094_aS();
      if(var1 == null) {
         return false;
      } else {
         this.field_48372_c = var1;
         return true;
      }
   }

   public boolean func_46084_g() {
      return this.func_46082_a() || !this.field_48371_b.func_48084_aL().func_46072_b();
   }

   public void func_46077_d() {
      this.field_48372_c = null;
   }

   public void func_46081_b() {
      double var1 = 100.0D;
      double var3 = this.field_48371_b.func_360_d(this.field_48372_c.field_611_ak, this.field_48372_c.field_601_au.field_1697_b, this.field_48372_c.field_609_am);
      boolean var5 = this.field_48371_b.func_48090_aM().func_48480_a(this.field_48372_c);
      if(var5) {
         ++this.field_48367_f;
      } else {
         this.field_48367_f = 0;
      }

      if(var3 <= var1 && this.field_48367_f >= 20) {
         this.field_48371_b.func_48084_aL().func_48672_f();
      } else {
         this.field_48371_b.func_48084_aL().func_48667_a(this.field_48372_c, this.field_48370_e);
      }

      this.field_48371_b.func_46008_aG().func_46141_a(this.field_48372_c, 30.0F, 30.0F);
      this.field_48369_d = Math.max(this.field_48369_d - 1, 0);
      if(this.field_48369_d <= 0) {
         if(var3 <= var1 && var5) {
            this.func_48366_h();
            this.field_48369_d = this.field_48374_h;
         }
      }
   }

   private void func_48366_h() {
      if(this.field_48368_g == 1) {
         EntityArrow var1 = new EntityArrow(this.field_48373_a, this.field_48371_b, this.field_48372_c, 1.6F, 12.0F);
         this.field_48373_a.func_623_a(this.field_48371_b, "random.bow", 1.0F, 1.0F / (this.field_48371_b.func_46004_aK().nextFloat() * 0.4F + 0.8F));
         this.field_48373_a.func_674_a(var1);
      } else if(this.field_48368_g == 2) {
         EntitySnowball var9 = new EntitySnowball(this.field_48373_a, this.field_48371_b);
         double var2 = this.field_48372_c.field_611_ak - this.field_48371_b.field_611_ak;
         double var4 = this.field_48372_c.field_610_al + (double)this.field_48372_c.func_373_s() - 1.100000023841858D - var9.field_610_al;
         double var6 = this.field_48372_c.field_609_am - this.field_48371_b.field_609_am;
         float var8 = MathHelper.func_1109_a(var2 * var2 + var6 * var6) * 0.2F;
         var9.func_40076_a(var2, var4 + (double)var8, var6, 1.6F, 12.0F);
         this.field_48373_a.func_623_a(this.field_48371_b, "random.bow", 1.0F, 1.0F / (this.field_48371_b.func_46004_aK().nextFloat() * 0.4F + 0.8F));
         this.field_48373_a.func_674_a(var9);
      }

   }
}
