package net.minecraft.src;

import java.io.File;
import java.io.FilenameFilter;
import net.minecraft.src.AnvilSaveConverter;

class AnvilSaveConverterFileFilter implements FilenameFilter {

   // $FF: synthetic field
   final AnvilSaveConverter field_48552_a;


   AnvilSaveConverterFileFilter(AnvilSaveConverter p_i1006_1_) {
      this.field_48552_a = p_i1006_1_;
   }

   public boolean accept(File p_accept_1_, String p_accept_2_) {
      return p_accept_2_.endsWith(".mcr");
   }
}
