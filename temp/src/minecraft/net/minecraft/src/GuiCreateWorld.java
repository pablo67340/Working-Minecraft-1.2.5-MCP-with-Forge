package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.MathHelper;
import net.minecraft.src.PlayerControllerCreative;
import net.minecraft.src.PlayerControllerSP;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;
import org.lwjgl.input.Keyboard;

public class GuiCreateWorld extends GuiScreen {

   private GuiScreen field_22131_a;
   private GuiTextField field_22134_h;
   private GuiTextField field_22133_i;
   private String field_22132_k;
   private String field_35364_f = "survival";
   private boolean field_35365_g = true;
   private boolean field_40232_h = false;
   private boolean field_22130_l;
   private boolean field_35368_i;
   private GuiButton field_35366_j;
   private GuiButton field_35367_k;
   private GuiButton field_35372_s;
   private GuiButton field_35371_t;
   private String field_35370_u;
   private String field_35369_v;
   private String field_41048_x;
   private String field_41047_y;
   private int field_46030_z = 0;


   public GuiCreateWorld(GuiScreen p_i680_1_) {
      this.field_22131_a = p_i680_1_;
      this.field_41048_x = "";
      this.field_41047_y = StatCollector.func_25200_a("selectWorld.newWorld");
   }

   public void func_570_g() {
      this.field_22134_h.func_22070_b();
      this.field_22133_i.func_22070_b();
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      Keyboard.enableRepeatEvents(true);
      this.field_949_e.clear();
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 155, this.field_950_d - 28, 150, 20, var1.func_20163_a("selectWorld.create")));
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 + 5, this.field_950_d - 28, 150, 20, var1.func_20163_a("gui.cancel")));
      this.field_949_e.add(this.field_35366_j = new GuiButton(2, this.field_951_c / 2 - 75, 100, 150, 20, var1.func_20163_a("selectWorld.gameMode")));
      this.field_949_e.add(this.field_35367_k = new GuiButton(3, this.field_951_c / 2 - 75, 172, 150, 20, var1.func_20163_a("selectWorld.moreWorldOptions")));
      this.field_949_e.add(this.field_35372_s = new GuiButton(4, this.field_951_c / 2 - 155, 100, 150, 20, var1.func_20163_a("selectWorld.mapFeatures")));
      this.field_35372_s.field_936_h = false;
      this.field_949_e.add(this.field_35371_t = new GuiButton(5, this.field_951_c / 2 + 5, 100, 150, 20, var1.func_20163_a("selectWorld.mapType")));
      this.field_35371_t.field_936_h = false;
      this.field_22134_h = new GuiTextField(this.field_6451_g, this.field_951_c / 2 - 100, 60, 200, 20);
      this.field_22134_h.func_50033_b(true);
      this.field_22134_h.func_22068_a(this.field_41047_y);
      this.field_22133_i = new GuiTextField(this.field_6451_g, this.field_951_c / 2 - 100, 60, 200, 20);
      this.field_22133_i.func_22068_a(this.field_41048_x);
      this.func_22129_j();
      this.func_35363_g();
   }

   private void func_22129_j() {
      this.field_22132_k = this.field_22134_h.func_22071_a().trim();
      char[] var1 = ChatAllowedCharacters.field_22286_b;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1[var3];
         this.field_22132_k = this.field_22132_k.replace(var4, '_');
      }

      if(MathHelper.func_22282_a(this.field_22132_k)) {
         this.field_22132_k = "World";
      }

      this.field_22132_k = func_25097_a(this.field_945_b.func_22004_c(), this.field_22132_k);
   }

   private void func_35363_g() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_35366_j.field_939_e = var1.func_20163_a("selectWorld.gameMode") + " " + var1.func_20163_a("selectWorld.gameMode." + this.field_35364_f);
      this.field_35370_u = var1.func_20163_a("selectWorld.gameMode." + this.field_35364_f + ".line1");
      this.field_35369_v = var1.func_20163_a("selectWorld.gameMode." + this.field_35364_f + ".line2");
      this.field_35372_s.field_939_e = var1.func_20163_a("selectWorld.mapFeatures") + " ";
      if(this.field_35365_g) {
         this.field_35372_s.field_939_e = this.field_35372_s.field_939_e + var1.func_20163_a("options.on");
      } else {
         this.field_35372_s.field_939_e = this.field_35372_s.field_939_e + var1.func_20163_a("options.off");
      }

      this.field_35371_t.field_939_e = var1.func_20163_a("selectWorld.mapType") + " " + var1.func_20163_a(WorldType.field_48637_a[this.field_46030_z].func_46136_a());
   }

   public static String func_25097_a(ISaveFormat p_25097_0_, String p_25097_1_) {
      for(p_25097_1_ = p_25097_1_.replaceAll("[\\./\"]|COM", "_"); p_25097_0_.func_22173_b(p_25097_1_) != null; p_25097_1_ = p_25097_1_ + "-") {
         ;
      }

      return p_25097_1_;
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 1) {
            this.field_945_b.func_6272_a(this.field_22131_a);
         } else if(p_572_1_.field_938_f == 0) {
            this.field_945_b.func_6272_a((GuiScreen)null);
            if(this.field_22130_l) {
               return;
            }

            this.field_22130_l = true;
            long var2 = (new Random()).nextLong();
            String var4 = this.field_22133_i.func_22071_a();
            if(!MathHelper.func_22282_a(var4)) {
               try {
                  long var5 = Long.parseLong(var4);
                  if(var5 != 0L) {
                     var2 = var5;
                  }
               } catch (NumberFormatException var7) {
                  var2 = (long)var4.hashCode();
               }
            }

            byte var9 = 0;
            if(this.field_35364_f.equals("creative")) {
               var9 = 1;
               this.field_945_b.field_6327_b = new PlayerControllerCreative(this.field_945_b);
            } else {
               this.field_945_b.field_6327_b = new PlayerControllerSP(this.field_945_b);
            }

            this.field_945_b.func_6247_b(this.field_22132_k, this.field_22134_h.func_22071_a(), new WorldSettings(var2, var9, this.field_35365_g, this.field_40232_h, WorldType.field_48637_a[this.field_46030_z]));
            this.field_945_b.func_6272_a((GuiScreen)null);
         } else if(p_572_1_.field_938_f == 3) {
            this.field_35368_i = !this.field_35368_i;
            this.field_35366_j.field_936_h = !this.field_35368_i;
            this.field_35372_s.field_936_h = this.field_35368_i;
            this.field_35371_t.field_936_h = this.field_35368_i;
            StringTranslate var8;
            if(this.field_35368_i) {
               var8 = StringTranslate.func_20162_a();
               this.field_35367_k.field_939_e = var8.func_20163_a("gui.done");
            } else {
               var8 = StringTranslate.func_20162_a();
               this.field_35367_k.field_939_e = var8.func_20163_a("selectWorld.moreWorldOptions");
            }
         } else if(p_572_1_.field_938_f == 2) {
            if(this.field_35364_f.equals("survival")) {
               this.field_40232_h = false;
               this.field_35364_f = "hardcore";
               this.field_40232_h = true;
               this.func_35363_g();
            } else if(this.field_35364_f.equals("hardcore")) {
               this.field_40232_h = false;
               this.field_35364_f = "creative";
               this.func_35363_g();
               this.field_40232_h = false;
            } else {
               this.field_35364_f = "survival";
               this.func_35363_g();
               this.field_40232_h = false;
            }

            this.func_35363_g();
         } else if(p_572_1_.field_938_f == 4) {
            this.field_35365_g = !this.field_35365_g;
            this.func_35363_g();
         } else if(p_572_1_.field_938_f == 5) {
            ++this.field_46030_z;
            if(this.field_46030_z >= WorldType.field_48637_a.length) {
               this.field_46030_z = 0;
            }

            while(WorldType.field_48637_a[this.field_46030_z] == null || !WorldType.field_48637_a[this.field_46030_z].func_48627_d()) {
               ++this.field_46030_z;
               if(this.field_46030_z >= WorldType.field_48637_a.length) {
                  this.field_46030_z = 0;
               }
            }

            this.func_35363_g();
         }

      }
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(this.field_22134_h.func_50025_j() && !this.field_35368_i) {
         this.field_22134_h.func_50037_a(p_580_1_, p_580_2_);
         this.field_41047_y = this.field_22134_h.func_22071_a();
      } else if(this.field_22133_i.func_50025_j() && this.field_35368_i) {
         this.field_22133_i.func_50037_a(p_580_1_, p_580_2_);
         this.field_41048_x = this.field_22133_i.func_22071_a();
      }

      if(p_580_1_ == 13) {
         this.func_572_a((GuiButton)this.field_949_e.get(0));
      }

      ((GuiButton)this.field_949_e.get(0)).field_937_g = this.field_22134_h.func_22071_a().length() > 0;
      this.func_22129_j();
   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      if(!this.field_35368_i) {
         this.field_22134_h.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
      } else {
         this.field_22133_i.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_578_i();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("selectWorld.create"), this.field_951_c / 2, 20, 16777215);
      if(!this.field_35368_i) {
         this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.enterName"), this.field_951_c / 2 - 100, 47, 10526880);
         this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.resultFolder") + " " + this.field_22132_k, this.field_951_c / 2 - 100, 85, 10526880);
         this.field_22134_h.func_22067_c();
         this.func_547_b(this.field_6451_g, this.field_35370_u, this.field_951_c / 2 - 100, 122, 10526880);
         this.func_547_b(this.field_6451_g, this.field_35369_v, this.field_951_c / 2 - 100, 134, 10526880);
      } else {
         this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.enterSeed"), this.field_951_c / 2 - 100, 47, 10526880);
         this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.seedInfo"), this.field_951_c / 2 - 100, 85, 10526880);
         this.func_547_b(this.field_6451_g, var4.func_20163_a("selectWorld.mapFeatures.info"), this.field_951_c / 2 - 150, 122, 10526880);
         this.field_22133_i.func_22067_c();
      }

      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
