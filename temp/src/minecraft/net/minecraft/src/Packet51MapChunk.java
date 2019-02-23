package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet51MapChunk extends Packet {

   public int field_48177_a;
   public int field_48175_b;
   public int field_48176_c;
   public int field_48173_d;
   public byte[] field_48174_e;
   public boolean field_48171_f;
   private int field_48172_g;
   private int field_48178_h;
   private static byte[] field_48179_i = new byte[0];


   public Packet51MapChunk() {
      this.field_472_j = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_48177_a = p_327_1_.readInt();
      this.field_48175_b = p_327_1_.readInt();
      this.field_48171_f = p_327_1_.readBoolean();
      this.field_48176_c = p_327_1_.readShort();
      this.field_48173_d = p_327_1_.readShort();
      this.field_48172_g = p_327_1_.readInt();
      this.field_48178_h = p_327_1_.readInt();
      if(field_48179_i.length < this.field_48172_g) {
         field_48179_i = new byte[this.field_48172_g];
      }

      p_327_1_.readFully(field_48179_i, 0, this.field_48172_g);
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < 16; ++var3) {
         var2 += this.field_48176_c >> var3 & 1;
      }

      var3 = 12288 * var2;
      if(this.field_48171_f) {
         var3 += 256;
      }

      this.field_48174_e = new byte[var3];
      Inflater var4 = new Inflater();
      var4.setInput(field_48179_i, 0, this.field_48172_g);

      try {
         var4.inflate(this.field_48174_e);
      } catch (DataFormatException var9) {
         throw new IOException("Bad compressed data format");
      } finally {
         var4.end();
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_48177_a);
      p_322_1_.writeInt(this.field_48175_b);
      p_322_1_.writeBoolean(this.field_48171_f);
      p_322_1_.writeShort((short)(this.field_48176_c & '\uffff'));
      p_322_1_.writeShort((short)(this.field_48173_d & '\uffff'));
      p_322_1_.writeInt(this.field_48172_g);
      p_322_1_.writeInt(this.field_48178_h);
      p_322_1_.write(this.field_48174_e, 0, this.field_48172_g);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_48487_a(this);
   }

   public int func_329_a() {
      return 17 + this.field_48172_g;
   }

}
