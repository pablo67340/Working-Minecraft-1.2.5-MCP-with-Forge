package net.minecraft.src;

import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityVillager;

public class EntityAILookAtVillager extends EntityAIBase {

   private EntityIronGolem field_48406_a;
   private EntityVillager field_48404_b;
   private int field_48405_c;


   public EntityAILookAtVillager(EntityIronGolem p_i1092_1_) {
      this.field_48406_a = p_i1092_1_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      if(!this.field_48406_a.field_615_ag.func_624_b()) {
         return false;
      } else if(this.field_48406_a.func_46004_aK().nextInt(8000) != 0) {
         return false;
      } else {
         this.field_48404_b = (EntityVillager)this.field_48406_a.field_615_ag.func_48459_a(EntityVillager.class, this.field_48406_a.field_601_au.func_1177_b(6.0D, 2.0D, 6.0D), this.field_48406_a);
         return this.field_48404_b != null;
      }
   }

   public boolean func_46084_g() {
      return this.field_48405_c > 0;
   }

   public void func_46080_e() {
      this.field_48405_c = 400;
      this.field_48406_a.func_48116_a(true);
   }

   public void func_46077_d() {
      this.field_48406_a.func_48116_a(false);
      this.field_48404_b = null;
   }

   public void func_46081_b() {
      this.field_48406_a.func_46008_aG().func_46141_a(this.field_48404_b, 30.0F, 30.0F);
      --this.field_48405_c;
   }
}
