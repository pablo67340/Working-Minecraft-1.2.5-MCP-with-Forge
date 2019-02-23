package net.minecraft.src;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.ChatClickData;
import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.GuiChatConfirmLink;
import net.minecraft.src.GuiPlayerInfo;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiChat extends GuiScreen {

   private String field_50062_b = "";
   private int field_50063_c = -1;
   private boolean field_50060_d = false;
   private String field_50061_e = "";
   private String field_50059_f = "";
   private int field_50067_h = 0;
   private List field_50068_i = new ArrayList();
   private URI field_50065_j = null;
   protected GuiTextField field_50064_a;
   private String field_50066_k = "";


   public GuiChat() {}

   public GuiChat(String p_i1207_1_) {
      this.field_50066_k = p_i1207_1_;
   }

   public void func_6448_a() {
      Keyboard.enableRepeatEvents(true);
      this.field_50063_c = this.field_945_b.field_6308_u.func_50013_c().size();
      this.field_50064_a = new GuiTextField(this.field_6451_g, 4, this.field_950_d - 12, this.field_951_c - 4, 12);
      this.field_50064_a.func_22066_a(100);
      this.field_50064_a.func_50027_a(false);
      this.field_50064_a.func_50033_b(true);
      this.field_50064_a.func_22068_a(this.field_50066_k);
      this.field_50064_a.func_50026_c(false);
   }

   public void func_6449_h() {
      Keyboard.enableRepeatEvents(false);
      this.field_945_b.field_6308_u.func_50014_d();
   }

   public void func_570_g() {
      this.field_50064_a.func_22070_b();
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == 15) {
         this.func_50057_d();
      } else {
         this.field_50060_d = false;
      }

      if(p_580_2_ == 1) {
         this.field_945_b.func_6272_a((GuiScreen)null);
      } else if(p_580_2_ == 28) {
         String var3 = this.field_50064_a.func_22071_a().trim();
         if(var3.length() > 0 && !this.field_945_b.func_22003_b(var3)) {
            this.field_945_b.field_6322_g.func_461_a(var3);
         }

         this.field_945_b.func_6272_a((GuiScreen)null);
      } else if(p_580_2_ == 200) {
         this.func_50058_a(-1);
      } else if(p_580_2_ == 208) {
         this.func_50058_a(1);
      } else if(p_580_2_ == 201) {
         this.field_945_b.field_6308_u.func_50011_a(19);
      } else if(p_580_2_ == 209) {
         this.field_945_b.field_6308_u.func_50011_a(-19);
      } else {
         this.field_50064_a.func_50037_a(p_580_1_, p_580_2_);
      }

   }

   public void func_566_e() {
      super.func_566_e();
      int var1 = Mouse.getEventDWheel();
      if(var1 != 0) {
         if(var1 > 1) {
            var1 = 1;
         }

         if(var1 < -1) {
            var1 = -1;
         }

         if(!func_50049_m()) {
            var1 *= 7;
         }

         this.field_945_b.field_6308_u.func_50011_a(var1);
      }

   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      if(p_565_3_ == 0) {
         ChatClickData var4 = this.field_945_b.field_6308_u.func_50012_a(Mouse.getX(), Mouse.getY());
         if(var4 != null) {
            URI var5 = var4.func_50089_b();
            if(var5 != null) {
               this.field_50065_j = var5;
               this.field_945_b.func_6272_a(new GuiChatConfirmLink(this, this, var4.func_50088_a(), 0, var4));
               return;
            }
         }
      }

      this.field_50064_a.func_22069_a(p_565_1_, p_565_2_, p_565_3_);
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
   }

   public void func_568_a(boolean p_568_1_, int p_568_2_) {
      if(p_568_2_ == 0) {
         if(p_568_1_) {
            try {
               Class var3 = Class.forName("java.awt.Desktop");
               Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
               var3.getMethod("browse", new Class[]{URI.class}).invoke(var4, new Object[]{this.field_50065_j});
            } catch (Throwable var5) {
               var5.printStackTrace();
            }
         }

         this.field_50065_j = null;
         this.field_945_b.func_6272_a(this);
      }

   }

   public void func_50057_d() {
      Iterator var2;
      GuiPlayerInfo var3;
      if(this.field_50060_d) {
         this.field_50064_a.func_50021_a(-1);
         if(this.field_50067_h >= this.field_50068_i.size()) {
            this.field_50067_h = 0;
         }
      } else {
         int var1 = this.field_50064_a.func_50028_c(-1);
         if(this.field_50064_a.func_50035_h() - var1 < 1) {
            return;
         }

         this.field_50068_i.clear();
         this.field_50061_e = this.field_50064_a.func_22071_a().substring(var1);
         this.field_50059_f = this.field_50061_e.toLowerCase();
         var2 = ((EntityClientPlayerMP)this.field_945_b.field_6322_g).field_797_bg.field_35786_c.iterator();

         while(var2.hasNext()) {
            var3 = (GuiPlayerInfo)var2.next();
            if(var3.func_50098_a(this.field_50059_f)) {
               this.field_50068_i.add(var3);
            }
         }

         if(this.field_50068_i.size() == 0) {
            return;
         }

         this.field_50060_d = true;
         this.field_50067_h = 0;
         this.field_50064_a.func_50020_b(var1 - this.field_50064_a.func_50035_h());
      }

      if(this.field_50068_i.size() > 1) {
         StringBuilder var4 = new StringBuilder();

         for(var2 = this.field_50068_i.iterator(); var2.hasNext(); var4.append(var3.field_35624_a)) {
            var3 = (GuiPlayerInfo)var2.next();
            if(var4.length() > 0) {
               var4.append(", ");
            }
         }

         this.field_945_b.field_6308_u.func_552_a(var4.toString());
      }

      this.field_50064_a.func_50031_b(((GuiPlayerInfo)this.field_50068_i.get(this.field_50067_h++)).field_35624_a);
   }

   public void func_50058_a(int p_50058_1_) {
      int var2 = this.field_50063_c + p_50058_1_;
      int var3 = this.field_945_b.field_6308_u.func_50013_c().size();
      if(var2 < 0) {
         var2 = 0;
      }

      if(var2 > var3) {
         var2 = var3;
      }

      if(var2 != this.field_50063_c) {
         if(var2 == var3) {
            this.field_50063_c = var3;
            this.field_50064_a.func_22068_a(this.field_50062_b);
         } else {
            if(this.field_50063_c == var3) {
               this.field_50062_b = this.field_50064_a.func_22071_a();
            }

            this.field_50064_a.func_22068_a((String)this.field_945_b.field_6308_u.func_50013_c().get(var2));
            this.field_50063_c = var2;
         }
      }
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      func_551_a(2, this.field_950_d - 14, this.field_951_c - 2, this.field_950_d - 2, Integer.MIN_VALUE);
      this.field_50064_a.func_22067_c();
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
   }
}
