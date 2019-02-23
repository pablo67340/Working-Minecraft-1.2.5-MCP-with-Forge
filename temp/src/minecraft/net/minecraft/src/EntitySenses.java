package net.minecraft.src;

import java.util.ArrayList;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Profiler;

public class EntitySenses {

   EntityLiving field_48484_a;
   ArrayList field_48482_b = new ArrayList();
   ArrayList field_48483_c = new ArrayList();


   public EntitySenses(EntityLiving p_i1000_1_) {
      this.field_48484_a = p_i1000_1_;
   }

   public void func_48481_a() {
      this.field_48482_b.clear();
      this.field_48483_c.clear();
   }

   public boolean func_48480_a(Entity p_48480_1_) {
      if(this.field_48482_b.contains(p_48480_1_)) {
         return true;
      } else if(this.field_48483_c.contains(p_48480_1_)) {
         return false;
      } else {
         Profiler.func_40663_a("canSee");
         boolean var2 = this.field_48484_a.func_420_c(p_48480_1_);
         Profiler.func_40662_b();
         if(var2) {
            this.field_48482_b.add(p_48480_1_);
         } else {
            this.field_48483_c.add(p_48480_1_);
         }

         return var2;
      }
   }
}
