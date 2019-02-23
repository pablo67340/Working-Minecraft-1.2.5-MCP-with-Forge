package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet70Bed extends Packet {

   public static final String[] field_25020_a = new String[]{"tile.bed.notValid", null, null, "gameMode.changed"};
   public int field_25019_b;
   public int field_35262_c;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_25019_b = p_327_1_.readByte();
      this.field_35262_c = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeByte(this.field_25019_b);
      p_322_1_.writeByte(this.field_35262_c);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_25118_a(this);
   }

   public int func_329_a() {
      return 2;
   }

}
