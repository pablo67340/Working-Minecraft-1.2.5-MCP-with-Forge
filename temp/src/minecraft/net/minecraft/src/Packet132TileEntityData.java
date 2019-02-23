package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet132TileEntityData extends Packet {

   public int field_48167_a;
   public int field_48165_b;
   public int field_48166_c;
   public int field_48163_d;
   public int field_48164_e;
   public int field_48161_f;
   public int field_48162_g;


   public Packet132TileEntityData() {
      this.field_472_j = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_48167_a = p_327_1_.readInt();
      this.field_48165_b = p_327_1_.readShort();
      this.field_48166_c = p_327_1_.readInt();
      this.field_48163_d = p_327_1_.readByte();
      this.field_48164_e = p_327_1_.readInt();
      this.field_48161_f = p_327_1_.readInt();
      this.field_48162_g = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_48167_a);
      p_322_1_.writeShort(this.field_48165_b);
      p_322_1_.writeInt(this.field_48166_c);
      p_322_1_.writeByte((byte)this.field_48163_d);
      p_322_1_.writeInt(this.field_48164_e);
      p_322_1_.writeInt(this.field_48161_f);
      p_322_1_.writeInt(this.field_48162_g);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_48489_a(this);
   }

   public int func_329_a() {
      return 25;
   }
}
