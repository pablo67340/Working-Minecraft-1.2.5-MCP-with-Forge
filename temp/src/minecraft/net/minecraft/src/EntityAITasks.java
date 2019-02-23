package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityAITaskEntry;

public class EntityAITasks {

   private ArrayList field_46120_a = new ArrayList();
   private ArrayList field_46119_b = new ArrayList();


   public void func_46118_a(int p_46118_1_, EntityAIBase p_46118_2_) {
      this.field_46120_a.add(new EntityAITaskEntry(this, p_46118_1_, p_46118_2_));
   }

   public void func_46115_a() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_46120_a.iterator();

      while(var2.hasNext()) {
         EntityAITaskEntry var3 = (EntityAITaskEntry)var2.next();
         boolean var4 = this.field_46119_b.contains(var3);
         if(var4) {
            if(this.func_46116_a(var3) && var3.field_46114_a.func_46084_g()) {
               continue;
            }

            var3.field_46114_a.func_46077_d();
            this.field_46119_b.remove(var3);
         }

         if(this.func_46116_a(var3) && var3.field_46114_a.func_46082_a()) {
            var1.add(var3);
            this.field_46119_b.add(var3);
         }
      }

      boolean var5 = false;
      if(var5 && var1.size() > 0) {
         System.out.println("Starting: ");
      }

      Iterator var6;
      EntityAITaskEntry var7;
      for(var6 = var1.iterator(); var6.hasNext(); var7.field_46114_a.func_46080_e()) {
         var7 = (EntityAITaskEntry)var6.next();
         if(var5) {
            System.out.println(var7.field_46114_a.toString() + ", ");
         }
      }

      if(var5 && this.field_46119_b.size() > 0) {
         System.out.println("Running: ");
      }

      for(var6 = this.field_46119_b.iterator(); var6.hasNext(); var7.field_46114_a.func_46081_b()) {
         var7 = (EntityAITaskEntry)var6.next();
         if(var5) {
            System.out.println(var7.field_46114_a.toString());
         }
      }

   }

   private boolean func_46116_a(EntityAITaskEntry p_46116_1_) {
      Iterator var2 = this.field_46120_a.iterator();

      while(var2.hasNext()) {
         EntityAITaskEntry var3 = (EntityAITaskEntry)var2.next();
         if(var3 != p_46116_1_) {
            if(p_46116_1_.field_46112_b >= var3.field_46112_b) {
               if(this.field_46119_b.contains(var3) && !this.func_46117_a(p_46116_1_, var3)) {
                  return false;
               }
            } else if(this.field_46119_b.contains(var3) && !var3.field_46114_a.func_46078_f()) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean func_46117_a(EntityAITaskEntry p_46117_1_, EntityAITaskEntry p_46117_2_) {
      return (p_46117_1_.field_46114_a.func_46083_c() & p_46117_2_.field_46114_a.func_46083_c()) == 0;
   }
}
