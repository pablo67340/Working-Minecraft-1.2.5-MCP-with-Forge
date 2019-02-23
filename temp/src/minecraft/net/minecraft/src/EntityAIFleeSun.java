package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Vec3D;
import net.minecraft.src.World;

public class EntityAIFleeSun extends EntityAIBase {

   private EntityCreature field_48302_a;
   private double field_48300_b;
   private double field_48301_c;
   private double field_48298_d;
   private float field_48299_e;
   private World field_48297_f;


   public EntityAIFleeSun(EntityCreature p_i1053_1_, float p_i1053_2_) {
      this.field_48302_a = p_i1053_1_;
      this.field_48299_e = p_i1053_2_;
      this.field_48297_f = p_i1053_1_.field_615_ag;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(!this.field_48297_f.func_624_b()) {
         return false;
      } else if(!this.field_48302_a.func_21062_U()) {
         return false;
      } else if(!this.field_48297_f.func_647_i(MathHelper.func_1108_b(this.field_48302_a.field_611_ak), (int)this.field_48302_a.field_601_au.field_1697_b, MathHelper.func_1108_b(this.field_48302_a.field_609_am))) {
         return false;
      } else {
         Vec3D var1 = this.func_48296_h();
         if(var1 == null) {
            return false;
         } else {
            this.field_48300_b = var1.field_1776_a;
            this.field_48301_c = var1.field_1775_b;
            this.field_48298_d = var1.field_1779_c;
            return true;
         }
      }
   }

   public boolean func_46084_g() {
      return !this.field_48302_a.func_48084_aL().func_46072_b();
   }

   public void func_46080_e() {
      this.field_48302_a.func_48084_aL().func_48666_a(this.field_48300_b, this.field_48301_c, this.field_48298_d, this.field_48299_e);
   }

   private Vec3D func_48296_h() {
      Random var1 = this.field_48302_a.func_46004_aK();

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = MathHelper.func_1108_b(this.field_48302_a.field_611_ak + (double)var1.nextInt(20) - 10.0D);
         int var4 = MathHelper.func_1108_b(this.field_48302_a.field_601_au.field_1697_b + (double)var1.nextInt(6) - 3.0D);
         int var5 = MathHelper.func_1108_b(this.field_48302_a.field_609_am + (double)var1.nextInt(20) - 10.0D);
         if(!this.field_48297_f.func_647_i(var3, var4, var5) && this.field_48302_a.func_439_a(var3, var4, var5) < 0.0F) {
            return Vec3D.func_1248_b((double)var3, (double)var4, (double)var5);
         }
      }

      return null;
   }
}
