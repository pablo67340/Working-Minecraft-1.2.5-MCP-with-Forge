package net.minecraft.src;

import net.minecraft.src.ChatClickData;
import net.minecraft.src.GuiChat;
import net.minecraft.src.GuiConfirmOpenLink;
import net.minecraft.src.GuiScreen;

class GuiChatConfirmLink extends GuiConfirmOpenLink {

   // $FF: synthetic field
   final ChatClickData field_50056_a;
   // $FF: synthetic field
   final GuiChat field_50055_b;


   GuiChatConfirmLink(GuiChat p_i1202_1_, GuiScreen p_i1202_2_, String p_i1202_3_, int p_i1202_4_, ChatClickData p_i1202_5_) {
      super(p_i1202_2_, p_i1202_3_, p_i1202_4_);
      this.field_50055_b = p_i1202_1_;
      this.field_50056_a = p_i1202_5_;
   }

   public void func_50052_d() {
      func_50050_a(this.field_50056_a.func_50088_a());
   }
}
