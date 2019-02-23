package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet53BlockChange extends Packet {

   public int field_492_a;
   public int field_491_b;
   public int field_495_c;
   public int field_494_d;
   public int field_493_e;


   public Packet53BlockChange() {
      this.field_472_j = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_492_a = p_327_1_.readInt();
      this.field_491_b = p_327_1_.read();
      this.field_495_c = p_327_1_.readInt();
      this.field_494_d = p_327_1_.read();
      this.field_493_e = p_327_1_.read();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_492_a);
      p_322_1_.write(this.field_491_b);
      p_322_1_.writeInt(this.field_495_c);
      p_322_1_.write(this.field_494_d);
      p_322_1_.write(this.field_493_e);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_822_a(this);
   }

   public int func_329_a() {
      return 11;
   }
}
