package net.minecraft.src;

import java.util.Comparator;
import net.minecraft.src.GuiSlotStatsItem;
import net.minecraft.src.GuiStats;
import net.minecraft.src.StatBase;
import net.minecraft.src.StatCrafting;
import net.minecraft.src.StatList;

class SorterStatsItem implements Comparator {

   // $FF: synthetic field
   final GuiStats field_27373_a;
   // $FF: synthetic field
   final GuiSlotStatsItem field_27372_b;


   SorterStatsItem(GuiSlotStatsItem p_i309_1_, GuiStats p_i309_2_) {
      this.field_27372_b = p_i309_1_;
      this.field_27373_a = p_i309_2_;
   }

   public int func_27371_a(StatCrafting p_27371_1_, StatCrafting p_27371_2_) {
      int var3 = p_27371_1_.func_25072_b();
      int var4 = p_27371_2_.func_25072_b();
      StatBase var5 = null;
      StatBase var6 = null;
      if(this.field_27372_b.field_27271_e == 0) {
         var5 = StatList.field_25170_B[var3];
         var6 = StatList.field_25170_B[var4];
      } else if(this.field_27372_b.field_27271_e == 1) {
         var5 = StatList.field_25158_z[var3];
         var6 = StatList.field_25158_z[var4];
      } else if(this.field_27372_b.field_27271_e == 2) {
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

         int var7 = GuiStats.func_27142_c(this.field_27372_b.field_27275_a).func_27184_a(var5);
         int var8 = GuiStats.func_27142_c(this.field_27372_b.field_27275_a).func_27184_a(var6);
         if(var7 != var8) {
            return (var7 - var8) * this.field_27372_b.field_27270_f;
         }
      }

      return var3 - var4;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.func_27371_a((StatCrafting)p_compare_1_, (StatCrafting)p_compare_2_);
   }
}
