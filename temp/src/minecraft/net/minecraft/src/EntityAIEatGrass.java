package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class EntityAIEatGrass extends EntityAIBase {

   private EntityLiving field_48397_b;
   private World field_48398_c;
   int field_48399_a = 0;


   public EntityAIEatGrass(EntityLiving p_i1095_1_) {
      this.field_48397_b = p_i1095_1_;
      this.field_48398_c = p_i1095_1_.field_615_ag;
      this.func_46079_a(7);
   }

   public boolean func_46082_a() {
      if(this.field_48397_b.func_46004_aK().nextInt(this.field_48397_b.func_40127_l()?50:1000) != 0) {
         return false;
      } else {
         int var1 = MathHelper.func_1108_b(this.field_48397_b.field_611_ak);
         int var2 = MathHelper.func_1108_b(this.field_48397_b.field_610_al);
         int var3 = MathHelper.func_1108_b(this.field_48397_b.field_609_am);
         return this.field_48398_c.func_600_a(var1, var2, var3) == Block.field_9257_X.field_376_bc && this.field_48398_c.func_602_e(var1, var2, var3) == 1?true:this.field_48398_c.func_600_a(var1, var2 - 1, var3) == Block.field_337_v.field_376_bc;
      }
   }

   public void func_46080_e() {
      this.field_48399_a = 40;
      this.field_48398_c.func_9425_a(this.field_48397_b, (byte)10);
      this.field_48397_b.func_48084_aL().func_48672_f();
   }

   public void func_46077_d() {
      this.field_48399_a = 0;
   }

   public boolean func_46084_g() {
      return this.field_48399_a > 0;
   }

   public int func_48396_h() {
      return this.field_48399_a;
   }

   public void func_46081_b() {
      this.field_48399_a = Math.max(0, this.field_48399_a - 1);
      if(this.field_48399_a == 4) {
         int var1 = MathHelper.func_1108_b(this.field_48397_b.field_611_ak);
         int var2 = MathHelper.func_1108_b(this.field_48397_b.field_610_al);
         int var3 = MathHelper.func_1108_b(this.field_48397_b.field_609_am);
         if(this.field_48398_c.func_600_a(var1, var2, var3) == Block.field_9257_X.field_376_bc) {
            this.field_48398_c.func_28106_e(2001, var1, var2, var3, Block.field_9257_X.field_376_bc + 4096);
            this.field_48398_c.func_690_d(var1, var2, var3, 0);
            this.field_48397_b.func_48095_u();
         } else if(this.field_48398_c.func_600_a(var1, var2 - 1, var3) == Block.field_337_v.field_376_bc) {
            this.field_48398_c.func_28106_e(2001, var1, var2 - 1, var3, Block.field_337_v.field_376_bc);
            this.field_48398_c.func_690_d(var1, var2 - 1, var3, Block.field_336_w.field_376_bc);
            this.field_48397_b.func_48095_u();
         }

      }
   }
}
