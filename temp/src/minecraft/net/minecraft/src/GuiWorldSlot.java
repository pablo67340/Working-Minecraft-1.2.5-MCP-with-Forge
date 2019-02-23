package net.minecraft.src;

import java.util.Date;
import net.minecraft.src.GuiSelectWorld;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SaveFormatComparator;
import net.minecraft.src.StatCollector;
import net.minecraft.src.Tessellator;

class GuiWorldSlot extends GuiSlot {

   // $FF: synthetic field
   final GuiSelectWorld field_22266_a;


   public GuiWorldSlot(GuiSelectWorld p_i383_1_) {
      super(p_i383_1_.field_945_b, p_i383_1_.field_951_c, p_i383_1_.field_950_d, 32, p_i383_1_.field_950_d - 64, 36);
      this.field_22266_a = p_i383_1_;
   }

   protected int func_22249_a() {
      return GuiSelectWorld.func_22090_a(this.field_22266_a).size();
   }

   protected void func_22247_a(int p_22247_1_, boolean p_22247_2_) {
      GuiSelectWorld.func_22089_a(this.field_22266_a, p_22247_1_);
      boolean var3 = GuiSelectWorld.func_22086_b(this.field_22266_a) >= 0 && GuiSelectWorld.func_22086_b(this.field_22266_a) < this.func_22249_a();
      GuiSelectWorld.func_22083_c(this.field_22266_a).field_937_g = var3;
      GuiSelectWorld.func_22085_d(this.field_22266_a).field_937_g = var3;
      GuiSelectWorld.func_22092_e(this.field_22266_a).field_937_g = var3;
      if(p_22247_2_ && var3) {
         this.field_22266_a.func_584_c(p_22247_1_);
      }

   }

   protected boolean func_22246_a(int p_22246_1_) {
      return p_22246_1_ == GuiSelectWorld.func_22086_b(this.field_22266_a);
   }

   protected int func_22245_b() {
      return GuiSelectWorld.func_22090_a(this.field_22266_a).size() * 36;
   }

   protected void func_22248_c() {
      this.field_22266_a.func_578_i();
   }

   protected void func_22242_a(int p_22242_1_, int p_22242_2_, int p_22242_3_, int p_22242_4_, Tessellator p_22242_5_) {
      SaveFormatComparator var6 = (SaveFormatComparator)GuiSelectWorld.func_22090_a(this.field_22266_a).get(p_22242_1_);
      String var7 = var6.func_22162_b();
      if(var7 == null || MathHelper.func_22282_a(var7)) {
         var7 = GuiSelectWorld.func_22087_f(this.field_22266_a) + " " + (p_22242_1_ + 1);
      }

      String var8 = var6.func_22164_a();
      var8 = var8 + " (" + GuiSelectWorld.func_22093_g(this.field_22266_a).format(new Date(var6.func_22163_e()));
      var8 = var8 + ")";
      String var9 = "";
      if(var6.func_22161_d()) {
         var9 = GuiSelectWorld.func_22088_h(this.field_22266_a) + " " + var9;
      } else {
         var9 = GuiSelectWorld.func_35315_i(this.field_22266_a)[var6.func_35719_f()];
         if(var6.func_40594_g()) {
            var9 = "\u00a74" + StatCollector.func_25200_a("gameMode.hardcore") + "\u00a78";
         }
      }

      this.field_22266_a.func_547_b(this.field_22266_a.field_6451_g, var7, p_22242_2_ + 2, p_22242_3_ + 1, 16777215);
      this.field_22266_a.func_547_b(this.field_22266_a.field_6451_g, var8, p_22242_2_ + 2, p_22242_3_ + 12, 8421504);
      this.field_22266_a.func_547_b(this.field_22266_a.field_6451_g, var9, p_22242_2_ + 2, p_22242_3_ + 12 + 10, 8421504);
   }
}
