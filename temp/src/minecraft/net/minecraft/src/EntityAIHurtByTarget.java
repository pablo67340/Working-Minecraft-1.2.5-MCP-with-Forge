package net.minecraft.src;

import java.util.Iterator;
import java.util.List;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityLiving;

public class EntityAIHurtByTarget extends EntityAITarget {

   boolean field_48395_a;


   public EntityAIHurtByTarget(EntityLiving p_i1096_1_, boolean p_i1096_2_) {
      super(p_i1096_1_, 16.0F, false);
      this.field_48395_a = p_i1096_2_;
      this.func_46079_a(1);
   }

   public boolean func_46082_a() {
      return this.func_48376_a(this.field_48382_c.func_46007_aL(), true);
   }

   public void func_46080_e() {
      this.field_48382_c.func_48092_c(this.field_48382_c.func_46007_aL());
      if(this.field_48395_a) {
         List var1 = this.field_48382_c.field_615_ag.func_657_a(this.field_48382_c.getClass(), AxisAlignedBB.func_1161_b(this.field_48382_c.field_611_ak, this.field_48382_c.field_610_al, this.field_48382_c.field_609_am, this.field_48382_c.field_611_ak + 1.0D, this.field_48382_c.field_610_al + 1.0D, this.field_48382_c.field_609_am + 1.0D).func_1177_b((double)this.field_48379_d, 4.0D, (double)this.field_48379_d));
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            Entity var3 = (Entity)var2.next();
            EntityLiving var4 = (EntityLiving)var3;
            if(this.field_48382_c != var4 && var4.func_48094_aS() == null) {
               var4.func_48092_c(this.field_48382_c.func_46007_aL());
            }
         }
      }

      super.func_46080_e();
   }
}
