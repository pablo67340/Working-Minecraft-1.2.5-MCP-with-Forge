package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet3Chat extends Packet {

   public static int field_52010_b = 119;
   public String field_517_a;


   public Packet3Chat() {}

   public Packet3Chat(String p_i81_1_) {
      if(p_i81_1_.length() > field_52010_b) {
         p_i81_1_ = p_i81_1_.substring(0, field_52010_b);
      }

      this.field_517_a = p_i81_1_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_517_a = func_27048_a(p_327_1_, field_52010_b);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      func_27049_a(this.field_517_a, p_322_1_);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_4113_a(this);
   }

   public int func_329_a() {
      return 2 + this.field_517_a.length() * 2;
   }

}
