package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet131MapData extends Packet {

   public short field_28055_a;
   public short field_28054_b;
   public byte[] field_28056_c;


   public Packet131MapData() {
      this.field_472_j = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_28055_a = p_327_1_.readShort();
      this.field_28054_b = p_327_1_.readShort();
      this.field_28056_c = new byte[p_327_1_.readByte() & 255];
      p_327_1_.readFully(this.field_28056_c);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeShort(this.field_28055_a);
      p_322_1_.writeShort(this.field_28054_b);
      p_322_1_.writeByte(this.field_28056_c.length);
      p_322_1_.write(this.field_28056_c);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_28116_a(this);
   }

   public int func_329_a() {
      return 4 + this.field_28056_c.length;
   }
}
