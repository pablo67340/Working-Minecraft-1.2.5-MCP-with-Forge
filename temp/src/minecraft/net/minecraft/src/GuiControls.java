package net.minecraft.src;

import net.minecraft.src.GameSettings;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.StringTranslate;

public class GuiControls extends GuiScreen {

   private GuiScreen field_957_h;
   protected String field_954_a = "Controls";
   private GameSettings field_956_i;
   private int field_955_j = -1;


   public GuiControls(GuiScreen p_i507_1_, GameSettings p_i507_2_) {
      this.field_957_h = p_i507_1_;
      this.field_956_i = p_i507_2_;
   }

   private int func_20080_j() {
      return this.field_951_c / 2 - 155;
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      int var2 = this.func_20080_j();

      for(int var3 = 0; var3 < this.field_956_i.field_1564_t.length; ++var3) {
         this.field_949_e.add(new GuiSmallButton(var3, var2 + var3 % 2 * 160, this.field_950_d / 6 + 24 * (var3 >> 1), 70, 20, this.field_956_i.func_1047_d(var3)));
      }

      this.field_949_e.add(new GuiButton(200, this.field_951_c / 2 - 100, this.field_950_d / 6 + 168, var1.func_20163_a("gui.done")));
      this.field_954_a = var1.func_20163_a("controls.title");
   }

   protected void func_572_a(GuiButton p_572_1_) {
      for(int var2 = 0; var2 < this.field_956_i.field_1564_t.length; ++var2) {
         ((GuiButton)this.field_949_e.get(var2)).field_939_e = this.field_956_i.func_1047_d(var2);
      }

      if(p_572_1_.field_938_f == 200) {
         this.field_945_b.func_6272_a(this.field_957_h);
      } else {
         this.field_955_j = p_572_1_.field_938_f;
         p_572_1_.field_939_e = "> " + this.field_956_i.func_1047_d(p_572_1_.field_938_f) + " <";
      }

   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      if(this.field_955_j >= 0) {
         this.field_956_i.func_1042_a(this.field_955_j, -100 + p_565_3_);
         ((GuiButton)this.field_949_e.get(this.field_955_j)).field_939_e = this.field_956_i.func_1047_d(this.field_955_j);
         this.field_955_j = -1;
         KeyBinding.func_35961_b();
      } else {
         super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      }

   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(this.field_955_j >= 0) {
         this.field_956_i.func_1042_a(this.field_955_j, p_580_2_);
         ((GuiButton)this.field_949_e.get(this.field_955_j)).field_939_e = this.field_956_i.func_1047_d(this.field_955_j);
         this.field_955_j = -1;
         KeyBinding.func_35961_b();
      } else {
         super.func_580_a(p_580_1_, p_580_2_);
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, this.field_954_a, this.field_951_c / 2, 20, 16777215);
      int var4 = this.func_20080_j();
      int var5 = 0;

      while(var5 < this.field_956_i.field_1564_t.length) {
         boolean var6 = false;
         int var7 = 0;

         while(true) {
            if(var7 < this.field_956_i.field_1564_t.length) {
               if(var7 == var5 || this.field_956_i.field_1564_t[var5].field_1370_b != this.field_956_i.field_1564_t[var7].field_1370_b) {
                  ++var7;
                  continue;
               }

               var6 = true;
            }

            if(this.field_955_j == var5) {
               ((GuiButton)this.field_949_e.get(var5)).field_939_e = "\u00a7f> \u00a7e??? \u00a7f<";
            } else if(var6) {
               ((GuiButton)this.field_949_e.get(var5)).field_939_e = "\u00a7c" + this.field_956_i.func_1047_d(var5);
            } else {
               ((GuiButton)this.field_949_e.get(var5)).field_939_e = this.field_956_i.func_1047_d(var5);
            }

            this.func_547_b(this.field_6451_g, this.field_956_i.func_20102_a(var5), var4 + var5 % 2 * 160 + 70 + 6, this.field_950_d / 6 + 24 * (var5 >> 1) + 7, -1);
            ++var5;
            break;
         }
      }

      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
