package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet10Flying extends Packet {

   public double field_561_a;
   public double field_560_b;
   public double field_559_c;
   public double field_558_d;
   public float field_557_e;
   public float field_556_f;
   public boolean field_555_g;
   public boolean field_554_h;
   public boolean field_553_i;


   public Packet10Flying() {}

   public Packet10Flying(boolean p_i338_1_) {
      this.field_555_g = p_i338_1_;
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_837_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_555_g = p_327_1_.read() != 0;
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.write(this.field_555_g?1:0);
   }

   public int func_329_a() {
      return 1;
   }
}
