package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GameSettings;
import net.minecraft.src.IStatStringFormat;

public class StatStringFormatKeyInv implements IStatStringFormat {

   // $FF: synthetic field
   final Minecraft field_27344_a;


   public StatStringFormatKeyInv(Minecraft p_i357_1_) {
      this.field_27344_a = p_i357_1_;
   }

   public String func_27343_a(String p_27343_1_) {
      try {
         return String.format(p_27343_1_, new Object[]{GameSettings.func_41085_c(this.field_27344_a.field_6304_y.field_1570_o.field_1370_b)});
      } catch (Exception var3) {
         return "Error: " + var3.getLocalizedMessage();
      }
   }
}
