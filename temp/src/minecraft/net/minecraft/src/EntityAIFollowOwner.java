package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityTameable;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PathNavigate;
import net.minecraft.src.World;

public class EntityAIFollowOwner extends EntityAIBase {

   private EntityTameable field_48305_d;
   private EntityLiving field_48306_e;
   World field_48309_a;
   private float field_48303_f;
   private PathNavigate field_48304_g;
   private int field_48310_h;
   float field_48307_b;
   float field_48308_c;
   private boolean field_48311_i;


   public EntityAIFollowOwner(EntityTameable p_i1054_1_, float p_i1054_2_, float p_i1054_3_, float p_i1054_4_) {
      this.field_48305_d = p_i1054_1_;
      this.field_48309_a = p_i1054_1_.field_615_ag;
      this.field_48303_f = p_i1054_2_;
      this.field_48304_g = p_i1054_1_.func_48084_aL();
      this.field_48308_c = p_i1054_3_;
      this.field_48307_b = p_i1054_4_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      EntityLiving var1 = this.field_48305_d.func_48144_ah();
      if(var1 == null) {
         return false;
      } else if(this.field_48305_d.func_48141_af()) {
         return false;
      } else if(this.field_48305_d.func_387_e(var1) < (double)(this.field_48308_c * this.field_48308_c)) {
         return false;
      } else {
         this.field_48306_e = var1;
         return true;
      }
   }

   public boolean func_46084_g() {
      return !this.field_48304_g.func_46072_b() && this.field_48305_d.func_387_e(this.field_48306_e) > (double)(this.field_48307_b * this.field_48307_b) && !this.field_48305_d.func_48141_af();
   }

   public void func_46080_e() {
      this.field_48310_h = 0;
      this.field_48311_i = this.field_48305_d.func_48084_aL().func_48658_a();
      this.field_48305_d.func_48084_aL().func_48664_a(false);
   }

   public void func_46077_d() {
      this.field_48306_e = null;
      this.field_48304_g.func_48672_f();
      this.field_48305_d.func_48084_aL().func_48664_a(this.field_48311_i);
   }

   public void func_46081_b() {
      this.field_48305_d.func_46008_aG().func_46141_a(this.field_48306_e, 10.0F, (float)this.field_48305_d.func_25026_x());
      if(!this.field_48305_d.func_48141_af()) {
         if(--this.field_48310_h <= 0) {
            this.field_48310_h = 10;
            if(!this.field_48304_g.func_48667_a(this.field_48306_e, this.field_48303_f)) {
               if(this.field_48305_d.func_387_e(this.field_48306_e) >= 144.0D) {
                  int var1 = MathHelper.func_1108_b(this.field_48306_e.field_611_ak) - 2;
                  int var2 = MathHelper.func_1108_b(this.field_48306_e.field_609_am) - 2;
                  int var3 = MathHelper.func_1108_b(this.field_48306_e.field_601_au.field_1697_b);

                  for(int var4 = 0; var4 <= 4; ++var4) {
                     for(int var5 = 0; var5 <= 4; ++var5) {
                        if((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && this.field_48309_a.func_28100_h(var1 + var4, var3 - 1, var2 + var5) && !this.field_48309_a.func_28100_h(var1 + var4, var3, var2 + var5) && !this.field_48309_a.func_28100_h(var1 + var4, var3 + 1, var2 + var5)) {
                           this.field_48305_d.func_365_c((double)((float)(var1 + var4) + 0.5F), (double)var3, (double)((float)(var2 + var5) + 0.5F), this.field_48305_d.field_605_aq, this.field_48305_d.field_604_ar);
                           this.field_48304_g.func_48672_f();
                           return;
                        }
                     }
                  }

               }
            }
         }
      }
   }
}
