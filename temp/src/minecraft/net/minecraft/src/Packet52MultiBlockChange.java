package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet52MultiBlockChange extends Packet {

   public int field_479_a;
   public int field_478_b;
   public byte[] field_481_e;
   public int field_480_f;
   private static byte[] field_48168_e = new byte[0];


   public Packet52MultiBlockChange() {
      this.field_472_j = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_479_a = p_327_1_.readInt();
      this.field_478_b = p_327_1_.readInt();
      this.field_480_f = p_327_1_.readShort() & '\uffff';
      int var2 = p_327_1_.readInt();
      if(var2 > 0) {
         this.field_481_e = new byte[var2];
         p_327_1_.readFully(this.field_481_e);
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_479_a);
      p_322_1_.writeInt(this.field_478_b);
      p_322_1_.writeShort((short)this.field_480_f);
      if(this.field_481_e != null) {
         p_322_1_.writeInt(this.field_481_e.length);
         p_322_1_.write(this.field_481_e);
      } else {
         p_322_1_.writeInt(0);
      }

   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_824_a(this);
   }

   public int func_329_a() {
      return 10 + this.field_480_f * 4;
   }

}
