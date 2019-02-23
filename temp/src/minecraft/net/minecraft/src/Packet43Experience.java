package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet43Experience extends Packet {

   public float field_35230_a;
   public int field_35228_b;
   public int field_35229_c;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_35230_a = p_327_1_.readFloat();
      this.field_35229_c = p_327_1_.readShort();
      this.field_35228_b = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeFloat(this.field_35230_a);
      p_322_1_.writeShort(this.field_35229_c);
      p_322_1_.writeShort(this.field_35228_b);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_35777_a(this);
   }

   public int func_329_a() {
      return 4;
   }
}
