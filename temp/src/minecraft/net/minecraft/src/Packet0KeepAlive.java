package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet0KeepAlive extends Packet {

   public int field_35254_a;


   public Packet0KeepAlive() {}

   public Packet0KeepAlive(int p_i26_1_) {
      this.field_35254_a = p_i26_1_;
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_35784_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_35254_a = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_35254_a);
   }

   public int func_329_a() {
      return 4;
   }
}
