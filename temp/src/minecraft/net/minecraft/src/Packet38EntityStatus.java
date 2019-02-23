package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet38EntityStatus extends Packet {

   public int field_9274_a;
   public byte field_9273_b;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_9274_a = p_327_1_.readInt();
      this.field_9273_b = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_9274_a);
      p_322_1_.writeByte(this.field_9273_b);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_9447_a(this);
   }

   public int func_329_a() {
      return 5;
   }
}
