package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet10Flying;

public class Packet12PlayerLook extends Packet10Flying {

   public Packet12PlayerLook() {
      this.field_553_i = true;
   }

   public Packet12PlayerLook(float p_i522_1_, float p_i522_2_, boolean p_i522_3_) {
      this.field_557_e = p_i522_1_;
      this.field_556_f = p_i522_2_;
      this.field_555_g = p_i522_3_;
      this.field_553_i = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_557_e = p_327_1_.readFloat();
      this.field_556_f = p_327_1_.readFloat();
      super.func_327_a(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeFloat(this.field_557_e);
      p_322_1_.writeFloat(this.field_556_f);
      super.func_322_a(p_322_1_);
   }

   public int func_329_a() {
      return 9;
   }
}
