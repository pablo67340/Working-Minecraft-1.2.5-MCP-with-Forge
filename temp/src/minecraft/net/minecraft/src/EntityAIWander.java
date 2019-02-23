package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;

public class EntityAIWander extends EntityAIBase {

   private EntityCreature field_46100_a;
   private double field_46098_b;
   private double field_46099_c;
   private double field_46097_d;
   private float field_48317_e;


   public EntityAIWander(EntityCreature p_i1002_1_, float p_i1002_2_) {
      this.field_46100_a = p_i1002_1_;
      this.field_48317_e = p_i1002_2_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(this.field_46100_a.func_46011_aM() >= 100) {
         return false;
      } else if(this.field_46100_a.func_46004_aK().nextInt(120) != 0) {
         return false;
      } else {
         Vec3D var1 = RandomPositionGenerator.func_48622_a(this.field_46100_a, 10, 7);
         if(var1 == null) {
            return false;
         } else {
            this.field_46098_b = var1.field_1776_a;
            this.field_46099_c = var1.field_1775_b;
            this.field_46097_d = var1.field_1779_c;
            return true;
         }
      }
   }

   public boolean func_46084_g() {
      return !this.field_46100_a.func_48084_aL().func_46072_b();
   }

   public void func_46080_e() {
      this.field_46100_a.func_48084_aL().func_48666_a(this.field_46098_b, this.field_46099_c, this.field_46097_d, this.field_48317_e);
   }
}
