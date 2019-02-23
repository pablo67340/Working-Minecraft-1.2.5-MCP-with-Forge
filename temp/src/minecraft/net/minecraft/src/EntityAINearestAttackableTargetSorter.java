package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAINearestAttackableTarget;

public class EntityAINearestAttackableTargetSorter implements Comparator {

   private Entity field_48470_b;
   // $FF: synthetic field
   final EntityAINearestAttackableTarget field_48471_a;


   public EntityAINearestAttackableTargetSorter(EntityAINearestAttackableTarget p_i1028_1_, Entity p_i1028_2_) {
      this.field_48471_a = p_i1028_1_;
      this.field_48470_b = p_i1028_2_;
   }

   public int func_48469_a(Entity p_48469_1_, Entity p_48469_2_) {
      double var3 = this.field_48470_b.func_387_e(p_48469_1_);
      double var5 = this.field_48470_b.func_387_e(p_48469_2_);
      return var3 < var5?-1:(var3 > var5?1:0);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_48469_a((Entity)p_compare_1_, (Entity)p_compare_2_);
   }
}
