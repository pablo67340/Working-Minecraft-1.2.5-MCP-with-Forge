package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet250CustomPayload extends Packet {

   public String field_44012_a;
   public int field_44010_b;
   public byte[] field_44011_c;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_44012_a = func_27048_a(p_327_1_, 16);
      this.field_44010_b = p_327_1_.readShort();
      if(this.field_44010_b > 0 && this.field_44010_b < 32767) {
         this.field_44011_c = new byte[this.field_44010_b];
         p_327_1_.readFully(this.field_44011_c);
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      func_27049_a(this.field_44012_a, p_322_1_);
      p_322_1_.writeShort((short)this.field_44010_b);
      if(this.field_44011_c != null) {
         p_322_1_.write(this.field_44011_c);
      }

   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_44028_a(this);
   }

   public int func_329_a() {
      return 2 + this.field_44012_a.length() * 2 + 2 + this.field_44010_b;
   }
}
