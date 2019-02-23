package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet23VehicleSpawn extends Packet {

   public int field_500_a;
   public int field_499_b;
   public int field_503_c;
   public int field_502_d;
   public int field_28047_e;
   public int field_28046_f;
   public int field_28045_g;
   public int field_501_e;
   public int field_28044_i;


   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_500_a = p_327_1_.readInt();
      this.field_501_e = p_327_1_.readByte();
      this.field_499_b = p_327_1_.readInt();
      this.field_503_c = p_327_1_.readInt();
      this.field_502_d = p_327_1_.readInt();
      this.field_28044_i = p_327_1_.readInt();
      if(this.field_28044_i > 0) {
         this.field_28047_e = p_327_1_.readShort();
         this.field_28046_f = p_327_1_.readShort();
         this.field_28045_g = p_327_1_.readShort();
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_500_a);
      p_322_1_.writeByte(this.field_501_e);
      p_322_1_.writeInt(this.field_499_b);
      p_322_1_.writeInt(this.field_503_c);
      p_322_1_.writeInt(this.field_502_d);
      p_322_1_.writeInt(this.field_28044_i);
      if(this.field_28044_i > 0) {
         p_322_1_.writeShort(this.field_28047_e);
         p_322_1_.writeShort(this.field_28046_f);
         p_322_1_.writeShort(this.field_28045_g);
      }

   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_835_a(this);
   }

   public int func_329_a() {
      return 21 + this.field_28044_i > 0?6:0;
   }
}
