package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet100OpenWindow extends Packet {

   public int field_20038_a;
   public int field_20037_b;
   public String field_20040_c;
   public int field_20039_d;


   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20087_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20038_a = p_327_1_.readByte() & 255;
      this.field_20037_b = p_327_1_.readByte() & 255;
      this.field_20040_c = func_27048_a(p_327_1_, 32);
      this.field_20039_d = p_327_1_.readByte() & 255;
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_20038_a & 255);
      p_322_1_.writeByte(this.field_20037_b & 255);
      func_27049_a(this.field_20040_c, p_322_1_);
      p_322_1_.writeByte(this.field_20039_d & 255);
   }

   public int func_329_a() {
      return 3 + this.field_20040_c.length();
   }
}
