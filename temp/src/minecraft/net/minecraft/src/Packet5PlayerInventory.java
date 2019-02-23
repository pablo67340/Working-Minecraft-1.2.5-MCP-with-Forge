package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet5PlayerInventory extends Packet {

   public int field_571_a;
   public int field_21056_b;
   public int field_570_b;
   public int field_20044_c;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_571_a = p_327_1_.readInt();
      this.field_21056_b = p_327_1_.readShort();
      this.field_570_b = p_327_1_.readShort();
      this.field_20044_c = p_327_1_.readShort();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_571_a);
      p_322_1_.writeShort(this.field_21056_b);
      p_322_1_.writeShort(this.field_570_b);
      p_322_1_.writeShort(this.field_20044_c);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_843_a(this);
   }

   public int func_329_a() {
      return 8;
   }
}
