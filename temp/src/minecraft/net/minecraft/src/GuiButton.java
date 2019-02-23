package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.Gui;
import org.lwjgl.opengl.GL11;

public class GuiButton extends Gui {

   protected int field_52008_a;
   protected int field_52007_b;
   public int field_941_c;
   public int field_940_d;
   public String field_939_e;
   public int field_938_f;
   public boolean field_937_g;
   public boolean field_936_h;


   public GuiButton(int p_i771_1_, int p_i771_2_, int p_i771_3_, String p_i771_4_) {
      this(p_i771_1_, p_i771_2_, p_i771_3_, 200, 20, p_i771_4_);
   }

   public GuiButton(int p_i772_1_, int p_i772_2_, int p_i772_3_, int p_i772_4_, int p_i772_5_, String p_i772_6_) {
      this.field_52008_a = 200;
      this.field_52007_b = 20;
      this.field_937_g = true;
      this.field_936_h = true;
      this.field_938_f = p_i772_1_;
      this.field_941_c = p_i772_2_;
      this.field_940_d = p_i772_3_;
      this.field_52008_a = p_i772_4_;
      this.field_52007_b = p_i772_5_;
      this.field_939_e = p_i772_6_;
   }

   protected int func_558_a(boolean p_558_1_) {
      byte var2 = 1;
      if(!this.field_937_g) {
         var2 = 0;
      } else if(p_558_1_) {
         var2 = 2;
      }

      return var2;
   }

   public void func_561_a(Minecraft p_561_1_, int p_561_2_, int p_561_3_) {
      if(this.field_936_h) {
         FontRenderer var4 = p_561_1_.field_6314_o;
         GL11.glBindTexture(3553, p_561_1_.field_6315_n.func_1070_a("/gui/gui.png"));
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         boolean var5 = p_561_2_ >= this.field_941_c && p_561_3_ >= this.field_940_d && p_561_2_ < this.field_941_c + this.field_52008_a && p_561_3_ < this.field_940_d + this.field_52007_b;
         int var6 = this.func_558_a(var5);
         this.func_550_b(this.field_941_c, this.field_940_d, 0, 46 + var6 * 20, this.field_52008_a / 2, this.field_52007_b);
         this.func_550_b(this.field_941_c + this.field_52008_a / 2, this.field_940_d, 200 - this.field_52008_a / 2, 46 + var6 * 20, this.field_52008_a / 2, this.field_52007_b);
         this.func_560_b(p_561_1_, p_561_2_, p_561_3_);
         int var7 = 14737632;
         if(!this.field_937_g) {
            var7 = -6250336;
         } else if(var5) {
            var7 = 16777120;
         }

         this.func_548_a(var4, this.field_939_e, this.field_941_c + this.field_52008_a / 2, this.field_940_d + (this.field_52007_b - 8) / 2, var7);
      }
   }

   protected void func_560_b(Minecraft p_560_1_, int p_560_2_, int p_560_3_) {}

   public void func_559_a(int p_559_1_, int p_559_2_) {}

   public boolean func_562_c(Minecraft p_562_1_, int p_562_2_, int p_562_3_) {
      return this.field_937_g && this.field_936_h && p_562_2_ >= this.field_941_c && p_562_3_ >= this.field_940_d && p_562_2_ < this.field_941_c + this.field_52008_a && p_562_3_ < this.field_940_d + this.field_52007_b;
   }
}
