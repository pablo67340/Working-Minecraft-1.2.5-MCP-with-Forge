package net.minecraft.src;

import java.io.File;
import java.net.URI;
import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiSmallButton;
import net.minecraft.src.GuiTexturePackSlot;
import net.minecraft.src.StringTranslate;
import org.lwjgl.Sys;

public class GuiTexturePacks extends GuiScreen {

   protected GuiScreen field_6461_a;
   private int field_6454_o = -1;
   private String field_6453_p = "";
   private GuiTexturePackSlot field_22128_k;


   public GuiTexturePacks(GuiScreen p_i304_1_) {
      this.field_6461_a = p_i304_1_;
   }

   public void func_6448_a() {
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.add(new GuiSmallButton(5, this.field_951_c / 2 - 154, this.field_950_d - 48, var1.func_20163_a("texturePack.openFolder")));
      this.field_949_e.add(new GuiSmallButton(6, this.field_951_c / 2 + 4, this.field_950_d - 48, var1.func_20163_a("gui.done")));
      this.field_945_b.field_6298_C.func_6532_a();
      this.field_6453_p = (new File(Minecraft.func_6240_b(), "texturepacks")).getAbsolutePath();
      this.field_22128_k = new GuiTexturePackSlot(this);
      this.field_22128_k.func_22240_a(this.field_949_e, 7, 8);
   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_937_g) {
         if(p_572_1_.field_938_f == 5) {
            boolean var2 = false;

            try {
               Class var3 = Class.forName("java.awt.Desktop");
               Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
               var3.getMethod("browse", new Class[]{URI.class}).invoke(var4, new Object[]{(new File(Minecraft.func_6240_b(), "texturepacks")).toURI()});
            } catch (Throwable var5) {
               var5.printStackTrace();
               var2 = true;
            }

            if(var2) {
               System.out.println("Opening via Sys class!");
               Sys.openURL("file://" + this.field_6453_p);
            }
         } else if(p_572_1_.field_938_f == 6) {
            this.field_945_b.field_6315_n.func_1065_b();
            this.field_945_b.func_6272_a(this.field_6461_a);
         } else {
            this.field_22128_k.func_22241_a(p_572_1_);
         }

      }
   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
   }

   protected void func_573_b(int p_573_1_, int p_573_2_, int p_573_3_) {
      super.func_573_b(p_573_1_, p_573_2_, p_573_3_);
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.field_22128_k.func_22243_a(p_571_1_, p_571_2_, p_571_3_);
      if(this.field_6454_o <= 0) {
         this.field_945_b.field_6298_C.func_6532_a();
         this.field_6454_o += 20;
      }

      StringTranslate var4 = StringTranslate.func_20162_a();
      this.func_548_a(this.field_6451_g, var4.func_20163_a("texturePack.title"), this.field_951_c / 2, 16, 16777215);
      this.func_548_a(this.field_6451_g, var4.func_20163_a("texturePack.folderInfo"), this.field_951_c / 2 - 77, this.field_950_d - 26, 8421504);
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }

   public void func_570_g() {
      super.func_570_g();
      --this.field_6454_o;
   }

   // $FF: synthetic method
   static Minecraft func_22124_a(GuiTexturePacks p_22124_0_) {
      return p_22124_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22126_b(GuiTexturePacks p_22126_0_) {
      return p_22126_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22119_c(GuiTexturePacks p_22119_0_) {
      return p_22119_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22122_d(GuiTexturePacks p_22122_0_) {
      return p_22122_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22117_e(GuiTexturePacks p_22117_0_) {
      return p_22117_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_35307_f(GuiTexturePacks p_35307_0_) {
      return p_35307_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_35308_g(GuiTexturePacks p_35308_0_) {
      return p_35308_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22118_f(GuiTexturePacks p_22118_0_) {
      return p_22118_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22116_g(GuiTexturePacks p_22116_0_) {
      return p_22116_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22121_h(GuiTexturePacks p_22121_0_) {
      return p_22121_0_.field_945_b;
   }

   // $FF: synthetic method
   static Minecraft func_22123_i(GuiTexturePacks p_22123_0_) {
      return p_22123_0_.field_945_b;
   }

   // $FF: synthetic method
   static FontRenderer func_22127_j(GuiTexturePacks p_22127_0_) {
      return p_22127_0_.field_6451_g;
   }

   // $FF: synthetic method
   static FontRenderer func_22120_k(GuiTexturePacks p_22120_0_) {
      return p_22120_0_.field_6451_g;
   }

   // $FF: synthetic method
   static FontRenderer func_22125_l(GuiTexturePacks p_22125_0_) {
      return p_22125_0_.field_6451_g;
   }
}
