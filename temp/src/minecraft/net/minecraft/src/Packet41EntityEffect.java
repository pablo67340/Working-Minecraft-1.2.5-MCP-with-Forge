package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet41EntityEffect extends Packet {

   public int field_35261_a;
   public byte field_35259_b;
   public byte field_35260_c;
   public short field_35258_d;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_35261_a = p_327_1_.readInt();
      this.field_35259_b = p_327_1_.readByte();
      this.field_35260_c = p_327_1_.readByte();
      this.field_35258_d = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_35261_a);
      p_322_1_.writeByte(this.field_35259_b);
      p_322_1_.writeByte(this.field_35260_c);
      p_322_1_.writeShort(this.field_35258_d);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_35780_a(this);
   }

   public int func_329_a() {
      return 8;
   }
}
