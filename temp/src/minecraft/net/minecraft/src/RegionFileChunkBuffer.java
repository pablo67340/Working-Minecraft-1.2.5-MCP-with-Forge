package net.minecraft.src;

import java.io.ByteArrayOutputStream;
import net.minecraft.src.RegionFile;

class RegionFileChunkBuffer extends ByteArrayOutputStream {

   private int field_22283_b;
   private int field_22285_c;
   // $FF: synthetic field
   final RegionFile field_22284_a;


   public RegionFileChunkBuffer(RegionFile p_i724_1_, int p_i724_2_, int p_i724_3_) {
      super(8096);
      this.field_22284_a = p_i724_1_;
      this.field_22283_b = p_i724_2_;
      this.field_22285_c = p_i724_3_;
   }

   public void close() {
      this.field_22284_a.func_22203_a(this.field_22283_b, this.field_22285_c, this.buf, this.count);
   }
}
