package net.minecraft.src;

import net.minecraft.src.EnumOptions;
import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSlider;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.ScaledResolution;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;

public class GuiVideoSettings extends GuiScreen {

   private GuiScreen field_22110_h;
   protected String field_22107_a = "Video Settings";
   private GameSettings field_22109_i;
   private boolean field_40231_d = false;
   private static EnumOptions[] field_22108_k = new EnumOptions[]{EnumOptions.GRAPHICS, EnumOptions.RENDER_DISTANCE, EnumOptions.AMBIENT_OCCLUSION, EnumOptions.FRAMERATE_LIMIT, EnumOptions.ANAGLYPH, EnumOptions.VIEW_BOBBING, EnumOptions.GUI_SCALE, EnumOptions.ADVANCED_OPENGL, EnumOptions.GAMMA, EnumOptions.RENDER_CLOUDS, EnumOptions.PARTICLES};


   public GuiVideoSettings(GuiScreen p_i404_1_, GameSettings p_i404_2_) {
      this.field_22110_h = p_i404_1_;
      this.field_22109_i = p_i404_2_;
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_22107_a = var1.func_20163_a("options.videoTitle");
      int var2 = 0;
      EnumOptions[] var3 = field_22108_k;
      int var4 = var3.length;

      int var5;
      for(var5 = 0; var5 < var4; ++var5) {
         EnumOptions var6 = var3[var5];
         if(!var6.func_20136_a()) {
            this.field_949_e.add(new GuiSmallButton(var6.func_20135_c(), this.field_951_c / 2 - 155 + var2 % 2 * 160, this.field_950_d / 6 + 24 * (var2 >> 1), var6, this.field_22109_i.func_1043_a(var6)));
         } else {
            this.field_949_e.add(new GuiSlider(var6.func_20135_c(), this.field_951_c / 2 - 155 + var2 % 2 * 160, this.field_950_d / 6 + 24 * (var2 >> 1), var6, this.field_22109_i.func_1043_a(var6), this.field_22109_i.func_20104_a(var6)));
         }

         ++var2;
      }

      this.field_949_e.add(new GuiButton(200, this.field_951_c / 2 - 100, this.field_950_d / 6 + 168, var1.func_20163_a("gui.done")));
      this.field_40231_d = false;
      String[] var9 = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};
      String[] var10 = var9;
      var5 = var9.length;

      for(int var11 = 0; var11 < var5; ++var11) {
         String var7 = var10[var11];
         String var8 = System.getProperty(var7);
         if(var8 != null && var8.indexOf("64") >= 0) {
            this.field_40231_d = true;
            break;
         }
      }

   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         int var2 = this.field_22109_i.field_25148_H;
         if(p_572_1_.field_938_f < 100 && p_572_1_ instanceof GuiSmallButton) {
            this.field_22109_i.func_1045_b(((GuiSmallButton)p_572_1_).func_20078_a(), 1);
            p_572_1_.field_939_e = this.field_22109_i.func_1043_a(EnumOptions.func_20137_a(p_572_1_.field_938_f));
         }

         if(p_572_1_.field_938_f == 200) {
            this.field_945_b.field_6304_y.func_1041_b();
            this.field_945_b.func_6272_a(this.field_22110_h);
         }

         if(this.field_22109_i.field_25148_H != var2) {
            ScaledResolution var3 = new ScaledResolution(this.field_945_b.field_6304_y, this.field_945_b.field_6326_c, this.field_945_b.field_6325_d);
            int var4 = var3.func_903_a();
            int var5 = var3.func_902_b();
            this.func_6447_a(this.field_945_b, var4, var5);
         }

      }
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, this.field_22107_a, this.field_951_c / 2, 20, 16777215);
      if(!this.field_40231_d && this.field_22109_i.field_1580_e == 0) {
         this.func_548_a(this.field_6451_g, StatCollector.func_25200_a("options.farWarning1"), this.field_951_c / 2, this.field_950_d / 6 + 144, 11468800);
         this.func_548_a(this.field_6451_g, StatCollector.func_25200_a("options.farWarning2"), this.field_951_c / 2, this.field_950_d / 6 + 144 + 12, 11468800);
      }

      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

}
