package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet130UpdateSign extends Packet {

   public int field_20020_a;
   public int field_20019_b;
   public int field_20022_c;
   public String[] field_20021_d;


   public Packet130UpdateSign() {
      this.field_472_j = true;
   }

   public Packet130UpdateSign(int p_i148_1_, int p_i148_2_, int p_i148_3_, String[] p_i148_4_) {
      this.field_472_j = true;
      this.field_20020_a = p_i148_1_;
      this.field_20019_b = p_i148_2_;
      this.field_20022_c = p_i148_3_;
      this.field_20021_d = p_i148_4_;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_20020_a = p_327_1_.readInt();
      this.field_20019_b = p_327_1_.readShort();
      this.field_20022_c = p_327_1_.readInt();
      this.field_20021_d = new String[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.field_20021_d[var2] = func_27048_a(p_327_1_, 15);
      }

   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_20020_a);
      p_322_1_.writeShort(this.field_20019_b);
      p_322_1_.writeInt(this.field_20022_c);

      for(int var2 = 0; var2 < 4; ++var2) {
         func_27049_a(this.field_20021_d[var2], p_322_1_);
      }

   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_20093_a(this);
   }

   public int func_329_a() {
      int var1 = 0;

      for(int var2 = 0; var2 < 4; ++var2) {
         var1 += this.field_20021_d[var2].length();
      }

      return var1;
   }
}
