package net.minecraft.src;

import java.io.InputStream;
import java.net.URL;
import net.minecraft.src.CodecMus;

class MusInputStream extends InputStream {

   private int field_1516_c;
   private InputStream field_1515_d;
   byte[] field_1514_a;
   // $FF: synthetic field
   final CodecMus field_1513_b;


   public MusInputStream(CodecMus p_i46_1_, URL p_i46_2_, InputStream p_i46_3_) {
      this.field_1513_b = p_i46_1_;
      this.field_1514_a = new byte[1];
      this.field_1515_d = p_i46_3_;
      String var4 = p_i46_2_.getPath();
      var4 = var4.substring(var4.lastIndexOf("/") + 1);
      this.field_1516_c = var4.hashCode();
   }

   public int read() {
      int var1 = this.read(this.field_1514_a, 0, 1);
      return var1 < 0?var1:this.field_1514_a[0];
   }

   public int read(byte[] p_read_1_, int p_read_2_, int p_read_3_) {
      p_read_3_ = this.field_1515_d.read(p_read_1_, p_read_2_, p_read_3_);

      for(int var4 = 0; var4 < p_read_3_; ++var4) {
         byte var5 = p_read_1_[p_read_2_ + var4] = (byte)(p_read_1_[p_read_2_ + var4] ^ this.field_1516_c >> 8);
         this.field_1516_c = this.field_1516_c * 498729871 + 85731 * var5;
      }

      return p_read_3_;
   }
}
