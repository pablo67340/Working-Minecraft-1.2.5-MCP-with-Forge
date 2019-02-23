package net.minecraft.src;

import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.WorldInfo;
import org.lwjgl.input.Keyboard;

public class GuiRenameWorld extends GuiScreen {

   private GuiScreen field_22112_a;
   private GuiTextField field_22114_h;
   private final String field_22113_i;


   public GuiRenameWorld(GuiScreen p_i756_1_, String p_i756_2_) {
      this.field_22112_a = p_i756_1_;
      this.field_22113_i = p_i756_2_;
   }

   public void func_570_g() {
      this.field_22114_h.func_22070_b();
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      Keyboard.enableRepeatEvents(true);
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 96 + 12, var1.func_20163_a("selectWorld.renameButton")));
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120 + 12, var1.func_20163_a("gui.cancel")));
      ISaveFormat var2 = this.field_945_b.func_22004_c();
      WorldInfo var3 = var2.func_22173_b(this.field_22113_i);
      String var4 = var3.func_22302_j();
      this.field_22114_h = new GuiTextField(this.field_6451_g, this.field_951_c / 2 - 100, 60, 200, 20);
      this.field_22114_h.func_50033_b(true);
      this.field_22114_h.func_22068_a(var4);
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 1) {
            this.field_945_b.func_6272_a(this.field_22112_a);
         } else if(p_572_1_.field_938_f == 0) {
            ISaveFormat var2 = this.field_945_b.func_22004_c();
            var2.func_22170_a(this.field_22113_i, this.field_22114_h.func_22071_a().trim());
            this.field_945_b.func_6272_a(this.field_22112_a);
         }

      }
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      this.field_22114_h.func_50037_a(p_580_1_, p_580_2_);
      ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_22114_h.func_22071_a().trim().length() > 0;
      if(p_580_1_ == 13) {
         this.func_572_a((GuiButton)this.field_949_e.get(0));
      }

   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      this.field_22114_h.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_578_i();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("selectWorld.renameTitle"), this.field_951_c / 2, this.field_950_d / 4 - 60 + 20, 16777215);
      this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.enterName"), this.field_951_c / 2 - 100, 47, 10526880);
      this.field_22114_h.func_22067_c();
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
