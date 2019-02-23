package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.Entity;
import net.minecraft.src.WorldRenderer;

public class EntitySorter implements Comparator {

   private double field_30008_a;
   private double field_30007_b;
   private double field_30009_c;


   public EntitySorter(Entity p_i349_1_) {
      this.field_30008_a = -p_i349_1_.field_611_ak;
      this.field_30007_b = -p_i349_1_.field_610_al;
      this.field_30009_c = -p_i349_1_.field_609_am;
   }

   public int func_1063_a(WorldRenderer p_1063_1_, WorldRenderer p_1063_2_) {
      double var3 = (double)p_1063_1_.field_1746_q + this.field_30008_a;
      double var5 = (double)p_1063_1_.field_1743_r + this.field_30007_b;
      double var7 = (double)p_1063_1_.field_1741_s + this.field_30009_c;
      double var9 = (double)p_1063_2_.field_1746_q + this.field_30008_a;
      double var11 = (double)p_1063_2_.field_1743_r + this.field_30007_b;
      double var13 = (double)p_1063_2_.field_1741_s + this.field_30009_c;
      return (int)((var3 * var3 + var5 * var5 + var7 * var7 - (var9 * var9 + var11 * var11 + var13 * var13)) * 1024.0D);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_1063_a((WorldRenderer)p_compare_1_, (WorldRenderer)p_compare_2_);
   }
}
