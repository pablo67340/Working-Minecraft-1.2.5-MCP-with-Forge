package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet30Entity;

public class Packet33RelEntityMoveLook extends Packet30Entity {

   public Packet33RelEntityMoveLook() {
      this.field_486_g = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      super.func_327_a(p_327_1_);
      this.field_484_b = p_327_1_.readByte();
      this.field_490_c = p_327_1_.readByte();
      this.field_489_d = p_327_1_.readByte();
      this.field_488_e = p_327_1_.readByte();
      this.field_487_f = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      super.func_322_a(p_322_1_);
      p_322_1_.writeByte(this.field_484_b);
      p_322_1_.writeByte(this.field_490_c);
      p_322_1_.writeByte(this.field_489_d);
      p_322_1_.writeByte(this.field_488_e);
      p_322_1_.writeByte(this.field_487_f);
   }

   public int func_329_a() {
      return 9;
   }
}
