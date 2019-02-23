package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet6SpawnPosition extends Packet {

   public int field_515_a;
   public int field_514_b;
   public int field_516_c;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_515_a = p_327_1_.readInt();
      this.field_514_b = p_327_1_.readInt();
      this.field_516_c = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_515_a);
      p_322_1_.writeInt(this.field_514_b);
      p_322_1_.writeInt(this.field_516_c);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_845_a(this);
   }

   public int func_329_a() {
      return 12;
   }
}
