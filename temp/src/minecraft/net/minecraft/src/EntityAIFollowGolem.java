package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIBase;
import net.minecraft.src.EntityIronGolem;
import net.minecraft.src.EntityVillager;

public class EntityAIFollowGolem extends EntityAIBase {

   private EntityVillager field_48403_a;
   private EntityIronGolem field_48401_b;
   private int field_48402_c;
   private boolean field_48400_d = false;


   public EntityAIFollowGolem(EntityVillager p_i1093_1_) {
      this.field_48403_a = p_i1093_1_;
      this.func_46079_a(3);
   }

   public boolean func_46082_a() {
      if(this.field_48403_a.func_48123_at() >= 0) {
         return false;
      } else if(!this.field_48403_a.field_615_ag.func_624_b()) {
         return false;
      } else {
         List var1 = this.field_48403_a.field_615_ag.func_657_a(EntityIronGolem.class, this.field_48403_a.field_601_au.func_1177_b(6.0D, 2.0D, 6.0D));
         if(var1.size() == 0) {
            return false;
         } else {
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               Entity var3 = (Entity)var2.next();
               EntityIronGolem var4 = (EntityIronGolem)var3;
               if(var4.func_48117_D_() > 0) {
                  this.field_48401_b = var4;
                  break;
               }
            }

            return this.field_48401_b != null;
         }
      }
   }

   public boolean func_46084_g() {
      return this.field_48401_b.func_48117_D_() > 0;
   }

   public void func_46080_e() {
      this.field_48402_c = this.field_48403_a.func_46004_aK().nextInt(320);
      this.field_48400_d = false;
      this.field_48401_b.func_48084_aL().func_48672_f();
   }

   public void func_46077_d() {
      this.field_48401_b = null;
      this.field_48403_a.func_48084_aL().func_48672_f();
   }

   public void func_46081_b() {
      this.field_48403_a.func_46008_aG().func_46141_a(this.field_48401_b, 30.0F, 30.0F);
      if(this.field_48401_b.func_48117_D_() == this.field_48402_c) {
         this.field_48403_a.func_48084_aL().func_48667_a(this.field_48401_b, 0.15F);
         this.field_48400_d = true;
      }

      if(this.field_48400_d && this.field_48403_a.func_387_e(this.field_48401_b) < 4.0D) {
         this.field_48401_b.func_48116_a(false);
         this.field_48403_a.func_48084_aL().func_48672_f();
      }

   }
}
