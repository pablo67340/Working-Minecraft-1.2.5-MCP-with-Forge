package net.minecraft.src;

import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSlotLanguage;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.StringTranslate;

public class GuiLanguage extends GuiScreen {

   protected GuiScreen field_44009_a;
   private int field_44007_b = -1;
   private GuiSlotLanguage field_44008_c;
   private final GameSettings field_44006_d;
   private GuiSmallButton field_46029_e;


   public GuiLanguage(GuiScreen p_i92_1_, GameSettings p_i92_2_) {
      this.field_44009_a = p_i92_1_;
      this.field_44006_d = p_i92_2_;
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.add(this.field_46029_e = new GuiSmallButton(6, this.field_951_c / 2 - 75, this.field_950_d - 38, var1.func_20163_a("gui.done")));
      this.field_44008_c = new GuiSlotLanguage(this);
      this.field_44008_c.func_22240_a(this.field_949_e, 7, 8);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         switch(p_572_1_.field_938_f) {
         case 5:
            break;
         case 6:
            this.field_44006_d.func_1041_b();
            this.field_945_b.func_6272_a(this.field_44009_a);
            break;
         default:
            this.field_44008_c.func_22241_a(p_572_1_);
         }

      }
   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
   }

   protected void func_573_b(int p_573_1_, int p_573_2_, int p_573_3_) {
      super.func_573_b(p_573_1_, p_573_2_, p_573_3_);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.field_44008_c.func_22243_a(p_571_1_, p_571_2_, p_571_3_);
      if(this.field_44007_b <= 0) {
         this.field_945_b.field_6298_C.func_6532_a();
         this.field_44007_b += 20;
      }

      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("options.language"), this.field_951_c / 2, 16, 16777215);
      this.func_548_a(this.field_6451_g, "(" + var4.func_20163_a("options.languageWarning") + ")", this.field_951_c / 2, this.field_950_d - 56, 8421504);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

   public void func_570_g() {
      super.func_570_g();
      --this.field_44007_b;
   }

   // $FF: synthetic method
   static GameSettings func_44005_a(GuiLanguage p_44005_0_) {
      return p_44005_0_.field_44006_d;
   }

   // $FF: synthetic method
   static GuiSmallButton func_46028_b(GuiLanguage p_46028_0_) {
      return p_46028_0_.field_46029_e;
   }
}
