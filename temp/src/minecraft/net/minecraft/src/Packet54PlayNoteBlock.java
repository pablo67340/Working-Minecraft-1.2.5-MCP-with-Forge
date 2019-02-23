package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet54PlayNoteBlock extends Packet {

   public int field_21037_a;
   public int field_21036_b;
   public int field_21040_c;
   public int field_21039_d;
   public int field_21038_e;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_21037_a = p_327_1_.readInt();
      this.field_21036_b = p_327_1_.readShort();
      this.field_21040_c = p_327_1_.readInt();
      this.field_21039_d = p_327_1_.read();
      this.field_21038_e = p_327_1_.read();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_21037_a);
      p_322_1_.writeShort(this.field_21036_b);
      p_322_1_.writeInt(this.field_21040_c);
      p_322_1_.write(this.field_21039_d);
      p_322_1_.write(this.field_21038_e);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_21145_a(this);
   }

   public int func_329_a() {
      return 12;
   }
}
