package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.WorldRenderer;

public class RenderSorter implements Comparator {

   private EntityLiving field_4274_a;


   public RenderSorter(EntityLiving p_i380_1_) {
      this.field_4274_a = p_i380_1_;
   }

   public int func_993_a(WorldRenderer p_993_1_, WorldRenderer p_993_2_) {
      if(p_993_1_.field_1749_o && !p_993_2_.field_1749_o) {
         return 1;
      } else if(p_993_2_.field_1749_o && !p_993_1_.field_1749_o) {
         return -1;
      } else {
         double var3 = (double)p_993_1_.func_1202_a(this.field_4274_a);
         double var5 = (double)p_993_2_.func_1202_a(this.field_4274_a);
         return var3 < var5?1:(var3 > var5?-1:(p_993_1_.field_1735_w < p_993_2_.field_1735_w?1:-1));
      }
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_993_a((WorldRenderer)p_compare_1_, (WorldRenderer)p_compare_2_);
   }
}
