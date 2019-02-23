package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;

public class EntityAIPanic extends EntityAIBase {

   private EntityCreature field_48316_a;
   private float field_48314_b;
   private double field_48315_c;
   private double field_48312_d;
   private double field_48313_e;


   public EntityAIPanic(EntityCreature p_i1049_1_, float p_i1049_2_) {
      this.field_48316_a = p_i1049_1_;
      this.field_48314_b = p_i1049_2_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(this.field_48316_a.func_46007_aL() == null) {
         return false;
      } else {
         Vec3D var1 = RandomPositionGenerator.func_48622_a(this.field_48316_a, 5, 4);
         if(var1 == null) {
            return false;
         } else {
            this.field_48315_c = var1.field_1776_a;
            this.field_48312_d = var1.field_1775_b;
            this.field_48313_e = var1.field_1779_c;
            return true;
         }
      }
   }

   public void func_46080_e() {
      this.field_48316_a.func_48084_aL().func_48666_a(this.field_48315_c, this.field_48312_d, this.field_48313_e, this.field_48314_b);
   }

   public boolean func_46084_g() {
      return !this.field_48316_a.func_48084_aL().func_46072_b();
   }
}
