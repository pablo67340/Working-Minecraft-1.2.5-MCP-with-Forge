package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet30Entity;

public class Packet32EntityLook extends Packet30Entity {

   public Packet32EntityLook() {
      this.field_486_g = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      super.func_327_a(p_327_1_);
      this.field_488_e = p_327_1_.readByte();
      this.field_487_f = p_327_1_.readByte();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      super.func_322_a(p_322_1_);
      p_322_1_.writeByte(this.field_488_e);
      p_322_1_.writeByte(this.field_487_f);
   }

   public int func_329_a() {
      return 6;
   }
}
