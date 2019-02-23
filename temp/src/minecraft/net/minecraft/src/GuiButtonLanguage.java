package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiButtonLanguage extends GuiButton {

   public GuiButtonLanguage(int p_i44_1_, int p_i44_2_, int p_i44_3_) {
      super(p_i44_1_, p_i44_2_, p_i44_3_, 20, 20, "");
   }

   public void func_561_a(Minecraft p_561_1_, int p_561_2_, int p_561_3_) {
      if(this.field_936_h) {
         GL11.glBindTexture(3553, p_561_1_.field_6315_n.func_1070_a("/gui/gui.png"));
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         boolean var4 = p_561_2_ >= this.field_941_c && p_561_3_ >= this.field_940_d && p_561_2_ < this.field_941_c + this.field_52008_a && p_561_3_ < this.field_940_d + this.field_52007_b;
         int var5 = 106;
         if(var4) {
            var5 += this.field_52007_b;
         }

         this.func_550_b(this.field_941_c, this.field_940_d, 0, var5, this.field_52008_a, this.field_52007_b);
      }
   }
}
