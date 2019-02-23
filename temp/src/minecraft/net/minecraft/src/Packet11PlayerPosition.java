package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet10Flying;

public class Packet11PlayerPosition extends Packet10Flying {

   public Packet11PlayerPosition() {
      this.field_554_h = true;
   }

   public Packet11PlayerPosition(double p_i97_1_, double p_i97_3_, double p_i97_5_, double p_i97_7_, boolean p_i97_9_) {
      this.field_561_a = p_i97_1_;
      this.field_560_b = p_i97_3_;
      this.field_558_d = p_i97_5_;
      this.field_559_c = p_i97_7_;
      this.field_555_g = p_i97_9_;
      this.field_554_h = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_561_a = p_327_1_.readDouble();
      this.field_560_b = p_327_1_.readDouble();
      this.field_558_d = p_327_1_.readDouble();
      this.field_559_c = p_327_1_.readDouble();
      super.func_327_a(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeDouble(this.field_561_a);
      p_322_1_.writeDouble(this.field_560_b);
      p_322_1_.writeDouble(this.field_558_d);
      p_322_1_.writeDouble(this.field_559_c);
      super.func_322_a(p_322_1_);
   }

   public int func_329_a() {
      return 33;
   }
}
