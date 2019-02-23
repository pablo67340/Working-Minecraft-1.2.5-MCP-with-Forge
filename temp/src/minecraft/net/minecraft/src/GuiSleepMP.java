package net.minecraft.src;

import net.minecraft.src.EntityClientPlayerMP;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiChat;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet19EntityAction;
import net.minecraft.src.StringTranslate;

public class GuiSleepMP extends GuiChat {

   public void func_6448_a() {
      super.func_6448_a();
      StringTranslate var1 = StringTranslate.func_20162_a();
      this.field_949_e.add(new GuiButton(1, this.field_951_c / 2 - 100, this.field_950_d - 40, var1.func_20163_a("multiplayer.stopSleeping")));
   }

   protected void func_580_a(char p_580_1_, int p_580_2_) {
      if(p_580_2_ == 1) {
         this.func_22115_j();
      } else if(p_580_2_ == 28) {
         String var3 = this.field_50064_a.func_22071_a().trim();
         if(var3.length() > 0) {
            this.field_945_b.field_6322_g.func_461_a(var3);
         }

         this.field_50064_a.func_22068_a("");
         this.field_945_b.field_6308_u.func_50014_d();
      } else {
         super.func_580_a(p_580_1_, p_580_2_);
      }

   }

   protected void func_572_a(GuiButton p_572_1_) {
      if(p_572_1_.field_938_f == 1) {
         this.func_22115_j();
      } else {
         super.func_572_a(p_572_1_);
      }

   }

   private void func_22115_j() {
      if(this.field_945_b.field_6322_g instanceof EntityClientPlayerMP) {
         NetClientHandler var1 = ((EntityClientPlayerMP)this.field_945_b.field_6322_g).field_797_bg;
         var1.func_847_a(new Packet19EntityAction(this.field_945_b.field_6322_g, 3));
      }

   }
}
