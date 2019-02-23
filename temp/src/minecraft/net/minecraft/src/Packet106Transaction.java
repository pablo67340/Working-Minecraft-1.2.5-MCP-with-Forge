package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet106Transaction extends Packet {

   public int field_20029_a;
   public short field_20028_b;
   public boolean field_20030_c;


   public Packet106Transaction() {}

   public Packet106Transaction(int p_i416_1_, short p_i416_2_, boolean p_i416_3_) {
      this.field_20029_a = p_i416_1_;
      this.field_20028_b = p_i416_2_;
      this.field_20030_c = p_i416_3_;
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20089_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20029_a = p_327_1_.readByte();
      this.field_20028_b = p_327_1_.readShort();
      this.field_20030_c = p_327_1_.readByte() != 0;
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_20029_a);
      p_322_1_.writeShort(this.field_20028_b);
      p_322_1_.writeByte(this.field_20030_c?1:0);
   }

   public int func_329_a() {
      return 4;
   }
}
