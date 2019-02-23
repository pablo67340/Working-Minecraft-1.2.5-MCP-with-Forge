package net.minecraft.src;

import net.minecraft.src.ChunkCoordinates;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;

public class EntityAIMoveTwardsRestriction extends EntityAIBase {

   private EntityCreature field_48355_a;
   private double field_48353_b;
   private double field_48354_c;
   private double field_48351_d;
   private float field_48352_e;


   public EntityAIMoveTwardsRestriction(EntityCreature p_i1079_1_, float p_i1079_2_) {
      this.field_48355_a = p_i1079_1_;
      this.field_48352_e = p_i1079_2_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(this.field_48355_a.func_48093_aT()) {
         return false;
      } else {
         ChunkCoordinates var1 = this.field_48355_a.func_48091_aU();
         Vec3D var2 = RandomPositionGenerator.func_48620_a(this.field_48355_a, 16, 7, Vec3D.func_1248_b((double)var1.field_22395_a, (double)var1.field_22394_b, (double)var1.field_22396_c));
         if(var2 == null) {
            return false;
         } else {
            this.field_48353_b = var2.field_1776_a;
            this.field_48354_c = var2.field_1775_b;
            this.field_48351_d = var2.field_1779_c;
            return true;
         }
      }
   }

   public boolean func_46084_g() {
      return !this.field_48355_a.func_48084_aL().func_46072_b();
   }

   public void func_46080_e() {
      this.field_48355_a.func_48084_aL().func_48666_a(this.field_48353_b, this.field_48354_c, this.field_48351_d, this.field_48352_e);
   }
}
