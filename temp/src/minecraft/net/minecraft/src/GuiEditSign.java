package net.minecraft.src;

import net.minecraft.src.Block;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Packet130UpdateSign;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.TileEntitySign;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiEditSign extends GuiScreen {

   private static final String field_20083_l = ChatAllowedCharacters.field_20157_a;
   protected String field_999_a = "Edit sign message:";
   private TileEntitySign field_1002_h;
   private int field_4189_i;
   private int field_1000_j = 0;


   public GuiEditSign(TileEntitySign p_i209_1_) {
      this.field_1002_h = p_i209_1_;
   }

   public void func_6448_a() {
      this.field_949_e.clear();
      Keyboard.enableRepeatEvents(true);
      this.field_949_e.add(new GuiButton(0, this.field_951_c / 2 - 100, this.field_950_d / 4 + 120, "Done"));
      this.field_1002_h.func_50006_a(false);
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
      if(this.field_945_b.field_6324_e.field_1026_y) {
         this.field_945_b.func_20001_q().func_847_a(new Packet130UpdateSign(this.field_1002_h.field_823_f, this.field_1002_h.field_822_g, this.field_1002_h.field_821_h, this.field_1002_h.field_826_a));
      }

      this.field_1002_h.func_50006_a(true);
   }

   public void func_570_g() {
      ++this.field_4189_i;
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 0) {
            this.field_1002_h.func_474_j_();
            this.field_945_b.func_6272_a((GuiScreen)null);
         }

      }
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == 200) {
         this.field_1000_j = this.field_1000_j - 1 & 3;
      }

      if(p_580_2_ == 208 || p_580_2_ == 28) {
         this.field_1000_j = this.field_1000_j + 1 & 3;
      }

      if(p_580_2_ == 14 && this.field_1002_h.field_826_a[this.field_1000_j].length() > 0) {
         this.field_1002_h.field_826_a[this.field_1000_j] = this.field_1002_h.field_826_a[this.field_1000_j].substring(0, this.field_1002_h.field_826_a[this.field_1000_j].length() - 1);
      }

      if(field_20083_l.indexOf(p_580_1_) >= 0 && this.field_1002_h.field_826_a[this.field_1000_j].length() < 15) {
         this.field_1002_h.field_826_a[this.field_1000_j] = this.field_1002_h.field_826_a[this.field_1000_j] + p_580_1_;
      }

   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      this.func_548_a(this.field_6451_g, this.field_999_a, this.field_951_c / 2, 40, 16777215);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)(this.field_951_c / 2), 0.0F, 50.0F);
      float var4 = 93.75F;
      GL11.glScalef(-var4, -var4, -var4);
      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
      Block var5 = this.field_1002_h.func_478_g();
      if(var5 == Block.field_443_aE) {
         float var6 = (float)(this.field_1002_h.func_479_f() * 360) / 16.0F;
         GL11.glRotatef(var6, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
      } else {
         int var8 = this.field_1002_h.func_479_f();
         float var7 = 0.0F;
         if(var8 == 2) {
            var7 = 180.0F;
         }

         if(var8 == 4) {
            var7 = 90.0F;
         }

         if(var8 == 5) {
            var7 = -90.0F;
         }

         GL11.glRotatef(var7, 0.0F, 1.0F, 0.0F);
         GL11.glTranslatef(0.0F, -1.0625F, 0.0F);
      }

      if(this.field_4189_i / 6 % 2 == 0) {
         this.field_1002_h.field_825_b = this.field_1000_j;
      }

      TileEntityRenderer.field_1554_a.func_1032_a(this.field_1002_h, -0.5D, -0.75D, -0.5D, 0.0F);
      this.field_1002_h.field_825_b = -1;
      GL11.glPopMatrix();
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

}
