package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import net.minecraft.src.EnumOptions;
import net.minecraft.src.EnumOptionsMappingHelper;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;
import org.lwjgl.input.Keyboard;

public class GameSettings {

   private static final String[] field_20105_z = new String[]{"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
   private static final String[] field_20106_A = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
   private static final String[] field_25147_K = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
   private static final String[] field_41086_T = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
   private static final String[] field_30006_M = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
   public float field_1584_a = 1.0F;
   public float field_1583_b = 1.0F;
   public float field_1582_c = 0.5F;
   public boolean field_1581_d = false;
   public int field_1580_e = 0;
   public boolean field_1579_f = true;
   public boolean field_1578_g = false;
   public boolean field_27342_h = false;
   public int field_1577_h = 1;
   public boolean field_1576_i = true;
   public boolean field_22278_j = true;
   public boolean field_40445_l = true;
   public String field_6524_j = "Default";
   public KeyBinding field_1575_j = new KeyBinding("key.forward", 17);
   public KeyBinding field_1574_k = new KeyBinding("key.left", 30);
   public KeyBinding field_1573_l = new KeyBinding("key.back", 31);
   public KeyBinding field_1572_m = new KeyBinding("key.right", 32);
   public KeyBinding field_1571_n = new KeyBinding("key.jump", 57);
   public KeyBinding field_1570_o = new KeyBinding("key.inventory", 18);
   public KeyBinding field_6523_q = new KeyBinding("key.drop", 16);
   public KeyBinding field_6521_r = new KeyBinding("key.chat", 20);
   public KeyBinding field_1565_s = new KeyBinding("key.sneak", 42);
   public KeyBinding field_35382_v = new KeyBinding("key.attack", -100);
   public KeyBinding field_35381_w = new KeyBinding("key.use", -99);
   public KeyBinding field_35384_x = new KeyBinding("key.playerlist", 15);
   public KeyBinding field_35383_y = new KeyBinding("key.pickItem", -98);
   public KeyBinding[] field_1564_t;
   protected Minecraft field_1563_u;
   private File field_6522_B;
   public int field_1561_w;
   public boolean field_22277_y;
   public int field_1560_x;
   public boolean field_22276_A;
   public boolean field_50119_G;
   public String field_12259_z;
   public boolean field_22275_C;
   public boolean field_22274_D;
   public boolean field_22273_E;
   public float field_22272_F;
   public float field_22271_G;
   public float field_35379_L;
   public float field_35380_M;
   public int field_25148_H;
   public int field_41087_P;
   public String field_44018_Q;


   public GameSettings(Minecraft p_i365_1_, File p_i365_2_) {
      this.field_1564_t = new KeyBinding[]{this.field_35382_v, this.field_35381_w, this.field_1575_j, this.field_1574_k, this.field_1573_l, this.field_1572_m, this.field_1571_n, this.field_1565_s, this.field_6523_q, this.field_1570_o, this.field_6521_r, this.field_35384_x, this.field_35383_y};
      this.field_1561_w = 2;
      this.field_22277_y = false;
      this.field_1560_x = 0;
      this.field_22276_A = false;
      this.field_50119_G = false;
      this.field_12259_z = "";
      this.field_22275_C = false;
      this.field_22274_D = false;
      this.field_22273_E = false;
      this.field_22272_F = 1.0F;
      this.field_22271_G = 1.0F;
      this.field_35379_L = 0.0F;
      this.field_35380_M = 0.0F;
      this.field_25148_H = 0;
      this.field_41087_P = 0;
      this.field_44018_Q = "en_US";
      this.field_1563_u = p_i365_1_;
      this.field_6522_B = new File(p_i365_2_, "options.txt");
      this.func_6519_a();
   }

   public GameSettings() {
      this.field_1564_t = new KeyBinding[]{this.field_35382_v, this.field_35381_w, this.field_1575_j, this.field_1574_k, this.field_1573_l, this.field_1572_m, this.field_1571_n, this.field_1565_s, this.field_6523_q, this.field_1570_o, this.field_6521_r, this.field_35384_x, this.field_35383_y};
      this.field_1561_w = 2;
      this.field_22277_y = false;
      this.field_1560_x = 0;
      this.field_22276_A = false;
      this.field_50119_G = false;
      this.field_12259_z = "";
      this.field_22275_C = false;
      this.field_22274_D = false;
      this.field_22273_E = false;
      this.field_22272_F = 1.0F;
      this.field_22271_G = 1.0F;
      this.field_35379_L = 0.0F;
      this.field_35380_M = 0.0F;
      this.field_25148_H = 0;
      this.field_41087_P = 0;
      this.field_44018_Q = "en_US";
   }

   public String func_20102_a(int p_20102_1_) {
      StringTranslate var2 = StringTranslate.func_20162_a();
      return var2.func_20163_a(this.field_1564_t[p_20102_1_].field_1371_a);
   }

   public String func_1047_d(int p_1047_1_) {
      int var2 = this.field_1564_t[p_1047_1_].field_1370_b;
      return func_41085_c(var2);
   }

   public static String func_41085_c(int p_41085_0_) {
      return p_41085_0_ < 0?StatCollector.func_25199_a("key.mouseButton", new Object[]{Integer.valueOf(p_41085_0_ + 101)}):Keyboard.getKeyName(p_41085_0_);
   }

   public void func_1042_a(int p_1042_1_, int p_1042_2_) {
      this.field_1564_t[p_1042_1_].field_1370_b = p_1042_2_;
      this.func_1041_b();
   }

   public void func_1048_a(EnumOptions p_1048_1_, float p_1048_2_) {
      if(p_1048_1_ == EnumOptions.MUSIC) {
         this.field_1584_a = p_1048_2_;
         this.field_1563_u.field_6301_A.func_335_a();
      }

      if(p_1048_1_ == EnumOptions.SOUND) {
         this.field_1583_b = p_1048_2_;
         this.field_1563_u.field_6301_A.func_335_a();
      }

      if(p_1048_1_ == EnumOptions.SENSITIVITY) {
         this.field_1582_c = p_1048_2_;
      }

      if(p_1048_1_ == EnumOptions.FOV) {
         this.field_35379_L = p_1048_2_;
      }

      if(p_1048_1_ == EnumOptions.GAMMA) {
         this.field_35380_M = p_1048_2_;
      }

   }

   public void func_1045_b(EnumOptions p_1045_1_, int p_1045_2_) {
      if(p_1045_1_ == EnumOptions.INVERT_MOUSE) {
         this.field_1581_d = !this.field_1581_d;
      }

      if(p_1045_1_ == EnumOptions.RENDER_DISTANCE) {
         this.field_1580_e = this.field_1580_e + p_1045_2_ & 3;
      }

      if(p_1045_1_ == EnumOptions.GUI_SCALE) {
         this.field_25148_H = this.field_25148_H + p_1045_2_ & 3;
      }

      if(p_1045_1_ == EnumOptions.PARTICLES) {
         this.field_41087_P = (this.field_41087_P + p_1045_2_) % 3;
      }

      if(p_1045_1_ == EnumOptions.VIEW_BOBBING) {
         this.field_1579_f = !this.field_1579_f;
      }

      if(p_1045_1_ == EnumOptions.RENDER_CLOUDS) {
         this.field_40445_l = !this.field_40445_l;
      }

      if(p_1045_1_ == EnumOptions.ADVANCED_OPENGL) {
         this.field_27342_h = !this.field_27342_h;
         this.field_1563_u.field_6323_f.func_958_a();
      }

      if(p_1045_1_ == EnumOptions.ANAGLYPH) {
         this.field_1578_g = !this.field_1578_g;
         this.field_1563_u.field_6315_n.func_1065_b();
      }

      if(p_1045_1_ == EnumOptions.FRAMERATE_LIMIT) {
         this.field_1577_h = (this.field_1577_h + p_1045_2_ + 3) % 3;
      }

      if(p_1045_1_ == EnumOptions.DIFFICULTY) {
         this.field_1561_w = this.field_1561_w + p_1045_2_ & 3;
      }

      if(p_1045_1_ == EnumOptions.GRAPHICS) {
         this.field_1576_i = !this.field_1576_i;
         this.field_1563_u.field_6323_f.func_958_a();
      }

      if(p_1045_1_ == EnumOptions.AMBIENT_OCCLUSION) {
         this.field_22278_j = !this.field_22278_j;
         this.field_1563_u.field_6323_f.func_958_a();
      }

      this.func_1041_b();
   }

   public float func_20104_a(EnumOptions p_20104_1_) {
      return p_20104_1_ == EnumOptions.FOV?this.field_35379_L:(p_20104_1_ == EnumOptions.GAMMA?this.field_35380_M:(p_20104_1_ == EnumOptions.MUSIC?this.field_1584_a:(p_20104_1_ == EnumOptions.SOUND?this.field_1583_b:(p_20104_1_ == EnumOptions.SENSITIVITY?this.field_1582_c:0.0F))));
   }

   public boolean func_20103_b(EnumOptions p_20103_1_) {
      switch(EnumOptionsMappingHelper.field_20155_a[p_20103_1_.ordinal()]) {
      case 1:
         return this.field_1581_d;
      case 2:
         return this.field_1579_f;
      case 3:
         return this.field_1578_g;
      case 4:
         return this.field_27342_h;
      case 5:
         return this.field_22278_j;
      case 6:
         return this.field_40445_l;
      default:
         return false;
      }
   }

   private static String func_48571_a(String[] p_48571_0_, int p_48571_1_) {
      if(p_48571_1_ < 0 || p_48571_1_ >= p_48571_0_.length) {
         p_48571_1_ = 0;
      }

      StringTranslate var2 = StringTranslate.func_20162_a();
      return var2.func_20163_a(p_48571_0_[p_48571_1_]);
   }

   public String func_1043_a(EnumOptions p_1043_1_) {
      StringTranslate var2 = StringTranslate.func_20162_a();
      String var3 = var2.func_20163_a(p_1043_1_.func_20138_d()) + ": ";
      if(p_1043_1_.func_20136_a()) {
         float var5 = this.func_20104_a(p_1043_1_);
         return p_1043_1_ == EnumOptions.SENSITIVITY?(var5 == 0.0F?var3 + var2.func_20163_a("options.sensitivity.min"):(var5 == 1.0F?var3 + var2.func_20163_a("options.sensitivity.max"):var3 + (int)(var5 * 200.0F) + "%")):(p_1043_1_ == EnumOptions.FOV?(var5 == 0.0F?var3 + var2.func_20163_a("options.fov.min"):(var5 == 1.0F?var3 + var2.func_20163_a("options.fov.max"):var3 + (int)(70.0F + var5 * 40.0F))):(p_1043_1_ == EnumOptions.GAMMA?(var5 == 0.0F?var3 + var2.func_20163_a("options.gamma.min"):(var5 == 1.0F?var3 + var2.func_20163_a("options.gamma.max"):var3 + "+" + (int)(var5 * 100.0F) + "%")):(var5 == 0.0F?var3 + var2.func_20163_a("options.off"):var3 + (int)(var5 * 100.0F) + "%")));
      } else if(p_1043_1_.func_20140_b()) {
         boolean var4 = this.func_20103_b(p_1043_1_);
         return var4?var3 + var2.func_20163_a("options.on"):var3 + var2.func_20163_a("options.off");
      } else {
         return p_1043_1_ == EnumOptions.RENDER_DISTANCE?var3 + func_48571_a(field_20105_z, this.field_1580_e):(p_1043_1_ == EnumOptions.DIFFICULTY?var3 + func_48571_a(field_20106_A, this.field_1561_w):(p_1043_1_ == EnumOptions.GUI_SCALE?var3 + func_48571_a(field_25147_K, this.field_25148_H):(p_1043_1_ == EnumOptions.PARTICLES?var3 + func_48571_a(field_41086_T, this.field_41087_P):(p_1043_1_ == EnumOptions.FRAMERATE_LIMIT?var3 + func_48571_a(field_30006_M, this.field_1577_h):(p_1043_1_ == EnumOptions.GRAPHICS?(this.field_1576_i?var3 + var2.func_20163_a("options.graphics.fancy"):var3 + var2.func_20163_a("options.graphics.fast")):var3)))));
      }
   }

   public void func_6519_a() {
      try {
         if(!this.field_6522_B.exists()) {
            return;
         }

         BufferedReader var1 = new BufferedReader(new FileReader(this.field_6522_B));
         String var2 = "";

         while((var2 = var1.readLine()) != null) {
            try {
               String[] var3 = var2.split(":");
               if(var3[0].equals("music")) {
                  this.field_1584_a = this.func_1050_a(var3[1]);
               }

               if(var3[0].equals("sound")) {
                  this.field_1583_b = this.func_1050_a(var3[1]);
               }

               if(var3[0].equals("mouseSensitivity")) {
                  this.field_1582_c = this.func_1050_a(var3[1]);
               }

               if(var3[0].equals("fov")) {
                  this.field_35379_L = this.func_1050_a(var3[1]);
               }

               if(var3[0].equals("gamma")) {
                  this.field_35380_M = this.func_1050_a(var3[1]);
               }

               if(var3[0].equals("invertYMouse")) {
                  this.field_1581_d = var3[1].equals("true");
               }

               if(var3[0].equals("viewDistance")) {
                  this.field_1580_e = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("guiScale")) {
                  this.field_25148_H = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("particles")) {
                  this.field_41087_P = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("bobView")) {
                  this.field_1579_f = var3[1].equals("true");
               }

               if(var3[0].equals("anaglyph3d")) {
                  this.field_1578_g = var3[1].equals("true");
               }

               if(var3[0].equals("advancedOpengl")) {
                  this.field_27342_h = var3[1].equals("true");
               }

               if(var3[0].equals("fpsLimit")) {
                  this.field_1577_h = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("difficulty")) {
                  this.field_1561_w = Integer.parseInt(var3[1]);
               }

               if(var3[0].equals("fancyGraphics")) {
                  this.field_1576_i = var3[1].equals("true");
               }

               if(var3[0].equals("ao")) {
                  this.field_22278_j = var3[1].equals("true");
               }

               if(var3[0].equals("clouds")) {
                  this.field_40445_l = var3[1].equals("true");
               }

               if(var3[0].equals("skin")) {
                  this.field_6524_j = var3[1];
               }

               if(var3[0].equals("lastServer") && var3.length >= 2) {
                  this.field_12259_z = var3[1];
               }

               if(var3[0].equals("lang") && var3.length >= 2) {
                  this.field_44018_Q = var3[1];
               }

               for(int var4 = 0; var4 < this.field_1564_t.length; ++var4) {
                  if(var3[0].equals("key_" + this.field_1564_t[var4].field_1371_a)) {
                     this.field_1564_t[var4].field_1370_b = Integer.parseInt(var3[1]);
                  }
               }
            } catch (Exception var5) {
               System.out.println("Skipping bad option: " + var2);
            }
         }

         KeyBinding.func_35961_b();
         var1.close();
      } catch (Exception var6) {
         System.out.println("Failed to load options");
         var6.printStackTrace();
      }

   }

   private float func_1050_a(String p_1050_1_) {
      return p_1050_1_.equals("true")?1.0F:(p_1050_1_.equals("false")?0.0F:Float.parseFloat(p_1050_1_));
   }

   public void func_1041_b() {
      try {
         PrintWriter var1 = new PrintWriter(new FileWriter(this.field_6522_B));
         var1.println("music:" + this.field_1584_a);
         var1.println("sound:" + this.field_1583_b);
         var1.println("invertYMouse:" + this.field_1581_d);
         var1.println("mouseSensitivity:" + this.field_1582_c);
         var1.println("fov:" + this.field_35379_L);
         var1.println("gamma:" + this.field_35380_M);
         var1.println("viewDistance:" + this.field_1580_e);
         var1.println("guiScale:" + this.field_25148_H);
         var1.println("particles:" + this.field_41087_P);
         var1.println("bobView:" + this.field_1579_f);
         var1.println("anaglyph3d:" + this.field_1578_g);
         var1.println("advancedOpengl:" + this.field_27342_h);
         var1.println("fpsLimit:" + this.field_1577_h);
         var1.println("difficulty:" + this.field_1561_w);
         var1.println("fancyGraphics:" + this.field_1576_i);
         var1.println("ao:" + this.field_22278_j);
         var1.println("clouds:" + this.field_40445_l);
         var1.println("skin:" + this.field_6524_j);
         var1.println("lastServer:" + this.field_12259_z);
         var1.println("lang:" + this.field_44018_Q);

         for(int var2 = 0; var2 < this.field_1564_t.length; ++var2) {
            var1.println("key_" + this.field_1564_t[var2].field_1371_a + ":" + this.field_1564_t[var2].field_1370_b);
         }

         var1.close();
      } catch (Exception var3) {
         System.out.println("Failed to save options");
         var3.printStackTrace();
      }

   }

   public boolean func_40444_c() {
      return this.field_1580_e < 2 && this.field_40445_l;
   }

}
