package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;
import net.minecraft.src.WorldType;

public class Packet9Respawn extends Packet {

   public int field_35244_b;
   public int field_35245_c;
   public int field_35242_d;
   public int field_35243_e;
   public WorldType field_46031_f;


   public Packet9Respawn() {}

   public Packet9Respawn(int p_i1051_1_, byte p_i1051_2_, WorldType p_i1051_3_, int p_i1051_4_, int p_i1051_5_) {
      this.field_35244_b = p_i1051_1_;
      this.field_35245_c = p_i1051_2_;
      this.field_35242_d = p_i1051_4_;
      this.field_35243_e = p_i1051_5_;
      this.field_46031_f = p_i1051_3_;
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_9448_a(this);
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_35244_b = p_327_1_.readInt();
      this.field_35245_c = p_327_1_.readByte();
      this.field_35243_e = p_327_1_.readByte();
      this.field_35242_d = p_327_1_.readShort();
      String var2 = func_27048_a(p_327_1_, 16);
      this.field_46031_f = WorldType.func_46135_a(var2);
      if(this.field_46031_f == null) {
         this.field_46031_f = WorldType.field_48635_b;
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_35244_b);
      p_322_1_.writeByte(this.field_35245_c);
      p_322_1_.writeByte(this.field_35243_e);
      p_322_1_.writeShort(this.field_35242_d);
      func_27049_a(this.field_46031_f.func_48628_a(), p_322_1_);
   }

   public int func_329_a() {
      return 8 + this.field_46031_f.func_48628_a().length();
   }
}
