package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.Packet10Flying;

public class Packet13PlayerLookMove extends Packet10Flying {

   public Packet13PlayerLookMove() {
      this.field_553_i = true;
      this.field_554_h = true;
   }

   public Packet13PlayerLookMove(double p_i290_1_, double p_i290_3_, double p_i290_5_, double p_i290_7_, float p_i290_9_, float p_i290_10_, boolean p_i290_11_) {
      this.field_561_a = p_i290_1_;
      this.field_560_b = p_i290_3_;
      this.field_558_d = p_i290_5_;
      this.field_559_c = p_i290_7_;
      this.field_557_e = p_i290_9_;
      this.field_556_f = p_i290_10_;
      this.field_555_g = p_i290_11_;
      this.field_553_i = true;
      this.field_554_h = true;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_561_a = p_327_1_.readDouble();
      this.field_560_b = p_327_1_.readDouble();
      this.field_558_d = p_327_1_.readDouble();
      this.field_559_c = p_327_1_.readDouble();
      this.field_557_e = p_327_1_.readFloat();
      this.field_556_f = p_327_1_.readFloat();
      super.func_327_a(p_327_1_);
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeDouble(this.field_561_a);
      p_322_1_.writeDouble(this.field_560_b);
      p_322_1_.writeDouble(this.field_558_d);
      p_322_1_.writeDouble(this.field_559_c);
      p_322_1_.writeFloat(this.field_557_e);
      p_322_1_.writeFloat(this.field_556_f);
      super.func_322_a(p_322_1_);
   }

   public int func_329_a() {
      return 41;
   }
}
