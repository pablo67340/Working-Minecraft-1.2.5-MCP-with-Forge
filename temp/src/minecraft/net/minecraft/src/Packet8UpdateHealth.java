package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet8UpdateHealth extends Packet {

   public int field_9275_a;
   public int field_35231_b;
   public float field_35232_c;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_9275_a = p_327_1_.readShort();
      this.field_35231_b = p_327_1_.readShort();
      this.field_35232_c = p_327_1_.readFloat();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeShort(this.field_9275_a);
      p_322_1_.writeShort(this.field_35231_b);
      p_322_1_.writeFloat(this.field_35232_c);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_9446_a(this);
   }

   public int func_329_a() {
      return 8;
   }
}
