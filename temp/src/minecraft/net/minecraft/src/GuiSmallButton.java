package net.minecraft.src;

import net.minecraft.src.EnumOptions;
import net.minecraft.src.GuiButton;

public class GuiSmallButton extends GuiButton {

   private final EnumOptions field_20079_i;


   public GuiSmallButton(int p_i707_1_, int p_i707_2_, int p_i707_3_, String p_i707_4_) {
      this(p_i707_1_, p_i707_2_, p_i707_3_, (EnumOptions)null, p_i707_4_);
   }

   public GuiSmallButton(int p_i708_1_, int p_i708_2_, int p_i708_3_, int p_i708_4_, int p_i708_5_, String p_i708_6_) {
      super(p_i708_1_, p_i708_2_, p_i708_3_, p_i708_4_, p_i708_5_, p_i708_6_);
      this.field_20079_i = null;
   }

   public GuiSmallButton(int p_i709_1_, int p_i709_2_, int p_i709_3_, EnumOptions p_i709_4_, String p_i709_5_) {
      super(p_i709_1_, p_i709_2_, p_i709_3_, 150, 20, p_i709_5_);
      this.field_20079_i = p_i709_4_;
   }

   public EnumOptions func_20078_a() {
      return this.field_20079_i;
   }
}
