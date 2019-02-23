package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet105UpdateProgressbar extends Packet {

   public int field_20032_a;
   public int field_20031_b;
   public int field_20033_c;


   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20090_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20032_a = p_327_1_.readByte();
      this.field_20031_b = p_327_1_.readShort();
      this.field_20033_c = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_20032_a);
      p_322_1_.writeShort(this.field_20031_b);
      p_322_1_.writeShort(this.field_20033_c);
   }

   public int func_329_a() {
      return 5;
   }
}
