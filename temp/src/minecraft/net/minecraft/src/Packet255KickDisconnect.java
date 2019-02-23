package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet255KickDisconnect extends Packet {

   public String field_582_a;


   public Packet255KickDisconnect() {}

   public Packet255KickDisconnect(String p_i218_1_) {
      this.field_582_a = p_i218_1_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_582_a = func_27048_a(p_327_1_, 256);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      func_27049_a(this.field_582_a, p_322_1_);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_844_a(this);
   }

   public int func_329_a() {
      return this.field_582_a.length();
   }
}
