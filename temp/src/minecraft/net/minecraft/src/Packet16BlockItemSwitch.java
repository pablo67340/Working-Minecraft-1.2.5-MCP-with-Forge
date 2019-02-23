package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet16BlockItemSwitch extends Packet {

   public int field_562_b;


   public Packet16BlockItemSwitch() {}

   public Packet16BlockItemSwitch(int p_i720_1_) {
      this.field_562_b = p_i720_1_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_562_b = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeShort(this.field_562_b);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_841_a(this);
   }

   public int func_329_a() {
      return 2;
   }
}
