package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet61DoorChange extends Packet {

   public int field_28050_a;
   public int field_28049_b;
   public int field_28053_c;
   public int field_28052_d;
   public int field_28051_e;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_28050_a = p_327_1_.readInt();
      this.field_28053_c = p_327_1_.readInt();
      this.field_28052_d = p_327_1_.readByte() & 255;
      this.field_28051_e = p_327_1_.readInt();
      this.field_28049_b = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_28050_a);
      p_322_1_.writeInt(this.field_28053_c);
      p_322_1_.writeByte(this.field_28052_d & 255);
      p_322_1_.writeInt(this.field_28051_e);
      p_322_1_.writeInt(this.field_28049_b);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_28115_a(this);
   }

   public int func_329_a() {
      return 20;
   }
}
