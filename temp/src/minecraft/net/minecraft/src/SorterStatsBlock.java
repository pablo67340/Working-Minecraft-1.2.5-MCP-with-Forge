package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.GuiSlotStatsBlock;
import net.minecraft.src.GuiStats;
import net.minecraft.src.StatBase;
import net.minecraft.src.StatCrafting;
import net.minecraft.src.StatList;

class SorterStatsBlock implements Comparator {

   // $FF: synthetic field
   final GuiStats field_27299_a;
   // $FF: synthetic field
   final GuiSlotStatsBlock field_27298_b;


   SorterStatsBlock(GuiSlotStatsBlock p_i87_1_, GuiStats p_i87_2_) {
      this.field_27298_b = p_i87_1_;
      this.field_27299_a = p_i87_2_;
   }

   public int func_27297_a(StatCrafting p_27297_1_, StatCrafting p_27297_2_) {
      int var3 = p_27297_1_.func_25072_b();
      int var4 = p_27297_2_.func_25072_b();
      StatBase var5 = null;
      StatBase var6 = null;
      if(this.field_27298_b.field_27271_e == 2) {
         var5 = StatList.field_25159_y[var3];
         var6 = StatList.field_25159_y[var4];
      } else if(this.field_27298_b.field_27271_e == 0) {
         var5 = StatList.field_25158_z[var3];
         var6 = StatList.field_25158_z[var4];
      } else if(this.field_27298_b.field_27271_e == 1) {
         var5 = StatList.field_25172_A[var3];
         var6 = StatList.field_25172_A[var4];
      }

      if(var5 != null || var6 != null) {
         if(var5 == null) {
            return 1;
         }

         if(var6 == null) {
            return -1;
         }

         int var7 = GuiStats.func_27142_c(this.field_27298_b.field_27274_a).func_27184_a(var5);
         int var8 = GuiStats.func_27142_c(this.field_27298_b.field_27274_a).func_27184_a(var6);
         if(var7 != var8) {
            return (var7 - var8) * this.field_27298_b.field_27270_f;
         }
      }

      return var3 - var4;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_27297_a((StatCrafting)p_compare_1_, (StatCrafting)p_compare_2_);
   }
}
