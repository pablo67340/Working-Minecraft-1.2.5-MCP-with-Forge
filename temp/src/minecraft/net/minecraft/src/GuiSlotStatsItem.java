package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.src.GuiSlotStats;
import net.minecraft.src.GuiStats;
import net.minecraft.src.SorterStatsItem;
import net.minecraft.src.StatCrafting;
import net.minecraft.src.StatList;
import net.minecraft.src.Tessellator;

class GuiSlotStatsItem extends GuiSlotStats {

   // $FF: synthetic field
   final GuiStats field_27275_a;


   public GuiSlotStatsItem(GuiStats p_i253_1_) {
      super(p_i253_1_);
      this.field_27275_a = p_i253_1_;
      this.field_27273_c = new ArrayList();
      Iterator var2 = StatList.field_25186_c.iterator();

      while(var2.hasNext()) {
         StatCrafting var3 = (StatCrafting)var2.next();
         boolean var4 = false;
         int var5 = var3.func_25072_b();
         if(GuiStats.func_27142_c(p_i253_1_).func_27184_a(var3) > 0) {
            var4 = true;
         } else if(StatList.field_25170_B[var5] != null && GuiStats.func_27142_c(p_i253_1_).func_27184_a(StatList.field_25170_B[var5]) > 0) {
            var4 = true;
         } else if(StatList.field_25158_z[var5] != null && GuiStats.func_27142_c(p_i253_1_).func_27184_a(StatList.field_25158_z[var5]) > 0) {
            var4 = true;
         }

         if(var4) {
            this.field_27273_c.add(var3);
         }
      }

      this.field_27272_d = new SorterStatsItem(this, p_i253_1_);
   }

   protected void func_27260_a(int p_27260_1_, int p_27260_2_, Tessellator p_27260_3_) {
      super.func_27260_a(p_27260_1_, p_27260_2_, p_27260_3_);
      if(this.field_27268_b == 0) {
         GuiStats.func_27128_a(this.field_27275_a, p_27260_1_ + 115 - 18 + 1, p_27260_2_ + 1 + 1, 72, 18);
      } else {
         GuiStats.func_27128_a(this.field_27275_a, p_27260_1_ + 115 - 18, p_27260_2_ + 1, 72, 18);
      }

      if(this.field_27268_b == 1) {
         GuiStats.func_27128_a(this.field_27275_a, p_27260_1_ + 165 - 18 + 1, p_27260_2_ + 1 + 1, 18, 18);
      } else {
         GuiStats.func_27128_a(this.field_27275_a, p_27260_1_ + 165 - 18, p_27260_2_ + 1, 18, 18);
      }

      if(this.field_27268_b == 2) {
         GuiStats.func_27128_a(this.field_27275_a, p_27260_1_ + 215 - 18 + 1, p_27260_2_ + 1 + 1, 36, 18);
      } else {
         GuiStats.func_27128_a(this.field_27275_a, p_27260_1_ + 215 - 18, p_27260_2_ + 1, 36, 18);
      }

   }

   protected void func_22242_a(int p_22242_1_, int p_22242_2_, int p_22242_3_, int p_22242_4_, Tessellator p_22242_5_) {
      StatCrafting var6 = this.func_27264_b(p_22242_1_);
      int var7 = var6.func_25072_b();
      GuiStats.func_27148_a(this.field_27275_a, p_22242_2_ + 40, p_22242_3_, var7);
      this.func_27265_a((StatCrafting)StatList.field_25170_B[var7], p_22242_2_ + 115, p_22242_3_, p_22242_1_ % 2 == 0);
      this.func_27265_a((StatCrafting)StatList.field_25158_z[var7], p_22242_2_ + 165, p_22242_3_, p_22242_1_ % 2 == 0);
      this.func_27265_a(var6, p_22242_2_ + 215, p_22242_3_, p_22242_1_ % 2 == 0);
   }

   protected String func_27263_a(int p_27263_1_) {
      return p_27263_1_ == 1?"stat.crafted":(p_27263_1_ == 2?"stat.used":"stat.depleted");
   }
}
