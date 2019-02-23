package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiYesNo;
import net.minecraft.src.StringTranslate;

public abstract class GuiConfirmOpenLink extends GuiYesNo {

   private String field_50054_a;
   private String field_50053_b;


   public GuiConfirmOpenLink(GuiScreen p_i1200_1_, String p_i1200_2_, int p_i1200_3_) {
      super(p_i1200_1_, StringTranslate.func_20162_a().func_20163_a("chat.link.confirm"), p_i1200_2_, p_i1200_3_);
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.field_22106_k = var4.func_20163_a("gui.yes");
      this.field_22105_l = var4.func_20163_a("gui.no");
      this.field_50053_b = var4.func_20163_a("chat.copy");
      this.field_50054_a = var4.func_20163_a("chat.link.warning");
   }

   public void func_6448_a() {
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 3 - 83 + 0, this.field_950_d / 6 + 96, 100, 20, this.field_22106_k));
      this.field_949_e.add(new GuiButton(2, this.field_951_c / 3 - 83 + 105, this.field_950_d / 6 + 96, 100, 20, this.field_50053_b));
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 3 - 83 + 210, this.field_950_d / 6 + 96, 100, 20, this.field_22105_l));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 2) {
         this.func_50052_d();
         super.func_572_a((GuiButton)this.field_949_e.get(1));
      } else {
         super.func_572_a(p_572_1_);
      }

   }

   public abstract void func_50052_d();

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
      this.func_548_a(this.field_6451_g, this.field_50054_a, this.field_951_c / 2, 110, 16764108);
   }
}
