package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.StringTranslate;

public class GuiYesNo extends GuiScreen {

   private GuiScreen field_961_a;
   private String field_964_h;
   private String field_963_i;
   protected String field_22106_k;
   protected String field_22105_l;
   private int field_962_j;


   public GuiYesNo(GuiScreen p_i1204_1_, String p_i1204_2_, String p_i1204_3_, int p_i1204_4_) {
      this.field_961_a = p_i1204_1_;
      this.field_964_h = p_i1204_2_;
      this.field_963_i = p_i1204_3_;
      this.field_962_j = p_i1204_4_;
      StringTranslate var5 = StringTranslate.func_20162_a();
      this.field_22106_k = var5.func_20163_a("gui.yes");
      this.field_22105_l = var5.func_20163_a("gui.no");
   }

   public GuiYesNo(GuiScreen p_i453_1_, String p_i453_2_, String p_i453_3_, String p_i453_4_, String p_i453_5_, int p_i453_6_) {
      this.field_961_a = p_i453_1_;
      this.field_964_h = p_i453_2_;
      this.field_963_i = p_i453_3_;
      this.field_22106_k = p_i453_4_;
      this.field_22105_l = p_i453_5_;
      this.field_962_j = p_i453_6_;
   }

   public void func_6448_a() {
      this.field_949_e.add(new GuiSmallButton(0, this.field_951_c / 2 - 155, this.field_950_d / 6 + 96, this.field_22106_k));
      this.field_949_e.add(new GuiSmallButton(1, this.field_951_c / 2 - 155 + 160, this.field_950_d / 6 + 96, this.field_22105_l));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      this.field_961_a.func_568_a(p_572_1_.field_938_f == 0, this.field_962_j);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, this.field_964_h, this.field_951_c / 2, 70, 16777215);
      this.func_548_a(this.field_6451_g, this.field_963_i, this.field_951_c / 2, 90, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
