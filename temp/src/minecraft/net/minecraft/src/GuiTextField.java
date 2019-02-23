package net.minecraft.src;

import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Tessellator;
import org.lwjgl.opengl.GL11;

public class GuiTextField extends Gui {

   private final FontRenderer field_22080_c;
   private final int field_22079_d;
   private final int field_22078_e;
   private final int field_22077_f;
   private final int field_22076_g;
   private String field_22075_h = "";
   private int field_22074_i = 32;
   private int field_22073_k;
   private boolean field_50044_j = true;
   private boolean field_50045_k = true;
   private boolean field_22082_a = false;
   private boolean field_50043_m = true;
   private int field_50041_n = 0;
   private int field_50042_o = 0;
   private int field_50048_p = 0;
   private int field_50047_q = 14737632;
   private int field_50046_r = 7368816;


   public GuiTextField(FontRenderer p_i1201_1_, int p_i1201_2_, int p_i1201_3_, int p_i1201_4_, int p_i1201_5_) {
      this.field_22080_c = p_i1201_1_;
      this.field_22079_d = p_i1201_2_;
      this.field_22078_e = p_i1201_3_;
      this.field_22077_f = p_i1201_4_;
      this.field_22076_g = p_i1201_5_;
   }

   public void func_22070_b() {
      ++this.field_22073_k;
   }

   public void func_22068_a(String p_22068_1_) {
      if(p_22068_1_.length() > this.field_22074_i) {
         this.field_22075_h = p_22068_1_.substring(0, this.field_22074_i);
      } else {
         this.field_22075_h = p_22068_1_;
      }

      this.func_50038_e();
   }

   public String func_22071_a() {
      return this.field_22075_h;
   }

   public String func_50039_c() {
      int var1 = this.field_50042_o < this.field_50048_p?this.field_50042_o:this.field_50048_p;
      int var2 = this.field_50042_o < this.field_50048_p?this.field_50048_p:this.field_50042_o;
      return this.field_22075_h.substring(var1, var2);
   }

   public void func_50031_b(String p_50031_1_) {
      String var2 = "";
      String var3 = ChatAllowedCharacters.func_52019_a(p_50031_1_);
      int var4 = this.field_50042_o < this.field_50048_p?this.field_50042_o:this.field_50048_p;
      int var5 = this.field_50042_o < this.field_50048_p?this.field_50048_p:this.field_50042_o;
      int var6 = this.field_22074_i - this.field_22075_h.length() - (var4 - this.field_50048_p);
      boolean var7 = false;
      if(this.field_22075_h.length() > 0) {
         var2 = var2 + this.field_22075_h.substring(0, var4);
      }

      int var8;
      if(var6 < var3.length()) {
         var2 = var2 + var3.substring(0, var6);
         var8 = var6;
      } else {
         var2 = var2 + var3;
         var8 = var3.length();
      }

      if(this.field_22075_h.length() > 0 && var5 < this.field_22075_h.length()) {
         var2 = var2 + this.field_22075_h.substring(var5);
      }

      this.field_22075_h = var2;
      this.func_50023_d(var4 - this.field_50048_p + var8);
   }

   public void func_50021_a(int p_50021_1_) {
      if(this.field_22075_h.length() != 0) {
         if(this.field_50048_p != this.field_50042_o) {
            this.func_50031_b("");
         } else {
            this.func_50020_b(this.func_50028_c(p_50021_1_) - this.field_50042_o);
         }
      }
   }

   public void func_50020_b(int p_50020_1_) {
      if(this.field_22075_h.length() != 0) {
         if(this.field_50048_p != this.field_50042_o) {
            this.func_50031_b("");
         } else {
            boolean var2 = p_50020_1_ < 0;
            int var3 = var2?this.field_50042_o + p_50020_1_:this.field_50042_o;
            int var4 = var2?this.field_50042_o:this.field_50042_o + p_50020_1_;
            String var5 = "";
            if(var3 >= 0) {
               var5 = this.field_22075_h.substring(0, var3);
            }

            if(var4 < this.field_22075_h.length()) {
               var5 = var5 + this.field_22075_h.substring(var4);
            }

            this.field_22075_h = var5;
            if(var2) {
               this.func_50023_d(p_50020_1_);
            }

         }
      }
   }

   public int func_50028_c(int p_50028_1_) {
      return this.func_50024_a(p_50028_1_, this.func_50035_h());
   }

   public int func_50024_a(int p_50024_1_, int p_50024_2_) {
      int var3 = p_50024_2_;
      boolean var4 = p_50024_1_ < 0;
      int var5 = Math.abs(p_50024_1_);

      for(int var6 = 0; var6 < var5; ++var6) {
         if(var4) {
            while(var3 > 0 && this.field_22075_h.charAt(var3 - 1) == 32) {
               --var3;
            }

            while(var3 > 0 && this.field_22075_h.charAt(var3 - 1) != 32) {
               --var3;
            }
         } else {
            int var7 = this.field_22075_h.length();
            var3 = this.field_22075_h.indexOf(32, var3);
            if(var3 == -1) {
               var3 = var7;
            } else {
               while(var3 < var7 && this.field_22075_h.charAt(var3) == 32) {
                  ++var3;
               }
            }
         }
      }

      return var3;
   }

   public void func_50023_d(int p_50023_1_) {
      this.func_50030_e(this.field_50048_p + p_50023_1_);
   }

   public void func_50030_e(int p_50030_1_) {
      this.field_50042_o = p_50030_1_;
      int var2 = this.field_22075_h.length();
      if(this.field_50042_o < 0) {
         this.field_50042_o = 0;
      }

      if(this.field_50042_o > var2) {
         this.field_50042_o = var2;
      }

      this.func_50032_g(this.field_50042_o);
   }

   public void func_50034_d() {
      this.func_50030_e(0);
   }

   public void func_50038_e() {
      this.func_50030_e(this.field_22075_h.length());
   }

   public boolean func_50037_a(char p_50037_1_, int p_50037_2_) {
      if(this.field_50043_m && this.field_22082_a) {
         switch(p_50037_1_) {
         case 1:
            this.func_50038_e();
            this.func_50032_g(0);
            return true;
         case 3:
            GuiScreen.func_50050_a(this.func_50039_c());
            return true;
         case 22:
            this.func_50031_b(GuiScreen.func_574_c());
            return true;
         case 24:
            GuiScreen.func_50050_a(this.func_50039_c());
            this.func_50031_b("");
            return true;
         default:
            switch(p_50037_2_) {
            case 14:
               if(GuiScreen.func_50051_l()) {
                  this.func_50021_a(-1);
               } else {
                  this.func_50020_b(-1);
               }

               return true;
            case 199:
               if(GuiScreen.func_50049_m()) {
                  this.func_50032_g(0);
               } else {
                  this.func_50034_d();
               }

               return true;
            case 203:
               if(GuiScreen.func_50049_m()) {
                  if(GuiScreen.func_50051_l()) {
                     this.func_50032_g(this.func_50024_a(-1, this.func_50036_k()));
                  } else {
                     this.func_50032_g(this.func_50036_k() - 1);
                  }
               } else if(GuiScreen.func_50051_l()) {
                  this.func_50030_e(this.func_50028_c(-1));
               } else {
                  this.func_50023_d(-1);
               }

               return true;
            case 205:
               if(GuiScreen.func_50049_m()) {
                  if(GuiScreen.func_50051_l()) {
                     this.func_50032_g(this.func_50024_a(1, this.func_50036_k()));
                  } else {
                     this.func_50032_g(this.func_50036_k() + 1);
                  }
               } else if(GuiScreen.func_50051_l()) {
                  this.func_50030_e(this.func_50028_c(1));
               } else {
                  this.func_50023_d(1);
               }

               return true;
            case 207:
               if(GuiScreen.func_50049_m()) {
                  this.func_50032_g(this.field_22075_h.length());
               } else {
                  this.func_50038_e();
               }

               return true;
            case 211:
               if(GuiScreen.func_50051_l()) {
                  this.func_50021_a(1);
               } else {
                  this.func_50020_b(1);
               }

               return true;
            default:
               if(ChatAllowedCharacters.func_48614_a(p_50037_1_)) {
                  this.func_50031_b(Character.toString(p_50037_1_));
                  return true;
               } else {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   public void func_22069_a(int p_22069_1_, int p_22069_2_, int p_22069_3_) {
      boolean var4 = p_22069_1_ >= this.field_22079_d && p_22069_1_ < this.field_22079_d + this.field_22077_f && p_22069_2_ >= this.field_22078_e && p_22069_2_ < this.field_22078_e + this.field_22076_g;
      if(this.field_50045_k) {
         this.func_50033_b(this.field_50043_m && var4);
      }

      if(this.field_22082_a && p_22069_3_ == 0) {
         int var5 = p_22069_1_ - this.field_22079_d;
         if(this.field_50044_j) {
            var5 -= 4;
         }

         String var6 = this.field_22080_c.func_50107_a(this.field_22075_h.substring(this.field_50041_n), this.func_50019_l());
         this.func_50030_e(this.field_22080_c.func_50107_a(var6, var5).length() + this.field_50041_n);
      }

   }

   public void func_22067_c() {
      if(this.func_50022_i()) {
         func_551_a(this.field_22079_d - 1, this.field_22078_e - 1, this.field_22079_d + this.field_22077_f + 1, this.field_22078_e + this.field_22076_g + 1, -6250336);
         func_551_a(this.field_22079_d, this.field_22078_e, this.field_22079_d + this.field_22077_f, this.field_22078_e + this.field_22076_g, -16777216);
      }

      int var1 = this.field_50043_m?this.field_50047_q:this.field_50046_r;
      int var2 = this.field_50042_o - this.field_50041_n;
      int var3 = this.field_50048_p - this.field_50041_n;
      String var4 = this.field_22080_c.func_50107_a(this.field_22075_h.substring(this.field_50041_n), this.func_50019_l());
      boolean var5 = var2 >= 0 && var2 <= var4.length();
      boolean var6 = this.field_22082_a && this.field_22073_k / 6 % 2 == 0 && var5;
      int var7 = this.field_50044_j?this.field_22079_d + 4:this.field_22079_d;
      int var8 = this.field_50044_j?this.field_22078_e + (this.field_22076_g - 8) / 2:this.field_22078_e;
      int var9 = var7;
      if(var3 > var4.length()) {
         var3 = var4.length();
      }

      if(var4.length() > 0) {
         String var10 = var5?var4.substring(0, var2):var4;
         var9 = this.field_22080_c.func_50103_a(var10, var7, var8, var1);
      }

      boolean var13 = this.field_50042_o < this.field_22075_h.length() || this.field_22075_h.length() >= this.func_50040_g();
      int var11 = var9;
      if(!var5) {
         var11 = var2 > 0?var7 + this.field_22077_f:var7;
      } else if(var13) {
         var11 = var9 - 1;
         --var9;
      }

      if(var4.length() > 0 && var5 && var2 < var4.length()) {
         this.field_22080_c.func_50103_a(var4.substring(var2), var9, var8, var1);
      }

      if(var6) {
         if(var13) {
            Gui.func_551_a(var11, var8 - 1, var11 + 1, var8 + 1 + this.field_22080_c.field_41063_b, -3092272);
         } else {
            this.field_22080_c.func_50103_a("_", var11, var8, var1);
         }
      }

      if(var3 != var2) {
         int var12 = var7 + this.field_22080_c.func_871_a(var4.substring(0, var3));
         this.func_50029_c(var11, var8 - 1, var12 - 1, var8 + 1 + this.field_22080_c.field_41063_b);
      }

   }

   private void func_50029_c(int p_50029_1_, int p_50029_2_, int p_50029_3_, int p_50029_4_) {
      int var5;
      if(p_50029_1_ < p_50029_3_) {
         var5 = p_50029_1_;
         p_50029_1_ = p_50029_3_;
         p_50029_3_ = var5;
      }

      if(p_50029_2_ < p_50029_4_) {
         var5 = p_50029_2_;
         p_50029_2_ = p_50029_4_;
         p_50029_4_ = var5;
      }

      Tessellator var6 = Tessellator.field_1512_a;
      GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
      GL11.glDisable(3553);
      GL11.glEnable(3058);
      GL11.glLogicOp(5387);
      var6.func_977_b();
      var6.func_991_a((double)p_50029_1_, (double)p_50029_4_, 0.0D);
      var6.func_991_a((double)p_50029_3_, (double)p_50029_4_, 0.0D);
      var6.func_991_a((double)p_50029_3_, (double)p_50029_2_, 0.0D);
      var6.func_991_a((double)p_50029_1_, (double)p_50029_2_, 0.0D);
      var6.func_982_a();
      GL11.glDisable(3058);
      GL11.glEnable(3553);
   }

   public void func_22066_a(int p_22066_1_) {
      this.field_22074_i = p_22066_1_;
      if(this.field_22075_h.length() > p_22066_1_) {
         this.field_22075_h = this.field_22075_h.substring(0, p_22066_1_);
      }

   }

   public int func_50040_g() {
      return this.field_22074_i;
   }

   public int func_50035_h() {
      return this.field_50042_o;
   }

   public boolean func_50022_i() {
      return this.field_50044_j;
   }

   public void func_50027_a(boolean p_50027_1_) {
      this.field_50044_j = p_50027_1_;
   }

   public void func_50033_b(boolean p_50033_1_) {
      if(p_50033_1_ && !this.field_22082_a) {
         this.field_22073_k = 0;
      }

      this.field_22082_a = p_50033_1_;
   }

   public boolean func_50025_j() {
      return this.field_22082_a;
   }

   public int func_50036_k() {
      return this.field_50048_p;
   }

   public int func_50019_l() {
      return this.func_50022_i()?this.field_22077_f - 8:this.field_22077_f;
   }

   public void func_50032_g(int p_50032_1_) {
      int var2 = this.field_22075_h.length();
      if(p_50032_1_ > var2) {
         p_50032_1_ = var2;
      }

      if(p_50032_1_ < 0) {
         p_50032_1_ = 0;
      }

      this.field_50048_p = p_50032_1_;
      if(this.field_22080_c != null) {
         if(this.field_50041_n > var2) {
            this.field_50041_n = var2;
         }

         int var3 = this.func_50019_l();
         String var4 = this.field_22080_c.func_50107_a(this.field_22075_h.substring(this.field_50041_n), var3);
         int var5 = var4.length() + this.field_50041_n;
         if(p_50032_1_ == this.field_50041_n) {
            this.field_50041_n -= this.field_22080_c.func_50104_a(this.field_22075_h, var3, true).length();
         }

         if(p_50032_1_ > var5) {
            this.field_50041_n += p_50032_1_ - var5;
         } else if(p_50032_1_ <= this.field_50041_n) {
            this.field_50041_n -= this.field_50041_n - p_50032_1_;
         }

         if(this.field_50041_n < 0) {
            this.field_50041_n = 0;
         }

         if(this.field_50041_n > var2) {
            this.field_50041_n = var2;
         }
      }

   }

   public void func_50026_c(boolean p_50026_1_) {
      this.field_50045_k = p_50026_1_;
   }
}
