package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet4UpdateTime extends Packet {

   public long field_564_a;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_564_a = p_327_1_.readLong();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeLong(this.field_564_a);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_846_a(this);
   }

   public int func_329_a() {
      return 8;
   }
}
