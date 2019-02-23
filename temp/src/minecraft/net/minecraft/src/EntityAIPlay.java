package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.RandomPositionGenerator;
import net.minecraft.src.Vec3D;

public class EntityAIPlay extends EntityAIBase {

   private EntityVillager field_48359_a;
   private EntityLiving field_48357_b;
   private float field_48358_c;
   private int field_48356_d;


   public EntityAIPlay(EntityVillager p_i1074_1_, float p_i1074_2_) {
      this.field_48359_a = p_i1074_1_;
      this.field_48358_c = p_i1074_2_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      if(this.field_48359_a.func_48123_at() >= 0) {
         return false;
      } else if(this.field_48359_a.func_46004_aK().nextInt(400) != 0) {
         return false;
      } else {
         List var1 = this.field_48359_a.field_615_ag.func_657_a(EntityVillager.class, this.field_48359_a.field_601_au.func_1177_b(6.0D, 3.0D, 6.0D));
         double var2 = Double.MAX_VALUE;
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            Entity var5 = (Entity)var4.next();
            if(var5 != this.field_48359_a) {
               EntityVillager var6 = (EntityVillager)var5;
               if(!var6.func_48125_w() && var6.func_48123_at() < 0) {
                  double var7 = var6.func_387_e(this.field_48359_a);
                  if(var7 <= var2) {
                     var2 = var7;
                     this.field_48357_b = var6;
                  }
               }
            }
         }

         if(this.field_48357_b == null) {
            Vec3D var9 = RandomPositionGenerator.func_48622_a(this.field_48359_a, 16, 3);
            if(var9 == null) {
               return false;
            }
         }

         return true;
      }
   }

   public boolean func_46084_g() {
      return this.field_48356_d > 0;
   }

   public void func_46080_e() {
      if(this.field_48357_b != null) {
         this.field_48359_a.func_48127_b(true);
      }

      this.field_48356_d = 1000;
   }

   public void func_46077_d() {
      this.field_48359_a.func_48127_b(false);
      this.field_48357_b = null;
   }

   public void func_46081_b() {
      --this.field_48356_d;
      if(this.field_48357_b != null) {
         if(this.field_48359_a.func_387_e(this.field_48357_b) > 4.0D) {
            this.field_48359_a.func_48084_aL().func_48667_a(this.field_48357_b, this.field_48358_c);
         }
      } else if(this.field_48359_a.func_48084_aL().func_46072_b()) {
         Vec3D var1 = RandomPositionGenerator.func_48622_a(this.field_48359_a, 16, 3);
         if(var1 == null) {
            return;
         }

         this.field_48359_a.func_48084_aL().func_48666_a(var1.field_1776_a, var1.field_1775_b, var1.field_1779_c, this.field_48358_c);
      }

   }
}
