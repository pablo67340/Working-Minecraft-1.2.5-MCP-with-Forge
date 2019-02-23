package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet2Handshake extends Packet {

   public String field_532_a;


   public Packet2Handshake() {}

   public Packet2Handshake(String p_i388_1_) {
      this.field_532_a = p_i388_1_;
   }

   public Packet2Handshake(String p_i1047_1_, String p_i1047_2_, int p_i1047_3_) {
      this.field_532_a = p_i1047_1_ + ";" + p_i1047_2_ + ":" + p_i1047_3_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_532_a = func_27048_a(p_327_1_, 64);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      func_27049_a(this.field_532_a, p_322_1_);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_838_a(this);
   }

   public int func_329_a() {
      return 4 + this.field_532_a.length() + 4;
   }
}
