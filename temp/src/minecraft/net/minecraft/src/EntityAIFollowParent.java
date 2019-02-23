package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityAnimal;

public class EntityAIFollowParent extends EntityAIBase {

   EntityAnimal field_48249_a;
   EntityAnimal field_48247_b;
   float field_48248_c;
   private int field_48246_d;


   public EntityAIFollowParent(EntityAnimal p_i1031_1_, float p_i1031_2_) {
      this.field_48249_a = p_i1031_1_;
      this.field_48248_c = p_i1031_2_;
   }

   public boolean func_46082_a() {
      if(this.field_48249_a.func_48123_at() >= 0) {
         return false;
      } else {
         List var1 = this.field_48249_a.field_615_ag.func_657_a(this.field_48249_a.getClass(), this.field_48249_a.field_601_au.func_1177_b(8.0D, 4.0D, 8.0D));
         EntityAnimal var2 = null;
         double var3 = Double.MAX_VALUE;
         Iterator var5 = var1.iterator();

         while(var5.hasNext()) {
            Entity var6 = (Entity)var5.next();
            EntityAnimal var7 = (EntityAnimal)var6;
            if(var7.func_48123_at() >= 0) {
               double var8 = this.field_48249_a.func_387_e(var7);
               if(var8 <= var3) {
                  var3 = var8;
                  var2 = var7;
               }
            }
         }

         if(var2 == null) {
            return false;
         } else if(var3 < 9.0D) {
            return false;
         } else {
            this.field_48247_b = var2;
            return true;
         }
      }
   }

   public boolean func_46084_g() {
      if(!this.field_48247_b.func_354_B()) {
         return false;
      } else {
         double var1 = this.field_48249_a.func_387_e(this.field_48247_b);
         return var1 >= 9.0D && var1 <= 256.0D;
      }
   }

   public void func_46080_e() {
      this.field_48246_d = 0;
   }

   public void func_46077_d() {
      this.field_48247_b = null;
   }

   public void func_46081_b() {
      if(--this.field_48246_d <= 0) {
         this.field_48246_d = 10;
         this.field_48249_a.func_48084_aL().func_48667_a(this.field_48247_b, this.field_48248_c);
      }
   }
}
