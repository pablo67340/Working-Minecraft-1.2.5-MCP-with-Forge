package net.minecraft.src;

import java.util.List;
import net.minecraft.src.Container;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.OpenGlHelper;
import net.minecraft.src.RenderHelper;
import net.minecraft.src.RenderItem;
import net.minecraft.src.Slot;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public abstract class GuiContainer extends GuiScreen {

   protected static RenderItem field_972_j = new RenderItem();
   protected int field_971_a = 176;
   protected int field_974_h = 166;
   public Container field_973_i;
   protected int field_40216_e;
   protected int field_40215_f;


   public GuiContainer(Container p_i335_1_) {
      this.field_973_i = p_i335_1_;
   }

   public void func_6448_a() {
      super.func_6448_a();
      this.field_945_b.field_6322_g.field_20068_h = this.field_973_i;
      this.field_40216_e = (this.field_951_c - this.field_971_a) / 2;
      this.field_40215_f = (this.field_950_d - this.field_974_h) / 2;
   }

   public void func_571_a(int p_571_1_, int p_571_2_, float p_571_3_) {
      this.func_578_i();
      int var4 = this.field_40216_e;
      int var5 = this.field_40215_f;
      this.func_589_a(p_571_3_, p_571_1_, p_571_2_);
      RenderHelper.func_41089_c();
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var4, (float)var5, 0.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable('\u803a');
      Slot var6 = null;
      short var7 = 240;
      short var8 = 240;
      OpenGlHelper.func_40454_a(OpenGlHelper.field_40455_b, (float)var7 / 1.0F, (float)var8 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

      int var10;
      for(int var20 = 0; var20 < this.field_973_i.field_20122_e.size(); ++var20) {
         Slot var22 = (Slot)this.field_973_i.field_20122_e.get(var20);
         this.func_590_a(var22);
         if(this.func_20081_a(var22, p_571_1_, p_571_2_)) {
            var6 = var22;
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int var9 = var22.field_20006_b;
            var10 = var22.field_20008_c;
            this.func_549_a(var9, var10, var9 + 16, var10 + 16, -2130706433, -2130706433);
            GL11.glEnable(2896);
            GL11.glEnable(2929);
         }
      }

      this.func_587_j();
      InventoryPlayer var21 = this.field_945_b.field_6322_g.field_778_b;
      if(var21.func_20075_i() != null) {
         GL11.glTranslatef(0.0F, 0.0F, 32.0F);
         this.field_923_k = 200.0F;
         field_972_j.field_40268_b = 200.0F;
         field_972_j.func_161_a(this.field_6451_g, this.field_945_b.field_6315_n, var21.func_20075_i(), p_571_1_ - var4 - 8, p_571_2_ - var5 - 8);
         field_972_j.func_164_b(this.field_6451_g, this.field_945_b.field_6315_n, var21.func_20075_i(), p_571_1_ - var4 - 8, p_571_2_ - var5 - 8);
         this.field_923_k = 0.0F;
         field_972_j.field_40268_b = 0.0F;
      }

      GL11.glDisable('\u803a');
      RenderHelper.func_1159_a();
      GL11.glDisable(2896);
      GL11.glDisable(2929);
      if(var21.func_20075_i() == null && var6 != null && var6.func_20005_c()) {
         ItemStack var23 = var6.func_777_b();
         List var24 = var23.func_40712_q();
         if(var24.size() > 0) {
            var10 = 0;

            int var11;
            int var12;
            for(var11 = 0; var11 < var24.size(); ++var11) {
               var12 = this.field_6451_g.func_871_a((String)var24.get(var11));
               if(var12 > var10) {
                  var10 = var12;
               }
            }

            var11 = p_571_1_ - var4 + 12;
            var12 = p_571_2_ - var5 - 12;
            int var14 = 8;
            if(var24.size() > 1) {
               var14 += 2 + (var24.size() - 1) * 10;
            }

            this.field_923_k = 300.0F;
            field_972_j.field_40268_b = 300.0F;
            int var15 = -267386864;
            this.func_549_a(var11 - 3, var12 - 4, var11 + var10 + 3, var12 - 3, var15, var15);
            this.func_549_a(var11 - 3, var12 + var14 + 3, var11 + var10 + 3, var12 + var14 + 4, var15, var15);
            this.func_549_a(var11 - 3, var12 - 3, var11 + var10 + 3, var12 + var14 + 3, var15, var15);
            this.func_549_a(var11 - 4, var12 - 3, var11 - 3, var12 + var14 + 3, var15, var15);
            this.func_549_a(var11 + var10 + 3, var12 - 3, var11 + var10 + 4, var12 + var14 + 3, var15, var15);
            int var16 = 1347420415;
            int var17 = (var16 & 16711422) >> 1 | var16 & -16777216;
            this.func_549_a(var11 - 3, var12 - 3 + 1, var11 - 3 + 1, var12 + var14 + 3 - 1, var16, var17);
            this.func_549_a(var11 + var10 + 2, var12 - 3 + 1, var11 + var10 + 3, var12 + var14 + 3 - 1, var16, var17);
            this.func_549_a(var11 - 3, var12 - 3, var11 + var10 + 3, var12 - 3 + 1, var16, var16);
            this.func_549_a(var11 - 3, var12 + var14 + 2, var11 + var10 + 3, var12 + var14 + 3, var17, var17);

            for(int var18 = 0; var18 < var24.size(); ++var18) {
               String var19 = (String)var24.get(var18);
               if(var18 == 0) {
                  var19 = "\u00a7" + Integer.toHexString(var23.func_40707_s().field_40535_e) + var19;
               } else {
                  var19 = "\u00a77" + var19;
               }

               this.field_6451_g.func_50103_a(var19, var11, var12, -1);
               if(var18 == 0) {
                  var12 += 2;
               }

               var12 += 10;
            }

            this.field_923_k = 0.0F;
            field_972_j.field_40268_b = 0.0F;
         }
      }

      GL11.glPopMatrix();
      super.func_571_a(p_571_1_, p_571_2_, p_571_3_);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
   }

   protected void func_587_j() {}

   protected abstract void func_589_a(float var1, int var2, int var3);

   private void func_590_a(Slot p_590_1_) {
      int var2 = p_590_1_.field_20006_b;
      int var3 = p_590_1_.field_20008_c;
      ItemStack var4 = p_590_1_.func_777_b();
      boolean var5 = false;
      this.field_923_k = 100.0F;
      field_972_j.field_40268_b = 100.0F;
      if(var4 == null) {
         int var8 = p_590_1_.func_775_c();
         if(var8 >= 0) {
            GL11.glDisable(2896);
            this.field_945_b.field_6315_n.func_1076_b(this.field_945_b.field_6315_n.func_1070_a("/gui/items.png"));
            this.func_550_b(var2, var3, var8 % 16 * 16, var8 / 16 * 16, 16, 16);
            GL11.glEnable(2896);
            var5 = true;
         }
      }

      if(!var5) {
         field_972_j.func_161_a(this.field_6451_g, this.field_945_b.field_6315_n, var4, var2, var3);
         field_972_j.func_164_b(this.field_6451_g, this.field_945_b.field_6315_n, var4, var2, var3);
      }

      field_972_j.field_40268_b = 0.0F;
      this.field_923_k = 0.0F;
   }

   private Slot func_588_a(int p_588_1_, int p_588_2_) {
      for(int var3 = 0; var3 < this.field_973_i.field_20122_e.size(); ++var3) {
         Slot var4 = (Slot)this.field_973_i.field_20122_e.get(var3);
         if(this.func_20081_a(var4, p_588_1_, p_588_2_)) {
            return var4;
         }
      }

      return null;
   }

   protected void func_565_a(int p_565_1_, int p_565_2_, int p_565_3_) {
      super.func_565_a(p_565_1_, p_565_2_, p_565_3_);
      if(p_565_3_ == 0 || p_565_3_ == 1) {
         Slot var4 = this.func_588_a(p_565_1_, p_565_2_);
         int var5 = this.field_40216_e;
         int var6 = this.field_40215_f;
         boolean var7 = p_565_1_ < var5 || p_565_2_ < var6 || p_565_1_ >= var5 + this.field_971_a || p_565_2_ >= var6 + this.field_974_h;
         int var8 = -1;
         if(var4 != null) {
            var8 = var4.field_20007_a;
         }

         if(var7) {
            var8 = -999;
         }

         if(var8 != -1) {
            boolean var9 = var8 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
            this.func_35309_a(var4, var8, p_565_3_, var9);
         }
      }

   }

   private boolean func_20081_a(Slot p_20081_1_, int p_20081_2_, int p_20081_3_) {
      int var4 = this.field_40216_e;
      int var5 = this.field_40215_f;
      p_20081_2_ -= var4;
      p_20081_3_ -= var5;
      return p_20081_2_ >= p_20081_1_.field_20006_b - 1 && p_20081_2_ < p_20081_1_.field_20006_b + 16 + 1 && p_20081_3_ >= p_20081_1_.field_20008_c - 1 && p_20081_3_ < p_20081_1_.field_20008_c + 16 + 1;
   }

   protected void func_35309_a(Slot p_35309_1_, int p_35309_2_, int p_35309_3_, boolean p_35309_4_) {
      if(p_35309_1_ != null) {
         p_35309_2_ = p_35309_1_.field_20007_a;
      }

      this.field_945_b.field_6327_b.func_27174_a(this.field_973_i.field_1618_c, p_35309_2_, p_35309_3_, p_35309_4_, this.field_945_b.field_6322_g);
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == 1 || p_580_2_ == this.field_945_b.field_6304_y.field_1570_o.field_1370_b) {
         this.field_945_b.field_6322_g.func_20059_m();
      }

   }

   public void func_6449_h() {
      if(this.field_945_b.field_6322_g != null) {
         this.field_973_i.func_1104_a(this.field_945_b.field_6322_g);
         this.field_945_b.field_6327_b.func_20086_a(this.field_973_i.field_1618_c, this.field_945_b.field_6322_g);
      }
   }

   public boolean func_6450_b() {
      return false;
   }

   public void func_570_g() {
      super.func_570_g();
      if(!this.field_945_b.field_6322_g.func_354_B() || this.field_945_b.field_6322_g.field_646_aA) {
         this.field_945_b.field_6322_g.func_20059_m();
      }

   }

}
