package net.minecraft.src;

import net.minecraft.src.GuiSlot;
import net.minecraft.src.GuiStats;
import net.minecraft.src.StatBase;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StatList;
import net.minecraft.src.Tessellator;

class GuiSlotStatsGeneral extends GuiSlot {

   // $FF: synthetic field
   final GuiStats field_27276_a;


   public GuiSlotStatsGeneral(GuiStats p_i483_1_) {
      super(GuiStats.func_27141_a(p_i483_1_), p_i483_1_.field_951_c, p_i483_1_.field_950_d, 32, p_i483_1_.field_950_d - 64, 10);
      this.field_27276_a = p_i483_1_;
      this.func_27258_a(false);
   }

   protected int func_22249_a() {
      return StatList.field_25187_b.size();
   }

   protected void func_22247_a(int p_22247_1_, boolean p_22247_2_) {}

   protected boolean func_22246_a(int p_22246_1_) {
      return false;
   }

   protected int func_22245_b() {
      return this.func_22249_a() * 10;
   }

   protected void func_22248_c() {
      this.field_27276_a.func_578_i();
   }

   protected void func_22242_a(int p_22242_1_, int p_22242_2_, int p_22242_3_, int p_22242_4_, Tessellator p_22242_5_) {
      StatBase var6 = (StatBase)StatList.field_25187_b.get(p_22242_1_);
      this.field_27276_a.func_547_b(GuiStats.func_27145_b(this.field_27276_a), StatCollector.func_25200_a(var6.func_44020_i()), p_22242_2_ + 2, p_22242_3_ + 1, p_22242_1_ % 2 == 0?16777215:9474192);
      String var7 = var6.func_27084_a(GuiStats.func_27142_c(this.field_27276_a).func_27184_a(var6));
      this.field_27276_a.func_547_b(GuiStats.func_27140_d(this.field_27276_a), var7, p_22242_2_ + 2 + 213 - GuiStats.func_27146_e(this.field_27276_a).func_871_a(var7), p_22242_3_ + 1, p_22242_1_ % 2 == 0?16777215:9474192);
   }
}
