package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet101CloseWindow extends Packet {

   public int field_20034_a;


   public Packet101CloseWindow() {}

   public Packet101CloseWindow(int p_i33_1_) {
      this.field_20034_a = p_i33_1_;
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20092_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20034_a = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_20034_a);
   }

   public int func_329_a() {
      return 1;
   }
}
