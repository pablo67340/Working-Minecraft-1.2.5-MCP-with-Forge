package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet17Sleep extends Packet {

   public int field_22045_a;
   public int field_22044_b;
   public int field_22048_c;
   public int field_22047_d;
   public int field_22046_e;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_22045_a = p_327_1_.readInt();
      this.field_22046_e = p_327_1_.readByte();
      this.field_22044_b = p_327_1_.readInt();
      this.field_22048_c = p_327_1_.readByte();
      this.field_22047_d = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_22045_a);
      p_322_1_.writeByte(this.field_22046_e);
      p_322_1_.writeInt(this.field_22044_b);
      p_322_1_.writeByte(this.field_22048_c);
      p_322_1_.writeInt(this.field_22047_d);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_22186_a(this);
   }

   public int func_329_a() {
      return 14;
   }
}
