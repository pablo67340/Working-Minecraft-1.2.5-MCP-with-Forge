package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet14BlockDig extends Packet {

   public int field_542_a;
   public int field_541_b;
   public int field_545_c;
   public int field_544_d;
   public int field_543_e;


   public Packet14BlockDig() {}

   public Packet14BlockDig(int p_i352_1_, int p_i352_2_, int p_i352_3_, int p_i352_4_, int p_i352_5_) {
      this.field_543_e = p_i352_1_;
      this.field_542_a = p_i352_2_;
      this.field_541_b = p_i352_3_;
      this.field_545_c = p_i352_4_;
      this.field_544_d = p_i352_5_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_543_e = p_327_1_.read();
      this.field_542_a = p_327_1_.readInt();
      this.field_541_b = p_327_1_.read();
      this.field_545_c = p_327_1_.readInt();
      this.field_544_d = p_327_1_.read();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.write(this.field_543_e);
      p_322_1_.writeInt(this.field_542_a);
      p_322_1_.write(this.field_541_b);
      p_322_1_.writeInt(this.field_545_c);
      p_322_1_.write(this.field_544_d);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_821_a(this);
   }

   public int func_329_a() {
      return 11;
   }
}
