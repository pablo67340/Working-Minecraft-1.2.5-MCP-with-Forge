package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EnumArt;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet25EntityPainting extends Packet {

   public int field_21042_a;
   public int field_21041_b;
   public int field_21046_c;
   public int field_21045_d;
   public int field_21044_e;
   public String field_21043_f;


   public Packet25EntityPainting() {}

   public Packet25EntityPainting(EntityPainting p_i537_1_) {
      this.field_21042_a = p_i537_1_.field_620_ab;
      this.field_21041_b = p_i537_1_.field_9322_d;
      this.field_21046_c = p_i537_1_.field_9321_e;
      this.field_21045_d = p_i537_1_.field_9320_f;
      this.field_21044_e = p_i537_1_.field_691_a;
      this.field_21043_f = p_i537_1_.field_690_b.field_1624_y;
   }

   public void func_327_a(DataInputStream p_327_1_) throws IOException {
      this.field_21042_a = p_327_1_.readInt();
      this.field_21043_f = func_27048_a(p_327_1_, EnumArt.field_27365_z);
      this.field_21041_b = p_327_1_.readInt();
      this.field_21046_c = p_327_1_.readInt();
      this.field_21045_d = p_327_1_.readInt();
      this.field_21044_e = p_327_1_.readInt();
   }

   public void func_322_a(DataOutputStream p_322_1_) throws IOException {
      p_322_1_.writeInt(this.field_21042_a);
      func_27049_a(this.field_21043_f, p_322_1_);
      p_322_1_.writeInt(this.field_21041_b);
      p_322_1_.writeInt(this.field_21046_c);
      p_322_1_.writeInt(this.field_21045_d);
      p_322_1_.writeInt(this.field_21044_e);
   }

   public void func_323_a(NetHandler p_323_1_) {
      p_323_1_.func_21146_a(this);
   }

   public int func_329_a() {
      return 24;
   }
}
