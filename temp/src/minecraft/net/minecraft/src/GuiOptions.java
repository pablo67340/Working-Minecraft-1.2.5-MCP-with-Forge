package net.minecraft.src;

import net.minecraft.src.EnumOptions;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiControls;
import net.minecraft.src.GuiLanguage;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSlider;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.GuiVideoSettings;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;

public class GuiOptions extends GuiScreen {

   private GuiScreen field_996_h;
   protected String field_994_a = "Options";
   private GameSettings field_995_i;
   private static EnumOptions[] field_22135_k = new EnumOptions[]{EnumOptions.MUSIC, EnumOptions.SOUND, EnumOptions.INVERT_MOUSE, EnumOptions.SENSITIVITY, EnumOptions.FOV, EnumOptions.DIFFICULTY};


   public GuiOptions(GuiScreen p_i260_1_, GameSettings p_i260_2_) {
      this.field_996_h = p_i260_1_;
      this.field_995_i = p_i260_2_;
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_994_a = var1.func_20163_a("options.title");
      int var2 = 0;
      EnumOptions[] var3 = field_22135_k;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         EnumOptions var6 = var3[var5];
         if(!var6.func_20136_a()) {
            GuiSmallButton var7 = new GuiSmallButton(var6.func_20135_c(), this.field_951_c / 2 - 155 + var2 % 2 * 160, this.field_950_d / 6 + 24 * (var2 >> 1), var6, this.field_995_i.func_1043_a(var6));
            if(var6 == EnumOptions.DIFFICULTY && this.field_945_b.field_6324_e != null && this.field_945_b.field_6324_e.func_22144_v().func_40724_s()) {
               var7.field_937_g = false;
               var7.field_939_e = StatCollector.func_25200_a("options.difficulty") + ": " + StatCollector.func_25200_a("options.difficulty.hardcore");
            }

            this.field_949_e.add(var7);
         } else {
            this.field_949_e.add(new GuiSlider(var6.func_20135_c(), this.field_951_c / 2 - 155 + var2 % 2 * 160, this.field_950_d / 6 + 24 * (var2 >> 1), var6, this.field_995_i.func_1043_a(var6), this.field_995_i.func_20104_a(var6)));
         }

         ++var2;
      }

      this.field_949_e.add(new GuiButton(101, this.field_951_c / 2 - 100, this.field_950_d / 6 + 96 - 6, var1.func_20163_a("options.video")));
      this.field_949_e.add(new GuiButton(100, this.field_951_c / 2 - 100, this.field_950_d / 6 + 120 - 6, var1.func_20163_a("options.controls")));
      this.field_949_e.add(new GuiButton(102, this.field_951_c / 2 - 100, this.field_950_d / 6 + 144 - 6, var1.func_20163_a("options.language")));
      this.field_949_e.add(new GuiButton(200, this.field_951_c / 2 - 100, this.field_950_d / 6 + 168, var1.func_20163_a("gui.done")));
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f < 100 && p_572_1_ instanceof GuiSmallButton) {
            this.field_995_i.func_1045_b(((GuiSmallButton)p_572_1_).func_20078_a(), 1);
            p_572_1_.field_939_e = this.field_995_i.func_1043_a(EnumOptions.func_20137_a(p_572_1_.field_938_f));
         }

         if(p_572_1_.field_938_f == 101) {
            this.field_945_b.field_6304_y.func_1041_b();
            this.field_945_b.func_6272_a(new GuiVideoSettings(this, this.field_995_i));
         }

         if(p_572_1_.field_938_f == 100) {
            this.field_945_b.field_6304_y.func_1041_b();
            this.field_945_b.func_6272_a(new GuiControls(this, this.field_995_i));
         }

         if(p_572_1_.field_938_f == 102) {
            this.field_945_b.field_6304_y.func_1041_b();
            this.field_945_b.func_6272_a(new GuiLanguage(this, this.field_995_i));
         }

         if(p_572_1_.field_938_f == 200) {
            this.field_945_b.field_6304_y.func_1041_b();
            this.field_945_b.func_6272_a(this.field_996_h);
         }

      }
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, this.field_994_a, this.field_951_c / 2, 20, 16777215);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

}
