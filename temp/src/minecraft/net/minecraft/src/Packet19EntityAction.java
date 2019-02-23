package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Entity;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet19EntityAction extends Packet {

   public int field_21051_a;
   public int field_21050_b;


   public Packet19EntityAction() {}

   public Packet19EntityAction(Entity p_i141_1_, int p_i141_2_) {
      this.field_21051_a = p_i141_1_.field_620_ab;
      this.field_21050_b = p_i141_2_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_21051_a = p_327_1_.readInt();
      this.field_21050_b = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_21051_a);
      p_322_1_.writeByte(this.field_21050_b);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_21147_a(this);
   }

   public int func_329_a() {
      return 5;
   }
}
